package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Person;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryService {

    private final BookRepository bookRepository;
    private final PeopleRepository peopleRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository, PeopleRepository peopleRepository) {
        this.bookRepository = bookRepository;
        this.peopleRepository = peopleRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public List<Person> getAllPeople() {
        return peopleRepository.findAll();
    }


    public List<Book> getBooksByPerson(Person person) {
        return bookRepository.findByOwner(person);
    }


    public Book getBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }


    public Person getBookOwner(Book book) {
        return book.getOwner();
    }


    public void assignBookToPerson(Book book, Person person) {
        book.setOwner(person);
        bookRepository.save(book);
    }


    public void returnBook(Book book) {
        book.setOwner(null);
        bookRepository.save(book);
    }


    public void saveBook(Book book) {
        bookRepository.save(book);
    }


    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }


    public void updateBook(int id, Book newBookData) {
        Book bookToUpdate = bookRepository.findById(id).orElse(null);

        if (bookToUpdate == null) {
            return;
        }

        bookToUpdate.setName(newBookData.getName());
        bookToUpdate.setAuthor(newBookData.getAuthor());
        bookToUpdate.setYear(newBookData.getYear());

        bookRepository.save(bookToUpdate);
    }


    public Person getPerson(int id) {
        return peopleRepository.findById(id).orElse(null);
    }


    public void savePerson(Person person) {
        peopleRepository.save(person);
    }


    public void updatePerson(int id, Person newPersonData) {
        Person personToUpdate = peopleRepository.findById(id).orElse(null);

        if (personToUpdate == null) {
            return;
        }

        personToUpdate.setName(newPersonData.getName());
        personToUpdate.setYear(newPersonData.getYear());

        peopleRepository.save(personToUpdate);
    }


    public void deletePerson(Person person) {
        peopleRepository.delete(person);
    }


    public List<Book> getAllBooks(boolean sortByYear, int page, int showPerPage) {
        if (sortByYear) {
            return bookRepository.findAll(PageRequest.of(page, showPerPage, Sort.by("year"))).getContent();
        }
        return bookRepository.findAll(PageRequest.of(page, showPerPage)).getContent();
    }


    public List<Book> getBooksBySearchQuery(String query) {
        if (query == null || query.length() == 0) {
            return null;
        }
        query = "%" + query;
        return bookRepository.findBookByNameIsLike(query);
    }

}
