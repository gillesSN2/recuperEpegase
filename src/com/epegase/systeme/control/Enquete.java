package com.epegase.systeme.control;

import com.epegase.systeme.classe.PegEnquete;
import com.epegase.systeme.dao.PegEnqueteDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class Enquete implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private PegEnquete pegEnquete = new PegEnquete();
   private PegEnqueteDao pegEnqueteDao;
   private String urlClient;

   public Enquete() {
      this.pegEnquete = new PegEnquete();
   }

   public String creationEnquete() throws HibernateException, NamingException {
      int var1 = this.pegEnquete.getPegenq00Assistance() + this.pegEnquete.getPegenq00Convivialite() + this.pegEnquete.getPegenq00Ergonomie() + this.pegEnquete.getPegenq00Fonctionnel();
      int var2 = this.pegEnquete.getPegenq01Convivialite() + this.pegEnquete.getPegenq01Ergonomie() + this.pegEnquete.getPegenq01Fonctionnel();
      int var3 = this.pegEnquete.getPegenq02Convivialite() + this.pegEnquete.getPegenq02Ergonomie() + this.pegEnquete.getPegenq02Fonctionnel();
      int var4 = this.pegEnquete.getPegenq03Convivialite() + this.pegEnquete.getPegenq03Ergonomie() + this.pegEnquete.getPegenq03Fonctionnel();
      int var5 = this.pegEnquete.getPegenq04Convivialite() + this.pegEnquete.getPegenq04Ergonomie() + this.pegEnquete.getPegenq04Fonctionnel();
      int var6 = this.pegEnquete.getPegenq05Convivialite() + this.pegEnquete.getPegenq05Ergonomie() + this.pegEnquete.getPegenq05Fonctionnel();
      int var7 = this.pegEnquete.getPegenq06Convivialite() + this.pegEnquete.getPegenq06Ergonomie() + this.pegEnquete.getPegenq06Fonctionnel();
      int var8 = this.pegEnquete.getPegenq07Convivialite() + this.pegEnquete.getPegenq07Ergonomie() + this.pegEnquete.getPegenq07Fonctionnel();
      int var9 = this.pegEnquete.getPegenq08Convivialite() + this.pegEnquete.getPegenq08Ergonomie() + this.pegEnquete.getPegenq08Fonctionnel();
      int var10 = this.pegEnquete.getPegenq09Convivialite() + this.pegEnquete.getPegenq09Ergonomie() + this.pegEnquete.getPegenq09Fonctionnel();
      int var11 = this.pegEnquete.getPegenq10Convivialite() + this.pegEnquete.getPegenq10Ergonomie() + this.pegEnquete.getPegenq10Fonctionnel();
      int var12 = this.pegEnquete.getPegenq11Convivialite() + this.pegEnquete.getPegenq11Ergonomie() + this.pegEnquete.getPegenq11Fonctionnel();
      int var13 = this.pegEnquete.getPegenq12Convivialite() + this.pegEnquete.getPegenq12Ergonomie() + this.pegEnquete.getPegenq12Fonctionnel();
      if (var1 + var2 + var3 + var4 + var5 + var6 + var7 + var8 + var9 + var10 + var11 + var12 + var13 != 0) {
         this.utilInitHibernate = new UtilInitHibernate();
         this.pegEnqueteDao = new PegEnqueteDao(this.utilInitHibernate);
         this.pegEnquete.setPegenqUrl(this.urlClient);
         this.pegEnquete.setPegenqDate(new Date());
         this.pegEnqueteDao.insert(this.pegEnquete);
      }

      return "retourEnquete";
   }

   public String annulerEnquete() {
      return "retourEnquete";
   }

   public void analyseEnquete() {
   }

   public PegEnquete getPegEnquete() {
      return this.pegEnquete;
   }

   public void setPegEnquete(PegEnquete var1) {
      this.pegEnquete = var1;
   }

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getUrlClient() {
      return this.urlClient;
   }

   public void setUrlClient(String var1) {
      this.urlClient = var1;
   }
}
