package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TaskmasterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Taskmaster;
import kodlamaio.hrms.entities.dtos.TaskmasterForRegisterDto;

@RestController
@RequestMapping("/api/taskmasters")
public class TaskmastersController
{
	private TaskmasterService taskmasterService;

	@Autowired
	public TaskmastersController(TaskmasterService taskmasterService)
	{
		super();
		this.taskmasterService = taskmasterService;
	}

	@GetMapping("/getall")
	public DataResult<List<Taskmaster>> getAllActives()
	{
		return this.taskmasterService.getAllActives();
	}

	@PostMapping("/add")
	public Result add(@RequestBody TaskmasterForRegisterDto taskmasterForRegisterDto)
	{
		return this.taskmasterService.add(taskmasterForRegisterDto);

	}
}
