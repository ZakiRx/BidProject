package zoz.bidproject.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CategoryInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String slug;
	private String name;
	
	public CategoryInfo() {
		
	}
	public CategoryInfo(Long id, String slug, String name) {
		this.id = id;
		this.slug = slug;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
