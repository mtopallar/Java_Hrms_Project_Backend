package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TaskmasterService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TaskmasterDao;
import kodlamaio.hrms.entities.concretes.Taskmaster;
import kodlamaio.hrms.entities.dtos.TaskmasterForRegisterDto;

@Service
public class TaskmasterManager implements TaskmasterService
{

	private TaskmasterDao taskmasterDao;
	private UserService userService;

	@Autowired
	public TaskmasterManager(TaskmasterDao taskmasterDao, UserService userService)
	{
		super();
		this.taskmasterDao = taskmasterDao;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Taskmaster>> getAllActives()
	{
		return new SuccessDataResult<List<Taskmaster>>(this.taskmasterDao.getByUser_IsActive(true),
				Messages.getAllActiveTaskmastersSuccessfully);
	}

	@Override
	public DataResult<List<Taskmaster>> getAllActiveButNotActivatedByEmployee()
	{
		return new SuccessDataResult<List<Taskmaster>>(
				this.taskmasterDao.getByUser_IsActiveAndActivatedByEmployee(true, false),
				Messages.getAllNotActivatebDyEmployeeFromAllActiveTaskmastersSuccessfully);
	}

	@Override
	public DataResult<List<Taskmaster>> getAllActivesAndActivatedByEmployee()
	{
		return new SuccessDataResult<List<Taskmaster>>(
				this.taskmasterDao.getByUser_IsActiveAndActivatedByEmployee(true, true),
				Messages.getAllActiveAndActivatedByEmployeeTaskmastersSuccessfully);
	}

	@Override
	public Result add(TaskmasterForRegisterDto taskmasterForRegisterDto)
	{
		var domainChecker = this.webSiteAndMailDomainChecker(taskmasterForRegisterDto.getCompanyWebSite(),
				taskmasterForRegisterDto.getEmail());

		if (!domainChecker.isSuccess())
		{
			return domainChecker;
		}

		var nullCheck = this.nullChecker(taskmasterForRegisterDto);
		if (!nullCheck.isSuccess())
		{
			return nullCheck;
		}

		var user = this.dtoToEntityConverter(taskmasterForRegisterDto).getUser();
		var addUser = this.userService.add(user);
		if (!addUser.isSuccess())
		{
			return addUser;
		}
		var taskmaster = this.dtoToEntityConverter(taskmasterForRegisterDto);
		taskmaster.setUserId(user.getId());
		this.taskmasterDao.save(taskmaster);
		return new SuccessResult(Messages.taskmasterAddedSuccessfully);
	}

	@Override
	public Result delete(Taskmaster taskmaster)
	{
		this.userService.delete(taskmaster.getUser());
		return new SuccessResult(Messages.taskMasterDeletedSuccessfully);
	}

	@Override
	public Result activatorForEmployee(Taskmaster taskmaster)
	{
		var taskmasterToActivate = this.taskmasterDao.getById(taskmaster.getUserId());
		taskmasterToActivate.setActivatedByEmployee(true);
		this.taskmasterDao.save(taskmasterToActivate);
		return new SuccessResult(Messages.taskmasterActivatedByEmployeeSuccessfully);
	}

	private Result webSiteAndMailDomainChecker(String webAdress, String email)
	{
		String[] webAdressParts = webAdress.split(".");
		String[] emailParts = email.split("@");
		String mailSecond[] = emailParts[1].split(".");
		String newMail = webAdressParts[1] + webAdressParts[2];
		String newAdress = mailSecond[0];
		if (newAdress == newMail)
		{
			return new SuccessResult();
		}
		return new ErrorResult(Messages.emailDomainVerificationError);
	}

	private Result nullChecker(TaskmasterForRegisterDto taskmasterForRegisterDto)
	{
		if (taskmasterForRegisterDto.getCompanyName() == null
				|| taskmasterForRegisterDto.getCompanyWebSite() == null
				|| taskmasterForRegisterDto.getEmail() == null
				|| taskmasterForRegisterDto.getPhoneNumber() == null
				|| taskmasterForRegisterDto.getPassword() == null
				|| taskmasterForRegisterDto.getPasswordAgain() == null)
		{
			return new ErrorResult("Tüm alanlar zorunludur.");
		} else if (taskmasterForRegisterDto.getPassword() != taskmasterForRegisterDto.getPasswordAgain())
		{
			return new ErrorResult("Parola ve parola tekrarı uyuşmamaktadır.");
		}

		return new SuccessResult();
	}

	private Taskmaster dtoToEntityConverter(TaskmasterForRegisterDto taskmasterForRegisterDto)
	{
		Taskmaster taskmaster = new Taskmaster();

		taskmaster.getUser().setAddedDate(LocalDate.now());
		taskmaster.getUser().setEmail(taskmasterForRegisterDto.getEmail());
		taskmaster.getUser().setPassword(taskmasterForRegisterDto.getPassword());
		taskmaster.setCompanyName(taskmasterForRegisterDto.getCompanyName());
		taskmaster.setCompanyWebSite(taskmasterForRegisterDto.getCompanyWebSite());
		taskmaster.setPhoneNumber(taskmasterForRegisterDto.getPhoneNumber());
		taskmaster.setActivatedByEmployee(false);
		return taskmaster;
	}

}
