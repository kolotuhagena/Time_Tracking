package edu.TimeTracker.Java_external.web.command;

import edu.TimeTracker.Java_external.service.UserService.Registration;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {
  private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);
  private static final String EMAIL = "regEmail";
  private static final String USERNAME = "regUsername";
  private static final String PASSWORD = "regPassword";


  /**
   * Method for registration (button submit)
   *
   * @param request
   * @param response
   * @return page
   * @throws ServletException
   * @throws IOException
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter(USERNAME);
    String password = request.getParameter(PASSWORD);
    String email = request.getParameter(EMAIL);
    LOGGER.info("Was successful registration on page");
    return Registration.getInstance().registration(request, username, password, email);
  }
}
