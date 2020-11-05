package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LireLesoptionsPaye;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormOptionsPaye implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionPaye optionPaye = new OptionPaye();
   private Element racine = new Element("optionPaye");
   private Document document;
   private ObjetCompte objetCompte;
   private boolean griseAnalytique = false;
   private String obsAnalytique;
   private boolean griseProduit = false;
   private String obsProduit;
   private List lesVersementsItems;
   private List lesRetraitsItems;
   private List lesModeTravailItems;
   private List lesChronoMAtricule;
   private List lesSocietesItems;
   private boolean moduleTemps = false;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;
   private boolean moduleInterim = false;
   private boolean afficheAjDefaut = false;

   public FormOptionsPaye() throws SAXException {
      this.document = new Document(this.racine);
   }

   public void chargerRubriques(Session var1) throws HibernateException, NamingException {
      this.lesSocietesItems = new ArrayList();
      this.lesVersementsItems = new ArrayList();
      this.lesRetraitsItems = new ArrayList();
      new ExercicesPaye();
      ExercicesPayeDao var3 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         PlanPayeDao var4 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
         this.lesVersementsItems = var4.chargerPlanPayeNatureItems(var2.getExepayId(), 80, var1);
         this.lesRetraitsItems = var4.chargerPlanPayeNatureItems(var2.getExepayId(), 70, var1);
      }

      this.lesModeTravailItems = new ArrayList();
      this.lesModeTravailItems.add(new SelectItem("0", "Répartition par Feuilles"));
      this.lesModeTravailItems.add(new SelectItem("1", "Répartition par Activités"));
      this.lesModeTravailItems.add(new SelectItem("2", "Répartition par Services"));
      if (this.rechercheModule(40300)) {
         this.lesModeTravailItems.add(new SelectItem("3", "Répartition par Projets"));
      }

      if (this.rechercheModule(80400)) {
         this.moduleInterim = true;
         this.lesModeTravailItems.add(new SelectItem("4", "Répartition par Clients"));
         TiersDao var6 = new TiersDao(this.baseLog, this.utilInitHibernate);
         this.lesSocietesItems = var6.chargerLesClientsByIdItems(0, var1);
      } else {
         this.moduleInterim = false;
      }

      this.lesChronoMAtricule = new ArrayList();
      FeuilleCalculDao var7 = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      this.lesChronoMAtricule = var7.chargerFeuilles(var2.getExepayId(), (String)null, var1);
      this.calculeLibEntete();
      File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "optionsPaye" + File.separator + "optionsPaye_" + this.structureLog.getStrcodepays() + ".xml");
      if (var5.exists()) {
         this.afficheAjDefaut = true;
      }

   }

   public void defaultAdd() {
      if (this.optionPaye != null) {
         new OptionPaye();
         LireLesoptionsPaye var2 = new LireLesoptionsPaye();
         var2.setStrId(this.structureLog.getStrid());
         OptionPaye var1 = var2.lancerDefaut(this.structureLog.getStrcodepays());
         if (var1 != null) {
            this.optionPaye.setCnamgs(var1.getCnamgs());
            this.optionPaye.setCotisationSocialeGene(var1.getCotisationSocialeGene());
            this.optionPaye.setNbEnfantAllocation(var1.getNbEnfantAllocation());
            this.optionPaye.setNbEnfantsFiscaux(var1.getNbEnfantsFiscaux());
            this.optionPaye.setPlafond(var1.getPlafond());
            this.optionPaye.setPrestationMedicaleGene(var1.getPrestationMedicaleGene());
            this.optionPaye.setSecuriteSocialeCadre(var1.getSecuriteSocialeCadre());
            this.optionPaye.setSecuriteSocialeGene(var1.getSecuriteSocialeGene());
            this.optionPaye.setSmig(var1.getSmig());
            this.optionPaye.setTauxAt(var1.getTauxAt());
            this.optionPaye.setTauxCfpa(var1.getTauxCfpa());
            this.optionPaye.setTauxPf(var1.getTauxPf());
            this.optionPaye.setTauxTa(var1.getTauxTa());
            this.optionPaye.setTauxVf(var1.getTauxVf());
            this.optionPaye.setTauxcfcePP(var1.getTauxcfcePP());
            this.optionPaye.setTauxcfpPP(var1.getTauxcfpPP());
            this.optionPaye.setTauxcnamgsPP(var1.getTauxcnamgsPP());
            this.optionPaye.setTauxcnamgsPS(var1.getTauxcnamgsPS());
            this.optionPaye.setTauxcnssPP(var1.getTauxcnssPP());
            this.optionPaye.setTauxcnssPS(var1.getTauxcnssPS());
            this.optionPaye.setTauxcssatPP(var1.getTauxcssatPP());
            this.optionPaye.setTauxcsspfPP(var1.getTauxcsspfPP());
            this.optionPaye.setTauxfnhPP(var1.getTauxfnhPP());
            this.optionPaye.setTauxipressCadrePP(var1.getTauxipressCadrePP());
            this.optionPaye.setTauxipressCadrePS(var1.getTauxipressCadrePS());
            this.optionPaye.setTauxipressGenePP(var1.getTauxipressGenePP());
            this.optionPaye.setTauxipressGenePS(var1.getTauxipressGenePS());
            this.optionPaye.setTauxtusPP(var1.getTauxtusPP());
            this.optionPaye.setTaxeTolCv(var1.getTaxeTolCv());
            this.optionPaye.setTaxeTolPeriph(var1.getTaxeTolPeriph());
            this.optionPaye.setEloignementExpat(var1.getEloignementExpat());
            this.optionPaye.setEloignementLocal(var1.getEloignementLocal());
            if (this.structureLog.getStrmaitrecabinet() != 0) {
               this.optionPaye.setCalculRegularisation("0");
               this.optionPaye.setPlafond("0");
               this.optionPaye.setArrondiNet("0");
               this.optionPaye.setTriAgents("0");
               this.optionPaye.setRubVersement("");
               this.optionPaye.setRubSpontanee("");
               this.optionPaye.setRubRetrait("");
               this.optionPaye.setEcheanceprets("1");
               this.optionPaye.setNbEnfantsFiscaux("1");
               this.optionPaye.setRubQuinzaine("");
               this.optionPaye.setCalculRegularisation("0");
            }
         }
      }

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

      if (this.rechercheModule(50000) || this.rechercheModule(50300)) {
         this.modulePaye = true;
      }

      if (this.rechercheModule(50200)) {
         this.modulePaye = true;
         this.moduleTemps = true;
      }

      if (this.rechercheModule(40300)) {
         this.moduleProjet = true;
      }

      if (this.structureLog.getStrmaitrecabinet() == 12) {
         this.moduleStructure = true;
      }

   }

   public void creerOptionPaye() throws IOException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("nbLigneMax");
      this.racine.addContent(var1);
      var1.setText(this.optionPaye.getNbLigneMax());
      Element var2 = new Element("chargementListe");
      this.racine.addContent(var2);
      var2.setText(this.optionPaye.getChargementListe());
      Element var3 = new Element("calculRegularisation");
      this.racine.addContent(var3);
      var3.setText(this.optionPaye.getCalculRegularisation());
      Element var4 = new Element("arrondiNet");
      this.racine.addContent(var4);
      var4.setText(this.optionPaye.getArrondiNet());
      Element var5 = new Element("triAgents");
      this.racine.addContent(var5);
      var5.setText(this.optionPaye.getTriAgents());
      Element var6 = new Element("chronoMatricule");
      this.racine.addContent(var6);
      var6.setText(this.optionPaye.getChronoMatricule());
      Element var7 = new Element("modeTravail");
      this.racine.addContent(var7);
      var7.setText(this.optionPaye.getModeTravail());
      Element var8 = new Element("triModeTravail");
      this.racine.addContent(var8);
      var8.setText(this.optionPaye.getTriModeTravail());
      Element var9 = new Element("plafond");
      this.racine.addContent(var9);
      var9.setText(this.optionPaye.getPlafond());
      Element var10 = new Element("securiteSocialeGene");
      this.racine.addContent(var10);
      var10.setText("" + this.optionPaye.getSecuriteSocialeGene());
      Element var11 = new Element("securiteSocialeCadre");
      this.racine.addContent(var11);
      var11.setText("" + this.optionPaye.getSecuriteSocialeCadre());
      Element var12 = new Element("cnamgs");
      this.racine.addContent(var12);
      var12.setText("" + this.optionPaye.getCnamgs());
      Element var13 = new Element("tauxcnamgsPS");
      this.racine.addContent(var13);
      var13.setText("" + this.optionPaye.getTauxcnamgsPS());
      Element var14 = new Element("tauxcnamgsPP");
      this.racine.addContent(var14);
      var14.setText("" + this.optionPaye.getTauxcnamgsPP());
      Element var15 = new Element("tauxcnssPS");
      this.racine.addContent(var15);
      var15.setText("" + this.optionPaye.getTauxcnssPS());
      Element var16 = new Element("tauxcnssPP");
      this.racine.addContent(var16);
      var16.setText("" + this.optionPaye.getTauxcnssPP());
      Element var17 = new Element("tauxfnhPP");
      this.racine.addContent(var17);
      var17.setText("" + this.optionPaye.getTauxfnhPP());
      Element var18 = new Element("tauxcfpPP");
      this.racine.addContent(var18);
      var18.setText("" + this.optionPaye.getTauxcfpPP());
      Element var19 = new Element("tauxipressGenePS");
      this.racine.addContent(var19);
      var19.setText("" + this.optionPaye.getTauxipressGenePS());
      Element var20 = new Element("tauxipressGenePP");
      this.racine.addContent(var20);
      var20.setText("" + this.optionPaye.getTauxipressGenePP());
      Element var21 = new Element("tauxipressCadrePS");
      this.racine.addContent(var21);
      var21.setText("" + this.optionPaye.getTauxipressCadrePS());
      Element var22 = new Element("tauxipressCadrePP");
      this.racine.addContent(var22);
      var22.setText("" + this.optionPaye.getTauxipressCadrePP());
      Element var23 = new Element("tauxcsspfPP");
      this.racine.addContent(var23);
      var23.setText("" + this.optionPaye.getTauxcsspfPP());
      Element var24 = new Element("tauxcssatPP");
      this.racine.addContent(var24);
      var24.setText("" + this.optionPaye.getTauxcssatPP());
      Element var25 = new Element("tauxcfcePP");
      this.racine.addContent(var25);
      var25.setText("" + this.optionPaye.getTauxcfcePP());
      Element var26 = new Element("cotisationSocialeGene");
      this.racine.addContent(var26);
      var26.setText("" + this.optionPaye.getCotisationSocialeGene());
      Element var27 = new Element("prestationMedicaleGene");
      this.racine.addContent(var27);
      var27.setText("" + this.optionPaye.getPrestationMedicaleGene());
      Element var28 = new Element("smig");
      this.racine.addContent(var28);
      var28.setText("" + this.optionPaye.getSmig());
      Element var29 = new Element("trimf");
      this.racine.addContent(var29);
      var29.setText(this.optionPaye.getTrimf());
      Element var30 = new Element("nbEnfantAllocation");
      this.racine.addContent(var30);
      var30.setText("" + this.optionPaye.getNbEnfantAllocation());
      Element var31 = new Element("rubVersement");
      this.racine.addContent(var31);
      var31.setText("" + this.optionPaye.getRubVersement());
      Element var32 = new Element("rubSpontanee");
      this.racine.addContent(var32);
      var32.setText("" + this.optionPaye.getRubSpontanee());
      Element var33 = new Element("rubRetrait");
      this.racine.addContent(var33);
      var33.setText("" + this.optionPaye.getRubRetrait());
      Element var34 = new Element("heurejournee");
      this.racine.addContent(var34);
      var34.setText("" + this.optionPaye.getHeurejournee());
      Element var35 = new Element("heuredemijournee");
      this.racine.addContent(var35);
      var35.setText("" + this.optionPaye.getHeuredemijournee());
      Element var36 = new Element("dossierExport");
      this.racine.addContent(var36);
      var36.setText(this.optionPaye.getDossierExport());
      Element var37 = new Element("echeanceprets");
      this.racine.addContent(var37);
      var37.setText(this.optionPaye.getEcheanceprets());
      Element var38 = new Element("baseconges");
      this.racine.addContent(var38);
      var38.setText(this.optionPaye.getBaseconges());
      Element var39 = new Element("nbEnfantsFiscaux");
      this.racine.addContent(var39);
      var39.setText(this.optionPaye.getNbEnfantsFiscaux());
      Element var40 = new Element("rubQuinzaine");
      this.racine.addContent(var40);
      var40.setText(this.optionPaye.getRubQuinzaine());
      Element var41 = new Element("societeInterim");
      this.racine.addContent(var41);
      var41.setText(this.optionPaye.getSocieteInterim());
      Element var42 = new Element("tauxtusPP");
      this.racine.addContent(var42);
      var42.setText("" + this.optionPaye.getTauxtusPP());
      Element var43 = new Element("taxeTolCv");
      this.racine.addContent(var43);
      var43.setText("" + this.optionPaye.getTaxeTolCv());
      Element var44 = new Element("taxeTolPeriph");
      this.racine.addContent(var44);
      var44.setText("" + this.optionPaye.getTaxeTolPeriph());
      Element var45 = new Element("tauxAt");
      this.racine.addContent(var45);
      var45.setText("" + this.optionPaye.getTauxAt());
      Element var46 = new Element("tauxPf");
      this.racine.addContent(var46);
      var46.setText("" + this.optionPaye.getTauxPf());
      Element var47 = new Element("eloignementExpat");
      this.racine.addContent(var47);
      var47.setText("" + this.optionPaye.getEloignementExpat());
      Element var48 = new Element("eloignementLocal");
      this.racine.addContent(var48);
      var48.setText("" + this.optionPaye.getEloignementLocal());
      Element var49 = new Element("axeStructure");
      this.racine.addContent(var49);
      var49.setText(this.optionPaye.getAxeStructure());
      Element var50 = new Element("axeSite");
      this.racine.addContent(var50);
      var50.setText(this.optionPaye.getAxeSite());
      Element var51 = new Element("axeRegion");
      this.racine.addContent(var51);
      var51.setText(this.optionPaye.getAxeRegion());
      Element var52 = new Element("axeUsine");
      this.racine.addContent(var52);
      var52.setText(this.optionPaye.getAxeUsine());
      Element var53 = new Element("axeActivite");
      this.racine.addContent(var53);
      var53.setText(this.optionPaye.getAxeActivite());
      Element var54 = new Element("axeAgent");
      this.racine.addContent(var54);
      var54.setText(this.optionPaye.getAxeAgent());
      Element var55 = new Element("axeChantier");
      this.racine.addContent(var55);
      var55.setText(this.optionPaye.getAxeChantier());
      Element var56 = new Element("axeParc");
      this.racine.addContent(var56);
      var56.setText(this.optionPaye.getAxeParc());
      Element var57 = new Element("axeMission");
      this.racine.addContent(var57);
      var57.setText(this.optionPaye.getAxeMission());
      Element var58 = new Element("axeCles");
      this.racine.addContent(var58);
      var58.setText(this.optionPaye.getAxeCles());
      Element var59 = new Element("axeProjet");
      this.racine.addContent(var59);
      var59.setText(this.optionPaye.getAxeProjet());
      Element var60 = new Element("axeDossier");
      this.racine.addContent(var60);
      var60.setText(this.optionPaye.getAxeDossier());
      Element var61 = new Element("trfCptePaye");
      this.racine.addContent(var61);
      var61.setText(this.optionPaye.getTrfCptePaye());
      Element var62 = new Element("exportOd");
      this.racine.addContent(var62);
      var62.setText(this.optionPaye.getExportOd());
      Element var63 = new Element("nbcrExport");
      this.racine.addContent(var63);
      var63.setText(this.optionPaye.getNbcrExport());
      Element var64 = new Element("nbcrTiersExport");
      this.racine.addContent(var64);
      var64.setText(this.optionPaye.getNbcrTiersExport());
      Element var65 = new Element("prefixeTiersExport");
      this.racine.addContent(var65);
      var65.setText(this.optionPaye.getPrefixeTiersExport());
      Element var66 = new Element("pointage");
      this.racine.addContent(var66);
      var66.setText(this.optionPaye.getPointage());
      Element var67 = new Element("temps");
      this.racine.addContent(var67);
      var67.setText(this.optionPaye.getTemps());
      this.enregistrer();
   }

   public void updateOptionPaye() throws IOException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("nbLigneMax");
      this.racine.addContent(var1);
      var1.setText(this.optionPaye.getNbLigneMax());
      Element var2 = new Element("chargementListe");
      this.racine.addContent(var2);
      var2.setText(this.optionPaye.getChargementListe());
      Element var3 = new Element("calculRegularisation");
      this.racine.addContent(var3);
      var3.setText(this.optionPaye.getCalculRegularisation());
      Element var4 = new Element("arrondiNet");
      this.racine.addContent(var4);
      var4.setText(this.optionPaye.getArrondiNet());
      Element var5 = new Element("triAgents");
      this.racine.addContent(var5);
      var5.setText(this.optionPaye.getTriAgents());
      Element var6 = new Element("chronoMatricule");
      this.racine.addContent(var6);
      var6.setText(this.optionPaye.getChronoMatricule());
      Element var7 = new Element("modeTravail");
      this.racine.addContent(var7);
      var7.setText(this.optionPaye.getModeTravail());
      Element var8 = new Element("triModeTravail");
      this.racine.addContent(var8);
      var8.setText(this.optionPaye.getTriModeTravail());
      Element var9 = new Element("plafond");
      this.racine.addContent(var9);
      var9.setText(this.optionPaye.getPlafond());
      Element var10 = new Element("securiteSocialeGene");
      this.racine.addContent(var10);
      var10.setText("" + this.optionPaye.getSecuriteSocialeGene());
      Element var11 = new Element("securiteSocialeCadre");
      this.racine.addContent(var11);
      var11.setText("" + this.optionPaye.getSecuriteSocialeCadre());
      Element var12 = new Element("cnamgs");
      this.racine.addContent(var12);
      var12.setText("" + this.optionPaye.getCnamgs());
      Element var13 = new Element("tauxcnamgsPS");
      this.racine.addContent(var13);
      var13.setText("" + this.optionPaye.getTauxcnamgsPS());
      Element var14 = new Element("tauxcnamgsPP");
      this.racine.addContent(var14);
      var14.setText("" + this.optionPaye.getTauxcnamgsPP());
      Element var15 = new Element("tauxcnssPS");
      this.racine.addContent(var15);
      var15.setText("" + this.optionPaye.getTauxcnssPS());
      Element var16 = new Element("tauxcnssPP");
      this.racine.addContent(var16);
      var16.setText("" + this.optionPaye.getTauxcnssPP());
      Element var17 = new Element("tauxfnhPP");
      this.racine.addContent(var17);
      var17.setText("" + this.optionPaye.getTauxfnhPP());
      Element var18 = new Element("tauxcfpPP");
      this.racine.addContent(var18);
      var18.setText("" + this.optionPaye.getTauxcfpPP());
      Element var19 = new Element("tauxipressGenePS");
      this.racine.addContent(var19);
      var19.setText("" + this.optionPaye.getTauxipressGenePS());
      Element var20 = new Element("tauxipressGenePP");
      this.racine.addContent(var20);
      var20.setText("" + this.optionPaye.getTauxipressGenePP());
      Element var21 = new Element("tauxipressCadrePS");
      this.racine.addContent(var21);
      var21.setText("" + this.optionPaye.getTauxipressCadrePS());
      Element var22 = new Element("tauxipressCadrePP");
      this.racine.addContent(var22);
      var22.setText("" + this.optionPaye.getTauxipressCadrePP());
      Element var23 = new Element("tauxcsspfPP");
      this.racine.addContent(var23);
      var23.setText("" + this.optionPaye.getTauxcsspfPP());
      Element var24 = new Element("tauxcssatPP");
      this.racine.addContent(var24);
      var24.setText("" + this.optionPaye.getTauxcssatPP());
      Element var25 = new Element("tauxcfcePP");
      this.racine.addContent(var25);
      var25.setText("" + this.optionPaye.getTauxcfcePP());
      Element var26 = new Element("cotisationSocialeGene");
      this.racine.addContent(var26);
      var26.setText("" + this.optionPaye.getCotisationSocialeGene());
      Element var27 = new Element("prestationMedicaleGene");
      this.racine.addContent(var27);
      var27.setText("" + this.optionPaye.getPrestationMedicaleGene());
      Element var28 = new Element("smig");
      this.racine.addContent(var28);
      var28.setText("" + this.optionPaye.getSmig());
      Element var29 = new Element("trimf");
      this.racine.addContent(var29);
      var29.setText(this.optionPaye.getTrimf());
      Element var30 = new Element("nbEnfantAllocation");
      this.racine.addContent(var30);
      var30.setText("" + this.optionPaye.getNbEnfantAllocation());
      Element var31 = new Element("rubVersement");
      this.racine.addContent(var31);
      var31.setText("" + this.optionPaye.getRubVersement());
      Element var32 = new Element("rubSpontanee");
      this.racine.addContent(var32);
      var32.setText("" + this.optionPaye.getRubSpontanee());
      Element var33 = new Element("rubRetrait");
      this.racine.addContent(var33);
      var33.setText("" + this.optionPaye.getRubRetrait());
      Element var34 = new Element("heurejournee");
      this.racine.addContent(var34);
      var34.setText("" + this.optionPaye.getHeurejournee());
      Element var35 = new Element("heuredemijournee");
      this.racine.addContent(var35);
      var35.setText("" + this.optionPaye.getHeuredemijournee());
      Element var36 = new Element("dossierExport");
      this.racine.addContent(var36);
      var36.setText(this.optionPaye.getDossierExport());
      Element var37 = new Element("echeanceprets");
      this.racine.addContent(var37);
      var37.setText(this.optionPaye.getEcheanceprets());
      Element var38 = new Element("baseconges");
      this.racine.addContent(var38);
      var38.setText(this.optionPaye.getBaseconges());
      Element var39 = new Element("nbEnfantsFiscaux");
      this.racine.addContent(var39);
      var39.setText(this.optionPaye.getNbEnfantsFiscaux());
      Element var40 = new Element("rubQuinzaine");
      this.racine.addContent(var40);
      var40.setText(this.optionPaye.getRubQuinzaine());
      Element var41 = new Element("societeInterim");
      this.racine.addContent(var41);
      var41.setText(this.optionPaye.getSocieteInterim());
      Element var42 = new Element("tauxtusPP");
      this.racine.addContent(var42);
      var42.setText("" + this.optionPaye.getTauxtusPP());
      Element var43 = new Element("taxeTolCv");
      this.racine.addContent(var43);
      var43.setText("" + this.optionPaye.getTaxeTolCv());
      Element var44 = new Element("taxeTolPeriph");
      this.racine.addContent(var44);
      var44.setText("" + this.optionPaye.getTaxeTolPeriph());
      Element var45 = new Element("tauxAt");
      this.racine.addContent(var45);
      var45.setText("" + this.optionPaye.getTauxAt());
      Element var46 = new Element("tauxPf");
      this.racine.addContent(var46);
      var46.setText("" + this.optionPaye.getTauxPf());
      Element var47 = new Element("eloignementExpat");
      this.racine.addContent(var47);
      var47.setText("" + this.optionPaye.getEloignementExpat());
      Element var48 = new Element("eloignementLocal");
      this.racine.addContent(var48);
      var48.setText("" + this.optionPaye.getEloignementLocal());
      Element var49 = new Element("axeStructure");
      this.racine.addContent(var49);
      var49.setText(this.optionPaye.getAxeStructure());
      Element var50 = new Element("axeSite");
      this.racine.addContent(var50);
      var50.setText(this.optionPaye.getAxeSite());
      Element var51 = new Element("axeRegion");
      this.racine.addContent(var51);
      var51.setText(this.optionPaye.getAxeRegion());
      Element var52 = new Element("axeUsine");
      this.racine.addContent(var52);
      var52.setText(this.optionPaye.getAxeUsine());
      Element var53 = new Element("axeActivite");
      this.racine.addContent(var53);
      var53.setText(this.optionPaye.getAxeActivite());
      Element var54 = new Element("axeAgent");
      this.racine.addContent(var54);
      var54.setText(this.optionPaye.getAxeAgent());
      Element var55 = new Element("axeChantier");
      this.racine.addContent(var55);
      var55.setText(this.optionPaye.getAxeChantier());
      Element var56 = new Element("axeParc");
      this.racine.addContent(var56);
      var56.setText(this.optionPaye.getAxeParc());
      Element var57 = new Element("axeMission");
      this.racine.addContent(var57);
      var57.setText(this.optionPaye.getAxeMission());
      Element var58 = new Element("axeCles");
      this.racine.addContent(var58);
      var58.setText(this.optionPaye.getAxeCles());
      Element var59 = new Element("axeProjet");
      this.racine.addContent(var59);
      var59.setText(this.optionPaye.getAxeProjet());
      Element var60 = new Element("axeDossier");
      this.racine.addContent(var60);
      var60.setText(this.optionPaye.getAxeDossier());
      Element var61 = new Element("trfCptePaye");
      this.racine.addContent(var61);
      var61.setText(this.optionPaye.getTrfCptePaye());
      Element var62 = new Element("exportOd");
      this.racine.addContent(var62);
      var62.setText(this.optionPaye.getExportOd());
      Element var63 = new Element("nbcrExport");
      this.racine.addContent(var63);
      var63.setText(this.optionPaye.getNbcrExport());
      Element var64 = new Element("nbcrTiersExport");
      this.racine.addContent(var64);
      var64.setText(this.optionPaye.getNbcrTiersExport());
      Element var65 = new Element("prefixeTiersExport");
      this.racine.addContent(var65);
      var65.setText(this.optionPaye.getPrefixeTiersExport());
      Element var66 = new Element("pointage");
      this.racine.addContent(var66);
      var66.setText(this.optionPaye.getPointage());
      Element var67 = new Element("temps");
      this.racine.addContent(var67);
      var67.setText(this.optionPaye.getTemps());
      this.enregistrer();
   }

   public void creerOptionsPayeCompta(OptionComptabilite var1) throws IOException {
      this.racine.removeContent();
      Element var2 = new Element("nbLigneMax");
      this.racine.addContent(var2);
      var2.setText(this.optionPaye.getNbLigneMax());
      Element var3 = new Element("chargementListe");
      this.racine.addContent(var3);
      var3.setText(this.optionPaye.getChargementListe());
      Element var4 = new Element("calculRegularisation");
      this.racine.addContent(var4);
      var4.setText(this.optionPaye.getCalculRegularisation());
      Element var5 = new Element("arrondiNet");
      this.racine.addContent(var5);
      var5.setText(this.optionPaye.getArrondiNet());
      Element var6 = new Element("triAgents");
      this.racine.addContent(var6);
      var6.setText(this.optionPaye.getTriAgents());
      Element var7 = new Element("chronoMatricule");
      this.racine.addContent(var7);
      var7.setText(this.optionPaye.getChronoMatricule());
      Element var8 = new Element("modeTravail");
      this.racine.addContent(var8);
      var8.setText(this.optionPaye.getModeTravail());
      Element var9 = new Element("triModeTravail");
      this.racine.addContent(var9);
      var9.setText(this.optionPaye.getTriModeTravail());
      Element var10 = new Element("plafond");
      this.racine.addContent(var10);
      var10.setText(this.optionPaye.getPlafond());
      Element var11 = new Element("securiteSocialeGene");
      this.racine.addContent(var11);
      var11.setText("" + this.optionPaye.getSecuriteSocialeGene());
      Element var12 = new Element("securiteSocialeCadre");
      this.racine.addContent(var12);
      var12.setText("" + this.optionPaye.getSecuriteSocialeCadre());
      Element var13 = new Element("cnamgs");
      this.racine.addContent(var13);
      var13.setText("" + this.optionPaye.getCnamgs());
      Element var14 = new Element("tauxcnamgsPS");
      this.racine.addContent(var14);
      var14.setText("" + this.optionPaye.getTauxcnamgsPS());
      Element var15 = new Element("tauxcnamgsPP");
      this.racine.addContent(var15);
      var15.setText("" + this.optionPaye.getTauxcnamgsPP());
      Element var16 = new Element("tauxcnssPS");
      this.racine.addContent(var16);
      var16.setText("" + this.optionPaye.getTauxcnssPS());
      Element var17 = new Element("tauxcnssPP");
      this.racine.addContent(var17);
      var17.setText("" + this.optionPaye.getTauxcnssPP());
      Element var18 = new Element("tauxfnhPP");
      this.racine.addContent(var18);
      var18.setText("" + this.optionPaye.getTauxfnhPP());
      Element var19 = new Element("tauxcfpPP");
      this.racine.addContent(var19);
      var19.setText("" + this.optionPaye.getTauxcfpPP());
      Element var20 = new Element("tauxipressGenePS");
      this.racine.addContent(var20);
      var20.setText("" + this.optionPaye.getTauxipressGenePS());
      Element var21 = new Element("tauxipressGenePP");
      this.racine.addContent(var21);
      var21.setText("" + this.optionPaye.getTauxipressGenePP());
      Element var22 = new Element("tauxipressCadrePS");
      this.racine.addContent(var22);
      var22.setText("" + this.optionPaye.getTauxipressCadrePS());
      Element var23 = new Element("tauxipressCadrePP");
      this.racine.addContent(var23);
      var23.setText("" + this.optionPaye.getTauxipressCadrePP());
      Element var24 = new Element("tauxcsspfPP");
      this.racine.addContent(var24);
      var24.setText("" + this.optionPaye.getTauxcsspfPP());
      Element var25 = new Element("tauxcssatPP");
      this.racine.addContent(var25);
      var25.setText("" + this.optionPaye.getTauxcssatPP());
      Element var26 = new Element("tauxcfcePP");
      this.racine.addContent(var26);
      var26.setText("" + this.optionPaye.getTauxcfcePP());
      Element var27 = new Element("cotisationSocialeGene");
      this.racine.addContent(var27);
      var27.setText("" + this.optionPaye.getCotisationSocialeGene());
      Element var28 = new Element("prestationMedicaleGene");
      this.racine.addContent(var28);
      var28.setText("" + this.optionPaye.getPrestationMedicaleGene());
      Element var29 = new Element("smig");
      this.racine.addContent(var29);
      var29.setText("" + this.optionPaye.getSmig());
      Element var30 = new Element("trimf");
      this.racine.addContent(var30);
      var30.setText(this.optionPaye.getTrimf());
      Element var31 = new Element("nbEnfantAllocation");
      this.racine.addContent(var31);
      var31.setText("" + this.optionPaye.getNbEnfantAllocation());
      Element var32 = new Element("rubVersement");
      this.racine.addContent(var32);
      var32.setText("" + this.optionPaye.getRubVersement());
      Element var33 = new Element("rubSpontanee");
      this.racine.addContent(var33);
      var33.setText("" + this.optionPaye.getRubSpontanee());
      Element var34 = new Element("rubRetrait");
      this.racine.addContent(var34);
      var34.setText("" + this.optionPaye.getRubRetrait());
      Element var35 = new Element("heurejournee");
      this.racine.addContent(var35);
      var35.setText("" + this.optionPaye.getHeurejournee());
      Element var36 = new Element("heuredemijournee");
      this.racine.addContent(var36);
      var36.setText("" + this.optionPaye.getHeuredemijournee());
      Element var37 = new Element("dossierExport");
      this.racine.addContent(var37);
      var37.setText(this.optionPaye.getDossierExport());
      Element var38 = new Element("echeanceprets");
      this.racine.addContent(var38);
      var38.setText(this.optionPaye.getEcheanceprets());
      Element var39 = new Element("baseconges");
      this.racine.addContent(var39);
      var39.setText(this.optionPaye.getBaseconges());
      Element var40 = new Element("nbEnfantsFiscaux");
      this.racine.addContent(var40);
      var40.setText(this.optionPaye.getNbEnfantsFiscaux());
      Element var41 = new Element("rubQuinzaine");
      this.racine.addContent(var41);
      var41.setText(this.optionPaye.getRubQuinzaine());
      Element var42 = new Element("societeInterim");
      this.racine.addContent(var42);
      var42.setText(this.optionPaye.getSocieteInterim());
      Element var43 = new Element("tauxtusPP");
      this.racine.addContent(var43);
      var43.setText("" + this.optionPaye.getTauxtusPP());
      Element var44 = new Element("taxeTolCv");
      this.racine.addContent(var44);
      var44.setText("" + this.optionPaye.getTaxeTolCv());
      Element var45 = new Element("taxeTolPeriph");
      this.racine.addContent(var45);
      var45.setText("" + this.optionPaye.getTaxeTolPeriph());
      Element var46 = new Element("tauxAt");
      this.racine.addContent(var46);
      var46.setText("" + this.optionPaye.getTauxAt());
      Element var47 = new Element("tauxPf");
      this.racine.addContent(var47);
      var47.setText("" + this.optionPaye.getTauxPf());
      Element var48 = new Element("eloignementExpat");
      this.racine.addContent(var48);
      var48.setText("" + this.optionPaye.getEloignementExpat());
      Element var49 = new Element("eloignementLocal");
      this.racine.addContent(var49);
      var49.setText("" + this.optionPaye.getEloignementLocal());
      Element var50 = new Element("axeStructure");
      this.racine.addContent(var50);
      var50.setText(this.optionPaye.getAxeStructure());
      Element var51 = new Element("axeSite");
      this.racine.addContent(var51);
      var51.setText(this.optionPaye.getAxeSite());
      Element var52 = new Element("axeRegion");
      this.racine.addContent(var52);
      var52.setText(this.optionPaye.getAxeRegion());
      Element var53 = new Element("axeUsine");
      this.racine.addContent(var53);
      var53.setText(this.optionPaye.getAxeUsine());
      Element var54 = new Element("axeActivite");
      this.racine.addContent(var54);
      var54.setText(this.optionPaye.getAxeActivite());
      Element var55 = new Element("axeAgent");
      this.racine.addContent(var55);
      var55.setText(this.optionPaye.getAxeAgent());
      Element var56 = new Element("axeChantier");
      this.racine.addContent(var56);
      var56.setText(this.optionPaye.getAxeChantier());
      Element var57 = new Element("axeParc");
      this.racine.addContent(var57);
      var57.setText(this.optionPaye.getAxeParc());
      Element var58 = new Element("axeMission");
      this.racine.addContent(var58);
      var58.setText(this.optionPaye.getAxeMission());
      Element var59 = new Element("axeCles");
      this.racine.addContent(var59);
      var59.setText(this.optionPaye.getAxeCles());
      Element var60 = new Element("axeProjet");
      this.racine.addContent(var60);
      var60.setText(this.optionPaye.getAxeProjet());
      Element var61 = new Element("axeDossier");
      this.racine.addContent(var61);
      var61.setText(this.optionPaye.getAxeDossier());
      Element var62 = new Element("trfCptePaye");
      this.racine.addContent(var62);
      var62.setText(this.optionPaye.getTrfCptePaye());
      Element var63 = new Element("exportOd");
      this.racine.addContent(var63);
      var63.setText(this.optionPaye.getExportOd());
      Element var64 = new Element("nbcrExport");
      this.racine.addContent(var64);
      var64.setText(this.optionPaye.getNbcrExport());
      Element var65 = new Element("nbcrTiersExport");
      this.racine.addContent(var65);
      var65.setText(this.optionPaye.getNbcrTiersExport());
      Element var66 = new Element("prefixeTiersExport");
      this.racine.addContent(var66);
      var66.setText(this.optionPaye.getPrefixeTiersExport());
      Element var67 = new Element("pointage");
      this.racine.addContent(var67);
      var67.setText(this.optionPaye.getPointage());
      Element var68 = new Element("temps");
      this.racine.addContent(var68);
      var68.setText(this.optionPaye.getTemps());
      this.enregistrer();
   }

   public void creerOptionsPayeAchats(OptionAchats var1) throws IOException {
      this.racine.removeContent();
      Element var2 = new Element("nbLigneMax");
      this.racine.addContent(var2);
      var2.setText(this.optionPaye.getNbLigneMax());
      Element var3 = new Element("chargementListe");
      this.racine.addContent(var3);
      var3.setText(this.optionPaye.getChargementListe());
      Element var4 = new Element("calculRegularisation");
      this.racine.addContent(var4);
      var4.setText(this.optionPaye.getCalculRegularisation());
      Element var5 = new Element("arrondiNet");
      this.racine.addContent(var5);
      var5.setText(this.optionPaye.getArrondiNet());
      Element var6 = new Element("triAgents");
      this.racine.addContent(var6);
      var6.setText(this.optionPaye.getTriAgents());
      Element var7 = new Element("chronoMatricule");
      this.racine.addContent(var7);
      var7.setText(this.optionPaye.getChronoMatricule());
      Element var8 = new Element("modeTravail");
      this.racine.addContent(var8);
      var8.setText(this.optionPaye.getModeTravail());
      Element var9 = new Element("triModeTravail");
      this.racine.addContent(var9);
      var9.setText(this.optionPaye.getTriModeTravail());
      Element var10 = new Element("plafond");
      this.racine.addContent(var10);
      var10.setText(this.optionPaye.getPlafond());
      Element var11 = new Element("securiteSocialeGene");
      this.racine.addContent(var11);
      var11.setText("" + this.optionPaye.getSecuriteSocialeGene());
      Element var12 = new Element("securiteSocialeCadre");
      this.racine.addContent(var12);
      var12.setText("" + this.optionPaye.getSecuriteSocialeCadre());
      Element var13 = new Element("cnamgs");
      this.racine.addContent(var13);
      var13.setText("" + this.optionPaye.getCnamgs());
      Element var14 = new Element("tauxcnamgsPS");
      this.racine.addContent(var14);
      var14.setText("" + this.optionPaye.getTauxcnamgsPS());
      Element var15 = new Element("tauxcnamgsPP");
      this.racine.addContent(var15);
      var15.setText("" + this.optionPaye.getTauxcnamgsPP());
      Element var16 = new Element("tauxcnssPS");
      this.racine.addContent(var16);
      var16.setText("" + this.optionPaye.getTauxcnssPS());
      Element var17 = new Element("tauxcnssPP");
      this.racine.addContent(var17);
      var17.setText("" + this.optionPaye.getTauxcnssPP());
      Element var18 = new Element("tauxfnhPP");
      this.racine.addContent(var18);
      var18.setText("" + this.optionPaye.getTauxfnhPP());
      Element var19 = new Element("tauxcfpPP");
      this.racine.addContent(var19);
      var19.setText("" + this.optionPaye.getTauxcfpPP());
      Element var20 = new Element("tauxipressGenePS");
      this.racine.addContent(var20);
      var20.setText("" + this.optionPaye.getTauxipressGenePS());
      Element var21 = new Element("tauxipressGenePP");
      this.racine.addContent(var21);
      var21.setText("" + this.optionPaye.getTauxipressGenePP());
      Element var22 = new Element("tauxipressCadrePS");
      this.racine.addContent(var22);
      var22.setText("" + this.optionPaye.getTauxipressCadrePS());
      Element var23 = new Element("tauxipressCadrePP");
      this.racine.addContent(var23);
      var23.setText("" + this.optionPaye.getTauxipressCadrePP());
      Element var24 = new Element("tauxcsspfPP");
      this.racine.addContent(var24);
      var24.setText("" + this.optionPaye.getTauxcsspfPP());
      Element var25 = new Element("tauxcssatPP");
      this.racine.addContent(var25);
      var25.setText("" + this.optionPaye.getTauxcssatPP());
      Element var26 = new Element("tauxcfcePP");
      this.racine.addContent(var26);
      var26.setText("" + this.optionPaye.getTauxcfcePP());
      Element var27 = new Element("cotisationSocialeGene");
      this.racine.addContent(var27);
      var27.setText("" + this.optionPaye.getCotisationSocialeGene());
      Element var28 = new Element("prestationMedicaleGene");
      this.racine.addContent(var28);
      var28.setText("" + this.optionPaye.getPrestationMedicaleGene());
      Element var29 = new Element("smig");
      this.racine.addContent(var29);
      var29.setText("" + this.optionPaye.getSmig());
      Element var30 = new Element("trimf");
      this.racine.addContent(var30);
      var30.setText(this.optionPaye.getTrimf());
      Element var31 = new Element("nbEnfantAllocation");
      this.racine.addContent(var31);
      var31.setText("" + this.optionPaye.getNbEnfantAllocation());
      Element var32 = new Element("rubVersement");
      this.racine.addContent(var32);
      var32.setText("" + this.optionPaye.getRubVersement());
      Element var33 = new Element("rubSpontanee");
      this.racine.addContent(var33);
      var33.setText("" + this.optionPaye.getRubSpontanee());
      Element var34 = new Element("rubRetrait");
      this.racine.addContent(var34);
      var34.setText("" + this.optionPaye.getRubRetrait());
      Element var35 = new Element("heurejournee");
      this.racine.addContent(var35);
      var35.setText("" + this.optionPaye.getHeurejournee());
      Element var36 = new Element("heuredemijournee");
      this.racine.addContent(var36);
      var36.setText("" + this.optionPaye.getHeuredemijournee());
      Element var37 = new Element("dossierExport");
      this.racine.addContent(var37);
      var37.setText(this.optionPaye.getDossierExport());
      Element var38 = new Element("echeanceprets");
      this.racine.addContent(var38);
      var38.setText(this.optionPaye.getEcheanceprets());
      Element var39 = new Element("baseconges");
      this.racine.addContent(var39);
      var39.setText(this.optionPaye.getBaseconges());
      Element var40 = new Element("nbEnfantsFiscaux");
      this.racine.addContent(var40);
      var40.setText(this.optionPaye.getNbEnfantsFiscaux());
      Element var41 = new Element("rubQuinzaine");
      this.racine.addContent(var41);
      var41.setText(this.optionPaye.getRubQuinzaine());
      Element var42 = new Element("societeInterim");
      this.racine.addContent(var42);
      var42.setText(this.optionPaye.getSocieteInterim());
      Element var43 = new Element("tauxtusPP");
      this.racine.addContent(var43);
      var43.setText("" + this.optionPaye.getTauxtusPP());
      Element var44 = new Element("taxeTolCv");
      this.racine.addContent(var44);
      var44.setText("" + this.optionPaye.getTaxeTolCv());
      Element var45 = new Element("taxeTolPeriph");
      this.racine.addContent(var45);
      var45.setText("" + this.optionPaye.getTaxeTolPeriph());
      Element var46 = new Element("tauxAt");
      this.racine.addContent(var46);
      var46.setText("" + this.optionPaye.getTauxAt());
      Element var47 = new Element("tauxPf");
      this.racine.addContent(var47);
      var47.setText("" + this.optionPaye.getTauxPf());
      Element var48 = new Element("eloignementExpat");
      this.racine.addContent(var48);
      var48.setText("" + this.optionPaye.getEloignementExpat());
      Element var49 = new Element("eloignementLocal");
      this.racine.addContent(var49);
      var49.setText("" + this.optionPaye.getEloignementLocal());
      Element var50 = new Element("axeStructure");
      this.racine.addContent(var50);
      var50.setText(this.optionPaye.getAxeStructure());
      Element var51 = new Element("axeSite");
      this.racine.addContent(var51);
      var51.setText(this.optionPaye.getAxeSite());
      Element var52 = new Element("axeRegion");
      this.racine.addContent(var52);
      var52.setText(this.optionPaye.getAxeRegion());
      Element var53 = new Element("axeUsine");
      this.racine.addContent(var53);
      var53.setText(this.optionPaye.getAxeUsine());
      Element var54 = new Element("axeActivite");
      this.racine.addContent(var54);
      var54.setText(this.optionPaye.getAxeActivite());
      Element var55 = new Element("axeAgent");
      this.racine.addContent(var55);
      var55.setText(this.optionPaye.getAxeAgent());
      Element var56 = new Element("axeChantier");
      this.racine.addContent(var56);
      var56.setText(this.optionPaye.getAxeChantier());
      Element var57 = new Element("axeParc");
      this.racine.addContent(var57);
      var57.setText(this.optionPaye.getAxeParc());
      Element var58 = new Element("axeMission");
      this.racine.addContent(var58);
      var58.setText(this.optionPaye.getAxeMission());
      Element var59 = new Element("axeCles");
      this.racine.addContent(var59);
      var59.setText(this.optionPaye.getAxeCles());
      Element var60 = new Element("axeProjet");
      this.racine.addContent(var60);
      var60.setText(this.optionPaye.getAxeProjet());
      Element var61 = new Element("axeDossier");
      this.racine.addContent(var61);
      var61.setText(this.optionPaye.getAxeDossier());
      Element var62 = new Element("trfCptePaye");
      this.racine.addContent(var62);
      var62.setText(this.optionPaye.getTrfCptePaye());
      Element var63 = new Element("exportOd");
      this.racine.addContent(var63);
      var63.setText(this.optionPaye.getExportOd());
      Element var64 = new Element("nbcrExport");
      this.racine.addContent(var64);
      var64.setText(this.optionPaye.getNbcrExport());
      Element var65 = new Element("nbcrTiersExport");
      this.racine.addContent(var65);
      var65.setText(this.optionPaye.getNbcrTiersExport());
      Element var66 = new Element("prefixeTiersExport");
      this.racine.addContent(var66);
      var66.setText(this.optionPaye.getPrefixeTiersExport());
      Element var67 = new Element("pointage");
      this.racine.addContent(var67);
      var67.setText(this.optionPaye.getPointage());
      Element var68 = new Element("temps");
      this.racine.addContent(var68);
      var68.setText(this.optionPaye.getTemps());
      this.enregistrer();
   }

   public void enregistrer() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "optionsPaye.xml");
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

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
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

   public List getLesRetraitsItems() {
      return this.lesRetraitsItems;
   }

   public void setLesRetraitsItems(List var1) {
      this.lesRetraitsItems = var1;
   }

   public List getLesVersementsItems() {
      return this.lesVersementsItems;
   }

   public void setLesVersementsItems(List var1) {
      this.lesVersementsItems = var1;
   }

   public List getLesModeTravailItems() {
      return this.lesModeTravailItems;
   }

   public void setLesModeTravailItems(List var1) {
      this.lesModeTravailItems = var1;
   }

   public List getLesChronoMAtricule() {
      return this.lesChronoMAtricule;
   }

   public void setLesChronoMAtricule(List var1) {
      this.lesChronoMAtricule = var1;
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

   public boolean isModuleUsine() {
      return this.moduleUsine;
   }

   public void setModuleUsine(boolean var1) {
      this.moduleUsine = var1;
   }

   public List getLesSocietesItems() {
      return this.lesSocietesItems;
   }

   public void setLesSocietesItems(List var1) {
      this.lesSocietesItems = var1;
   }

   public boolean isModuleInterim() {
      return this.moduleInterim;
   }

   public void setModuleInterim(boolean var1) {
      this.moduleInterim = var1;
   }

   public boolean isModuleTemps() {
      return this.moduleTemps;
   }

   public void setModuleTemps(boolean var1) {
      this.moduleTemps = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }
}
