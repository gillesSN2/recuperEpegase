package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.InfosSysteme;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.LireLesoptionsGroupe;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.LireLesoptionsParcs;
import com.epegase.systeme.xml.LireLesoptionsPaye;
import com.epegase.systeme.xml.LireLesoptionsStocks;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetGrilleSalaire;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionGroupe;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionPaye;
import com.epegase.systeme.xml.OptionStocks;
import com.epegase.systeme.xml.OptionTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.xml.sax.SAXException;

public class FormInfoSysteme implements Serializable {
   private int typeVente;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String nomTable;
   private String module;
   private transient DataModel datamodelTable = new ListDataModel();
   private List lesTables = new ArrayList();
   private InfosSysteme infosSysteme;
   private String var_type_os_serveur_local;
   private long tailleTotale;
   private long tailleBase;
   private int nombreTable;
   private int nombreTotalTable;
   private long tailleGenerale;
   private long tailleRep;
   private long nombreFile;
   private long nombreFileTotal;
   private List listDossier = new ArrayList();
   private transient DataModel datamodelDossier = new ListDataModel();
   private int type;
   private List listBases;
   private transient DataModel dataModelBases;
   private int etat;
   private int mode;
   private String pays;
   private boolean var_showBarProg;
   private int var_currentValue;
   private String var_info;
   private String nomStructureEnCours;

   public FormInfoSysteme() {
      if (StaticModePegase.getOsContext() == 0) {
         this.var_type_os_serveur_local = System.getProperty("os.name") + " " + System.getProperty("os.version");
      } else if (StaticModePegase.getOsContext() == 1) {
         this.var_type_os_serveur_local = System.getProperty("os.name") + " " + System.getProperty("os.version");
      } else if (StaticModePegase.getOsContext() == 2) {
         this.var_type_os_serveur_local = System.getProperty("os.name") + " " + System.getProperty("os.version");
      }

   }

