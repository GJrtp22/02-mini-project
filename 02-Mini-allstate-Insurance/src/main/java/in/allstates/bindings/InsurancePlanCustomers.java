package in.allstates.bindings;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor	
@Table(name="INSURANCE_PLAN_CUSTOMERS")
public class InsurancePlanCustomers {
	
	@Id
	@GeneratedValue
	private Integer customerId;
	
	@Column(name="Customer_Name")
	private String customerName;
	
	@Column(name="Customer_Email")
	private String customerEmail;
	
	@Column(name="Customer_Phone_number")
	private String customerPhoneNumber;
	
	@Column(name="Customer_Gender")
	private String customerGender;
	
	@Column(name="Customer_SSN")
	private Long CustomerSSN;
	
	@Column(name="Plan_Name")
	private String planName;
	
	@Column(name="Plan_Status")
	private String planStatus;
	
}
