package com.defaultid.myspringapp.repositories;

import com.defaultid.myspringapp.models.Message;
import com.defaultid.myspringapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> { }
