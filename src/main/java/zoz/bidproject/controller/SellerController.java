package zoz.bidproject.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.converter.FollowConvert;
import zoz.bidproject.converter.OrderConvert;
import zoz.bidproject.converter.SellerConvert;
import zoz.bidproject.dto.FollowDto;
import zoz.bidproject.dto.OrderDto;
import zoz.bidproject.dto.SellerDto;
import zoz.bidproject.model.Follow;
import zoz.bidproject.model.Ordre;
import zoz.bidproject.model.Product;
import zoz.bidproject.model.Seller;
import zoz.bidproject.service.FollowService;
import zoz.bidproject.service.OrderService;
import zoz.bidproject.service.ProductService;
import zoz.bidproject.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private FollowService followService;
	
	private FollowConvert followConvert;
	private SellerConvert sellerConvert;
	private OrderConvert orderConvert ;

	@PostConstruct
	public void init() {
		followConvert= new FollowConvert();
		sellerConvert= new SellerConvert();
		orderConvert= new OrderConvert();
	}
	@GetMapping
	@RequestMapping("/")
	public List<SellerDto> getSellers() {
		return sellerConvert.entityToDto(sellerService.getSellers()) ;
	}

	@GetMapping
	@RequestMapping("/{id}")
	public SellerDto getSeller(@PathVariable Long id) {
		return sellerConvert.entityToDto(sellerService.getSeller(id));
	}

	@GetMapping
	@RequestMapping("/products")
	public List<Product> getProductsOffer() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Seller seller = sellerService.getSellerByUserName(username);
		return productService.getProductsBySeller(seller);
	}

	@GetMapping
	@RequestMapping("/order")
	public List<OrderDto> getOrders() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Seller seller = sellerService.getSellerByUserName(username);
		return  orderConvert.entityToDto(orderService.getOrdersBySeller(seller));
	}
	

	@GetMapping
	@RequestMapping("/followers")
	public List<FollowDto> getFollowers() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Seller seller = sellerService.getSellerByUserName(username);
		List<Follow> follows=followService.getFollowersBySeller(seller);
		return followConvert.entityToDto(follows);
	}
	

	
}
