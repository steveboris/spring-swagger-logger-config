package com.titus.springswaggerlogger.controller;


import com.titus.springswaggerlogger.models.Contact;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class DummyResource {

    // logging
    // This follow line is to make the logging possible
    Logger logger = LoggerFactory.getLogger(DummyResource.class);

    ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<String, Contact>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds Contact by id", notes="Provide an id to look up specific contact from the address book",
            response= Contact.class) // This annotation help to print more detail for the documentation
    public Contact getContact(@PathVariable String id) {
        return contacts.get(id);
    }

    @GetMapping("/")
    public ConcurrentMap<String, Contact> getAllContacts() {
        return contacts;
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        logger.info("A new contact successfully added { " + contact.toString() +" }");
        return contact;
    }

    @GetMapping("/logging")
    public String logging() {
        // By default this first line will not work.
        // We must first add some properties in the properties file
        logger.trace("logging method accessed");
        return "<h1>Logging has been successfully configured</h1>";
    }
}
