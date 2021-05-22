package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "taskmasters")
public class Taskmaster extends User {

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

	public Taskmaster(int id, Date addedDate, Date removedDate, String password, boolean isMailActivated,
			boolean isActive, int userId, String companyName, String companyWebSite, String companyEmail,
			String phoneNumber, boolean activatedByEmployee) {
		super(id, addedDate, removedDate, password, isMailActivated, isActive);
		this.userId = id;
		this.companyName = companyName;
		this.companyWebSite = companyWebSite;
		this.companyEmail = companyEmail;
		this.phoneNumber = phoneNumber;
		this.activatedByEmployee = activatedByEmployee;
	}
}
