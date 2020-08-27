package br.com.fmchagas.intazp.domain.post.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.fmchagas.intazp.domain.post.Post;
import br.com.fmchagas.intazp.domain.user.User;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotBlank @Size(max = 200) String content;
	@ManyToOne
	private @NotNull User user;
	@ManyToOne
	private @NotNull Post post;

	public Comment(@NotBlank @Size(max = 200) String content, @NotNull User user, @NotNull Post post) {
		this.content = content;
		this.user = user;
		this.post = post;
	}

}
