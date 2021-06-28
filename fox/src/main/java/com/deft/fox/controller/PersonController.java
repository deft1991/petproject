package com.deft.fox.controller;

import com.deft.fox.model.Person;
import com.deft.fox.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sergey Golitsyn
 * created on 08.10.2020
 */
@RestController
@RequestMapping("/v2/persons/")
//@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class PersonController {

    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
//    @ApiOperation("Returns list of all Persons in the system.")
    public List getAllPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
//    @ApiOperation("Returns a specific person by their identifier. 404 if does not exist.")
    public Person getPersonById(/*@ApiParam("Id of the person to be obtained. Cannot be empty.")*/
            @PathVariable int id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
//    @ApiOperation("Deletes a person from the system. 404 if the person's identifier is not found.")
    public void deletePerson(/*@ApiParam("Id of the person to be deleted. Cannot be empty.")*/
            @PathVariable int id) {
        personService.deletePerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
//    @ApiOperation("Creates a new person.")
    public Person createPerson(/*@ApiParam("Person information for a new person to be created.")*/
            @RequestBody Person person) {
        return personService.createPerson(person);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
