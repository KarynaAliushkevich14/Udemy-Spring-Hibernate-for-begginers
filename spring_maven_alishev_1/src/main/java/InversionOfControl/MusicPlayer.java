package InversionOfControl;

public class MusicPlayer {
    private Music music;
    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //create construct which implement Music music
    //IoC
    public MusicPlayer(Music theMusic){
        music = theMusic;
    }

    public MusicPlayer(){};

    public void setMusic(Music music){
        this.music = music;
     }

    //method
    void playMusic(){
        System.out.println("PLaying.. "+music.getSong());
    }
}
