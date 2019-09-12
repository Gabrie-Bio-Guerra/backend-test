package br.com.fcamaratest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fcamaratest.model.Park;

public interface ParkRepository extends JpaRepository<Park, Long> {

}
