package MusicPlayerNoXML;

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