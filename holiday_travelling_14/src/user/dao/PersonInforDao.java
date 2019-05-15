package user.dao;



import user.model.UserInfor;

public interface PersonInforDao {

	public UserInfor getPersonalInforBySno(String parameter);

	/**
	 * @param profile
	 */
	public void saveProfileBySno(UserInfor profile);

	/**
	 * @param sno
	 */
	public void clearInformBySno(String sno);


}
