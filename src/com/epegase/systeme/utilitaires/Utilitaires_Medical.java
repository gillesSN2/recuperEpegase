package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.DevisEnteteMedical;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationCaution;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationLabo;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationPrest;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationInfirmerieDao;
import com.epegase.systeme.dao.ConsultationLaboDao;
import com.epegase.systeme.dao.ConsultationOrdoDao;
import com.epegase.systeme.dao.ConsultationReglementDao;
import com.epegase.systeme.dao.DevisEnteteMedicalDao;
import com.epegase.systeme.dao.DevisLigneMedicalDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationCautionDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationReglementDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LaboratoireReglementDao;
import com.epegase.systeme.dao.LaboratoireResultatDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PharmacieReglementDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Utilitaires_Medical implements Serializable {
   public void suppressionConsultation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ConsultationEnteteGene();
      ConsultationEnteteGeneDao var9 = new ConsultationEnteteGeneDao(var5, var6);
      new ArrayList();
      ConsultationActesDao var11 = new ConsultationActesDao(var5, var6);
      ConsultationInfirmerieDao var12 = new ConsultationInfirmerieDao(var5, var6);
      ConsultationLaboDao var13 = new ConsultationLaboDao(var5, var6);
      ConsultationOrdoDao var14 = new ConsultationOrdoDao(var5, var6);
      ConsultationReglementDao var15 = new ConsultationReglementDao(var5, var6);
      UtilDate var16 = new UtilDate();
      String var17 = var16.dateToStringSQLLight(var1) + " 00:00:00";
      String var18 = var16.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.rechercheConsultationPeriode(var17, var18, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var19 = 0; var19 < var10.size(); ++var19) {
            ConsultationEnteteGene var8 = (ConsultationEnteteGene)var10.get(var19);
            var11.deleteAllLigne(var8, var7);
            var12.deleteConsulInfirmerieByConsultEnt(var8, var7);
            var13.deleteConsulLaboByConsultEnt(var8, var7);
            var14.deleteConsulOrdoByConsultEnt(var8, var7);
            var15.deleteAllLigne(var8, var7);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionPharmacie(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new PharmacieEntete();
      PharmacieEnteteDao var9 = new PharmacieEnteteDao(var5, var6);
      new ArrayList();
      PharmacieLigneDao var11 = new PharmacieLigneDao(var5, var6);
      PharmacieReglementDao var12 = new PharmacieReglementDao(var5, var6);
      UtilDate var13 = new UtilDate();
      String var14 = var13.dateToStringSQLLight(var1) + " 00:00:00";
      String var15 = var13.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.recherchePharmaciePeriode(var14, var15, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var16 = 0; var16 < var10.size(); ++var16) {
            PharmacieEntete var8 = (PharmacieEntete)var10.get(var16);
            var11.deleteAllLigne(var8, var7);
            var12.deleteAllLigne(var8, var7);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionLaboratoire(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new LaboratoireEntete();
      LaboratoireEnteteDao var9 = new LaboratoireEnteteDao(var5, var6);
      new ArrayList();
      LaboratoireLigneDao var11 = new LaboratoireLigneDao(var5, var6);
      LaboratoireResultatDao var12 = new LaboratoireResultatDao(var5, var6);
      LaboratoireReglementDao var13 = new LaboratoireReglementDao(var5, var6);
      UtilDate var14 = new UtilDate();
      String var15 = var14.dateToStringSQLLight(var1) + " 00:00:00";
      String var16 = var14.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.rechercheLaboratoirePeriode(var15, var16, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var17 = 0; var17 < var10.size(); ++var17) {
            LaboratoireEntete var8 = (LaboratoireEntete)var10.get(var17);
            var11.deleteAllLigne(var8, var7);
            var12.deleteAllLigne(var8.getLabNum(), var7);
            var13.deleteAllLigne(var8, var7);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionHospitalisation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new HospitalisationEntete();
      HospitalisationEnteteDao var9 = new HospitalisationEnteteDao(var5, var6);
      new ArrayList();
      HospitalisationActesDao var11 = new HospitalisationActesDao(var5, var6);
      HospitalisationLaboDao var12 = new HospitalisationLaboDao(var5, var6);
      HospitalisationMediDao var13 = new HospitalisationMediDao(var5, var6);
      HospitalisationPrestDao var14 = new HospitalisationPrestDao(var5, var6);
      HospitalisationSejourDao var15 = new HospitalisationSejourDao(var5, var6);
      HospitalisationReglementDao var16 = new HospitalisationReglementDao(var5, var6);
      UtilDate var17 = new UtilDate();
      String var18 = var17.dateToStringSQLLight(var1) + " 00:00:00";
      String var19 = var17.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.rechercheHospitalisationPeriode(var18, var19, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var20 = 0; var20 < var10.size(); ++var20) {
            HospitalisationEntete var8 = (HospitalisationEntete)var10.get(var20);
            var11.deleteAllLigne(var8, var7);
            var12.deleteAllLigne(var8, var7);
            var13.deleteAllLigne(var8, var7);
            var14.deleteAllLigne(var8, var7);
            var15.deleteAllLigne(var8, var7);
            var16.deleteAllLigne(var8, var7);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionDevisMedical(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new DevisEnteteMedical();
      DevisEnteteMedicalDao var9 = new DevisEnteteMedicalDao(var5, var6);
      new ArrayList();
      DevisLigneMedicalDao var11 = new DevisLigneMedicalDao(var5, var6);
      UtilDate var12 = new UtilDate();
      String var13 = var12.dateToStringSQLLight(var1) + " 00:00:00";
      String var14 = var12.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.rechercheDevisPeriode(var13, var14, var7);
      if (var10.size() != 0) {
         for(int var15 = 0; var15 < var10.size(); ++var15) {
            DevisEnteteMedical var8 = (DevisEnteteMedical)var10.get(var15);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionReFacturation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new FactureEnteteMedical();
      FactureEnteteMedicalDao var9 = new FactureEnteteMedicalDao(var5, var6);
      new ArrayList();
      FactureLigneMedicalDao var11 = new FactureLigneMedicalDao(var5, var6);
      List var10 = var9.rechercheFactureByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            FactureEnteteMedical var8 = (FactureEnteteMedical)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getFacId(), var7);
         }
      }

   }

   public void suppressionFactureExterne(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new NoteDebitEnteteVentes();
      NoteDebitEnteteVentesDao var9 = new NoteDebitEnteteVentesDao(var5, var6);
      new ArrayList();
      NoteDebitLigneVentesDao var11 = new NoteDebitLigneVentesDao(var5, var6);
      List var10 = var9.rechercheCommissions(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            NoteDebitEnteteVentes var8 = (NoteDebitEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getNdbId(), var7);
         }
      }

   }

   public void recalculConsultation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ConsultationEnteteGene();
      ConsultationEnteteGeneDao var9 = new ConsultationEnteteGeneDao(var5, var6);
      new ArrayList();
      ConsultationActesDao var11 = new ConsultationActesDao(var5, var6);
      new ArrayList();
      UtilDate var13 = new UtilDate();
      String var14 = var13.dateToStringSQLLight(var1) + " 00:00:00";
      String var15 = var13.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.rechercheConsultationPeriode(var14, var15, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var16 = 0; var16 < var10.size(); ++var16) {
            ConsultationEnteteGene var8 = (ConsultationEnteteGene)var10.get(var16);
            List var12 = var11.selectConsActesByConsEnt(var8, var7);
            double var17 = 0.0D;
            double var19 = 0.0D;
            double var21 = 0.0D;
            double var23 = 0.0D;
            double var25 = 0.0D;
            double var27 = 0.0D;
            double var29 = 0.0D;
            double var31 = 0.0D;
            double var33 = 0.0D;
            double var35 = 0.0D;
            double var37 = 0.0D;
            if (var12.size() != 0) {
               new ConsultationActes();

               for(int var40 = 0; var40 < var12.size(); ++var40) {
                  ConsultationActes var39 = (ConsultationActes)var12.get(var40);
                  var21 += var39.getCslactPatientHt();
                  var23 += var39.getCslactPatientTaxe();
                  var25 += var39.getCslactSocieteHt();
                  var27 += var39.getCslactSocieteTaxe();
                  var29 += var39.getCslactAssuranceHt();
                  var31 += var39.getCslactAssuranceTaxe();
                  var33 += var39.getCslactComplementaireHt();
                  var35 += var39.getCslactComplementaireTaxe();
                  var37 += var39.getCslactRabais();
               }

               var17 = var21 + var25 + var29 + var33;
               var19 = var23 + var27 + var31 + var35;
            }

            var8.setCsgTotPatient(var21);
            var8.setCsgTotTaxePatient(var23);
            var8.setCsgTotSociete(var25);
            var8.setCsgTotTaxeSociete(var27);
            var8.setCsgTotAssurance(var29);
            var8.setCsgTotTaxeAssurance(var31);
            var8.setCsgTotComplmentaire(var33);
            var8.setCsgTotTaxeComplementaire(var35);
            var8.setCsgTotGeneral(var17);
            var8.setCsgTotTaxeGeneral(var19);
            var8.setCsgTotRabais(var37);
            if (var8.getCsgTotAssurance() == 0.0D || !var3.getStrcodepays().equals("0077")) {
               var8.setCsgFondCnamgs(0);
               var8.setCsgPecCnamgs(0.0F);
            }

            var9.modif(var8, var7);
         }
      }

   }

   public void recalculPharmacie(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new PharmacieEntete();
      PharmacieEnteteDao var9 = new PharmacieEnteteDao(var5, var6);
      new ArrayList();
      PharmacieLigneDao var11 = new PharmacieLigneDao(var5, var6);
      new ArrayList();
      UtilDate var13 = new UtilDate();
      String var14 = var13.dateToStringSQLLight(var1) + " 00:00:00";
      String var15 = var13.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.recherchePharmaciePeriode(var14, var15, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var16 = 0; var16 < var10.size(); ++var16) {
            PharmacieEntete var8 = (PharmacieEntete)var10.get(var16);
            double var17 = 0.0D;
            double var19 = 0.0D;
            double var21 = 0.0D;
            double var23 = 0.0D;
            double var25 = 0.0D;
            double var27 = 0.0D;
            double var29 = 0.0D;
            double var31 = 0.0D;
            double var33 = 0.0D;
            double var35 = 0.0D;
            double var37 = 0.0D;
            List var12 = var11.selectConsActesByConsEnt(var8, var7);
            if (var12.size() != 0) {
               new PharmacieLigne();

               for(int var40 = 0; var40 < var12.size(); ++var40) {
                  PharmacieLigne var39 = (PharmacieLigne)var12.get(var40);
                  var21 += var39.getPhaligPatientHt();
                  var23 += var39.getPhaligPatientTaxe();
                  var25 += var39.getPhaligSocieteHt();
                  var27 += var39.getPhaligSocieteTaxe();
                  var29 += var39.getPhaligAssuranceHt();
                  var31 += var39.getPhaligAssuranceTaxe();
                  var33 += var39.getPhaligComplementaireHt();
                  var35 += var39.getPhaligComplementaireTaxe();
                  var37 += var39.getPhaligRabais();
               }

               var17 = var21 + var25 + var29 + var33;
               var19 = var23 + var27 + var31 + var35;
            }

            var8.setPhaTotPatient(var21);
            var8.setPhaTotTaxePatient(var23);
            var8.setPhaTotSociete(var25);
            var8.setPhaTotTaxeSociete(var27);
            var8.setPhaTotAssurance(var29);
            var8.setPhaTotTaxeAssurance(var31);
            var8.setPhaTotComplmentaire(var33);
            var8.setPhaTotTaxeComplementaire(var35);
            var8.setPhaTotGeneral(var17);
            var8.setPhaTotTaxeGeneral(var19);
            var8.setPhaTotRabais(var37);
            if (var8.getPhaTotAssurance() == 0.0D || !var3.getStrcodepays().equals("0077")) {
               var8.setPhaFondCnamgs(0);
               var8.setPhaPecCnamgs(0.0F);
            }

            var9.modif(var8, var7);
         }
      }

   }

   public void recalculLaboratoire(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new LaboratoireEntete();
      LaboratoireEnteteDao var9 = new LaboratoireEnteteDao(var5, var6);
      new ArrayList();
      LaboratoireLigneDao var11 = new LaboratoireLigneDao(var5, var6);
      new ArrayList();
      UtilDate var13 = new UtilDate();
      String var14 = var13.dateToStringSQLLight(var1) + " 00:00:00";
      String var15 = var13.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.rechercheLaboratoirePeriode(var14, var15, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var16 = 0; var16 < var10.size(); ++var16) {
            LaboratoireEntete var8 = (LaboratoireEntete)var10.get(var16);
            double var17 = 0.0D;
            double var19 = 0.0D;
            double var21 = 0.0D;
            double var23 = 0.0D;
            double var25 = 0.0D;
            double var27 = 0.0D;
            double var29 = 0.0D;
            double var31 = 0.0D;
            double var33 = 0.0D;
            double var35 = 0.0D;
            double var37 = 0.0D;
            List var12 = var11.selectConsActesByConsEnt(var8, var7);
            if (var12.size() != 0) {
               new LaboratoireLigne();

               for(int var40 = 0; var40 < var12.size(); ++var40) {
                  LaboratoireLigne var39 = (LaboratoireLigne)var12.get(var40);
                  var21 += var39.getLabligPatientHt();
                  var23 += var39.getLabligPatientTaxe();
                  var25 += var39.getLabligSocieteHt();
                  var27 += var39.getLabligSocieteTaxe();
                  var29 += var39.getLabligAssuranceHt();
                  var31 += var39.getLabligAssuranceTaxe();
                  var33 += var39.getLabligComplementaireHt();
                  var35 += var39.getLabligComplementaireTaxe();
                  var37 += var39.getLabligRabais();
               }

               var17 = var21 + var25 + var29 + var33;
               var19 = var23 + var27 + var31 + var35;
            }

            var8.setLabTotPatient(var21);
            var8.setLabTotTaxePatient(var23);
            var8.setLabTotSociete(var25);
            var8.setLabTotTaxeSociete(var27);
            var8.setLabTotAssurance(var29);
            var8.setLabTotTaxeAssurance(var31);
            var8.setLabTotComplmentaire(var33);
            var8.setLabTotTaxeComplementaire(var35);
            var8.setLabTotGeneral(var17);
            var8.setLabTotTaxeGeneral(var19);
            var8.setLabTotRabais(var37);
            if (var8.getLabTotAssurance() == 0.0D || !var3.getStrcodepays().equals("0077")) {
               var8.setLabFondCnamgs(0);
               var8.setLabPecCnamgs(0.0F);
            }

            var9.modif(var8, var7);
         }
      }

   }

   public void recalculHospitalisation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new HospitalisationEntete();
      HospitalisationEnteteDao var9 = new HospitalisationEnteteDao(var5, var6);
      new ArrayList();
      HospitalisationActesDao var11 = new HospitalisationActesDao(var5, var6);
      new ArrayList();
      HospitalisationLaboDao var13 = new HospitalisationLaboDao(var5, var6);
      new ArrayList();
      HospitalisationMediDao var15 = new HospitalisationMediDao(var5, var6);
      new ArrayList();
      HospitalisationPrestDao var17 = new HospitalisationPrestDao(var5, var6);
      new ArrayList();
      HospitalisationSejourDao var19 = new HospitalisationSejourDao(var5, var6);
      new ArrayList();
      HospitalisationCautionDao var21 = new HospitalisationCautionDao(var5, var6);
      new ArrayList();
      UtilDate var23 = new UtilDate();
      String var24 = var23.dateToStringSQLLight(var1) + " 00:00:00";
      String var25 = var23.dateToStringSQLLight(var2) + " 23:59:59";
      List var10 = var9.rechercheHospitalisationPeriode(var24, var25, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var26 = 0; var26 < var10.size(); ++var26) {
            HospitalisationEntete var8 = (HospitalisationEntete)var10.get(var26);
            List var20 = var19.selectSejourByEnt(var8, var7);
            List var22 = var21.selectReglementByEnt(var8, var7);
            List var12 = var11.selectActesByEnt(var8, var7);
            List var16 = var15.selectMediByEnt(var8, var7);
            List var14 = var13.selectLaboByEnt(var8, var7);
            List var18 = var17.selectPrestByEnt(var8, var7);
            double var27 = 0.0D;
            double var29 = 0.0D;
            double var31 = 0.0D;
            double var33 = 0.0D;
            double var35 = 0.0D;
            double var37 = 0.0D;
            double var39 = 0.0D;
            double var41 = 0.0D;
            double var43 = 0.0D;
            double var45 = 0.0D;
            double var47 = 0.0D;
            double var49 = 0.0D;
            int var52;
            if (var20.size() != 0) {
               new HospitalisationSejour();

               for(var52 = 0; var52 < var20.size(); ++var52) {
                  HospitalisationSejour var51 = (HospitalisationSejour)var20.get(var52);
                  var33 += var51.getHossejPatientHt();
                  var35 += var51.getHossejPatientTaxe();
                  var37 += var51.getHossejSocieteHt();
                  var39 += var51.getHossejSocieteTaxe();
                  var41 += var51.getHossejAssuranceHt();
                  var43 += var51.getHossejAssuranceTaxe();
                  var45 += var51.getHossejComplementaireHt();
                  var47 += var51.getHossejComplementaireTaxe();
                  var49 += var51.getHossejRabais();
               }
            }

            if (var22.size() != 0) {
               new HospitalisationCaution();

               for(var52 = 0; var52 < var22.size(); ++var52) {
                  HospitalisationCaution var53 = (HospitalisationCaution)var22.get(var52);
                  if (var53.getHoscauIdRecu() != 0L) {
                     var27 += var53.getHoscauMontant();
                  }
               }
            }

            if (var12.size() != 0) {
               new HospitalisationActes();

               for(var52 = 0; var52 < var12.size(); ++var52) {
                  HospitalisationActes var54 = (HospitalisationActes)var12.get(var52);
                  var33 += var54.getHosactPatientHt();
                  var35 += var54.getHosactPatientTaxe();
                  var37 += var54.getHosactSocieteHt();
                  var39 += var54.getHosactSocieteTaxe();
                  var41 += var54.getHosactAssuranceHt();
                  var43 += var54.getHosactAssuranceTaxe();
                  var45 += var54.getHosactComplementaireHt();
                  var47 += var54.getHosactComplementaireTaxe();
                  var49 += var54.getHosactRabais();
               }
            }

            if (var16.size() != 0) {
               new HospitalisationMedi();

               for(var52 = 0; var52 < var16.size(); ++var52) {
                  HospitalisationMedi var55 = (HospitalisationMedi)var16.get(var52);
                  var33 += var55.getHosmedPatientHt();
                  var35 += var55.getHosmedPatientTaxe();
                  var37 += var55.getHosmedSocieteHt();
                  var39 += var55.getHosmedSocieteTaxe();
                  var41 += var55.getHosmedAssuranceHt();
                  var43 += var55.getHosmedAssuranceTaxe();
                  var45 += var55.getHosmedComplementaireHt();
                  var47 += var55.getHosmedComplementaireTaxe();
                  var49 += var55.getHosmedRabais();
               }
            }

            if (var14.size() != 0) {
               new HospitalisationLabo();

               for(var52 = 0; var52 < var14.size(); ++var52) {
                  HospitalisationLabo var56 = (HospitalisationLabo)var14.get(var52);
                  var33 += var56.getHoslabPatientHt();
                  var35 += var56.getHoslabPatientTaxe();
                  var37 += var56.getHoslabSocieteHt();
                  var39 += var56.getHoslabSocieteTaxe();
                  var41 += var56.getHoslabAssuranceHt();
                  var43 += var56.getHoslabAssuranceTaxe();
                  var45 += var56.getHoslabComplementaireHt();
                  var47 += var56.getHoslabComplementaireTaxe();
                  var49 += var56.getHoslabRabais();
               }
            }

            if (var18.size() != 0) {
               new HospitalisationPrest();

               for(var52 = 0; var52 < var18.size(); ++var52) {
                  HospitalisationPrest var57 = (HospitalisationPrest)var18.get(var52);
                  var33 += var57.getHosprtPatientHt();
                  var35 += var57.getHosprtPatientTaxe();
                  var37 += var57.getHosprtSocieteHt();
                  var39 += var57.getHosprtSocieteTaxe();
                  var41 += var57.getHosprtAssuranceHt();
                  var43 += var57.getHosprtAssuranceTaxe();
                  var45 += var57.getHosprtComplementaireHt();
                  var47 += var57.getHosprtComplementaireTaxe();
                  var49 += var57.getHosprtRabais();
               }
            }

            var29 = var33 + var37 + var41 + var45;
            var31 = var35 + var39 + var43 + var47;
            var8.setHosTotPatient(var33);
            var8.setHosTotTaxePatient(var35);
            var8.setHosTotSociete(var37);
            var8.setHosTotTaxeSociete(var39);
            var8.setHosTotAssurance(var41);
            var8.setHosTotTaxeAssurance(var43);
            var8.setHosTotComplmentaire(var45);
            var8.setHosTotTaxeComplementaire(var47);
            var8.setHosTotGeneral(var29);
            var8.setHosTotTaxeGeneral(var31);
            var8.setHosTotCaution(var27);
            var8.setHosTotRabais(var49);
            if (var8.getHosTotAssurance() == 0.0D || !var3.getStrcodepays().equals("0077")) {
               var8.setHosFondCnamgs(0);
               var8.setHosPecCnamgs(0.0F);
            }

            var9.modif(var8, var7);
         }
      }

   }

   public List rechercherAnnulTrfMedical(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException {
      ConsultationEnteteGeneDao var6 = new ConsultationEnteteGeneDao(var4, var5);
      PharmacieEnteteDao var7 = new PharmacieEnteteDao(var4, var5);
      LaboratoireEnteteDao var8 = new LaboratoireEnteteDao(var4, var5);
      HospitalisationEnteteDao var9 = new HospitalisationEnteteDao(var4, var5);
      FactureEnteteMedicalDao var10 = new FactureEnteteMedicalDao(var4, var5);
      Session var11 = var5.getOpenSession(var4, "EcrituresMedical");
      new DocumentEntete();
      UtilDate var13 = new UtilDate();
      String var14 = var13.dateToStringSQLLight(var1) + " 00:00:00";
      String var15 = var13.dateToStringSQLLight(var2) + " 23:59:59";
      new ArrayList();
      List var16 = var6.rechercheConsultationDejaTransfererCompta(var14, var15, var11);
      DocumentEntete var12;
      if (var16.size() != 0) {
         new ConsultationEnteteGene();

         for(int var18 = 0; var18 < var16.size(); ++var18) {
            ConsultationEnteteGene var17 = (ConsultationEnteteGene)var16.get(var18);
            if (var17.getCsgDateTransfert() != null) {
               var12 = new DocumentEntete();
               var12.setDocId(var17.getCsgId());
               var12.setDocDate(var17.getCsgDate());
               var12.setDocNum(var17.getCsgNum());
               var12.setDocSerie(var17.getCsgSerie());
               var12.setDocNature(71);
               var12.setDocNomTiers(var17.getCsgNomPatient());
               if (var17.getCsgNomAssurance() != null && !var17.getCsgNomAssurance().isEmpty()) {
                  var12.setDocNomContact(var17.getCsgNomAssurance());
               } else if (var17.getCsgNomSociete() != null && !var17.getCsgNomSociete().isEmpty()) {
                  var12.setDocNomContact(var17.getCsgNomSociete());
               } else if (var17.getCsgNomComplemtaire() != null && !var17.getCsgNomComplemtaire().isEmpty()) {
                  var12.setDocNomContact(var17.getCsgNomComplemtaire());
               } else {
                  var12.setDocNomContact("");
               }

               var12.setDocTotHt(var17.getTotalTiers());
               var12.setDocTotTva(var17.getTotalPatient());
               var12.setDocTotTtc(var17.getCsgTotGeneral());
               var12.setDocAnal4(var17.getCsgEntree());
               var12.setDocObject(var17.getCsgMedecin());
               var3.add(var12);
            }
         }
      }

      new ArrayList();
      List var23 = var7.recherchePharmacieDejaTransfererCompta(var14, var15, var11);
      if (var23.size() != 0) {
         new PharmacieEntete();

         for(int var19 = 0; var19 < var23.size(); ++var19) {
            PharmacieEntete var24 = (PharmacieEntete)var23.get(var19);
            if (var24.getPhaDateTransfert() != null) {
               var12 = new DocumentEntete();
               var12.setDocId(var24.getPhaId());
               var12.setDocDate(var24.getPhaDate());
               var12.setDocNum(var24.getPhaNum());
               var12.setDocSerie(var24.getPhaSerie());
               var12.setDocNature(73);
               var12.setDocNomTiers(var24.getPhaNomPatient());
               if (var24.getPhaNomAssurance() != null && !var24.getPhaNomAssurance().isEmpty()) {
                  var12.setDocNomContact(var24.getPhaNomAssurance());
               } else if (var24.getPhaNomSociete() != null && !var24.getPhaNomSociete().isEmpty()) {
                  var12.setDocNomContact(var24.getPhaNomSociete());
               } else if (var24.getPhaNomComplemtaire() != null && !var24.getPhaNomComplemtaire().isEmpty()) {
                  var12.setDocNomContact(var24.getPhaNomComplemtaire());
               } else {
                  var12.setDocNomContact("");
               }

               var12.setDocTotHt(var24.getTotalTiers());
               var12.setDocTotTva(var24.getTotalPatient());
               var12.setDocTotTtc(var24.getPhaTotGeneral());
               var12.setDocAnal4("");
               var12.setDocObject(var24.getPhaMedecin());
               var3.add(var12);
            }
         }
      }

      new ArrayList();
      List var25 = var8.rechercheLaboratoireDejaTransfererCompta(var14, var15, var11);
      if (var25.size() != 0) {
         new LaboratoireEntete();

         for(int var20 = 0; var20 < var25.size(); ++var20) {
            LaboratoireEntete var26 = (LaboratoireEntete)var25.get(var20);
            if (var26.getLabDateTransfert() != null) {
               var12 = new DocumentEntete();
               var12.setDocId(var26.getLabId());
               var12.setDocDate(var26.getLabDate());
               var12.setDocNum(var26.getLabNum());
               var12.setDocSerie(var26.getLabSerie());
               var12.setDocNature(74);
               var12.setDocNomTiers(var26.getLabNomPatient());
               if (var26.getLabNomAssurance() != null && !var26.getLabNomAssurance().isEmpty()) {
                  var12.setDocNomContact(var26.getLabNomAssurance());
               } else if (var26.getLabNomSociete() != null && !var26.getLabNomSociete().isEmpty()) {
                  var12.setDocNomContact(var26.getLabNomSociete());
               } else if (var26.getLabNomComplemtaire() != null && !var26.getLabNomComplemtaire().isEmpty()) {
                  var12.setDocNomContact(var26.getLabNomComplemtaire());
               } else {
                  var12.setDocNomContact("");
               }

               var12.setDocTotHt(var26.getTotalTiers());
               var12.setDocTotTva(var26.getTotalPatient());
               var12.setDocTotTtc(var26.getLabTotGeneral());
               var12.setDocAnal4(var26.getLabEntree());
               var12.setDocObject(var26.getLabMedecin());
               var3.add(var12);
            }
         }
      }

      new ArrayList();
      List var27 = var9.rechercheHospitalisationDejaTransfererCompta(var14, var15, var11);
      if (var27.size() != 0) {
         new HospitalisationEntete();

         for(int var21 = 0; var21 < var27.size(); ++var21) {
            HospitalisationEntete var28 = (HospitalisationEntete)var27.get(var21);
            if (var28.getHosDateTransfert() != null) {
               var12 = new DocumentEntete();
               var12.setDocId(var28.getHosId());
               var12.setDocDate(var28.getHosDateSortie());
               var12.setDocNum(var28.getHosNum());
               var12.setDocSerie(var28.getHosSerie());
               var12.setDocNature(76);
               var12.setDocNomTiers(var28.getHosNomPatient());
               if (var28.getHosNomAssurance() != null && !var28.getHosNomAssurance().isEmpty()) {
                  var12.setDocNomContact(var28.getHosNomAssurance());
               } else if (var28.getHosNomSociete() != null && !var28.getHosNomSociete().isEmpty()) {
                  var12.setDocNomContact(var28.getHosNomSociete());
               } else if (var28.getHosNomComplemtaire() != null && !var28.getHosNomComplemtaire().isEmpty()) {
                  var12.setDocNomContact(var28.getHosNomComplemtaire());
               } else {
                  var12.setDocNomContact("");
               }

               var12.setDocTotHt(var28.getTotalTiers());
               var12.setDocTotTva(var28.getTotalPatient());
               var12.setDocTotTtc(var28.getHosTotGeneral());
               var12.setDocAnal4(var28.getHosMotifEntree());
               var12.setDocObject(var28.getHosMedecin());
               var3.add(var12);
            }
         }
      }

      new ArrayList();
      List var29 = var10.rechercheFactureDejaTransfererCompta(var14, var15, var11);
      if (var29.size() != 0) {
         new FactureEnteteMedical();

         for(int var22 = 0; var22 < var29.size(); ++var22) {
            FactureEnteteMedical var30 = (FactureEnteteMedical)var29.get(var22);
            if (var30.getFacDateTransfert() != null) {
               var12 = new DocumentEntete();
               var12.setDocId(var30.getFacId());
               var12.setDocDate(var30.getFacDate());
               var12.setDocNum(var30.getFacNum());
               var12.setDocSerie(var30.getFacSerie());
               var12.setDocNature(78);
               var12.setDocNomTiers(var30.getFacNomTiers());
               var12.setDocNomContact("");
               var12.setDocTotHt(var30.getFacTotHt());
               var12.setDocTotTva(var30.getFacTotTva());
               var12.setDocTotTtc(var30.getFacTotTtc());
               var12.setDocAnal4(var30.getFacAnal4());
               var12.setDocObject(var30.getFacObject());
               var3.add(var12);
            }
         }
      }

      return var3;
   }

   public void annulTrfMedical(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException {
      Session var6 = var5.getOpenSession(var4, "EcrituresMedical");
      EcrituresAnalytiquesDao var7 = new EcrituresAnalytiquesDao(var4, var5);
      EcrituresDao var8 = new EcrituresDao(var4, var5);
      new BrouillardDao(var4, var5);
      ConsultationEnteteGeneDao var10 = new ConsultationEnteteGeneDao(var4, var5);
      PharmacieEnteteDao var11 = new PharmacieEnteteDao(var4, var5);
      LaboratoireEnteteDao var12 = new LaboratoireEnteteDao(var4, var5);
      HospitalisationEnteteDao var13 = new HospitalisationEnteteDao(var4, var5);
      FactureEnteteMedicalDao var14 = new FactureEnteteMedicalDao(var4, var5);
      String var15 = "";
      String var16 = "";
      String var17 = "";
      String var18 = "";
      String var19 = "";
      boolean var20 = true;
      Transaction var21 = null;

      List var22;
      EcrituresAnalytique var23;
      try {
         var21 = var6.beginTransaction();
         new ArrayList();
         new EcrituresAnalytique();

         for(int var24 = 0; var24 < var3.size(); ++var24) {
            if (((DocumentEntete)var3.get(var24)).isDocSelect()) {
               if (((DocumentEntete)var3.get(var24)).getDocNature() == 71) {
                  if (var15 != null && !var15.isEmpty()) {
                     var15 = var15 + "," + ((DocumentEntete)var3.get(var24)).getDocId();
                  } else {
                     var15 = "" + ((DocumentEntete)var3.get(var24)).getDocId();
                  }
               } else if (((DocumentEntete)var3.get(var24)).getDocNature() == 73) {
                  if (var16 != null && !var16.isEmpty()) {
                     var16 = var16 + "," + ((DocumentEntete)var3.get(var24)).getDocId();
                  } else {
                     var16 = "" + ((DocumentEntete)var3.get(var24)).getDocId();
                  }
               } else if (((DocumentEntete)var3.get(var24)).getDocNature() == 74) {
                  if (var17 != null && !var17.isEmpty()) {
                     var17 = var17 + "," + ((DocumentEntete)var3.get(var24)).getDocId();
                  } else {
                     var17 = "" + ((DocumentEntete)var3.get(var24)).getDocId();
                  }
               } else if (((DocumentEntete)var3.get(var24)).getDocNature() == 76) {
                  if (var18 != null && !var18.isEmpty()) {
                     var18 = var18 + "," + ((DocumentEntete)var3.get(var24)).getDocId();
                  } else {
                     var18 = "" + ((DocumentEntete)var3.get(var24)).getDocId();
                  }
               } else if (((DocumentEntete)var3.get(var24)).getDocNature() == 78) {
                  if (var19 != null && !var19.isEmpty()) {
                     var19 = var19 + "," + ((DocumentEntete)var3.get(var24)).getDocId();
                  } else {
                     var19 = "" + ((DocumentEntete)var3.get(var24)).getDocId();
                  }
               }
            }
         }

         String var58 = "";
         if (var15 != null && !var15.isEmpty()) {
            var58 = " (ecritures.ecrTypeOrigine='71' and ecritures.ecrIdOrigine in (" + var15 + "))";
         }

         if (var16 != null && !var16.isEmpty()) {
            if (var58 != null && !var58.isEmpty()) {
               var58 = var58 + " or (ecritures.ecrTypeOrigine='73' and ecritures.ecrIdOrigine in (" + var16 + "))";
            } else {
               var58 = " (ecritures.ecrTypeOrigine='73' and ecritures.ecrIdOrigine in (" + var16 + "))";
            }
         }

         if (var17 != null && !var17.isEmpty()) {
            if (var58 != null && !var58.isEmpty()) {
               var58 = var58 + " or (ecritures.ecrTypeOrigine='74' and ecritures.ecrIdOrigine in (" + var17 + "))";
            } else {
               var58 = " (ecritures.ecrTypeOrigine='74' and ecritures.ecrIdOrigine in (" + var17 + "))";
            }
         }

         if (var18 != null && !var18.isEmpty()) {
            if (var58 != null && !var58.isEmpty()) {
               var58 = var58 + " or (ecritures.ecrTypeOrigine='76' and ecritures.ecrIdOrigine in (" + var18 + "))";
            } else {
               var58 = " (ecritures.ecrTypeOrigine='76' and ecritures.ecrIdOrigine in (" + var18 + "))";
            }
         }

         if (var19 != null && !var19.isEmpty()) {
            if (var58 != null && !var58.isEmpty()) {
               var58 = var58 + " or (ecritures.ecrTypeOrigine='78' and ecritures.ecrIdOrigine in (" + var19 + "))";
            } else {
               var58 = " (ecritures.ecrTypeOrigine='78' and ecritures.ecrIdOrigine in (" + var19 + "))";
            }
         }

         if (var58 != null && !var58.isEmpty()) {
            var22 = var7.ChargerLesEcrituresanalytiquesRecherche(var58, var6);
            if (var22.size() != 0) {
               for(int var25 = 0; var25 < var22.size(); ++var25) {
                  var23 = (EcrituresAnalytique)var22.get(var25);
                  var7.nettoyageAnalytique(var23, var6);
               }
            }
         }

         var21.commit();
      } catch (HibernateException var54) {
         if (var21 != null) {
            var20 = false;
            var21.rollback();
         }

         throw var54;
      } finally {
         var5.closeSession();
      }

      if (var20) {
         var6 = var5.getOpenSession(var4, "EcrituresMedical");
         var22 = null;

         try {
            Transaction var56 = var6.beginTransaction();
            String var57 = "";
            if (var15 != null && !var15.isEmpty()) {
               var57 = " (ecrTypeOrigine='71' and ecrIdOrigine in (" + var15 + "))";
            }

            if (var16 != null && !var16.isEmpty()) {
               if (var57 != null && !var57.isEmpty()) {
                  var57 = var57 + " or (ecrTypeOrigine='73' and ecrIdOrigine in (" + var16 + "))";
               } else {
                  var57 = " (ecrTypeOrigine='73' and ecrIdOrigine in (" + var16 + "))";
               }
            }

            if (var17 != null && !var17.isEmpty()) {
               if (var57 != null && !var57.isEmpty()) {
                  var57 = var57 + " or (ecrTypeOrigine='74' and ecrIdOrigine in (" + var17 + "))";
               } else {
                  var57 = " (ecrTypeOrigine='74' and ecrIdOrigine in (" + var17 + "))";
               }
            }

            if (var18 != null && !var18.isEmpty()) {
               if (var57 != null && !var57.isEmpty()) {
                  var57 = var57 + " or (ecrTypeOrigine='76' and ecrIdOrigine in (" + var18 + "))";
               } else {
                  var57 = " (ecrTypeOrigine='76' and ecrIdOrigine in (" + var18 + "))";
               }
            }

            if (var19 != null && !var19.isEmpty()) {
               if (var57 != null && !var57.isEmpty()) {
                  var57 = var57 + " or (ecrTypeOrigine='78' and ecrIdOrigine in (" + var19 + "))";
               } else {
                  var57 = " (ecrTypeOrigine='78' and ecrIdOrigine in (" + var19 + "))";
               }
            }

            if (var57 != null && !var57.isEmpty()) {
               new ArrayList();
               List var63 = var8.ChargerLesEcrituresRecherche(var57, var6);
               if (var63.size() != 0) {
                  new Ecritures();

                  for(int var26 = 0; var26 < var63.size(); ++var26) {
                     Ecritures var59 = (Ecritures)var63.get(var26);
                     var8.removeSelectedEC0(var59, 0, var6);
                  }
               }
            }

            var56.commit();
         } catch (HibernateException var52) {
            if (var22 != null) {
               var20 = false;
               var22.rollback();
            }

            throw var52;
         } finally {
            var5.closeSession();
         }

         if (var20) {
            var20 = true;
            if (var20) {
               var6 = var5.getOpenSession(var4, "EcrituresMedical");
               var23 = null;

               try {
                  Transaction var62 = var6.beginTransaction();
                  if (var3.size() != 0) {
                     new DocumentEntete();
                     new ConsultationEnteteGene();
                     new PharmacieEntete();
                     new LaboratoireEntete();
                     new HospitalisationEntete();
                     new FactureEnteteMedical();

                     for(int var30 = 0; var30 < var3.size(); ++var30) {
                        DocumentEntete var64 = (DocumentEntete)var3.get(var30);
                        if (var64.isDocSelect()) {
                           if (var64.getDocNature() == 71) {
                              ConsultationEnteteGene var60 = var10.selectById(var64.getDocId(), var6);
                              if (var60 != null) {
                                 var60.setCsgDateTransfert((Date)null);
                                 var10.modif(var60, var6);
                              }
                           } else if (var64.getDocNature() == 73) {
                              PharmacieEntete var61 = var11.selectById(var64.getDocId(), var6);
                              if (var61 != null) {
                                 var61.setPhaDateTransfert((Date)null);
                                 var11.modif(var61, var6);
                              }
                           } else if (var64.getDocNature() == 74) {
                              LaboratoireEntete var27 = var12.selectById(var64.getDocId(), var6);
                              if (var27 != null) {
                                 var27.setLabDateTransfert((Date)null);
                                 var12.modif(var27, var6);
                              }
                           } else if (var64.getDocNature() == 76) {
                              HospitalisationEntete var28 = var13.selectById(var64.getDocId(), var6);
                              if (var28 != null) {
                                 var28.setHosDateTransfert((Date)null);
                                 var13.modif(var28, var6);
                              }
                           } else if (var64.getDocNature() == 78) {
                              FactureEnteteMedical var29 = var14.pourParapheur(var64.getDocId(), var6);
                              if (var29 != null) {
                                 var29.setFacDateTransfert((Date)null);
                                 var14.modif(var29, var6);
                              }
                           }
                        }
                     }
                  }

                  var62.commit();
               } catch (HibernateException var50) {
                  if (var23 != null) {
                     var23.rollback();
                  }

                  throw var50;
               } finally {
                  var5.closeSession();
               }
            }
         }
      }

   }

   public void forceTrfMedical(Date var1, Date var2, String var3, UtilInitHibernate var4) throws HibernateException, NamingException {
      Session var5 = var4.getOpenSession(var3, "EcrituresVentes");
      ConsultationEnteteGeneDao var6 = new ConsultationEnteteGeneDao(var3, var4);
      PharmacieEnteteDao var7 = new PharmacieEnteteDao(var3, var4);
      LaboratoireEnteteDao var8 = new LaboratoireEnteteDao(var3, var4);
      HospitalisationEnteteDao var9 = new HospitalisationEnteteDao(var3, var4);
      FactureEnteteMedicalDao var10 = new FactureEnteteMedicalDao(var3, var4);
      Transaction var11 = null;

      try {
         var11 = var5.beginTransaction();
         UtilDate var12 = new UtilDate();
         String var13 = var12.dateToStringSQLLight(var1) + " 00:00:00";
         String var14 = var12.dateToStringSQLLight(var2) + " 23:59:59";
         new ArrayList();
         List var15 = var6.rechercheConsultationATransfererCompta("1", "", "", var13, var14, false, var5);
         if (var15.size() != 0) {
            new ConsultationEnteteGene();

            for(int var17 = 0; var17 < var15.size(); ++var17) {
               ConsultationEnteteGene var16 = (ConsultationEnteteGene)var15.get(var17);
               var16.setCsgDateTransfert(var16.getCsgDate());
               var6.modif(var16, var5);
            }
         }

         new ArrayList();
         List var27 = var7.recherchePharmacieATransfererCompta("1", "", "", var13, var14, false, var5);
         if (var27.size() != 0) {
            new PharmacieEntete();

            for(int var18 = 0; var18 < var27.size(); ++var18) {
               PharmacieEntete var28 = (PharmacieEntete)var27.get(var18);
               var28.setPhaDateTransfert(var28.getPhaDate());
               var7.modif(var28, var5);
            }
         }

         new ArrayList();
         List var29 = var8.rechercheLaboratoireATransfererCompta("1", "", "", var13, var14, false, var5);
         if (var29.size() != 0) {
            new LaboratoireEntete();

            for(int var19 = 0; var19 < var29.size(); ++var19) {
               LaboratoireEntete var30 = (LaboratoireEntete)var29.get(var19);
               var30.setLabDateTransfert(var30.getLabDate());
               var8.modif(var30, var5);
            }
         }

         new ArrayList();
         List var31 = var9.rechercheHospitalisationATransfererCompta("1", "", "", var13, var14, false, var5);
         if (var31.size() != 0) {
            new HospitalisationEntete();

            for(int var20 = 0; var20 < var31.size(); ++var20) {
               HospitalisationEntete var32 = (HospitalisationEntete)var31.get(var20);
               var32.setHosDateTransfert(var32.getHosDateSortie());
               var9.modif(var32, var5);
            }
         }

         new ArrayList();
         List var33 = var10.rechercheFactureATransfererCompta("1", "", "", var13, var14, false, var5);
         if (var33.size() != 0) {
            new FactureEnteteMedical();

            for(int var21 = 0; var21 < var33.size(); ++var21) {
               FactureEnteteMedical var34 = (FactureEnteteMedical)var33.get(var21);
               var34.setFacDateTransfert(var34.getFacDate());
               var10.modif(var34, var5);
            }
         }

         var11.commit();
      } catch (HibernateException var25) {
         if (var11 != null) {
            var11.rollback();
         }

         throw var25;
      } finally {
         var4.closeSession();
      }

   }

   public void recalculEtatConsultation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ConsultationEnteteGene();
      ConsultationEnteteGeneDao var9 = new ConsultationEnteteGeneDao(var5, var6);
      new ArrayList();
      FactureLigneMedicalDao var11 = new FactureLigneMedicalDao(var5, var6);
      new ArrayList();
      ArrayList var13 = new ArrayList();
      UtilDate var14 = new UtilDate();
      String var15 = var14.dateToStringSQLLight(var1) + " 00:00:00";
      String var16 = var14.dateToStringSQLLight(var2) + " 23:59:59";
      List var12 = var11.chargerLesMvts(var15, var7);
      List var10 = var9.rechercheConsultationPeriode(var15, var16, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var17 = 0; var17 < var10.size(); ++var17) {
            ConsultationEnteteGene var8 = (ConsultationEnteteGene)var10.get(var17);
            if (var8.getCsgEtat() != 3) {
               var13.clear();

               for(int var18 = 0; var18 < var12.size(); ++var18) {
                  if (((FactureLigneMedical)var12.get(var18)).getFacligIdConsultation() == var8.getCsgId()) {
                     var13.add(var12.get(var18));
                     break;
                  }
               }

               if (var13.size() != 0) {
                  if (var8.getCsgEtat() <= 5) {
                     var8.setCsgEtat(6);
                     var9.modif(var8, var7);
                  }
               } else if (var8.getCsgEtat() >= 6) {
                  var8.setCsgEtat(5);
                  var9.modif(var8, var7);
               }
            }
         }
      }

   }

   public void recalculEtatPharmacie(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new PharmacieEntete();
      PharmacieEnteteDao var9 = new PharmacieEnteteDao(var5, var6);
      new ArrayList();
      FactureLigneMedicalDao var11 = new FactureLigneMedicalDao(var5, var6);
      new ArrayList();
      ArrayList var13 = new ArrayList();
      UtilDate var14 = new UtilDate();
      String var15 = var14.dateToStringSQLLight(var1) + " 00:00:00";
      String var16 = var14.dateToStringSQLLight(var2) + " 23:59:59";
      List var12 = var11.chargerLesMvts(var15, var7);
      List var10 = var9.recherchePharmaciePeriode(var15, var16, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var17 = 0; var17 < var10.size(); ++var17) {
            PharmacieEntete var8 = (PharmacieEntete)var10.get(var17);
            if (var8.getPhaEtat() != 3) {
               var13.clear();

               for(int var18 = 0; var18 < var12.size(); ++var18) {
                  if (((FactureLigneMedical)var12.get(var18)).getFacligIdPharmacie() == var8.getPhaId()) {
                     var13.add(var12.get(var18));
                     break;
                  }
               }

               if (var13.size() != 0) {
                  if (var8.getPhaEtat() <= 5) {
                     var8.setPhaEtat(6);
                     var9.modif(var8, var7);
                  }
               } else if (var8.getPhaEtat() >= 6) {
                  var8.setPhaEtat(5);
                  var9.modif(var8, var7);
               }
            }
         }
      }

   }

   public void recalculEtatLaboratoire(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new LaboratoireEntete();
      LaboratoireEnteteDao var9 = new LaboratoireEnteteDao(var5, var6);
      new ArrayList();
      FactureLigneMedicalDao var11 = new FactureLigneMedicalDao(var5, var6);
      new ArrayList();
      ArrayList var13 = new ArrayList();
      UtilDate var14 = new UtilDate();
      String var15 = var14.dateToStringSQLLight(var1) + " 00:00:00";
      String var16 = var14.dateToStringSQLLight(var2) + " 23:59:59";
      List var12 = var11.chargerLesMvts(var15, var7);
      List var10 = var9.rechercheLaboratoirePeriode(var15, var16, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var17 = 0; var17 < var10.size(); ++var17) {
            LaboratoireEntete var8 = (LaboratoireEntete)var10.get(var17);
            if (var8.getLabEtat() != 3) {
               var13.clear();

               for(int var18 = 0; var18 < var12.size(); ++var18) {
                  if (((FactureLigneMedical)var12.get(var18)).getFacligIdLaboratoire() == var8.getLabId()) {
                     var13.add(var12.get(var18));
                     break;
                  }
               }

               if (var13.size() != 0) {
                  if (var8.getLabEtat() <= 5) {
                     var8.setLabEtat(6);
                     var9.modif(var8, var7);
                  }
               } else if (var8.getLabEtat() >= 6) {
                  var8.setLabEtat(5);
                  var9.modif(var8, var7);
               }
            }
         }
      }

   }

   public void recalculEtatHospitalisation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new HospitalisationEntete();
      HospitalisationEnteteDao var9 = new HospitalisationEnteteDao(var5, var6);
      new ArrayList();
      FactureLigneMedicalDao var11 = new FactureLigneMedicalDao(var5, var6);
      new ArrayList();
      new ArrayList();
      UtilDate var14 = new UtilDate();
      String var15 = var14.dateToStringSQLLight(var1) + " 00:00:00";
      String var16 = var14.dateToStringSQLLight(var2) + " 23:59:59";
      var11.chargerLesMvts(var15, var7);
      List var10 = var9.rechercheHospitalisationPeriode(var15, var16, 0L, (String)null, var7);
      if (var10.size() != 0) {
         for(int var17 = 0; var17 < var10.size(); ++var17) {
            HospitalisationEntete var8 = (HospitalisationEntete)var10.get(var17);
            if (var8.getHosEtat() != 3) {
               List var12 = var11.chargerLesLignesFacturesByNature(var8.getHosId(), "", 76, var7);
               if (var12.size() != 0) {
                  if (var8.getHosEtat() <= 5) {
                     var8.setHosEtat(6);
                     var9.modif(var8, var7);
                  }
               } else if (var8.getHosEtat() >= 6) {
                  var8.setHosEtat(5);
                  var9.modif(var8, var7);
               }
            }
         }
      }

   }
}
