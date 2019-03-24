package edu.TimeTracker.Java_external.web.command;

import edu.TimeTracker.Java_external.service.Pagination;
import edu.TimeTracker.Java_external.web.controller.controller_util.PageConfiguration;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaginationCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(PaginationCommand.class);
    private static final String PAGE_PARAM = "page";

    /**
     * Method for pagination (pages on condition page)
     *
     * @param request
     * @param response
     * @return page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Pagination.getInstance().conditionPagination(request, PAGE_PARAM);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ADMIN_PAGE);
    }
}
