package myCrud.DAO;

//Zajmije się wyodrębnieniem osoby z listy, znalezieniu osoby według listy, dodawać, uprgade oraz usunięcie

import myCrud.Model.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;



    /*private List<Person> people;

    {
        people = new ArrayList<Person>();

        people.add (new Person(++PEOPLE_COUNT,"Tom", 24, "tom@mail.ru"));
        people.add (new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        people.add (new Person(++PEOPLE_COUNT, "Mike", 18, "mike@yahoo.com"));
        people.add (new Person(++PEOPLE_COUNT, "Katy", 34, "katy@gmail.com"));
    }
    */

    //PODŁĄCZAMU SIĘ DO DB: url DB, imię użytkownika i password
    private static final String URL = "jdbc:mysql://localhost:3306/person";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "25091997Nast";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //1 method
    //tylko zwracamy listę people
    public List<Person> index(){
        //return people;

        List <Person> people = new ArrayList<>();
        //Объект, который имеет SQL хапрос к базе данных
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    //2 method
    // zwracany osobę według id

    public Person showById(int id){
        /*
         return people.stream().filter(person->person.getId() == id).findAny().orElse(null);
         */
        Person person = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));
            person.setAge(resultSet.getInt("age"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }


    //3 method
    //dodajemy osobę do naszej listy
    public void save (Person person){
        //person.setId(++PEOPLE_COUNT);
        // people.add(person);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person ( name, age, email) VALUES ( ?, ?, ?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //3 method
    //update danych za pomocą konkretnrgo id i osoby

    public void update(int id, Person updatedPerson){
        /*
        Person personToBeUpdated = showById(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        */
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");

            preparedStatement.setInt(1, id);//WTF

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //4 method
    //usuwanie danych za pomocą konkretnrgo id
    public void delete(int id){
        //people.removeIf(p -> p.getId() == id);
        PreparedStatement preparedStatement =
                null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE id=?");

            preparedStatement.setInt(1, id); //WTF

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
