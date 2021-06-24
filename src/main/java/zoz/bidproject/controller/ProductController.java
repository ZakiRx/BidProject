package zoz.bidproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.classpath.ClassPathDirectories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import zoz.bidproject.converter.ProductConvert;
import zoz.bidproject.dto.ProductDto;
import zoz.bidproject.model.Category;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Product;
import zoz.bidproject.service.CategoryService;
import zoz.bidproject.service.OfferService;
import zoz.bidproject.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private OfferService offerService;

	private ProductConvert productConvert;

	@PostConstruct
	public void init() {
		productConvert = new ProductConvert();
	}

	@GetMapping
	@RequestMapping("/")
	public List<Product> getProducts(@PathVariable Long id) {
		Category category = categoryService.getCategory(id);
		return productService.getProductsByCategory(category);
	}

	@GetMapping
	@RequestMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		Product product = productService.getProduct(id);
		return product;
	}

	@PostMapping
	@RequestMapping(path = "/new",method = RequestMethod.POST)
	@PreAuthorize("hasAnyAuthority('SELLER', 'ADMIN')")
	public ProductDto newProduct(@RequestBody ProductDto productDto){
		 Offer offer = offerService.getOfferById(productDto.getIdOffer());
		 if(offer ==null) {
			 return null;
		 }
		 Product product = productConvert.dtoToEntity(productDto);
		 product.setOffre(offer);
		 return productConvert.entityToDto(productService.saveProduct(product));
	}
	
	@PostMapping
	@RequestMapping(path = "/image/{id}",method = RequestMethod.POST)
	public void uploadImageProduct(@RequestParam("file") MultipartFile file,@RequestParam("files") MultipartFile files[],@PathVariable("id") Long id) throws URISyntaxException, IOException {
		Product product = productService.getProduct(id);
		if(product != null &&  product.getOffer().getSeller().getUserName().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
			
			//add image principal
			String imageName=product.getName()+"_"+product.getId()+"_"+file.getOriginalFilename();
			if(file.getOriginalFilename().lastIndexOf(".jpg")!=-1 || file.getOriginalFilename().lastIndexOf(".png")!=-1  ) {
				 File image = new File( "src/main/resources/images/products/"+imageName);
				 image.createNewFile();
				 FileOutputStream stream = new FileOutputStream(image);
				 stream.write(file.getBytes());
				 product.setImage(imageName);
				 stream.close();
				 
				 //add images for product
				 String images="";
				 for (MultipartFile fileG  : files) {
						String imageNameG=product.getName()+"_"+product.getId()+"_"+file.getOriginalFilename();
						File imageG = new File( "src/main/resources/images/products/"+imageNameG);
						 image.createNewFile();
						 FileOutputStream streamG = new FileOutputStream(imageG);
						 streamG.write(file.getBytes());
						 streamG.close();
						 images+=imageNameG+",";
					}
				 product.setImages(images);
				 productService.saveProduct(product);
			}
			
		}
		
	}


	@PutMapping
	@RequestMapping(path = "/edit/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasAnyAuthority('SELLER', 'ADMIN') && #productDto.nameSeller==authentication.name")
	public ProductDto editProduct(@RequestBody ProductDto productDto, @PathVariable("id") Long id) {
		Product product = productService.getProduct(id);
		product.setDescription(productDto.getDescription());
		product.setImage(productDto.getImage());
		product.setImages(productDto.getImages());
		product.setTags(productDto.getTags());
		product.setName(productDto.getName());
		
		return productConvert.entityToDto(productService.saveProduct(product));
	}

	@DeleteMapping
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {

		try {
			Product product = productService.getProduct(id);
			productService.deleteProduct(product);
			return new ResponseEntity<Object>(
					(new JSONObject().put("message", "Product " + product.getName() + " Has been deleted").toString()),
					HttpStatus.OK);
		} catch (JSONException e) {
			return null;
		}
	}
}
