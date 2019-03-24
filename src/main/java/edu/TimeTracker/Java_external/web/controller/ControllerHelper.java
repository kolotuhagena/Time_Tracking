package edu.TimeTracker.Java_external.web.controller;

import edu.TimeTracker.Java_external.web.command.*;
import edu.TimeTracker.Java_external.web.controller.controller_util.UriMarshaller;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerHelper extends CommandFactory {
    private static final Logger LOGGER = Logger.getLogger(ControllerHelper.class);
    private static ControllerHelper instance;

    /**
     * Constructor in which filling the table with commands
     */
    public ControllerHelper(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
    }

    @Override
    public Command defineCommand() {
        UriMarshaller marshaller = new UriMarshaller(request);
        String action = marshaller.getAction();
        switch (action) {
            case "administrate":
                return Commands.ADMINISTRATE.getCommand();
            case "sign_in":
                return Commands.FORWARD_SIGN_IN.getCommand();
            case "home":
                return Commands.HOME.getCommand();
            case "logout":
                return Commands.LOGOUT.getCommand();
            case "pagination":
                return Commands.PAGINATION.getCommand();
            case "registration":
                return Commands.REGISTRATION.getCommand();

            default:
                return Commands.MissingCommand.getCommand();
        }
    }
}
