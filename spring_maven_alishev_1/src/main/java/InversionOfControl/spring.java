package InversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class spring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Music music = context.getBean("rockMusicBean", Music.class);

        //create MusicPlayer
        MusicPlayer myMusicPlayer = new MusicPlayer(music);

        myMusicPlayer.playMusic();

        context.close();
    }
}
