package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobseeker_cvs")
public class JobseekerCv
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @Column(name = "jobseeker_id")
	// private int jobseekerId;

	@Column(name = "name")
	@NotNull
	@NotBlank
	private String name;

	@Column(name = "photo_link")
	private String photoLink;

	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "linkedin_link")
	private String linkedinLink;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "added_date")
	private LocalDate addedDate;

	@Column(name = "removed_date")
	private LocalDate removedDate;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "jobseeker_id", nullable = false)
	@NotBlank
	@NotNull
	private Jobseeker jobseeker;

	@OneToMany(mappedBy = "jobseekerCv")
	private Set<JobseekerEducation> jobseekerEducations;

	@OneToMany(mappedBy = "jobseekerCv")
	private Set<JobseekerProgrammingLanguage> jobseekerProgrammingLanguages;

	@OneToMany(mappedBy = "jobseekerCv")
	private Set<JobseekerLanguage> jobseekerLanguages;

	@OneToMany(mappedBy = "jobseekerCv")
	private Set<JobseekerWorkExperience> jobseekerWorkExperiences;
}
