package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "addedDate")
	private Date addedDate;

	@Column(name = "removedDate")
	private Date removedDate;

	@Column(name = "password")
	private String password;

	@Column(name = "isMailActivated")
	private boolean isMailActivated;

	@Column(name = "isActive")
	private boolean isActive;

	public User(int id, Date addedDate, Date removedDate, String password, boolean isMailActivated,
			boolean isActive) {
		super();
		this.id = id;
		this.addedDate = addedDate;
		this.removedDate = removedDate;
		this.password = password;
		this.isMailActivated = isMailActivated;
		this.isActive = isActive;
	}

}
