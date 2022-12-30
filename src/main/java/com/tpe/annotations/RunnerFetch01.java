package com.tpe.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer01.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Developer01 dev1=session.get(Developer01.class,1);
        System.out.println(dev1);

        // sql ile tum datayi cekiniz.
        String sqlQuery1="select * from t_developer01";
        List<Object[]>resultList1=session.createSQLQuery(sqlQuery1).getResultList();
        for (Object[] object:resultList1){
            System.out.println(Arrays.toString(object));
        }

        // hql ile tum datayi cekiniz.
        String hqlQuery2="from Developer01";
        List<Developer01>resultList2= session.createQuery(hqlQuery2, Developer01.class).getResultList();
        for (Developer01 developer01:resultList2){
            System.out.println(developer01);
        }

        String hqlQuery3="from Developer01";
        List<Object>resultList3=session.createQuery(hqlQuery3).getResultList();
        for (Object object:resultList3){
            System.out.println(object);
        }

        // hql ile ismi shrek olan datayi cekiniz.
        String hqlQuery4="from Developer01 where name='Shrek'";
        List<Developer01>resultList4=session.createQuery(hqlQuery4, Developer01.class).getResultList();
        for (Developer01 developer01:resultList4){
            System.out.println(developer01);
        }

        // hql ile emaili jack@gmail.com olan datayi cekiniz.
        String hqlQuery5="from Developer01 where email='jack@mail.com'";
        Developer01 developer01=session.createQuery(hqlQuery5, Developer01.class).uniqueResult();
        System.out.println(developer01);

        // hql ile branch i backend olan datanin ismini getiriniz.
        String hqlQuery6="from Developer01 where branch='backend'";
        List<Developer01>resultList6= session.createQuery(hqlQuery6, Developer01.class).getResultList();
        for (Developer01 developer:resultList6){
            System.out.println(developer.getName());
        }

        tx.commit();
        sf.close();
        session.close();

    }

}
