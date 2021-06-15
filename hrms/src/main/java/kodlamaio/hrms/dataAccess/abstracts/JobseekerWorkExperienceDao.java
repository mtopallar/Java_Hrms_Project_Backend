package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerWorkExperience;

public interface JobseekerWorkExperienceDao extends JpaRepository<JobseekerWorkExperience, Integer>
{
	List<JobseekerWorkExperience> getByJobseekerIdAndJobseekerCvIdAndAndIsActive(int jobseekerId,
			int jobseekerCvId, boolean isActive);

	List<JobseekerWorkExperience> getByJobseekerIdAndIsActive(int jobseekerId, boolean isActive);

	List<JobseekerWorkExperience> getByIsActive(boolean isActive);
}
