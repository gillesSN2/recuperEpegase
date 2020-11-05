package com.epegase.forms.achats;

import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.OptionAchats;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormTransfertAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionAchats optionAchats;
   private ExercicesAchats exercicesAchats;
   private EspionDao espionDao;
   private String pageIndex;
   private JournauxComptables journauxComptables = new JournauxComptables();
   private JournauxComptablesDao journauxComptablesDao;
   private Chrono chrono = new Chrono();
   private ChronoDao chronoDao;
   private FactureEnteteAchats factureEnteteAchats = new FactureEnteteAchats();
   private FactureEnteteAchatsDao factureEnteteAchatsDao;
   private FactureLigneAchats factureLigneAchats = new FactureLigneAchats();
   private FactureLigneAchatsDao factureLigneAchatsDao;
   private AvoirEnteteAchats avoirEnteteAchats = new AvoirEnteteAchats();
   private AvoirEnteteAchatsDao avoirEnteteAchatsDao;
   private AvoirLigneAchats avoirLigneAchats = new AvoirLigneAchats();
   private AvoirLigneAchatsDao avoirLigneAchatsDao;
   private NoteDebitEnteteAchats noteDebitEnteteAchats = new NoteDebitEnteteAchats();
   private NoteDebitEnteteAchatsDao noteDebitEnteteAchatsDao;
   private NoteDebitLigneAchats noteDebitLigneAchats = new NoteDebitLigneAchats();
   private NoteDebitLigneAchatsDao noteDebitLigneAchatsDao;
   private FraisEnteteAchats fraisEnteteAchats;
   private FraisEnteteAchatsDao fraisEnteteAchatsDao;
   private ValorisationEnteteAchats valorisationEnteteAchats = new ValorisationEnteteAchats();
   private ValorisationEnteteAchatsDao valorisationEnteteAchatsDao;
   private Date inpDu;
   private Date inpAu;
   private String inpPieceDeb;
   private String inpPieceFin;
   private boolean inpDocNonTrf = false;
   private UtilDate utilDate = new UtilDate();
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private boolean var_affiche_bouton = false;
   private int choixRacine;
   private String selecFiscalite;

   public void InstancesDaoUtilses() {
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteAchatsDao = new FactureEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneAchatsDao = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirEnteteAchatsDao = new AvoirEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneAchatsDao = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitEnteteAchatsDao = new NoteDebitEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneAchatsDao = new NoteDebitLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fraisEnteteAchatsDao = new FraisEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.valorisationEnteteAchatsDao = new ValorisationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
   }

   public void executerRequete() throws HibernateException, NamingException {
      this.listDocument.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertAch");
      String var2 = "";
      String var3 = "";
      if (this.inpDu != null && this.inpAu != null) {
         var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
         var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
         var2 = var2 + " 00:00:00";
         var3 = var3 + " 23:59:59";
      }

      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      new ArrayList();
      List var9 = this.chronoDao.selectListAchat(1, var1);
      if (var9.size() != 0) {
         for(int var10 = 0; var10 < var9.size(); ++var10) {
            if (((Chrono)var9.get(var10)).getChrNature() == 15 && ((Chrono)var9.get(var10)).getChrJournal() != null && !((Chrono)var9.get(var10)).getChrJournal().isEmpty()) {
               var4 = true;
            } else if (((Chrono)var9.get(var10)).getChrNature() == 16 && ((Chrono)var9.get(var10)).getChrJournal() != null && !((Chrono)var9.get(var10)).getChrJournal().isEmpty()) {
               var5 = true;
            } else if (((Chrono)var9.get(var10)).getChrNature() == 17 && ((Chrono)var9.get(var10)).getChrJournal() != null && !((Chrono)var9.get(var10)).getChrJournal().isEmpty()) {
               var6 = true;
            } else if (((Chrono)var9.get(var10)).getChrNature() == 18 && ((Chrono)var9.get(var10)).getChrJournal() != null && !((Chrono)var9.get(var10)).getChrJournal().isEmpty()) {
               var7 = true;
            } else if (((Chrono)var9.get(var10)).getChrNature() == 35 && ((Chrono)var9.get(var10)).getChrJournal() != null && !((Chrono)var9.get(var10)).getChrJournal().isEmpty()) {
               var8 = true;
            }
         }
      }

      int var11;
      DocumentEntete var12;
      List var13;
      if (var4) {
         new ArrayList();
         var13 = this.factureEnteteAchatsDao.rechercheFactureATransfererCompta(this.optionAchats.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var13.size() != 0) {
            for(var11 = 0; var11 < var13.size(); ++var11) {
               var12 = new DocumentEntete();
               var12.setDocNature(15);
               var12.setDocId(((FactureEnteteAchats)var13.get(var11)).getFcfId());
               var12.setDocDate(((FactureEnteteAchats)var13.get(var11)).getFcfDate());
               var12.setDocNum(((FactureEnteteAchats)var13.get(var11)).getFcfNum());
               var12.setDocAnal4(((FactureEnteteAchats)var13.get(var11)).getFcfAnal4());
               var12.setDocSerie(((FactureEnteteAchats)var13.get(var11)).getFcfSerie());
               var12.setDocNomTiers(((FactureEnteteAchats)var13.get(var11)).getFcfNomTiers());
               var12.setDocTotHt(((FactureEnteteAchats)var13.get(var11)).getFcfTotHt());
               var12.setDocTotTva(((FactureEnteteAchats)var13.get(var11)).getFcfTotTva());
               var12.setDocTotTtc(((FactureEnteteAchats)var13.get(var11)).getFcfTotTtc());
               var12.setDocSelect(true);
               this.listDocument.add(var12);
            }
         }
      }

      if (var5) {
         new ArrayList();
         var13 = this.avoirEnteteAchatsDao.rechercheAvoirATransfererCompta(this.optionAchats.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var13.size() != 0) {
            for(var11 = 0; var11 < var13.size(); ++var11) {
               var12 = new DocumentEntete();
               var12.setDocNature(16);
               var12.setDocId(((AvoirEnteteAchats)var13.get(var11)).getAvfId());
               var12.setDocDate(((AvoirEnteteAchats)var13.get(var11)).getAvfDate());
               var12.setDocNum(((AvoirEnteteAchats)var13.get(var11)).getAvfNum());
               var12.setDocAnal4(((AvoirEnteteAchats)var13.get(var11)).getAvfAnal4());
               var12.setDocSerie(((AvoirEnteteAchats)var13.get(var11)).getAvfSerie());
               var12.setDocNomTiers(((AvoirEnteteAchats)var13.get(var11)).getAvfNomTiers());
               var12.setDocTotHt(((AvoirEnteteAchats)var13.get(var11)).getAvfTotHt() * -1.0D);
               var12.setDocTotTva(((AvoirEnteteAchats)var13.get(var11)).getAvfTotTva() * -1.0D);
               var12.setDocTotTtc(((AvoirEnteteAchats)var13.get(var11)).getAvfTotTtc() * -1.0D);
               var12.setDocSelect(true);
               this.listDocument.add(var12);
            }
         }
      }

      if (var6) {
         new ArrayList();
         var13 = this.noteDebitEnteteAchatsDao.rechercheNoteDebitATransfererCompta(this.optionAchats.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var13.size() != 0) {
            for(var11 = 0; var11 < var13.size(); ++var11) {
               var12 = new DocumentEntete();
               var12.setDocNature(17);
               var12.setDocId(((NoteDebitEnteteAchats)var13.get(var11)).getNdfId());
               var12.setDocDate(((NoteDebitEnteteAchats)var13.get(var11)).getNdfDate());
               var12.setDocNum(((NoteDebitEnteteAchats)var13.get(var11)).getNdfNum());
               var12.setDocAnal4(((NoteDebitEnteteAchats)var13.get(var11)).getNdfAnal4());
               var12.setDocSerie(((NoteDebitEnteteAchats)var13.get(var11)).getNdfSerie());
               var12.setDocNomTiers(((NoteDebitEnteteAchats)var13.get(var11)).getNdfNomTiers());
               var12.setDocTotHt(((NoteDebitEnteteAchats)var13.get(var11)).getNdfTotHt());
               var12.setDocTotTva(((NoteDebitEnteteAchats)var13.get(var11)).getNdfTotTva());
               var12.setDocTotTtc(((NoteDebitEnteteAchats)var13.get(var11)).getNdfTotTtc());
               var12.setDocSelect(true);
               this.listDocument.add(var12);
            }
         }
      }

      if (var7) {
         new ArrayList();
         var13 = this.fraisEnteteAchatsDao.rechercheFraisATransfererCompta(this.optionAchats.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var13.size() != 0) {
            for(var11 = 0; var11 < var13.size(); ++var11) {
               var12 = new DocumentEntete();
               var12.setDocNature(18);
               var12.setDocId(((FraisEnteteAchats)var13.get(var11)).getFsfId());
               var12.setDocDate(((FraisEnteteAchats)var13.get(var11)).getFsfDate());
               var12.setDocNum(((FraisEnteteAchats)var13.get(var11)).getFsfNum());
               var12.setDocAnal4(((FraisEnteteAchats)var13.get(var11)).getFsfAnal4());
               var12.setDocSerie(((FraisEnteteAchats)var13.get(var11)).getFsfSerie());
               var12.setDocNomTiers(((FraisEnteteAchats)var13.get(var11)).getFsfNomTiers());
               var12.setDocTotHt(((FraisEnteteAchats)var13.get(var11)).getFsfTotHt());
               var12.setDocTotTva(((FraisEnteteAchats)var13.get(var11)).getFsfTotTva());
               var12.setDocTotTtc(((FraisEnteteAchats)var13.get(var11)).getFsfTotTtc());
               var12.setDocSelect(true);
               this.listDocument.add(var12);
            }
         }
      }

      if (var8 && this.optionAchats.getTrfCompta().equals("1")) {
         new ArrayList();
         var13 = this.valorisationEnteteAchatsDao.rechercheValoATransfererCompta(this.optionAchats.getTransfertDocument(), this.inpPieceDeb, this.inpPieceFin, var2, var3, this.inpDocNonTrf, var1);
         if (var13.size() != 0) {
            for(var11 = 0; var11 < var13.size(); ++var11) {
               if (((ValorisationEnteteAchats)var13.get(var11)).getValFictif() != 1) {
                  var12 = new DocumentEntete();
                  var12.setDocNature(35);
                  var12.setDocId(((ValorisationEnteteAchats)var13.get(var11)).getValId());
                  var12.setDocDate(((ValorisationEnteteAchats)var13.get(var11)).getValDate());
                  if (((ValorisationEnteteAchats)var13.get(var11)).getValFictif() == 2) {
                     var12.setDocNum("Prv:" + ((ValorisationEnteteAchats)var13.get(var11)).getValNum());
                     var12.setDocAnal4("Prv:" + ((ValorisationEnteteAchats)var13.get(var11)).getValDossierTransit());
                  } else {
                     var12.setDocNum(((ValorisationEnteteAchats)var13.get(var11)).getValNum());
                     var12.setDocAnal4(((ValorisationEnteteAchats)var13.get(var11)).getValDossierTransit());
                  }

                  var12.setDocSerie(((ValorisationEnteteAchats)var13.get(var11)).getValSerie());
                  var12.setDocNomTiers("");
                  var12.setDocTotHt(((ValorisationEnteteAchats)var13.get(var11)).getValPr1());
                  var12.setDocTotTva(0.0D);
                  var12.setDocTotTtc(((ValorisationEnteteAchats)var13.get(var11)).getValPr1());
                  var12.setDocSelect(true);
                  this.listDocument.add(var12);
               }
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

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public List getListDocument() {
      return this.listDocument;
   }

   public void setListDocument(List var1) {
      this.listDocument = var1;
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

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
