package user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="history_plan")
public class HistoryPlan {
	private int id;
	private String sno;
	private String province ;
	private String city;
	private String view;
	private int totalperson ;
	private int totaltime;
	private int totalcost ;
	private  int companysex;
	private int selfsex;
	
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
	public int getCompanysex() {
		return companysex;
	}
	public void setCompanysex(int companysex) {
		this.companysex = companysex;
	}
	public int getSelfsex() {
		return selfsex;
	}
	public void setSelfsex(int selfsex) {
		this.selfsex = selfsex;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