   public List chargerListeTable(boolean var1, int var2) throws HibernateException, NamingException, SQLException, ClassNotFoundException, SAXException, IOException {
      this.nombreTotalTable = 0;
      this.lesTables = new ArrayList();
      new InfosSysteme();
      String var4 = "";
      String var5 = "";
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog);
      InfosSysteme var3 = new InfosSysteme();
      var5 = "Commun";
      var4 = "Espion";
      var3.setNomReel("cmm_espion");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Chrono";
      var3.setNomReel("cmm_chrono");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Users";
      var3.setNomReel("cmm_users");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "UsersFavoris";
      var3.setNomReel("cmm_users_favoris");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "UsersObjectifs";
      var3.setNomReel("cmm_users_objectifs");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "UsersChrono";
      var3.setNomReel("cmm_users_chrono");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Tiers";
      var3.setNomReel("cmm_tiers");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TiersTechnique";
      var3.setNomReel("cmm_tiers_technique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Contacts";
      var3.setNomReel("cmm_contacts");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Responsable";
      var3.setNomReel("cmm_responsable");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Equipes";
      var3.setNomReel("cmm_equipes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Structure";
      var3.setNomReel("cmm_structure");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ExercicesComptable";
      var3.setNomReel("cpt_exercices_comptable");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ExercicesVentes";
      var3.setNomReel("vte_exercices_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ExercicesAchats";
      var3.setNomReel("ach_exercices_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ExercicesParc";
      var3.setNomReel("prc_exercices_parc");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ExercicesCaisse";
      var3.setNomReel("cai_exercices_caisse");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ExercicesPaye";
      var3.setNomReel("pay_exercices_paye");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Habilitation";
      var3.setNomReel("cmm_habilitation");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Parapheur";
      var3.setNomReel("cmm_parapheur");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReunionEntete";
      var3.setNomReel("cmm_reunion_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReunionPresence";
      var3.setNomReel("cmm_reunion_presence");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReunionAction";
      var3.setNomReel("cmm_reunion_action");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Parc";
      var3.setNomReel("cmm_parc");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlansAnalytiques";
      var3.setNomReel("cmm_plan_analytique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlanAnalytiqueRepartition";
      var3.setNomReel("cmm_plan_analytique_repartition");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CleAnalytique";
      var3.setNomReel("cmm_cle_analytique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Activites";
      var3.setNomReel("cmm_activites");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Site";
      var3.setNomReel("cmm_site");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Departement";
      var3.setNomReel("cmm_departement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Service";
      var3.setNomReel("cmm_service");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProductionLigne";
      var3.setNomReel("cmm_production_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProductionAtelier";
      var3.setNomReel("cmm_production_atelier");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Region";
      var3.setNomReel("cmm_region");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Secteur";
      var3.setNomReel("cmm_secteur");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PointDeVente";
      var3.setNomReel("cmm_point_de_vente");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Ville";
      var3.setNomReel("cmm_ville");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Quartier";
      var3.setNomReel("cmm_quartier");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Cellule";
      var3.setNomReel("cmm_cellule");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Projets";
      var3.setNomReel("cmm_projets");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Groupe";
      var3.setNomReel("cmm_groupe");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "GroupeFavoris";
      var3.setNomReel("cmm_groupe_favoris");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "GroupeChrono";
      var3.setNomReel("cmm_groupe_chrono");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Bal";
      var3.setNomReel("cmm_bal");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Mails";
      var3.setNomReel("cmm_mails");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "MailsLu";
      var3.setNomReel("cmm_mails_lu");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "MailsPj";
      var3.setNomReel("cmm_mails_pj");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Rdv";
      var3.setNomReel("cmm_rdv");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Sms";
      var3.setNomReel("cmm_sms");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Devise";
      var3.setNomReel("cmm_devise");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Metiers";
      var3.setNomReel("cmm_metiers");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ModelesCourriers";
      var3.setNomReel("cmm_modele_courriers");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Marques";
      var3.setNomReel("cmm_marques");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Couleur";
      var3.setNomReel("cmm_couleur");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DouanesPosition";
      var3.setNomReel("cmm_douanes_position");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Produits";
      var3.setNomReel("cmm_produits");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsTarif";
      var3.setNomReel("cmm_produits_tarif");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Baremes";
      var3.setNomReel("cmm_baremes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsFournisseur";
      var3.setNomReel("cmm_produits_fournisseur");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsServices";
      var3.setNomReel("cmm_produits_services");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsMcles";
      var3.setNomReel("cmm_produits_mcles");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsHistoRef";
      var3.setNomReel("cmm_produits_histo_ref");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsGrp";
      var3.setNomReel("cmm_produits_grp");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsFrais";
      var3.setNomReel("cmm_produits_frais");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Unite";
      var3.setNomReel("cmm_unite");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Conditionnement";
      var3.setNomReel("cmm_conditionnement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Cadeaux";
      var3.setNomReel("cmm_cadeaux");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CertificationDocument";
      var3.setNomReel("cmm_certification_document");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Android";
      var3.setNomReel("cmm_android");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Comptabilité";
      var3 = new InfosSysteme();
      var4 = "Racines";
      var3.setNomReel("cpt_racines");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlanComptable";
      var3.setNomReel("cpt_plan_comptable");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ComplementInformations";
      var3.setNomReel("cpt_complement_informations");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LocalisationImmobilisation";
      var3.setNomReel("cpt_localisation_immobilisation");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Ecritures";
      var3.setNomReel("cpt_ecritures");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "EcrituresAnterieur";
      var3.setNomReel("cpt_ecritures_anterieur");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "EcrituresModeles";
      var3.setNomReel("cpt_ecritures_modeles");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "EcrituresModelesLignes";
      var3.setNomReel("cpt_ecritures_modeles_lignes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlansTresorerie";
      var3.setNomReel("cpt_plans_tresorerie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlansBudgetaires";
      var3.setNomReel("cpt_plan_budgetaire");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlanBudgetaireCompte";
      var3.setNomReel("cpt_plan_bugetaire_compte");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "JournauxComptables";
      var3.setNomReel("cpt_journaux_comptables");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "JournauxMois";
      var3.setNomReel("cpt_journaux_mois");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "JournauxJour";
      var3.setNomReel("cpt_journaux_jour");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Amortissements";
      var3.setNomReel("cpt_amortissements");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AmortissementReg";
      var3.setNomReel("cpt_amortissements_reg");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AmortissementTab";
      var3.setNomReel("cpt_amortissements_tab");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AmortissementInv";
      var3.setNomReel("cpt_amortissements_inv");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Budget";
      var3.setNomReel("cpt_budget");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BudgetLigne";
      var3.setNomReel("cpt_budget_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BudgetTresorerie";
      var3.setNomReel("cpt_budget_tresorerie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BudgetTresorerieLigne";
      var3.setNomReel("cpt_budget_tresorerie_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Brouillard";
      var3.setNomReel("cpt_brouillard");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "EcrituresAnalytique";
      var3.setNomReel("cpt_ecritures_analytiques");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "EcrituresDestroy";
      var3.setNomReel("cpt_ecritures_destroy");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Ecrituresanalytiquesdestroy";
      var3.setNomReel("cpt_ecritures_analytiques_destroy");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CptTabNom";
      var3.setNomReel("cpt_tab_nom");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CptTabElement";
      var3.setNomReel("cpt_tab_element");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CptTabFormule";
      var3.setNomReel("cpt_tab_formule");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TabResultats";
      var3.setNomReel("cpt_tab_resultats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "EcrituresNotes";
      var3.setNomReel("cpt_ecritures_notes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "RevueCompte";
      var3.setNomReel("cpt_revue_compte");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Achats";
      var3 = new InfosSysteme();
      var4 = "TaxesAchats";
      var3.setNomReel("ach_taxes_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FormulesAchats";
      var3.setNomReel("ach_formules_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FamillesProduitsAchats";
      var3.setNomReel("ach_familles_produits_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FraisTheoAchats";
      var3.setNomReel("ach_frais_theo_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsDepot";
      var3.setNomReel("cmm_produits_depot");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DepotAchats";
      var3.setNomReel("ach_depot");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DemandeEnteteAchats";
      var3.setNomReel("ach_demande_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DemandeLigneAchats";
      var3.setNomReel("ach_ligne_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CotationEnteteAchats";
      var3.setNomReel("ach_cotations_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CotationLigneAchats";
      var3.setNomReel("ach_cotations_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CommandeEnteteAchats";
      var3.setNomReel("ach_commande_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CommandeLigneAchats";
      var3.setNomReel("ach_commande_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReceptionEnteteAchats";
      var3.setNomReel("ach_reception_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReceptionLigneAchats";
      var3.setNomReel("ach_reception_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReceptionLotAchats";
      var3.setNomReel("ach_reception_lot");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReceptionSerieAchats";
      var3.setNomReel("ach_reception_serie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReceptionAvicultureAchats";
      var3.setNomReel("ach_reception_aviculture");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReacheminementEnteteAchats";
      var3.setNomReel("ach_reacheminement_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ReacheminementLigneAchats";
      var3.setNomReel("ach_reacheminement_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PumpAchats";
      var3.setNomReel("ach_pump");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureEnteteAchats";
      var3.setNomReel("ach_facture_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureLigneAchats";
      var3.setNomReel("ach_facture_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "RetourEnteteAchats";
      var3.setNomReel("ach_retour_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "RetourLigneAchats";
      var3.setNomReel("ach_retour_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "NoteDebitEnteteAchats";
      var3.setNomReel("ach_note_debit_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "NoteDebitLigneAchats";
      var3.setNomReel("ach_note_debit_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AvoirEnteteAchats";
      var3.setNomReel("ach_avoir_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AvoirLigneAchats";
      var3.setNomReel("ach_avoir_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FraisEnteteAchats";
      var3.setNomReel("ach_frais_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FraisLigneAchats";
      var3.setNomReel("ach_frais_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DocumentTraceAchats";
      var3.setNomReel("ach_document_trace_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ValorisationEnteteAchats";
      var3.setNomReel("ach_valorisation_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SommierEnteteAchats";
      var3.setNomReel("ach_sommier_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonDecaissementAchat";
      var3.setNomReel("ach_bon_decaissement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonEntreeEntete";
      var3.setNomReel("ach_bon_entree_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonEntreeLigne";
      var3.setNomReel("ach_bon_entree_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonSortieEntete";
      var3.setNomReel("ach_bon_sortie_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonSortieLigne";
      var3.setNomReel("ach_bon_sortie_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CessionEntete";
      var3.setNomReel("ach_cession_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CessionLigne";
      var3.setNomReel("ach_cession_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "InventaireEntete";
      var3.setNomReel("ach_inventaire_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "InventaireLigne";
      var3.setNomReel("ach_inventaire_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProcessEnteteAchats";
      var3.setNomReel("ach_process_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProcessLigneAchats";
      var3.setNomReel("ach_process_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FabricationEnteteAchats";
      var3.setNomReel("ach_fabrication_entete_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FabricationLigneAchats";
      var3.setNomReel("ach_fabrication_ligne_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlanningAvicultureAchats";
      var3.setNomReel("ach_planning_aviculture_achats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Ventes";
      var3 = new InfosSysteme();
      var4 = "TaxesVentes";
      var3.setNomReel("vte_taxes_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FamillesProduitsVentes";
      var3.setNomReel("vte_taxes_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FormulesVentes";
      var3.setNomReel("vte_formules_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SuiviLivraisonVentes";
      var3.setNomReel("vte_suivi_livraison_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BesoinEnteteVentes";
      var3.setNomReel("vte_besoin_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BesoinLigneVentes";
      var3.setNomReel("vte_besoin_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SimulationEnteteVentes";
      var3.setNomReel("vte_simulation_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DevisEnteteVentes";
      var3.setNomReel("vte_devis_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DevisLigneVentes";
      var3.setNomReel("vte_devis_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CommandeEnteteVentes";
      var3.setNomReel("vte_bcommande_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CommandeLigneVentes";
      var3.setNomReel("vte_bcommande_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LivraisonEnteteVentes";
      var3.setNomReel("vte_blivraison_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LivraisonLigneVentes";
      var3.setNomReel("vte_blivraison_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "RetourEnteteVentes";
      var3.setNomReel("vte_bretour_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "RetourLigneVentes";
      var3.setNomReel("vte_bretour_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureEnteteVentes";
      var3.setNomReel("vte_facture_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureLigneVentes";
      var3.setNomReel("vte_facture_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AvoirEnteteVentes";
      var3.setNomReel("vte_avoir_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AvoirLigneVentes";
      var3.setNomReel("vte_avoir_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "NoteDebitEnteteVentes";
      var3.setNomReel("vte_note_debit_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "NoteDebitLigneVentes";
      var3.setNomReel("vte_note_debit_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureInterneEnteteVentes";
      var3.setNomReel("vte_facture_interne_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureInterneLigneVentes";
      var3.setNomReel("vte_facture_interne_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DocumentTraceVentes";
      var3.setNomReel("vte_document_trace_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ChargementEntete";
      var3.setNomReel("vte_chargement_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ChargementLigne";
      var3.setNomReel("vte_chargement_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ChargementFrais";
      var3.setNomReel("vte_chargement_frais");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CommissionEnteteVentes";
      var3.setNomReel("vte_commission_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CommissionLigneVentes";
      var3.setNomReel("vte_commission_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TicketEnteteVentes";
      var3.setNomReel("vte_ticket_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TicketLigneVentes";
      var3.setNomReel("vte_ticket_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonEncaissementVente";
      var3.setNomReel("vte_bon_encaissement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ContratEnteteVentes";
      var3.setNomReel("vte_contrat_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ContratLigneVentes";
      var3.setNomReel("vte_contrat_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ContratEcheanceVentes";
      var3.setNomReel("vte_contrat_echeance");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CampagneEnteteVentes";
      var3.setNomReel("vte_campagne_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CampagneParticipantVentes";
      var3.setNomReel("vte_campagne_participant");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CampagneMessageVentes";
      var3.setNomReel("vte_campagne_message");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CampagneActionVentes";
      var3.setNomReel("vte_campagne_action");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Parc";
      var3 = new InfosSysteme();
      var4 = "FamillesParc1";
      var3.setNomReel("prc_familles_parc1");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FamillesParc2";
      var3.setNomReel("prc_familles_parc2");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Caracteristique";
      var3.setNomReel("prc_caracteristique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ParcCaracteristique";
      var3.setNomReel("prc_parc_caracteristique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ParcAffectation";
      var3.setNomReel("prc_parc_affectation");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "MotifEntreeParc";
      var3.setNomReel("prc_motif_entree");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ParcConsommation";
      var3.setNomReel("prc_parc_consommation");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LocalisationGps";
      var3.setNomReel("prc_localisation_gps");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ManifestEntete";
      var3.setNomReel("prc_manifest_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ManifestLigne";
      var3.setNomReel("prc_manifest_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ManifestProduit";
      var3.setNomReel("prc_manifest_produit");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ManifestEnteteImport";
      var3.setNomReel("prc_manifest_entete_import");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ManifestLigneImport";
      var3.setNomReel("prc_manifest_ligne_import");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TransitLieuVentes";
      var3.setNomReel("prc_transit_lieu_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TransitPortVentes";
      var3.setNomReel("prc_transit_port_ventes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ParcOrEntete";
      var3.setNomReel("prc_parc_or_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ParcOrPiece";
      var3.setNomReel("prc_parc_or_piece");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ParcLocationEntete";
      var3.setNomReel("prc_parc_location_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ParcLocationLigne";
      var3.setNomReel("prc_parc_location_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Caisse";
      var3 = new InfosSysteme();
      var4 = "CaissesCommerciales";
      var3.setNomReel("cai_caisses_commerciales");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CaissesMois";
      var3.setNomReel("cai_caisses_mois");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CaissesJour";
      var3.setNomReel("cai_caisses_jour");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CaissesInventaire";
      var3.setNomReel("cai_caisses_inventaire");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CaissesPrevision";
      var3.setNomReel("cai_caisses_prevision");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CaissesOperations";
      var3.setNomReel("cai_caisses_operations");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Reglements";
      var3.setNomReel("cai_reglements");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonEntreCaiss";
      var3.setNomReel("cai_bon_entree");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BonSortieCaiss";
      var3.setNomReel("cai_bon_sortie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "VirementInterne";
      var3.setNomReel("cai_virement_interne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TraiteEntete";
      var3.setNomReel("cai_traite_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TraiteLigne";
      var3.setNomReel("cai_traite_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Medical";
      var3 = new InfosSysteme();
      var4 = "ProtocoleMedical";
      var3.setNomReel("med_protocole");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LettreMedical";
      var3.setNomReel("med_lettre_medical");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PathologieMedical";
      var3.setNomReel("med_pathologie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "MotifEntreeMedical";
      var3.setNomReel("med_motif_entree");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CimMedical";
      var3.setNomReel("med_cim");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CmaMedical";
      var3.setNomReel("med_cma");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CmdMedical";
      var3.setNomReel("med_cmd");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CcamMedical";
      var3.setNomReel("med_ccam");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "NgapMedical";
      var3.setNomReel("med_ngap");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsDci";
      var3.setNomReel("med_produits_dci");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ProduitsMedicamment";
      var3.setNomReel("med_produits_medicamment");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "TiersAdherent";
      var3.setNomReel("med_tiers_adherent");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Patients";
      var3.setNomReel("med_patients");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PatientContact";
      var3.setNomReel("med_patient_contact");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PatientPec";
      var3.setNomReel("med_patient_pec");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PatientLettreGarantie";
      var3.setNomReel("med_patient_lettre_garantie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PatientProt";
      var3.setNomReel("med_patient_prot");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PatientAnt";
      var3.setNomReel("med_patient_ant");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ConsultationEnteteGene";
      var3.setNomReel("med_consultation_entete_gene");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ConsultationActes";
      var3.setNomReel("med_consultation_actes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ConsultationInfirmerie";
      var3.setNomReel("med_consultation_infirmerie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ConsultationOrdo";
      var3.setNomReel("med_consultation_ordo");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ConsultationLabo";
      var3.setNomReel("med_consultation_labo");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ConsultationReglement";
      var3.setNomReel("med_consultation_reglement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LaboratoireEntete";
      var3.setNomReel("med_laboratoire_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LaboratoireLigne";
      var3.setNomReel("med_laboratoire_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LaboratoireResultat";
      var3.setNomReel("med_laboratoire_resultat");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LaboratoireReglement";
      var3.setNomReel("med_laboratoire_reglement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PharmacieEntete";
      var3.setNomReel("med_pharmacie_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PharmacieLigne";
      var3.setNomReel("med_pharmacie_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PharmacieReglement";
      var3.setNomReel("med_pharmacie_reglement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationEntete";
      var3.setNomReel("med_hospitalisation_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationCaution";
      var3.setNomReel("med_hospitalisation_caution");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationSejour";
      var3.setNomReel("med_hospitalisation_sejour");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationActes";
      var3.setNomReel("med_hospitalisation_actes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationMedi";
      var3.setNomReel("med_hospitalisation_Medi");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationLabo";
      var3.setNomReel("med_hospitalisation_labo");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationPrest";
      var3.setNomReel("med_hospitalisation_prest");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "HospitalisationReglement";
      var3.setNomReel("med_hospitalisation_reglement");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DevisEnteteMedical";
      var3.setNomReel("med_devis_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DevisLigneMedical";
      var3.setNomReel("med_devis_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureEnteteMedical";
      var3.setNomReel("med_facture_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FactureLigneMedical";
      var3.setNomReel("med_facture_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "RecapitulatifMedical";
      var3.setNomReel("med_recapitulatif");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "RapportMedical";
      var3.setNomReel("med_rapport_medical");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Paye";
      var3 = new InfosSysteme();
      var4 = "Salaries";
      var3.setNomReel("pay_salaries");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesContrats";
      var3.setNomReel("pay_salaries_contrats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesGrh";
      var3.setNomReel("pay_salaries_grh");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesConges";
      var3.setNomReel("pay_salaries_conges");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesCapitalisation";
      var3.setNomReel("pay_salaries_capitalisation");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesPrets";
      var3.setNomReel("pay_salaries_prets");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesPretsLignes";
      var3.setNomReel("pay_salaries_prets_lignes");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesVariables";
      var3.setNomReel("pay_salaries_variables");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesHistorique";
      var3.setNomReel("pay_salaries_historique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesElements";
      var3.setNomReel("pay_salaries_elements");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesTaches";
      var3.setNomReel("pay_salaries_taches");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "PlanPaye";
      var3.setNomReel("pay_plan_paye");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FeuilleCalcul";
      var3.setNomReel("pay_feuille_calcul");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FeuilleCalculRubrique";
      var3.setNomReel("pay_feuille_calcul_rubrique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FeuilleCalculFormule";
      var3.setNomReel("pay_feuille_calcul_formule");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BulletinMois";
      var3.setNomReel("pay_bulletin_mois");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BulletinSalaire";
      var3.setNomReel("pay_bulletin_salaire");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BulletinLigne";
      var3.setNomReel("pay_bulletin_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "Missions";
      var3.setNomReel("pay_missions");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesMissions";
      var3.setNomReel("pay_salaries_missions");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesMissionsFrais";
      var3.setNomReel("pay_salaries_missions_frais");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "SalariesPointage";
      var3.setNomReel("pay_salaries_pointage");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CentreImpot";
      var3.setNomReel("pay_centre_impot");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "LocalisationSalarie";
      var3.setNomReel("pay_localisation_salarie");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BsoTabNom";
      var3.setNomReel("pay_tab_nom");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BsoTabElement";
      var3.setNomReel("bso_tab_element");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BsoTabFormule";
      var3.setNomReel("pay_tab_formule");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BsoResultats";
      var3.setNomReel("pay_tab_resultats");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CvSession";
      var3.setNomReel("pay_cv_session");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CvCriteres";
      var3.setNomReel("pay_cv_criteres");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CvAgents";
      var3.setNomReel("pay_cv_agents");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "CvAgentsCriteres";
      var3.setNomReel("pay_cv_agents_criteres");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Education";
      var3 = new InfosSysteme();
      var4 = "Eleves";
      var3.setNomReel("edu_eleves");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ElevesContact";
      var3.setNomReel("edu_eleves_contact");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FilieresEducation";
      var3.setNomReel("edu_filieres_education");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "FilieresMatieres";
      var3.setNomReel("edu_filieres_matieres");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ElevesInscription";
      var3.setNomReel("edu_eleves_inscription");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ElevesFacture";
      var3.setNomReel("edu_eleves_facture");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ElevesAppels";
      var3.setNomReel("edu_eleves_appels");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ElevesViolences";
      var3.setNomReel("edu_eleves_violences");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ElevesNote";
      var3.setNomReel("edu_eleves_note");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ClassementMediatheque";
      var3.setNomReel("edu_classement_mediatheque");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "DocumentMediatheque";
      var3.setNomReel("edu_document_mediatheque");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Immobilier";
      var3 = new InfosSysteme();
      var4 = "Bien";
      var3.setNomReel("imm_bien");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienBail";
      var3.setNomReel("imm_bien_bail");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienHistorique";
      var3.setNomReel("imm_bien_historique");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienGeranceEntete";
      var3.setNomReel("imm_bien_gerance_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienGeranceLigne";
      var3.setNomReel("imm_bien_gerance_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienTravauxEntete";
      var3.setNomReel("imm_bien_travaux_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienTravauxLigne";
      var3.setNomReel("imm_bien_travaux_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienFacture";
      var3.setNomReel("imm_bien_facture");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienBudgetEntete";
      var3.setNomReel("imm_bien_budget_entete");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienBudgetLigne";
      var3.setNomReel("imm_bien_budget_ligne");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "AppelCharge";
      var3.setNomReel("imm_appel_charge");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "BienPv";
      var3.setNomReel("imm_bien_pv");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var5 = "Foret";
      var3 = new InfosSysteme();
      var4 = "ForetInventaire";
      var3.setNomReel("wod_foret_inventaire");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ForetCarnet";
      var3.setNomReel("wod_foret_carnet");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      var3 = new InfosSysteme();
      var4 = "ForetGrume";
      var3.setNomReel("wod_foret_grume");
      var3.setModule(var5);
      var3.setNomTable(var4);
      var3.setNbRecords((long)this.calculeInfosTables(var4, var6));
      if (var3.getNbRecords() != 0L) {
         this.lesTables.add(var3);
      }

      if (!var1) {
         this.utilInitHibernate.closeSession();
      } else {
         if (var2 >= 1) {
            this.majOptions(var6);
         }

         this.utilInitHibernate.closeSession();
         this.calculeTailleTable();
         this.datamodelTable.setWrappedData(this.lesTables);
         this.calculeTailleDossier();
         this.calculTotal();
      }

      return this.lesTables;
   }

   public void changeStructure(String var1, int var2) throws HibernateException, NamingException, SQLException, ClassNotFoundException, SAXException, IOException {
      this.baseLog = var1;
      this.chargerListeTable(true, var2);
   }

   public void changeePegase() throws HibernateException, NamingException, SQLException, ClassNotFoundException, SAXException, IOException {
      Session var1 = this.utilInitHibernate.getSystemeReorgansation();
      this.utilInitHibernate.closeSession();
   }

   public void majOptions(Session var1) throws SAXException, IOException, HibernateException, NamingException {
      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + this.structureLog.getStrid() + ".xml");
      if (var2.exists()) {
         LireLesoptionsGroupe var3 = new LireLesoptionsGroupe();
         var3.setStrId(this.structureLog.getStrid());
         new OptionGroupe();
         OptionGroupe var4 = var3.lancerExploitation();
         var3.setOptionGroupe(var4);
         var3.creerOptionGroupe(0);
      }

      String var16 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator;
      File var17 = new File(var16);
      if (var17.exists()) {
         boolean var5 = false;
         Object var6 = null;
         LireLesoptionsTiers var7 = new LireLesoptionsTiers();
         new OptionTiers();
         var7.setStrId(this.structureLog.getStrid());
         OptionTiers var8 = var7.lancer();
         FormOptionsOffice var9 = new FormOptionsOffice();
         var9.setLabase(this.baseLog);
         var9.setStructureLog(this.structureLog);
         var9.setUserlog(this.usersLog);
         var9.setOptionTiers(var8);
         var9.creerOptionTiers();
         var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
         int var18 = Integer.parseInt(var6.toString());
         if (var18 != 0) {
            LireLesoptionsCompta var10 = new LireLesoptionsCompta(this.structureLog);
            new OptionComptabilite();
            var10.setStrId(this.structureLog.getStrid());
            OptionComptabilite var11 = var10.lancer();
            FormOptionComptabilite var12 = new FormOptionComptabilite();
            var12.setBaseLog(this.baseLog);
            var12.setStructureLog(this.structureLog);
            var12.setUsersLog(this.usersLog);
            var12.setOptionComptabilite(var11);
            var12.setMesClassesAnalytiques(var10.getMesClassesAnalytiques());
            var12.setMesClassesBudgets(var10.getMesClassesBudgets());
            var12.setMesCentralisations(var10.getMesCentralisations());
            var12.creerOptioncompta();
         }

         var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesAchats").uniqueResult();
         var18 = Integer.parseInt(var6.toString());
         if (var18 != 0) {
            LireLesoptionsAchats var19 = new LireLesoptionsAchats();
            new OptionAchats();
            var19.setStrId(this.structureLog.getStrid());
            OptionAchats var22 = var19.lancer();
            FormOptionsAchats var28 = new FormOptionsAchats();
            var28.setBaseLog(this.baseLog);
            var28.setStructureLog(this.structureLog);
            var28.setUsersLog(this.usersLog);
            var28.setOptionAchats(var22);
            var28.updateOptionAchats();
            LireLesoptionsStocks var13 = new LireLesoptionsStocks();
            new OptionStocks();
            var13.setStrId(this.structureLog.getStrid());
            OptionStocks var14 = var13.lancer();
            FormOptionsStocks var15 = new FormOptionsStocks();
            var15.setBaseLog(this.baseLog);
            var15.setStructureLog(this.structureLog);
            var15.setUsersLog(this.usersLog);
            var15.setOptionStocks(var14);
            var15.updateOptionStocks();
         }

         var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesVentes").uniqueResult();
         var18 = Integer.parseInt(var6.toString());
         if (var18 != 0) {
            if (this.typeVente == 815) {
               LireLesoptionsMedical var20 = new LireLesoptionsMedical();
               new OptionMedical();
               var20.setStrId(this.structureLog.getStrid());
               OptionMedical var24 = var20.lancer();
               FormOptionsMedical var30 = new FormOptionsMedical();
               var30.setBaseLog(this.baseLog);
               var30.setStructureLog(this.structureLog);
               var30.setUsersLog(this.usersLog);
               var30.setOptionMedical(var24);
               var30.updateOptionMedical();
            } else {
               LireLesoptionsVentes var21 = new LireLesoptionsVentes();
               new OptionVentes();
               var21.setStrId(this.structureLog.getStrid());
               OptionVentes var26 = var21.lancer();
               FormOptionsVentes var32 = new FormOptionsVentes(this.structureLog);
               var32.setBaseLog(this.baseLog);
               var32.setStructureLog(this.structureLog);
               var32.setUsersLog(this.usersLog);
               var32.setOptionVentes(var26);
               var32.updateOptionsVentes();
            }
         }

         var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesCaisse").uniqueResult();
         var18 = Integer.parseInt(var6.toString());
         if (var18 != 0) {
            LireLesoptionsCaisses var23 = new LireLesoptionsCaisses();
            new OptionCaisses();
            var23.setStrId(this.structureLog.getStrid());
            OptionCaisses var29 = var23.lancer();
            FormOptionsCaisse var34 = new FormOptionsCaisse();
            var34.setBaseLog(this.baseLog);
            var34.setStructureLog(this.structureLog);
            var34.setUsersLog(this.usersLog);
            var34.setOptionCaisses(var29);
            var34.creerOptionsCaisses();
         }

         var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesPaye").uniqueResult();
         var18 = Integer.parseInt(var6.toString());
         if (var18 != 0) {
            LireLesoptionsPaye var25 = new LireLesoptionsPaye();
            new OptionPaye();
            var25.setStrId(this.structureLog.getStrid());
            OptionPaye var31 = var25.lancer();
            FormOptionsPaye var35 = new FormOptionsPaye();
            var35.setBaseLog(this.baseLog);
            var35.setStructureLog(this.structureLog);
            var35.setUsersLog(this.usersLog);
            var35.setOptionPaye(var31);
            var35.updateOptionPaye();
         }

         var6 = var1.createQuery("SELECT COUNT(*) FROM ExercicesParc").uniqueResult();
         var18 = Integer.parseInt(var6.toString());
         if (var18 != 0) {
            LireLesoptionsParcs var27 = new LireLesoptionsParcs();
            new OptionParcs();
            var27.setStrId(this.structureLog.getStrid());
            OptionParcs var33 = var27.lancer();
            FormOptionsParc var36 = new FormOptionsParc();
            var36.setBaseLog(this.baseLog);
            var36.setStructureLog(this.structureLog);
            var36.setUsersLog(this.usersLog);
            var36.setOptionParcs(var33);
            var36.creerOptionParc();
         }
      }

   }

   public void chargerListeTableDistant() throws HibernateException, NamingException, SQLException, ClassNotFoundException {
      if (this.lesTables.size() != 0) {
         Session var1 = this.utilInitHibernate.getSystemeEPegaseGlobal(this.baseLog);
         if (var1 != null) {
            for(int var2 = 0; var2 < this.lesTables.size(); ++var2) {
               this.infosSysteme = (InfosSysteme)this.lesTables.get(var2);
               this.infosSysteme.setNbRecordsDistant((long)this.calculeInfosTables(this.infosSysteme.getNomTable(), var1));
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public int calculeInfosTables(String var1, Session var2) {
      ++this.nombreTotalTable;
      boolean var3 = false;
      Object var4 = var2.createQuery("SELECT COUNT(*) FROM " + var1).uniqueResult();
      int var5 = Integer.parseInt(var4.toString());
      return var5;
   }

   public void calculeTailleTable() throws HibernateException, NamingException, SQLException, ClassNotFoundException {
      if (this.lesTables.size() != 0) {
         ArrayList var1 = new ArrayList();

         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection var2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/epegase?autoReconnect=true", this.utilInitHibernate.getUser(), this.utilInitHibernate.getPw());
            Statement var3 = var2.createStatement(1004, 1008);
            String var4 = "SELECT TABLE_SCHEMA, TABLE_NAME, DATA_LENGTH, INDEX_LENGTH FROM information_schema.TABLES WHERE TABLE_SCHEMA = '" + this.baseLog + "'";
            ResultSet var5 = var3.executeQuery(var4);
            new ObjetGrilleSalaire();

            for(int var7 = 1; var5.next(); ++var7) {
               ObjetGrilleSalaire var6 = new ObjetGrilleSalaire();
               var6.setLib_FR(var5.getString("TABLE_SCHEMA"));
               var6.setLib_UK(var5.getString("TABLE_NAME"));
               String var8 = (String)var6.getLib_UK().subSequence(4, var6.getLib_UK().length());
               String var9 = "";
               if (var8.contains("_")) {
                  for(int var10 = 0; var10 < var8.length(); ++var10) {
                     if (!var8.substring(var10, var10 + 1).equals("_")) {
                        var9 = var9 + var8.substring(var10, var10 + 1);
                     }
                  }
               } else {
                  var9 = var8;
               }

               var6.setLib_UK(var9);
               var6.setLogement(Double.parseDouble(var5.getString("DATA_LENGTH")));
               var6.setTelephone(Double.parseDouble(var5.getString("INDEX_LENGTH")));
               var1.add(var6);
            }

            var3.close();
         } catch (Exception var11) {
            var11.printStackTrace();
         }

         this.infosSysteme = new InfosSysteme();

         for(int var12 = 0; var12 < this.lesTables.size(); ++var12) {
            this.infosSysteme = (InfosSysteme)this.lesTables.get(var12);
            if (this.infosSysteme.getNomReel().contains("taches")) {
               boolean var13 = false;
            }

            double var14 = 0.0D;
            boolean var15 = false;
            if (var1.size() != 0) {
               for(int var16 = 0; var16 < var1.size(); ++var16) {
                  if (((ObjetGrilleSalaire)var1.get(var16)).getLib_UK().equalsIgnoreCase(this.infosSysteme.getNomTable())) {
                     var14 = ((ObjetGrilleSalaire)var1.get(var16)).getLogement() + ((ObjetGrilleSalaire)var1.get(var16)).getTelephone();
                     var15 = true;
                     break;
                  }
               }
            }

            if (var15) {
               long var17 = (new Double(var14)).longValue() / 1024L;
               this.infosSysteme.setTaille(var17);
            }
         }
      }

   }

   public void calculeTailleDossier() {
      this.tailleTotale = 0L;
      this.tailleRep = 0L;
      this.nombreFile = 0L;
      this.nombreFileTotal = 0L;
      this.listDossier.clear();
      ArrayList var1 = new ArrayList();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator;
      File var3 = new File(var2);
      if (var3.exists()) {
         this.listeRepertoire(new File(var2), var1);
         new InfosSysteme();
         if (this.listDossier.size() != 0) {
            InfosSysteme var4;
            for(int var5 = 0; var5 < this.listDossier.size(); ++var5) {
               var4 = (InfosSysteme)this.listDossier.get(var5);
               if (var4 != null && var4.getNomTable() != null && !var4.getNomTable().isEmpty() && var4.getNomTable().contains("/")) {
                  String[] var6 = var4.getNomTable().split("/");
                  if (var6.length >= 4) {
                     var4.setModule(var6[2]);
                     if (var4.getNomTable().contains("commun/accueil") && var6.length >= 5) {
                        var4.setNomTable(var6[4] + ":" + var6[5]);
                     } else if (!var4.getNomTable().contains("/photos/marque/pdf") && (!var4.getNomTable().contains("/photos/produits/pdf") || var6.length < 5)) {
                        if (!var4.getNomTable().contains("/photos/marque/photo") && (!var4.getNomTable().contains("/photos/produits/photo") || var6.length < 5)) {
                           if (var4.getNomTable().contains("/photos") && !var4.getNomTable().contains("/photos/marque/photo") && !var4.getNomTable().contains("/photos/marque/pdf") && !var4.getNomTable().contains("/photos/produits/photo") && !var4.getNomTable().contains("/photos/produits/pdf") && var6.length >= 4) {
                              var4.setNomTable(var6[3] + ":" + var6[4]);
                           } else {
                              var4.setNomTable(var6[3]);
                           }
                        } else {
                           var4.setNomTable(var6[3] + ":" + var6[4] + ":" + var6[5]);
                        }
                     } else {
                        var4.setNomTable(var6[3] + ":" + var6[4] + ":" + var6[5]);
                     }
                  }
               }
            }

            ArrayList var19 = new ArrayList();

            int var20;
            for(var20 = 0; var20 < this.listDossier.size(); ++var20) {
               var4 = (InfosSysteme)this.listDossier.get(var20);
               String var7 = var4.getNomTable();
               long var8 = var4.getNbRecords();
               long var10 = var4.getTaille();
               if (var19.size() == 0) {
                  var19.add(var4);
               } else {
                  boolean var12 = false;

                  for(int var13 = 0; var13 < var19.size(); ++var13) {
                     new InfosSysteme();
                     InfosSysteme var14 = (InfosSysteme)var19.get(var13);
                     if (var14.getNomTable().equals(var7)) {
                        long var15 = var14.getNbRecords();
                        long var17 = var14.getTaille();
                        var14.setNbRecords(var15 + var8);
                        var14.setTaille(var17 + var10);
                        var12 = true;
                        break;
                     }
                  }

                  if (!var12) {
                     var19.add(var4);
                  }
               }
            }

            this.listDossier.clear();
            if (var19.size() != 0) {
               for(var20 = 0; var20 < var19.size(); ++var20) {
                  var4 = (InfosSysteme)var19.get(var20);
                  this.listDossier.add(var4);
               }
            }
         }
      }

      this.datamodelDossier.setWrappedData(this.listDossier);
   }

   public void listeRepertoire(File var1, List var2) {
      if (var1.isDirectory()) {
         File[] var3 = var1.listFiles();
         if (var3 != null) {
            this.tailleRep = 0L;
            this.nombreFile = 0L;

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].exists()) {
                  this.listeRepertoire(var3[var4], var2);
               }
            }

            if (this.tailleRep != 0L) {
               this.infosSysteme = new InfosSysteme();
               this.infosSysteme.setNomTable(var1.toString());
               this.infosSysteme.setTaille(this.tailleRep);
               this.infosSysteme.setNbRecords(this.nombreFile);
               this.listDossier.add(this.infosSysteme);
            }

            this.tailleRep = 0L;
            this.nombreFile = 0L;
         }
      } else {
         String var5 = var1.getAbsolutePath();
         File var6 = new File(var5);
         this.tailleRep += var6.length() / 1024L;
         ++this.nombreFile;
         var2.add(var5);
      }

   }

   public void calculTotal() {
      this.nombreFileTotal = 0L;
      this.tailleTotale = 0L;
      this.tailleBase = 0L;
      this.tailleGenerale = 0L;
      int var1;
      if (this.lesTables.size() != 0) {
         for(var1 = 0; var1 < this.lesTables.size(); ++var1) {
            this.tailleBase += ((InfosSysteme)this.lesTables.get(var1)).getTaille();
         }
      }

      this.nombreTable = this.lesTables.size();
      if (this.listDossier.size() != 0) {
         for(var1 = 0; var1 < this.listDossier.size(); ++var1) {
            this.tailleTotale += ((InfosSysteme)this.listDossier.get(var1)).getTaille();
            this.nombreFileTotal += ((InfosSysteme)this.listDossier.get(var1)).getNbRecords();
         }
      }

      this.tailleGenerale = this.tailleBase + this.tailleTotale;
   }

   public void chargerListeBaseReorganisation() throws HibernateException, NamingException {
      this.listBases = new ArrayList();
      this.dataModelBases = new ListDataModel();
      this.dataModelBases.setWrappedData(this.listBases);
      this.etat = 9;
      this.mode = 9;
      this.pays = "0";
      this.type = 1;
   }

   public void chargerLesSocietes() throws HibernateException, NamingException {
      String var1 = " where strId> 0";
      if (this.etat != 9) {
         var1 = var1 + " and  stretat=" + this.etat;
      }

      if (this.mode != 9) {
         var1 = var1 + " and  strmode=" + this.mode;
      }

      if (!this.pays.equals("0")) {
         var1 = var1 + " and  strnompays=" + "'" + this.pays + "'";
      }

      StructureDao var2 = new StructureDao(this.utilInitHibernate);
      this.listBases.clear();
      this.listBases = var2.selectStructurePeg(var1);
      this.dataModelBases.setWrappedData(this.listBases);
   }

   public void toutSelectionner() {
      new StructurePeg();

      for(int var2 = 0; var2 < this.listBases.size(); ++var2) {
         StructurePeg var1 = (StructurePeg)this.listBases.get(var2);
         var1.setSelectStructure(true);
      }

   }

   public void rienSelectionner() {
      new StructurePeg();

      for(int var2 = 0; var2 < this.listBases.size(); ++var2) {
         StructurePeg var1 = (StructurePeg)this.listBases.get(var2);
         var1.setSelectStructure(false);
      }

   }

   public void reorganisationBases() throws IOException, HibernateException, NamingException, Exception {
      if (this.listBases.size() != 0) {
         this.var_showBarProg = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des structures en cours...";
         ArrayList var1 = new ArrayList();

         for(int var2 = 0; var2 < this.listBases.size(); ++var2) {
            if (((StructurePeg)this.listBases.get(var2)).isSelectStructure()) {
               var1.add(this.listBases.get(var2));
            }
         }

         if (var1.size() != 0) {
            new StructurePeg();

            for(int var3 = 0; var3 < var1.size(); ++var3) {
               StructurePeg var4 = (StructurePeg)var1.get(var3);
               if (var3 != 0) {
                  this.var_currentValue = 100 / (var1.size() / var3);
               }

               this.nomStructureEnCours = "structure" + var4.getStrId();
               this.var_info = "Informations Systemes: " + this.nomStructureEnCours + "  soit " + (var3 + 1) + "/" + var1.size();
               this.changeStructure(this.nomStructureEnCours, 0);
            }
         }

         this.nomStructureEnCours = this.baseLog;
         this.var_info = "Informations Systemes: " + this.nomStructureEnCours + " (base maitre)";
         this.changeStructure(this.nomStructureEnCours, 1);
         this.var_showBarProg = false;
      }

   }

   public DataModel getDatamodelTable() {
      return this.datamodelTable;
   }

   public void setDatamodelTable(DataModel var1) {
      this.datamodelTable = var1;
   }

   public InfosSysteme getInfosSysteme() {
      return this.infosSysteme;
   }

   public void setInfosSysteme(InfosSysteme var1) {
      this.infosSysteme = var1;
   }

   public List getLesTables() {
      return this.lesTables;
   }

   public void setLesTables(List var1) {
      this.lesTables = var1;
   }

   public String getModule() {
      return this.module;
   }

   public void setModule(String var1) {
      this.module = var1;
   }

   public String getNomTable() {
      return this.nomTable;
   }

   public void setNomTable(String var1) {
      this.nomTable = var1;
   }

   public String getVar_type_os_serveur_local() {
      return this.var_type_os_serveur_local;
   }

   public void setVar_type_os_serveur_local(String var1) {
      this.var_type_os_serveur_local = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public DataModel getDatamodelDossier() {
      return this.datamodelDossier;
   }

   public void setDatamodelDossier(DataModel var1) {
      this.datamodelDossier = var1;
   }

   public long getTailleTotale() {
      return this.tailleTotale;
   }

   public void setTailleTotale(long var1) {
      this.tailleTotale = var1;
   }

   public long getTailleBase() {
      return this.tailleBase;
   }

   public void setTailleBase(long var1) {
      this.tailleBase = var1;
   }

   public long getTailleGenerale() {
      return this.tailleGenerale;
   }

   public void setTailleGenerale(long var1) {
      this.tailleGenerale = var1;
   }

   public long getNombreFileTotal() {
      return this.nombreFileTotal;
   }

   public void setNombreFileTotal(long var1) {
      this.nombreFileTotal = var1;
   }

   public int getNombreTable() {
      return this.nombreTable;
   }

   public void setNombreTable(int var1) {
      this.nombreTable = var1;
   }

   public int getNombreTotalTable() {
      return this.nombreTotalTable;
   }

   public void setNombreTotalTable(int var1) {
      this.nombreTotalTable = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelBases() {
      return this.dataModelBases;
   }

   public void setDataModelBases(DataModel var1) {
      this.dataModelBases = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public int getMode() {
      return this.mode;
   }

   public void setMode(int var1) {
      this.mode = var1;
   }

   public String getPays() {
      return this.pays;
   }

   public void setPays(String var1) {
      this.pays = var1;
   }
}
