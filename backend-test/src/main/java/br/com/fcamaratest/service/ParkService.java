package br.com.fcamaratest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fcamaratest.dto.ParkDto;
import br.com.fcamaratest.model.Park;
import br.com.fcamaratest.repository.ParkRepository;

@Service
public class ParkService {

	@Autowired
	private ParkRepository parkRepository;

	public List<ParkDto> retorna(String option, String value) {
		List<Park> parks = null;
		if (option != null && option != "") {
			switch (option) {
			case "name": {
				parks = parkRepository.findByName(value);
			}
				break;

			case "cnpj": {
				parks = parkRepository.findByCnpj(value);
			}
				break;

			case "address": {
				parks = parkRepository.findByAddress(value);
			}
				break;

			case "phone": {
				parks = parkRepository.findByPhone(value);
			}
				break;

			default: {
				parks = parkRepository.findAll();
			}
			}
		} else
			parks = parkRepository.findAll();
		
		return ParkDto.convert(parks);

	}

}
