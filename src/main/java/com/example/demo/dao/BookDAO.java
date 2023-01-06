package com.example.demo.dao;

import com.example.demo.models.Book;
import com.example.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class BookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }


    public List<Book> getFreeBooks() {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id IS NULL", new BeanPropertyRowMapper<>(Book.class));
    }


    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE id = ?", new BeanPropertyRowMapper<>(Book.class), id)
                .stream()
                .findAny()
                .orElse(null);
    }


    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(name, author, year) VALUES (?, ?, ?)", book.getName(), book.getAuthor(), book.getYear());
    }


    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE book SET name=?, author=?, year=? WHERE id = ?", book.getName(), book.getAuthor(), book.getYear(), id);
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }


    public Person getBookOwner(Book book) {
        return jdbcTemplate.query("SELECT person.* FROM person LEFT JOIN book ON person.id = book.person_id WHERE book.id = ?", new BeanPropertyRowMapper<>(Person.class), book.getId())
                .stream()
                .findAny()
                .orElse(null);
    }


    public void assignBookToPerson(Book book, Person person) {
        jdbcTemplate.update("UPDATE book SET person_id = ? WHERE id = ?", person.getId(), book.getId());
    }


    public void returnBook(Book book) {
        jdbcTemplate.update("UPDATE book SET person_id = NULL WHERE id = ?", book.getId());
    }


}
