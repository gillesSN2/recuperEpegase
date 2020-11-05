package com.epegase.systeme.dao;



import com.epegase.systeme.classe.PegEnvoieMail;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PegEnvoieMailDao implements Serializable {
  private UtilInitHibernate utilInitHibernate;
  
  public PegEnvoieMailDao(UtilInitHibernate paramUtilInitHibernate) {
    this.utilInitHibernate = paramUtilInitHibernate;
  }
  
  public PegEnvoieMail insert(PegEnvoieMail paramPegEnvoieMail) throws HibernateException, NamingException {
    Session session = this.utilInitHibernate.getSysteme();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      session.save(paramPegEnvoieMail);
      transaction.commit();
    } catch (HibernateException hibernateException) {
      if (transaction != null)
        transaction.rollback(); 
      throw hibernateException;
    } finally {
      this.utilInitHibernate.closeSession();
    } 
    return paramPegEnvoieMail;
  }
  
  public PegEnvoieMail modif(PegEnvoieMail paramPegEnvoieMail) throws HibernateException, NamingException {
    Session session = this.utilInitHibernate.getSysteme();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      session.update(paramPegEnvoieMail);
      transaction.commit();
    } catch (HibernateException hibernateException) {
      if (transaction != null)
        transaction.rollback(); 
      throw hibernateException;
    } finally {
      this.utilInitHibernate.closeSession();
    } 
    return paramPegEnvoieMail;
  }
  
  public void delete(PegEnvoieMail paramPegEnvoieMail) throws HibernateException, NamingException {
    Session session = this.utilInitHibernate.getSysteme();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      session.delete(paramPegEnvoieMail);
      transaction.commit();
    } catch (HibernateException hibernateException) {
      if (transaction != null)
        transaction.rollback(); 
      throw hibernateException;
    } finally {
      this.utilInitHibernate.closeSession();
    } 
  }
  
  public List<PegEnvoieMail> rechecheGlobale() throws HibernateException, NamingException {
    ArrayList arrayList = new ArrayList();
    Session session = this.utilInitHibernate.getSysteme();
    Query query = session.createQuery("from PegEnvoieMail order by pegmaiDateCreat desc");
    List<PegEnvoieMail> list = query.list();
    this.utilInitHibernate.closeSession();
    return list;
  }
  
  public long rechecheNext() throws HibernateException, NamingException {
    Session session = this.utilInitHibernate.getSysteme();
    Query query = session.createQuery("from PegEnvoieMail order by pegmaiNum desc").setMaxResults(1);
    ArrayList arrayList = new ArrayList();
    long l = 0L;
    List<PegEnvoieMail> list = query.list();
    if (list.size() != 0) {
      l = ((PegEnvoieMail)list.get(0)).getPegmaiId() + 1L;
    } else {
      l = 1L;
    } 
    this.utilInitHibernate.closeSession();
    return l;
  }
}

