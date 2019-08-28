package com.CezaryZal.testDB;

import com.CezaryZal.entity.Contact;
import com.CezaryZal.service.ContactService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;

public class ConnectDB {
    public static void main(String[] args) {

        final String JDB_URL = "jdbc:mysql://localhost:3306/web_contacts?useSSL=false&serverTimezone=UTC";
        final String USENAME = "hbstudent";
        final String PASSWORD = "HBstudent!123";

        try (Connection connection = DriverManager.getConnection(JDB_URL, USENAME, PASSWORD)) {

            System.out.println("Test connect");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contact");

//            ContactService contactService;
//            List<Contact> contacts = contactService.getContacts();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void displayContacts(List<Contact> theContact) {
        for (Contact tempContact : theContact) {
            System.out.println(tempContact);
        }
    }

}
