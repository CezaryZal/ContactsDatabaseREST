package com.CezaryZal.dao;

import com.CezaryZal.entity.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Contact> getContacts() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Contact> theQuery = currentSession.createQuery("from Contact order by lastName", Contact.class);
        List<Contact> contacts = theQuery.getResultList();

        return contacts;
    }

    @Override
    public void saveContact(Contact contact) {

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(contact);
    }

    @Override
    public Contact getContact(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Contact contact = currentSession.get(Contact.class, id);

        return contact;
    }

    @Override
    public void deleteContact(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Contact where id=:contactId");
        query.setParameter("contactId", id);

        query.executeUpdate();
    }

    @Override
    public List<Contact> searchContacts(String searchName) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = null;

        if (searchName != null && searchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            query = currentSession.createQuery("from Contact where lower(firstName) like :name or lower(lastName) like :name", Contact.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            query =currentSession.createQuery("from Contact", Contact.class);
        }

        // execute query and get result list
        List<Contact> contacts = query.getResultList();

        System.out.println("Lista wybrana" + Arrays.toString(contacts.toArray()));
        return contacts;
    }
}
