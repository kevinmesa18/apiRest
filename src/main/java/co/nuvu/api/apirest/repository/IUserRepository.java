package co.nuvu.api.apirest.repository;

import co.nuvu.api.apirest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.email = ?1 and u.password = ?2")
	User validateUser(String email, String password);
}
