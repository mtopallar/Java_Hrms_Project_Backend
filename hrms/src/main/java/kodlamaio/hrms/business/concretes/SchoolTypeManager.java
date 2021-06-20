package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolTypeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolTypeDao;
import kodlamaio.hrms.entities.concretes.SchoolType;

@Service
public class SchoolTypeManager implements SchoolTypeService
{
	private SchoolTypeDao schoolTypeDao;

	@Autowired
	public SchoolTypeManager(SchoolTypeDao schoolTypeDao)
	{
		super();
		this.schoolTypeDao = schoolTypeDao;
	}

	@Override
	public DataResult<List<SchoolType>> getAllActives()
	{
		var result = this.schoolTypeDao.getByIsActive(true);
		if (result == null)
		{
			return new ErrorDataResult<List<SchoolType>>(Messages.ActiveSchoolTypeNotFound);
		}
		return new SuccessDataResult<List<SchoolType>>(result, Messages.GetAllActiveSchoolsSucccessfully);
	}

	@Override
	public DataResult<SchoolType> getById(int id)
	{
		var result = this.schoolTypeDao.getById(id);
		if (result == null)
		{
			return new ErrorDataResult<SchoolType>(Messages.SchoolTypeNotFound);
		}
		return new SuccessDataResult<SchoolType>(result, Messages.GetSchoolTypeByIdSuccessfully);
	}

	@Override
	public DataResult<List<SchoolType>> getPredefinedSchoolTypesForAdd()
	{
		var predefinedSchools = new ArrayList<SchoolType>()
		{

			private static final long serialVersionUID = 1L;

			{
				new SchoolType()
				{
					{
						setName("İlkokul");
						setActive(true);
					}
				};
				new SchoolType()
				{
					{
						setName("İlköğretim");
						setActive(true);
					}
				};
				new SchoolType()
				{
					{
						setName("Ortaokul");
						setActive(true);
					}
				};
				new SchoolType()
				{
					{
						setName("Lise");
						setActive(true);
					}
				};
				new SchoolType()
				{
					{
						setName("Yüksekokul");
						setActive(true);
					}
				};
				new SchoolType()
				{
					{
						setName("Üniversite");
						setActive(true);
					}
				};
				new SchoolType()
				{
					{
						setName("Yüksek Lisans");
						setActive(true);
					}
				};
				new SchoolType()
				{
					{
						setName("Doktora");
						setActive(true);
					}
				};
			}
		};

		return new SuccessDataResult<List<SchoolType>>(predefinedSchools,
				Messages.PredefinesSchoolsListedSucccessfully);
	}

	@Override
	public Result add(SchoolType schoolType)
	{
		this.schoolTypeDao.save(schoolType);
		return new SuccessResult(Messages.SchoolTypeAddedSuccessfully);
	}

	@Override
	public Result delete(SchoolType schoolType)
	{
		var result = this.schoolTypeDao.getById(schoolType.getId());
		result.setActive(false);
		return new SuccessResult(Messages.SchoolTypeDeletedSuccessfully);
	}

}
