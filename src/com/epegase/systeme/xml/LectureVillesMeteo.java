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

public class LectureVillesMeteo implements Serializable {
   private ObjetPays ville;
   private List mesvilles = new ArrayList();

   public LectureVillesMeteo() {
      this.recupereLesVilles();
   }

   public void recupereLesVilles() {
      this.mesvilles = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "villesMeteo.xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.ville = new ObjetPays();
               this.ville.setIdentification(((Element)var6.get(var7)).getChild("codeVille").getText());
               this.ville.setNom_FR(((Element)var6.get(var7)).getChild("nomVille").getText());
               this.mesvilles.add(this.ville);
            }

            var3.close();
         }
      } catch (JDOMException var8) {
      } catch (IOException var9) {
      }

   }

   public ObjetPays trouveVilles(String var1) {
      this.ville = new ObjetPays();
      if (this.mesvilles.size() != 0) {
         for(int var2 = 0; var2 < this.mesvilles.size(); ++var2) {
            if (var1.contains(((ObjetPays)this.mesvilles.get(var2)).getNom_FR())) {
               this.ville = (ObjetPays)this.mesvilles.get(var2);
               break;
            }
         }
      }

      return this.ville;
   }

   public List getMesvilles() {
      return this.mesvilles;
   }

   public void setMesvilles(List var1) {
      this.mesvilles = var1;
   }

   public ObjetPays getVille() {
      return this.ville;
   }

   public void setVille(ObjetPays var1) {
      this.ville = var1;
   }
}
