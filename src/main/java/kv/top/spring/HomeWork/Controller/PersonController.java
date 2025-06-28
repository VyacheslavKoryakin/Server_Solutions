package kv.top.spring.HomeWork.Controller;

import kv.top.spring.HomeWork.Model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    List<Person> persons;

    public PersonController() {
        persons= new ArrayList<>();
                persons.addAll(List.of(
                        new Person(1,"John",23),
                        new Person(2,"Jane",24),
                        new Person(3,"Bob",25)));
    }

    @PostMapping("/createPerson")
    public boolean add(@RequestBody Person person) {
        return persons.add(person);
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return persons;
    }
    @GetMapping ( "/getById")
    public Person getPersonById(int id){
        return persons.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
    }

    @GetMapping ( "/delById")
    public boolean delPersonById(int id){
        return persons.remove(persons.stream().filter(person -> person.getId() == id).findFirst().orElse(null));
    }

    @PostMapping ( "/updateById")
    public void updatePersonById(int id, String name){
        for (Person person : persons) {
            if (person.getId() == id) {
                person.setName(name);
            }
        }

    }
}
