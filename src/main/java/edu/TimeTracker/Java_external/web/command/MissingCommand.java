package edu.TimeTracker.Java_external.web.command;

import edu.TimeTracker.Java_external.web.controller.controller_util.PageConfiguration;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MissingCommand implements Command {
  private static final Logger LOGGER = Logger.getLogger(MissingCommand.class);

  /**
   * Method for missing command from user
   * he forward to error page
   *
   * @param request
   * @param response
   * @return page
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
  }
}
