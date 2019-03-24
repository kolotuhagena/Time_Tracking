package edu.TimeTracker.Java_external.web.command;

import edu.TimeTracker.Java_external.web.controller.controller_util.PageConfiguration;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardToSignIn implements Command {
  private static final Logger LOGGER = Logger.getLogger(ForwardToSignIn.class);

  /**
   * Method for forward on registration page
   *
   * @param request
   * @param response
   * @return page
   * @throws ServletException
   * @throws IOException
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
  }
}
