package com.defaultid.FirstSecurityApp.services;

import com.defaultid.FirstSecurityApp.models.Person;
import com.defaultid.FirstSecurityApp.repositories.PeopleRepository;
import com.defaultid.FirstSecurityApp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = peopleRepository.findByUsername(username);
        if (person == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new PersonDetails(person);
    }
}
