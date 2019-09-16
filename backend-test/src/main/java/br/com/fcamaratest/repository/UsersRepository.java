package br.com.fcamaratest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fcamaratest.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String email);
}
