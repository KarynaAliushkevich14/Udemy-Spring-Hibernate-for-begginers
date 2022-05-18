package MusicPlayerAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {
    public static void main(String[] args) {

        //start file applicationContext
        //but now applicationContext create beans for us with the stroke context:component-scan
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //define bean with getbean
        /*
        Computer computer = context.getBean("computer", Computer.class);

        System.out.println(computer);

         */

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        //checking if @Scope of ClassicalMusic bean is working
        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println(classicalMusic == classicalMusic2);

        context.close();

    }
}
