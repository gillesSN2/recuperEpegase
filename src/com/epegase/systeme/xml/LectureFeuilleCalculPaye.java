package com.epegase.systeme.xml;

import com.epegase.systeme.classe.FeuilleCalcul;
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

public class LectureFeuilleCalculPaye implements Serializable {
   private Structure structureLog;
   private FeuilleCalcul objetFeuille;
   private List mesFeuilles;

   public void recuperePaye() {
      this.mesFeuilles = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "feuilleCalcul" + File.separator + "feuille_" + this.structureLog.getStrcodepays() + ".xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.objetFeuille = new FeuilleCalcul();
               this.objetFeuille.setFeuCode(((Element)var6.get(var7)).getChild("feu_code").getText());
               this.objetFeuille.setFeuCompte(((Element)var6.get(var7)).getChild("feu_compte").getText());
               if (this.objetFeuille.getFeuCompte() != null && !this.objetFeuille.getFeuCompte().isEmpty() && this.objetFeuille.getFeuCompte().equalsIgnoreCase("null")) {
                  this.objetFeuille.setFeuCompte("");
               }

               this.objetFeuille.setFeuDecale(Integer.parseInt(((Element)var6.get(var7)).getChild("feu_decale").getText()));
               this.objetFeuille.setFeuInactif(Integer.parseInt(((Element)var6.get(var7)).getChild("feu_inactif").getText()));
               this.objetFeuille.setFeuJournal(((Element)var6.get(var7)).getChild("feu_journal").getText());
               if (this.objetFeuille.getFeuJournal() != null && !this.objetFeuille.getFeuJournal().isEmpty() && this.objetFeuille.getFeuJournal().equalsIgnoreCase("null")) {
                  this.objetFeuille.setFeuJournal("");
               }

               this.objetFeuille.setFeuLibelleFr(((Element)var6.get(var7)).getChild("feu_libelle_FR").getText());
               this.objetFeuille.setFeuLibelleSp(((Element)var6.get(var7)).getChild("feu_libelle_SP").getText());
               if (this.objetFeuille.getFeuLibelleSp() != null && !this.objetFeuille.getFeuLibelleSp().isEmpty() && this.objetFeuille.getFeuLibelleSp().equalsIgnoreCase("null")) {
                  this.objetFeuille.setFeuLibelleSp("");
               }

               this.objetFeuille.setFeuLibelleUk(((Element)var6.get(var7)).getChild("feu_libelle_UK").getText());
               if (this.objetFeuille.getFeuLibelleUk() != null && !this.objetFeuille.getFeuLibelleUk().isEmpty() && this.objetFeuille.getFeuLibelleUk().equalsIgnoreCase("null")) {
                  this.objetFeuille.setFeuLibelleUk("");
               }

               this.objetFeuille.setFeuModele(((Element)var6.get(var7)).getChild("feu_modele").getText());
               if (this.objetFeuille.getFeuModele() != null && !this.objetFeuille.getFeuModele().isEmpty() && this.objetFeuille.getFeuModele().equalsIgnoreCase("null")) {
                  this.objetFeuille.setFeuModele("");
               }

               this.objetFeuille.setFeuModeleMat(((Element)var6.get(var7)).getChild("feu_modele_mat").getText());
               if (this.objetFeuille.getFeuModeleMat() != null && !this.objetFeuille.getFeuModeleMat().isEmpty() && this.objetFeuille.getFeuModeleMat().equalsIgnoreCase("null")) {
                  this.objetFeuille.setFeuModeleMat("");
               }

               this.objetFeuille.setFeuNature(((Element)var6.get(var7)).getChild("feu_nature").getText());
               if (this.objetFeuille.getFeuInactif() == 0) {
                  this.mesFeuilles.add(this.objetFeuille);
               }
            }

            var3.close();
         }
      } catch (JDOMException var8) {
      } catch (IOException var9) {
      }

   }

   public List getMesFeuilles() {
      return this.mesFeuilles;
   }

   public void setMesFeuilles(List var1) {
      this.mesFeuilles = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
