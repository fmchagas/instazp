package br.com.fmchagas.intazp.domain.feed;

import br.com.fmchagas.intazp.domain.post.Post;

public class FeedPostDTO {
	private String name;
	private String linkImageMoment;
	private String content;

	
	public FeedPostDTO(Post post) {
		name = post.getUser().getName();
		linkImageMoment = post.getLinkImageMoment();
		content = post.getContent();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
