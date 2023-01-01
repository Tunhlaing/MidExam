package com.example.midexam;

public class RegisterModel {
    private int register_id;
    private String username;
    private String password;

    public RegisterModel(int register_id, String username, String password) {
        this.register_id = register_id;
        this.username = username;
        this.password = password;
    }

    public int getRegister_id() {
        return register_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
