package user.hibernate.util;

import user.model.UserInfor;

public class SqlSet {
	static UserInfor userInfor;
    public static final String checkLoginUser="from UserInfor u where u.sno = '" + userInfor.getSno() + "' "+"and u.pwd='"+ userInfor.getPwd()+"'";
}
