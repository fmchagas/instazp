package br.com.fmchagas.intazp.domain.post.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import br.com.fmchagas.intazp.domain.post.Post;
import br.com.fmchagas.intazp.domain.post.PostRepository;
import br.com.fmchagas.intazp.domain.user.User;
import br.com.fmchagas.intazp.domain.user.UserRepository;

public class NewCommentForm {
	
	@NotNull
	private Long userId;
	
	@NotBlank
	@Size(max = 200)
	private String content;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Comment newComment(PostRepository postRepository, UserRepository userRepository, Long postId) {
		Assert.isTrue(userRepository.existsById(userId), "Você não pode fazer um comentario com usuário que não existe");
		
		User user = userRepository.findById(userId).get();
		Post post = postRepository.findById(postId).get();
		
		return new Comment(content, user, post);
	}
}
