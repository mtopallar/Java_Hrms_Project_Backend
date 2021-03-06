package kodlamaio.hrms.core.utilities.verification.mailVerification;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class FakeMailActivator implements MailActivatorService
{

	@Override
	public DataResult<User> sendActivationMail(User user)
	{
		user.setMailActivated(true);
		return new SuccessDataResult<User>(user, Messages.mailActivatedSuccessfully);
	}

}
