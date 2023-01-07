package com.example.demo.controllers;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.PersonDAO;
import com.example.demo.models.Book;
import com.example.demo.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Book book = bookDAO.show(id);
        model.addAttribute("book", book);
        model.addAttribute("owner", bookDAO.getBookOwner(book));
        model.addAttribute("person", new Person());
        model.addAttribute("people", personDAO.index());
        return "books/show";
    }


    @PostMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("person") Person person) {
        Book book = bookDAO.show(id);
        bookDAO.assignBookToPerson(book, person);
        return "redirect:/books/" + id;

    }


    @PostMapping("/{id}/return")
    public String returnBook(@PathVariable("id") int id) {
        bookDAO.returnBook(bookDAO.show(id));
        return "redirect:/books/" + id;
    }


    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("book") Book book,
                          BindingResult bindingResult) {
        bookDAO.save(book);
        return "redirect:/books";
    }
}
