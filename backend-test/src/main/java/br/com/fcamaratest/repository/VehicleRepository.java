package br.com.fcamaratest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fcamaratest.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
