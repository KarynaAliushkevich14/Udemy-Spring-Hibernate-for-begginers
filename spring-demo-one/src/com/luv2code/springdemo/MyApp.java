package com.luv2code.springdemo;

public class MyApp {
    public static void main(String[] args) {

        //Basic example of Inversion of Control
        Coach theCoach = new TrackCoach();
        System.out.println(theCoach.getDailyWorkOut());

    }
}
