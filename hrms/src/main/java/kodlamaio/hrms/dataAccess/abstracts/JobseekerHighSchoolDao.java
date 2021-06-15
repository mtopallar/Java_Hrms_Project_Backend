package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerHighSchool;

public interface JobseekerHighSchoolDao extends JpaRepository<JobseekerHighSchool, Integer>
{

}
