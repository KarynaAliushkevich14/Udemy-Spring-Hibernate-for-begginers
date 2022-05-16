package com.luv2code.springdemo;

public class GolfCoach implements Coach {
    //field of "interface"
    FortuneService fortuneService;

    //class constructor
    public GolfCoach(FortuneService theFortuneService)
    {
      fortuneService= theFortuneService;
    }

    @Override
    public String getDailyWorkOut(){
        return "Let's play some golf";
    }

    @Override
    //use my fortuneService to get a fortune
    public String getFortune(){
        return fortuneService.getFortune();
    }

}