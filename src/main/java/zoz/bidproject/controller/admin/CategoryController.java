package zoz.bidproject.controller.admin;

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

import zoz.bidproject.model.Category;
import zoz.bidproject.service.CategoryService;

@RestController("adminCategoryController")
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	@RequestMapping("/")
	public List<Category> getCategories(){
		return categoryService.getCategories();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Category getCategory(@PathVariable Long id){
		Category category = categoryService.getCategory(id);
		return category;
	}
	@PostMapping
	@RequestMapping("/new")
	public Category newCategory(@RequestBody Category category){
		return categoryService.newCategory(category);
	}
	@PutMapping
	@RequestMapping("/edit")
	public Category editCategory(@RequestBody Category category){
		return categoryService.newCategory(category);
	}
	@DeleteMapping
	@RequestMapping("/{id}/delete")
	public void deleteCategory(@PathVariable Long id){
		Category category = categoryService.getCategory(id);
		 categoryService.delteCategory(category);
	}
	
}
