package kodlamaio.hrms.core.utilities.verification.mailVerification;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.User;

public class FakeMailActivator implements MailActivatorService
{
	private UserService userService;

	public FakeMailActivator(UserService userService)
	{
		super();
		this.userService = userService;
	}

	@Override
	public DataResult<User> sendActivationMail(User user)
	{
		// User servisten user ı çek, is_mail_activated alanını true yapıp güncelle.
		var userToMailActivated = this.userService.getById(user.getId()).getData();
		userToMailActivated.setMailActivated(true);
		return new SuccessDataResult<User>(userToMailActivated, Messages.mailActivatedSuccessfully);
	}

}
