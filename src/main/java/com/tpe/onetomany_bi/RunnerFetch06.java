package com.tpe.onetomany_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer06.class).addAnnotatedClass(Company3.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // Amazonda calisan developer bilgilerini getiriniz.
//        String hqlQuery="from Developer06 d where d.company.companyname='Amazon'";
//        List<Developer06>resultList=session.createQuery(hqlQuery,Developer06.class).getResultList();
//        resultList.forEach(System.out::println);
//
//        String hql="from Company3 c where c.companyname='Amazon'";
//        Company3 companyA=session.createQuery(hql,Company3.class).uniqueResult();
//        companyA.getDevs().forEach(System.out::println);

        // Gandalf in calistigi company bilgilerini getiriniz.
//        String hqlQuery2="from Developer06 d where d.name='Gandalf'";
//        Developer06 dev=session.createQuery(hqlQuery2,Developer06.class).uniqueResult();
//        System.out.println(dev.getCompany());

        // id si 22 olan company nin dev listesinden id si 3 olan developer i siliniz.
//        Developer06 dev3=session.get(Developer06.class,3L);
//        Company3 company=session.get(Company3.class,22L);
//        company.getDevs().remove(dev3);
//        System.out.println("Amazon dev listesi:"+company.getDevs());

        // id si 11 olan company yi sil.
        Company3 company2=session.get(Company3.class,11L);
        session.delete(company2);

        // orphanRemoval true ise table dan da siliyor.
        // cascadetypeALL da sadece listeden cikariyor.

        tx.commit();
        session.close();
        sf.close();

    }

}
