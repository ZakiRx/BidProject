package zoz.bidproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubCategory extends CategoryInfo {

	@ManyToOne
	@JsonIgnore
	private Category category;
	@OneToMany(mappedBy = "subCategory")
	@JsonIgnore
	private List<Product> products;

	public SubCategory() {
		super();
	}

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
