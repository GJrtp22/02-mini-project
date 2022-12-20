package in.allstates.bindings;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="INSURANCE_PLAN")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePlan {
	
	@Id
	@GeneratedValue
	@Column(name="Insurance_Id")
	private Integer insuranceId;
	
	@Column(name="Plan_Name")
	private String planName;
	
	@Column(name="Plan_Status")
	private String planStatus;
	
	@Column(name="Start_Date")
	private Date startDate;
	
	@Column(name="End_Date")
	private Date endDate;

}
