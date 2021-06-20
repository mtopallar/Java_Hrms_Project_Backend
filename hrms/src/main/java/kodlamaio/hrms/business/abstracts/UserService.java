package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService
{
	DataResult<User> getByEmail(String email);

	DataResult<User> getById(int id);

	DataResult<List<User>> getAll(); // Admin

	DataResult<List<User>> getAllActiveUsers();

	DataResult<List<User>> getAllNoMailActivatedActiveUsers();

	DataResult<List<User>> getAllDeactiveUsers();

	Result add(User user);

	// Result add(User user, AddUserSelectorService addUserSelectorService);

	Result delete(User user);

	// buraya dto ları içeren işveren, iş arayan, personel paramına göre ekleme
	// metod alternatifleri getirilebiir. parametreye göre ilgili birimin servisi
	// controllerda çağırılır.

}
