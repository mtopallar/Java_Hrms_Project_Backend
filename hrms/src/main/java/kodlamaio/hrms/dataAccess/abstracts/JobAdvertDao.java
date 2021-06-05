package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertToShowDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>
{
	List<JobAdvert> getByIsActive(boolean isActive); // henüz kullanmadım

	List<JobAdvert> getByTaskmaster_UserId(int taskmasterId); // henüz kullanmadım.

	// base - henüz kullanmadım
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertToShowDto(a.id, t.companyName, p.name, a.workerNeeded, a.addedDate, a.deadlineDate) From JobAdvert a Inner Join a.taskmaster t Inner Join a.jobPosition p")
	List<JobAdvertToShowDto> getJobAdvertWithPositionNameAndCompanyDetails();

	// kullanıldı
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertToShowDto(a.id, t.companyName, p.name, a.workerNeeded, a.addedDate, a.deadlineDate) From JobAdvert a Inner Join a.taskmaster t Inner Join a.jobPosition p where a.isActive=:isActive")
	List<JobAdvertToShowDto> getAllActiveStatueJobAdvertWithPositionNameAndCompanyDetails(boolean isActive);

	// kullanıldı
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertToShowDto(a.id, t.companyName, p.name, a.workerNeeded, a.addedDate, a.deadlineDate) From JobAdvert a Inner Join a.taskmaster t Inner Join a.jobPosition p where t.userId=:taskmasterId and a.isActive =:isActive")
	List<JobAdvertToShowDto> getAllActiveJobAdvertWithPositionNameAndCompanyDetailsByTaskmasterId(
			int taskmasterId, boolean isActive);

	// kullanıldı
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertToShowDto(a.id, t.companyName, p.name, a.workerNeeded, a.addedDate, a.deadlineDate) From JobAdvert a Inner Join a.taskmaster t Inner Join a.jobPosition p where a.isActive=:isActive Order By a.deadlineDate Desc")
	List<JobAdvertToShowDto> getAllActiveJobAdvertWithPositionNameAndCompanyDetailsByDeadlineDateDesc(
			boolean isActive);

	// select t.companyName, p.name, a.workerNeeded, a.addedDate, a.deadlineDate
	// from JobAdvert a inner join Taskmaster t inner join JobPosition p

	// t den company name
	// p name

	// isactive ler front tarafta listelenirken isActive olanla arasından
	// listeleneceği için burada tekrar kontrole gerek kalmaz. Front tarafta çılır
	// liste is active = true ya göre geleceğinden seçilecek id ler zaten aktif
	// olacaktır.

}
