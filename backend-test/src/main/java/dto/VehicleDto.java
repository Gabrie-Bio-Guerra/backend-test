package dto;

import java.util.List;
import java.util.stream.Collectors;

import model.Park;
import model.Vehicle;

public class VehicleDto {
	
	private int id;
	private String brand;
	private String model; 
	private String color;
	private String plate;
	private int type; /* 0 -> Car / 1 -> Motorcycle */
	private Park park;
	private Boolean status; /* true -> on park / false -> on street */
	
	public VehicleDto (Vehicle vehicle) {
		this.id = vehicle.getId();
		this.brand = vehicle.getBrand();
		this.model = vehicle.getModel();
		this.color = vehicle.getColor();
		this.plate = vehicle.getPlate();
		this.type = vehicle.getType();
		this.park = vehicle.getPark();
		this.status = vehicle.getStatus();
	}

	public int getId() {
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
	
	public int getType() {
		return type;
	}
	
	public Park getPark() {
		return park;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public List<VehicleDto> convert(List<Vehicle> vehicles){
		return vehicles.stream().map(VehicleDto::new).collect(Collectors.toList());
	}
	
}
