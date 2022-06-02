package myCrud.DAO;

//Zajmije się wyodrębnieniem osoby z listy, znalezieniu osoby według listy, dodawać, uprgade oraz usunięcie

import myCrud.Model.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<Person>();

        people.add (new Person(++PEOPLE_COUNT,"Tom"));
        people.add (new Person(++PEOPLE_COUNT, "Bob"));
        people.add (new Person(++PEOPLE_COUNT, "Mike"));
        people.add (new Person(++PEOPLE_COUNT, "Katy"));
    }

    //1 method
    //tylko zwracamy listę people
    public List<Person> index(){
        return people;
    }

    //2 method
    // zwracany osobę według id
    public Person showById(int id){
         return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
    }

}
