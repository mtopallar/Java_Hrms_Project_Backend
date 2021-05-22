package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TaskmasterService;
import kodlamaio.hrms.dataAccess.abstracts.TaskmasterDao;
import kodlamaio.hrms.entities.concretes.Taskmaster;

@Service
public class TaskmasterManager implements TaskmasterService {

	private TaskmasterDao taskMasterDao;

	@Autowired
	public TaskmasterManager(TaskmasterDao taskMasterDao) {
		super();
		this.taskMasterDao = taskMasterDao;
	}

	@Override
	public List<Taskmaster> getAll()
	{
		return this.taskMasterDao.findAll();
	}

}
