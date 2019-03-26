package edu.TimeTracker.Java_external.web.command;



public enum Commands {
    ADMINISTRATE(new AdministrateCommand()),
    FORWARD_SIGN_IN(new ForwardToSignIn()),
    HOME(new HomeCommand()),
    LOGOUT(new LogoutCommand()),
    MissingCommand(new MissingCommand()),
    REGISTRATION(new RegistrationCommand()),
    ACCOUNT_MANAGE(new AccountManageCommand());
    Commands(Command command){
        this.command = command;
    }
    Command command;
    public Command getCommand(){return command;}
}
