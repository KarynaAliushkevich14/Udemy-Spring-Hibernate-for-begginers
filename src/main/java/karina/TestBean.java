package karina;

// z tej klasy Spring utworzy się Bean
public class TestBean {
    String name;

    public TestBean(String theName){
        name = theName;
        System.out.println("THIS IS OUT CONSTRUKTOR TestBean");
    }

    public String getName(){
        return name;
    }
    public void setName(String thisName){
        name = thisName;
    }


}