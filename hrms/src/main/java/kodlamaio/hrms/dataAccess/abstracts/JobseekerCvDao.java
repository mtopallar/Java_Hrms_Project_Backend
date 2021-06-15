package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerCv;

public interface JobseekerCvDao extends JpaRepository<JobseekerCv, Integer>
{
	List<JobseekerCv> getByJobseekerIdAndIsActive(int jobseekerId, boolean isActive);

	List<JobseekerCv> getByIsActive(boolean isActive);
}
