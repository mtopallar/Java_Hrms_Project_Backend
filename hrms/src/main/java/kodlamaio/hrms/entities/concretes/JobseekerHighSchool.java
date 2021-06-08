package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
@Table(name = "jobseeker_high_schools")
public class JobseekerHighSchool
{
	@Id
	@Column(name = "jobseeker_education_id")
	private int jobseekerEducationId;

	// @Column(name = "department_id")
	// private int departmentId;

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;

	@Column(name = "is_completed")
	private boolean isCompleted;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "graduation_grade")
	private String graduationGrade;

	@OneToOne
	@MapsId
	@JoinColumn(name = "jobseeker_education_id")
	private JobseekerEducation jobseekerEducation;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	@NotBlank
	@NotNull
	private Department department;
}
