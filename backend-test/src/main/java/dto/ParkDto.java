package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Vehicle;
import model.Park;

public class ParkDto {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private int carSpaces;
	private int motorcycleSpaces;
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public ParkDto(Park park) {
		
		this.id = park.getId();
		this.name = park.getName();
		this.address = park.getAddress();
		this.phone = park.getPhone();
		this.carSpaces = park.getCarSpaces();
		this.motorcycleSpaces = park.getMotorcycleSpaces();
		this.vehicles = park.getVehicles();
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public int getCarSpaces() {
		return carSpaces;
	}
	
	public int getMotorcycleSpaces() {
		return motorcycleSpaces;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public List<ParkDto> convert(List<Park> park){
		return park.stream().map(ParkDto::new).collect(Collectors.toList());
	}

}
