package kodlamaio.hrms.core.utilities.verification.mailVerification;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;

public interface MailActivatorService
{
	DataResult<User> sendActivationMail(User user);
}
