package br.com.fmchagas.instazp.domain.user;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class CrudUserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@InitBinder("newUserForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new UniqueEmailValidator(userRepository), new UniqueUserNameValidator(userRepository));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public void create(@Validated @RequestBody NewUserForm form) {
		User newUser = form.newUser();
		
		userRepository.save(newUser);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<UserProfileDTO> profile(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(new UserProfileDTO(user.get()));
		}
		
		return ResponseEntity.notFound().build();
	}


}
