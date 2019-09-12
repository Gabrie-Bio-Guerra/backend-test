package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Park {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cnpj;
	private String address;
	private String phone;
	private int carSpaces;
	private int motorcycleSpaces;
	@OneToMany(mappedBy = "park")
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
	public int getCarSpaces() {
		return carSpaces;
	}
	
	public void setCarSpaces(int carSpaces) {
		this.carSpaces = carSpaces;
	}
	
	public int getMotorcycleSpaces() {
		return motorcycleSpaces;
	}
	
	public void setMotorcycleSpaces(int motorcycleSpaces) {
		this.motorcycleSpaces = motorcycleSpaces;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
