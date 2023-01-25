package com.avijeet.practice_2022.tekion;

public class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {

        if (singleton != null) {
            return singleton;
        }

            singleton = new Singleton();

        return singleton;
    }
}