package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerPrimarySchoolService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerPrimarySchoolDao;
import kodlamaio.hrms.entities.concretes.JobseekerPrimarySchool;

@Service
public class JobseekerPrimarySchoolManager implements JobseekerPrimarySchoolService
{
	private JobseekerPrimarySchoolDao jobseekerPrimarySchoolDao;

	@Autowired
	public JobseekerPrimarySchoolManager(JobseekerPrimarySchoolDao jobseekerPrimarySchoolDao)
	{
		super();
		this.jobseekerPrimarySchoolDao = jobseekerPrimarySchoolDao;
	}

	@Override
	public DataResult<JobseekerPrimarySchool> getActiveByJobseekerId(int jobseekerId)
	{
		var result = this.jobseekerPrimarySchoolDao.getByJobseekerIdAndIsActiveId(jobseekerId, true);
		if (result == null)
		{
			return new ErrorDataResult<JobseekerPrimarySchool>(Messages.NoActivePrimarySchoolFoundForThisUser);
		}
		return new SuccessDataResult<JobseekerPrimarySchool>(Messages.GetUsersPrimarySchoolSuccessfully);
	}

	@Override
	public DataResult<List<JobseekerPrimarySchool>> getAllActives()
	{
		var result = this.jobseekerPrimarySchoolDao.getByIsActive(true);
		if (result == null)
		{
			return new ErrorDataResult<List<JobseekerPrimarySchool>>(Messages.NoActivePrimarySchoolFound);
		}
		return new SuccessDataResult<List<JobseekerPrimarySchool>>(result, Messages.GetAllActivePrimarySchoolsSuccessfully);
	}

	@Override
	public Result add(JobseekerPrimarySchool jobseekerPrimarySchool)
	{
		jobseekerPrimarySchool.setAddedDate(LocalDate.now());
		jobseekerPrimarySchool.setActive(true);
		this.jobseekerPrimarySchoolDao.save(jobseekerPrimarySchool);
		return new SuccessResult(Messages.PrimarySchoolAddedSuccessfully);
	}

	@Override
	public Result update(JobseekerPrimarySchool jobseekerPrimarySchool)
	{
		var result = this.jobseekerPrimarySchoolDao.getById(jobseekerPrimarySchool.getId());
		result.setEndDate(jobseekerPrimarySchool.getEndDate());
		result.setGraduationGrade(jobseekerPrimarySchool.getGraduationGrade());
		result.setName(jobseekerPrimarySchool.getName());
		result.setStartDate(jobseekerPrimarySchool.getStartDate());
		this.jobseekerPrimarySchoolDao.save(result);
		return new SuccessResult(Messages.PrimarySchoolUpdatedSuccessfully);
	}

	@Override
	public Result delete(JobseekerPrimarySchool jobseekerPrimarySchool)
	{
		var result = this.jobseekerPrimarySchoolDao.getById(jobseekerPrimarySchool.getId());
		result.setActive(false);
		return new SuccessResult(Messages.PrimarySchoolDeletedSuccessfully);
	}

}
