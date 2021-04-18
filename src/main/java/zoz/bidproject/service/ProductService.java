package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Offre;
import zoz.bidproject.model.Product;
import zoz.bidproject.repositories.jpa.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getProductsByOffre(Offre offre){
		return offre.getProducts();
	}
	
}
