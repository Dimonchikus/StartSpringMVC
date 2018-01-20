package viti.kaf22;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by korch on 27.10.17
 * Modified by Tesla on 18.01.18
 */
@Controller
public class MainController {
    private List<Person> personList = new ArrayList<Person>();

    public List<Person> getPersonList() {
        return personList;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject(createPerson());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute("person") Person person){
        personList.add(person);
        modelAndView.setViewName("index");
        modelAndView.addObject("message", "SUCCESS");
        return modelAndView;
    }

    @RequestMapping(value = "/showTable", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView showTable(ModelAndView modelAndView, @ModelAttribute("person") Person person){

        modelAndView.setViewName("index");
        modelAndView.addObject( "tableView", personList);
        return modelAndView;
    }

    @RequestMapping(value = "/clear", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView clear(ModelAndView modelAndView, @ModelAttribute("person") Person person){
        personList.clear();
        modelAndView.setViewName("index");
        modelAndView.addObject( "tableView", personList);
        return modelAndView;
    }

    private Person createPerson(){
        Person person = new Person();
        person.setName("Dmitry");
        person.setSurname("Teslov");
        return person;
    }
}

