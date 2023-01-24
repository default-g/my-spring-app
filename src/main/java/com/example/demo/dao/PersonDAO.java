package com.example.demo.dao;

import com.example.demo.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT p FROM Person p", Person.class).list();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
       return sessionFactory.getCurrentSession().get(Person.class, id);
    }


    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().persist(person);
    }

    @Transactional
    public void update(int id, Person person) {
         Session session = sessionFactory.getCurrentSession();
         Person personToUpdate = session.get(Person.class, id);
         personToUpdate.setName(person.getName());
         personToUpdate.setAge(person.getAge());
         personToUpdate.setEmail(person.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        sessionFactory.getCurrentSession().remove(session.get(Person.class, id));
    }

}
