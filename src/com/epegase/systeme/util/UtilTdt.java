package com.epegase.systeme.util;

import com.epegase.systeme.classe.BienBail;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetTable;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilTdt implements Serializable {
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();

   public List rubriqueUser(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "");
      String var4 = "cmm_users";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("usr_login") && !var9.contains("usr_pw") && !var9.contains("usr_last_log") && !var9.contains("usr_first_log") && !var9.contains("usr_photo") && !var9.contains("usr_signature") && !var9.contains("usr_jrx_interdit") && !var9.contains("usr_cpt_interdit") && !var9.equals("usr_acces_mail") && !var9.equals("usr_nb_log") && !var9.equals("usr_pr") && !var9.equals("usr_pv") && !var9.equals("usr_caissier") && !var9.equals("usr_caissier_service") && !var9.equals("usr_recus") && !var9.equals("usr_paye") && !var9.equals("usr_paye_service") && !var9.equals("usr_tiers") && !var9.equals("usr_planning") && !var9.equals("usr_mail_copie") && !var9.equals("usr_achats_service") && !var9.equals("usr_achats") && !var9.equals("usr_resp_achats") && !var9.equals("usr_ventes_service") && !var9.equals("usr_ventes") && !var9.equals("usr_caissier") && !var9.equals("usr_caissier_service") && !var9.equals("usr_comm_ventes") && !var9.equals("usr_mf") && !var9.equals("usrMedical_service") && !var9.equals("usr_medical") && !var9.equals("usr_acces_brouillard") && !var9.equals("usr_ach_trf_da") && !var9.equals("usr_ach_trf_cot") && !var9.equals("usr_ach_trf_cmd") && !var9.equals("usr_ach_trf_rec") && !var9.equals("usr_ach_trf_ret") && !var9.equals("usr_ach_trf_fac") && !var9.equals("usr_ach_trf_avr") && !var9.equals("usr_ach_trf_ndd") && !var9.equals("usr_ach_trf_fra") && !var9.equals("usr_vte_trf_bes") && !var9.equals("usr_vte_trf_dev") && !var9.equals("usr_vte_trf_bc") && !var9.equals("usr_vte_trf_bl") && !var9.equals("usr_vte_trf_fac") && !var9.equals("usr_vte_trf_ret") && !var9.equals("usr_vte_trf_avr") && !var9.equals("usr_vte_trf_ndd") && !var9.equals("usr_serie_maj") && !var9.equals("usr_aff_pump") && !var9.equals("usr_ver_remise") && !var9.equals("usr_ver_pv") && !var9.equals("usr_ver_serie") && !var9.equals("usr_prod_service") && !var9.equals("usr_serie_maj_ach") && !var9.equals("usr_ver_remise_ach") && !var9.equals("usr_ver_pa_ach") && !var9.equals("usr_ver_serie_ach") && !var9.equals("usr_prod_service_ach")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueStructure(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "");
      String var4 = "cmm_structure";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_dte_creat") && !var9.contains("_dte_modif") && !var9.contains("_user_creat") && !var9.contains("_user_modif") && !var9.contains("str_etat") && !var9.contains("str_type_contact") && !var9.contains("str_adresse_serveur") && !var9.contains("str_repertoire") && !var9.equals("str_mod1") && !var9.equals("str_mod2") && !var9.equals("str_mod3") && !var9.equals("str_mod4") && !var9.equals("str_mod5") && !var9.equals("str_mod6") && !var9.equals("str_mod7") && !var9.equals("str_mod8") && !var9.equals("str_mod9") && !var9.equals("str_mod10") && !var9.equals("str_logo1") && !var9.equals("str_logo2") && !var9.equals("str_logo3") && !var9.equals("str_logo4") && !var9.equals("str_nom_bd") && !var9.equals("str_log_bd") && !var9.equals("str_pw_bd") && !var9.equals("str_rep_image") && !var9.equals("str_e_commerce_val") && !var9.contains("str_vte_") && !var9.contains("str_fgvte_") && !var9.contains("str_ach_") && !var9.contains("str_fgach_") && !var9.contains("str_prd_") && !var9.contains("str_fgprd_") && !var9.contains("str_pw_bd") && !var9.contains("str_rep_image") && !var9.contains("str_e_commerce_val")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueAgent(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "Salaries");
      String var4 = "pay_salaries";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif") && !var9.contains("usr_code_secret")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueContrat(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "SalariesContrats");
      String var4 = "pay_salaries_contrats";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_mofif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }

         ObjetTable var12 = new ObjetTable();
         var12.setIndice(var5.size() + 1);
         var12.setColumn_name("salcon_simulation");
         var12.setColumn_comment("Simulation du bulletin");
         var5.add(var12);
         var12 = new ObjetTable();
         var12.setIndice(var5.size() + 1);
         var12.setColumn_name("salcon_salaire_global");
         var12.setColumn_comment("Salaire de base conventionné + sursalaire");
         var5.add(var12);
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueTiers(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "");
      String var4 = "cmm_tiers";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif") && !var9.equals("tie_etat") && !var9.equals("tie_type_adresse") && !var9.equals("tie_visibilite_user") && !var9.equals("tie_fac_pr") && !var9.equals("tie_no_use_1") && !var9.equals("tie_no_use_2")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueEleves(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "Eleves");
      String var4 = "edu_eleves";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriquePatients(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "Patients");
      String var4 = "med_patients";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueProduits(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "");
      String var4 = "cmm_produits";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueProduitsDepots(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "");
      String var4 = "cmm_produits_depot";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueProduitsTarifs(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "");
      String var4 = "cmm_produits_tarif";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueBaremes(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "");
      String var4 = "cmm_baremes";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public List rubriqueAmortissements(UtilInitHibernate var1, String var2) throws HibernateException, NamingException {
      Session var3 = var1.getOpenSession(var2, "Amortissements");
      String var4 = "cpt_amortissements";
      ArrayList var5 = new ArrayList();
      List var6 = var3.createSQLQuery("SELECT column_name FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      List var7 = var3.createSQLQuery("SELECT column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var4 + "'").list();
      if (var6.size() != 0 && var7.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            String var9 = var6.get(var8).toString();
            if (!var9.contains("_id") && !var9.contains("_date_creat") && !var9.contains("_user_creat") && !var9.contains("_date_modif") && !var9.contains("_user_modif")) {
               String var10 = var7.get(var8).toString();
               ObjetTable var11 = new ObjetTable();
               var11.setIndice(var8);
               var11.setColumn_name(var9);
               var11.setColumn_comment(var10);
               var5.add(var11);
            }
         }
      }

      var1.closeSession();
      return var5;
   }

   public String analyseTexteRH(String var1, Users var2, Structure var3, Salaries var4, SalariesContrats var5, String var6, UtilInitHibernate var7) throws HibernateException, NamingException {
      String var8;
      String var12;
      String var13;
      for(var8 = var1; var8.contains("["); var8 = var8.replace(var12, var13)) {
         int var9 = 0;
         int var10 = 0;

         for(int var11 = 0; var11 < var8.length(); ++var11) {
            if (var8.substring(var11, var11 + 1).equals("[")) {
               var9 = var11 + 1;
            }

            if (var8.substring(var11, var11 + 1).equals("]")) {
               var10 = var11;
               break;
            }
         }

         String var14 = var8.substring(var9, var10);
         var12 = "[" + var14 + "]";
         var13 = "";
         if (var14.contains("usr_") && var2 != null) {
            var13 = this.calculeZoneUser(var14, var2);
         } else if (var14.contains("str_") && var3 != null) {
            var13 = this.calculeZoneStructure(var14, var3);
         } else if (var14.contains("sal_") && var4 != null) {
            var13 = this.calculeZoneAgent(var14, var4);
         } else if (var14.contains("salcon_") && var5 != null) {
            var13 = this.calculeZoneContrat(var14, var5, var3.getStrdevise(), var6, var7);
         } else {
            var13 = "erreur zone " + var14;
         }
      }

      return var8;
   }

   public String analyseTexteCommercial(String var1, Users var2, Structure var3, Tiers var4) {
      String var5;
      String var9;
      String var10;
      for(var5 = var1; var5.contains("["); var5 = var5.replace(var9, var10)) {
         int var6 = 0;
         int var7 = 0;

         for(int var8 = 0; var8 < var5.length(); ++var8) {
            if (var5.substring(var8, var8 + 1).equals("[")) {
               var6 = var8 + 1;
            }

            if (var5.substring(var8, var8 + 1).equals("]")) {
               var7 = var8;
               break;
            }
         }

         String var11 = var5.substring(var6, var7);
         var9 = "[" + var11 + "]";
         var10 = "";
         if (var11.contains("usr_") && var2 != null) {
            var10 = this.calculeZoneUser(var11, var2);
         } else if (var11.contains("str_") && var3 != null) {
            var10 = this.calculeZoneStructure(var11, var3);
         } else if (var11.contains("tie_") && var4 != null) {
            var10 = this.calculeZoneTiers(var11, var4);
         } else {
            var10 = "erreur zone " + var11;
         }
      }

      return var5;
   }

   public String analyseTexteDevis(String var1, Users var2, Structure var3, Tiers var4, DevisEnteteVentes var5) {
      String var6;
      String var10;
      String var11;
      for(var6 = var1; var6.contains("["); var6 = var6.replace(var10, var11)) {
         int var7 = 0;
         int var8 = 0;

         for(int var9 = 0; var9 < var6.length(); ++var9) {
            if (var6.substring(var9, var9 + 1).equals("[")) {
               var7 = var9 + 1;
            }

            if (var6.substring(var9, var9 + 1).equals("]")) {
               var8 = var9;
               break;
            }
         }

         String var12 = var6.substring(var7, var8);
         var10 = "[" + var12 + "]";
         var11 = "";
         if (var12.contains("usr_") && var2 != null) {
            var11 = this.calculeZoneUser(var12, var2);
         } else if (var12.contains("str_") && var3 != null) {
            var11 = this.calculeZoneStructure(var12, var3);
         } else if (var12.contains("tie_") && var4 != null) {
            var11 = this.calculeZoneTiers(var12, var4);
         } else if (var12.contains("dvs_") && var4 != null) {
            var11 = this.calculeZoneDocumentDevis(var12, var4, var5);
         } else {
            var11 = "erreur zone " + var12;
         }
      }

      return var6;
   }

   public String analyseTexteMedicall(String var1, Users var2, Structure var3, Patients var4) {
      String var5;
      String var9;
      String var10;
      for(var5 = var1; var5.contains("["); var5 = var5.replace(var9, var10)) {
         int var6 = 0;
         int var7 = 0;

         for(int var8 = 0; var8 < var5.length(); ++var8) {
            if (var5.substring(var8, var8 + 1).equals("[")) {
               var6 = var8 + 1;
            }

            if (var5.substring(var8, var8 + 1).equals("]")) {
               var7 = var8;
               break;
            }
         }

         String var11 = var5.substring(var6, var7);
         var9 = "[" + var11 + "]";
         var10 = "";
         if (var11.contains("usr_") && var2 != null) {
            var10 = this.calculeZoneUser(var11, var2);
         } else if (var11.contains("str_") && var3 != null) {
            var10 = this.calculeZoneStructure(var11, var3);
         } else if (var11.contains("pat_") && var4 != null) {
            var10 = this.calculeZonePatients(var11, var4);
         } else {
            var10 = "erreur zone " + var11;
         }
      }

      return var5;
   }

   public String analyseTexteCommercial(String var1, Users var2, Structure var3, Tiers var4, BienBail var5) {
      String var6;
      String var10;
      String var11;
      for(var6 = var1; var6.contains("["); var6 = var6.replace(var10, var11)) {
         int var7 = 0;
         int var8 = 0;

         for(int var9 = 0; var9 < var6.length(); ++var9) {
            if (var6.substring(var9, var9 + 1).equals("[")) {
               var7 = var9 + 1;
            }

            if (var6.substring(var9, var9 + 1).equals("]")) {
               var8 = var9;
               break;
            }
         }

         String var12 = var6.substring(var7, var8);
         var10 = "[" + var12 + "]";
         var11 = "";
         if (var12.contains("usr_") && var2 != null) {
            var11 = this.calculeZoneUser(var12, var2);
         } else if (var12.contains("str_") && var3 != null) {
            var11 = this.calculeZoneStructure(var12, var3);
         } else if (var12.contains("tie_") && var4 != null) {
            var11 = this.calculeZoneTiers(var12, var4);
         } else if (var12.contains("biebai_") && var4 != null) {
            var11 = this.calculeZoneBail(var12, var5);
         } else {
            var11 = "erreur zone " + var12;
         }
      }

      return var6;
   }

   public String calculeZoneUser(String var1, Users var2) {
      String var3 = "";
      if (var1.equalsIgnoreCase("usr_civilite")) {
         var3 = var2.getUsrCivilite();
      } else if (var1.equalsIgnoreCase("usr_nom")) {
         var3 = var2.getUsrNom();
      } else if (var1.equalsIgnoreCase("usr_prenom")) {
         var3 = var2.getUsrPrenom();
      } else if (var1.equalsIgnoreCase("usr_patronyme")) {
         var3 = var2.getUsrPatronyme();
      } else if (var1.equalsIgnoreCase("usr_date_naissance")) {
         if (var2.getUsrDateNaissance() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getUsrDateNaissance());
         }
      } else if (var1.equalsIgnoreCase("usr_anniversaire")) {
         var3 = var2.getUsrAnniversaire();
      } else if (var1.equalsIgnoreCase("usr_langue")) {
         var3 = var2.getUsrLangue();
      } else if (var1.equalsIgnoreCase("usr_templates")) {
         var3 = var2.getUsrTemplates();
      } else if (var1.equalsIgnoreCase("usr_themes")) {
         var3 = var2.getUsrThemes();
      } else if (var1.equalsIgnoreCase("usr_collaboration")) {
         var3 = var2.getUsrCollaboration();
      } else if (var1.equalsIgnoreCase("usr_fonction")) {
         var3 = var2.getUsrFonction();
      } else if (var1.equalsIgnoreCase("usr_adresse")) {
         var3 = var2.getUsrAdresse();
      } else if (var1.equalsIgnoreCase("usr_bp")) {
         var3 = var2.getUsrBp();
      } else if (var1.equalsIgnoreCase("usr_ville")) {
         var3 = var2.getUsrVille();
      } else if (var1.equalsIgnoreCase("usr_nom_pays")) {
         var3 = var2.getUsrNomPays();
      } else if (var1.equalsIgnoreCase("usr_tel_bureau")) {
         var3 = var2.getUsrTelBureau();
      } else if (var1.equalsIgnoreCase("usr_tel_domicile")) {
         var3 = var2.getUsrTelDomicile();
      } else if (var1.equalsIgnoreCase("usr_cel1")) {
         var3 = var2.getUsrCel1();
      } else if (var1.equalsIgnoreCase("usr_cel2")) {
         var3 = var2.getUsrCel2();
      } else if (var1.equalsIgnoreCase("usr_cel3")) {
         var3 = var2.getUsrCel3();
      } else if (var1.equalsIgnoreCase("usr_mail")) {
         var3 = var2.getUsrMail();
      } else if (var1.equalsIgnoreCase("usr_yahoo")) {
         var3 = var2.getUsrYahoo();
      } else if (var1.equalsIgnoreCase("usr_msn")) {
         var3 = var2.getUsrMsn();
      } else if (var1.equalsIgnoreCase("usr_skype")) {
         var3 = var2.getUsrSkype();
      } else if (var1.equalsIgnoreCase("usr_aol")) {
         var3 = var2.getUsrAol();
      } else if (var1.equalsIgnoreCase("usr_depot_sel")) {
         if (var2.getUsrDepotSel() == 1) {
            var3 = "Dépots choisis";
         } else {
            var3 = "Tous les dépots";
         }
      } else if (var1.equalsIgnoreCase("usr_service")) {
         var3 = var2.getUsrService();
      } else if (var1.equalsIgnoreCase("usr_departement")) {
         var3 = var2.getUsrDepartement();
      } else if (var1.equalsIgnoreCase("usr_site")) {
         var3 = var2.getUsrSite();
      } else if (var1.equalsIgnoreCase("usr_startup")) {
         var3 = var2.getUsrStartup();
      } else if (var1.equalsIgnoreCase("usr_date_debut_indisponibilite")) {
         if (var2.getUsrDateDebutIndisponibilite() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getUsrDateDebutIndisponibilite());
         }
      } else if (var1.equalsIgnoreCase("usr_date_fin_indisponibilite")) {
         if (var2.getUsrDateFinIndisponibilite() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getUsrDateFinIndisponibilite());
         }
      } else {
         var3 = "???";
      }

      return var3;
   }

   public String calculeZoneStructure(String var1, Structure var2) {
      String var3 = "";
      if (var1.equalsIgnoreCase("str_mode")) {
         if (var2.getStrmode() == 0) {
            var3 = "full internet";
         } else if (var2.getStrmode() == 1) {
            var3 = "full intranet";
         } else if (var2.getStrmode() == 2) {
            var3 = "mixte";
         } else if (var2.getStrmode() == 3) {
            var3 = "special";
         }
      } else if (var1.equalsIgnoreCase("str_raison_sociale")) {
         var3 = var2.getStrraisonsociale();
      } else if (var1.equalsIgnoreCase("str_sigle")) {
         var3 = var2.getStrsigle();
      } else if (var1.equalsIgnoreCase("str_nom_pays")) {
         var3 = var2.getStrnompays();
      } else if (var1.equalsIgnoreCase("str_code_pays")) {
         var3 = var2.getStrcodepays();
      } else if (var1.equalsIgnoreCase("str_devise")) {
         var3 = var2.getStrdevise();
      } else if (var1.equalsIgnoreCase("str_format_devise")) {
         if (var2.getStrformatdevise() == 0) {
            var3 = "format us";
         } else if (var2.getStrformatdevise() == 1) {
            var3 = "format euro";
         } else if (var2.getStrformatdevise() == 2) {
            var3 = "format cfa";
         }
      } else if (var1.equalsIgnoreCase("str_langue")) {
         var3 = var2.getStrlangue();
      } else if (var1.equalsIgnoreCase("str_zone_fiscale")) {
         var3 = var2.getStrzonefiscale();
      } else if (var1.equalsIgnoreCase("str_format_date")) {
         var3 = var2.getStrformatdate();
      } else if (var1.equalsIgnoreCase("str_format_heure")) {
         var3 = var2.getStrformatheure();
      } else if (var1.equalsIgnoreCase("str_hr_deb")) {
         var3 = var2.getStrHrDeb();
      } else if (var1.equalsIgnoreCase("str_mn_deb")) {
         var3 = var2.getStrMnDeb();
      } else if (var1.equalsIgnoreCase("str_hr_pas")) {
         var3 = var2.getStrHrPas();
      } else if (var1.equalsIgnoreCase("str_mn_pas")) {
         var3 = var2.getStrMnPas();
      } else if (var1.equalsIgnoreCase("str_hr_fin")) {
         var3 = var2.getStrHrFin();
      } else if (var1.equalsIgnoreCase("str_mn_fin")) {
         var3 = var2.getStrMnFin();
      } else if (var1.equalsIgnoreCase("str_forme_juridique")) {
         var3 = var2.getStrformejuridique();
      } else if (var1.equalsIgnoreCase("str_type_entreprise")) {
         var3 = var2.getStrtypeentreprise();
      } else if (var1.equalsIgnoreCase("str_adresse")) {
         var3 = var2.getStradresse();
      } else if (var1.equalsIgnoreCase("str_rue")) {
         var3 = var2.getStrrue();
      } else if (var1.equalsIgnoreCase("str_lot")) {
         var3 = var2.getStrlot();
      } else if (var1.equalsIgnoreCase("str_porte")) {
         var3 = var2.getStrporte();
      } else if (var1.equalsIgnoreCase("str_quartier")) {
         var3 = var2.getStrquartier();
      } else if (var1.equalsIgnoreCase("str_ville")) {
         var3 = var2.getStrville();
      } else if (var1.equalsIgnoreCase("str_commune")) {
         var3 = var2.getStrcommune();
      } else if (var1.equalsIgnoreCase("str_departement")) {
         var3 = var2.getStrdepartement();
      } else if (var1.equalsIgnoreCase("str_zone")) {
         var3 = var2.getStrzone();
      } else if (var1.equalsIgnoreCase("str_batiment")) {
         var3 = var2.getStrbatiment();
      } else if (var1.equalsIgnoreCase("str_etage")) {
         var3 = var2.getStretage();
      } else if (var1.equalsIgnoreCase("str_bp")) {
         var3 = var2.getStrbp();
      } else if (var1.equalsIgnoreCase("str_cedex")) {
         var3 = var2.getStrcedex();
      } else if (var1.equalsIgnoreCase("str_tel1")) {
         var3 = var2.getStrtel1();
      } else if (var1.equalsIgnoreCase("str_tel2")) {
         var3 = var2.getStrtel2();
      } else if (var1.equalsIgnoreCase("str_tel3")) {
         var3 = var2.getStrtel3();
      } else if (var1.equalsIgnoreCase("str_fax")) {
         var3 = var2.getStrfax();
      } else if (var1.equalsIgnoreCase("str_telex")) {
         var3 = var2.getStrtelex();
      } else if (var1.equalsIgnoreCase("str_site_wzb")) {
         var3 = var2.getStrsitewzb();
      } else if (var1.equalsIgnoreCase("str_num1")) {
         var3 = var2.getStrnum1();
      } else if (var1.equalsIgnoreCase("str_num2")) {
         var3 = var2.getStrnum2();
      } else if (var1.equalsIgnoreCase("str_num3")) {
         var3 = var2.getStrnum3();
      } else if (var1.equalsIgnoreCase("str_num4")) {
         var3 = var2.getStrnum4();
      } else if (var1.equalsIgnoreCase("str_num5")) {
         var3 = var2.getStrnum5();
      } else if (var1.equalsIgnoreCase("str_num6")) {
         var3 = var2.getStrnum6();
      } else if (var1.equalsIgnoreCase("str_num7")) {
         var3 = var2.getStrnum7();
      } else if (var1.equalsIgnoreCase("str_num8")) {
         var3 = var2.getStrnum8();
      } else if (var1.equalsIgnoreCase("str_num9")) {
         var3 = var2.getStrnum9();
      } else if (var1.equalsIgnoreCase("str_num10")) {
         var3 = var2.getStrnum10();
      } else if (var1.equalsIgnoreCase("str_num11")) {
         var3 = var2.getStrnum11();
      } else if (var1.equalsIgnoreCase("str_num12")) {
         var3 = var2.getStrnum12();
      } else if (var1.equalsIgnoreCase("str_num13")) {
         var3 = var2.getStrnum13();
      } else if (var1.equalsIgnoreCase("str_num14")) {
         var3 = var2.getStrnum14();
      } else if (var1.equalsIgnoreCase("str_num15")) {
         var3 = var2.getStrnum15();
      } else if (var1.equalsIgnoreCase("str_num16")) {
         var3 = var2.getStrnum16();
      } else if (var1.equalsIgnoreCase("str_num17")) {
         var3 = var2.getStrnum17();
      } else if (var1.equalsIgnoreCase("str_num18")) {
         var3 = var2.getStrnum18();
      } else if (var1.equalsIgnoreCase("str_num19")) {
         var3 = var2.getStrnum19();
      } else if (var1.equalsIgnoreCase("str_num20")) {
         var3 = var2.getStrnum20();
      } else if (var1.equalsIgnoreCase("str_domaine")) {
         var3 = var2.getStrdomaine();
      } else if (var1.equalsIgnoreCase("str_responsable")) {
         var3 = var2.getStrResponsable();
      } else if (var1.equalsIgnoreCase("str_qualite_responsable")) {
         var3 = var2.getStrQualiteResponsable();
      } else if (var1.equalsIgnoreCase("str_capital")) {
         var3 = var2.getStrCapital();
      } else {
         var3 = "???";
      }

      return var3;
   }

   public String calculeZoneAgent(String var1, Salaries var2) {
      String var3 = "";
      if (var1.equalsIgnoreCase("sal_matricule")) {
         var3 = var2.getSalMatricule();
      } else if (var1.equalsIgnoreCase("sal_photo")) {
         var3 = var2.getSalPhoto();
      } else if (var1.equalsIgnoreCase("sal_nature")) {
         var3 = var2.getLib_nature();
      } else if (var1.equalsIgnoreCase("sal_etat")) {
         var3 = var2.getLib_etat();
      } else if (var1.equalsIgnoreCase("sal_protege")) {
         var3 = "" + var2.getSalProtege();
      } else if (var1.equalsIgnoreCase("sal_nom")) {
         var3 = var2.getSalNom();
      } else if (var1.equalsIgnoreCase("sal_nomJf")) {
         var3 = var2.getSalNomJf();
      } else if (var1.equalsIgnoreCase("sal_prenom")) {
         var3 = var2.getSalPrenom();
      } else if (var1.equalsIgnoreCase("sal_pere")) {
         var3 = var2.getSalPere();
      } else if (var1.equalsIgnoreCase("sal_mere")) {
         var3 = var2.getSalMere();
      } else if (var1.equalsIgnoreCase("sal_civilite")) {
         var3 = var2.getSalCivilite();
      } else if (var1.equalsIgnoreCase("sal_nompays")) {
         var3 = var2.getSalNompays();
      } else if (var1.equalsIgnoreCase("sal_langue")) {
         var3 = var2.getSalLangue();
      } else if (var1.equalsIgnoreCase("sal_fonction")) {
         var3 = var2.getSalFonction();
      } else if (var1.equalsIgnoreCase("sal_site")) {
         var3 = var2.getSalSite();
      } else if (var1.equalsIgnoreCase("sal_departement")) {
         var3 = var2.getSalDepartement();
      } else if (var1.equalsIgnoreCase("sal_service")) {
         var3 = var2.getSalService();
      } else if (var1.equalsIgnoreCase("sal_activite")) {
         var3 = var2.getSalActivite();
      } else if (var1.equalsIgnoreCase("sal_budget")) {
         var3 = var2.getSalBudget();
      } else if (var1.equalsIgnoreCase("sal_parc")) {
         var3 = var2.getSalParc();
      } else if (var1.equalsIgnoreCase("sal_date_naissance")) {
         if (var2.getSalDateNaissance() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateNaissance());
         }
      } else if (var1.equalsIgnoreCase("sal_lieu_naissance")) {
         var3 = var2.getSalLieuNaissance();
      } else if (var1.equalsIgnoreCase("sal_pays_naissance")) {
         var3 = var2.getSalPaysNaissance();
      } else if (var1.equalsIgnoreCase("sal_code_naissance")) {
         var3 = var2.getSalCodeNaissance();
      } else if (var1.equalsIgnoreCase("sal_nationnalite")) {
         var3 = var2.getSalNationnalite();
      } else if (var1.equalsIgnoreCase("sal_ethnie")) {
         var3 = var2.getSalEthnie();
      } else if (var1.equalsIgnoreCase("sal_anniversaire")) {
         var3 = var2.getSalAnniversaire();
      } else if (var1.equalsIgnoreCase("sal_tel_bur")) {
         var3 = var2.getSalTelBur();
      } else if (var1.equalsIgnoreCase("sal_tel_dom")) {
         var3 = var2.getSalTelDom();
      } else if (var1.equalsIgnoreCase("sal_cel1")) {
         var3 = var2.getSalCel1();
      } else if (var1.equalsIgnoreCase("sal_cel2")) {
         var3 = var2.getSalCel2();
      } else if (var1.equalsIgnoreCase("sal_cel3")) {
         var3 = var2.getSalCel3();
      } else if (var1.equalsIgnoreCase("sal_adresse")) {
         var3 = var2.getSalAdresse();
      } else if (var1.equalsIgnoreCase("sal_rue")) {
         var3 = var2.getSalRue();
      } else if (var1.equalsIgnoreCase("sal_lot")) {
         var3 = var2.getSalLot();
      } else if (var1.equalsIgnoreCase("sal_ilot")) {
         var3 = var2.getSalIlot();
      } else if (var1.equalsIgnoreCase("sal_batiment")) {
         var3 = var2.getSalBatiment();
      } else if (var1.equalsIgnoreCase("sal_porte")) {
         var3 = var2.getSalPorte();
      } else if (var1.equalsIgnoreCase("sal_escalier")) {
         var3 = var2.getSalEscalier();
      } else if (var1.equalsIgnoreCase("sal_ascensseur")) {
         var3 = var2.getSalAscensseur();
      } else if (var1.equalsIgnoreCase("sal_etage")) {
         var3 = var2.getSalEtage();
      } else if (var1.equalsIgnoreCase("sal_quartier")) {
         var3 = var2.getSalQuartier();
      } else if (var1.equalsIgnoreCase("sal_commune")) {
         var3 = var2.getSalCommune();
      } else if (var1.equalsIgnoreCase("sal_departe")) {
         var3 = var2.getSalDeparte();
      } else if (var1.equalsIgnoreCase("sal_zone")) {
         var3 = var2.getSalZone();
      } else if (var1.equalsIgnoreCase("sal_bp")) {
         var3 = var2.getSalBp();
      } else if (var1.equalsIgnoreCase("sal_ville")) {
         var3 = var2.getSalVille();
      } else if (var1.equalsIgnoreCase("sal_yahoo")) {
         var3 = var2.getSalYahoo();
      } else if (var1.equalsIgnoreCase("sal_msn")) {
         var3 = var2.getSalMsn();
      } else if (var1.equalsIgnoreCase("sal_skype")) {
         var3 = var2.getSalSkype();
      } else if (var1.equalsIgnoreCase("sal_aol")) {
         var3 = var2.getSalAol();
      } else if (var1.equalsIgnoreCase("sal_mail1")) {
         var3 = var2.getSalMail1();
      } else if (var1.equalsIgnoreCase("sal_observation")) {
         var3 = var2.getSalObservation();
      } else if (var1.equalsIgnoreCase("sal_num_banque")) {
         var3 = var2.getSalNumBanque();
      } else if (var1.equalsIgnoreCase("sal_guichet_banque")) {
         var3 = var2.getSalGuichetBanque();
      } else if (var1.equalsIgnoreCase("sal_compte_banque")) {
         var3 = var2.getSalCompteBanque();
      } else if (var1.equalsIgnoreCase("sal_cle_banque")) {
         var3 = var2.getSalCleBanque();
      } else if (var1.equalsIgnoreCase("sal_iban")) {
         var3 = var2.getSalIban();
      } else if (var1.equalsIgnoreCase("sal_swift")) {
         var3 = var2.getSalSwift();
      } else if (var1.equalsIgnoreCase("sal_num_banque_15")) {
         var3 = var2.getSalNumBanque15();
      } else if (var1.equalsIgnoreCase("sal_guichet_banque_15")) {
         var3 = var2.getSalGuichetBanque15();
      } else if (var1.equalsIgnoreCase("sal_compte_banque_15")) {
         var3 = var2.getSalCompteBanque15();
      } else if (var1.equalsIgnoreCase("sal_cle_banque_15")) {
         var3 = var2.getSalCleBanque15();
      } else if (var1.equalsIgnoreCase("sal_iban_15")) {
         var3 = var2.getSalIban15();
      } else if (var1.equalsIgnoreCase("sal_swift_15")) {
         var3 = var2.getSalSwift15();
      } else if (var1.equalsIgnoreCase("sal_sit_famille")) {
         var3 = var2.getLib_sitfamille();
      } else if (var1.equalsIgnoreCase("sal_genre")) {
         var3 = var2.getLib_genre();
      } else if (var1.equalsIgnoreCase("sal_nb_enfant")) {
         var3 = "" + var2.getSalNbEnfant();
      } else if (var1.equalsIgnoreCase("sal_nb_part_fiscal")) {
         var3 = "" + var2.getSalNbPartFiscal();
      } else if (var1.equalsIgnoreCase("sal_nb_femme")) {
         var3 = "" + var2.getSalNbFemme();
      } else if (var1.equalsIgnoreCase("sal_nb_part_trimf")) {
         var3 = "" + var2.getSalNbPartTrimf();
      } else if (var1.equalsIgnoreCase("sal_nb_jour_cp")) {
         var3 = "" + var2.getSalNbJourCp();
      } else if (var1.equalsIgnoreCase("sal_nb_jour_tr")) {
         var3 = "" + var2.getSalNbJourTr();
      } else if (var1.equalsIgnoreCase("sal_date_marie")) {
         if (var2.getSalDateMarie() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateMarie());
         }
      } else if (var1.equalsIgnoreCase("sal_date_divorce")) {
         if (var2.getSalDateDivorce() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateDivorce());
         }
      } else if (var1.equalsIgnoreCase("sal_date_veuf")) {
         if (var2.getSalDateVeuf() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateVeuf());
         }
      } else if (var1.equalsIgnoreCase("sal_date_concubinage")) {
         if (var2.getSalDateConcubinage() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateConcubinage());
         }
      } else if (var1.equalsIgnoreCase("sal_date_pacs")) {
         if (var2.getSalDatePacs() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDatePacs());
         }
      } else if (var1.equalsIgnoreCase("sal_convention")) {
         var3 = var2.getSalConvention();
      } else if (var1.equalsIgnoreCase("sal_lib_convention")) {
         var3 = var2.getSalLibConvention();
      } else if (var1.equalsIgnoreCase("sal_centres_impots")) {
         var3 = var2.getSalCentresImpots();
      } else if (var1.equalsIgnoreCase("sal_lib_centres_impots")) {
         var3 = var2.getSalLibCentresImpots();
      } else if (var1.equalsIgnoreCase("sal_classement")) {
         var3 = var2.getSalClassement();
      } else if (var1.equalsIgnoreCase("sal_lib_classement")) {
         var3 = var2.getSalLibClassement();
      } else if (var1.equalsIgnoreCase("sal_niv_emploi")) {
         var3 = var2.getSalNivEmploi();
      } else if (var1.equalsIgnoreCase("sal_lib_niv_emploi")) {
         var3 = var2.getSalLibNivEmploi();
      } else if (var1.equalsIgnoreCase("sal_grille")) {
         var3 = var2.getSalGrille();
      } else if (var1.equalsIgnoreCase("sal_lib_grille")) {
         var3 = var2.getSalLibGrille();
      } else if (var1.equalsIgnoreCase("sal_date_entree")) {
         if (var2.getSalDateEntree() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateEntree());
         }
      } else if (var1.equalsIgnoreCase("sal_date_sortie")) {
         if (var2.getSalDateSortie() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateSortie());
         }
      } else if (var1.equalsIgnoreCase("sal_motif_sortie")) {
         var3 = var2.getSalMotifSortie();
      } else if (var1.equalsIgnoreCase("sal_date_impot")) {
         if (var2.getSalDateImpot() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateImpot());
         }
      } else if (var1.equalsIgnoreCase("sal_feuille")) {
         var3 = var2.getSalFeuille();
      } else if (var1.equalsIgnoreCase("sal_num_ci")) {
         var3 = var2.getSalNumCi();
      } else if (var1.equalsIgnoreCase("sal_date_ci")) {
         if (var2.getSalDateCi() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateCi());
         }
      } else if (var1.equalsIgnoreCase("sal_delivre_ci")) {
         var3 = var2.getSalDelivreCi();
      } else if (var1.equalsIgnoreCase("sal_lieu_ci")) {
         var3 = var2.getSalLieuCi();
      } else if (var1.equalsIgnoreCase("sal_num_secu")) {
         var3 = var2.getSalNumSecu();
      } else if (var1.equalsIgnoreCase("sal_date_secu")) {
         if (var2.getSalDateSecu() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateSecu());
         }
      } else if (var1.equalsIgnoreCase("sal_num_retraite")) {
         var3 = var2.getSalNumRetraite();
      } else if (var1.equalsIgnoreCase("sal_date_retraite")) {
         if (var2.getSalDateSecu() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateRetraite());
         }
      } else if (var1.equalsIgnoreCase("sal_approb_insp")) {
         var3 = var2.getSalApprobInsp();
      } else if (var1.equalsIgnoreCase("sal_visa_enreg")) {
         var3 = var2.getSalVisaEnreg();
      } else if (var1.equalsIgnoreCase("sal_classe_recrut")) {
         var3 = var2.getSalClasseRecrut();
      } else if (var1.equalsIgnoreCase("sal_service_mil")) {
         if (var2.isSalServiceMil()) {
            var3 = "oui";
         } else {
            var3 = "non";
         }
      } else if (var1.equalsIgnoreCase("sal_coprs_app")) {
         var3 = var2.getSalCoprsApp();
      } else if (var1.equalsIgnoreCase("sal_grade")) {
         var3 = var2.getSalGrade();
      } else if (var1.equalsIgnoreCase("sal_date_entree_pays")) {
         if (var2.getSalDateEntreePays() != null) {
            var3 = this.utilDate.dateToStringFr(var2.getSalDateEntreePays());
         }
      } else {
         var3 = "???";
      }

      return var3;
   }

   public String calculeZoneContrat(String var1, SalariesContrats var2, String var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException {
      String var6 = "";
      if (var1.equalsIgnoreCase("salcon_num")) {
         var6 = var2.getSalconNum();
      } else if (var1.equalsIgnoreCase("salcon_type")) {
         var6 = "" + var2.getSalconType();
      } else if (var1.equalsIgnoreCase("salcon_feuille")) {
         var6 = var2.getSalconFeuille();
      } else if (var1.equalsIgnoreCase("salcon_etat")) {
         var6 = var2.getLib_etat();
      } else if (var1.equalsIgnoreCase("salcon_essai")) {
         if (var2.getSalconEssai() == 1) {
            var6 = "avec période d'essai";
         } else {
            var6 = "sans période d'essai";
         }
      } else if (var1.equalsIgnoreCase("salcon_nb_mois_essai")) {
         var6 = "" + var2.getSalconNbMoisEssai();
      } else if (var1.equalsIgnoreCase("salcon_fonction")) {
         var6 = var2.getSalconFonction();
      } else if (var1.equalsIgnoreCase("salcon_site")) {
         var6 = var2.getSalconSite();
      } else if (var1.equalsIgnoreCase("salcon_departement")) {
         var6 = var2.getSalconDepartement();
      } else if (var1.equalsIgnoreCase("salcon_service")) {
         var6 = var2.getSalconService();
      } else if (var1.equalsIgnoreCase("salcon_date_debut")) {
         if (var2.getSalconDateDebut() != null) {
            var6 = this.utilDate.dateToStringFr(var2.getSalconDateDebut());
         }
      } else if (var1.equalsIgnoreCase("salcon_lieu_travail")) {
         var6 = var2.getSalconLieuTravail();
      } else if (var1.equalsIgnoreCase("salcon_convention")) {
         var6 = var2.getSalconConvention();
      } else if (var1.equalsIgnoreCase("salcon_lib_convention")) {
         var6 = var2.getSalconLibConvention();
      } else if (var1.equalsIgnoreCase("salcon_centres_impots")) {
         var6 = var2.getSalconCentresImpots();
      } else if (var1.equalsIgnoreCase("salcon_lib_centres_impots")) {
         var6 = var2.getSalconLibCentresImpots();
      } else if (var1.equalsIgnoreCase("salcon_classement")) {
         var6 = var2.getSalconClassement();
      } else if (var1.equalsIgnoreCase("salcon_lib_classement")) {
         var6 = var2.getSalconLibClassement();
      } else if (var1.equalsIgnoreCase("salcon_niv_emploi")) {
         var6 = var2.getSalconNivEmploi();
      } else if (var1.equalsIgnoreCase("salcon_lib_niv_emploi")) {
         var6 = var2.getSalconLibNivEmploi();
      } else if (var1.equalsIgnoreCase("salcon_grille")) {
         var6 = var2.getSalconGrille();
      } else if (var1.equalsIgnoreCase("salcon_lib_grille")) {
         var6 = var2.getSalconLibGrille();
      } else if (var1.equalsIgnoreCase("salcon_activite")) {
         var6 = var2.getSalconActivite();
      } else if (var1.equalsIgnoreCase("salcon_lib_activite")) {
         var6 = var2.getSalconLibActivite();
      } else if (var1.equalsIgnoreCase("salcon_budget")) {
         var6 = var2.getSalconBudget();
      } else if (var1.equalsIgnoreCase("salcon_lib_budget")) {
         var6 = var2.getSalconLibBudget();
      } else if (var1.equalsIgnoreCase("salcon_vehicule")) {
         var6 = "" + var2.getSalconVehicule();
      } else if (var1.equalsIgnoreCase("salcon_rmb_kms")) {
         var6 = "" + var2.getSalconRbmKms();
      } else if (var1.equalsIgnoreCase("salcon_parc")) {
         var6 = var2.getSalconParc();
      } else if (var1.equalsIgnoreCase("salcon_date_fin")) {
         if (var2.getSalconDateFin() != null) {
            var6 = this.utilDate.dateToStringFr(var2.getSalconDateFin());
         }
      } else if (var1.equalsIgnoreCase("salcon_motif_sortie")) {
         var6 = var2.getSalconMotifSortie();
      } else if (var1.equalsIgnoreCase("salcon_date_remise")) {
         if (var2.getSalconDateRemise() != null) {
            var6 = this.utilDate.dateToStringFr(var2.getSalconDateRemise());
         }
      } else if (var1.equalsIgnoreCase("salcon_date_retour")) {
         if (var2.getSalconDateRetour() != null) {
            var6 = this.utilDate.dateToStringFr(var2.getSalconDateRetour());
         }
      } else if (var1.equalsIgnoreCase("salcon_date_confirmation")) {
         if (var2.getSalconDateConfirmation() != null) {
            var6 = this.utilDate.dateToStringFr(var2.getSalconDateConfirmation());
         }
      } else if (var1.equalsIgnoreCase("salcon_nom_representant")) {
         var6 = var2.getSalconNomRepresentant();
      } else if (var1.equalsIgnoreCase("salcon_qualite")) {
         var6 = var2.getSalconQualite();
      } else if (var1.equalsIgnoreCase("salcon_base")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconBase(), var3);
      } else if (var1.equalsIgnoreCase("salcon_sursalaire")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconSursalaire(), var3);
      } else if (var1.equalsIgnoreCase("salcon_prime_rendement")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeRendement(), var3);
      } else if (var1.equalsIgnoreCase("salcon_prime_responsabilite")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeResponsabilite(), var3);
      } else if (var1.equalsIgnoreCase("salcon_prime_sujetion")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeSujetion(), var3);
      } else if (var1.equalsIgnoreCase("salcon_prime_fonction")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeFonction(), var3);
      } else if (var1.equalsIgnoreCase("salcon_indemnite_caisse")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconIndemniteCaisse(), var3);
      } else if (var1.equalsIgnoreCase("salcon_indemnite_transport")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconIndemniteTransport(), var3);
      } else if (var1.equalsIgnoreCase("salcon_indemnite_logement")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconIndemniteLogement(), var3);
      } else if (var1.equalsIgnoreCase("salcon_indemnite_deplacement")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconIndemniteDeplacement(), var3);
      } else if (var1.equalsIgnoreCase("salcon_indemnite_kilometrique")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconIndemniteKilometrique(), var3);
      } else if (var1.equalsIgnoreCase("salcon_indemnite_salissure")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconIndemniteSalissure(), var3);
      } else if (var1.equalsIgnoreCase("salcon_indemnite_representation")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconIndemniteRepresentation(), var3);
      } else if (var1.equalsIgnoreCase("salcon_avn_logement")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconAvnLogement(), var3);
      } else if (var1.equalsIgnoreCase("salcon_avn_domesticite")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconAvnDomesticite(), var3);
      } else if (var1.equalsIgnoreCase("salcon_avn_telephone")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconAvnTelephone(), var3);
      } else if (var1.equalsIgnoreCase("salcon_avn_eau")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconAvnEau(), var3);
      } else if (var1.equalsIgnoreCase("salcon_avn_electricite")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconAvnElectricite(), var3);
      } else if (var1.equalsIgnoreCase("salcon_avn_nourriture")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconAvnNourriture(), var3);
      } else if (var1.equalsIgnoreCase("salcon_avn_vehicule")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconAvnVehicule(), var3);
      } else if (var1.equalsIgnoreCase("salcon_simulation")) {
         var6 = this.calculSimulation(var2.getSalaries().getSalMatricule(), var4, var3, var5);
      } else if (var1.equalsIgnoreCase("salcon_salaire_global")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconBase() + var2.getSalconSursalaire(), var3);
      } else if (var1.equalsIgnoreCase("salconPrimeTransport")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeTransport(), var3);
      } else if (var1.equalsIgnoreCase("salconPrimeLogement")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeLogement(), var3);
      } else if (var1.equalsIgnoreCase("salconPrimeOutillage")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeOutillage(), var3);
      } else if (var1.equalsIgnoreCase("salconPrimeAstreinte")) {
         var6 = this.utilNombre.beginSimple(var2.getSalconPrimeAstreinte(), var3);
      } else if (var1.equalsIgnoreCase("salcon_nom_tiers")) {
         var6 = var2.getSalconNomTiers();
      } else {
         var6 = "???";
      }

      return var6;
   }

   public String calculSimulation(String var1, String var2, String var3, UtilInitHibernate var4) throws HibernateException, NamingException {
      String var5 = "";
      BulletinSalaireDao var6 = new BulletinSalaireDao(var2, var4);
      new BulletinSalaire();
      BulletinSalaire var7 = var6.rechercheBulletinSalariePeriode(var1, "SIMUL", (Session)null);
      if (var7 != null) {
         BulletinLigneDao var8 = new BulletinLigneDao(var2, var4);
         new ArrayList();
         List var9 = var8.chargerleslignesBulletinSimulation(var7, (Session)null);
         if (var9.size() != 0) {
            var5 = "<table border=\"1\"><tbody>";
            var5 = var5 + "<tr><td style=\"text-align: center;\"><strong>RUBRIQUES</strong></td>/<td style=\"text-align: center;\"><strong>BASE</strong></td><td style=\"text-align: center;\"><strong>NOMBRE</strong></td><td style=\"text-align: center;\"><strong>TAUX</strong></td><td style=\"text-align: center;\"><strong>RESULTAT</strong></td></tr>";
            new BulletinLigne();

            for(int var11 = 0; var11 < var9.size(); ++var11) {
               BulletinLigne var10 = (BulletinLigne)var9.get(var11);
               if (var10.getBulligNature() <= 89) {
                  String var12 = "";
                  if (var10.getBulligValColB() != 0.0D) {
                     var12 = this.utilNombre.beginSimple(var10.getBulligValColB(), var3);
                  }

                  String var13 = "";
                  if (var10.getBulligValColC() != 0.0D) {
                     var13 = this.utilNombre.beginQte((float)var10.getBulligValColC(), "2");
                  }

                  String var14 = "";
                  if (var10.getBulligValColD() != 0.0D) {
                     var14 = this.utilNombre.beginQte((float)var10.getBulligValColD(), "0");
                  }

                  String var15 = "";
                  if (var10.getBulligValColE() != 0.0D) {
                     var15 = this.utilNombre.beginSimple(var10.getBulligValColE(), var3);
                  }

                  if (var10.getBulligNature() != 59 && var10.getBulligNature() != 69 && var10.getBulligNature() != 89) {
                     var5 = var5 + "<tr><td>" + var10.getBulligLibelle() + "</td>/<td style=\"text-align: right;\">" + var12 + "</td><td style=\"text-align: right;\">" + var13 + "</td><td style=\"text-align: right;\">" + var14 + "</td><td style=\"text-align: right;\">" + var15 + "</td></tr>";
                  } else {
                     var5 = var5 + "<tr><td><strong>" + var10.getBulligLibelle() + "</strong></td>/<td style=\"text-align: right;\"><strong>" + var12 + "</strong></td><td style=\"text-align: right;\"><strong>" + var13 + "</strong></td><td style=\"text-align: right;\"><strong>" + var14 + "</strong></td><td style=\"text-align: right;\"><strong>" + var15 + "</strong></td></tr>";
                  }
               }
            }

            var5 = var5 + "</tbody></table>";
         }
      }

      return var5;
   }

   public String calculeZoneTiers(String var1, Tiers var2) {
      String var3 = "";
      if (var1.equalsIgnoreCase("tie_raison_sociale_nom")) {
         var3 = var2.getTieraisonsocialenom();
      } else if (var1.equalsIgnoreCase("tie_sigle")) {
         var3 = var2.getTiesigle();
      } else if (var1.equalsIgnoreCase("tie_sigle")) {
         var3 = var2.getTiesigle();
      } else if (var1.equalsIgnoreCase("tie_type")) {
         if (var2.getTietype().equals("0")) {
            var3 = "fournisseur";
         } else if (var2.getTietype().equals("1")) {
            var3 = "suspect";
         } else if (var2.getTietype().equals("2")) {
            var3 = "prospect";
         } else if (var2.getTietype().equals("3")) {
            var3 = "client";
         } else if (var2.getTietype().equals("6")) {
            var3 = "paroissien";
         } else if (var2.getTietype().equals("99")) {
            var3 = "divers";
         }
      } else if (var1.equalsIgnoreCase("tie_genre")) {
         var3 = var2.getTiegenre();
      } else if (var1.equalsIgnoreCase("tie_categorie")) {
         var3 = var2.getTiecategorie();
      } else if (var1.equalsIgnoreCase("tie_civilite")) {
         var3 = var2.getTiecivilite();
      } else if (var1.equalsIgnoreCase("tie_nom_pays")) {
         var3 = var2.getTienompays();
      } else if (var1.equalsIgnoreCase("tie_code_pays")) {
         var3 = var2.getTiecodepays();
      } else if (var1.equalsIgnoreCase("tie_devise")) {
         var3 = var2.getTiedevise();
      } else if (var1.equalsIgnoreCase("tie_format_devise")) {
         if (var2.getTieFormatDevise() == 0) {
            var3 = "format us";
         } else if (var2.getTieFormatDevise() == 1) {
            var3 = "format euro";
         } else if (var2.getTieFormatDevise() == 2) {
            var3 = "format cfa";
         }
      } else if (var1.equalsIgnoreCase("tie_tel_dom")) {
         var3 = var2.getTieteldom();
      } else if (var1.equalsIgnoreCase("tie_cel1")) {
         var3 = var2.getTiecel1();
      } else if (var1.equalsIgnoreCase("tie_cel2")) {
         var3 = var2.getTiecel2();
      } else if (var1.equalsIgnoreCase("tie_cel3")) {
         var3 = var2.getTiecel3();
      } else if (var1.equalsIgnoreCase("tie_tel_voiture")) {
         var3 = var2.getTietelvoiture();
      } else if (var1.equalsIgnoreCase("tie_prenom")) {
         var3 = var2.getTieprenom();
      } else if (var1.equalsIgnoreCase("tie_nom_jf")) {
         var3 = var2.getTienomjf();
      } else if (var1.equalsIgnoreCase("tie_surnom")) {
         var3 = var2.getTiesurnom();
      } else if (var1.equalsIgnoreCase("tie_surnom")) {
         var3 = var2.getTiesurnom();
      } else if (var1.equalsIgnoreCase("tie_sexe")) {
         if (var2.getTiesexe() == 0) {
            var3 = "femme";
         } else if (var2.getTiesexe() == 1) {
            var3 = "homme";
         }
      } else if (var1.equalsIgnoreCase("tie_date_naissance")) {
         var3 = this.utilDate.dateToStringFr(var2.getTiedatenaissance());
      } else if (var1.equalsIgnoreCase("tie_lieu_naissance")) {
         var3 = var2.getTielieunaissance();
      } else if (var1.equalsIgnoreCase("tie_anniversaire")) {
         var3 = var2.getTieanniversaire();
      } else if (var1.equalsIgnoreCase("tie_observations")) {
         var3 = var2.getTieobservations();
      } else if (var1.equalsIgnoreCase("tie_activite1")) {
         var3 = var2.getTieactivite1();
      } else if (var1.equalsIgnoreCase("tie_activite2")) {
         var3 = var2.getTieactivite2();
      } else if (var1.equalsIgnoreCase("tie_source")) {
         var3 = var2.getTiesource();
      } else if (var1.equalsIgnoreCase("tie_visibilite")) {
         if (var2.getTievisibilite() == 0) {
            var3 = "public";
         } else if (var2.getTievisibilite() == 1) {
            var3 = "collaborateur";
         } else if (var2.getTievisibilite() == 2) {
            var3 = "privé";
         }
      } else if (var1.equalsIgnoreCase("tie_visibilite_grp")) {
         var3 = var2.getTievisibiliteGrp();
      } else if (var1.equalsIgnoreCase("tie_adresse")) {
         var3 = var2.getTieadresse();
      } else if (var1.equalsIgnoreCase("tie_rue")) {
         var3 = var2.getTierue();
      } else if (var1.equalsIgnoreCase("tie_lot")) {
         var3 = var2.getTielot();
      } else if (var1.equalsIgnoreCase("tie_ilot")) {
         var3 = var2.getTieilot();
      } else if (var1.equalsIgnoreCase("tie_batiment")) {
         var3 = var2.getTiebatiment();
      } else if (var1.equalsIgnoreCase("tie_porte")) {
         var3 = var2.getTieporte();
      } else if (var1.equalsIgnoreCase("tie_etage")) {
         var3 = var2.getTieetage();
      } else if (var1.equalsIgnoreCase("tie_ascensseur")) {
         var3 = var2.getTieascensseur();
      } else if (var1.equalsIgnoreCase("tie_quartier")) {
         var3 = var2.getTiequartier();
      } else if (var1.equalsIgnoreCase("tie_commune")) {
         var3 = var2.getTiecommune();
      } else if (var1.equalsIgnoreCase("tie_depart")) {
         var3 = var2.getTiedepart();
      } else if (var1.equalsIgnoreCase("tie_zone")) {
         var3 = var2.getTiezone();
      } else if (var1.equalsIgnoreCase("tie_bp")) {
         var3 = var2.getTiebp();
      } else if (var1.equalsIgnoreCase("tie_cedex")) {
         var3 = var2.getTiecedex();
      } else if (var1.equalsIgnoreCase("tie_ville")) {
         var3 = var2.getTieville();
      } else if (var1.equalsIgnoreCase("tie_bur_tel1")) {
         var3 = var2.getTieburtel1();
      } else if (var1.equalsIgnoreCase("tie_bur_tel2")) {
         var3 = var2.getTieburtel2();
      } else if (var1.equalsIgnoreCase("tie_bur_tel3")) {
         var3 = var2.getTieburtel3();
      } else if (var1.equalsIgnoreCase("tie_bur_fax")) {
         var3 = var2.getTieburfax();
      } else if (var1.equalsIgnoreCase("tie_telex")) {
         var3 = var2.getTietelex();
      } else if (var1.equalsIgnoreCase("tie_yahoo")) {
         var3 = var2.getTieyahoo();
      } else if (var1.equalsIgnoreCase("tie_msn")) {
         var3 = var2.getTiemsn();
      } else if (var1.equalsIgnoreCase("tie_skype")) {
         var3 = var2.getTieskype();
      } else if (var1.equalsIgnoreCase("tie_aol")) {
         var3 = var2.getTieaol();
      } else if (var1.equalsIgnoreCase("tie_mail1")) {
         var3 = var2.getTiemail1();
      } else if (var1.equalsIgnoreCase("tie_mail2")) {
         var3 = var2.getTiemail2();
      } else if (var1.equalsIgnoreCase("tie_mail3")) {
         var3 = var2.getTiemail3();
      } else if (var1.equalsIgnoreCase("tie_mail4")) {
         var3 = var2.getTiemail4();
      } else if (var1.equalsIgnoreCase("tie_mail5")) {
         var3 = var2.getTiemail5();
      } else if (var1.equalsIgnoreCase("tie_web")) {
         var3 = var2.getTieweb();
      } else if (var1.equalsIgnoreCase("tie_mode_reg")) {
         var3 = var2.getTiemodereg();
      } else if (var1.equalsIgnoreCase("tie_type_reg")) {
         if (var2.getTietypereg() == 0) {
            var3 = "sans calcul";
         } else if (var2.getTietypereg() == 1) {
            var3 = "paiement comptant";
         } else if (var2.getTietypereg() == 2) {
            var3 = "paiement terme date de facture";
         } else if (var2.getTietypereg() == 3) {
            var3 = "paiement terme fin de mois";
         }
      } else if (var1.equalsIgnoreCase("tie_nb_echeance")) {
         var3 = "" + var2.getTienbecheance();
      } else if (var1.equalsIgnoreCase("tie_nb_arrondi")) {
         var3 = "" + var2.getTienbarrondi();
      } else if (var1.equalsIgnoreCase("tie_journal_reg")) {
         var3 = var2.getTiejournalreg();
      } else if (var1.equalsIgnoreCase("tie_condition_reg")) {
         var3 = var2.getTieconditionreg();
      } else if (var1.equalsIgnoreCase("tie_plafond")) {
         var3 = "" + var2.getTieplafond();
      } else if (var1.equalsIgnoreCase("tie_depotavance")) {
         var3 = "" + var2.getTiedepotavance();
      } else if (var1.equalsIgnoreCase("tie_capatente")) {
         var3 = "" + var2.getTiecapatente();
      } else if (var1.equalsIgnoreCase("tie_plaf_patente")) {
         var3 = "" + var2.getTieplafpatente();
      } else if (var1.equalsIgnoreCase("tie_compte_bloque")) {
         if (var2.getTiecomptebloque() == 0) {
            var3 = "fonctionnel";
         } else if (var2.getTiecomptebloque() == 1) {
            var3 = "bloqué";
         }
      } else if (var1.equalsIgnoreCase("tie_nom_famille")) {
         var3 = var2.getTienomfamille();
      } else if (var1.equalsIgnoreCase("tie_serie")) {
         var3 = var2.getTieserie();
      } else if (var1.equalsIgnoreCase("tie_exo_douane")) {
         if (var2.getTieexodouane() == 0) {
            var3 = "non exonéré de douane";
         } else if (var2.getTiecomptebloque() == 1) {
            var3 = "exonéré de douane";
         }
      } else if (var1.equalsIgnoreCase("tie_exo_tva")) {
         if (var2.getTieexotva() == 0) {
            var3 = "non exonéré de tva";
         } else if (var2.getTieexotva() == 1) {
            var3 = "exonéré de tva";
         }
      } else if (var1.equalsIgnoreCase("tie_depot")) {
         var3 = var2.getTiedepot();
      } else if (var1.equalsIgnoreCase("tie_escompte")) {
         var3 = "" + var2.getTieescompte();
      } else if (var1.equalsIgnoreCase("tie_nom_banque")) {
         var3 = var2.getTienombanque();
      } else if (var1.equalsIgnoreCase("tie_adresse_banque")) {
         var3 = var2.getTieadressebanque();
      } else if (var1.equalsIgnoreCase("tie_num_banque")) {
         var3 = var2.getTienumbanque();
      } else if (var1.equalsIgnoreCase("tie_guichet_banque")) {
         var3 = var2.getTieguichetbanque();
      } else if (var1.equalsIgnoreCase("tie_compte_banque")) {
         var3 = var2.getTiecomptebanque();
      } else if (var1.equalsIgnoreCase("tie_cle_banque")) {
         var3 = var2.getTieclebanque();
      } else if (var1.equalsIgnoreCase("tie_iban")) {
         var3 = var2.getTieiban();
      } else if (var1.equalsIgnoreCase("tie_swift")) {
         var3 = var2.getTieswift();
      } else if (var1.equalsIgnoreCase("tie_compte_0")) {
         var3 = var2.getTiecompte0();
      } else if (var1.equalsIgnoreCase("tie_compte_1")) {
         var3 = var2.getTiecompte1();
      } else if (var1.equalsIgnoreCase("tie_compte_2")) {
         var3 = var2.getTiecompte2();
      } else if (var1.equalsIgnoreCase("tie_compte_3")) {
         var3 = var2.getTiecompte3();
      } else if (var1.equalsIgnoreCase("tie_compte_4")) {
         var3 = var2.getTiecompte4();
      } else if (var1.equalsIgnoreCase("tie_note_auto")) {
         var3 = "" + var2.getTienoteauto();
      } else if (var1.equalsIgnoreCase("tie_note_man")) {
         var3 = var2.getTienoteman();
      } else if (var1.equalsIgnoreCase("tie_num1")) {
         var3 = var2.getTienum1();
      } else if (var1.equalsIgnoreCase("tie_num2")) {
         var3 = var2.getTienum2();
      } else if (var1.equalsIgnoreCase("tie_num3")) {
         var3 = var2.getTienum3();
      } else if (var1.equalsIgnoreCase("tie_num4")) {
         var3 = var2.getTienum4();
      } else if (var1.equalsIgnoreCase("tie_num5")) {
         var3 = var2.getTienum5();
      } else if (var1.equalsIgnoreCase("tie_num6")) {
         var3 = var2.getTienum6();
      } else if (var1.equalsIgnoreCase("tie_num7")) {
         var3 = var2.getTienum7();
      } else if (var1.equalsIgnoreCase("tie_num8")) {
         var3 = var2.getTienum8();
      } else if (var1.equalsIgnoreCase("tie_num9")) {
         var3 = var2.getTienum9();
      } else if (var1.equalsIgnoreCase("tie_num10")) {
         var3 = var2.getTienum10();
      } else if (var1.equalsIgnoreCase("tie_num11")) {
         var3 = var2.getTienum11();
      } else if (var1.equalsIgnoreCase("tie_num12")) {
         var3 = var2.getTienum12();
      } else if (var1.equalsIgnoreCase("tie_num13")) {
         var3 = var2.getTienum13();
      } else if (var1.equalsIgnoreCase("tie_num14")) {
         var3 = var2.getTienum14();
      } else if (var1.equalsIgnoreCase("tie_num15")) {
         var3 = var2.getTienum15();
      } else if (var1.equalsIgnoreCase("tie_num16")) {
         var3 = var2.getTienum16();
      } else if (var1.equalsIgnoreCase("tie_num17")) {
         var3 = var2.getTienum17();
      } else if (var1.equalsIgnoreCase("tie_num18")) {
         var3 = var2.getTienum18();
      } else if (var1.equalsIgnoreCase("tie_num19")) {
         var3 = var2.getTienum19();
      } else if (var1.equalsIgnoreCase("tie_num20")) {
         var3 = var2.getTienum20();
      } else if (var1.equalsIgnoreCase("tie_pdv")) {
         var3 = var2.getTiepdv();
      } else if (var1.equalsIgnoreCase("tie_secteur")) {
         var3 = var2.getTiesecteur();
      } else if (var1.equalsIgnoreCase("tie_region")) {
         var3 = var2.getTieregion();
      } else if (var1.equalsIgnoreCase("tie_epoux")) {
         var3 = var2.getTieepoux();
      } else if (var1.equalsIgnoreCase("tie_nom_pere")) {
         var3 = var2.getTienompere();
      } else if (var1.equalsIgnoreCase("tie_nom_mere")) {
         var3 = var2.getTienommere();
      } else if (var1.equalsIgnoreCase("tie_ci_num")) {
         var3 = var2.getTiecinum();
      } else if (var1.equalsIgnoreCase("tie_ci_date")) {
         var3 = var2.getTiecidate();
      } else if (var1.equalsIgnoreCase("tie_ci_lieu")) {
         var3 = var2.getTiecilieu();
      } else if (var1.equalsIgnoreCase("tie_niveau_etude")) {
         var3 = var2.getTieniveauetude();
      } else if (var1.equalsIgnoreCase("tie_employeur")) {
         var3 = var2.getTieemployeur();
      } else if (var1.equalsIgnoreCase("tie_adresse_employeur")) {
         var3 = var2.getTieadresseemployeur();
      } else if (var1.equalsIgnoreCase("tie_bp_employeur")) {
         var3 = var2.getTiebpemployeur();
      } else if (var1.equalsIgnoreCase("tie_ville_employeur")) {
         var3 = var2.getTievilleemployeur();
      } else if (var1.equalsIgnoreCase("tie_tel_employeur")) {
         var3 = var2.getTietelemployeur();
      } else if (var1.equalsIgnoreCase("tie_sit_fam")) {
         if (var2.getTiesitfam() == 0) {
            var3 = "non renseigné";
         } else if (var2.getTiesitfam() == 1) {
            var3 = "célibataire";
         } else if (var2.getTiesitfam() == 2) {
            var3 = "marié";
         } else if (var2.getTiesitfam() == 3) {
            var3 = "concubin";
         } else if (var2.getTiesitfam() == 4) {
            var3 = "divorcé";
         } else if (var2.getTiesitfam() == 5) {
            var3 = "veuf";
         }
      } else if (var1.equalsIgnoreCase("tie_nb_charge")) {
         var3 = "" + var2.getTienbcharge();
      } else if (var1.equalsIgnoreCase("tie_nb_enf")) {
         var3 = "" + var2.getTienbenf();
      } else if (var1.equalsIgnoreCase("tie_habitation")) {
         if (var2.getTiehabitation() == 0) {
            var3 = "locataire";
         } else if (var2.getTiehabitation() == 1) {
            var3 = "propriétaire";
         }
      } else {
         var3 = "???";
      }

      return var3;
   }

   public String calculeZoneDocumentDevis(String var1, Tiers var2, DevisEnteteVentes var3) {
      String var4 = "";
      if (var1.equalsIgnoreCase("dvs_civil_tiers")) {
         if (var3.getDvsCivilContact() != null && !var3.getDvsCivilContact().isEmpty() && !var3.getDvsCivilContact().equalsIgnoreCase("autre")) {
            var4 = var3.getDvsCivilContact();
         } else {
            var4 = "Madame, Monsieur";
         }
      } else if (var1.equalsIgnoreCase("dvs_total_ht")) {
         var4 = this.utilNombre.myConvertStringSeperateur(var3.getDvsTotHt(), 2) + " " + var3.getDvsDevise();
      } else if (var1.equalsIgnoreCase("dvs_dte_validite")) {
         if (var3.getDvsDateValidite() != null) {
            var4 = this.utilDate.dateToStringFrLg(var3.getDvsDateValidite());
         } else {
            var4 = "Sans date de validité";
         }
      } else if (var1.equalsIgnoreCase("dvs_dte_livraison")) {
         var4 = "";
         if (var3.getDvsDateLivraison() != null) {
            int var5 = (int)((var3.getDvsDateLivraison().getTime() - var3.getDvsDate().getTime()) / 86400000L / 7L);
            var4 = var5 + " semaine(s)";
         }

         if (var3.getDvsInfoLivraison() != null && !var3.getDvsInfoLivraison().isEmpty()) {
            var4 = var4 + "  " + var3.getDvsInfoLivraison();
         }

         if (var4 == null || var4.isEmpty()) {
            var4 = "A déterminer";
         }
      } else if (var1.equalsIgnoreCase("dvs_condition_paiement")) {
         var4 = var3.getDvsConditionReg();
      } else {
         var4 = "???";
      }

      return var4;
   }

   public String calculeZonePatients(String var1, Patients var2) {
      String var3 = "";
      if (var1.equalsIgnoreCase("pat_nom")) {
         var3 = var2.getPatronyme();
      } else {
         var3 = "???";
      }

      return var3;
   }

   public String calculeZoneBail(String var1, BienBail var2) {
      String var3 = "";
      return var3;
   }
}
