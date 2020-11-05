package com.epegase.systeme.xml;

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

public class LectureModeleAutorise implements Serializable {
   private List lesModelesAutorises = new ArrayList();

   public LectureModeleAutorise(String var1) {
      this.recupereDestination(var1);
   }

   public void recupereDestination(String var1) {
      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(var1);
         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         this.lesModelesAutorises = new ArrayList();
         List var7 = var6.getChildren();

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            String var9 = ((Element)var7.get(var8)).getChild("modele").getText();
            this.lesModelesAutorises.add(var9);
         }

         var4.close();
      } catch (JDOMException var10) {
      } catch (IOException var11) {
      }

   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }
}
