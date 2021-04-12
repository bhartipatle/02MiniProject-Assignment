package in.ashokit.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STATE")
public class State {
	
	@Id
	@Column(name = "STATE_ID")
	private Integer stateId;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="state",cascade = CascadeType.ALL)
	private Set<City> cities;
}
