package se.fidde.angular.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import se.fidde.angular.domain.Person;
import se.fidde.angular.service.PersonService;

@Controller
@RequestMapping(value = "/*.json")
public class WuvController {

    @Autowired
    PersonService personService;
    private Logger log = Logger.getLogger(WuvController.class);

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addPerson(@RequestBody Person person) {
        log.debug("message recived: " + person);

        personService.addPerson(person);
    }

    @RequestMapping(value = "getAllPeople", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Person> getAllPeople() {
        log.debug("getting all people");

        Collection<Person> allPeople = personService.getAllPeople();

        return allPeople;
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> error(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }

}
