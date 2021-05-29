package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobseekerForRegisterDto
{
	private String firstName;
	private String lastName;
	private String identityNumber;
	private int yearOfBirth;
	private String email;
	private String password;
	private String passwordAgain;
}
