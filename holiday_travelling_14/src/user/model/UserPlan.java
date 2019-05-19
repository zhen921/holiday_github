package user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_plan")
public class UserPlan {
	private String sno;
	private String province ;
	private  int companysex;
	private String city;
	private String view;
	private int totalperson ;
	private int totaltime;
	private int totalcost ;
	private int startdate;
	private String title ;
	private String introduce;
	private int selfsex;
	private int hot;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getCompanysex() {
		return companysex;
	}
	public void setCompanysex(int companysex) {
		this.companysex = companysex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public void setStartdate(int i) {
		this.startdate = i;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getHot() {
		return hot;
	}
	public void setHot(int hot) {
		this.hot = hot;
	}
	public int getSelfsex() {
		return selfsex;
	}
	public void setSelfsex(int selfsex) {
		this.selfsex = selfsex;
	}
	public int getTotalperson() {
		return totalperson;
	}
	public void setTotalperson(int totalperson) {
		this.totalperson = totalperson;
	}
	public int getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(int totaltime) {
		this.totaltime = totaltime;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public int getStartdate() {
		return startdate;
	}
}
