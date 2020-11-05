package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LireVersion implements Serializable {
   private Version version;

   public Version lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "update" + File.separator + "version.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.version = new Version();
         this.version.setVersion_numero(var5.getChildText("numero"));
         this.version.setVersion_date(var5.getChildText("date"));
         this.version.setVersion_internet(var5.getChildText("internet"));
         this.version.setVersion_os(var5.getChildText("os"));
         this.version.setVersion_base(var5.getChildText("base"));
         this.version.setVersion_serveur(var5.getChildText("serveur"));
         this.version.setVersion_imageStartup(var5.getChildText("imageStartup"));
         this.version.setVersion_pageStartup(var5.getChildText("pageAccueil"));
         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      return this.version;
   }
}
