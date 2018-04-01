package sk.zadanie.service.impl;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sk.zadanie.dto.UserDto;
 
public class PasswordValidator implements Validator {
 
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
        System.out.println("Validujem Password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
    }
}

