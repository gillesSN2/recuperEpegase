package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionTiers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormOptionsOffice implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private OptionTiers optionTiers;
   private Element racine = new Element("option_Tiers");
   private Document document;
   private String labase;
   private Structure structureLog;
   private String format;
   private UtilPrint utilPrint;
   private Users usersLog;
   private List mesModelesAchats;
   private List mesModelesStocks;
   private List mesModelesVentes;
   private List mesModelesTresorerie;
   private List lesRepImpression;
   private String nomRepertoire;
   private boolean afficheAchat = false;
   private boolean afficheVente = false;
   private boolean afficheTreso = false;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;

   public FormOptionsOffice() throws HibernateException, NamingException {
      this.document = new Document(this.racine);
      this.optionTiers = new OptionTiers();
      this.mesModelesAchats = new ArrayList();
      this.mesModelesStocks = new ArrayList();
      this.mesModelesVentes = new ArrayList();
      this.mesModelesTresorerie = new ArrayList();
      this.lesRepImpression = new ArrayList();
   }

   public void initOption() {
      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().equals("60000") || this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().equals("60000") || this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().equals("60000") || this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().equals("60000") || this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().equals("60000") || this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().equals("60000") || this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().equals("60000") || this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().equals("60000") || this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().equals("60000") || this.structureLog.getStrmod10() != null && this.structureLog.getStrmod10().equals("60000")) {
         this.afficheAchat = true;
      }

      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().equals("60010") || this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().equals("60010") || this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().equals("60010") || this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().equals("60010") || this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().equals("60010") || this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().equals("60010") || this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().equals("60010") || this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().equals("60010") || this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().equals("60010") || this.structureLog.getStrmod10() != null && this.structureLog.getStrmod10().equals("60010")) {
         this.afficheAchat = true;
      }

      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().equals("60020") || this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().equals("60020") || this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().equals("60020") || this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().equals("60020") || this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().equals("60020") || this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().equals("60020") || this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().equals("60020") || this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().equals("60020") || this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().equals("60020") || this.structureLog.getStrmod10() != null && this.structureLog.getStrmod10().equals("60020")) {
         this.afficheAchat = true;
      }

      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().equals("80100") || this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().equals("80100") || this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().equals("80100") || this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().equals("80100") || this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().equals("80100") || this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().equals("80100") || this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().equals("80100") || this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().equals("80100") || this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().equals("80100") || this.structureLog.getStrmod10() != null && this.structureLog.getStrmod10().equals("80100")) {
         this.afficheVente = true;
      }

      if (this.structureLog.getStrmod1() != null && this.structureLog.getStrmod1().equals("90000") || this.structureLog.getStrmod2() != null && this.structureLog.getStrmod2().equals("90000") || this.structureLog.getStrmod3() != null && this.structureLog.getStrmod3().equals("90000") || this.structureLog.getStrmod4() != null && this.structureLog.getStrmod4().equals("90000") || this.structureLog.getStrmod5() != null && this.structureLog.getStrmod5().equals("90000") || this.structureLog.getStrmod6() != null && this.structureLog.getStrmod6().equals("90000") || this.structureLog.getStrmod7() != null && this.structureLog.getStrmod7().equals("90000") || this.structureLog.getStrmod8() != null && this.structureLog.getStrmod8().equals("90000") || this.structureLog.getStrmod9() != null && this.structureLog.getStrmod9().equals("90000") || this.structureLog.getStrmod10() != null && this.structureLog.getStrmod10().equals("90000")) {
         this.afficheTreso = true;
      }

      this.calculeLibEntete();
   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void calculeLibEntete() {
      if (this.structureLog.getStrtypeentreprise().equals("2")) {
         this.moduleUsine = true;
      }

      if (this.rechercheModule(70000)) {
         this.moduleParc = true;
      }

      if (this.rechercheModule(50000)) {
         this.modulePaye = true;
      }

      if (this.rechercheModule(40300)) {
         this.moduleProjet = true;
      }

      if (this.structureLog.getStrmaitrecabinet() == 12) {
         this.moduleStructure = true;
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

   public void chargerLesRepImpAchats() {
      this.lesRepImpression.clear();
      this.mesModelesAchats.clear();
      if (this.afficheAchat) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "fournisseur";
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         int var4;
         String var5;
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (!var3[var4].equalsIgnoreCase(".svn")) {
                  var5 = "";
                  var5 = var3[var4].toUpperCase();
                  this.lesRepImpression.add(var5);
               }
            }
         }

         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "produits";
         var2 = new File(var1);
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (!var3[var4].equalsIgnoreCase(".svn")) {
                  this.nomRepertoire = "";
                  this.nomRepertoire = var3[var4].toUpperCase();
                  this.lesRepImpression.add(this.nomRepertoire);
               }
            }
         }

         if (this.lesRepImpression.size() != 0) {
            for(var4 = 0; var4 < this.lesRepImpression.size(); ++var4) {
               this.nomRepertoire = ((String)this.lesRepImpression.get(var4)).toLowerCase();
               var5 = null;
               String var6 = "";
               if (this.nomRepertoire.contains("ligne_")) {
                  var6 = "produits";
                  var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "produits" + File.separator + this.nomRepertoire;
               } else {
                  var6 = "fournisseur";
                  var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "achats" + File.separator + "fournisseur" + File.separator + this.nomRepertoire;
               }

               File var7 = new File(var5);
               String[] var8 = var7.list();
               if (var8 != null) {
                  var8 = this.triAlphabetique(var8, var8.length);

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     if (var8[var9].endsWith("jasper")) {
                        String var10 = var6 + ":" + this.nomRepertoire + ":" + var8[var9].substring(0, var8[var9].indexOf("."));
                        this.mesModelesAchats.add(new SelectItem(var10));
                     }
                  }
               }
            }
         }
      }

   }

   public void chargerLesRepImpStocks() {
      this.lesRepImpression.clear();
      this.mesModelesStocks.clear();
      if (this.afficheAchat) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "stock";
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         int var4;
         String var5;
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (!var3[var4].equalsIgnoreCase(".svn")) {
                  var5 = "";
                  var5 = var3[var4].toUpperCase();
                  this.lesRepImpression.add(var5);
               }
            }
         }

         if (this.lesRepImpression.size() != 0) {
            for(var4 = 0; var4 < this.lesRepImpression.size(); ++var4) {
               this.nomRepertoire = ((String)this.lesRepImpression.get(var4)).toLowerCase();
               var5 = null;
               String var6 = this.nomRepertoire;
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "stock" + File.separator + this.nomRepertoire;
               File var7 = new File(var5);
               String[] var8 = var7.list();
               if (var8 != null) {
                  var8 = this.triAlphabetique(var8, var8.length);

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     if (var8[var9].endsWith("jasper")) {
                        String var10 = var6 + ":" + this.nomRepertoire + ":" + var8[var9].substring(0, var8[var9].indexOf("."));
                        this.mesModelesStocks.add(new SelectItem(var10));
                     }
                  }
               }
            }
         }
      }

   }

   public void chargerLesRepImpVentes() {
      this.lesRepImpression.clear();
      this.mesModelesVentes.clear();
      if (this.afficheVente) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client";
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         int var4;
         String var5;
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (!var3[var4].equalsIgnoreCase(".svn")) {
                  var5 = "";
                  var5 = var3[var4].toUpperCase();
                  this.lesRepImpression.add(var5);
               }
            }
         }

         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits";
         var2 = new File(var1);
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (!var3[var4].equalsIgnoreCase(".svn")) {
                  this.nomRepertoire = "";
                  this.nomRepertoire = var3[var4].toUpperCase();
                  this.lesRepImpression.add(this.nomRepertoire);
               }
            }
         }

         if (this.lesRepImpression.size() != 0) {
            for(var4 = 0; var4 < this.lesRepImpression.size(); ++var4) {
               this.nomRepertoire = ((String)this.lesRepImpression.get(var4)).toLowerCase();
               var5 = null;
               String var6 = "";
               if (this.nomRepertoire.contains("ligne_")) {
                  var6 = "produits";
                  var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "produits" + File.separator + this.nomRepertoire;
               } else {
                  var6 = "client";
                  var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "client" + File.separator + this.nomRepertoire;
               }

               File var7 = new File(var5);
               String[] var8 = var7.list();
               if (var8 != null) {
                  var8 = this.triAlphabetique(var8, var8.length);

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     if (var8[var9].endsWith("jasper")) {
                        String var10 = var6 + ":" + this.nomRepertoire + ":" + var8[var9].substring(0, var8[var9].indexOf("."));
                        this.mesModelesVentes.add(new SelectItem(var10));
                     }
                  }
               }
            }
         }
      }

   }

   public void chargerLesRepImpTreso() {
      this.lesRepImpression.clear();
      this.mesModelesTresorerie.clear();
      if (this.afficheTreso) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "operation";
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         int var4;
         String var5;
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               if (!var3[var4].equalsIgnoreCase(".svn")) {
                  var5 = "";
                  var5 = var3[var4].toUpperCase();
                  this.lesRepImpression.add(var5);
               }
            }
         }

         if (this.lesRepImpression.size() != 0) {
            for(var4 = 0; var4 < this.lesRepImpression.size(); ++var4) {
               this.nomRepertoire = ((String)this.lesRepImpression.get(var4)).toLowerCase();
               var5 = null;
               String var6 = "operation";
               var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "impression" + File.separator + "fr" + File.separator + "caisses" + File.separator + "operation" + File.separator + this.nomRepertoire;
               File var7 = new File(var5);
               String[] var8 = var7.list();
               if (var8 != null) {
                  var8 = this.triAlphabetique(var8, var8.length);

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     if (var8[var9].endsWith("jasper")) {
                        String var10 = var6 + ":" + this.nomRepertoire + ":" + var8[var9].substring(0, var8[var9].indexOf("."));
                        this.mesModelesTresorerie.add(new SelectItem(var10));
                     }
                  }
               }
            }
         }
      }

   }

   public void creerOptionTiers() throws IOException {
      this.racine.removeContent();
      Element var1 = new Element("gestionComm");
      this.racine.addContent(var1);
      var1.setText(this.optionTiers.getGestionComm());
      Element var2 = new Element("affFicheTiers");
      this.racine.addContent(var2);
      var2.setText(this.optionTiers.getAffFicheTiers());
      Element var3 = new Element("affMessagerie");
      this.racine.addContent(var3);
      var3.setText(this.optionTiers.getAffMessagerie());
      Element var4 = new Element("affCadeaux");
      this.racine.addContent(var4);
      var4.setText(this.optionTiers.getAffCadeaux());
      Element var5 = new Element("nbLigneMaxTi");
      this.racine.addContent(var5);
      var5.setText(this.optionTiers.getNbLigneMaxTi());
      Element var6 = new Element("nbLigneMaxMs");
      this.racine.addContent(var6);
      var6.setText(this.optionTiers.getNbLigneMaxMs());
      Element var7 = new Element("nbLigneMaxCad");
      this.racine.addContent(var7);
      var7.setText(this.optionTiers.getNbLigneMaxCad());
      Element var8 = new Element("chargementListe");
      this.racine.addContent(var8);
      var8.setText(this.optionTiers.getChargementListe());
      Element var9 = new Element("nbJoursPasses");
      this.racine.addContent(var9);
      var9.setText(this.optionTiers.getNbJoursPasses());
      Element var10 = new Element("saisieCourrier");
      this.racine.addContent(var10);
      var10.setText(this.optionTiers.getSaisieCourrier());
      Element var11 = new Element("ongletContact");
      this.racine.addContent(var11);
      var11.setText(this.optionTiers.getOngletContact());
      Element var12 = new Element("ongletColaborateur");
      this.racine.addContent(var12);
      var12.setText(this.optionTiers.getOngletColaborateur());
      Element var13 = new Element("majTodo");
      this.racine.addContent(var13);
      var13.setText(this.optionTiers.getMajTodo());
      Element var14 = new Element("zoneObligatoire");
      this.racine.addContent(var14);
      var14.setText(this.optionTiers.getZoneObligatoire());
      Element var15 = new Element("lib1");
      this.racine.addContent(var15);
      var15.setText(this.optionTiers.getLib1());
      Element var16 = new Element("lib2");
      this.racine.addContent(var16);
      var16.setText(this.optionTiers.getLib2());
      Element var17 = new Element("lib3");
      this.racine.addContent(var17);
      var17.setText(this.optionTiers.getLib3());
      Element var18 = new Element("lib4");
      this.racine.addContent(var18);
      var18.setText(this.optionTiers.getLib4());
      Element var19 = new Element("lib5");
      this.racine.addContent(var19);
      var19.setText(this.optionTiers.getLib5());
      Element var20 = new Element("lib6");
      this.racine.addContent(var20);
      var20.setText(this.optionTiers.getLib6());
      Element var21 = new Element("lib7");
      this.racine.addContent(var21);
      var21.setText(this.optionTiers.getLib7());
      Element var22 = new Element("lib8");
      this.racine.addContent(var22);
      var22.setText(this.optionTiers.getLib8());
      Element var23 = new Element("lib9");
      this.racine.addContent(var23);
      var23.setText(this.optionTiers.getLib9());
      Element var24 = new Element("lib10");
      this.racine.addContent(var24);
      var24.setText(this.optionTiers.getLib10());
      Element var25 = new Element("modeleAch1");
      this.racine.addContent(var25);
      var25.setText(this.optionTiers.getModeleAch1());
      Element var26 = new Element("modeleAch2");
      this.racine.addContent(var26);
      var26.setText(this.optionTiers.getModeleAch2());
      Element var27 = new Element("modeleAch3");
      this.racine.addContent(var27);
      var27.setText(this.optionTiers.getModeleAch3());
      Element var28 = new Element("modeleAch4");
      this.racine.addContent(var28);
      var28.setText(this.optionTiers.getModeleAch4());
      Element var29 = new Element("modeleAch5");
      this.racine.addContent(var29);
      var29.setText(this.optionTiers.getModeleAch5());
      Element var30 = new Element("modeleAch6");
      this.racine.addContent(var30);
      var30.setText(this.optionTiers.getModeleAch6());
      Element var31 = new Element("modeleAch7");
      this.racine.addContent(var31);
      var31.setText(this.optionTiers.getModeleAch7());
      Element var32 = new Element("modeleAch8");
      this.racine.addContent(var32);
      var32.setText(this.optionTiers.getModeleAch8());
      Element var33 = new Element("modeleAch9");
      this.racine.addContent(var33);
      var33.setText(this.optionTiers.getModeleAch9());
      Element var34 = new Element("modeleAch10");
      this.racine.addContent(var34);
      var34.setText(this.optionTiers.getModeleAch10());
      Element var35 = new Element("modeleStk1");
      this.racine.addContent(var35);
      var35.setText(this.optionTiers.getModeleStk1());
      Element var36 = new Element("modeleStk2");
      this.racine.addContent(var36);
      var36.setText(this.optionTiers.getModeleStk2());
      Element var37 = new Element("modeleStk3");
      this.racine.addContent(var37);
      var37.setText(this.optionTiers.getModeleStk3());
      Element var38 = new Element("modeleStk4");
      this.racine.addContent(var38);
      var38.setText(this.optionTiers.getModeleStk4());
      Element var39 = new Element("modeleStk5");
      this.racine.addContent(var39);
      var39.setText(this.optionTiers.getModeleStk5());
      Element var40 = new Element("modeleStk6");
      this.racine.addContent(var40);
      var40.setText(this.optionTiers.getModeleStk6());
      Element var41 = new Element("modeleStk7");
      this.racine.addContent(var41);
      var41.setText(this.optionTiers.getModeleStk7());
      Element var42 = new Element("modeleStk8");
      this.racine.addContent(var42);
      var42.setText(this.optionTiers.getModeleStk8());
      Element var43 = new Element("modeleStk9");
      this.racine.addContent(var43);
      var43.setText(this.optionTiers.getModeleStk9());
      Element var44 = new Element("modeleStk10");
      this.racine.addContent(var44);
      var44.setText(this.optionTiers.getModeleStk10());
      Element var45 = new Element("modeleVte1");
      this.racine.addContent(var45);
      var45.setText(this.optionTiers.getModeleVte1());
      Element var46 = new Element("modeleVte2");
      this.racine.addContent(var46);
      var46.setText(this.optionTiers.getModeleVte2());
      Element var47 = new Element("modeleVte3");
      this.racine.addContent(var47);
      var47.setText(this.optionTiers.getModeleVte3());
      Element var48 = new Element("modeleVte4");
      this.racine.addContent(var48);
      var48.setText(this.optionTiers.getModeleVte4());
      Element var49 = new Element("modeleVte5");
      this.racine.addContent(var49);
      var49.setText(this.optionTiers.getModeleVte5());
      Element var50 = new Element("modeleVte6");
      this.racine.addContent(var50);
      var50.setText(this.optionTiers.getModeleVte6());
      Element var51 = new Element("modeleVte7");
      this.racine.addContent(var51);
      var51.setText(this.optionTiers.getModeleVte7());
      Element var52 = new Element("modeleVte8");
      this.racine.addContent(var52);
      var52.setText(this.optionTiers.getModeleVte8());
      Element var53 = new Element("modeleVte9");
      this.racine.addContent(var53);
      var53.setText(this.optionTiers.getModeleVte9());
      Element var54 = new Element("modeleVte10");
      this.racine.addContent(var54);
      var54.setText(this.optionTiers.getModeleVte10());
      Element var55 = new Element("modeleTre1");
      this.racine.addContent(var55);
      var55.setText(this.optionTiers.getModeleTre1());
      Element var56 = new Element("modeleTre2");
      this.racine.addContent(var56);
      var56.setText(this.optionTiers.getModeleTre2());
      Element var57 = new Element("modeleTre3");
      this.racine.addContent(var57);
      var57.setText(this.optionTiers.getModeleTre3());
      Element var58 = new Element("modeleTre4");
      this.racine.addContent(var58);
      var58.setText(this.optionTiers.getModeleTre4());
      Element var59 = new Element("modeleTre5");
      this.racine.addContent(var59);
      var59.setText(this.optionTiers.getModeleTre5());
      Element var60 = new Element("libAch1");
      this.racine.addContent(var60);
      var60.setText(this.optionTiers.getLibAch1());
      Element var61 = new Element("libAch2");
      this.racine.addContent(var61);
      var61.setText(this.optionTiers.getLibAch2());
      Element var62 = new Element("libAch3");
      this.racine.addContent(var62);
      var62.setText(this.optionTiers.getLibAch3());
      Element var63 = new Element("libAch4");
      this.racine.addContent(var63);
      var63.setText(this.optionTiers.getLibAch4());
      Element var64 = new Element("libAch5");
      this.racine.addContent(var64);
      var64.setText(this.optionTiers.getLibAch5());
      Element var65 = new Element("libAch6");
      this.racine.addContent(var65);
      var65.setText(this.optionTiers.getLibAch6());
      Element var66 = new Element("libAch7");
      this.racine.addContent(var66);
      var66.setText(this.optionTiers.getLibAch7());
      Element var67 = new Element("libAch8");
      this.racine.addContent(var67);
      var67.setText(this.optionTiers.getLibAch8());
      Element var68 = new Element("libAch9");
      this.racine.addContent(var68);
      var68.setText(this.optionTiers.getLibAch9());
      Element var69 = new Element("libAch10");
      this.racine.addContent(var69);
      var69.setText(this.optionTiers.getLibAch10());
      Element var70 = new Element("libStk1");
      this.racine.addContent(var70);
      var70.setText(this.optionTiers.getLibStk1());
      Element var71 = new Element("libStk2");
      this.racine.addContent(var71);
      var71.setText(this.optionTiers.getLibStk2());
      Element var72 = new Element("libStk3");
      this.racine.addContent(var72);
      var72.setText(this.optionTiers.getLibStk3());
      Element var73 = new Element("libStk4");
      this.racine.addContent(var73);
      var73.setText(this.optionTiers.getLibStk4());
      Element var74 = new Element("libStk5");
      this.racine.addContent(var74);
      var74.setText(this.optionTiers.getLibStk5());
      Element var75 = new Element("libStk6");
      this.racine.addContent(var75);
      var75.setText(this.optionTiers.getLibStk6());
      Element var76 = new Element("libStk7");
      this.racine.addContent(var76);
      var76.setText(this.optionTiers.getLibStk7());
      Element var77 = new Element("libStk8");
      this.racine.addContent(var77);
      var77.setText(this.optionTiers.getLibStk8());
      Element var78 = new Element("libStk9");
      this.racine.addContent(var78);
      var78.setText(this.optionTiers.getLibStk9());
      Element var79 = new Element("libStk10");
      this.racine.addContent(var79);
      var79.setText(this.optionTiers.getLibStk10());
      Element var80 = new Element("libVte1");
      this.racine.addContent(var80);
      var80.setText(this.optionTiers.getLibVte1());
      Element var81 = new Element("libVte2");
      this.racine.addContent(var81);
      var81.setText(this.optionTiers.getLibVte2());
      Element var82 = new Element("libVte3");
      this.racine.addContent(var82);
      var82.setText(this.optionTiers.getLibVte3());
      Element var83 = new Element("libVte4");
      this.racine.addContent(var83);
      var83.setText(this.optionTiers.getLibVte4());
      Element var84 = new Element("libVte5");
      this.racine.addContent(var84);
      var84.setText(this.optionTiers.getLibVte5());
      Element var85 = new Element("libVte6");
      this.racine.addContent(var85);
      var85.setText(this.optionTiers.getLibVte6());
      Element var86 = new Element("libVte7");
      this.racine.addContent(var86);
      var86.setText(this.optionTiers.getLibVte7());
      Element var87 = new Element("libVte8");
      this.racine.addContent(var87);
      var87.setText(this.optionTiers.getLibVte8());
      Element var88 = new Element("libVte9");
      this.racine.addContent(var88);
      var88.setText(this.optionTiers.getLibVte9());
      Element var89 = new Element("libVte10");
      this.racine.addContent(var89);
      var89.setText(this.optionTiers.getLibVte10());
      Element var90 = new Element("libTre1");
      this.racine.addContent(var90);
      var90.setText(this.optionTiers.getLibTre1());
      Element var91 = new Element("libTre2");
      this.racine.addContent(var91);
      var91.setText(this.optionTiers.getLibTre2());
      Element var92 = new Element("libTre3");
      this.racine.addContent(var92);
      var92.setText(this.optionTiers.getLibTre3());
      Element var93 = new Element("libTre4");
      this.racine.addContent(var93);
      var93.setText(this.optionTiers.getLibTre4());
      Element var94 = new Element("libTre5");
      this.racine.addContent(var94);
      var94.setText(this.optionTiers.getLibTre5());
      this.enregistre();
   }

   public String afficheALL() {
      List var1 = this.racine.getChildren();

      Element var3;
      for(Iterator var2 = var1.iterator(); var2.hasNext(); var3 = (Element)var2.next()) {
      }

      return "";
   }

   public void enregistre() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.labase + File.separator + "commun" + File.separator + "configuration" + File.separator + "optionTiers.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public String getLabase() {
      return this.labase;
   }

   public void setLabase(String var1) {
      this.labase = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public Users getUserlog() {
      return this.usersLog;
   }

   public void setUserlog(Users var1) {
      this.usersLog = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public List getMesModelesAchats() {
      return this.mesModelesAchats;
   }

   public void setMesModelesAchats(List var1) {
      this.mesModelesAchats = var1;
   }

   public List getMesModelesTresorerie() {
      return this.mesModelesTresorerie;
   }

   public void setMesModelesTresorerie(List var1) {
      this.mesModelesTresorerie = var1;
   }

   public List getMesModelesVentes() {
      return this.mesModelesVentes;
   }

   public void setMesModelesVentes(List var1) {
      this.mesModelesVentes = var1;
   }

   public boolean isAfficheAchat() {
      return this.afficheAchat;
   }

   public void setAfficheAchat(boolean var1) {
      this.afficheAchat = var1;
   }

   public boolean isAfficheTreso() {
      return this.afficheTreso;
   }

   public void setAfficheTreso(boolean var1) {
      this.afficheTreso = var1;
   }

   public boolean isAfficheVente() {
      return this.afficheVente;
   }

   public void setAfficheVente(boolean var1) {
      this.afficheVente = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public List getMesModelesStocks() {
      return this.mesModelesStocks;
   }

   public void setMesModelesStocks(List var1) {
      this.mesModelesStocks = var1;
   }

   public boolean isModuleParc() {
      return this.moduleParc;
   }

   public void setModuleParc(boolean var1) {
      this.moduleParc = var1;
   }

   public boolean isModulePaye() {
      return this.modulePaye;
   }

   public void setModulePaye(boolean var1) {
      this.modulePaye = var1;
   }

   public boolean isModuleProjet() {
      return this.moduleProjet;
   }

   public void setModuleProjet(boolean var1) {
      this.moduleProjet = var1;
   }

   public boolean isModuleStructure() {
      return this.moduleStructure;
   }

   public void setModuleStructure(boolean var1) {
      this.moduleStructure = var1;
   }

   public boolean isModuleUsine() {
      return this.moduleUsine;
   }

   public void setModuleUsine(boolean var1) {
      this.moduleUsine = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }
}
