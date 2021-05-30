package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verification.mailVerification.MailActivatorService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService
{

	private UserDao userDao;
	private MailActivatorService mailActivatorService;

	@Autowired
	public UserManager(UserDao userDao, MailActivatorService mailActivatorService)
	{
		super();
		this.userDao = userDao;
		this.mailActivatorService = mailActivatorService;
	}

	@Override
	public DataResult<User> getByEmail(String email)
	{
		return new SuccessDataResult<User>(this.userDao.getByEmail(email), Messages.getUserByMailSuccessfully);
	}

	@Override
	public DataResult<User> getById(int id)
	{
		return new SuccessDataResult<User>(this.userDao.getById(id), Messages.getUserByIdSuccessfully);
	}

	@Override
	public DataResult<List<User>> getAll()
	{

		return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.getAllUserSuccessfully);
	}

	@Override
	public DataResult<List<User>> getAllActiveUsers()
	{
		return new SuccessDataResult<List<User>>(this.userDao.getByIsActive(true),
				Messages.getAllActiveUsersSuccessfully);
	}

	@Override
	public DataResult<List<User>> getAllNoMailActivatedActiveUsers()
	{
		return new SuccessDataResult<List<User>>(this.userDao.getByIsMailActivatedAndIsActive(false, true),
				Messages.getAllNoMailActivatedActiveUsers);
	}

	@Override
	public DataResult<List<User>> getAllDeactiveUsers()
	{
		return new SuccessDataResult<List<User>>(this.userDao.getByIsActive(false),
				Messages.getAllDeactiveUsersSuccessfully);
	}

	@Override
	public Result add(User user)
	{
		// mernis (jobseekerda), daha önce kayıtlı eposta olmayacak, email doğrulama
		user.setActive(true);
		var mailUsedBefore = this.getByEmail(user.getEmail());
		var mailActivated = this.mailActivatorService.sendActivationMail(user);
		if (mailUsedBefore.isSuccess())
		{
			return new ErrorResult(Messages.mailAdressUsedBefore);
		}
		if (mailActivated.isSuccess())
		{
			this.userDao.save(mailActivated.getData());
			return new SuccessResult(Messages.userSavedSuccessfully);
		}

		return new ErrorResult(Messages.toComleteRegistrationActivateMail);
	}

	@Override
	public Result delete(User user)
	{
		var userToDelete = this.getById(user.getId()).getData();
		userToDelete.setActive(false);
		this.userDao.save(userToDelete);
		return new SuccessResult(Messages.userDeletedSuccessfully);
	}

}
