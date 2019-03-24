package edu.TimeTracker.Java_external.service.UserService;

import edu.TimeTracker.Java_external.persistence.DAO.Factory.Factory;
import edu.TimeTracker.Java_external.persistence.DAO.UserDao;
import edu.TimeTracker.Java_external.persistence.entity.User;
import edu.TimeTracker.Java_external.service.Validation;
import edu.TimeTracker.Java_external.web.controller.controller_util.MessageUtil;
import edu.TimeTracker.Java_external.web.controller.controller_util.PageConfiguration;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Registration extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Registration.class);
    private static Registration INSTANCE;
    private  final UserDao userDao = new Factory().getUserDao();
/**
     * Singleton
     *
     * @return INSTANCE
     */

    public static Registration getInstance() {
        if (INSTANCE == null) {
            synchronized (Registration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Registration();
                }
            }
        }
        return INSTANCE;
    }

/**
 * Method for registration
 *
 * @param request
 * @param username
 * @param password
 * @param email
 * @return page
 */


public String registration(HttpServletRequest request, String username, String password, String email) {
    boolean usernameOk = Validation.getInstance().validUsername(username);
    boolean passwordOk = Validation.getInstance().validPassword(password);
    boolean emailOk = Validation.getInstance().validEmail(email);
    String page;
    if (existUsername(username) == null) {
        User user = new User();
        if (usernameOk) {
            user.setLogin(username);
        } else {
            request.setAttribute("usernameBoolean", true);
            request.setAttribute("usernameException",
                    MessageUtil.getInstance().getMessageException(MessageUtil.USERNAME_EXCEPTION));
            return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        }
        // if password is valid, here password converting to hashcode
        if (passwordOk) {
            user.setPassword(password.hashCode());
        } else {
            request.setAttribute("passwordBoolean", true);
            request.setAttribute("passwordException",
                    MessageUtil.getInstance().getMessageException(MessageUtil.PASSWORD_EXCEPTION));
            return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        }
        if (emailOk) {
                user.setEmail(email);
        } else {
            request.setAttribute("emailValid", false);
            request.setAttribute("emailException",
                    MessageUtil.getInstance().getMessageException(MessageUtil.EMAIL_EXCEPTION));
            return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        }
        user.setRole(User.Role.USER);
        userDao.create(user);

        request.setAttribute("createUser", true);
        request.getSession().setAttribute("user", user);
        LOGGER.info("User was created: " + username);
        page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);

    } else {
        LOGGER.info("Was attempt to registration with existing data");
        request.setAttribute("existUsername", true);
        request.setAttribute("existUsernameMessage",
                MessageUtil.getInstance().getMessageException(
                        MessageUtil.EXIST_USERNAME));
        page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
    }
    return page;
}

    public User existUsername(String username) {
        User user = userDao.getByName(username);
        if (user != null) {
            LOGGER.info(username + ": is present in our DB");
        } else {
            LOGGER.info(username + ": isn't present in our DB");
        }
        return user;
    }
}
