package com.example.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.model.Mago;

public class MagoControlador {
    public void guardarMago(Mago mago){
        Session session;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            session=factory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
