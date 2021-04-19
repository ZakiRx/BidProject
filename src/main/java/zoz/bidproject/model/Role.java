package zoz.bidproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nameRole;
	@ManyToMany(mappedBy = "roles")
	private List<Manager> managers;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public List<Manager> getManagers() {
		return managers;
	}
	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}
	
	
	
}
