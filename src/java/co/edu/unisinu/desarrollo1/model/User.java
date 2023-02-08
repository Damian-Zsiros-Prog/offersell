package co.edu.unisinu.desarrollo1.model;

import java.sql.Timestamp;

public class User {
    private int idUser;
    private String names;
    private String surnnames;
    private String direction;
    private String email;
    private String password;
    private String phoneNumber;
    private int rol;
    private Timestamp date_register;

    public User(int idUser, String names, String surnnames, String direction, String email, String password, String phoneNumber, int rol, Timestamp date_register) {
        this.idUser = idUser;
        this.names = names;
        this.surnnames = surnnames;
        this.direction = direction;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.rol = rol;
        this.date_register = date_register;
    }

    public User(String names, String surnnames, String direction, String email, String password, String phoneNumber, int rol) {
        this.names = names;
        this.surnnames = surnnames;
        this.direction = direction;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.rol = rol;
    }

    public User(int idUser) {
        this.idUser = idUser;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnnames() {
        return surnnames;
    }

    public void setSurnnames(String surnnames) {
        this.surnnames = surnnames;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDate_register() {
        return date_register;
    }

    public void setDate_register(Timestamp date_register) {
        this.date_register = date_register;
    }

    
    
}
