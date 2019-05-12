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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import user.dto.UserInforDTO;
import user.logiccompute.SendInformEmail;
import user.model.UserInfor;
import user.model.UserPlan;
import user.service.UserInforService;

@Controller
@Component("login")
@Scope("prototype")
public class Register {
	UserInforService service;
	SendInformEmail sendEmail=new SendInformEmail();
	
	
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

	 // 如果有发布计划则获取匹配列表
	@RequestMapping(value="/getEmailVerificationCode",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void getEmailVerificationCode(@RequestParam(value="tempVerificationCode") String tempVerificationCode,@RequestParam(value="email") String email) throws Exception {
		sendEmail.sendEmai(email, true, tempVerificationCode);
	}
	

	public UserInforService getService() {
		return service;
	}
	@Resource(name = "userInforImpl")
	public void setService(UserInforService service) {
		this.service = service;
	}


}
