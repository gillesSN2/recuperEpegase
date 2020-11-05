package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class DepotAchatsDao implements Serializable {
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public DepotAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public DepotAchats insert(DepotAchats var1, Session var2) {
      var1.setDpoDateCreation(new Date());
      var2.save(var1);
      return var1;
   }

   public DepotAchats modifDepot(DepotAchats var1, Session var2) {
      var1.setDpoDateModif(new Date());
      var2.update(var1);
      return var1;
   }

   public String delDepot(DepotAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from DepotAchats where dpoId =" + var1.getDpoId());
      var3.executeUpdate();
      return null;
   }

   public List selectAllDepot(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from DepotAchats order by dpoCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectAllDepotActif(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var2 = true;
      }

      List var3 = var1.createQuery("from DepotAchats where dpoInactif=0 order by dpoCode").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List selectActifDepot(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var3 = true;
      }

      Query var4 = null;
      var4 = this.requeteDepot(var1, var4, var2);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectActifDepotItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var3 = true;
      }

      Query var4 = null;
      var4 = this.requeteDepot(var1, var4, var2);
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      ArrayList var6 = new ArrayList();
      if (((List)var5).size() != 0) {
         new DepotAchats();

         for(int var8 = 0; var8 < ((List)var5).size(); ++var8) {
            DepotAchats var7 = (DepotAchats)((List)var5).get(var8);
            if (var7.getDpoCode() != null && !var7.getDpoCode().isEmpty()) {
               var6.add(new SelectItem(var7.getDpoCode() + ":" + var7.getDpoLibelle()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectActifDepotUsersItems(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var4 = true;
      }

      Query var5 = null;
      var5 = this.requeteDepot(var1, var5, var3);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         ArrayList var8 = new ArrayList();
         int var10;
         if (!var2.contains(",")) {
            var8.add(var2);
         } else {
            String[] var9 = var2.split(",");
            var10 = var9.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               var8.add(var9[var11]);
            }
         }

         new DepotAchats();

         for(var10 = 0; var10 < ((List)var6).size(); ++var10) {
            DepotAchats var13 = (DepotAchats)((List)var6).get(var10);
            boolean var14 = false;
            if (var13.getDpoCode() != null && !var13.getDpoCode().isEmpty()) {
               var14 = false;

               for(int var12 = 0; var12 < var8.size(); ++var12) {
                  if (var13.getDpoCode().equals(((String)var8.get(var12)).toString())) {
                     var14 = true;
                     break;
                  }
               }

               if (var14) {
                  var7.add(new SelectItem(var13.getDpoCode() + ":" + var13.getDpoLibelle()));
               }
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectActifDepotItems(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var4 = true;
      }

      Query var5 = null;
      var5 = this.requeteDepotAvecService(var1, var2, var5, var3);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         new DepotAchats();

         for(int var9 = 0; var9 < ((List)var6).size(); ++var9) {
            DepotAchats var8 = (DepotAchats)((List)var6).get(var9);
            if (var8.getDpoCode() != null && !var8.getDpoCode().isEmpty()) {
               var7.add(new SelectItem(var8.getDpoCode() + ":" + var8.getDpoLibelle()));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectActifDepotUsersItems(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var5 = true;
      }

      Query var6 = null;
      var6 = this.requeteDepotAvecService(var1, var2, var6, var4);
      Object var7 = new ArrayList();
      if (var6.list() != null) {
         var7 = var6.list();
      }

      ArrayList var8 = new ArrayList();
      if (((List)var7).size() != 0) {
         ArrayList var9 = new ArrayList();
         int var11;
         if (!var3.contains(",")) {
            var9.add(var3);
         } else {
            String[] var10 = var3.split(",");
            var11 = var10.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               var9.add(var10[var12]);
            }
         }

         new DepotAchats();

         for(var11 = 0; var11 < ((List)var7).size(); ++var11) {
            DepotAchats var14 = (DepotAchats)((List)var7).get(var11);
            boolean var15 = false;
            if (var14.getDpoCode() != null && !var14.getDpoCode().isEmpty()) {
               var15 = false;

               for(int var13 = 0; var13 < var9.size(); ++var13) {
                  if (var14.getDpoCode().equals(((String)var9.get(var13)).toString())) {
                     var15 = true;
                     break;
                  }
               }

               if (var15) {
                  var8.add(new SelectItem(var14.getDpoCode() + ":" + var14.getDpoLibelle()));
               }
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List selectActifDepotCodeItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var3 = true;
      }

      Query var4 = null;
      var4 = this.requeteDepot(var1, var4, var2);
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      ArrayList var6 = new ArrayList();
      if (((List)var5).size() != 0) {
         new DepotAchats();

         for(int var8 = 0; var8 < ((List)var5).size(); ++var8) {
            DepotAchats var7 = (DepotAchats)((List)var5).get(var8);
            if (var7.getDpoCode() != null && !var7.getDpoCode().isEmpty()) {
               var6.add(new SelectItem(var7.getDpoCode(), var7.getDpoCode() + ":" + var7.getDpoLibelle()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectActifDepotUsersCodeItems(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var4 = true;
      }

      Query var5 = null;
      var5 = this.requeteDepot(var1, var5, var3);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         ArrayList var8 = new ArrayList();
         int var10;
         if (!var2.contains(",")) {
            var8.add(var2);
         } else {
            String[] var9 = var2.split(",");
            var10 = var9.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               var8.add(var9[var11]);
            }
         }

         new DepotAchats();

         for(var10 = 0; var10 < ((List)var6).size(); ++var10) {
            DepotAchats var13 = (DepotAchats)((List)var6).get(var10);
            boolean var14 = false;
            if (var13.getDpoCode() != null && !var13.getDpoCode().isEmpty()) {
               var14 = false;

               for(int var12 = 0; var12 < var8.size(); ++var12) {
                  if (var13.getDpoCode().equals(((String)var8.get(var12)).toString())) {
                     var14 = true;
                     break;
                  }
               }

               if (var14) {
                  var7.add(new SelectItem(var13.getDpoCode(), var13.getDpoCode() + ":" + var13.getDpoLibelle()));
               }
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectActifDepotCodeItems(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var4 = true;
      }

      Query var5 = null;
      var5 = this.requeteDepotAvecService(var1, var2, var5, var3);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         new DepotAchats();

         for(int var9 = 0; var9 < ((List)var6).size(); ++var9) {
            DepotAchats var8 = (DepotAchats)((List)var6).get(var9);
            if (var8.getDpoCode() != null && !var8.getDpoCode().isEmpty()) {
               var7.add(new SelectItem(var8.getDpoCode(), var8.getDpoCode() + ":" + var8.getDpoLibelle()));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectActifDepotUsersCodeItems(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var5 = true;
      }

      Query var6 = null;
      var6 = this.requeteDepotAvecService(var1, var2, var6, var4);
      Object var7 = new ArrayList();
      if (var6.list() != null) {
         var7 = var6.list();
      }

      ArrayList var8 = new ArrayList();
      if (((List)var7).size() != 0) {
         ArrayList var9 = new ArrayList();
         int var11;
         if (!var3.contains(",")) {
            var9.add(var3);
         } else {
            String[] var10 = var3.split(",");
            var11 = var10.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               var9.add(var10[var12]);
            }
         }

         new DepotAchats();

         for(var11 = 0; var11 < ((List)var7).size(); ++var11) {
            DepotAchats var14 = (DepotAchats)((List)var7).get(var11);
            boolean var15 = false;
            if (var14.getDpoCode() != null && !var14.getDpoCode().isEmpty()) {
               var15 = false;

               for(int var13 = 0; var13 < var9.size(); ++var13) {
                  if (var14.getDpoCode().equals(((String)var9.get(var13)).toString())) {
                     var15 = true;
                     break;
                  }
               }

               if (var15) {
                  var8.add(new SelectItem(var14.getDpoCode(), var14.getDpoCode() + ":" + var14.getDpoLibelle()));
               }
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List selectActifDepotSansServiceItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var3 = true;
      }

      Query var4 = null;
      var4 = this.requeteDepotSansService(var1, var4, var2);
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      ArrayList var6 = new ArrayList();
      if (((List)var5).size() != 0) {
         new DepotAchats();

         for(int var8 = 0; var8 < ((List)var5).size(); ++var8) {
            DepotAchats var7 = (DepotAchats)((List)var5).get(var8);
            if (var7.getDpoCode() != null && !var7.getDpoCode().isEmpty()) {
               var6.add(new SelectItem(var7.getDpoCode(), var7.getDpoCode() + ":" + var7.getDpoLibelle()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectActifDepotByServiceItems(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var4 = true;
      }

      Query var5 = null;
      var5 = this.requeteDepotAvecService(var1, var2, var5, var3);
      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      if (((List)var6).size() != 0) {
         new DepotAchats();

         for(int var9 = 0; var9 < ((List)var6).size(); ++var9) {
            DepotAchats var8 = (DepotAchats)((List)var6).get(var9);
            if (var8.getDpoCode() != null && !var8.getDpoCode().isEmpty()) {
               var7.add(new SelectItem(var8.getDpoCode(), var8.getDpoCode() + ":" + var8.getDpoLibelle()));
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var3 = true;
      }

      boolean var4 = false;
      Query var5 = var2.createQuery("from DepotAchats where dpoCode=:cod ").setParameter("cod", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public DepotAchats trouveDepot(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var3 = true;
      }

      Query var4 = var2.createQuery("from DepotAchats where dpoCode=:val").setParameter("val", var1).setMaxResults(1);
      DepotAchats var5 = (DepotAchats)var4.uniqueResult();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public String trouveDepotDechet(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "DepotAchats");
         var2 = true;
      }

      Query var3 = var1.createQuery("from DepotAchats where dpoType=3").setMaxResults(1);
      DepotAchats var4 = (DepotAchats)var3.uniqueResult();
      String var5 = "";
      if (var4 != null) {
         var5 = var4.getDpoCode();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Query requeteDepot(int var1, Query var2, Session var3) {
      if (var1 == 13) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoReception=1 order by dpoCode");
      } else if (var1 == 14) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoRetourAch=1 order by dpoCode");
      } else if (var1 == 23) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoLivraison=1 order by dpoCode");
      } else if (var1 == 24) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoRetourVent=1 order by dpoCode");
      } else if (var1 == 28) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoMobileVent=1 order by dpoCode");
      } else if (var1 == 30) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoInventaire=1 order by dpoCode");
      } else if (var1 == 31) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoBonEntree=1 order by dpoCode");
      } else if (var1 == 32) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoBonSortie=1 order by dpoCode");
      } else if (var1 == 33) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoCession=1 order by dpoCode");
      } else if (var1 == 34) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoFabrication=1 order by dpoCode");
      } else if (var1 == 35) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoReachmin=1 order by dpoCode");
      } else if (var1 == 45) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoCarburant=1 order by dpoCode");
      } else if (var1 == 73) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoPharmacie=1 order by dpoCode");
      } else {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 group by dpoCode order by dpoCode");
      }

      return var2;
   }

   public Query requeteDepotSansService(int var1, Query var2, Session var3) {
      if (var1 == 13) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoReception=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 14) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoRetourAch=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 23) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoLivraison=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 24) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoRetourVent=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 28) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoMobileVent=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 30) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoInventaire=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 31) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoBonEntree=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 32) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoBonSortie=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 33) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoCession=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 34) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoFabrication=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 35) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoReachmin=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 45) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoCarburant=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else if (var1 == 73) {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and dpoPharmacie=1 and (dpoService is null or dpoService='') order by dpoCode");
      } else {
         var2 = var3.createQuery("from DepotAchats where dpoInactif=0 and (dpoService is null or dpoService='') order by dpoCode");
      }

      return var2;
   }

   public Query requeteDepotAvecService(int var1, String var2, Query var3, Session var4) {
      String var5 = "";
      if (var2.contains(":")) {
         String[] var6 = var2.split(":");
         var5 = var6[0];
      } else if (var2.contains(",")) {
         var5 = var2;
      } else {
         var5 = var2;
      }

      if (var1 == 13) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoReception=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 14) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoRetourAch=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 23) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoLivraison=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 24) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoRetourVent=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 28) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoMobileVent=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 30) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoInventaire=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 31) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoBonEntree=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 32) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoBonSortie=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 33) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoCession=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 34) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoFabrication=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 35) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoReachmin=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 45) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoCarburant=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else if (var1 == 73) {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoPharmacie=1 and dpoService like '%" + var5 + "%' order by dpoCode");
      } else {
         var3 = var4.createQuery("from DepotAchats where dpoInactif=0 and dpoService like '%" + var5 + "%' order by dpoCode");
      }

      return var3;
   }
}
