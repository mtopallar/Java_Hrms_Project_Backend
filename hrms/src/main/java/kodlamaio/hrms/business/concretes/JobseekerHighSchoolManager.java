package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerHighSchoolService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerHighSchoolDao;
import kodlamaio.hrms.entities.concretes.JobseekerHighSchool;

@Service
public class JobseekerHighSchoolManager implements JobseekerHighSchoolService
{
	private JobseekerHighSchoolDao jobseekerHighSchoolDao;
	
	@Autowired
	public JobseekerHighSchoolManager(JobseekerHighSchoolDao jobseekerHighSchoolDao)
	{
		super();
		this.jobseekerHighSchoolDao = jobseekerHighSchoolDao;
	}

	@Override
	public DataResult<JobseekerHighSchool> getActiveByJobseekerId(int jobseekerId)
	{
		var result = this.jobseekerHighSchoolDao.getByJobseekerIdAndIsActive(jobseekerId, true);
		if (result==null)
		{
			return new ErrorDataResult<JobseekerHighSchool>(Messages.NoActiveHighSchoolFound);
		}
		return new SuccessDataResult<JobseekerHighSchool>(result, Messages.getActiveByJobseekerIdSuccessfully);
	}

	@Override
	public DataResult<List<JobseekerHighSchool>> getAllActives()
	{
		var result = this.jobseekerHighSchoolDao.getByIsActive(true);
		if (result==null)
		{
			return new ErrorDataResult<List<JobseekerHighSchool>>(Messages.GetAllActivesError);
		}
		return new SuccessDataResult<List<JobseekerHighSchool>>(result, Messages.getAllActivesSuccessfully);
	}

	@Override
	public Result add(JobseekerHighSchool jobseekerHighSchool)
	{
		jobseekerHighSchool.setAddedDate(LocalDate.now());
		jobseekerHighSchool.setActive(true);
		this.jobseekerHighSchoolDao.save(jobseekerHighSchool);
		return new SuccessResult(Messages.HighSchoolAddedSuccessfully);
	}

	@Override
	public Result update(JobseekerHighSchool jobseekerHighSchool)
	{
		var result = this.jobseekerHighSchoolDao.getById(jobseekerHighSchool.getId());
		result.setDepartment(jobseekerHighSchool.getDepartment());
		result.setName(jobseekerHighSchool.getName());
		result.setStartDate(jobseekerHighSchool.getStartDate());
		result.setCompleted(jobseekerHighSchool.isCompleted());
		result.setEndDate(jobseekerHighSchool.getEndDate());;
		result.setGraduationGrade(jobseekerHighSchool.getGraduationGrade());
		this.jobseekerHighSchoolDao.save(result);
		return new SuccessResult(Messages.JobseekerHighSchoolUpdatedSuccessfully);
	}

	@Override
	public Result delete(JobseekerHighSchool jobseekerHighSchool)
	{
		var result = this.jobseekerHighSchoolDao.getById(jobseekerHighSchool.getId());
		result.setActive(false);
		return new SuccessResult(Messages.JobseekerHighSchoolDeletedSuccessfully);
	}

}
