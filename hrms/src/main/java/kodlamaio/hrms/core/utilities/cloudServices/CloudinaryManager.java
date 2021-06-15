package kodlamaio.hrms.core.utilities.cloudServices;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.secrets.cloudinary.CloudinarySecrets;

public class CloudinaryManager implements CloudImageService
{

	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", CloudinarySecrets.cloud_name,
			"api_key", CloudinarySecrets.api_key, "api_secret", CloudinarySecrets.api_secret));
}
