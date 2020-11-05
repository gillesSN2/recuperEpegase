package com.epegase.forms.commun;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureSites;
import com.epegase.systeme.xml.ObjetSites;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Scope;

@Scope("Request")
public class FormDocumentsOfficiels implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int nature;
   private String nomRepertoire;
   private List lesDocuments;
   private transient DataModel dataModelDocumnts;
   private List lesSites;
   private transient DataModel dataModelSites;
   private String nomRepertoireCGI;
   private List lesCGI;
   private transient DataModel dataModelCGI;
   private boolean showModalPanelPj = false;
   private String fichierMine;
   private URL fichierUrl;
   private UtilDownload utilDownload;
   private String urlExplorateur;
   private ObjetSites objetSites;
   private LectureSites lectureSites;
   private int choixRacine;
   private String selecFiscalite;

   public FormDocumentsOfficiels(String var1, Structure var2, Users var3, int var4, String var5, UtilInitHibernate var6) {
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.utilInitHibernate = var6;
      this.nature = var4;
      this.urlExplorateur = var5;
      this.lesDocuments = new ArrayList();
      this.dataModelDocumnts = new ListDataModel();
      this.lesCGI = new ArrayList();
      this.dataModelCGI = new ListDataModel();
      this.lesSites = new ArrayList();
      this.dataModelSites = new ListDataModel();
   }

   public void chargerMesracines() throws HibernateException, NamingException, IOException {
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && (this.choixRacine == 2 || this.choixRacine == 0)) {
         this.choixRacine = 1;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      } else if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.choixRacine == 1) {
         this.choixRacine = 2;
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      } else {
         this.choixRacine = 0;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      }

   }

   public void permutterDocuments() throws HibernateException, NamingException, IOException {
      this.ouvrirDocument();
   }

   public void ouvrirDocument() throws IOException, HibernateException, NamingException {
      this.lesDocuments = new ArrayList();
      this.lesCGI = new ArrayList();
      this.lesSites = new ArrayList();
      this.nomRepertoireCGI = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + "documentsOfficiels" + File.separator + "CGI" + File.separator + this.structureLog.getStrcodepays() + File.separator;
      if (this.nature == 50 && this.structureLog.getStrzonefiscale() != null && !this.structureLog.getStrzonefiscale().isEmpty()) {
         this.chargerMesracines();
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "fiscalites" + File.separator + this.selecFiscalite + File.separator + "documentsOfficiels" + File.separator;
         this.lectureSites = new LectureSites(this.nomRepertoire + "listeSites.xml");
      } else if (this.nature == 80 && this.structureLog.getStrcodepays() != null && !this.structureLog.getStrcodepays().isEmpty()) {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "documentsOfficiels" + File.separator + this.structureLog.getStrcodepays() + File.separator;
         this.lectureSites = new LectureSites(this.nomRepertoire + "listeSites.xml");
      } else if (this.nature == 100 && this.structureLog.getStrcodepays() != null && !this.structureLog.getStrcodepays().isEmpty()) {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "education" + File.separator + "documentsOfficiels" + File.separator + this.structureLog.getStrcodepays() + File.separator;
         this.lectureSites = new LectureSites(this.nomRepertoire + "listeSites.xml");
      } else if (this.nature == 150 && this.structureLog.getStrcodepays() != null && !this.structureLog.getStrcodepays().isEmpty()) {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "medical" + File.separator + "documentsOfficiels" + File.separator;
         this.lectureSites = new LectureSites(this.nomRepertoire + "listeSites.xml");
      } else if (this.nature == 160 && this.structureLog.getStrcodepays() != null && !this.structureLog.getStrcodepays().isEmpty()) {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "immobilier" + File.separator + "location" + File.separator + "documentsOfficiels" + File.separator + this.structureLog.getStrcodepays() + File.separator;
         this.lectureSites = new LectureSites(this.nomRepertoire + "listeSites.xml");
      } else if (this.nature == 170 && this.structureLog.getStrcodepays() != null && !this.structureLog.getStrcodepays().isEmpty()) {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "immobilier" + File.separator + "syndic" + File.separator + "documentsOfficiels" + File.separator + this.structureLog.getStrcodepays() + File.separator;
         this.lectureSites = new LectureSites(this.nomRepertoire + "listeSites.xml");
      } else if (this.nature == 180 && this.structureLog.getStrcodepays() != null && !this.structureLog.getStrcodepays().isEmpty()) {
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "immobilier" + File.separator + "negoce" + File.separator + "documentsOfficiels" + File.separator + this.structureLog.getStrcodepays() + File.separator;
         this.lectureSites = new LectureSites(this.nomRepertoire + "listeSites.xml");
      }

      File var1;
      String[] var2;
      int var3;
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         var2 = var1.list();
         if (var2 != null) {
            var2 = this.triAlphabetique(var2, var2.length);

            for(var3 = 0; var3 < var2.length; ++var3) {
               if (this.nature == 50) {
                  if (var2[var3].endsWith(".pdf")) {
                     this.lesDocuments.add(var2[var3]);
                  }
               } else if (this.nature == 80) {
                  if (var2[var3].endsWith(".pdf")) {
                     this.lesDocuments.add(var2[var3]);
                  }
               } else if (this.nature == 100) {
                  if (var2[var3].endsWith(".pdf")) {
                     this.lesDocuments.add(var2[var3]);
                  }
               } else if (this.nature == 150) {
                  if (var2[var3].endsWith(".pdf")) {
                     this.lesDocuments.add(var2[var3]);
                  }
               } else if ((this.nature == 160 || this.nature == 170 || this.nature == 180) && var2[var3].endsWith(".pdf")) {
                  this.lesDocuments.add(var2[var3]);
               }
            }
         }

         this.lesSites = this.lectureSites.getMesSites();
      }

      if (this.nomRepertoireCGI != null && !this.nomRepertoireCGI.isEmpty()) {
         var1 = new File(this.nomRepertoireCGI);
         if (!var1.exists()) {
            var1.mkdir();
         }

         var2 = var1.list();
         if (var2 != null) {
            var2 = this.triAlphabetique(var2, var2.length);

            for(var3 = 0; var3 < var2.length; ++var3) {
               if (var2[var3].endsWith(".pdf")) {
                  this.lesCGI.add(var2[var3]);
               }
            }
         }
      }

      this.dataModelCGI.setWrappedData(this.lesCGI);
      this.dataModelDocumnts.setWrappedData(this.lesDocuments);
      this.dataModelSites.setWrappedData(this.lesSites);
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

   public void lectureDoc() throws MalformedURLException, IOException {
      if (this.dataModelDocumnts.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumnts.getRowData();
         if (var1.contains(".pdf")) {
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               File var3 = new File(var2);
               if (var3.exists()) {
                  this.consulterDocument(var2);
               }
            }
         }
      }

   }

   public void lectureDocCGI() throws MalformedURLException, IOException {
      if (this.dataModelCGI.isRowAvailable()) {
         String var1 = (String)this.dataModelCGI.getRowData();
         if (var1.contains(".pdf")) {
            String var2 = this.nomRepertoireCGI + var1;
            if (var2 != null && !var2.isEmpty()) {
               File var3 = new File(var2);
               if (var3.exists()) {
                  this.consulterDocument(var2);
               }
            }
         }
      }

   }

   public void consulterDocument(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuCatalogue() {
      this.showModalPanelPj = false;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
   }

   public boolean isShowModalPanelPj() {
      return this.showModalPanelPj;
   }

   public void setShowModalPanelPj(boolean var1) {
      this.showModalPanelPj = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public DataModel getDataModelSites() {
      return this.dataModelSites;
   }

   public void setDataModelSites(DataModel var1) {
      this.dataModelSites = var1;
   }

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
   }

   public String getSelecFiscalite() {
      return this.selecFiscalite;
   }

   public void setSelecFiscalite(String var1) {
      this.selecFiscalite = var1;
   }

   public DataModel getDataModelCGI() {
      return this.dataModelCGI;
   }

   public void setDataModelCGI(DataModel var1) {
      this.dataModelCGI = var1;
   }
}
