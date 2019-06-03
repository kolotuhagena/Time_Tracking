package edu.timeTracker.java_external.web.command;

import edu.timeTracker.java_external.web.controller.controller_util.PageConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand implements Command {
  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

  /**
   * Method for logout
   *
   * @param request
   * @param response
   * @return page
   * @throws ServletException
   * @throws IOException
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    int id =(int) session.getAttribute("id");
    session.invalidate();
    LOGGER.info("Was destroyed session with user id: " + id);
    return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.HOME_PAGE);
  }
}
