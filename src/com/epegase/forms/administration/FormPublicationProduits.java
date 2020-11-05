package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureNatureVentes;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;

public class FormPublicationProduits implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int var_action = 0;
   private ExercicesVentes exercicesVentes;
   private OptionVentes optionsVentes = new OptionVentes();
   private Produits produits;
   private String var_NatureFind;
   private String var_FamilleFind;
   private String var_ServiceFind;
   private String var_ActiviteFind;
   private String var_CodFind;
   private String var_LibFind;
   private String inpNatureVnt = "";
   private String inpFamilleVnt = "";
   private List lesProduits = new ArrayList();
   private transient DataModel datamodelProduit = new ListDataModel();
   private boolean afficheButtPanier = false;
   private int var_inactif = 0;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   FamillesProduitsVentes famillesProduitsVentes;
   private ProduitsVtesDao produitsVtesDao;
   private List mesFamillesClientsItems;
   private List lesFamillesclients;
   private List mesFamillesVentesItems;
   private List mesnaturesItems;
   private List mesServicesItems;
   private List mesActivitesItems;
   private List lesProduitsServicesFind;
   private Element racine;
   private Document document;
   private List lesmodelesImpressions = new ArrayList();
   private String modeleRapport;
   private boolean errorConnection;
   private boolean var_affFicPdf;

   public void instanceDaoUtilises() {
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptions() throws NamingException {
      if (this.structureLog.getStrECommerceVal() == 1) {
         this.afficheButtPanier = true;
      } else {
         this.afficheButtPanier = false;
      }

      this.produits = null;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
      this.recupererNatureFamilleVentesItem();
      this.recupererFamilleProduitVentesItem(var1);
      this.recupererActiviteItem(var1);
      this.recupererServiceItem(var1);
      this.utilInitHibernate.closeSession();
   }

   public void rechercherProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.lesProduits = new ArrayList();
      String var1 = this.getVar_CodFind();
      String var2 = this.getVar_LibFind();
      String var3 = "X0X";
      if (this.getVar_FamilleFind() != null && this.getVar_FamilleFind().contains(":")) {
         String[] var4 = this.getVar_FamilleFind().split(":");
         var3 = var4[0];
      }

      String var8 = "X0X";
      if (this.getVar_NatureFind() != null && this.getVar_NatureFind().contains(":")) {
         String[] var5 = this.getVar_NatureFind().split(":");
         var8 = var5[0];
      }

      String var9 = "X0X";
      if (this.getVar_ActiviteFind() != null && this.getVar_ActiviteFind().contains(":")) {
         String[] var6 = this.getVar_ActiviteFind().split(":");
         var9 = var6[0];
      }

      String var10 = "X0X";
      if (this.getVar_ServiceFind() != null && this.getVar_ServiceFind().contains(":")) {
         String[] var7 = this.getVar_ServiceFind().split(":");
         var10 = var7[0];
      }

      this.recupereProdIdByProdService(var1, var2, var8, var3, var9, var10);
      this.datamodelProduit.setWrappedData(this.lesProduits);
   }

   public void recupereProdIdByProdService(String var1, String var2, String var3, String var4, String var5, String var6) throws JDOMException, IOException, HibernateException, NamingException {
      new Service();
      new ProduitsServices();
      ProduitsServices var8 = new ProduitsServices();
      if (var6.equalsIgnoreCase("X0X")) {
         this.lesProduits = this.produitsVtesDao.selectFindProduit(var1, var2, var3, "", var4, var5, this.var_inactif, (String)null, (Session)null);
      } else {
         String[] var9 = var6.split(":");
         String var10 = var9[0];
         ServiceDao var11 = new ServiceDao(this.baseLog, this.utilInitHibernate);
         Service var7 = var11.chargerLeServiceCode(var10, (Session)null);
         var8.setServices(var7);
         this.lesProduitsServicesFind = new ArrayList();
         this.lesProduits = new ArrayList();
         ProduitsServicesDao var12 = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
         this.lesProduitsServicesFind = var12.selectProdServiceByservVtes(var8.getServices(), var1, (Session)null);
         if (this.lesProduitsServicesFind.size() > 0) {
            String var13 = "0000";

            for(int var14 = 0; var14 < this.lesProduitsServicesFind.size(); ++var14) {
               ProduitsServices var15 = (ProduitsServices)this.lesProduitsServicesFind.get(var14);
               var13 = var13 + "," + var15.getProduits().getProId();
            }

            var13 = "(" + var13 + ")";
            this.lesProduits = this.produitsVtesDao.selectFindProduitSer(var1, var2, var3, var4, var5, var13, this.var_inactif, (Session)null);
         }
      }

   }

   public void consulterProduit() {
      this.var_action = 3;
      if (this.produits.getProInactif() == 1) {
         this.produits.setInactif(true);
      } else {
         this.produits.setInactif(false);
      }

   }

   public void selectionProduit() throws IOException, SQLException, HibernateException, NamingException {
      this.produits = new Produits();
      if (this.datamodelProduit.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduit.getRowData();
         long var1 = this.produits.getProId();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.produits = this.produitsVtesDao.chargeProduit(var1, var3);
         if (this.produits != null) {
            if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
               this.famillesProduitsVentes = new FamillesProduitsVentes();
               this.famillesProduitsVentes = this.famillesProduitsVentesDao.rechercheFamilleByCode(this.exercicesVentes.getExevteId(), this.produits.getProVteCode(), var3);
               if (this.famillesProduitsVentes != null) {
                  this.inpNatureVnt = this.famillesProduitsVentes.getFamvteNature() + ":" + this.famillesProduitsVentes.getFamvteLibNature();
               } else {
                  this.inpNatureVnt = "";
               }
            } else {
               this.inpNatureVnt = "";
            }

            if (this.produits.getProVteCode() != null && !this.produits.getProVteCode().isEmpty()) {
               this.inpFamilleVnt = this.produits.getProVteCode() + ":" + this.produits.getProVteLib();
            } else {
               this.inpFamilleVnt = "";
            }

            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void annuleSaisie() {
      this.var_action = 0;
   }

   public void majProduit() throws JDOMException, IOException, HibernateException, NamingException {
      String[] var1;
      if (this.inpNatureVnt.contains(":")) {
         var1 = this.inpNatureVnt.split(":");
         this.produits.setProVteNat(var1[0]);
      } else {
         this.produits.setProVteNat("");
      }

      if (this.inpFamilleVnt.contains(":")) {
         var1 = this.inpFamilleVnt.split(":");
         this.produits.setProVteCode(var1[0]);
         this.produits.setProVteLib(var1[1]);
      } else {
         this.produits.setProVteCode("");
         this.produits.setProVteLib("");
      }

      if (this.produits.getProVteCpteLoc() != null && this.produits.getProVteCpteLoc().contains(":")) {
         var1 = this.produits.getProVteCpteLoc().split(":");
         this.produits.setProVteCpteLoc(var1[0]);
      } else {
         this.produits.setProVteCpteLoc("");
      }

      if (this.produits.getProVteCpteZ() != null && this.produits.getProVteCpteZ().contains(":")) {
         var1 = this.produits.getProVteCpteZ().split(":");
         this.produits.setProVteCpteZ(var1[0]);
      } else {
         this.produits.setProVteCpteZ("");
      }

      if (this.produits.getProVteCpteHz() != null && this.produits.getProVteCpteHz().contains(":")) {
         var1 = this.produits.getProVteCpteHz().split(":");
         this.produits.setProVteCpteHz(var1[0]);
      } else {
         this.produits.setProVteCpteHz("");
      }

      if (this.produits.getProVteCptePr() != null && this.produits.getProVteCptePr().contains(":")) {
         var1 = this.produits.getProVteCptePr().split(":");
         this.produits.setProVteCptePr(var1[0]);
      } else {
         this.produits.setProVteCptePr("");
      }

      if (this.produits.getProVteCpteSt() != null && this.produits.getProVteCpteSt().contains(":")) {
         var1 = this.produits.getProVteCpteSt().split(":");
         this.produits.setProVteCpteSt(var1[0]);
      } else {
         this.produits.setProVteCpteSt("");
      }

      if (this.produits.getProVteTva() != null && this.produits.getProVteTva().contains(":")) {
         var1 = this.produits.getProVteTva().split(":");
         this.produits.setProVteTva(var1[0]);
      } else {
         this.produits.setProVteTva("");
      }

      if (this.produits.getProDepotVte() != null && this.produits.getProDepotVte().contains(":")) {
         var1 = this.produits.getProDepotVte().split(":");
         this.produits.setProDepotVte(var1[0]);
      } else {
         this.produits.setProDepotVte("");
      }

      if (this.produits.getProActivite() != null && this.produits.getProActivite().contains(":")) {
         var1 = this.produits.getProActivite().split(":");
         this.produits.setProActivite(var1[0]);
      } else {
         this.produits.setProActivite("");
      }

      if (this.produits.isInactif()) {
         this.produits.setProInactif(1);
      }

      if (this.getProduits().getProId() == 0L) {
         this.produits = this.produitsVtesDao.insert(this.produits);
         this.lesProduits.add(this.produits);
         this.datamodelProduit.setWrappedData(this.lesProduits);
         this.var_action = 2;
      } else {
         this.produits = this.produitsVtesDao.modifProduit(this.produits);
         this.rechercherProduit();
         this.var_action = 0;
      }

   }

   public void initPublicSelect() throws IOException, SQLException {
      this.var_action = 5;
   }

   public void publierProduit() {
   }

   public void changerVersion() {
      Produits var1 = (Produits)this.datamodelProduit.getRowData();
      if (var1.isPublicBool()) {
         var1.setProPublic(1);
      } else {
         var1.setProPublic(0);
      }

   }

   public void recupererNatureFamilleVentesItem() {
      this.mesnaturesItems = new ArrayList();
      LectureNatureVentes var1 = new LectureNatureVentes();
      this.mesnaturesItems = var1.getMesNatureVentesItems();
   }

   public void recupererFamilleProduitVentesItem(Session var1) throws HibernateException, NamingException {
      this.mesFamillesVentesItems = new ArrayList();
      this.mesFamillesVentesItems = this.famillesProduitsVentesDao.chargerFamilleProduitVentesItems(this.exercicesVentes.getExevteId(), var1);
   }

   public void recupererActiviteItem(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesItems = var2.chargerLesActivites(var1);
   }

   public void recupererServiceItem(Session var1) throws HibernateException, NamingException {
      this.mesServicesItems = new ArrayList();
      ServiceDao var2 = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.mesServicesItems = var2.chargerLesServicesItems(0, false, var1);
   }

   public void pamarPrint() throws IOException {
      this.chargerlesmodelesimpressions();
   }

   public void chargerlesmodelesimpressions() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesmodelesImpressions = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith(".jasper")) {
               String var6 = var5.substring(0, var5.indexOf("."));
               this.lesmodelesImpressions.add(new SelectItem(var6));
            }
         }
      }

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

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public boolean isErrorConnection() {
      return this.errorConnection;
   }

   public void setErrorConnection(boolean var1) {
      this.errorConnection = var1;
   }

   public List getLesProduits() {
      return this.lesProduits;
   }

   public void setLesProduits(List var1) {
      this.lesProduits = var1;
   }

   public DataModel getDatamodelProduit() {
      return this.datamodelProduit;
   }

   public void setDatamodelProduit(DataModel var1) {
      this.datamodelProduit = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public List getMesnaturesItems() {
      return this.mesnaturesItems;
   }

   public void setMesnaturesItems(List var1) {
      this.mesnaturesItems = var1;
   }

   public String getInpNatureVnt() {
      return this.inpNatureVnt;
   }

   public void setInpNatureVnt(String var1) {
      this.inpNatureVnt = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public List getLesProduitsServicesFind() {
      return this.lesProduitsServicesFind;
   }

   public void setLesProduitsServicesFind(List var1) {
      this.lesProduitsServicesFind = var1;
   }

   public String getVar_ActiviteFind() {
      return this.var_ActiviteFind;
   }

   public void setVar_ActiviteFind(String var1) {
      this.var_ActiviteFind = var1;
   }

   public String getVar_CodFind() {
      return this.var_CodFind;
   }

   public void setVar_CodFind(String var1) {
      this.var_CodFind = var1;
   }

   public String getVar_FamilleFind() {
      return this.var_FamilleFind;
   }

   public void setVar_FamilleFind(String var1) {
      this.var_FamilleFind = var1;
   }

   public String getVar_LibFind() {
      return this.var_LibFind;
   }

   public void setVar_LibFind(String var1) {
      this.var_LibFind = var1;
   }

   public String getVar_NatureFind() {
      return this.var_NatureFind;
   }

   public void setVar_NatureFind(String var1) {
      this.var_NatureFind = var1;
   }

   public String getVar_ServiceFind() {
      return this.var_ServiceFind;
   }

   public void setVar_ServiceFind(String var1) {
      this.var_ServiceFind = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getLesmodelesImpressions() {
      return this.lesmodelesImpressions;
   }

   public void setLesmodelesImpressions(List var1) {
      this.lesmodelesImpressions = var1;
   }

   public String getModeleRapport() {
      return this.modeleRapport;
   }

   public void setModeleRapport(String var1) {
      this.modeleRapport = var1;
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

   public List getMesFamillesVentesItems() {
      return this.mesFamillesVentesItems;
   }

   public void setMesFamillesVentesItems(List var1) {
      this.mesFamillesVentesItems = var1;
   }

   public String getInpFamilleVnt() {
      return this.inpFamilleVnt;
   }

   public void setInpFamilleVnt(String var1) {
      this.inpFamilleVnt = var1;
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public boolean isVar_affFicPdf() {
      if (this.produits.getProPdf() != null && !this.produits.getProPdf().isEmpty()) {
         this.var_affFicPdf = true;
      } else {
         this.var_affFicPdf = false;
      }

      return this.var_affFicPdf;
   }

   public void setVar_affFicPdf(boolean var1) {
      this.var_affFicPdf = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public List getMesFamillesClientsItems() {
      return this.mesFamillesClientsItems;
   }

   public void setMesFamillesClientsItems(List var1) {
      this.mesFamillesClientsItems = var1;
   }

   public List getLesFamillesclients() {
      return this.lesFamillesclients;
   }

   public void setLesFamillesclients(List var1) {
      this.lesFamillesclients = var1;
   }

   public boolean isAfficheButtPanier() {
      return this.afficheButtPanier;
   }

   public void setAfficheButtPanier(boolean var1) {
      this.afficheButtPanier = var1;
   }

   public FamillesProduitsVentes getFamillesProduitsVentes() {
      return this.famillesProduitsVentes;
   }

   public void setFamillesProduitsVentes(FamillesProduitsVentes var1) {
      this.famillesProduitsVentes = var1;
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

   public int getVar_inactif() {
      return this.var_inactif;
   }

   public void setVar_inactif(int var1) {
      this.var_inactif = var1;
   }
}
