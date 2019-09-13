package br.com.fcamaratest.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fcamaratest.model.Vehicle;

public class VehicleForm {
	
	@NotNull @NotEmpty
	private String brand;
	@NotNull @NotEmpty
	private String model;
	@NotNull @NotEmpty
	private String color;
	@NotNull @NotEmpty
	private String plate;
	@NotNull @NotEmpty
	private String type;
	@NotNull @Min(value = 1L, message = "The value must be positive") //@Max(Número de estacionamentos)
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
