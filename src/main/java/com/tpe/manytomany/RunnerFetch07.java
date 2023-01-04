package com.tpe.manytomany;

import com.tpe.manytomany.Developer07;
import com.tpe.manytomany.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Set;

public class RunnerFetch07 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer07.class).addAnnotatedClass(Project.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // id si 11 olan projede calisan developer bilgilerini getiriniz.
//        Set<Developer07> resultList =session.get(Project.class,11L).getDevelopers();
//        resultList.forEach(System.out::println);

        // id si 1 olan developerin calistigi proje bilgilerini getiriniz.
        Set<Project>resultList2=session.get(Developer07.class,1L).getProjects();
        resultList2.forEach(System.out::println);



        tx.commit();
        session.close();
        sf.close();

    }

}
