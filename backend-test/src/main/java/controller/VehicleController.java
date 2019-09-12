package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.VehicleDto;
import model.Vehicle;
import repository.VehicleRepository;;

@RestController
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@RequestMapping("/vehicles")
	public List<VehicleDto> list(){
		List<Vehicle> vehicle = vehicleRepository.findAll();
		return VehicleDto.convert(vehicle);
	}
}
