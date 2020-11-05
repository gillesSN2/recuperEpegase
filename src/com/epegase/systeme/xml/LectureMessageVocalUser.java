package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class LectureMessageVocalUser implements Serializable {
   private ObjetMessageVocalUser objetMessageVocalUser;
   private List lesMessagesVaocauxUsers;
   Element racine;
   Document document;

   public List recupererMessageVocalUser(long var1, long var3, String var5) {
      this.lesMessagesVaocauxUsers = new ArrayList();

      try {
         File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "users" + File.separator + "messageVocal");
         if (!var6.exists()) {
            var6.mkdir();
         }

         File var7 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "users" + File.separator + "messageVocal" + File.separator + var3 + "_" + var5);
         if (var7.exists()) {
            SAXBuilder var8 = new SAXBuilder();
            FileReader var9 = new FileReader(var7);
            Document var10 = var8.build(var9);
            Element var11 = var10.getRootElement();
            List var12 = var11.getChildren();

            for(int var13 = 0; var13 < var12.size(); ++var13) {
               this.objetMessageVocalUser = new ObjetMessageVocalUser();
               String var14 = ((Element)var12.get(var13)).getChild("dateJour").getText();
               String var15 = ((Element)var12.get(var13)).getChild("heure").getText();
               String var16 = ((Element)var12.get(var13)).getChild("time").getText();
               String var17 = ((Element)var12.get(var13)).getChild("condit1").getText();
               String var18 = ((Element)var12.get(var13)).getChild("condit2").getText();
               String var19 = ((Element)var12.get(var13)).getChild("message").getText();
               this.objetMessageVocalUser.setDateJour(var14);
               this.objetMessageVocalUser.setHeure(var15);
               this.objetMessageVocalUser.setTime(var16);
               this.objetMessageVocalUser.setCondit1(var17);
               this.objetMessageVocalUser.setCondit2(var18);
               this.objetMessageVocalUser.setMessage(var19);
               this.lesMessagesVaocauxUsers.add(this.objetMessageVocalUser);
            }

            var9.close();
         }
      } catch (JDOMException var20) {
      } catch (IOException var21) {
      }

      return this.lesMessagesVaocauxUsers;
   }

   public void ecritureMessageUser(long var1, long var3, String var5, String var6, String var7, String var8, String var9, String var10, List var11) throws IOException, JDOMException {
      String var12 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1 + File.separator + "users" + File.separator + "messageVocal" + File.separator + var3 + "_" + var7;
      File var13 = new File(var12);
      if (!var13.exists()) {
         this.racine = new Element("message");
         this.document = new Document(this.racine);
         this.enregistre(var12);
      } else {
         this.racine = new Element("message");
         this.document = new Document(this.racine);
         Element var14 = new Element("type");
         this.racine.addContent(var14);
      }

      if (var10 != null && !var10.isEmpty()) {
         this.objetMessageVocalUser = new ObjetMessageVocalUser();
         this.objetMessageVocalUser.setDateJour(var7);
         this.objetMessageVocalUser.setHeure(var8);
         this.objetMessageVocalUser.setTime(var9);
         this.objetMessageVocalUser.setCondit1(var5);
         this.objetMessageVocalUser.setCondit2(var6);
         this.objetMessageVocalUser.setMessage(var10);
         var11.add(this.objetMessageVocalUser);
      }

      SAXBuilder var25 = new SAXBuilder();

      try {
         this.document = var25.build(var12);
         this.racine = this.document.getRootElement();
         this.racine.removeContent();
         if (var11 != null && var11.size() != 0) {
            this.objetMessageVocalUser = new ObjetMessageVocalUser();

            for(int var15 = 0; var15 < var11.size(); ++var15) {
               this.objetMessageVocalUser = (ObjetMessageVocalUser)var11.get(var15);
               if (this.objetMessageVocalUser.getMessage() != null && !this.objetMessageVocalUser.getMessage().isEmpty()) {
                  Element var16 = new Element("type");
                  Element var17 = new Element("dateJour");
                  Element var18 = new Element("heure");
                  Element var19 = new Element("time");
                  Element var20 = new Element("condit1");
                  Element var21 = new Element("condit2");
                  Element var22 = new Element("message");
                  var17.setText(this.objetMessageVocalUser.getDateJour());
                  var18.setText(this.objetMessageVocalUser.getHeure());
                  var19.setText(this.objetMessageVocalUser.getTime());
                  var20.setText(this.objetMessageVocalUser.getCondit1());
                  var21.setText(this.objetMessageVocalUser.getCondit2());
                  var22.setText(this.objetMessageVocalUser.getMessage());
                  var16.addContent(var17);
                  var16.addContent(var18);
                  var16.addContent(var19);
                  var16.addContent(var20);
                  var16.addContent(var21);
                  var16.addContent(var22);
                  this.racine.addContent(var16);
               }
            }

            this.enregistre(var12);
         }
      } catch (IOException var23) {
      } catch (JDOMException var24) {
      }

   }

   public void enregistre(String var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public List getLesMessagesVaocauxUsers() {
      return this.lesMessagesVaocauxUsers;
   }

   public void setLesMessagesVaocauxUsers(List var1) {
      this.lesMessagesVaocauxUsers = var1;
   }
}
