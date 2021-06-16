package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerHighSchool;

public interface JobseekerHighSchoolDao extends JpaRepository<JobseekerHighSchool, Integer>
{

	JobseekerHighSchool getByJobseekerIdAndIsActive(int jobseekerId, boolean isActive);

	List<JobseekerHighSchool> getByIsActive(boolean isActive);
}
