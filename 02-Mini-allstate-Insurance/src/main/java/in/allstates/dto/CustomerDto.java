package in.allstates.dto;

import in.allstates.bindings.InsurancePlanCustomers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	
	private InsurancePlanCustomers customers;

}
