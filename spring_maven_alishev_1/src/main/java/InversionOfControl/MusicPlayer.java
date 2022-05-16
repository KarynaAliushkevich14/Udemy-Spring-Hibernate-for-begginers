package InversionOfControl;

public class MusicPlayer {
    private Music music;

    //create construct which implement Music music
    //IoC
    MusicPlayer(Music theMusic){
        music = theMusic;
    }

    //method
    void playMusic(){
        System.out.println("PLaying.. "+music.getSong());
    }
}
