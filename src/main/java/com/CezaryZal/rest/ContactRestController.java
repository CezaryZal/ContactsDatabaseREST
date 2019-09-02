package com.CezaryZal.rest;

import com.CezaryZal.entity.Contact;
import com.CezaryZal.rest.Exception.ContactNotFoundException;
import com.CezaryZal.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getContacts (){
        return contactService.getContacts();
    }

    @GetMapping("/contacts/{contactId}")
    public Contact getContact (@PathVariable int contactId){
        Contact contact = contactService.getContact(contactId);
        if (contact == null){
            throw new ContactNotFoundException("Contact id not found - " + contactId);
        }

        return contact;
    }

}
