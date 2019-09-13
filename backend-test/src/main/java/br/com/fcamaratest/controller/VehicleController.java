package br.com.fcamaratest.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fcamaratest.dto.ParkDto;
import br.com.fcamaratest.dto.VehicleDto;
import br.com.fcamaratest.form.ParkForm;
import br.com.fcamaratest.form.VehicleForm;
import br.com.fcamaratest.model.Park;
import br.com.fcamaratest.model.Vehicle;
import br.com.fcamaratest.repository.VehicleRepository;;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;

	@GetMapping
	public List<VehicleDto> list(String option, String value) {
		List<Vehicle> vehicles = null;
		if (option != null && option != "") {
			switch (option) {
				case "type": {
					vehicles = vehicleRepository.findByType(value);
				}
					break;
	
				case "color": {
					vehicles = vehicleRepository.findByColor(value);
				}
					break;
	
				case "model": {
					vehicles = vehicleRepository.findByModel(value);
				}
					break;
	
				case "brand": {
					vehicles = vehicleRepository.findByBrand(value);
				}
					break;
	
				case "plate": {
					vehicles = vehicleRepository.findByPlate(value);
				}
					break;
	
				default: {
					vehicles = vehicleRepository.findAll();
				}
			}
		}else 
			vehicles = vehicleRepository.findAll();

		return VehicleDto.convert(vehicles);
	}
	
	@GetMapping("/{id}")
	public VehicleDto getOne(@PathVariable Long id) {
		Vehicle vehicle = vehicleRepository.getOne(id);
		return VehicleDto.convertOne(vehicle);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VehicleDto> update(@PathVariable Long id, @RequestBody @Valid VehicleForm form) {
		Vehicle vehicle = form.update(id, vehicleRepository);
		return ResponseEntity.ok(VehicleDto.convertOne(vehicle));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Long id) {
		vehicleRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<VehicleDto> register(@RequestBody @Valid VehicleForm form, UriComponentsBuilder uriBuilder) {
		Vehicle vehicle = form.convert();
		vehicleRepository.save(vehicle);

		URI uri = uriBuilder.path("/vehicles/{id}").buildAndExpand(vehicle.getId()).toUri();
		return ResponseEntity.created(uri).body(new VehicleDto(vehicle));
	}

}
