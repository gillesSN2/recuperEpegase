package com.epegase.forms.administration;

import com.epegase.systeme.classe.Groupe;
import com.epegase.systeme.classe.GroupeFavoris;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.GroupeDao;
import com.epegase.systeme.dao.GroupeFavorisDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetMessageSysteme;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormGestionRepertoire implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ObjetMessageSysteme objetMessageSysteme;
   private List listeRepertoiresCommun = new ArrayList();
   private transient DataModel dataModelRepertoiresCommun = new ListDataModel();
   private String nomRepertoire;
   private String nomRepertoireAncien;
   private String gestionRepertoire;
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
   private boolean showModalPanelRepertoire = false;
   private boolean visibiliteBton = false;
   private boolean modifRepertoire = false;
   private List lesGroupesFavoris = new ArrayList();
   private transient DataModel dataModelGroupesFavoris = new ListDataModel();
   private GroupeDao groupeDao;
   private GroupeFavorisDao groupeFavorisDao;
   private List lesGroupes = new ArrayList();
   private boolean afficheDossierSelection = false;
   private List lesAutresDossiersItems = new ArrayList();
   private String var_dossier;

   public void InstancesDaoUtilses() {
      this.groupeDao = new GroupeDao(this.baseLog, this.utilInitHibernate);
      this.groupeFavorisDao = new GroupeFavorisDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerGroupe(Session var1) throws HibernateException, NamingException {
      this.lesGroupes = new ArrayList();
      this.lesGroupes = this.groupeDao.selectGroupe(var1);
   }

   public void lectureDossierAccueil(String var1) {
      this.listeRepertoiresCommun.clear();
      if (var1 != null && !var1.isEmpty() && !var1.equals("..")) {
         File var2 = new File(var1);
         String[] var3 = var2.list();
         if (var3 != null) {
            String var4 = "";
            var3 = this.triAlphabetique(var3, var3.length);
            if (this.niveau != 0) {
               this.objetMessageSysteme = new ObjetMessageSysteme();
               this.objetMessageSysteme.setTexte("..");
               this.objetMessageSysteme.setIndice(this.niveau);
               this.listeRepertoiresCommun.add(this.objetMessageSysteme);
            }

            for(int var5 = 0; var5 < var3.length; ++var5) {
               var4 = var3[var5];
               this.objetMessageSysteme = new ObjetMessageSysteme();
               this.objetMessageSysteme.setTexte(var4);
               this.objetMessageSysteme.setIndice(this.niveau);
               this.listeRepertoiresCommun.add(this.objetMessageSysteme);
            }
         }
      }

      this.dataModelRepertoiresCommun.setWrappedData(this.listeRepertoiresCommun);
   }

   public void selectionRepertoire() throws IOException, DocumentException, HibernateException, NamingException {
      if (this.dataModelRepertoiresCommun.isRowAvailable()) {
         this.objetMessageSysteme = (ObjetMessageSysteme)this.dataModelRepertoiresCommun.getRowData();
         if (!this.objetMessageSysteme.getTexte().contains(".") || this.objetMessageSysteme.getTexte().equals("..")) {
            if (this.objetMessageSysteme.getTexte().equals("..")) {
               --this.niveau;
               this.visibiliteBton = false;
               this.lectureDossierAccueil(this.calculeRepertoireNavigation());
               this.chargerAutorisationRepertoire();
            } else {
               ++this.niveau;
               this.visibiliteBton = true;
               this.lectureDossierAccueil(this.calculeRepertoireNavigation());
               this.chargerAutorisationRepertoire();
            }
         }
      }

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

   public String enleverContext() {
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

   public void chargerAutorisationRepertoire() throws HibernateException, NamingException {
      this.lesGroupesFavoris.clear();
      String var1 = this.enleverContext();
      this.lesGroupesFavoris = this.groupeFavorisDao.selectGroupeRepertoire(var1, (Session)null);
      if (this.lesGroupes.size() != 0) {
         for(int var2 = 0; var2 < this.lesGroupes.size(); ++var2) {
            new Groupe();
            Groupe var3 = (Groupe)this.lesGroupes.get(var2);
            boolean var4 = false;
            if (this.lesGroupesFavoris.size() != 0) {
               for(int var5 = 0; var5 < this.lesGroupesFavoris.size(); ++var5) {
                  if (var3.getGrpCode().equals(((GroupeFavoris)this.lesGroupesFavoris.get(var5)).getGroupe().getGrpCode())) {
                     var4 = true;
                  }
               }
            }

            if (!var4) {
               GroupeFavoris var6 = new GroupeFavoris();
               var6.setGrpfavNature(0);
               var6.setGroupe(var3);
               var6.setGrpfavRepertoire(var1);
               this.lesGroupesFavoris.add(var6);
            }
         }
      }

      this.dataModelGroupesFavoris.setWrappedData(this.lesGroupesFavoris);
   }

   public void heritageAutorisationRepertoire(String var1, String var2) throws HibernateException, NamingException {
      this.lesGroupesFavoris.clear();
      this.lesGroupesFavoris = this.groupeFavorisDao.selectGroupeRepertoire(var1, (Session)null);
      if (this.lesGroupes.size() != 0) {
         for(int var3 = 0; var3 < this.lesGroupes.size(); ++var3) {
            new Groupe();
            Groupe var4 = (Groupe)this.lesGroupes.get(var3);
            boolean var5 = false;
            if (this.lesGroupesFavoris.size() != 0) {
               for(int var6 = 0; var6 < this.lesGroupesFavoris.size(); ++var6) {
                  if (var4.getGrpCode().equals(((GroupeFavoris)this.lesGroupesFavoris.get(var6)).getGroupe().getGrpCode())) {
                     var5 = true;
                  }
               }
            }

            if (!var5) {
               GroupeFavoris var7 = new GroupeFavoris();
               var7.setGrpfavNature(0);
               var7.setGroupe(var4);
               var7.setGrpfavRepertoire(var1);
               this.lesGroupesFavoris.add(var7);
            }
         }
      }

      this.dataModelGroupesFavoris.setWrappedData(this.lesGroupesFavoris);
   }

   public void toutSelectionner() {
      if (this.lesGroupesFavoris.size() != 0) {
         for(int var1 = 0; var1 < this.lesGroupesFavoris.size(); ++var1) {
            new GroupeFavoris();
            GroupeFavoris var2 = (GroupeFavoris)this.lesGroupesFavoris.get(var1);
            var2.setGrpfavAcces(true);
            var2.setGrpfavAjout(true);
            var2.setGrpfavModif(true);
            var2.setGrpfavSupp(true);
         }

         this.dataModelGroupesFavoris.setWrappedData(this.lesGroupesFavoris);
      }

   }

   public void rienSelectionner() {
      if (this.lesGroupesFavoris.size() != 0) {
         for(int var1 = 0; var1 < this.lesGroupesFavoris.size(); ++var1) {
            new GroupeFavoris();
            GroupeFavoris var2 = (GroupeFavoris)this.lesGroupesFavoris.get(var1);
            var2.setGrpfavAcces(false);
            var2.setGrpfavAjout(false);
            var2.setGrpfavModif(false);
            var2.setGrpfavSupp(false);
         }

         this.dataModelGroupesFavoris.setWrappedData(this.lesGroupesFavoris);
      }

   }

   public void heritageDroitParent() throws HibernateException, NamingException {
      --this.niveau;
      this.chargerAutorisationRepertoire();
      ++this.niveau;
   }

   public void heritageDroitRepertoire() {
      if (!this.afficheDossierSelection) {
         this.lesAutresDossiersItems.clear();
         --this.niveau;
         this.calculeRepertoireEnCours();
         this.lesAutresDossiersItems.add(new SelectItem("", "Sélectionnez le dossier"));
         if (this.calculeRepertoireEnCours() != null && !this.calculeRepertoireEnCours().isEmpty() && !this.calculeRepertoireEnCours().equals("..")) {
            File var1 = new File(this.calculeRepertoireEnCours());
            String[] var2 = var1.list();
            if (var2 != null) {
               String var3 = "";
               var2 = this.triAlphabetique(var2, var2.length);

               for(int var4 = 0; var4 < var2.length; ++var4) {
                  var3 = var2[var4];
                  this.lesAutresDossiersItems.add(new SelectItem(this.calculeRepertoireEnCours(), var3));
               }
            }
         }

         ++this.niveau;
         this.afficheDossierSelection = true;
      } else {
         this.afficheDossierSelection = false;
      }

   }

   public void recupHeritageDroitRepertoire() {
      this.afficheDossierSelection = false;
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

   public void ajouterRepertoire() {
      if (this.niveau <= 10) {
         this.gestionRepertoire = "";
         this.modifRepertoire = false;
         this.showModalPanelRepertoire = true;
         this.afficheDossierSelection = false;
      }

   }

   public void modifierRepertoire() {
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         this.nomRepertoireAncien = this.nomRepertoire;
         this.gestionRepertoire = this.nomRepertoire;
         this.modifRepertoire = true;
         this.showModalPanelRepertoire = true;
         this.afficheDossierSelection = false;
      }

   }

   public void supprimerRepertoire() {
      if (this.objetMessageSysteme.getTexte() != null && !this.objetMessageSysteme.getTexte().isEmpty()) {
         String var1 = this.calculeRepertoireEnCours();
         boolean var2 = true;
         File var3 = new File(this.calculeRepertoireEnCours());
         String[] var4 = var3.list();
         if (var4.length != 0) {
            var2 = false;
         }

         if (var2) {
            File var5 = new File(var1);
            var5.delete();
            --this.niveau;
            this.visibiliteBton = false;
            this.lectureDossierAccueil(this.calculeRepertoireNavigation());
         }
      }

      this.visibiliteBton = false;
   }

   public void annulerRepertoire() {
      this.showModalPanelRepertoire = false;
   }

   public void validerAjoutRepertoire() throws HibernateException, NamingException {
      if (this.gestionRepertoire != null && !this.gestionRepertoire.isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Accueil");
         Transaction var2 = null;

         String var3;
         try {
            var2 = var1.beginTransaction();
            this.groupeFavorisDao.suppressionAutorisation(this.nomRepertoireAncien, var1);
            var3 = this.enleverContext();
            if (this.lesGroupesFavoris.size() != 0) {
               for(int var4 = 0; var4 < this.lesGroupesFavoris.size(); ++var4) {
                  new GroupeFavoris();
                  GroupeFavoris var5 = (GroupeFavoris)this.lesGroupesFavoris.get(var4);
                  var5.setGrpfavRepertoire(var3);
               }
            }

            this.groupeFavorisDao.creationAutorisation(this.lesGroupesFavoris, var1);
            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var3 = this.calculeRepertoireEnCours() + File.separator + this.gestionRepertoire;
         if (!this.modifRepertoire) {
            (new File(var3)).mkdir();
            this.objetMessageSysteme = new ObjetMessageSysteme();
            this.objetMessageSysteme.setTexte(this.gestionRepertoire);
            this.objetMessageSysteme.setIndice(this.niveau);
            this.listeRepertoiresCommun.add(this.objetMessageSysteme);
            this.dataModelRepertoiresCommun.setWrappedData(this.listeRepertoiresCommun);
         } else {
            --this.niveau;
            String var12 = this.calculeRepertoireEnCours() + File.separator + this.nomRepertoireAncien;
            File var13 = new File(var12);
            String var6 = this.calculeRepertoireEnCours() + File.separator + this.gestionRepertoire;
            this.objetMessageSysteme = new ObjetMessageSysteme();
            this.objetMessageSysteme.setTexte(this.gestionRepertoire);
            this.objetMessageSysteme.setIndice(this.niveau);
            File var7 = new File(var6);
            var13.renameTo(var7);
            this.nomRepertoire = this.gestionRepertoire;
            this.dataModelRepertoiresCommun.setWrappedData(this.listeRepertoiresCommun);
            ++this.niveau;
         }
      }

      this.showModalPanelRepertoire = false;
      this.visibiliteBton = false;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public DataModel getDataModelRepertoiresCommun() {
      return this.dataModelRepertoiresCommun;
   }

   public void setDataModelRepertoiresCommun(DataModel var1) {
      this.dataModelRepertoiresCommun = var1;
   }

   public int getNiveau() {
      return this.niveau;
   }

   public void setNiveau(int var1) {
      this.niveau = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public boolean isShowModalPanelRepertoire() {
      return this.showModalPanelRepertoire;
   }

   public void setShowModalPanelRepertoire(boolean var1) {
      this.showModalPanelRepertoire = var1;
   }

   public String getGestionRepertoire() {
      return this.gestionRepertoire;
   }

   public void setGestionRepertoire(String var1) {
      this.gestionRepertoire = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public DataModel getDataModelGroupesFavoris() {
      return this.dataModelGroupesFavoris;
   }

   public void setDataModelGroupesFavoris(DataModel var1) {
      this.dataModelGroupesFavoris = var1;
   }

   public boolean isAfficheDossierSelection() {
      return this.afficheDossierSelection;
   }

   public void setAfficheDossierSelection(boolean var1) {
      this.afficheDossierSelection = var1;
   }

   public List getLesAutresDossiersItems() {
      return this.lesAutresDossiersItems;
   }

   public void setLesAutresDossiersItems(List var1) {
      this.lesAutresDossiersItems = var1;
   }

   public String getVar_dossier() {
      return this.var_dossier;
   }

   public void setVar_dossier(String var1) {
      this.var_dossier = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
