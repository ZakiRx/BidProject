package zoz.bidproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Category;
import zoz.bidproject.model.Product;
import zoz.bidproject.service.CategoryService;
import zoz.bidproject.service.ProductService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	@RequestMapping("/")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public List<Product> getProducts(@PathVariable Long id){
		Category category = categoryService.getCategory(id);
		return productService.getProductsByCategory(category);
	}
	
}
