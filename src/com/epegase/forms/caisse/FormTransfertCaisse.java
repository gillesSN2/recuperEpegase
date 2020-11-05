package com.epegase.forms.caisse;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesOperations;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.CaissesOperationsDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.OptionCaisses;
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

public class FormTransfertCaisse implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionCaisses optionsCaisse;
   private ExercicesCaisse exercicesCaisse;
   private EspionDao espionDao;
   private String pageIndex;
   private JournauxComptables journauxComptables = new JournauxComptables();
   private JournauxComptablesDao journauxComptablesDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private Reglements reglements = new Reglements();
   private ReglementsDao reglementsDao;
   private Date inpDu;
   private Date inpAu;
   private String inpCaisse;
   private int inpOperation;
   private String inpPieceDeb;
   private String inpPieceFin;
   private int inpMode;
   private boolean inpDocNonTrf = false;
   private UtilDate utilDate = new UtilDate();
   private List listCaisses;
   private List mesCaissesItems = new ArrayList();
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private boolean var_affiche_bouton = false;

   public void InstancesDaoUtilses() {
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
   }

   public void configTransfert() throws HibernateException, NamingException {
      this.mesCaissesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() != null && !((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse().isEmpty() && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60) {
               this.mesCaissesItems.add(new SelectItem(((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib()));
            }
         }
      }

   }

   public void executerRequete() throws HibernateException, NamingException {
      this.listDocument.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Reglements");
      String var2 = "";
      CaissesOperationsDao var3 = new CaissesOperationsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.selectOperation(var1);
      new CaissesCommerciales();
      CaissesCommercialesDao var6 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
      CaissesCommerciales var5 = var6.chercheCaisseDefaut(this.exercicesCaisse.getExecaiId(), var1);
      if (var5 != null) {
         var2 = var5.getCaiCode();
      }

      String var7 = "";
      String var8 = "";
      if (this.inpDu != null && this.inpAu != null) {
         var7 = this.utilDate.dateToStringSQLLight(this.inpDu);
         var8 = this.utilDate.dateToStringSQLLight(this.inpAu);
         var7 = var7 + " 00:00:00";
         var8 = var8 + " 23:59:59";
      }

      String var9 = "";
      if (this.inpCaisse != null && !this.inpCaisse.isEmpty() && this.inpCaisse.contains(":")) {
         String[] var10 = this.inpCaisse.split(":");
         var9 = var10[0];
      }

      new ArrayList();
      List var16 = this.reglementsDao.rechercheReglementATransfererCompta(this.inpPieceDeb, this.inpPieceFin, var7, var8, var9, this.inpOperation, this.inpMode, this.inpDocNonTrf, var1);
      if (var16.size() != 0) {
         for(int var11 = 0; var11 < var16.size(); ++var11) {
            DocumentEntete var12 = new DocumentEntete();
            boolean var13 = false;
            if (((Reglements)var16.get(var11)).getRglOperation() != null && !((Reglements)var16.get(var11)).getRglOperation().isEmpty() && ((Reglements)var16.get(var11)).getRglOperation().equals("00")) {
               ((Reglements)var16.get(var11)).setRglOperation("");
            }

            if (((Reglements)var16.get(var11)).getRglOperation() != null && !((Reglements)var16.get(var11)).getRglOperation().isEmpty()) {
               if (var4.size() != 0) {
                  for(int var14 = 0; var14 < var4.size(); ++var14) {
                     if (((Reglements)var16.get(var11)).getRglOperation().equals(((CaissesOperations)var4.get(var14)).getCaiopeCode())) {
                        if (((CaissesOperations)var4.get(var14)).getCaiopeTransfert() == 0) {
                           var13 = true;
                        } else {
                           var13 = false;
                        }
                        break;
                     }
                  }
               } else {
                  var13 = true;
               }
            } else {
               var13 = true;
            }

            if (var13) {
               if (((Reglements)var16.get(var11)).getRglNatureDoc() == 0) {
                  var12.setDocNature(((Reglements)var16.get(var11)).getRglCategorie());
                  var12.setDocNomTiers(((Reglements)var16.get(var11)).getRglLibelle());
               } else {
                  var12.setDocNature(((Reglements)var16.get(var11)).getRglNatureDoc());
                  var12.setDocNomTiers(((Reglements)var16.get(var11)).getRglNomTiers());
               }

               String var17 = "";
               if (((Reglements)var16.get(var11)).getRglObjet() != null && !((Reglements)var16.get(var11)).getRglObjet().isEmpty()) {
                  var17 = ((Reglements)var16.get(var11)).getRglObjet();
               }

               String var15 = "";
               if (((Reglements)var16.get(var11)).getRglLibelle() != null && !((Reglements)var16.get(var11)).getRglLibelle().isEmpty()) {
                  var15 = ((Reglements)var16.get(var11)).getRglLibelle();
               }

               if (((Reglements)var16.get(var11)).getRglNatureDoc() != 71 && ((Reglements)var16.get(var11)).getRglNatureDoc() != 73 && ((Reglements)var16.get(var11)).getRglNatureDoc() != 74 && ((Reglements)var16.get(var11)).getRglNatureDoc() != 76) {
                  var12.setDocLibelle(var17 + " " + var15);
               } else {
                  var12.setDocLibelle("");
                  var12.setDocNomTiers("Paiement comptant");
               }

               var12.setDocId(((Reglements)var16.get(var11)).getRglId());
               var12.setDocDate(((Reglements)var16.get(var11)).getRglDateReg());
               var12.setDocNum(((Reglements)var16.get(var11)).getRglNum());
               var12.setDocTypeReg(((Reglements)var16.get(var11)).getRglTypeReg());
               var12.setDocSerie(((Reglements)var16.get(var11)).getRglSerie());
               if (((Reglements)var16.get(var11)).getRglCodeCaiss() != null && !((Reglements)var16.get(var11)).getRglCodeCaiss().isEmpty()) {
                  var12.setDocCodeCaiss(((Reglements)var16.get(var11)).getRglCodeCaiss());
               } else {
                  var12.setDocCodeCaiss(var2);
               }

               var12.setDocCodeEmetrice(((Reglements)var16.get(var11)).getRglCodeEmetrice());
               var12.setDocCodeReceptrice(((Reglements)var16.get(var11)).getRglCodeReceptrice());
               var12.setDocTotTva(((Reglements)var16.get(var11)).getRglRecette() - ((Reglements)var16.get(var11)).getRglRendu());
               var12.setDocTotTtc(((Reglements)var16.get(var11)).getRglDepense());
               var12.setDocSelect(true);
               this.listDocument.add(var12);
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

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public OptionCaisses getOptionsCaisse() {
      return this.optionsCaisse;
   }

   public void setOptionsCaisse(OptionCaisses var1) {
      this.optionsCaisse = var1;
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

   public String getInpCaisse() {
      return this.inpCaisse;
   }

   public void setInpCaisse(String var1) {
      this.inpCaisse = var1;
   }

   public int getInpOperation() {
      return this.inpOperation;
   }

   public void setInpOperation(int var1) {
      this.inpOperation = var1;
   }

   public int getInpMode() {
      return this.inpMode;
   }

   public void setInpMode(int var1) {
      this.inpMode = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesCaissesItems() {
      return this.mesCaissesItems;
   }

   public void setMesCaissesItems(List var1) {
      this.mesCaissesItems = var1;
   }
}
