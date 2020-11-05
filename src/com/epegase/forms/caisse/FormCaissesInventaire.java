package com.epegase.forms.caisse;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesInventaire;
import com.epegase.systeme.classe.CaissesJour;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesInventaireDao;
import com.epegase.systeme.dao.CaissesJourDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionCaisses;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormCaissesInventaire implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private OptionCaisses optionCaisses;
   private ExercicesCaisse selectedExo;
   private ExercicesCaisse lastExo;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private EspionDao espionDao;
   private int inpEtat = 0;
   private Date dateDebut;
   private Date dateFin;
   private String inpService = "100";
   private CalculChrono calculChrono;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private List mesCaissesItems = new ArrayList();
   private transient DataModel dataModelInventaire = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesCaissesInventaire = new ArrayList();
   private CaissesInventaireDao caissesInventaireDao;
   private CaissesInventaire caissesInventaire = new CaissesInventaire();
   private boolean visibiliteBton = false;
   private String inpCaisse = "100";
   private String var_caisse;
   private boolean var_valide = false;
   private List mesCaisseControlItems = new ArrayList();
   private CaissesJourDao caissesJourDao;
   private CaissesJour caissesJour;
   private String inputTypReglment;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private boolean champCltVide = false;
   private boolean var_acc_descriptif = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean visibleOnglet = false;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_choix_modele = 0;
   private String nomModeleDocument;
   private String nomModeleListe;
   private boolean visibleOptionMail = false;
   private List mesModesleRecus = new ArrayList();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean showModalPanelPrint = false;
   private Habilitation habilitation;
   private HabilitationDao habilitationDao;
   private Parapheur parapheur;
   private ParapheurDao parapheurDao;
   private int val_b1 = 0;
   private int val_b2 = 0;
   private int val_b3 = 0;
   private int val_b4 = 0;
   private int val_b5 = 0;
   private int val_b6 = 0;
   private int val_b7 = 0;
   private int val_b8 = 0;
   private int val_b9 = 0;
   private int val_b10 = 0;
   private int val_p1 = 0;
   private int val_p2 = 0;
   private int val_p3 = 0;
   private int val_p4 = 0;
   private int val_p5 = 0;
   private int val_p6 = 0;
   private int val_p7 = 0;
   private int val_p8 = 0;
   private int val_p9 = 0;
   private int val_p10 = 0;
   private double tot_b1 = 0.0D;
   private double tot_b2 = 0.0D;
   private double tot_b3 = 0.0D;
   private double tot_b4 = 0.0D;
   private double tot_b5 = 0.0D;
   private double tot_b6 = 0.0D;
   private double tot_b7 = 0.0D;
   private double tot_b8 = 0.0D;
   private double tot_b9 = 0.0D;
   private double tot_b10 = 0.0D;
   private double tot_p1 = 0.0D;
   private double tot_p2 = 0.0D;
   private double tot_p3 = 0.0D;
   private double tot_p4 = 0.0D;
   private double tot_p5 = 0.0D;
   private double tot_p6 = 0.0D;
   private double tot_p7 = 0.0D;
   private double tot_p8 = 0.0D;
   private double tot_p9 = 0.0D;
   private double tot_p10 = 0.0D;
   private double totalBillet = 0.0D;
   private double totalPiece = 0.0D;
   private String devise1 = "*";
   private String devise2 = "*";
   private String devise3 = "*";
   private String devise4 = "*";
   private String devise5 = "*";
   private double totalDevise = 0.0D;
   private double ecart = 0.0D;
   private double soldeCorrection;
   private double soldeFinalEspece;
   private double soldeFinalCheque;
   private double soldeFinalVirement;
   private double soldeFinalTraite;
   private double soldeFinalTpe;
   private double soldeFinalTransfert;
   private double soldeFinalePaiement;
   private double soldeFinalCredoc;
   private double soldeFinalFactor;
   private double soldeFinalCompense;
   private double soldeFinalTerme;
   private double soldeFinalBonCaisse;
   private double tot_b1_reel = 0.0D;
   private double tot_b2_reel = 0.0D;
   private double tot_b3_reel = 0.0D;
   private double tot_b4_reel = 0.0D;
   private double tot_b5_reel = 0.0D;
   private double tot_b6_reel = 0.0D;
   private double tot_b7_reel = 0.0D;
   private double tot_b8_reel = 0.0D;
   private double tot_b9_reel = 0.0D;
   private double tot_b10_reel = 0.0D;
   private double tot_p1_reel = 0.0D;
   private double tot_p2_reel = 0.0D;
   private double tot_p3_reel = 0.0D;
   private double tot_p4_reel = 0.0D;
   private double tot_p5_reel = 0.0D;
   private double tot_p6_reel = 0.0D;
   private double tot_p7_reel = 0.0D;
   private double tot_p8_reel = 0.0D;
   private double tot_p9_reel = 0.0D;
   private double tot_p10_reel = 0.0D;
   private double totalBillet_reel = 0.0D;
   private double totalPiece_reel = 0.0D;
   private double totalDevise_reel = 0.0D;
   private double ecart_reel = 0.0D;
   private double tot_b1_ecart = 0.0D;
   private double tot_b2_ecart = 0.0D;
   private double tot_b3_ecart = 0.0D;
   private double tot_b4_ecart = 0.0D;
   private double tot_b5_ecart = 0.0D;
   private double tot_b6_ecart = 0.0D;
   private double tot_b7_ecart = 0.0D;
   private double tot_b8_ecart = 0.0D;
   private double tot_b9_ecart = 0.0D;
   private double tot_b10_ecart = 0.0D;
   private double tot_p1_ecart = 0.0D;
   private double tot_p2_ecart = 0.0D;
   private double tot_p3_ecart = 0.0D;
   private double tot_p4_ecart = 0.0D;
   private double tot_p5_ecart = 0.0D;
   private double tot_p6_ecart = 0.0D;
   private double tot_p7_ecart = 0.0D;
   private double tot_p8_ecart = 0.0D;
   private double tot_p9_ecart = 0.0D;
   private double tot_p10_ecart = 0.0D;
   private double totalBillet_ecart = 0.0D;
   private double totalPiece_ecart = 0.0D;
   private double totalDevise_ecart = 0.0D;
   private double ecart_ecart = 0.0D;

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.caissesInventaireDao = new CaissesInventaireDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      this.caissesJourDao = new CaissesJourDao(this.baseLog, this.utilInitHibernate);
   }

   public void configCaisses(Session var1) throws HibernateException, NamingException, ParseException {
      this.visibiliteBton = false;
      if (this.optionCaisses.getNbLigneMax() != null && !this.optionCaisses.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionCaisses.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.inpEtat = 0;
      this.mesCaissesItems.clear();
      this.mesCaissesItems = this.caissesCommercialesDao.selectActifCaisseItems(var1);
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.dateFin = this.utilDate.dateDernierJourMois(new Date());
      if (this.optionCaisses.getB1() != null && !this.optionCaisses.getB1().isEmpty()) {
         this.val_b1 = Integer.parseInt(this.optionCaisses.getB1());
      }

      if (this.optionCaisses.getB2() != null && !this.optionCaisses.getB2().isEmpty()) {
         this.val_b2 = Integer.parseInt(this.optionCaisses.getB2());
      }

      if (this.optionCaisses.getB3() != null && !this.optionCaisses.getB3().isEmpty()) {
         this.val_b3 = Integer.parseInt(this.optionCaisses.getB3());
      }

      if (this.optionCaisses.getB4() != null && !this.optionCaisses.getB4().isEmpty()) {
         this.val_b4 = Integer.parseInt(this.optionCaisses.getB4());
      }

      if (this.optionCaisses.getB5() != null && !this.optionCaisses.getB5().isEmpty()) {
         this.val_b5 = Integer.parseInt(this.optionCaisses.getB5());
      }

      if (this.optionCaisses.getB6() != null && !this.optionCaisses.getB6().isEmpty()) {
         this.val_b6 = Integer.parseInt(this.optionCaisses.getB6());
      }

      if (this.optionCaisses.getB7() != null && !this.optionCaisses.getB7().isEmpty()) {
         this.val_b7 = Integer.parseInt(this.optionCaisses.getB7());
      }

      if (this.optionCaisses.getB8() != null && !this.optionCaisses.getB8().isEmpty()) {
         this.val_b8 = Integer.parseInt(this.optionCaisses.getB8());
      }

      if (this.optionCaisses.getB9() != null && !this.optionCaisses.getB9().isEmpty()) {
         this.val_b9 = Integer.parseInt(this.optionCaisses.getB9());
      }

      if (this.optionCaisses.getB10() != null && !this.optionCaisses.getB10().isEmpty()) {
         this.val_b10 = Integer.parseInt(this.optionCaisses.getB10());
      }

      if (this.optionCaisses.getP1() != null && !this.optionCaisses.getP1().isEmpty()) {
         this.val_p1 = Integer.parseInt(this.optionCaisses.getP1());
      }

      if (this.optionCaisses.getP2() != null && !this.optionCaisses.getP2().isEmpty()) {
         this.val_p2 = Integer.parseInt(this.optionCaisses.getP2());
      }

      if (this.optionCaisses.getP3() != null && !this.optionCaisses.getP3().isEmpty()) {
         this.val_p3 = Integer.parseInt(this.optionCaisses.getP3());
      }

      if (this.optionCaisses.getP4() != null && !this.optionCaisses.getP4().isEmpty()) {
         this.val_p4 = Integer.parseInt(this.optionCaisses.getP4());
      }

      if (this.optionCaisses.getP5() != null && !this.optionCaisses.getP5().isEmpty()) {
         this.val_p5 = Integer.parseInt(this.optionCaisses.getP5());
      }

      if (this.optionCaisses.getP6() != null && !this.optionCaisses.getP6().isEmpty()) {
         this.val_p6 = Integer.parseInt(this.optionCaisses.getP6());
      }

      if (this.optionCaisses.getP7() != null && !this.optionCaisses.getP7().isEmpty()) {
         this.val_p7 = Integer.parseInt(this.optionCaisses.getP7());
      }

      if (this.optionCaisses.getP8() != null && !this.optionCaisses.getP8().isEmpty()) {
         this.val_p8 = Integer.parseInt(this.optionCaisses.getP8());
      }

      if (this.optionCaisses.getP9() != null && !this.optionCaisses.getP9().isEmpty()) {
         this.val_p9 = Integer.parseInt(this.optionCaisses.getP9());
      }

      if (this.optionCaisses.getP10() != null && !this.optionCaisses.getP10().isEmpty()) {
         this.val_p10 = Integer.parseInt(this.optionCaisses.getP10());
      }

      new ArrayList();
      DeviseDao var3 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesDevises(var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (var4 == 0) {
               this.devise1 = ((Devise)var2.get(var4)).getDevCode();
            } else if (var4 == 1) {
               this.devise2 = ((Devise)var2.get(var4)).getDevCode();
            } else if (var4 == 2) {
               this.devise3 = ((Devise)var2.get(var4)).getDevCode();
            } else if (var4 == 3) {
               this.devise4 = ((Devise)var2.get(var4)).getDevCode();
            } else if (var4 == 4) {
               this.devise5 = ((Devise)var2.get(var4)).getDevCode();
            }
         }
      }

   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() {
   }

   public void razListe() {
      this.visibiliteBton = false;
      this.lesCaissesInventaire.clear();
      this.dataModelInventaire.setWrappedData(this.lesCaissesInventaire);
   }

   public void chargerFind(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesCaissesInventaire.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.dateDebut == null) {
         this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      }

      if (this.dateFin == null) {
         this.dateFin = this.utilDate.dateDernierJourMois(new Date());
      }

      String var2 = "";
      if (this.dateDebut.getDate() <= 9) {
         var2 = "0" + this.dateDebut.getDate();
      } else {
         var2 = "" + this.dateDebut.getDate();
      }

      String var3 = "";
      if (this.dateDebut.getMonth() + 1 <= 9) {
         var3 = "0" + (this.dateDebut.getMonth() + 1);
      } else {
         var3 = "" + (this.dateDebut.getMonth() + 1);
      }

      String var4 = "" + (this.dateDebut.getYear() + 1900);
      String var5 = var4 + "-" + var3 + "-" + var2;
      String var6 = "";
      if (this.dateFin.getDate() <= 9) {
         var6 = "0" + this.dateFin.getDate();
      } else {
         var6 = "" + this.dateFin.getDate();
      }

      String var7 = "";
      if (this.dateFin.getMonth() + 1 <= 9) {
         var7 = "0" + (this.dateFin.getMonth() + 1);
      } else {
         var7 = "" + (this.dateFin.getMonth() + 1);
      }

      String var8 = "" + (this.dateFin.getYear() + 1900);
      String var9 = var8 + "-" + var7 + "-" + var6;
      String var10 = "";
      if (this.inpCaisse.contains(":")) {
         String[] var11 = this.inpCaisse.split(":");
         var10 = var11[0];
      } else {
         var10 = this.inpCaisse;
      }

      this.lesCaissesInventaire = this.caissesInventaireDao.selectFind(this.inpEtat, var10, var5, var9, this.usersLog.getUsrRecus(), this.usersLog.getUsrid(), var1);
      this.dataModelInventaire.setWrappedData(this.lesCaissesInventaire);
      this.caissesInventaire = new CaissesInventaire();
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.caissesInventaire = (CaissesInventaire)var1.get(0);
            if (this.caissesInventaire.getCaiinvCodeCaisse() != null && !this.caissesInventaire.getCaiinvCodeCaisse().isEmpty()) {
               this.var_caisse = this.caissesInventaire.getCaiinvCodeCaisse() + ":" + this.caissesInventaire.getCaiinvLibCaisse();
            } else {
               this.var_caisse = "";
            }

            this.chargerUserChrono((Session)null);
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.caissesInventaire != null) {
         if (this.caissesInventaire.getCaiinvEtat() == 0) {
            this.modifierInventaire();
         } else {
            this.consulterInventaire();
         }
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.caissesInventaire != null && this.caissesInventaire.getCaiinvSerie() != null && !this.caissesInventaire.getCaiinvSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.caissesInventaire.getCaiinvSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void ajouterInventaire() {
      this.caissesJour = new CaissesJour();
      this.caissesInventaire = new CaissesInventaire();
      this.caissesInventaire.setCaiinvDate(new Date());
      this.var_caisse = "100";
      this.var_valide = false;
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void modifierInventaire() {
      if (this.caissesInventaire != null) {
         this.var_valide = true;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterInventaire() {
      if (this.caissesInventaire != null) {
         this.var_valide = false;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.caissesInventaire != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.caissesInventaire.getCaiinvEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.caissesInventaire.setCaiinvEtat(1);
               this.caissesInventaire = this.caissesInventaireDao.modif(this.caissesInventaire, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle inventaire (T.) N° " + this.caissesInventaire.getCaiinvNum() + " du " + this.utilDate.dateToStringSQLLight(this.caissesInventaire.getCaiinvDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.caissesInventaire != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.caissesInventaire.getCaiinvEtat() == 1 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.caissesInventaire.setCaiinvEtat(0);
               this.caissesInventaire = this.caissesInventaireDao.modif(this.caissesInventaire, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle inventaire (T.) N° " + this.caissesInventaire.getCaiinvNum() + " du " + this.utilDate.dateToStringSQLLight(this.caissesInventaire.getCaiinvDate()));
               this.espionDao.mAJEspion(var3, var1);
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void supprimerInventaire() throws HibernateException, NamingException {
      if (this.caissesInventaire != null) {
         this.lesCaissesInventaire.remove(this.caissesInventaire);
         this.dataModelInventaire.setWrappedData(this.lesCaissesInventaire);
         this.caissesInventaireDao.delete(this.caissesInventaire);
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveInventaire() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.caissesInventaire.getCaiinvId() == 0L) {
            this.caissesInventaire.setExercicesCaisse(this.selectedExo);
            String var3 = this.calculChrono.numCompose(this.caissesInventaire.getCaiinvDate(), this.nature, this.caissesInventaire.getCaiinvSerie(), var1);
            this.caissesInventaire.setCaiinvNum(var3);
            this.caissesInventaire.setCaiinvDateCreation(new Date());
            this.caissesInventaire.setCaiinvUserIdCreation(this.usersLog.getUsrid());
            this.caissesInventaire = this.caissesInventaireDao.insert(this.caissesInventaire, var1);
            this.lesCaissesInventaire.add(this.caissesInventaire);
            this.dataModelInventaire.setWrappedData(this.lesCaissesInventaire);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.caissesInventaire.setCaiinvDateModif(new Date());
            this.caissesInventaire.setCaiinvUserIdModif(this.usersLog.getUsrid());
            this.caissesInventaire = this.caissesInventaireDao.modif(this.caissesInventaire, var1);
         }

         if (this.caissesJour != null) {
            this.caissesJour.setCaijouControle(this.caissesInventaire.getCaiinvDate());
            this.caissesJour = this.caissesJourDao.majJournal(this.caissesJour, var1);
         }

         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.initImpression();
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void calculBilletageJournalier() {
      this.tot_b1 = (double)(this.val_b1 * this.caissesInventaire.getCaiinvB1());
      this.tot_b2 = (double)(this.val_b2 * this.caissesInventaire.getCaiinvB2());
      this.tot_b3 = (double)(this.val_b3 * this.caissesInventaire.getCaiinvB3());
      this.tot_b4 = (double)(this.val_b4 * this.caissesInventaire.getCaiinvB4());
      this.tot_b5 = (double)(this.val_b5 * this.caissesInventaire.getCaiinvB5());
      this.tot_b6 = (double)(this.val_b6 * this.caissesInventaire.getCaiinvB6());
      this.tot_b7 = (double)(this.val_b7 * this.caissesInventaire.getCaiinvB7());
      this.tot_b8 = (double)(this.val_b8 * this.caissesInventaire.getCaiinvB8());
      this.tot_b9 = (double)(this.val_b9 * this.caissesInventaire.getCaiinvB9());
      this.tot_b10 = (double)(this.val_b10 * this.caissesInventaire.getCaiinvB10());
      this.totalBillet = this.tot_b1 + this.tot_b2 + this.tot_b3 + this.tot_b4 + this.tot_b5 + this.tot_b6 + this.tot_b7 + this.tot_b8 + this.tot_b9 + this.tot_b10;
      this.tot_p1 = (double)(this.val_p1 * this.caissesInventaire.getCaiinvP1());
      this.tot_p2 = (double)(this.val_p2 * this.caissesInventaire.getCaiinvP2());
      this.tot_p3 = (double)(this.val_p3 * this.caissesInventaire.getCaiinvP3());
      this.tot_p4 = (double)(this.val_p4 * this.caissesInventaire.getCaiinvP4());
      this.tot_p5 = (double)(this.val_p5 * this.caissesInventaire.getCaiinvP5());
      this.tot_p6 = (double)(this.val_p6 * this.caissesInventaire.getCaiinvP6());
      this.tot_p7 = (double)(this.val_p7 * this.caissesInventaire.getCaiinvP7());
      this.tot_p8 = (double)(this.val_p8 * this.caissesInventaire.getCaiinvP8());
      this.tot_p9 = (double)(this.val_p9 * this.caissesInventaire.getCaiinvP9());
      this.tot_p10 = (double)(this.val_p10 * this.caissesInventaire.getCaiinvP10());
      this.totalPiece = this.tot_p1 + this.tot_p2 + this.tot_p3 + this.tot_p4 + this.tot_p5 + this.tot_p6 + this.tot_p7 + this.tot_p8 + this.tot_p9 + this.tot_p10;
      this.totalDevise = this.caissesJour.getCaijouBon() + this.caissesJour.getCaijouTimbre();
      double var1 = this.soldeFinalCheque + this.soldeFinalCompense + this.soldeFinalCredoc + this.soldeFinalEspece + this.soldeFinalFactor + this.soldeFinalTerme + this.soldeFinalTpe + this.soldeFinalTraite + this.soldeFinalTransfert + this.soldeFinalVirement + this.soldeFinalePaiement;
      double var3 = this.totalBillet + this.totalPiece;
      this.ecart = var1 - var3;
      this.caissesInventaire.setCaiinvB1Ecart(this.caissesInventaire.getCaiinvB1() - this.caissesInventaire.getCaiinvB1Reel());
      this.caissesInventaire.setCaiinvB2Ecart(this.caissesInventaire.getCaiinvB2() - this.caissesInventaire.getCaiinvB2Reel());
      this.caissesInventaire.setCaiinvB3Ecart(this.caissesInventaire.getCaiinvB3() - this.caissesInventaire.getCaiinvB3Reel());
      this.caissesInventaire.setCaiinvB4Ecart(this.caissesInventaire.getCaiinvB4() - this.caissesInventaire.getCaiinvB4Reel());
      this.caissesInventaire.setCaiinvB5Ecart(this.caissesInventaire.getCaiinvB5() - this.caissesInventaire.getCaiinvB5Reel());
      this.caissesInventaire.setCaiinvB6Ecart(this.caissesInventaire.getCaiinvB6() - this.caissesInventaire.getCaiinvB6Reel());
      this.caissesInventaire.setCaiinvB7Ecart(this.caissesInventaire.getCaiinvB7() - this.caissesInventaire.getCaiinvB7Reel());
      this.caissesInventaire.setCaiinvB8Ecart(this.caissesInventaire.getCaiinvB8() - this.caissesInventaire.getCaiinvB8Reel());
      this.caissesInventaire.setCaiinvB9Ecart(this.caissesInventaire.getCaiinvB9() - this.caissesInventaire.getCaiinvB9Reel());
      this.caissesInventaire.setCaiinvB10Ecart(this.caissesInventaire.getCaiinvB10() - this.caissesInventaire.getCaiinvB10Reel());
      this.tot_b1_ecart = this.tot_b1 - this.tot_b1_reel;
      this.tot_b2_ecart = this.tot_b2 - this.tot_b2_reel;
      this.tot_b3_ecart = this.tot_b3 - this.tot_b3_reel;
      this.tot_b4_ecart = this.tot_b4 - this.tot_b4_reel;
      this.tot_b5_ecart = this.tot_b5 - this.tot_b5_reel;
      this.tot_b6_ecart = this.tot_b6 - this.tot_b6_reel;
      this.tot_b7_ecart = this.tot_b7 - this.tot_b7_reel;
      this.tot_b8_ecart = this.tot_b8 - this.tot_b8_reel;
      this.tot_b9_ecart = this.tot_b9 - this.tot_b9_reel;
      this.tot_b10_ecart = this.tot_b10 - this.tot_b10_reel;
      this.totalBillet_ecart = this.tot_b1_ecart + this.tot_b2_ecart + this.tot_b3_ecart + this.tot_b4_ecart + this.tot_b5_ecart + this.tot_b6_ecart + this.tot_b7_ecart + this.tot_b8_ecart + this.tot_b9_ecart + this.tot_b10_ecart;
      this.caissesInventaire.setCaiinvP1Ecart(this.caissesInventaire.getCaiinvP1() - this.caissesInventaire.getCaiinvP1Reel());
      this.caissesInventaire.setCaiinvP2Ecart(this.caissesInventaire.getCaiinvP2() - this.caissesInventaire.getCaiinvP2Reel());
      this.caissesInventaire.setCaiinvP3Ecart(this.caissesInventaire.getCaiinvP3() - this.caissesInventaire.getCaiinvP3Reel());
      this.caissesInventaire.setCaiinvP4Ecart(this.caissesInventaire.getCaiinvP4() - this.caissesInventaire.getCaiinvP4Reel());
      this.caissesInventaire.setCaiinvP5Ecart(this.caissesInventaire.getCaiinvP5() - this.caissesInventaire.getCaiinvP5Reel());
      this.caissesInventaire.setCaiinvP6Ecart(this.caissesInventaire.getCaiinvP6() - this.caissesInventaire.getCaiinvP6Reel());
      this.caissesInventaire.setCaiinvP7Ecart(this.caissesInventaire.getCaiinvP7() - this.caissesInventaire.getCaiinvP7Reel());
      this.caissesInventaire.setCaiinvP8Ecart(this.caissesInventaire.getCaiinvP8() - this.caissesInventaire.getCaiinvP8Reel());
      this.caissesInventaire.setCaiinvP9Ecart(this.caissesInventaire.getCaiinvP9() - this.caissesInventaire.getCaiinvP9Reel());
      this.caissesInventaire.setCaiinvP10Ecart(this.caissesInventaire.getCaiinvP10() - this.caissesInventaire.getCaiinvP10Reel());
      this.tot_p1_ecart = this.tot_p1 - this.tot_p1_reel;
      this.tot_p2_ecart = this.tot_p2 - this.tot_p2_reel;
      this.tot_p3_ecart = this.tot_p3 - this.tot_p3_reel;
      this.tot_p4_ecart = this.tot_p4 - this.tot_p4_reel;
      this.tot_p5_ecart = this.tot_p5 - this.tot_p5_reel;
      this.tot_p6_ecart = this.tot_p6 - this.tot_p6_reel;
      this.tot_p7_ecart = this.tot_p7 - this.tot_p7_reel;
      this.tot_p8_ecart = this.tot_p8 - this.tot_p8_reel;
      this.tot_p9_ecart = this.tot_p9 - this.tot_p9_reel;
      this.tot_p10_ecart = this.tot_p10 - this.tot_p10_reel;
      this.caissesInventaire.setCaiinvBonEcart(this.caissesInventaire.getCaiinvBon() - this.caissesInventaire.getCaiinvBonReel());
      this.caissesInventaire.setCaiinvEspeceEcart(this.caissesInventaire.getCaiinvEspece() - this.caissesInventaire.getCaiinvEspeceReel());
      this.caissesInventaire.setCaiinvTimbreEcart(this.caissesInventaire.getCaiinvTimbre() - this.caissesInventaire.getCaiinvTimbreReel());
      this.caissesInventaire.setCaiinvAutreEcart(this.caissesInventaire.getCaiinvAutre() - this.caissesInventaire.getCaiinvAutreReel());
      this.caissesInventaire.setCaiinvDevise1Ecart(this.caissesInventaire.getCaiinvDevise1() - this.caissesInventaire.getCaiinvDevise1Reel());
      this.caissesInventaire.setCaiinvDevise2Ecart(this.caissesInventaire.getCaiinvDevise2() - this.caissesInventaire.getCaiinvDevise2Reel());
      this.caissesInventaire.setCaiinvDevise3Ecart(this.caissesInventaire.getCaiinvDevise3() - this.caissesInventaire.getCaiinvDevise3Reel());
      this.caissesInventaire.setCaiinvDevise4Ecart(this.caissesInventaire.getCaiinvDevise4() - this.caissesInventaire.getCaiinvDevise4Reel());
      this.caissesInventaire.setCaiinvDevise5Ecart(this.caissesInventaire.getCaiinvDevise5() - this.caissesInventaire.getCaiinvDevise5Reel());
      this.totalPiece_ecart = this.tot_p1_ecart + this.tot_p2_ecart + this.tot_p3_ecart + this.tot_p4_ecart + this.tot_p5_ecart + this.tot_p6_ecart + this.tot_p7_ecart + this.tot_p8_ecart + this.tot_p9_ecart + this.tot_p10_ecart;
      this.totalDevise_ecart = this.totalDevise - this.totalDevise_reel;
      this.ecart_ecart = this.ecart - this.ecart_reel;
   }

   public void calculBilletageJournalierReel() {
      this.tot_b1_reel = (double)(this.val_b1 * this.caissesInventaire.getCaiinvB1Reel());
      this.tot_b2_reel = (double)(this.val_b2 * this.caissesInventaire.getCaiinvB2Reel());
      this.tot_b3_reel = (double)(this.val_b3 * this.caissesInventaire.getCaiinvB3Reel());
      this.tot_b4_reel = (double)(this.val_b4 * this.caissesInventaire.getCaiinvB4Reel());
      this.tot_b5_reel = (double)(this.val_b5 * this.caissesInventaire.getCaiinvB5Reel());
      this.tot_b6_reel = (double)(this.val_b6 * this.caissesInventaire.getCaiinvB6Reel());
      this.tot_b7_reel = (double)(this.val_b7 * this.caissesInventaire.getCaiinvB7Reel());
      this.tot_b8_reel = (double)(this.val_b8 * this.caissesInventaire.getCaiinvB8Reel());
      this.tot_b9_reel = (double)(this.val_b9 * this.caissesInventaire.getCaiinvB9Reel());
      this.tot_b10_reel = (double)(this.val_b10 * this.caissesInventaire.getCaiinvB10Reel());
      this.totalBillet_reel = this.tot_b1_reel + this.tot_b2_reel + this.tot_b3_reel + this.tot_b4_reel + this.tot_b5_reel + this.tot_b6_reel + this.tot_b7_reel + this.tot_b8_reel + this.tot_b9_reel + this.tot_b10_reel;
      this.tot_p1_reel = (double)(this.val_p1 * this.caissesInventaire.getCaiinvP1Reel());
      this.tot_p2_reel = (double)(this.val_p2 * this.caissesInventaire.getCaiinvP2Reel());
      this.tot_p3_reel = (double)(this.val_p3 * this.caissesInventaire.getCaiinvP3Reel());
      this.tot_p4_reel = (double)(this.val_p4 * this.caissesInventaire.getCaiinvP4Reel());
      this.tot_p5_reel = (double)(this.val_p5 * this.caissesInventaire.getCaiinvP5Reel());
      this.tot_p6_reel = (double)(this.val_p6 * this.caissesInventaire.getCaiinvP6Reel());
      this.tot_p7_reel = (double)(this.val_p7 * this.caissesInventaire.getCaiinvP7Reel());
      this.tot_p8_reel = (double)(this.val_p8 * this.caissesInventaire.getCaiinvP8Reel());
      this.tot_p9_reel = (double)(this.val_p9 * this.caissesInventaire.getCaiinvP9Reel());
      this.tot_p10_reel = (double)(this.val_p10 * this.caissesInventaire.getCaiinvP10Reel());
      this.totalPiece_reel = this.tot_p1_reel + this.tot_p2_reel + this.tot_p3_reel + this.tot_p4_reel + this.tot_p5_reel + this.tot_p6_reel + this.tot_p7_reel + this.tot_p8_reel + this.tot_p9_reel + this.tot_p10_reel;
      this.totalDevise_reel = this.caissesInventaire.getCaiinvBonReel() + this.caissesInventaire.getCaiinvTimbreReel();
      this.ecart_reel = this.caissesInventaire.getCaiinvEcartReel();
   }

   public void chargerFind() throws HibernateException, NamingException, ParseException {
      this.chargerFind((Session)null);
   }

   public void choixCaisse() throws HibernateException, NamingException {
      this.var_valide = false;
      this.mesCaisseControlItems.clear();
      if (this.var_caisse != null && !this.var_caisse.isEmpty() && this.var_caisse.contains(":")) {
         String[] var1 = this.var_caisse.split(":");
         this.caissesInventaire.setCaiinvCodeCaisse(var1[0]);
         this.caissesInventaire.setCaiinvLibCaisse(var1[1]);
         new ArrayList();
         List var2 = this.caissesJourDao.listeDateNonControle(this.caissesInventaire.getCaiinvCodeCaisse(), (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               new CaissesJour();
               CaissesJour var4 = (CaissesJour)var2.get(var3);
               this.mesCaisseControlItems.add(new SelectItem(var4.getCaijouId(), var4.getCaijouCode() + ":" + this.utilDate.dateToStringFr(var4.getCaijouDate())));
            }
         }
      } else {
         this.caissesInventaire.setCaiinvCodeCaisse("");
         this.caissesInventaire.setCaiinvLibCaisse("");
      }

   }

   public void choisirDateControle() throws HibernateException, NamingException {
      long var1 = this.caissesInventaire.getCaiinvCaisseIdCtrl();
      this.caissesJour = this.caissesJourDao.recupererCaissesJour(var1, (Session)null);
      if (this.caissesJour != null) {
         this.caissesInventaire.setCaiinvCaisseIdCtrl(this.caissesJour.getCaijouId());
         this.caissesInventaire.setCaiinvDateCtrl(this.caissesJour.getCaijouDate());
         this.caissesInventaire.setCaiinvAutreReel(this.caissesJour.getCaijouAutre());
         this.caissesInventaire.setCaiinvB1Reel(this.caissesJour.getCaijouB1());
         this.caissesInventaire.setCaiinvB2Reel(this.caissesJour.getCaijouB2());
         this.caissesInventaire.setCaiinvB3Reel(this.caissesJour.getCaijouB3());
         this.caissesInventaire.setCaiinvB4Reel(this.caissesJour.getCaijouB4());
         this.caissesInventaire.setCaiinvB5Reel(this.caissesJour.getCaijouB5());
         this.caissesInventaire.setCaiinvB6Reel(this.caissesJour.getCaijouB6());
         this.caissesInventaire.setCaiinvB7Reel(this.caissesJour.getCaijouB7());
         this.caissesInventaire.setCaiinvB8Reel(this.caissesJour.getCaijouB8());
         this.caissesInventaire.setCaiinvB9Reel(this.caissesJour.getCaijouB9());
         this.caissesInventaire.setCaiinvB10Reel(this.caissesJour.getCaijouB10());
         this.caissesInventaire.setCaiinvBonReel(this.caissesJour.getCaijouBon());
         this.caissesInventaire.setCaiinvDevise1Reel(this.caissesJour.getCaijouDevise1());
         this.caissesInventaire.setCaiinvDevise2Reel(this.caissesJour.getCaijouDevise2());
         this.caissesInventaire.setCaiinvDevise3Reel(this.caissesJour.getCaijouDevise3());
         this.caissesInventaire.setCaiinvDevise4Reel(this.caissesJour.getCaijouDevise4());
         this.caissesInventaire.setCaiinvDevise5Reel(this.caissesJour.getCaijouDevise5());
         this.caissesInventaire.setCaiinvEcartReel(this.caissesJour.getCaijouEcart());
         this.caissesInventaire.setCaiinvEspeceReel(this.caissesJour.getCaijouEspeceReel());
         this.caissesInventaire.setCaiinvP1Reel(this.caissesJour.getCaijouP1());
         this.caissesInventaire.setCaiinvP2Reel(this.caissesJour.getCaijouP2());
         this.caissesInventaire.setCaiinvP3Reel(this.caissesJour.getCaijouP3());
         this.caissesInventaire.setCaiinvP4Reel(this.caissesJour.getCaijouP4());
         this.caissesInventaire.setCaiinvP5Reel(this.caissesJour.getCaijouP5());
         this.caissesInventaire.setCaiinvP6Reel(this.caissesJour.getCaijouP6());
         this.caissesInventaire.setCaiinvP7Reel(this.caissesJour.getCaijouP7());
         this.caissesInventaire.setCaiinvP8Reel(this.caissesJour.getCaijouP8());
         this.caissesInventaire.setCaiinvP9Reel(this.caissesJour.getCaijouP9());
         this.caissesInventaire.setCaiinvP10Reel(this.caissesJour.getCaijouP10());
         this.caissesInventaire.setCaiinvSoldeBonCaisseReel(this.caissesJour.getCaijouSoldeBonCaisse());
         this.caissesInventaire.setCaiinvSoldeChequeReel(this.caissesJour.getCaijouSoldeCheque());
         this.caissesInventaire.setCaiinvSoldeCompenseReel(this.caissesJour.getCaijouSoldeCompense());
         this.caissesInventaire.setCaiinvSoldeCredocReel(this.caissesJour.getCaijouSoldeCredoc());
         this.caissesInventaire.setCaiinvSoldeEspeceReel(this.caissesJour.getCaijouSoldeEspece());
         this.caissesInventaire.setCaiinvSoldeFactorReel(this.caissesJour.getCaijouSoldeFactor());
         this.caissesInventaire.setCaiinvSoldeTermeReel(this.caissesJour.getCaijouSoldeTerme());
         this.caissesInventaire.setCaiinvSoldeTpeReel(this.caissesJour.getCaijouSoldeTpe());
         this.caissesInventaire.setCaiinvSoldeTraiteReel(this.caissesJour.getCaijouSoldeTraite());
         this.caissesInventaire.setCaiinvSoldeTransfertReel(this.caissesJour.getCaijouSoldeTransfert());
         this.caissesInventaire.setCaiinvSoldeVirementReel(this.caissesJour.getCaijouSoldeVirement());
         this.caissesInventaire.setCaiinvSoldeePaiementReel(this.caissesJour.getCaijouSoldeePaiement());
         this.caissesInventaire.setCaiinvTimbreReel(this.caissesJour.getCaijouTimbre());
         this.calculBilletageJournalierReel();
         this.var_valide = true;
      } else {
         this.caissesInventaire.setCaiinvAutreReel(0.0D);
         this.caissesInventaire.setCaiinvB1Reel(0);
         this.caissesInventaire.setCaiinvB2Reel(0);
         this.caissesInventaire.setCaiinvB3Reel(0);
         this.caissesInventaire.setCaiinvB4Reel(0);
         this.caissesInventaire.setCaiinvB5Reel(0);
         this.caissesInventaire.setCaiinvB6Reel(0);
         this.caissesInventaire.setCaiinvB7Reel(0);
         this.caissesInventaire.setCaiinvB8Reel(0);
         this.caissesInventaire.setCaiinvB9Reel(0);
         this.caissesInventaire.setCaiinvB10Reel(0);
         this.caissesInventaire.setCaiinvBonReel(0.0D);
         this.caissesInventaire.setCaiinvDevise1Reel(0.0D);
         this.caissesInventaire.setCaiinvDevise2Reel(0.0D);
         this.caissesInventaire.setCaiinvDevise3Reel(0.0D);
         this.caissesInventaire.setCaiinvDevise4Reel(0.0D);
         this.caissesInventaire.setCaiinvDevise5Reel(0.0D);
         this.caissesInventaire.setCaiinvEcartReel(0.0D);
         this.caissesInventaire.setCaiinvEspeceReel(0.0D);
         this.caissesInventaire.setCaiinvP1Reel(0);
         this.caissesInventaire.setCaiinvP2Reel(0);
         this.caissesInventaire.setCaiinvP3Reel(0);
         this.caissesInventaire.setCaiinvP4Reel(0);
         this.caissesInventaire.setCaiinvP5Reel(0);
         this.caissesInventaire.setCaiinvP6Reel(0);
         this.caissesInventaire.setCaiinvP7Reel(0);
         this.caissesInventaire.setCaiinvP8Reel(0);
         this.caissesInventaire.setCaiinvP9Reel(0);
         this.caissesInventaire.setCaiinvP10Reel(0);
         this.caissesInventaire.setCaiinvSoldeBonCaisseReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeChequeReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeCompenseReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeCredocReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeEspeceReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeFactorReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeTermeReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeTpeReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeTraiteReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeTransfertReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeVirementReel(0.0D);
         this.caissesInventaire.setCaiinvSoldeePaiementReel(0.0D);
         this.caissesInventaire.setCaiinvTimbreReel(0.0D);
         this.calculBilletageJournalierReel();
         this.var_valide = false;
      }

   }

   public void initImpression() {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.var_choix_modele = 0;
      this.ListeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void ListeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "inventaire" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add(this.caissesInventaire);
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      return var2;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CaisseCommerciale");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.caissesInventaire.setCaiinvDateImpression(new Date());
               if (this.caissesInventaire.getCaiinvEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 0) {
                  this.caissesInventaire.setCaiinvEtat(1);
               }

               this.caissesInventaire.setCaiinvModeleImp(this.nomModeleDocument);
               this.caissesInventaire = this.caissesInventaireDao.modif(this.caissesInventaire, var1);
               var2.commit();
            } catch (HibernateException var7) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var7;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            String var3 = this.utilNombre.begin(this.caissesInventaire.getSoldeFinal(), this.structureLog.getStrdevise());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression inventaire");
            this.utilPrint.setMontant_lettre(var3);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des inventaires");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "liste" + File.separator + "inventaire" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var9 = new JRBeanCollectionDataSource(this.lesCaissesInventaire);
         this.utilPrint.setjRBeanCollectionDataSource(var9);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

      this.var_action = 0;
   }

   public Date getDateDebut() {
      return this.dateDebut;
   }

   public void setDateDebut(Date var1) {
      this.dateDebut = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public String getInpCaisse() {
      return this.inpCaisse;
   }

   public void setInpCaisse(String var1) {
      this.inpCaisse = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public boolean isChampCltVide() {
      return this.champCltVide;
   }

   public void setChampCltVide(boolean var1) {
      this.champCltVide = var1;
   }

   public String getInputTypReglment() {
      return this.inputTypReglment;
   }

   public void setInputTypReglment(String var1) {
      this.inputTypReglment = var1;
   }

   public ExercicesCaisse getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesCaisse var1) {
      this.lastExo = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public ExercicesCaisse getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesCaisse var1) {
      this.selectedExo = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public CaissesInventaire getBonEntreeCaiss() {
      return this.caissesInventaire;
   }

   public void setBonEntreeCaiss(CaissesInventaire var1) {
      this.caissesInventaire = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
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

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }

   public DataModel getDataModelInventaire() {
      return this.dataModelInventaire;
   }

   public void setDataModelInventaire(DataModel var1) {
      this.dataModelInventaire = var1;
   }

   public CaissesInventaire getCaissesInventaire() {
      return this.caissesInventaire;
   }

   public void setCaissesInventaire(CaissesInventaire var1) {
      this.caissesInventaire = var1;
   }

   public String getVar_caisse() {
      return this.var_caisse;
   }

   public void setVar_caisse(String var1) {
      this.var_caisse = var1;
   }

   public boolean isVar_valide() {
      return this.var_valide;
   }

   public void setVar_valide(boolean var1) {
      this.var_valide = var1;
   }

   public List getMesCaisseControlItems() {
      return this.mesCaisseControlItems;
   }

   public void setMesCaisseControlItems(List var1) {
      this.mesCaisseControlItems = var1;
   }

   public String getDevise1() {
      return this.devise1;
   }

   public void setDevise1(String var1) {
      this.devise1 = var1;
   }

   public String getDevise2() {
      return this.devise2;
   }

   public void setDevise2(String var1) {
      this.devise2 = var1;
   }

   public String getDevise3() {
      return this.devise3;
   }

   public void setDevise3(String var1) {
      this.devise3 = var1;
   }

   public String getDevise4() {
      return this.devise4;
   }

   public void setDevise4(String var1) {
      this.devise4 = var1;
   }

   public String getDevise5() {
      return this.devise5;
   }

   public void setDevise5(String var1) {
      this.devise5 = var1;
   }

   public double getEcart() {
      return this.ecart;
   }

   public void setEcart(double var1) {
      this.ecart = var1;
   }

   public double getSoldeCorrection() {
      return this.soldeCorrection;
   }

   public void setSoldeCorrection(double var1) {
      this.soldeCorrection = var1;
   }

   public double getTot_b1() {
      return this.tot_b1;
   }

   public void setTot_b1(double var1) {
      this.tot_b1 = var1;
   }

   public double getTot_b10() {
      return this.tot_b10;
   }

   public void setTot_b10(double var1) {
      this.tot_b10 = var1;
   }

   public double getTot_b2() {
      return this.tot_b2;
   }

   public void setTot_b2(double var1) {
      this.tot_b2 = var1;
   }

   public double getTot_b3() {
      return this.tot_b3;
   }

   public void setTot_b3(double var1) {
      this.tot_b3 = var1;
   }

   public double getTot_b4() {
      return this.tot_b4;
   }

   public void setTot_b4(double var1) {
      this.tot_b4 = var1;
   }

   public double getTot_b5() {
      return this.tot_b5;
   }

   public void setTot_b5(double var1) {
      this.tot_b5 = var1;
   }

   public double getTot_b6() {
      return this.tot_b6;
   }

   public void setTot_b6(double var1) {
      this.tot_b6 = var1;
   }

   public double getTot_b7() {
      return this.tot_b7;
   }

   public void setTot_b7(double var1) {
      this.tot_b7 = var1;
   }

   public double getTot_b8() {
      return this.tot_b8;
   }

   public void setTot_b8(double var1) {
      this.tot_b8 = var1;
   }

   public double getTot_b9() {
      return this.tot_b9;
   }

   public void setTot_b9(double var1) {
      this.tot_b9 = var1;
   }

   public double getTot_p1() {
      return this.tot_p1;
   }

   public void setTot_p1(double var1) {
      this.tot_p1 = var1;
   }

   public double getTot_p10() {
      return this.tot_p10;
   }

   public void setTot_p10(double var1) {
      this.tot_p10 = var1;
   }

   public double getTot_p2() {
      return this.tot_p2;
   }

   public void setTot_p2(double var1) {
      this.tot_p2 = var1;
   }

   public double getTot_p3() {
      return this.tot_p3;
   }

   public void setTot_p3(double var1) {
      this.tot_p3 = var1;
   }

   public double getTot_p4() {
      return this.tot_p4;
   }

   public void setTot_p4(double var1) {
      this.tot_p4 = var1;
   }

   public double getTot_p5() {
      return this.tot_p5;
   }

   public void setTot_p5(double var1) {
      this.tot_p5 = var1;
   }

   public double getTot_p6() {
      return this.tot_p6;
   }

   public void setTot_p6(double var1) {
      this.tot_p6 = var1;
   }

   public double getTot_p7() {
      return this.tot_p7;
   }

   public void setTot_p7(double var1) {
      this.tot_p7 = var1;
   }

   public double getTot_p8() {
      return this.tot_p8;
   }

   public void setTot_p8(double var1) {
      this.tot_p8 = var1;
   }

   public double getTot_p9() {
      return this.tot_p9;
   }

   public void setTot_p9(double var1) {
      this.tot_p9 = var1;
   }

   public double getTotalBillet() {
      return this.totalBillet;
   }

   public void setTotalBillet(double var1) {
      this.totalBillet = var1;
   }

   public double getTotalDevise() {
      return this.totalDevise;
   }

   public void setTotalDevise(double var1) {
      this.totalDevise = var1;
   }

   public double getTotalPiece() {
      return this.totalPiece;
   }

   public void setTotalPiece(double var1) {
      this.totalPiece = var1;
   }

   public int getVal_b1() {
      return this.val_b1;
   }

   public void setVal_b1(int var1) {
      this.val_b1 = var1;
   }

   public int getVal_b10() {
      return this.val_b10;
   }

   public void setVal_b10(int var1) {
      this.val_b10 = var1;
   }

   public int getVal_b2() {
      return this.val_b2;
   }

   public void setVal_b2(int var1) {
      this.val_b2 = var1;
   }

   public int getVal_b3() {
      return this.val_b3;
   }

   public void setVal_b3(int var1) {
      this.val_b3 = var1;
   }

   public int getVal_b4() {
      return this.val_b4;
   }

   public void setVal_b4(int var1) {
      this.val_b4 = var1;
   }

   public int getVal_b5() {
      return this.val_b5;
   }

   public void setVal_b5(int var1) {
      this.val_b5 = var1;
   }

   public int getVal_b6() {
      return this.val_b6;
   }

   public void setVal_b6(int var1) {
      this.val_b6 = var1;
   }

   public int getVal_b7() {
      return this.val_b7;
   }

   public void setVal_b7(int var1) {
      this.val_b7 = var1;
   }

   public int getVal_b8() {
      return this.val_b8;
   }

   public void setVal_b8(int var1) {
      this.val_b8 = var1;
   }

   public int getVal_b9() {
      return this.val_b9;
   }

   public void setVal_b9(int var1) {
      this.val_b9 = var1;
   }

   public int getVal_p1() {
      return this.val_p1;
   }

   public void setVal_p1(int var1) {
      this.val_p1 = var1;
   }

   public int getVal_p10() {
      return this.val_p10;
   }

   public void setVal_p10(int var1) {
      this.val_p10 = var1;
   }

   public int getVal_p2() {
      return this.val_p2;
   }

   public void setVal_p2(int var1) {
      this.val_p2 = var1;
   }

   public int getVal_p3() {
      return this.val_p3;
   }

   public void setVal_p3(int var1) {
      this.val_p3 = var1;
   }

   public int getVal_p4() {
      return this.val_p4;
   }

   public void setVal_p4(int var1) {
      this.val_p4 = var1;
   }

   public int getVal_p5() {
      return this.val_p5;
   }

   public void setVal_p5(int var1) {
      this.val_p5 = var1;
   }

   public int getVal_p6() {
      return this.val_p6;
   }

   public void setVal_p6(int var1) {
      this.val_p6 = var1;
   }

   public int getVal_p7() {
      return this.val_p7;
   }

   public void setVal_p7(int var1) {
      this.val_p7 = var1;
   }

   public int getVal_p8() {
      return this.val_p8;
   }

   public void setVal_p8(int var1) {
      this.val_p8 = var1;
   }

   public int getVal_p9() {
      return this.val_p9;
   }

   public void setVal_p9(int var1) {
      this.val_p9 = var1;
   }

   public double getTot_b10_reel() {
      return this.tot_b10_reel;
   }

   public void setTot_b10_reel(double var1) {
      this.tot_b10_reel = var1;
   }

   public double getTot_b1_reel() {
      return this.tot_b1_reel;
   }

   public void setTot_b1_reel(double var1) {
      this.tot_b1_reel = var1;
   }

   public double getTot_b2_reel() {
      return this.tot_b2_reel;
   }

   public void setTot_b2_reel(double var1) {
      this.tot_b2_reel = var1;
   }

   public double getTot_b3_reel() {
      return this.tot_b3_reel;
   }

   public void setTot_b3_reel(double var1) {
      this.tot_b3_reel = var1;
   }

   public double getTot_b4_reel() {
      return this.tot_b4_reel;
   }

   public void setTot_b4_reel(double var1) {
      this.tot_b4_reel = var1;
   }

   public double getTot_b5_reel() {
      return this.tot_b5_reel;
   }

   public void setTot_b5_reel(double var1) {
      this.tot_b5_reel = var1;
   }

   public double getTot_b6_reel() {
      return this.tot_b6_reel;
   }

   public void setTot_b6_reel(double var1) {
      this.tot_b6_reel = var1;
   }

   public double getTot_b7_reel() {
      return this.tot_b7_reel;
   }

   public void setTot_b7_reel(double var1) {
      this.tot_b7_reel = var1;
   }

   public double getTot_b8_reel() {
      return this.tot_b8_reel;
   }

   public void setTot_b8_reel(double var1) {
      this.tot_b8_reel = var1;
   }

   public double getTot_b9_reel() {
      return this.tot_b9_reel;
   }

   public void setTot_b9_reel(double var1) {
      this.tot_b9_reel = var1;
   }

   public double getTot_p10_reel() {
      return this.tot_p10_reel;
   }

   public void setTot_p10_reel(double var1) {
      this.tot_p10_reel = var1;
   }

   public double getTot_p1_reel() {
      return this.tot_p1_reel;
   }

   public void setTot_p1_reel(double var1) {
      this.tot_p1_reel = var1;
   }

   public double getTot_p2_reel() {
      return this.tot_p2_reel;
   }

   public void setTot_p2_reel(double var1) {
      this.tot_p2_reel = var1;
   }

   public double getTot_p3_reel() {
      return this.tot_p3_reel;
   }

   public void setTot_p3_reel(double var1) {
      this.tot_p3_reel = var1;
   }

   public double getTot_p4_reel() {
      return this.tot_p4_reel;
   }

   public void setTot_p4_reel(double var1) {
      this.tot_p4_reel = var1;
   }

   public double getTot_p5_reel() {
      return this.tot_p5_reel;
   }

   public void setTot_p5_reel(double var1) {
      this.tot_p5_reel = var1;
   }

   public double getTot_p6_reel() {
      return this.tot_p6_reel;
   }

   public void setTot_p6_reel(double var1) {
      this.tot_p6_reel = var1;
   }

   public double getTot_p7_reel() {
      return this.tot_p7_reel;
   }

   public void setTot_p7_reel(double var1) {
      this.tot_p7_reel = var1;
   }

   public double getTot_p8_reel() {
      return this.tot_p8_reel;
   }

   public void setTot_p8_reel(double var1) {
      this.tot_p8_reel = var1;
   }

   public double getTot_p9_reel() {
      return this.tot_p9_reel;
   }

   public void setTot_p9_reel(double var1) {
      this.tot_p9_reel = var1;
   }

   public double getTotalBillet_reel() {
      return this.totalBillet_reel;
   }

   public void setTotalBillet_reel(double var1) {
      this.totalBillet_reel = var1;
   }

   public double getTotalDevise_reel() {
      return this.totalDevise_reel;
   }

   public void setTotalDevise_reel(double var1) {
      this.totalDevise_reel = var1;
   }

   public double getTotalPiece_reel() {
      return this.totalPiece_reel;
   }

   public void setTotalPiece_reel(double var1) {
      this.totalPiece_reel = var1;
   }

   public double getEcart_reel() {
      return this.ecart_reel;
   }

   public void setEcart_reel(double var1) {
      this.ecart_reel = var1;
   }

   public double getEcart_ecart() {
      return this.ecart_ecart;
   }

   public void setEcart_ecart(double var1) {
      this.ecart_ecart = var1;
   }

   public double getTot_b10_ecart() {
      return this.tot_b10_ecart;
   }

   public void setTot_b10_ecart(double var1) {
      this.tot_b10_ecart = var1;
   }

   public double getTot_b1_ecart() {
      return this.tot_b1_ecart;
   }

   public void setTot_b1_ecart(double var1) {
      this.tot_b1_ecart = var1;
   }

   public double getTot_b2_ecart() {
      return this.tot_b2_ecart;
   }

   public void setTot_b2_ecart(double var1) {
      this.tot_b2_ecart = var1;
   }

   public double getTot_b3_ecart() {
      return this.tot_b3_ecart;
   }

   public void setTot_b3_ecart(double var1) {
      this.tot_b3_ecart = var1;
   }

   public double getTot_b4_ecart() {
      return this.tot_b4_ecart;
   }

   public void setTot_b4_ecart(double var1) {
      this.tot_b4_ecart = var1;
   }

   public double getTot_b5_ecart() {
      return this.tot_b5_ecart;
   }

   public void setTot_b5_ecart(double var1) {
      this.tot_b5_ecart = var1;
   }

   public double getTot_b6_ecart() {
      return this.tot_b6_ecart;
   }

   public void setTot_b6_ecart(double var1) {
      this.tot_b6_ecart = var1;
   }

   public double getTot_b7_ecart() {
      return this.tot_b7_ecart;
   }

   public void setTot_b7_ecart(double var1) {
      this.tot_b7_ecart = var1;
   }

   public double getTot_b8_ecart() {
      return this.tot_b8_ecart;
   }

   public void setTot_b8_ecart(double var1) {
      this.tot_b8_ecart = var1;
   }

   public double getTot_b9_ecart() {
      return this.tot_b9_ecart;
   }

   public void setTot_b9_ecart(double var1) {
      this.tot_b9_ecart = var1;
   }

   public double getTot_p10_ecart() {
      return this.tot_p10_ecart;
   }

   public void setTot_p10_ecart(double var1) {
      this.tot_p10_ecart = var1;
   }

   public double getTot_p1_ecart() {
      return this.tot_p1_ecart;
   }

   public void setTot_p1_ecart(double var1) {
      this.tot_p1_ecart = var1;
   }

   public double getTot_p2_ecart() {
      return this.tot_p2_ecart;
   }

   public void setTot_p2_ecart(double var1) {
      this.tot_p2_ecart = var1;
   }

   public double getTot_p3_ecart() {
      return this.tot_p3_ecart;
   }

   public void setTot_p3_ecart(double var1) {
      this.tot_p3_ecart = var1;
   }

   public double getTot_p4_ecart() {
      return this.tot_p4_ecart;
   }

   public void setTot_p4_ecart(double var1) {
      this.tot_p4_ecart = var1;
   }

   public double getTot_p5_ecart() {
      return this.tot_p5_ecart;
   }

   public void setTot_p5_ecart(double var1) {
      this.tot_p5_ecart = var1;
   }

   public double getTot_p6_ecart() {
      return this.tot_p6_ecart;
   }

   public void setTot_p6_ecart(double var1) {
      this.tot_p6_ecart = var1;
   }

   public double getTot_p7_ecart() {
      return this.tot_p7_ecart;
   }

   public void setTot_p7_ecart(double var1) {
      this.tot_p7_ecart = var1;
   }

   public double getTot_p8_ecart() {
      return this.tot_p8_ecart;
   }

   public void setTot_p8_ecart(double var1) {
      this.tot_p8_ecart = var1;
   }

   public double getTot_p9_ecart() {
      return this.tot_p9_ecart;
   }

   public void setTot_p9_ecart(double var1) {
      this.tot_p9_ecart = var1;
   }

   public double getTotalBillet_ecart() {
      return this.totalBillet_ecart;
   }

   public void setTotalBillet_ecart(double var1) {
      this.totalBillet_ecart = var1;
   }

   public double getTotalDevise_ecart() {
      return this.totalDevise_ecart;
   }

   public void setTotalDevise_ecart(double var1) {
      this.totalDevise_ecart = var1;
   }

   public double getTotalPiece_ecart() {
      return this.totalPiece_ecart;
   }

   public void setTotalPiece_ecart(double var1) {
      this.totalPiece_ecart = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
   }
}
