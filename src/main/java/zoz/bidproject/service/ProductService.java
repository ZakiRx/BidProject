package zoz.bidproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Offer;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
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
	
	public List<Product> getProductsByOffre(Offer offer){
		return offer.getProducts();
	}
	
	public List<Product> getProductsBySeller(Long id){
		List<Product> products = new ArrayList<Product>();
		Seller seller = sellerService.getSeller(id);
		for (Offer offer : seller.getOffres()) {
			products.addAll(getProductsByOffre(offer));
		}
		return products;
	}
	
}
