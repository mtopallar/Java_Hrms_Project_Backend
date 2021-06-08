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
@Table(name = "jobseeker_languages")
public class JobseekerLanguage
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// private int jobseekerId;
	// private int languageId;
	// private int jobseekerCvId;

	@Column(name = "reading_point")
	@NotNull
	@NotBlank
	private char readingPoint;

	@Column(name = "writing_point")
	@NotNull
	@NotBlank
	private char writingPoint;

	@Column(name = "speaking_point")
	@NotNull
	@NotBlank
	private char speakingPoint;

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
	@JoinColumn(name = "language_id", nullable = false)
	@NotBlank
	@NotNull
	private Language language;

	@ManyToOne
	@JoinColumn(name = "jobseeker_cv_id", nullable = false)
	@NotBlank
	@NotNull
	private JobseekerCv jobseekerCv;

}
