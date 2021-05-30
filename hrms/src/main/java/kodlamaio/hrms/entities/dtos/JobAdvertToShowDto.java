package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertToShowDto
{
	private String companyName;
	private String jobPositionName;
	private short workerNeeded;
	private LocalDate addedDate;
	private LocalDate deadlineDate;
}
