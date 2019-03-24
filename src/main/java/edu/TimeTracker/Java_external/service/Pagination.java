package edu.TimeTracker.Java_external.service;

import edu.TimeTracker.Java_external.persistence.DAO.Factory.DAOFactory;
import edu.TimeTracker.Java_external.persistence.DAO.Factory.Factory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Pagination {
    private static final Logger LOGGER = Logger.getLogger(Pagination.class);
    private static Pagination INSTANCE;

    private Pagination() {
        DAOFactory factory = new Factory();
    }

    /**
     * Singleton
     *
     * @return INSTANCE

     */
    public static Pagination getInstance() {
        if (INSTANCE == null) {
            synchronized (Pagination.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Pagination();
                }
            }
        }
        return INSTANCE;
    }

    /*public void conditionPagination(HttpServletRequest request, String parameterPage) {
        int startPage = 1;
        if (request.getParameter(parameterPage) != null) {
            startPage = Integer.parseInt(request.getParameter(parameterPage));
        }
        int recordPerPage = 10;
        List<PaginationAble> list = .getInstance().
                ((startPage - 1) * recordPerPage, recordPerPage);
        int countRecords = .getInstance().();
        int noOfPages = (int) Math.ceil(countRecords * 1.0 / recordPerPage);
        request.setAttribute("directionListP", );
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", startPage);
        request.setAttribute("visibleTable", true);
    }*/

}
