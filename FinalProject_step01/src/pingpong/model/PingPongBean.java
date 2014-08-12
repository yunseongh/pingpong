package pingpong.model;

import java.io.Serializable;

public class PingPongBean implements Serializable{
	private String Email;
	private String Name;
	private String Password;
	private String School;
	private String Major;
	
	public PingPongBean(String email, String name, String password, String school, String major) {
		super();
		Email = email;
		Name = name;
		Password = password;
		School = school;
		Major = major;
	}
	
	public PingPongBean(String email, String name, String password) {
		Email = email;
		Name = name;
		Password = password;
	}
	
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getSchool() {
		return School;
	}

	public void setSchool(String school) {
		School = school;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	@Override
	public String toString() {
		return "PingPongBean [Email=" + Email + ", Name=" + Name
				+ ", Password=" + Password + ", School=" + School + ", Major="
				+ Major + "]";
	}
	
}
