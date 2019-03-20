package edu.TimeTracker.Java_external.entity;

public class User {
    private int userId;
    private String login;
    private int password;
    private String email;
    private Role role;

    public User(int userId, String login, int password, String email, Role role) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role {
        ADMIN("ADMIN"), USER("USER");
        private final String name;
        Role(String name){
            this.name=name;
        }
        public String getName() {
            return name;
        }
    }
}
