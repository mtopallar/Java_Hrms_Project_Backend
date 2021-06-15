package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>
{
	List<Department> getByNameAndIsActive(String name, boolean isActive);

	List<Department> getByIsActive(boolean isActive);
}
