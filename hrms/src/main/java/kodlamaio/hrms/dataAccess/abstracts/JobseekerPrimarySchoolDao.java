package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerPrimarySchool;

public interface JobseekerPrimarySchoolDao extends JpaRepository<JobseekerPrimarySchool, Integer>
{

}