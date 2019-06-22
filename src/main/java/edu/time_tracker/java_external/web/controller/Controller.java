package edu.time_tracker.java_external.web.controller;

import edu.time_tracker.java_external.web.command.Command;
import edu.time_tracker.java_external.web.controller.controller_util.MessageUtil;
import edu.time_tracker.java_external.web.controller.controller_util.PageConfiguration;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/administrate" ,
        "/sign_in",
        "/home",
        "/logout",
        "/registration",
        "/account"})
public class Controller extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "text/html;charset=utf-8";


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Definition command which went from jsp
     * call the implemented  execute() method of the Command interface and pass parameters
     * the class-processor of a specific command
     *
     * @return page
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page;
        try {
            CommandFactory factory = new ControllerHelper(request,response);
            Command command = factory.defineCommand();
            page = command.execute(request, response);
        } catch (Exception e) {
            request.setAttribute("Exception",
                    MessageUtil.getInstance().getMessageException(MessageUtil.SERVLET_EXCEPTION));
            LOGGER.error(e);
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        }
        response.setCharacterEncoding(ENCODING);
        response.setContentType(CONTENT_TYPE);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        LOGGER.info("Forward to: " + page);
        requestDispatcher.forward(request, response);
    }
}
