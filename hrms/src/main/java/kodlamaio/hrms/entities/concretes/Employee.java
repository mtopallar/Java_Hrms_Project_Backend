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
@Table(name = ("employees"))
@EqualsAndHashCode(callSuper = false)
public class Employee extends User {
	@Id
	@Column(name = "userId")
	private int userId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	private String email;

	public Employee(int id, Date addedDate, Date removedDate, String password, boolean isMailActivated,
			boolean isActive, int userId, String firstName, String lastName, String email) {
		super(id, addedDate, removedDate, password, isMailActivated, isActive);
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}
