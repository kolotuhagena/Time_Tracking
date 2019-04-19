/*
package edu.TimeTracker.Java_external.web.command;

import edu.TimeTracker.Java_external.domain.entity.Request;
import edu.TimeTracker.Java_external.service.Administrate;
import edu.TimeTracker.Java_external.web.controller.controller_util.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class AdministrateCommand implements Command{
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
        String act = request.getParameter("act");
        Object reqList = request.getSession().getAttribute("requestList");
        List<Request> list = new ArrayList<>();
        if(nonNull(act)&&act.equals("true")&&nonNull(reqList)&&reqList.getClass().equals(list.getClass()))
        {
            list =(List<Request>) reqList;
        }
            for (Request userReq : list){
                Administrate.getInstance().response(userReq.getId(), request.getParameter("opt"+userReq.getId()));
            }
        int startPage = 1;
        if (request.getParameter("page") != null) {
            startPage = Integer.parseInt(request.getParameter("page"));
        }
        int recordPerPage = 6;
        int offset = startPage*recordPerPage-recordPerPage;
        int countRecords = Administrate.getInstance().getRequestRecords() ;
        int noOfPages = (int) Math.ceil(countRecords * 1.0 / recordPerPage);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", startPage);
        request.getSession().setAttribute("requestList",Administrate.getInstance().getRequest(offset,recordPerPage));
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ADMIN_PAGE);
    }
}
*/
