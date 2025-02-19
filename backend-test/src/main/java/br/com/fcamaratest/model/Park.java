package br.com.fcamaratest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Park {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cnpj;
	private String address;
	private String phone;
	private Integer spaces;
	@OneToMany(mappedBy = "park")
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public Park() {}
	
	public Park(String name, String cnpj, String address, String phone) {
		this.name = name;
		this.cnpj = cnpj;
		this.address = address;
		this.phone = phone;
	}
	
	public Integer getSpaces() {
		return spaces;
	}

	public void setSpaces(Integer spaces) {
		this.spaces = spaces;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
