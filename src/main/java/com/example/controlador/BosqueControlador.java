package com.example.controlador;

import com.example.model.Bosque;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class BosqueControlador {

    public void guardarBosque(Bosque bosque){
        Session session = null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            session=factory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(bosque);
            tx.commit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
