package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>
{
	User getByEmail(String email);

	List<User> getAll();

	List<User> getByIsMailActivatedAndIsActive(boolean isMailActivated, boolean isActive);

	List<User> getByIsActive(boolean isActive);

}
