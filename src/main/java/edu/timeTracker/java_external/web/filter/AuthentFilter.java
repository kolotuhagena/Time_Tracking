/*
package edu.timeTracker.java_external.web.filter;


import User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;
@WebFilter(filterName = "AuthenticationFilter",
        urlPatterns = { "/administrate",
                        "/sign_in",
                        "/home",
                        "/logout",
                        "/account"})
public class AuthentFilter implements Filter {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession();
        final UserDao userDao = new Factory().getUserDao();
        final User user = userDao.getByName(login);
        final String sessionLogin = (String) session.getAttribute("login");
        Integer sessionPassword = (Integer) session.getAttribute("password");
        if (nonNull(session) &&
                nonNull(sessionLogin) &&
                nonNull(sessionPassword)) {
            User sessionUser = userDao.getByName(sessionLogin);
            if (sessionUser.getLogin().equals(sessionLogin) && sessionPassword.equals(sessionUser.getPassword())) {
                moveToMenu(sessionUser, req, res, filterChain);
            }
        } else if (nonNull(login) && nonNull(password) && nonNull(user)) {
            //Тут происходит проверка пользователя на подлинность
            if (user.getLogin().equals(login) && user.getPassword() == password.hashCode()) {
                session.setAttribute("login", user.getLogin());
                session.setAttribute("id", user.getId());
                session.setAttribute("password", user.getPassword());
                if(user.getRole().equals(User.Role.ADMIN)){
                    session.setAttribute("IsAdministrator",true);
                }
                moveToMenu(user, req, res, filterChain);
            }
        } else moveToMenu(null, req, res, null);
    }

    private void moveToMenu(User user, HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        if (nonNull(user)) {
            chain.doFilter(req, res);
        } else req.getRequestDispatcher("/WEB-INF/view/signIn.html").forward(req, res);
    }

    @Override
    public void destroy() {

    }
}
*/
