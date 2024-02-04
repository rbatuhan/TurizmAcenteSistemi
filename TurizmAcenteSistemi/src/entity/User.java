package entity;

import core.ComboItem;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;

    //Parametreli constructor metodu
    public User(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + role + '\'' +
                "}";
    }

   public ComboItem getComboItem() {
        return new ComboItem(this.getId(), this.getUsername() +" - "+ this.getPassword()+" - " + this.getRole());
    }

}
