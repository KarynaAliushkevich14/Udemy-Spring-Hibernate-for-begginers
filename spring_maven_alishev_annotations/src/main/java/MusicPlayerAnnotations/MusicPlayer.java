package MusicPlayerAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    //fields
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    @Qualifier("rockMusic")
    private Music music;
/*
    //constructor with Dependecy Injection
    //@Autowired
    public MusicPlayer(Music music){
        this.music = music;
    }

    //setter with DI
    //doesn't matter how it called
    //@Autowired
    public void setMusic(Music music){
        this.music=music;
    }
*/

    //method
    public String playMusic() {
        return "Playing: " + music.getSong();
    }

    //getters for name, volume
    public String getName(){
        return name;
    }

    public int getVolume(){
        return volume;
    }
}
