package in.ashokit.domain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="USER_EMAIL")
	private String userEmail;
	
	@Column(name="USER_MOBILE")
	private String userMobile;
	
	@Column(name="DOB")
	private Date dob;
	
	@CreatedDate
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@LastModifiedDate
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="USER_PWD")
	private String userPwd;
	
	@Column(name="ACC_STATUS")
	private String accStatus;
	
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	
	@Column(name="STATE_ID")
	private Integer stateId;
	
	@Column(name="CITY_ID")
	private Integer cityId;
	
}
