package com.charitynews.news.user;

/**
 * Created by ashley on 31/07/14.
 */
public class User {

    public static String name;
    public static String email;
    public static boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String names) {
        name = names;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String emails) {
        email = emails;
    }
}
