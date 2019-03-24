package edu.TimeTracker.Java_external.web.command;

import edu.TimeTracker.Java_external.service.Pagination;

public enum Commands {
    ADMINISTRATE(new AdministrateCommand()),
    FORWARD_SIGN_IN(new ForwardToSignIn()),
    HOME(new HomeCommand()),
    LOGOUT(new LogoutCommand()),
    MissingCommand(new MissingCommand()),
    PAGINATION(new PaginationCommand()),
    REGISTRATION(new RegistrationCommand());
    Commands(Command command){
        this.command = command;
    }
    Command command;
    public Command getCommand(){return command;}
}
