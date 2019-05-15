package user.dto;

import org.springframework.stereotype.Component;

@Component
public class UserInforDTO {
	private String sno;
	private String role;
	private  int sex;
	private int inform;

	public int getInform() {
		return inform;
	}
	public void setInform(int inform) {
		this.inform = inform;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
}
