//package edu.timeTracker.java_external.web.command;
//
//import edu.timeTracker.java_external.service.UserService.Registration;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class RegistrationCommand implements Command {
//  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//  private static final String EMAIL = "regEmail";
//  private static final String USERNAME = "regUsername";
//  private static final String PASSWORD = "regPassword";
//
//
//  /**
//   * Method for registration (button submit)
//   *
//   * @param request
//   * @param response
//   * @return page
//   * @throws ServletException
//   * @throws IOException
//   */
//  @Override
//  public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    String username = request.getParameter(USERNAME);
//    String password = request.getParameter(PASSWORD);
//    String email = request.getParameter(EMAIL);
//    LOGGER.info("Was successful registration on page");
//    return Registration.getInstance().registration(request, username, password, email);
//  }
//}
