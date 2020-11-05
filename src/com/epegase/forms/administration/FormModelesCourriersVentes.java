package com.epegase.forms.administration;

import com.epegase.systeme.classe.ModelesCourriers;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetTable;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilTdt;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
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

public class FormModelesCourriersVentes implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ModelesCourriers modelesCourriers = new ModelesCourriers();
   private ModelesCourriersDao modelesCourriersDao;
   private List lesModelesCourriers = new ArrayList();
   private transient DataModel datamodelModeles = new ListDataModel();
   private boolean var_affiche_bouton = false;
   private boolean inactif = false;
   private boolean showModalPanel;
   private boolean doublon = false;
   private UtilTdt utilTdt = new UtilTdt();
   private transient DataModel dataModelDictionnaire = new ListDataModel();
   private transient DataModel dataModelDictUser = new ListDataModel();
   private transient DataModel dataModelDictStructure = new ListDataModel();
   private transient DataModel dataModelDictTiers = new ListDataModel();
   private ObjetTable dictionnaire = new ObjetTable();
   private String var_champ;
   private boolean showModalPanelDictionnaire = false;
   private String var_nom_table;
   private List lesModelesExemples = new ArrayList();
   private transient DataModel dataModelModeleExemples = new ListDataModel();
   private String var_repertoire;
   private ObjetTable modelesExemples;
   private String var_modele_exemple;
   private boolean showModalPanelModelesExemples = false;
   private String var_texte_modele;
   private String var_acces_fichier;

   public FormModelesCourriersVentes() throws ParseException {
      this.datamodelModeles = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.modelesCourriersDao = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesModeles(int var1, Session var2) throws HibernateException, NamingException {
      if (var1 == 0) {
         this.lesModelesCourriers = this.modelesCourriersDao.selectModelesVentes(var2);
      } else {
         this.lesModelesCourriers = this.modelesCourriersDao.selectContratsVentes(var2);
      }

      this.datamodelModeles.setWrappedData(this.lesModelesCourriers);
      this.dataModelDictUser.setWrappedData(this.utilTdt.rubriqueUser(this.utilInitHibernate, this.baseLog));
      this.dataModelDictStructure.setWrappedData(this.utilTdt.rubriqueStructure(this.utilInitHibernate, this.baseLog));
      this.dataModelDictTiers.setWrappedData(this.utilTdt.rubriqueTiers(this.utilInitHibernate, this.baseLog));
   }

   public void calculeMesTypes() {
      this.lesModelesExemples.clear();
      if (this.modelesCourriers.getModNature() == 20) {
         this.var_repertoire = "page_garde";
      } else if (this.modelesCourriers.getModNature() == 21) {
         this.var_repertoire = "annexe";
      } else if (this.modelesCourriers.getModNature() == 22) {
         this.var_repertoire = "correspondance";
      } else if (this.modelesCourriers.getModNature() == 161) {
         this.var_repertoire = "gerance";
      } else if (this.modelesCourriers.getModNature() == 171) {
         this.var_repertoire = "syndic";
      } else {
         this.var_repertoire = "";
      }

      if (this.var_repertoire != null && !this.var_repertoire.isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes";
         File var2 = new File(var1 + File.separator + this.var_repertoire.toLowerCase() + File.separator);
         String[] var3 = var2.list();
         if (var2.list().length != 0) {
            var3 = this.triAlphabetique(var3, var3.length);
            if (var3 != null) {
               for(int var4 = 0; var4 < var3.length; ++var4) {
                  if (var3[var4].endsWith("html") || var3[var4].endsWith("rtf")) {
                     ObjetTable var5 = new ObjetTable();
                     var5.setColumn_name(var3[var4]);
                     this.lesModelesExemples.add(var5);
                  }
               }
            }
         }
      }

      this.dataModelModeleExemples.setWrappedData(this.lesModelesExemples);
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

   public void selectionModele() {
      if (this.datamodelModeles.isRowAvailable()) {
         this.modelesCourriers = (ModelesCourriers)this.datamodelModeles.getRowData();
         if (this.modelesCourriers.getModInactif() == 1) {
            this.inactif = true;
            this.var_affiche_bouton = true;
         } else if (this.modelesCourriers.getModInactif() == 2) {
            this.inactif = true;
            this.var_affiche_bouton = false;
         } else {
            this.inactif = false;
            this.var_affiche_bouton = true;
         }
      }

   }

   public void ajouterModeles() {
      this.modelesCourriers = new ModelesCourriers();
      this.inactif = false;
      this.doublon = false;
      this.calculeMesTypes();
      this.showModalPanel = true;
   }

   public void modifierModeles() {
      this.doublon = true;
      this.calculeMesTypes();
      this.showModalPanel = true;
   }

   public void supprimerModeles() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesModelesCourriers.remove(this.modelesCourriers);
         this.datamodelModeles.setWrappedData(this.lesModelesCourriers);
         this.modelesCourriersDao.delete(this.modelesCourriers, var1);
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

   public void reactiverModeles() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.modelesCourriers.setModDateModif(new Date());
         this.modelesCourriers.setModUserModif(this.usersLog.getUsrid());
         this.modelesCourriers.setModInactif(0);
         this.modelesCourriers = this.modelesCourriersDao.modif(this.modelesCourriers, var1);
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

   public void annule() {
      this.showModalPanel = false;
   }

   public void doublonCode() throws HibernateException, NamingException {
      if (this.modelesCourriers.getModCode().equalsIgnoreCase("")) {
         this.doublon = false;
      } else {
         this.doublon = this.modelesCourriersDao.existCode(this.modelesCourriers.getModCode(), (Session)null);
      }

   }

   public void saveModeles() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ModelesCourriers");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.modelesCourriers.getModId() == 0L) {
            this.modelesCourriers.setModDateCreat(new Date());
            this.modelesCourriers.setModUserCreat(this.usersLog.getUsrid());
            if (this.inactif) {
               this.modelesCourriers.setModInactif(1);
            } else {
               this.modelesCourriers.setModInactif(0);
            }

            this.modelesCourriers = this.modelesCourriersDao.insert(this.modelesCourriers, var1);
            this.lesModelesCourriers.add(this.modelesCourriers);
            this.datamodelModeles.setWrappedData(this.lesModelesCourriers);
         } else {
            this.modelesCourriers.setModDateModif(new Date());
            this.modelesCourriers.setModUserModif(this.usersLog.getUsrid());
            this.modelesCourriers = this.modelesCourriersDao.modif(this.modelesCourriers, var1);
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

      this.var_affiche_bouton = false;
      this.showModalPanel = false;
   }

   public void ouvrirDictUser() {
      this.var_nom_table = "Utilisateurs";
      this.dataModelDictionnaire = this.dataModelDictUser;
      this.showModalPanelDictionnaire = true;
   }

   public void ouvrirDictStructure() {
      this.var_nom_table = "Structure";
      this.dataModelDictionnaire = this.dataModelDictStructure;
      this.showModalPanelDictionnaire = true;
   }

   public void ouvrirDictTiers() {
      this.var_nom_table = "Tiers";
      this.dataModelDictionnaire = this.dataModelDictTiers;
      this.showModalPanelDictionnaire = true;
   }

   public void selectionDictionnaire() {
      if (this.dataModelDictionnaire.isRowAvailable()) {
         this.dictionnaire = (ObjetTable)this.dataModelDictionnaire.getRowData();
      } else {
         this.dictionnaire = new ObjetTable();
      }

   }

   public void annuleDictionnaire() {
      this.showModalPanelDictionnaire = false;
   }

   public void calculeDictionnaire() {
      if (this.dictionnaire == null) {
         this.selectionDictionnaire();
      }

      if (this.dictionnaire != null) {
         this.var_champ = "[" + this.dictionnaire.getColumn_name() + "]";
         if (this.var_champ != null) {
            StringSelection var1 = new StringSelection(this.var_champ);
            Clipboard var2 = Toolkit.getDefaultToolkit().getSystemClipboard();
            var2.setContents(var1, (ClipboardOwner)null);
         }
      } else {
         this.var_champ = "";
      }

      this.showModalPanelDictionnaire = false;
   }

   public void ouvrirModelesExemples() {
      this.var_texte_modele = "";
      this.var_acces_fichier = "";
      this.modelesExemples = new ObjetTable();
      this.showModalPanelModelesExemples = true;
   }

   public void selectionModelesExemples() throws FileNotFoundException {
      if (this.dataModelModeleExemples.isRowAvailable()) {
         this.modelesExemples = (ObjetTable)this.dataModelModeleExemples.getRowData();
         this.var_acces_fichier = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + this.var_repertoire.toLowerCase() + File.separator + this.modelesExemples.getColumn_name();
         this.var_texte_modele = "";

         try {
            FileInputStream var1 = new FileInputStream(this.var_acces_fichier);
            InputStreamReader var2 = new InputStreamReader(var1);

            BufferedReader var3;
            String var4;
            for(var3 = new BufferedReader(var2); (var4 = var3.readLine()) != null; this.var_texte_modele = this.var_texte_modele + var4 + "\n") {
            }

            var3.close();
         } catch (Exception var5) {
         }
      }

   }

   public void annuleModelesExemples() {
      this.showModalPanelModelesExemples = false;
   }

   public void calculeModelesExemples() {
      if (this.modelesExemples != null) {
         this.modelesCourriers.setModTexte(this.var_texte_modele);
      }

      this.showModalPanelModelesExemples = false;
   }

   public boolean isDoublon() {
      return this.doublon;
   }

   public void setDoublon(boolean var1) {
      this.doublon = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public DataModel getDatamodelModeles() {
      return this.datamodelModeles;
   }

   public void setDatamodelModeles(DataModel var1) {
      this.datamodelModeles = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public List getLesModelesCourriers() {
      return this.lesModelesCourriers;
   }

   public void setLesModelesCourriers(List var1) {
      this.lesModelesCourriers = var1;
   }

   public ModelesCourriers getModelesCourriers() {
      return this.modelesCourriers;
   }

   public void setModelesCourriers(ModelesCourriers var1) {
      this.modelesCourriers = var1;
   }

   public UtilTdt getUtilTdt() {
      return this.utilTdt;
   }

   public void setUtilTdt(UtilTdt var1) {
      this.utilTdt = var1;
   }

   public DataModel getDataModelDictionnaire() {
      return this.dataModelDictionnaire;
   }

   public void setDataModelDictionnaire(DataModel var1) {
      this.dataModelDictionnaire = var1;
   }

   public ObjetTable getDictionnaire() {
      return this.dictionnaire;
   }

   public void setDictionnaire(ObjetTable var1) {
      this.dictionnaire = var1;
   }

   public boolean isShowModalPanelDictionnaire() {
      return this.showModalPanelDictionnaire;
   }

   public void setShowModalPanelDictionnaire(boolean var1) {
      this.showModalPanelDictionnaire = var1;
   }

   public String getVar_champ() {
      return this.var_champ;
   }

   public void setVar_champ(String var1) {
      this.var_champ = var1;
   }

   public String getVar_nom_table() {
      return this.var_nom_table;
   }

   public void setVar_nom_table(String var1) {
      this.var_nom_table = var1;
   }

   public List getLesModelesExemples() {
      return this.lesModelesExemples;
   }

   public void setLesModelesExemples(List var1) {
      this.lesModelesExemples = var1;
   }

   public String getVar_repertoire() {
      return this.var_repertoire;
   }

   public void setVar_repertoire(String var1) {
      this.var_repertoire = var1;
   }

   public String getVar_modele_exemple() {
      return this.var_modele_exemple;
   }

   public void setVar_modele_exemple(String var1) {
      this.var_modele_exemple = var1;
   }

   public DataModel getDataModelModeleExemples() {
      return this.dataModelModeleExemples;
   }

   public void setDataModelModeleExemples(DataModel var1) {
      this.dataModelModeleExemples = var1;
   }

   public boolean isShowModalPanelModelesExemples() {
      return this.showModalPanelModelesExemples;
   }

   public void setShowModalPanelModelesExemples(boolean var1) {
      this.showModalPanelModelesExemples = var1;
   }

   public String getVar_texte_modele() {
      return this.var_texte_modele;
   }

   public void setVar_texte_modele(String var1) {
      this.var_texte_modele = var1;
   }

   public ObjetTable getModelesExemples() {
      return this.modelesExemples;
   }

   public void setModelesExemples(ObjetTable var1) {
      this.modelesExemples = var1;
   }

   public String getVar_acces_fichier() {
      return this.var_acces_fichier;
   }

   public void setVar_acces_fichier(String var1) {
      this.var_acces_fichier = var1;
   }

   public DataModel getDataModelDictUser() {
      return this.dataModelDictUser;
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
}
