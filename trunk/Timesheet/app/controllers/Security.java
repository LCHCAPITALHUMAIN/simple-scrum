package controllers;

import models.User;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        System.out.println("connected user is " + connected());
        return User.find("byUserName", username).<User>first() != null;

    }

    static boolean check(String profile) {
        System.out.println("connected user is " + connected());
        if (connected() == null) {
            System.out.println("User is null");
            return false;
        }
        User user = User.find("byUserName", connected()).<User>first();
        if (user == null) {
            System.out.println("user is not found");
            return false;
        }

        return profile.equals(user.profile);
    }

}