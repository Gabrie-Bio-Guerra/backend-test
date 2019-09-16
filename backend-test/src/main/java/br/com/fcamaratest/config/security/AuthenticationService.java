package br.com.fcamaratest.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fcamaratest.model.Users;
import br.com.fcamaratest.repository.UsersRepository;

@Service
public class AuthenticationService implements UserDetailsService{

	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> user = userRepository.findByEmail(username);
		if (user.isPresent()) {
			return user.get();
		}
		throw new UsernameNotFoundException("Dados Inválidos!");
	}

}
