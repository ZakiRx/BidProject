package zoz.bidproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nameRole;
	@JsonIgnore
	@ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
	private List<Buyer> buyers;
	@JsonIgnore
	@ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
	private List<Manager> managers;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String name) {
		this.id = id;
		this.nameRole = name.toUpperCase();
	}

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
		this.nameRole = nameRole.toUpperCase();
	}

	public List<Buyer> getBuyers() {
		return buyers;
	}

	public void setBuyers(List<Buyer> buyers) {
		this.buyers = buyers;
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}

}
