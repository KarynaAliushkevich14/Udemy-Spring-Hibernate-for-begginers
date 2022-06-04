package myCrud.Controllers;

import myCrud.DAO.PersonDAO;
import myCrud.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    //Spring podstawi Component PersonDAO do Controller przez pole
    // @Autowired
    private PersonDAO personDAO;

    //Spring podstawi Component PersonDAO do Controller przez konstruktor
    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    //1 method
    //zwraca listę osób
    // REST form : /posts  HTTP method: GET
    @GetMapping()
    public String index(Model model) {
        // Получим всех людей из myCrud.DAO и передадим на отображение писок людей в view
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    //2 method
    //zwraca listę osób według id
    // REST form : /posts/:id  HTTP method: GET
    // Za pomocą GetMapping, możemy wpisać do URL jakikolwiek {id} i on włoży się za pomocą @PathVariable do parametru int id
    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model){
        // Получим одного человека по id из myCrud.DAO и передадим на отображение в view
        model.addAttribute("person", personDAO.showById(id));
        return "people/show";
    }

    //3 method
    //zwraca HTML formę dla stworzenia nowego Person
    // REST form : /posts/new  HTTP method: GET
    //Dlaczego w argumentach Model model? Bo musimy przekazywać obiekt Person dla Thymeleaf żeby stworzyć na podstawie pól Thymeleaf formy- HTML
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    //4 method
    // bierzy z url argumenty->stwarza new Person()->person.setName->model.add(person)
    // REST form : /people  HTTP method: POST
    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }

    //5 method
    //forma HTML dla edit person by ID
    // REST form : /people/{id}/edit  HTTP method: GET
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.showById(id));
        return "people/edit";
    }

    //6 method
    //przyjmuję PATCH z edit.html
    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("person") Person person, @PathVariable("id") int id) {
        personDAO.update(id, person);
        return "redirect:/people";
    }

    //7 method
    //metoda kontrollera która usuwa dane z listy
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }



}
