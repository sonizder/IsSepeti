/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ispt.hib.core;


import com.ispt.users.Users;
import com.ispt.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author s1r
 */
public class HibCrud<T> extends HibCrudAbst<T> {

    @Override
    public boolean create(T domainObj) {
        boolean create=false;
        try {

            Session newSession = HibernateUtil.getSessionFactory().openSession();
            Transaction txT = newSession.beginTransaction();
            newSession.save(domainObj);
            System.out.println("Kayit basarili");
            txT.commit();
            newSession.close();
            create=true;
        } catch (Exception e) {
            create= false;
            e.printStackTrace();
        }
        return create;
    }

    @Override
    public int delete(String sorgu) {

        Session newsession = HibernateUtil.getSessionFactory().openSession();
        Transaction txT = newsession.beginTransaction();
        Query query = newsession.createQuery(sorgu);

        int result = query.executeUpdate();
        txT.commit();
        newsession.close();
        return result;
    }

    public void delete2() {
        Session newsession = HibernateUtil.getSessionFactory().openSession();
        Transaction txT = newsession.beginTransaction();
        int userId = 1234;
        Users user = (Users) newsession.get(Users.class, new Long(userId));
        newsession.delete(user);
        txT.commit();
        newsession.close();
    }

    public void update(int param)  {
        Session newsession = null;
        Transaction txT = null;
        try {
            newsession = HibernateUtil.getSessionFactory().openSession();
            txT = newsession.beginTransaction();            
            Users user = (Users) newsession.get(Users.class, param);
            if (user != null) {
                user.setIsim("soner");
                newsession.update(user);
                txT.commit();
            }else{
                System.out.println("Kayit Bulunamadı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        newsession.close();

    }

    @Override
    public List read(String sorgu) {

        Session newsession = HibernateUtil.getSessionFactory().openSession();
        Transaction txT = newsession.beginTransaction();
        List resultList = newsession.createQuery(sorgu).list();
//        newsession.getTransaction().commit();
        txT.commit();
        return resultList;

    }
}

/*
 * catch (Exception e) { if (tx!=null) tx.rollback(); throw e; } finally {
 * sess.close(); }
 */
