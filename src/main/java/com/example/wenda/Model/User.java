package com.example.wenda.Model;

/**
 * Created by Administrator on 2018/8/22 0022.
 */
public class User {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name = name;
    }
    public String getDescription(){
        return "this is" + name ;
    }
}

