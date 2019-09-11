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

}
