package com.example.demo.dao;

import com.example.demo.models.Book;
import com.example.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }


    public Person show(int id) {
       return jdbcTemplate.query("SELECT * FROM person WHERE id = ? LIMIT 1", new BeanPropertyRowMapper<>(Person.class), id)
               .stream()
               .findAny()
               .orElse(null);
    }


    public Person show(String name) {
        return jdbcTemplate.query("SELECT * FROM person WHERE name=?", new BeanPropertyRowMapper<>(Person.class), name)
                .stream()
                .findAny()
                .orElse(null);
    }


    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, year) VALUES(?, ?)", person.getName(), person.getYear());
    }


    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE person SET name=?, year=? WHERE id=?", person.getName(), person.getYear(), id);
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }


    public List<Book> getBooksByPerson(Person person) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id=?", new BeanPropertyRowMapper<>(Book.class), person.getId());
    }

}
