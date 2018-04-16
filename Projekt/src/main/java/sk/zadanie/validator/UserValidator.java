package sk.zadanie.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sk.zadanie.dto.UserDto;
import sk.zadanie.entity.User;

@Component
public class UserValidator implements Validator {

    public boolean supports(Class clazz) {
        return UserDto.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        UserDto userDto = (UserDto) obj;
        System.out.println("Erroors:"+ errors.hasErrors());
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcherFirstname = pattern.matcher(userDto.getFirstName());
        if (!matcherFirstname.matches()) {
            errors.rejectValue("firstName", "error.badFirstname");
        }
        Matcher matcherLastname = pattern.matcher(userDto.getLastName());
        if (!matcherLastname.matches()) {
            errors.rejectValue("lastName", "error.badLastname");
        }

        if (userDto.getPassword().length() < 8) {
            errors.rejectValue("password", "error.shortPassword");
        }

        String regexValidatePass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        pattern = Pattern.compile(regexValidatePass);
        Matcher matcherPassword = pattern.matcher(userDto.getPassword());
        if (!matcherPassword.matches()) {
            errors.rejectValue("password", "error.validPassword");
        }

        if (!userDto.getConfirmPassword().equals(userDto.getPassword())) {
            errors.rejectValue("password", "error.passwordConfDiff");
        }
    }
}
