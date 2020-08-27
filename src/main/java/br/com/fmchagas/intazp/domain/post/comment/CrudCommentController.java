package br.com.fmchagas.intazp.domain.post.comment;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fmchagas.intazp.domain.post.PostRepository;
import br.com.fmchagas.intazp.domain.user.UserRepository;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CrudCommentController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> create(@PathVariable Long postId, @Validated NewCommentForm form) {
		if (!postRepository.existsById(postId)) {
			return ResponseEntity.notFound().build();
		}
		
		Comment newComment = form.newComment(postRepository, userRepository, postId);
		
		commentRepository.save(newComment);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
