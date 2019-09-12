package br.com.fcamaratest.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fcamaratest.model.Park;
import br.com.fcamaratest.model.Vehicle;

public class VehicleDto {
	
	private Long id;
	private String brand;
	private String model; 
	private String color;
	private String plate;
	private String type; 
	private Integer parkId;
	private Boolean status; /* true -> on park / false -> on street */
	
	public VehicleDto (Vehicle vehicle) {
		this.id = vehicle.getId();
		this.brand = vehicle.getBrand();
		this.model = vehicle.getModel();
		this.color = vehicle.getColor();
		this.plate = vehicle.getPlate();
		this.type = vehicle.getType();
		this.parkId = vehicle.getParkId();
		this.status = vehicle.getStatus();
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
		return parkId;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public static List<VehicleDto> convert(List<Vehicle> vehicles){
		return vehicles.stream().map(VehicleDto::new).collect(Collectors.toList());
	}
	
}
