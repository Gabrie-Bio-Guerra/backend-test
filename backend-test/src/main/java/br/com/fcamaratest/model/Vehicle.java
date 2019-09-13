package br.com.fcamaratest.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String brand;
	private String model;
	private String color;
	private String plate;
	private String type;
	private Integer park;
	private LocalDateTime entry = LocalDateTime.now();
	private LocalDateTime exit;
	private Long time;

	public Vehicle() {
	}

	public Vehicle(String brand, String model, String color, String plate, String type, Integer park) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.plate = plate;
		this.type = type;
		this.setPark(park);
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getEntry() {
		return entry;
	}

	public void setEntry(LocalDateTime entry) {
		this.entry = entry;
	}

	public LocalDateTime getExit() {
		return exit;
	}

	public void setExit(LocalDateTime exit) {
		this.exit = exit;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getPark() {
		return park;
	}

	public void setPark(Integer park) {
		this.park = park;
	}

}
