package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobseekerHigherEducation;


public interface JobseekerHigherEducationService
{
	DataResult<List<JobseekerHigherEducation>> getAllActivesByJobseekerId(int jobseekerId);

	DataResult<List<JobseekerHigherEducation>> getAllActives();
	
	DataResult<List<JobseekerHigherEducation>> getAllActivesByJobseekerIdSorted(int jobseekerId);

	Result add(JobseekerHigherEducation jobseekerHigherEducation);

	Result update(JobseekerHigherEducation jobseekerHigherEducation);

	Result delete(JobseekerHigherEducation jobseekerHigherEducation);
}
