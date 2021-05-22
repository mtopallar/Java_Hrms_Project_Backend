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
@Table(name = "jobPositions")
public class JobPosition {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "addedDate")
	private Date addedDate;

	@Column(name = "removedDate")
	private Date removedDate;

	@Column(name = "isActive")
	private boolean isActive;

	public JobPosition(int id, String name, Date addedDate, Date removedDate, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.addedDate = addedDate;
		this.removedDate = removedDate;
		this.isActive = isActive;
	}
}
