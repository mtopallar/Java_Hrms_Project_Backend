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
}
