package com.epegase.forms.parc;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.LocalisationGps;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.dao.LocalisationGpsDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionParcs;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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

public class FormLocalisationGps implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private OptionParcs optionParcs;
   private ExercicesParc selectedExo;
   private ExercicesParc lastExo;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private FormRecherche formRecherche;
   private boolean var_acc_descriptif = false;
   private boolean var_acc_affectation = false;
   private boolean var_acc_etat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean var_aff_action = false;
   private boolean var_valide_parc = false;
   private List mesNatureItems;
   private List mesServiceItems;
   private List mesFamilleItems_rec;
   private String var_immat_rec = "";
   private String var_nature_rec = "";
   private String var_famille_rec = "";
   private String var_balise_rec = "";
   private String periode;
   private int var_type_rec = 0;
   private String var_service_rec = "";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private LocalisationGps localisationGps;
   private LocalisationGpsDao localisationGpsDao;
   private List lesLocalisation = new ArrayList();
   private transient DataModel dataModelocalisation = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private boolean var_affiche_mapper = false;
   private Parc parc;
   private ParcDao parcDao;
   private List lesParcs = new ArrayList();
   private List mesParcsItems = new ArrayList();
   private UtilTdt utilTdt = new UtilTdt();
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String requete;
   private String filtre;
   private String format = "PDF";
   private String nomModeleListe;
   private String impEmetteur;
   private String impDestinataire;
   private boolean showModalPanelPrint = false;
   public boolean showModalPanelMap = false;
   private URI uri;
   private String coordonnees;
   private String origine;
   private String legende;
   private EtatDocument etatDocument = new EtatDocument();

   public void InstancesDaoUtilses() {
      this.localisationGpsDao = new LocalisationGpsDao(this.baseLog, this.utilInitHibernate);
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException {
      if (this.optionParcs.getNbLigneMax() != null && !this.optionParcs.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionParcs.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.var_action = 0;
      this.lesParcs = this.parcDao.selectLesParcs(var1);
      if (this.lesParcs.size() != 0) {
         for(int var2 = 0; var2 < this.lesParcs.size(); ++var2) {
            this.parc = (Parc)this.lesParcs.get(var2);
            this.mesParcsItems.add(new SelectItem(this.parc.getPrcImmatriculation(), this.parc.getPrcImmatriculation() + " " + this.parc.getPrcLibFamille()));
         }
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
      }

   }

   public void rechercherLocalisation() throws HibernateException, NamingException, ParseException {
      this.rechercherLocalisation((Session)null);
   }

   public void rechercherLocalisation(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesLocalisation.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      String var2 = "";
      String var3 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var2 = null;
         var3 = null;
      }

      this.lesLocalisation = this.localisationGpsDao.rechercheLocalisationGps(this.selectedExo.getExeprcId(), this.periode, var2, var3, this.var_balise_rec, this.var_immat_rec, this.var_famille_rec, this.var_service_rec, var1);
      this.dataModelocalisation.setWrappedData(this.lesLocalisation);
      if (this.lesLocalisation.size() != 0) {
         this.var_affiche_mapper = true;
      } else {
         this.var_affiche_mapper = false;
      }

      this.legende = "";
      if (this.inpDu != null && this.inpAu != null) {
         String var4 = this.utilDate.dateToStringFr(this.inpDu);
         String var5 = this.utilDate.dateToStringFr(this.inpAu);
         this.legende = this.legende + " Du " + var4 + " au " + var5;
      } else if (this.periode.equals("100")) {
         this.legende = this.legende + " Toutes periodes";
      } else {
         this.legende = this.legende + " " + this.etatDocument.calculeLibellePeriode(this.periode);
      }

      if (this.var_balise_rec != null && !this.var_balise_rec.isEmpty()) {
         this.legende = this.legende + " Balise:" + this.var_balise_rec;
      }

      if (this.var_immat_rec != null && !this.var_immat_rec.isEmpty()) {
         this.legende = this.legende + " Immatriculation:" + this.var_immat_rec;
      }

      if (this.var_famille_rec != null && !this.var_famille_rec.isEmpty()) {
         this.legende = this.legende + " Famulle:" + this.var_famille_rec;
      }

      if (this.var_service_rec != null && !this.var_service_rec.isEmpty()) {
         this.legende = this.legende + " Service:" + this.var_service_rec;
      }

   }

   public void accesResteintGroupe() {
      this.var_acc_descriptif = false;
      this.var_acc_affectation = false;
      this.var_acc_etat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_descriptif = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_affectation = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_etat = true;
            }
         }
      }

   }

   public void autorisationDescription() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAffectation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("2")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationEtat() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("3")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void selectionLocalisation() throws HibernateException, NamingException {
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
            this.localisationGps = (LocalisationGps)var1.get(0);
            this.var_date = this.localisationGps.getLocgpsDate();
            if (this.localisationGps.getLocgpsDate().getHours() <= 9) {
               this.var_heure = "0" + this.localisationGps.getLocgpsDate().getHours();
            } else {
               this.var_heure = "" + this.localisationGps.getLocgpsDate().getHours();
            }

            if (this.localisationGps.getLocgpsDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.localisationGps.getLocgpsDate().getMinutes();
            } else {
               this.var_minute = "" + this.localisationGps.getLocgpsDate().getMinutes();
            }

            if (this.localisationGps.getLocgpsDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.localisationGps.getLocgpsDate().getSeconds();
            } else {
               this.var_seconde = "" + this.localisationGps.getLocgpsDate().getSeconds();
            }

            this.parc = this.localisationGps.getParc();
            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.localisationGps != null) {
         this.consulterLocalisation();
      }

   }

   public void ajouterLocalisation() throws HibernateException, NamingException {
      this.parc = new Parc();
      this.localisationGps = new LocalisationGps();
      this.var_date = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure = "0" + (new Date()).getHours();
      } else {
         this.var_heure = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde = "" + (new Date()).getSeconds();
      }

      this.var_action = 1;
      this.var_valide_parc = false;
      this.var_aff_action = false;
      this.var_memo_action = this.var_action;
   }

   public void modifierLocalisation() {
      if (this.localisationGps != null) {
         this.var_valide_parc = true;
         this.var_aff_action = false;
         this.var_action = 2;
         this.var_memo_action = this.var_action;
      }

   }

   public void consulterLocalisation() {
      if (this.localisationGps != null) {
         this.var_valide_parc = false;
         this.var_aff_action = true;
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerLocalisation() throws HibernateException, NamingException {
      if (this.localisationGps != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LocalisationParc");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.localisationGpsDao.delete(this.localisationGps);
            this.lesLocalisation.remove(this.localisationGps);
            this.dataModelocalisation.setWrappedData(this.lesLocalisation);
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

      this.var_affiche_bouton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annulerLocalisation() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.var_affiche_bouton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveLocalisation() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LocalisationParc");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.localisationGps.getLocgpsId() == 0L) {
            if (this.var_date == null) {
               this.var_date = new Date();
            }

            this.localisationGps.setLocgpsDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
            this.localisationGps.setExercicesParc(this.lastExo);
            this.localisationGps.setParc(this.parc);
            this.localisationGps = this.localisationGpsDao.insert(this.localisationGps, var1);
            this.lesLocalisation.add(this.localisationGps);
            this.dataModelocalisation.setWrappedData(this.lesLocalisation);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            this.localisationGps = this.localisationGpsDao.modif(this.localisationGps, var1);
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

      this.var_action = 0;
   }

   public void rechercheParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.parc = this.formRecherche.rechercheParc(this.parc.getPrcImmatriculation(), this.nature);
      if (this.parc != null) {
         if (this.parc.getPrcId() != 0L) {
            this.calculeParc();
         } else {
            this.var_action = 10;
         }
      } else if (this.parc == null) {
         this.calculeParc();
      }

   }

   public void recuperationParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.parc = this.formRecherche.calculeParc();
      this.calculeParc();
   }

   public void calculeParc() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.parc != null) {
         new Produits();
         if (this.parc.getPrcAlimentation() != 0 && this.parc.getPrcAlimentation() != 1 && this.parc.getPrcAlimentation() != 2 && this.parc.getPrcAlimentation() != 3 && this.parc.getPrcAlimentation() != 4 && this.parc.getPrcAlimentation() != 5 && this.parc.getPrcAlimentation() != 6 && this.parc.getPrcAlimentation() != 7 && this.parc.getPrcAlimentation() != 8 && this.parc.getPrcAlimentation() != 9 && this.parc.getPrcAlimentation() != 10 && this.parc.getPrcAlimentation() != 11 && this.parc.getPrcAlimentation() == 12) {
         }

         this.var_valide_parc = true;
      } else {
         this.parc = null;
         this.var_valide_parc = false;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleParc() {
      this.parc = null;
      this.var_action = 0;
      this.var_valide_parc = false;
   }

   public void traitementImortation(List var1) throws ParseException, NamingException {
      if (var1.size() != 0) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "LocalisationParc");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            String var4 = "";

            for(int var5 = 1; var5 < var1.size(); ++var5) {
               var4 = ((String)var1.get(var5)).toString();
               if (var4.contains(",")) {
                  String[] var6 = var4.split(",");
                  if (var6.length == 4) {
                     String var7 = var6[0];
                     String[] var8 = var6[1].split(" ");
                     String[] var9 = var8[0].split("-");
                     String var10 = "20" + var9[2];
                     String var11 = var9[1];
                     String var12 = var9[0];
                     String[] var13 = var8[1].split(":");
                     String var14 = var13[0];
                     String var15 = var13[1];
                     Date var16 = this.utilDate.stringToDateSQL(var10 + "-" + var11 + "-" + var12 + " " + var14 + ":" + var15 + ":00");
                     Date var17 = this.utilDate.stringToDateSQLLight(var10 + "-" + var11 + "-" + var12);
                     if (!this.localisationGpsDao.rechercheLocalisation(var10 + "-" + var11 + "-" + var12 + " " + var14 + ":" + var15 + ":00", var7, var2)) {
                        Float var18 = Float.parseFloat(var6[2]);
                        Float var19 = Float.parseFloat(var6[3]);
                        this.localisationGps = new LocalisationGps();
                        this.localisationGps.setExercicesParc(this.selectedExo);
                        if (this.lesParcs.size() != 0) {
                           boolean var20 = false;

                           for(int var21 = 0; var21 < this.lesParcs.size(); ++var21) {
                              this.parc = (Parc)this.lesParcs.get(var21);
                              if (this.parc.getPrcBalise() != null && !this.parc.getPrcBalise().isEmpty() && this.parc.getPrcBalise().equalsIgnoreCase(var7)) {
                                 var20 = true;
                                 break;
                              }
                           }

                           if (var20) {
                              this.localisationGps.setParc(this.parc);
                              this.localisationGps.setLocgpsBalise(var7);
                              this.localisationGps.setLocgpsDate(var16);
                              this.localisationGps.setLocgpsJour(var17);
                              this.localisationGps.setLocgpsLongitude(var18);
                              this.localisationGps.setLocgpsLatitude(var19);
                              this.localisationGps = this.localisationGpsDao.insert(this.localisationGps, var2);
                              this.lesLocalisation.add(this.localisationGps);
                           }
                        }
                     }
                  }
               }
            }

            this.dataModelocalisation.setWrappedData(this.lesLocalisation);
            var3.commit();
         } catch (HibernateException var25) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var25;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void caluleRoute() throws URISyntaxException {
      if (this.lesLocalisation.size() != 0) {
         UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
         this.coordonnees = var1.calculRouteMapBox(this.lesLocalisation);
         int var2 = this.lesLocalisation.size() - 1;
         this.origine = "[" + ((LocalisationGps)this.lesLocalisation.get(var2)).getLocgpsLongitude() + "," + ((LocalisationGps)this.lesLocalisation.get(var2)).getLocgpsLatitude() + "]";
         this.showModalPanelMap = true;
      }

   }

   public void fermerMapper() {
      this.showModalPanelMap = false;
   }

   public void initImpression() {
      this.affMail = false;
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
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

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
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
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && this.impDestinataire != null && !this.impDestinataire.isEmpty()) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (!this.format.equals("MAIL")) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des localisations");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "localisation" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(this.nature);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.lesLocalisation);
         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public ExercicesParc getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesParc var1) {
      this.lastExo = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
   }

   public ExercicesParc getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesParc var1) {
      this.selectedExo = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public List getMesNatureItems() {
      return this.mesNatureItems;
   }

   public void setMesNatureItems(List var1) {
      this.mesNatureItems = var1;
   }

   public List getMesServiceItems() {
      return this.mesServiceItems;
   }

   public void setMesServiceItems(List var1) {
      this.mesServiceItems = var1;
   }

   public DataModel getDataModelocalisation() {
      return this.dataModelocalisation;
   }

   public void setDataModelocalisation(DataModel var1) {
      this.dataModelocalisation = var1;
   }

   public LocalisationGps getLocalisationGps() {
      return this.localisationGps;
   }

   public void setLocalisationGps(LocalisationGps var1) {
      this.localisationGps = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public UtilDate getUtilDate() {
      return this.utilDate;
   }

   public void setUtilDate(UtilDate var1) {
      this.utilDate = var1;
   }

   public String getVar_famille_rec() {
      return this.var_famille_rec;
   }

   public void setVar_famille_rec(String var1) {
      this.var_famille_rec = var1;
   }

   public String getVar_immat_rec() {
      return this.var_immat_rec;
   }

   public void setVar_immat_rec(String var1) {
      this.var_immat_rec = var1;
   }

   public String getVar_nature_rec() {
      return this.var_nature_rec;
   }

   public void setVar_nature_rec(String var1) {
      this.var_nature_rec = var1;
   }

   public String getVar_service_rec() {
      return this.var_service_rec;
   }

   public void setVar_service_rec(String var1) {
      this.var_service_rec = var1;
   }

   public List getMesFamilleItems_rec() {
      return this.mesFamilleItems_rec;
   }

   public void setMesFamilleItems_rec(List var1) {
      this.mesFamilleItems_rec = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public boolean isVar_acc_affectation() {
      return this.var_acc_affectation;
   }

   public void setVar_acc_affectation(boolean var1) {
      this.var_acc_affectation = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
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

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
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

   public int getVar_type_rec() {
      return this.var_type_rec;
   }

   public void setVar_type_rec(int var1) {
      this.var_type_rec = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public String getVar_heure() {
      return this.var_heure;
   }

   public void setVar_heure(String var1) {
      this.var_heure = var1;
   }

   public String getVar_minute() {
      return this.var_minute;
   }

   public void setVar_minute(String var1) {
      this.var_minute = var1;
   }

   public String getVar_seconde() {
      return this.var_seconde;
   }

   public void setVar_seconde(String var1) {
      this.var_seconde = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isVar_valide_parc() {
      return this.var_valide_parc;
   }

   public void setVar_valide_parc(boolean var1) {
      this.var_valide_parc = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public String getVar_balise_rec() {
      return this.var_balise_rec;
   }

   public void setVar_balise_rec(String var1) {
      this.var_balise_rec = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isShowModalPanelMap() {
      return this.showModalPanelMap;
   }

   public void setShowModalPanelMap(boolean var1) {
      this.showModalPanelMap = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public String getCoordonnees() {
      return this.coordonnees;
   }

   public void setCoordonnees(String var1) {
      this.coordonnees = var1;
   }

   public String getOrigine() {
      return this.origine;
   }

   public void setOrigine(String var1) {
      this.origine = var1;
   }

   public boolean isVar_affiche_mapper() {
      return this.var_affiche_mapper;
   }

   public void setVar_affiche_mapper(boolean var1) {
      this.var_affiche_mapper = var1;
   }

   public String getLegende() {
      return this.legende;
   }

   public void setLegende(String var1) {
      this.legende = var1;
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
