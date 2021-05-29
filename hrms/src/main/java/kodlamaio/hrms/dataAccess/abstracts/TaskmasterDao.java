package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Taskmaster;

public interface TaskmasterDao extends JpaRepository<Taskmaster, Integer>
{
	List<Taskmaster> getByUser_IsActive(boolean isActive);

	List<Taskmaster> getByUser_IsActiveAndActivatedByEmployee(boolean isActive, boolean activatedByEmployee);

	Taskmaster getByUser_Email(String email);
}
