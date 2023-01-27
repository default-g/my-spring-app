package com.example.demo.repositories;

import com.example.demo.models.Book;
import com.example.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    public List<Book> findByOwner(Person person);
    public List<Book> findBookByNameIsLike(String name);
}

