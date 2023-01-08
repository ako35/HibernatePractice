package com.tpe.criteriaapi;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration cfg=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Developer09.class);

        SessionFactory sf=cfg.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // id si 1 olan dev in ismini sezai karakoc olarak update ediniz.
//        Developer09 developer1= session.get(Developer09.class,1L);
//        developer1.setName("Sezai Karakoc");
//        session.update(developer1);

        // yukaridaki sorguyu hql ile yapiniz.
//        String hqlQuery2="from Developer09 d where d.id='1'";
//        Developer09 developer2= session.createQuery(hqlQuery2,Developer09.class).uniqueResult();
//        developer2.setName("Sezai Karakoc");
//        session.update(developer2);

//        String hqlQuery3="update Developer09 d set d.name='Sair Sezai Karakoc' where d.id=1";
//        int numRecord3 = session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println("numRecord"+numRecord3);

        // parametre kullanarak salary si 7000 den az olan devlerin salarysini 7850 yapiniz.
//        String hqlQuery4="update Developer09 set salary=7850 where salary=7000";
//        int numRecord4= session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println(numRecord4);

//        String hqlQuery5="update Developer09 set salary=:guncelSalary where salary<:eskiSalary";
//        Query query5=session.createQuery(hqlQuery5);
//
//        query5.setParameter("guncelSalary",7850);
//        query5.setParameter("eskiSalary",7000);
//
//        int guncellenenKayit= query5.executeUpdate();
//        System.out.println(guncellenenKayit);

        // criteriaAPI
        CriteriaBuilder cbuilder=session.getCriteriaBuilder(); // CriteriaQuery nesnesi olusturmak ve bazi methodlar icin
        CriteriaQuery<Developer09>cq=cbuilder.createQuery(Developer09.class);
        Root<Developer09>root=cq.from(Developer09.class); // classimizin tum datalarini tutan kaynak

        // ismi Cemal olanlari getiriniz.
//        cq.select(root).where(cbuilder.equal(root.get("name"),"Cemal"));
//        List<Developer09>result= session.createQuery(cq).getResultList();
//        result.forEach(System.out::println);

        // ismi Erdem veya salarysi 9000 den fazla olan developerlari getiriniz.
//        Predicate nameErdem=cbuilder.equal(root.get("name"),"Erdem");
//        Predicate salary9000Fazla=cbuilder.greaterThan(root.get("salary"),9000);
//        Predicate predicate=cbuilder.or(nameErdem,salary9000Fazla);
//
//        cq.select(root).where(predicate);
//        List<Developer09>result2= session.createQuery(cq).getResultList();
//        result2.forEach(System.out::println);

        // salary si 8000 olan developerlari getiriniz.
//        cq.select(root).where(cbuilder.equal(root.get("salary"),8000));
//        List<Developer09> resultList3=session.createQuery(cq).getResultList();
//        resultList3.forEach(System.out::println);

        // salary si 8000 den fazla olan developerlari getiriniz.
        cq.select(root).where(cbuilder.greaterThan(root.get("salary"),8000));
        List<Developer09>resultList4=session.createQuery(cq).getResultList();
        resultList4.forEach(System.out::println);




        tx.commit();
        session.close();
        sf.close();

    }

}
