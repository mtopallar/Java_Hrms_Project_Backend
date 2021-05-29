package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService
{

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao)
	{
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAllActives()
	{
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.getByIsActive(true),
				Messages.getAllActivePositions);
	}

	@Override
	public Result add(JobPosition jobPosition)
	{
		var result = this.isAddedBefore(jobPosition.getName());
		if (!result.isSuccess())
		{
			return result;
		}
		jobPosition.setAddedDate(LocalDate.now());
		jobPosition.setActive(true);
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(Messages.positionAddedSuccessfully);
	}

	private Result isAddedBefore(String name)
	{
		var checkName = this.jobPositionDao.getByName(name);
		if (checkName != null)
		{
			return new ErrorResult("Bu pozisyon daha önce eklenmiş.");
		}
		return new SuccessResult();
	}

}
