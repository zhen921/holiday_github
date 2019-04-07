package user.service;

import java.util.List;

import user.dto.UserInforDTO;
import user.model.UserInfor;


public interface UserInforService {
	public boolean queryExist(UserInfor u);
	public void addUser(UserInfor u);
	public UserInforDTO loginCheck(UserInfor userInfor);
	public UserInfor getSelfInfor(UserInfor userInfor);
}
