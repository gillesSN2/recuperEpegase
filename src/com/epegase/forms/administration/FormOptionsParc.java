package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionParcs;
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

public class FormOptionsParc implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionParcs optionParcs = new OptionParcs();
   private Element racine = new Element("optionParcs");
   private Document document;
   private ObjetCompte objetCompte;
   private boolean griseAnalytique = false;
   private String obsAnalytique;
   private boolean griseProduit = false;
   private String obsProduit;
   private List mesTvaItem;
   private ExercicesParc exercicesParc;
   private boolean moduleTransit = false;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;

   public FormOptionsParc() throws SAXException {
      this.document = new Document(this.racine);
      this.mesTvaItem = new ArrayList();
   }

   public void calculeTvaItems(Session var1) throws HibernateException, NamingException {
      this.mesTvaItem.clear();
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exercicesParc.getExeprcId(), var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.mesTvaItem.add(new SelectItem(((TaxesVentes)var3.get(var4)).getTaxvteCode(), ((TaxesVentes)var3.get(var4)).getTaxvteCode() + ":" + ((TaxesVentes)var3.get(var4)).getTaxvteLibelleFr()));
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

      if (this.rechercheModule(80600)) {
         this.moduleTransit = true;
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

   public void creerOptionParc() throws IOException {
      this.racine.removeContent();
      Element var1 = new Element("type");
      this.racine.addContent(var1);
      var1.setText("" + this.optionParcs.getType());
      Element var2 = new Element("affichageTransPersonnel");
      this.racine.addContent(var2);
      var2.setText("" + this.optionParcs.getAffichageTransMateriel());
      Element var3 = new Element("affichageTransMateriel");
      this.racine.addContent(var3);
      var3.setText("" + this.optionParcs.getAffichageTransMateriel());
      Element var4 = new Element("affichageTPParc");
      this.racine.addContent(var4);
      var4.setText(this.optionParcs.getAffichageTPParc());
      Element var5 = new Element("affichageLocParc");
      this.racine.addContent(var5);
      var5.setText(this.optionParcs.getAffichageLocParc());
      Element var6 = new Element("affichageGPSParc");
      this.racine.addContent(var6);
      var6.setText(this.optionParcs.getAffichageGPSParc());
      Element var7 = new Element("affichageConParc");
      this.racine.addContent(var7);
      var7.setText(this.optionParcs.getAffichageConParc());
      Element var8 = new Element("affichageORParc");
      this.racine.addContent(var8);
      var8.setText(this.optionParcs.getAffichageORParc());
      Element var9 = new Element("libProduit");
      this.racine.addContent(var9);
      var9.setText(this.optionParcs.getLibProduit());
      Element var10 = new Element("libelleProduit");
      this.racine.addContent(var10);
      var10.setText(this.optionParcs.getLibelleProduit());
      Element var11 = new Element("tvaDefaut");
      this.racine.addContent(var11);
      var11.setText(this.optionParcs.getTvaDefaut());
      Element var12 = new Element("decrmtPriVteStock");
      this.racine.addContent(var12);
      var12.setText(this.optionParcs.getDecrmtPriVteStock());
      Element var13 = new Element("decrmtRabais");
      this.racine.addContent(var13);
      var13.setText(this.optionParcs.getDecrmtRabais());
      Element var14 = new Element("choixStock");
      this.racine.addContent(var14);
      var14.setText(this.optionParcs.getChoixStock());
      Element var15 = new Element("nbDecPu");
      this.racine.addContent(var15);
      var15.setText(this.optionParcs.getNbDecPu());
      Element var16 = new Element("affichInGlobViewMANIFESTE");
      this.racine.addContent(var16);
      var16.setText(this.optionParcs.getAffichInGlobViewMANIFESTE());
      Element var17 = new Element("ajoutMANIFESTE");
      this.racine.addContent(var17);
      var17.setText(this.optionParcs.getAjoutMANIFESTE());
      Element var18 = new Element("contenerMANIFEST");
      this.racine.addContent(var18);
      var18.setText(this.optionParcs.getContenerMANIFEST());
      Element var19 = new Element("chauffeurMANIFEST");
      this.racine.addContent(var19);
      var19.setText(this.optionParcs.getChauffeurMANIFEST());
      Element var20 = new Element("produitMANIFEST");
      this.racine.addContent(var20);
      var20.setText(this.optionParcs.getProduitMANIFEST());
      Element var21 = new Element("minimumMANIFEST");
      this.racine.addContent(var21);
      var21.setText(this.optionParcs.getMinimumMANIFEST());
      Element var22 = new Element("libelleMANIFEST");
      this.racine.addContent(var22);
      var22.setText(this.optionParcs.getLibelleMANIFEST());
      Element var23 = new Element("lib1ENTETE");
      this.racine.addContent(var23);
      var23.setText(this.optionParcs.getLib1ENTETE());
      Element var24 = new Element("lib2ENTETE");
      this.racine.addContent(var24);
      var24.setText(this.optionParcs.getLib2ENTETE());
      Element var25 = new Element("lib3ENTETE");
      this.racine.addContent(var25);
      var25.setText(this.optionParcs.getLib3ENTETE());
      Element var26 = new Element("lib4ENTETE");
      this.racine.addContent(var26);
      var26.setText(this.optionParcs.getLib4ENTETE());
      Element var27 = new Element("lib5ENTETE");
      this.racine.addContent(var27);
      var27.setText(this.optionParcs.getLib5ENTETE());
      Element var28 = new Element("lib6ENTETE");
      this.racine.addContent(var28);
      var28.setText(this.optionParcs.getLib6ENTETE());
      Element var29 = new Element("lib7ENTETE");
      this.racine.addContent(var29);
      var29.setText(this.optionParcs.getLib7ENTETE());
      Element var30 = new Element("lib8ENTETE");
      this.racine.addContent(var30);
      var30.setText(this.optionParcs.getLib8ENTETE());
      Element var31 = new Element("lib9ENTETE");
      this.racine.addContent(var31);
      var31.setText(this.optionParcs.getLib9ENTETE());
      Element var32 = new Element("lib10ENTETE");
      this.racine.addContent(var32);
      var32.setText(this.optionParcs.getLib10ENTETE());
      Element var33 = new Element("nbLigneMax");
      this.racine.addContent(var33);
      var33.setText(this.optionParcs.getNbLigneMax());
      Element var34 = new Element("chargementListe");
      this.racine.addContent(var34);
      var34.setText(this.optionParcs.getChargementListe());
      this.enregistrer();
   }

   public void enregistrer() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "parc" + File.separator + "configuration" + File.separator + "optionsParc.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
   }

   public void afficheALL() {
      List var1 = this.racine.getChildren();

      Element var3;
      for(Iterator var2 = var1.iterator(); var2.hasNext(); var3 = (Element)var2.next()) {
      }

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

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
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

   public boolean isModuleTransit() {
      return this.moduleTransit;
   }

   public void setModuleTransit(boolean var1) {
      this.moduleTransit = var1;
   }

   public ExercicesParc getExercicesParc() {
      return this.exercicesParc;
   }

   public void setExercicesParc(ExercicesParc var1) {
      this.exercicesParc = var1;
   }

   public List getMesTvaItem() {
      return this.mesTvaItem;
   }

   public void setMesTvaItem(List var1) {
      this.mesTvaItem = var1;
   }
}
