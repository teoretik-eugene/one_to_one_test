package org.example;

import org.example.model.Person;
import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Principal principal = new Principal("Eugene", 20);
            School school = new School(1511, principal);

            principal.setSchool(school);

            session.persist(principal);
            session.persist(school);
            

            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
