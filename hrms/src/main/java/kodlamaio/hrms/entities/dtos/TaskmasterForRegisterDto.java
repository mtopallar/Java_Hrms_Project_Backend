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
public class TaskmasterForRegisterDto
{
	@NotBlank
	@NotNull
	private String companyName;

	@NotBlank
	@NotNull
	private String companyWebSite;

	@Email
	@NotBlank
	@NotNull
	private String email;

	@NotBlank
	@NotNull
	private String phoneNumber;

	@NotBlank
	@NotNull
	private String password;

	@NotBlank
	@NotNull
	private String passwordAgain;

}
