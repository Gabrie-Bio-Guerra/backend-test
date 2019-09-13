package br.com.fcamaratest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import br.com.fcamaratest.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{


	List<Vehicle> findByColor(String value);

	List<Vehicle> findByModel(String value);

	List<Vehicle> findByBrand(String value);

	List<Vehicle> findByPlate(String value);

	List<Vehicle> findByType(String value);

	List<Vehicle> findByPark(int parseInt);

	List<Vehicle> findByPark(@Nullable Object object);

}
