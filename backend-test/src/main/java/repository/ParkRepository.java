package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Park;

public interface ParkRepository extends JpaRepository<Park, Long> {

}
