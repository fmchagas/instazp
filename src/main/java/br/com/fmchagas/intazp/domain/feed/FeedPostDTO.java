package br.com.fmchagas.intazp.domain.feed;

import br.com.fmchagas.intazp.domain.post.Post;

public class FeedPostDTO {
	private String userName;
	private String linkImageMoment;
	private String content;

	
	public FeedPostDTO(Post post) {
		userName = post.getUser().getUserName();
		linkImageMoment = post.getLinkImageMoment();
		content = post.getContent();
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getLinkImageMoment() {
		return linkImageMoment;
	}


	public void setLinkImageMoment(String linkImageMoment) {
		this.linkImageMoment = linkImageMoment;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
}
