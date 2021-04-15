package zoz.bidproject.model;

import java.util.List;

public class Category extends CategoryInfo {

	private List<SubCategory> subCategories;
	
	public Category(Long id, String slug, String name) {
		super(id, slug, name);

	}
	
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	
}
