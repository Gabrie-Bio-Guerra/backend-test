package br.com.fcamaratest.form;


import java.time.Duration;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.fcamaratest.model.Vehicle;
import br.com.fcamaratest.repository.VehicleRepository;

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
	@Min(value = 1L, message = "The value must be positive") //@Max(Número de estacionamentos)
	private Integer park;
	//coloca as variáveis zeradas e reseta a entrada

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
	public Integer getPark() {
		return park;
	}
	public void setPark(Integer park) {
		this.park = park;
	}
	
	public Vehicle convert(){
		Vehicle vehicle =  new Vehicle(brand, model, color, plate, type, park);
		return vehicle;
	}
	
	private void checkOut(Vehicle vehicle) {
		LocalDateTime time = LocalDateTime.now();
		vehicle.setExit(time);
		Long duration =  Duration.between(vehicle.getEntry(),vehicle.getExit()).toHours();
		vehicle.setTime(duration);
	}
	
	private void checkIn(Vehicle vehicle) {
		LocalDateTime time = LocalDateTime.now();
		vehicle.setEntry(time);
		vehicle.setExit(null);
		vehicle.setTime(null);
		
	}
	
	public Vehicle update(Long id, VehicleRepository vehicleRepository) {
		Vehicle vehicle = vehicleRepository.getOne(id);
		if(vehicle.getPark() != null) {
			//Long oldId = vehicle.getId();
			vehicle.setBrand(this.brand);
			vehicle.setModel(this.model);
			vehicle.setColor(this.color);
			vehicle.setPlate(this.plate);
			vehicle.setType(this.type);
			vehicle.setPark(this.park);
			//e se ele mudar para outro diretamente?
			if(vehicle.getPark() == null) {
				checkOut(vehicle);
			}
		}else {
			vehicle.setBrand(this.brand);
			vehicle.setModel(this.model);
			vehicle.setColor(this.color);
			vehicle.setPlate(this.plate);
			vehicle.setType(this.type);
			vehicle.setPark(this.park);
			checkIn(vehicle);
		}
		
		
		return vehicle;
	}
	
	
}
