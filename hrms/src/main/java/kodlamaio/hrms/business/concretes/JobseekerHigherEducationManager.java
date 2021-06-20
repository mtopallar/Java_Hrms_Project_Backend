package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerHigherEducationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerHigherEducationDao;
import kodlamaio.hrms.entities.concretes.JobseekerHigherEducation;

@Service
public class JobseekerHigherEducationManager implements JobseekerHigherEducationService
{
	private JobseekerHigherEducationDao jobseekerHigherEducationDao;
	
	@Autowired
	public JobseekerHigherEducationManager(JobseekerHigherEducationDao jobseekerHigherEducationDao)
	{
		super();
		this.jobseekerHigherEducationDao = jobseekerHigherEducationDao;
	}

	@Override
	public DataResult<List<JobseekerHigherEducation>> getAllActivesByJobseekerId(int jobseekerId)	
	{
		var result = this.jobseekerHigherEducationDao.getByJobseekerIdAndIsActive(jobseekerId, true);
		if (result == null)
		{
			return new ErrorDataResult<List<JobseekerHigherEducation>>(Messages.GetActiveByJobseekerIdError);
		}
		return new SuccessDataResult<List<JobseekerHigherEducation>>(result, Messages.GetActiveByJobseekerIdSuccessfully);
	}

	@Override
	public DataResult<List<JobseekerHigherEducation>> getAllActives()
	{
		var result = this.jobseekerHigherEducationDao.getByIsActive(true);
		if (result == null)
		{
			return new ErrorDataResult<List<JobseekerHigherEducation>>(Messages.GetAllActiveHigherEducationsError);
		}
		return new SuccessDataResult<List<JobseekerHigherEducation>>(result, Messages.GetAllActiveHigherEducationsSuccessfully);
	}
	
	@Override
	public DataResult<List<JobseekerHigherEducation>> getAllActivesByJobseekerIdSorted(int jobseekerId)
	{
		var result = this.jobseekerHigherEducationDao.getJobseekerActiveHigherEducationsSortedByEndDateDesc(jobseekerId, true);
		if (result==null)
		{
			return new ErrorDataResult<List<JobseekerHigherEducation>>();
		}
		return new SuccessDataResult<List<JobseekerHigherEducation>>(result, Messages.GetAllHigherEducationsSortedSuccessfully);
	}

	@Override
	public Result add(JobseekerHigherEducation jobseekerHigherEducation)
	{
		jobseekerHigherEducation.setAddedDate(LocalDate.now());
		jobseekerHigherEducation.setActive(true);
		this.jobseekerHigherEducationDao.save(jobseekerHigherEducation);
		return new SuccessResult(Messages.JobseekerHigherEducationSacedSuccessfully);
	}

	@Override
	public Result update(JobseekerHigherEducation jobseekerHigherEducation)
	{
		var result = this.jobseekerHigherEducationDao.getById(jobseekerHigherEducation.getId());
		result.setUniversity(jobseekerHigherEducation.getUniversity());
		result.setDepartment(jobseekerHigherEducation.getDepartment());
		result.setStartDate(jobseekerHigherEducation.getStartDate());
		result.setCompleted(jobseekerHigherEducation.isCompleted());
		result.setEndDate(jobseekerHigherEducation.getEndDate());
		result.setGraduationGrade(jobseekerHigherEducation.getGraduationGrade());
		this.jobseekerHigherEducationDao.save(result);
		return new SuccessResult(Messages.JobseekerHigherEducationUpdatedSuccessfully);
	}

	@Override
	public Result delete(JobseekerHigherEducation jobseekerHigherEducation)
	{
		var result = this.jobseekerHigherEducationDao.getById(jobseekerHigherEducation.getId());
		result.setActive(false);
		this.jobseekerHigherEducationDao.save(result);
		return new SuccessResult(Messages.JobseekerHigherEducationDeletedSuccessfully);
	}

	

}
