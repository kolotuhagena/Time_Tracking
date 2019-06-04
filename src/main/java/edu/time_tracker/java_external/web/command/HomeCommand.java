/*
package edu.time_tracker.java_external.web.command;


import user_service;
import PageConfiguration;

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
      user_service.getInstance().updateTracks(trackId,time,id);
      else if(request.getParameter("act").equals("add")){
        String activityId = request.getParameter("activity");
        user_service.getInstance().addRequest(activityId,id);
      }else if(request.getParameter("act").equals("delete")){
        user_service.getInstance().deleteRequest(trackId);
      }
    }
    int startPage = 1;
    if (request.getParameter("page") != null) {
      startPage = Integer.parseInt(request.getParameter("page"));
    }
    int recordPerPage = 6;
    int offset = startPage*recordPerPage-recordPerPage;
    int id = (int)request.getSession().getAttribute("id");
    int countRecords = user_service.getInstance().getRecords(id) ;
    int noOfPages = (int) Math.ceil(countRecords * 1.0 / recordPerPage);
    request.setAttribute("noOfPages", noOfPages);
    request.setAttribute("currentPage", startPage);
    request.getSession().setAttribute("activityList", user_service.getInstance().getActivityList());
    request.getSession().setAttribute("trackList",user_service.getInstance().getTracksWithPagination(id,offset,recordPerPage));
    return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
  }
}
*/
