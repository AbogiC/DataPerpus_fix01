package com.model.dto;

public class LoginDto {

    private Long id;
    private String emaillogin;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmaillogin() {
        return emaillogin;
    }

    public void setEmaillogin(String emaillogin) {
        this.emaillogin = emaillogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
