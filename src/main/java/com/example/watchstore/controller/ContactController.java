package com.example.watchstore.controller;

import com.example.watchstore.model.Contact;
import com.example.watchstore.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }
}
