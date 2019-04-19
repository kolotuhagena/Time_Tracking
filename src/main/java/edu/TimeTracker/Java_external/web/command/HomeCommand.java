/*
package edu.TimeTracker.Java_external.web.command;


import edu.TimeTracker.Java_external.service.UserService.UserService;
import edu.TimeTracker.Java_external.web.controller.controller_util.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeCommand implements Command {
  */
/**
   * Method for forward on home(main) page
   *
   * @param request
   * @param response
   * @return page
   * @throws ServletException
   * @throws IOException
   *//*

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    if(request.getParameter("act")!=null){
      String trackId = request.getParameter("number");
      String time = request.getParameter("time");
      int id = (int) request.getSession().getAttribute("id");
      if(request.getParameter("act").equals("update"))
      UserService.getInstance().updateTracks(trackId,time,id);
      else if(request.getParameter("act").equals("add")){
        String activityId = request.getParameter("activity");
        UserService.getInstance().addRequest(activityId,id);
      }else if(request.getParameter("act").equals("delete")){
        UserService.getInstance().deleteRequest(trackId);
      }
    }
    int startPage = 1;
    if (request.getParameter("page") != null) {
      startPage = Integer.parseInt(request.getParameter("page"));
    }
    int recordPerPage = 6;
    int offset = startPage*recordPerPage-recordPerPage;
    int id = (int)request.getSession().getAttribute("id");
    int countRecords = UserService.getInstance().getRecords(id) ;
    int noOfPages = (int) Math.ceil(countRecords * 1.0 / recordPerPage);
    request.setAttribute("noOfPages", noOfPages);
    request.setAttribute("currentPage", startPage);
    request.getSession().setAttribute("activityList", UserService.getInstance().getActivityList());
    request.getSession().setAttribute("trackList",UserService.getInstance().getTracksWithPagination(id,offset,recordPerPage));
    return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
  }
}
*/
