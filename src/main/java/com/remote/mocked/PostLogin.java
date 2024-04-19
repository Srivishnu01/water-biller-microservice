package com.remote.mocked;

public class PostLogin
{
    public enum Login_status {LOGGED_IN, INVALID_USER, INVALID_PASSWORD};
    public Login_status login_status;
    public String AccountNumber;
    public String message;
    public String username, password;
    public PostLogin(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    public void findUser()
    {
        this.login_status = Login_status.LOGGED_IN;
        this.AccountNumber = "Accsrivari";
    }
}