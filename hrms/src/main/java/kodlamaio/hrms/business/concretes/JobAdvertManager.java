package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertToShowDto;

@Service
public class JobAdvertManager implements JobAdvertService
{
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao)
	{
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvertToShowDto>> getAllActives()
	{
		var result = this.jobAdvertDao.getByIsActive(true);
		return new SuccessDataResult<List<JobAdvertToShowDto>>(this.entityToDtoConverter(result),
				Messages.getAllActiveInDtoFormatSuccessfully);
	}

	@Override
	public DataResult<List<JobAdvertToShowDto>> getAllActivesByDeadlineDateDesc()
	{
		Sort sort = Sort.by(Sort.Direction.DESC, "deadlineDate");
		var result = this.jobAdvertDao.findAll(sort);
		List<JobAdvert> activeJobAdverts = new ArrayList<JobAdvert>();
		for (JobAdvert jobAdvert : result)
		{
			if (jobAdvert.isActive())
			{
				activeJobAdverts.add(jobAdvert);
			}
		}

		return new SuccessDataResult<List<JobAdvertToShowDto>>(this.entityToDtoConverter(activeJobAdverts),
				Messages.getAllActiveJobAdvertsByDeadlineDateAscSuccessfully);

	}

	@Override
	public DataResult<List<JobAdvertToShowDto>> getAllByTaskmasterId(int taskmasterId)
	{
		var result = this.jobAdvertDao.getByTaskmaster_UserId(taskmasterId);
		return new SuccessDataResult<List<JobAdvertToShowDto>>(this.entityToDtoConverter(result),
				Messages.getAllJobAdvertsByTaskmasterIdSuccessfully);
	}

	@Override
	public Result add(JobAdvert jobAdvert)
	{
		jobAdvert.setActive(true);
		jobAdvert.setAddedDate(LocalDate.now());
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult(Messages.jobAdvertAddedSuccessfully);
	}

	@Override
	public Result delete(JobAdvert jobAdvert)
	{
		var jobAdvertToDelete = this.jobAdvertDao.getById(jobAdvert.getId());
		jobAdvertToDelete.setActive(false);
		jobAdvertToDelete.setRemovedDate(LocalDate.now());
		this.jobAdvertDao.save(jobAdvertToDelete);
		return new SuccessResult(Messages.jobAdvertDeletedSuccessfully);
	}

	private List<JobAdvertToShowDto> entityToDtoConverter(List<JobAdvert> jobAdverts)
	{
		List<JobAdvertToShowDto> jobAdvertToShowDtos = new ArrayList<JobAdvertToShowDto>();

		for (JobAdvert jobAdvert : jobAdverts)
		{
			JobAdvertToShowDto dto = new JobAdvertToShowDto();
			dto.setCompanyName(jobAdvert.getTaskmaster().getCompanyName());
			dto.setJobPositionName(jobAdvert.getJobPosition().getName());
			dto.setWorkerNeeded(jobAdvert.getWorkerNeeded());
			dto.setAddedDate(jobAdvert.getAddedDate());
			dto.setDeadlineDate(jobAdvert.getDeadlineDate());

			jobAdvertToShowDtos.add(dto);
		}

		return jobAdvertToShowDtos;
	}

}
