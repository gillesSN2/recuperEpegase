package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class LireLesoptionsGroupe implements Serializable {
   private long strId;
   private OptionGroupe optionGroupe;
   private Element racine = new Element("optionGroupe");
   private Document document;

   public LireLesoptionsGroupe() {
      this.document = new Document(this.racine);
      this.optionGroupe = new OptionGroupe();
   }

   public OptionGroupe lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator);
         if (!var2.exists()) {
            var2.mkdir();
            var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration");
            if (!var2.exists()) {
               var2.mkdir();
            }
         }

         var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + this.strId + ".xml");
         if (!var2.exists()) {
            this.enregistrer();
         }

         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         if (var5.getChildText("typeGroupe") != null && !var5.getChildText("typeGroupe").isEmpty()) {
            this.optionGroupe.setTypeGroupe(var5.getChildText("typeGroupe"));
         } else {
            this.optionGroupe.setTypeGroupe("0");
         }

         if (var5.getChildText("idGroupe") != null && !var5.getChildText("idGroupe").isEmpty()) {
            this.optionGroupe.setIdGroupe(var5.getChildText("idGroupe"));
         } else {
            this.optionGroupe.setIdGroupe("0");
         }

         if (var5.getChildText("synchroTiers") != null && !var5.getChildText("synchroTiers").isEmpty()) {
            this.optionGroupe.setSynchroTiers(var5.getChildText("synchroTiers"));
         } else {
            this.optionGroupe.setSynchroTiers("0");
         }

         if (var5.getChildText("synchroOffice") != null && !var5.getChildText("synchroOffice").isEmpty()) {
            this.optionGroupe.setSynchroOffice(var5.getChildText("synchroOffice"));
         } else {
            this.optionGroupe.setSynchroOffice("0");
         }

         if (var5.getChildText("synchroProduits") != null && !var5.getChildText("synchroProduits").isEmpty()) {
            this.optionGroupe.setSynchroProduits(var5.getChildText("synchroProduits"));
         } else {
            this.optionGroupe.setSynchroProduits("0");
         }

         if (var5.getChildText("centralisationCompta") != null && !var5.getChildText("centralisationCompta").isEmpty()) {
            this.optionGroupe.setCentralisationCompta(var5.getChildText("centralisationCompta"));
         } else {
            this.optionGroupe.setCentralisationCompta("0");
         }

         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.optionGroupe;
   }

   public OptionGroupe lancerExploitation() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = null;
         int var3 = ("" + this.strId).length();
         String var4 = "" + this.strId;

         for(int var5 = var3; var5 != 0; --var5) {
            String var6 = var4.substring(0, var5);
            var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + var6 + ".xml");
            if (var2.exists()) {
               break;
            }
         }

         if (var2.exists()) {
            FileReader var10 = new FileReader(var2);
            Document var11 = var1.build(var10);
            Element var7 = var11.getRootElement();
            if (var7.getChildText("typeGroupe") != null && !var7.getChildText("typeGroupe").isEmpty()) {
               this.optionGroupe.setTypeGroupe(var7.getChildText("typeGroupe"));
            } else {
               this.optionGroupe.setTypeGroupe("0");
            }

            if (var7.getChildText("idGroupe") != null && !var7.getChildText("idGroupe").isEmpty()) {
               this.optionGroupe.setIdGroupe(var7.getChildText("idGroupe"));
            } else {
               this.optionGroupe.setIdGroupe("0");
            }

            this.optionGroupe.setNomGroupe(var7.getChildText("nomGroupe"));
            if (var7.getChildText("synchroTiers") != null && !var7.getChildText("synchroTiers").isEmpty()) {
               this.optionGroupe.setSynchroTiers(var7.getChildText("synchroTiers"));
            } else {
               this.optionGroupe.setSynchroTiers("0");
            }

            if (var7.getChildText("synchroOffice") != null && !var7.getChildText("synchroOffice").isEmpty()) {
               this.optionGroupe.setSynchroOffice(var7.getChildText("synchroOffice"));
            } else {
               this.optionGroupe.setSynchroOffice("0");
            }

            if (var7.getChildText("synchroProduits") != null && !var7.getChildText("synchroProduits").isEmpty()) {
               this.optionGroupe.setSynchroProduits(var7.getChildText("synchroProduits"));
            } else {
               this.optionGroupe.setSynchroProduits("0");
            }

            if (var7.getChildText("centralisationCompta") != null && !var7.getChildText("centralisationCompta").isEmpty()) {
               this.optionGroupe.setCentralisationCompta(var7.getChildText("centralisationCompta"));
            } else {
               this.optionGroupe.setCentralisationCompta("0");
            }

            var10.close();
         } else {
            this.optionGroupe = new OptionGroupe();
         }
      } catch (JDOMException var8) {
      } catch (IOException var9) {
      }

      return this.optionGroupe;
   }

   public void creerOptionGroupe(int var1) throws IOException {
      this.racine.removeContent();
      if (var1 == 1 || var1 == 5) {
         this.optionGroupe.setSynchroTiers("0");
         this.optionGroupe.setSynchroProduits("0");
         this.optionGroupe.setSynchroOffice("0");
         this.optionGroupe.setCentralisationCompta("0");
      }

      Element var2 = new Element("typeGroupe");
      this.racine.addContent(var2);
      var2.setText("" + this.optionGroupe.getTypeGroupe());
      Element var3 = new Element("idGroupe");
      this.racine.addContent(var3);
      var3.setText("" + this.optionGroupe.getIdGroupe());
      Element var4 = new Element("nomGroupe");
      this.racine.addContent(var4);
      var4.setText(this.optionGroupe.getNomGroupe());
      Element var5 = new Element("synchroTiers");
      this.racine.addContent(var5);
      var5.setText("" + this.optionGroupe.getSynchroTiers());
      Element var6 = new Element("synchroOffice");
      this.racine.addContent(var6);
      var6.setText("" + this.optionGroupe.getSynchroOffice());
      Element var7 = new Element("synchroProduits");
      this.racine.addContent(var7);
      var7.setText("" + this.optionGroupe.getSynchroProduits());
      Element var8 = new Element("centralisationCompta");
      this.racine.addContent(var8);
      var8.setText("" + this.optionGroupe.getCentralisationCompta());
      this.enregistrer();
   }

   public void enregistrer() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "groupe" + File.separator + "configuration" + File.separator + "optionsGroupe_" + this.strId + ".xml");
      var1.output(this.getDocument(), var2);
      var2.close();
   }

   public OptionGroupe getOptionGroupe() {
      return this.optionGroupe;
   }

   public void setOptionGroupe(OptionGroupe var1) {
      this.optionGroupe = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }
}
