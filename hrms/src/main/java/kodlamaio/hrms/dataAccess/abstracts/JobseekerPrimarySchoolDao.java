package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerPrimarySchool;

public interface JobseekerPrimarySchoolDao extends JpaRepository<JobseekerPrimarySchool, Integer>
{
	JobseekerPrimarySchool getByJobseekerIdAndIsActiveId(int jobseekerId, boolean isActive);

	List<JobseekerPrimarySchool> getByIsActive(boolean isActive);
}
