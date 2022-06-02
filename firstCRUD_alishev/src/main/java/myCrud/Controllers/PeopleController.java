package myCrud.Controllers;

import myCrud.DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
