package zoz.bidproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Category;
import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
import zoz.bidproject.model.SubCategory;
import zoz.bidproject.repositories.jpa.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SellerService sellerService;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public List<Product> getProductsByOffre(Offer offer){
		return offer.getProducts();
	}
	
	public List<Product> getProductsBySeller(Seller seller){
		List<Product> products = new ArrayList<Product>();
		for (Offer offer : seller.getOffres()) {
			products.addAll(getProductsByOffre(offer));
		}
		return products;
	}
	
	public List<Product> getProductsByCategory(Category category){
		List<Product> products = new ArrayList<Product>();
		for (Product product : productRepository.findAll()) {
			if(product.getSubCategory().getCategory().getName().equals(category.getName())) {
				products.add(product);
			}
			
		}
		return products;
	}
	public List<Product> getProductsBySubCategory(SubCategory subCategory){
		List<Product> products = new ArrayList<Product>();
		for (Product product : productRepository.findAll()) {
			if(product.getSubCategory().getName().equals(subCategory.getName())) {
				products.add(product);
			}
			
		}
		return products;
	}
	public Product getProduct(Long id) {
		
		return productRepository.getOne(id);
	}
}
