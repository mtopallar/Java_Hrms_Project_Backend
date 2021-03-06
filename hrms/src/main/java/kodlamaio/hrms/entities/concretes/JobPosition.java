package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "added_date")
	private LocalDate addedDate;

	@Column(name = "removed_date")
	private LocalDate removedDate;

	@Column(name = "is_active")
	private boolean isActive;

	@OneToMany(mappedBy = "jobPosition")
	private Set<JobAdvert> jobAdverts;
}
