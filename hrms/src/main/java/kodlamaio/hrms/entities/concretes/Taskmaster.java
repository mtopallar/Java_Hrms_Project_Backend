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
public class Taskmaster
{

	@Id
	@Column(name = "user_id")
	private int userId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_web_site")
	private String companyWebSite;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "activated_by_employee")
	private boolean activatedByEmployee;

	@OneToOne
	@MapsId
	@JoinColumn(name = "user_id")
	private User user;
}
