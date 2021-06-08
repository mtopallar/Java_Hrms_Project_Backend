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
@Table(name = "jobseeker_work_experiences")
public class JobseekerWorkExperience
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// private int jobseekerId;
	// private int jobseekerCvId;

	@Column(name = "workplace_name")
	@NotNull
	@NotBlank
	private String workplaceName;

	@Column(name = "job_description")
	@NotNull
	@NotBlank
	private String jobDescription;

	@Column(name = "start_date")
	@NotNull
	@NotBlank
	private LocalDate startDate;

	@Column(name = "still_working")
	private boolean stillWorking;

	@Column(name = "end_date")
	private LocalDate endDate;

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
}
