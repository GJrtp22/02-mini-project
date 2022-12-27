package in.umt.bindings;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USER_DTLS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	private Long Id;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String email;
	private String phoneNumber;
	private Date dob;
	private String gender;
	private String country;
	private String state;
	private String city;
	private String password;
	private boolean active;
	
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="userId_fk")
	//private Country country;
	
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="userId_fk")
	//private Location location;
	
	
	
	

}
