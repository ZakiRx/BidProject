package zoz.bidproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubCategory extends CategoryInfo {

	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "subCategory")
	private List<Product> products;
	
	public SubCategory(Long id, String slug, String name, Category category) {
		super(id, slug, name);
		this.category = category;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
