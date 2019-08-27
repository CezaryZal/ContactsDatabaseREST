package com.CezaryZal.service;

import com.CezaryZal.dao.ContactDAO;
import com.CezaryZal.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Override
    @Transactional
    public List<Contact> getContacts() {
        return contactDAO.getContacts();
    }

    @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactDAO.saveContact(contact);
    }

    @Override
    @Transactional
    public Contact getContact(int id) {
        return contactDAO.getContact(id);
    }

    @Override
    @Transactional
    public void deleteContact(int id) {
        contactDAO.deleteContact(id);

    }

    @Override
    @Transactional
    public List<Contact> searchContacts(String searchName) {
        return contactDAO.searchContacts(searchName);
    }
}
