package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertToShowDto;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController
{
	private JobAdvertService jobadvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService advertService)
	{
		super();
		this.jobadvertService = advertService;
	}

	@GetMapping("/getallactives")
	public DataResult<List<JobAdvertToShowDto>> getAllActive()
	{
		return this.jobadvertService.getAllActives();
	}

	@GetMapping("/getallactivesbydeadlinedatedesc")
	public DataResult<List<JobAdvertToShowDto>> getAllActivesByDeadlineDateDesc()
	{
		return this.jobadvertService.getAllActivesByDeadlineDateDesc();
	}

	@GetMapping("/getAllByTaskmasterId")
	public DataResult<List<JobAdvertToShowDto>> getAllByTaskmasterId(int taskmasterId)
	{
		return this.jobadvertService.getAllByTaskmasterId(taskmasterId);
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert)
	{
		return this.jobadvertService.add(jobAdvert);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvert jobAdvert)
	{
		return this.jobadvertService.delete(jobAdvert);
	}
}
