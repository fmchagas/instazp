package br.com.fmchagas.intazp.domain.post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdatePostForm {
	@NotBlank
	@Size(max = 500)
	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
