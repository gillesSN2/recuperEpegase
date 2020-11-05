package com.epegase.forms.administration;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.fileUtil.FileRep;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureConventions;
import com.epegase.systeme.xml.LectureGrilleSalaire;
import com.epegase.systeme.xml.ObjetConvention;
import com.epegase.systeme.xml.ObjetGrilleSalaire;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormConventionsCollectives implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private Element racine;
   private Document document;
   private LectureConventions lectureConventions;
   private ObjetConvention objetConvention;
   private List listeConvention = new ArrayList();
   private transient DataModel dataModelConvention = new ListDataModel();
   private LectureGrilleSalaire lectureGrilleSalaire;
   private ObjetGrilleSalaire objetGrilleSalaire;
   private List listeGrille = new ArrayList();
   private transient DataModel dataModelGrilles = new ListDataModel();
   private boolean grillePerso = false;
   private String colorGrille = "color:black";
   private String format;
   private UtilPrint utilPrint;
   private boolean var_affiche_convention = false;
   private boolean var_affiche_grille = false;
   private boolean showModalPanelConvention = false;
   private boolean showModalPanelGrille = false;

   public void chargerConventions() {
      this.lectureConventions = new LectureConventions();
      this.lectureConventions.setStrId(this.structureLog.getStrid());
      this.lectureConventions.setStructureLog(this.structureLog);
      this.lectureConventions.recuperePaye();
      this.listeConvention = this.lectureConventions.getMesConventions();
      this.dataModelConvention.setWrappedData(this.listeConvention);
      this.dataModelGrilles.setWrappedData(this.listeGrille);
   }

   public void chargerLesGrilles() throws SAXException, IOException {
      this.lectureGrilleSalaire = new LectureGrilleSalaire();
      this.lectureGrilleSalaire.setStructureLog(this.structureLog);
      this.lectureGrilleSalaire.setStrId(this.structureLog.getStrid());
      this.grillePerso = this.lectureGrilleSalaire.recuperePaye(this.objetConvention.getCode());
      if (this.grillePerso) {
         this.colorGrille = "color:red";
      } else {
         this.colorGrille = "color:black";
      }

      this.listeGrille = new ArrayList();
      this.listeGrille = this.lectureGrilleSalaire.getMesGrillesSalaires();
      this.dataModelGrilles.setWrappedData(this.listeGrille);
   }

   public void majConvention() throws FileNotFoundException, IOException {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml");
      Element var4;
      Element var5;
      Element var6;
      Element var7;
      Element var8;
      Element var9;
      Element var10;
      Element var11;
      Element var12;
      Element var13;
      Element var14;
      Element var15;
      Element var16;
      Element var17;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml"));
            this.racine = this.document.getRootElement();
            this.racine.removeContent();

            for(int var3 = 0; var3 < this.listeConvention.size(); ++var3) {
               var4 = new Element("convention");
               this.racine.addContent(var4);
               var5 = new Element("code");
               var6 = new Element("lib_FR");
               var7 = new Element("lib_UK");
               var8 = new Element("lib_SP");
               var9 = new Element("heure_mois");
               var10 = new Element("heure_semaine");
               var11 = new Element("date_maj");
               var12 = new Element("tranche1");
               var13 = new Element("tranche2");
               var14 = new Element("tranche3");
               var15 = new Element("tranche4");
               var16 = new Element("tranche5");
               var17 = new Element("inactif");
               Element var18 = new Element("at");
               var5.setText(((ObjetConvention)this.listeConvention.get(var3)).getCode());
               var6.setText(((ObjetConvention)this.listeConvention.get(var3)).getLib_FR());
               var7.setText(((ObjetConvention)this.listeConvention.get(var3)).getLib_UK());
               var8.setText(((ObjetConvention)this.listeConvention.get(var3)).getLib_SP());
               var9.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getHeure_mois());
               var10.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getHeure_semaine());
               var11.setText(((ObjetConvention)this.listeConvention.get(var3)).getDate_maj());
               var12.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getTranche1());
               var13.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getTranche2());
               var14.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getTranche3());
               var15.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getTranche4());
               var16.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getTranche5());
               if (((ObjetConvention)this.listeConvention.get(var3)).isValide()) {
                  var17.setText("1");
               } else {
                  var17.setText("0");
               }

               var18.setText("" + ((ObjetConvention)this.listeConvention.get(var3)).getAt());
               var4.addContent(var5);
               var4.addContent(var6);
               var4.addContent(var7);
               var4.addContent(var8);
               var4.addContent(var9);
               var4.addContent(var10);
               var4.addContent(var11);
               var4.addContent(var12);
               var4.addContent(var13);
               var4.addContent(var14);
               var4.addContent(var15);
               var4.addContent(var16);
               var4.addContent(var17);
               var4.addContent(var18);
            }

            this.enregistrer(StaticModePegase.getCheminContext(), this.document);
         } catch (JDOMException var19) {
         } catch (IOException var20) {
         }
      } else {
         this.racine = new Element("collective");
         this.document = new Document(this.racine);

         for(int var21 = 0; var21 < this.listeConvention.size(); ++var21) {
            Element var22 = new Element("convention");
            this.racine.addContent(var22);
            var4 = new Element("code");
            var5 = new Element("lib_FR");
            var6 = new Element("lib_UK");
            var7 = new Element("lib_SP");
            var8 = new Element("heure_mois");
            var9 = new Element("heure_semaine");
            var10 = new Element("date_maj");
            var11 = new Element("tranche1");
            var12 = new Element("tranche2");
            var13 = new Element("tranche3");
            var14 = new Element("tranche4");
            var15 = new Element("tranche5");
            var16 = new Element("inactif");
            var17 = new Element("at");
            var4.setText(((ObjetConvention)this.listeConvention.get(var21)).getCode());
            var5.setText(((ObjetConvention)this.listeConvention.get(var21)).getLib_FR());
            var6.setText(((ObjetConvention)this.listeConvention.get(var21)).getLib_UK());
            var7.setText(((ObjetConvention)this.listeConvention.get(var21)).getLib_SP());
            var8.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getHeure_mois());
            var9.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getHeure_semaine());
            var10.setText(((ObjetConvention)this.listeConvention.get(var21)).getDate_maj());
            var11.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getTranche1());
            var12.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getTranche2());
            var13.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getTranche3());
            var14.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getTranche4());
            var15.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getTranche5());
            if (((ObjetConvention)this.listeConvention.get(var21)).isValide()) {
               var16.setText("1");
            } else {
               var16.setText("0");
            }

            var17.setText("" + ((ObjetConvention)this.listeConvention.get(var21)).getAt());
            var22.addContent(var4);
            var22.addContent(var5);
            var22.addContent(var6);
            var22.addContent(var7);
            var22.addContent(var8);
            var22.addContent(var9);
            var22.addContent(var10);
            var22.addContent(var11);
            var22.addContent(var12);
            var22.addContent(var13);
            var22.addContent(var14);
            var22.addContent(var15);
            var22.addContent(var16);
            var22.addContent(var17);
         }

         this.enregistrer(StaticModePegase.getCheminContext(), this.document);
      }

   }

   public void enregistrer(String var1, Document var2) throws FileNotFoundException, IOException {
      XMLOutputter var3 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var4 = new FileOutputStream(var1 + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml");
      var3.output(this.getDocument(), var4);
      var4.close();
      if (this.structureLog.getStrmode() == 1 && this.structureLog.getStrRepDocument() != null && !this.structureLog.getStrRepDocument().isEmpty()) {
         String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator;
         String var6 = this.structureLog.getStrRepDocument() + this.baseLog + File.separator + "paye" + File.separator + "configuration" + File.separator;
         File var7 = new File(var5);
         File var8 = new File(var6);
         FileRep.copy(var7, var8);
      }

   }

   public void selectionConvention() throws SAXException, IOException {
      if (this.dataModelConvention.isRowAvailable()) {
         this.objetConvention = (ObjetConvention)this.dataModelConvention.getRowData();
         this.chargerLesGrilles();
         this.var_affiche_convention = true;
         this.var_affiche_grille = false;
      }

   }

   public void ajouterConvention() {
      this.objetConvention = new ObjetConvention();
      this.showModalPanelConvention = true;
   }

   public void modifierConvention() {
      if (this.objetConvention != null) {
         this.showModalPanelConvention = true;
      }

   }

   public void supprimerConvention() throws JDOMException, IOException {
      if (this.objetConvention != null) {
         this.listeConvention.remove(this.objetConvention);
         SAXBuilder var1 = new SAXBuilder();
         Document var2 = null;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml";
         File var4 = new File(var3);
         if (!var4.exists()) {
            this.racine = new Element("collective");
            var2 = new Document(this.racine);
         } else {
            var2 = var1.build(var4);
         }

         Element var5 = var2.getRootElement();
         this.creerArborescenceConventionXml(var5, var2);
         this.chargerConventions();
      }

   }

   public void fermerConvention() {
      this.showModalPanelConvention = false;
   }

   public void validerConvention() throws JDOMException, IOException {
      if (this.objetConvention != null) {
         new ObjetConvention();
         ObjetConvention var1 = this.objetConvention;
         int var2 = 0;

         for(int var3 = 0; var3 < this.listeConvention.size(); ++var3) {
            if (((ObjetConvention)this.listeConvention.get(var3)).equals(this.objetConvention)) {
               var2 = var3;
               break;
            }
         }

         this.listeConvention.remove(this.objetConvention);
         this.objetConvention = new ObjetConvention();
         this.objetConvention = var1;
         this.listeConvention.add(var2, this.objetConvention);
         SAXBuilder var8 = new SAXBuilder();
         Document var4 = null;
         String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml";
         File var6 = new File(var5);
         if (!var6.exists()) {
            this.racine = new Element("collective");
            var4 = new Document(this.racine);
         } else {
            var4 = var8.build(var6);
         }

         Element var7 = var4.getRootElement();
         this.creerArborescenceConventionXml(var7, var4);
         this.chargerConventions();
      }

      this.showModalPanelConvention = false;
   }

   public void creerArborescenceConventionXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeConvention.size(); ++var3) {
         this.objetConvention = (ObjetConvention)this.listeConvention.get(var3);
         Element var4 = new Element("convention");
         Element var5 = new Element("code");
         Element var6 = new Element("lib_FR");
         Element var7 = new Element("lib_UK");
         Element var8 = new Element("lib_SP");
         Element var9 = new Element("heure_mois");
         Element var10 = new Element("heure_semaine");
         Element var11 = new Element("date_maj");
         Element var12 = new Element("tranche1");
         Element var13 = new Element("tranche2");
         Element var14 = new Element("tranche3");
         Element var15 = new Element("tranche4");
         Element var16 = new Element("tranche5");
         Element var17 = new Element("inactif");
         var5.setText(this.objetConvention.getCode().toUpperCase());
         var6.setText(this.objetConvention.getLib_FR().toUpperCase());
         var7.setText(this.objetConvention.getLib_UK());
         var8.setText(this.objetConvention.getLib_SP());
         var9.setText("" + this.objetConvention.getHeure_mois());
         var10.setText("" + this.objetConvention.getHeure_semaine());
         var11.setText("" + this.objetConvention.getDate_maj());
         var12.setText("" + this.objetConvention.getTranche1());
         var13.setText("" + this.objetConvention.getTranche2());
         var14.setText("" + this.objetConvention.getTranche3());
         var15.setText("" + this.objetConvention.getTranche4());
         var16.setText("" + this.objetConvention.getTranche5());
         var17.setText("" + this.objetConvention.getInactif());
         var4.addContent(var5);
         var4.addContent(var6);
         var4.addContent(var7);
         var4.addContent(var8);
         var4.addContent(var9);
         var4.addContent(var10);
         var4.addContent(var11);
         var4.addContent(var12);
         var4.addContent(var13);
         var4.addContent(var14);
         var4.addContent(var15);
         var4.addContent(var16);
         var4.addContent(var17);
         var1.addContent(var4);
      }

      XMLOutputter var18 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var19 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "conv_" + this.structureLog.getStrcodepays() + ".xml");
      var18.output(var2, var19);
      var19.close();
   }

   public void majContrat() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new ArrayList();
         SalariesContratsDao var4 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         new SalariesContrats();
         List var3 = var4.chargerlesContrats(var1);
         if (var3.size() != 0) {
            for(int var6 = 0; var6 < var3.size(); ++var6) {
               SalariesContrats var5 = (SalariesContrats)var3.get(var6);

               for(int var7 = 0; var7 < this.listeGrille.size(); ++var7) {
                  this.objetGrilleSalaire = (ObjetGrilleSalaire)this.listeGrille.get(var7);
                  if (var5.getSalconGrille() != null && !var5.getSalconGrille().isEmpty() && var5.getSalconGrille().equals(this.objetGrilleSalaire.getCode())) {
                     var5.setSalconLibGrille(this.objetGrilleSalaire.getLib_FR());
                     if (!var5.getSalconType().equals("03D") && !var5.getSalconType().equals("03I") && !var5.getSalconType().equals("04")) {
                        if (var5.getSalconType().equals("01D") || var5.getSalconType().equals("01I") || var5.getSalconType().equals("02D") || var5.getSalconType().equals("02I") || var5.getSalconType().equals("11")) {
                           var5.setSalconBase((double)this.objetGrilleSalaire.getVal_mois());
                        }
                     } else {
                        var5.setSalconBase((double)this.objetGrilleSalaire.getVal_heure());
                     }

                     var4.modif(var5, var1);
                     break;
                  }
               }
            }
         }

         new ArrayList();
         SalariesDao var17 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         new Salaries();
         List var16 = var17.chargerlesSalariesActif(var1);
         if (var16.size() != 0) {
            for(int var9 = 0; var9 < var16.size(); ++var9) {
               Salaries var8 = (Salaries)var16.get(var9);

               for(int var10 = 0; var10 < this.listeGrille.size(); ++var10) {
                  this.objetGrilleSalaire = (ObjetGrilleSalaire)this.listeGrille.get(var10);
                  if (var8.getSalGrille() != null && !var8.getSalGrille().isEmpty() && var8.getSalGrille().equals(this.objetGrilleSalaire.getCode())) {
                     var8.setSalLibGrille(this.objetGrilleSalaire.getLib_FR());
                     var17.modif(var8, var1);
                     break;
                  }
               }
            }
         }

         var2.commit();
      } catch (HibernateException var14) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionGrille() throws SAXException, IOException {
      if (this.dataModelGrilles.isRowAvailable()) {
         this.objetGrilleSalaire = (ObjetGrilleSalaire)this.dataModelGrilles.getRowData();
         this.var_affiche_grille = true;
      }

   }

   public void ajouterGrille() {
      if (this.objetConvention != null) {
         this.objetGrilleSalaire = new ObjetGrilleSalaire();
         this.showModalPanelGrille = true;
      }

   }

   public void modifierGrille() {
      if (this.objetGrilleSalaire != null) {
         this.showModalPanelGrille = true;
      }

   }

   public void supprimerGrille() throws JDOMException, IOException, SAXException {
      if (this.objetGrilleSalaire != null) {
         this.listeGrille.remove(this.objetGrilleSalaire);
         SAXBuilder var1 = new SAXBuilder();
         Document var2 = null;
         String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "gril_" + this.structureLog.getStrcodepays() + "_" + this.objetConvention.getCode() + ".xml";
         File var4 = new File(var3);
         if (!var4.exists()) {
            this.racine = new Element("grille_convent");
            new Document(this.racine);
         } else {
            var1.build(var4);
         }

         var2 = var1.build(var4);
         Element var5 = var2.getRootElement();
         this.creerArborescenceGrilleXml(var5, var2);
         this.chargerLesGrilles();
      }

   }

   public void fermerGrille() {
      this.showModalPanelGrille = false;
   }

   public void validerGrille() throws FileNotFoundException, IOException, JDOMException, SAXException {
      if (this.objetGrilleSalaire != null) {
         ObjetGrilleSalaire var1 = new ObjetGrilleSalaire();
         int var2 = 0;
         if (this.listeGrille != null && this.listeGrille.size() != 0) {
            var1 = this.objetGrilleSalaire;

            for(int var3 = 0; var3 < this.listeGrille.size(); ++var3) {
               if (((ObjetGrilleSalaire)this.listeGrille.get(var3)).equals(this.objetGrilleSalaire)) {
                  var2 = var3;
                  break;
               }
            }

            this.listeGrille.remove(this.objetGrilleSalaire);
         } else {
            this.listeGrille = new ArrayList();
            var1.setCaisse(this.objetGrilleSalaire.getCaisse());
            var1.setCode(this.objetGrilleSalaire.getCode());
            var1.setEau(this.objetGrilleSalaire.getEau());
            var1.setElectricite(this.objetGrilleSalaire.getElectricite());
            var1.setFonction(this.objetGrilleSalaire.getFonction());
            var1.setLib_FR(this.objetGrilleSalaire.getLib_FR());
            var1.setLib_SP(this.objetGrilleSalaire.getLib_SP());
            var1.setLib_UK(this.objetGrilleSalaire.getLib_UK());
            var1.setLogement(this.objetGrilleSalaire.getLogement());
            var1.setNiveau(this.objetGrilleSalaire.getNiveau());
            var1.setRendement(this.objetGrilleSalaire.getRendement());
            var1.setResponsabilite(this.objetGrilleSalaire.getResponsabilite());
            var1.setTelephone(this.objetGrilleSalaire.getTelephone());
            var1.setTransport(this.objetGrilleSalaire.getTransport());
            var1.setVal_heure(this.objetGrilleSalaire.getVal_heure());
            var1.setVal_mois(this.objetGrilleSalaire.getVal_mois());
         }

         this.objetGrilleSalaire = new ObjetGrilleSalaire();
         this.objetGrilleSalaire = var1;
         this.listeGrille.add(var2, this.objetGrilleSalaire);
         SAXBuilder var10 = new SAXBuilder();
         Document var4 = null;
         String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "gril_" + this.structureLog.getStrcodepays() + "_" + this.objetConvention.getCode() + ".xml";
         File var6 = new File(var5);
         if (var6.exists()) {
            var4 = var10.build(var6);
         } else {
            UtilDownload var7 = new UtilDownload();
            String var8 = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "grillesConventions" + File.separator + "gril_" + this.structureLog.getStrcodepays() + "_" + this.objetConvention.getCode() + ".xml";
            File var9 = new File(var8);
            if (var9.exists()) {
               var7.copy(var9, var6, true);
               var4 = var10.build(var6);
            } else {
               this.racine = new Element("grille_convent");
               var4 = new Document(this.racine);
            }
         }

         Element var11 = var4.getRootElement();
         this.creerArborescenceGrilleXml(var11, var4);
         this.chargerLesGrilles();
      }

      this.showModalPanelGrille = false;
   }

   public void creerArborescenceGrilleXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeGrille.size(); ++var3) {
         this.objetGrilleSalaire = (ObjetGrilleSalaire)this.listeGrille.get(var3);
         Element var4 = new Element("grille");
         Element var5 = new Element("code");
         Element var6 = new Element("lib_FR");
         Element var7 = new Element("lib_UK");
         Element var8 = new Element("lib_SP");
         Element var9 = new Element("val_mois");
         Element var10 = new Element("val_heure");
         Element var11 = new Element("niveau");
         Element var12 = new Element("rendement");
         Element var13 = new Element("responsabilite");
         Element var14 = new Element("fonction");
         Element var15 = new Element("caisse");
         Element var16 = new Element("transport");
         Element var17 = new Element("telephone");
         Element var18 = new Element("logement");
         Element var19 = new Element("eau");
         Element var20 = new Element("electricite");
         var5.setText(this.objetGrilleSalaire.getCode().toUpperCase());
         var6.setText(this.objetGrilleSalaire.getLib_FR().toUpperCase());
         var7.setText(this.objetGrilleSalaire.getLib_UK());
         var8.setText(this.objetGrilleSalaire.getLib_SP());
         var9.setText("" + this.objetGrilleSalaire.getVal_mois());
         var10.setText("" + this.objetGrilleSalaire.getVal_heure());
         var11.setText("" + this.objetGrilleSalaire.getNiveau());
         var12.setText("" + this.objetGrilleSalaire.getRendement());
         var13.setText("" + this.objetGrilleSalaire.getResponsabilite());
         var14.setText("" + this.objetGrilleSalaire.getFonction());
         var15.setText("" + this.objetGrilleSalaire.getCaisse());
         var16.setText("" + this.objetGrilleSalaire.getTransport());
         var17.setText("" + this.objetGrilleSalaire.getTelephone());
         var18.setText("" + this.objetGrilleSalaire.getLogement());
         var19.setText("" + this.objetGrilleSalaire.getEau());
         var20.setText("" + this.objetGrilleSalaire.getElectricite());
         var4.addContent(var5);
         var4.addContent(var6);
         var4.addContent(var7);
         var4.addContent(var8);
         var4.addContent(var9);
         var4.addContent(var10);
         var4.addContent(var11);
         var4.addContent(var12);
         var4.addContent(var13);
         var4.addContent(var14);
         var4.addContent(var15);
         var4.addContent(var16);
         var4.addContent(var17);
         var4.addContent(var18);
         var4.addContent(var19);
         var4.addContent(var20);
         var1.addContent(var4);
      }

      XMLOutputter var21 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var22 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "paye" + File.separator + "configuration" + File.separator + "gril_" + this.structureLog.getStrcodepays() + "_" + this.objetConvention.getCode() + ".xml");
      var21.output(var2, var22);
      var22.close();
   }

   public void imprimerConvPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimerConv();
   }

   public void imprimerConvJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerConv();
   }

   public void imprimerConvPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerConv();
   }

   public void imprimerConvODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimerConv();
   }

   public void imprimerConvXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimerConv();
   }

   public void imprimerConvDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimerConv();
   }

   public void imprimerConvHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimerConv();
   }

   public void imprimerConvXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimerConv();
   }

   public void imprimerConv() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setSource("");
      this.utilPrint.setRecordPath("");
      this.utilPrint.setRapport("ConventionsCollectives");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
      this.utilPrint.setCheminSousrapport("");
      this.utilPrint.setEntete("Liste des conventions collectives");
      this.utilPrint.setFiltre("Pays : " + this.structureLog.getStrnompays());
      this.utilPrint.setRequete("");
      this.utilPrint.setFormat(this.getFormat());
      this.utilPrint.setDestinataire("");
      this.utilPrint.setEmetteur("");
      this.utilPrint.setTiersSelectionne((Tiers)null);
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.listeConvention);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.imprimeRapport();
   }

   public void imprimerGrilPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimerGril();
   }

   public void imprimerGrilJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimerGril();
   }

   public void imprimerGrilPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimerGril();
   }

   public void imprimerGrilODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimerGril();
   }

   public void imprimerGrilXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimerGril();
   }

   public void imprimerGrilDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimerGril();
   }

   public void imprimerGrilHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimerGril();
   }

   public void imprimerGrilXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimerGril();
   }

   public void imprimerGril() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setSource("");
      this.utilPrint.setRecordPath("");
      this.utilPrint.setRapport("GrillesSalariales");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
      this.utilPrint.setCheminSousrapport("");
      this.utilPrint.setEntete("Liste de la grille des salaires");
      this.utilPrint.setFiltre("Convention : " + this.objetConvention.getLib_FR());
      this.utilPrint.setRequete("");
      this.utilPrint.setFormat(this.getFormat());
      this.utilPrint.setDestinataire("");
      this.utilPrint.setEmetteur("");
      this.utilPrint.setTiersSelectionne((Tiers)null);
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.listeGrille);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.imprimeRapport();
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public DataModel getDataModelConvention() {
      return this.dataModelConvention;
   }

   public void setDataModelConvention(DataModel var1) {
      this.dataModelConvention = var1;
   }

   public DataModel getDataModelGrilles() {
      return this.dataModelGrilles;
   }

   public void setDataModelGrilles(DataModel var1) {
      this.dataModelGrilles = var1;
   }

   public LectureConventions getLectureConventions() {
      return this.lectureConventions;
   }

   public void setLectureConventions(LectureConventions var1) {
      this.lectureConventions = var1;
   }

   public LectureGrilleSalaire getLectureGrilleSalaire() {
      return this.lectureGrilleSalaire;
   }

   public void setLectureGrilleSalaire(LectureGrilleSalaire var1) {
      this.lectureGrilleSalaire = var1;
   }

   public List getListeConvention() {
      return this.listeConvention;
   }

   public void setListeConvention(List var1) {
      this.listeConvention = var1;
   }

   public List getListeGrille() {
      return this.listeGrille;
   }

   public void setListeGrille(List var1) {
      this.listeGrille = var1;
   }

   public ObjetConvention getObjetConvention() {
      return this.objetConvention;
   }

   public void setObjetConvention(ObjetConvention var1) {
      this.objetConvention = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
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

   public boolean isVar_affiche_convention() {
      return this.var_affiche_convention;
   }

   public void setVar_affiche_convention(boolean var1) {
      this.var_affiche_convention = var1;
   }

   public boolean isVar_affiche_grille() {
      return this.var_affiche_grille;
   }

   public void setVar_affiche_grille(boolean var1) {
      this.var_affiche_grille = var1;
   }

   public ObjetGrilleSalaire getObjetGrilleSalaire() {
      return this.objetGrilleSalaire;
   }

   public void setObjetGrilleSalaire(ObjetGrilleSalaire var1) {
      this.objetGrilleSalaire = var1;
   }

   public boolean isShowModalPanelConvention() {
      return this.showModalPanelConvention;
   }

   public void setShowModalPanelConvention(boolean var1) {
      this.showModalPanelConvention = var1;
   }

   public boolean isShowModalPanelGrille() {
      return this.showModalPanelGrille;
   }

   public void setShowModalPanelGrille(boolean var1) {
      this.showModalPanelGrille = var1;
   }

   public String getColorGrille() {
      return this.colorGrille;
   }

   public void setColorGrille(String var1) {
      this.colorGrille = var1;
   }

   public boolean isGrillePerso() {
      return this.grillePerso;
   }

   public void setGrillePerso(boolean var1) {
      this.grillePerso = var1;
   }
}
