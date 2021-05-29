package kodlamaio.hrms.core.utilities.verification.mailVerification;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;

public interface MailActivatorService
{
	public DataResult<User> sendActivationMail(User user);
}
