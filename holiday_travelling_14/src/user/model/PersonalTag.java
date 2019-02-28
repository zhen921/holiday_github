package user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personal_tag")
public class PersonalTag {
	private String sno;
	private String province ;
	private String city;
	private String view;
	private double totalperson ;
	private double totaltime;
	private double totalcost ;
	private  int companysex;
	private int selfsex;
	private int classtag;
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
	public double getTotalperson() {
		return totalperson;
	}
	public void setTotalperson(double totalperson) {
		this.totalperson = totalperson;
	}
	public double getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(double totaltime) {
		this.totaltime = totaltime;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	public int getClasstag() {
		return classtag;
	}
	public void setClasstag(int classtag) {
		this.classtag = classtag;
	}
	
}
