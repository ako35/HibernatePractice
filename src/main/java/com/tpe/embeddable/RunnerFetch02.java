package com.tpe.embeddable;

import com.tpe.annotations.Developer01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Developer02.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // id si 1 olan developerin tum bilgilerini yazdiriniz.
        Developer02 dev=session.get(Developer02.class,1L);
        System.out.println(dev);

//        Object result= session.createQuery("from Developer02 where id=1").uniqueResult();
//        System.out.println(result);

        // id=1 olan developerın sadece eğitim bilgilerini yazdırınız.
        Developer02 dev1=session.get(Developer02.class,1L);
        System.out.println(dev1.getEducation());

        tx.commit();
        sf.close();
        session.close();

    }

}
