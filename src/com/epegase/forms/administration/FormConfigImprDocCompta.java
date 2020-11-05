package com.epegase.forms.administration;

import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
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
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.jdom.JDOMException;

public class FormConfigImprDocCompta implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String var_acces_rapport;
   private String var_acces_rapport_ligne;
   private String var_acces_sous_rapport;
   private String var_nom_ecran;
   private String pageIndex;
   private List listRepertoires = new ArrayList();
   private transient DataModel dataModelRepertoire = new ListDataModel();
   private UtilDownload utilDownload = new UtilDownload();
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

   public void chargerSousRapport() {
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

   public void selectionRepertoire() {
      if (this.dataModelRepertoire.isRowAvailable()) {
         this.var_nom_repertoire = (String)this.dataModelRepertoire.getRowData();
         this.var_rapport_visible = false;
         this.var_repertoire_selectionne = true;
         this.var_sousRapport_visible = false;
         this.listeRapport();
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

   public void selectionSousRapport() {
      if (this.dataModelSousRapport.isRowAvailable()) {
         this.var_nom_sousRapport = (String)this.dataModelSousRapport.getRowData();
         this.var_rapport_visible = false;
         this.var_sousRapport_visible = true;
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

   public void supprimerSousRapport() {
      String var1 = this.var_acces_sous_rapport + File.separator + this.var_nom_sousRapport + ".jasper";
      File var2 = new File(var1);
      var2.delete();
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
}
