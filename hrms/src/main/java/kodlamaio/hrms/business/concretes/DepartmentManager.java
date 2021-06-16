package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService
{
	private DepartmentDao departmentDao;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao)
	{
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAllActtives()
	{
		var result = this.departmentDao.getByIsActive(true);
		if (result == null)
		{
			return new ErrorDataResult<List<Department>>(Messages.ActiveDepartmentNotFound);
		}
		return new SuccessDataResult<List<Department>>(result, Messages.AllActiveDepartmentsListedSuccessfully);
	}

	@Override
	public DataResult<Department> getById(int id)
	{
		var result = this.departmentDao.getById(id);
		if (result == null)
		{
			return new ErrorDataResult<Department>(Messages.DepartmentByIdNotFound);
		}
		return new SuccessDataResult<Department>(Messages.GetDepartmentByIdSuccessfully);
	}

	@Override
	public Result add(Department department)
	{
		this.departmentDao.save(department);
		return new SuccessResult(Messages.DepartmentAddedSuccessfully);
	}

	@Override
	public Result update(Department department)
	{
		var result = this.departmentDao.getById(department.getId());
		result.setName(department.getName());
		this.departmentDao.save(result);
		return new SuccessResult(Messages.DepartmentUpdatedSuccessfully);
	}

	@Override
	public Result delete(Department department)
	{
		var result = this.departmentDao.getById(department.getId());
		result.setActive(false);
		this.departmentDao.save(result);
		return new SuccessResult(Messages.DepartmentDeletedSuccessfully);
	}

}
