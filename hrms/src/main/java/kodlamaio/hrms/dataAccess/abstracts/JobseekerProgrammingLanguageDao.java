package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerProgrammingLanguage;

public interface JobseekerProgrammingLanguageDao extends JpaRepository<JobseekerProgrammingLanguage, Integer>
{
	List<JobseekerProgrammingLanguage> getByJobseekerIdAndIsActive(int jobseekerId, boolean isActive);

	List<JobseekerProgrammingLanguage> getByIsActive(boolean isActive);

	// Bir DTO ile çekmek gerekebilir
}
