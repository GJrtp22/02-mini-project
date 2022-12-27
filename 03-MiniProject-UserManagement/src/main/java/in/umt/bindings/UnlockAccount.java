package in.umt.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnlockAccount {

	private String emailId;
	private String temparoryPassword;
	private String newPassword;

}
