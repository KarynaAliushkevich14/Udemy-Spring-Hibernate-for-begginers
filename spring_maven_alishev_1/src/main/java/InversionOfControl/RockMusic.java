package InversionOfControl;

public class RockMusic implements Music{

    @Override
    public String getSong(){
        return "Nothing Else Matters";
    }

    public void doMyInit(){
        System.out.println("MyInit");
    }
    public void doMyDestroy(){
        System.out.println("MyDestroy");
    }
}
