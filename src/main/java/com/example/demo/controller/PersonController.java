package com.example.demo.controller;

import com.example.demo.dao.PersonRepository;
import com.example.demo.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/save")
    public String save(){
        for(int i=30;i<40;i++){
            Person person=new Person();
            person.setId(i+1);
            person.setName("瓜田李下"+i);
            person.setAge(i);

            personRepository.save(person);
        }

        return "success";
    }

    @RequestMapping("/update")
    public Person update(){
        Person person=personRepository.getOne(1);
        person.setName("海贼王");
        personRepository.save(person);

        return person;
    }
}
