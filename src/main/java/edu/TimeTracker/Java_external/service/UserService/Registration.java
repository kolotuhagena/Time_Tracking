package edu.TimeTracker.Java_external.service.UserService;

import edu.TimeTracker.Java_external.domain.entity.User;
import edu.TimeTracker.Java_external.repository.UserRepository;
import edu.TimeTracker.Java_external.service.ValidationService;
import edu.TimeTracker.Java_external.web.controller.controller_util.MessageUtil;
import edu.TimeTracker.Java_external.web.controller.controller_util.PageConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;

@Service
public class Registration {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    public String registration(String username, String password, String email) {
        boolean usernameOk = validationService.validUsername(username);
        boolean passwordOk = validationService.validPassword(password);
        boolean emailOk = validationService.validPassword(email);
        String page;
        if (existUsername(username) == null) {
            User user = new User();
            if (usernameOk) {
                user.setLogin(username);
            } else {
                return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            }
            // if password is valid, here password converting to hashcode
            if (passwordOk) {
                user.setPassword(""+password.hashCode());
            } else {
                return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            }
            if (emailOk) {
                user.setEmail(email);
            } else {
//                request.setAttribute("Exception",
//                        MessageUtil.getInstance().getMessageException(MessageUtil.EMAIL_EXCEPTION));
                return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            }
            user.setRole(User.Role.USER);
            userRepository.save(user);

//            request.setAttribute("createUser", true);
//            request.getSession().setAttribute("login", user.getLogin());
//            request.getSession().setAttribute("id", user.getId());
//            request.getSession().setAttribute("password", user.getPassword());
            LOGGER.info("User was created: " + username);
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);

        } else {
            LOGGER.info("Was attempt to registration with existing data");
//            request.setAttribute("Exception",
//                    MessageUtil.getInstance().getMessageException(MessageUtil.EXIST_USERNAME));
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        }
        return page;
    }

    public User existUsername(String username) {
        User user = userRepository.findByLogin(username).orElse(null);
        if (user != null) {
            LOGGER.info(username + ": is present in our DB");
        } else {
            LOGGER.info(username + ": isn't present in our DB");
        }
        return user;
    }
}
