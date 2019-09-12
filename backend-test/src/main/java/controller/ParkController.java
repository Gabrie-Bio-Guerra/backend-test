package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ParkDto;
import model.Park;
import repository.ParkRepository;

@RestController
public class ParkController {
	
	@Autowired
	private ParkRepository parkRepository;
	
	@RequestMapping("/parks")
	public List<ParkDto> list(){
		List<Park> park = parkRepository.findAll();
		return ParkDto.convert(park);
	}
	

}
