package br.com.fmchagas.instazp.domain.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewUserForm {
	
	@NotBlank
	@Email
	@Size(max = 255)
	private String email;
	@NotBlank
	@Size(max = 80)
	private String name;
	@NotBlank
	@Size(max = 30)
	private String userName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public User newUser() {
		return new User(email, name, userName);
	}
}
