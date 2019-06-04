package edu.time_tracker.java_external.service.user_service;

import edu.time_tracker.java_external.domain.entity.User;
import edu.time_tracker.java_external.repository.UserRepository;
import edu.time_tracker.java_external.service.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class RegistrationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;

    private final ValidationService validationService;

    public RegistrationService(UserRepository userRepository, ValidationService validationService) {
        this.userRepository = userRepository;
        this.validationService = validationService;
    }

    public boolean registration(User user, Map<String, Object> model) {
        Optional<User> userFromDb = userRepository.findByUsername(user.getUsername());
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
            logger.info(user.getUsername() + "Was attempt to registration with existing data");
        }
        return false;
    }
}
