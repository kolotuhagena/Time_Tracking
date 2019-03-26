package edu.TimeTracker.Java_external.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "encodingFilter",
urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
  private String encoding = "UTF-8";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    String encodingParam = filterConfig.getInitParameter("encoding");
    if (encodingParam != null) {
      encoding = encodingParam;
    }
  }

  @Override
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain)
          throws IOException, ServletException {
    request.setCharacterEncoding(encoding);
    response.setContentType("text/html");
    response.setCharacterEncoding(encoding);
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {

  }
}
