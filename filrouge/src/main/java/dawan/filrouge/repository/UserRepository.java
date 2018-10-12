package dawan.filrouge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dawan.filrouge.authentification.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	@Query(" select u from User u " +
			" where u.username = ?1")
			Optional<User> findUserWithName(String username);
}
