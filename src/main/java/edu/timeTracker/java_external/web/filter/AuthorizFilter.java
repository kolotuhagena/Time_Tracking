/*
package edu.timeTracker.java_external.web.filter;

import User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(filterName = "AuthorizationFilter",
            urlPatterns = {"/administrate"})
public class AuthorizFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;


        final HttpSession session = req.getSession();
        final UserDao userDao = new Factory().getUserDao();
        final String sessionLogin = (String) session.getAttribute("login");
        if (nonNull(session) &&
                nonNull(sessionLogin)) {

            User sessionUser = userDao.getByName(sessionLogin);
            if (sessionUser.getRole().equals(User.Role.ADMIN)) {
                session.setAttribute("IsAdministrator",true);
                moveToMenu(sessionUser, req, res, filterChain);
            } else moveToMenu(null,req,res,filterChain);
        }
    }

    private void moveToMenu(User user, HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        if (nonNull(user)) {
            chain.doFilter(req, res);
        } else req.getRequestDispatcher("/WEB-INF/view/index.ftl").forward(req, res);
    }

    @Override
    public void destroy() {

    }
}
*/
