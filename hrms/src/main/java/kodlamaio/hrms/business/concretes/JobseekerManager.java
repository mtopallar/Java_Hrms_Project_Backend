package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.mernisVerification.FakeMernisService;
import kodlamaio.hrms.dataAccess.abstracts.JobseekerDao;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dtos.JobseekerForRegisterDto;

@Service
public class JobseekerManager implements JobseekerService
{

	private JobseekerDao jobseekerDao;
	private FakeMernisService mernisService;
	private UserService userService;

	@Autowired
	public JobseekerManager(JobseekerDao jobseekerDao, FakeMernisService mernisService, UserService userService)
	{
		super();
		this.jobseekerDao = jobseekerDao;
		this.mernisService = mernisService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Jobseeker>> getAllActives()
	{
		return new SuccessDataResult<List<Jobseeker>>(this.jobseekerDao.getByUserIsActive(true),
				Messages.allJobseekersListedSuccessfully);
	}

	@Override
	public Result add(JobseekerForRegisterDto jobseekerForRegisterDto)
	{
		var jobseeker = this.ifModelValidCreateJobseeker(jobseekerForRegisterDto);
		var result = this.checkIdentityNumberUsedBefore(jobseeker.getIdentityNumber());
		if (!result.isSuccess())
		{
			return result;
		}

		var mernis = this.mernisIdentifier(jobseeker);
		if (!mernis.isSuccess())
		{
			return mernis;
		}
		var user = jobseeker.getUser();
		var canUserSavesSuccessfully = this.userService.add(user);
		if (!canUserSavesSuccessfully.isSuccess())
		{
			return canUserSavesSuccessfully;

		}

		jobseeker.setUserId(user.getId());
		this.jobseekerDao.save(jobseeker);
		return new SuccessResult(Messages.jobSeekerSavedSuccessFully);

	}

	private Result checkIfAnyPropertiesNull(JobseekerForRegisterDto jobseekerForRegisterDto)
	{

		if (jobseekerForRegisterDto.getFirstName() == null || jobseekerForRegisterDto.getLastName() == null
				|| jobseekerForRegisterDto.getIdentityNumber() == null
				|| jobseekerForRegisterDto.getYearOfBirth() == 0 || jobseekerForRegisterDto.getEmail() == null
				|| jobseekerForRegisterDto.getPassword() == null
				|| jobseekerForRegisterDto.getPasswordAgain() == null)
		{
			return new ErrorResult("Tüm alanlar zorunludur");
		} else if (jobseekerForRegisterDto.getPassword() != jobseekerForRegisterDto.getPasswordAgain())
		{
			return new ErrorResult(Messages.passwordMatchError);
		}
		return new SuccessResult();
	}

	private Jobseeker ifModelValidCreateJobseeker(JobseekerForRegisterDto jobseekerForRegisterDto)
	{
		if (this.checkIfAnyPropertiesNull(jobseekerForRegisterDto).isSuccess())
		{

			Jobseeker jobseeker = new Jobseeker();
			jobseeker.getUser().setAddedDate(LocalDate.now());
			jobseeker.getUser().setEmail(jobseekerForRegisterDto.getEmail());
			jobseeker.getUser().setPassword(jobseekerForRegisterDto.getPassword());
			jobseeker.setFirstName(jobseeker.getFirstName());
			jobseeker.setLastName(jobseekerForRegisterDto.getFirstName());
			jobseeker.setIdentityNumber(jobseekerForRegisterDto.getIdentityNumber());
			jobseeker.setYearOfBirth(jobseekerForRegisterDto.getYearOfBirth());

			return jobseeker;
		}

		return null;
	}

	private Result mernisIdentifier(Jobseeker jobseeker)
	{
		var result = this.mernisService.verify(jobseeker);
		if (!result)
		{
			return new ErrorResult(Messages.verifyError);
		}
		return new SuccessResult();
	}

	private Result checkIdentityNumberUsedBefore(String identityNumber)
	{
		var checkId = this.jobseekerDao.getByIdentityNumber(identityNumber);
		if (checkId == null)
		{
			return new SuccessResult();
		}
		return new ErrorResult(Messages.identityNumberUsedBefore);
	}

}
