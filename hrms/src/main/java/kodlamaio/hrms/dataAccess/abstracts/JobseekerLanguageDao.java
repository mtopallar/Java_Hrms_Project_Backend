package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerLanguage;

public interface JobseekerLanguageDao extends JpaRepository<JobseekerLanguage, Integer>
{
	List<JobseekerLanguage> getByJobseekerIdAndJobseekerCvIdAndIsActive(int jobseekerId, int jobseekerCvId,
			boolean isActive);

	List<JobseekerLanguage> getByJobseekerIdAndIsActive(int jobseekerId, boolean isActive);

	List<JobseekerLanguage> getByIsActive(boolean isActive);

	// DTO ile çekmek gerekebilir.
}
