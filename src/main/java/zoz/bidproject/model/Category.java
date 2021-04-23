package zoz.bidproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Category extends CategoryInfo {

	
	public Category() {
		super();
	}
	@OneToMany(mappedBy = "category")
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
