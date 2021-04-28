package zoz.bidproject.converter;

import java.util.List;

import java.util.stream.Collectors;

import zoz.bidproject.dto.CategoryDto;
import zoz.bidproject.model.Category;

public class CategoryConvert {

	public CategoryDto entityToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();

		return categoryDto;
	}

	public List<CategoryDto> entityToDto(List<Category> Categories) {

		return Categories.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public Category dtoToEntity(CategoryDto categoryDto) {
		Category category = new Category();
		return category;
	}

	public List<Category> dtoToEntity(List<CategoryDto> CategoriesDto) {

		return CategoriesDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}

}
