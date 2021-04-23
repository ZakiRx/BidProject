package zoz.bidproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zoz.bidproject.model.Category;
import zoz.bidproject.model.SubCategory;
import zoz.bidproject.repositories.jpa.SubCategoryRepository;

/**
 * 
 * @author Zaki_Rx
 *
 */
@Service
public class SubCategoryService {
	@Autowired
	private SubCategoryRepository subCategoryRepository;

	public List<SubCategory> getSubCategories() {
		return subCategoryRepository.findAll();
	}

	public SubCategory getSubCategory(Long id) {
		return subCategoryRepository.getOne(id);
	}

	public Category getSubCategory(SubCategory subCategory) {
		return subCategory.getCategory();
	}

	public SubCategory newSubCategory(SubCategory subCategory) {
		return subCategoryRepository.save(subCategory);
	}
	
	public void deleteSubCategory(SubCategory subCategory) {
		subCategoryRepository.delete(subCategory);
	}
}
