package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "jobseekers")
@AllArgsConstructor
@NoArgsConstructor
public class Jobseeker {

	@Id
	@Column(name = "userId")
	private int userId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "identityNumber")
	private String identityNumber;

	@Column(name = "yearOfBirth")
	private int yearOfBirth;

	@Column(name = "email")
	private String email;

	@OneToOne
	@MapsId
	@JoinColumn(name = "userId")
	private User user;

}
