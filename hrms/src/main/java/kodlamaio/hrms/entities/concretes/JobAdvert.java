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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	// @Column(name = "taskmaster_id")
	// private int taskmasterId;

	// @Column(name = "job_position_id")
	// private int jobPositionId;

	// @Column(name = "city_id")
	// private int cityId;

	@Column(name = "position_details")
	private String positionDetails;

	@Column(name = "salary_min", nullable = true)
	private double salaryMin;

	@Column(name = "salary_max", nullable = true)
	private double salaryMax;

	@Column(name = "worker_needed")
	private short workerNeeded;

	@Column(name = "added_date")
	private LocalDate addedDate;

	@Column(name = "removed_date")
	private LocalDate removedDate;

	@Column(name = "deadline_date")
	private LocalDate deadlineDate;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	@ManyToOne
	@JoinColumn(name = "job_position_id", nullable = false)
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name = "taskmaster_id", nullable = false)
	private Taskmaster taskmaster;

}
