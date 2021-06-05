package kodlamaio.hrms.core.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>
{
	User getByEmail(String email);

	List<User> getByIsMailActivatedAndIsActive(boolean isMailActivated, boolean isActive);

	List<User> getByIsActive(boolean isActive);

}
