package MusicPlayerAnnotations;

public class MusicPlayer {
    private Music music;

    //constructor with Dependecy Injection
    public MusicPlayer(Music theMusic){
        music = theMusic;
    }

    //method
    void playMusic(){
        System.out.println("PLaying.. "+music.getSong());
    }

}
