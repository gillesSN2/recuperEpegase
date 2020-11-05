package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureMessageVocalCommun implements Serializable {
   private ObjetMessageVocalCommun objetMessageVocalCommun;
   private List lesMessagesVaocauxComun;

   public LectureMessageVocalCommun() {
      this.recupererMessageVocal();
   }

   public void recupererMessageVocal() {
      this.lesMessagesVaocauxComun = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "messageVocal.xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.objetMessageVocalCommun = new ObjetMessageVocalCommun();
               int var8 = Integer.parseInt(((Element)var6.get(var7)).getChild("heureDebut").getText());
               int var9 = Integer.parseInt(((Element)var6.get(var7)).getChild("heureFin").getText());
               String var10 = ((Element)var6.get(var7)).getChild("condit1").getText();
               String var11 = ((Element)var6.get(var7)).getChild("condit2").getText();
               String var12 = ((Element)var6.get(var7)).getChild("message").getText();
               this.objetMessageVocalCommun.setHeureDebut(var8);
               this.objetMessageVocalCommun.setHeureFin(var9);
               this.objetMessageVocalCommun.setCondit1(var10);
               this.objetMessageVocalCommun.setCondit2(var11);
               this.objetMessageVocalCommun.setMessage(var12);
               this.lesMessagesVaocauxComun.add(this.objetMessageVocalCommun);
            }

            var3.close();
         }
      } catch (JDOMException var13) {
      } catch (IOException var14) {
      }

   }

   public List getLesMessagesVaocauxComun() {
      return this.lesMessagesVaocauxComun;
   }

   public void setLesMessagesVaocauxComun(List var1) {
      this.lesMessagesVaocauxComun = var1;
   }
}
