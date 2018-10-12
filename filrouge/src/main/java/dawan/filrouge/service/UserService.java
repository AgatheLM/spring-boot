package dawan.filrouge.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dawan.filrouge.authentification.User;
import dawan.filrouge.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Objects.requireNonNull(username);
		Optional<User> user = userRepository.findUserWithName(username);
		if (!user.isPresent())
			throw new UsernameNotFoundException("User not found");
		return user.get();
	}
}