package in.ashokit.resource;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable>{

}
