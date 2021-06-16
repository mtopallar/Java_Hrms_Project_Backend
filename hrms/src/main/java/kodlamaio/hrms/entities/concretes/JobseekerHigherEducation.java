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
@Table(name = "jobseeker_higher_educations")
public class JobseekerHigherEducation
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @Column(name = "university_id")
	// @NotNull
	// @NotBlank
	// private int universityId;

	// @Column(name = "department_id")
	// @NotNull
	// @NotBlank
	// private int departmentId;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "is_completed")
	private boolean isCompleted;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "graduation_grade")
	@NotNull
	@NotBlank
	private String graduationGrade;

	@Column(name = "added_date")
	private LocalDate addedDate;

	@Column(name = "removed_date")
	private LocalDate removedDate;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "university_id", nullable = false)
	@NotBlank
	@NotNull
	private University university;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	@NotBlank
	@NotNull
	private Department department;

	@ManyToOne
	@JoinColumn(name = "jobseeker_id", nullable = false)
	@NotNull
	@NotBlank
	private Jobseeker jobseeker;

}
