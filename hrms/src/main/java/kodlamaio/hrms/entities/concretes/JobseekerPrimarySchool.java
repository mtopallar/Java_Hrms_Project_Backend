package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "jobseeker_primary_schools")
public class JobseekerPrimarySchool
{
	@Id
	@Column(name = "jobseeker_education_id")
	private int jobseekerEducationId;

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "graduation_grade")
	private String graduationGrade;

	@OneToOne
	@MapsId
	@JoinColumn(name = "jobseeker_education_id")
	private JobseekerEducation jobseekerEducation;
}
