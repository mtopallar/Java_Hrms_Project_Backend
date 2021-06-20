package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobseekerPrimarySchool;

public interface JobseekerPrimarySchoolService
{
	DataResult<JobseekerPrimarySchool> getActiveByJobseekerId(int jobseekerId);

	DataResult<List<JobseekerPrimarySchool>> getAllActives();

	Result add(JobseekerPrimarySchool jobseekerPrimarySchool);

	Result update(JobseekerPrimarySchool jobseekerPrimarySchool);

	Result delete(JobseekerPrimarySchool jobseekerPrimarySchool);
}
