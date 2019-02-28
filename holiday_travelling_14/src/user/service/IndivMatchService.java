package user.service;

import java.util.List;

import user.model.UserInfor;

public interface IndivMatchService {

	public boolean checkCondition(String sno);

	public void getClusterAnaly();

	public List<UserInfor> getFriend(String sno);

}
