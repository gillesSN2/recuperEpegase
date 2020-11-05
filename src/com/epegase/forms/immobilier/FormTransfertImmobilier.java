package com.epegase.forms.immobilier;

import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.OptionVentes;
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

public class FormTransfertImmobilier implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionVentes optionsVentes;
   private ExercicesVentes exercicesVentes;
   private EspionDao espionDao;
   private int var_nb_max;
   private String pageIndex;
   private int typeImmobilier;
   private String libelleImmobilier;
   private JournauxComptables journauxComptables = new JournauxComptables();
   private JournauxComptablesDao journauxComptablesDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private BienFacture bienFacture = new BienFacture();
   private BienFactureDao bienFactureDao;
   private Reglements reglements;
   private ReglementsDao reglementsDao;
   private String var_requete;
   private Date inpDu;
   private Date inpAu;
   private String inpPieceDeb;
   private String inpPieceFin;
   private boolean inpDocNonTrf = false;
   private UtilDate utilDate = new UtilDate();
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private boolean var_affiche_bouton = false;

   public void InstancesDaoUtilses() {
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.bienFactureDao = new BienFactureDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
   }

   public void init() {
      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.typeImmobilier == 1) {
         this.libelleImmobilier = "SYNDIC";
      } else if (this.typeImmobilier == 2) {
         this.libelleImmobilier = "NEGOCE";
      } else {
         this.libelleImmobilier = "LOCATION";
      }

   }

   public void executerRequete() throws HibernateException, NamingException {
      this.var_requete = "rgl_date_reg>='" + this.inpDu + "' and rgl_date_reg<='" + this.inpAu + "' and rgl_nature_doc=165 and rgl_id_document<>0";
      String var1 = "";
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         new ArrayList();
         List var4 = this.reglementsDao.rechercheReglementsRequete(this.var_requete, var2);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "," + ((Reglements)var4.get(var5)).getRglIdDocument();
               } else {
                  var1 = "" + ((Reglements)var4.get(var5)).getRglIdDocument();
               }
            }

            if (var1 != null && !var1.isEmpty()) {
               new ArrayList();
               String var6 = "biefac_id in (" + var1 + ")";
               List var18 = this.bienFactureDao.rechercheFactureRequete(var6, var2);
               if (var18.size() != 0) {
                  new BienFacture();

                  BienFacture var7;
                  for(int var8 = 0; var8 < var18.size(); ++var8) {
                     var7 = (BienFacture)var18.get(var8);
                     var7.setBiefacRegTmp(0.0D);
                     this.bienFactureDao.modif(var7, var2);
                  }

                  var2.flush();
                  new Reglements();

                  for(int var9 = 0; var9 < var4.size(); ++var9) {
                     Reglements var22 = (Reglements)var4.get(var9);
                     long var10 = var22.getRglIdDocument();
                     var7 = this.bienFactureDao.pourParapheur(var10, var2);
                     if (var7 != null) {
                        var7.setBiefacRegTmp(var7.getBiefacRegTmp() + var22.getRglRecette());
                        this.bienFactureDao.modif(var7, var2);
                     }
                  }

                  var2.flush();
               }
            }

            var3.commit();
         }
      } catch (HibernateException var15) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var15;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "BiensImmobilier");
      this.listDocument.clear();
      String var17 = "";
      String var19 = "";
      if (this.inpDu != null && this.inpAu != null) {
         var17 = this.utilDate.dateToStringSQLLight(this.inpDu);
         var19 = this.utilDate.dateToStringSQLLight(this.inpAu);
         var17 = var17 + " 00:00:00";
         var19 = var19 + " 23:59:59";
      }

      new ArrayList();
      List var20 = this.bienFactureDao.rechercheFactureATransfererCompta(this.optionsVentes.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var17, var19, this.inpDocNonTrf, var2);
      if (var20.size() != 0) {
         for(int var21 = 0; var21 < var20.size(); ++var21) {
            DocumentEntete var23 = new DocumentEntete();
            if (((BienFacture)var20.get(var21)).getBiefacRegTmp() != 0.0D) {
               var23.setDocNature(165);
               var23.setDocId(((BienFacture)var20.get(var21)).getBiefacId());
               var23.setDocDate(((BienFacture)var20.get(var21)).getBiefacDateDebut());
               var23.setDocNum(((BienFacture)var20.get(var21)).getBiefacNum());
               var23.setDocSerie(((BienFacture)var20.get(var21)).getBiefacSerie());
               var23.setDocNomTiers(((BienFacture)var20.get(var21)).getBiefacNomTiers());
               var23.setDocTotHt(((BienFacture)var20.get(var21)).getBiefacTotHt());
               var23.setDocTotTva(((BienFacture)var20.get(var21)).getBiefacTotTva());
               var23.setDocTotTc(0.0D);
               var23.setDocTotTtc(((BienFacture)var20.get(var21)).getBiefacTotTtc());
               var23.setDocTotReglement(((BienFacture)var20.get(var21)).getBiefacRegTmp());
               var23.setNumComptetier(((BienFacture)var20.get(var21)).getTiers().getTiecompte0());
               var23.setDocSelect(true);
               this.listDocument.add(var23);
            }
         }
      }

      this.datamodelDocument.setWrappedData(this.listDocument);
      this.utilInitHibernate.closeSession();
      if (this.listDocument.size() != 0) {
         this.var_affiche_bouton = true;
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void selectionLigne() {
      if (this.datamodelDocument.isRowAvailable()) {
      }

   }

   public void selectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(true);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public void deSelectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(false);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public boolean isInpDocNonTrf() {
      return this.inpDocNonTrf;
   }

   public void setInpDocNonTrf(boolean var1) {
      this.inpDocNonTrf = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public String getInpPieceDeb() {
      return this.inpPieceDeb;
   }

   public void setInpPieceDeb(String var1) {
      this.inpPieceDeb = var1;
   }

   public String getInpPieceFin() {
      return this.inpPieceFin;
   }

   public void setInpPieceFin(String var1) {
      this.inpPieceFin = var1;
   }

   public List getListDocument() {
      return this.listDocument;
   }

   public void setListDocument(List var1) {
      this.listDocument = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public String getLibelleImmobilier() {
      return this.libelleImmobilier;
   }

   public void setLibelleImmobilier(String var1) {
      this.libelleImmobilier = var1;
   }

   public int getTypeImmobilier() {
      return this.typeImmobilier;
   }

   public void setTypeImmobilier(int var1) {
      this.typeImmobilier = var1;
   }
}
