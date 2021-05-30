package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService
{
	private CityDao cityDao;

	public CityManager(CityDao cityDao)
	{
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll()
	{
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), Messages.getAllCitiesSuccessfully);
	}

	@Override
	public Result add(City city)
	{
		var addedBefore = this.isCityAddedBefore(city.getName());
		if (!addedBefore.isSuccess())
		{
			return addedBefore;
		}
		city.setActive(true);
		this.cityDao.save(city);
		return new SuccessResult(Messages.cityAddedSuccessfully);
	}

	private Result isCityAddedBefore(String cityName)
	{
		var result = this.cityDao.getByName(cityName);
		if (result != null)
		{
			return new ErrorResult("Şehir daha ömnce eklenmiş");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<City>> getAllActives()
	{
		return new SuccessDataResult<List<City>>(this.cityDao.getByIsActive(true),
				Messages.getAllActiveCitiesSuccessfully);
	}

}
