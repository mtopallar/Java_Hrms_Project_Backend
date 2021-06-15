package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobseekerEducationsMainToShowDto
{
	private int jobseekerEducationId;
	private int jobseekerId;
	private int jobseekerCvId;
	private String schoolTypeName;
	private String schoolName;
	private String departmentName;
	private String graduationGrade;
	private LocalDate startDate;
	private LocalDate endDate;
}
