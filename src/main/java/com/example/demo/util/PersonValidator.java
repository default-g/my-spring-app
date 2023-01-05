package com.example.demo.util;

import com.example.demo.dao.PersonDAO;
import com.example.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // Посмотреть, есть ли человек с таким же email;
        if (personDAO.show(person.getName()) != null) {
            errors.rejectValue("name", "", "Пользователь с таким именем уже существует");
        }

        // Проверка года рождения
        if (person.getYear() <= 0) {
            errors.rejectValue("year", "", "Некорректно указан год рождения");
        }

    }
}
