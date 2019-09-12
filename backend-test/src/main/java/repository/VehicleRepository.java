package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
