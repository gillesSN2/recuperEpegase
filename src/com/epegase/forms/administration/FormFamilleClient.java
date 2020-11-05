package com.epegase.forms.administration;

import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormFamilleClient implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeFamilleTiers;
   private transient DataModel dataModelSourcesTiers = new ListDataModel();
   private transient DataModel dataModelClient = new ListDataModel();
   private ObjetFamilleTiers objetFamilleTiers;
   private boolean btnModClient = false;
   private String lib;
   private boolean exoT;
   private boolean exoD;
   private String ser;
   private String etat = "";
   private Chrono chrono;
   private ChronoDao chronoDao;
   private List lesChronosClt;
   private List lesChronosItemsClt = new ArrayList();
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;
   private boolean familleProduit = false;
   private transient DataModel dataModelBaremes = new ListDataModel();
   private List lesBaremes = new ArrayList();
   private Baremes baremes;
   private BaremesDao baremesDao;
   private List lesProduits = new ArrayList();
   private ProduitsAchsDao produitsAchsDao;
   private List lesProduitsTarifs = new ArrayList();
   private ProduitsTarifDao produitsTarifDao;
   private int majTarif = 0;
   private String libelleRabRis;
   private boolean ristourne;

   public FormFamilleClient() throws IOException {
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
   }

   public void listeFamilleClient() throws JDOMException, IOException, NamingException {
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.listeFamilleTiers = var1.getMesFamillesClients();
      this.dataModelClient.setWrappedData(this.listeFamilleTiers);
      this.lesBaremes.clear();
      this.dataModelBaremes.setWrappedData(this.lesBaremes);
      this.lesProduits.clear();
      this.lesProduitsTarifs.clear();
      new ExercicesVentes();
      ExercicesVentesDao var3 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      ExercicesVentes var2 = var3.recupererLastExo((Session)null);
      if (var2 != null) {
         this.familleProduit = true;
         new OptionVentes();
         LireLesoptionsVentes var5 = new LireLesoptionsVentes();
         var5.setStrId(this.structureLog.getStrid());
         var5.lancer();
         OptionVentes var4 = var5.getOptionsVentes();
         if (var4 != null && var4.getDecrmtRabais().equals("3")) {
            this.libelleRabRis = "Ristourne";
            this.ristourne = true;
         } else {
            this.libelleRabRis = "Rabais";
            this.ristourne = false;
         }
      } else {
         this.familleProduit = false;
         this.libelleRabRis = "";
         this.ristourne = false;
      }

   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetFamilleTiers = new ObjetFamilleTiers();
      this.lib = "";
      this.ser = "";
      this.exoT = false;
      this.exoD = false;
      this.recupererChronoItemClt();
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.dataModelClient.isRowAvailable()) {
         this.objetFamilleTiers = new ObjetFamilleTiers();
         this.objetFamilleTiers = (ObjetFamilleTiers)this.dataModelClient.getRowData();
         this.btnModClient = true;
         this.lesBaremes.clear();
         this.dataModelBaremes.setWrappedData(this.lesBaremes);
         this.lesProduits.clear();
         this.lesProduitsTarifs.clear();
         if (this.familleProduit) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Baremes");
            this.lesBaremes = this.baremesDao.listBaremesByCategorie(this.objetFamilleTiers.getLibelle(), var1);
            this.lesProduits = this.produitsAchsDao.selectAllProduitsVte(var1);
            this.lesProduitsTarifs = this.produitsTarifDao.selectAllProduitsTarif(var1);
            if (this.lesProduits.size() != 0) {
               boolean var2 = false;
               new Produits();

               for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
                  Produits var3 = (Produits)this.lesProduits.get(var4);
                  if (this.lesBaremes.size() == 0) {
                     var2 = false;
                  } else {
                     var2 = false;

                     for(int var5 = 0; var5 < this.lesBaremes.size(); ++var5) {
                        if (((Baremes)this.lesBaremes.get(var5)).getBarCodeProduit() != null && !((Baremes)this.lesBaremes.get(var5)).getBarCodeProduit().isEmpty() && ((Baremes)this.lesBaremes.get(var5)).getBarCodeProduit().equals(var3.getProCode())) {
                           var2 = true;
                           break;
                        }
                     }
                  }

                  if (!var2) {
                     this.baremes = new Baremes();
                     this.baremes.setBarCategorieTiers(this.objetFamilleTiers.getLibelle());
                     this.baremes.setBarOrdreTarif(this.objetFamilleTiers.getIndice());
                     this.baremes.setBarCodeProduit(var3.getProCode());
                     this.baremes.setBarLibelleProduit(var3.getProLibClient());
                     this.baremes.setBarCode("");
                     this.baremes.setBarCodeVte("");
                     this.baremes.setBarDateCreat(new Date());
                     this.baremes.setBarDateDebut((Date)null);
                     this.baremes.setBarDateFin((Date)null);
                     this.baremes.setBarDateModif((Date)null);
                     this.baremes.setBarIdMedecin(0L);
                     this.baremes.setBarIdTiers(0L);
                     this.baremes.setBarLibelleVte("");
                     this.baremes.setBarNomFr("");
                     this.baremes.setBarNomSp("");
                     this.baremes.setBarNomUk("");
                     this.baremes.setBarNomTiers("");
                     this.baremes.setBarOptions(0);
                     double var8 = 0.0D;
                     if (this.lesProduitsTarifs.size() != 0) {
                        for(int var7 = 0; var7 < this.lesProduitsTarifs.size(); ++var7) {
                           if (((ProduitsTarif)this.lesProduitsTarifs.get(var7)).getProduits().getProId() == var3.getProId()) {
                              var8 = ((ProduitsTarif)this.lesProduitsTarifs.get(var7)).getProtarPv();
                              break;
                           }
                        }
                     }

                     this.baremes.setBarPrix(var8);
                     this.baremes.setBarRabais(0.0D);
                     this.baremes.setBarRemise(0.0F);
                     this.baremes.setBarType(1);
                     this.baremes.setBarUserCreat(this.usersLog.getUsrid());
                     this.baremes.setBarUserModif(0L);
                     this.lesBaremes.add(this.baremes);
                  }
               }
            }

            this.utilInitHibernate.closeSession();
         }

         this.dataModelBaremes.setWrappedData(this.lesBaremes);
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      this.lib = this.objetFamilleTiers.getLibelle();
      if (this.objetFamilleTiers.getExoTva().contentEquals("true")) {
         this.exoT = true;
      } else {
         this.exoT = false;
      }

      if (this.objetFamilleTiers.getExoDouane().contentEquals("true")) {
         this.exoD = true;
      } else {
         this.exoD = false;
      }

      this.recupererChronoItemClt();
      this.afficheModePanel = true;
      this.afficheModePanelAjt = false;
   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void recupererChronoItemClt() throws HibernateException, NamingException {
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.lesChronosItemsClt = new ArrayList();
      this.lesChronosItemsClt = this.chronoDao.selectListClientItem((Session)null);
   }

   public void majAjout() throws JDOMException, IOException, NamingException {
      this.creation();
      this.listeFamilleClient();
      this.closeModif();
      this.btnModClient = false;
   }

   public void majModif() throws JDOMException, IOException, NamingException {
      this.objetFamilleTiers.setLibelle(this.lib);
      if (this.exoT) {
         this.objetFamilleTiers.setExoTva("true");
      } else {
         this.objetFamilleTiers.setExoTva("false");
      }

      if (this.exoD) {
         this.objetFamilleTiers.setExoDouane("true");
      } else {
         this.objetFamilleTiers.setExoDouane("false");
      }

      this.modification();
      this.listeFamilleClient();
      this.closeModif();
      if (this.lesBaremes.size() != 0 && this.majTarif == 1) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Baremes");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesBaremes.size(); ++var3) {
               this.baremes = (Baremes)this.lesBaremes.get(var3);
               if (this.baremes.getBarRemise() == 0.0F && this.baremes.getBarRabais() == 0.0D && this.baremes.getBarPrix() == 0.0D) {
                  if (this.baremes.getBarId() != 0L) {
                     this.baremesDao.delete(this.baremes, var1);
                  }
               } else if (this.baremes.getBarId() == 0L) {
                  this.baremes = this.baremesDao.insert(this.baremes, var1);
               } else {
                  this.baremes = this.baremesDao.modif(this.baremes, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.btnModClient = false;
   }

   public void supprimer() throws JDOMException, IOException, NamingException {
      this.supprimerTier();
      this.listeFamilleClient();
      this.closeModif();
      this.btnModClient = false;
   }

   public void creation() {
      File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "clients.xml");
      Element var3;
      Element var4;
      Element var5;
      Element var6;
      Element var7;
      Element var8;
      Element var9;
      if (var1.exists()) {
         SAXBuilder var2 = new SAXBuilder();

         try {
            this.document = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "clients.xml"));
            this.racine = this.document.getRootElement();
            var3 = new Element("clients");
            this.racine.addContent(var3);
            var4 = new Element("libelle");
            var5 = new Element("exoTva");
            var6 = new Element("exoDouane");
            var7 = new Element("serie");
            var8 = new Element("taxeSpecial");
            var9 = new Element("taux");
            Element var10 = new Element("compte");
            var4.setText(this.lib);
            if (this.exoT) {
               var5.setText("true");
            } else {
               var5.setText("false");
            }

            if (this.exoD) {
               var6.setText("true");
            } else {
               var6.setText("false");
            }

            var7.setText(this.ser);
            var3.addContent(var4);
            var3.addContent(var5);
            var3.addContent(var6);
            var3.addContent(var7);
            var3.addContent(var8);
            var3.addContent(var9);
            var3.addContent(var10);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "clients.xml");
         } catch (JDOMException var11) {
         } catch (IOException var12) {
         }
      } else {
         this.racine = new Element("famille");
         this.document = new Document(this.racine);
         Element var13 = new Element("clients");
         this.racine.addContent(var13);
         var3 = new Element("libelle");
         var4 = new Element("exoTva");
         var5 = new Element("exoDouane");
         var6 = new Element("serie");
         var7 = new Element("taxeSpecial");
         var8 = new Element("taux");
         var9 = new Element("compte");
         var3.setText(this.lib);
         if (this.exoT) {
            var4.setText("true");
         } else {
            var4.setText("false");
         }

         if (this.exoD) {
            var5.setText("true");
         } else {
            var5.setText("false");
         }

         var6.setText(this.ser);
         var13.addContent(var3);
         var13.addContent(var4);
         var13.addContent(var5);
         var13.addContent(var6);
         var13.addContent(var7);
         var13.addContent(var8);
         var13.addContent(var9);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "clients.xml");
      }

   }

   public void enregistre(String var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public void modification() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "clients.xml"));
      Element var3 = var2.getRootElement();
      this.listeFamilleTiers.remove(this.objetFamilleTiers.getIndice());
      this.listeFamilleTiers.add(this.objetFamilleTiers.getIndice(), this.objetFamilleTiers);
      this.creerArborescenceXml(var3, var2);
   }

   public void creerArborescenceXml(Element var1, Document var2) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var3 = 0; var3 < this.listeFamilleTiers.size(); ++var3) {
         this.objetFamilleTiers = new ObjetFamilleTiers();
         this.objetFamilleTiers = (ObjetFamilleTiers)this.listeFamilleTiers.get(var3);
         Element var4 = new Element("clients");
         Element var5 = new Element("libelle");
         Element var6 = new Element("exoTva");
         Element var7 = new Element("exoDouane");
         Element var8 = new Element("serie");
         Element var9 = new Element("taxeSpecial");
         Element var10 = new Element("taux");
         Element var11 = new Element("compte");
         var5.setText(this.objetFamilleTiers.getLibelle());
         if (this.objetFamilleTiers.getExoTva().equalsIgnoreCase("true")) {
            var6.setText("true");
         } else {
            var6.setText("false");
         }

         if (this.objetFamilleTiers.getExoDouane().equalsIgnoreCase("true")) {
            var7.setText("true");
         } else {
            var7.setText("false");
         }

         var4.addContent(var5);
         var4.addContent(var6);
         var4.addContent(var7);
         var4.addContent(var8);
         var4.addContent(var9);
         var4.addContent(var10);
         var4.addContent(var11);
         var1.addContent(var4);
      }

      this.enregistreFmtClient(var2);
   }

   public void enregistreFmtClient(Document var1) throws FileNotFoundException, IOException {
      XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var3 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "clients.xml");
      var2.output(var1, var3);
      var3.close();
   }

   public void supprimerTier() throws JDOMException, IOException {
      SAXBuilder var1 = new SAXBuilder();
      Document var2 = var1.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "familles_tiers" + File.separator + "clients.xml"));
      Element var3 = var2.getRootElement();
      this.listeFamilleTiers.remove(this.objetFamilleTiers.getIndice());
      this.creerArborescenceXml(var3, var2);
   }

   public DataModel getDataModelSourcesTiers() {
      return this.dataModelSourcesTiers;
   }

   public void setDataModelSourcesTiers(DataModel var1) {
      this.dataModelSourcesTiers = var1;
   }

   public boolean isBtnModClient() {
      return this.btnModClient;
   }

   public void setBtnModClient(boolean var1) {
      this.btnModClient = var1;
   }

   public DataModel getDataModelClient() {
      return this.dataModelClient;
   }

   public void setDataModelClient(DataModel var1) {
      this.dataModelClient = var1;
   }

   public List getListeFamilleTiers() {
      return this.listeFamilleTiers;
   }

   public void setListeFamilleTiers(List var1) {
      this.listeFamilleTiers = var1;
   }

   public ObjetFamilleTiers getObjetFamilleTiers() {
      return this.objetFamilleTiers;
   }

   public void setObjetFamilleTiers(ObjetFamilleTiers var1) {
      this.objetFamilleTiers = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isExoD() {
      return this.exoD;
   }

   public void setExoD(boolean var1) {
      this.exoD = var1;
   }

   public boolean isExoT() {
      return this.exoT;
   }

   public void setExoT(boolean var1) {
      this.exoT = var1;
   }

   public String getLib() {
      return this.lib;
   }

   public void setLib(String var1) {
      this.lib = var1;
   }

   public String getSer() {
      return this.ser;
   }

   public void setSer(String var1) {
      this.ser = var1;
   }

   public boolean isAfficheModePanel() {
      return this.afficheModePanel;
   }

   public void setAfficheModePanel(boolean var1) {
      this.afficheModePanel = var1;
   }

   public boolean isAfficheModePanelAjt() {
      return this.afficheModePanelAjt;
   }

   public void setAfficheModePanelAjt(boolean var1) {
      this.afficheModePanelAjt = var1;
   }

   public List getLesChronosClt() {
      return this.lesChronosClt;
   }

   public void setLesChronosClt(List var1) {
      this.lesChronosClt = var1;
   }

   public List getLesChronosItemsClt() {
      return this.lesChronosItemsClt;
   }

   public void setLesChronosItemsClt(List var1) {
      this.lesChronosItemsClt = var1;
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

   public DataModel getDataModelBaremes() {
      return this.dataModelBaremes;
   }

   public void setDataModelBaremes(DataModel var1) {
      this.dataModelBaremes = var1;
   }

   public boolean isFamilleProduit() {
      return this.familleProduit;
   }

   public void setFamilleProduit(boolean var1) {
      this.familleProduit = var1;
   }

   public String getLibelleRabRis() {
      return this.libelleRabRis;
   }

   public void setLibelleRabRis(String var1) {
      this.libelleRabRis = var1;
   }

   public boolean isRistourne() {
      return this.ristourne;
   }

   public void setRistourne(boolean var1) {
      this.ristourne = var1;
   }

   public int getMajTarif() {
      return this.majTarif;
   }

   public void setMajTarif(int var1) {
      this.majTarif = var1;
   }
}
