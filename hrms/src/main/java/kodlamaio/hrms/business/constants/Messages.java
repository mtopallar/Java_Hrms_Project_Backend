package kodlamaio.hrms.business.constants;

public class Messages
{
	// Jobseeker
	public static String allJobseekersListedSuccessfully = "Tüm iş arayanlar başarıyla listelendi.";
	public static String verifyError = "Kimlik doğrulama hatalı";
	public static String passwordMatchError = "Parola ile parola tekrarı eşleşmemektedir.";
	public static String jobSeekerSavedSuccessFully = "Kullanıcı kaydı (jobseeker) başarılı";
	public static String identityNumberUsedBefore = "Kimlik numaranız ile daha önce kayıt işlemi gerçekleştirmişsiniz.";

	// User
	public static String getUserByMailSuccessfully = "Mail'e göre kullanıcı başarıyla getirildi.";
	public static String getUserByIdSuccessfully = "Id numarasına göre kullanıcı başarıyla getirildi.";
	public static String getAllUserSuccessfully = "Tüm kullanıcılar başarıyla listelendi.";
	public static String getByIsMailActivatedAndIsActive = "Mail aktivasyonu ve aktiflik durumuna göre kullanıcılar başarıyla listelendi.";
	public static String getAllActiveUsersSuccessfully = "Tüm aktif kullanıcılar başarıyla listelendi.";
	public static String getAllNoMailActivatedActiveUsers = "Mail aktivasyonu tamamlanmamış tüm aktif kullanıcılar listelendi.";
	public static String getAllDeactiveUsersSuccessfully = "Aktif olmayan tüm kullanıcılar listelendi.";
	public static String userSavedSuccessfully = "Kullanıcı başarıyla kaydedildi.";
	public static String userUpdatedSuccessfully = "Kullanıcı başarıyla güncellendi.";
	public static String userDeletedSuccessfully = "Kullanıcı başarıyla silindi.";
	public static String mailAdressUsedBefore = "Bu mail adresi daha önce kullanılmış";
	public static String toComleteRegistrationActivateMail = "Kayıt işlemini tamamlayabilmeniz için mail doğrulaması yapmanız gereklidir.";

	// Taskmaster

	public static String getAllActiveTaskmastersSuccessfully = "Tüm aktif işverenler başarıyla listelendi.";
	public static String getAllNotActivatebDyEmployeeFromAllActiveTaskmastersSuccessfully = "Aktif işverenler arasında henüz personel onayı yapılmamış olanlar başarıyla listelendi.";
	public static String getAllActiveAndActivatedByEmployeeTaskmastersSuccessfully = "Tüm aktif ve onaylanmış işverenler başarıyla listelendi.";
	public static String emailDomainVerificationError = "Şirket mailiniz şirket web sitesi adresinizle aynı domaine sahip olmalıdır.";
	public static String taskmasterAddedSuccessfully = "Kullanıcı kaydı (taskmaster) başarılı";
	public static String taskmasterActivatedByEmployeeSuccessfully = "İşveren kaydı HRMS personeli tarafından başarıyla onaylanmıştır.";
	public static String taskMasterDeletedSuccessfully = "Kullanıcı kaydı (taskmaster) başarıyla silinmiştir.";

	// Employee

	public static String getAllEmployeeSuccessfully = "Tüm iş arayanlar başarıyla listelendi.";
	// Job Positions

	public static String getAllActivePositions = "Tüm ilanlar başarıyla listelenmiştir.";
	public static String positionAddedSuccessfully = "İlan başarıyla eklendi.";

	// Fake Mail Activator

	public static String mailActivatedSuccessfully = "Mail aktivasyonu başarıyla tamamlanmıştır.";

	// Cities

	public static String getAllCitiesSuccessfully = "Tüm şehirler başarıyla listelendi.";
	public static String cityAddedSuccessfully = "Şehir başarıyla eklendi.";
	public static String getAllActiveCitiesSuccessfully = "Tüm aktif şehirler başarıyla listelendi.";

	// JobAdvert

	public static String getAllActiveInDtoFormatSuccessfully = "Tüm aktif ilanlar formatlı biçimde getirildi.";
	public static String getAllActiveJobAdvertsByDeadlineDateAscSuccessfully = "Aktif ilanların tamamı son başvuru tarihine göre ters sıralamalı olarak başarıyla listelendi.";
	public static String getAllJobAdvertsByTaskmasterIdSuccessfully = "Aktif ilanlar firmaya göre başarıyla listelendi.";
	public static String jobAdvertAddedSuccessfully = "İş ilanı başarıyla kaydedildi.";
	public static String jobAdvertDeletedSuccessfully = "İş ilanı başarıyla silnmiştir.";

	// Universities

