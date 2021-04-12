package in.ashokit.resource;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.domain.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	
	@Query("select * from User where userEmail =? 1")
	public User findUserByEmailId(String email);
	
}
