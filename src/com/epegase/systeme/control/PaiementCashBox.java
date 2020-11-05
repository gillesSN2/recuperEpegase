package com.epegase.systeme.control;

import com.epegase.forms.accueil.FormEspaceClient;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaiementCashBox extends HttpServlet implements Serializable {
   private String basePlanetePegase = "structure1";
   private UtilInitHibernate utilInitHibernate = new UtilInitHibernate();
   private FactureEnteteVentes factureEnteteVentes = new FactureEnteteVentes();
   private List lesFacturesEntete = new ArrayList();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private NoteDebitEnteteVentes noteDebitEnteteVentes;
   private List lesNoteDebitEntete;
   private NoteDebitEnteteVentesDao noteDebitEnteteVentesDao;
   private Reglements reglements;
   private ReglementsDao reglementsDao;
   private ExercicesCaisseDao exercicesCaisseDao;
   private ExercicesCaisse exercicesCaisse;
   private UtilDate utilDate;
   private CalculChrono calculChrono;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;

   public PaiementCashBox() {
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.basePlanetePegase, this.utilInitHibernate);
      this.noteDebitEnteteVentes = new NoteDebitEnteteVentes();
      this.lesNoteDebitEntete = new ArrayList();
      this.noteDebitEnteteVentesDao = new NoteDebitEnteteVentesDao(this.basePlanetePegase, this.utilInitHibernate);
      this.reglements = new Reglements();
      this.reglementsDao = new ReglementsDao(this.basePlanetePegase, this.utilInitHibernate);
      this.exercicesCaisseDao = new ExercicesCaisseDao(this.basePlanetePegase, this.utilInitHibernate);
      this.exercicesCaisse = new ExercicesCaisse();
      this.utilDate = new UtilDate();
      this.calculChrono = new CalculChrono(this.basePlanetePegase, this.utilInitHibernate);
      this.caissesCommerciales = new CaissesCommerciales();
      this.caissesCommercialesDao = new CaissesCommercialesDao(this.basePlanetePegase, this.utilInitHibernate);
   }

   public void init() {
   }

   protected void processRequest(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      try {
         this.paiementCashBox();
      } catch (HibernateException var4) {
         Logger.getLogger(PaiementCashBox.class.getName()).log(Level.SEVERE, (String)null, var4);
      } catch (NamingException var5) {
         Logger.getLogger(PaiementCashBox.class.getName()).log(Level.SEVERE, (String)null, var5);
      }

      var2.setContentType("text/html;charset=UTF-8");
      PrintWriter var3 = var2.getWriter();
      var3.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
      var3.println("<HTML>");
      var3.println("  <HEAD><TITLE>Contrôle d'accès ePegase</TITLE></HEAD>");
      var3.println("  <BODY>");
      var3.println("  <BR />Cliquez ici .");
      var3.println("  <A HREF='/epegase/'>pour vous reconnecter à la plateforme ePegase</A>");
      var3.println("  </BODY>");
      var3.println("</HTML>");
      var3.flush();
      var3.close();
   }

   protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      this.processRequest(var1, var2);
   }

   protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      this.processRequest(var1, var2);
   }

   public String getServletInfo() {
      return "Short description";
   }

   public void paiementCashBox() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getLoginPlanetePegase();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.exercicesCaisse = this.exercicesCaisseDao.recupererLastExo(var1);
         if (this.exercicesCaisse != null) {
            this.caissesCommerciales = this.caissesCommercialesDao.chercheCaisseTpe(this.exercicesCaisse.getExecaiId(), var1);
            if (this.caissesCommerciales != null) {
               int var3;
               if (FormEspaceClient.getLesFacturesEntete().size() != 0) {
                  for(var3 = 0; var3 < FormEspaceClient.getLesFacturesEntete().size(); ++var3) {
                     this.factureEnteteVentes = (FactureEnteteVentes)FormEspaceClient.getLesFacturesEntete().get(var3);
                     if (this.factureEnteteVentes.isVar_select_ligne()) {
                        this.generationReglementFacture(var1);
                        this.factureEnteteVentes.setFacTotReglement(this.factureEnteteVentes.getFacTotTtc());
                        this.factureEnteteVentes.setFacSolde(1);
                        this.factureEnteteVentes = this.factureEnteteVentesDao.modif(this.factureEnteteVentes, var1);
                     }
                  }
               }

               if (FormEspaceClient.getLesNoteDebitEntete().size() != 0) {
                  for(var3 = 0; var3 < FormEspaceClient.getLesNoteDebitEntete().size(); ++var3) {
                     this.noteDebitEnteteVentes = (NoteDebitEnteteVentes)FormEspaceClient.getLesNoteDebitEntete().get(var3);
                     if (this.noteDebitEnteteVentes.isVar_select_ligne()) {
                        this.generationReglementNoteDebit(var1);
                        this.noteDebitEnteteVentes.setNdbTotReglement(this.noteDebitEnteteVentes.getNdbTotTtc());
                        this.noteDebitEnteteVentes.setNdbSolde(1);
                        this.noteDebitEnteteVentes = this.noteDebitEnteteVentesDao.modif(this.noteDebitEnteteVentes, var1);
                     }
                  }
               }

               var2.commit();
            }
         }
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void generationReglementFacture(Session var1) throws HibernateException, NamingException {
      String var2 = this.calculChrono.numCompose(new Date(), 61, this.factureEnteteVentes.getFacSerie(), var1);
      this.reglements = new Reglements();
      this.reglements.setRglActivite("");
      this.reglements.setRglB1(0);
      this.reglements.setRglB2(0);
      this.reglements.setRglB3(0);
      this.reglements.setRglB4(0);
      this.reglements.setRglB5(0);
      this.reglements.setRglB6(0);
      this.reglements.setRglB7(0);
      this.reglements.setRglB8(0);
      this.reglements.setRglB9(0);
      this.reglements.setRglB10(0);
      this.reglements.setRglBanqueMvt2("");
      this.reglements.setRglBanqueTireur("");
      this.reglements.setRglBon(FormEspaceClient.getResult());
      this.reglements.setRglBudget("");
      this.reglements.setRglCaisseMvt1("");
      this.reglements.setRglCategorie(20);
      this.reglements.setRglCle1Repartition("");
      this.reglements.setRglCle2Repartition("");
      this.reglements.setRglCodeBudgetTreso("");
      this.reglements.setRglCodeCaiss(this.caissesCommerciales.getCaiCode());
      this.reglements.setRglCodeEmetrice("");
      this.reglements.setRglCodePosteTreso("");
      this.reglements.setRglCodeReceptrice("");
      this.reglements.setRglCommission(0.0D);
      this.reglements.setRglDateCloture((Date)null);
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateExecBc((Date)null);
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateModif((Date)null);
      this.reglements.setRglDateMvt1((Date)null);
      this.reglements.setRglDateMvt2((Date)null);
      this.reglements.setRglDateReg(new Date());
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDepartement("");
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglDevise(this.factureEnteteVentes.getFacDevise());
      this.reglements.setRglDocument(this.factureEnteteVentes.getFacNum());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglFrais(0.0D);
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdCaissier(FormEspaceClient.getIdUser());
      this.reglements.setRglIdCommercial(this.factureEnteteVentes.getFacIdCommercial());
      this.reglements.setRglIdContact(this.factureEnteteVentes.getFacIdContact());
      this.reglements.setRglIdDocument(this.factureEnteteVentes.getFacId());
      this.reglements.setRglIdEquipe(this.factureEnteteVentes.getFacIdEquipe());
      this.reglements.setRglIdResponsable(this.factureEnteteVentes.getFacIdResponsable());
      this.reglements.setRglIdTiers(this.factureEnteteVentes.getTiers().getTieid());
      this.reglements.setRglImp(0);
      this.reglements.setRglLibCaiss(this.caissesCommerciales.getCaiNom());
      this.reglements.setRglLibEmetrice("");
      this.reglements.setRglLibReceptrice("");
      this.reglements.setRglLibelle("Reg. Facture N° " + this.factureEnteteVentes.getFacNum());
      this.reglements.setRglMode("4");
      this.reglements.setRglModele("recuTpe");
      this.reglements.setRglNatureDoc(25);
      this.reglements.setRglNomCaissier(FormEspaceClient.getNomUser());
      this.reglements.setRglNomCommercial(this.factureEnteteVentes.getFacNomCommercial());
      this.reglements.setRglNomContact(this.factureEnteteVentes.getFacNomCommercial());
      this.reglements.setRglNomEquipe(this.factureEnteteVentes.getFacNomEquipe());
      this.reglements.setRglNomResponsable(this.factureEnteteVentes.getFacNomResponsable());
      this.reglements.setRglNomTiers(this.factureEnteteVentes.getTiers().getTieraisonsocialenom());
      this.reglements.setRglNum(var2);
      this.reglements.setRglNumChqBdx(FormEspaceClient.getResult());
      this.reglements.setRglNumMvt1("");
      this.reglements.setRglNumMvt2("");
      this.reglements.setRglNumTrf("");
      this.reglements.setRglObjet("");
      this.reglements.setRglOperation("01");
      this.reglements.setRglP1(0);
      this.reglements.setRglP2(0);
      this.reglements.setRglP3(0);
      this.reglements.setRglP4(0);
      this.reglements.setRglP5(0);
      this.reglements.setRglP6(0);
      this.reglements.setRglP7(0);
      this.reglements.setRglP8(0);
      this.reglements.setRglP9(0);
      this.reglements.setRglP10(0);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv("");
      this.reglements.setRglRecette(this.factureEnteteVentes.getFacTotTtc());
      this.reglements.setRglRegion("");
      this.reglements.setRglSecteur("");
      this.reglements.setRglSerie(this.factureEnteteVentes.getFacSerie());
      this.reglements.setRglService("");
      this.reglements.setRglSite("");
      this.reglements.setRglTimbre(0.0D);
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeReg(4);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglUserCreat(FormEspaceClient.getIdUser());
      this.reglements.setRglUserModif(0L);
      String var3 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var3 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var3 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var4 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var3 + ":" + var4);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var5 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var5);
      this.reglements.setExercicesCaisse(this.exercicesCaisse);
      this.reglements = this.reglementsDao.insert(this.reglements, var1);
   }

   public void generationReglementNoteDebit(Session var1) throws HibernateException, NamingException {
      String var2 = this.calculChrono.numCompose(new Date(), 61, this.noteDebitEnteteVentes.getNdbSerie(), var1);
      this.reglements = new Reglements();
      this.reglements.setRglActivite("");
      this.reglements.setRglB1(0);
      this.reglements.setRglB2(0);
      this.reglements.setRglB3(0);
      this.reglements.setRglB4(0);
      this.reglements.setRglB5(0);
      this.reglements.setRglB6(0);
      this.reglements.setRglB7(0);
      this.reglements.setRglB8(0);
      this.reglements.setRglB9(0);
      this.reglements.setRglB10(0);
      this.reglements.setRglBanqueMvt2("");
      this.reglements.setRglBanqueTireur("");
      this.reglements.setRglBon(FormEspaceClient.getResult());
      this.reglements.setRglBudget("");
      this.reglements.setRglCaisseMvt1("");
      this.reglements.setRglCategorie(20);
      this.reglements.setRglCle1Repartition("");
      this.reglements.setRglCle2Repartition("");
      this.reglements.setRglCodeBudgetTreso("");
      this.reglements.setRglCodeCaiss(this.caissesCommerciales.getCaiCode());
      this.reglements.setRglCodeEmetrice("");
      this.reglements.setRglCodePosteTreso("");
      this.reglements.setRglCodeReceptrice("");
      this.reglements.setRglCommission(0.0D);
      this.reglements.setRglDateCloture((Date)null);
      this.reglements.setRglDateCreation(new Date());
      this.reglements.setRglDateExecBc((Date)null);
      this.reglements.setRglDateImp((Date)null);
      this.reglements.setRglDateModif((Date)null);
      this.reglements.setRglDateMvt1((Date)null);
      this.reglements.setRglDateMvt2((Date)null);
      this.reglements.setRglDateReg(new Date());
      this.reglements.setRglDateTransfert((Date)null);
      this.reglements.setRglDateValeur((Date)null);
      this.reglements.setRglDepartement("");
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglDevise(this.noteDebitEnteteVentes.getNdbDevise());
      this.reglements.setRglDocument(this.noteDebitEnteteVentes.getNdbNum());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglFrais(0.0D);
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdCaissier(FormEspaceClient.getIdUser());
      this.reglements.setRglIdCommercial(this.noteDebitEnteteVentes.getNdbIdCommercial());
      this.reglements.setRglIdContact(this.noteDebitEnteteVentes.getNdbIdContact());
      this.reglements.setRglIdDocument(this.noteDebitEnteteVentes.getNdbId());
      this.reglements.setRglIdEquipe(this.noteDebitEnteteVentes.getNdbIdEquipe());
      this.reglements.setRglIdResponsable(this.noteDebitEnteteVentes.getNdbIdResponsable());
      this.reglements.setRglIdTiers(this.noteDebitEnteteVentes.getTiers().getTieid());
      this.reglements.setRglImp(0);
      this.reglements.setRglLibCaiss(this.caissesCommerciales.getCaiNom());
      this.reglements.setRglLibEmetrice("");
      this.reglements.setRglLibReceptrice("");
      this.reglements.setRglLibelle("Reg. Note debit N° " + this.noteDebitEnteteVentes.getNdbNum());
      this.reglements.setRglMode("4");
      this.reglements.setRglModele("recuTpe");
      this.reglements.setRglNatureDoc(27);
      this.reglements.setRglNomCaissier(FormEspaceClient.getNomUser());
      this.reglements.setRglNomCommercial(this.noteDebitEnteteVentes.getNdbNomCommercial());
      this.reglements.setRglNomContact(this.noteDebitEnteteVentes.getNdbNomCommercial());
      this.reglements.setRglNomEquipe(this.noteDebitEnteteVentes.getNdbNomEquipe());
      this.reglements.setRglNomResponsable(this.noteDebitEnteteVentes.getNdbNomResponsable());
      this.reglements.setRglNomTiers(this.noteDebitEnteteVentes.getTiers().getTieraisonsocialenom());
      this.reglements.setRglNum(var2);
      this.reglements.setRglNumChqBdx(FormEspaceClient.getResult());
      this.reglements.setRglNumMvt1("");
      this.reglements.setRglNumMvt2("");
      this.reglements.setRglNumTrf("");
      this.reglements.setRglObjet("");
      this.reglements.setRglOperation("01");
      this.reglements.setRglP1(0);
      this.reglements.setRglP2(0);
      this.reglements.setRglP3(0);
      this.reglements.setRglP4(0);
      this.reglements.setRglP5(0);
      this.reglements.setRglP6(0);
      this.reglements.setRglP7(0);
      this.reglements.setRglP8(0);
      this.reglements.setRglP9(0);
      this.reglements.setRglP10(0);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv("");
      this.reglements.setRglRecette(this.noteDebitEnteteVentes.getNdbTotTtc());
      this.reglements.setRglRegion("");
      this.reglements.setRglSecteur("");
      this.reglements.setRglSerie(this.noteDebitEnteteVentes.getNdbSerie());
      this.reglements.setRglService("");
      this.reglements.setRglSite("");
      this.reglements.setRglTimbre(0.0D);
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeReg(4);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglUserCreat(FormEspaceClient.getIdUser());
      this.reglements.setRglUserModif(0L);
      String var3 = "";
      if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
         var3 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
      } else {
         var3 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
      }

      String var4 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
      this.reglements.setRglPeriode(var3 + ":" + var4);
      this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
      String var5 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
      this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var5);
      this.reglements.setExercicesCaisse(this.exercicesCaisse);
      this.reglements = this.reglementsDao.insert(this.reglements, var1);
   }

   public int calculformatDevise(String var1) {
      byte var2 = 0;
      if (!var1.equals("XAF") && !var1.equals("XOF")) {
         if (var1.equals("EUR") || var1.equals("CHF")) {
            var2 = 1;
         }
      } else {
         var2 = 2;
      }

      return var2;
   }
}
