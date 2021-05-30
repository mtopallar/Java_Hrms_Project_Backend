package kodlamaio.hrms.core.utilities.verification.mernisVerification;

import kodlamaio.hrms.entities.concretes.Jobseeker;

public interface FakeMernisService
{
	boolean verify(Jobseeker jobseeker);

	// Long nationalityId, String firstName, String lastname, int yearOfBirth
}
