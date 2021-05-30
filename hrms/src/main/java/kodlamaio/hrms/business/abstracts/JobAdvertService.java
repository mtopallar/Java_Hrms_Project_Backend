package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertToShowDto;

public interface JobAdvertService
{
	// DataResult<List<JobAdvert>> getAllActives();
	// DataResult<List<JobAdvert>> getAllActivesByAddedDateAsc();
	// DataResult<List<JobAdvert>> getAllByTaskmasterId(int taskmasterId);

	DataResult<List<JobAdvertToShowDto>> getAllActives();

	DataResult<List<JobAdvertToShowDto>> getAllActivesByDeadlineDateDesc();

	DataResult<List<JobAdvertToShowDto>> getAllByTaskmasterId(int taskmasterId);

	Result add(JobAdvert jobAdvert);

	Result delete(JobAdvert jobAdvert);
}
