package edu.time_tracker.java_external.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    private static final String TIME_PATTERN = "^(2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static final String USERNAME_PATTERN = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{0,19}$";



    /**
     * Validate password with regular expression
     *
     * @param password for validation
     * @return true valid password, false invalid password
     */
    public boolean validPassword(String password) {
        boolean validationPassword;
        if (validationPassword = password.matches(PASSWORD_PATTERN)) {
            LOGGER.info("Password successful passed the validation");
        } else {
            LOGGER.info("Password wasn't passed the validation");
        }
        return validationPassword;
    }

    /**
     * Validate email with regular expression
     *
     * @param email for validation
     * @return true valid email, false invalid email
     */
    public boolean validEmail(String email) {
        boolean validationEmail;
        if (validationEmail = email.matches(EMAIL_PATTERN)) {
            LOGGER.info("Email successful passed the validation");
        } else {
            LOGGER.info("Email wasn't passed the validation");
        }
        return validationEmail;
    }

    /**
     * Validate username with regular expression
     *
     * @param username username for validation
     * @return true valid username, false invalid username
     */
    public boolean validUsername(String username) {
        boolean validationUsername;
        if (validationUsername = username.matches(USERNAME_PATTERN)) {
            LOGGER.info("Username successful passed the validation");
        } else {
            LOGGER.info("Username wasn't passed the validation");
        }
        return validationUsername;
    }

    public boolean validTime(String time){
        if(time.matches(TIME_PATTERN)){
            LOGGER.info("Time successful passed the validation");
            return true;
        }else return false;
    }
}
