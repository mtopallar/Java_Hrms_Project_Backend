package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolType;

public interface SchoolTypeService
{
	DataResult<List<SchoolType>> getAllActives();

	DataResult<SchoolType> getById(int id);

	DataResult<List<SchoolType>> getPredefinedSchoolTypesForAdd();

	Result add(SchoolType schoolType);

	Result delete(SchoolType schoolType);

}
