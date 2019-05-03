package user.service;



import user.model.UserInfor;

public interface PersonInforService {

	public UserInfor getPersonalInforBySno(String parameter);

	/**
	 * @param profile
	 */
	public void saveProfileBySno(UserInfor profile);

}
