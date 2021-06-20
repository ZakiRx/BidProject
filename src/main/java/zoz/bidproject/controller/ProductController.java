package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Product> getProducts(@PathVariable Long id){
		Category category = categoryService.getCategory(id);
		return productService.getProductsByCategory(category);
	}
	@GetMapping
	@RequestMapping("/{id}")
	public Product getProduct(@PathVariable Long id){
		Product product=productService.getProduct(id);
		return product;
	}
	@PostMapping
	@RequestMapping(path = "/new",method = RequestMethod.POST)
	@PreAuthorize("hasAnyAuthority('SELLER', 'ADMIN')")
	public ProductDto newProduct(@RequestBody ProductDto productDto){
		 Product product = productConvert.dtoToEntity(productDto);
		 Offer offer = offerService.getOfferById(productDto.getIdOffer());
		 product.setOffre(offer);
		 return productConvert.entityToDto(productService.saveProduct(product));
	}
	@PutMapping
	@RequestMapping(path = "/edit/{id}",method = RequestMethod.PUT)
	@PreAuthorize("hasAnyAuthority('SELLER', 'ADMIN') && #productDto.nameSeller==authentication.name")
	public ProductDto editProduct(@RequestBody ProductDto productDto,@PathVariable("id") Long id){
		 Product product = productService.getProduct(id);
		 product.setDescription(productDto.getDescription());
		 product.setImage(productDto.getImage());
		 product.setImages(productDto.getImages());
		 product.setTags(productDto.getTags());
		 product.setName(productDto.getName());
		
		 return productConvert.entityToDto(productService.saveProduct(product));
	}
}
