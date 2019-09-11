package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String brand;
	private String model; 
	private String color;
	private String plate;
	private int type; /* 0 -> Car / 1 -> Motorcycle */
	@ManyToOne
	private Park park;
	private Boolean status;
	

	

}
