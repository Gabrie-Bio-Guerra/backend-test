package br.com.fcamaratest.form;

import br.com.fcamaratest.model.Vehicle;

public class VehicleForm {
	
	private String brand;
	private String model; 
	private String color;
	private String plate;
	private String type; 
	private Integer parkId;

	public Integer getparkId() {
		return parkId;
	}
	public void setparkId(Integer parkId) {
		this.parkId = parkId;
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
	
	public Vehicle convert(){
		Vehicle vehicle =  new Vehicle(brand, model, color, plate, type, parkId);
		return vehicle;
	}
	
}
