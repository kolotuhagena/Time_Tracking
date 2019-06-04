package edu.time_tracker.java_external.web.controller.controller_util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class UriMarshaller {
    private String requestUri;
    private String action = null;
    /*Supposing we have uri /Login/SignIn, then SignIn action has index 1
     * in an array splitted by '/' */
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    public UriMarshaller(HttpServletRequest request) {
        this.requestUri = request.getRequestURI().substring(request.getContextPath().length());
    }

    /**
     * Returns action part of the current URI.
     * If no action is specified, <code>null</code> is returned
     * @return action based on URI
     */
    public String getAction(){
        //lazy initialization
        if(action!=null)
            return action;
        else{
            try {
                action = parseUri();
            } catch (RuntimeException e) {
                LOGGER.info(e.getMessage());
            }
        }
        return action;
    }

    String parseUri() {
        if(requestUri==null)
            throw new RuntimeException("Request uri can't be null");

        String[] uriParts = requestUri.split("/");
        uriParts = Arrays.stream(uriParts).filter(x -> !x.equals("")).toArray(String[]::new);
        if(uriParts.length>=1)
            return uriParts[0];
        else throw new RuntimeException("No action part found in uri");
    }
}
