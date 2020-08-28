package br.com.fmchagas.instazp.domain.user;

public class UserProfileDTO {

	private String email;
	private String name;

	public UserProfileDTO(User user) {
		email = user.getEmail();
		name = user.getName();
	}

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
}
