package br.com.fmchagas.instazp.domain.user;

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
		String email = form.getEmail();
		Optional<User> possibleUser = userRepository.findByEmail(email);
		
		if (possibleUser.isPresent()) {
			StringBuilder sb = new StringBuilder();
			sb.append("Já existe um usuário com e-mail: ")
			.append(email)
			.append(" cadastado no sistema!");
			
			errors.rejectValue("email", null, sb.toString());
		}
	}

}
