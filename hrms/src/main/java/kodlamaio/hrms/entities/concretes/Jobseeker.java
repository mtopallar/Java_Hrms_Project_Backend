package kodlamaio.hrms.entities.concretes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "jobseekers")
@AllArgsConstructor
@NoArgsConstructor
public class Jobseeker
{

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;

	@Column(name = "identity_number")
	@NotBlank
	@NotNull
	private String identityNumber;

	@Column(name = "year_of_birth")
	@NotBlank
	@NotNull
	private int yearOfBirth;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "jobseeker")
	private Set<JobseekerCv> jobseekerCvs;

	@OneToMany(mappedBy = "jobseeker")
	private Set<JobseekerEducation> jobseekerEducations;

	@OneToMany(mappedBy = "jobseeker")
	private Set<JobseekerProgrammingLanguage> jobseekerProgrammingLanguages;

	@OneToMany(mappedBy = "jobseeker")
	private Set<JobseekerLanguage> jobseekerLanguages;

	@OneToMany(mappedBy = "jobseeker")
	private Set<JobseekerWorkExperience> jobseekerWorkExperiences;

}
