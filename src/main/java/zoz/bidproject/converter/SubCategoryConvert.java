package zoz.bidproject.converter;

import java.util.List;
import java.util.stream.Collectors;
import zoz.bidproject.dto.SubCategoryDto;
import zoz.bidproject.model.SubCategory;

public class SubCategoryConvert {
	public SubCategoryDto entityToDto(SubCategory subCategory) {
		SubCategoryDto subCategoryDto = new SubCategoryDto();

		return subCategoryDto;
	}

	public List<SubCategoryDto> entityToDto(List<SubCategory> subCategories) {

		return subCategories.stream().map(b -> entityToDto(b)).collect(Collectors.toList());
	}

	public SubCategory dtoToEntity(SubCategoryDto subCategoriesDto) {
		SubCategory subCategory = new SubCategory();
		return subCategory;
	}

	public List<SubCategory> dtoToEntity(List<SubCategoryDto> SubCategoriesDto) {

		return SubCategoriesDto.stream().map(b -> dtoToEntity(b)).collect(Collectors.toList());
	}
}
