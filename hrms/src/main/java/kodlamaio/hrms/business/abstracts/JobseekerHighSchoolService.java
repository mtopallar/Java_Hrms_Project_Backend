package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobseekerHighSchool;

public interface JobseekerHighSchoolService
{
	DataResult<JobseekerHighSchool> getActiveByJobseekerId(int jobseekerId);
	DataResult<List<JobseekerHighSchool>> getAllActives();
	Result add(JobseekerHighSchool jobseekerHighSchool);
	Result update(JobseekerHighSchool jobseekerHighSchool);
	Result delete(JobseekerHighSchool jobseekerHighSchool);
}
