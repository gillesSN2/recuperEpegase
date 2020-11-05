package com.epegase.forms.education;

import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.ElevesContact;
import com.epegase.systeme.classe.ElevesFacture;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.ElevesContactDao;
import com.epegase.systeme.dao.ElevesFactureDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormBonEncaissementEducation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private String pageIndex;
   private ExercicesVentes exercicesVentes;
   private OptionVentes optionsVentes;
   private int var_nb_max = 100;
   private UsersChrono usersChrono;
   private CalculChrono calculChrono;
   private transient DataModel datamodelEncaiss = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesBonEncaissementVente = new ArrayList();
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private BonEncaissementVente bonEncaissementVente;
   private double montantAPayer;
   private boolean var_affiche_valide = false;
   private List listFacture = new ArrayList();
   private transient DataModel datamodelTransfert = new ListDataModel();
   private boolean showModalPanelAnnuler = false;
   private int inpEtat = 0;
   private Date dateDebut;
   private Date dateFin;
   private UtilDate utilDate = new UtilDate();
   private String requete;
   private String filtre;
   private String format = "PDF";
   private int var_nb_ligne;
   private double montantRecette = 0.0D;
   private boolean visibiliteBton = false;
   private boolean afficheAPayer;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private int var_choix_modele = 0;
   private String nomModeleListe;
   private String nomModeleDocument;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private UtilNombre utilNombre = new UtilNombre();
   private boolean showModalPanelPrint = false;
   private String var_inputCaisse;
   private String var_type_reg;
   private String var_banque_destination;
   private boolean showModalPanelGeneration = false;
   private List lesFacturesGenerees;
   private ElevesFactureDao elevesFactureDao;
   private ElevesContactDao elevesContactDao;
   private String site;
   private String departement;
   private String service;
   private String region;
   private String secteur;
   private String pdv;
   private List mesSecteursItems;
   private List mesPdvItems;
   private List mesDepartementsItems;
   private List mesServicesItems;

   public FormBonEncaissementEducation() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.lesFacturesGenerees = new ArrayList();
      this.mesSecteursItems = new ArrayList();
      this.mesPdvItems = new ArrayList();
      this.mesDepartementsItems = new ArrayList();
      this.mesServicesItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      this.elevesFactureDao = new ElevesFactureDao(this.baseLog, this.utilInitHibernate);
      this.elevesContactDao = new ElevesContactDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         new ArrayList();
         String[] var2 = this.site.split(":");
         new Site();
         SiteDao var4 = new SiteDao(this.baseLog, this.utilInitHibernate);
         Site var3 = var4.rechercheSite(var2[0], (Session)null);
         if (var3 != null) {
            DepartementDao var5 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listDepartementBySit((Site)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesDepartementsItems.add(new SelectItem(((Departement)var1.get(var6)).getDepCode() + ":" + ((Departement)var1.get(var6)).getDepNomFr()));
               }
            }
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         new ArrayList();
         String[] var2 = this.departement.split(":");
         new Departement();
         DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         Departement var3 = var4.rechercheDepartement(var2[0], (Session)null);
         if (var3 != null) {
            ServiceDao var5 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listServiceByDep((Departement)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesServicesItems.add(new SelectItem(((Service)var1.get(var6)).getSerCode() + ":" + ((Service)var1.get(var6)).getSerNomFr()));
               }
            }
         }
      }

   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         new ArrayList();
         String[] var2 = this.region.split(":");
         new Region();
         RegionDao var4 = new RegionDao(this.baseLog, this.utilInitHibernate);
         Region var3 = var4.rechercheRegion(var2[0], (Session)null);
         if (var3 != null) {
            SecteurDao var5 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listSecteurByRegion((Region)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesSecteursItems.add(new SelectItem(((Secteur)var1.get(var6)).getSecCode() + ":" + ((Secteur)var1.get(var6)).getSecNomFr()));
               }
            }
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         new ArrayList();
         String[] var2 = this.secteur.split(":");
         new Secteur();
         SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         Secteur var3 = var4.rechercheSecteur(var2[0], (Session)null);
         if (var3 != null) {
            PointDeVenteDao var5 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listPdvBySecteur((Secteur)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesPdvItems.add(new SelectItem(((PointDeVente)var1.get(var6)).getPdvCode() + ":" + ((PointDeVente)var1.get(var6)).getPdvNomFr()));
               }
            }
         }
      }

   }

   public void chargerFind() throws HibernateException, NamingException {
      this.chargerFind((Session)null);
   }

   public void chargerFind(Session var1) throws HibernateException, NamingException {
      if (this.dateDebut == null) {
         this.dateDebut = this.exercicesVentes.getExevteDateDebut();
      }

      if (this.dateFin == null) {
         this.dateFin = this.exercicesVentes.getExevteDateFin();
      }

      this.lesBonEncaissementVente.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.inpEtat == 0) {
         this.lesBonEncaissementVente = this.bonEncaissementVenteDao.selectNonPayer(var1);
      } else if (this.inpEtat == 1) {
         this.lesBonEncaissementVente = this.bonEncaissementVenteDao.selectExecuter(this.dateDebut, this.dateFin, var1);
      } else if (this.inpEtat == 2) {
         this.lesBonEncaissementVente = this.bonEncaissementVenteDao.selectAnnuler(this.dateDebut, this.dateFin, var1);
      } else if (this.inpEtat == 3) {
         this.showModalPanelGeneration = true;
      }

      this.datamodelEncaiss.setWrappedData(this.lesBonEncaissementVente);
      this.var_nb_ligne = this.lesBonEncaissementVente.size();
      this.montantRecette = 0.0D;
      if (this.lesBonEncaissementVente.size() != 0) {
         for(int var2 = 0; var2 < this.lesBonEncaissementVente.size(); ++var2) {
            this.montantRecette += ((BonEncaissementVente)this.lesBonEncaissementVente.get(var2)).getBonAPayer();
         }
      }

   }

   public void fermerGeneration() {
      this.showModalPanelGeneration = false;
   }

   public void rechercheGeneration() {
      this.var_inputCaisse = "";
      this.var_banque_destination = "";
   }

   public void validerGeneration() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementEducation");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new ArrayList();
         Object var4 = new ArrayList();
         new ArrayList();
         List var5 = this.elevesFactureDao.chargerLesFacturesEcheances(this.dateDebut, this.dateFin, this.site, this.departement, this.service, this.region, this.secteur, this.pdv, var1);
         new ElevesFacture();
         if (var5.size() != 0) {
            for(int var7 = 0; var7 < var5.size(); ++var7) {
               ElevesFacture var6 = (ElevesFacture)var5.get(var7);
               if (var6.getElefacTarifAssociation() + var6.getElefacTarifCantine() + var6.getElefacTarifDivers() + var6.getElefacTarifDossier() + var6.getElefacTarifExamens() + var6.getElefacTarifInscription() + var6.getElefacTarifReinscription() + var6.getElefacTarifScolarite() + var6.getElefacTarifTenue() + var6.getElefacTarifTransport() > var6.getElefacReglement()) {
                  boolean var8 = true;
                  List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(var6.getElefacId(), 101, var1);
                  if (var3.size() != 0) {
                     for(int var9 = 0; var9 < var3.size(); ++var9) {
                        if (((BonEncaissementVente)var3.get(var9)).getBonEtat() == 0 && ((BonEncaissementVente)var3.get(var9)).getBonDate().compareTo(this.dateDebut) >= 0 && ((BonEncaissementVente)var3.get(var9)).getBonDate().compareTo(this.dateFin) <= 0) {
                           var8 = false;
                           break;
                        }
                     }
                  }

                  if (var8) {
                     String var17 = this.calculChrono.numCompose(new Date(), 109, var6.getElefacSerie(), var1);
                     this.bonEncaissementVente = new BonEncaissementVente();
                     String[] var10;
                     if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                        var10 = this.var_inputCaisse.split(":");
                        this.bonEncaissementVente.setBonCodeCaisse(var10[0]);
                        this.bonEncaissementVente.setBonLibCaisse(var10[1]);
                        if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
                           String[] var11 = this.var_type_reg.split(":");
                           this.bonEncaissementVente.setBonTypeReg(Integer.parseInt(var11[0]));
                        } else {
                           this.bonEncaissementVente.setBonTypeReg(0);
                        }
                     } else {
                        this.bonEncaissementVente.setBonCodeCaisse((String)null);
                        this.bonEncaissementVente.setBonLibCaisse((String)null);
                        this.bonEncaissementVente.setBonTypeReg(0);
                     }

                     if (this.var_banque_destination != null && !this.var_banque_destination.isEmpty() && this.var_banque_destination.contains(":")) {
                        var10 = this.var_banque_destination.split(":");
                        this.bonEncaissementVente.setBonCodeBanq(var10[0]);
                        this.bonEncaissementVente.setBonLibBanq(var10[1]);
                     } else {
                        this.bonEncaissementVente.setBonCodeBanq((String)null);
                        this.bonEncaissementVente.setBonLibBanq((String)null);
                     }

                     this.bonEncaissementVente.setBonBanqueTireur("");
                     this.bonEncaissementVente.setBonNumChqBdx("");
                     this.bonEncaissementVente.setBonDateCreat(new Date());
                     this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                     if (var6.getElefacType() == 1) {
                        this.bonEncaissementVente.setBonActivite("INSCRIPTION");
                        this.bonEncaissementVente.setBonObject("Inscription");
                     } else if (var6.getElefacType() == 2) {
                        this.bonEncaissementVente.setBonActivite("SCOLARITE");
                        if (var6.getElefacModeScolarite() == 0) {
                           this.bonEncaissementVente.setBonObject(this.calculMois());
                        } else if (var6.getElefacModeScolarite() == 1) {
                           this.bonEncaissementVente.setBonObject(this.calculTrimestre(var6.getElefacAnnee()));
                        } else if (var6.getElefacModeScolarite() == 2) {
                           this.bonEncaissementVente.setBonObject(this.calculSemestre(var6.getElefacAnnee()));
                        } else if (var6.getElefacModeScolarite() == 3) {
                           this.bonEncaissementVente.setBonObject(this.calculAnnuel(var6.getElefacAnnee()));
                        }
                     } else {
                        this.bonEncaissementVente.setBonActivite("DIVERS");
                        this.bonEncaissementVente.setBonObject("Divers");
                     }

                     this.bonEncaissementVente.setBonSite(var6.getElefacSite());
                     this.bonEncaissementVente.setBonDepartement(var6.getElefacDepartement());
                     this.bonEncaissementVente.setBonService(var6.getElefacService());
                     this.bonEncaissementVente.setBonRegion(var6.getElefacRegion());
                     this.bonEncaissementVente.setBonSecteur(var6.getElefacSecteur());
                     this.bonEncaissementVente.setBonPdv(var6.getElefacPdv());
                     this.bonEncaissementVente.setBonDateEcheReg(this.dateDebut);
                     this.bonEncaissementVente.setBonEtat(0);
                     this.bonEncaissementVente.setBonNatRef(101);
                     this.bonEncaissementVente.setBonNomTiers(var6.getEleves().getPatronyme());
                     this.bonEncaissementVente.setBonIdTiers(var6.getEleves().getEleId());
                     this.bonEncaissementVente.setBonNomContact("");
                     this.bonEncaissementVente.setBonIdContact(0L);
                     ((List)var4).clear();
                     var4 = this.elevesContactDao.chargerLesElevesContact(var6.getEleves(), var1);
                     if (((List)var4).size() != 0) {
                        boolean var18 = false;

                        for(int var19 = 0; var19 < ((List)var4).size(); ++var19) {
                           if (((ElevesContact)((List)var4).get(var19)).getEleconFacture() == 1) {
                              this.bonEncaissementVente.setBonNomContact(((ElevesContact)((List)var4).get(var19)).getPatronyme());
                              this.bonEncaissementVente.setBonIdContact(((ElevesContact)((List)var4).get(var19)).getEleconId());
                              var18 = true;
                              break;
                           }
                        }

                        if (!var18) {
                           this.bonEncaissementVente.setBonNomContact(((ElevesContact)((List)var4).get(0)).getPatronyme());
                           this.bonEncaissementVente.setBonIdContact(((ElevesContact)((List)var4).get(0)).getEleconId());
                        }
                     }

                     this.bonEncaissementVente.setBonTypeTiers(5);
                     this.bonEncaissementVente.setBonLibelle("Règlement Facture N° " + var6.getElefacNum());
                     this.bonEncaissementVente.setBonRef(var6.getElefacNum());
                     this.bonEncaissementVente.setBonIdRef(var6.getElefacId());
                     this.bonEncaissementVente.setBonObservation("");
                     this.bonEncaissementVente.setBonSerie(var6.getElefacSerie());
                     this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                     double var20 = 0.0D;
                     if (var6.getElefacDateEche01().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche01().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacTarifInscription() + var6.getElefacTarifReinscription() + var6.getElefacTarifDossier() + var6.getElefacTarifExamens() + var6.getElefacTarifAssociation() + var6.getElefacTarifTenue() + var6.getElefacTarifDivers() + var6.getElefacScolarite01() + var6.getElefacTransport01() + var6.getElefacCantine01();
                     } else if (var6.getElefacDateEche02().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche02().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite02() + var6.getElefacTransport02() + var6.getElefacCantine02();
                     } else if (var6.getElefacDateEche03().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche03().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite03() + var6.getElefacTransport03() + var6.getElefacCantine03();
                     } else if (var6.getElefacDateEche04().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche04().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite04() + var6.getElefacTransport04() + var6.getElefacCantine04();
                     } else if (var6.getElefacDateEche05().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche05().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite05() + var6.getElefacTransport05() + var6.getElefacCantine05();
                     } else if (var6.getElefacDateEche06().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche06().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite06() + var6.getElefacTransport06() + var6.getElefacCantine06();
                     } else if (var6.getElefacDateEche07().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche07().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite07() + var6.getElefacTransport07() + var6.getElefacCantine07();
                     } else if (var6.getElefacDateEche08().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche08().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite08() + var6.getElefacTransport08() + var6.getElefacCantine08();
                     } else if (var6.getElefacDateEche09().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche09().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite09() + var6.getElefacTransport09() + var6.getElefacCantine09();
                     } else if (var6.getElefacDateEche10().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche10().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite10() + var6.getElefacTransport10() + var6.getElefacCantine10();
                     } else if (var6.getElefacDateEche11().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche11().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite11() + var6.getElefacTransport11() + var6.getElefacCantine11();
                     } else if (var6.getElefacDateEche12().compareTo(this.dateDebut) >= 0 && var6.getElefacDateEche12().compareTo(this.dateFin) <= 0) {
                        var20 = var6.getElefacScolarite12() + var6.getElefacTransport12() + var6.getElefacCantine12();
                     }

                     this.bonEncaissementVente.setBonTotTtc(var20);
                     this.bonEncaissementVente.setBonAPayer(var20);
                     this.bonEncaissementVente.setBonActif(0);
                     this.bonEncaissementVente.setBonNum(var17);
                     this.bonEncaissementVente.setBonDate(this.dateDebut);
                     this.bonEncaissementVente.setBonIdResponsable(var6.getElefacIdResponsable());
                     this.bonEncaissementVente.setBonNomResponsable(var6.getElefacNomResponsable());
                     this.bonEncaissementVente.setBonIdCommercial(var6.getElefacIdCommercial());
                     this.bonEncaissementVente.setBonNomCommercial(var6.getElefacNomCommercial());
                     this.bonEncaissementVente.setBonIdEquipe(0L);
                     this.bonEncaissementVente.setBonNomEquipe("");
                     this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
                     this.bonEncaissementVente.setBonClient("");
                     this.bonEncaissementVente.setBonFacture("");
                     this.bonEncaissementVente.setBonMontant("");
                     this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var1);
                  }
               }
            }
         }

         var2.commit();
      } catch (HibernateException var15) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var15;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelGeneration = false;
      this.inpEtat = 0;
      this.chargerFind();
   }

   public String calculMois() {
      String var1 = "";
      if (this.dateDebut.getMonth() + 1 == 1) {
         var1 = "Janvier";
      } else if (this.dateDebut.getMonth() + 1 == 2) {
         var1 = "Février";
      } else if (this.dateDebut.getMonth() + 1 == 3) {
         var1 = "Mars";
      } else if (this.dateDebut.getMonth() + 1 == 4) {
         var1 = "Avril";
      } else if (this.dateDebut.getMonth() + 1 == 5) {
         var1 = "Mai";
      } else if (this.dateDebut.getMonth() + 1 == 6) {
         var1 = "Juin";
      } else if (this.dateDebut.getMonth() + 1 == 7) {
         var1 = "Juillet";
      } else if (this.dateDebut.getMonth() + 1 == 8) {
         var1 = "Aout";
      } else if (this.dateDebut.getMonth() + 1 == 9) {
         var1 = "Septembre";
      } else if (this.dateDebut.getMonth() + 1 == 10) {
         var1 = "Octobre";
      } else if (this.dateDebut.getMonth() + 1 == 11) {
         var1 = "Novembre";
      } else if (this.dateDebut.getMonth() + 1 == 12) {
         var1 = "Décembre";
      }

      var1 = var1 + " " + (this.dateDebut.getYear() + 1900);
      return var1;
   }

   public String calculTrimestre(String var1) {
      String var2 = "";
      if (this.dateDebut.getMonth() + 1 >= 1 && this.dateDebut.getMonth() + 1 <= 3) {
         var2 = "1er Trimestre";
      } else if (this.dateDebut.getMonth() + 4 >= 1 && this.dateDebut.getMonth() + 1 <= 6) {
         var2 = "2eme Trimestre";
      } else if (this.dateDebut.getMonth() + 1 >= 7 && this.dateDebut.getMonth() + 1 <= 9) {
         var2 = "3eme Trimestre";
      } else if (this.dateDebut.getMonth() + 1 >= 10 && this.dateDebut.getMonth() + 1 <= 12) {
         var2 = "4eme Trimestre";
      }

      var2 = var2 + " " + var1;
      return var2;
   }

   public String calculSemestre(String var1) {
      String var2 = "";
      if (this.dateDebut.getMonth() + 1 >= 1 && this.dateDebut.getMonth() + 1 <= 6) {
         var2 = "1er Semestre";
      } else {
         var2 = "2eme Semestre";
      }

      var2 = var2 + " " + var1;
      return var2;
   }

   public String calculAnnuel(String var1) {
      String var2 = "";
      var2 = "Année" + var1;
      return var2;
   }

   public void selectionLigne() {
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
            this.bonEncaissementVente = (BonEncaissementVente)var1.get(0);
            this.montantAPayer = this.bonEncaissementVente.getBonAPayer();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public ObjetDevises calculerLibelleDevise(String var1) throws IOException {
      LectureDevises var2 = new LectureDevises();
      new ArrayList();
      List var3 = var2.getMesDevises();
      ObjetDevises var4 = new ObjetDevises();
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            if (((ObjetDevises)var3.get(var5)).getCode().equalsIgnoreCase(var1)) {
               var4 = (ObjetDevises)var3.get(var5);
               break;
            }
         }
      }

      return var4;
   }

   public void modifierBon() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         this.montantAPayer = this.bonEncaissementVente.getBonAPayer();
         this.var_affiche_valide = true;
         if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty()) {
            this.listeFacture();
            this.var_action = 11;
         } else {
            this.var_action = 1;
         }
      }

   }

   public void consultBonEncaissement() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         this.var_affiche_valide = false;
         if (this.bonEncaissementVente.getBonClient() != null && !this.bonEncaissementVente.getBonClient().isEmpty()) {
            this.listeFacture();
            this.var_action = 13;
         } else {
            this.var_action = 3;
         }
      }

   }

   public void listeFacture() throws HibernateException, NamingException {
      this.listFacture.clear();
      if (this.bonEncaissementVente.getBonFacture() != null && !this.bonEncaissementVente.getBonFacture().isEmpty() && this.bonEncaissementVente.getBonFacture().contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Eleves");
         int var2 = this.regexOccur(this.bonEncaissementVente.getBonFacture(), Pattern.quote(":"));
         if (var2 != 0) {
            String[] var3 = this.bonEncaissementVente.getBonFacture().split(":");

            for(int var4 = 0; var4 < var2; ++var4) {
               new ElevesFacture();
               ElevesFacture var5 = this.elevesFactureDao.pourParapheur(var3[var4], var1);
               if (var5 != null && var5.getElefacNum() != null && !var5.getElefacNum().isEmpty()) {
                  this.listFacture.add(var5);
               }
            }

            this.datamodelTransfert.setWrappedData(this.listFacture);
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public int regexOccur(String var1, String var2) {
      Matcher var3 = Pattern.compile(var2).matcher(var1);

      int var4;
      for(var4 = 0; var3.find(); ++var4) {
      }

      return var4;
   }

   public void deleteBonEncaissement() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         String var1 = this.bonEncaissementVente.getBonNum();
         String var2 = this.utilDate.dateToStringFr(this.bonEncaissementVente.getBonDate());
         this.lesBonEncaissementVente.remove(this.bonEncaissementVente);
         this.datamodelEncaiss.setWrappedData(this.lesBonEncaissementVente);
         this.bonEncaissementVenteDao.delete(this.bonEncaissementVente);
         this.var_nb_ligne = this.lesBonEncaissementVente.size();
         this.montantRecette = 0.0D;
         if (this.lesBonEncaissementVente.size() != 0) {
            for(int var3 = 0; var3 < this.lesBonEncaissementVente.size(); ++var3) {
               this.montantRecette += ((BonEncaissementVente)this.lesBonEncaissementVente.get(var3)).getBonAPayer();
            }
         }

         this.visibiliteBton = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
         Espion var5 = new Espion();
         EspionDao var4 = new EspionDao(this.baseLog, this.utilInitHibernate);
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Suppression bon encaissement N° " + var1 + " du " + var2);
         var4.mAJEspion(var5);
      }

   }

   public void annulerBonEncaissement() {
      if (this.bonEncaissementVente != null) {
         this.showModalPanelAnnuler = true;
      }

   }

   public void fermerAnnulerBon() {
      this.showModalPanelAnnuler = false;
   }

   public void validerAnnulerBon() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         String var1 = this.bonEncaissementVente.getBonNum();
         String var2 = this.utilDate.dateToStringFr(this.bonEncaissementVente.getBonDate());
         this.lesBonEncaissementVente.remove(this.bonEncaissementVente);
         this.datamodelEncaiss.setWrappedData(this.lesBonEncaissementVente);
         this.bonEncaissementVente.setBonDateAnnule(new Date());
         this.bonEncaissementVente.setBonUserAnnule(this.usersLog.getUsrid());
         this.bonEncaissementVente.setBonEtat(2);
         this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente);
         this.var_nb_ligne = this.lesBonEncaissementVente.size();
         this.montantRecette = 0.0D;
         if (this.lesBonEncaissementVente.size() != 0) {
            for(int var3 = 0; var3 < this.lesBonEncaissementVente.size(); ++var3) {
               this.montantRecette += ((BonEncaissementVente)this.lesBonEncaissementVente.get(var3)).getBonAPayer();
            }
         }

         this.visibiliteBton = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
         Espion var5 = new Espion();
         EspionDao var4 = new EspionDao(this.baseLog, this.utilInitHibernate);
         var5.setUsers(this.usersLog);
         var5.setEsptype(0);
         var5.setEspdtecreat(new Date());
         var5.setEspaction("Annulation bon encaissement N° " + var1 + " du " + var2);
         var4.mAJEspion(var5);
      }

      this.showModalPanelAnnuler = false;
   }

   public void controleMontant() {
      if (this.montantAPayer <= this.bonEncaissementVente.getBonTotTtc()) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void annule() {
      this.var_action = 0;
      this.visibiliteBton = false;
   }

   public void save() throws HibernateException, NamingException {
      if (this.bonEncaissementVente != null) {
         this.bonEncaissementVente.setBonAPayer(this.montantAPayer);
         this.bonEncaissementVente = this.bonEncaissementVenteDao.ModifBon(this.bonEncaissementVente);
         this.var_action = 0;
      }

   }

   public void initImpression() throws IOException {
      if (this.utilPrint == null) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
      }

      this.affMail = false;
      this.var_choix_modele = 0;
      this.ListeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
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
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      var1.add(this.bonEncaissementVente);
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
            this.utilPrint.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            String var1 = this.calculerLibelleDevise(this.bonEncaissementVente.getBonDevise()).getLibelle();
            String var2 = this.utilNombre.begin(this.bonEncaissementVente.getBonAPayer(), this.bonEncaissementVente.getBonDevise());
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setEntete("Impression du bon d'encaissement en cours");
            this.utilPrint.setMontant_lettre(var2);
            this.utilPrint.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des bons d'encaissement");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "liste" + File.separator + "bon_encaissement" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setNature(0);
         this.utilPrint.setId_doc(0L);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesBonEncaissementVente);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public BonEncaissementVente getBonEncaissementVente() {
      return this.bonEncaissementVente;
   }

   public void setBonEncaissementVente(BonEncaissementVente var1) {
      this.bonEncaissementVente = var1;
   }

   public DataModel getDatamodelEncaiss() {
      return this.datamodelEncaiss;
   }

   public void setDatamodelEncaiss(DataModel var1) {
      this.datamodelEncaiss = var1;
   }

   public boolean isAfficheAPayer() {
      return this.afficheAPayer;
   }

   public void setAfficheAPayer(boolean var1) {
      this.afficheAPayer = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public double getMontantRecette() {
      return this.montantRecette;
   }

   public void setMontantRecette(double var1) {
      this.montantRecette = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_affiche_valide() {
      return this.var_affiche_valide;
   }

   public void setVar_affiche_valide(boolean var1) {
      this.var_affiche_valide = var1;
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

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public double getMontantAPayer() {
      return this.montantAPayer;
   }

   public void setMontantAPayer(double var1) {
      this.montantAPayer = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
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

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
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

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
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

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public boolean isShowModalPanelGeneration() {
      return this.showModalPanelGeneration;
   }

   public void setShowModalPanelGeneration(boolean var1) {
      this.showModalPanelGeneration = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
   }

   public String getPdv() {
      return this.pdv;
   }

   public void setPdv(String var1) {
      this.pdv = var1;
   }

   public String getRegion() {
      return this.region;
   }

   public void setRegion(String var1) {
      this.region = var1;
   }

   public String getSecteur() {
      return this.secteur;
   }

   public void setSecteur(String var1) {
      this.secteur = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public String getVar_inputCaisse() {
      return this.var_inputCaisse;
   }

   public void setVar_inputCaisse(String var1) {
      this.var_inputCaisse = var1;
   }

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }
}
