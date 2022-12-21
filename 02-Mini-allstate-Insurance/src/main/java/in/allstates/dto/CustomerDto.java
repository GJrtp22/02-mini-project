package in.allstates.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString

public class CustomerDto {
	
	private String customerName;
	private String customerEmail;
	private String customerPhoneNumber;
	private String customerGender;
	private Long CustomerSSN;
}
