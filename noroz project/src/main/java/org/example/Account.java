package org.example;

//This class is the Account class, and its parent classes are User, Artist, and Admin.

public class Account {

    private String name;
    private int age;
    private String username;
    private String password;


    public Account(String username,int age, String password, String name) {
        this.name = name;
        this.age = age;
        this.username =username;
        this.password =password;
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

