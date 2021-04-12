package in.ashokit.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="COUNTRY")
public class Country {
	
	@Id
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="country",cascade = CascadeType.ALL)
	private Set<State> states;
}
