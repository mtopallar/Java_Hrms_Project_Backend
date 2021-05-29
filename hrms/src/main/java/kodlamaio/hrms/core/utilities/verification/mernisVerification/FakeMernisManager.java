package kodlamaio.hrms.core.utilities.verification.mernisVerification;

import java.util.Random;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Jobseeker;

@Service
public class FakeMernisManager implements FakeMernisService
{
	// Buraya Mernis servis çağırılır ve jobseeker içindeki bilgilere göre gerçek
	// mernis doğrulaması yapılır.
	@Override
	public boolean verify(Jobseeker jobseeker)
	{
		Random random = new Random();
		var chance = random.nextBoolean();

		if (chance)
		{
			return true;
		}
		return false;
	}

}
