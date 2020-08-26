package br.com.fmchagas.intazp.domain.user;

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
	public User newUser() {
		return new User(email, name);
	}
}
