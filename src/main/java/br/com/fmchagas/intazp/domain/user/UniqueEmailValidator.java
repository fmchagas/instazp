package br.com.fmchagas.intazp.domain.user;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueEmailValidator implements Validator {

	private UserRepository userRepository;

	public UniqueEmailValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NewUserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NewUserForm form = (NewUserForm) target;
		Optional<User> possibleUser = userRepository.findByEmail(form.getEmail());
		
		if (possibleUser.isPresent()) {
			errors.rejectValue("email", null, "Já existe um usuário com esse e-mail!");
		}
	}

}
