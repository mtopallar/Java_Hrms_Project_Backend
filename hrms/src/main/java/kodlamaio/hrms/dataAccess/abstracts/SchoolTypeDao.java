package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SchoolType;

public interface SchoolTypeDao extends JpaRepository<SchoolType, Integer>
{
	List<SchoolType> getByNameAndIsActive(String name, boolean isActive);

	List<SchoolType> getByIsActive(boolean isActive);

}
