package com.CezaryZal.rest;

import com.CezaryZal.entity.Contact;
import com.CezaryZal.rest.Exception.ContactNotFoundException;
import com.CezaryZal.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/contact/{contactId}")
    public Contact getContact (@PathVariable int contactId){
        Contact contact = contactService.getContact(contactId);
        if (contact == null){
            throw new ContactNotFoundException("Contact id not found - " + contactId);
        }
        return contact;
    }

    @PostMapping("contact")
    public Contact addContact (@RequestBody Contact contact){
        contact.setId(0);
        contactService.saveContact(contact);

        return contact;
    }

    @PutMapping("/contact")
    public Contact updateContact (@RequestBody Contact contact){
        contactService.saveContact(contact);

        return contact;
    }

    @DeleteMapping("/contact/{contactId}")
    public String deleteContact(@PathVariable int contactId){
        Contact contact = contactService.getContact(contactId);
        if (contact == null){
            throw new ContactNotFoundException("Contact id not found - " + contactId);
        }
        contactService.deleteContact(contactId);

        return "Delete contact id - " + contactId;
    }



}
