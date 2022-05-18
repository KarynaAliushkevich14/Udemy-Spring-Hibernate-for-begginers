package MusicPlayerNoXML;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Spring {
    public static void main(String[] args) {

        //instead of ClassPathXmlApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

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
