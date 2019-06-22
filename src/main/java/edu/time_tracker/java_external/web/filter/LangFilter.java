package edu.time_tracker.java_external.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

import static java.util.Objects.nonNull;

@WebFilter(filterName = "LanguageFilter", urlPatterns = {"/*"})
public class LangFilter implements Filter {

    private static final String LANG_PARAM = "lang";
    private static final Locale UKRAINIAN = new Locale("ua", "UA");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String param = request.getParameter(LANG_PARAM);
        if (nonNull(param)) {
            if (param.equals("EN")) {
                Config.set(request.getSession(false), Config.FMT_LOCALE, Locale.ENGLISH);
            } else if (param.equals("UA"))
                Config.set(request.getSession(false), Config.FMT_LOCALE, UKRAINIAN);
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}

