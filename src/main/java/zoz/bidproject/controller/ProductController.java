package zoz.bidproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Buyer;
import zoz.bidproject.model.Category;
import zoz.bidproject.model.Comment;
import zoz.bidproject.model.Product;
import zoz.bidproject.service.BuyerService;
import zoz.bidproject.service.CategoryService;
import zoz.bidproject.service.CommentService;
import zoz.bidproject.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
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
}
