package zoz.bidproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import zoz.bidproject.model.Category;
import zoz.bidproject.model.SubCategory;
import zoz.bidproject.repositories.jpa.CategoryRepository;

/**
 * @author Zaki_Guemi
 */

@Service
public class CategoryService  {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getCategories(){
		return categoryRepository.findAll();
	}
	public Category getCategory(Long id) {
		return categoryRepository.getOne(id);
	}
	public List<SubCategory> getSubCategories(Category category){
		return category.getSubCategories();
	}
	public Category newCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void delteCategory(Category category) {
		categoryRepository.delete(category);
	}
	
	
	
	
	
}
