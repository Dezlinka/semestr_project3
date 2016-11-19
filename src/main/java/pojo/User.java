package main.java.pojo;

/**
 * Created by Данил on 14.11.2016.
 */
public abstract class User {

    private int databaseId=-1;
    private String username;
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDatabaseId() {return this.databaseId;}

    public void setDatabaseId(int id) {this.databaseId=id;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public abstract boolean isModer();

    public abstract boolean isAdmin();


}
