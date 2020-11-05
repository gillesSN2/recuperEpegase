package com.epegase.forms.medical;

import com.epegase.forms.administration.FormPlanComptable;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationLabo;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationPrest;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.TransfertPaye;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.OptionMedical;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormTransfertMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionMedical optionMedical;
   private ExercicesVentes exercicesVentes;
   private EspionDao espionDao;
   private int var_nb_max;
   private String pageIndex;
   private JournauxComptables journauxComptables = new JournauxComptables();
   private JournauxComptablesDao journauxComptablesDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private ConsultationEnteteGene consultationEnteteGene = new ConsultationEnteteGene();
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private ConsultationActes consultationActes = new ConsultationActes();
   private ConsultationActesDao consultationActesDao;
   private PharmacieEntete pharmacieEntete;
   private PharmacieEnteteDao pharmacieEnteteDao;
   private PharmacieLigne pharmacieLigne;
   private PharmacieLigneDao pharmacieLigneDao;
   private LaboratoireEntete laboratoireEntete;
   private LaboratoireEnteteDao laboratoireEnteteDao;
   private LaboratoireLigne laboratoireLigne;
   private LaboratoireLigneDao laboratoireLigneDao;
   private HospitalisationEntete hospitalisationEntete;
   private HospitalisationEnteteDao hospitalisationEnteteDao;
   private HospitalisationActes hospitalisationActes;
   private HospitalisationActesDao hospitalisationActesDao;
   private HospitalisationLabo hospitalisationLabo;
   private HospitalisationLaboDao hospitalisationLaboDao;
   private HospitalisationMedi hospitalisationMedi;
   private HospitalisationMediDao hospitalisationMediDao;
   private HospitalisationSejour hospitalisationSejour;
   private HospitalisationSejourDao hospitalisationSejourDao;
   private HospitalisationPrest hospitalisationPrest;
   private HospitalisationPrestDao hospitalisationPrestDao;
   private FactureEnteteMedical factureEnteteMedical;
   private FactureEnteteMedicalDao factureEnteteMedicalDao;
   private FactureLigneMedical factureLigneMedical;
   private FactureLigneMedicalDao factureLigneMedicalDao;
   private Date inpDu;
   private Date inpAu;
   private String inpPieceDeb;
   private String inpPieceFin;
   private boolean inpDocNonTrf = false;
   private UtilDate utilDate = new UtilDate();
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private boolean var_affiche_bouton = false;
   private int var_choix_importation;
   private List lesTransfertPaye;
   private TransfertPaye transfertPaye;
   private int balance;
   private int naturePatient;
   private int choixRacine;
   private String selecFiscalite;

   public void InstancesDaoUtilses() {
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationActesDao = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationLaboDao = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationPrestDao = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteMedicalDao = new FactureEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void init() {
      if (this.optionMedical.getNbLigneMax() != null && !this.optionMedical.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionMedical.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && (this.choixRacine == 2 || this.choixRacine == 0)) {
         this.choixRacine = 1;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      } else if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.choixRacine == 1) {
         this.choixRacine = 2;
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      } else {
         this.choixRacine = 0;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      }

   }

   public void executerRequete() throws HibernateException, NamingException, IOException, ParseException {
      this.listDocument.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      String var2 = "";
      String var3 = "";
      if (this.inpDu != null && this.inpAu != null) {
         var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
         var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
         var2 = var2 + " 00:00:00";
         var3 = var3 + " 23:59:59";
      }

      if (this.optionMedical.getComptePatient() == null || this.optionMedical.getComptePatient().isEmpty()) {
         this.optionMedical.setComptePatient("411109");
      }

      new ArrayList();
      List var4 = this.consultationEnteteGeneDao.rechercheConsultationATransfererCompta("1", this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            if (((ConsultationEnteteGene)var4.get(var5)).getCsgTotPatient() != 0.0D) {
               DocumentEntete var6 = new DocumentEntete();
               var6.setDocNature(71);
               var6.setDocId(((ConsultationEnteteGene)var4.get(var5)).getCsgId());
               var6.setDocDate(this.utilDate.dateToSQLLight(((ConsultationEnteteGene)var4.get(var5)).getCsgDate()));
               var6.setDocNum(((ConsultationEnteteGene)var4.get(var5)).getCsgNum());
               var6.setDocSerie(((ConsultationEnteteGene)var4.get(var5)).getCsgSerie());
               var6.setDocNomTiers("Patient comptant");
               var6.setDocTotHt(((ConsultationEnteteGene)var4.get(var5)).getCsgTotPatient());
               var6.setDocTotTva(((ConsultationEnteteGene)var4.get(var5)).getCsgTotTaxePatient());
               var6.setDocTotTc(0.0D);
               var6.setDocTotTtc(((ConsultationEnteteGene)var4.get(var5)).getCsgTotPatient() + ((ConsultationEnteteGene)var4.get(var5)).getCsgTotTaxePatient());
               var6.setNumComptetier(this.optionMedical.getComptePatient());
               var6.setDocSelect(true);
               this.listDocument.add(var6);
            }
         }
      }

      new ArrayList();
      List var11 = this.pharmacieEnteteDao.recherchePharmacieATransfererCompta("1", this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
      if (var11.size() != 0) {
         for(int var12 = 0; var12 < var11.size(); ++var12) {
            if (((PharmacieEntete)var11.get(var12)).getPhaTotPatient() != 0.0D) {
               DocumentEntete var7 = new DocumentEntete();
               var7.setDocNature(73);
               var7.setDocId(((PharmacieEntete)var11.get(var12)).getPhaId());
               var7.setDocDate(this.utilDate.dateToSQLLight(((PharmacieEntete)var11.get(var12)).getPhaDate()));
               var7.setDocNum(((PharmacieEntete)var11.get(var12)).getPhaNum());
               var7.setDocSerie(((PharmacieEntete)var11.get(var12)).getPhaSerie());
               var7.setDocNomTiers("Patient comptant");
               var7.setDocTotHt(((PharmacieEntete)var11.get(var12)).getPhaTotPatient());
               var7.setDocTotTva(((PharmacieEntete)var11.get(var12)).getPhaTotTaxePatient());
               var7.setDocTotTc(0.0D);
               var7.setDocTotTtc(((PharmacieEntete)var11.get(var12)).getPhaTotPatient() + ((PharmacieEntete)var11.get(var12)).getPhaTotTaxePatient());
               var7.setNumComptetier(this.optionMedical.getComptePatient());
               var7.setDocSelect(true);
               this.listDocument.add(var7);
            }
         }
      }

      new ArrayList();
      List var13 = this.laboratoireEnteteDao.rechercheLaboratoireATransfererCompta("1", this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
      if (var13.size() != 0) {
         for(int var14 = 0; var14 < var13.size(); ++var14) {
            if (((LaboratoireEntete)var13.get(var14)).getLabTotPatient() != 0.0D) {
               DocumentEntete var8 = new DocumentEntete();
               var8.setDocNature(74);
               var8.setDocId(((LaboratoireEntete)var13.get(var14)).getLabId());
               var8.setDocDate(this.utilDate.dateToSQLLight(((LaboratoireEntete)var13.get(var14)).getLabDate()));
               var8.setDocNum(((LaboratoireEntete)var13.get(var14)).getLabNum());
               var8.setDocSerie(((LaboratoireEntete)var13.get(var14)).getLabSerie());
               var8.setDocNomTiers("Patient comptant");
               var8.setDocTotHt(((LaboratoireEntete)var13.get(var14)).getLabTotPatient());
               var8.setDocTotTva(((LaboratoireEntete)var13.get(var14)).getLabTotTaxePatient());
               var8.setDocTotTc(0.0D);
               var8.setDocTotTtc(((LaboratoireEntete)var13.get(var14)).getLabTotPatient() + ((LaboratoireEntete)var13.get(var14)).getLabTotTaxePatient());
               var8.setNumComptetier(this.optionMedical.getComptePatient());
               var8.setDocSelect(true);
               this.listDocument.add(var8);
            }
         }
      }

      new ArrayList();
      List var15 = this.hospitalisationEnteteDao.rechercheHospitalisationATransfererCompta("1", this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            if (((HospitalisationEntete)var15.get(var16)).getHosTotPatient() != 0.0D) {
               DocumentEntete var9 = new DocumentEntete();
               var9.setDocNature(76);
               var9.setDocId(((HospitalisationEntete)var15.get(var16)).getHosId());
               var9.setDocDate(this.utilDate.dateToSQLLight(((HospitalisationEntete)var15.get(var16)).getHosDateSortie()));
               var9.setDocNum(((HospitalisationEntete)var15.get(var16)).getHosNum());
               var9.setDocSerie(((HospitalisationEntete)var15.get(var16)).getHosSerie());
               var9.setDocNomTiers("Patient comptant");
               var9.setDocTotHt(((HospitalisationEntete)var15.get(var16)).getHosTotPatient());
               var9.setDocTotTva(((HospitalisationEntete)var15.get(var16)).getHosTotTaxePatient());
               var9.setDocTotTc(0.0D);
               var9.setDocTotTtc(((HospitalisationEntete)var15.get(var16)).getHosTotPatient() + ((HospitalisationEntete)var15.get(var16)).getHosTotTaxePatient());
               var9.setNumComptetier(this.optionMedical.getComptePatient());
               var9.setDocSelect(true);
               this.listDocument.add(var9);
            }
         }
      }

      new ArrayList();
      List var17 = this.factureEnteteMedicalDao.rechercheFactureATransfererCompta("1", this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
      if (var17.size() != 0) {
         for(int var18 = 0; var18 < var17.size(); ++var18) {
            DocumentEntete var10 = new DocumentEntete();
            var10.setDocNature(78);
            var10.setDocId(((FactureEnteteMedical)var17.get(var18)).getFacId());
            var10.setDocDate(((FactureEnteteMedical)var17.get(var18)).getFacDate());
            var10.setDocNum(((FactureEnteteMedical)var17.get(var18)).getFacNum());
            var10.setDocSerie(((FactureEnteteMedical)var17.get(var18)).getFacSerie());
            var10.setDocNomTiers(((FactureEnteteMedical)var17.get(var18)).getFacNomTiers());
            var10.setDocTotHt(((FactureEnteteMedical)var17.get(var18)).getFacTotHt());
            var10.setDocTotTva(((FactureEnteteMedical)var17.get(var18)).getFacTotTva());
            var10.setDocTotTc(0.0D);
            var10.setDocTotTtc(((FactureEnteteMedical)var17.get(var18)).getFacTotTtc());
            if (var10.getDocNomTiers() != null && !var10.getDocNomTiers().isEmpty() && var10.getDocNomTiers().equalsIgnoreCase("cnamgs")) {
               if (((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 1 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 11 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 21 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 31) {
                  if (((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 2 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 12 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 22 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 32) {
                     if (((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 3 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 13 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 23 && ((FactureEnteteMedical)var17.get(var18)).getFacFondCnamgs() != 33) {
                        var10.setNumComptetier(this.optionMedical.getCompteCNAMGSAP());
                     } else {
                        var10.setNumComptetier(this.optionMedical.getCompteCNAMGSGEF());
                     }
                  } else {
                     var10.setNumComptetier(this.optionMedical.getCompteCNAMGSSP());
                  }
               } else {
                  var10.setNumComptetier(this.optionMedical.getCompteCNAMGSAP());
               }

               if (var10.getNumComptetier() == null || var10.getNumComptetier().isEmpty()) {
                  var10.setNumComptetier(((FactureEnteteMedical)var17.get(var18)).getTiers().getTiecompte0());
               }
            } else {
               var10.setNumComptetier(((FactureEnteteMedical)var17.get(var18)).getTiers().getTiecompte0());
            }

            var10.setDocSelect(true);
            this.listDocument.add(var10);
         }
      }

      this.utilInitHibernate.closeSession();
      this.verificationCompte();
      this.datamodelDocument.setWrappedData(this.listDocument);
      if (this.listDocument.size() != 0) {
         this.var_affiche_bouton = true;
      } else {
         this.var_affiche_bouton = false;
      }

      this.balance = 1;
   }

   public void verificationCompte() throws HibernateException, NamingException, IOException {
      if (this.listDocument.size() != 0) {
         FormPlanComptable var1 = new FormPlanComptable();
         var1.setStructureLog(this.structureLog);
         var1.setBaseLog(this.baseLog);
         var1.setUsersLog(this.usersLog);
         var1.InstancesDaoUtilses();
         new DocumentEntete();
         new DocumentEntete();
         new PlanComptable();
         new Tiers();
         TiersDao var6 = new TiersDao(this.baseLog, this.utilInitHibernate);
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();

            for(int var9 = 0; var9 < this.listDocument.size(); ++var9) {
               DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var9);
               boolean var10 = false;
               if (var2.getNumComptetier() != null && !var2.getNumComptetier().isEmpty()) {
                  if (var2.getNumComptetier().contains("XXXX")) {
                     var10 = true;
                  }
               } else {
                  var10 = true;
               }

               if (var10) {
                  PlanComptable var4 = var1.creationAuto(this.selecFiscalite, var2.getNumComptetier(), var2.getDocNomTiers(), var7);
                  if (var4 != null) {
                     var2.setNumComptetier(var4.getPlcCompte());
                     Tiers var5 = var6.selectTierD(var2.getDocIdCommercial(), var7);
                     if (var5 != null) {
                        var5.setTiecompte0(var4.getPlcCompte());
                        var6.modif(var5, var7);

                        for(int var11 = var9; var11 < this.listDocument.size(); ++var11) {
                           DocumentEntete var3 = (DocumentEntete)this.listDocument.get(var11);
                           if (var2.getDocIdCommercial() == var3.getDocIdCommercial()) {
                              var3.setNumComptetier(var4.getPlcCompte());
                           }
                        }
                     }
                  }
               }
            }

            var8.commit();
         } catch (HibernateException var15) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var15;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void selectionLigne() {
      if (this.datamodelDocument.isRowAvailable()) {
      }

   }

   public void selectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(true);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public void deSelectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(false);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public void liaisonPaye() {
   }

   public void transfertSalariesImport(List var1) throws HibernateException, NamingException, ParseException, ParseException {
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertPaye = new ArrayList();
      new Salaries();
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            Salaries var2 = (Salaries)var1.get(var3);
            boolean var4 = false;
            if (var2.getSalMatricule() != null && !var2.getSalMatricule().isEmpty()) {
               this.importFicheSalarieePegase(var2);
               this.naturePatient = 0;
               this.balance = 2;
            } else {
               String var5;
               if (var2.getSalActivite().contains("�")) {
                  var5 = var2.getSalActivite().replace("�", "e");
                  var2.setSalActivite(var5);
               }

               var5 = null;
               String[] var7;
               if (this.structureLog.getStrid() == 70L) {
                  if (var2.getSalActivite().contains(";")) {
                     var7 = var2.getSalActivite().split(";");
                  } else {
                     var7 = var2.getSalActivite().split(",");
                  }
               } else {
                  var7 = var2.getSalActivite().split(",");
               }

               int var6 = var7.length;
               if (var6 == 17) {
                  this.transfertPaye = new TransfertPaye();
                  this.importFicheSalarieTemporaire(var7);
                  this.naturePatient = 1;
                  this.balance = 3;
               } else if (var6 == 21) {
                  this.transfertPaye = new TransfertPaye();
                  this.importFicheSalarieEmbauche(var7);
                  this.naturePatient = 2;
                  this.balance = 4;
               }
            }
         }

         if (this.balance == 2 || this.balance == 3 || this.balance == 4) {
            this.datamodelDocument.setWrappedData(this.lesTransfertPaye);
            this.var_affiche_bouton = true;
         }
      }

   }

   public void importFicheSalarieTemporaire(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertPaye.setTrfColT01(var1[0]);
      }

      if (!var1[0].equals("Matricule")) {
         if (var1[1] != null && !var1[1].isEmpty()) {
            this.transfertPaye.setTrfColT02(var1[1].toUpperCase());
         }

         if (var1[2] != null && !var1[2].isEmpty()) {
            this.transfertPaye.setTrfColT03(var1[2].toUpperCase());
         }

         if (var1[3] != null && !var1[3].isEmpty()) {
            this.transfertPaye.setTrfColT04(var1[3]);
         }

         String var2 = null;
         String[] var3;
         if (var1[4] != null && !var1[4].isEmpty()) {
            var2 = var1[4];
            if (var2.length() == 5 || var2.length() == 7) {
               var2 = "0" + var2;
            }

            if (var2.length() == 6) {
               var2 = "20" + var2.substring(4, 6) + "-" + var2.substring(2, 4) + "-" + var2.substring(0, 2);
            } else if (var2.length() == 8) {
               var2 = var2.substring(5, 8) + "-" + var2.substring(3, 5) + "-" + var2.substring(1, 2);
            } else if (var2.length() == 10 && var2.contains("/")) {
               var3 = var2.split("/");
               var2 = var3[2] + "-" + var3[1] + "-" + var3[0];
            }
         }

         this.transfertPaye.setTrfColT05(var2);
         var2 = null;
         if (var1[5] != null && !var1[5].isEmpty()) {
            var2 = var1[5];
            if (var2.length() == 5 || var2.length() == 7) {
               var2 = "0" + var2;
            }

            if (var2.length() == 6) {
               var2 = "20" + var2.substring(4, 6) + "-" + var2.substring(2, 4) + "-" + var2.substring(0, 2);
            } else if (var2.length() == 8) {
               var2 = var2.substring(5, 8) + "-" + var2.substring(3, 5) + "-" + var2.substring(1, 2);
            } else if (var2.length() == 10 && var2.contains("/")) {
               var3 = var2.split("/");
               var2 = var3[2] + "-" + var3[1] + "-" + var3[0];
            }
         }

         this.transfertPaye.setTrfColT06(var2);
         if (var1[6] != null && !var1[6].isEmpty()) {
            this.transfertPaye.setTrfColT07(var1[6]);
         }

         if (var1[7] != null && !var1[7].isEmpty()) {
            this.transfertPaye.setTrfColT08(var1[7]);
         }

         if (var1[8] != null && !var1[8].isEmpty()) {
            this.transfertPaye.setTrfColT09(var1[8]);
         }

         if (var1[9] != null && !var1[9].isEmpty()) {
            this.transfertPaye.setTrfColT10(var1[9]);
         }

         if (var1[10] != null && !var1[10].isEmpty()) {
            this.transfertPaye.setTrfColT11(var1[10]);
         }

         if (var1[11] != null && !var1[11].isEmpty()) {
            this.transfertPaye.setTrfColT12(var1[11]);
         }

         if (var1[12] != null && !var1[12].isEmpty()) {
            this.transfertPaye.setTrfColT13(var1[12]);
         }

         if (var1[13] != null && !var1[13].isEmpty()) {
            this.transfertPaye.setTrfColT14(var1[13].toUpperCase());
         }

         if (var1[14] != null && !var1[14].isEmpty()) {
            this.transfertPaye.setTrfColT15(var1[14].toUpperCase());
         }

         if (var1[15] != null && !var1[15].isEmpty()) {
            this.transfertPaye.setTrfColT16(var1[15].toUpperCase());
         }

         if (var1[16] != null && !var1[16].isEmpty()) {
            this.transfertPaye.setTrfColT17(var1[16].toUpperCase());
         }

         if (this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty()) {
            this.lesTransfertPaye.add(this.transfertPaye);
         }
      }

   }

   public void importFicheSalarieEmbauche(String[] var1) throws ParseException {
      if (var1[0] != null && !var1[0].isEmpty()) {
         this.transfertPaye.setTrfColT01(var1[0]);
      }

      if (var1[1] != null && !var1[1].isEmpty()) {
         this.transfertPaye.setTrfColT02(var1[1].toUpperCase());
      }

      if (var1[2] != null && !var1[2].isEmpty()) {
         this.transfertPaye.setTrfColT03(var1[2].toUpperCase());
      }

      if (var1[3] != null && !var1[3].isEmpty()) {
         this.transfertPaye.setTrfColT04(var1[3]);
      }

      if (var1[4] != null && !var1[4].isEmpty()) {
         this.transfertPaye.setTrfColT05(var1[4]);
      }

      String var2 = null;
      if (var1[5] != null && !var1[5].isEmpty()) {
         var2 = var1[5];
         if (var2.length() == 5 || var2.length() == 7) {
            var2 = "0" + var2;
         }

         if (var2.length() == 6) {
            var2 = "20" + var2.substring(4, 6) + "-" + var2.substring(2, 4) + "-" + var2.substring(0, 2);
         } else if (var2.length() == 8) {
            var2 = var2.substring(5, 8) + "-" + var2.substring(3, 5) + "-" + var2.substring(1, 2);
         }
      }

      this.transfertPaye.setTrfColT06(var2);
      var2 = null;
      if (var1[6] != null && !var1[6].isEmpty()) {
         var2 = var1[6];
         if (var2.length() == 5 || var2.length() == 7) {
            var2 = "0" + var2;
         }

         if (var2.length() == 6) {
            var2 = "20" + var2.substring(4, 6) + "-" + var2.substring(2, 4) + "-" + var2.substring(0, 2);
         } else if (var2.length() == 8) {
            var2 = var2.substring(5, 8) + "-" + var2.substring(3, 5) + "-" + var2.substring(1, 2);
         }
      }

      this.transfertPaye.setTrfColT07(var2);
      if (var1[7] != null && !var1[7].isEmpty()) {
         this.transfertPaye.setTrfColT08(var1[7]);
      }

      if (var1[8] != null && !var1[8].isEmpty()) {
         this.transfertPaye.setTrfColT09(var1[8]);
      }

      if (var1[9] != null && !var1[9].isEmpty()) {
         this.transfertPaye.setTrfColT10(var1[9]);
      }

      if (var1[10] != null && !var1[10].isEmpty()) {
         this.transfertPaye.setTrfColT11(var1[10]);
      }

      if (var1[11] != null && !var1[11].isEmpty()) {
         this.transfertPaye.setTrfColT12(var1[11]);
      }

      if (var1[12] != null && !var1[12].isEmpty()) {
         this.transfertPaye.setTrfColT13(var1[12]);
      }

      if (var1[13] != null && !var1[13].isEmpty()) {
         this.transfertPaye.setTrfColT14(var1[13].toUpperCase());
      }

      if (var1[14] != null && !var1[14].isEmpty()) {
         this.transfertPaye.setTrfColT15(var1[14].toUpperCase());
      }

      if (var1[15] != null && !var1[15].isEmpty()) {
         this.transfertPaye.setTrfColT16(var1[15].toUpperCase());
      }

      if (var1[16] != null && !var1[16].isEmpty()) {
         this.transfertPaye.setTrfColT17(var1[16].toUpperCase());
      }

      var2 = null;
      if (var1[17] != null && !var1[17].isEmpty()) {
         var2 = var1[17];
         if (var2.length() == 5 || var2.length() == 7) {
            var2 = "0" + var2;
         }

         if (var2.length() == 6) {
            var2 = "20" + var2.substring(4, 6) + "-" + var2.substring(2, 4) + "-" + var2.substring(0, 2);
         } else if (var2.length() == 8) {
            var2 = var2.substring(5, 8) + "-" + var2.substring(3, 5) + "-" + var2.substring(1, 2);
         }
      }

      this.transfertPaye.setTrfColT18(var2);
      var2 = null;
      if (var1[18] != null && !var1[18].isEmpty()) {
         var2 = var1[18];
         if (var2.length() == 5 || var2.length() == 7) {
            var2 = "0" + var2;
         }

         if (var2.length() == 6) {
            var2 = "20" + var2.substring(4, 6) + "-" + var2.substring(2, 4) + "-" + var2.substring(0, 2);
         } else if (var2.length() == 8) {
            var2 = var2.substring(5, 8) + "-" + var2.substring(3, 5) + "-" + var2.substring(1, 2);
         }
      }

      this.transfertPaye.setTrfColT19(var2);
      if (var1[19] != null && !var1[19].isEmpty()) {
         this.transfertPaye.setTrfColT20(var1[19].toUpperCase());
      }

      if (this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty()) {
         this.lesTransfertPaye.add(this.transfertPaye);
      }

   }

   public void importFicheSalarieePegase(Salaries var1) {
   }

   public void transfertElevesImport(List var1) throws HibernateException, NamingException, ParseException, ParseException {
   }

   public void transfertPatient() throws HibernateException, NamingException, ParseException {
      if (this.lesTransfertPaye.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new Patients();
            PatientsDao var4 = new PatientsDao(this.baseLog, this.utilInitHibernate);

            for(int var5 = 0; var5 < this.lesTransfertPaye.size(); ++var5) {
               this.transfertPaye = (TransfertPaye)this.lesTransfertPaye.get(var5);
               if (this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty() && !this.transfertPaye.getTrfColT01().equals("matricule")) {
                  Patients var3 = var4.selectPatientsM(this.transfertPaye.getTrfColT01(), var1);
                  if (var3 != null) {
                     if (this.balance == 4) {
                        var3 = this.majEmbauches(var3);
                     } else {
                        var3 = this.majTemporaires(var3);
                        if (var3.getPatCommune() != null && !var3.getPatCommune().isEmpty()) {
                           if (var3.getPatCommune().equalsIgnoreCase("pog")) {
                              var3.setPatCommune("ET02:PORT-GENTIL");
                           } else if (var3.getPatCommune().equalsIgnoreCase("fcv")) {
                              var3.setPatCommune("ET03:FRANCEVILLE");
                           } else if (var3.getPatCommune().equalsIgnoreCase("mol")) {
                              var3.setPatCommune("ET04:MOUILA");
                           } else if (var3.getPatCommune().equalsIgnoreCase("oym")) {
                              var3.setPatCommune("ET05:OYEM");
                           } else if (var3.getPatCommune().equalsIgnoreCase("sob")) {
                              var3.setPatCommune("ET01:SOBOLECO LECONI");
                           } else {
                              var3.setPatCommune("ET01:LIBREVILLE");
                           }
                        } else {
                           var3.setPatCommune("ET01:LIBREVILLE");
                        }
                     }

                     var4.modif(var3, var1);
                  } else {
                     var3 = new Patients();
                     var3.setPatDossier(this.transfertPaye.getTrfColT01());
                     var3.setPatNom(this.transfertPaye.getTrfColT02());
                     var3.setPatPrenom(this.transfertPaye.getTrfColT03());
                     var3.setPatSexe(Integer.parseInt(this.transfertPaye.getTrfColT04()));
                     if (var3.getPatSexe() == 1) {
                        var3.setPatCivilite("Monsieur");
                     } else {
                        var3.setPatCivilite("Mademoiselle");
                     }

                     if (this.balance == 4) {
                        var3 = this.majEmbauches(var3);
                     } else {
                        var3 = this.majTemporaires(var3);
                        if (var3.getPatCommune() != null && !var3.getPatCommune().isEmpty()) {
                           if (var3.getPatCommune().equalsIgnoreCase("pog")) {
                              var3.setPatCommune("ET02:PORT-GENTIL");
                           } else if (var3.getPatCommune().equalsIgnoreCase("fcv")) {
                              var3.setPatCommune("ET03:FRANCEVILLE");
                           } else if (var3.getPatCommune().equalsIgnoreCase("mol")) {
                              var3.setPatCommune("ET04:MOUILA");
                           } else if (var3.getPatCommune().equalsIgnoreCase("oym")) {
                              var3.setPatCommune("ET05:OYEM");
                           } else if (var3.getPatCommune().equalsIgnoreCase("sob")) {
                              var3.setPatCommune("ET01:SOBOLECO LECONI");
                           } else {
                              var3.setPatCommune("ET01:LIBREVILLE");
                           }
                        } else {
                           var3.setPatCommune("ET01:LIBREVILLE");
                        }
                     }

                     var4.insert(var3, var1);
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public Patients majEmbauches(Patients var1) throws ParseException {
      var1.setPatPorte("EMB");
      var1.setPatEtat(Integer.parseInt(this.transfertPaye.getTrfColT05()));
      if (this.transfertPaye.getTrfColT06() != null && !this.transfertPaye.getTrfColT06().isEmpty()) {
         var1.setPatDateNaissance(this.utilDate.stringToDateSQLLight(this.transfertPaye.getTrfColT06()));
      } else {
         var1.setPatDateNaissance((Date)null);
      }

      if (this.transfertPaye.getTrfColT07() != null && !this.transfertPaye.getTrfColT07().isEmpty()) {
         var1.setPatDateEmbauche(this.utilDate.stringToDateSQLLight(this.transfertPaye.getTrfColT07()));
      } else {
         var1.setPatDateEmbauche((Date)null);
      }

      if (this.transfertPaye.getTrfColT08() != null && !this.transfertPaye.getTrfColT08().isEmpty() && this.transfertPaye.getTrfColT08().length() > 49) {
         var1.setPatPaysNaissance(this.transfertPaye.getTrfColT08().substring(49));
      } else {
         var1.setPatPaysNaissance(this.transfertPaye.getTrfColT08());
      }

      var1.setPatPays(this.structureLog.getNomPays());
      if (this.transfertPaye.getTrfColT09() != null && !this.transfertPaye.getTrfColT09().isEmpty() && this.transfertPaye.getTrfColT09().length() > 99) {
         var1.setPatProfession(this.transfertPaye.getTrfColT09().substring(99));
      } else {
         var1.setPatProfession(this.transfertPaye.getTrfColT09());
      }

      if (this.transfertPaye.getTrfColT10() != null && !this.transfertPaye.getTrfColT10().isEmpty() && this.transfertPaye.getTrfColT10().length() > 99) {
         var1.setPatAdresse(this.transfertPaye.getTrfColT10().substring(99));
      } else {
         var1.setPatAdresse(this.transfertPaye.getTrfColT10());
      }

      if (this.transfertPaye.getTrfColT11() != null && !this.transfertPaye.getTrfColT11().isEmpty() && this.transfertPaye.getTrfColT11().length() > 19) {
         var1.setPatCel1(this.transfertPaye.getTrfColT11().substring(19));
      } else {
         var1.setPatCel1(this.transfertPaye.getTrfColT11());
      }

      if (this.transfertPaye.getTrfColT12() != null && !this.transfertPaye.getTrfColT12().isEmpty() && this.transfertPaye.getTrfColT12().length() > 19) {
         var1.setPatCel2(this.transfertPaye.getTrfColT12().substring(19));
      } else {
         var1.setPatCel2(this.transfertPaye.getTrfColT12());
      }

      if (this.transfertPaye.getTrfColT13() != null && !this.transfertPaye.getTrfColT13().isEmpty() && this.transfertPaye.getTrfColT13().length() > 99) {
         var1.setPatMail1(this.transfertPaye.getTrfColT13().substring(99));
      } else {
         var1.setPatMail1(this.transfertPaye.getTrfColT13());
      }

      if (this.transfertPaye.getTrfColT14() != null && !this.transfertPaye.getTrfColT14().isEmpty() && this.transfertPaye.getTrfColT14().length() > 49) {
         var1.setPatCommune(this.transfertPaye.getTrfColT14().substring(49));
      } else {
         var1.setPatCommune(this.transfertPaye.getTrfColT14());
      }

      if (this.transfertPaye.getTrfColT15() != null && !this.transfertPaye.getTrfColT15().isEmpty() && this.transfertPaye.getTrfColT15().length() > 49) {
         var1.setPatDepart(this.transfertPaye.getTrfColT15().substring(49));
      } else {
         var1.setPatDepart(this.transfertPaye.getTrfColT15());
      }

      if (this.transfertPaye.getTrfColT16() != null && !this.transfertPaye.getTrfColT16().isEmpty() && this.transfertPaye.getTrfColT16().length() > 49) {
         var1.setPatZone(this.transfertPaye.getTrfColT16().substring(49));
      } else {
         var1.setPatZone(this.transfertPaye.getTrfColT16());
      }

      if (this.transfertPaye.getTrfColT17() != null && !this.transfertPaye.getTrfColT17().isEmpty() && this.transfertPaye.getTrfColT17().length() > 49) {
         var1.setPatLot(this.transfertPaye.getTrfColT17().substring(49));
      } else {
         var1.setPatLot(this.transfertPaye.getTrfColT17());
      }

      if (this.transfertPaye.getTrfColT18() != null && !this.transfertPaye.getTrfColT18().isEmpty() && this.transfertPaye.getTrfColT18() != null && !this.transfertPaye.getTrfColT18().isEmpty()) {
         var1.setPatDatePrelev1(this.utilDate.stringToDateSQLLight(this.transfertPaye.getTrfColT18()));
      } else {
         var1.setPatDatePrelev1((Date)null);
      }

      if (this.transfertPaye.getTrfColT19() != null && !this.transfertPaye.getTrfColT19().isEmpty() && this.transfertPaye.getTrfColT19() != null && !this.transfertPaye.getTrfColT19().isEmpty()) {
         var1.setPatDatePrelev2(this.utilDate.stringToDateSQLLight(this.transfertPaye.getTrfColT19()));
      } else {
         var1.setPatDatePrelev2((Date)null);
      }

      if (this.transfertPaye.getTrfColT20() != null && !this.transfertPaye.getTrfColT20().isEmpty() && this.transfertPaye.getTrfColT20().length() > 19) {
         var1.setPatSecu(this.transfertPaye.getTrfColT20().substring(19));
      } else {
         var1.setPatSecu(this.transfertPaye.getTrfColT20());
      }

      return var1;
   }

   public Patients majTemporaires(Patients var1) throws ParseException {
      var1.setPatPorte("TMP");
      if (this.transfertPaye.getTrfColT05() != null && !this.transfertPaye.getTrfColT05().isEmpty()) {
         var1.setPatDateNaissance(this.utilDate.stringToDateSQLLight(this.transfertPaye.getTrfColT05()));
      } else {
         var1.setPatDateNaissance((Date)null);
      }

      if (this.transfertPaye.getTrfColT06() != null && !this.transfertPaye.getTrfColT06().isEmpty()) {
         var1.setPatDateEmbauche(this.utilDate.stringToDateSQLLight(this.transfertPaye.getTrfColT06()));
      } else {
         var1.setPatDateEmbauche((Date)null);
      }

      var1.setPatPays(this.structureLog.getNomPays());
      if (this.transfertPaye.getTrfColT07() != null && !this.transfertPaye.getTrfColT07().isEmpty() && this.transfertPaye.getTrfColT07().length() > 49) {
         var1.setPatPaysNaissance(this.transfertPaye.getTrfColT07().substring(49));
      } else {
         var1.setPatPaysNaissance(this.transfertPaye.getTrfColT07());
      }

      if (this.transfertPaye.getTrfColT08() != null && !this.transfertPaye.getTrfColT08().isEmpty() && this.transfertPaye.getTrfColT08().length() > 99) {
         var1.setPatProfession(this.transfertPaye.getTrfColT08().substring(99));
      } else {
         var1.setPatProfession(this.transfertPaye.getTrfColT08());
      }

      var1.setPatEtat(Integer.parseInt(this.transfertPaye.getTrfColT09()));
      if (this.transfertPaye.getTrfColT10() != null && !this.transfertPaye.getTrfColT10().isEmpty() && this.transfertPaye.getTrfColT10().length() > 99) {
         var1.setPatAdresse(this.transfertPaye.getTrfColT10().substring(99));
      } else {
         var1.setPatAdresse(this.transfertPaye.getTrfColT10());
      }

      if (this.transfertPaye.getTrfColT11() != null && !this.transfertPaye.getTrfColT11().isEmpty() && this.transfertPaye.getTrfColT11().length() > 19) {
         var1.setPatCel1(this.transfertPaye.getTrfColT11().substring(19));
      } else {
         var1.setPatCel1(this.transfertPaye.getTrfColT11());
      }

      if (this.transfertPaye.getTrfColT12() != null && !this.transfertPaye.getTrfColT12().isEmpty() && this.transfertPaye.getTrfColT12().length() > 19) {
         var1.setPatCel2(this.transfertPaye.getTrfColT12().substring(19));
      } else {
         var1.setPatCel2(this.transfertPaye.getTrfColT12());
      }

      if (this.transfertPaye.getTrfColT13() != null && !this.transfertPaye.getTrfColT13().isEmpty() && this.transfertPaye.getTrfColT13().length() > 99) {
         var1.setPatMail1(this.transfertPaye.getTrfColT13().substring(99));
      } else {
         var1.setPatMail1(this.transfertPaye.getTrfColT13());
      }

      if (this.transfertPaye.getTrfColT14() != null && !this.transfertPaye.getTrfColT14().isEmpty() && this.transfertPaye.getTrfColT14().length() > 49) {
         var1.setPatCommune(this.transfertPaye.getTrfColT14().substring(49));
      } else {
         var1.setPatCommune(this.transfertPaye.getTrfColT14());
      }

      if (this.transfertPaye.getTrfColT15() != null && !this.transfertPaye.getTrfColT15().isEmpty() && this.transfertPaye.getTrfColT15().length() > 49) {
         var1.setPatDepart(this.transfertPaye.getTrfColT15().substring(49));
      } else {
         var1.setPatDepart(this.transfertPaye.getTrfColT15());
      }

      if (this.transfertPaye.getTrfColT16() != null && !this.transfertPaye.getTrfColT16().isEmpty() && this.transfertPaye.getTrfColT16().length() > 49) {
         var1.setPatZone(this.transfertPaye.getTrfColT16().substring(49));
      } else {
         var1.setPatZone(this.transfertPaye.getTrfColT16());
      }

      if (this.transfertPaye.getTrfColT17() != null && !this.transfertPaye.getTrfColT17().isEmpty() && this.transfertPaye.getTrfColT17().length() > 49) {
         var1.setPatLot(this.transfertPaye.getTrfColT17().substring(49));
      } else {
         var1.setPatLot(this.transfertPaye.getTrfColT17());
      }

      return var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public boolean isInpDocNonTrf() {
      return this.inpDocNonTrf;
   }

   public void setInpDocNonTrf(boolean var1) {
      this.inpDocNonTrf = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public String getInpPieceDeb() {
      return this.inpPieceDeb;
   }

   public void setInpPieceDeb(String var1) {
      this.inpPieceDeb = var1;
   }

   public String getInpPieceFin() {
      return this.inpPieceFin;
   }

   public void setInpPieceFin(String var1) {
      this.inpPieceFin = var1;
   }

   public List getListDocument() {
      return this.listDocument;
   }

   public void setListDocument(List var1) {
      this.listDocument = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getVar_choix_importation() {
      return this.var_choix_importation;
   }

   public void setVar_choix_importation(int var1) {
      this.var_choix_importation = var1;
   }

   public int getBalance() {
      return this.balance;
   }

   public void setBalance(int var1) {
      this.balance = var1;
   }
}
