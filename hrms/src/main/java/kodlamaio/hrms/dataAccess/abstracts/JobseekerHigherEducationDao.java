package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobseekerHigherEducation;

public interface JobseekerHigherEducationDao extends JpaRepository<JobseekerHigherEducation, Integer>
{

}
