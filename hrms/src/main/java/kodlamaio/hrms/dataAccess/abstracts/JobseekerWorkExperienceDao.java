package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobseekerWorkExperience;

public interface JobseekerWorkExperienceDao extends JpaRepository<JobseekerWorkExperience, Integer>
{
	List<JobseekerWorkExperience> getByJobseekerIdAndJobseekerCvIdAndAndIsActive(int jobseekerId, int jobseekerCvId, boolean isActive);

	List<JobseekerWorkExperience> getByJobseekerIdAndIsActive(int jobseekerId, boolean isActive);

	List<JobseekerWorkExperience> getByIsActive(boolean isActive);
	
	@Query("From JobseekerWorkExperience where jobseekerId=:jobseekerId and isActive=:isActive Order By endDate Desc")
	List<JobseekerWorkExperience> getJobseekerWorkExperienceSortedByEndDateDesc(int jobseekerId, boolean isActive);
}
