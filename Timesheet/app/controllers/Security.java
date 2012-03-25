package controllers;

import models.User;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        System.out.println("connected user is " + connected());
        return User.find("byUserName", username).<User>first() != null;

    }

    static boolean check(String profile) {
        if (connected() == null) {
            return false;
        }
        User user = User.find("byUserName", connected()).<User>first();
        if (user == null) {
            return false;
        }
        return profile.equals(user.profile.profileName);
    }

}