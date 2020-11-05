package com.epegase.forms.administration;

import com.epegase.systeme.classe.Cellule;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Quartier;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.Ville;
import com.epegase.systeme.dao.CelluleDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.QuartierDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.VilleDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormOrganisationCommerciale implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private boolean existeCode = true;
   private transient DataModel dataModelRegion = new ListDataModel();
   private List regionList = new ArrayList();
   private Region region = new Region();
   private RegionDao regionDao;
   private boolean showmodelPanelRegion = false;
   private boolean var_region_inactif;
   private transient DataModel dataModelSecteur = new ListDataModel();
   private List secteurList = new ArrayList();
   private Secteur secteur = new Secteur();
   private SecteurDao secteurDao;
   private boolean showmodelPanelSecteur = false;
   private boolean var_secteur_inactif;
   private transient DataModel dataModelPdv = new ListDataModel();
   private List pdvList = new ArrayList();
   private PointDeVente pdv = new PointDeVente();
   private PointDeVenteDao pdvDao;
   private boolean showmodelPanelPdv = false;
   private boolean var_pdv_inactif;
   private transient DataModel dataModelVille = new ListDataModel();
   private List villeList = new ArrayList();
   private Ville ville = new Ville();
   private VilleDao villeDao;
   private boolean showmodelPanelVille = false;
   private boolean var_ville_inactif;
   private transient DataModel dataModelQuartier = new ListDataModel();
   private List quartierList = new ArrayList();
   private Quartier quartier = new Quartier();
   private QuartierDao quartierDao;
   private boolean showmodelPanelQuartier = false;
   private boolean var_quartier_inactif;
   private transient DataModel dataModelCellule = new ListDataModel();
   private List celluleList = new ArrayList();
   private Cellule cellule = new Cellule();
   private CelluleDao celluleDao;
   private boolean showmodelPanelCellule = false;
   private boolean var_cellule_inactif;
   private List mesResponsable = new ArrayList();
   private UserDao userDao;

   public void InstancesDaoUtilses() {
      this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      this.pdvDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
      this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
      this.villeDao = new VilleDao(this.baseLog, this.utilInitHibernate);
      this.quartierDao = new QuartierDao(this.baseLog, this.utilInitHibernate);
      this.celluleDao = new CelluleDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesRegions() throws HibernateException, NamingException {
      this.regionList.clear();
      this.regionList = this.regionDao.selectRegion((Session)null);
      this.dataModelRegion.setWrappedData(this.regionList);
      this.secteurList.clear();
      this.dataModelSecteur.setWrappedData(this.secteurList);
      this.pdvList.clear();
      this.dataModelPdv.setWrappedData(this.pdvList);
      this.mesResponsable.clear();
      this.mesResponsable.add(new SelectItem(0, ""));
      new ArrayList();
      List var1 = this.userDao.chargerLesSignataires("Ventes", (Session)null);
      if (var1.size() != 0) {
         this.mesResponsable.add(new SelectItem(0, ""));

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            new Users();
            Users var3 = (Users)var1.get(var2);
            this.mesResponsable.add(new SelectItem(var3.getUsrid(), var3.getUsrNom() + ":" + var3.getUsrPrenom()));
         }
      }

   }

   public void ajouterRegion() {
      this.region = new Region();
      this.secteur = new Secteur();
      this.pdv = new PointDeVente();
      this.ville = new Ville();
      this.quartier = new Quartier();
      this.cellule = new Cellule();
      this.var_region_inactif = false;
      this.existeCode = true;
      this.showmodelPanelRegion = true;
   }

   public void modifierRegion() {
      if (this.region != null) {
         if (this.region.getRegInactif() == 1) {
            this.var_region_inactif = true;
         } else {
            this.var_region_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelRegion = true;
      }

   }

   public void selectionRegion() throws HibernateException, NamingException {
      if (this.dataModelRegion.isRowAvailable()) {
         this.region = (Region)this.dataModelRegion.getRowData();
         this.secteurList = this.secteurDao.listSecteurByRegion((Region)this.region, (Session)null);
         this.dataModelSecteur.setWrappedData(this.secteurList);
         this.secteur = new Secteur();
         this.pdvList.clear();
         this.dataModelPdv.setWrappedData(this.pdvList);
         this.pdv = new PointDeVente();
         this.villeList.clear();
         this.dataModelVille.setWrappedData(this.villeList);
         this.ville = new Ville();
         this.quartierList.clear();
         this.dataModelQuartier.setWrappedData(this.quartierList);
         this.quartier = new Quartier();
         this.celluleList.clear();
         this.dataModelCellule.setWrappedData(this.celluleList);
         this.cellule = new Cellule();
      }

   }

   public void supprimerRegion() throws HibernateException, NamingException {
      if (this.region != null) {
         this.regionList.remove(this.region);
         this.dataModelRegion.setWrappedData(this.regionList);
         this.regionDao.delete(this.region);
         this.region = new Region();
      }

   }

   public void annulerRegion() {
      this.showmodelPanelRegion = false;
   }

   public void validerRegion() throws HibernateException, NamingException {
      if (this.var_region_inactif) {
         this.region.setRegInactif(1);
      } else {
         this.region.setRegInactif(0);
      }

      if (this.region.getRegIdResponsable() != 0L) {
         new Users();
         Users var1 = this.userDao.selectByIdUsers(this.region.getRegIdResponsable(), (Session)null);
         if (var1 != null) {
            this.region.setRegNomResponsable(var1.getUsrPatronyme());
         } else {
            this.region.setRegNomResponsable("");
         }
      } else {
         this.region.setRegNomResponsable("");
      }

      if (this.region.getRegId() == 0L) {
         this.region.setRegUserCreat(this.usersLog.getUsrid());
         this.region.setRegDateCreat(new Date());
         this.region = this.regionDao.insert(this.region);
         this.regionList.add(this.region);
         this.dataModelRegion.setWrappedData(this.regionList);
         this.secteurList.clear();
         this.secteur = new Secteur();
         this.dataModelSecteur.setWrappedData(this.secteurList);
         this.pdvList.clear();
         this.dataModelPdv.setWrappedData(this.pdvList);
         this.villeList.clear();
         this.dataModelVille.setWrappedData(this.villeList);
         this.quartierList.clear();
         this.dataModelQuartier.setWrappedData(this.quartierList);
         this.celluleList.clear();
         this.dataModelCellule.setWrappedData(this.celluleList);
         this.pdv = new PointDeVente();
      } else {
         this.region.setRegUserModif(this.usersLog.getUsrid());
         this.region.setRegDateModif(new Date());
         this.region = this.regionDao.modif(this.region);
      }

      this.showmodelPanelRegion = false;
   }

   public void verifierCodeRegion() throws HibernateException, NamingException {
      this.existeCode = this.regionDao.existCode(this.region.getRegCode(), (Session)null);
   }

   public void ajouterSecteur() {
      if (this.region != null) {
         this.secteur = new Secteur();
         this.pdv = new PointDeVente();
         this.ville = new Ville();
         this.quartier = new Quartier();
         this.cellule = new Cellule();
         this.var_secteur_inactif = false;
         this.existeCode = true;
         this.showmodelPanelSecteur = true;
      }

   }

   public void modifierSecteur() {
      if (this.secteur != null) {
         if (this.secteur.getSecInactif() == 1) {
            this.var_secteur_inactif = true;
         } else {
            this.var_secteur_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelSecteur = true;
      }

   }

   public void selectionSecteur() throws HibernateException, NamingException {
      if (this.dataModelSecteur.isRowAvailable()) {
         this.secteur = (Secteur)this.dataModelSecteur.getRowData();
         this.pdvList = this.pdvDao.listPdvBySecteur((Secteur)this.secteur, (Session)null);
         this.dataModelPdv.setWrappedData(this.pdvList);
         this.pdv = new PointDeVente();
         this.villeList.clear();
         this.dataModelVille.setWrappedData(this.villeList);
         this.ville = new Ville();
         this.quartierList.clear();
         this.dataModelQuartier.setWrappedData(this.quartierList);
         this.quartier = new Quartier();
         this.celluleList.clear();
         this.dataModelCellule.setWrappedData(this.celluleList);
         this.cellule = new Cellule();
      }

   }

   public void supprimerSecteur() throws HibernateException, NamingException {
      if (this.secteur != null) {
         this.secteurList.remove(this.secteur);
         this.dataModelSecteur.setWrappedData(this.secteurList);
         this.secteurDao.delete(this.secteur);
         this.secteur = new Secteur();
      }

   }

   public void annulerSecteur() {
      this.showmodelPanelSecteur = false;
   }

   public void validerSecteur() throws HibernateException, NamingException {
      if (this.region != null) {
         if (this.var_secteur_inactif) {
            this.secteur.setSecInactif(1);
         } else {
            this.secteur.setSecInactif(0);
         }

         if (this.secteur.getSecIdResponsable() != 0L) {
            new Users();
            Users var1 = this.userDao.selectByIdUsers(this.secteur.getSecIdResponsable(), (Session)null);
            if (var1 != null) {
               this.secteur.setSecNomResponsable(var1.getUsrPatronyme());
            } else {
               this.secteur.setSecNomResponsable("");
            }
         } else {
            this.secteur.setSecNomResponsable("");
         }

         if (this.secteur.getSecId() == 0L) {
            this.secteur.setSecUserCreat(this.usersLog.getUsrid());
            this.secteur.setSecDateCreat(new Date());
            this.secteur.setRegion(this.region);
            this.secteur = this.secteurDao.insert(this.secteur);
            this.secteurList.add(this.secteur);
            this.dataModelSecteur.setWrappedData(this.secteurList);
            this.pdvList.clear();
            this.dataModelPdv.setWrappedData(this.pdvList);
            this.villeList.clear();
            this.dataModelVille.setWrappedData(this.villeList);
            this.quartierList.clear();
            this.dataModelQuartier.setWrappedData(this.quartierList);
            this.celluleList.clear();
            this.dataModelCellule.setWrappedData(this.celluleList);
            this.pdv = new PointDeVente();
         } else {
            this.secteur.setSecUserModif(this.usersLog.getUsrid());
            this.secteur.setSecDateModif(new Date());
            this.secteur = this.secteurDao.modif(this.secteur);
         }
      }

      this.showmodelPanelSecteur = false;
   }

   public void verifierCodeSecteur() throws HibernateException, NamingException {
      this.existeCode = this.secteurDao.existCode(this.secteur.getSecCode(), (Session)null);
   }

   public void ajouterPdv() {
      if (this.region != null && this.secteur != null) {
         this.pdv = new PointDeVente();
         this.ville = new Ville();
         this.quartier = new Quartier();
         this.cellule = new Cellule();
         this.var_pdv_inactif = false;
         this.existeCode = true;
         this.showmodelPanelPdv = true;
      }

   }

   public void modifierPdv() {
      if (this.pdv != null) {
         if (this.pdv.getPdvInactif() == 1) {
            this.var_pdv_inactif = true;
         } else {
            this.var_pdv_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelPdv = true;
      }

   }

   public void selectionPdv() throws HibernateException, NamingException {
      if (this.dataModelPdv.isRowAvailable()) {
         this.pdv = (PointDeVente)this.dataModelPdv.getRowData();
         this.villeList = this.villeDao.listVilleByPdv(this.pdv, (Session)null);
         this.dataModelVille.setWrappedData(this.villeList);
         this.ville = new Ville();
         this.quartierList.clear();
         this.dataModelQuartier.setWrappedData(this.quartierList);
         this.quartier = new Quartier();
         this.celluleList.clear();
         this.dataModelCellule.setWrappedData(this.celluleList);
         this.cellule = new Cellule();
      }

   }

   public void supprimerPdv() throws HibernateException, NamingException {
      if (this.pdv != null) {
         this.pdvList.remove(this.pdv);
         this.dataModelPdv.setWrappedData(this.pdvList);
         this.pdvDao.delete(this.pdv);
         this.pdv = new PointDeVente();
      }

   }

   public void annulerPdv() {
      this.showmodelPanelPdv = false;
   }

   public void validerPdv() throws HibernateException, NamingException {
      if (this.region != null && this.secteur != null) {
         if (this.var_pdv_inactif) {
            this.pdv.setPdvInactif(1);
         } else {
            this.pdv.setPdvInactif(0);
         }

         if (this.pdv.getPdvIdResponsable() != 0L) {
            new Users();
            Users var1 = this.userDao.selectByIdUsers(this.pdv.getPdvIdResponsable(), (Session)null);
            if (var1 != null) {
               this.pdv.setPdvNomResponsable(var1.getUsrPatronyme());
            } else {
               this.pdv.setPdvNomResponsable("");
            }
         } else {
            this.pdv.setPdvNomResponsable("");
         }

         if (this.pdv.getPdvId() == 0L) {
            this.pdv.setPdvUserCreat(this.usersLog.getUsrid());
            this.pdv.setPdvDateCreat(new Date());
            this.pdv.setRegion(this.region);
            this.pdv.setSecteur(this.secteur);
            this.pdv = this.pdvDao.insert(this.pdv);
            this.pdvList.add(this.pdv);
            this.dataModelPdv.setWrappedData(this.pdvList);
            this.villeList.clear();
            this.dataModelVille.setWrappedData(this.villeList);
            this.quartierList.clear();
            this.dataModelQuartier.setWrappedData(this.quartierList);
            this.celluleList.clear();
            this.dataModelCellule.setWrappedData(this.celluleList);
         } else {
            this.pdv.setPdvUserModif(this.usersLog.getUsrid());
            this.pdv.setPdvDateModif(new Date());
            this.pdv = this.pdvDao.modif(this.pdv);
         }
      }

      this.showmodelPanelPdv = false;
   }

   public void verifierCodePdv() throws HibernateException, NamingException {
      this.existeCode = this.pdvDao.existCode(this.pdv.getPdvCode(), (Session)null);
   }

   public void ajouterVille() {
      if (this.pdv != null && this.secteur != null && this.region != null) {
         this.ville = new Ville();
         this.quartier = new Quartier();
         this.cellule = new Cellule();
         this.var_ville_inactif = false;
         this.existeCode = true;
         this.showmodelPanelVille = true;
      }

   }

   public void modifierVille() {
      if (this.ville != null) {
         if (this.ville.getVilInactif() == 1) {
            this.var_ville_inactif = true;
         } else {
            this.var_ville_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelVille = true;
      }

   }

   public void selectionVille() throws HibernateException, NamingException {
      if (this.dataModelVille.isRowAvailable()) {
         this.ville = (Ville)this.dataModelVille.getRowData();
         this.quartierList = this.quartierDao.listQuartierByVille(this.ville, (Session)null);
         this.dataModelQuartier.setWrappedData(this.quartierList);
         this.quartier = new Quartier();
         this.celluleList.clear();
         this.dataModelCellule.setWrappedData(this.celluleList);
         this.cellule = new Cellule();
      }

   }

   public void supprimerVille() throws HibernateException, NamingException {
      if (this.ville != null) {
         this.villeList.remove(this.ville);
         this.dataModelVille.setWrappedData(this.villeList);
         this.villeDao.delete(this.ville);
         this.ville = new Ville();
      }

   }

   public void annulerVille() {
      this.showmodelPanelVille = false;
   }

   public void validerVille() throws HibernateException, NamingException {
      if (this.pdv != null && this.region != null && this.secteur != null) {
         if (this.var_ville_inactif) {
            this.ville.setVilInactif(1);
         } else {
            this.ville.setVilInactif(0);
         }

         if (this.ville.getVilIdResponsable() != 0L) {
            new Users();
            Users var1 = this.userDao.selectByIdUsers(this.ville.getVilIdResponsable(), (Session)null);
            if (var1 != null) {
               this.ville.setVilNomResponsable(var1.getUsrPatronyme());
            } else {
               this.ville.setVilNomResponsable("");
            }
         } else {
            this.ville.setVilNomResponsable("");
         }

         if (this.ville.getVilId() == 0L) {
            this.ville.setVilUserCreat(this.usersLog.getUsrid());
            this.ville.setVilDateCreat(new Date());
            this.ville.setRegion(this.region);
            this.ville.setSecteur(this.secteur);
            this.ville.setPointDeVente(this.pdv);
            this.ville = this.villeDao.insert(this.ville);
            this.villeList.add(this.ville);
            this.dataModelVille.setWrappedData(this.villeList);
            this.quartierList.clear();
            this.dataModelQuartier.setWrappedData(this.quartierList);
            this.celluleList.clear();
            this.dataModelCellule.setWrappedData(this.celluleList);
         } else {
            this.ville.setVilUserModif(this.usersLog.getUsrid());
            this.ville.setVilDateModif(new Date());
            this.ville = this.villeDao.modif(this.ville);
         }
      }

      this.showmodelPanelVille = false;
   }

   public void verifierCodeVille() throws HibernateException, NamingException {
      this.existeCode = this.villeDao.existCode(this.ville.getVilCode(), (Session)null);
   }

   public void ajouterQuartier() {
      if (this.ville != null && this.pdv != null && this.secteur != null && this.region != null) {
         this.quartier = new Quartier();
         this.cellule = new Cellule();
         this.var_quartier_inactif = false;
         this.existeCode = true;
         this.showmodelPanelQuartier = true;
      }

   }

   public void modifierQuartier() {
      if (this.quartier != null) {
         if (this.quartier.getQuaInactif() == 1) {
            this.var_quartier_inactif = true;
         } else {
            this.var_quartier_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelQuartier = true;
      }

   }

   public void selectionQuartier() throws HibernateException, NamingException {
      if (this.dataModelQuartier.isRowAvailable()) {
         this.quartier = (Quartier)this.dataModelQuartier.getRowData();
         this.celluleList = this.celluleDao.listCelluleByQuartier(this.quartier, (Session)null);
         this.dataModelCellule.setWrappedData(this.celluleList);
         this.cellule = new Cellule();
      }

   }

   public void supprimerQuartier() throws HibernateException, NamingException {
      if (this.quartier != null) {
         this.quartierList.remove(this.quartier);
         this.dataModelQuartier.setWrappedData(this.quartierList);
         this.quartierDao.delete(this.quartier);
         this.quartier = new Quartier();
      }

   }

   public void annulerQuartier() {
      this.showmodelPanelQuartier = false;
   }

   public void validerQuartier() throws HibernateException, NamingException {
      if (this.ville != null && this.pdv != null && this.region != null && this.secteur != null) {
         if (this.var_quartier_inactif) {
            this.quartier.setQuaInactif(1);
         } else {
            this.quartier.setQuaInactif(0);
         }

         if (this.quartier.getQuaIdResponsable() != 0L) {
            new Users();
            Users var1 = this.userDao.selectByIdUsers(this.quartier.getQuaIdResponsable(), (Session)null);
            if (var1 != null) {
               this.quartier.setQuaNomResponsable(var1.getUsrPatronyme());
            } else {
               this.quartier.setQuaNomResponsable("");
            }
         } else {
            this.quartier.setQuaNomResponsable("");
         }

         if (this.quartier.getQuaId() == 0L) {
            this.quartier.setQuaUserCreat(this.usersLog.getUsrid());
            this.quartier.setQuaDateCreat(new Date());
            this.quartier.setRegion(this.region);
            this.quartier.setSecteur(this.secteur);
            this.quartier.setPointDeVente(this.pdv);
            this.quartier.setVille(this.ville);
            this.quartier = this.quartierDao.insert(this.quartier);
            this.quartierList.add(this.quartier);
            this.dataModelQuartier.setWrappedData(this.quartierList);
            this.celluleList.clear();
            this.dataModelCellule.setWrappedData(this.celluleList);
         } else {
            this.quartier.setQuaUserModif(this.usersLog.getUsrid());
            this.quartier.setQuaDateModif(new Date());
            this.quartier = this.quartierDao.modif(this.quartier);
         }
      }

      this.showmodelPanelQuartier = false;
   }

   public void verifierCodeQuartier() throws HibernateException, NamingException {
      this.existeCode = this.quartierDao.existCode(this.quartier.getQuaCode(), (Session)null);
   }

   public void ajouterCellule() {
      if (this.quartier != null && this.ville != null && this.pdv != null && this.secteur != null && this.region != null) {
         this.cellule = new Cellule();
         this.var_cellule_inactif = false;
         this.existeCode = true;
         this.showmodelPanelCellule = true;
      }

   }

   public void modifierCellule() {
      if (this.cellule != null) {
         if (this.cellule.getCelInactif() == 1) {
            this.var_cellule_inactif = true;
         } else {
            this.var_cellule_inactif = false;
         }

         this.existeCode = false;
         this.showmodelPanelCellule = true;
      }

   }

   public void selectionCellule() {
      if (this.dataModelCellule.isRowAvailable()) {
         this.cellule = (Cellule)this.dataModelCellule.getRowData();
      }

   }

   public void supprimerCellule() throws HibernateException, NamingException {
      if (this.cellule != null) {
         this.celluleList.remove(this.cellule);
         this.dataModelCellule.setWrappedData(this.celluleList);
         this.celluleDao.delete(this.cellule);
         this.cellule = new Cellule();
      }

   }

   public void annulerCellule() {
      this.showmodelPanelCellule = false;
   }

   public void validerCellule() throws HibernateException, NamingException {
      if (this.quartier != null && this.ville != null && this.pdv != null && this.region != null && this.secteur != null) {
         if (this.var_cellule_inactif) {
            this.cellule.setCelInactif(1);
         } else {
            this.cellule.setCelInactif(0);
         }

         if (this.cellule.getCelIdResponsable() != 0L) {
            new Users();
            Users var1 = this.userDao.selectByIdUsers(this.cellule.getCelIdResponsable(), (Session)null);
            if (var1 != null) {
               this.cellule.setCelNomResponsable(var1.getUsrPatronyme());
            } else {
               this.cellule.setCelNomResponsable("");
            }
         } else {
            this.cellule.setCelNomResponsable("");
         }

         if (this.cellule.getCelId() == 0L) {
            this.cellule.setCelUserCreat(this.usersLog.getUsrid());
            this.cellule.setCelDateCreat(new Date());
            this.cellule.setRegion(this.region);
            this.cellule.setSecteur(this.secteur);
            this.cellule.setPointDeVente(this.pdv);
            this.cellule.setVille(this.ville);
            this.cellule.setQuartier(this.quartier);
            this.cellule = this.celluleDao.insert(this.cellule);
            this.celluleList.add(this.cellule);
            this.dataModelCellule.setWrappedData(this.celluleList);
         } else {
            this.cellule.setCelUserModif(this.usersLog.getUsrid());
            this.cellule.setCelDateModif(new Date());
            this.cellule = this.celluleDao.modif(this.cellule);
         }
      }

      this.showmodelPanelCellule = false;
   }

   public void verifierCodeCellule() throws HibernateException, NamingException {
      this.existeCode = this.celluleDao.existCode(this.cellule.getCelCode(), (Session)null);
   }

   public DataModel getDataModelSecteur() {
      return this.dataModelSecteur;
   }

   public void setDataModelSecteur(DataModel var1) {
      this.dataModelSecteur = var1;
   }

   public DataModel getDataModelPdv() {
      return this.dataModelPdv;
   }

   public void setDataModelPdv(DataModel var1) {
      this.dataModelPdv = var1;
   }

   public DataModel getDataModelRegion() {
      return this.dataModelRegion;
   }

   public void setDataModelRegion(DataModel var1) {
      this.dataModelRegion = var1;
   }

   public Secteur getSecteur() {
      return this.secteur;
   }

   public void setSecteur(Secteur var1) {
      this.secteur = var1;
   }

   public boolean isExisteCode() {
      return this.existeCode;
   }

   public void setExisteCode(boolean var1) {
      this.existeCode = var1;
   }

   public PointDeVente getPdv() {
      return this.pdv;
   }

   public void setPdv(PointDeVente var1) {
      this.pdv = var1;
   }

   public boolean isShowmodelPanelSecteur() {
      return this.showmodelPanelSecteur;
   }

   public void setShowmodelPanelSecteur(boolean var1) {
      this.showmodelPanelSecteur = var1;
   }

   public boolean isVar_secteur_inactif() {
      return this.var_secteur_inactif;
   }

   public void setVar_secteur_inactif(boolean var1) {
      this.var_secteur_inactif = var1;
   }

   public boolean isVar_pdv_inactif() {
      return this.var_pdv_inactif;
   }

   public void setVar_pdv_inactif(boolean var1) {
      this.var_pdv_inactif = var1;
   }

   public boolean isShowmodelPanelPdv() {
      return this.showmodelPanelPdv;
   }

   public void setShowmodelPanelPdv(boolean var1) {
      this.showmodelPanelPdv = var1;
   }

   public boolean isShowmodelPanelRegion() {
      return this.showmodelPanelRegion;
   }

   public void setShowmodelPanelRegion(boolean var1) {
      this.showmodelPanelRegion = var1;
   }

   public Region getRegion() {
      return this.region;
   }

   public void setRegion(Region var1) {
      this.region = var1;
   }

   public boolean isVar_region_inactif() {
      return this.var_region_inactif;
   }

   public void setVar_region_inactif(boolean var1) {
      this.var_region_inactif = var1;
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

   public List getMesResponsable() {
      return this.mesResponsable;
   }

   public void setMesResponsable(List var1) {
      this.mesResponsable = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public Cellule getCellule() {
      return this.cellule;
   }

   public void setCellule(Cellule var1) {
      this.cellule = var1;
   }

   public DataModel getDataModelCellule() {
      return this.dataModelCellule;
   }

   public void setDataModelCellule(DataModel var1) {
      this.dataModelCellule = var1;
   }

   public DataModel getDataModelQuartier() {
      return this.dataModelQuartier;
   }

   public void setDataModelQuartier(DataModel var1) {
      this.dataModelQuartier = var1;
   }

   public DataModel getDataModelVille() {
      return this.dataModelVille;
   }

   public void setDataModelVille(DataModel var1) {
      this.dataModelVille = var1;
   }

   public Quartier getQuartier() {
      return this.quartier;
   }

   public void setQuartier(Quartier var1) {
      this.quartier = var1;
   }

   public boolean isShowmodelPanelCellule() {
      return this.showmodelPanelCellule;
   }

   public void setShowmodelPanelCellule(boolean var1) {
      this.showmodelPanelCellule = var1;
   }

   public boolean isShowmodelPanelQuartier() {
      return this.showmodelPanelQuartier;
   }

   public void setShowmodelPanelQuartier(boolean var1) {
      this.showmodelPanelQuartier = var1;
   }

   public boolean isShowmodelPanelVille() {
      return this.showmodelPanelVille;
   }

   public void setShowmodelPanelVille(boolean var1) {
      this.showmodelPanelVille = var1;
   }

   public boolean isVar_cellule_inactif() {
      return this.var_cellule_inactif;
   }

   public void setVar_cellule_inactif(boolean var1) {
      this.var_cellule_inactif = var1;
   }

   public boolean isVar_quartier_inactif() {
      return this.var_quartier_inactif;
   }

   public void setVar_quartier_inactif(boolean var1) {
      this.var_quartier_inactif = var1;
   }

   public boolean isVar_ville_inactif() {
      return this.var_ville_inactif;
   }

   public void setVar_ville_inactif(boolean var1) {
      this.var_ville_inactif = var1;
   }

   public Ville getVille() {
      return this.ville;
   }

   public void setVille(Ville var1) {
      this.ville = var1;
   }
}
