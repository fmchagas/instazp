package br.com.fmchagas.instazp.domain.feed;

import java.util.List;

import br.com.fmchagas.instazp.domain.post.Post;
import br.com.fmchagas.instazp.domain.post.comment.Comment;

public class FeedPostDTO {
	private String userName;
	private String linkImageMoment;
	private String content;
	private List<Comment> comments;

	
	public FeedPostDTO(Post post) {
		userName = post.getUser().getUserName();
		linkImageMoment = post.getLinkImageMoment();
		content = post.getContent();
		comments = post.getComments();
	}


	public String getUserName() {
		return userName;
	}
	public String getLinkImageMoment() {
		return linkImageMoment;
	}
	public String getContent() {
		return content;
	}
	public List<Comment> getComments() {
		return comments;
	}
}
