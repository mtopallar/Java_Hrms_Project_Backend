package kodlamaio.hrms.core.utilities.cloudServices;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.secrets.cloudinary.CloudinarySecrets;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

public class CloudinaryManager implements CloudImageService
{

	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", CloudinarySecrets.cloud_name,
			"api_key", CloudinarySecrets.api_key, "api_secret", CloudinarySecrets.api_secret));

	@SuppressWarnings("rawtypes")
	public DataResult<String> uploadImage(File image) throws IOException
	{
		// map a kadarki kısım gerekmeyebilir.

		cloudinary.url().transformation(new Transformation().gravity("face").height(200).width(200)
				.crop("thumb").chain().border("5px_solid_black").radius(20).chain());

		Map uploadResult = cloudinary.uploader().upload(image, ObjectUtils.emptyMap());
		if (uploadResult == null)
		{
			return new ErrorDataResult<String>(null, "Yükleme hatası");
		}
		return new SuccessDataResult<String>(uploadResult.get("url").toString(), "Yükleme başarılı");
	}

}
