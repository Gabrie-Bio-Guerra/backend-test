package br.com.fcamaratest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fcamaratest.model.Park;
import br.com.fcamaratest.model.Vehicle;

public class ParkDto {
	
	private Long id;
	private String name;
	private String address;
	private String phone;
//	private int carSpaces;
//	private int motorcycleSpaces;
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public ParkDto(Park park) {
		
		this.id = park.getId();
		this.name = park.getName();
		this.address = park.getAddress();
		this.phone = park.getPhone();
//		this.carSpaces = park.getCarSpaces();
//		this.motorcycleSpaces = park.getMotorcycleSpaces();
		this.vehicles = park.getVehicles();
		
	}
	
	public Long getId() {
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
	
//	public int getCarSpaces() {
//		return carSpaces;
//	}
//	
//	public int getMotorcycleSpaces() {
//		return motorcycleSpaces;
//	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public static List<ParkDto> convert(List<Park> park){
		return park.stream().map(ParkDto::new).collect(Collectors.toList());
	}
	
	public static ParkDto convertOne(Park park){
		return new ParkDto(park);
	}

}
