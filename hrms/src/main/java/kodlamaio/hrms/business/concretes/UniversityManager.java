package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDao;
import kodlamaio.hrms.entities.concretes.University;

@Service
public class UniversityManager implements UniversityService
{
	private UniversityDao universityDao;

	@Autowired
	public UniversityManager(UniversityDao universityDao)
	{
		super();
		this.universityDao = universityDao;
	}

	@Override
	public DataResult<List<University>> getAllActives()
	{
		var result = this.universityDao.getByIsActive(true);
		if (result == null)
		{
			return new ErrorDataResult<List<University>>(Messages.ActiveUniversityNotFound);
		}
		return new SuccessDataResult<List<University>>(result, Messages.GetAllActiveUniversitiesSuccessfully);
	}

	@Override
	public DataResult<University> getById(int id)
	{
		var result = this.universityDao.getById(id);
		if (result == null)
		{
			return new ErrorDataResult<University>(Messages.GetUniversityByIdNotFound);
		}
		return new SuccessDataResult<University>(result, Messages.GetUniversityByIdSuccessfully);
	}

	@Override
	public Result add(University university)
	{
		this.universityDao.save(university);
		return new SuccessResult(Messages.UniversityAddedSucccessfully);
	}

	@Override
	public Result update(University university)
	{
		var result = this.universityDao.getById(university.getId());
		result.setName(university.getName());
		this.universityDao.save(result);
		return new SuccessResult(Messages.UniversityUpdatedSuccessfully);
	}

	@Override
	public Result delete(University university)
	{
		var result = this.universityDao.getById(university.getId());
		result.setActive(false);
		return new SuccessResult(Messages.UniversityDeletedSucccessfully);
	}

}
