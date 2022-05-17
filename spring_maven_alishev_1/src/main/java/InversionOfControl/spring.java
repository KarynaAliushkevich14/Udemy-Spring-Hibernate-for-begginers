package InversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class spring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Music music = context.getBean("rockMusicBean", Music.class);

        //create MusicPlayer
        //MusicPlayer myMusicPlayer = new MusicPlayer(music);

        MusicPlayer myMusicPlayer = context.getBean("MusicPlayer", MusicPlayer.class );

        myMusicPlayer.playMusic();
        System.out.println(myMusicPlayer.getName());
        System.out.println(myMusicPlayer.getVolume());

        context.close();
    }
}
