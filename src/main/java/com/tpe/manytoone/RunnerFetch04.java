package com.tpe.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer04.class).addAnnotatedClass(Company.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // id si 2 olan developerin calistigi company bilgilerini getiriniz.
//        Developer04 developer1=session.get(Developer04.class,2L);
//        System.out.println(developer1.getCompany());

        // tum developerlarin ismini ve calistigi company ismini goruntuleyiniz.

//        String sqlQuery3="select d.name,c.companyname from t_developer04 d inner join company c on d.company_id=c.id";
//        List<Object[]>resultList3=session.createSQLQuery(sqlQuery3).getResultList();

//        for (Object[] o:resultList3){
//            System.out.println(Arrays.toString(o));
//        }

//        resultList3.forEach(t-> System.out.println(Arrays.toString(t)));

        // google da calisan developer larin ismini ve branch ini goruntuleyiniz.
        String sqlQuery4="select name, branch from t_developer04 d inner join company c on d.company_id=c.id where c.companyname='Google'";
        List<Object[]> resultList4=session.createSQLQuery(sqlQuery4).getResultList();
        resultList4.forEach(t-> System.out.println(Arrays.toString(t)));


        tx.commit();
        session.close();
        sf.close();

    }

}
