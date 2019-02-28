package user.dao;

import user.model.UserInfor;

public interface UserInforDao {
	public void addUser(UserInfor u);
	public boolean queryExist(UserInfor u);
	public boolean loginCheck(UserInfor userInfor);
	public String getInform(UserInfor userInfor);
	public UserInfor getSelfInfor(UserInfor userInfor);
}
