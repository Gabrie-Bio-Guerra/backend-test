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

import br.com.fcamaratest.dto.ParkDto;
import br.com.fcamaratest.form.ParkForm;
import br.com.fcamaratest.model.Park;
import br.com.fcamaratest.repository.ParkRepository;

@RestController
@RequestMapping("/parks")
public class ParkController {
	
	@Autowired
	private ParkRepository parkRepository;
	
	@GetMapping
	public List<ParkDto> list(String option, String value){
		List<Park> park = null;
		if(option == null) {
			park = parkRepository.findAll();
		}else {
			switch(option){
				case "name": {
					park = parkRepository.findByName(value);
				}break;
				
				case "cnpj": {
					park = parkRepository.findByCnpj(value);
				}
				
				case "address": {
					park = parkRepository.findByAddress(value);
				}break;
				
				case "phone": {
					park = parkRepository.findByPhone(value);
				}
			}
		}
		return ParkDto.convert(park);
	}

	@PostMapping
	public ResponseEntity<ParkDto> register(@RequestBody ParkForm form, UriComponentsBuilder uriBuilder){
		Park park = form.convert();
		parkRepository.save(park);
		
		URI uri = uriBuilder.path("/parks/{id}").buildAndExpand(park.getId()).toUri();
		return ResponseEntity.created(uri).body(new ParkDto(park));
	}

}
