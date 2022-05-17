package MusicPlayerAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    @Autowired
    private Music music;

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


    //method
    public String playMusic() {
        return "PLaying.. " + music.getSong();
    }
}
