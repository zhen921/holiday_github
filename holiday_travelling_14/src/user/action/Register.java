package user.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import user.model.UserInfor;
import user.service.UserInforService;

@Component("login")
@Scope("prototype")
public class Register extends ActionSupport implements ModelDriven {
	/*
	 * 用于存放学号，作为旅游计划的主键
	 */
	static String snoid;
	UserInfor userInfor = new UserInfor();
	UserInfor user;
	UserInforService service;
	//用于存放通知
	static List<String> list=new ArrayList<String >();
	public String register() {
		if (service.queryExist(userInfor)) {
			return "registerfail";
		} else {
			service.addUser(userInfor);
			return "registersuccess";
		}
	}

	// 用于验证登录信息
	public String loginCheck() {
		/*
		 * 用用户实体封装登录信息，也可能封装的是管理员信息
		 */
		if (userInfor.getSex() == 1) {
			if (service.loginCheck(userInfor)) {
				//此处获得学号，是后期在别的操作中要用到
				snoid=userInfor.getSno();
				//此处获取相匹配人的学号
				this.list=service.getInform(userInfor);
				//此处获得个人信息，用于主页面显示
				this.userInfor=service.getSelfInfor(userInfor);
				return "loginsuccess";
			} else {
				return "loginfail";
			}
		} else {
	  		if (service.loginCheck(userInfor)) {
				return "adminloginok";
			} else {
				return "loginfail";
			}
		}

	}

	// 跳转到主页页面
	public String goRegister() {
		return "goregister";
	}

	// 实现modeldriven用于action传值
	@Override
	public Object getModel() {
		return userInfor;
	}

	public UserInfor getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(UserInfor userInfor) {
		this.userInfor = userInfor;
	}

	public UserInforService getService() {
		return service;
	}

	@Resource(name = "userInforImpl")
	public void setService(UserInforService service) {
		this.service = service;
	}

	public static String getSnoid() {
		return snoid;
	}

	public static void setSnoid(String snoid) {
		Register.snoid = snoid;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public UserInfor getUser() {
		return user;
	}

	public void setUser(UserInfor user) {
		this.user = user;
	}
}
