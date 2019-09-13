package br.com.fcamaratest.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fcamaratest.model.Vehicle;

public class VehicleDto {
	
	private Long id;
	private String brand;
	private String model; 
	private String color;
	private String plate;
	private String type; 
	private Integer park;
	private LocalDateTime entry;
	private LocalDateTime exit;
	private Long time;

	
	public VehicleDto (Vehicle vehicle) {
		this.id = vehicle.getId();
		this.brand = vehicle.getBrand();
		this.model = vehicle.getModel();
		this.color = vehicle.getColor();
		this.plate = vehicle.getPlate();
		this.type = vehicle.getType();
		this.park = vehicle.getPark();
		this.entry = vehicle.getEntry();
		this.exit = vehicle.getExit();
		this.time = vehicle.getTime();
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


	public void setId(Long id) {
		this.id = id;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Long getId() {
		return id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getPlate() {
		return plate;
	}
	
	public String getType() {
		return type;
	}
	
	public Integer getPark() {
		return park;
	}
	
	
	public static List<VehicleDto> convert(List<Vehicle> vehicles){
		return vehicles.stream().map(VehicleDto::new).collect(Collectors.toList());
	}

	public static VehicleDto convertOne(Vehicle vehicle) {
		return new VehicleDto(vehicle);
	}
	
}
