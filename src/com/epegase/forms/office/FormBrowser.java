package com.epegase.forms.office;

import com.epegase.systeme.classe.GroupeFavoris;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.GroupeFavorisDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetMessageSysteme;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;

public class FormBrowser implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private int typePlateForme;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int typeSaisie;
   private String pageIndex;
   private UtilDownload utilDownload = new UtilDownload();
   private ObjetMessageSysteme objetMessageSysteme;
   private List listRepertoire = new ArrayList();
   private transient DataModel dataModelRepertoire = new ListDataModel();
   private String nomRepertoire;
   private String nomFichier;
   private int niveau = 0;
   private String repNiveau1;
   private String repNiveau2;
   private String repNiveau3;
   private String repNiveau4;
   private String repNiveau5;
   private String repNiveau6;
   private String repNiveau7;
   private String repNiveau8;
   private String repNiveau9;
   private String repNiveau10;
   private boolean fichier = false;
   private boolean showModalPanelAjoutFile = false;
   private UploadedFile uploadedFile;
   private GroupeFavorisDao groupeFavorisDao;
   private GroupeFavoris groupeFavoris = new GroupeFavoris();
   private List lesGroupesFavoris = new ArrayList();
   private boolean memoAjout;
   private boolean memoModif;
   private boolean memoSupp;
   private URL fichierUrl;
   private String fichierCode;
   private String fichierMine;
   private URL repertoireUrl;
   private String repertoireString;
   private boolean viewerPdf = false;
   private String adresseTelechargement;

   public FormBrowser() throws UnknownHostException {
   }

   public void InstancesDaoUtilses() {
      this.groupeFavorisDao = new GroupeFavorisDao(this.baseLog, this.utilInitHibernate);
   }

   public void accueil(Session var1, String var2, int var3) throws HibernateException, NamingException, IOException, ParseException {
      this.urlExplorateur = var2;
      this.typePlateForme = var3;
      this.niveau = 0;
      this.nomRepertoire = "Internes";
      this.nomFichier = "";
      this.lesGroupesFavoris = this.groupeFavorisDao.selectGroupe(this.usersLog.getGroupe(), var1);
      String var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "commun" + File.separator + "accueil";
      this.adresseTelechargement = this.urlExplorateur + "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "commun" + File.separator + "accueil";
      this.lectureDossierAccueil(var4);
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void lectureDossierAccueil(String var1) throws IOException {
      this.listRepertoire.clear();
      if (var1 != null && !var1.isEmpty()) {
         File var2 = new File(var1);
         String[] var3 = var2.list();
         if (var3 != null && var3.length != 0) {
            String var4 = "";
            if (var3 != null) {
               var3 = this.triAlphabetique(var3, var3.length);
               if (this.niveau != 0) {
                  this.objetMessageSysteme = new ObjetMessageSysteme();
                  this.objetMessageSysteme.setTexte("..");
                  this.objetMessageSysteme.setIndice(this.niveau);
                  this.listRepertoire.add(this.objetMessageSysteme);
               }
            }

            for(int var5 = 0; var5 < var3.length; ++var5) {
               var4 = var3[var5];
               this.objetMessageSysteme = new ObjetMessageSysteme();
               this.objetMessageSysteme.setTexte(var4);
               this.objetMessageSysteme.setIndice(this.niveau);
               boolean var6 = false;
               if (this.lesGroupesFavoris.size() != 0) {
                  String var7 = this.enleverRacine();
                  if (var7 != null && !var7.isEmpty()) {
                     var7 = var7 + File.separator + var4;
                  } else {
                     var7 = var4;
                  }

                  if (!var7.contains(".")) {
                     for(int var8 = 0; var8 < this.lesGroupesFavoris.size(); ++var8) {
                        if (((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavAcces() && ((GroupeFavoris)this.lesGroupesFavoris.get(var8)).getGrpfavRepertoire().equalsIgnoreCase(var7)) {
                           this.objetMessageSysteme.setAjout(((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavAjout());
                           this.objetMessageSysteme.setModif(((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavModif());
                           this.objetMessageSysteme.setSupp(((GroupeFavoris)this.lesGroupesFavoris.get(var8)).isGrpfavSupp());
                           var6 = true;
                           break;
                        }
                     }
                  } else if (var7.contains(".")) {
                     var6 = true;
                  }
               }

               if (var6) {
                  this.listRepertoire.add(this.objetMessageSysteme);
               }
            }
         } else {
            this.objetMessageSysteme = new ObjetMessageSysteme();
            this.objetMessageSysteme.setTexte("..");
            this.objetMessageSysteme.setIndice(this.niveau);
            this.listRepertoire.add(this.objetMessageSysteme);
         }
      } else {
         this.objetMessageSysteme = new ObjetMessageSysteme();
         this.objetMessageSysteme.setTexte("..");
         this.objetMessageSysteme.setIndice(this.niveau);
         this.listRepertoire.add(this.objetMessageSysteme);
      }

      this.dataModelRepertoire.setWrappedData(this.listRepertoire);
   }

   public void selectionRepertoire() throws IOException, DocumentException {
      if (this.dataModelRepertoire.isRowAvailable()) {
         this.objetMessageSysteme = (ObjetMessageSysteme)this.dataModelRepertoire.getRowData();
         if (this.objetMessageSysteme.getTexte().contains(".") && !this.objetMessageSysteme.getTexte().equals("..")) {
            this.fichier = true;
            this.nomFichier = this.objetMessageSysteme.getTexte();
            this.objetMessageSysteme.setAjout(this.memoAjout);
            this.objetMessageSysteme.setModif(this.memoModif);
            this.objetMessageSysteme.setSupp(this.memoSupp);
            this.lireDocument();
         } else if (this.objetMessageSysteme.getTexte().equals("..")) {
            this.fichier = false;
            this.nomFichier = "";
            --this.niveau;
            this.memoAjout = this.objetMessageSysteme.isAjout();
            this.memoModif = this.objetMessageSysteme.isModif();
            this.memoSupp = this.objetMessageSysteme.isSupp();
            this.lectureDossierAccueil(this.calculeRepertoireNavigation());
            this.objetMessageSysteme.setAjout(this.memoAjout);
            this.objetMessageSysteme.setModif(this.memoModif);
            this.objetMessageSysteme.setSupp(this.memoSupp);
         } else {
            this.fichier = false;
            this.nomFichier = "";
            ++this.niveau;
            this.memoAjout = this.objetMessageSysteme.isAjout();
            this.memoModif = this.objetMessageSysteme.isModif();
            this.memoSupp = this.objetMessageSysteme.isSupp();
            this.lectureDossierAccueil(this.calculeRepertoireNavigation());
            this.objetMessageSysteme.setAjout(this.memoAjout);
            this.objetMessageSysteme.setModif(this.memoModif);
            this.objetMessageSysteme.setSupp(this.memoSupp);
         }
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
   }

   public String calculeRepertoireNavigation() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "commun" + File.separator + "accueil";
      if (this.objetMessageSysteme.getTexte().equals("..")) {
         if (this.niveau == 0) {
            this.nomRepertoire = "Internes";
         } else if (this.niveau == 1) {
            this.nomRepertoire = this.repNiveau1;
            var1 = var1 + File.separator + this.repNiveau1;
         } else if (this.niveau == 2) {
            this.nomRepertoire = this.repNiveau2;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2;
         } else if (this.niveau == 3) {
            this.nomRepertoire = this.repNiveau3;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
         } else if (this.niveau == 4) {
            this.nomRepertoire = this.repNiveau4;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
         } else if (this.niveau == 5) {
            this.nomRepertoire = this.repNiveau5;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
         } else if (this.niveau == 6) {
            this.nomRepertoire = this.repNiveau6;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
         } else if (this.niveau == 7) {
            this.nomRepertoire = this.repNiveau7;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
         } else if (this.niveau == 8) {
            this.nomRepertoire = this.repNiveau8;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
         } else if (this.niveau == 9) {
            this.nomRepertoire = this.repNiveau9;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
         } else if (this.niveau == 10) {
            this.nomRepertoire = this.repNiveau10;
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
         }
      } else {
         this.nomRepertoire = this.objetMessageSysteme.getTexte();
         if (this.niveau == 1) {
            this.repNiveau1 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1;
         } else if (this.niveau == 2) {
            this.repNiveau2 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2;
         } else if (this.niveau == 3) {
            this.repNiveau3 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
         } else if (this.niveau == 4) {
            this.repNiveau4 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
         } else if (this.niveau == 5) {
            this.repNiveau5 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
         } else if (this.niveau == 6) {
            this.repNiveau6 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
         } else if (this.niveau == 7) {
            this.repNiveau7 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
         } else if (this.niveau == 8) {
            this.repNiveau8 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
         } else if (this.niveau == 9) {
            this.repNiveau9 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
         } else if (this.niveau == 10) {
            this.repNiveau10 = this.objetMessageSysteme.getTexte();
            var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
         }
      }

      return var1;
   }

   public String calculeRepertoireEnCours() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "commun" + File.separator + "accueil";
      if (this.niveau == 1) {
         var1 = var1 + File.separator + this.repNiveau1;
      } else if (this.niveau == 2) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2;
      } else if (this.niveau == 3) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
      } else if (this.niveau == 4) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
      } else if (this.niveau == 5) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
      } else if (this.niveau == 6) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
      } else if (this.niveau == 7) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
      } else if (this.niveau == 8) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
      } else if (this.niveau == 9) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
      } else if (this.niveau == 10) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
      }

      return var1;
   }

   public String calculeFichier() {
      String var1 = this.adresseTelechargement;
      if (this.niveau == 1) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 2) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 3) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 4) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 5) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 6) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 7) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 8) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 9) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.objetMessageSysteme.getTexte();
      } else if (this.niveau == 10) {
         var1 = var1 + File.separator + this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10 + File.separator + this.objetMessageSysteme.getTexte();
      }

      return var1;
   }

   public String enleverRacine() {
      String var1 = "";
      if (this.niveau == 1) {
         var1 = this.repNiveau1;
      } else if (this.niveau == 2) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2;
      } else if (this.niveau == 3) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3;
      } else if (this.niveau == 4) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4;
      } else if (this.niveau == 5) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5;
      } else if (this.niveau == 6) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6;
      } else if (this.niveau == 7) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7;
      } else if (this.niveau == 8) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8;
      } else if (this.niveau == 9) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9;
      } else if (this.niveau == 10) {
         var1 = this.repNiveau1 + File.separator + this.repNiveau2 + File.separator + this.repNiveau3 + File.separator + this.repNiveau4 + File.separator + this.repNiveau5 + File.separator + this.repNiveau6 + File.separator + this.repNiveau7 + File.separator + this.repNiveau8 + File.separator + this.repNiveau9 + File.separator + this.repNiveau10;
      }

      return var1;
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

   public void ajouterDocument() throws MalformedURLException, IOException {
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         this.repertoireUrl = this.utilDownload.convertirFichierUtl(this.calculeRepertoireEnCours(), this.urlExplorateur);
         this.repertoireString = this.repertoireUrl.toString() + File.separator;
      }

      this.uploadedFile = null;
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocument() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerDocument() {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            if (var1.toString().contains(".")) {
               if (var1.toString().contains(" ")) {
                  String var2 = var1.toString();
                  String var3 = "";

                  for(int var4 = 0; var4 < var2.length(); ++var4) {
                     String var5 = var2.substring(var4, var4 + 1);
                     if (var5.equals(" ")) {
                        var3 = var3 + "_";
                     } else {
                        var3 = var3 + var2.substring(var4, var4 + 1);
                     }
                  }

                  var1 = var3;
               }

               File var7 = new File(this.calculeRepertoireEnCours() + File.separator + var1);
               var7.delete();
               File var8 = this.utilDownload.uniqueFile(new File(this.calculeRepertoireEnCours() + File.separator), var1);
               this.utilDownload.write(var8, this.uploadedFile.getInputStream());
               this.objetMessageSysteme = new ObjetMessageSysteme();
               this.objetMessageSysteme.setTexte(var1);
               this.objetMessageSysteme.setIndice(this.niveau);
               this.listRepertoire.add(this.objetMessageSysteme);
               this.dataModelRepertoire.setWrappedData(this.listRepertoire);
            }
         }
      } catch (IOException var6) {
      }

      this.showModalPanelAjoutFile = false;
   }

   public void lireDocument() throws IOException {
      if (this.nomFichier != null && !this.nomFichier.isEmpty() && this.fichier) {
         this.fichierUrl = this.utilDownload.convertirFichierUtl(this.calculeFichier(), this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(this.nomFichier);
         if (!this.nomFichier.contains(".pdf") && !this.nomFichier.contains(".PDF")) {
            this.viewerPdf = false;
         } else {
            this.viewerPdf = true;
         }
      }

   }

   public void supprimerDocument() throws IOException {
      if (this.objetMessageSysteme.getTexte().contains(".") && !this.objetMessageSysteme.getTexte().equals("..")) {
         File var1 = new File(this.calculeFichier());
         var1.delete();
         this.listRepertoire.remove(this.objetMessageSysteme);
         this.dataModelRepertoire.setWrappedData(this.listRepertoire);
         this.nomFichier = "";
      }

   }

   public ObjetMessageSysteme getObjetMessageSysteme() {
      return this.objetMessageSysteme;
   }

   public void setObjetMessageSysteme(ObjetMessageSysteme var1) {
      this.objetMessageSysteme = var1;
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

   public int getTypeSaisie() {
      return this.typeSaisie;
   }

   public void setTypeSaisie(int var1) {
      this.typeSaisie = var1;
   }

   public DataModel getDataModelRepertoire() {
      return this.dataModelRepertoire;
   }

   public void setDataModelRepertoire(DataModel var1) {
      this.dataModelRepertoire = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public boolean isFichier() {
      return this.fichier;
   }

   public void setFichier(boolean var1) {
      this.fichier = var1;
   }

   public String getNomFichier() {
      return this.nomFichier;
   }

   public void setNomFichier(String var1) {
      this.nomFichier = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public int getNiveau() {
      return this.niveau;
   }

   public void setNiveau(int var1) {
      this.niveau = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public String getFichierCode() {
      return this.fichierCode;
   }

   public void setFichierCode(String var1) {
      this.fichierCode = var1;
   }

   public URL getRepertoireUrl() {
      return this.repertoireUrl;
   }

   public void setRepertoireUrl(URL var1) {
      this.repertoireUrl = var1;
   }

   public String getRepertoireString() {
      return this.repertoireString;
   }

   public void setRepertoireString(String var1) {
      this.repertoireString = var1;
   }

   public boolean isViewerPdf() {
      return this.viewerPdf;
   }

   public void setViewerPdf(boolean var1) {
      this.viewerPdf = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
