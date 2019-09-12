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
	public List<VehicleDto> list(String option, String value){
		List<Vehicle> vehicles = null;
		if(option == null) {
			vehicles = vehicleRepository.findAll();
		}else {
			System.out.println("Option: " + option + " / " + "Valor: " + value);
			
			switch(option) {
				case "status":{
					vehicles = vehicleRepository.findByStatus(Boolean.parseBoolean(value));
				}break;
				
				case "type":{
					vehicles = vehicleRepository.findByType(value);
				}break;
				
				case "color":{
					vehicles = vehicleRepository.findByColor(value);
				}break;
				
				case "model":{
					vehicles = vehicleRepository.findByModel(value);
				}break;
			
				case "brand":{
					vehicles = vehicleRepository.findByBrand(value);
				}break;
				
				case "plate":{
					vehicles = vehicleRepository.findByPlate(value);
				}break;
				
				default:{
				vehicles = vehicleRepository.findAll();
				}
			}
			
		}
		
		
		return VehicleDto.convert(vehicles);
	}
}
