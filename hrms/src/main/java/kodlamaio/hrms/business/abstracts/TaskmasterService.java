package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Taskmaster;
import kodlamaio.hrms.entities.dtos.TaskmasterForRegisterDto;

public interface TaskmasterService
{
	DataResult<List<Taskmaster>> getAllActives();

	DataResult<List<Taskmaster>> getAllActiveButNotActivatedByEmployee();

	DataResult<List<Taskmaster>> getAllActivesAndActivatedByEmployee();

	Result add(TaskmasterForRegisterDto taskmasterForRegisterDto);

	Result delete(Taskmaster taskmaster);

	Result activatorForEmployee(Taskmaster taskmaster);
}
