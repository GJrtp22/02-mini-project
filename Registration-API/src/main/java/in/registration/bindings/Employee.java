package in.registration.bindings;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="EMPLOYEE_DTLS")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="empId")
	private Long empId;
	
	private String empName;
	private Integer empAge;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_emp_Id", referencedColumnName = "empId")
	private List<Address> address;
	

}
