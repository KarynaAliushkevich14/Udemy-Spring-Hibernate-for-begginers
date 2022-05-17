package MusicPlayerAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {
    public static void main(String[] args) {

        //start file applicationContext
        //but now applicationContext create beans for us with the stroke context:component-scan
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //create 2 beans: form Music and from MusicPLayer
        Music musicC = context.getBean("classicalMusic", Music.class);

        MusicPlayer musicPlayerC = new MusicPlayer(musicC);

        //musicPlayer method
        musicPlayerC.playMusic();

        context.close();

    }
}
