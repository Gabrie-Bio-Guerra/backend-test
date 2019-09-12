package br.com.fcamaratest.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fcamaratest.dto.VehicleDto;
import br.com.fcamaratest.form.VehicleForm;
import br.com.fcamaratest.model.Vehicle;
import br.com.fcamaratest.repository.ParkRepository;
import br.com.fcamaratest.repository.VehicleRepository;;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private ParkRepository parkRepository;
	
	@GetMapping
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
	
	@PostMapping
	public ResponseEntity<VehicleDto> register(@RequestBody VehicleForm form, UriComponentsBuilder uriBuilder){
		Vehicle vehicle = form.convert(parkRepository);
		vehicle.toString();
		
		
		
		
		vehicleRepository.save(vehicle);
		
		URI uri = uriBuilder.path("/vehicles/{id}").buildAndExpand(vehicle.getId()).toUri();
		return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
	}
	
}
