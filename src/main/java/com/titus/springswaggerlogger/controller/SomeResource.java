package com.titus.springswaggerlogger.controller;


import com.titus.springswaggerlogger.models.Contact;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class SomeResource {

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds Contact by id", notes="Provide an id to look up specific contact from the address book",
            response= Contact.class) // Help to print more detail in the documentation
    public Contact getContact(@PathVariable String id) {
        return contacts.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts() {
        return (List)contacts;
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }

    // logging
    // To be able to log this method
    Logger logger = LoggerFactory.getLogger(SomeResource.class);

    @GetMapping("/logging")
    public String logging() {
        logger.trace("logging method accessed"); // By default this line will not work. To make it possible we have to add a property in the properties files
        return "<h1>Logging has been successfully configured</h1>";
    }
}
