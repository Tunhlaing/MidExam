package com.example.midexam;

public class RegisterModel {
    private int register_id;
    private String username;
    private String password;
    private String status;

    public RegisterModel(int register_id, String username, String password, String status) {
        this.register_id = register_id;
        this.username = username;
        this.password = password;
        this.status = status;
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

    public String getStatus(){
        return status;
    }
}
