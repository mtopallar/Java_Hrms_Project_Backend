package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerHigherEducation;

public interface JobseekerHigherEducationDao extends JpaRepository<JobseekerHigherEducation, Integer>
{
	List<JobseekerHigherEducation> getByJobseekerIdAndIsActive(int JobseekerId, boolean isActive);

	List<JobseekerHigherEducation> getByIsActive(boolean isActive);
}
