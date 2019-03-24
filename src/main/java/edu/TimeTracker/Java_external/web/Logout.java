package edu.TimeTracker.Java_external.web;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {
    private final Logger LOGGER = Logger.getLogger(Logout.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session =req.getSession();
        session.removeAttribute("password");
        session.removeAttribute("login");
        session.removeAttribute("role");

        LOGGER.info(req.getContextPath());
        resp.sendRedirect("/");
    }
}
