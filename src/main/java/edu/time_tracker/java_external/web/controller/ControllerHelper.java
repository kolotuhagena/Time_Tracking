/*
package edu.time_tracker.java_external.web.controller;

import edu.time_tracker.java_external.web.command.*;
import UriMarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerHelper extends CommandFactory {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private static ControllerHelper instance;

    */
/**
     * Constructor in which filling the table with commands
     *//*

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
*/