	public static String ActiveUniversityNotFound = "Sistemde kayıtlı aktif üniversite mevcut değildir.";
	public static String GetAllActiveUniversitiesSuccessfully = "Sistemde kayıtlı tüm aktif üniversiteler başarıyla listelenmiştir.";
	public static String GetUniversityByIdNotFound = "Belirtilen üniversite bulunamadı.";
	public static String GetUniversityByIdSuccessfully = "Üniversite detayları başarıyla getirildi.";
	public static String UniversityAddedSucccessfully = "Üniversite başarıyla kaydedildi.";
	public static String UniversityUpdatedSuccessfully = "Üniversite başarıyla güncellendi.";
	public static String UniversityDeletedSucccessfully = "Üniversite başarıyla silindi.";

	// Departments

	public static String ActiveDepartmentNotFound = "Sistemde kayıtlı aktif bölüm mevcut değildir.";
	public static String AllActiveDepartmentsListedSuccessfully = "Tüm aktif bölümler başarıyla listelenmiştir";
	public static String DepartmentByIdNotFound = "Belirtilen bölüm bulunamadı.";
	public static String GetDepartmentByIdSuccessfully = "Bölüm detayları başarıyla getirildi.";
	public static String DepartmentAddedSuccessfully = "Bölüm başarıyla kaydedildi.";
	public static String DepartmentUpdatedSuccessfully = "Bölüm başarıyla güncellenmiştir.";
	public static String DepartmentDeletedSuccessfully = "Bölüm başarıyla silinmiştir.";

	// School Types

	public static String PredefinesSchoolsListedSucccessfully = "Öntanımlı okullar başarıyla listelendi.";
	public static String ActiveSchoolTypeNotFound = "Sistemde kayıtlı aktif okul türü bulunmamaktadır.";
	public static String GetAllActiveSchoolsSucccessfully = "Tüm aktif okul türleri başarıyla listelenmiştir.";
	public static String SchoolTypeNotFound = "Belirtilen okul türü bbulunamadı.";
	public static String GetSchoolTypeByIdSuccessfully = "Okul türü detayları başarıyla getirildi.";
	public static String SchoolTypeAddedSuccessfully = "Okul türü bbaşarıyla kaydedildi.";
	public static String SchoolTypeDeletedSuccessfully = "Okul türü başarrıyla silinmiştir.";

	// Primary School

	public static String NoActivePrimarySchoolFoundForThisUser = "Sisteme kayıtlı ilkokulunuz bulunmamaktadır.";
	public static String GetUsersPrimarySchoolSuccessfully = "İlkokul bilginiz başarıyla getirilmiştir.";
	public static String NoActivePrimarySchoolFound = "Sistemde kayıtlı aktif herhangi bir ilkokul bulunmamaktadır.";
	public static String GetAllActivePrimarySchoolsSuccessfully = "Sistemde kayıtlı tüm aktif ilkokullar başarıyla listelendi.";
	public static String PrimarySchoolAddedSuccessfully = "İlkokul başarıyla kaydedildi.";
	public static String PrimarySchoolUpdatedSuccessfully = "İlkokul başarıyla güncellendi.";
	public static String PrimarySchoolDeletedSuccessfully = "İlkokul başarıyla silindi.";
	
	// High School
	
	public static String NoActiveHighSchoolFound = "Sistemde kayıtlı aktif lise bilginiz bulunmamaktadır.";
	public static String getActiveByJobseekerIdSuccessfully = "Sistemde kayıtlı lise bilginiz başarıyla getirilmiştir.";
	public static String GetAllActivesError = "Sistemde kayıtlı aktif lise bulunmamaktadır.";
	public static String getAllActivesSuccessfully = "Sistemdeki tüm aktif liseler başarıyla listelendi.";
	public static String HighSchoolAddedSuccessfully = "Lise başarıyla kaydedildi.";
	public static String JobseekerHighSchoolUpdatedSuccessfully = "Lise bilginiz başarıyla güncellendi.";
	public static String JobseekerHighSchoolDeletedSuccessfully = "Lise bilgisi başarıyla silindi.";
	
	// Higher Education Manager
	
	public static String GetActiveByJobseekerIdError = "Sistemde kayıtlı yüksek öğrenim bilginiz bulunmamaktadır." ;
	public static String GetActiveByJobseekerIdSuccessfully = "Sistemde kayıtlı olan tüm yüksek öğrenim bilgileriniz başarıyla listelendi.";
	public static String GetAllActiveHigherEducationsError = "Sistemde kayıtlı aktif yüksek öğrenim bilgisi mevcut değildir.";
	public static String GetAllActiveHigherEducationsSuccessfully = "Sistemdeki tüm kayıtlı yüksek öğrenim kayıtları başarıyla listelenmiştir.";
	public static String JobseekerHigherEducationSacedSuccessfully = "Yüksek öğrenim bilgisi başarıyla kaydedildi.";
	public static String JobseekerHigherEducationUpdatedSuccessfully = "Yüksek öğrenim bilgisi başarıyla güncellenmiştir.";
	public static String JobseekerHigherEducationDeletedSuccessfully = "Yüksek öğrenim bilgisi başarıyla silinmiştir.";
	public static String GetAllHigherEducationsSortedSuccessfully = "Sistemdeki tüm yüksek öğrenim bilgileriniz başarıyla listelenmişitr.";

}
