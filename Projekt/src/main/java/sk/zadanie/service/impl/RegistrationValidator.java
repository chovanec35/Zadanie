package sk.zadanie.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sk.zadanie.dto.UserDto;
 
public class RegistrationValidator implements Validator {
 
    public boolean supports(Class clazz) {
        return UserDto.class.equals(clazz);
    }
 
    public void validate(Object obj, Errors errors) {
        UserDto userDto = (UserDto) obj;
        
        System.out.println("Validujem Password");
        
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcherFirstname = pattern.matcher(userDto.getFirstName());
        if (!matcherFirstname.matches()) {
            System.out.println("non alphanumerical");
            errors.rejectValue("badfirst", "error.badFirstname");
        }
        
        Matcher matcherLastname = pattern.matcher(userDto.getLastName());
        if (!matcherLastname.matches()) {
            errors.rejectValue("lastName", "error.badLastname");
        }
        
        if (userDto.getPassword().length() < 8) {
            errors.rejectValue("password", "error.shortPassword");
        }
       
        if (!userDto.getConfirmPassword().equals(userDto.getPassword())) {
            errors.rejectValue("password", "error.passwordConfDiff");
        }
        
    }
        
    
}

