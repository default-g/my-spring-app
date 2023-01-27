package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private int year;

    @Column(name = "date_taken")
    private Date dateTaken;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Book() {}

    public Book(String name, String author, int year) {
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


    public Person getOwner() {
        return owner;
    }


    public void setOwner(Person owner) {
        if (owner == null) {
            dateTaken = null;
        } else {
            dateTaken = new Date();
        }
        this.owner = owner;
    }


    @Transient
    public boolean isExpired() {

        if (dateTaken == null) {
            return false;
        }

        long timeDiffInMilliseconds = Math.abs(dateTaken.getTime() - (new Date()).getTime());
        long timeDiffInDays = TimeUnit.DAYS.convert(timeDiffInMilliseconds, TimeUnit.MILLISECONDS);

        return timeDiffInDays >= 10;
    }


}
