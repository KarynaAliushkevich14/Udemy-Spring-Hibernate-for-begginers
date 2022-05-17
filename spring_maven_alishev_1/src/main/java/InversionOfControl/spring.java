package InversionOfControl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class spring {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Music music = context.getBean("rockMusicBean", Music.class);

        //create MusicPlayer
        //MusicPlayer myMusicPlayer = new MusicPlayer(music);

        MusicPlayer firstMusicPlayer = context.getBean("MusicPlayer", MusicPlayer.class );
        MusicPlayer secondMusicPlayer = context.getBean("MusicPlayer", MusicPlayer.class );

        firstMusicPlayer.setVolume(1);

        System.out.println(firstMusicPlayer.getVolume());
        System.out.println(secondMusicPlayer.getVolume());

        //adding myInit and myDestroy
        RockMusic rocky = context.getBean("rockMusicBean", RockMusic.class);



        context.close();
    }
}
