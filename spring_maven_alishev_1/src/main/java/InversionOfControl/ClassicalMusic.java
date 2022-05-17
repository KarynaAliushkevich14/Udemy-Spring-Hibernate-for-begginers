package InversionOfControl;

public class ClassicalMusic implements Music {

    @Override
    public String getSong(){
        return "4 seasons";
    }

    //private constructor
    private ClassicalMusic(){};

    //Fabric method
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

}
