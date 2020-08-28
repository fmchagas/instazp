package br.com.fmchagas.instazp.domain.post;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

	@Override
	Collection<Post> findAll();
}
