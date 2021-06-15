package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.University;

public interface UniversityDao extends JpaRepository<University, Integer>
{
	List<University> getByNameAndIsActive(String name, boolean isActive);

	List<University> getByIsActive(boolean isActive);
}
