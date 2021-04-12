package in.ashokit.resource;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.domain.City;

public interface CityRepository extends JpaRepository<City, Serializable> {
	
	// write custom query
	@Query("select cityName from City where stateId =? 1")
	public List<City> findCitiesByStateId(Integer id);
	
}
