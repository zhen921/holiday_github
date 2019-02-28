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

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import user.model.*;
import user.service.ReleaseService;

@Component("release")
@Scope("prototype")
public class Plan extends ActionSupport implements ModelDriven {
	// 省列表
	List<Province> list;
	// 市列表
	List<City> cityList;
	List<UserPlan> matchList;
	List<UserPlan> recomList;
	ReleaseService service;
	UserPlan userPlan;

	/*
	 * 此处是点发布计划页面进行的跳转操作，其中获得了省份列表
	 */
	public String goReleasePage() {
		this.list = service.getProvince();
		return "release";
	}

	/*
	 * 此处往数据库里写入计划，预计匹配也会写在这部分
	 */
	public String releasePlan() {
		// 查询是否发布的已有计划
		if (service.releasePlan(userPlan)) {
			return "release_fail";
		} else {
			/*
			 * 作为推荐中的匹配一项，自是很费劲的写 在从数据库拿到匹配数据后就把计划插入进去了
			 */
			this.matchList = service.getMatchPlan(userPlan);
			if (matchList != null && matchList.size() > 0) {
				return "has_result";
			} else {
				return "no_result";
			}
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

	/*
	 * 利用了ajax去获取相应省份的城市数据
	 */
	public String getCity() throws IOException {
		HttpServletResponse resp = ServletActionContext.getResponse();
		HttpServletRequest req = ServletActionContext.getRequest();
		String code = req.getParameter("para");
		this.cityList = service.getCity(code);
		StringBuilder str = new StringBuilder();
		str.append("<select name=\"userPlan.city\">");
		// str.append("<c:forEach items=\"${cityList}\"   var=\"s\" >"+"  <option value=\"${s.code}\">${s.name}</option>   	</c:forEach>");
		for (Iterator iterator = cityList.iterator(); iterator.hasNext();) {
			City type = (City) iterator.next();
			str.append("<option value=\"" + type.getCode() + "\">"
					+ type.getName() + "</option>");
		}
		str.append("</select>");
		resp.setContentType("text/html;chatset=utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().append(str);
		return null;
	}

	
	
	@Override
	public Object getModel() {
		return null;
	}

	public List<Province> getList() {
		return list;
	}

	public void setList(List<Province> list) {
		this.list = list;
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

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<UserPlan> getMatchList() {
		return matchList;
	}

	public void setMatchList(List<UserPlan> matchList) {
		this.matchList = matchList;
	}

}
