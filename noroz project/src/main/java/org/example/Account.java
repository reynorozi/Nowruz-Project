package org.example;

public class Account {

    private String name;
    private int age;
    private String username;
    private String password;
    private String role;

    public Account() {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
/*
info should be save in jason
parsing json to the aarry list of accounts

sign up some users
make array list of users info
write the login method

*/
