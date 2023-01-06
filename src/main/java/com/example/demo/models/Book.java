package com.example.demo.models;

public class Book {

    private int id;
    private String name;
    private String author;
    private int year;
    private Person person;


    public Book() {}


    public Book(int id, String name, String author, int year, Person person) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public Person getPerson() {
        return person;
    }


    public void setPerson(Person person) {
        this.person = person;
    }

}
