package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "jobseeker_educations")
public class JobseekerEducation
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// private int jobseekerId;
	// private int schoolTypeId;
	// private int jobseekerCvId;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "added_date")
	private LocalDate addedDate;

	@Column(name = "removed_date")
	private LocalDate removedDate;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "jobseeker_cv_id", nullable = false)
	@NotBlank
	@NotNull
	private JobseekerCv jobseekerCv;

	@OneToOne(mappedBy = "jobseekerEducation", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private JobseekerPrimarySchool jobseekerPrimarySchool;

	@OneToOne(mappedBy = "jobseekerEducation", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private JobseekerHighSchool jobseekerHighSchool;

	@OneToOne(mappedBy = "jobseekerEducation", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private JobseekerHigherEducation jobseekerHigherEducation;

}
