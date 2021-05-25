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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "taskmasters")
@AllArgsConstructor
@NoArgsConstructor
public class Taskmaster {

	@Id
	@Column(name = "userId")
	private int userId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "companyWebSite")
	private String companyWebSite;

	@Column(name = "companyEmail")
	private String companyEmail;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "activatedByEmployee")
	private boolean activatedByEmployee;

	@OneToOne
	@MapsId
	@JoinColumn(name = "userId")
	private User user;
}
