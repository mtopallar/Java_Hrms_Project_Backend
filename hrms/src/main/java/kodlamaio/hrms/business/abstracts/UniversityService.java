package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.University;

public interface UniversityService
{
	DataResult<List<University>> getAllActives();

	DataResult<University> getById(int id);

	Result add(University university);

	Result update(University university);

	Result delete(University university);

}
