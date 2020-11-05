package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionStocks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormOptionsStocks implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionStocks optionStocks = new OptionStocks();
   private Element racine = new Element("optionStocks");
   private Document document;
   private ObjetCompte objetCompte;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;

   public FormOptionsStocks() throws SAXException {
      this.document = new Document(this.racine);
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

   public void creerOptionStocks() throws IOException, SAXException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("affichInGlobViewINV");
      this.racine.addContent(var1);
      var1.setText(this.optionStocks.getAffichInGlobViewINV());
      Element var2 = new Element("affichInGlobViewBIN");
      this.racine.addContent(var2);
      var2.setText(this.optionStocks.getAffichInGlobViewBIN());
      Element var3 = new Element("affichInGlobViewBOUT");
      this.racine.addContent(var3);
      var3.setText(this.optionStocks.getAffichInGlobViewBOUT());
      Element var4 = new Element("affichInGlobViewCES");
      this.racine.addContent(var4);
      var4.setText(this.optionStocks.getAffichInGlobViewCES());
      Element var5 = new Element("affichInGlobViewPRD");
      this.racine.addContent(var5);
      var5.setText(this.optionStocks.getAffichInGlobViewPRD());
      Element var6 = new Element("affichInGlobViewREX");
      this.racine.addContent(var6);
      var6.setText(this.optionStocks.getAffichInGlobViewREX());
      Element var7 = new Element("lib1");
      this.racine.addContent(var7);
      var7.setText(this.optionStocks.getLib1());
      Element var8 = new Element("lib2");
      this.racine.addContent(var8);
      var8.setText(this.optionStocks.getLib2());
      Element var9 = new Element("lib3");
      this.racine.addContent(var9);
      var9.setText(this.optionStocks.getLib3());
      Element var10 = new Element("lib4");
      this.racine.addContent(var10);
      var10.setText(this.optionStocks.getLib4());
      Element var11 = new Element("lib5");
      this.racine.addContent(var11);
      var11.setText(this.optionStocks.getLib5());
      Element var12 = new Element("lib6");
      this.racine.addContent(var12);
      var12.setText(this.optionStocks.getLib6());
      Element var13 = new Element("lib7");
      this.racine.addContent(var13);
      var13.setText(this.optionStocks.getLib7());
      Element var14 = new Element("lib8");
      this.racine.addContent(var14);
      var14.setText(this.optionStocks.getLib8());
      Element var15 = new Element("lib9");
      this.racine.addContent(var15);
      var15.setText(this.optionStocks.getLib9());
      Element var16 = new Element("lib10");
      this.racine.addContent(var16);
      var16.setText(this.optionStocks.getLib10());
      Element var17 = new Element("nbLigneMax");
      this.racine.addContent(var17);
      var17.setText(this.optionStocks.getNbLigneMax());
      Element var18 = new Element("stockNegatif");
      this.racine.addContent(var18);
      var18.setText(this.optionStocks.getStockNegatif());
      Element var19 = new Element("demandeurRapporteur");
      this.racine.addContent(var19);
      var19.setText(this.optionStocks.getDemandeurRapporteur());
      Element var20 = new Element("choixStock");
      this.racine.addContent(var20);
      var20.setText(this.optionStocks.getChoixStock());
      Element var21 = new Element("nbDecQteProd");
      this.racine.addContent(var21);
      var21.setText(this.optionStocks.getNbDecQteProd());
      this.enregistre();
      StructureDao var22 = new StructureDao(this.baseLog, this.utilInitHibernate);
      new Structure();
      Structure var23;
      if (this.structureLog.getStrid() == 0L) {
         var23 = var22.logStructure((Session)null);
      } else {
         var23 = var22.logStructureId(this.structureLog.getStrid(), (Session)null);
      }

      var23.setStrstockNegatif(Integer.parseInt(this.optionStocks.getStockNegatif()));
      var22.modStructure(var23);
   }

   public void updateOptionStocks() throws IOException, SAXException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("affichInGlobViewINV");
      this.racine.addContent(var1);
      var1.setText(this.optionStocks.getAffichInGlobViewINV());
      Element var2 = new Element("affichInGlobViewBIN");
      this.racine.addContent(var2);
      var2.setText(this.optionStocks.getAffichInGlobViewBIN());
      Element var3 = new Element("affichInGlobViewBOUT");
      this.racine.addContent(var3);
      var3.setText(this.optionStocks.getAffichInGlobViewBOUT());
      Element var4 = new Element("affichInGlobViewCES");
      this.racine.addContent(var4);
      var4.setText(this.optionStocks.getAffichInGlobViewCES());
      Element var5 = new Element("affichInGlobViewPRD");
      this.racine.addContent(var5);
      var5.setText(this.optionStocks.getAffichInGlobViewPRD());
      Element var6 = new Element("affichInGlobViewREX");
      this.racine.addContent(var6);
      var6.setText(this.optionStocks.getAffichInGlobViewREX());
      Element var7 = new Element("lib1");
      this.racine.addContent(var7);
      var7.setText(this.optionStocks.getLib1());
      Element var8 = new Element("lib2");
      this.racine.addContent(var8);
      var8.setText(this.optionStocks.getLib2());
      Element var9 = new Element("lib3");
      this.racine.addContent(var9);
      var9.setText(this.optionStocks.getLib3());
      Element var10 = new Element("lib4");
      this.racine.addContent(var10);
      var10.setText(this.optionStocks.getLib4());
      Element var11 = new Element("lib5");
      this.racine.addContent(var11);
      var11.setText(this.optionStocks.getLib5());
      Element var12 = new Element("lib6");
      this.racine.addContent(var12);
      var12.setText(this.optionStocks.getLib6());
      Element var13 = new Element("lib7");
      this.racine.addContent(var13);
      var13.setText(this.optionStocks.getLib7());
      Element var14 = new Element("lib8");
      this.racine.addContent(var14);
      var14.setText(this.optionStocks.getLib8());
      Element var15 = new Element("lib9");
      this.racine.addContent(var15);
      var15.setText(this.optionStocks.getLib9());
      Element var16 = new Element("lib10");
      this.racine.addContent(var16);
      var16.setText(this.optionStocks.getLib10());
      Element var17 = new Element("nbLigneMax");
      this.racine.addContent(var17);
      var17.setText(this.optionStocks.getNbLigneMax());
      Element var18 = new Element("stockNegatif");
      this.racine.addContent(var18);
      var18.setText(this.optionStocks.getStockNegatif());
      Element var19 = new Element("demandeurRapporteur");
      this.racine.addContent(var19);
      var19.setText(this.optionStocks.getDemandeurRapporteur());
      Element var20 = new Element("choixStock");
      this.racine.addContent(var20);
      var20.setText(this.optionStocks.getChoixStock());
      Element var21 = new Element("nbDecQteProd");
      this.racine.addContent(var21);
      var21.setText(this.optionStocks.getNbDecQteProd());
      this.enregistre();
   }

   public void enregistre() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator + "configuration" + File.separator + "optionStocks.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
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

   public OptionStocks getOptionStocks() {
      return this.optionStocks;
   }

   public void setOptionStocks(OptionStocks var1) {
      this.optionStocks = var1;
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
