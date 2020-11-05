package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionMedical;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormOptionsMedical implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionMedical optionMedical = new OptionMedical();
   private Element racine = new Element("optionMedical");
   private Document document;
   private ObjetCompte objetCompte;
   private boolean griseAnalytique = false;
   private String obsAnalytique;
   private boolean griseProduit = false;
   private String obsProduit;
   private boolean infirmerie = false;
   private boolean cabinet = false;
   private boolean laboratoire = false;
   private boolean pharmacie = false;
   private boolean clinique = false;
   private boolean hopital = false;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;

   public FormOptionsMedical() throws SAXException {
      this.document = new Document(this.racine);
   }

   public void initOption() {
      this.infirmerie = this.rechercheModule(81500);
      this.cabinet = this.rechercheModule(81510);
      this.laboratoire = this.rechercheModule(81520);
      this.pharmacie = this.rechercheModule(81530);
      this.clinique = this.rechercheModule(81540);
      this.hopital = this.rechercheModule(81550);
      this.calculeLibEntete();
   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void calculeLibEntete() {
      if (this.structureLog.getStrtypeentreprise().equals("2")) {
         this.moduleUsine = true;
      }

      if (this.rechercheModule(70000)) {
         this.moduleParc = true;
      }

      if (this.rechercheModule(50000)) {
         this.modulePaye = true;
      }

      if (this.rechercheModule(40300)) {
         this.moduleProjet = true;
      }

      if (this.structureLog.getStrmaitrecabinet() == 12) {
         this.moduleStructure = true;
      }

   }

   public void creerOptionMedical() throws IOException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("gestPharCP");
      this.racine.addContent(var1);
      var1.setText(this.optionMedical.getGestPharCP());
      Element var2 = new Element("affichInTierViewCP");
      this.racine.addContent(var2);
      var2.setText(this.optionMedical.getAffichInTierViewCP());
      Element var3 = new Element("affichInGlobViewCP");
      this.racine.addContent(var3);
      var3.setText(this.optionMedical.getAffichInGlobViewCP());
      Element var4 = new Element("gestConsultGenCC");
      this.racine.addContent(var4);
      var4.setText(this.optionMedical.getGestConsultGenCC());
      Element var5 = new Element("affichInTierViewCC");
      this.racine.addContent(var5);
      var5.setText(this.optionMedical.getAffichInTierViewCC());
      Element var6 = new Element("affichInGlobViewCC");
      this.racine.addContent(var6);
      var6.setText(this.optionMedical.getAffichInGlobViewCC());
      Element var7 = new Element("nbrJrGraceCG");
      this.racine.addContent(var7);
      var7.setText(this.optionMedical.getNbrJrGraceCG());
      Element var8 = new Element("gestConsultGenCS");
      this.racine.addContent(var8);
      var8.setText(this.optionMedical.getGestConsultGenCS());
      Element var9 = new Element("affichInTierViewCS");
      this.racine.addContent(var9);
      var9.setText(this.optionMedical.getAffichInTierViewCS());
      Element var10 = new Element("affichInGlobViewCS");
      this.racine.addContent(var10);
      var10.setText(this.optionMedical.getAffichInGlobViewCS());
      Element var11 = new Element("dent");
      this.racine.addContent(var11);
      var11.setText(this.optionMedical.getDent());
      Element var12 = new Element("gestLaboratoireCL");
      this.racine.addContent(var12);
      var12.setText(this.optionMedical.getGestLaboratoireCL());
      Element var13 = new Element("affichInTierViewCL");
      this.racine.addContent(var13);
      var13.setText(this.optionMedical.getAffichInTierViewCL());
      Element var14 = new Element("affichInGlobViewCL");
      this.racine.addContent(var14);
      var14.setText(this.optionMedical.getAffichInGlobViewCL());
      Element var15 = new Element("choixLabo");
      this.racine.addContent(var15);
      var15.setText(this.optionMedical.getChoixLabo());
      Element var16 = new Element("affichInGlobViewPaillasse");
      this.racine.addContent(var16);
      var16.setText(this.optionMedical.getAffichInGlobViewPaillasse());
      Element var17 = new Element("gestHospitalisationCH");
      this.racine.addContent(var17);
      var17.setText(this.optionMedical.getGestHospitalisationCH());
      Element var18 = new Element("affichInTierViewCH");
      this.racine.addContent(var18);
      var18.setText(this.optionMedical.getAffichInTierViewCH());
      Element var19 = new Element("affichInGlobViewCH");
      this.racine.addContent(var19);
      var19.setText(this.optionMedical.getAffichInGlobViewCH());
      Element var20 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var20);
      var20.setText(this.optionMedical.getNbrJrRelanceDEVIS());
      Element var21 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var21);
      var21.setText(this.optionMedical.getNbrJrValidDEVIS());
      Element var22 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var22);
      var22.setText(this.optionMedical.getAffichInTierFilDEVIS());
      Element var23 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var23);
      var23.setText(this.optionMedical.getAffichInGlobViewDEVIS());
      Element var24 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var24);
      var24.setText(this.optionMedical.getNbrJrRelanceFAC());
      Element var25 = new Element("nbrJrValidFAC");
      this.racine.addContent(var25);
      var25.setText(this.optionMedical.getNbrJrValidFAC());
      Element var26 = new Element("affichInTierFilFAC");
      this.racine.addContent(var26);
      var26.setText(this.optionMedical.getAffichInTierFilFAC());
      Element var27 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var27);
      var27.setText(this.optionMedical.getAffichInGlobViewFAC());
      Element var28 = new Element("decrmtPriVteStock");
      this.racine.addContent(var28);
      var28.setText(this.optionMedical.getDecrmtPriVteStock());
      Element var29 = new Element("modeRefacturation");
      this.racine.addContent(var29);
      var29.setText(this.optionMedical.getModeRefacturation());
      Element var30 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var30);
      var30.setText(this.optionMedical.getNbrJrRelanceNOTDEB());
      Element var31 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var31);
      var31.setText(this.optionMedical.getNbrJrValidNOTDEB());
      Element var32 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var32);
      var32.setText(this.optionMedical.getAffichInTierFilNOTDEB());
      Element var33 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var33);
      var33.setText(this.optionMedical.getAffichInGlobViewNOTDEB());
      Element var34 = new Element("gestionPlafondNdb");
      this.racine.addContent(var34);
      var34.setText(this.optionMedical.getGestionPlafondNdb());
      Element var35 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var35);
      var35.setText(this.optionMedical.getNbrJrRelanceAVOIR());
      Element var36 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var36);
      var36.setText(this.optionMedical.getNbrJrValidAVOIR());
      Element var37 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var37);
      var37.setText(this.optionMedical.getAffichInTierFilAVOIR());
      Element var38 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var38);
      var38.setText(this.optionMedical.getAffichInGlobViewAVOIR());
      Element var39 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var39);
      var39.setText(this.optionMedical.getAffichInGlobViewCOMMISSION());
      Element var40 = new Element("compteDebit");
      this.racine.addContent(var40);
      var40.setText(this.optionMedical.getCompteDebit());
      Element var41 = new Element("modeCommission");
      this.racine.addContent(var41);
      var41.setText(this.optionMedical.getModeCommission());
      Element var42 = new Element("cnamgs");
      this.racine.addContent(var42);
      var42.setText(this.optionMedical.getCnamgs());
      Element var43 = new Element("nbrCtrsFamOP");
      this.racine.addContent(var43);
      var43.setText(this.optionMedical.getNbrCtrsFamOP());
      Element var44 = new Element("nbrCtrsProOP");
      this.racine.addContent(var44);
      var44.setText(this.optionMedical.getNbrCtrsProOP());
      Element var45 = new Element("modCalcOP");
      this.racine.addContent(var45);
      var45.setText(this.optionMedical.getModCalcOP());
      Element var46 = new Element("chargementListe");
      this.racine.addContent(var46);
      var46.setText(this.optionMedical.getChargementListe());
      Element var47 = new Element("actePerso");
      this.racine.addContent(var47);
      var47.setText(this.optionMedical.getActePerso());
      Element var48 = new Element("acteCcam");
      this.racine.addContent(var48);
      var48.setText(this.optionMedical.getActeCcam());
      Element var49 = new Element("acteNgap");
      this.racine.addContent(var49);
      var49.setText(this.optionMedical.getActeNgap());
      Element var50 = new Element("comptePatient");
      this.racine.addContent(var50);
      var50.setText(this.optionMedical.getComptePatient());
      Element var51 = new Element("compteProduit");
      this.racine.addContent(var51);
      var51.setText(this.optionMedical.getCompteProduit());
      Element var52 = new Element("compteCNAMGSAP");
      this.racine.addContent(var52);
      var52.setText(this.optionMedical.getCompteCNAMGSAP());
      Element var53 = new Element("compteCNAMGSSP");
      this.racine.addContent(var53);
      var53.setText(this.optionMedical.getCompteCNAMGSSP());
      Element var54 = new Element("compteCNAMGSGEF");
      this.racine.addContent(var54);
      var54.setText(this.optionMedical.getCompteCNAMGSGEF());
      Element var55 = new Element("nbDecQte");
      this.racine.addContent(var55);
      var55.setText(this.optionMedical.getNbDecQte());
      Element var56 = new Element("nbDecPu");
      this.racine.addContent(var56);
      var56.setText(this.optionMedical.getNbDecPu());
      Element var57 = new Element("anneeFinBebe");
      this.racine.addContent(var57);
      var57.setText(this.optionMedical.getAnneeFinBebe());
      Element var58 = new Element("anneeDebutEnfant");
      this.racine.addContent(var58);
      var58.setText(this.optionMedical.getAnneeDebutEnfant());
      Element var59 = new Element("anneeFinEnfant");
      this.racine.addContent(var59);
      var59.setText(this.optionMedical.getAnneeFinEnfant());
      Element var60 = new Element("anneeDebutAdo");
      this.racine.addContent(var60);
      var60.setText(this.optionMedical.getAnneeDebutAdo());
      Element var61 = new Element("anneeFinAdo");
      this.racine.addContent(var61);
      var61.setText(this.optionMedical.getAnneeFinAdo());
      Element var62 = new Element("anneeDebutAdulte");
      this.racine.addContent(var62);
      var62.setText(this.optionMedical.getAnneeDebutAdulte());
      Element var63 = new Element("anneeFinAdulte");
      this.racine.addContent(var63);
      var63.setText(this.optionMedical.getAnneeFinAdulte());
      Element var64 = new Element("anneeDebutSenior");
      this.racine.addContent(var64);
      var64.setText(this.optionMedical.getAnneeDebutSenior());
      Element var65 = new Element("serviceCG");
      this.racine.addContent(var65);
      var65.setText(this.optionMedical.getServiceCG());
      Element var66 = new Element("serviceCS");
      this.racine.addContent(var66);
      var66.setText(this.optionMedical.getServiceCS());
      Element var67 = new Element("serviceLB");
      this.racine.addContent(var67);
      var67.setText(this.optionMedical.getServiceLB());
      Element var68 = new Element("servicePH");
      this.racine.addContent(var68);
      var68.setText(this.optionMedical.getServicePH());
      Element var69 = new Element("medecinCG");
      this.racine.addContent(var69);
      var69.setText(this.optionMedical.getMedecinCG());
      Element var70 = new Element("medecinCS");
      this.racine.addContent(var70);
      var70.setText(this.optionMedical.getMedecinCS());
      Element var71 = new Element("medecinLB");
      this.racine.addContent(var71);
      var71.setText(this.optionMedical.getMedecinLB());
      Element var72 = new Element("medecinPH");
      this.racine.addContent(var72);
      var72.setText(this.optionMedical.getMedecinPH());
      Element var73 = new Element("medecinHP");
      this.racine.addContent(var73);
      var73.setText(this.optionMedical.getMedecinHP());
      Element var74 = new Element("coefMajoration");
      this.racine.addContent(var74);
      var74.setText(this.optionMedical.getCoefMajoration());
      Element var75 = new Element("tarifSociete");
      this.racine.addContent(var75);
      var75.setText(this.optionMedical.getTarifSociete());
      Element var76 = new Element("tvaDefaut");
      this.racine.addContent(var76);
      var76.setText(this.optionMedical.getTvaDefaut());
      Element var77 = new Element("lib1ENTETE");
      this.racine.addContent(var77);
      var77.setText(this.optionMedical.getLib1ENTETE());
      Element var78 = new Element("lib2ENTETE");
      this.racine.addContent(var78);
      var78.setText(this.optionMedical.getLib2ENTETE());
      Element var79 = new Element("lib3ENTETE");
      this.racine.addContent(var79);
      var79.setText(this.optionMedical.getLib3ENTETE());
      Element var80 = new Element("lib4ENTETE");
      this.racine.addContent(var80);
      var80.setText(this.optionMedical.getLib4ENTETE());
      Element var81 = new Element("lib5ENTETE");
      this.racine.addContent(var81);
      var81.setText(this.optionMedical.getLib5ENTETE());
      Element var82 = new Element("lib6ENTETE");
      this.racine.addContent(var82);
      var82.setText(this.optionMedical.getLib6ENTETE());
      Element var83 = new Element("lib7ENTETE");
      this.racine.addContent(var83);
      var83.setText(this.optionMedical.getLib7ENTETE());
      Element var84 = new Element("lib8ENTETE");
      this.racine.addContent(var84);
      var84.setText(this.optionMedical.getLib8ENTETE());
      Element var85 = new Element("lib9ENTETE");
      this.racine.addContent(var85);
      var85.setText(this.optionMedical.getLib9ENTETE());
      Element var86 = new Element("lib10ENTETE");
      this.racine.addContent(var86);
      var86.setText(this.optionMedical.getLib10ENTETE());
      Element var87 = new Element("transfertDocument");
      this.racine.addContent(var87);
      var87.setText(this.optionMedical.getTransfertDocument());
      Element var88 = new Element("zoneRef1");
      this.racine.addContent(var88);
      var88.setText(this.optionMedical.getZoneRef1());
      Element var89 = new Element("zoneRef2");
      this.racine.addContent(var89);
      var89.setText(this.optionMedical.getZoneRef2());
      Element var90 = new Element("zoneLibelle");
      this.racine.addContent(var90);
      var90.setText(this.optionMedical.getZoneLibelle());
      Element var91 = new Element("zoneLibelleSuite");
      this.racine.addContent(var91);
      var91.setText(this.optionMedical.getZoneLibelleSuite());
      Element var92 = new Element("zoneRef1Serie");
      this.racine.addContent(var92);
      var92.setText(this.optionMedical.getZoneRef1Serie());
      Element var93 = new Element("zoneRef2Serie");
      this.racine.addContent(var93);
      var93.setText(this.optionMedical.getZoneRef2Serie());
      this.enregistrer();
      StructureDao var94 = new StructureDao(this.baseLog, this.utilInitHibernate);
      new Structure();
      Structure var95;
      if (this.structureLog.getStrid() == 0L) {
         var95 = var94.logStructure((Session)null);
      } else {
         var95 = var94.logStructureId(this.structureLog.getStrid(), (Session)null);
      }

      var95.setStrtypeContact(0);
      var94.modStructure(var95);
   }

   public void updateOptionMedical() throws IOException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("gestPharCP");
      this.racine.addContent(var1);
      var1.setText(this.optionMedical.getGestPharCP());
      Element var2 = new Element("affichInTierViewCP");
      this.racine.addContent(var2);
      var2.setText(this.optionMedical.getAffichInTierViewCP());
      Element var3 = new Element("affichInGlobViewCP");
      this.racine.addContent(var3);
      var3.setText(this.optionMedical.getAffichInGlobViewCP());
      Element var4 = new Element("gestConsultGenCC");
      this.racine.addContent(var4);
      var4.setText(this.optionMedical.getGestConsultGenCC());
      Element var5 = new Element("affichInTierViewCC");
      this.racine.addContent(var5);
      var5.setText(this.optionMedical.getAffichInTierViewCC());
      Element var6 = new Element("affichInGlobViewCC");
      this.racine.addContent(var6);
      var6.setText(this.optionMedical.getAffichInGlobViewCC());
      Element var7 = new Element("nbrJrGraceCG");
      this.racine.addContent(var7);
      var7.setText(this.optionMedical.getNbrJrGraceCG());
      Element var8 = new Element("gestConsultGenCS");
      this.racine.addContent(var8);
      var8.setText(this.optionMedical.getGestConsultGenCS());
      Element var9 = new Element("affichInTierViewCS");
      this.racine.addContent(var9);
      var9.setText(this.optionMedical.getAffichInTierViewCS());
      Element var10 = new Element("affichInGlobViewCS");
      this.racine.addContent(var10);
      var10.setText(this.optionMedical.getAffichInGlobViewCS());
      Element var11 = new Element("dent");
      this.racine.addContent(var11);
      var11.setText(this.optionMedical.getDent());
      Element var12 = new Element("gestLaboratoireCL");
      this.racine.addContent(var12);
      var12.setText(this.optionMedical.getGestLaboratoireCL());
      Element var13 = new Element("affichInTierViewCL");
      this.racine.addContent(var13);
      var13.setText(this.optionMedical.getAffichInTierViewCL());
      Element var14 = new Element("affichInGlobViewCL");
      this.racine.addContent(var14);
      var14.setText(this.optionMedical.getAffichInGlobViewCL());
      Element var15 = new Element("choixLabo");
      this.racine.addContent(var15);
      var15.setText(this.optionMedical.getChoixLabo());
      Element var16 = new Element("affichInGlobViewPaillasse");
      this.racine.addContent(var16);
      var16.setText(this.optionMedical.getAffichInGlobViewPaillasse());
      Element var17 = new Element("gestHospitalisationCH");
      this.racine.addContent(var17);
      var17.setText(this.optionMedical.getGestHospitalisationCH());
      Element var18 = new Element("affichInTierViewCH");
      this.racine.addContent(var18);
      var18.setText(this.optionMedical.getAffichInTierViewCH());
      Element var19 = new Element("affichInGlobViewCH");
      this.racine.addContent(var19);
      var19.setText(this.optionMedical.getAffichInGlobViewCH());
      Element var20 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var20);
      var20.setText(this.optionMedical.getNbrJrRelanceDEVIS());
      Element var21 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var21);
      var21.setText(this.optionMedical.getNbrJrValidDEVIS());
      Element var22 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var22);
      var22.setText(this.optionMedical.getAffichInTierFilDEVIS());
      Element var23 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var23);
      var23.setText(this.optionMedical.getAffichInGlobViewDEVIS());
      Element var24 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var24);
      var24.setText(this.optionMedical.getNbrJrRelanceFAC());
      Element var25 = new Element("nbrJrValidFAC");
      this.racine.addContent(var25);
      var25.setText(this.optionMedical.getNbrJrValidFAC());
      Element var26 = new Element("affichInTierFilFAC");
      this.racine.addContent(var26);
      var26.setText(this.optionMedical.getAffichInTierFilFAC());
      Element var27 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var27);
      var27.setText(this.optionMedical.getAffichInGlobViewFAC());
      Element var28 = new Element("decrmtPriVteStock");
      this.racine.addContent(var28);
      var28.setText(this.optionMedical.getDecrmtPriVteStock());
      Element var29 = new Element("modeRefacturation");
      this.racine.addContent(var29);
      var29.setText(this.optionMedical.getModeRefacturation());
      Element var30 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var30);
      var30.setText(this.optionMedical.getNbrJrRelanceNOTDEB());
      Element var31 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var31);
      var31.setText(this.optionMedical.getNbrJrValidNOTDEB());
      Element var32 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var32);
      var32.setText(this.optionMedical.getAffichInTierFilNOTDEB());
      Element var33 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var33);
      var33.setText(this.optionMedical.getAffichInGlobViewNOTDEB());
      Element var34 = new Element("gestionPlafondNdb");
      this.racine.addContent(var34);
      var34.setText(this.optionMedical.getGestionPlafondNdb());
      Element var35 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var35);
      var35.setText(this.optionMedical.getNbrJrRelanceAVOIR());
      Element var36 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var36);
      var36.setText(this.optionMedical.getNbrJrValidAVOIR());
      Element var37 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var37);
      var37.setText(this.optionMedical.getAffichInTierFilAVOIR());
      Element var38 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var38);
      var38.setText(this.optionMedical.getAffichInGlobViewAVOIR());
      Element var39 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var39);
      var39.setText(this.optionMedical.getAffichInGlobViewCOMMISSION());
      Element var40 = new Element("compteDebit");
      this.racine.addContent(var40);
      var40.setText(this.optionMedical.getCompteDebit());
      Element var41 = new Element("modeCommission");
      this.racine.addContent(var41);
      var41.setText(this.optionMedical.getModeCommission());
      Element var42 = new Element("cnamgs");
      this.racine.addContent(var42);
      var42.setText(this.optionMedical.getCnamgs());
      Element var43 = new Element("nbrCtrsFamOP");
      this.racine.addContent(var43);
      var43.setText(this.optionMedical.getNbrCtrsFamOP());
      Element var44 = new Element("nbrCtrsProOP");
      this.racine.addContent(var44);
      var44.setText(this.optionMedical.getNbrCtrsProOP());
      Element var45 = new Element("modCalcOP");
      this.racine.addContent(var45);
      var45.setText(this.optionMedical.getModCalcOP());
      Element var46 = new Element("chargementListe");
      this.racine.addContent(var46);
      var46.setText(this.optionMedical.getChargementListe());
      Element var47 = new Element("actePerso");
      this.racine.addContent(var47);
      var47.setText(this.optionMedical.getActePerso());
      Element var48 = new Element("acteCcam");
      this.racine.addContent(var48);
      var48.setText(this.optionMedical.getActeCcam());
      Element var49 = new Element("acteNgap");
      this.racine.addContent(var49);
      var49.setText(this.optionMedical.getActeNgap());
      Element var50 = new Element("comptePatient");
      this.racine.addContent(var50);
      var50.setText(this.optionMedical.getComptePatient());
      Element var51 = new Element("compteProduit");
      this.racine.addContent(var51);
      var51.setText(this.optionMedical.getCompteProduit());
      Element var52 = new Element("compteCNAMGSAP");
      this.racine.addContent(var52);
      var52.setText(this.optionMedical.getCompteCNAMGSAP());
      Element var53 = new Element("compteCNAMGSSP");
      this.racine.addContent(var53);
      var53.setText(this.optionMedical.getCompteCNAMGSSP());
      Element var54 = new Element("compteCNAMGSGEF");
      this.racine.addContent(var54);
      var54.setText(this.optionMedical.getCompteCNAMGSGEF());
      Element var55 = new Element("nbDecQte");
      this.racine.addContent(var55);
      var55.setText(this.optionMedical.getNbDecQte());
      Element var56 = new Element("nbDecPu");
      this.racine.addContent(var56);
      var56.setText(this.optionMedical.getNbDecPu());
      Element var57 = new Element("anneeFinBebe");
      this.racine.addContent(var57);
      var57.setText(this.optionMedical.getAnneeFinBebe());
      Element var58 = new Element("anneeDebutEnfant");
      this.racine.addContent(var58);
      var58.setText(this.optionMedical.getAnneeDebutEnfant());
      Element var59 = new Element("anneeFinEnfant");
      this.racine.addContent(var59);
      var59.setText(this.optionMedical.getAnneeFinEnfant());
      Element var60 = new Element("anneeDebutAdo");
      this.racine.addContent(var60);
      var60.setText(this.optionMedical.getAnneeDebutAdo());
      Element var61 = new Element("anneeFinAdo");
      this.racine.addContent(var61);
      var61.setText(this.optionMedical.getAnneeFinAdo());
      Element var62 = new Element("anneeDebutAdulte");
      this.racine.addContent(var62);
      var62.setText(this.optionMedical.getAnneeDebutAdulte());
      Element var63 = new Element("anneeFinAdulte");
      this.racine.addContent(var63);
      var63.setText(this.optionMedical.getAnneeFinAdulte());
      Element var64 = new Element("anneeDebutSenior");
      this.racine.addContent(var64);
      var64.setText(this.optionMedical.getAnneeDebutSenior());
      Element var65 = new Element("serviceCG");
      this.racine.addContent(var65);
      var65.setText(this.optionMedical.getServiceCG());
      Element var66 = new Element("serviceCS");
      this.racine.addContent(var66);
      var66.setText(this.optionMedical.getServiceCS());
      Element var67 = new Element("serviceLB");
      this.racine.addContent(var67);
      var67.setText(this.optionMedical.getServiceLB());
      Element var68 = new Element("servicePH");
      this.racine.addContent(var68);
      var68.setText(this.optionMedical.getServicePH());
      Element var69 = new Element("medecinCG");
      this.racine.addContent(var69);
      var69.setText(this.optionMedical.getMedecinCG());
      Element var70 = new Element("medecinCS");
      this.racine.addContent(var70);
      var70.setText(this.optionMedical.getMedecinCS());
      Element var71 = new Element("medecinLB");
      this.racine.addContent(var71);
      var71.setText(this.optionMedical.getMedecinLB());
      Element var72 = new Element("medecinPH");
      this.racine.addContent(var72);
      var72.setText(this.optionMedical.getMedecinPH());
      Element var73 = new Element("medecinHP");
      this.racine.addContent(var73);
      var73.setText(this.optionMedical.getMedecinHP());
      Element var74 = new Element("coefMajoration");
      this.racine.addContent(var74);
      var74.setText(this.optionMedical.getCoefMajoration());
      Element var75 = new Element("tarifSociete");
      this.racine.addContent(var75);
      var75.setText(this.optionMedical.getTarifSociete());
      Element var76 = new Element("tvaDefaut");
      this.racine.addContent(var76);
      var76.setText(this.optionMedical.getTvaDefaut());
      Element var77 = new Element("lib1ENTETE");
      this.racine.addContent(var77);
      var77.setText(this.optionMedical.getLib1ENTETE());
      Element var78 = new Element("lib2ENTETE");
      this.racine.addContent(var78);
      var78.setText(this.optionMedical.getLib2ENTETE());
      Element var79 = new Element("lib3ENTETE");
      this.racine.addContent(var79);
      var79.setText(this.optionMedical.getLib3ENTETE());
      Element var80 = new Element("lib4ENTETE");
      this.racine.addContent(var80);
      var80.setText(this.optionMedical.getLib4ENTETE());
      Element var81 = new Element("lib5ENTETE");
      this.racine.addContent(var81);
      var81.setText(this.optionMedical.getLib5ENTETE());
      Element var82 = new Element("lib6ENTETE");
      this.racine.addContent(var82);
      var82.setText(this.optionMedical.getLib6ENTETE());
      Element var83 = new Element("lib7ENTETE");
      this.racine.addContent(var83);
      var83.setText(this.optionMedical.getLib7ENTETE());
      Element var84 = new Element("lib8ENTETE");
      this.racine.addContent(var84);
      var84.setText(this.optionMedical.getLib8ENTETE());
      Element var85 = new Element("lib9ENTETE");
      this.racine.addContent(var85);
      var85.setText(this.optionMedical.getLib9ENTETE());
      Element var86 = new Element("lib10ENTETE");
      this.racine.addContent(var86);
      var86.setText(this.optionMedical.getLib10ENTETE());
      Element var87 = new Element("transfertDocument");
      this.racine.addContent(var87);
      var87.setText(this.optionMedical.getTransfertDocument());
      Element var88 = new Element("zoneRef1");
      this.racine.addContent(var88);
      var88.setText(this.optionMedical.getZoneRef1());
      Element var89 = new Element("zoneRef2");
      this.racine.addContent(var89);
      var89.setText(this.optionMedical.getZoneRef2());
      Element var90 = new Element("zoneLibelle");
      this.racine.addContent(var90);
      var90.setText(this.optionMedical.getZoneLibelle());
      Element var91 = new Element("zoneLibelleSuite");
      this.racine.addContent(var91);
      var91.setText(this.optionMedical.getZoneLibelleSuite());
      Element var92 = new Element("zoneRef1Serie");
      this.racine.addContent(var92);
      var92.setText(this.optionMedical.getZoneRef1Serie());
      Element var93 = new Element("zoneRef2Serie");
      this.racine.addContent(var93);
      var93.setText(this.optionMedical.getZoneRef2Serie());
      this.enregistrer();
   }

   public void creerOptionsMedicalCompta(OptionMedical var1, OptionComptabilite var2) throws IOException {
      this.racine.removeContent();
      Element var3 = new Element("gestPharCP");
      this.racine.addContent(var3);
      var3.setText(var1.getGestPharCP());
      Element var4 = new Element("affichInTierViewCP");
      this.racine.addContent(var4);
      var4.setText(var1.getAffichInTierViewCP());
      Element var5 = new Element("affichInGlobViewCP");
      this.racine.addContent(var5);
      var5.setText(var1.getAffichInGlobViewCP());
      Element var6 = new Element("gestConsultGenCC");
      this.racine.addContent(var6);
      var6.setText(var1.getGestConsultGenCC());
      Element var7 = new Element("affichInTierViewCC");
      this.racine.addContent(var7);
      var7.setText(var1.getAffichInTierViewCC());
      Element var8 = new Element("affichInGlobViewCC");
      this.racine.addContent(var8);
      var8.setText(var1.getAffichInGlobViewCC());
      Element var9 = new Element("nbrJrGraceCG");
      this.racine.addContent(var9);
      var9.setText(var1.getNbrJrGraceCG());
      Element var10 = new Element("gestConsultGenCS");
      this.racine.addContent(var10);
      var10.setText(var1.getGestConsultGenCS());
      Element var11 = new Element("affichInTierViewCS");
      this.racine.addContent(var11);
      var11.setText(var1.getAffichInTierViewCS());
      Element var12 = new Element("affichInGlobViewCS");
      this.racine.addContent(var12);
      var12.setText(var1.getAffichInGlobViewCS());
      Element var13 = new Element("dent");
      this.racine.addContent(var13);
      var13.setText(var1.getDent());
      Element var14 = new Element("gestLaboratoireCL");
      this.racine.addContent(var14);
      var14.setText(var1.getGestLaboratoireCL());
      Element var15 = new Element("affichInTierViewCL");
      this.racine.addContent(var15);
      var15.setText(var1.getAffichInTierViewCL());
      Element var16 = new Element("affichInGlobViewCL");
      this.racine.addContent(var16);
      var16.setText(var1.getAffichInGlobViewCL());
      Element var17 = new Element("choixLabo");
      this.racine.addContent(var17);
      var17.setText(var1.getChoixLabo());
      Element var18 = new Element("affichInGlobViewPaillasse");
      this.racine.addContent(var18);
      var18.setText(var1.getAffichInGlobViewPaillasse());
      Element var19 = new Element("gestHospitalisationCH");
      this.racine.addContent(var19);
      var19.setText(var1.getGestHospitalisationCH());
      Element var20 = new Element("affichInTierViewCH");
      this.racine.addContent(var20);
      var20.setText(var1.getAffichInTierViewCH());
      Element var21 = new Element("affichInGlobViewCH");
      this.racine.addContent(var21);
      var21.setText(var1.getAffichInGlobViewCH());
      Element var22 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var22);
      var22.setText(var1.getNbrJrRelanceDEVIS());
      Element var23 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var23);
      var23.setText(var1.getNbrJrValidDEVIS());
      Element var24 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var24);
      var24.setText(var1.getAffichInTierFilDEVIS());
      Element var25 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var25);
      var25.setText(var1.getAffichInGlobViewDEVIS());
      Element var26 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var26);
      var26.setText(var1.getNbrJrRelanceFAC());
      Element var27 = new Element("nbrJrValidFAC");
      this.racine.addContent(var27);
      var27.setText(var1.getNbrJrValidFAC());
      Element var28 = new Element("affichInTierFilFAC");
      this.racine.addContent(var28);
      var28.setText(var1.getAffichInTierFilFAC());
      Element var29 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var29);
      var29.setText(var1.getAffichInGlobViewFAC());
      Element var30 = new Element("decrmtPriVteStock");
      this.racine.addContent(var30);
      var30.setText(var1.getDecrmtPriVteStock());
      Element var31 = new Element("modeRefacturation");
      this.racine.addContent(var31);
      var31.setText(var1.getModeRefacturation());
      Element var32 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var32);
      var32.setText(var1.getNbrJrRelanceNOTDEB());
      Element var33 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var33);
      var33.setText(var1.getNbrJrValidNOTDEB());
      Element var34 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var34);
      var34.setText(var1.getAffichInTierFilNOTDEB());
      Element var35 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var35);
      var35.setText(var1.getAffichInGlobViewNOTDEB());
      Element var36 = new Element("gestionPlafondNdb");
      this.racine.addContent(var36);
      var36.setText(var1.getGestionPlafondNdb());
      Element var37 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var37);
      var37.setText(var1.getNbrJrRelanceAVOIR());
      Element var38 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var38);
      var38.setText(var1.getNbrJrValidAVOIR());
      Element var39 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var39);
      var39.setText(var1.getAffichInTierFilAVOIR());
      Element var40 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var40);
      var40.setText(var1.getAffichInGlobViewAVOIR());
      Element var41 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var41);
      var41.setText(var1.getAffichInGlobViewCOMMISSION());
      Element var42 = new Element("compteDebit");
      this.racine.addContent(var42);
      var42.setText(var1.getCompteDebit());
      Element var43 = new Element("modeCommission");
      this.racine.addContent(var43);
      var43.setText(var1.getModeCommission());
      Element var44 = new Element("cnamgs");
      this.racine.addContent(var44);
      var44.setText(var1.getCnamgs());
      Element var45 = new Element("nbrCtrsFamOP");
      this.racine.addContent(var45);
      var45.setText(var1.getNbrCtrsFamOP());
      Element var46 = new Element("nbrCtrsProOP");
      this.racine.addContent(var46);
      var46.setText(var1.getNbrCtrsProOP());
      Element var47 = new Element("modCalcOP");
      this.racine.addContent(var47);
      var47.setText(var1.getModCalcOP());
      Element var48 = new Element("chargementListe");
      this.racine.addContent(var48);
      var48.setText(var1.getChargementListe());
      Element var49 = new Element("actePerso");
      this.racine.addContent(var49);
      var49.setText(var1.getActePerso());
      Element var50 = new Element("acteCcam");
      this.racine.addContent(var50);
      var50.setText(var1.getActeCcam());
      Element var51 = new Element("acteNgap");
      this.racine.addContent(var51);
      var51.setText(var1.getActeNgap());
      Element var52 = new Element("comptePatient");
      this.racine.addContent(var52);
      var52.setText(var1.getComptePatient());
      Element var53 = new Element("compteProduit");
      this.racine.addContent(var53);
      var53.setText(var1.getCompteProduit());
      Element var54 = new Element("compteCNAMGSAP");
      this.racine.addContent(var54);
      var54.setText(var1.getCompteCNAMGSAP());
      Element var55 = new Element("compteCNAMGSSP");
      this.racine.addContent(var55);
      var55.setText(var1.getCompteCNAMGSSP());
      Element var56 = new Element("compteCNAMGSGEF");
      this.racine.addContent(var56);
      var56.setText(var1.getCompteCNAMGSGEF());
      Element var57 = new Element("nbDecQte");
      this.racine.addContent(var57);
      var57.setText(var1.getNbDecQte());
      Element var58 = new Element("nbDecPu");
      this.racine.addContent(var58);
      var58.setText(var1.getNbDecPu());
      Element var59 = new Element("anneeFinBebe");
      this.racine.addContent(var59);
      var59.setText(var1.getAnneeFinBebe());
      Element var60 = new Element("anneeDebutEnfant");
      this.racine.addContent(var60);
      var60.setText(var1.getAnneeDebutEnfant());
      Element var61 = new Element("anneeFinEnfant");
      this.racine.addContent(var61);
      var61.setText(var1.getAnneeFinEnfant());
      Element var62 = new Element("anneeDebutAdo");
      this.racine.addContent(var62);
      var62.setText(var1.getAnneeDebutAdo());
      Element var63 = new Element("anneeFinAdo");
      this.racine.addContent(var63);
      var63.setText(var1.getAnneeFinAdo());
      Element var64 = new Element("anneeDebutAdulte");
      this.racine.addContent(var64);
      var64.setText(var1.getAnneeDebutAdulte());
      Element var65 = new Element("anneeFinAdulte");
      this.racine.addContent(var65);
      var65.setText(var1.getAnneeFinAdulte());
      Element var66 = new Element("anneeDebutSenior");
      this.racine.addContent(var66);
      var66.setText(var1.getAnneeDebutSenior());
      Element var67 = new Element("serviceCG");
      this.racine.addContent(var67);
      var67.setText(var1.getServiceCG());
      Element var68 = new Element("serviceCS");
      this.racine.addContent(var68);
      var68.setText(var1.getServiceCS());
      Element var69 = new Element("serviceLB");
      this.racine.addContent(var69);
      var69.setText(var1.getServiceLB());
      Element var70 = new Element("servicePH");
      this.racine.addContent(var70);
      var70.setText(var1.getServicePH());
      Element var71 = new Element("medecinCG");
      this.racine.addContent(var71);
      var71.setText(var1.getMedecinCG());
      Element var72 = new Element("medecinCS");
      this.racine.addContent(var72);
      var72.setText(var1.getMedecinCS());
      Element var73 = new Element("medecinLB");
      this.racine.addContent(var73);
      var73.setText(var1.getMedecinLB());
      Element var74 = new Element("medecinPH");
      this.racine.addContent(var74);
      var74.setText(var1.getMedecinPH());
      Element var75 = new Element("medecinHP");
      this.racine.addContent(var75);
      var75.setText(var1.getMedecinHP());
      Element var76 = new Element("coefMajoration");
      this.racine.addContent(var76);
      var76.setText(var1.getCoefMajoration());
      Element var77 = new Element("tarifSociete");
      this.racine.addContent(var77);
      var77.setText(var1.getTarifSociete());
      Element var78 = new Element("tvaDefaut");
      this.racine.addContent(var78);
      var78.setText(var1.getTvaDefaut());
      Element var79 = new Element("lib1ENTETE");
      this.racine.addContent(var79);
      var79.setText(var1.getLib1ENTETE());
      Element var80 = new Element("lib2ENTETE");
      this.racine.addContent(var80);
      var80.setText(var1.getLib2ENTETE());
      Element var81 = new Element("lib3ENTETE");
      this.racine.addContent(var81);
      var81.setText(var1.getLib3ENTETE());
      Element var82 = new Element("lib4ENTETE");
      this.racine.addContent(var82);
      var82.setText(var1.getLib4ENTETE());
      Element var83 = new Element("lib5ENTETE");
      this.racine.addContent(var83);
      var83.setText(var1.getLib5ENTETE());
      Element var84 = new Element("lib6ENTETE");
      this.racine.addContent(var84);
      var84.setText(var1.getLib6ENTETE());
      Element var85 = new Element("lib7ENTETE");
      this.racine.addContent(var85);
      var85.setText(var1.getLib7ENTETE());
      Element var86 = new Element("lib8ENTETE");
      this.racine.addContent(var86);
      var86.setText(var1.getLib8ENTETE());
      Element var87 = new Element("lib9ENTETE");
      this.racine.addContent(var87);
      var87.setText(var1.getLib9ENTETE());
      Element var88 = new Element("lib10ENTETE");
      this.racine.addContent(var88);
      var88.setText(var1.getLib10ENTETE());
      Element var89 = new Element("transfertDocument");
      this.racine.addContent(var89);
      var89.setText(var1.getTransfertDocument());
      Element var90 = new Element("zoneRef1");
      this.racine.addContent(var90);
      var90.setText(var1.getZoneRef1());
      Element var91 = new Element("zoneRef2");
      this.racine.addContent(var91);
      var91.setText(var1.getZoneRef2());
      Element var92 = new Element("zoneLibelle");
      this.racine.addContent(var92);
      var92.setText(var1.getZoneLibelle());
      Element var93 = new Element("zoneLibelleSuite");
      this.racine.addContent(var93);
      var93.setText(var1.getZoneLibelleSuite());
      Element var94 = new Element("zoneRef1Serie");
      this.racine.addContent(var94);
      var94.setText(var1.getZoneRef1Serie());
      Element var95 = new Element("zoneRef2Serie");
      this.racine.addContent(var95);
      var95.setText(var1.getZoneRef2Serie());
      this.enregistrer();
   }

   public void creerOptionsMedicalAchats(OptionMedical var1, OptionAchats var2) throws IOException {
      this.racine.removeContent();
      Element var3 = new Element("gestPharCP");
      this.racine.addContent(var3);
      var3.setText(var1.getGestPharCP());
      Element var4 = new Element("affichInTierViewCP");
      this.racine.addContent(var4);
      var4.setText(var1.getAffichInTierViewCP());
      Element var5 = new Element("affichInGlobViewCP");
      this.racine.addContent(var5);
      var5.setText(var1.getAffichInGlobViewCP());
      Element var6 = new Element("gestConsultGenCC");
      this.racine.addContent(var6);
      var6.setText(var1.getGestConsultGenCC());
      Element var7 = new Element("affichInTierViewCC");
      this.racine.addContent(var7);
      var7.setText(var1.getAffichInTierViewCC());
      Element var8 = new Element("affichInGlobViewCC");
      this.racine.addContent(var8);
      var8.setText(var1.getAffichInGlobViewCC());
      Element var9 = new Element("nbrJrGraceCG");
      this.racine.addContent(var9);
      var9.setText(var1.getNbrJrGraceCG());
      Element var10 = new Element("gestConsultGenCS");
      this.racine.addContent(var10);
      var10.setText(var1.getGestConsultGenCS());
      Element var11 = new Element("affichInTierViewCS");
      this.racine.addContent(var11);
      var11.setText(var1.getAffichInTierViewCS());
      Element var12 = new Element("affichInGlobViewCS");
      this.racine.addContent(var12);
      var12.setText(var1.getAffichInGlobViewCS());
      Element var13 = new Element("dent");
      this.racine.addContent(var13);
      var13.setText(var1.getDent());
      Element var14 = new Element("gestLaboratoireCL");
      this.racine.addContent(var14);
      var14.setText(var1.getGestLaboratoireCL());
      Element var15 = new Element("affichInTierViewCL");
      this.racine.addContent(var15);
      var15.setText(var1.getAffichInTierViewCL());
      Element var16 = new Element("affichInGlobViewCL");
      this.racine.addContent(var16);
      var16.setText(var1.getAffichInGlobViewCL());
      Element var17 = new Element("choixLabo");
      this.racine.addContent(var17);
      var17.setText(var1.getChoixLabo());
      Element var18 = new Element("affichInGlobViewPaillasse");
      this.racine.addContent(var18);
      var18.setText(var1.getAffichInGlobViewPaillasse());
      Element var19 = new Element("gestHospitalisationCH");
      this.racine.addContent(var19);
      var19.setText(var1.getGestHospitalisationCH());
      Element var20 = new Element("affichInTierViewCH");
      this.racine.addContent(var20);
      var20.setText(var1.getAffichInTierViewCH());
      Element var21 = new Element("affichInGlobViewCH");
      this.racine.addContent(var21);
      var21.setText(var1.getAffichInGlobViewCH());
      Element var22 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var22);
      var22.setText(var1.getNbrJrRelanceDEVIS());
      Element var23 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var23);
      var23.setText(var1.getNbrJrValidDEVIS());
      Element var24 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var24);
      var24.setText(var1.getAffichInTierFilDEVIS());
      Element var25 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var25);
      var25.setText(var1.getAffichInGlobViewDEVIS());
      Element var26 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var26);
      var26.setText(var1.getNbrJrRelanceFAC());
      Element var27 = new Element("nbrJrValidFAC");
      this.racine.addContent(var27);
      var27.setText(var1.getNbrJrValidFAC());
      Element var28 = new Element("affichInTierFilFAC");
      this.racine.addContent(var28);
      var28.setText(var1.getAffichInTierFilFAC());
      Element var29 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var29);
      var29.setText(var1.getAffichInGlobViewFAC());
      Element var30 = new Element("decrmtPriVteStock");
      this.racine.addContent(var30);
      var30.setText(var1.getDecrmtPriVteStock());
      Element var31 = new Element("modeRefacturation");
      this.racine.addContent(var31);
      var31.setText(var1.getModeRefacturation());
      Element var32 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var32);
      var32.setText(var1.getNbrJrRelanceNOTDEB());
      Element var33 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var33);
      var33.setText(var1.getNbrJrValidNOTDEB());
      Element var34 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var34);
      var34.setText(var1.getAffichInTierFilNOTDEB());
      Element var35 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var35);
      var35.setText(var1.getAffichInGlobViewNOTDEB());
      Element var36 = new Element("gestionPlafondNdb");
      this.racine.addContent(var36);
      var36.setText(var1.getGestionPlafondNdb());
      Element var37 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var37);
      var37.setText(var1.getNbrJrRelanceAVOIR());
      Element var38 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var38);
      var38.setText(var1.getNbrJrValidAVOIR());
      Element var39 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var39);
      var39.setText(var1.getAffichInTierFilAVOIR());
      Element var40 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var40);
      var40.setText(var1.getAffichInGlobViewAVOIR());
      Element var41 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var41);
      var41.setText(var1.getAffichInGlobViewCOMMISSION());
      Element var42 = new Element("compteDebit");
      this.racine.addContent(var42);
      var42.setText(var1.getCompteDebit());
      Element var43 = new Element("modeCommission");
      this.racine.addContent(var43);
      var43.setText(var1.getModeCommission());
      Element var44 = new Element("cnamgs");
      this.racine.addContent(var44);
      var44.setText(var1.getCnamgs());
      Element var45 = new Element("nbrCtrsFamOP");
      this.racine.addContent(var45);
      var45.setText(var1.getNbrCtrsFamOP());
      Element var46 = new Element("nbrCtrsProOP");
      this.racine.addContent(var46);
      var46.setText(var1.getNbrCtrsProOP());
      Element var47 = new Element("modCalcOP");
      this.racine.addContent(var47);
      var47.setText(var1.getModCalcOP());
      Element var48 = new Element("chargementListe");
      this.racine.addContent(var48);
      var48.setText(var1.getChargementListe());
      Element var49 = new Element("actePerso");
      this.racine.addContent(var49);
      var49.setText(var1.getActePerso());
      Element var50 = new Element("acteCcam");
      this.racine.addContent(var50);
      var50.setText(var1.getActeCcam());
      Element var51 = new Element("acteNgap");
      this.racine.addContent(var51);
      var51.setText(var1.getActeNgap());
      Element var52 = new Element("comptePatient");
      this.racine.addContent(var52);
      var52.setText(var1.getComptePatient());
      Element var53 = new Element("compteProduit");
      this.racine.addContent(var53);
      var53.setText(var1.getCompteProduit());
      Element var54 = new Element("compteCNAMGSAP");
      this.racine.addContent(var54);
      var54.setText(var1.getCompteCNAMGSAP());
      Element var55 = new Element("compteCNAMGSSP");
      this.racine.addContent(var55);
      var55.setText(var1.getCompteCNAMGSSP());
      Element var56 = new Element("compteCNAMGSGEF");
      this.racine.addContent(var56);
      var56.setText(var1.getCompteCNAMGSGEF());
      Element var57 = new Element("nbDecQte");
      this.racine.addContent(var57);
      var57.setText(var1.getNbDecQte());
      Element var58 = new Element("nbDecPu");
      this.racine.addContent(var58);
      var58.setText(var1.getNbDecPu());
      Element var59 = new Element("anneeFinBebe");
      this.racine.addContent(var59);
      var59.setText(var1.getAnneeFinBebe());
      Element var60 = new Element("anneeDebutEnfant");
      this.racine.addContent(var60);
      var60.setText(var1.getAnneeDebutEnfant());
      Element var61 = new Element("anneeFinEnfant");
      this.racine.addContent(var61);
      var61.setText(var1.getAnneeFinEnfant());
      Element var62 = new Element("anneeDebutAdo");
      this.racine.addContent(var62);
      var62.setText(var1.getAnneeDebutAdo());
      Element var63 = new Element("anneeFinAdo");
      this.racine.addContent(var63);
      var63.setText(var1.getAnneeFinAdo());
      Element var64 = new Element("anneeDebutAdulte");
      this.racine.addContent(var64);
      var64.setText(var1.getAnneeDebutAdulte());
      Element var65 = new Element("anneeFinAdulte");
      this.racine.addContent(var65);
      var65.setText(var1.getAnneeFinAdulte());
      Element var66 = new Element("anneeDebutSenior");
      this.racine.addContent(var66);
      var66.setText(var1.getAnneeDebutSenior());
      Element var67 = new Element("serviceCG");
      this.racine.addContent(var67);
      var67.setText(var1.getServiceCG());
      Element var68 = new Element("serviceCS");
      this.racine.addContent(var68);
      var68.setText(var1.getServiceCS());
      Element var69 = new Element("serviceLB");
      this.racine.addContent(var69);
      var69.setText(var1.getServiceLB());
      Element var70 = new Element("servicePH");
      this.racine.addContent(var70);
      var70.setText(var1.getServicePH());
      Element var71 = new Element("medecinCG");
      this.racine.addContent(var71);
      var71.setText(var1.getMedecinCG());
      Element var72 = new Element("medecinCS");
      this.racine.addContent(var72);
      var72.setText(var1.getMedecinCS());
      Element var73 = new Element("medecinLB");
      this.racine.addContent(var73);
      var73.setText(var1.getMedecinLB());
      Element var74 = new Element("medecinPH");
      this.racine.addContent(var74);
      var74.setText(var1.getMedecinPH());
      Element var75 = new Element("medecinHP");
      this.racine.addContent(var75);
      var75.setText(var1.getMedecinHP());
      Element var76 = new Element("coefMajoration");
      this.racine.addContent(var76);
      var76.setText(var1.getCoefMajoration());
      Element var77 = new Element("tarifSociete");
      this.racine.addContent(var77);
      var77.setText(var1.getTarifSociete());
      Element var78 = new Element("tvaDefaut");
      this.racine.addContent(var78);
      var78.setText(var1.getTvaDefaut());
      Element var79 = new Element("lib1ENTETE");
      this.racine.addContent(var79);
      var79.setText(var1.getLib1ENTETE());
      Element var80 = new Element("lib2ENTETE");
      this.racine.addContent(var80);
      var80.setText(var1.getLib2ENTETE());
      Element var81 = new Element("lib3ENTETE");
      this.racine.addContent(var81);
      var81.setText(var1.getLib3ENTETE());
      Element var82 = new Element("lib4ENTETE");
      this.racine.addContent(var82);
      var82.setText(var1.getLib4ENTETE());
      Element var83 = new Element("lib5ENTETE");
      this.racine.addContent(var83);
      var83.setText(var1.getLib5ENTETE());
      Element var84 = new Element("lib6ENTETE");
      this.racine.addContent(var84);
      var84.setText(var1.getLib6ENTETE());
      Element var85 = new Element("lib7ENTETE");
      this.racine.addContent(var85);
      var85.setText(var1.getLib7ENTETE());
      Element var86 = new Element("lib8ENTETE");
      this.racine.addContent(var86);
      var86.setText(var1.getLib8ENTETE());
      Element var87 = new Element("lib9ENTETE");
      this.racine.addContent(var87);
      var87.setText(var1.getLib9ENTETE());
      Element var88 = new Element("lib10ENTETE");
      this.racine.addContent(var88);
      var88.setText(var1.getLib10ENTETE());
      Element var89 = new Element("transfertDocument");
      this.racine.addContent(var89);
      var89.setText(var1.getTransfertDocument());
      Element var90 = new Element("zoneRef1");
      this.racine.addContent(var90);
      var90.setText(var1.getZoneRef1());
      Element var91 = new Element("zoneRef2");
      this.racine.addContent(var91);
      var91.setText(var1.getZoneRef2());
      Element var92 = new Element("zoneLibelle");
      this.racine.addContent(var92);
      var92.setText(var1.getZoneLibelle());
      Element var93 = new Element("zoneLibelleSuite");
      this.racine.addContent(var93);
      var93.setText(var1.getZoneLibelleSuite());
      Element var94 = new Element("zoneRef1Serie");
      this.racine.addContent(var94);
      var94.setText(var1.getZoneRef1Serie());
      Element var95 = new Element("zoneRef2Serie");
      this.racine.addContent(var95);
      var95.setText(var1.getZoneRef2Serie());
      this.enregistrer();
   }

   public void enregistrer() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "medical" + File.separator + "configuration" + File.separator + "optionMedical.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
   }

   public String afficheALL() {
      List var1 = this.racine.getChildren();

      Element var3;
      for(Iterator var2 = var1.iterator(); var2.hasNext(); var3 = (Element)var2.next()) {
      }

      return "";
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public String annuler() {
      return "annuler";
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public String getObsAnalytique() {
      return this.obsAnalytique;
   }

   public void setObsAnalytique(String var1) {
      this.obsAnalytique = var1;
   }

   public boolean isGriseAnalytique() {
      return this.griseAnalytique;
   }

   public void setGriseAnalytique(boolean var1) {
      this.griseAnalytique = var1;
   }

   public boolean isGriseProduit() {
      return this.griseProduit;
   }

   public void setGriseProduit(boolean var1) {
      this.griseProduit = var1;
   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }

   public String getObsProduit() {
      return this.obsProduit;
   }

   public void setObsProduit(String var1) {
      this.obsProduit = var1;
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

   public boolean isCabinet() {
      return this.cabinet;
   }

   public void setCabinet(boolean var1) {
      this.cabinet = var1;
   }

   public boolean isClinique() {
      return this.clinique;
   }

   public void setClinique(boolean var1) {
      this.clinique = var1;
   }

   public boolean isHopital() {
      return this.hopital;
   }

   public void setHopital(boolean var1) {
      this.hopital = var1;
   }

   public boolean isInfirmerie() {
      return this.infirmerie;
   }

   public void setInfirmerie(boolean var1) {
      this.infirmerie = var1;
   }

   public boolean isLaboratoire() {
      return this.laboratoire;
   }

   public void setLaboratoire(boolean var1) {
      this.laboratoire = var1;
   }

   public boolean isPharmacie() {
      return this.pharmacie;
   }

   public void setPharmacie(boolean var1) {
      this.pharmacie = var1;
   }

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public boolean isModuleParc() {
      return this.moduleParc;
   }

   public void setModuleParc(boolean var1) {
      this.moduleParc = var1;
   }

   public boolean isModulePaye() {
      return this.modulePaye;
   }

   public void setModulePaye(boolean var1) {
      this.modulePaye = var1;
   }

   public boolean isModuleProjet() {
      return this.moduleProjet;
   }

   public void setModuleProjet(boolean var1) {
      this.moduleProjet = var1;
   }

   public boolean isModuleStructure() {
      return this.moduleStructure;
   }

   public void setModuleStructure(boolean var1) {
      this.moduleStructure = var1;
   }
}
