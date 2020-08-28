package br.com.fmchagas.instazp.domain.post;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import br.com.fmchagas.instazp.domain.post.comment.Comment;
import br.com.fmchagas.instazp.domain.user.User;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private @NotBlank @Size(max = 500) String content;
	private @NotBlank @URL String linkImageMoment;
	@ManyToOne
	private @NotNull User user;
	@OneToMany(mappedBy = "post")
	private List<Comment> comments = new ArrayList<>();
	@Deprecated
	public Post() {
	}

	public Post(@NotBlank @Size(max = 500) String content, @NotNull User user, @NotBlank @URL String linkImageMoment) {
		this.content = content;
		this.user = user;
		this.linkImageMoment = linkImageMoment;
	}

	@Override
	public String toString() {
		return "Post [content=" + content + ", user=" + user + ", linkImageMoment=" + linkImageMoment + "]";
	}
	
	public Long getId() {
		return Id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLinkImageMoment() {
		return linkImageMoment;
	}
	public User getUser() {
		return user;
	}
	public List<Comment> getComments() {
		return comments;
	}
}
