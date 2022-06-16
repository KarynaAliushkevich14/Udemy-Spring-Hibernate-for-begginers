package myCrud.DAO;

//Zajmije się wyodrębnieniem osoby z listy, znalezieniu osoby według listy, dodawać, uprgade oraz usunięcie

import myCrud.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //1 method
    //tylko zwracamy listę people
    public List<Person> index(){
       return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    //2 method
    // zwracany osobę według id
    public Person showById(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }


    //3 method
    //dodajemy osobę do naszej listy
    public void save (Person person){
        jdbcTemplate.update("INSERT INTO person (name,age,email) VALUES (?, ?, ?)", person.getName(), person.getAge(), person.getEmail());
    }

    //3 method
    //update danych za pomocą konkretnrgo id i osoby
    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id =?", updatedPerson.getName(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }


    //4 method
    //usuwanie danych za pomocą konkretnrgo id
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }


}
