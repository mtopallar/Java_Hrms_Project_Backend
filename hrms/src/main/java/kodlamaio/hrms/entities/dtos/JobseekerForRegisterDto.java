package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobseekerForRegisterDto
{
	@NotBlank
	@NotNull
	private String firstName;

	@NotBlank
	@NotNull
	private String lastName;

	@NotBlank
	@NotNull
	private String identityNumber;

	@NotBlank
	@NotNull
	private int yearOfBirth;

	@NotBlank
	@NotNull
	private String email;

	@Email
	@NotBlank
	@NotNull
	private String password;

	@NotBlank
	@NotNull
	private String passwordAgain;
}
