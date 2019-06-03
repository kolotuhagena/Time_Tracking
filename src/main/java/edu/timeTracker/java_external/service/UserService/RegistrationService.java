package edu.timeTracker.java_external.service.UserService;

import edu.timeTracker.java_external.domain.entity.User;
import edu.timeTracker.java_external.repository.UserRepository;
import edu.timeTracker.java_external.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class RegistrationService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    public boolean registration(User user, Map<String, Object> model) {
        Optional<User> userFromDb = userRepository.findByLogin(user.getUsername());
        if (!userFromDb.isPresent()) {
            boolean usernameOk = validationService.validUsername(user.getUsername());
            boolean passwordOk = validationService.validPassword(user.getPassword());
            boolean emailOk = validationService.validEmail(user.getEmail());
            if (usernameOk) {
                if (passwordOk) {
                    if (emailOk) {
                        user.setRole(User.Role.USER);
                        return true;
                    } else {
                        model.put("error", "type of email doesn't maintaining");
                    }
                } else {
                    model.put("error", "type of password doesn't maintaining");
                }
            } else {
                model.put("error", "type of username doesn't maintaining");
            }

        } else {
            model.put("error", "Was attempt to registration with existing data");
            LOGGER.info(user.getUsername() + "Was attempt to registration with existing data");
        }
        return false;
    }
}
