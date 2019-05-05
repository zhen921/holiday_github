package user.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import user.model.*;
import user.service.ReleaseService;

@Controller
@Component("release")
@Scope("prototype")
public class Plan extends ActionSupport implements ModelDriven {
	List<UserPlan> matchList;
	List<UserPlan> recomList;
	ReleaseService service;
	UserPlan userPlan;

	/*
	 * 此处是点发布计划页面进行的跳转操作，其中获得了省份列表
	 */
	@RequestMapping(value="/getProvinceName",method = RequestMethod.GET,produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Province> goReleasePage() {
		return service.getProvince();
	}

	/*
	 * 利用了ajax去获取相应省份的城市数据
	 */
	@RequestMapping(value="/getCityName",method = RequestMethod.GET,produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<City> getCity(@RequestParam String provinceCode) throws IOException {
		return service.getCity(provinceCode);
	}
	
	/*
	 * 此处往数据库里写入计划，预计匹配也会写在这部分
	 */
	@RequestMapping(value="/planRelease",method = RequestMethod.POST,produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UserPlan> releasePlan(@RequestBody UserPlan plan) throws Exception {
		// 查询是否发布的已有计划
		if (service.releasePlan(plan)) {
			 throw new  Exception("plan exist");
		} else {
			return service.getMatchPlan(plan);
		}
	}

	//作为登录后消息里推荐人的计划显示
	public String getMatchInfor() {
		//拿到的是学号的列表
		List<String> lists=new Register().getList();
		//匹配到的是这些人的计划，到前台做展示
		this.matchList = service.getRecom(lists);
		return "open_recom";
	}

	@Override
	public Object getModel() {
		return null;
	}


	public ReleaseService getService() {
		return service;
	}

	@Resource(name = "releaseServiceImpl")
	public void setService(ReleaseService service) {
		this.service = service;
	}

	public UserPlan getUserPlan() {
		return userPlan;
	}

	public void setUserPlan(UserPlan userPlan) {
		this.userPlan = userPlan;
	}

	public List<UserPlan> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<UserPlan> matchList) {
		this.matchList = matchList;
	}

}
