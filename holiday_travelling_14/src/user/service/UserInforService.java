package user.service;

import java.util.List;

import user.model.UserInfor;


public interface UserInforService {
	public boolean queryExist(UserInfor u);
	public void addUser(UserInfor u);
	public boolean loginCheck(UserInfor userInfor);
	public List<String> getInform(UserInfor userInfor);
	public UserInfor getSelfInfor(UserInfor userInfor);
}
