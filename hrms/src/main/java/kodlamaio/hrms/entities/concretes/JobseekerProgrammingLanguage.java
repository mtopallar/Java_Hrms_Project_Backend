package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "jobseeker_programming_languages")
public class JobseekerProgrammingLanguage
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// private int jobseekerId;
	// private int jobseekerCvId;
	// private int programmingLanguageId;

	@Column(name = "experience_detail")
	private String experienceDetail;

	@Column(name = "experience_point")
	@NotBlank
	@NotNull
	private char experiencePoint;

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

	@ManyToOne
	@JoinColumn(name = "jobseeker_cv_id", nullable = false)
	@NotBlank
	@NotNull
	private JobseekerCv jobseekerCv;

	@ManyToOne
	@JoinColumn(name = "programming_language_id", nullable = false)
	@NotBlank
	@NotNull
	private ProgrammingLanguage programmingLanguage;
}
