package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureMissions;
import com.epegase.systeme.xml.LectureTache;
import com.epegase.systeme.xml.ObjetCompte;
import java.io.File;
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

public class FormTache implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private Taches taches;
   private TachesDao tachesDao;
   private transient DataModel datamodelTache;
   private List listeTaches;
   private int strformatdevise;
   private boolean tacInactif;
   private boolean showButtonSupp;
   private boolean showButtonModif;
   private boolean inactifModif;
   private boolean existCod = false;
   private boolean afficheAjDefaut;
   private int ajoutModif = 0;
   private boolean showModalPanel = false;
   private Element racine;
   private Document document;
   private List mesMissionsItems;
   private Produits produits;
   private ProduitsVtesDao produitsVtesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentesDao exercicesVentesDao;

   public void InstancesDaoUtilses() {
      this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentesDao = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void defaultAdd() throws JDOMException, IOException, HibernateException, NamingException {
      new ArrayList();
      LectureTache var2 = new LectureTache();
      List var1 = var2.getMesTaches();
      if (var1.size() != 0) {
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Taches");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            int var5 = 0;

            while(true) {
               if (var5 >= var1.size()) {
                  var4.commit();
                  break;
               }

               this.taches = new Taches();
               this.taches.setTacMission(((ObjetCompte)var1.get(var5)).getType());
               this.taches.setTacCode(((ObjetCompte)var1.get(var5)).getCode());
               this.taches.setTacNomFr(((ObjetCompte)var1.get(var5)).getNom_FR());
               this.taches.setTacDateCreat(new Date());
               this.taches.setTacUserCreat(this.usersLog.getUsrid());
               this.taches = this.tachesDao.insert(this.taches, var3);
               ++var5;
            }
         } catch (HibernateException var9) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.listeTaches = this.tachesDao.selectTaches((Session)null);
         this.datamodelTache.setWrappedData(this.listeTaches);
         this.afficheAjDefaut = false;
      }

   }

   public void chargerlesTaches() throws HibernateException, NamingException, JDOMException, IOException {
      this.listeTaches = new ArrayList();
      this.datamodelTache = new ListDataModel();
      this.listeTaches = this.tachesDao.selectTaches((Session)null);
      this.datamodelTache.setWrappedData(this.listeTaches);
      if (this.listeTaches.size() != 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

      this.mesMissionsItems = new ArrayList();
      LectureNatureMissions var1 = new LectureNatureMissions();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.mesMissionsItems = var1.getMesNaturesMissionsItems();
      this.exercicesVentes = this.exercicesVentesDao.recupererLastExo((Session)null);
   }

   public void selectionTaches() {
      if (this.datamodelTache.isRowAvailable()) {
         this.taches = (Taches)this.datamodelTache.getRowData();
         this.inactifModif = this.recupererInactifModif();
         int var1 = this.taches.getTacInactif();
         if (var1 != 2) {
            this.showButtonModif = true;
            this.showButtonSupp = true;
         } else {
            this.showButtonModif = false;
            this.showButtonSupp = false;
         }

         this.ajoutModif = 1;
      }

   }

   public void ajouterTache() {
      this.taches = new Taches();
      this.showButtonModif = false;
      this.showButtonSupp = false;
      this.existCod = false;
      this.ajoutModif = 0;
      this.showModalPanel = true;
   }

   public void modifierTache() {
      if (this.taches != null) {
         this.existCod = true;
         this.showModalPanel = true;
      }

   }

   public void annule() {
      this.showModalPanel = false;
   }

   public boolean verifCode() throws HibernateException, NamingException {
      boolean var1 = false;
      var1 = this.tachesDao.existCode(this.taches.getTacCode(), (Session)null);
      if (!var1) {
         this.existCod = true;
      } else {
         this.existCod = false;
      }

      return this.existCod;
   }

   public void enregistrerTache() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Taches");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.ajoutModif == 0) {
            this.taches.setTacDateCreat(new Date());
            this.taches.setTacUserCreat(this.usersLog.getUsrid());
            this.taches = this.tachesDao.insert(this.taches, var1);
            this.listeTaches.add(this.taches);
            this.datamodelTache.setWrappedData(this.listeTaches);
         } else if (this.ajoutModif == 1) {
            this.taches.setTacDateModif(new Date());
            this.taches.setTacUserModif(this.usersLog.getUsrid());
            this.taches = this.tachesDao.modif(this.taches, var1);
         }

         if (this.taches.getTacMission() != null && !this.taches.getTacMission().isEmpty() && this.taches.getTacMission().contains(":")) {
            String[] var3 = this.taches.getTacMission().split(":");
            this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), var3[0], var1);
            if (this.famillesProduitsVentes != null) {
               this.famillesProduitsVentes.setFamvteLibelleFr(var3[1]);
               this.famillesProduitsVentes.setFamvteDateModif(new Date());
               this.famillesProduitsVentes.setFamvteUserModif(this.usersLog.getUsrid());
               this.famillesProduitsVentes = this.famillesProduitsVentesDao.modif(this.famillesProduitsVentes, var1);
            } else {
               this.famillesProduitsVentes = new FamillesProduitsVentes();
               this.famillesProduitsVentes.setExerciceventes(this.exercicesVentes);
               this.famillesProduitsVentes.setFamvteCode(var3[0]);
               this.famillesProduitsVentes.setFamvteLibelleFr(var3[1]);
               this.famillesProduitsVentes.setFamvteNature("1610");
               this.famillesProduitsVentes.setFamvteLibNature("Prestations");
               this.famillesProduitsVentes.setFamvteCat(3);
               this.famillesProduitsVentes.setFamvteStock(0);
               this.famillesProduitsVentes.setFamvteDateCreation(new Date());
               this.famillesProduitsVentes.setFamvteUserCreation(this.usersLog.getUsrid());
               this.famillesProduitsVentes = this.famillesProduitsVentesDao.insert(this.famillesProduitsVentes, var1);
            }

            this.produits = this.produitsVtesDao.chargeProduit(this.taches.getTacCode(), var1);
            if (this.produits != null) {
               this.produits.setProLibClient(this.taches.getTacNomFr());
               this.produits.setProVteCode(var3[0]);
               this.produits.setProVteLib(var3[1]);
               this.produits.setProDateModif(new Date());
               this.produits.setProUserModif(this.usersLog.getUsrid());
               this.produits.setProEtat("0");
               this.produits.setProVteNat("1610");
               this.produits.setProInactif(0);
               this.produits = this.produitsVtesDao.modifProduit(this.produits, var1);
            } else {
               this.produits = new Produits();
               this.produits.setProCode(this.taches.getTacCode());
               this.produits.setProLibClient(this.taches.getTacNomFr());
               this.produits.setProVteCode(var3[0]);
               this.produits.setProVteLib(var3[1]);
               this.produits.setProDateCreat(new Date());
               this.produits.setProUserCreat(this.usersLog.getUsrid());
               this.produits.setProEtat("0");
               this.produits.setProVteNat("1610");
               this.produits.setProInactif(0);
               this.produits = this.produitsVtesDao.insert(this.produits, var1);
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

      this.existCod = true;
      this.showModalPanel = false;
   }

   public int getTacheDesactiveModif() {
      byte var1;
      if (!this.inactifModif) {
         var1 = 0;
      } else {
         var1 = 1;
      }

      return var1;
   }

   public void supprimerTache() throws HibernateException, NamingException {
      this.taches.setTacInactif(2);
      this.taches = this.tachesDao.modif(this.taches);
      this.produits = this.produitsVtesDao.chargeProduit(this.taches.getTacCode(), (Session)null);
      if (this.produits != null) {
         this.produits.setProInactif(2);
         this.produits = this.produitsVtesDao.modifProduit(this.produits);
      }

      this.showButtonModif = false;
      this.showButtonSupp = false;
   }

   public boolean recupererInactifModif() {
      return this.taches.getTacInactif() != 0;
   }

   public void reactiverTache() throws HibernateException, NamingException {
      this.taches.setTacInactif(0);
      this.taches.setTacUserModif(this.usersLog.getUsrid());
      this.taches = this.tachesDao.modif(this.taches);
   }

   public void exportXML() {
      new SAXBuilder();

      try {
         File var2 = File.createTempFile("test", ".xml");
         String var3 = var2.getAbsolutePath();
         this.racine = new Element("tache");
         this.document = new Document(this.racine);
         new Taches();

         for(int var5 = 0; var5 < this.listeTaches.size(); ++var5) {
            Taches var4 = (Taches)this.listeTaches.get(var5);
            Element var6 = new Element("tac");
            Element var7 = new Element("mission");
            var6.addContent(var7);
            var7.setText(var4.getTacMission());
            Element var8 = new Element("code");
            var6.addContent(var8);
            var8.setText(var4.getTacCode());
            Element var9 = new Element("libelle");
            var6.addContent(var9);
            var9.addContent(var4.getTacNomFr());
            this.racine.addContent(var6);
         }

         this.enregistre(var2);
      } catch (Exception var10) {
      }

   }

   public void enregistre(File var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public Taches getTaches() {
      return this.taches;
   }

   public void setTaches(Taches var1) {
      this.taches = var1;
   }

   public DataModel getDatamodelTache() {
      return this.datamodelTache;
   }

   public void setDatamodelTache(DataModel var1) {
      this.datamodelTache = var1;
   }

   public int getStrformatdevise() {
      return this.strformatdevise;
   }

   public void setStrformatdevise(int var1) {
      this.strformatdevise = var1;
   }

   public boolean isTacInactif() {
      return this.tacInactif;
   }

   public void setTacInactif(boolean var1) {
      this.tacInactif = var1;
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public boolean isShowButtonModif() {
      return this.showButtonModif;
   }

   public void setShowButtonModif(boolean var1) {
      this.showButtonModif = var1;
   }

   public boolean isShowButtonSupp() {
      return this.showButtonSupp;
   }

   public void setShowButtonSupp(boolean var1) {
      this.showButtonSupp = var1;
   }

   public boolean isInactifModif() {
      return this.inactifModif;
   }

   public void setInactifModif(boolean var1) {
      this.inactifModif = var1;
   }

   public int getAjoutModif() {
      return this.ajoutModif;
   }

   public void setAjoutModif(int var1) {
      this.ajoutModif = var1;
   }

   public List getListeTaches() {
      return this.listeTaches;
   }

   public void setListeTaches(List var1) {
      this.listeTaches = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
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

   public List getMesMissionsItems() {
      return this.mesMissionsItems;
   }

   public void setMesMissionsItems(List var1) {
      this.mesMissionsItems = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }
}
