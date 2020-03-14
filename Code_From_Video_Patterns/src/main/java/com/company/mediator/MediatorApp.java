package com.company.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Ivan Ivanich");
        User user1 = new SimpleUser(chat, "Vanya");
        User user2 = new SimpleUser(chat, "Vova");
        User user3 = new SimpleUser(chat, "Sasha");
        user2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);

        user1.sendMessage("Hello, I'm user");
        admin.sendMessage("Admin here!!!");
    }
}

abstract class User {
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [name=" + name +
                ']';
    }

    void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);

    public String getName(){
        return this.name;
    }
}

class Admin extends User {

    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin " + name + " get message '" + message + "'");

    }
}

class SimpleUser extends User {

    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User" + name + " get message '" + message + "'");

    }
}

interface Chat {
    void sendMessage(String message, User user);
}

class TextChat implements Chat {
    private User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("Permission denied");
        }
    }

    void addUser(User user) {
        if (admin == null) {
            throw new RuntimeException("Admin not in chat");
        }
        if (user instanceof SimpleUser) {
            users.add(user);
        } else {
            throw new RuntimeException("Admin can't come to another chat");
        }
    }

    @Override
    public void sendMessage(String message, User user) {
        if(user instanceof Admin) {
            for (User u : users) {
                u.getMessage(message);
            }
        }
        if(user instanceof SimpleUser){
            for (User u : users) {
                if (u!=user && u.isEnable()) {
                    u.getMessage(message);
                }
            }
            if(admin.isEnable())
            admin.getMessage(user.getName() + " : " + message);

        }
    }
}