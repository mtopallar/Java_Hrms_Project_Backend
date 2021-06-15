package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobseekerEducation;

public interface JobseekerEducationDao extends JpaRepository<JobseekerEducation, Integer>
{
	List<JobseekerEducation> getByJobseekerIdAndIsActive(int jobseekerId, boolean isActive);

	List<JobseekerEducation> getByIsActive(boolean isActive);

	@Query("package kodlamaio.hrms.entities.dtos.JobseekerEducationsMainToShowDto()") // eksik
	List<JobseekerEducation> getJobseekersFullEducationsInOneCv(int jobseekerId, int cvId);
}
