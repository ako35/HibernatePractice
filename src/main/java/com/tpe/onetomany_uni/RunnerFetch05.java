package com.tpe.onetomany_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer05.class).addAnnotatedClass(Company2.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // Amazonda calisan bilgilerini getiriniz.

//        String hql="from Company2 c where c.companyname='Amazon'";
//        Company2 company=session.createQuery(hql,Company2.class).uniqueResult();
//        System.out.println(company.getDevs());

        String hql2="select c.devs from Company2 c where c.companyname='Amazon'";
        List<Object>resultList2=session.createQuery(hql2).getResultList();
        resultList2.forEach(System.out::println);


        tx.commit();
        session.close();
        sf.close();

    }

}
