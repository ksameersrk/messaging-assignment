package me.sameerkulkarni.projects.msgapp;


public class Util {

    static private String toUserName;
    static private String fromUserName;
    static private String baseEndpoint;


    static {
        String profile = System.getProperty("user.profile");
        if (profile != null && profile.equalsIgnoreCase("p2")) {
            toUserName = "Danny";
            fromUserName = "Jon";
            baseEndpoint = "http://localhost:8080";
        } else {
            toUserName = "Jon";
            fromUserName = "Danny";
            baseEndpoint = "http://localhost:8081";
        }
    }

    public static String getBaseEndpoint() {
        return baseEndpoint;
    }

    public static String getToUserName() {
        return toUserName;
    }

    public static String getFromUserName() {
        return fromUserName;
    }
}
