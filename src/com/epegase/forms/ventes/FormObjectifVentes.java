package com.epegase.forms.ventes;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersObjectifs;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersObjectifsDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.OptionTiers;
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

public class FormObjectifVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionTiers optionTiers;
   private int var_action;
   private String pageIndex;
   private ObjetLigneMenu ligneMenu;
   private Users users;
   private UserDao userDao;
   private UsersObjectifs usersObjectifs;
   private UsersObjectifsDao usersObjectifsDao;
   private List userList = new ArrayList();
   private ExercicesVentes exercicesVentes;
   private transient DataModel dataModelUser = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private LireLesoptionsTiers lireLesOptionsTiers;
   private boolean afficheButtOption = false;
   private boolean showModalPanelObjectif = false;
   private int var_nb_max = 100;
   private List lesUsersObjectifs = new ArrayList();
   private transient DataModel dataModelObjectif = new ListDataModel();
   private String anneeRec;
   private String serviceRec;
   private int choixRec = 0;
   private List anneeItems = new ArrayList();
   private List serviceItems = new ArrayList();
   private UtilPrint utilPrint;
   private List lesmodelesImpressions = new ArrayList();
   private boolean affMail = false;
   private String nomModeleListe;
   private String format = "PDF";
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private boolean visibleOptionMail = false;
   private boolean showModalPanelPrint = false;

   public FormObjectifVentes() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersObjectifsDao = new UsersObjectifsDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptionsTiers(Session var1) throws NamingException {
      this.lireLesOptionsTiers = new LireLesoptionsTiers();
      this.lireLesOptionsTiers.setStrId(this.structureLog.getStrid());
      this.lireLesOptionsTiers.lancer();
      this.optionTiers = this.lireLesOptionsTiers.getOptionTiers();
      if (this.optionTiers.getNbLigneMaxTi() != null && !this.optionTiers.getNbLigneMaxTi().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxTi());
      } else {
         this.var_nb_max = 100;
      }

      this.exercicesVentes = new ExercicesVentes();
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var2.recupererLastExo(var1);
   }

   public void chargerAnnees(Session var1) throws IOException, HibernateException, NamingException {
      this.anneeItems.clear();
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectExercicesVentes(var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.anneeItems.add(new SelectItem(((ExercicesVentes)var3.get(var4)).getExevteId()));
         }

         this.anneeRec = "" + this.exercicesVentes.getExevteId();
      }

   }

   public void chargerServices(Session var1) throws HibernateException, NamingException {
      this.serviceItems.clear();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.serviceItems = var2.chargerLesServicesItems(0, false, var1);
   }

   public void chargerLesAgents() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Objectifs");
      new ArrayList();
      new ArrayList();
      List var2 = this.userDao.chargerByRequete(this.rechercherAgents(), var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            this.users = (Users)var2.get(var4);
            List var3 = this.usersObjectifsDao.chargerUsersObjectifs(this.users, this.anneeRec, var1);
            if (var3.size() != 0) {
               for(int var5 = 0; var5 < var3.size(); ++var5) {
                  this.usersObjectifs = (UsersObjectifs)var3.get(var5);
                  if (this.usersObjectifs.getUsrobjNature() == 21) {
                     this.users.setObjectifDevis(this.usersObjectifs.getUsrobjCaTotal());
                  } else if (this.usersObjectifs.getUsrobjNature() == 22) {
                     this.users.setObjectifBc(this.usersObjectifs.getUsrobjCaTotal());
                  } else if (this.usersObjectifs.getUsrobjNature() == 23) {
                     this.users.setObjectifBl(this.usersObjectifs.getUsrobjCaTotal());
                  } else if (this.usersObjectifs.getUsrobjNature() == 24) {
                     this.users.setObjectifBr(this.usersObjectifs.getUsrobjCaTotal());
                  } else if (this.usersObjectifs.getUsrobjNature() == 25) {
                     this.users.setObjectifFacture(this.usersObjectifs.getUsrobjCaTotal());
                  } else if (this.usersObjectifs.getUsrobjNature() == 26) {
                     this.users.setObjectifNdb(this.usersObjectifs.getUsrobjCaTotal());
                  } else if (this.usersObjectifs.getUsrobjNature() == 27) {
                     this.users.setObjectifAvoir(this.usersObjectifs.getUsrobjCaTotal());
                  } else if (this.usersObjectifs.getUsrobjNature() == 2) {
                     this.users.setObjectifRdv(this.usersObjectifs.getUsrobjCaTotal());
                  }
               }
            }

            this.users.setObjectifAnnee(this.anneeRec);
            this.userList.add(this.users);
         }
      }

      this.dataModelUser.setWrappedData(this.userList);
      this.afficheButtOption = false;
      this.utilInitHibernate.closeSession();
   }

   public String rechercherAgents() {
      String var1 = "from Users where usrSysteme<=3 and usrEtat=1";
      var1 = var1 + " and usrVendeur=1";
      if (!this.serviceRec.equals("100")) {
         var1 = var1 + " and usrService='" + this.serviceRec + "'";
      }

      return var1;
   }

   public void selectionAgents() throws HibernateException, NamingException {
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
            this.users = (Users)var1.get(0);
            ArrayList var8 = new ArrayList();
            var8.add(2);
            var8.add(21);
            var8.add(22);
            var8.add(23);
            var8.add(24);
            var8.add(25);
            var8.add(26);
            var8.add(27);
            this.lesUsersObjectifs.clear();
            this.lesUsersObjectifs = this.usersObjectifsDao.chargerUsersObjectifs(this.users, this.anneeRec, (Session)null);

            for(int var4 = 0; var4 < var8.size(); ++var4) {
               int var5 = Integer.parseInt(((Integer)var8.get(var4)).toString());
               if (this.lesUsersObjectifs.size() == 0) {
                  this.usersObjectifs = new UsersObjectifs();
                  this.usersObjectifs.setUsrobjAnnee(this.anneeRec);
                  this.usersObjectifs.setUsrobjNature(var5);
                  this.usersObjectifs.setUsers(this.users);
                  this.lesUsersObjectifs.add(this.usersObjectifs);
               } else {
                  boolean var6 = false;

                  for(int var7 = 0; var7 < this.lesUsersObjectifs.size(); ++var7) {
                     if (((UsersObjectifs)this.lesUsersObjectifs.get(var7)).getUsrobjNature() == var5) {
                        var6 = true;
                        break;
                     }
                  }

                  if (!var6) {
                     this.usersObjectifs = new UsersObjectifs();
                     this.usersObjectifs.setUsrobjAnnee(this.anneeRec);
                     this.usersObjectifs.setUsrobjNature(var5);
                     this.usersObjectifs.setUsers(this.users);
                     this.lesUsersObjectifs.add(this.usersObjectifs);
                  }
               }
            }

            this.dataModelObjectif.setWrappedData(this.lesUsersObjectifs);
            this.afficheButtOption = true;
         } else {
            this.afficheButtOption = false;
         }
      } else {
         this.afficheButtOption = false;
      }

   }

   public void visualisationAgents() {
      if (this.users != null) {
         this.consulterObjectif();
      }

   }

   public void modifierObjectif() {
      if (this.users != null) {
         this.var_action = 1;
         this.showModalPanelObjectif = true;
      }

   }

   public void consulterObjectif() {
      if (this.users != null) {
         this.var_action = 3;
         this.showModalPanelObjectif = true;
      }

   }

   public void selectionObjectif() {
      if (this.dataModelObjectif.isRowAvailable()) {
         this.usersObjectifs = (UsersObjectifs)this.dataModelObjectif.getRowData();
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.usersObjectifs != null) {
         this.consulterObjectif();
      }

   }

   public void fermerObjectif() {
      this.showModalPanelObjectif = false;
   }

   public void validerObjectif() throws HibernateException, NamingException {
      if (this.lesUsersObjectifs.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Objectifs");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            double var3 = 0.0D;
            double var5 = 0.0D;
            double var7 = 0.0D;
            double var9 = 0.0D;
            double var11 = 0.0D;
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;

            for(int var19 = 0; var19 < this.lesUsersObjectifs.size(); ++var19) {
               this.usersObjectifs = (UsersObjectifs)this.lesUsersObjectifs.get(var19);
               if (this.usersObjectifs.getUsrobjCaTotal() != 0.0D) {
                  if (this.usersObjectifs.getUsrobjId() == 0L) {
                     this.usersObjectifs.setUsrobjDateCreat(new Date());
                     this.usersObjectifs.setUsrobjUserCreat(this.usersLog.getUsrid());
                     this.usersObjectifs = this.usersObjectifsDao.insert(this.usersObjectifs, var1);
                  } else {
                     this.usersObjectifs.setUsrobjDateModif(new Date());
                     this.usersObjectifs.setUsrobjUserModif(this.usersLog.getUsrid());
                     this.usersObjectifs = this.usersObjectifsDao.modif(this.usersObjectifs, var1);
                  }

                  if (this.usersObjectifs.getUsrobjNature() == 21) {
                     var3 += this.usersObjectifs.getUsrobjCaTotal();
                  } else if (this.usersObjectifs.getUsrobjNature() == 22) {
                     var5 += this.usersObjectifs.getUsrobjCaTotal();
                  } else if (this.usersObjectifs.getUsrobjNature() == 23) {
                     var7 += this.usersObjectifs.getUsrobjCaTotal();
                  } else if (this.usersObjectifs.getUsrobjNature() == 24) {
                     var9 += this.usersObjectifs.getUsrobjCaTotal();
                  } else if (this.usersObjectifs.getUsrobjNature() == 25) {
                     var11 += this.usersObjectifs.getUsrobjCaTotal();
                  } else if (this.usersObjectifs.getUsrobjNature() == 26) {
                     var13 += this.usersObjectifs.getUsrobjCaTotal();
                  } else if (this.usersObjectifs.getUsrobjNature() == 27) {
                     var15 += this.usersObjectifs.getUsrobjCaTotal();
                  } else if (this.usersObjectifs.getUsrobjNature() == 2) {
                     var17 += this.usersObjectifs.getUsrobjCaTotal();
                  }
               }
            }

            this.users.setObjectifDevis(var3);
            this.users.setObjectifBc(var5);
            this.users.setObjectifBl(var7);
            this.users.setObjectifBr(var9);
            this.users.setObjectifFacture(var11);
            this.users.setObjectifNdb(var13);
            this.users.setObjectifAvoir(var15);
            this.users.setObjectifRdv(var17);
            var2.commit();
         } catch (HibernateException var23) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelObjectif = false;
   }

   public void calculTotal() {
      if (this.usersObjectifs != null) {
         double var1 = this.usersObjectifs.getUsrobjCa01() + this.usersObjectifs.getUsrobjCa02() + this.usersObjectifs.getUsrobjCa03() + this.usersObjectifs.getUsrobjCa04() + this.usersObjectifs.getUsrobjCa05() + this.usersObjectifs.getUsrobjCa06() + this.usersObjectifs.getUsrobjCa07() + this.usersObjectifs.getUsrobjCa08() + this.usersObjectifs.getUsrobjCa09() + this.usersObjectifs.getUsrobjCa10() + this.usersObjectifs.getUsrobjCa11() + this.usersObjectifs.getUsrobjCa12();
         this.usersObjectifs.setUsrobjCaTotal(var1);
      }

   }

   public void recupererModeleListe() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "objectif" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesmodelesImpressions = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.lesmodelesImpressions.add(new SelectItem(var5));
            }
         }
      }

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

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.visibleOptionMail = false;
      this.affMail = false;
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
      if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des objectifs");
         this.utilPrint.setRequete("");
         this.utilPrint.setFiltre("");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "objectif" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.userList);
         this.utilPrint.setjRBeanCollectionDataSource(var1);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isAfficheButtOption() {
      return this.afficheButtOption;
   }

   public void setAfficheButtOption(boolean var1) {
      this.afficheButtOption = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public ObjetLigneMenu getLigneMenu() {
      return this.ligneMenu;
   }

   public void setLigneMenu(ObjetLigneMenu var1) {
      this.ligneMenu = var1;
   }

   public DataModel getDataModelUser() {
      return this.dataModelUser;
   }

   public void setDataModelUser(DataModel var1) {
      this.dataModelUser = var1;
   }

   public List getLesmodelesImpressions() {
      return this.lesmodelesImpressions;
   }

   public void setLesmodelesImpressions(List var1) {
      this.lesmodelesImpressions = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
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

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
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

   public String getServiceRec() {
      return this.serviceRec;
   }

   public void setServiceRec(String var1) {
      this.serviceRec = var1;
   }

   public List getServiceItems() {
      return this.serviceItems;
   }

   public void setServiceItems(List var1) {
      this.serviceItems = var1;
   }

   public List getAnneeItems() {
      return this.anneeItems;
   }

   public void setAnneeItems(List var1) {
      this.anneeItems = var1;
   }

   public String getAnneeRec() {
      return this.anneeRec;
   }

   public void setAnneeRec(String var1) {
      this.anneeRec = var1;
   }

   public boolean isShowModalPanelObjectif() {
      return this.showModalPanelObjectif;
   }

   public void setShowModalPanelObjectif(boolean var1) {
      this.showModalPanelObjectif = var1;
   }

   public UsersObjectifs getUsersObjectifs() {
      return this.usersObjectifs;
   }

   public void setUsersObjectifs(UsersObjectifs var1) {
      this.usersObjectifs = var1;
   }

   public int getChoixRec() {
      return this.choixRec;
   }

   public void setChoixRec(int var1) {
      this.choixRec = var1;
   }

   public DataModel getDataModelObjectif() {
      return this.dataModelObjectif;
   }

   public void setDataModelObjectif(DataModel var1) {
      this.dataModelObjectif = var1;
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
