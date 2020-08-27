package br.com.fmchagas.intazp.domain.post;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmchagas.intazp.domain.user.User;
import br.com.fmchagas.intazp.domain.user.UserRepository;

@RestController
@RequestMapping("/api/posts")
public class CrudPostController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LocalUploader uploader;
	@Autowired
	private PostRepository postRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public void create(@Validated NewPostForm form) {
		Post newPost = form.newPost(userRepository, uploader);
		postRepository.save(newPost);
	}

	@PutMapping("/{postId}")
	@Transactional
	public void update(@Validated @PathVariable Long postId, UpdatePostForm form) {

		Post post = postRepository.findById(postId).get();

		User user = userRepository.findById(post.getId()).get();
		Post updatePost = new Post(form.getContent(), user, post.getLinkImageMoment());
		updatePost.setId(postId);

		postRepository.save(updatePost);
	}

}
