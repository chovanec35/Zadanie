package sk.zadanie.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sk.zadanie.dto.UserDto;
import sk.zadanie.service.UserService;
import sk.zadanie.service.impl.UtilService;

@Component
public class UserValidator implements Validator {

    @Autowired
    UtilService utilService;
    
    @Autowired
    UserService userService;

    public boolean supports(Class clazz) {
        return UserDto.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date actualDate = new Date();
        
        UserDto userDto = (UserDto) obj;
        
        
        
        Date birthDate = null;
        try {
            birthDate = utilService.convertStringToDate(userDto.getBirthdate());
        } catch (ParseException ex) {
            Logger.getLogger(UserValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            errors.rejectValue("confirmPassword", "error.passwordConfDiff");
        }

        if (actualDate.before(birthDate)) {
            errors.rejectValue("birthdate", "error.birthdate");
        }
        if (userService.emailExist(userDto)) {
            errors.rejectValue("email", "error.emailExist");
        }
    }
}
