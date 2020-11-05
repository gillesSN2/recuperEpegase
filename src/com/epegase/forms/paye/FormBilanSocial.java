package com.epegase.forms.paye;

import com.epegase.forms.administration.FormBilanSocialConfigClient;
import com.epegase.systeme.classe.BsoResultats;
import com.epegase.systeme.classe.BsoTabElement;
import com.epegase.systeme.classe.BsoTabFormule;
import com.epegase.systeme.classe.BsoTabNom;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.PegTabElement;
import com.epegase.systeme.classe.PegTabFormule;
import com.epegase.systeme.classe.PegTabNom;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresBalance;
import com.epegase.systeme.dao.BsoResultatsDao;
import com.epegase.systeme.dao.BsoTabElementDao;
import com.epegase.systeme.dao.BsoTabFormuleDao;
import com.epegase.systeme.dao.BsoTabNomDao;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.PegTabElementDao;
import com.epegase.systeme.dao.PegTabFormuleDao;
import com.epegase.systeme.dao.PegTabNomDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

public class FormBilanSocial implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private String pageIndex;
   private int nature = 0;
   private OptionPaye optionPaye;
   private ExercicesPaye selectedExo;
   private ExercicesPaye lastExo;
   private ExercicesPayeDao exercicesPayeDao;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List balanceListe = new ArrayList();
   private List lesTableaux = new ArrayList();
   private List lesTableauxItems = new ArrayList();
   private String var_tableau_selectionne;
   private List lesResultats = new ArrayList();
   private List listMemoResultat = new ArrayList();
   private transient DataModel dataModelResultat = new ListDataModel();
   private BsoTabNom cptTabNom;
   private BsoTabNomDao bsoTabNomDao;
   private BsoTabElement cptTabElement;
   private BsoTabElementDao bsoTabElementDao;
   private BsoTabFormule cptTabFormule;
   private BsoTabFormuleDao bsoTabFormuleDao;
   private boolean decoupageActivite;
   private PegTabNom pegTabNom;
   private PegTabNomDao pegTabNomDao;
   private PegTabElement pegTabElement;
   private PegTabElementDao pegTabElementDao;
   private PegTabFormule pegTabFormule;
   private PegTabFormuleDao pegTabFormuleDao;
   private BsoResultats tabResultats;
   private BsoResultatsDao bsoResultatsDao;
   private boolean afficheValider = false;
   private boolean modeModifierTab = false;
   private List lesNomsColEtatFin = new ArrayList();
   private boolean testAffElmtOrTabResultat;
   private BulletinLigneDao bulletinLigneDao;
   private List lesLigneBulletins = new ArrayList();
   private List lesBulletins = new ArrayList();
   private SalariesDao salariesDao;
   private List lesSalaries = new ArrayList();
   private double resultat1;
   private double resultat2;
   private String resultat3;
   private Date dateDebCalcul = null;
   private Date dateFinCalcul = null;
   private Date memoDateDebCalcul = null;
   private Date memoDateFinCalcul = null;
   private String operateur = "";
   private boolean allSelect = false;
   private int var_currentValue;
   private boolean var_showBarProg = false;
   private String var_date_periode_deb;
   private String var_date_periode_fin;
   private long var_exercice;
   private boolean var_aff_col01;
   private boolean var_aff_col02;
   private boolean var_aff_col03;
   private boolean var_aff_col04;
   private boolean var_aff_col05;
   private boolean var_aff_col06;
   private boolean var_aff_col07;
   private boolean var_aff_col08;
   private boolean var_aff_col09;
   private boolean var_aff_col10;
   private boolean var_aff_col11;
   private boolean var_aff_col12;
   private boolean var_aff_col13;
   private boolean var_aff_col14;
   private boolean var_aff_col15;
   private boolean var_aff_col16;
   private boolean var_aff_col17;
   private boolean var_aff_col18;
   private boolean var_aff_col19;
   private boolean var_aff_col20;
   private int var_largeur_tableau;
   private int var_largeur_col1;
   private int var_largeur_col2;
   private int var_largeur_col3;
   private int var_largeur_col4;
   private int var_largeur_col5;
   private int var_largeur_col6;
   private int var_largeur_col7;
   private int var_largeur_col8;
   private int var_largeur_col9;
   private int var_largeur_col10;
   private int var_largeur_col11;
   private int var_largeur_col12;
   private int var_largeur_col13;
   private int var_largeur_col14;
   private int var_largeur_col15;
   private int var_largeur_col16;
   private int var_largeur_col17;
   private int var_largeur_col18;
   private int var_largeur_col19;
   private int var_largeur_col20;
   private String elementEnCours;
   private String colonneEnCours;
   private String format;
   private String filtre;
   private String entete;
   private String requete;
   private boolean testAffImprimer;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private List tabResultatsList;
   private boolean showModalPanelPrint = false;
   private List lesModelsimpression;
   private String nomRapport;
   private int etatCumul;
   private boolean showModalPanelDetailCalcul = false;
   private EcrituresBalance ecrituresBalance;
   private List lesEcrituresDetail = new ArrayList();
   private transient DataModel dataModelEcrituresDetail = new ListDataModel();
   private List lesFormules = new ArrayList();

   public void InstancesDaoUtilses() {
      this.pegTabNomDao = new PegTabNomDao(this.utilInitHibernate);
      this.pegTabElementDao = new PegTabElementDao(this.utilInitHibernate);
      this.pegTabFormuleDao = new PegTabFormuleDao(this.utilInitHibernate);
      this.bsoTabNomDao = new BsoTabNomDao(this.baseLog, this.utilInitHibernate);
      this.bsoTabElementDao = new BsoTabElementDao(this.baseLog, this.utilInitHibernate);
      this.bsoTabFormuleDao = new BsoTabFormuleDao(this.baseLog, this.utilInitHibernate);
      this.bsoResultatsDao = new BsoResultatsDao(this.baseLog, this.utilInitHibernate);
      this.bulletinLigneDao = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesPayeDao = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerMesTabNom(int var1, Session var2) throws HibernateException, NamingException {
      this.lesResultats = new ArrayList();
      this.dataModelResultat = new ListDataModel();
      this.lesTableaux = new ArrayList();
      this.lesTableauxItems = new ArrayList();
      this.lesTableaux = this.bsoTabNomDao.chargerMesTabNomExp(var1, this.structureLog.getStrbilansocial(), var2);
      if (this.lesTableaux.size() != 0) {
         for(int var3 = 0; var3 < this.lesTableaux.size(); ++var3) {
            this.lesTableauxItems.add(new SelectItem(((BsoTabNom)this.lesTableaux.get(var3)).getTablisCode(), ((BsoTabNom)this.lesTableaux.get(var3)).getTablisCode() + ":" + ((BsoTabNom)this.lesTableaux.get(var3)).getTablisLibFR()));
         }
      }

      this.dateDebCalcul = this.selectedExo.getExepayDateDebut();
      this.dateFinCalcul = this.selectedExo.getExepayDateFin();
      this.memoDateDebCalcul = this.dateDebCalcul;
      this.memoDateFinCalcul = this.dateFinCalcul;
      this.afficheValider = true;
      this.cptTabNom = new BsoTabNom();
      this.var_tableau_selectionne = "";
      this.decoupageActivite = false;
   }

   public void calculerBilan() throws HibernateException, NamingException, ParseException {
      if (this.lesTableaux.size() != 0) {
         String var1 = this.var_tableau_selectionne;
         this.memoDateDebCalcul = this.utilDate.dateToSQL(this.dateDebCalcul, "00", "00", "00");
         this.memoDateFinCalcul = this.utilDate.dateToSQL(this.dateFinCalcul, "23", "59", "59");

         for(int var2 = 0; var2 < this.lesTableaux.size(); ++var2) {
            this.cptTabNom = (BsoTabNom)this.lesTableaux.get(var2);
            if ((this.cptTabNom.getTablisType() == 0 || this.cptTabNom.getTablisType() == 1) && (this.cptTabNom.getTablisCode().equals("BA") || this.cptTabNom.getTablisCode().equals("BP") || this.cptTabNom.getTablisCode().equals("CRC") || this.cptTabNom.getTablisCode().equals("CRP") || this.cptTabNom.getTablisCode().equals("TAF1") || this.cptTabNom.getTablisCode().equals("TAF2") || this.cptTabNom.getTablisCode().equals("TAF3") || this.cptTabNom.getTablisCode().equals("TAF4"))) {
               this.calculTableaux();
            }
         }

         this.var_tableau_selectionne = var1;
         this.selectionBilanSocial();
      }

   }

   public void calculerTableauxAnnexes() throws HibernateException, NamingException, ParseException {
      if (this.lesTableaux.size() != 0) {
         String var1 = this.var_tableau_selectionne;
         this.memoDateDebCalcul = this.utilDate.dateToSQL(this.dateDebCalcul, "00", "00", "00");
         this.memoDateFinCalcul = this.utilDate.dateToSQL(this.dateFinCalcul, "23", "59", "59");

         for(int var2 = 0; var2 < this.lesTableaux.size(); ++var2) {
            this.cptTabNom = (BsoTabNom)this.lesTableaux.get(var2);
            if ((this.cptTabNom.getTablisType() == 0 || this.cptTabNom.getTablisType() == 1) && (this.cptTabNom.getTablisCode().equals("T1") || this.cptTabNom.getTablisCode().equals("T2") || this.cptTabNom.getTablisCode().equals("T3") || this.cptTabNom.getTablisCode().equals("T4") || this.cptTabNom.getTablisCode().equals("T5") || this.cptTabNom.getTablisCode().equals("T6") || this.cptTabNom.getTablisCode().equals("T7") || this.cptTabNom.getTablisCode().equals("T8") || this.cptTabNom.getTablisCode().equals("T9") || this.cptTabNom.getTablisCode().equals("T10") || this.cptTabNom.getTablisCode().equals("T11") || this.cptTabNom.getTablisCode().equals("T12") || this.cptTabNom.getTablisCode().equals("T13"))) {
               this.calculTableaux();
            }
         }

         this.var_tableau_selectionne = var1;
         this.selectionBilanSocial();
      }

   }

   public void selectionBilanSocial() throws HibernateException, NamingException {
      this.cptTabNom = null;
      this.testAffImprimer = false;
      this.modeModifierTab = false;
      if (this.var_tableau_selectionne != null && !this.var_tableau_selectionne.isEmpty()) {
         for(int var1 = 0; var1 < this.lesTableaux.size(); ++var1) {
            if (((BsoTabNom)this.lesTableaux.get(var1)).getTablisCode().equals(this.var_tableau_selectionne)) {
               this.cptTabNom = new BsoTabNom();
               this.cptTabNom = (BsoTabNom)this.lesTableaux.get(var1);
               break;
            }
         }

         if (this.cptTabNom != null) {
            this.testAffImprimer = true;
            this.selectionBilanSuite();
         }
      }

   }

   public void selectionBilanSuite() throws HibernateException, NamingException {
      if (this.cptTabNom != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BilanSocial");
         this.chargerMesTabElementOrTabResultat(var1);
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionTableau() throws HibernateException, NamingException {
      this.cptTabNom = null;
      this.testAffImprimer = false;
      this.modeModifierTab = false;
      if (this.var_tableau_selectionne != null && !this.var_tableau_selectionne.isEmpty()) {
         for(int var1 = 0; var1 < this.lesTableaux.size(); ++var1) {
            if (((BsoTabNom)this.lesTableaux.get(var1)).getTablisCode().equals(this.var_tableau_selectionne)) {
               this.cptTabNom = (BsoTabNom)this.lesTableaux.get(var1);
               break;
            }
         }

         if (this.cptTabNom != null) {
            this.testAffImprimer = true;
            this.selectionTableauSuite();
         }
      }

   }

   public void selectionTableauSuite() throws HibernateException, NamingException {
      if (this.cptTabNom != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BilanSocial");
         if (this.cptTabNom.getTablisType() == 1) {
            this.chargerMesTabElementOrTabResultat(var1);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void chargerMesTabElementOrTabResultat(Session var1) throws HibernateException, NamingException {
      if (this.cptTabNom != null) {
         this.dateDebCalcul = this.selectedExo.getExepayDateDebut();
         this.dateFinCalcul = this.selectedExo.getExepayDateFin();
         this.memoDateDebCalcul = this.dateDebCalcul;
         this.memoDateFinCalcul = this.dateFinCalcul;
         this.lesResultats = new ArrayList();
         this.dataModelResultat = new ListDataModel();
         this.lesResultats = this.bsoResultatsDao.chargerMesTabResultats(this.cptTabNom.getTablisCode(), this.selectedExo.getExepayId(), var1);
         if (this.lesResultats.size() == 0) {
            this.lesResultats = new ArrayList();
            this.lesResultats = this.convertirTableau(var1);
            this.testAffElmtOrTabResultat = true;
         } else {
            if (((BsoResultats)this.lesResultats.get(0)).getTabresDateDeb() != null) {
               this.dateDebCalcul = ((BsoResultats)this.lesResultats.get(0)).getTabresDateDeb();
            }

            if (((BsoResultats)this.lesResultats.get(0)).getTabresDateFin() != null) {
               this.dateFinCalcul = ((BsoResultats)this.lesResultats.get(0)).getTabresDateFin();
            }

            this.memoDateDebCalcul = this.dateDebCalcul;
            this.memoDateFinCalcul = this.dateFinCalcul;
            this.testAffElmtOrTabResultat = false;
         }

         this.affichageColonne();
         this.var_largeur_tableau = this.var_largeur_col1 + this.var_largeur_col2 + this.var_largeur_col3 + this.var_largeur_col4 + this.var_largeur_col5 + this.var_largeur_col6 + this.var_largeur_col7 + this.var_largeur_col8 + this.var_largeur_col9 + this.var_largeur_col10 + this.var_largeur_col11 + this.var_largeur_col12 + this.var_largeur_col13 + this.var_largeur_col14 + this.var_largeur_col15 + this.var_largeur_col16 + this.var_largeur_col17 + this.var_largeur_col18 + this.var_largeur_col19 + this.var_largeur_col20 + 100 + 400 + 30;
         this.dataModelResultat.setWrappedData(this.lesResultats);
      }

   }

   public void chargerMesTabElementAnterieur(Session var1) throws HibernateException, NamingException {
      if (this.cptTabNom != null) {
         Date var2 = this.dateDebCalcul;
         Date var3 = this.dateFinCalcul;
         new ExercicesPaye();
         long var5 = this.selectedExo.getExepayId() - 1L;
         ExercicesPaye var4 = this.exercicesPayeDao.recupererLExoSelect(var5, var1);
         if (var4 != null) {
            this.dateDebCalcul = var4.getExepayDateDebut();
            this.dateFinCalcul = var4.getExepayDateFin();
            new ArrayList();
            this.lesResultats = new ArrayList();
            this.dataModelResultat = new ListDataModel();
            List var7 = this.bsoResultatsDao.chargerMesTabResultats(this.cptTabNom.getTablisCode(), var4.getExepayId(), var1);
            if (var7.size() == 0) {
               this.testAffElmtOrTabResultat = true;
            } else {
               this.testAffElmtOrTabResultat = false;
               if (var7.size() != 0) {
                  new BsoResultats();

                  for(int var9 = 0; var9 < var7.size(); ++var9) {
                     this.tabResultats = new BsoResultats();
                     BsoResultats var8 = (BsoResultats)var7.get(var9);
                     this.tabResultats.setExercicesPaye(this.selectedExo);
                     this.tabResultats.setTabresAnnee(this.selectedExo.getExepayId());
                     this.tabResultats.setTabresCode(var8.getTabresCode());
                     this.tabResultats.setTabresCol01(var8.getTabresCol01());
                     this.tabResultats.setTabresCol02(var8.getTabresCol02());
                     this.tabResultats.setTabresCol03(var8.getTabresCol03());
                     this.tabResultats.setTabresCol04(var8.getTabresCol04());
                     this.tabResultats.setTabresCol05(var8.getTabresCol05());
                     this.tabResultats.setTabresCol06(var8.getTabresCol06());
                     this.tabResultats.setTabresCol07(var8.getTabresCol07());
                     this.tabResultats.setTabresCol08(var8.getTabresCol08());
                     this.tabResultats.setTabresCol09(var8.getTabresCol09());
                     this.tabResultats.setTabresCol10(var8.getTabresCol10());
                     this.tabResultats.setTabresCol11(var8.getTabresCol11());
                     this.tabResultats.setTabresCol12(var8.getTabresCol12());
                     this.tabResultats.setTabresCol13(var8.getTabresCol13());
                     this.tabResultats.setTabresCol14(var8.getTabresCol14());
                     this.tabResultats.setTabresCol15(var8.getTabresCol15());
                     this.tabResultats.setTabresCol16(var8.getTabresCol16());
                     this.tabResultats.setTabresCol17(var8.getTabresCol17());
                     this.tabResultats.setTabresCol18(var8.getTabresCol18());
                     this.tabResultats.setTabresCol19(var8.getTabresCol19());
                     this.tabResultats.setTabresCol20(var8.getTabresCol20());
                     this.tabResultats.setTabresCon01(var8.getTabresCon01());
                     this.tabResultats.setTabresCon02(var8.getTabresCon02());
                     this.tabResultats.setTabresCon03(var8.getTabresCon03());
                     this.tabResultats.setTabresCon04(var8.getTabresCon04());
                     this.tabResultats.setTabresCon05(var8.getTabresCon05());
                     this.tabResultats.setTabresCon06(var8.getTabresCon06());
                     this.tabResultats.setTabresCon07(var8.getTabresCon07());
                     this.tabResultats.setTabresCon08(var8.getTabresCon08());
                     this.tabResultats.setTabresCon09(var8.getTabresCon09());
                     this.tabResultats.setTabresCon10(var8.getTabresCon10());
                     this.tabResultats.setTabresCon11(var8.getTabresCon11());
                     this.tabResultats.setTabresCon12(var8.getTabresCon12());
                     this.tabResultats.setTabresCon13(var8.getTabresCon13());
                     this.tabResultats.setTabresCon14(var8.getTabresCon14());
                     this.tabResultats.setTabresCon15(var8.getTabresCon15());
                     this.tabResultats.setTabresCon16(var8.getTabresCon16());
                     this.tabResultats.setTabresCon17(var8.getTabresCon17());
                     this.tabResultats.setTabresCon18(var8.getTabresCon18());
                     this.tabResultats.setTabresCon19(var8.getTabresCon19());
                     this.tabResultats.setTabresCon20(var8.getTabresCon20());
                     this.tabResultats.setTabresDateDeb(var2);
                     this.tabResultats.setTabresDateFin(var3);
                     this.tabResultats.setTabresIdElement(var8.getTabresIdElement());
                     this.tabResultats.setTabresJrRv(var8.getTabresJrRv());
                     this.tabResultats.setTabresJrSit(var8.getTabresJrSit());
                     this.tabResultats.setTabresLibFr(var8.getTabresLibFr());
                     this.tabResultats.setTabresLibSp(var8.getTabresLibSp());
                     this.tabResultats.setTabresLibUk(var8.getTabresLibUk());
                     this.tabResultats.setTabresMode(var8.getTabresMode());
                     this.tabResultats.setTabresNbMois(var8.getTabresNbMois());
                     this.tabResultats.setTabresNomFr(var8.getTabresNomFr());
                     this.tabResultats.setTabresNomSp(var8.getTabresNomSp());
                     this.tabResultats.setTabresNomUk(var8.getTabresNomUk());
                     this.tabResultats.setTabresNum(var8.getTabresNum());
                     this.tabResultats.setTabresPrint(var8.getTabresPrint());
                     this.tabResultats.setTabresReference(var8.getTabresReference());
                     this.tabResultats.setTabresType(var8.getTabresType());
                     this.tabResultats.setTabresTypeCol01(var8.getTabresTypeCol01());
                     this.tabResultats.setTabresTypeCol02(var8.getTabresTypeCol02());
                     this.tabResultats.setTabresTypeCol03(var8.getTabresTypeCol03());
                     this.tabResultats.setTabresTypeCol04(var8.getTabresTypeCol04());
                     this.tabResultats.setTabresTypeCol05(var8.getTabresTypeCol05());
                     this.tabResultats.setTabresTypeCol06(var8.getTabresTypeCol06());
                     this.tabResultats.setTabresTypeCol07(var8.getTabresTypeCol07());
                     this.tabResultats.setTabresTypeCol08(var8.getTabresTypeCol08());
                     this.tabResultats.setTabresTypeCol09(var8.getTabresTypeCol09());
                     this.tabResultats.setTabresTypeCol10(var8.getTabresTypeCol10());
                     this.tabResultats.setTabresTypeCol11(var8.getTabresTypeCol11());
                     this.tabResultats.setTabresTypeCol12(var8.getTabresTypeCol12());
                     this.tabResultats.setTabresTypeCol13(var8.getTabresTypeCol13());
                     this.tabResultats.setTabresTypeCol14(var8.getTabresTypeCol14());
                     this.tabResultats.setTabresTypeCol15(var8.getTabresTypeCol15());
                     this.tabResultats.setTabresTypeCol16(var8.getTabresTypeCol16());
                     this.tabResultats.setTabresTypeCol17(var8.getTabresTypeCol17());
                     this.tabResultats.setTabresTypeCol18(var8.getTabresTypeCol18());
                     this.tabResultats.setTabresTypeCol19(var8.getTabresTypeCol19());
                     this.tabResultats.setTabresTypeCol20(var8.getTabresTypeCol20());
                     this.tabResultats.setTabresFormatCol01(var8.getTabresFormatCol01());
                     this.tabResultats.setTabresFormatCol02(var8.getTabresFormatCol02());
                     this.tabResultats.setTabresFormatCol03(var8.getTabresFormatCol03());
                     this.tabResultats.setTabresFormatCol04(var8.getTabresFormatCol04());
                     this.tabResultats.setTabresFormatCol05(var8.getTabresFormatCol05());
                     this.tabResultats.setTabresFormatCol06(var8.getTabresFormatCol06());
                     this.tabResultats.setTabresFormatCol07(var8.getTabresFormatCol07());
                     this.tabResultats.setTabresFormatCol08(var8.getTabresFormatCol08());
                     this.tabResultats.setTabresFormatCol09(var8.getTabresFormatCol09());
                     this.tabResultats.setTabresFormatCol10(var8.getTabresFormatCol10());
                     this.tabResultats.setTabresFormatCol11(var8.getTabresFormatCol11());
                     this.tabResultats.setTabresFormatCol12(var8.getTabresFormatCol12());
                     this.tabResultats.setTabresFormatCol13(var8.getTabresFormatCol13());
                     this.tabResultats.setTabresFormatCol14(var8.getTabresFormatCol14());
                     this.tabResultats.setTabresFormatCol15(var8.getTabresFormatCol15());
                     this.tabResultats.setTabresFormatCol16(var8.getTabresFormatCol16());
                     this.tabResultats.setTabresFormatCol17(var8.getTabresFormatCol17());
                     this.tabResultats.setTabresFormatCol18(var8.getTabresFormatCol18());
                     this.tabResultats.setTabresFormatCol19(var8.getTabresFormatCol19());
                     this.tabResultats.setTabresFormatCol20(var8.getTabresFormatCol20());
                     this.lesResultats.add(this.tabResultats);
                  }
               }
            }

            this.affichageColonne();
            this.var_largeur_tableau = this.var_largeur_col1 + this.var_largeur_col2 + this.var_largeur_col3 + this.var_largeur_col4 + this.var_largeur_col5 + this.var_largeur_col6 + this.var_largeur_col7 + this.var_largeur_col8 + this.var_largeur_col9 + this.var_largeur_col10 + this.var_largeur_col11 + this.var_largeur_col12 + this.var_largeur_col13 + this.var_largeur_col14 + this.var_largeur_col15 + this.var_largeur_col16 + this.var_largeur_col17 + this.var_largeur_col18 + this.var_largeur_col19 + this.var_largeur_col20 + 100 + 400 + 30;
            this.dataModelResultat.setWrappedData(this.lesResultats);
         }
      }

   }

   public void chargerElementsExerciceAnterieur(Session var1) throws HibernateException, NamingException {
      if (this.cptTabNom != null) {
         new ExercicesPaye();
         long var3 = this.selectedExo.getExepayId() - 1L;
         ExercicesPaye var2 = this.exercicesPayeDao.recupererLExoSelect(var3, var1);
         if (var2 != null) {
         }
      }

   }

   public List convertirTableau(Session var1) throws HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      if (this.cptTabNom != null) {
         new ArrayList();
         List var3 = this.bsoTabElementDao.chargerMesTabElement(this.cptTabNom.getTablis_id(), var1);
         if (var3.size() != 0) {
            new BsoTabElement();

            for(int var5 = 0; var5 < var3.size(); ++var5) {
               BsoTabElement var4 = (BsoTabElement)var3.get(var5);
               BsoResultats var6 = new BsoResultats();
               var6.setTabresCode(this.cptTabNom.getTablisCode());
               var6.setTabresNomFr(this.cptTabNom.getTablisLibFR());
               var6.setTabresNomUk(this.cptTabNom.getTablisLibUK());
               var6.setTabresNomSp(this.cptTabNom.getTablisLibSP());
               var6.setTabresReference(var4.getTabeleReference());
               var6.setTabresLibFr(var4.getTabeleLibFR());
               var6.setTabresLibUk(var4.getTabeleLibUK());
               var6.setTabresLibSp(var4.getTabeleLibSP());
               var6.setTabresType(var4.getTabeleType());
               var6.setTabresPrint(var4.getTabelePrint());
               var6.setTabresNum(var5);
               var6.setTabresMode(var4.getTabeleMode());
               var6.setTabresIdElement(var4.getTabele_id());
               var6.setTabresFormatCol01(var4.getTabeleFormatCel01());
               var6.setTabresFormatCol02(var4.getTabeleFormatCel02());
               var6.setTabresFormatCol03(var4.getTabeleFormatCel03());
               var6.setTabresFormatCol04(var4.getTabeleFormatCel04());
               var6.setTabresFormatCol05(var4.getTabeleFormatCel05());
               var6.setTabresFormatCol06(var4.getTabeleFormatCel06());
               var6.setTabresFormatCol07(var4.getTabeleFormatCel07());
               var6.setTabresFormatCol08(var4.getTabeleFormatCel08());
               var6.setTabresFormatCol09(var4.getTabeleFormatCel09());
               var6.setTabresFormatCol10(var4.getTabeleFormatCel10());
               var6.setTabresFormatCol11(var4.getTabeleFormatCel11());
               var6.setTabresFormatCol12(var4.getTabeleFormatCel12());
               var6.setTabresFormatCol13(var4.getTabeleFormatCel13());
               var6.setTabresFormatCol14(var4.getTabeleFormatCel14());
               var6.setTabresFormatCol15(var4.getTabeleFormatCel15());
               var6.setTabresFormatCol16(var4.getTabeleFormatCel16());
               var6.setTabresFormatCol17(var4.getTabeleFormatCel17());
               var6.setTabresFormatCol18(var4.getTabeleFormatCel18());
               var6.setTabresFormatCol19(var4.getTabeleFormatCel19());
               var6.setTabresFormatCol20(var4.getTabeleFormatCel20());
               var6.setTabresFormatCol01(var4.getTabeleFormatCel01());
               var6.setTabresFormatCol02(var4.getTabeleFormatCel02());
               var6.setTabresFormatCol03(var4.getTabeleFormatCel03());
               var6.setTabresFormatCol04(var4.getTabeleFormatCel04());
               var6.setTabresFormatCol05(var4.getTabeleFormatCel05());
               var6.setTabresFormatCol06(var4.getTabeleFormatCel06());
               var6.setTabresFormatCol07(var4.getTabeleFormatCel07());
               var6.setTabresFormatCol08(var4.getTabeleFormatCel08());
               var6.setTabresFormatCol09(var4.getTabeleFormatCel09());
               var6.setTabresFormatCol10(var4.getTabeleFormatCel10());
               var6.setTabresFormatCol11(var4.getTabeleFormatCel11());
               var6.setTabresFormatCol12(var4.getTabeleFormatCel12());
               var6.setTabresFormatCol13(var4.getTabeleFormatCel13());
               var6.setTabresFormatCol14(var4.getTabeleFormatCel14());
               var6.setTabresFormatCol15(var4.getTabeleFormatCel15());
               var6.setTabresFormatCol16(var4.getTabeleFormatCel16());
               var6.setTabresFormatCol17(var4.getTabeleFormatCel17());
               var6.setTabresFormatCol18(var4.getTabeleFormatCel18());
               var6.setTabresFormatCol19(var4.getTabeleFormatCel19());
               var6.setTabresFormatCol20(var4.getTabeleFormatCel20());
               new ArrayList();
               List var7 = this.bsoTabFormuleDao.chargerMesTabFormule(var4.getTabele_id(), var1);
               if (var7.size() != 0) {
                  for(int var8 = 0; var8 < var7.size(); ++var8) {
                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 1) {
                        var6.setTabresTypeCol01(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 2) {
                        var6.setTabresTypeCol02(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 3) {
                        var6.setTabresTypeCol03(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 4) {
                        var6.setTabresTypeCol04(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 5) {
                        var6.setTabresTypeCol05(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 6) {
                        var6.setTabresTypeCol06(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 7) {
                        var6.setTabresTypeCol07(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 8) {
                        var6.setTabresTypeCol08(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 9) {
                        var6.setTabresTypeCol09(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 10) {
                        var6.setTabresTypeCol10(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 11) {
                        var6.setTabresTypeCol11(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 12) {
                        var6.setTabresTypeCol12(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 13) {
                        var6.setTabresTypeCol13(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 14) {
                        var6.setTabresTypeCol14(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 15) {
                        var6.setTabresTypeCol15(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 16) {
                        var6.setTabresTypeCol16(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 17) {
                        var6.setTabresTypeCol17(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 18) {
                        var6.setTabresTypeCol18(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 19) {
                        var6.setTabresTypeCol19(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }

                     if (((BsoTabFormule)var7.get(var8)).getTabforCol() == 20) {
                        var6.setTabresTypeCol20(((BsoTabFormule)var7.get(var8)).getTabforSolde());
                     }
                  }
               }

               var2.add(var6);
            }
         }
      }

      return var2;
   }

   public void majExercice() throws HibernateException, NamingException {
      this.selectedExo = this.exercicesPayeDao.modif(this.selectedExo);
   }

   public void majExercice(Session var1) {
      this.selectedExo = this.exercicesPayeDao.modif(this.selectedExo, var1);
   }

   public void affichageColonne() {
      this.var_aff_col01 = false;
      this.var_largeur_col1 = 0;
      this.var_aff_col02 = false;
      this.var_largeur_col2 = 0;
      this.var_aff_col03 = false;
      this.var_largeur_col3 = 0;
      this.var_aff_col04 = false;
      this.var_largeur_col4 = 0;
      this.var_aff_col05 = false;
      this.var_largeur_col5 = 0;
      this.var_aff_col06 = false;
      this.var_largeur_col6 = 0;
      this.var_aff_col07 = false;
      this.var_largeur_col7 = 0;
      this.var_aff_col08 = false;
      this.var_largeur_col8 = 0;
      this.var_aff_col09 = false;
      this.var_largeur_col9 = 0;
      this.var_aff_col10 = false;
      this.var_largeur_col10 = 0;
      this.var_aff_col11 = false;
      this.var_largeur_col11 = 0;
      this.var_aff_col12 = false;
      this.var_largeur_col12 = 0;
      this.var_aff_col13 = false;
      this.var_largeur_col13 = 0;
      this.var_aff_col14 = false;
      this.var_largeur_col14 = 0;
      this.var_aff_col15 = false;
      this.var_largeur_col15 = 0;
      this.var_aff_col16 = false;
      this.var_largeur_col16 = 0;
      this.var_aff_col17 = false;
      this.var_largeur_col17 = 0;
      this.var_aff_col18 = false;
      this.var_largeur_col18 = 0;
      this.var_aff_col19 = false;
      this.var_largeur_col19 = 0;
      this.var_aff_col20 = false;
      this.var_largeur_col20 = 0;
      short var1 = 150;
      short var2 = 300;
      short var3 = 500;
      int var4 = this.cptTabNom.getTablisNbCol();
      if (1 <= var4) {
         this.var_aff_col01 = true;
         if (this.cptTabNom.getTablisTypeCol01() == 7) {
            this.var_largeur_col1 = var2;
         } else if (this.cptTabNom.getTablisTypeCol01() == 8) {
            this.var_largeur_col1 = var3;
         } else {
            this.var_largeur_col1 = var1;
         }
      }

      if (2 <= var4) {
         this.var_aff_col02 = true;
         if (this.cptTabNom.getTablisTypeCol02() == 7) {
            this.var_largeur_col2 = var2;
         } else if (this.cptTabNom.getTablisTypeCol02() == 8) {
            this.var_largeur_col2 = var3;
         } else {
            this.var_largeur_col2 = var1;
         }
      }

      if (3 <= var4) {
         this.var_aff_col03 = true;
         if (this.cptTabNom.getTablisTypeCol03() == 7) {
            this.var_largeur_col3 = var2;
         } else if (this.cptTabNom.getTablisTypeCol03() == 8) {
            this.var_largeur_col3 = var3;
         } else {
            this.var_largeur_col3 = var1;
         }
      }

      if (4 <= var4) {
         this.var_aff_col04 = true;
         if (this.cptTabNom.getTablisTypeCol04() == 7) {
            this.var_largeur_col4 = var2;
         } else if (this.cptTabNom.getTablisTypeCol04() == 8) {
            this.var_largeur_col4 = var3;
         } else {
            this.var_largeur_col4 = var1;
         }
      }

      if (5 <= var4) {
         this.var_aff_col05 = true;
         if (this.cptTabNom.getTablisTypeCol05() == 7) {
            this.var_largeur_col5 = var2;
         } else if (this.cptTabNom.getTablisTypeCol05() == 8) {
            this.var_largeur_col5 = var3;
         } else {
            this.var_largeur_col5 = var1;
         }
      }

      if (6 <= var4) {
         this.var_aff_col06 = true;
         if (this.cptTabNom.getTablisTypeCol06() == 7) {
            this.var_largeur_col6 = var2;
         } else if (this.cptTabNom.getTablisTypeCol06() == 8) {
            this.var_largeur_col6 = var3;
         } else {
            this.var_largeur_col6 = var1;
         }
      }

      if (7 <= var4) {
         this.var_aff_col07 = true;
         if (this.cptTabNom.getTablisTypeCol07() == 7) {
            this.var_largeur_col7 = var2;
         } else if (this.cptTabNom.getTablisTypeCol07() == 8) {
            this.var_largeur_col7 = var3;
         } else {
            this.var_largeur_col7 = var1;
         }
      }

      if (8 <= var4) {
         this.var_aff_col08 = true;
         if (this.cptTabNom.getTablisTypeCol08() == 7) {
            this.var_largeur_col8 = var2;
         } else if (this.cptTabNom.getTablisTypeCol08() == 8) {
            this.var_largeur_col8 = var3;
         } else {
            this.var_largeur_col8 = var1;
         }
      }

      if (9 <= var4) {
         this.var_aff_col09 = true;
         if (this.cptTabNom.getTablisTypeCol09() == 7) {
            this.var_largeur_col9 = var2;
         } else if (this.cptTabNom.getTablisTypeCol09() == 8) {
            this.var_largeur_col9 = var3;
         } else {
            this.var_largeur_col9 = var1;
         }
      }

      if (10 <= var4) {
         this.var_aff_col10 = true;
         if (this.cptTabNom.getTablisTypeCol10() == 7) {
            this.var_largeur_col10 = var2;
         } else if (this.cptTabNom.getTablisTypeCol10() == 8) {
            this.var_largeur_col10 = var3;
         } else {
            this.var_largeur_col10 = var1;
         }
      }

      if (11 <= var4) {
         this.var_aff_col11 = true;
         if (this.cptTabNom.getTablisTypeCol11() == 7) {
            this.var_largeur_col11 = var2;
         } else if (this.cptTabNom.getTablisTypeCol11() == 8) {
            this.var_largeur_col11 = var3;
         } else {
            this.var_largeur_col11 = var1;
         }
      }

      if (12 <= var4) {
         this.var_aff_col12 = true;
         if (this.cptTabNom.getTablisTypeCol12() == 7) {
            this.var_largeur_col12 = var2;
         } else if (this.cptTabNom.getTablisTypeCol12() == 8) {
            this.var_largeur_col12 = var3;
         } else {
            this.var_largeur_col12 = var1;
         }
      }

      if (13 <= var4) {
         this.var_aff_col13 = true;
         if (this.cptTabNom.getTablisTypeCol13() == 7) {
            this.var_largeur_col13 = var2;
         } else if (this.cptTabNom.getTablisTypeCol13() == 8) {
            this.var_largeur_col13 = var3;
         } else {
            this.var_largeur_col13 = var1;
         }
      }

      if (14 <= var4) {
         this.var_aff_col14 = true;
         if (this.cptTabNom.getTablisTypeCol14() == 7) {
            this.var_largeur_col14 = var2;
         } else if (this.cptTabNom.getTablisTypeCol14() == 8) {
            this.var_largeur_col14 = var3;
         } else {
            this.var_largeur_col14 = var1;
         }
      }

      if (15 <= var4) {
         this.var_aff_col15 = true;
         if (this.cptTabNom.getTablisTypeCol15() == 7) {
            this.var_largeur_col15 = var2;
         } else if (this.cptTabNom.getTablisTypeCol15() == 8) {
            this.var_largeur_col15 = var3;
         } else {
            this.var_largeur_col15 = var1;
         }
      }

      if (16 <= var4) {
         this.var_aff_col16 = true;
         if (this.cptTabNom.getTablisTypeCol16() == 7) {
            this.var_largeur_col16 = var2;
         } else if (this.cptTabNom.getTablisTypeCol16() == 8) {
            this.var_largeur_col16 = var3;
         } else {
            this.var_largeur_col16 = var1;
         }
      }

      if (17 <= var4) {
         this.var_aff_col17 = true;
         if (this.cptTabNom.getTablisTypeCol17() == 7) {
            this.var_largeur_col17 = var2;
         } else if (this.cptTabNom.getTablisTypeCol17() == 8) {
            this.var_largeur_col17 = var3;
         } else {
            this.var_largeur_col17 = var1;
         }
      }

      if (18 <= var4) {
         this.var_aff_col18 = true;
         if (this.cptTabNom.getTablisTypeCol18() == 7) {
            this.var_largeur_col18 = var2;
         } else if (this.cptTabNom.getTablisTypeCol18() == 8) {
            this.var_largeur_col18 = var3;
         } else {
            this.var_largeur_col18 = var1;
         }
      }

      if (19 <= var4) {
         this.var_aff_col19 = true;
         if (this.cptTabNom.getTablisTypeCol19() == 7) {
            this.var_largeur_col19 = var2;
         } else if (this.cptTabNom.getTablisTypeCol19() == 8) {
            this.var_largeur_col19 = var3;
         } else {
            this.var_largeur_col19 = var1;
         }
      }

      if (20 <= var4) {
         this.var_aff_col20 = true;
         if (this.cptTabNom.getTablisTypeCol20() == 7) {
            this.var_largeur_col20 = var2;
         } else if (this.cptTabNom.getTablisTypeCol20() == 8) {
            this.var_largeur_col20 = var3;
         } else {
            this.var_largeur_col20 = var1;
         }
      }

   }

   public void majFormules() throws HibernateException, NamingException {
      if (this.nature == 10 && this.structureLog.getStrbilansocial() != null && !this.structureLog.getStrbilansocial().isEmpty()) {
         FormBilanSocialConfigClient var1 = new FormBilanSocialConfigClient();
         var1.setutilInitHibernate(this.utilInitHibernate);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.InstancesDaoUtilses();
         var1.setNature(0);
         var1.setTabliszone(this.structureLog.getStrbilansocial());
         var1.genererDefaultEtat();
         this.chargerMesTabNom(this.nature, (Session)null);
      }

   }

   public void calculTableaux() throws HibernateException, NamingException, ParseException {
      if (this.cptTabNom != null) {
         this.colonneEnCours = "...Initialisation...";
         if (this.memoDateDebCalcul.getMonth() != this.dateDebCalcul.getMonth() || this.memoDateDebCalcul.getYear() != this.dateDebCalcul.getYear() || this.memoDateFinCalcul.getMonth() != this.dateFinCalcul.getMonth() || this.memoDateFinCalcul.getYear() != this.dateFinCalcul.getYear()) {
            this.balanceListe.clear();
         }

         this.var_showBarProg = true;
         if (this.dateDebCalcul == null) {
            this.dateDebCalcul = this.selectedExo.getExepayDateDebut();
         }

         if (this.dateFinCalcul == null) {
            this.dateFinCalcul = this.selectedExo.getExepayDateFin();
         }

         this.tabResultats = new BsoResultats();
         this.listMemoResultat.clear();
         if (this.lesResultats.size() != 0) {
            new BsoResultats();

            for(int var2 = 0; var2 < this.lesResultats.size(); ++var2) {
               BsoResultats var3 = new BsoResultats();
               BsoResultats var1 = (BsoResultats)this.lesResultats.get(var2);
               var3.setTabresCol01(var1.getTabresCol01());
               var3.setTabresCol02(var1.getTabresCol02());
               var3.setTabresCol03(var1.getTabresCol03());
               var3.setTabresCol04(var1.getTabresCol04());
               var3.setTabresCol05(var1.getTabresCol05());
               var3.setTabresCol06(var1.getTabresCol06());
               var3.setTabresCol07(var1.getTabresCol07());
               var3.setTabresCol08(var1.getTabresCol08());
               var3.setTabresCol09(var1.getTabresCol09());
               var3.setTabresCol10(var1.getTabresCol10());
               var3.setTabresCol11(var1.getTabresCol11());
               var3.setTabresCol12(var1.getTabresCol12());
               var3.setTabresCol13(var1.getTabresCol13());
               var3.setTabresCol14(var1.getTabresCol14());
               var3.setTabresCol15(var1.getTabresCol15());
               var3.setTabresCol16(var1.getTabresCol16());
               var3.setTabresCol17(var1.getTabresCol17());
               var3.setTabresCol18(var1.getTabresCol18());
               var3.setTabresCol19(var1.getTabresCol19());
               var3.setTabresCol20(var1.getTabresCol20());
               var3.setTabresCon01(var1.getTabresCon01());
               var3.setTabresCon02(var1.getTabresCon02());
               var3.setTabresCon03(var1.getTabresCon03());
               var3.setTabresCon04(var1.getTabresCon04());
               var3.setTabresCon05(var1.getTabresCon05());
               var3.setTabresCon06(var1.getTabresCon06());
               var3.setTabresCon07(var1.getTabresCon07());
               var3.setTabresCon08(var1.getTabresCon08());
               var3.setTabresCon09(var1.getTabresCon09());
               var3.setTabresCon10(var1.getTabresCon10());
               var3.setTabresCon11(var1.getTabresCon11());
               var3.setTabresCon12(var1.getTabresCon12());
               var3.setTabresCon13(var1.getTabresCon13());
               var3.setTabresCon14(var1.getTabresCon14());
               var3.setTabresCon15(var1.getTabresCon15());
               var3.setTabresCon16(var1.getTabresCon16());
               var3.setTabresCon17(var1.getTabresCon17());
               var3.setTabresCon18(var1.getTabresCon18());
               var3.setTabresCon19(var1.getTabresCon19());
               var3.setTabresCon20(var1.getTabresCon20());
               var3.setTabresFormatCol01(var1.getTabresFormatCol01());
               var3.setTabresFormatCol02(var1.getTabresFormatCol02());
               var3.setTabresFormatCol03(var1.getTabresFormatCol03());
               var3.setTabresFormatCol04(var1.getTabresFormatCol04());
               var3.setTabresFormatCol05(var1.getTabresFormatCol05());
               var3.setTabresFormatCol06(var1.getTabresFormatCol06());
               var3.setTabresFormatCol07(var1.getTabresFormatCol07());
               var3.setTabresFormatCol08(var1.getTabresFormatCol08());
               var3.setTabresFormatCol09(var1.getTabresFormatCol09());
               var3.setTabresFormatCol10(var1.getTabresFormatCol10());
               var3.setTabresFormatCol11(var1.getTabresFormatCol11());
               var3.setTabresFormatCol12(var1.getTabresFormatCol12());
               var3.setTabresFormatCol13(var1.getTabresFormatCol13());
               var3.setTabresFormatCol14(var1.getTabresFormatCol14());
               var3.setTabresFormatCol15(var1.getTabresFormatCol15());
               var3.setTabresFormatCol16(var1.getTabresFormatCol16());
               var3.setTabresFormatCol17(var1.getTabresFormatCol17());
               var3.setTabresFormatCol18(var1.getTabresFormatCol18());
               var3.setTabresFormatCol19(var1.getTabresFormatCol19());
               var3.setTabresFormatCol20(var1.getTabresFormatCol20());
               this.listMemoResultat.add(var3);
            }
         }

         this.choixNature();
         if (!this.modeModifierTab && this.balanceListe.size() == 0 && this.cptTabNom.getTablisType() == 0 && !this.cptTabNom.getTablisCode().equals("ETAN1") && !this.cptTabNom.getTablisCode().equals("ETAN2") && !this.cptTabNom.getTablisCode().equals("ETAN3") && !this.cptTabNom.getTablisCode().equals("ETAN4") && !this.cptTabNom.getTablisCode().equals("ETAN5") && !this.cptTabNom.getTablisCode().equals("ETAN6") && !this.cptTabNom.getTablisCode().equals("ETAN7") && !this.cptTabNom.getTablisCode().equals("ETAN8") && !this.cptTabNom.getTablisCode().equals("ETAN9") && !this.cptTabNom.getTablisCode().equals("ETAN10") && !this.cptTabNom.getTablisCode().equals("ETAN11") && !this.cptTabNom.getTablisCode().equals("ETAN12") && !this.cptTabNom.getTablisCode().equals("ETAN13") && !this.cptTabNom.getTablisCode().equals("ETAN14") && !this.cptTabNom.getTablisCode().equals("ETAN15") && !this.cptTabNom.getTablisCode().equals("ETAN16") && !this.cptTabNom.getTablisCode().equals("ETAN16B") && !this.cptTabNom.getTablisCode().equals("T5") && !this.cptTabNom.getTablisCode().equals("T10") && !this.cptTabNom.getTablisCode().equals("T11") && !this.cptTabNom.getTablisCode().equals("T12") && !this.cptTabNom.getTablisCode().equals("T13")) {
            this.traitementEcritures();
         }

         this.bsoResultatsDao.deleteTabResultatAnnee(this.cptTabNom.getTablisCode(), this.selectedExo.getExepayId());
         Session var19 = this.utilInitHibernate.getOpenSession(this.baseLog, "BilanSocial");
         Transaction var20 = null;

         try {
            var20 = var19.beginTransaction();
            this.exercicesPayeDao.modif(this.selectedExo, var19);
            ArrayList var21 = new ArrayList();
            this.lesResultats.clear();
            this.lesResultats = this.convertirTableau(var19);
            this.var_currentValue = 0;
            new BsoTabFormule();
            this.tabResultats = new BsoResultats();
            int var5 = 0;

            while(true) {
               if (var5 >= this.lesResultats.size()) {
                  this.var_currentValue = 100;
                  this.lesResultats = var21;
                  this.dataModelResultat.setWrappedData(this.lesResultats);
                  var20.commit();
                  break;
               }

               if (var5 != 0) {
                  double var6 = (double)this.lesResultats.size();
                  double var8 = this.utilNombre.myRound(var6 / (double)var5, 4);
                  double var10 = this.utilNombre.myRound(100.0D / var8, 2);
                  this.var_currentValue = (int)var10;
               }

               this.tabResultats = (BsoResultats)this.lesResultats.get(var5);
               this.tabResultats.setExercicesPaye(this.selectedExo);
               this.tabResultats.setTabresNomFr(this.cptTabNom.getTablisLibFR());
               this.tabResultats.setTabresNomSp(this.cptTabNom.getTablisLibSP());
               this.tabResultats.setTabresNomUk(this.cptTabNom.getTablisLibUK());
               this.tabResultats.setTabresCode(this.cptTabNom.getTablisCode());
               this.tabResultats.setTabresDateDeb(this.dateDebCalcul);
               this.tabResultats.setTabresDateFin(this.dateFinCalcul);
               this.tabResultats.setTabresAnnee((long)(this.selectedExo.getExepayDateFin().getYear() + 1900));
               int var22 = (this.getTabResultats().getTabresDateFin().getYear() - this.getTabResultats().getTabresDateDeb().getYear()) * 12;
               int var7 = var22 + this.getTabResultats().getTabresDateFin().getMonth() - this.getTabResultats().getTabresDateDeb().getMonth() + 1;
               this.tabResultats.setTabresNbMois(var7);
               this.tabResultats.setTabresNum(var5);
               this.tabResultats.setTabresJrRv(0);
               this.tabResultats.setTabresJrSit(0);
               int var23 = 0;
               int var9 = this.cptTabNom.getTablisNbCol();

               for(int var24 = 1; var24 <= var9; ++var24) {
                  if (var24 == 1) {
                     var23 = this.cptTabNom.getTablisAnn01();
                  } else if (var24 == 2) {
                     var23 = this.cptTabNom.getTablisAnn02();
                  } else if (var24 == 3) {
                     var23 = this.cptTabNom.getTablisAnn03();
                  } else if (var24 == 4) {
                     var23 = this.cptTabNom.getTablisAnn04();
                  } else if (var24 == 5) {
                     var23 = this.cptTabNom.getTablisAnn05();
                  } else if (var24 == 6) {
                     var23 = this.cptTabNom.getTablisAnn06();
                  } else if (var24 == 7) {
                     var23 = this.cptTabNom.getTablisAnn07();
                  } else if (var24 == 8) {
                     var23 = this.cptTabNom.getTablisAnn08();
                  } else if (var24 == 9) {
                     var23 = this.cptTabNom.getTablisAnn09();
                  } else if (var24 == 10) {
                     var23 = this.cptTabNom.getTablisAnn10();
                  } else if (var24 == 11) {
                     var23 = this.cptTabNom.getTablisAnn11();
                  } else if (var24 == 12) {
                     var23 = this.cptTabNom.getTablisAnn12();
                  } else if (var24 == 13) {
                     var23 = this.cptTabNom.getTablisAnn13();
                  } else if (var24 == 14) {
                     var23 = this.cptTabNom.getTablisAnn14();
                  } else if (var24 == 15) {
                     var23 = this.cptTabNom.getTablisAnn15();
                  } else if (var24 == 16) {
                     var23 = this.cptTabNom.getTablisAnn16();
                  } else if (var24 == 17) {
                     var23 = this.cptTabNom.getTablisAnn17();
                  } else if (var24 == 18) {
                     var23 = this.cptTabNom.getTablisAnn18();
                  } else if (var24 == 19) {
                     var23 = this.cptTabNom.getTablisAnn19();
                  } else if (var24 == 20) {
                     var23 = this.cptTabNom.getTablisAnn20();
                  }

                  this.colonneEnCours = "" + var24;
                  this.calculePeriode(var23);
                  this.resultat1 = 0.0D;
                  this.resultat2 = 0.0D;
                  this.resultat3 = "";
                  this.operateur = "";
                  List var11 = this.bsoTabFormuleDao.chargerMesTabFormule(this.tabResultats.getTabresIdElement(), var24, var19);

                  for(int var12 = 0; var12 < var11.size(); ++var12) {
                     BsoTabFormule var4 = (BsoTabFormule)var11.get(var12);
                     if (var23 != var4.getTabforPeriode()) {
                        var23 = var4.getTabforPeriode();
                        this.calculePeriode(var23);
                     }

                     int var13 = var4.getTabforSolde();
                     if (this.modeModifierTab && this.tabResultats.getTabresType() == 3) {
                        if (this.tabResultats.getTabresTypeCol01() != 7 && this.tabResultats.getTabresTypeCol01() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol02() != 7 && this.tabResultats.getTabresTypeCol02() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol03() != 7 && this.tabResultats.getTabresTypeCol03() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol04() != 7 && this.tabResultats.getTabresTypeCol04() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol05() != 7 && this.tabResultats.getTabresTypeCol05() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol06() != 7 && this.tabResultats.getTabresTypeCol06() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol07() != 7 && this.tabResultats.getTabresTypeCol07() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol08() != 7 && this.tabResultats.getTabresTypeCol08() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol09() != 7 && this.tabResultats.getTabresTypeCol09() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol10() != 7 && this.tabResultats.getTabresTypeCol10() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol11() != 7 && this.tabResultats.getTabresTypeCol11() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol12() != 7 && this.tabResultats.getTabresTypeCol12() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol13() != 7 && this.tabResultats.getTabresTypeCol13() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol14() != 7 && this.tabResultats.getTabresTypeCol14() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol15() != 7 && this.tabResultats.getTabresTypeCol15() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol16() != 7 && this.tabResultats.getTabresTypeCol16() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol17() != 7 && this.tabResultats.getTabresTypeCol17() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol18() != 7 && this.tabResultats.getTabresTypeCol18() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol19() != 7 && this.tabResultats.getTabresTypeCol19() != 8) {
                           var13 = 6;
                        } else if (this.tabResultats.getTabresTypeCol20() != 7 && this.tabResultats.getTabresTypeCol20() != 8) {
                           var13 = 6;
                        }
                     }

                     this.analyseFormule(var23, var4, var13, var24, var5, var19);
                  }

                  this.renseigneCol(var24, this.resultat1, this.resultat3);
               }

               this.tabResultats = this.bsoResultatsDao.saveTabResulats(this.tabResultats, var19);
               var21.add(this.tabResultats);
               ++var5;
            }
         } catch (HibernateException var17) {
            if (var20 != null) {
               var20.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerMesTabElementOrTabResultat((Session)null);
      }

      this.var_showBarProg = false;
      this.var_currentValue = 0;
   }

   public void supprimeTableaux() throws HibernateException, NamingException {
      if (this.cptTabNom != null && this.lesResultats.size() != 0) {
         this.bsoResultatsDao.deleteTabResultatAnnee(this.cptTabNom.getTablisCode(), this.selectedExo.getExepayId());
         this.selectionBilanSocial();
      }

   }

   public void modifieTableaux() {
      if (this.cptTabNom != null) {
         this.modeModifierTab = true;
         if (this.lesResultats.size() != 0) {
            for(int var1 = 0; var1 < this.lesResultats.size(); ++var1) {
               this.tabResultats = new BsoResultats();
               this.tabResultats = (BsoResultats)this.lesResultats.get(var1);
               if (this.tabResultats.getTabresType() == 3) {
                  if (this.tabResultats.getTabresTypeCol01() >= 0 && this.tabResultats.getTabresTypeCol01() <= 5 || this.tabResultats.getTabresTypeCol01() >= 10 && this.tabResultats.getTabresTypeCol01() <= 30) {
                     this.tabResultats.setTabresTypeCol01(6);
                  }

                  if (this.tabResultats.getTabresTypeCol02() >= 0 && this.tabResultats.getTabresTypeCol02() <= 5 || this.tabResultats.getTabresTypeCol02() >= 10 && this.tabResultats.getTabresTypeCol02() <= 30) {
                     this.tabResultats.setTabresTypeCol02(6);
                  }

                  if (this.tabResultats.getTabresTypeCol03() >= 0 && this.tabResultats.getTabresTypeCol03() <= 5 || this.tabResultats.getTabresTypeCol03() >= 10 && this.tabResultats.getTabresTypeCol03() <= 30) {
                     this.tabResultats.setTabresTypeCol03(6);
                  }

                  if (this.tabResultats.getTabresTypeCol04() >= 0 && this.tabResultats.getTabresTypeCol04() <= 5 || this.tabResultats.getTabresTypeCol04() >= 10 && this.tabResultats.getTabresTypeCol04() <= 30) {
                     this.tabResultats.setTabresTypeCol04(6);
                  }

                  if (this.tabResultats.getTabresTypeCol05() >= 0 && this.tabResultats.getTabresTypeCol05() <= 5 || this.tabResultats.getTabresTypeCol05() >= 10 && this.tabResultats.getTabresTypeCol05() <= 30) {
                     this.tabResultats.setTabresTypeCol05(6);
                  }

                  if (this.tabResultats.getTabresTypeCol06() >= 0 && this.tabResultats.getTabresTypeCol06() <= 5 || this.tabResultats.getTabresTypeCol06() >= 10 && this.tabResultats.getTabresTypeCol06() <= 30) {
                     this.tabResultats.setTabresTypeCol06(6);
                  }

                  if (this.tabResultats.getTabresTypeCol07() >= 0 && this.tabResultats.getTabresTypeCol07() <= 5 || this.tabResultats.getTabresTypeCol07() >= 10 && this.tabResultats.getTabresTypeCol07() <= 30) {
                     this.tabResultats.setTabresTypeCol07(6);
                  }

                  if (this.tabResultats.getTabresTypeCol08() >= 0 && this.tabResultats.getTabresTypeCol08() <= 5 || this.tabResultats.getTabresTypeCol08() >= 10 && this.tabResultats.getTabresTypeCol08() <= 30) {
                     this.tabResultats.setTabresTypeCol08(6);
                  }

                  if (this.tabResultats.getTabresTypeCol09() >= 0 && this.tabResultats.getTabresTypeCol09() <= 5 || this.tabResultats.getTabresTypeCol09() >= 10 && this.tabResultats.getTabresTypeCol09() <= 30) {
                     this.tabResultats.setTabresTypeCol09(6);
                  }

                  if (this.tabResultats.getTabresTypeCol10() >= 0 && this.tabResultats.getTabresTypeCol10() <= 5 || this.tabResultats.getTabresTypeCol10() >= 10 && this.tabResultats.getTabresTypeCol10() <= 30) {
                     this.tabResultats.setTabresTypeCol10(6);
                  }

                  if (this.tabResultats.getTabresTypeCol11() >= 0 && this.tabResultats.getTabresTypeCol11() <= 5 || this.tabResultats.getTabresTypeCol11() >= 10 && this.tabResultats.getTabresTypeCol11() <= 30) {
                     this.tabResultats.setTabresTypeCol11(6);
                  }

                  if (this.tabResultats.getTabresTypeCol12() >= 0 && this.tabResultats.getTabresTypeCol12() <= 5 || this.tabResultats.getTabresTypeCol12() >= 10 && this.tabResultats.getTabresTypeCol12() <= 30) {
                     this.tabResultats.setTabresTypeCol12(6);
                  }

                  if (this.tabResultats.getTabresTypeCol13() >= 0 && this.tabResultats.getTabresTypeCol13() <= 5 || this.tabResultats.getTabresTypeCol13() >= 10 && this.tabResultats.getTabresTypeCol13() <= 30) {
                     this.tabResultats.setTabresTypeCol13(6);
                  }

                  if (this.tabResultats.getTabresTypeCol14() >= 0 && this.tabResultats.getTabresTypeCol14() <= 5 || this.tabResultats.getTabresTypeCol14() >= 10 && this.tabResultats.getTabresTypeCol14() <= 30) {
                     this.tabResultats.setTabresTypeCol14(6);
                  }

                  if (this.tabResultats.getTabresTypeCol15() >= 0 && this.tabResultats.getTabresTypeCol15() <= 5 || this.tabResultats.getTabresTypeCol15() >= 10 && this.tabResultats.getTabresTypeCol15() <= 30) {
                     this.tabResultats.setTabresTypeCol15(6);
                  }

                  if (this.tabResultats.getTabresTypeCol16() >= 0 && this.tabResultats.getTabresTypeCol16() <= 5 || this.tabResultats.getTabresTypeCol16() >= 10 && this.tabResultats.getTabresTypeCol16() <= 30) {
                     this.tabResultats.setTabresTypeCol16(6);
                  }

                  if (this.tabResultats.getTabresTypeCol17() >= 0 && this.tabResultats.getTabresTypeCol17() <= 5 || this.tabResultats.getTabresTypeCol17() >= 10 && this.tabResultats.getTabresTypeCol17() <= 30) {
                     this.tabResultats.setTabresTypeCol17(6);
                  }

                  if (this.tabResultats.getTabresTypeCol18() >= 0 && this.tabResultats.getTabresTypeCol18() <= 5 || this.tabResultats.getTabresTypeCol18() >= 10 && this.tabResultats.getTabresTypeCol18() <= 30) {
                     this.tabResultats.setTabresTypeCol18(6);
                  }

                  if (this.tabResultats.getTabresTypeCol19() >= 0 && this.tabResultats.getTabresTypeCol19() <= 5 || this.tabResultats.getTabresTypeCol19() >= 10 && this.tabResultats.getTabresTypeCol19() <= 30) {
                     this.tabResultats.setTabresTypeCol19(6);
                  }

                  if (this.tabResultats.getTabresTypeCol20() >= 0 && this.tabResultats.getTabresTypeCol20() <= 5 || this.tabResultats.getTabresTypeCol20() >= 10 && this.tabResultats.getTabresTypeCol20() <= 30) {
                     this.tabResultats.setTabresTypeCol20(6);
                  }
               }
            }

            this.dataModelResultat.setWrappedData(this.lesResultats);
         }
      }

   }

   public void duppliqueTableaux() throws HibernateException, NamingException {
      if (this.cptTabNom != null) {
         if (this.lesResultats.size() != 0 && this.cptTabNom.getTablisType() == 0) {
            this.bsoResultatsDao.deleteTabResultatAnnee(this.cptTabNom.getTablisCode(), this.selectedExo.getExepayId());
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BilanSocial");
         this.chargerMesTabElementAnterieur(var1);
         this.utilInitHibernate.closeSession();
      }

   }

   public void traitementEcritures() throws HibernateException, NamingException {
      if (this.balanceListe.size() == 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         if (this.cptTabNom.getTablisType() == 0) {
            this.selectedExo.setExepayDateDebut(this.dateDebCalcul);
            this.selectedExo.setExepayDateFin(this.dateFinCalcul);
            this.majExercice(var1);
            this.tabResultats.setTabresNomFr("Chargement et traitement des salaires (N)");
            this.balanceListe = this.bulletinLigneDao.chargerLigneBulletins(this.dateDebCalcul, this.dateFinCalcul, var1);
            new ExercicesPaye();
            long var3 = this.selectedExo.getExepayId() - 1L;
            ExercicesPaye var2 = this.exercicesPayeDao.recupererLExoSelect(var3, var1);
            if (var2 != null) {
               this.tabResultats.setTabresNomFr("Chargement et traitement des Salaires (N-1)");
               new ArrayList();
               List var5 = this.bulletinLigneDao.chargerLigneBulletins(var2.getExepayDateDebut(), var2.getExepayDateFin(), var1);
               if (var5.size() != 0) {
                  new BulletinLigne();

                  for(int var7 = 0; var7 < var5.size(); ++var7) {
                     BulletinLigne var6 = (BulletinLigne)var5.get(var7);
                     this.balanceListe.add(var6);
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionFormule() {
   }

   public void calculePeriode(int var1) throws ParseException {
      if (var1 >= 0 && var1 <= 19) {
         this.var_exercice = (long)(this.dateDebCalcul.getYear() + 1900);
      } else if (var1 >= 20 && var1 <= 39) {
         this.var_exercice = this.selectedExo.getExepayId() - 1L;
      } else if (var1 >= 40 && var1 <= 59) {
         this.var_exercice = this.selectedExo.getExepayId() - 2L;
      }

      if (var1 == 0) {
         this.var_date_periode_deb = this.utilDate.dateToStringSQLLight(this.dateDebCalcul);
         this.var_date_periode_fin = this.utilDate.dateToStringSQLLight(this.dateFinCalcul);
      } else if (var1 != 1 && var1 != 21 && var1 != 41) {
         if (var1 != 2 && var1 != 22 && var1 != 42) {
            if (var1 != 3 && var1 != 23 && var1 != 43) {
               if (var1 != 4 && var1 != 24 && var1 != 44) {
                  if (var1 != 5 && var1 != 25 && var1 != 45) {
                     if (var1 != 6 && var1 != 26 && var1 != 46) {
                        if (var1 != 7 && var1 != 27 && var1 != 47) {
                           if (var1 != 8 && var1 != 28 && var1 != 48) {
                              if (var1 != 9 && var1 != 29 && var1 != 49) {
                                 if (var1 != 10 && var1 != 30 && var1 != 50) {
                                    if (var1 != 11 && var1 != 31 && var1 != 51) {
                                       if (var1 != 12 && var1 != 32 && var1 != 52) {
                                          if (var1 != 13 && var1 != 33 && var1 != 53) {
                                             if (var1 != 14 && var1 != 34 && var1 != 54) {
                                                if (var1 != 15 && var1 != 35 && var1 != 55) {
                                                   if (var1 != 16 && var1 != 36 && var1 != 56) {
                                                      if (var1 != 17 && var1 != 37 && var1 != 57) {
                                                         if (var1 != 18 && var1 != 38 && var1 != 58) {
                                                            if (var1 != 19 && var1 != 39 && var1 != 59) {
                                                               if (var1 == 20 || var1 == 40) {
                                                                  this.var_date_periode_deb = this.var_exercice + "-01-01";
                                                                  this.var_date_periode_fin = this.var_exercice + "-12-31";
                                                               }
                                                            } else {
                                                               this.var_date_periode_deb = this.var_exercice + "-01-01";
                                                               this.var_date_periode_fin = this.var_exercice + "-12-31";
                                                            }
                                                         } else {
                                                            this.var_date_periode_deb = this.var_exercice + "-07-01";
                                                            this.var_date_periode_fin = this.var_exercice + "-12-31";
                                                         }
                                                      } else {
                                                         this.var_date_periode_deb = this.var_exercice + "-01-01";
                                                         this.var_date_periode_fin = this.var_exercice + "-06-30";
                                                      }
                                                   } else {
                                                      this.var_date_periode_deb = this.var_exercice + "-10-01";
                                                      this.var_date_periode_fin = this.var_exercice + "-12-31";
                                                   }
                                                } else {
                                                   this.var_date_periode_deb = this.var_exercice + "-07-01";
                                                   this.var_date_periode_fin = this.var_exercice + "-09-30";
                                                }
                                             } else {
                                                this.var_date_periode_deb = this.var_exercice + "-04-01";
                                                this.var_date_periode_fin = this.var_exercice + "-06-30";
                                             }
                                          } else {
                                             this.var_date_periode_deb = this.var_exercice + "-01-01";
                                             this.var_date_periode_fin = this.var_exercice + "-03-31";
                                          }
                                       } else {
                                          this.var_date_periode_deb = this.var_exercice + "-12-01";
                                          this.var_date_periode_fin = this.var_exercice + "-12-31";
                                       }
                                    } else {
                                       this.var_date_periode_deb = this.var_exercice + "-11-01";
                                       this.var_date_periode_fin = this.var_exercice + "-11-30";
                                    }
                                 } else {
                                    this.var_date_periode_deb = this.var_exercice + "-10-01";
                                    this.var_date_periode_fin = this.var_exercice + "-10-31";
                                 }
                              } else {
                                 this.var_date_periode_deb = this.var_exercice + "-09-01";
                                 this.var_date_periode_fin = this.var_exercice + "-09-30";
                              }
                           } else {
                              this.var_date_periode_deb = this.var_exercice + "-08-01";
                              this.var_date_periode_fin = this.var_exercice + "-08-31";
                           }
                        } else {
                           this.var_date_periode_deb = this.var_exercice + "-07-01";
                           this.var_date_periode_fin = this.var_exercice + "-07-31";
                        }
                     } else {
                        this.var_date_periode_deb = this.var_exercice + "-06-01";
                        this.var_date_periode_fin = this.var_exercice + "-06-30";
                     }
                  } else {
                     this.var_date_periode_deb = this.var_exercice + "-05-01";
                     this.var_date_periode_fin = this.var_exercice + "-05-31";
                  }
               } else {
                  this.var_date_periode_deb = this.var_exercice + "-04-01";
                  this.var_date_periode_fin = this.var_exercice + "-04-30";
               }
            } else {
               this.var_date_periode_deb = this.var_exercice + "-03-01";
               this.var_date_periode_fin = this.var_exercice + "-03-31";
            }
         } else {
            this.var_date_periode_deb = this.var_exercice + "-02-01";
            Date var2 = this.utilDate.stringToDateSQLLight(this.var_date_periode_deb);
            Date var3 = this.utilDate.dateDernierJourMois(var2);
            this.var_date_periode_fin = this.utilDate.dateToStringSQLLight(var3);
         }
      } else {
         this.var_date_periode_deb = this.var_exercice + "-01-01";
         this.var_date_periode_fin = this.var_exercice + "-01-31";
      }

   }

   public void choixNature() {
   }

   public void analyseFormule(int var1, BsoTabFormule var2, int var3, int var4, int var5, Session var6) throws HibernateException, NamingException, ParseException {
      this.cptTabFormule = var2;
      String var7 = this.cptTabFormule.getTabforFormule();
      String var8 = "";
      String var9 = "";
      if (this.cptTabNom.getTablisType() == 1) {
         var8 = this.cptTabFormule.getTabforBudget();
         if (this.cptTabNom.getTablisAnalytique() != null && !this.cptTabNom.getTablisAnalytique().isEmpty()) {
            var9 = this.cptTabNom.getTablisAnalytique();
         } else {
            var9 = this.cptTabFormule.getTabforAnalytique();
         }
      }

      this.lesSalaries.clear();
      this.lesLigneBulletins.clear();
      this.lesBulletins.clear();
      this.elementEnCours = "";
      BsoResultats var10;
      if (var3 == 6) {
         this.resultat1 = 0.0D;
         if (this.listMemoResultat.size() != 0 && var5 >= 0 && var5 < this.listMemoResultat.size()) {
            new BsoResultats();
            var10 = (BsoResultats)this.listMemoResultat.get(var5);
            if (var4 == 1) {
               this.resultat1 = var10.getTabresCol01();
            } else if (var4 == 2) {
               this.resultat1 = var10.getTabresCol02();
            } else if (var4 == 3) {
               this.resultat1 = var10.getTabresCol03();
            } else if (var4 == 4) {
               this.resultat1 = var10.getTabresCol04();
            } else if (var4 == 5) {
               this.resultat1 = var10.getTabresCol05();
            } else if (var4 == 6) {
               this.resultat1 = var10.getTabresCol06();
            } else if (var4 == 7) {
               this.resultat1 = var10.getTabresCol07();
            } else if (var4 == 8) {
               this.resultat1 = var10.getTabresCol08();
            } else if (var4 == 9) {
               this.resultat1 = var10.getTabresCol09();
            } else if (var4 == 10) {
               this.resultat1 = var10.getTabresCol10();
            } else if (var4 == 11) {
               this.resultat1 = var10.getTabresCol11();
            } else if (var4 == 12) {
               this.resultat1 = var10.getTabresCol12();
            } else if (var4 == 13) {
               this.resultat1 = var10.getTabresCol13();
            } else if (var4 == 14) {
               this.resultat1 = var10.getTabresCol14();
            } else if (var4 == 15) {
               this.resultat1 = var10.getTabresCol15();
            } else if (var4 == 16) {
               this.resultat1 = var10.getTabresCol16();
            } else if (var4 == 17) {
               this.resultat1 = var10.getTabresCol17();
            } else if (var4 == 18) {
               this.resultat1 = var10.getTabresCol18();
            } else if (var4 == 19) {
               this.resultat1 = var10.getTabresCol19();
            } else if (var4 == 20) {
               this.resultat1 = var10.getTabresCol20();
            }
         }
      } else if (var3 != 7 && var3 != 8) {
         if (var7.equalsIgnoreCase("INV()")) {
            this.inv();
         } else if (var7.equalsIgnoreCase("ABS()")) {
            this.abs();
         } else if (var7.startsWith("ARR(") && var7.endsWith(")")) {
            this.arr(var7);
         } else if (var7.equalsIgnoreCase("INT()")) {
            this.entier();
         } else if (var7.equalsIgnoreCase("MOD()")) {
            this.mod();
         } else if (var7.length() == 1) {
            this.selectOperateur(var7);
         } else if (var7.startsWith("SOMH(") && var7.endsWith(")")) {
            this.somh(var7);
         } else if (var7.startsWith("DIFH(") && var7.endsWith(")")) {
            this.difh(var7);
         } else if (var7.startsWith("SOMV(") && var7.endsWith(")")) {
            this.somv(var7, var4);
         } else if (var7.startsWith("CEL(") && var7.endsWith(")")) {
            this.cel(var7, var4, var1, var6);
         } else if (var7.startsWith("VAL(") && var7.endsWith(")")) {
            this.val(var7);
         } else if (var7.startsWith("COL>0")) {
            this.colsup();
         } else if (var7.startsWith("COL<0")) {
            this.colinf();
         } else if (var7.startsWith("STOT(") && var7.endsWith(")")) {
            this.stot(var5, var4);
         } else if (var7.startsWith("TTAB(") && var7.endsWith(")")) {
            this.ttab(var4);
         } else if (var7.startsWith("COMPTE(") && var7.endsWith(")") && (var8 == null || var8.isEmpty()) && (var9 == null || var9.isEmpty())) {
            this.compte(var1, var7, var3, var6);
         }
      } else {
         this.resultat3 = "";
         if (this.listMemoResultat.size() != 0 && var5 >= 0 && var5 < this.listMemoResultat.size()) {
            new BsoResultats();
            var10 = (BsoResultats)this.listMemoResultat.get(var5);
            if (var4 == 1) {
               this.resultat3 = var10.getTabresCon01();
            } else if (var4 == 2) {
               this.resultat3 = var10.getTabresCon02();
            } else if (var4 == 3) {
               this.resultat3 = var10.getTabresCon03();
            } else if (var4 == 4) {
               this.resultat3 = var10.getTabresCon04();
            } else if (var4 == 5) {
               this.resultat3 = var10.getTabresCon05();
            } else if (var4 == 6) {
               this.resultat3 = var10.getTabresCon06();
            } else if (var4 == 7) {
               this.resultat3 = var10.getTabresCon07();
            } else if (var4 == 8) {
               this.resultat3 = var10.getTabresCon08();
            } else if (var4 == 9) {
               this.resultat3 = var10.getTabresCon09();
            } else if (var4 == 10) {
               this.resultat3 = var10.getTabresCon10();
            } else if (var4 == 11) {
               this.resultat3 = var10.getTabresCon11();
            } else if (var4 == 12) {
               this.resultat3 = var10.getTabresCon12();
            } else if (var4 == 13) {
               this.resultat3 = var10.getTabresCon13();
            } else if (var4 == 14) {
               this.resultat3 = var10.getTabresCon14();
            } else if (var4 == 15) {
               this.resultat3 = var10.getTabresCon15();
            } else if (var4 == 16) {
               this.resultat3 = var10.getTabresCon16();
            } else if (var4 == 17) {
               this.resultat3 = var10.getTabresCon17();
            } else if (var4 == 18) {
               this.resultat3 = var10.getTabresCon18();
            } else if (var4 == 19) {
               this.resultat3 = var10.getTabresCon19();
            } else if (var4 == 20) {
               this.resultat3 = var10.getTabresCon20();
            }
         }
      }

   }

   public void inv() {
      this.resultat1 *= -1.0D;
   }

   public void abs() {
      this.resultat1 = Math.abs(this.resultat1);
   }

   public void arr(String var1) {
      if (var1.equalsIgnoreCase("ARR(1)")) {
         this.resultat1 = this.utilNombre.myRound(this.resultat1, 1);
      } else if (var1.equalsIgnoreCase("ARR(2)")) {
         this.resultat1 = this.utilNombre.myRound(this.resultat1, 2);
      } else {
         this.resultat1 = (double)Math.round(this.resultat1);
      }

   }

   public void entier() {
      int var1 = (int)this.resultat1;
      this.resultat1 = (double)Float.parseFloat("" + var1);
   }

   public void mod() {
      if (this.resultat2 != 0.0D) {
         this.resultat1 = Math.IEEEremainder(this.resultat1, this.resultat2);
         this.resultat2 = 0.0D;
      }

   }

   public void selectOperateur(String var1) {
      if (var1.equalsIgnoreCase("=")) {
         this.operateur = "=";
         this.resultat2 = this.resultat1;
         this.resultat1 = 0.0D;
      } else if (var1.equalsIgnoreCase("-")) {
         this.operateur = "-";
         this.resultat2 = this.resultat1;
         this.resultat1 = 0.0D;
      } else if (var1.equalsIgnoreCase("*")) {
         this.operateur = "*";
         this.resultat2 = this.resultat1;
         this.resultat1 = 0.0D;
      } else if (var1.equalsIgnoreCase("/")) {
         this.operateur = "/";
         this.resultat2 = this.resultat1;
         this.resultat1 = 0.0D;
      } else {
         this.operateur = "+";
         this.resultat2 = this.resultat1;
         this.resultat1 = 0.0D;
      }

   }

   public void somh(String var1) {
      String var2 = var1.substring(5, var1.length() - 1);
      if (var2.contains(":")) {
         String[] var3 = var2.split(":");
         int var4 = Integer.parseInt(var3[0]);
         int var5 = Integer.parseInt(var3[1]);
         this.recuperSomH(var4, var5, this.tabResultats);
         this.calculByOperateur();
      } else {
         this.resultat1 = 0.0D;
      }

   }

   public void difh(String var1) {
      String var2 = var1.substring(5, var1.length() - 1);
      if (var2.contains(":")) {
         String[] var3 = var2.split(":");
         int var4 = Integer.parseInt(var3[0]);
         int var5 = Integer.parseInt(var3[1]);
         this.recuperDifH(var4, var5, this.tabResultats);
         this.calculByOperateur();
      } else {
         this.resultat1 = 0.0D;
      }

   }

   public void somv(String var1, int var2) {
      String var3 = var1.substring(5, var1.length() - 1);
      if (var3.contains(":")) {
         String[] var4 = var3.split(":");
         String var5 = var4[0];
         String var6 = var4[1];
         this.recuperSomV(var5, var6, var2, this.lesResultats);
         this.calculByOperateur();
      } else {
         this.resultat1 = 0.0D;
      }

   }

   public void cel(String var1, int var2, int var3, Session var4) throws HibernateException, NamingException {
      String var5 = var1.substring(4, var1.length() - 1);
      if (var5.contains(":")) {
         String[] var6;
         String var7;
         String var8;
         String var10;
         String var11;
         if (var5.contains("=")) {
            var6 = var5.split("=");
            var7 = var6[0];
            var8 = var6[1];
            String[] var9 = var8.split(":");
            var10 = var9[0];
            var11 = var9[1];
            boolean var12 = false;
            int var18;
            if (var11.equals("*")) {
               var18 = var2;
            } else {
               var18 = Integer.parseInt(var9[1]);
            }

            if (var18 == 1 || var18 == 2 || var18 == 3 || var18 == 4 || var18 == 5 || var18 == 6 || var18 == 7 || var18 == 8 || var18 == 9 || var18 == 10 || var18 == 11 || var18 == 12 || var18 == 13 || var18 == 14 || var18 == 15 || var18 == 16 || var18 == 17 || var18 == 18 || var18 == 19 || var18 == 20) {
               if (var3 <= 19) {
                  this.recuperCelTabRefCol(var7, var10, var18, var4);
               } else {
                  String var13 = this.var_date_periode_deb;
                  String var14 = this.var_date_periode_fin;
                  this.recuperCelTabRefCol(var7, var10, var18, var13, var14, var4);
               }

               this.calculByOperateur();
            }
         } else {
            var6 = var5.split(":");
            var7 = var6[0];
            var8 = var6[1];
            boolean var15 = false;
            int var16;
            if (var8.equals("*")) {
               var16 = var2;
            } else {
               var16 = Integer.parseInt(var6[1]);
            }

            if (var16 == 1 || var16 == 2 || var16 == 3 || var16 == 4 || var16 == 5 || var16 == 6 || var16 == 7 || var16 == 8 || var16 == 9 || var16 == 10 || var16 == 11 || var16 == 12 || var16 == 13 || var16 == 14 || var16 == 15 || var16 == 16 || var16 == 17 || var16 == 18 || var16 == 19 || var16 == 20) {
               if (var3 <= 19) {
                  int var17 = this.lesResultats.size() - 1;
                  if (var17 + 1 != this.lesResultats.size()) {
                     this.lesResultats.add(this.tabResultats);
                  }

                  this.recuperCelRefCol(var7, var16, this.lesResultats);
                  this.calculByOperateur();
                  if (var17 + 1 != this.lesResultats.size()) {
                     this.lesResultats.remove(var17);
                  }
               } else {
                  var10 = this.var_date_periode_deb;
                  var11 = this.var_date_periode_fin;
                  this.recuperCelTabRefCol(this.tabResultats.getTabresCode(), var7, var16, var10, var11, var4);
                  this.calculByOperateur();
               }
            }
         }
      } else {
         this.resultat1 = 0.0D;
      }

   }

   public void val(String var1) {
      if (var1.endsWith("VAL()")) {
         this.resultat1 = 0.0D;
      } else {
         if (var1.contains(",")) {
            String var2 = var1.replace(",", ".");
            var1 = var2;
         }

         this.resultat1 = Double.parseDouble(var1.substring(4, var1.length() - 1));
         this.calculByOperateur();
      }

   }

   public void colsup() {
      if (this.resultat1 < 0.0D) {
         this.resultat1 = 0.0D;
      }

   }

   public void colinf() {
      if (this.resultat1 <= 0.0D) {
         this.resultat1 = Math.abs(this.resultat1);
      } else {
         this.resultat1 = 0.0D;
      }

   }

   public void stot(int var1, int var2) {
      this.recuperSousTotal(var1, var2, this.lesResultats);
      this.calculByOperateur();
   }

   public void ttab(int var1) {
      this.recuperTotalTableau(var1, this.lesResultats);
      this.calculByOperateur();
   }

   public void compte(int var1, String var2, int var3, Session var4) {
   }

   public void calculByOperateur() {
      if (this.operateur.equalsIgnoreCase("+")) {
         this.resultat1 += this.resultat2;
         this.resultat2 = 0.0D;
      } else if (this.operateur.equalsIgnoreCase("-")) {
         this.resultat1 = this.resultat2 - this.resultat1;
         this.resultat2 = 0.0D;
      } else if (this.operateur.equalsIgnoreCase("*")) {
         this.resultat1 = this.resultat2 * this.resultat1;
         this.resultat2 = 0.0D;
      } else if (this.operateur.equalsIgnoreCase("/")) {
         if (this.resultat1 != 0.0D) {
            this.resultat1 = this.resultat2 / this.resultat1;
            this.resultat2 = 0.0D;
         } else {
            this.resultat1 = 0.0D;
            this.resultat2 = 0.0D;
         }
      }

   }

   public void renseigneCol(int var1, double var2, String var4) {
      if (var1 == 1) {
         this.tabResultats.setTabresCol01(var2);
         this.tabResultats.setTabresCon01(var4);
      } else if (var1 == 2) {
         this.tabResultats.setTabresCol02(var2);
         this.tabResultats.setTabresCon02(var4);
      } else if (var1 == 3) {
         this.tabResultats.setTabresCol03(var2);
         this.tabResultats.setTabresCon03(var4);
      } else if (var1 == 4) {
         this.tabResultats.setTabresCol04(var2);
         this.tabResultats.setTabresCon04(var4);
      } else if (var1 == 5) {
         this.tabResultats.setTabresCol05(var2);
         this.tabResultats.setTabresCon05(var4);
      } else if (var1 == 6) {
         this.tabResultats.setTabresCol06(var2);
         this.tabResultats.setTabresCon06(var4);
      } else if (var1 == 7) {
         this.tabResultats.setTabresCol07(var2);
         this.tabResultats.setTabresCon07(var4);
      } else if (var1 == 8) {
         this.tabResultats.setTabresCol08(var2);
         this.tabResultats.setTabresCon08(var4);
      } else if (var1 == 9) {
         this.tabResultats.setTabresCol09(var2);
         this.tabResultats.setTabresCon09(var4);
      } else if (var1 == 10) {
         this.tabResultats.setTabresCol10(var2);
         this.tabResultats.setTabresCon10(var4);
      } else if (var1 == 11) {
         this.tabResultats.setTabresCol11(var2);
         this.tabResultats.setTabresCon11(var4);
      } else if (var1 == 12) {
         this.tabResultats.setTabresCol12(var2);
         this.tabResultats.setTabresCon12(var4);
      } else if (var1 == 13) {
         this.tabResultats.setTabresCol13(var2);
         this.tabResultats.setTabresCon13(var4);
      } else if (var1 == 14) {
         this.tabResultats.setTabresCol14(var2);
         this.tabResultats.setTabresCon14(var4);
      } else if (var1 == 15) {
         this.tabResultats.setTabresCol15(var2);
         this.tabResultats.setTabresCon15(var4);
      } else if (var1 == 16) {
         this.tabResultats.setTabresCol16(var2);
         this.tabResultats.setTabresCon16(var4);
      } else if (var1 == 17) {
         this.tabResultats.setTabresCol17(var2);
         this.tabResultats.setTabresCon17(var4);
      } else if (var1 == 18) {
         this.tabResultats.setTabresCol18(var2);
         this.tabResultats.setTabresCon18(var4);
      } else if (var1 == 19) {
         this.tabResultats.setTabresCol19(var2);
         this.tabResultats.setTabresCon19(var4);
      } else if (var1 == 20) {
         this.tabResultats.setTabresCol20(var2);
         this.tabResultats.setTabresCon20(var4);
      }

   }

   public double recuperSomH(int var1, int var2, BsoResultats var3) {
      double var4 = 0.0D;

      for(int var6 = var1; var6 <= var2; ++var6) {
         if (var6 == 1) {
            var4 += var3.getTabresCol01();
         } else if (var6 == 2) {
            var4 += var3.getTabresCol02();
         } else if (var6 == 3) {
            var4 += var3.getTabresCol03();
         } else if (var6 == 4) {
            var4 += var3.getTabresCol04();
         } else if (var6 == 5) {
            var4 += var3.getTabresCol05();
         } else if (var6 == 6) {
            var4 += var3.getTabresCol06();
         } else if (var6 == 7) {
            var4 += var3.getTabresCol07();
         } else if (var6 == 8) {
            var4 += var3.getTabresCol08();
         } else if (var6 == 9) {
            var4 += var3.getTabresCol09();
         } else if (var6 == 10) {
            var4 += var3.getTabresCol10();
         } else if (var6 == 11) {
            var4 += var3.getTabresCol11();
         } else if (var6 == 12) {
            var4 += var3.getTabresCol12();
         } else if (var6 == 13) {
            var4 += var3.getTabresCol13();
         } else if (var6 == 14) {
            var4 += var3.getTabresCol14();
         } else if (var6 == 15) {
            var4 += var3.getTabresCol15();
         } else if (var6 == 16) {
            var4 += var3.getTabresCol16();
         } else if (var6 == 17) {
            var4 += var3.getTabresCol17();
         } else if (var6 == 18) {
            var4 += var3.getTabresCol18();
         } else if (var6 == 19) {
            var4 += var3.getTabresCol19();
         } else if (var6 == 20) {
            var4 += var3.getTabresCol20();
         }
      }

      this.resultat1 = var4;
      return var4;
   }

   public double recuperDifH(int var1, int var2, BsoResultats var3) {
      double var4 = 0.0D;
      double var6 = 0.0D;
      boolean var8 = false;

      for(int var9 = var1; var9 <= var2; ++var9) {
         if (var9 == 1) {
            var4 = var3.getTabresCol01();
         } else if (var9 == 2) {
            var4 = var3.getTabresCol02();
         } else if (var9 == 3) {
            var4 = var3.getTabresCol03();
         } else if (var9 == 4) {
            var4 = var3.getTabresCol04();
         } else if (var9 == 5) {
            var4 = var3.getTabresCol05();
         } else if (var9 == 6) {
            var4 = var3.getTabresCol06();
         } else if (var9 == 7) {
            var4 = var3.getTabresCol07();
         } else if (var9 == 8) {
            var4 = var3.getTabresCol08();
         } else if (var9 == 9) {
            var4 = var3.getTabresCol09();
         } else if (var9 == 10) {
            var4 = var3.getTabresCol10();
         } else if (var9 == 11) {
            var4 = var3.getTabresCol11();
         } else if (var9 == 12) {
            var4 = var3.getTabresCol12();
         } else if (var9 == 13) {
            var4 = var3.getTabresCol13();
         } else if (var9 == 14) {
            var4 = var3.getTabresCol14();
         } else if (var9 == 15) {
            var4 = var3.getTabresCol15();
         } else if (var9 == 16) {
            var4 = var3.getTabresCol16();
         } else if (var9 == 17) {
            var4 = var3.getTabresCol17();
         } else if (var9 == 18) {
            var4 = var3.getTabresCol18();
         } else if (var9 == 19) {
            var4 = var3.getTabresCol19();
         } else if (var9 == 20) {
            var4 = var3.getTabresCol20();
         }

         if (!var8) {
            var6 = var4;
            var8 = true;
         } else {
            var6 -= var4;
            var8 = false;
         }

         var4 = 0.0D;
      }

      this.resultat1 = var6;
      return var6;
   }

   public double recuperSomV(String var1, String var2, int var3, List var4) {
      double var5 = 0.0D;
      boolean var7 = false;
      new BsoResultats();

      for(int var9 = 0; var9 < var4.size(); ++var9) {
         BsoResultats var8 = (BsoResultats)var4.get(var9);
         if (var8.getTabresReference() != null && var8.getTabresReference().equalsIgnoreCase(var1)) {
            var7 = true;
         }

         if (var7 && var8.getTabresType() == 3 && var8.getTabresMode() == 0) {
            if (var3 == 1) {
               var5 += var8.getTabresCol01();
            } else if (var3 == 2) {
               var5 += var8.getTabresCol02();
            } else if (var3 == 3) {
               var5 += var8.getTabresCol03();
            } else if (var3 == 4) {
               var5 += var8.getTabresCol04();
            } else if (var3 == 5) {
               var5 += var8.getTabresCol05();
            } else if (var3 == 6) {
               var5 += var8.getTabresCol06();
            } else if (var3 == 7) {
               var5 += var8.getTabresCol07();
            } else if (var3 == 8) {
               var5 += var8.getTabresCol08();
            } else if (var3 == 9) {
               var5 += var8.getTabresCol09();
            } else if (var3 == 10) {
               var5 += var8.getTabresCol10();
            } else if (var3 == 11) {
               var5 += var8.getTabresCol11();
            } else if (var3 == 12) {
               var5 += var8.getTabresCol12();
            } else if (var3 == 13) {
               var5 += var8.getTabresCol13();
            } else if (var3 == 14) {
               var5 += var8.getTabresCol14();
            } else if (var3 == 15) {
               var5 += var8.getTabresCol15();
            } else if (var3 == 16) {
               var5 += var8.getTabresCol16();
            } else if (var3 == 17) {
               var5 += var8.getTabresCol17();
            } else if (var3 == 18) {
               var5 += var8.getTabresCol18();
            } else if (var3 == 19) {
               var5 += var8.getTabresCol19();
            } else if (var3 == 20) {
               var5 += var8.getTabresCol20();
            }
         }

         if (var8.getTabresReference() != null && var8.getTabresReference().equalsIgnoreCase(var2)) {
            var7 = false;
            break;
         }
      }

      this.resultat1 = var5;
      return var5;
   }

   public double recuperSousTotal(int var1, int var2, List var3) {
      double var4 = 0.0D;
      boolean var6 = true;
      new BsoResultats();

      for(int var8 = var1; var8 != 0; --var8) {
         BsoResultats var7 = (BsoResultats)var3.get(var8);
         if (var7.getTabresType() <= 2) {
            var6 = false;
         }

         if (var6 && var7.getTabresType() == 3 && var7.getTabresMode() == 0) {
            if (var2 == 1) {
               var4 += var7.getTabresCol01();
            } else if (var2 == 2) {
               var4 += var7.getTabresCol02();
            } else if (var2 == 3) {
               var4 += var7.getTabresCol03();
            } else if (var2 == 4) {
               var4 += var7.getTabresCol04();
            } else if (var2 == 5) {
               var4 += var7.getTabresCol05();
            } else if (var2 == 6) {
               var4 += var7.getTabresCol06();
            } else if (var2 == 7) {
               var4 += var7.getTabresCol07();
            } else if (var2 == 8) {
               var4 += var7.getTabresCol08();
            } else if (var2 == 9) {
               var4 += var7.getTabresCol09();
            } else if (var2 == 10) {
               var4 += var7.getTabresCol10();
            } else if (var2 == 11) {
               var4 += var7.getTabresCol11();
            } else if (var2 == 12) {
               var4 += var7.getTabresCol12();
            } else if (var2 == 13) {
               var4 += var7.getTabresCol13();
            } else if (var2 == 14) {
               var4 += var7.getTabresCol14();
            } else if (var2 == 15) {
               var4 += var7.getTabresCol15();
            } else if (var2 == 16) {
               var4 += var7.getTabresCol16();
            } else if (var2 == 17) {
               var4 += var7.getTabresCol17();
            } else if (var2 == 18) {
               var4 += var7.getTabresCol18();
            } else if (var2 == 19) {
               var4 += var7.getTabresCol19();
            } else if (var2 == 20) {
               var4 += var7.getTabresCol20();
            }
         }

         if (var7.getTabresType() <= 2) {
            var6 = false;
            break;
         }
      }

      this.resultat1 = var4;
      return var4;
   }

   public double recuperTotalTableau(int var1, List var2) {
      double var3 = 0.0D;
      new BsoResultats();

      for(int var6 = 0; var6 < var2.size(); ++var6) {
         BsoResultats var5 = (BsoResultats)var2.get(var6);
         if (var5.getTabresType() == 3 && var5.getTabresMode() == 0) {
            if (var1 == 1) {
               var3 += var5.getTabresCol01();
            } else if (var1 == 2) {
               var3 += var5.getTabresCol02();
            } else if (var1 == 3) {
               var3 += var5.getTabresCol03();
            } else if (var1 == 4) {
               var3 += var5.getTabresCol04();
            } else if (var1 == 5) {
               var3 += var5.getTabresCol05();
            } else if (var1 == 6) {
               var3 += var5.getTabresCol06();
            } else if (var1 == 7) {
               var3 += var5.getTabresCol07();
            } else if (var1 == 8) {
               var3 += var5.getTabresCol08();
            } else if (var1 == 9) {
               var3 += var5.getTabresCol09();
            } else if (var1 == 10) {
               var3 += var5.getTabresCol10();
            } else if (var1 == 11) {
               var3 += var5.getTabresCol11();
            } else if (var1 == 12) {
               var3 += var5.getTabresCol12();
            } else if (var1 == 13) {
               var3 += var5.getTabresCol13();
            } else if (var1 == 14) {
               var3 += var5.getTabresCol14();
            } else if (var1 == 15) {
               var3 += var5.getTabresCol15();
            } else if (var1 == 16) {
               var3 += var5.getTabresCol16();
            } else if (var1 == 17) {
               var3 += var5.getTabresCol17();
            } else if (var1 == 18) {
               var3 += var5.getTabresCol18();
            } else if (var1 == 19) {
               var3 += var5.getTabresCol19();
            } else if (var1 == 20) {
               var3 += var5.getTabresCol20();
            }
         }
      }

      this.resultat1 = var3;
      return var3;
   }

   public double recuperCelRefCol(String var1, int var2, List var3) {
      double var4 = 0.0D;
      new BsoResultats();

      for(int var7 = 0; var7 < var3.size(); ++var7) {
         BsoResultats var6 = (BsoResultats)var3.get(var7);
         if (var6.getTabresReference() != null && var6.getTabresReference().equalsIgnoreCase(var1)) {
            if (var2 == 1) {
               var4 = var6.getTabresCol01();
            } else if (var2 == 2) {
               var4 = var6.getTabresCol02();
            } else if (var2 == 3) {
               var4 = var6.getTabresCol03();
            } else if (var2 == 4) {
               var4 = var6.getTabresCol04();
            } else if (var2 == 5) {
               var4 = var6.getTabresCol05();
            } else if (var2 == 6) {
               var4 = var6.getTabresCol06();
            } else if (var2 == 7) {
               var4 = var6.getTabresCol07();
            } else if (var2 == 8) {
               var4 = var6.getTabresCol08();
            } else if (var2 == 9) {
               var4 = var6.getTabresCol09();
            } else if (var2 == 10) {
               var4 = var6.getTabresCol10();
            } else if (var2 == 11) {
               var4 = var6.getTabresCol11();
            } else if (var2 == 12) {
               var4 = var6.getTabresCol12();
            } else if (var2 == 13) {
               var4 = var6.getTabresCol13();
            } else if (var2 == 14) {
               var4 = var6.getTabresCol14();
            } else if (var2 == 15) {
               var4 = var6.getTabresCol15();
            } else if (var2 == 16) {
               var4 = var6.getTabresCol16();
            } else if (var2 == 17) {
               var4 = var6.getTabresCol17();
            } else if (var2 == 18) {
               var4 = var6.getTabresCol18();
            } else if (var2 == 19) {
               var4 = var6.getTabresCol19();
            } else if (var2 == 20) {
               var4 = var6.getTabresCol20();
            }
         }
      }

      this.resultat1 = var4;
      return var4;
   }

   public double recuperCelTabRefCol(String var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      double var5 = 0.0D;
      new BsoResultats();
      BsoResultats var7 = this.bsoResultatsDao.recuperCelTabRefCol(var4, this.var_exercice, var2, var1);
      if (var7 != null) {
         if (var3 == 1) {
            var5 = var7.getTabresCol01();
         } else if (var3 == 2) {
            var5 = var7.getTabresCol02();
         } else if (var3 == 3) {
            var5 = var7.getTabresCol03();
         } else if (var3 == 4) {
            var5 = var7.getTabresCol04();
         } else if (var3 == 5) {
            var5 = var7.getTabresCol05();
         } else if (var3 == 6) {
            var5 = var7.getTabresCol06();
         } else if (var3 == 7) {
            var5 = var7.getTabresCol07();
         } else if (var3 == 8) {
            var5 = var7.getTabresCol08();
         } else if (var3 == 9) {
            var5 = var7.getTabresCol09();
         } else if (var3 == 10) {
            var5 = var7.getTabresCol10();
         } else if (var3 == 11) {
            var5 = var7.getTabresCol11();
         } else if (var3 == 12) {
            var5 = var7.getTabresCol12();
         } else if (var3 == 13) {
            var5 = var7.getTabresCol13();
         } else if (var3 == 14) {
            var5 = var7.getTabresCol14();
         } else if (var3 == 15) {
            var5 = var7.getTabresCol15();
         } else if (var3 == 16) {
            var5 = var7.getTabresCol16();
         } else if (var3 == 17) {
            var5 = var7.getTabresCol17();
         } else if (var3 == 18) {
            var5 = var7.getTabresCol18();
         } else if (var3 == 19) {
            var5 = var7.getTabresCol19();
         } else if (var3 == 20) {
            var5 = var7.getTabresCol20();
         }
      } else {
         var5 = 0.0D;
      }

      this.resultat1 = var5;
      return var5;
   }

   public double recuperCelTabRefCol(String var1, String var2, int var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      double var7 = 0.0D;
      new BsoResultats();
      BsoResultats var9 = this.bsoResultatsDao.recuperCelTabRefCol(var6, this.var_exercice, var2, var1, var4, var5);
      if (var9 != null) {
         if (var3 == 1) {
            var7 = var9.getTabresCol01();
         } else if (var3 == 2) {
            var7 = var9.getTabresCol02();
         } else if (var3 == 3) {
            var7 = var9.getTabresCol03();
         } else if (var3 == 4) {
            var7 = var9.getTabresCol04();
         } else if (var3 == 5) {
            var7 = var9.getTabresCol05();
         } else if (var3 == 6) {
            var7 = var9.getTabresCol06();
         } else if (var3 == 7) {
            var7 = var9.getTabresCol07();
         } else if (var3 == 8) {
            var7 = var9.getTabresCol08();
         } else if (var3 == 9) {
            var7 = var9.getTabresCol09();
         } else if (var3 == 10) {
            var7 = var9.getTabresCol10();
         } else if (var3 == 11) {
            var7 = var9.getTabresCol11();
         } else if (var3 == 12) {
            var7 = var9.getTabresCol12();
         } else if (var3 == 13) {
            var7 = var9.getTabresCol13();
         } else if (var3 == 14) {
            var7 = var9.getTabresCol14();
         } else if (var3 == 15) {
            var7 = var9.getTabresCol15();
         } else if (var3 == 16) {
            var7 = var9.getTabresCol16();
         } else if (var3 == 17) {
            var7 = var9.getTabresCol17();
         } else if (var3 == 18) {
            var7 = var9.getTabresCol18();
         } else if (var3 == 19) {
            var7 = var9.getTabresCol19();
         } else if (var3 == 20) {
            var7 = var9.getTabresCol20();
         }
      } else {
         var7 = 0.0D;
      }

      this.resultat1 = var7;
      return var7;
   }

   public List chargerEcrituresByNumCpte(int var1, String var2, Session var3) {
      ArrayList var4 = new ArrayList();
      if (this.balanceListe.size() != 0 && this.cptTabNom.getTablisType() == 0) {
         new BulletinLigne();

         for(int var6 = 0; var6 < this.balanceListe.size(); ++var6) {
            BulletinLigne var5 = (BulletinLigne)this.balanceListe.get(var6);
         }
      }

      return var4;
   }

   public double calculSoldeforCompte(int var1, List var2, int var3, Session var4) {
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      if (var3 == 0 || var3 == 1) {
         for(int var11 = 0; var11 < var2.size(); ++var11) {
            if (((Ecritures)var2.get(var11)).getEcrNatureJrx() != 13) {
               var7 += ((Ecritures)var2.get(var11)).getEcrDebitPays();
               var9 += ((Ecritures)var2.get(var11)).getEcrCreditPays();
            }
         }

         if (var3 == 0) {
            var5 = var7 - var9;
         } else {
            var5 = var9 - var7;
         }
      }

      this.resultat1 = var5;
      return this.resultat1;
   }

   public void detailColonne01() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(1);
         }
      }

   }

   public void detailColonne02() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(2);
         }
      }

   }

   public void detailColonne03() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(3);
         }
      }

   }

   public void detailColonne04() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(4);
         }
      }

   }

   public void detailColonne05() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(5);
         }
      }

   }

   public void detailColonne06() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(6);
         }
      }

   }

   public void detailColonne07() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(7);
         }
      }

   }

   public void detailColonne08() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(8);
         }
      }

   }

   public void detailColonne09() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(9);
         }
      }

   }

   public void detailColonne10() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(10);
         }
      }

   }

   public void detailColonne11() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(11);
         }
      }

   }

   public void detailColonne12() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(12);
         }
      }

   }

   public void detailColonne13() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(13);
         }
      }

   }

   public void detailColonne14() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(14);
         }
      }

   }

   public void detailColonne15() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(15);
         }
      }

   }

   public void detailColonne16() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(16);
         }
      }

   }

   public void detailColonne17() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(17);
         }
      }

   }

   public void detailColonne18() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(18);
         }
      }

   }

   public void detailColonne19() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(19);
         }
      }

   }

   public void detailColonne20() throws HibernateException, NamingException {
      if (this.dataModelResultat.isRowAvailable()) {
         this.tabResultats = (BsoResultats)this.dataModelResultat.getRowData();
         if (this.tabResultats != null) {
            this.calculDetail(20);
         }
      }

   }

   public void calculDetail(int var1) throws HibernateException, NamingException {
      this.lesEcrituresDetail.clear();
      this.dataModelEcrituresDetail.setWrappedData(this.lesEcrituresDetail);
      this.showModalPanelDetailCalcul = true;
   }

   public void fermerDetailLigne() {
      this.showModalPanelDetailCalcul = false;
   }

   public void initImpressionTableauEnCours() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      this.etatCumul = 0;
      this.showModalPanelPrint = true;
   }

   public void initImpressionBilanComplet() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      this.etatCumul = 2;
      this.showModalPanelPrint = true;
   }

   public void initImpressionTableaux() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      this.chargerLesModelesImpresion();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "bilans";
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
               int var6 = var5.indexOf(".");
               var5 = var5.substring(0, var6);
               this.lesModelsimpression.add(new SelectItem(var5));
            }
         }
      }

      this.nomRapport = "Tableau_bord_" + this.cptTabNom.getTablisNbCol();
   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
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

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.utilPrint.setVar_nom_col1(this.cptTabNom.getTablisNom01());
      this.utilPrint.setVar_nom_col2(this.cptTabNom.getTablisNom02());
      this.utilPrint.setVar_nom_col3(this.cptTabNom.getTablisNom03());
      this.utilPrint.setVar_nom_col4(this.cptTabNom.getTablisNom04());
      this.utilPrint.setVar_nom_col5(this.cptTabNom.getTablisNom05());
      this.utilPrint.setVar_nom_col6(this.cptTabNom.getTablisNom06());
      this.utilPrint.setVar_nom_col7(this.cptTabNom.getTablisNom07());
      this.utilPrint.setVar_nom_col8(this.cptTabNom.getTablisNom08());
      this.utilPrint.setVar_nom_col9(this.cptTabNom.getTablisNom09());
      this.utilPrint.setVar_nom_col10(this.cptTabNom.getTablisNom10());
      this.utilPrint.setVar_nom_col11(this.cptTabNom.getTablisNom11());
      this.utilPrint.setVar_nom_col12(this.cptTabNom.getTablisNom12());
      this.utilPrint.setVar_nom_col13(this.cptTabNom.getTablisNom13());
      this.utilPrint.setVar_nom_col14(this.cptTabNom.getTablisNom14());
      this.utilPrint.setVar_nom_col15(this.cptTabNom.getTablisNom15());
      this.utilPrint.setVar_nom_col16(this.cptTabNom.getTablisNom16());
      this.utilPrint.setVar_nom_col17(this.cptTabNom.getTablisNom17());
      this.utilPrint.setVar_nom_col18(this.cptTabNom.getTablisNom18());
      this.utilPrint.setVar_nom_col19(this.cptTabNom.getTablisNom19());
      this.utilPrint.setVar_nom_col20(this.cptTabNom.getTablisNom20());
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "etatfin_" + this.structureLog.getStrzonefiscale() + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "etatfin_" + this.structureLog.getStrzonefiscale() + File.separator);
      this.utilPrint.setEntete("Bilan social");
      this.utilPrint.setNomMapping("bilnsocial");
      this.utilPrint.setExercice(this.selectedExo.getExepayId());
      this.utilPrint.setDateDeb(this.dateDebCalcul);
      this.utilPrint.setDateFin(this.dateFinCalcul);
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setEmetteur(this.impEmetteur);
      this.utilPrint.setDestinataire(this.impDestinataire);
      this.utilPrint.setDestinataireCC(this.impDestinataireCC);
      this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
      this.utilPrint.setTiersSelectionne((Tiers)null);
      ArrayList var1 = new ArrayList();
      JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
      this.utilPrint.setjRBeanCollectionDataSource(var2);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      if (this.etatCumul == 0) {
         this.impressionEtat(this.cptTabNom);
      } else {
         BsoTabNom var3;
         if (this.etatCumul == 1) {
            var3 = new BsoTabNom();
            var3.setTablisLibFR("bilanCrTaf");
            var3.setTablisCode("XX");
            this.impressionEtat(var3);
         } else if (this.etatCumul == 2) {
            var3 = new BsoTabNom();
            var3.setTablisLibFR("liasseComplete");
            var3.setTablisCode("XX");
            this.impressionEtat(var3);
         } else if (this.etatCumul == 3) {
            var3 = new BsoTabNom();
            var3.setTablisLibFR("liasseTableaux");
            var3.setTablisCode("XX");
            this.impressionEtat(var3);
         }
      }

   }

   public void impressionEtat(BsoTabNom var1) throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var1.getTablisLibFR().equals("bilanCrTaf")) {
         this.requete = "tabres_code='BA' and execpt_id=" + this.selectedExo.getExepayId();
         this.utilPrint.setRapport("bilanCrTaf");
         this.utilPrint.setPage_init(8);
      } else if (var1.getTablisLibFR().equals("liasseComplete")) {
         this.requete = "tabres_code='BA' and execpt_id=" + this.selectedExo.getExepayId();
         this.utilPrint.setRapport("liasseComplete");
         this.utilPrint.setPage_init(1);
      } else if (var1.getTablisLibFR().equals("liasseTableaux")) {
         this.requete = "tabres_code='T1' and execpt_id=" + this.selectedExo.getExepayId();
         this.utilPrint.setRapport("liasseTableaux");
         this.utilPrint.setEtat_init(41);
      } else {
         this.requete = "tabres_code='" + var1.getTablisCode() + "' and execpt_id=" + this.selectedExo.getExepayId();
         this.utilPrint.setRapport(var1.getTablisModele());
         if (var1.getTablisCode().equals("BA")) {
            this.utilPrint.setPage_init(8);
         } else if (var1.getTablisCode().equals("BP")) {
            this.utilPrint.setPage_init(10);
         } else if (var1.getTablisCode().equals("CRC")) {
            this.utilPrint.setPage_init(12);
         } else if (var1.getTablisCode().equals("CRP")) {
            this.utilPrint.setPage_init(14);
         } else if (var1.getTablisCode().equals("TAF1")) {
            this.utilPrint.setPage_init(16);
         } else if (var1.getTablisCode().equals("TAF2")) {
            this.utilPrint.setPage_init(17);
         } else if (var1.getTablisCode().equals("TAF3")) {
            this.utilPrint.setPage_init(18);
         } else if (var1.getTablisCode().equals("TAF4")) {
            this.utilPrint.setPage_init(19);
         } else {
            this.utilPrint.setEtat_init(var1.getTablisNum());
         }
      }

      this.utilPrint.setFiltre(this.filtre);
      this.utilPrint.setRequete(this.requete);
      this.utilPrint.imprimeRapport();
   }

   public void imprimerForPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimerFor();
   }

   public void imprimerForJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimerFor();
   }

   public void imprimerForPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimerFor();
   }

   public void imprimerForXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimerFor();
   }

   public void imprimerForDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimerFor();
   }

   public void imprimerForODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimerFor();
   }

   public void imprimerForHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimerFor();
   }

   public void imprimerForXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimerFor();
   }

   public void imprimerFor() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (!this.format.equals("MAIL")) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.cptTabNom != null) {
         this.filtre = this.cptTabNom.getTablisCode() + " : " + this.cptTabNom.getTablisLibFR();
         this.requete = "tablis_code='" + this.cptTabNom.getTablisCode() + "'";
         if (!this.format.equals("MAIL")) {
            this.utilPrint = new UtilPrint(this.utilInitHibernate);
         }

         if (this.cptTabNom.getTablisType() == 1) {
            this.utilPrint.setRapport("Tableau_Bord");
         } else {
            this.utilPrint.setRapport("Etat_Financier_str");
         }

         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Structure des Etats financiers");
         this.utilPrint.setFiltre(this.filtre);
         this.utilPrint.setRequete(this.requete);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         ArrayList var1 = new ArrayList();
         JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
         this.utilPrint.setjRBeanCollectionDataSource(var2);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public List getLesTableauxItems() {
      return this.lesTableauxItems;
   }

   public BsoTabNom getCptTabNom() {
      return this.cptTabNom;
   }

   public void setCptTabNom(BsoTabNom var1) {
      this.cptTabNom = var1;
   }

   public void setLesTableauxItems(List var1) {
      this.lesTableauxItems = var1;
   }

   public boolean isTestAffElmtOrTabResultat() {
      return this.testAffElmtOrTabResultat;
   }

   public void setTestAffElmtOrTabResultat(boolean var1) {
      this.testAffElmtOrTabResultat = var1;
   }

   public BsoResultats getTabResultats() {
      return this.tabResultats;
   }

   public void setTabResultats(BsoResultats var1) {
      this.tabResultats = var1;
   }

   public boolean isTestAffImprimer() {
      return this.testAffImprimer;
   }

   public void setTestAffImprimer(boolean var1) {
      this.testAffImprimer = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public Date getDateDebCalcul() {
      return this.dateDebCalcul;
   }

   public void setDateDebCalcul(Date var1) {
      this.dateDebCalcul = var1;
   }

   public Date getDateFinCalcul() {
      return this.dateFinCalcul;
   }

   public void setDateFinCalcul(Date var1) {
      this.dateFinCalcul = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_date_periode_deb() {
      return this.var_date_periode_deb;
   }

   public void setVar_date_periode_deb(String var1) {
      this.var_date_periode_deb = var1;
   }

   public String getVar_date_periode_fin() {
      return this.var_date_periode_fin;
   }

   public void setVar_date_periode_fin(String var1) {
      this.var_date_periode_fin = var1;
   }

   public long getVar_exercice() {
      return this.var_exercice;
   }

   public void setVar_exercice(long var1) {
      this.var_exercice = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public boolean isVar_aff_col01() {
      return this.var_aff_col01;
   }

   public void setVar_aff_col01(boolean var1) {
      this.var_aff_col01 = var1;
   }

   public boolean isVar_aff_col02() {
      return this.var_aff_col02;
   }

   public void setVar_aff_col02(boolean var1) {
      this.var_aff_col02 = var1;
   }

   public boolean isVar_aff_col03() {
      return this.var_aff_col03;
   }

   public void setVar_aff_col03(boolean var1) {
      this.var_aff_col03 = var1;
   }

   public boolean isVar_aff_col04() {
      return this.var_aff_col04;
   }

   public void setVar_aff_col04(boolean var1) {
      this.var_aff_col04 = var1;
   }

   public boolean isVar_aff_col05() {
      return this.var_aff_col05;
   }

   public void setVar_aff_col05(boolean var1) {
      this.var_aff_col05 = var1;
   }

   public boolean isVar_aff_col06() {
      return this.var_aff_col06;
   }

   public void setVar_aff_col06(boolean var1) {
      this.var_aff_col06 = var1;
   }

   public boolean isVar_aff_col07() {
      return this.var_aff_col07;
   }

   public void setVar_aff_col07(boolean var1) {
      this.var_aff_col07 = var1;
   }

   public boolean isVar_aff_col08() {
      return this.var_aff_col08;
   }

   public void setVar_aff_col08(boolean var1) {
      this.var_aff_col08 = var1;
   }

   public boolean isVar_aff_col09() {
      return this.var_aff_col09;
   }

   public void setVar_aff_col09(boolean var1) {
      this.var_aff_col09 = var1;
   }

   public boolean isVar_aff_col10() {
      return this.var_aff_col10;
   }

   public void setVar_aff_col10(boolean var1) {
      this.var_aff_col10 = var1;
   }

   public boolean isVar_aff_col11() {
      return this.var_aff_col11;
   }

   public void setVar_aff_col11(boolean var1) {
      this.var_aff_col11 = var1;
   }

   public boolean isVar_aff_col12() {
      return this.var_aff_col12;
   }

   public void setVar_aff_col12(boolean var1) {
      this.var_aff_col12 = var1;
   }

   public boolean isVar_aff_col13() {
      return this.var_aff_col13;
   }

   public void setVar_aff_col13(boolean var1) {
      this.var_aff_col13 = var1;
   }

   public boolean isVar_aff_col14() {
      return this.var_aff_col14;
   }

   public void setVar_aff_col14(boolean var1) {
      this.var_aff_col14 = var1;
   }

   public boolean isVar_aff_col15() {
      return this.var_aff_col15;
   }

   public void setVar_aff_col15(boolean var1) {
      this.var_aff_col15 = var1;
   }

   public boolean isVar_aff_col16() {
      return this.var_aff_col16;
   }

   public void setVar_aff_col16(boolean var1) {
      this.var_aff_col16 = var1;
   }

   public boolean isVar_aff_col17() {
      return this.var_aff_col17;
   }

   public void setVar_aff_col17(boolean var1) {
      this.var_aff_col17 = var1;
   }

   public boolean isVar_aff_col18() {
      return this.var_aff_col18;
   }

   public void setVar_aff_col18(boolean var1) {
      this.var_aff_col18 = var1;
   }

   public boolean isVar_aff_col19() {
      return this.var_aff_col19;
   }

   public void setVar_aff_col19(boolean var1) {
      this.var_aff_col19 = var1;
   }

   public boolean isVar_aff_col20() {
      return this.var_aff_col20;
   }

   public void setVar_aff_col20(boolean var1) {
      this.var_aff_col20 = var1;
   }

   public BsoTabElement getCptTabElement() {
      return this.cptTabElement;
   }

   public void setCptTabElement(BsoTabElement var1) {
      this.cptTabElement = var1;
   }

   public int getVar_largeur_col1() {
      return this.var_largeur_col1;
   }

   public void setVar_largeur_col1(int var1) {
      this.var_largeur_col1 = var1;
   }

   public int getVar_largeur_col10() {
      return this.var_largeur_col10;
   }

   public void setVar_largeur_col10(int var1) {
      this.var_largeur_col10 = var1;
   }

   public int getVar_largeur_col11() {
      return this.var_largeur_col11;
   }

   public void setVar_largeur_col11(int var1) {
      this.var_largeur_col11 = var1;
   }

   public int getVar_largeur_col12() {
      return this.var_largeur_col12;
   }

   public void setVar_largeur_col12(int var1) {
      this.var_largeur_col12 = var1;
   }

   public int getVar_largeur_col13() {
      return this.var_largeur_col13;
   }

   public void setVar_largeur_col13(int var1) {
      this.var_largeur_col13 = var1;
   }

   public int getVar_largeur_col14() {
      return this.var_largeur_col14;
   }

   public void setVar_largeur_col14(int var1) {
      this.var_largeur_col14 = var1;
   }

   public int getVar_largeur_col15() {
      return this.var_largeur_col15;
   }

   public void setVar_largeur_col15(int var1) {
      this.var_largeur_col15 = var1;
   }

   public int getVar_largeur_col16() {
      return this.var_largeur_col16;
   }

   public void setVar_largeur_col16(int var1) {
      this.var_largeur_col16 = var1;
   }

   public int getVar_largeur_col17() {
      return this.var_largeur_col17;
   }

   public void setVar_largeur_col17(int var1) {
      this.var_largeur_col17 = var1;
   }

   public int getVar_largeur_col18() {
      return this.var_largeur_col18;
   }

   public void setVar_largeur_col18(int var1) {
      this.var_largeur_col18 = var1;
   }

   public int getVar_largeur_col19() {
      return this.var_largeur_col19;
   }

   public void setVar_largeur_col19(int var1) {
      this.var_largeur_col19 = var1;
   }

   public int getVar_largeur_col2() {
      return this.var_largeur_col2;
   }

   public void setVar_largeur_col2(int var1) {
      this.var_largeur_col2 = var1;
   }

   public int getVar_largeur_col20() {
      return this.var_largeur_col20;
   }

   public void setVar_largeur_col20(int var1) {
      this.var_largeur_col20 = var1;
   }

   public int getVar_largeur_col3() {
      return this.var_largeur_col3;
   }

   public void setVar_largeur_col3(int var1) {
      this.var_largeur_col3 = var1;
   }

   public int getVar_largeur_col4() {
      return this.var_largeur_col4;
   }

   public void setVar_largeur_col4(int var1) {
      this.var_largeur_col4 = var1;
   }

   public int getVar_largeur_col5() {
      return this.var_largeur_col5;
   }

   public void setVar_largeur_col5(int var1) {
      this.var_largeur_col5 = var1;
   }

   public int getVar_largeur_col6() {
      return this.var_largeur_col6;
   }

   public void setVar_largeur_col6(int var1) {
      this.var_largeur_col6 = var1;
   }

   public int getVar_largeur_col7() {
      return this.var_largeur_col7;
   }

   public void setVar_largeur_col7(int var1) {
      this.var_largeur_col7 = var1;
   }

   public int getVar_largeur_col8() {
      return this.var_largeur_col8;
   }

   public void setVar_largeur_col8(int var1) {
      this.var_largeur_col8 = var1;
   }

   public int getVar_largeur_col9() {
      return this.var_largeur_col9;
   }

   public void setVar_largeur_col9(int var1) {
      this.var_largeur_col9 = var1;
   }

   public int getVar_largeur_tableau() {
      return this.var_largeur_tableau;
   }

   public void setVar_largeur_tableau(int var1) {
      this.var_largeur_tableau = var1;
   }

   public boolean isAfficheValider() {
      return this.afficheValider;
   }

   public void setAfficheValider(boolean var1) {
      this.afficheValider = var1;
   }

   public String getOperateur() {
      return this.operateur;
   }

   public void setOperateur(String var1) {
      this.operateur = var1;
   }

   public double getResultat1() {
      return this.resultat1;
   }

   public void setResultat1(double var1) {
      this.resultat1 = var1;
   }

   public double getResultat2() {
      return this.resultat2;
   }

   public void setResultat2(double var1) {
      this.resultat2 = var1;
   }

   public String getResultat3() {
      return this.resultat3;
   }

   public void setResultat3(String var1) {
      this.resultat3 = var1;
   }

   public ExercicesPaye getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesPaye var1) {
      this.lastExo = var1;
   }

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
   }

   public ExercicesPaye getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesPaye var1) {
      this.selectedExo = var1;
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

   public boolean isAllSelect() {
      return this.allSelect;
   }

   public void setAllSelect(boolean var1) {
      this.allSelect = var1;
   }

   public String getElementEnCours() {
      return this.elementEnCours;
   }

   public void setElementEnCours(String var1) {
      this.elementEnCours = var1;
   }

   public String getColonneEnCours() {
      return this.colonneEnCours;
   }

   public void setColonneEnCours(String var1) {
      this.colonneEnCours = var1;
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

   public DataModel getDataModelResultat() {
      return this.dataModelResultat;
   }

   public void setDataModelResultat(DataModel var1) {
      this.dataModelResultat = var1;
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

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public String getNomRapport() {
      return this.nomRapport;
   }

   public void setNomRapport(String var1) {
      this.nomRapport = var1;
   }

   public String getVar_tableau_selectionne() {
      return this.var_tableau_selectionne;
   }

   public void setVar_tableau_selectionne(String var1) {
      this.var_tableau_selectionne = var1;
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

   public boolean isShowModalPanelDetailCalcul() {
      return this.showModalPanelDetailCalcul;
   }

   public void setShowModalPanelDetailCalcul(boolean var1) {
      this.showModalPanelDetailCalcul = var1;
   }

   public DataModel getDataModelEcrituresDetail() {
      return this.dataModelEcrituresDetail;
   }

   public void setDataModelEcrituresDetail(DataModel var1) {
      this.dataModelEcrituresDetail = var1;
   }

   public EcrituresBalance getEcrituresBalance() {
      return this.ecrituresBalance;
   }

   public void setEcrituresBalance(EcrituresBalance var1) {
      this.ecrituresBalance = var1;
   }

   public BsoTabFormule getCptTabFormule() {
      return this.cptTabFormule;
   }

   public void setCptTabFormule(BsoTabFormule var1) {
      this.cptTabFormule = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
