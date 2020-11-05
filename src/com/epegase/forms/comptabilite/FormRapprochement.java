package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnterieur;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxJour;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.EcrituresAnterieurDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.JournauxJourDao;
import com.epegase.systeme.dao.JournauxMoisDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormRapprochement implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private int nature;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private int var_nb_max = 100;
   private List lesjournauxActifs = new ArrayList();
   private List lesjournauxMois = new ArrayList();
   private JournauxComptables journauxActif = new JournauxComptables();
   private JournauxMois journauxMois = new JournauxMois();
   private transient DataModel datamodelJournaux = new ListDataModel();
   private UIDataTable extDTableJournaux = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionJournaux = new SimpleSelection();
   private transient DataModel dataModelMois = new ListDataModel();
   private UIDataTable extDTablePeriode = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionPeriode = new SimpleSelection();
   private JournauxMoisDao journauxMoisDao;
   private JournauxComptablesDao journauxComptablesDao;
   private boolean afficheTJM = false;
   private int nbPeriode;
   private List mesPeriodes = new ArrayList();
   private Ecritures ecritures = new Ecritures();
   private EcrituresDao ecrituresDao;
   private List lesEcritures = new ArrayList();
   private transient DataModel datamodelEcritures = new ListDataModel();
   private String var_periode;
   private String var_periode_rapproche;
   private Date DteDeb;
   private Date DteFin;
   private int var_jr_nature;
   private int var_format_devise;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private boolean testfermerleJournal = true;
   private String cpTreso;
   private boolean cloture = false;
   private double soldeTreso;
   private JournauxJour journauxJour;
   private JournauxJourDao journauxJourDao;
   private List lesjournauxJour = new ArrayList();
   private boolean afficheTJJ = false;
   private transient DataModel dataModelJour = new ListDataModel();
   private UIDataTable extDTableJour = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionJour = new SimpleSelection();
   private int nbJour;
   private String jourEnCours;
   private Date var_jour_rapproche;
   private double soldeAnterieur = 0.0D;
   private double soldeRapproche = 0.0D;
   private double soldeComptaAnterieur = 0.0D;
   private double soldeReleve = 0.0D;
   private double ecart = 0.0D;
   private double calculette = 0.0D;
   private boolean testAffSuppImpList;
   private double var_final;
   private double var_correctifImprimante;
   private double var_correctifEcran;
   private SimpleSelection selection;
   private String jrperiode_ante;
   private transient DataModel datamodelAnte = new ListDataModel();
   private List lesEcrituresAnterieurs = new ArrayList();
   private EcrituresAnterieur ecrituresAnterieur;
   private EcrituresAnterieurDao ecrituresAnterieurDao;
   private double totalMvtsdebit = 0.0D;
   private double totalMvtscredit = 0.0D;
   private double releveAnte = 0.0D;
   private boolean showModalPanelExtra = false;
   private int var_jour;
   private List lesjoursItems = new ArrayList();
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelMessage = false;
   private String message;
   private List lesModelesAutorises;
   private double var_tot_debit_np;
   private double var_tot_credit_np;
   private double var_tot_debit_p;
   private double var_tot_credit_p;
   private double var_tot_debit_eca;
   private double var_tot_credit_eca;
   private int choixRacine;
   private String selecFiscalite;
   private String compteTreso;

   public void InstancesDaoUtilses() {
      this.journauxMoisDao = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      this.journauxJourDao = new JournauxJourDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnterieurDao = new EcrituresAnterieurDao(this.baseLog, this.utilInitHibernate);
   }

   public void calculPeriode() {
      if (this.optionComptabilite.getNbLigneMaxJr() != null && !this.optionComptabilite.getNbLigneMaxJr().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxJr());
      } else {
         this.var_nb_max = 100;
      }

      this.nbPeriode = 0;
      this.mesPeriodes.clear();
      Date var1 = this.selectedExo.getExecptDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.selectedExo.getExecptDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         ++this.nbPeriode;
         this.mesPeriodes.add(var5);
      }

   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void chargerLesJournauxComptable(Session var1) throws HibernateException, NamingException {
      this.lesjournauxActifs = new ArrayList();
      this.lesjournauxActifs = this.journauxComptablesDao.mesjournauxBanquesActifs(this.selectedExo.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), var1);
      this.datamodelJournaux.setWrappedData(this.lesjournauxActifs);
   }

   public void calculLesJourDunMois() throws ParseException {
      this.lesjoursItems = new ArrayList();
      String[] var1 = this.journauxMois.getJoumenPeriode().split(":");
      String var2 = var1[0];
      String var3 = var1[1];
      Date var4 = this.utilDate.stringToDateFr("01-" + var2 + "-" + var3);
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      Date var6 = this.utilDate.dateDernierJourMois(var4);
      GregorianCalendar var7 = new GregorianCalendar();
      var7.setTime(var6);

      for(int var8 = 1; var5.compareTo(var7) <= 0; ++var8) {
         var5.add(5, 1);
         this.lesjoursItems.add(new SelectItem(var8));
      }

   }

   public void selectionJournauxActifs() throws NamingException {
      if (this.extDTableJournaux != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionJournaux.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableJournaux.setRowKey(var3);
            if (this.extDTableJournaux.isRowAvailable()) {
               var1.add(this.extDTableJournaux.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.journauxActif = (JournauxComptables)var1.get(0);
            this.selectionJournauxActifsSuite();
         }
      }

   }

   public void selectionJournauxActifsSuite() throws NamingException {
      if (this.journauxActif != null) {
         this.afficheTJM = true;
         this.afficheTJJ = false;
         this.lesjournauxMois = new ArrayList();
         this.lesjournauxMois = this.journauxMoisDao.mesjournauxmois(this.journauxActif.getPljCode(), this.selectedExo, (Session)null);
         if (this.nbPeriode > this.lesjournauxMois.size()) {
            this.journauxMoisDao.ajoutPeriode(this.journauxActif, this.selectedExo, this.mesPeriodes);
            this.lesjournauxMois.clear();
            this.lesjournauxMois = this.journauxMoisDao.mesjournauxmois(this.journauxActif.getPljCode(), this.selectedExo, (Session)null);
         }

         UtilTrie var1 = new UtilTrie();
         this.lesjournauxMois = var1.triListeJournaux(this.lesjournauxMois);
         this.lesjournauxMois = var1.triListeJournaux(this.lesjournauxMois);
         this.dataModelMois.setWrappedData(this.lesjournauxMois);
      }

   }

   public void selectionMoisSaisieLight() throws HibernateException, NamingException, ParseException {
      if (this.journauxActif != null && this.extDTablePeriode != null) {
         int var1 = 0;
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.simpleSelectionPeriode.getKeys();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var1 = Integer.parseInt(var4.toString());
            this.extDTablePeriode.setRowKey(var4);
            if (this.extDTablePeriode.isRowAvailable()) {
               var2.add(this.extDTablePeriode.getRowData());
            }
         }

         for(int var5 = 0; var5 < this.lesjournauxMois.size(); ++var5) {
            this.journauxMois = (JournauxMois)this.lesjournauxMois.get(var5);
            if (var5 == var1) {
               this.journauxMois.setSelect(true);
            } else {
               this.journauxMois.setSelect(false);
            }
         }

         if (var2.size() != 0) {
            this.journauxMois = (JournauxMois)var2.get(0);
         }
      }

   }

   public void selectionMoisSaisie() throws HibernateException, NamingException, ParseException {
      if (this.extDTablePeriode != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionPeriode.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTablePeriode.setRowKey(var3);
            if (this.extDTablePeriode.isRowAvailable()) {
               var1.add(this.extDTablePeriode.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.journauxMois = (JournauxMois)var1.get(0);
            this.var_periode = this.journauxMois.getJoumenPeriode();
            this.var_format_devise = this.journauxActif.getPljFormatDevise();
            this.var_jr_nature = this.journauxActif.getPljNature();
            this.selecFiscalite = this.structureLog.getStrzonefiscale();
            this.compteTreso = this.journauxActif.getPljCompteTreso();
            String var4;
            String var5;
            String[] var9;
            if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
               var9 = this.journauxMois.getJoumenPeriode().split(":");
               var4 = var9[0];
               var5 = var9[1];
               Date var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-" + "01");
               long var7 = (long)(var6.getYear() + 1900);
               if (this.structureLog.getStrdatefiscale2() != null && (var6.compareTo(this.structureLog.getStrdatefiscale2()) > 0 || var7 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900))) {
                  this.selecFiscalite = this.structureLog.getStrzonefiscale2();
                  this.compteTreso = this.journauxActif.getPljCompteTresoNew();
               }
            }

            var9 = this.var_periode.split(":");
            var4 = var9[0];
            var5 = var9[1];
            this.var_periode_rapproche = var5 + ":" + var4;
            String var10 = var5 + "-" + var4 + "-01";
            this.DteDeb = this.utilDate.stringToDateSQLLight(var10);
            this.DteFin = this.utilDate.dateDernierJourMois(this.DteDeb);
            this.soldeReleve = this.journauxMois.getJoumenReleve();
            this.var_correctifImprimante = this.journauxMois.getJoumenCorrectif();
            this.var_correctifEcran = this.journauxMois.getJoumenCorrectifEcran();
            Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            this.calculAnterieur(var11);
            this.calculerSoldeAnterieur(var11);
            this.ChargerLesEcritures(var11);
            if (this.selectedExo.getExecpt_id() != this.lastExo.getExecpt_id()) {
               this.var_action = 3;
            } else if (this.journauxMois.getJoumenEtat() == 0) {
               this.var_action = 1;
            } else {
               this.var_action = 3;
            }

            this.utilInitHibernate.closeSession();
            this.ouvrirLeJournalEncours();
            this.calculette = 0.0D;
         }
      }

   }

   public void selectionMoisConsult() throws HibernateException, NamingException, ParseException {
      if (this.dataModelMois.isRowAvailable()) {
         this.journauxMois = (JournauxMois)this.dataModelMois.getRowData();
         this.ChargerLesEcritures((Session)null);
         this.ouvrirLeJournalEncours();
         this.var_action = 3;
      }

   }

   public void ChargerLesEcritures(Session var1) throws ParseException, HibernateException, NamingException {
      this.lesEcritures = new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      this.datamodelEcritures = new ListDataModel();
      this.soldeTreso = 0.0D;
      boolean var5 = false;
      byte var19;
      if (this.journauxActif.getPljNature() == 7) {
         var19 = 0;
      } else if (this.optionComptabilite.getTrf_rapprochement().equals("1")) {
         var19 = 1;
      } else {
         var19 = 0;
      }

      String[] var6 = this.var_periode_rapproche.split(":");
      Date var7 = this.utilDate.stringToDateSQLLight(var6[0] + "-" + var6[1] + "-01");
      List var2 = this.ecrituresDao.ChargerRapprochement(this.journauxActif.getPljCode(), this.compteTreso, this.DteFin, var7, this.selectedExo.getExecpt_id(), var19, var1);
      if (var2.size() != 0) {
         for(int var8 = 0; var8 < var2.size(); ++var8) {
            this.ecritures = (Ecritures)var2.get(var8);
            if (this.ecritures.getEcrRapprochement() != null && !this.ecritures.getEcrRapprochement().isEmpty() && !this.ecritures.getEcrRapprochement().equals(this.var_periode_rapproche)) {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrAnaActif(9);
            }

            this.lesEcritures.add(this.ecritures);
         }
      }

      List var3 = this.ecrituresAnterieurDao.chargerLesEcrituresRapp(this.journauxActif.getPljCode(), this.DteFin, var7, this.selectedExo.getExecpt_id(), 0, var1);
      int var9;
      EcrituresAnterieur var20;
      if (var3.size() != 0) {
         new EcrituresAnterieur();

         for(var9 = 0; var9 < var3.size(); ++var9) {
            var20 = (EcrituresAnterieur)var3.get(var9);
            this.ecritures = new Ecritures();
            this.ecritures.setEcr_id(0L);
            this.ecritures.setEcrIdOrigine(var20.getEcrant_id());
            this.ecritures.setEcrDateSaisie(var20.getEcrantDate());
            this.ecritures.setEcrPiece(var20.getEcrantPiece());
            this.ecritures.setEcrReference1(var20.getEcrantReference1());
            this.ecritures.setEcrReference2(var20.getEcrantReference2());
            this.ecritures.setEcrRapprochement(var20.getEcrantRapprochement());
            this.ecritures.setEcrLibelle(var20.getEcrantLibelle());
            this.ecritures.setEcrCompte("ANTERIEUR");
            this.ecritures.setEcrDebitSaisie(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditSaisie(var20.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitPays(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditPays(var20.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitGrp(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditGrp(var20.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitEuro(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditEuro(var20.getEcrantCreditSaisie());
            if (this.ecritures.getEcrRapprochement() != null && !this.ecritures.getEcrRapprochement().isEmpty() && !this.ecritures.getEcrRapprochement().equals(this.var_periode_rapproche)) {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrAnaActif(9);
            }

            this.lesEcritures.add(this.ecritures);
         }
      }

      List var4 = this.ecrituresAnterieurDao.chargerLesEcrituresRapp(this.journauxActif.getPljCode(), this.DteFin, var7, this.selectedExo.getExecpt_id(), 1, var1);
      if (var4.size() != 0) {
         new EcrituresAnterieur();

         for(var9 = 0; var9 < var4.size(); ++var9) {
            var20 = (EcrituresAnterieur)var4.get(var9);
            this.ecritures = new Ecritures();
            this.ecritures.setEcr_id(0L);
            this.ecritures.setEcrIdOrigine(var20.getEcrant_id());
            this.ecritures.setEcrDateSaisie(var20.getEcrantDate());
            this.ecritures.setEcrPiece(var20.getEcrantPiece());
            this.ecritures.setEcrReference1(var20.getEcrantReference1());
            this.ecritures.setEcrReference2(var20.getEcrantReference2());
            this.ecritures.setEcrRapprochement(var20.getEcrantRapprochement());
            this.ecritures.setEcrLibelle(var20.getEcrantLibelle());
            this.ecritures.setEcrCompte("EXTRA CPTE");
            this.ecritures.setEcrDebitSaisie(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditSaisie(var20.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitPays(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditPays(var20.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitGrp(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditGrp(var20.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitEuro(var20.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditEuro(var20.getEcrantCreditSaisie());
            if (this.ecritures.getEcrRapprochement() != null && !this.ecritures.getEcrRapprochement().isEmpty() && !this.ecritures.getEcrRapprochement().equals(this.var_periode_rapproche)) {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrAnaActif(9);
            }

            this.lesEcritures.add(this.ecritures);
         }
      }

      String var21 = this.convertitrPeriodeSql(this.var_periode);
      Date var22 = this.utilDate.stringToDateSQLLight(var21 + "-" + "01");
      Date var10 = this.utilDate.dateDernierJourMois(var22);
      String var11 = this.utilDate.dateToStringSQLLight(var10);
      new ArrayList();
      List var12 = this.ecrituresDao.calculSoldeAnterieur(this.var_periode, var11, this.compteTreso, this.journauxActif.getPljCode(), this.selectedExo.getExecpt_id(), var1);
      double var13 = 0.0D;
      double var15 = 0.0D;
      new Ecritures();

      for(int var18 = 0; var18 < var12.size(); ++var18) {
         Ecritures var17 = (Ecritures)var12.get(var18);
         if (var17.getEcrEtat() <= 1) {
            var13 += var17.getEcrDebitSaisie();
            var15 += var17.getEcrCreditSaisie();
         }
      }

      if (var13 > var15) {
         this.soldeTreso = var13 - var15;
      } else {
         this.soldeTreso = var15 - var13;
      }

      this.datamodelEcritures.setWrappedData(this.lesEcritures);
      this.calcultotaux();
      this.ecritures = new Ecritures();
   }

   public void ouvrirLeJournalEncours() throws HibernateException, NamingException {
      if (this.journauxMois != null && this.journauxMois.getJoumenEtat() == 0) {
         this.journauxMois.setJoumenOpenJournal(1);
         this.journauxMois.setJoumenOpenUserJournal(this.usersLog.getUsrPatronyme());
         this.journauxMois.setJoumenUserIdJournal(this.usersLog.getUsrid());
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
      }

   }

   public void fermerLeJournalEncours() throws NamingException {
      if (this.journauxMois != null && this.journauxMois.getJoumenEtat() == 0) {
         this.journauxMois.setJoumenOpenUserJournal("");
         this.journauxMois.setJoumenOpenJournal(0);
         this.journauxMois.setJoumenUserIdJournal(0L);
         this.journauxMois.setJoumenReleve(this.soldeReleve);
         this.journauxMois.setJoumenCorrectif(this.var_correctifImprimante);
         this.journauxMois.setJoumenCorrectifEcran(this.var_correctifEcran);
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
      }

      this.afficheTJM = true;
      this.var_action = 0;
   }

   public void ouvrirLeJournalJourEncours() throws HibernateException, NamingException {
      if (this.journauxJour != null && this.journauxJour.getJoujrEtat() == 0) {
         this.journauxJour.setJoujrOpenJournal(1);
         this.journauxJour.setJoujrOpenUserJournal(this.usersLog.getUsrPatronyme());
         this.journauxJour.setJoujrUserIdJournal(this.usersLog.getUsrid());
         this.journauxJour = this.journauxJourDao.majJournal(this.journauxJour);
      }

   }

   public void fermerLeJournalJourEncours() throws NamingException {
      if (this.journauxJour != null && this.journauxJour.getJoujrEtat() == 0) {
         this.journauxJour.setJoujrOpenUserJournal("");
         this.journauxJour.setJoujrOpenJournal(0);
         this.journauxJour.setJoujrUserIdJournal(0L);
         this.journauxJour.setJoujrReleve(this.soldeReleve);
         this.journauxJour.setJoujrCorrectif(this.var_correctifImprimante);
         this.journauxJour.setJoujrCorrectifEcran(this.var_correctifEcran);
         this.journauxJour = this.journauxJourDao.majJournal(this.journauxJour);
      }

      this.afficheTJM = true;
      this.var_action = 0;
   }

   public void selectionEcriture() {
      this.calculette = 0.0D;
      if (this.selection.size() != 0) {
         double var1 = 0.0D;
         double var3 = 0.0D;

         for(Iterator var5 = this.selection.getKeys(); var5.hasNext(); var3 += this.ecritures.getEcrCreditSaisie()) {
            Object var6 = var5.next();
            int var7 = Integer.parseInt(var6.toString());
            this.ecritures = (Ecritures)this.lesEcritures.get(var7);
            var1 += this.ecritures.getEcrDebitSaisie();
         }

         this.calculette = var1 - var3;
      }

   }

   public void fermerMessage() {
      this.showModalPanelMessage = false;
   }

   public void calculAnterieur(Session var1) throws ParseException, HibernateException, NamingException {
      int var2 = 0;
      if (this.lesjournauxMois.size() != 0) {
         for(int var3 = 0; var3 < this.lesjournauxMois.size(); ++var3) {
            if (this.journauxMois.getJoumenId() == ((JournauxMois)this.lesjournauxMois.get(var3)).getJoumenId()) {
               var2 = var3;
               break;
            }
         }
      }

      String var4;
      String var5;
      Date var6;
      String var7;
      String var8;
      String var9;
      JournauxMois var10;
      String[] var11;
      if (var2 == 0) {
         this.soldeAnterieur = this.journauxMois.getJoumenReleveAnte();
         this.var_correctifImprimante = this.journauxMois.getJoumenCorrectif();
         this.var_correctifEcran = this.journauxMois.getJoumenCorrectifEcran();
         if (this.soldeAnterieur == 0.0D) {
            var11 = this.journauxMois.getJoumenPeriode().split(":");
            var4 = var11[0];
            var5 = var11[1];
            var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-01");
            var6 = this.utilDate.dateMoisPrecedent(var6);
            var7 = "";
            if (var6.getMonth() + 1 <= 9) {
               var7 = "0" + (var6.getMonth() + 1);
            } else {
               var7 = "" + (var6.getMonth() + 1);
            }

            var8 = "" + (var6.getYear() + 1900);
            var9 = this.journauxActif.getPljCode() + ":" + var7 + ":" + var8;
            new JournauxMois();
            var10 = this.journauxMoisDao.recupererJournauxMois(var9, this.selectedExo, var1);
            if (var10 != null) {
               this.soldeAnterieur = var10.getJoumenReleve();
               this.var_correctifImprimante = this.journauxMois.getJoumenCorrectif();
               this.var_correctifEcran = this.journauxMois.getJoumenCorrectifEcran();
            } else {
               this.soldeAnterieur = 0.0D;
               this.var_correctifEcran = 0.0D;
               this.var_correctifImprimante = 0.0D;
            }
         }
      } else {
         var11 = this.journauxMois.getJoumenPeriode().split(":");
         var4 = var11[0];
         var5 = var11[1];
         var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-01");
         var6 = this.utilDate.dateMoisPrecedent(var6);
         var7 = "";
         if (var6.getMonth() + 1 <= 9) {
            var7 = "0" + (var6.getMonth() + 1);
         } else {
            var7 = "" + (var6.getMonth() + 1);
         }

         var8 = "" + (var6.getYear() + 1900);
         var9 = this.journauxActif.getPljCode() + ":" + var7 + ":" + var8;
         new JournauxMois();
         var10 = this.journauxMoisDao.recupererJournauxMois(var9, this.selectedExo, var1);
         if (var10 != null) {
            this.soldeAnterieur = var10.getJoumenReleve();
         } else {
            this.soldeAnterieur = 0.0D;
         }
      }

   }

   public void calcultotaux() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
         if (this.soldeAnterieur < 0.0D) {
            var1 = this.soldeAnterieur * -1.0D;
            var3 = 0.0D;
         } else {
            var1 = 0.0D;
            var3 = this.soldeAnterieur;
         }
      } else if (this.soldeAnterieur < 0.0D) {
         var1 = 0.0D;
         var3 = this.soldeAnterieur * -1.0D;
      } else {
         var1 = this.soldeAnterieur;
         var3 = 0.0D;
      }

      String[] var5 = this.journauxMois.getJoumenPeriode().split(":");
      String var6 = var5[1] + ":" + var5[0];
      this.soldeRapproche = 0.0D;
      this.ecart = 0.0D;
      this.var_final = 0.0D;
      this.var_tot_debit_np = 0.0D;
      this.var_tot_credit_np = 0.0D;
      this.var_tot_debit_p = 0.0D;
      this.var_tot_credit_p = 0.0D;
      this.var_tot_debit_eca = 0.0D;
      this.var_tot_credit_eca = 0.0D;
      if (this.lesEcritures.size() != 0) {
         new Ecritures();

         for(int var8 = 0; var8 < this.lesEcritures.size(); ++var8) {
            Ecritures var7 = (Ecritures)this.lesEcritures.get(var8);
            if (var7.getEcrRapprochement() != null && !var7.getEcrRapprochement().isEmpty()) {
               if (var7.getEcrRapprochement().equals(var6)) {
                  this.var_tot_debit_p += var7.getEcrDebitSaisie();
                  this.var_tot_credit_p += var7.getEcrCreditSaisie();
               }
            } else {
               this.var_tot_debit_np += var7.getEcrDebitSaisie();
               this.var_tot_credit_np += var7.getEcrCreditSaisie();
            }

            if (var7.getEcrCompte() != null && !var7.getEcrCompte().isEmpty() && var7.getEcr_id() == 0L && var7.getEcrCompte().equals("EXTRA CPTE") && var7.getEcrDateSaisie().compareTo(this.DteDeb) < 0) {
               this.var_tot_debit_eca += var7.getEcrDebitSaisie();
               this.var_tot_credit_eca += var7.getEcrCreditSaisie();
            }
         }

         this.soldeRapproche = this.var_tot_debit_p - this.var_tot_credit_p;
         this.testAffSuppImpList = true;
         this.ecart = this.soldeAnterieur - this.soldeRapproche;
      } else {
         this.soldeRapproche = 0.0D;
         this.ecart = this.soldeAnterieur - this.soldeRapproche;
         this.cloture = false;
         this.testAffSuppImpList = false;
         this.cloture = false;
      }

      double var11 = 0.0D;
      double var9 = 0.0D;
      if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
         var11 = var1 + Math.abs(this.var_tot_debit_p);
         var9 = var3 + Math.abs(this.var_tot_credit_p);
      } else {
         var11 = var1 + Math.abs(this.var_tot_debit_p);
         var9 = var3 + Math.abs(this.var_tot_credit_p);
      }

      this.var_final = Math.abs(this.soldeReleve) - Math.abs(var11 - var9) + this.var_correctifEcran;
      if ((this.soldeAnterieur != 0.0D || this.soldeRapproche != 0.0D) && this.var_final == 0.0D) {
         this.cloture = true;
      } else {
         this.cloture = false;
      }

   }

   public void calculerSoldeAnterieur(Session var1) throws NamingException, ParseException {
      this.soldeRapproche = 0.0D;
      this.soldeComptaAnterieur = 0.0D;
      if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 8 || this.journauxActif.getPljNature() == 9 || this.journauxActif.getPljNature() == 10) {
         this.cpTreso = this.compteTreso;
         String var2 = this.convertitrPeriodeSql(this.var_periode);
         String var3 = var2 + "-" + "01";
         Date var4 = this.utilDate.stringToDateSQLLight(var3);
         Date var5 = this.utilDate.dateDernierJourMois(var4);
         Date var6 = this.utilDate.dateJourSuivant(var5);
         String var7 = this.utilDate.dateToStringSQLLight(var6);
         new ArrayList();
         String var9 = "";
         if (this.selectedExo.getExecptDateDebut().getMonth() + 1 <= 9) {
            var9 = "0" + (this.selectedExo.getExecptDateDebut().getMonth() + 1);
         } else {
            var9 = "" + (this.selectedExo.getExecptDateDebut().getMonth() + 1);
         }

         String var10 = "" + (this.selectedExo.getExecptDateDebut().getYear() + 1900);
         String var11 = var9 + ":" + var10;
         List var8 = this.ecrituresDao.calculSoldeAnterieur(var11, var7, this.cpTreso, this.journauxActif.getPljCode(), this.selectedExo.getExecpt_id(), var1);
         double var12 = 0.0D;
         double var14 = 0.0D;
         new Ecritures();

         for(int var17 = 0; var17 < var8.size(); ++var17) {
            Ecritures var16 = (Ecritures)var8.get(var17);
            if (var16.getEcrEtat() <= 1) {
               var12 += var16.getEcrDebitSaisie();
               var14 += var16.getEcrCreditSaisie();
            }
         }

         this.soldeComptaAnterieur = var12 - var14;
      }

   }

   public String convertitrPeriodeSql(String var1) {
      String[] var2 = var1.split(":");
      String var3 = var2[0];
      String var4 = var2[1];
      String var5 = var4 + "-" + var3;
      return var5;
   }

   public void saveRapprochement() throws NamingException, ParseException {
      if (this.datamodelEcritures.isRowAvailable()) {
         this.ecrituresAnterieur = new EcrituresAnterieur();
         this.ecritures = (Ecritures)this.datamodelEcritures.getRowData();
         if (this.ecritures != null) {
            String[] var1;
            if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
               this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), (Session)null);
               if (this.ecrituresAnterieur != null) {
                  if (this.ecrituresAnterieur.getEcrantRapprochement() != null && !this.ecrituresAnterieur.getEcrantRapprochement().isEmpty()) {
                     if (this.ecrituresAnterieur.getEcrantRapprochement().equalsIgnoreCase(this.var_periode_rapproche)) {
                        this.ecrituresAnterieur.setEcrantRapprochement("");
                        this.ecrituresAnterieur.setEcrantDteRapprochement((Date)null);
                        this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur);
                        this.ecritures.setEcrRapprochement("");
                        this.ecritures.setEcrDteRapprochement((Date)null);
                        this.calcultotaux();
                     }
                  } else {
                     this.ecrituresAnterieur.setEcrantRapprochement(this.var_periode_rapproche);
                     var1 = this.var_periode_rapproche.split(":");
                     this.ecrituresAnterieur.setEcrantDteRapprochement(this.utilDate.stringToDateSQLLight(var1[0] + "-" + var1[1] + "-01"));
                     this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur);
                     this.ecritures.setEcrRapprochement(this.ecrituresAnterieur.getEcrantRapprochement());
                     this.calcultotaux();
                  }
               }
            } else if (this.ecritures.getEcrRapprochement() != null && !this.ecritures.getEcrRapprochement().isEmpty()) {
               if (this.ecritures.getEcrRapprochement().equalsIgnoreCase(this.var_periode_rapproche)) {
                  this.ecritures.setEcrRapprochement("");
                  this.ecritures.setEcrDteRapprochement((Date)null);
                  this.ecritures = this.ecrituresDao.modif(this.ecritures);
                  this.calcultotaux();
               }
            } else {
               this.ecritures.setEcrRapprochement(this.var_periode_rapproche);
               var1 = this.var_periode_rapproche.split(":");
               this.ecritures.setEcrDteRapprochement(this.utilDate.stringToDateSQLLight(var1[0] + "-" + var1[1] + "-01"));
               this.ecritures = this.ecrituresDao.modif(this.ecritures);
               this.calcultotaux();
            }
         }
      }

   }

   public void saveRapprochementANNULE() throws HibernateException, NamingException, ParseException {
      if (this.datamodelEcritures.isRowAvailable()) {
         this.ecrituresAnterieur = new EcrituresAnterieur();
         this.ecritures = (Ecritures)this.datamodelEcritures.getRowData();
         if (this.ecritures != null) {
            if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
               this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), (Session)null);
               if (this.ecrituresAnterieur != null) {
                  this.ecrituresAnterieur.setEcrantRapprochement("");
                  this.ecrituresAnterieur.setEcrantDteRapprochement((Date)null);
                  this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur);
                  this.ecritures.setEcrRapprochement("");
                  this.ecritures.setEcrDteRapprochement((Date)null);
                  this.ecritures.setEcrAnaActif(0);
                  if (this.ecrituresAnterieur.getEcrantPeriode().equals(this.var_periode_rapproche)) {
                     this.lesEcritures.remove(this.ecritures);
                     this.datamodelEcritures.setWrappedData(this.lesEcritures);
                  }

                  this.calcultotaux();
               }
            } else {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrDteRapprochement((Date)null);
               this.ecritures.setEcrAnaActif(0);
               this.ecritures = this.ecrituresDao.modif(this.ecritures);
               if (this.ecritures.getEcrPeriode().equals(this.var_periode_rapproche)) {
                  this.lesEcritures.remove(this.ecritures);
                  this.datamodelEcritures.setWrappedData(this.lesEcritures);
               }

               this.calcultotaux();
            }
         }
      }

   }

   public void effaceRapprochement() throws NamingException, ParseException {
      if (this.lesEcritures.size() != 0) {
         String[] var1 = this.var_periode.split(":");
         (new StringBuilder()).append(var1[1]).append(":").append(var1[0]).toString();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            var3.setFlushMode(FlushMode.MANUAL);
            int var5 = 0;

            while(true) {
               if (var5 >= this.lesEcritures.size()) {
                  var4.commit();
                  break;
               }

               this.ecritures = (Ecritures)this.lesEcritures.get(var5);
               if (this.ecritures.getEcrRapprochement() != null && !this.ecritures.getEcrRapprochement().isEmpty() && this.ecritures.getEcrRapprochement().equals(this.var_periode_rapproche)) {
                  if (this.ecritures.getEcr_id() != 0L) {
                     this.ecritures.setEcrRapprochement("");
                     this.ecritures.setEcrDteRapprochement((Date)null);
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var3);
                     var3.flush();
                  } else if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
                     this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), var3);
                     if (this.ecrituresAnterieur != null) {
                        this.ecrituresAnterieur.setEcrantRapprochement("");
                        this.ecrituresAnterieur.setEcrantDteRapprochement((Date)null);
                        this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur, var3);
                        var3.flush();
                        this.ecritures.setEcrRapprochement("");
                        this.ecritures.setEcrDteRapprochement((Date)null);
                     }
                  }
               }

               ++var5;
            }
         } catch (HibernateException var9) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ChargerLesEcritures((Session)null);
      }

   }

   public void pointeRapprochement() throws ParseException, HibernateException, NamingException {
      if (this.lesEcritures.size() != 0) {
         String[] var1 = this.var_periode_rapproche.split(":");
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            var2.setFlushMode(FlushMode.MANUAL);
            int var4 = 0;

            while(true) {
               if (var4 >= this.lesEcritures.size()) {
                  var3.commit();
                  break;
               }

               this.ecritures = (Ecritures)this.lesEcritures.get(var4);
               if (this.ecritures.getEcrRapprochement() == null || this.ecritures.getEcrRapprochement().isEmpty()) {
                  if (this.ecritures.getEcr_id() != 0L) {
                     this.ecritures.setEcrRapprochement(this.var_periode_rapproche);
                     this.ecritures.setEcrDteRapprochement(this.utilDate.stringToDateSQLLight(var1[0] + "-" + var1[1] + "-01"));
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var2);
                     var2.flush();
                  } else if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
                     this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), var2);
                     if (this.ecrituresAnterieur != null) {
                        this.ecrituresAnterieur.setEcrantRapprochement(this.var_periode_rapproche);
                        this.ecrituresAnterieur.setEcrantDteRapprochement(this.utilDate.stringToDateSQLLight(var1[0] + "-" + var1[1] + "-01"));
                        this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur, var2);
                        var2.flush();
                        this.ecritures.setEcrRapprochement(this.var_periode_rapproche);
                        this.ecritures.setEcrDteRapprochement(this.ecrituresAnterieur.getEcrantDteRapprochement());
                     }
                  }
               }

               ++var4;
            }
         } catch (HibernateException var8) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ChargerLesEcritures((Session)null);
      }

   }

   public void suprimeEcritureExtra() throws HibernateException, NamingException {
      if (this.ecritures != null) {
         if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
            if (this.ecritures.getEcrRapprochement() != null && !this.ecritures.getEcrRapprochement().isEmpty()) {
               this.message = "Cette écriture est déjà rapprochée. Vous ne pouvez pas la supprimer...";
               this.showModalPanelMessage = true;
            } else {
               this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), (Session)null);
               if (this.ecrituresAnterieur != null) {
                  this.ecrituresAnterieurDao.delete(this.ecrituresAnterieur);
                  this.lesEcritures.remove(this.ecritures);
                  this.datamodelEcritures.setWrappedData(this.lesEcritures);
                  this.calcultotaux();
               }
            }
         } else {
            this.message = "Cette écriture n'est pas une écriture extra-comptable. Vous ne pouvez pas la supprimer...";
            this.showModalPanelMessage = true;
         }
      }

   }

   public void clotureRapprochement() throws NamingException, Exception {
      if (this.journauxMois != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.lesEcritures.size() != 0) {
               new Ecritures();

               for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
                  Ecritures var3 = (Ecritures)this.lesEcritures.get(var4);
                  if (var3.getEcrEtat() == 2 && var3.getEcrRapprochement() != null && !var3.getEcrRapprochement().isEmpty()) {
                     var3.setEcrEtat(0);
                     this.ecrituresDao.modif(this.ecritures, var1);
                     var1.flush();
                  }
               }
            }

            this.journauxMois.setJoumenEtat(1);
            this.journauxMois.setJoumenOpenUserJournal("");
            this.journauxMois.setJoumenOpenJournal(0);
            this.journauxMois.setJoumenUserIdJournal(0L);
            this.journauxMois.setJoumenReleve(this.soldeReleve);
            this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois, var1);
            var1.flush();
            if (this.optionComptabilite.getMailClotureRappro() != null && !this.optionComptabilite.getMailClotureRappro().isEmpty() && this.optionComptabilite.getMailClotureRappro().contains("@")) {
               UtilMail var10 = new UtilMail(this.structureLog);
               String var11 = "Banque: " + this.journauxMois.getJoumenCode() + " Période:" + this.journauxMois.getJoumenPeriode();
               var10.envoieMailRappro(this.structureLog, this.usersLog, var11, 0, this.optionComptabilite.getMailClotureRappro(), this.utilDate);
            }

            var2.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.afficheTJM = false;
      this.var_action = 0;
   }

   public void actualiserCtrl() {
      this.calcultotaux();
   }

   public void ajouterExtra() throws ParseException {
      this.ecrituresAnterieur = new EcrituresAnterieur();
      this.calculLesJourDunMois();
      this.var_jour = (new Date()).getDate();
      this.showModalPanelExtra = true;
   }

   public void annulerExtra() {
      this.showModalPanelExtra = false;
   }

   public void valideExtra() throws ParseException, HibernateException, NamingException {
      this.ecrituresAnterieur.setExercicesComptable(this.selectedExo);
      String[] var1 = this.journauxMois.getJoumenPeriode().split(":");
      String var2 = var1[0];
      String var3 = var1[1];
      String var4 = "";
      if (this.var_jour <= 9) {
         var4 = "0" + this.var_jour;
      } else {
         var4 = "" + this.var_jour;
      }

      Date var5 = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-" + var4);
      this.ecrituresAnterieur.setEcrantDate(var5);
      this.ecrituresAnterieur.setEcrantCode(this.journauxActif.getPljCode());
      this.ecrituresAnterieur.setEcrantAnnee("" + this.selectedExo.getExecpt_id());
      this.ecrituresAnterieur.setEcrantPeriode(this.journauxMois.getJoumenPeriode());
      this.ecrituresAnterieur.setEcrantType(1);
      this.ecrituresAnterieur.setEcrantCle1(this.journauxMois.getJoumenCle1());
      this.ecrituresAnterieur = this.ecrituresAnterieurDao.inser(this.ecrituresAnterieur);
      this.ecritures = new Ecritures();
      this.ecritures.setEcrIdOrigine(this.ecrituresAnterieur.getEcrant_id());
      this.ecritures.setEcrDateSaisie(this.ecrituresAnterieur.getEcrantDate());
      this.ecritures.setEcrPiece(this.ecrituresAnterieur.getEcrantPiece());
      this.ecritures.setEcrReference1(this.ecrituresAnterieur.getEcrantReference1());
      this.ecritures.setEcrReference2(this.ecrituresAnterieur.getEcrantReference2());
      this.ecritures.setEcrRapprochement(this.ecrituresAnterieur.getEcrantRapprochement());
      this.ecritures.setEcrLibelle(this.ecrituresAnterieur.getEcrantLibelle());
      this.ecritures.setEcrCompte("EXTRA CPTE");
      this.ecritures.setEcrDebitSaisie(this.ecrituresAnterieur.getEcrantDebitSaisie());
      this.ecritures.setEcrCreditSaisie(this.ecrituresAnterieur.getEcrantCreditSaisie());
      this.ecritures.setEcrDebitPays(this.ecrituresAnterieur.getEcrantDebitSaisie());
      this.ecritures.setEcrCreditPays(this.ecrituresAnterieur.getEcrantCreditSaisie());
      this.ecritures.setEcrDebitGrp(this.ecrituresAnterieur.getEcrantDebitSaisie());
      this.ecritures.setEcrCreditGrp(this.ecrituresAnterieur.getEcrantCreditSaisie());
      this.ecritures.setEcrDebitEuro(this.ecrituresAnterieur.getEcrantDebitSaisie());
      this.ecritures.setEcrCreditEuro(this.ecrituresAnterieur.getEcrantCreditSaisie());
      this.lesEcritures.add(this.ecritures);
      this.datamodelEcritures.setWrappedData(this.lesEcritures);
      this.showModalPanelExtra = false;
      this.calcultotaux();
   }

   public void saisieAnterieur() throws NamingException, ParseException {
      if (this.dataModelMois.isRowAvailable()) {
         this.journauxMois = (JournauxMois)this.dataModelMois.getRowData();
         this.var_correctifImprimante = this.journauxMois.getJoumenCorrectif();
         this.var_correctifEcran = this.journauxMois.getJoumenCorrectifEcran();
         String[] var1 = this.journauxMois.getJoumenPeriode().split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         Date var4 = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-01");
         var4 = this.utilDate.dateMoisPrecedent(var4);
         String var5 = "";
         if (var4.getMonth() + 1 <= 9) {
            var5 = "0" + (var4.getMonth() + 1);
         } else {
            var5 = "" + (var4.getMonth() + 1);
         }

         String var6 = "" + (var4.getYear() + 1900);
         this.jrperiode_ante = var5 + ":" + var6;
         this.var_action = 4;
         this.ChargerLesAnterieurs((Session)null);
         this.ecrituresAnterieur = new EcrituresAnterieur();
      }

   }

   public void ChargerLesAnterieurs(Session var1) throws HibernateException, NamingException {
      this.lesEcrituresAnterieurs = new ArrayList();
      this.datamodelAnte = new ListDataModel();
      String var2 = this.journauxActif.getPljCode() + ":" + this.jrperiode_ante;
      this.lesEcrituresAnterieurs = this.ecrituresAnterieurDao.chargerAnterieur(var2, 0, var1);
      this.datamodelAnte.setWrappedData(this.lesEcrituresAnterieurs);
      this.calculEcritureAnterieur();
   }

   public void calculEcritureAnterieur() {
      this.totalMvtscredit = 0.0D;
      this.totalMvtsdebit = 0.0D;
      this.soldeAnterieur = 0.0D;
      this.releveAnte = this.journauxMois.getJoumenReleveAnte();
      if (this.lesEcrituresAnterieurs.size() != 0) {
         double var1 = 0.0D;
         double var3 = 0.0D;
         new EcrituresAnterieur();

         for(int var6 = 0; var6 < this.lesEcrituresAnterieurs.size(); ++var6) {
            EcrituresAnterieur var5 = (EcrituresAnterieur)this.lesEcrituresAnterieurs.get(var6);
            var1 += var5.getEcrantDebitSaisie();
            var3 += var5.getEcrantCreditSaisie();
         }

         this.totalMvtsdebit = var1;
         this.totalMvtscredit = var3;
         this.soldeAnterieur = var1 - var3;
      }

   }

   public void selectionAnte() {
      if (this.datamodelAnte.isRowAvailable()) {
         this.ecrituresAnterieur = (EcrituresAnterieur)this.datamodelAnte.getRowData();
      }

   }

   public void addligneAnte() {
      this.ecrituresAnterieur = new EcrituresAnterieur();
   }

   public void deleteAnterieur() throws HibernateException, NamingException {
      if (this.ecrituresAnterieur != null) {
         this.lesEcrituresAnterieurs.remove(this.ecrituresAnterieur);
         this.ecrituresAnterieurDao.delete(this.ecrituresAnterieur);
         this.datamodelAnte.setWrappedData(this.lesEcrituresAnterieurs);
         this.calculEcritureAnterieur();
         this.addligneAnte();
      }

   }

   public void saveAnterieur() throws ParseException, HibernateException, NamingException {
      if (this.ecrituresAnterieur.getEcrant_id() == 0L) {
         this.ecrituresAnterieur.setEcrantCode(this.journauxActif.getPljCode());
         this.ecrituresAnterieur.setEcrantPeriode(this.jrperiode_ante);
         this.ecrituresAnterieur.setEcrantCle1(this.journauxActif.getPljCode() + ":" + this.jrperiode_ante);
         String[] var1 = this.jrperiode_ante.split(":");
         String var2 = var1[0];
         String var3 = var1[1];
         this.ecrituresAnterieur.setEcrantAnnee(var3);
         String var4 = var3 + "-" + var2 + "-01";
         Date var5 = this.utilDate.stringToDateSQLLight(var4);
         this.ecrituresAnterieur.setEcrantDate(var5);
         this.ecrituresAnterieur.setExercicesComptable(this.selectedExo);
         this.ecrituresAnterieur.setEcrantType(0);
         this.ecrituresAnterieur = this.ecrituresAnterieurDao.inser(this.ecrituresAnterieur);
         this.lesEcrituresAnterieurs.add(this.ecrituresAnterieur);
         this.datamodelAnte.setWrappedData(this.lesEcrituresAnterieurs);
      } else {
         this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur);
      }

      this.calculEcritureAnterieur();
      this.addligneAnte();
   }

   public void fermerLeJournalAnterieur() throws NamingException {
      if (this.journauxMois != null) {
         this.journauxMois.setJoumenOpenUserJournal("");
         this.journauxMois.setJoumenOpenJournal(0);
         this.journauxMois.setJoumenUserIdJournal(0L);
         this.journauxMois.setJoumenReleveAnte(this.releveAnte);
         this.journauxMois.setJoumenCorrectif(this.var_correctifImprimante);
         this.journauxMois.setJoumenCorrectifEcran(this.var_correctifEcran);
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
      }

      this.afficheTJM = false;
      this.var_action = 0;
   }

   public void selectionJournalJour() throws HibernateException, NamingException, ParseException {
      if (this.extDTablePeriode != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionPeriode.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTablePeriode.setRowKey(var3);
            if (this.extDTablePeriode.isRowAvailable()) {
               var1.add(this.extDTablePeriode.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.journauxMois = (JournauxMois)var1.get(0);
            this.extDTableJour = new HtmlExtendedDataTable();
            this.simpleSelectionJour.clear();
            this.afficheTJJ = true;
            this.lesjournauxJour.clear();
            this.lesjournauxJour = this.journauxJourDao.mesjournauxjour(this.journauxActif.getPljCode(), this.journauxMois.getJoumenPeriode(), this.selectedExo, (Session)null);
            if (this.lesjournauxJour.size() == 0) {
               this.journauxJourDao.ajoutPeriode(this.journauxActif, this.journauxMois.getJoumenPeriode(), this.selectedExo);
               this.lesjournauxJour.clear();
               this.lesjournauxJour = this.journauxJourDao.mesjournauxjour(this.journauxActif.getPljCode(), this.journauxMois.getJoumenPeriode(), this.selectedExo, (Session)null);
            }

            this.dataModelJour.setWrappedData(this.lesjournauxJour);
            this.journauxJour = null;
         }
      }

   }

   public void selectionJourSaisie() throws HibernateException, NamingException, ParseException {
      if (this.extDTableJour != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionJour.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableJour.setRowKey(var3);
            if (this.extDTableJour.isRowAvailable()) {
               var1.add(this.extDTableJour.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.journauxJour = (JournauxJour)var1.get(0);
            this.var_periode = this.journauxJour.getJoujrPeriode();
            this.var_format_devise = this.journauxActif.getPljFormatDevise();
            this.var_jr_nature = this.journauxActif.getPljNature();
            this.selecFiscalite = this.structureLog.getStrzonefiscale();
            this.compteTreso = this.journauxActif.getPljCompteTreso();
            String var4;
            String var5;
            if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
               String[] var9 = this.journauxJour.getJoujrPeriode().split(":");
               var4 = var9[0];
               var5 = var9[1];
               Date var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-" + "01");
               long var7 = (long)(var6.getYear() + 1900);
               if (this.structureLog.getStrdatefiscale2() != null && (var6.compareTo(this.structureLog.getStrdatefiscale2()) > 0 || var7 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900))) {
                  this.selecFiscalite = this.structureLog.getStrzonefiscale2();
                  this.compteTreso = this.journauxActif.getPljCompteTresoNew();
               }
            }

            this.var_jour_rapproche = this.journauxJour.getJoujrDate();
            String var10 = "";
            if (this.var_jour_rapproche.getMonth() <= 9) {
               var10 = "0" + this.var_jour_rapproche.getMonth();
            } else {
               var10 = "" + this.var_jour_rapproche.getMonth();
            }

            var4 = "" + (this.var_jour_rapproche.getYear() + 1900);
            this.var_periode_rapproche = var4 + ":" + var10;
            var5 = var4 + "-" + var10 + "-01";
            this.DteDeb = this.utilDate.stringToDateSQLLight(var5);
            this.DteFin = this.journauxJour.getJoujrDate();
            this.soldeReleve = this.journauxJour.getJoujrReleve();
            this.var_correctifImprimante = this.journauxJour.getJoujrCorrectif();
            this.var_correctifEcran = this.journauxJour.getJoujrCorrectifEcran();
            Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            this.calculerSoldeJourAnterieur(var11);
            this.ChargerLesEcrituresJour(var11);
            if (this.selectedExo.getExecpt_id() != this.lastExo.getExecpt_id()) {
               this.var_action = 3;
            } else if (this.journauxJour.getJoujrEtat() == 0) {
               this.var_action = 1;
            } else {
               this.var_action = 3;
            }

            this.utilInitHibernate.closeSession();
            this.ouvrirLeJournalJourEncours();
            this.calculette = 0.0D;
         }
      }

   }

   public void selectionJourSaisieLight() throws HibernateException, NamingException, ParseException {
      if (this.journauxActif != null && this.extDTableJour != null) {
         int var1 = 0;
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.simpleSelectionJour.getKeys();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var1 = Integer.parseInt(var4.toString());
            this.extDTableJour.setRowKey(var4);
            if (this.extDTableJour.isRowAvailable()) {
               var2.add(this.extDTableJour.getRowData());
            }
         }

         for(int var5 = 0; var5 < this.lesjournauxJour.size(); ++var5) {
            this.journauxJour = (JournauxJour)this.lesjournauxJour.get(var5);
            if (var5 == var1) {
               this.journauxJour.setSelect(true);
            } else {
               this.journauxJour.setSelect(false);
            }
         }

         if (var2.size() != 0) {
            this.journauxJour = (JournauxJour)var2.get(0);
         }
      }

   }

   public void calculJourAnterieur(Session var1) throws ParseException, HibernateException, NamingException {
      int var2 = 0;
      if (this.lesjournauxJour.size() != 0) {
         for(int var3 = 0; var3 < this.lesjournauxJour.size(); ++var3) {
            if (this.journauxJour.getJoujrId() == ((JournauxJour)this.lesjournauxJour.get(var3)).getJoujrId()) {
               var2 = var3;
               break;
            }
         }
      }

      String var4;
      String var5;
      Date var6;
      String var7;
      String var8;
      String var9;
      JournauxMois var10;
      String[] var11;
      if (var2 == 0) {
         this.soldeAnterieur = this.journauxMois.getJoumenReleveAnte();
         this.var_correctifImprimante = this.journauxMois.getJoumenCorrectif();
         this.var_correctifEcran = this.journauxMois.getJoumenCorrectifEcran();
         if (this.soldeAnterieur == 0.0D) {
            var11 = this.journauxMois.getJoumenPeriode().split(":");
            var4 = var11[0];
            var5 = var11[1];
            var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-01");
            var6 = this.utilDate.dateMoisPrecedent(var6);
            var7 = "";
            if (var6.getMonth() + 1 <= 9) {
               var7 = "0" + (var6.getMonth() + 1);
            } else {
               var7 = "" + (var6.getMonth() + 1);
            }

            var8 = "" + (var6.getYear() + 1900);
            var9 = this.journauxActif.getPljCode() + ":" + var7 + ":" + var8;
            new JournauxMois();
            var10 = this.journauxMoisDao.recupererJournauxMois(var9, this.selectedExo, var1);
            if (var10 != null) {
               this.soldeAnterieur = var10.getJoumenReleve();
               this.var_correctifImprimante = this.journauxMois.getJoumenCorrectif();
               this.var_correctifEcran = this.journauxMois.getJoumenCorrectifEcran();
            } else {
               this.soldeAnterieur = 0.0D;
               this.var_correctifEcran = 0.0D;
               this.var_correctifImprimante = 0.0D;
            }
         }
      } else {
         var11 = this.journauxMois.getJoumenPeriode().split(":");
         var4 = var11[0];
         var5 = var11[1];
         var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-01");
         var6 = this.utilDate.dateMoisPrecedent(var6);
         var7 = "";
         if (var6.getMonth() + 1 <= 9) {
            var7 = "0" + (var6.getMonth() + 1);
         } else {
            var7 = "" + (var6.getMonth() + 1);
         }

         var8 = "" + (var6.getYear() + 1900);
         var9 = this.journauxActif.getPljCode() + ":" + var7 + ":" + var8;
         new JournauxMois();
         var10 = this.journauxMoisDao.recupererJournauxMois(var9, this.selectedExo, var1);
         if (var10 != null) {
            this.soldeAnterieur = var10.getJoumenReleve();
         } else {
            this.soldeAnterieur = 0.0D;
         }
      }

   }

   public void calculerSoldeJourAnterieur(Session var1) throws NamingException, ParseException {
      this.soldeRapproche = 0.0D;
      this.soldeComptaAnterieur = 0.0D;
      if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 8 || this.journauxActif.getPljNature() == 9 || this.journauxActif.getPljNature() == 10) {
         this.cpTreso = this.compteTreso;
         String var2 = this.utilDate.dateToStringSQLLight(this.var_jour_rapproche);
         new ArrayList();
         String var4 = "";
         if (this.selectedExo.getExecptDateDebut().getMonth() + 1 <= 9) {
            var4 = "0" + (this.selectedExo.getExecptDateDebut().getMonth() + 1);
         } else {
            var4 = "" + (this.selectedExo.getExecptDateDebut().getMonth() + 1);
         }

         String var5 = "" + (this.selectedExo.getExecptDateDebut().getYear() + 1900);
         String var6 = var4 + ":" + var5;
         List var3 = this.ecrituresDao.calculSoldeJour(var6, var2, this.cpTreso, this.journauxActif.getPljCode(), this.selectedExo.getExecpt_id(), var1);
         double var7 = 0.0D;
         double var9 = 0.0D;
         new Ecritures();

         for(int var12 = 0; var12 < var3.size(); ++var12) {
            Ecritures var11 = (Ecritures)var3.get(var12);
            if (var11.getEcrEtat() <= 1) {
               var7 += var11.getEcrDebitSaisie();
               var9 += var11.getEcrCreditSaisie();
            }
         }

         this.soldeComptaAnterieur = var7 - var9;
      }

   }

   public void ChargerLesEcrituresJour(Session var1) throws ParseException, HibernateException, NamingException {
      this.lesEcritures = new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      this.datamodelEcritures = new ListDataModel();
      this.soldeTreso = 0.0D;
      boolean var5 = false;
      byte var17;
      if (this.journauxActif.getPljNature() == 7) {
         var17 = 0;
      } else if (this.optionComptabilite.getTrf_rapprochement().equals("1")) {
         var17 = 1;
      } else {
         var17 = 0;
      }

      List var2 = this.ecrituresDao.ChargerRapprochement(this.journauxActif.getPljCode(), this.compteTreso, this.DteFin, this.var_jour_rapproche, this.selectedExo.getExecpt_id(), var17, var1);
      if (var2.size() != 0) {
         for(int var6 = 0; var6 < var2.size(); ++var6) {
            this.ecritures = (Ecritures)var2.get(var6);
            if (this.ecritures.getEcrDteRapprochement() != null && this.ecritures.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) != 0) {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrAnaActif(9);
            }

            this.lesEcritures.add(this.ecritures);
         }
      }

      List var3 = this.ecrituresAnterieurDao.chargerLesEcrituresRapp(this.journauxActif.getPljCode(), this.DteFin, this.var_jour_rapproche, this.selectedExo.getExecpt_id(), 0, var1);
      int var7;
      EcrituresAnterieur var18;
      if (var3.size() != 0) {
         new EcrituresAnterieur();

         for(var7 = 0; var7 < var3.size(); ++var7) {
            var18 = (EcrituresAnterieur)var3.get(var7);
            this.ecritures = new Ecritures();
            this.ecritures.setEcr_id(0L);
            this.ecritures.setEcrIdOrigine(var18.getEcrant_id());
            this.ecritures.setEcrDateSaisie(var18.getEcrantDate());
            this.ecritures.setEcrPiece(var18.getEcrantPiece());
            this.ecritures.setEcrReference1(var18.getEcrantReference1());
            this.ecritures.setEcrReference2(var18.getEcrantReference2());
            this.ecritures.setEcrRapprochement(var18.getEcrantRapprochement());
            this.ecritures.setEcrLibelle(var18.getEcrantLibelle());
            this.ecritures.setEcrCompte("ANTERIEUR");
            this.ecritures.setEcrDebitSaisie(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditSaisie(var18.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitPays(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditPays(var18.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitGrp(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditGrp(var18.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitEuro(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditEuro(var18.getEcrantCreditSaisie());
            if (this.ecritures.getEcrDteRapprochement() != null && this.ecritures.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) != 0) {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrAnaActif(9);
            }

            this.lesEcritures.add(this.ecritures);
         }
      }

      List var4 = this.ecrituresAnterieurDao.chargerLesEcrituresRapp(this.journauxActif.getPljCode(), this.DteFin, this.var_jour_rapproche, this.selectedExo.getExecpt_id(), 1, var1);
      if (var4.size() != 0) {
         new EcrituresAnterieur();

         for(var7 = 0; var7 < var4.size(); ++var7) {
            var18 = (EcrituresAnterieur)var4.get(var7);
            this.ecritures = new Ecritures();
            this.ecritures.setEcr_id(0L);
            this.ecritures.setEcrIdOrigine(var18.getEcrant_id());
            this.ecritures.setEcrDateSaisie(var18.getEcrantDate());
            this.ecritures.setEcrPiece(var18.getEcrantPiece());
            this.ecritures.setEcrReference1(var18.getEcrantReference1());
            this.ecritures.setEcrReference2(var18.getEcrantReference2());
            this.ecritures.setEcrRapprochement(var18.getEcrantRapprochement());
            this.ecritures.setEcrLibelle(var18.getEcrantLibelle());
            this.ecritures.setEcrCompte("EXTRA CPTE");
            this.ecritures.setEcrDebitSaisie(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditSaisie(var18.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitPays(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditPays(var18.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitGrp(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditGrp(var18.getEcrantCreditSaisie());
            this.ecritures.setEcrDebitEuro(var18.getEcrantDebitSaisie());
            this.ecritures.setEcrCreditEuro(var18.getEcrantCreditSaisie());
            if (this.ecritures.getEcrDteRapprochement() != null && this.ecritures.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) != 0) {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrAnaActif(9);
            }

            this.lesEcritures.add(this.ecritures);
         }
      }

      String var19 = this.convertitrPeriodeSql(this.var_periode);
      Date var20 = this.utilDate.stringToDateSQLLight(var19 + "-" + "01");
      Date var8 = this.utilDate.dateDernierJourMois(var20);
      String var9 = this.utilDate.dateToStringSQLLight(var8);
      new ArrayList();
      List var10 = this.ecrituresDao.calculSoldeAnterieur(this.var_periode, var9, this.compteTreso, this.journauxActif.getPljCode(), this.selectedExo.getExecpt_id(), var1);
      double var11 = 0.0D;
      double var13 = 0.0D;
      new Ecritures();

      for(int var16 = 0; var16 < var10.size(); ++var16) {
         Ecritures var15 = (Ecritures)var10.get(var16);
         if (var15.getEcrEtat() <= 1) {
            var11 += var15.getEcrDebitSaisie();
            var13 += var15.getEcrCreditSaisie();
         }
      }

      if (var11 > var13) {
         this.soldeTreso = var11 - var13;
      } else {
         this.soldeTreso = var13 - var11;
      }

      this.datamodelEcritures.setWrappedData(this.lesEcritures);
      this.calcultotauxJour();
      this.ecritures = new Ecritures();
   }

   public void calcultotauxJour() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
         if (this.soldeAnterieur < 0.0D) {
            var1 = this.soldeAnterieur * -1.0D;
            var3 = 0.0D;
         } else {
            var1 = 0.0D;
            var3 = this.soldeAnterieur;
         }
      } else if (this.soldeAnterieur < 0.0D) {
         var1 = 0.0D;
         var3 = this.soldeAnterieur * -1.0D;
      } else {
         var1 = this.soldeAnterieur;
         var3 = 0.0D;
      }

      String[] var5 = this.journauxJour.getJoujrPeriode().split(":");
      (new StringBuilder()).append(var5[1]).append(":").append(var5[0]).toString();
      this.soldeRapproche = 0.0D;
      this.ecart = 0.0D;
      this.var_final = 0.0D;
      this.var_tot_debit_np = 0.0D;
      this.var_tot_credit_np = 0.0D;
      this.var_tot_debit_p = 0.0D;
      this.var_tot_credit_p = 0.0D;
      this.var_tot_debit_eca = 0.0D;
      this.var_tot_credit_eca = 0.0D;
      if (this.lesEcritures.size() != 0) {
         new Ecritures();

         for(int var8 = 0; var8 < this.lesEcritures.size(); ++var8) {
            Ecritures var7 = (Ecritures)this.lesEcritures.get(var8);
            if (var7.getEcrDteRapprochement() == null) {
               this.var_tot_debit_np += var7.getEcrDebitSaisie();
               this.var_tot_credit_np += var7.getEcrCreditSaisie();
            } else if (var7.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) == 0) {
               this.var_tot_debit_p += var7.getEcrDebitSaisie();
               this.var_tot_credit_p += var7.getEcrCreditSaisie();
            }

            if (var7.getEcrCompte() != null && !var7.getEcrCompte().isEmpty() && var7.getEcr_id() == 0L && var7.getEcrCompte().equals("EXTRA CPTE") && var7.getEcrDateSaisie().compareTo(this.DteDeb) < 0) {
               this.var_tot_debit_eca += var7.getEcrDebitSaisie();
               this.var_tot_credit_eca += var7.getEcrCreditSaisie();
            }
         }

         this.soldeRapproche = this.var_tot_debit_p - this.var_tot_credit_p;
         this.testAffSuppImpList = true;
         this.ecart = this.soldeAnterieur - this.soldeRapproche;
      } else {
         this.soldeRapproche = 0.0D;
         this.ecart = this.soldeAnterieur - this.soldeRapproche;
         this.cloture = false;
         this.testAffSuppImpList = false;
         this.cloture = false;
      }

      double var11 = 0.0D;
      double var9 = 0.0D;
      if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
         var11 = var1 + Math.abs(this.var_tot_debit_p);
         var9 = var3 + Math.abs(this.var_tot_credit_p);
      } else {
         var11 = var1 + Math.abs(this.var_tot_debit_p);
         var9 = var3 + Math.abs(this.var_tot_credit_p);
      }

      this.var_final = Math.abs(this.soldeReleve) - Math.abs(var11 - var9) + this.var_correctifEcran;
      if ((this.soldeAnterieur != 0.0D || this.soldeRapproche != 0.0D) && this.var_final == 0.0D) {
         this.cloture = true;
      } else {
         this.cloture = false;
      }

   }

   public void saveRapprochementJour() throws NamingException, ParseException {
      if (this.datamodelEcritures.isRowAvailable()) {
         this.ecrituresAnterieur = new EcrituresAnterieur();
         this.ecritures = (Ecritures)this.datamodelEcritures.getRowData();
         if (this.ecritures != null) {
            if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
               this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), (Session)null);
               if (this.ecrituresAnterieur != null) {
                  if (this.ecrituresAnterieur.getEcrantDteRapprochement() == null) {
                     this.ecrituresAnterieur.setEcrantRapprochement(this.var_periode_rapproche);
                     this.ecrituresAnterieur.setEcrantDteRapprochement(this.var_jour_rapproche);
                     this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur);
                     this.ecritures.setEcrRapprochement(this.ecrituresAnterieur.getEcrantRapprochement());
                     this.calcultotauxJour();
                  } else if (this.ecrituresAnterieur.getEcrantDteRapprochement().compareTo(this.var_jour_rapproche) == 0) {
                     this.ecrituresAnterieur.setEcrantRapprochement("");
                     this.ecrituresAnterieur.setEcrantDteRapprochement((Date)null);
                     this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur);
                     this.ecritures.setEcrRapprochement("");
                     this.ecritures.setEcrDteRapprochement((Date)null);
                     this.calcultotauxJour();
                  }
               }
            } else if (this.ecritures.getEcrDteRapprochement() == null) {
               this.ecritures.setEcrRapprochement(this.var_periode_rapproche);
               this.ecritures.setEcrDteRapprochement(this.var_jour_rapproche);
               this.ecritures = this.ecrituresDao.modif(this.ecritures);
               this.calcultotauxJour();
            } else if (this.ecritures.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) == 0) {
               this.ecritures.setEcrRapprochement("");
               this.ecritures.setEcrDteRapprochement((Date)null);
               this.ecritures = this.ecrituresDao.modif(this.ecritures);
               this.calcultotauxJour();
            }
         }
      }

   }

   public void actualiserCtrlJour() {
      this.calcultotauxJour();
   }

   public void effaceRapprochementJour() throws NamingException, ParseException {
      if (this.lesEcritures.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesEcritures.size()) {
                  var2.commit();
                  break;
               }

               this.ecritures = (Ecritures)this.lesEcritures.get(var3);
               if (this.ecritures.getEcrDteRapprochement() != null && this.ecritures.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) == 0) {
                  if (this.ecritures.getEcr_id() != 0L) {
                     this.ecritures.setEcrRapprochement("");
                     this.ecritures.setEcrDteRapprochement((Date)null);
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                     var1.flush();
                  } else if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
                     this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), var1);
                     if (this.ecrituresAnterieur != null) {
                        this.ecrituresAnterieur.setEcrantRapprochement("");
                        this.ecrituresAnterieur.setEcrantDteRapprochement((Date)null);
                        this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur, var1);
                        var1.flush();
                        this.ecritures.setEcrRapprochement("");
                        this.ecritures.setEcrDteRapprochement((Date)null);
                     }
                  }
               }

               ++var3;
            }
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ChargerLesEcrituresJour((Session)null);
      }

   }

   public void pointeRapprochementJour() throws ParseException, HibernateException, NamingException {
      if (this.lesEcritures.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var3);
               if (this.ecritures.getEcrDteRapprochement() == null) {
                  if (this.ecritures.getEcr_id() != 0L) {
                     this.ecritures.setEcrRapprochement(this.var_periode_rapproche);
                     this.ecritures.setEcrDteRapprochement(this.var_jour_rapproche);
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                     var1.flush();
                  } else if (this.ecritures.getEcr_id() == 0L && this.ecritures.getEcrIdOrigine() != 0L) {
                     this.ecrituresAnterieur = this.ecrituresAnterieurDao.chercheAnterieur(this.ecritures.getEcrIdOrigine(), var1);
                     if (this.ecrituresAnterieur != null) {
                        this.ecrituresAnterieur.setEcrantRapprochement(this.var_periode_rapproche);
                        this.ecrituresAnterieur.setEcrantDteRapprochement(this.var_jour_rapproche);
                        this.ecrituresAnterieur = this.ecrituresAnterieurDao.modif(this.ecrituresAnterieur, var1);
                        var1.flush();
                        this.ecritures.setEcrRapprochement(this.var_periode_rapproche);
                        this.ecritures.setEcrDteRapprochement(this.ecrituresAnterieur.getEcrantDteRapprochement());
                     }
                  }
               }
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

         this.ChargerLesEcrituresJour((Session)null);
      }

   }

   public void clotureRapprochementJour() throws NamingException, Exception {
      if (this.journauxJour != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.lesEcritures.size() != 0) {
               new Ecritures();

               for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
                  Ecritures var3 = (Ecritures)this.lesEcritures.get(var4);
                  if (var3.getEcrEtat() == 2 && var3.getEcrRapprochement() != null && !var3.getEcrRapprochement().isEmpty()) {
                     var3.setEcrEtat(0);
                     this.ecrituresDao.modif(this.ecritures, var1);
                     var1.flush();
                  }
               }
            }

            this.journauxJour.setJoujrEtat(1);
            this.journauxJour.setJoujrOpenUserJournal("");
            this.journauxJour.setJoujrOpenJournal(0);
            this.journauxJour.setJoujrUserIdJournal(0L);
            this.journauxJour.setJoujrReleve(this.soldeReleve);
            this.journauxJour = this.journauxJourDao.majJournal(this.journauxJour, var1);
            var1.flush();
            if (this.optionComptabilite.getMailClotureRappro() != null && !this.optionComptabilite.getMailClotureRappro().isEmpty() && this.optionComptabilite.getMailClotureRappro().contains("@")) {
               UtilMail var10 = new UtilMail(this.structureLog);
               String var11 = "Banque: " + this.journauxJour.getJoujrCode() + " Date:" + this.utilDate.dateToStringFr(this.journauxJour.getJoujrDate());
               var10.envoieMailRappro(this.structureLog, this.usersLog, var11, 0, this.optionComptabilite.getMailClotureRappro(), this.utilDate);
            }

            var2.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.afficheTJM = true;
      this.afficheTJJ = false;
      this.var_action = 0;
   }

   public String[] triAlphabetique(String[] var1, int var2) {
      int var3 = var2;
      boolean var4;
      if (var2 != 0) {
         do {
            var4 = false;

            for(int var5 = 0; var5 < var3 - 1; ++var5) {
               if (var1[var5].compareToIgnoreCase(var1[var5 + 1]) > 0) {
                  this.echanger(var1, var5, var5 + 1);
                  var4 = true;
               }
            }

            --var3;
         } while(var4);
      }

      return var1;
   }

   public void echanger(String[] var1, int var2, int var3) {
      String var4 = var1[var2];
      var1[var2] = var1[var3];
      var1[var3] = var4;
   }

   public void chargerLesModelesImpresion() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "rapprochement";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesModelsimpression = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               String var6 = var3[var4];
               if (this.verificationAutorisation(var6)) {
                  int var7 = var5.indexOf(".");
                  var5 = var5.substring(0, var7);
                  this.lesModelsimpression.add(new SelectItem(var5));
               }
            }
         }
      }

   }

   public boolean verificationAutorisation(String var1) {
      boolean var2 = false;
      if (this.lesModelesAutorises != null && this.lesModelesAutorises.size() != 0) {
         for(int var3 = 0; var3 < this.lesModelesAutorises.size(); ++var3) {
            if (((String)this.lesModelesAutorises.get(var3)).toString().toLowerCase().contains(var1.toLowerCase())) {
               var2 = true;
               break;
            }
         }
      } else {
         var2 = true;
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         ArrayList var11 = new ArrayList();
         Ecritures var19;
         if (this.lesEcritures.size() == 0) {
            var19 = new Ecritures();
            if (this.optionComptabilite.getTrf_rapprochementMode().equals("1")) {
               var1.setDateFin(this.var_jour_rapproche);
               var1.setFiltre(this.journauxActif.getPljCode() + ": " + this.utilDate.dateToStringFrLg(this.var_jour_rapproche));
               var1.setValeur1(this.soldeComptaAnterieur);
               var1.setValeur2(this.soldeComptaAnterieur);
               var1.setValeur3(this.var_correctifImprimante);
            } else {
               var1.setDateFin(this.DteFin);
               var1.setFiltre(this.journauxActif.getPljCode() + ": " + this.journauxMois.getJoumenPeriode());
               var1.setValeur1(this.soldeComptaAnterieur);
               var1.setValeur2(this.soldeReleve);
               var1.setValeur3(this.var_correctifImprimante);
            }

            var11.add(var19);
         } else {
            String[] var12 = this.journauxMois.getJoumenPeriode().split(":");
            String var13 = var12[1] + ":" + var12[0];
            new Ecritures();
            boolean var15 = false;
            Ecritures var14;
            int var16;
            double var17;
            if (this.optionComptabilite.getTrf_rapprochementMode().equals("1")) {
               var1.setDateFin(this.var_jour_rapproche);
               var1.setFiltre(this.journauxActif.getPljCode() + ": " + this.utilDate.dateToStringFrLg(this.var_jour_rapproche));
               var1.setValeur1(this.soldeComptaAnterieur);
               var1.setValeur2(this.soldeComptaAnterieur);
               var1.setValeur3(this.var_correctifImprimante);
               if (var4.contains("Pointees")) {
                  var15 = true;
                  var1.setEntete("Rapprochement bancaire journalier (Ecritures pointées uniquement)");
               } else {
                  var1.setEntete("Rapprochement bancaire journalier");
               }

               for(var16 = 0; var16 < this.lesEcritures.size(); ++var16) {
                  var14 = (Ecritures)this.lesEcritures.get(var16);
                  if (!var15) {
                     if (var14.getEcrDteRapprochement() == null || var14.getEcrDteRapprochement() != null && var14.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) != 0) {
                        if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
                           var17 = var14.getEcrCreditGrp();
                           var14.setEcrCreditGrp(var14.getEcrDebitGrp());
                           var14.setEcrDebitGrp(var17);
                           var17 = var14.getEcrCreditPays();
                           var14.setEcrCreditPays(var14.getEcrDebitPays());
                           var14.setEcrDebitPays(var17);
                           var17 = var14.getEcrCreditSaisie();
                           var14.setEcrCreditSaisie(var14.getEcrDebitSaisie());
                           var14.setEcrDebitSaisie(var17);
                        }

                        var11.add(var14);
                     }
                  } else if (var14.getEcrDteRapprochement() != null && var14.getEcrDteRapprochement().compareTo(this.var_jour_rapproche) == 0) {
                     if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
                        var17 = var14.getEcrCreditGrp();
                        var14.setEcrCreditGrp(var14.getEcrDebitGrp());
                        var14.setEcrDebitGrp(var17);
                        var17 = var14.getEcrCreditPays();
                        var14.setEcrCreditPays(var14.getEcrDebitPays());
                        var14.setEcrDebitPays(var17);
                        var17 = var14.getEcrCreditSaisie();
                        var14.setEcrCreditSaisie(var14.getEcrDebitSaisie());
                        var14.setEcrDebitSaisie(var17);
                     }

                     var11.add(var14);
                  }
               }
            } else {
               var1.setDateFin(this.DteFin);
               var1.setFiltre(this.journauxActif.getPljCode() + ": " + this.journauxMois.getJoumenPeriode());
               var1.setValeur1(this.soldeComptaAnterieur);
               var1.setValeur2(this.soldeReleve);
               var1.setValeur3(this.var_correctifImprimante);
               if (var4.contains("Pointees")) {
                  var15 = true;
                  var1.setEntete("Rapprochement bancaire mensuel (Ecritures pointées uniquement)");
               } else {
                  var1.setEntete("Rapprochement bancaire mensuel");
               }

               for(var16 = 0; var16 < this.lesEcritures.size(); ++var16) {
                  var14 = (Ecritures)this.lesEcritures.get(var16);
                  if (!var15) {
                     if (var14.getEcrRapprochement() == null || var14.getEcrRapprochement().isEmpty() || var14.getEcrRapprochement() != null && !var14.getEcrRapprochement().isEmpty() && !var14.getEcrRapprochement().equals(var13)) {
                        if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
                           var17 = var14.getEcrCreditGrp();
                           var14.setEcrCreditGrp(var14.getEcrDebitGrp());
                           var14.setEcrDebitGrp(var17);
                           var17 = var14.getEcrCreditPays();
                           var14.setEcrCreditPays(var14.getEcrDebitPays());
                           var14.setEcrDebitPays(var17);
                           var17 = var14.getEcrCreditSaisie();
                           var14.setEcrCreditSaisie(var14.getEcrDebitSaisie());
                           var14.setEcrDebitSaisie(var17);
                        }

                        var11.add(var14);
                     }
                  } else if (var14.getEcrRapprochement() != null && !var14.getEcrRapprochement().isEmpty() && var14.getEcrRapprochement().equals(var13)) {
                     if (this.optionComptabilite.getTrf_rapprochement().equals("0")) {
                        var17 = var14.getEcrCreditGrp();
                        var14.setEcrCreditGrp(var14.getEcrDebitGrp());
                        var14.setEcrDebitGrp(var17);
                        var17 = var14.getEcrCreditPays();
                        var14.setEcrCreditPays(var14.getEcrDebitPays());
                        var14.setEcrDebitPays(var17);
                        var17 = var14.getEcrCreditSaisie();
                        var14.setEcrCreditSaisie(var14.getEcrDebitSaisie());
                        var14.setEcrDebitSaisie(var17);
                     }

                     var11.add(var14);
                  }
               }
            }
         }

         if (var11.size() == 0) {
            var19 = new Ecritures();
            var11.add(var19);
         }

         var1.setRapport(var4);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "rapprochement" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var20 = new JRBeanCollectionDataSource(var11);
         var1.setjRBeanCollectionDataSource(var20);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
         Session var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         if (this.optionComptabilite.getTrf_rapprochementMode().equals("1")) {
            this.ChargerLesEcrituresJour(var21);
         } else {
            this.ChargerLesEcritures(var21);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public boolean isTestfermerleJournal() {
      return this.testfermerleJournal;
   }

   public void setTestfermerleJournal(boolean var1) {
      this.testfermerleJournal = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public JournauxComptables getJournauxActif() {
      return this.journauxActif;
   }

   public void setJournauxActif(JournauxComptables var1) {
      this.journauxActif = var1;
   }

   public JournauxMois getJournauxMois() {
      return this.journauxMois;
   }

   public void setJournauxMois(JournauxMois var1) {
      this.journauxMois = var1;
   }

   public List getMesPeriodes() {
      return this.mesPeriodes;
   }

   public void setMesPeriodes(List var1) {
      this.mesPeriodes = var1;
   }

   public boolean isAfficheTJM() {
      return this.afficheTJM;
   }

   public void setAfficheTJM(boolean var1) {
      this.afficheTJM = var1;
   }

   public String getVar_periode() {
      return this.var_periode;
   }

   public void setVar_periode(String var1) {
      this.var_periode = var1;
   }

   public double getSoldeAnterieur() {
      return this.soldeAnterieur;
   }

   public void setSoldeAnterieur(double var1) {
      this.soldeAnterieur = var1;
   }

   public DataModel getDataModelMois() {
      return this.dataModelMois;
   }

   public void setDataModelMois(DataModel var1) {
      this.dataModelMois = var1;
   }

   public DataModel getDatamodelJournaux() {
      return this.datamodelJournaux;
   }

   public void setDatamodelJournaux(DataModel var1) {
      this.datamodelJournaux = var1;
   }

   public boolean isTestAffSuppImpList() {
      return this.testAffSuppImpList;
   }

   public void setTestAffSuppImpList(boolean var1) {
      this.testAffSuppImpList = var1;
   }

   public String getDevise() {
      return this.journauxActif.getPljChoixDevise();
   }

   public int getVar_jr_nature() {
      return this.var_jr_nature;
   }

   public void setVar_jr_nature(int var1) {
      this.var_jr_nature = var1;
   }

   public int getVar_format_devise() {
      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public ExercicesComptable getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesComptable var1) {
      this.selectedExo = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public DataModel getDatamodelEcritures() {
      return this.datamodelEcritures;
   }

   public void setDatamodelEcritures(DataModel var1) {
      this.datamodelEcritures = var1;
   }

   public Ecritures getEcritures() {
      return this.ecritures;
   }

   public void setEcritures(Ecritures var1) {
      this.ecritures = var1;
   }

   public int getNbPeriode() {
      return this.nbPeriode;
   }

   public void setNbPeriode(int var1) {
      this.nbPeriode = var1;
   }

   public String getCpTreso() {
      return this.cpTreso;
   }

   public void setCpTreso(String var1) {
      this.cpTreso = var1;
   }

   public double getEcart() {
      return this.ecart;
   }

   public void setEcart(double var1) {
      this.ecart = var1;
   }

   public double getSoldeRapproche() {
      return this.soldeRapproche;
   }

   public void setSoldeRapproche(double var1) {
      this.soldeRapproche = var1;
   }

   public double getSoldeReleve() {
      return this.soldeReleve;
   }

   public void setSoldeReleve(double var1) {
      this.soldeReleve = var1;
   }

   public String getJrperiode_ante() {
      return this.jrperiode_ante;
   }

   public void setJrperiode_ante(String var1) {
      this.jrperiode_ante = var1;
   }

   public double getCalculette() {
      return this.calculette;
   }

   public void setCalculette(double var1) {
      this.calculette = var1;
   }

   public SimpleSelection getSelection() {
      return this.selection;
   }

   public void setSelection(SimpleSelection var1) {
      this.selection = var1;
   }

   public DataModel getDatamodelAnte() {
      return this.datamodelAnte;
   }

   public void setDatamodelAnte(DataModel var1) {
      this.datamodelAnte = var1;
   }

   public EcrituresAnterieur getEcrituresAnterieur() {
      return this.ecrituresAnterieur;
   }

   public void setEcrituresAnterieur(EcrituresAnterieur var1) {
      this.ecrituresAnterieur = var1;
   }

   public double getReleveAnte() {
      return this.releveAnte;
   }

   public void setReleveAnte(double var1) {
      this.releveAnte = var1;
   }

   public double getTotalMvtscredit() {
      return this.totalMvtscredit;
   }

   public void setTotalMvtscredit(double var1) {
      this.totalMvtscredit = var1;
   }

   public double getTotalMvtsdebit() {
      return this.totalMvtsdebit;
   }

   public void setTotalMvtsdebit(double var1) {
      this.totalMvtsdebit = var1;
   }

   public boolean isShowModalPanelExtra() {
      return this.showModalPanelExtra;
   }

   public void setShowModalPanelExtra(boolean var1) {
      this.showModalPanelExtra = var1;
   }

   public int getVar_jour() {
      return this.var_jour;
   }

   public void setVar_jour(int var1) {
      this.var_jour = var1;
   }

   public List getLesjoursItems() {
      return this.lesjoursItems;
   }

   public void setLesjoursItems(List var1) {
      this.lesjoursItems = var1;
   }

   public boolean isCloture() {
      return this.cloture;
   }

   public void setCloture(boolean var1) {
      this.cloture = var1;
   }

   public double getVar_final() {
      return this.var_final;
   }

   public void setVar_final(double var1) {
      this.var_final = var1;
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

   public double getSoldeTreso() {
      return this.soldeTreso;
   }

   public void setSoldeTreso(double var1) {
      this.soldeTreso = var1;
   }

   public double getSoldeComptaAnterieur() {
      return this.soldeComptaAnterieur;
   }

   public void setSoldeComptaAnterieur(double var1) {
      this.soldeComptaAnterieur = var1;
   }

   public String getMessage() {
      return this.message;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public boolean isShowModalPanelMessage() {
      return this.showModalPanelMessage;
   }

   public void setShowModalPanelMessage(boolean var1) {
      this.showModalPanelMessage = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public double getVar_correctifEcran() {
      return this.var_correctifEcran;
   }

   public void setVar_correctifEcran(double var1) {
      this.var_correctifEcran = var1;
   }

   public double getVar_correctifImprimante() {
      return this.var_correctifImprimante;
   }

   public void setVar_correctifImprimante(double var1) {
      this.var_correctifImprimante = var1;
   }

   public double getVar_tot_credit_np() {
      return this.var_tot_credit_np;
   }

   public void setVar_tot_credit_np(double var1) {
      this.var_tot_credit_np = var1;
   }

   public double getVar_tot_credit_p() {
      return this.var_tot_credit_p;
   }

   public void setVar_tot_credit_p(double var1) {
      this.var_tot_credit_p = var1;
   }

   public double getVar_tot_debit_np() {
      return this.var_tot_debit_np;
   }

   public void setVar_tot_debit_np(double var1) {
      this.var_tot_debit_np = var1;
   }

   public double getVar_tot_debit_p() {
      return this.var_tot_debit_p;
   }

   public void setVar_tot_debit_p(double var1) {
      this.var_tot_debit_p = var1;
   }

   public double getVar_tot_credit_eca() {
      return this.var_tot_credit_eca;
   }

   public void setVar_tot_credit_eca(double var1) {
      this.var_tot_credit_eca = var1;
   }

   public double getVar_tot_debit_eca() {
      return this.var_tot_debit_eca;
   }

   public void setVar_tot_debit_eca(double var1) {
      this.var_tot_debit_eca = var1;
   }

   public UIDataTable getExtDTableJournaux() {
      return this.extDTableJournaux;
   }

   public void setExtDTableJournaux(UIDataTable var1) {
      this.extDTableJournaux = var1;
   }

   public UIDataTable getExtDTablePeriode() {
      return this.extDTablePeriode;
   }

   public void setExtDTablePeriode(UIDataTable var1) {
      this.extDTablePeriode = var1;
   }

   public SimpleSelection getSimpleSelectionJournaux() {
      return this.simpleSelectionJournaux;
   }

   public void setSimpleSelectionJournaux(SimpleSelection var1) {
      this.simpleSelectionJournaux = var1;
   }

   public SimpleSelection getSimpleSelectionPeriode() {
      return this.simpleSelectionPeriode;
   }

   public void setSimpleSelectionPeriode(SimpleSelection var1) {
      this.simpleSelectionPeriode = var1;
   }

   public boolean isAfficheTJJ() {
      return this.afficheTJJ;
   }

   public void setAfficheTJJ(boolean var1) {
      this.afficheTJJ = var1;
   }

   public DataModel getDataModelJour() {
      return this.dataModelJour;
   }

   public void setDataModelJour(DataModel var1) {
      this.dataModelJour = var1;
   }

   public UIDataTable getExtDTableJour() {
      return this.extDTableJour;
   }

   public void setExtDTableJour(UIDataTable var1) {
      this.extDTableJour = var1;
   }

   public SimpleSelection getSimpleSelectionJour() {
      return this.simpleSelectionJour;
   }

   public void setSimpleSelectionJour(SimpleSelection var1) {
      this.simpleSelectionJour = var1;
   }

   public JournauxJour getJournauxJour() {
      return this.journauxJour;
   }

   public void setJournauxJour(JournauxJour var1) {
      this.journauxJour = var1;
   }

   public Date getVar_jour_rapproche() {
      return this.var_jour_rapproche;
   }

   public void setVar_jour_rapproche(Date var1) {
      this.var_jour_rapproche = var1;
   }
}
