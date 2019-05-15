package user.action;


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


import user.model.UserInfor;

import user.service.PersonInforService;

@Controller
@Component
@Scope("prototype")
public class Personal{
	private PersonInforService service;

	
	@RequestMapping(value="/clearInform",method = RequestMethod.PUT,produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public  void clearInformBySno(@RequestParam String sno){
			service.clearInformBySno(sno);
	}
	/**
	 * @author yuwei wang
	 * @param sno
	 * @return profile json
	 * @description get profile data by sno
	 */	
	@RequestMapping(value="/getProfileBySno",method = RequestMethod.GET,produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public  UserInfor getPersonInfor(@RequestParam String sno){
		UserInfor user=service.getPersonalInforBySno(sno);
		return user;
	}
	
	/**
	 * @author yuwei wang
	 * @param profile data
	 * @return null
	 * @description update profile data
	 */	
	@RequestMapping(value="/saveProfileBySno",method = RequestMethod.PUT,produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void saveProfileBySno(@RequestBody UserInfor profile){
		service.saveProfileBySno(profile);
	}
	
	public PersonInforService getService() {
		return service;
	}
	@Resource(name="personInforServiceImpl")
	public void setService(PersonInforService service) {
		this.service = service;
	}
}
