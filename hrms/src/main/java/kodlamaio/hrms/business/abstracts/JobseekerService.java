package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dtos.JobseekerForRegisterDto;

public interface JobseekerService
{
	DataResult<List<Jobseeker>> getAllActives();

	Result add(JobseekerForRegisterDto jobseekerForRegisterDto);

}
