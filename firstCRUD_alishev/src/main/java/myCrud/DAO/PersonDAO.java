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

        people.add (new Person(++PEOPLE_COUNT,"Tom", 24, "tom@mail.ru"));
        people.add (new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        people.add (new Person(++PEOPLE_COUNT, "Mike", 18, "mike@yahoo.com"));
        people.add (new Person(++PEOPLE_COUNT, "Katy", 34, "katy@gmail.com"));
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

    //3 method
    //dodajemy osobę do naszej listy
    public void save (Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    //3 method
    //update danych za pomocą konkretnrgo id i osoby
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = showById(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    //4 method
    //usuwanie danych za pomocą konkretnrgo id
    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }


}
