package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionCaisses;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormOptionsCaisse implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String obsAnalytique;
   private boolean griseAnalytique = false;
   private OptionCaisses optionCaisses = new OptionCaisses();
   private Element racine = new Element("options_caisses");
   private Document document;
   private boolean griserNbrCarNumCpte;
   private ObjetCompte objetCompte;
   private List mesModelesRapport;
   private boolean lib1 = false;
   private boolean lib2 = false;
   private boolean lib3 = false;
   private boolean lib4 = false;
   private boolean lib5 = false;
   private boolean lib6 = false;
   private boolean lib7 = false;
   private boolean lib8 = false;
   private boolean lib9 = false;
   private boolean lib10 = false;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;

   public FormOptionsCaisse() throws SAXException {
      this.document = new Document(this.racine);
      this.mesModelesRapport = new ArrayList();
   }

   public void initlisteImp() {
      this.mesModelesRapport.clear();
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "operation" + File.separator + "rapport" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.mesModelesRapport.add(new SelectItem(var5));
            }
         }
      }

      this.calculeLibEntete();
   }

   public void calculeLibEntete() {
      if (this.optionCaisses.getLib1ENTETE() != null && !this.optionCaisses.getLib1ENTETE().isEmpty()) {
         this.lib1 = true;
      } else {
         this.lib1 = false;
      }

      if (this.optionCaisses.getLib2ENTETE() != null && !this.optionCaisses.getLib2ENTETE().isEmpty()) {
         this.lib2 = true;
      } else {
         this.lib2 = false;
      }

      if (this.optionCaisses.getLib3ENTETE() != null && !this.optionCaisses.getLib3ENTETE().isEmpty()) {
         this.lib3 = true;
      } else {
         this.lib3 = false;
      }

      if (this.optionCaisses.getLib4ENTETE() != null && !this.optionCaisses.getLib4ENTETE().isEmpty()) {
         this.lib4 = true;
      } else {
         this.lib4 = false;
      }

      if (this.optionCaisses.getLib5ENTETE() != null && !this.optionCaisses.getLib5ENTETE().isEmpty()) {
         this.lib5 = true;
      } else {
         this.lib5 = false;
      }

      if (this.optionCaisses.getLib6ENTETE() != null && !this.optionCaisses.getLib6ENTETE().isEmpty()) {
         this.lib6 = true;
      } else {
         this.lib6 = false;
      }

      if (this.optionCaisses.getLib7ENTETE() != null && !this.optionCaisses.getLib7ENTETE().isEmpty()) {
         this.lib7 = true;
      } else {
         this.lib7 = false;
      }

      if (this.optionCaisses.getLib8ENTETE() != null && !this.optionCaisses.getLib8ENTETE().isEmpty()) {
         this.lib8 = true;
      } else {
         this.lib8 = false;
      }

      if (this.optionCaisses.getLib9ENTETE() != null && !this.optionCaisses.getLib9ENTETE().isEmpty()) {
         this.lib9 = true;
      } else {
         this.lib9 = false;
      }

      if (this.optionCaisses.getLib10ENTETE() != null && !this.optionCaisses.getLib10ENTETE().isEmpty()) {
         this.lib10 = true;
      } else {
         this.lib10 = false;
      }

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

   public void creerOptionsCaisses() throws IOException {
      if (!this.moduleParc) {
         this.optionCaisses.setAxeParc("false");
      }

      if (!this.modulePaye) {
         this.optionCaisses.setAxeAgent("false");
      }

      if (!this.moduleUsine) {
         this.optionCaisses.setAxeUsine("false");
      }

      if (!this.moduleProjet) {
         this.optionCaisses.setAxeProjet("false");
      }

      if (!this.moduleStructure) {
         this.optionCaisses.setAxeStructure("false");
      }

      this.racine.removeContent();
      Element var1 = new Element("affichInGlobViewCAISSE");
      this.racine.addContent(var1);
      var1.setText(this.optionCaisses.getAffichInGlobViewCAISSE());
      Element var2 = new Element("affichInGlobViewRECU");
      this.racine.addContent(var2);
      var2.setText(this.optionCaisses.getAffichInGlobViewRECU());
      Element var3 = new Element("affichInGlobViewSorti");
      this.racine.addContent(var3);
      var3.setText(this.optionCaisses.getAffichInGlobViewSorti());
      Element var4 = new Element("affichInGlobViewEntre");
      this.racine.addContent(var4);
      var4.setText(this.optionCaisses.getAffichInGlobViewEntre());
      Element var5 = new Element("affichInGlobViewVirment");
      this.racine.addContent(var5);
      var5.setText(this.optionCaisses.getAffichInGlobViewVirment());
      Element var6 = new Element("affichInGlobViewPayment");
      this.racine.addContent(var6);
      var6.setText(this.optionCaisses.getAffichInGlobViewPayment());
      Element var7 = new Element("nbLigneMax");
      this.racine.addContent(var7);
      var7.setText(this.optionCaisses.getNbLigneMax());
      Element var8 = new Element("saisieRecette");
      this.racine.addContent(var8);
      var8.setText(this.optionCaisses.getSaisieRecette());
      Element var9 = new Element("saisieDepense");
      this.racine.addContent(var9);
      var9.setText(this.optionCaisses.getSaisieDepense());
      Element var10 = new Element("saisieTransfert");
      this.racine.addContent(var10);
      var10.setText(this.optionCaisses.getSaisieTransfert());
      Element var11 = new Element("saisieRegularisation");
      this.racine.addContent(var11);
      var11.setText(this.optionCaisses.getSaisieRegularisation());
      Element var12 = new Element("saisieAnnulation");
      this.racine.addContent(var12);
      var12.setText(this.optionCaisses.getSaisieAnnulation());
      Element var13 = new Element("saisieSuppression");
      this.racine.addContent(var13);
      var13.setText(this.optionCaisses.getSaisieSuppression());
      Element var14 = new Element("modeleClotJour");
      this.racine.addContent(var14);
      var14.setText(this.optionCaisses.getModeleClotJour());
      Element var15 = new Element("mailClotJour");
      this.racine.addContent(var15);
      var15.setText(this.optionCaisses.getMailClotJour());
      Element var16 = new Element("modeleClotMois");
      this.racine.addContent(var16);
      var16.setText(this.optionCaisses.getModeleClotMois());
      Element var17 = new Element("mailClotMois");
      this.racine.addContent(var17);
      var17.setText(this.optionCaisses.getMailClotMois());
      Element var18 = new Element("execution");
      this.racine.addContent(var18);
      var18.setText(this.optionCaisses.getExecution());
      Element var19 = new Element("chronoReglement");
      this.racine.addContent(var19);
      var19.setText(this.optionCaisses.getChronoReglement());
      Element var20 = new Element("blocageCompte");
      this.racine.addContent(var20);
      var20.setText(this.optionCaisses.getBlocageCompte());
      Element var21 = new Element("accesJournaux");
      this.racine.addContent(var21);
      var21.setText(this.optionCaisses.getAccesJournaux());
      Element var22 = new Element("bonDecaissement");
      this.racine.addContent(var22);
      var22.setText(this.optionCaisses.getBonDecaissement());
      Element var23 = new Element("bonEncaissement");
      this.racine.addContent(var23);
      var23.setText(this.optionCaisses.getBonEncaissement());
      Element var24 = new Element("dateSuppression");
      this.racine.addContent(var24);
      var24.setText(this.optionCaisses.getDateSuppression());
      Element var25 = new Element("b1");
      this.racine.addContent(var25);
      var25.setText(this.optionCaisses.getB1());
      Element var26 = new Element("b2");
      this.racine.addContent(var26);
      var26.setText(this.optionCaisses.getB2());
      Element var27 = new Element("b3");
      this.racine.addContent(var27);
      var27.setText(this.optionCaisses.getB3());
      Element var28 = new Element("b4");
      this.racine.addContent(var28);
      var28.setText(this.optionCaisses.getB4());
      Element var29 = new Element("b5");
      this.racine.addContent(var29);
      var29.setText(this.optionCaisses.getB5());
      Element var30 = new Element("b6");
      this.racine.addContent(var30);
      var30.setText(this.optionCaisses.getB6());
      Element var31 = new Element("b7");
      this.racine.addContent(var31);
      var31.setText(this.optionCaisses.getB7());
      Element var32 = new Element("b8");
      this.racine.addContent(var32);
      var32.setText(this.optionCaisses.getB8());
      Element var33 = new Element("b9");
      this.racine.addContent(var33);
      var33.setText(this.optionCaisses.getB9());
      Element var34 = new Element("b10");
      this.racine.addContent(var34);
      var34.setText(this.optionCaisses.getB10());
      Element var35 = new Element("p1");
      this.racine.addContent(var35);
      var35.setText(this.optionCaisses.getP1());
      Element var36 = new Element("p2");
      this.racine.addContent(var36);
      var36.setText(this.optionCaisses.getP2());
      Element var37 = new Element("p3");
      this.racine.addContent(var37);
      var37.setText(this.optionCaisses.getP3());
      Element var38 = new Element("p4");
      this.racine.addContent(var38);
      var38.setText(this.optionCaisses.getP4());
      Element var39 = new Element("p5");
      this.racine.addContent(var39);
      var39.setText(this.optionCaisses.getP5());
      Element var40 = new Element("p6");
      this.racine.addContent(var40);
      var40.setText(this.optionCaisses.getP6());
      Element var41 = new Element("p7");
      this.racine.addContent(var41);
      var41.setText(this.optionCaisses.getP7());
      Element var42 = new Element("p8");
      this.racine.addContent(var42);
      var42.setText(this.optionCaisses.getP8());
      Element var43 = new Element("p9");
      this.racine.addContent(var43);
      var43.setText(this.optionCaisses.getP9());
      Element var44 = new Element("p10");
      this.racine.addContent(var44);
      var44.setText(this.optionCaisses.getP10());
      Element var45 = new Element("zoneRef1");
      this.racine.addContent(var45);
      var45.setText(this.optionCaisses.getZoneRef1());
      Element var46 = new Element("zoneRef2");
      this.racine.addContent(var46);
      var46.setText(this.optionCaisses.getZoneRef2());
      Element var47 = new Element("zoneLibelle");
      this.racine.addContent(var47);
      var47.setText(this.optionCaisses.getZoneLibelle());
      Element var48 = new Element("zoneRef1Serie");
      this.racine.addContent(var48);
      var48.setText(this.optionCaisses.getZoneRef1Serie());
      Element var49 = new Element("zoneRef2Serie");
      this.racine.addContent(var49);
      var49.setText(this.optionCaisses.getZoneRef2Serie());
      Element var50 = new Element("lib1ENTETE");
      this.racine.addContent(var50);
      var50.setText(this.optionCaisses.getLib1ENTETE());
      Element var51 = new Element("lib2ENTETE");
      this.racine.addContent(var51);
      var51.setText(this.optionCaisses.getLib2ENTETE());
      Element var52 = new Element("lib3ENTETE");
      this.racine.addContent(var52);
      var52.setText(this.optionCaisses.getLib3ENTETE());
      Element var53 = new Element("lib4ENTETE");
      this.racine.addContent(var53);
      var53.setText(this.optionCaisses.getLib4ENTETE());
      Element var54 = new Element("lib5ENTETE");
      this.racine.addContent(var54);
      var54.setText(this.optionCaisses.getLib5ENTETE());
      Element var55 = new Element("lib6ENTETE");
      this.racine.addContent(var55);
      var55.setText(this.optionCaisses.getLib6ENTETE());
      Element var56 = new Element("lib7ENTETE");
      this.racine.addContent(var56);
      var56.setText(this.optionCaisses.getLib7ENTETE());
      Element var57 = new Element("lib8ENTETE");
      this.racine.addContent(var57);
      var57.setText(this.optionCaisses.getLib8ENTETE());
      Element var58 = new Element("lib9ENTETE");
      this.racine.addContent(var58);
      var58.setText(this.optionCaisses.getLib9ENTETE());
      Element var59 = new Element("lib10ENTETE");
      this.racine.addContent(var59);
      var59.setText(this.optionCaisses.getLib10ENTETE());
      Element var60 = new Element("axeStructure");
      this.racine.addContent(var60);
      var60.setText(this.optionCaisses.getAxeStructure());
      Element var61 = new Element("axeSite");
      this.racine.addContent(var61);
      var61.setText(this.optionCaisses.getAxeSite());
      Element var62 = new Element("axeRegion");
      this.racine.addContent(var62);
      var62.setText(this.optionCaisses.getAxeRegion());
      Element var63 = new Element("axeUsine");
      this.racine.addContent(var63);
      var63.setText(this.optionCaisses.getAxeUsine());
      Element var64 = new Element("axeActivite");
      this.racine.addContent(var64);
      var64.setText(this.optionCaisses.getAxeActivite());
      Element var65 = new Element("axeAgent");
      this.racine.addContent(var65);
      var65.setText(this.optionCaisses.getAxeAgent());
      Element var66 = new Element("axeChantier");
      this.racine.addContent(var66);
      var66.setText(this.optionCaisses.getAxeChantier());
      Element var67 = new Element("axeParc");
      this.racine.addContent(var67);
      var67.setText(this.optionCaisses.getAxeParc());
      Element var68 = new Element("axeMission");
      this.racine.addContent(var68);
      var68.setText(this.optionCaisses.getAxeMission());
      Element var69 = new Element("axeCles");
      this.racine.addContent(var69);
      var69.setText(this.optionCaisses.getAxeCles());
      Element var70 = new Element("axeProjet");
      this.racine.addContent(var70);
      var70.setText(this.optionCaisses.getAxeProjet());
      Element var71 = new Element("axeDossier");
      this.racine.addContent(var71);
      var71.setText(this.optionCaisses.getAxeDossier());
      this.enregistre();
   }

   public void enregistre() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "caisses" + File.separator + "configuration" + File.separator + "optionsCaisses.xml");
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

   public boolean isGriserNbrCarNumCpte() {
      return this.griserNbrCarNumCpte;
   }

   public void setGriserNbrCarNumCpte(boolean var1) {
      this.griserNbrCarNumCpte = var1;
   }

   public OptionCaisses getOptionCaisses() {
      return this.optionCaisses;
   }

   public void setOptionCaisses(OptionCaisses var1) {
      this.optionCaisses = var1;
   }

   public boolean isGriseAnalytique() {
      return this.griseAnalytique;
   }

   public void setGriseAnalytique(boolean var1) {
      this.griseAnalytique = var1;
   }

   public String getObsAnalytique() {
      return this.obsAnalytique;
   }

   public void setObsAnalytique(String var1) {
      this.obsAnalytique = var1;
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

   public List getMesModelesRapport() {
      return this.mesModelesRapport;
   }

   public void setMesModelesRapport(List var1) {
      this.mesModelesRapport = var1;
   }

   public boolean isLib1() {
      return this.lib1;
   }

   public void setLib1(boolean var1) {
      this.lib1 = var1;
   }

   public boolean isLib10() {
      return this.lib10;
   }

   public void setLib10(boolean var1) {
      this.lib10 = var1;
   }

   public boolean isLib2() {
      return this.lib2;
   }

   public void setLib2(boolean var1) {
      this.lib2 = var1;
   }

   public boolean isLib3() {
      return this.lib3;
   }

   public void setLib3(boolean var1) {
      this.lib3 = var1;
   }

   public boolean isLib4() {
      return this.lib4;
   }

   public void setLib4(boolean var1) {
      this.lib4 = var1;
   }

   public boolean isLib5() {
      return this.lib5;
   }

   public void setLib5(boolean var1) {
      this.lib5 = var1;
   }

   public boolean isLib6() {
      return this.lib6;
   }

   public void setLib6(boolean var1) {
      this.lib6 = var1;
   }

   public boolean isLib7() {
      return this.lib7;
   }

   public void setLib7(boolean var1) {
      this.lib7 = var1;
   }

   public boolean isLib8() {
      return this.lib8;
   }

   public void setLib8(boolean var1) {
      this.lib8 = var1;
   }

   public boolean isLib9() {
      return this.lib9;
   }

   public void setLib9(boolean var1) {
      this.lib9 = var1;
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
}
