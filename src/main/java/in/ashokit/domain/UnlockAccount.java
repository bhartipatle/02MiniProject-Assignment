package in.ashokit.domain;

import lombok.Data;

@Data
public class UnlockAccount {	
	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
	
	
}
