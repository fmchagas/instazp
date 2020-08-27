package br.com.fmchagas.intazp.domain.post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import br.com.fmchagas.intazp.domain.user.User;
import br.com.fmchagas.intazp.domain.user.UserRepository;

public class NewPostForm {
	@NotBlank
	@Size(max = 500)
	private String content;
	@NotNull
	private MultipartFile imageMoment;
	@NotNull 
	private Long userId;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getImageMoment() {
		return imageMoment;
	}
	public void setImageMoment(MultipartFile imageMoment) {
		this.imageMoment = imageMoment;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Post newPost(UserRepository userRepository, LocalUploader uploader) {
		User user = userRepository.findById(userId).get();
		String linkImageMoment = uploader.upload(imageMoment);
		return new Post(content, user, linkImageMoment);
	}
}
