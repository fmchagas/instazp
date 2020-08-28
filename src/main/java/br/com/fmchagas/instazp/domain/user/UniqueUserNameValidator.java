package br.com.fmchagas.instazp.domain.user;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UniqueUserNameValidator implements Validator {

	private UserRepository userRepository;

	public UniqueUserNameValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NewUserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NewUserForm form = (NewUserForm) target;
		String userName = form.getUserName();
		Optional<User> possibleUser = userRepository.findByUserName(userName);
		
		if (possibleUser.isPresent()) {
			StringBuilder sb = new StringBuilder();
			sb.append("Já existe um usuário com User Name: ")
			.append(userName)
			.append(" cadastado no sistema!");
			
			errors.rejectValue("userName", null, sb.toString());
		}
	}

}
