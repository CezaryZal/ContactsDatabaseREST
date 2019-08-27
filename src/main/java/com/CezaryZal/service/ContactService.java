package com.CezaryZal.service;


import com.CezaryZal.entity.Contact;

import java.util.List;

public interface ContactService {

    void saveContact(Contact contact);

    List<Contact> getContacts();

    public Contact getContact(int id);

    void deleteContact(int id);

    List<Contact> searchContacts(String searchName);
}
