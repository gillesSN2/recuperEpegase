package com.epegase.forms.accueil;

import com.epegase.systeme.classe.ConsultationInfirmerie;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.GroupeFavoris;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.ReunionPresence;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ConsultationInfirmerieDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.GroupeFavorisDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.ReunionPresenceDao;
import com.epegase.systeme.dao.SalariesCongesDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesGrhDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersFavorisDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureInfirmerieVaccin;
import com.epegase.systeme.xml.LectureNatureRdv;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetMessageSysteme;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormAccueil implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private int typePlateForme;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int typeSaisie;
   private String pageIndex;
   private TachesDao tachesDao;
   private String choixTache;
   private Rdv rdv = new Rdv();
   private boolean showModalPanelRdv = false;
   private transient DataModel datamodelRdv = new ListDataModel();
   private List listRdv = new ArrayList();
   private boolean afficheRdv = false;
   private int typeRdv;
   private boolean rdvdetails;
   private String refCollaborateur;
   private RdvDao rdvDao;
   private boolean showModalPanelRdvFait = false;
   private List mesNaturesRdvItems = new ArrayList();
   private List mesNaturesTodoItems = new ArrayList();
   private boolean showModalPanelTodo = false;
   private transient DataModel datamodelTdo = new ListDataModel();
   private List listToDo = new ArrayList();
   private boolean afficheTodo = false;
   private String mailTiers;
   private String telTiers;
   private UtilDownload utilDownload = new UtilDownload();
   private ObjetMessageSysteme objetMessageSysteme;
   private List listRepertoire = new ArrayList();
   private transient DataModel dataModelRepertoire = new ListDataModel();
   private String nomRepertoire;
   private String nomFichier;
   private int niveau = 0;
   private String repNiveau1;
   private String repNiveau2;
   private String repNiveau3;
   private String repNiveau4;
   private String repNiveau5;
   private String repNiveau6;
   private String repNiveau7;
   private String repNiveau8;
   private String repNiveau9;
   private String repNiveau10;
   private boolean fichier = false;
   private boolean showModalPanelAjoutFile = false;
   private UploadedFile uploadedFile;
   private GroupeFavorisDao groupeFavorisDao;
   private GroupeFavoris groupeFavoris = new GroupeFavoris();
   private List lesGroupesFavoris = new ArrayList();
   private boolean memoAjout;
   private boolean memoModif;
   private boolean memoSupp;
   private URL fichierUrl;
   private String fichierCode;
   private String fichierMine;
   private URL repertoireUrl;
   private String repertoireString;
   private boolean viewerPdf = false;
   private String adresseTelechargement;
   private transient DataModel datamodelFavoris = new ListDataModel();
   private transient DataModel datamodelAnniv = new ListDataModel();
   private boolean showModalPanelTiers = false;
   private transient DataModel datamodelTiers = new ListDataModel();
   private List lesTiers;
   private Tiers tiers;
   private TiersDao tiersDao;
   private boolean gestionPatient;
   private boolean showModalPanelPatients = false;
   private transient DataModel datamodelPatients = new ListDataModel();
   private List lesPatients;
   private Patients patients;
   private PatientsDao patientsDao;
   private Salaries salaries;
   private SalariesDao salariesDao;

   public FormAccueil() throws UnknownHostException {
   }

   public void InstancesDaoUtilses() {
      this.rdvDao = new RdvDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.groupeFavorisDao = new GroupeFavorisDao(this.baseLog, this.utilInitHibernate);
   }

   public void accueil(Session var1, String var2, int var3) throws HibernateException, NamingException, IOException, ParseException {
      this.urlExplorateur = var2;
      this.typePlateForme = var3;
      this.listRdv.clear();
      this.listRdv = this.rdvDao.selectRdvEnCours(this.usersLog.getUsrid(), var1);
      this.datamodelRdv.setWrappedData(this.listRdv);
      this.listToDo.clear();
      this.listToDo = this.rdvDao.selectTdo(this.usersLog.getUsrid(), var1);
      new ArrayList();
      ReunionPresenceDao var5 = new ReunionPresenceDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.selectReunion(this.usersLog.getUsrid(), var1);
      if (var4.size() != 0) {
         new ReunionPresence();

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            this.rdv = new Rdv();
            ReunionPresence var6 = (ReunionPresence)var4.get(var7);
            this.rdv.setRdvNature(8);
            this.rdv.setRdvDteDe(var6.getReunionEntete().getReuDate());
            if (var6.getReunionEntete().getReuLieu() != null && !var6.getReunionEntete().getReuLieu().isEmpty()) {
               this.rdv.setRdvSujet("Réunion " + var6.getReunionEntete().getReuObject() + " à " + var6.getReunionEntete().getReuHeureDeb() + ":" + var6.getReunionEntete().getReuMinuteDeb() + " à " + var6.getReunionEntete().getReuLieu());
            } else {
               this.rdv.setRdvSujet("Réunion " + var6.getReunionEntete().getReuObject() + " à " + var6.getReunionEntete().getReuHeureDeb() + ":" + var6.getReunionEntete().getReuMinuteDeb());
            }

            this.rdv.setRdvDescript(var6.getReunionEntete().getReuIntroduction());
            this.listToDo.add(this.rdv);
         }
      }

      this.datamodelTdo.setWrappedData(this.listToDo);
      this.niveau = 0;
      this.nomRepertoire = "Internes";
      this.nomFichier = "";
      this.lesGroupesFavoris = this.groupeFavorisDao.selectGroupe(this.usersLog.getGroupe(), var1);
      String var23 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "commun" + File.separator + "accueil";
      this.adresseTelechargement = this.urlExplorateur + "epegase" + File.separator + "clients" + File.separator + this.baseLog + File.separator + "commun" + File.separator + "accueil";
      this.lectureDossierAccueil(var23);
      UsersFavorisDao var24 = new UsersFavorisDao(this.baseLog, this.utilInitHibernate);
      this.datamodelFavoris.setWrappedData(var24.chargerUsersSites(this.usersLog, var1));
      UtilDate var8 = new UtilDate();
      new ObjetMessageSysteme();
      ArrayList var10 = new ArrayList();
      new ArrayList();
      List var11 = this.tiersDao.selectTiersAnniv(var1);
      ObjetMessageSysteme var9;
      if (var11.size() != 0) {
         for(int var12 = 0; var12 < var11.size(); ++var12) {
            var9 = new ObjetMessageSysteme();
            var9.setCat("TIERS");
            if (((Tiers)var11.get(var12)).getTieanniversairemariage() != null && !((Tiers)var11.get(var12)).getTieanniversairemariage().isEmpty()) {
               var9.setAnniv("/images/anniv_mariage.png");
            } else if (((Tiers)var11.get(var12)).getTieanniversairedeces() != null && !((Tiers)var11.get(var12)).getTieanniversairedeces().isEmpty()) {
               var9.setAnniv("/images/anniv_deces.png");
            } else {
               var9.setAnniv("/images/anniv_naissance.png");
            }

            var9.setTexte(((Tiers)var11.get(var12)).getTieraisonsocialenom());
            var9.setActif(((Tiers)var11.get(var12)).getTieburtel1());
            var10.add(var9);
         }
      }

      new ArrayList();
      ContactDao var13 = new ContactDao(this.baseLog, this.utilInitHibernate);
      List var25 = var13.selectContactsAnniv(var1);
      if (var25.size() != 0) {
         for(int var14 = 0; var14 < var25.size(); ++var14) {
            var9 = new ObjetMessageSysteme();
            var9.setCat("CONT.");
            var9.setAnniv("/images/anniv_naissance.png");
            var9.setTexte(((Contacts)var25.get(var14)).getConnom() + " " + ((Contacts)var25.get(var14)).getConprenom());
            var9.setActif(((Contacts)var25.get(var14)).getContelbur());
            var10.add(var9);
         }
      }

      new ArrayList();
      UserDao var15 = new UserDao(this.baseLog, this.utilInitHibernate);
      List var26 = var15.selectUsersAnniv(var1);
      if (var26.size() != 0) {
         for(int var16 = 0; var16 < var26.size(); ++var16) {
            var9 = new ObjetMessageSysteme();
            var9.setCat("USER");
            var9.setAnniv("/images/anniv_naissance.png");
            var9.setTexte(((Users)var26.get(var16)).getUsrNom() + " " + ((Users)var26.get(var16)).getUsrPrenom());
            var9.setActif(((Users)var26.get(var16)).getUsrTelBureau());
            var10.add(var9);
         }
      }

      Date var18;
      Date var19;
      int var20;
      List var27;
      if (this.usersLog.getUsrPayeAlerte() == 1 || this.usersLog.getUsrPayeAlerte() == 99) {
         new ArrayList();
         SalariesContratsDao var17 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         var18 = var8.datePremierJourMois(var8.dateEcheanceArrondi(new Date(), 60));
         var19 = var8.dateDernierJourMois(var8.dateEcheanceArrondi(new Date(), 60));
         var27 = var17.listelesContratsPeremption(var18, var19, var1);
         if (var27.size() != 0) {
            for(var20 = 0; var20 < var27.size(); ++var20) {
               var9 = new ObjetMessageSysteme();
               var9.setCat("CONTRAT");
               var9.setAnniv("/images/fichier_word.png");
               var9.setTexte(((SalariesContrats)var27.get(var20)).getSalaries().getPatronyme() + " au " + var8.dateToStringFr(((SalariesContrats)var27.get(var20)).getSalconDateFin()));
               var9.setActif("N° " + ((SalariesContrats)var27.get(var20)).getSalconNum());
               var10.add(var9);
            }
         }
      }

      int var31;
      if (this.usersLog.getUsrPayeAlerte() == 2 || this.usersLog.getUsrPayeAlerte() == 99) {
         new ArrayList();
         SalariesCongesDao var28 = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
         var27 = var28.chargerToutesDemandes(var1);
         if (var27.size() != 0) {
            for(var31 = 0; var31 < var27.size(); ++var31) {
               var9 = new ObjetMessageSysteme();
               if (((SalariesConges)var27.get(var31)).getSalcngNature() == 10) {
                  var9.setCat("DEMANDE");
                  var9.setAnniv("/images/fichier_word.png");
                  var9.setTexte("(Demande absence) " + ((SalariesConges)var27.get(var31)).getSalaries().getPatronyme() + " du " + var8.dateToStringFr(((SalariesConges)var27.get(var31)).getSalcngDateDebut()) + " au " + var8.dateToStringFr(((SalariesConges)var27.get(var31)).getSalcngDateFin()));
                  var9.setActif("");
                  var10.add(var9);
               } else if (((SalariesConges)var27.get(var31)).getSalcngNature() == 0) {
                  var9.setCat("DEMANDE");
                  var9.setAnniv("/images/fichier_word.png");
                  var9.setTexte("(Demande congés) " + ((SalariesConges)var27.get(var31)).getSalaries().getPatronyme() + " au " + var8.dateToStringFr(((SalariesConges)var27.get(var31)).getSalcngDateDebut()) + " au " + var8.dateToStringFr(((SalariesConges)var27.get(var31)).getSalcngDateFin()));
                  var9.setActif("");
                  var10.add(var9);
               }
            }
         }
      }

      if (this.usersLog.getUsrPayeAlerte() == 3 || this.usersLog.getUsrPayeAlerte() == 99) {
         new ArrayList();
         Date var29 = var8.datePremierJourMois(var8.dateEcheanceArrondi(new Date(), 60));
         var18 = var8.dateDernierJourMois(var8.dateEcheanceArrondi(new Date(), 60));
         SalariesGrhDao var35 = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
         var27 = var35.chargerlesElementRhAlerte(var29, var18, var1);
         if (var27.size() != 0) {
            for(var20 = 0; var20 < var27.size(); ++var20) {
               var9 = new ObjetMessageSysteme();
               if (((SalariesGrh)var27.get(var20)).getSalgrhType() == 11) {
                  var9.setCat("DOTATION");
                  var9.setAnniv("/images/dot_equip.png");
                  var9.setTexte("(Dotation équipement) " + ((SalariesGrh)var27.get(var20)).getSalaries().getPatronyme() + " du " + var8.dateToStringFr(((SalariesGrh)var27.get(var20)).getSalgrhDateAlerte()));
                  var9.setActif("");
                  var10.add(var9);
               } else if (((SalariesGrh)var27.get(var20)).getSalgrhType() == 12) {
                  var9.setCat("DOTATION");
                  var9.setAnniv("/images/dot_mobilier.png");
                  var9.setTexte("(Dotation mobilier) " + ((SalariesGrh)var27.get(var20)).getSalaries().getPatronyme() + " au " + var8.dateToStringFr(((SalariesGrh)var27.get(var20)).getSalgrhDateAlerte()));
                  var9.setActif("");
                  var10.add(var9);
               } else if (((SalariesGrh)var27.get(var20)).getSalgrhType() == 25) {
                  var9.setCat("RENOUVELLEMENT");
                  var9.setAnniv("/images/ren_doc.png");
                  var9.setTexte("(Renouvellement document) " + ((SalariesGrh)var27.get(var20)).getSalaries().getPatronyme() + " au " + var8.dateToStringFr(((SalariesGrh)var27.get(var20)).getSalgrhDateAlerte()));
                  var9.setActif("");
                  var10.add(var9);
               } else if (((SalariesGrh)var27.get(var20)).getSalgrhType() == 28) {
                  var9.setCat("VISITE MEDICALE");
                  var9.setAnniv("/images/vis_med.png");
                  var9.setTexte("(Visite médicale) " + ((SalariesGrh)var27.get(var20)).getSalaries().getPatronyme() + " au " + var8.dateToStringFr(((SalariesGrh)var27.get(var20)).getSalgrhDateAlerte()));
                  var9.setActif("");
                  var10.add(var9);
               }
            }
         }
      }

      if (this.usersLog.getUsrParcAlerte() != 1 && this.usersLog.getUsrParcAlerte() == 99) {
      }

      if (this.usersLog.getUsrParcAlerte() == 2 || this.usersLog.getUsrParcAlerte() == 99) {
         new ArrayList();
         ParcDao var30 = new ParcDao(this.baseLog, this.utilInitHibernate);
         var27 = var30.selectAchatsAnniv(var1);
         if (var27.size() != 0) {
            for(var31 = 0; var31 < var27.size(); ++var31) {
               var9 = new ObjetMessageSysteme();
               var9.setCat("PARC");
               var9.setAnniv("/images/anniv_achat.png");
               var9.setTexte(((Parc)var27.get(var31)).getPrcNomTiers());
               var9.setActif(((Parc)var27.get(var31)).getPrcImmatriculation());
               var10.add(var9);
            }
         }
      }

      if (this.usersLog.getUsrMedicalAlerte() == 1 || this.usersLog.getUsrMedicalAlerte() == 99) {
         new ArrayList();
         ConsultationInfirmerieDao var32 = new ConsultationInfirmerieDao(this.baseLog, this.utilInitHibernate);
         var18 = var8.datePremierJourMois(var8.dateEcheanceArrondi(new Date(), 30));
         var19 = var8.dateDernierJourMois(var8.dateEcheanceArrondi(new Date(), 30));
         var27 = var32.chargerLesVaccinsPerimes(var18, var19, var1);
         if (var27.size() != 0) {
            LectureInfirmerieVaccin var36 = new LectureInfirmerieVaccin();
            List var21 = var36.getMesElements();

            for(int var22 = 0; var22 < var27.size(); ++var22) {
               var9 = new ObjetMessageSysteme();
               var9.setCat("VACCIN");
               var9.setAnniv("/images/anniv_vaccin.png");
               var9.setTexte(((ConsultationInfirmerie)var27.get(var22)).getConsultationEnteteGene().getCsgMatricule() + " " + ((ConsultationInfirmerie)var27.get(var22)).getConsultationEnteteGene().getCsgNomPatient());
               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte1() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte1().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte1().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(0)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte2() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte2().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte2().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(1)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte3() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte3().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte3().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(2)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte4() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte4().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte4().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(3)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte5() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte5().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte5().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(4)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte6() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte6().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte6().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(5)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte7() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte7().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte7().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(6)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte8() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte8().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte8().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(7)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte9() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte9().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte9().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(8)).getNom_FR());
               }

               if (((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte10() != null && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte10().compareTo(var18) >= 0 && ((ConsultationInfirmerie)var27.get(var22)).getCslaccLotDte10().compareTo(var19) <= 0) {
                  var9.setActif(((ObjetCompte)var21.get(9)).getNom_FR());
               }

               var10.add(var9);
            }
         }
      }

      this.datamodelAnniv.setWrappedData(var10);
      this.afficheRdv = false;
      if (this.typeVente == 815) {
         this.gestionPatient = true;
      } else {
         this.gestionPatient = false;
      }

      this.mesNaturesRdvItems.clear();
      this.mesNaturesTodoItems.clear();
      LectureNatureRdv var33 = new LectureNatureRdv(this.baseLog);
      new ArrayList();
      List var34 = var33.getMesNatureRdvUtil();

      for(var31 = 0; var31 < var34.size(); ++var31) {
         if (((ObjetCompte)var34.get(var31)).isValide()) {
            this.mesNaturesRdvItems.add(new SelectItem(((ObjetCompte)var34.get(var31)).getCode(), ((ObjetCompte)var34.get(var31)).getCode() + ":" + ((ObjetCompte)var34.get(var31)).getNom_FR()));
            if (((ObjetCompte)var34.get(var31)).getCode().equals("0") || ((ObjetCompte)var34.get(var31)).getCode().equals("2") || ((ObjetCompte)var34.get(var31)).getCode().equals("10")) {
               this.mesNaturesRdvItems.add(new SelectItem(((ObjetCompte)var34.get(var31)).getCode(), ((ObjetCompte)var34.get(var31)).getCode() + ":" + ((ObjetCompte)var34.get(var31)).getNom_FR()));
            }
         }
      }

      if (this.mesNaturesRdvItems == null || this.mesNaturesRdvItems.size() == 0) {
         this.mesNaturesRdvItems.add(new SelectItem("1", "1:Rdv (défaut)"));
      }

      if (this.mesNaturesTodoItems == null || this.mesNaturesTodoItems.size() == 0) {
         this.mesNaturesTodoItems.add(new SelectItem("2", "2:To Do (défaut)"));
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void selectionRdv() throws HibernateException, NamingException {
      if (this.datamodelRdv.isRowAvailable()) {
         this.rdv = (Rdv)this.datamodelRdv.getRowData();
         this.refCollaborateur = "" + this.rdv.getRdvUsrDe();
         this.afficheRdv = true;
      }

   }

   public void consulterRdv() {
      if (this.rdv != null) {
         this.rdvdetails = true;
         this.choixTypeRdv();
         this.typeSaisie = 0;
         this.showModalPanelRdv = true;
      }

   }

   public void selectionTodo() throws HibernateException, NamingException {
      if (this.datamodelTdo.isRowAvailable()) {
         this.rdv = (Rdv)this.datamodelTdo.getRowData();
         if (this.rdv.getRdvNature() != 0 && this.rdv.getRdvNature() != 2 && this.rdv.getRdvNature() != 3 && this.rdv.getRdvNature() != 10) {
            this.afficheTodo = false;
         } else {
            this.afficheTodo = true;
         }
      }

   }

   public void ajouterTodo() {
      this.tiers = new Tiers();
      this.patients = new Patients();
      this.rdv = new Rdv();
      this.rdv.setRdvDteDe(new Date());
      this.rdv.setRdvNature(2);
      this.choixTypeRdv();
      this.refCollaborateur = "0";
      this.showModalPanelTodo = true;
      this.rdvdetails = false;
      this.typeSaisie = 0;
   }

   public void consulterTodo() throws HibernateException, NamingException {
      if (this.rdv != null) {
         this.rdvdetails = true;
         this.typeRdv = 2;
         this.typeSaisie = 1;
         this.mailTiers = "";
         this.telTiers = "";
         if (this.rdv.getRdvTieIdDe() != 0L) {
            this.tiers = this.tiersDao.selectTierD(this.rdv.getRdvTieIdDe());
            if (this.tiers != null) {
               this.mailTiers = this.tiers.getTiemail1();
               if (this.tiers.getTieburtel1() != null && !this.tiers.getTieburtel1().isEmpty()) {
                  this.telTiers = this.tiers.getTieburtel1();
               }

               if (this.tiers.getTiecel1() != null && !this.tiers.getTiecel1().isEmpty()) {
                  this.telTiers = this.telTiers + " " + this.tiers.getTiecel1();
               }
            }
         } else if (this.rdv.getRdvPatIdDe() != 0L) {
            this.patients = this.patientsDao.getPatientsById(this.rdv.getRdvPatIdDe());
            if (this.patients != null) {
               this.mailTiers = this.patients.getPatMail1();
               this.telTiers = this.patients.getPatBurTel1();
            }
         } else if (this.rdv.getRdvSalIdDe() != 0L) {
            this.salaries = this.salariesDao.chercherIdSalaries(this.rdv.getRdvSalIdDe(), (Session)null);
            if (this.salaries != null) {
               this.mailTiers = this.salaries.getSalMail1();
               this.telTiers = this.salaries.getSalCel1();
            }
         }

         this.showModalPanelTodo = true;
      }

   }

   public void markTodo() throws HibernateException, NamingException {
      if (this.rdv != null) {
         this.rdv.setRdvEtat(1);
         this.rdv.setRdvDteExec(new Date());
         this.rdvDao.modif(this.rdv);
         this.listToDo.remove(this.rdv);
         this.datamodelTdo.setWrappedData(this.listToDo);
         this.afficheTodo = false;
      }

   }

   public void choixTypeRdv() {
      if (this.rdv.getRdvNature() != 0 && this.rdv.getRdvNature() != 6) {
         if (this.rdv.getRdvNature() != 2 && this.rdv.getRdvNature() != 10 && this.rdv.getRdvNature() != 11) {
            if (this.rdv.getRdvNature() == 9) {
               this.typeRdv = 9;
            } else {
               this.typeRdv = 0;
            }
         } else {
            this.typeRdv = 2;
         }
      } else {
         this.typeRdv = 1;
      }

   }

   public void saveEvent() throws HibernateException, NamingException {
      if (!this.refCollaborateur.equals("0")) {
         this.rdv.setRdvUsrDe(Long.parseLong(this.refCollaborateur));
         UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.rdv.setRdvNomUsers(var1.selectUserD(Long.parseLong(this.refCollaborateur), (Session)null).getUsrPatronyme());
      } else {
         this.rdv.setRdvUsrDe(0L);
         this.rdv.setRdvNomUsers("");
      }

      if (this.choixTache != null && this.choixTache.contains(":")) {
         String[] var3 = this.choixTache.split(":");
         this.rdv.setRdvTache(var3[0]);
         this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
         new Taches();
         Taches var2 = this.tachesDao.rechercheTache(var3[0], (Session)null);
         if (var2 != null) {
            this.rdv.setRdvTache(var2.getTacCode());
            this.rdv.setRdvTachePr(var2.getTacValPr());
            this.rdv.setRdvTachePv(var2.getTacValPr());
         } else {
            this.rdv.setRdvTache("");
            this.rdv.setRdvTachePr(0.0F);
            this.rdv.setRdvTachePv(0.0F);
         }
      } else {
         this.rdv.setRdvTache("");
         this.rdv.setRdvTachePr(0.0F);
         this.rdv.setRdvTachePv(0.0F);
      }

      if (this.rdv.getRdvNature() == 10) {
         this.rdv.setRdvDteDe((Date)null);
      } else if (this.rdv.getRdvDteDe() == null) {
         this.rdv.setRdvDteDe(new Date());
      }

      if (this.rdv.getRdvId() == 0L) {
         this.rdv.setRdvDateCreation(new Date());
         this.rdv.setUsers(this.usersLog);
         this.rdv.setRdvEtat(0);
         this.rdv = this.rdvDao.insert(this.rdv);
      } else {
         this.rdv = this.rdvDao.modif(this.rdv);
      }

      if (this.typeSaisie != 0 && this.typeSaisie != 2 && this.typeSaisie != 3 && this.typeSaisie != 10) {
         this.listRdv.add(this.rdv);
         this.datamodelRdv.setWrappedData(this.listRdv);
         this.afficheRdv = false;
      } else {
         this.listToDo.add(this.rdv);
         this.datamodelTdo.setWrappedData(this.listToDo);
         this.afficheTodo = false;
      }

      this.afficheRdv = false;
      this.afficheTodo = false;
      this.showModalPanelRdv = false;
      this.showModalPanelTodo = false;
   }

   public void annule() {
      this.afficheRdv = false;
      this.afficheTodo = false;
      this.showModalPanelRdv = false;
      this.showModalPanelTodo = false;
   }

   public void lectureDossierAccueil(String var1) throws IOException {
      this.listRepertoire.clear();
      if (var1 != null && !var1.isEmpty()) {
         File var2 = new File(var1);
         String[] var3 = var2.list();
         if (var3 != null && var3.length != 0) {
            String var4 = "";
            var3 = this.triAlphabetique(var3, var3.length);
            if (this.niveau != 0) {
               this.objetMessageSysteme = new ObjetMessageSysteme();
               this.objetMessageSysteme.setTexte("..");
               this.objetMessageSysteme.setIndice(this.niveau);
               this.listRepertoire.add(this.objetMessageSysteme);
            }

            for(int var5 = 0; var5 < var3.length; ++var5) {
               var4 = var3[var5];
               this.objetMessageSysteme = new ObjetMessageSysteme();
               this.objetMessageSysteme.setTexte(var4);
               this.objetMessageSysteme.setIndice(this.niveau);
               boolean var6 = false;
               if (this.lesGroupesFavoris.size() != 0) {
                  String var7 = this.enleverRacine();
                  if (var7 != null && !var7.isEmpty()) {
                     var7 = var7 + File.separator + var4;
                  } else {
                     var7 = var4;
                  }

                  if (!var7.contains(".")) {
                     for(int var8 = 0; var8 < this.lesGroupesFavoris.size(); ++var8) {
                        if (((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavAcces() && ((GroupeFavoris)this.lesGroupesFavoris.get(var8)).getGrpfavRepertoire().equalsIgnoreCase(var7)) {
                           this.objetMessageSysteme.setAjout(((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavAjout());
                           this.objetMessageSysteme.setModif(((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavModif());
                           this.objetMessageSysteme.setSupp(((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavSupp());
                           var6 = true;
                           break;
                        }
                     }
                  } else if (var7.contains(".")) {
                     var6 = true;
                  }
               }

               if (var6) {
                  this.listRepertoire.add(this.objetMessageSysteme);
               }
            }
         } else {
            this.objetMessageSysteme = new ObjetMessageSysteme();
            this.objetMessageSysteme.setTexte("..");
            this.objetMessageSysteme.setIndice(this.niveau);
            this.listRepertoire.add(this.objetMessageSysteme);
         }
      } else {
         this.objetMessageSysteme = new ObjetMessageSysteme();
         this.objetMessageSysteme.setTexte("..");
         this.objetMessageSysteme.setIndice(this.niveau);
         this.listRepertoire.add(this.objetMessageSysteme);
      }

      this.dataModelRepertoire.setWrappedData(this.listRepertoire);
   }

   public void selectionRepertoire() throws IOException, DocumentException {
      if (this.dataModelRepertoire.isRowAvailable()) {
         this.objetMessageSysteme = (ObjetMessageSysteme)this.dataModelRepertoire.getRowData();
         if (this.objetMessageSysteme.getTexte().contains(".") && !this.objetMessageSysteme.getTexte().equals("..")) {
            this.fichier = true;
            this.nomFichier = this.objetMessageSysteme.getTexte();
            this.objetMessageSysteme.setAjout(this.memoAjout);
            this.objetMessageSysteme.setModif(this.memoModif);
            this.objetMessageSysteme.setSupp(this.memoSupp);
            this.lireDocument();
         } else if (this.objetMessageSysteme.getTexte().equals("..")) {
            this.fichier = false;
            this.nomFichier = "";
            --this.niveau;
            this.memoAjout = this.objetMessageSysteme.isAjout();
            this.memoModif = this.objetMessageSysteme.isModif();
            this.memoSupp = this.objetMessageSysteme.isSupp();
            this.lectureDossierAccueil(this.calculeRepertoireNavigation());
            this.objetMessageSysteme.setAjout(this.memoAjout);
            this.objetMessageSysteme.setModif(this.memoModif);
            this.objetMessageSysteme.setSupp(this.memoSupp);
         } else {
            this.fichier = false;
            this.nomFichier = "";
            ++this.niveau;
            this.memoAjout = this.objetMessageSysteme.isAjout();
            this.memoModif = this.objetMessageSysteme.isModif();
            this.memoSupp = this.objetMessageSysteme.isSupp();
            this.lectureDossierAccueil(this.calculeRepertoireNavigation());
            this.objetMessageSysteme.setAjout(this.memoAjout);
            this.objetMessageSysteme.setModif(this.memoModif);
            this.objetMessageSysteme.setSupp(this.memoSupp);
         }
      }

   }

   public String calculeRepertoireNavigation() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "commun" + File.separator + "accueil";
      if (this.objetMessageSysteme.getTexte().equals("..")) {
         if (this.niveau == 0) {
            this.nomRepertoire = "Internes";
         } else if (this.niveau == 1) {
            this.nomRepertoire = this.repNiveau1;
            var1 = var1 + File.separator + this.repNiveau1;
         } else if (this.niveau == 2) {
            this.nomRepertoire = this.repNiveau2;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2;
         } else if (this.niveau == 3) {
            this.nomRepertoire = this.repNiveau3;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
         } else if (this.niveau == 4) {
            this.nomRepertoire = this.repNiveau4;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
         } else if (this.niveau == 5) {
            this.nomRepertoire = this.repNiveau5;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
         } else if (this.niveau == 6) {
            this.nomRepertoire = this.repNiveau6;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
         } else if (this.niveau == 7) {
            this.nomRepertoire = this.repNiveau7;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
         } else if (this.niveau == 8) {
            this.nomRepertoire = this.repNiveau8;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
         } else if (this.niveau == 9) {
            this.nomRepertoire = this.repNiveau9;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
         } else if (this.niveau == 10) {
            this.nomRepertoire = this.repNiveau10;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
         }
      } else {
         this.nomRepertoire = this.objetMessageSysteme.getTexte();
         if (this.niveau == 1) {
            this.repNiveau1 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1;
         } else if (this.niveau == 2) {
            this.repNiveau2 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2;
         } else if (this.niveau == 3) {
            this.repNiveau3 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
         } else if (this.niveau == 4) {
            this.repNiveau4 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
         } else if (this.niveau == 5) {
            this.repNiveau5 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
         } else if (this.niveau == 6) {
            this.repNiveau6 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
         } else if (this.niveau == 7) {
            this.repNiveau7 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
         } else if (this.niveau == 8) {
            this.repNiveau8 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
         } else if (this.niveau == 9) {
            this.repNiveau9 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
         } else if (this.niveau == 10) {
            this.repNiveau10 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
         }
      }

      return var1;
   }

   public String calculeRepertoireEnCours() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "commun" + File.separator + "accueil";
      if (this.niveau == 1) {
         var1 = var1 + File.separator + this.repNiveau1;
      } else if (this.niveau == 2) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2;
      } else if (this.niveau == 3) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
      } else if (this.niveau == 4) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
      } else if (this.niveau == 5) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
      } else if (this.niveau == 6) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
      } else if (this.niveau == 7) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
      } else if (this.niveau == 8) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
      } else if (this.niveau == 9) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
      } else if (this.niveau == 10) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
      }

      return var1;
   }

   public String calculeFichier() {
      String var1 = this.adresseTelechargement;
      if (this.niveau == 1) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 2) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 3) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 4) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 5) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 6) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 7) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 8) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 9) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 10) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10 + File.separator + this.objetMessageSysteme.getTexte();
      }

      return var1;
   }

   public String enleverRacine() {
      String var1 = "";
      if (this.niveau == 1) {
         var1 = this.repNiveau1;
      } else if (this.niveau == 2) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2;
      } else if (this.niveau == 3) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
      } else if (this.niveau == 4) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
      } else if (this.niveau == 5) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
      } else if (this.niveau == 6) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
      } else if (this.niveau == 7) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
      } else if (this.niveau == 8) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
      } else if (this.niveau == 9) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
      } else if (this.niveau == 10) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
      }

      return var1;
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

   public void ajouterDocument() throws MalformedURLException, IOException {
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         this.repertoireUrl = this.utilDownload.convertirFichierUtl(this.calculeRepertoireEnCours(), this.urlExplorateur);
         this.repertoireString = this.repertoireUrl.toString() + File.separator;
      }

      this.uploadedFile = null;
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocument() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerDocument() {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1.toString().contains(".")) {
               if (var1.toString().contains(" ")) {
                  String var2 = var1.toString();
                  String var3 = "";

                  for(int var4 = 0; var4 < var2.length(); ++var4) {
                     String var5 = var2.substring(var4, var4 + 1);
                     if (var5.equals(" ")) {
                        var3 = var3 + "_";
                     } else {
                        var3 = var3 + var2.substring(var4, var4 + 1);
                     }
                  }

                  var1 = var3;
               }

               File var7 = new File(this.calculeRepertoireEnCours() + File.separator + var1);
               var7.delete();
               File var8 = this.utilDownload.uniqueFile(new File(this.calculeRepertoireEnCours() + File.separator), var1);
               this.utilDownload.write(var8, this.uploadedFile.getInputStream());
               this.objetMessageSysteme = new ObjetMessageSysteme();
               this.objetMessageSysteme.setTexte(var1);
               this.objetMessageSysteme.setIndice(this.niveau);
               this.listRepertoire.add(this.objetMessageSysteme);
               this.dataModelRepertoire.setWrappedData(this.listRepertoire);
            }
         }
      } catch (IOException var6) {
      }

      this.showModalPanelAjoutFile = false;
   }

   public void lireDocument() throws IOException {
      if (this.nomFichier != null && !this.nomFichier.isEmpty() && this.fichier) {
         this.fichierUrl = this.utilDownload.convertirFichierUtl(this.calculeFichier(), this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.nomFichier);
         if (!this.nomFichier.contains(".pdf") && !this.nomFichier.contains(".PDF")) {
            this.viewerPdf = false;
         } else {
            this.viewerPdf = true;
         }
      }

   }

   public void supprimerDocument() throws IOException {
      if (!this.objetMessageSysteme.getTexte().contains(".") || !this.objetMessageSysteme.getTexte().equals("..")) {
         String var1 = this.calculeRepertoireEnCours() + File.separator + this.objetMessageSysteme.getTexte();
         File var2 = new File(var1);
         var2.delete();
         this.listRepertoire.remove(this.objetMessageSysteme);
         this.dataModelRepertoire.setWrappedData(this.listRepertoire);
         this.nomFichier = "";
      }

   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiers = new ArrayList();
      if (this.rdv.getRdvNomTiers() != null && !this.rdv.getRdvNomTiers().isEmpty()) {
         this.lesTiers = this.tiersDao.verifTiers(this.usersLog, "", this.rdv.getRdvNomTiers(), (Session)null);
         if (this.lesTiers.size() == 1) {
            this.tiers = (Tiers)this.lesTiers.get(0);
            this.calculeTiers();
         } else if (this.lesTiers.size() >= 2) {
            this.datamodelTiers.setWrappedData(this.lesTiers);
            this.showModalPanelTiers = true;
         } else {
            this.tiers = null;
            this.rdv.setRdvNomTiers("");
            this.rdv.setRdvTieIdDe(0L);
         }
      }

   }

   public void selectionTiers() {
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void calculeTiers() {
      if (this.lesTiers.size() != 0) {
         if (this.tiers != null) {
            this.rdv.setRdvNomTiers(this.tiers.getTieraisonsocialenom());
            this.rdv.setRdvTieIdDe(this.tiers.getTieid());
            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.rdv.setRdvDiversTiers(99);
            } else {
               this.rdv.setRdvDiversTiers(0);
            }

            this.rdv.setRdvDiversNom("");
         } else {
            this.tiers = null;
            this.rdv.setRdvNomTiers("");
            this.rdv.setRdvTieIdDe(0L);
            this.rdv.setRdvDiversTiers(0);
            this.rdv.setRdvDiversNom("");
         }
      } else {
         this.tiers = null;
         this.rdv.setRdvNomTiers("");
         this.rdv.setRdvTieIdDe(0L);
         this.rdv.setRdvDiversTiers(0);
         this.rdv.setRdvDiversNom("");
      }

      this.showModalPanelTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.rdv.setRdvNomTiers("");
      this.rdv.setRdvTieIdDe(0L);
      this.showModalPanelTiers = false;
   }

   public void recherchePatients() throws HibernateException, NamingException {
      this.lesPatients = new ArrayList();
      if (this.rdv.getRdvNomPat() != null && !this.rdv.getRdvNomPat().isEmpty()) {
         this.lesPatients = this.patientsDao.chargerlesPatients(this.rdv.getRdvNomPat(), (Session)null);
         if (this.lesPatients.size() != 0) {
            this.datamodelPatients.setWrappedData(this.lesPatients);
            this.showModalPanelPatients = true;
         } else {
            this.patients = null;
            this.rdv.setRdvNomPat("");
            this.rdv.setRdvPatIdDe(0L);
         }
      }

   }

   public void selectionPatients() {
      if (this.datamodelPatients.isRowAvailable()) {
         this.patients = (Patients)this.datamodelPatients.getRowData();
      }

   }

   public void calculePatients() {
      if (this.lesPatients.size() != 0) {
         if (this.patients != null) {
            this.rdv.setRdvNomPat(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
            this.rdv.setRdvPatIdDe(this.patients.getPatId());
         } else {
            this.patients = null;
            this.rdv.setRdvNomPat("");
            this.rdv.setRdvPatIdDe(0L);
         }
      } else {
         this.patients = null;
         this.rdv.setRdvNomPat("");
         this.rdv.setRdvPatIdDe(0L);
      }

      this.showModalPanelPatients = false;
   }

   public void annulePatients() {
      this.patients = null;
      this.rdv.setRdvNomPat("");
      this.rdv.setRdvPatIdDe(0L);
      this.showModalPanelPatients = false;
   }

   public void caluleMap() {
   }

   public DataModel getDatamodelAnniv() {
      return this.datamodelAnniv;
   }

   public void setDatamodelAnniv(DataModel var1) {
      this.datamodelAnniv = var1;
   }

   public DataModel getDatamodelRdv() {
      return this.datamodelRdv;
   }

   public void setDatamodelRdv(DataModel var1) {
      this.datamodelRdv = var1;
   }

   public boolean isAfficheRdv() {
      return this.afficheRdv;
   }

   public void setAfficheRdv(boolean var1) {
      this.afficheRdv = var1;
   }

   public DataModel getDatamodelTdo() {
      return this.datamodelTdo;
   }

   public void setDatamodelTdo(DataModel var1) {
      this.datamodelTdo = var1;
   }

   public int getTypeRdv() {
      return this.typeRdv;
   }

   public void setTypeRdv(int var1) {
      this.typeRdv = var1;
   }

   public DataModel getDatamodelFavoris() {
      return this.datamodelFavoris;
   }

   public void setDatamodelFavoris(DataModel var1) {
      this.datamodelFavoris = var1;
   }

   public boolean isShowModalPanelRdv() {
      return this.showModalPanelRdv;
   }

   public void setShowModalPanelRdv(boolean var1) {
      this.showModalPanelRdv = var1;
   }

   public String getChoixTache() {
      return this.choixTache;
   }

   public void setChoixTache(String var1) {
      this.choixTache = var1;
   }

   public boolean isAfficheTodo() {
      return this.afficheTodo;
   }

   public void setAfficheTodo(boolean var1) {
      this.afficheTodo = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public ObjetMessageSysteme getObjetMessageSysteme() {
      return this.objetMessageSysteme;
   }

   public void setObjetMessageSysteme(ObjetMessageSysteme var1) {
      this.objetMessageSysteme = var1;
   }

   public boolean isRdvdetails() {
      return this.rdvdetails;
   }

   public void setRdvdetails(boolean var1) {
      this.rdvdetails = var1;
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

   public int getTypeSaisie() {
      return this.typeSaisie;
   }

   public void setTypeSaisie(int var1) {
      this.typeSaisie = var1;
   }

   public String getRefCollaborateur() {
      return this.refCollaborateur;
   }

   public void setRefCollaborateur(String var1) {
      this.refCollaborateur = var1;
   }

   public Rdv getRdv() {
      return this.rdv;
   }

   public void setRdv(Rdv var1) {
      this.rdv = var1;
   }

   public boolean isGestionPatient() {
      return this.gestionPatient;
   }

   public void setGestionPatient(boolean var1) {
      this.gestionPatient = var1;
   }

   public DataModel getDatamodelPatients() {
      return this.datamodelPatients;
   }

   public void setDatamodelPatients(DataModel var1) {
      this.datamodelPatients = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public boolean isShowModalPanelPatients() {
      return this.showModalPanelPatients;
   }

   public void setShowModalPanelPatients(boolean var1) {
      this.showModalPanelPatients = var1;
   }

   public DataModel getDataModelRepertoire() {
      return this.dataModelRepertoire;
   }

   public void setDataModelRepertoire(DataModel var1) {
      this.dataModelRepertoire = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public boolean isFichier() {
      return this.fichier;
   }

   public void setFichier(boolean var1) {
      this.fichier = var1;
   }

   public String getNomFichier() {
      return this.nomFichier;
   }

   public void setNomFichier(String var1) {
      this.nomFichier = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public int getNiveau() {
      return this.niveau;
   }

   public void setNiveau(int var1) {
      this.niveau = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public String getFichierCode() {
      return this.fichierCode;
   }

   public void setFichierCode(String var1) {
      this.fichierCode = var1;
   }

   public URL getRepertoireUrl() {
      return this.repertoireUrl;
   }

   public void setRepertoireUrl(URL var1) {
      this.repertoireUrl = var1;
   }

   public String getRepertoireString() {
      return this.repertoireString;
   }

   public void setRepertoireString(String var1) {
      this.repertoireString = var1;
   }

   public boolean isViewerPdf() {
      return this.viewerPdf;
   }

   public void setViewerPdf(boolean var1) {
      this.viewerPdf = var1;
   }

   public boolean isShowModalPanelRdvFait() {
      return this.showModalPanelRdvFait;
   }

   public void setShowModalPanelRdvFait(boolean var1) {
      this.showModalPanelRdvFait = var1;
   }

   public boolean isShowModalPanelTodo() {
      return this.showModalPanelTodo;
   }

   public void setShowModalPanelTodo(boolean var1) {
      this.showModalPanelTodo = var1;
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

   public List getMesNaturesRdvItems() {
      return this.mesNaturesRdvItems;
   }

   public void setMesNaturesRdvItems(List var1) {
      this.mesNaturesRdvItems = var1;
   }

   public List getMesNaturesTodoItems() {
      return this.mesNaturesTodoItems;
   }

   public void setMesNaturesTodoItems(List var1) {
      this.mesNaturesTodoItems = var1;
   }

   public String getMailTiers() {
      return this.mailTiers;
   }

   public void setMailTiers(String var1) {
      this.mailTiers = var1;
   }

   public String getTelTiers() {
      return this.telTiers;
   }

   public void setTelTiers(String var1) {
      this.telTiers = var1;
   }
}
