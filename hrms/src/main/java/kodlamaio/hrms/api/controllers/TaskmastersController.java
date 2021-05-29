package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TaskmasterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Taskmaster;

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
}
