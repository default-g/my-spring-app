package com.example.demo.dao;

import com.example.demo.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT = 0;

    {
        people = new ArrayList<>();
        people.add(new Person(PEOPLE_COUNT++, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(PEOPLE_COUNT++, "John", 21, "john@mail.ru"));
        people.add(new Person(PEOPLE_COUNT++, "Fred", 23, "fred@mail.ru"));
        people.add(new Person(PEOPLE_COUNT++, "Mike", 50, "mike@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people
                .stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(PEOPLE_COUNT++);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }

}
