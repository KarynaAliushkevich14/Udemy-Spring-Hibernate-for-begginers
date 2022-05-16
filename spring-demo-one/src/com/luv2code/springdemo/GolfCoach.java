package com.luv2code.springdemo;

public class GolfCoach implements Coach {
    //field of "interface"
    FortuneService fortuneService;

    //class constructor
    GolfCoach(FortuneService theFortuneService){
      fortuneService= theFortuneService;
    }

    @Override
    public String getDailyWorkOut(){
        return "Let's play some golf";
    }

}