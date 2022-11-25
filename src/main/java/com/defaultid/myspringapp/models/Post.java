package com.defaultid.myspringapp.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.ContentType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Message mainMessage;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> subMessages;


    public Post(Message message) {
        this.mainMessage = message;
    }

    public Post() {
        this.mainMessage = null;
    }

    public Message getMainMessage() {
        return this.mainMessage;
    }

    public List<Message> getSubMessages() {
        return this.subMessages;
    }

    public void addSubMessage(Message message) {
        if (this.subMessages == null) {
            this.subMessages = new ArrayList<>();
        }
        this.subMessages.add(message);
    }
}
