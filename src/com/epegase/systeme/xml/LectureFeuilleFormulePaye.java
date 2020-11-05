package com.epegase.systeme.xml;

import com.epegase.systeme.classe.FeuilleCalculFormule;
import com.epegase.systeme.classe.Structure;
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

public class LectureFeuilleFormulePaye implements Serializable {
   private Structure structureLog;
   private FeuilleCalculFormule objetFormule;
   private List mesFeuillesFormules;

   public void recuperePaye() {
      this.mesFeuillesFormules = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "feuilleCalcul" + File.separator + "feuille_formule_" + this.structureLog.getStrcodepays() + ".xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.objetFormule = new FeuilleCalculFormule();
               this.objetFormule.setFeurubforCode(((Element)var6.get(var7)).getChild("feurubfor_code").getText());
               this.objetFormule.setFeurubforColonne(((Element)var6.get(var7)).getChild("feurubfor_colonne").getText());
               this.objetFormule.setFeurubforFeuille(((Element)var6.get(var7)).getChild("feurubfor_feullle").getText());
               this.objetFormule.setFeurubforFormule(((Element)var6.get(var7)).getChild("feurubfor_formule").getText());
               if (this.objetFormule.getFeurubforFormule() != null && !this.objetFormule.getFeurubforFormule().isEmpty() && this.objetFormule.getFeurubforFormule().equalsIgnoreCase("NULL")) {
                  this.objetFormule.setFeurubforFormule("");
               }

               this.mesFeuillesFormules.add(this.objetFormule);
            }

            var3.close();
         }
      } catch (JDOMException var8) {
      } catch (IOException var9) {
      }

   }

   public List getMesFeuillesFormules() {
      return this.mesFeuillesFormules;
   }

   public void setMesFeuillesFormules(List var1) {
      this.mesFeuillesFormules = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
