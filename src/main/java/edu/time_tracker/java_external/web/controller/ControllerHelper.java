package edu.time_tracker.java_external.web.controller;

import edu.time_tracker.java_external.web.command.*;
import edu.time_tracker.java_external.web.controller.controller_util.UriMarshaller;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            case "registration":
                return Commands.REGISTRATION.getCommand();
            case "account":
                return Commands.ACCOUNT_MANAGE.getCommand();
            default:
                return Commands.MissingCommand.getCommand();
        }
    }
}
