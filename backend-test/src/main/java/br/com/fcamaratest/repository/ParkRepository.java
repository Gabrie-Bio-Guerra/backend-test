package br.com.fcamaratest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fcamaratest.model.Park;

public interface ParkRepository extends JpaRepository<Park, Long> {

	List<Park> findByCnpj(String value);

	List<Park> findByName(String value);

	List<Park> findByAddress(String value);

	List<Park> findByPhone(String value);

}
