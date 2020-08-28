package br.com.fmchagas.instazp.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotBlank @Email @Size(max = 255) String email;
	private @NotBlank @Size(max = 80) String name;
	@NotBlank
	@Size(max = 30)
	private String userName;
	
	@Deprecated
	public User() {
	}

	public User(@NotBlank @Email @Size(max = 255) String email, @NotBlank @Size(max = 80) String name, @NotBlank @Size(max = 30) String userName) {
		this.email = email;
		this.name = name;
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getUserName() {
		return userName;
	}
}
