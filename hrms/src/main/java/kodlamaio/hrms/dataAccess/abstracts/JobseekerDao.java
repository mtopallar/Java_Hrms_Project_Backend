package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface JobseekerDao extends JpaRepository<Jobseeker, Integer>
{
	Jobseeker getByIdentityNumber(String identityNumber);

	List<Jobseeker> getByUserIsActive(boolean isActive);
}
