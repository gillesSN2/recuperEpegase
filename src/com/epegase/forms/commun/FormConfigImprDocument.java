package com.epegase.forms.commun;

import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.Loyer;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.TransfertCompta;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilFtp;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.jdom.JDOMException;

public class FormConfigImprDocument implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String codePays;
   private String codeModule;
   private String var_acces_rapport;
   private String var_acces_rapport_ligne;
   private String var_acces_sous_rapport;
   private String var_nom_ecran;
   private String pageIndex;
   private List listRepertoires = new ArrayList();
   private transient DataModel dataModelRepertoire = new ListDataModel();
   private UtilDownload utilDownload = new UtilDownload();
   private boolean showModalPanelRenameRapport = false;
   private boolean showModalPanelRenameSousRapport = false;
   private String ancienNom;
   private String nouveauNom;
   private String var_nom_repertoire;
   private boolean var_repertoire_selectionne = false;
   private UploadedFile uploadedFileRapport;
   private List listRapport = new ArrayList();
   private transient DataModel dataModelRapport = new ListDataModel();
   private String var_nom_rapport;
   private boolean var_rapport_visible = false;
   private UploadedFile uploadedFileSousRapport;
   private List listSousRapport = new ArrayList();
   private transient DataModel dataModelSousRapport = new ListDataModel();
   private String var_nom_sousRapport;
   private boolean var_sousRapport_visible = false;
   private String format;
   private UtilPrint utilPrint;
   private UtilFtp utilFtp = new UtilFtp();
   private transient DataModel dataModelModeleRapport = new ListDataModel();
   private transient DataModel dataModelModeleSousRapport = new ListDataModel();
   private List lesModelesRapports = new ArrayList();
   private List lesModelesSousRapports = new ArrayList();
   private String var_acces_modeleRapport;
   private String var_acces_modeleRapport_ligne;
   private String var_acces_modeleSous_rapport;
   private boolean var_rapportModele_visible = false;
   private boolean var_sousRapportModele_visible = false;
   private String var_nom_rapportModele;
   private String var_nom_sousRapportModele;

   public void chargerLesRepertoires() {
      this.listRepertoires.clear();
      File var1 = new File(this.var_acces_rapport);
      String[] var2 = var1.list();
      int var3;
      String var4;
      if (var2 != null) {
         var2 = this.triAlphabetique(var2, var2.length);

         for(var3 = 0; var3 < var2.length; ++var3) {
            var4 = var2[var3].toUpperCase();
            if (!var4.equalsIgnoreCase(".SVN")) {
               this.listRepertoires.add(var4);
            }
         }
      }

      if (this.var_acces_rapport_ligne != null && !this.var_acces_rapport_ligne.isEmpty()) {
         var1 = new File(this.var_acces_rapport_ligne);
         var2 = var1.list();
         if (var2 != null) {
            var2 = this.triAlphabetique(var2, var2.length);

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3].toUpperCase();
               if (!var4.equalsIgnoreCase(".SVN")) {
                  this.listRepertoires.add(var4);
               }
            }
         }
      }

      this.dataModelRepertoire.setWrappedData(this.listRepertoires);
   }

   public void chargerLesRepertoires(String var1) {
      this.listRepertoires.clear();
      File var2 = new File(this.var_acces_rapport);
      String[] var3 = var2.list();
      int var4;
      String var5;
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(var4 = 0; var4 < var3.length; ++var4) {
            var5 = var3[var4].toUpperCase();
            if (!var5.equalsIgnoreCase(".SVN") && var1.toUpperCase().contains(var5)) {
               this.listRepertoires.add(var5);
            }
         }
      }

      if (this.var_acces_rapport_ligne != null && !this.var_acces_rapport_ligne.isEmpty()) {
         var2 = new File(this.var_acces_rapport_ligne);
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               var5 = var3[var4].toUpperCase();
               if (!var5.equalsIgnoreCase(".SVN")) {
                  this.listRepertoires.add(var5);
               }
            }
         }
      }

      this.dataModelRepertoire.setWrappedData(this.listRepertoires);
   }

   public void chargerSousRapport() throws SocketException, IOException {
      this.listSousRapport.clear();
      String var1 = this.var_acces_sous_rapport + File.separator;
      File var2 = new File(var1);
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.listSousRapport.add(var5);
            }
         }
      }

      this.dataModelSousRapport.setWrappedData(this.listSousRapport);
   }

   public void selectionRepertoire() throws MalformedURLException, IOException, URISyntaxException {
      if (this.dataModelRepertoire.isRowAvailable()) {
         this.var_nom_repertoire = (String)this.dataModelRepertoire.getRowData();
         this.var_rapport_visible = false;
         this.var_repertoire_selectionne = true;
         this.var_sousRapport_visible = false;
         this.listeRapport();
         if (StaticModePegase.getInternet_actif() >= 1) {
            this.listeRapportModele();
            if (this.lesModelesSousRapports.size() == 0) {
               this.listeSousRapportModele();
            }
         }
      }

   }

   public void listeRapport() {
      this.listRapport = new ArrayList();
      File var1 = null;
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         var1 = new File(this.var_acces_rapport_ligne + File.separator + this.var_nom_repertoire.toLowerCase());
      } else {
         var1 = new File(this.var_acces_rapport + File.separator + this.var_nom_repertoire.toLowerCase());
      }

      String[] var2 = var1.list();
      if (var2 != null) {
         var2 = this.triAlphabetique(var2, var2.length);

         for(int var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3].endsWith("jasper")) {
               String var4 = var2[var3].substring(0, var2[var3].indexOf("."));
               this.listRapport.add(var4);
            }
         }
      }

      this.dataModelRapport.setWrappedData(this.listRapport);
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

   public void selectionRapport() {
      if (this.dataModelRapport.isRowAvailable()) {
         this.var_nom_rapport = (String)this.dataModelRapport.getRowData();
         this.var_rapport_visible = true;
         this.var_sousRapport_visible = false;
         this.var_rapportModele_visible = false;
         this.var_sousRapportModele_visible = false;
      }

   }

   public void selectionRapportModele() {
      if (this.dataModelModeleRapport.isRowAvailable()) {
         this.var_nom_rapportModele = (String)this.dataModelModeleRapport.getRowData();
         this.var_rapport_visible = false;
         this.var_sousRapport_visible = false;
         this.var_rapportModele_visible = true;
         this.var_sousRapportModele_visible = false;
      }

   }

   public void envoyerRapport() throws IOException, JDOMException {
      if (this.uploadedFileRapport != null) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            String var2 = this.utilDownload.trimFilePath(this.uploadedFileRapport.getName());
            File var3 = null;
            if (this.var_nom_repertoire.contains("LIGNE_")) {
               var3 = this.utilDownload.uniqueFile(new File(this.var_acces_rapport_ligne + File.separator + this.var_nom_repertoire.toLowerCase()), var2);
            } else {
               var3 = this.utilDownload.uniqueFile(new File(this.var_acces_rapport + File.separator + this.var_nom_repertoire.toLowerCase()), var2);
            }

            String var4 = var3.getName();
            if (var4.endsWith("jasper")) {
               this.utilDownload.write(var3, this.uploadedFileRapport.getInputStream());
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.listeRapport();
            } else {
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Impossible de uploader ce fichier", (String)null));
            }
         } catch (IOException var5) {
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
         }
      }

   }

   public void copierRapport() throws MalformedURLException, IOException, ServletException {
      FacesContext var1 = FacesContext.getCurrentInstance();
      ExternalContext var2 = var1.getExternalContext();
      HttpServletResponse var3 = (HttpServletResponse)var2.getResponse();
      var3.reset();
      var3.setContentType("application/txt");
      var3.setHeader("Content-Disposition", "filename=" + this.var_nom_rapport + ".jasper");
      var3.setHeader("Content-Transfer-Encoding", "binary");
      File var4 = null;
      BufferedInputStream var5 = null;
      String var6 = "";
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         var6 = this.var_acces_rapport_ligne + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapport + ".jasper";
      } else {
         var6 = this.var_acces_rapport + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapport + ".jasper";
      }

      try {
         var4 = new File(var6);
         int var7 = 65536;
         long var8 = System.currentTimeMillis();

         try {
            var5 = new BufferedInputStream(new FileInputStream(var4), var7 * 2);
            byte[] var10 = new byte[var7];
            ServletOutputStream var11 = var3.getOutputStream();
            int var12 = 0;

            while(true) {
               int var13 = var5.read(var10);
               if (var13 < 0) {
                  var11.flush();
                  break;
               }

               var11.write(var10, 0, var13);
               ++var12;
            }
         } finally {
            var5.close();
         }

         var8 = (System.currentTimeMillis() - var8) / 1000L;
         double var25 = (double)var4.length() * 1.0D / 1024.0D;
      } catch (Exception var23) {
         System.out.println("***************************erreur telechargement : " + var23.toString());
      } finally {
         var1.responseComplete();
      }

   }

   public void renommerRapport() {
      if (this.var_nom_rapport != null && !this.var_nom_rapport.isEmpty()) {
         this.ancienNom = this.var_nom_rapport;
         this.nouveauNom = "";
         this.showModalPanelRenameRapport = true;
      }

   }

   public void fermerRenommerRapport() {
      this.showModalPanelRenameRapport = false;
   }

   public void validerRenommerRapport() {
      this.showModalPanelRenameRapport = false;
   }

   public void supprimerRapport() {
      String var1 = "";
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         var1 = this.var_acces_rapport_ligne + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapport + ".jasper";
      } else {
         var1 = this.var_acces_rapport + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapport + ".jasper";
      }

      File var2 = new File(var1);
      var2.delete();
      this.listeRapport();
   }

   public void listeRapportModele() throws MalformedURLException, IOException, URISyntaxException {
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         this.var_acces_modeleRapport_ligne = File.separator + "fr_" + this.codePays + File.separator + this.codeModule.replace("client", "produits") + File.separator + this.var_nom_repertoire.toLowerCase();
      } else {
         this.var_acces_modeleRapport = File.separator + "fr_" + this.codePays + File.separator + this.codeModule + File.separator + this.var_nom_repertoire.toLowerCase();
      }

      this.lesModelesRapports = this.utilFtp.listeFichierDepuisHorus(this.var_acces_modeleRapport);
      this.dataModelModeleRapport.setWrappedData(this.lesModelesRapports);
   }

   public void envoyerRapportversHorus() throws MalformedURLException, IOException, URISyntaxException {
      String var1 = "";
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         var1 = this.var_acces_rapport_ligne + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapport + ".jasper";
      } else {
         var1 = this.var_acces_rapport + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapport + ".jasper";
      }

      if (this.var_nom_repertoire.contains("LIGNE_")) {
         this.var_acces_modeleRapport_ligne = File.separator + "fr_" + this.codePays + File.separator + this.codeModule.replace("client", "produits") + File.separator + this.var_nom_repertoire.toLowerCase();
      } else {
         this.var_acces_modeleRapport = File.separator + "fr_" + this.codePays + File.separator + this.codeModule + File.separator + this.var_nom_repertoire.toLowerCase();
      }

      String var2 = "";
      var2 = this.utilFtp.copierFichierVersHorus(var1, this.var_acces_modeleRapport, this.var_nom_rapport + ".jasper");
      if (var2 == null || var2.isEmpty()) {
         this.listeRapportModele();
      }

   }

   public void copierRapportdepuisHorus() throws IOException {
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         this.var_acces_modeleRapport_ligne = File.separator + "fr_" + this.codePays + File.separator + this.codeModule.replace("client", "produits") + File.separator + this.var_nom_repertoire.toLowerCase();
      } else {
         this.var_acces_modeleRapport = File.separator + "fr_" + this.codePays + File.separator + this.codeModule + File.separator + this.var_nom_repertoire.toLowerCase();
      }

      String var1 = "";
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         var1 = this.var_acces_rapport_ligne + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapportModele + ".jasper";
      } else {
         var1 = this.var_acces_rapport + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_rapportModele + ".jasper";
      }

      String var2 = "";
      String var3 = File.separator + "opt" + File.separator + "download" + File.separator + "bibliotheque" + this.var_acces_modeleRapport;
      var2 = this.utilFtp.copierFichierDepuisHorus(var1, this.var_nom_rapportModele + ".jasper", var3);
      if (var2 == null || var2.isEmpty()) {
         this.listeRapport();
      }

   }

   public void visualiserRapportdepuisHorus() throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      JRBeanCollectionDataSource var1 = null;
      ArrayList var2;
      Amortissements var3;
      if (this.var_nom_repertoire.equalsIgnoreCase("amortissement")) {
         var2 = new ArrayList();
         var3 = new Amortissements();
         var2.add(var3);
         var1 = new JRBeanCollectionDataSource(var2);
      } else if (this.var_nom_repertoire.equalsIgnoreCase("budget")) {
         var2 = new ArrayList();
         Budget var7 = new Budget();
         var2.add(var7);
         var1 = new JRBeanCollectionDataSource(var2);
      } else if (this.var_nom_repertoire.equalsIgnoreCase("loyer")) {
         var2 = new ArrayList();
         Loyer var8 = new Loyer();
         var2.add(var8);
         var1 = new JRBeanCollectionDataSource(var2);
      } else if (this.var_nom_repertoire.equalsIgnoreCase("tableaux")) {
         var2 = new ArrayList();
         var3 = new Amortissements();
         var2.add(var3);
         var1 = new JRBeanCollectionDataSource(var2);
      } else if (this.var_nom_repertoire.equalsIgnoreCase("transfert")) {
         var2 = new ArrayList();
         TransfertCompta var10 = new TransfertCompta();
         var2.add(var10);
         var1 = new JRBeanCollectionDataSource(var2);
      } else {
         var2 = new ArrayList();
         Ecritures var11 = new Ecritures();
         var2.add(var11);
         var1 = new JRBeanCollectionDataSource(var2);
      }

      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.setEntete("Prévisuel Test");
      this.utilPrint.setFiltre(this.var_nom_rapportModele);
      this.utilPrint.setRapportEncapsule((String)null);
      if (this.var_nom_repertoire.contains("LIGNE_")) {
         this.var_acces_modeleRapport_ligne = File.separator + "fr_" + this.codePays + File.separator + this.codeModule.replace("client", "produits") + File.separator + this.var_nom_repertoire.toLowerCase();
         this.utilPrint.setCheminRapport(this.var_acces_modeleRapport_ligne);
      } else {
         this.var_acces_modeleRapport = File.separator + "fr_" + this.codePays + File.separator + this.codeModule + File.separator + this.var_nom_repertoire.toLowerCase();
         this.utilPrint.setCheminRapport(this.var_acces_modeleRapport);
      }

      String var9 = "";
      File var12 = File.createTempFile(this.var_nom_rapportModele, ".jasper");
      String var4 = var12.toString();
      String var5 = File.separator + "opt" + File.separator + "download" + File.separator + "bibliotheque" + this.var_acces_modeleRapport;
      var9 = this.utilFtp.copierFichierDepuisHorus(var4, this.var_nom_rapportModele + ".jasper", var5);
      File var6;
      if (var9 != null && !var9.isEmpty()) {
         var6 = new File(var4);
         var6.delete();
      } else {
         this.utilPrint.setCheminRapport("/tmp/");
         this.utilPrint.setRapport(var4.replace("/tmp/", "").replace(".jasper", ""));
         this.utilPrint.setCheminSousrapport("/tmp/");
         this.utilPrint.setImageFondPage((String)null);
         this.utilPrint.setFormat("JRV");
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setIdCommercial(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setContact((Contacts)null);
         this.utilPrint.setNumDoc("");
         this.utilPrint.setNature(0);
         this.utilPrint.setId_doc(0L);
         this.utilPrint.setParc((Parc)null);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
         var6 = new File(var4);
         var6.delete();
      }

   }

   public void selectionSousRapport() {
      if (this.dataModelSousRapport.isRowAvailable()) {
         this.var_nom_sousRapport = (String)this.dataModelSousRapport.getRowData();
         this.var_rapport_visible = false;
         this.var_sousRapport_visible = true;
         this.var_rapportModele_visible = false;
         this.var_sousRapportModele_visible = false;
      }

   }

   public void selectionSousRapportModele() {
      if (this.dataModelModeleSousRapport.isRowAvailable()) {
         this.var_nom_sousRapportModele = (String)this.dataModelModeleSousRapport.getRowData();
         this.var_rapport_visible = false;
         this.var_sousRapport_visible = false;
         this.var_rapportModele_visible = false;
         this.var_sousRapportModele_visible = true;
      }

   }

   public void envoyerSousRapport() throws IOException, JDOMException {
      if (this.uploadedFileSousRapport != null) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            String var2 = this.utilDownload.trimFilePath(this.uploadedFileSousRapport.getName());
            File var3 = this.utilDownload.uniqueFile(new File(this.var_acces_sous_rapport), var2);
            String var4 = var3.getName();
            if (var4.endsWith("jasper")) {
               this.utilDownload.write(var3, this.uploadedFileSousRapport.getInputStream());
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.chargerSousRapport();
            } else {
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "Impossible de uploader ce fichier", (String)null));
            }
         } catch (IOException var5) {
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var5.printStackTrace();
         }
      }

   }

   public void copierSousRapport() throws IOException {
      FacesContext var1 = FacesContext.getCurrentInstance();
      ExternalContext var2 = var1.getExternalContext();
      HttpServletResponse var3 = (HttpServletResponse)var2.getResponse();
      var3.reset();
      var3.setContentType("application/txt");
      var3.setHeader("Content-Disposition", "filename=" + this.var_nom_sousRapport + ".jasper");
      var3.setHeader("Content-Transfer-Encoding", "binary");
      File var4 = null;
      BufferedInputStream var5 = null;
      String var6 = this.var_acces_sous_rapport + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_sousRapport + ".jasper";

      try {
         var4 = new File(var6);
         int var7 = 65536;
         long var8 = System.currentTimeMillis();

         try {
            var5 = new BufferedInputStream(new FileInputStream(var4), var7 * 2);
            byte[] var10 = new byte[var7];
            ServletOutputStream var11 = var3.getOutputStream();
            int var12 = 0;

            while(true) {
               int var13 = var5.read(var10);
               if (var13 < 0) {
                  var11.flush();
                  break;
               }

               var11.write(var10, 0, var13);
               ++var12;
            }
         } finally {
            var5.close();
         }

         var8 = (System.currentTimeMillis() - var8) / 1000L;
         double var25 = (double)var4.length() * 1.0D / 1024.0D;
      } catch (Exception var23) {
         System.out.println("***************************erreur telechargement : " + var23.toString());
      } finally {
         var1.responseComplete();
      }

   }

   public void renommerSousRapport() {
      if (this.var_nom_sousRapport != null && !this.var_nom_sousRapport.isEmpty()) {
         this.ancienNom = this.var_nom_sousRapport;
         this.nouveauNom = "";
         this.showModalPanelRenameSousRapport = true;
      }

   }

   public void fermerRenommeSousrRapport() {
      this.showModalPanelRenameSousRapport = false;
   }

   public void validerRenommerSousRapport() {
      this.showModalPanelRenameSousRapport = false;
   }

   public void supprimerSousRapport() throws SocketException, IOException {
      String var1 = this.var_acces_sous_rapport + File.separator + this.var_nom_sousRapport + ".jasper";
      File var2 = new File(var1);
      var2.delete();
      this.chargerSousRapport();
   }

   public void listeSousRapportModele() throws SocketException, IOException {
      if (this.codeModule != null && !this.codeModule.isEmpty()) {
         String var1 = "";
         if (this.codeModule.contains("client")) {
            var1 = this.codeModule.replace("client", "sous_rapport");
         } else if (this.codeModule.contains("document")) {
            var1 = this.codeModule.replace("document", "sous_rapport");
         } else if (this.codeModule.contains("liste")) {
            var1 = this.codeModule.replace("liste", "sous_rapport");
         } else if (this.codeModule.equalsIgnoreCase("compta")) {
            var1 = this.codeModule + File.separator + "sous_rapport";
         } else {
            var1 = "sous_rapport";
         }

         this.var_acces_modeleSous_rapport = File.separator + "fr_" + this.codePays + File.separator + var1;
         this.lesModelesSousRapports = this.utilFtp.listeFichierDepuisHorus(this.var_acces_modeleSous_rapport);
      } else {
         this.lesModelesSousRapports.clear();
      }

      this.dataModelModeleSousRapport.setWrappedData(this.lesModelesSousRapports);
   }

   public void envoyerSousRapportversHorus() {
      String var1 = this.var_acces_sous_rapport + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_nom_sousRapport + ".jasper";
      this.var_acces_modeleSous_rapport = File.separator + "fr_" + this.codePays + File.separator + this.codeModule + File.separator + this.var_nom_repertoire.toLowerCase();
      String var2 = "";
      var2 = this.utilFtp.copierFichierVersHorus(var1, this.var_acces_modeleSous_rapport, this.var_nom_sousRapport + ".jasper");
      if (var2 == null || var2.isEmpty()) {
         this.lesModelesSousRapports.add(this.var_nom_sousRapport);
         this.dataModelModeleSousRapport.setWrappedData(this.lesModelesSousRapports);
      }

   }

   public void copierSousRapportdepuisHorus() throws IOException {
      this.var_acces_modeleSous_rapport = File.separator + "fr_" + this.codePays + File.separator + this.codeModule + File.separator + this.var_nom_repertoire.toLowerCase();
      String var1 = this.var_acces_sous_rapport + File.separator + this.var_nom_repertoire.toLowerCase() + File.separator + this.var_acces_modeleSous_rapport + ".jasper";
      String var2 = "epegase" + File.separator + "bibliotheque" + this.var_acces_modeleSous_rapport;
      this.utilDownload.downloadFile(var2, this.var_acces_modeleSous_rapport + ".jasper", var1);
      this.chargerSousRapport();
   }

   public DataModel getDataModelRapport() {
      return this.dataModelRapport;
   }

   public void setDataModelRapport(DataModel var1) {
      this.dataModelRapport = var1;
   }

   public DataModel getDataModelRepertoire() {
      return this.dataModelRepertoire;
   }

   public void setDataModelRepertoire(DataModel var1) {
      this.dataModelRepertoire = var1;
   }

   public DataModel getDataModelSousRapport() {
      return this.dataModelSousRapport;
   }

   public void setDataModelSousRapport(DataModel var1) {
      this.dataModelSousRapport = var1;
   }

   public UploadedFile getUploadedFileRapport() {
      return this.uploadedFileRapport;
   }

   public void setUploadedFileRapport(UploadedFile var1) {
      this.uploadedFileRapport = var1;
   }

   public UploadedFile getUploadedFileSousRapport() {
      return this.uploadedFileSousRapport;
   }

   public void setUploadedFileSousRapport(UploadedFile var1) {
      this.uploadedFileSousRapport = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isVar_rapport_visible() {
      return this.var_rapport_visible;
   }

   public void setVar_rapport_visible(boolean var1) {
      this.var_rapport_visible = var1;
   }

   public boolean isVar_sousRapport_visible() {
      return this.var_sousRapport_visible;
   }

   public void setVar_sousRapport_visible(boolean var1) {
      this.var_sousRapport_visible = var1;
   }

   public boolean isVar_repertoire_selectionne() {
      return this.var_repertoire_selectionne;
   }

   public void setVar_repertoire_selectionne(boolean var1) {
      this.var_repertoire_selectionne = var1;
   }

   public String getVar_acces_rapport() {
      return this.var_acces_rapport;
   }

   public void setVar_acces_rapport(String var1) {
      this.var_acces_rapport = var1;
   }

   public String getVar_acces_sous_rapport() {
      return this.var_acces_sous_rapport;
   }

   public void setVar_acces_sous_rapport(String var1) {
      this.var_acces_sous_rapport = var1;
   }

   public String getVar_nom_ecran() {
      return this.var_nom_ecran;
   }

   public void setVar_nom_ecran(String var1) {
      this.var_nom_ecran = var1;
   }

   public String getVar_acces_rapport_ligne() {
      return this.var_acces_rapport_ligne;
   }

   public void setVar_acces_rapport_ligne(String var1) {
      this.var_acces_rapport_ligne = var1;
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

   public DataModel getDataModelModeleRapport() {
      return this.dataModelModeleRapport;
   }

   public void setDataModelModeleRapport(DataModel var1) {
      this.dataModelModeleRapport = var1;
   }

   public DataModel getDataModelModeleSousRapport() {
      return this.dataModelModeleSousRapport;
   }

   public void setDataModelModeleSousRapport(DataModel var1) {
      this.dataModelModeleSousRapport = var1;
   }

   public String getCodePays() {
      return this.codePays;
   }

   public void setCodePays(String var1) {
      this.codePays = var1;
   }

   public String getVar_acces_modeleRapport() {
      return this.var_acces_modeleRapport;
   }

   public void setVar_acces_modeleRapport(String var1) {
      this.var_acces_modeleRapport = var1;
   }

   public String getVar_acces_modeleRapport_ligne() {
      return this.var_acces_modeleRapport_ligne;
   }

   public void setVar_acces_modeleRapport_ligne(String var1) {
      this.var_acces_modeleRapport_ligne = var1;
   }

   public String getVar_acces_modeleSous_rapport() {
      return this.var_acces_modeleSous_rapport;
   }

   public void setVar_acces_modeleSous_rapport(String var1) {
      this.var_acces_modeleSous_rapport = var1;
   }

   public String getCodeModule() {
      return this.codeModule;
   }

   public void setCodeModule(String var1) {
      this.codeModule = var1;
   }

   public boolean isVar_rapportModele_visible() {
      return this.var_rapportModele_visible;
   }

   public void setVar_rapportModele_visible(boolean var1) {
      this.var_rapportModele_visible = var1;
   }

   public boolean isVar_sousRapportModele_visible() {
      return this.var_sousRapportModele_visible;
   }

   public void setVar_sousRapportModele_visible(boolean var1) {
      this.var_sousRapportModele_visible = var1;
   }

   public String getNouveauNom() {
      return this.nouveauNom;
   }

   public void setNouveauNom(String var1) {
      this.nouveauNom = var1;
   }

   public String getAncienNom() {
      return this.ancienNom;
   }

   public void setAncienNom(String var1) {
      this.ancienNom = var1;
   }

   public boolean isShowModalPanelRenameRapport() {
      return this.showModalPanelRenameRapport;
   }

   public void setShowModalPanelRenameRapport(boolean var1) {
      this.showModalPanelRenameRapport = var1;
   }

   public boolean isShowModalPanelRenameSousRapport() {
      return this.showModalPanelRenameSousRapport;
   }

   public void setShowModalPanelRenameSousRapport(boolean var1) {
      this.showModalPanelRenameSousRapport = var1;
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
}
