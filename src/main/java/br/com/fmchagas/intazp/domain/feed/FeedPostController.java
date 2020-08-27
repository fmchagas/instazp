package br.com.fmchagas.intazp.domain.feed;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmchagas.intazp.domain.post.PostRepository;

@RestController
@RequestMapping("/api/feed")
public class FeedPostController {
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public Collection<FeedPostDTO> feed() {
		return postRepository.findAll().stream()
				.map(FeedPostDTO :: new)
				.collect(Collectors.toList());
	}
}
