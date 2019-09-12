package br.com.fcamaratest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fcamaratest.dto.VehicleDto;
import br.com.fcamaratest.model.Vehicle;
import br.com.fcamaratest.repository.VehicleRepository;;

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
