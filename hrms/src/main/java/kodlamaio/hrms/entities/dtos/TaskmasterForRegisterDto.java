package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskmasterForRegisterDto
{
	private String companyName;
	private String companyWebSite;
	private String email;
	private String phoneNumber;
	private String password;
	private String passwordAgain;

}
