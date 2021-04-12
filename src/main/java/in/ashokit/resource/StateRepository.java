package in.ashokit.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.domain.State;

public interface StateRepository extends JpaRepository<State, Serializable>{
	
	@Query("select stateName from State where countryId = ?1")
	public List<State> findStatesByCountryId(Integer id);
}
