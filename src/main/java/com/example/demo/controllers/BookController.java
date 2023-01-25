package com.example.demo.controllers;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.PersonDAO;
import com.example.demo.models.Book;
import com.example.demo.models.Person;
import com.example.demo.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final LibraryService libraryService;

    @Autowired
    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "books/index";
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Book book = libraryService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("owner", book.getOwner());
        model.addAttribute("person", new Person());
        model.addAttribute("people", libraryService.getAllPeople());
        return "books/show";
    }


    @PostMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("person") Person person) {
        Book book = libraryService.getBook(id);
        libraryService.assignBookToPerson(book, person);
        return "redirect:/books/" + id;

    }


    @PostMapping("/{id}/return")
    public String returnBook(@PathVariable("id") int id) {
        libraryService.returnBook(libraryService.getBook(id));
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
        libraryService.saveBook(book);
        return "redirect:/books";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        libraryService.deleteBook(libraryService.getBook(id));
        return "redirect:/books";
    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", libraryService.getBook(id));
        return "books/edit";
    }


    @PatchMapping("/{id}")
    public String edit(@PathVariable("id") int id,
                       @ModelAttribute("book") Book book,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

        }

        libraryService.updateBook(id, book);
        return "redirect:/books/" + id;
    }
}
