package user.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import user.dto.UserInforDTO;
import user.model.UserInfor;
import user.service.UserInforService;

@Controller
@Component("login")
@Scope("prototype")
public class Register {
	UserInfor userInfor;
	UserInforService service;
	
	//用于存放通知
	static List<String> list=new ArrayList<String >();
	
	//用户注册
	@RequestMapping(value="/register",method = RequestMethod.POST,consumes = "application/json",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void register(@RequestBody UserInfor user) throws Exception {
		if (service.queryExist(user)) {
			throw new Exception("The sno already in use!");
		} else {
			service.addUser(user);
		}
	}

	// 用于验证登录信息
	@RequestMapping(value="/login",method = RequestMethod.POST,consumes = "application/json",produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserInforDTO loginCheck(@RequestBody UserInfor user) {
		return service.loginCheck(user);
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

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
