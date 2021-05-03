package zoz.bidproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoz.bidproject.model.Product;
import zoz.bidproject.model.SubCategory;
import zoz.bidproject.service.ProductService;
import zoz.bidproject.service.SubCategoryService;

@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {
	@Autowired
	private ProductService productService;
	@Autowired
	private SubCategoryService subCategoryService;
	
	
	@GetMapping
	@RequestMapping("/")
	public List<Product> getProducts(){
	
		return productService.getProducts();
	}
	
	
	@GetMapping
	@RequestMapping("/{id}")
	public List<Product> getProducts(@PathVariable Long id){
		SubCategory subCategory = subCategoryService.getSubCategory(id);
		return productService.getProductsBySubCategory(subCategory);
	}
}
