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
import br.com.fcamaratest.form.ParkForm;
import br.com.fcamaratest.model.Park;
import br.com.fcamaratest.repository.ParkRepository;
import br.com.fcamaratest.service.ParkService;

@RestController
@RequestMapping("/parks")
public class ParkController {

	@Autowired
	private ParkRepository parkRepository;
	
	@Autowired
	private ParkService parkService;

	@GetMapping
	public ResponseEntity<List<ParkDto>> list(String option, String value) {		
		return ResponseEntity.ok(parkService.retorna(option, value));
	}

	@GetMapping("/{id}")
	public ParkDto getOne(@PathVariable Long id) {
		Park park = parkRepository.getOne(id);
		return ParkDto.convertOne(park);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ParkDto> update(@PathVariable Long id, @RequestBody @Valid ParkForm form) {
		Park park = form.update(id, parkRepository);
		return ResponseEntity.ok(ParkDto.convertOne(park));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		parkRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ParkDto> register(@RequestBody @Valid ParkForm form, UriComponentsBuilder uriBuilder) {
		Park park = form.convert();
		parkRepository.save(park);

		URI uri = uriBuilder.path("/parks/{id}").buildAndExpand(park.getId()).toUri();
		return ResponseEntity.created(uri).body(new ParkDto(park));
	}

}
