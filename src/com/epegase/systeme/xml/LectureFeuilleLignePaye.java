package com.epegase.systeme.xml;

import com.epegase.systeme.classe.FeuilleCalculRubrique;
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

public class LectureFeuilleLignePaye implements Serializable {
   private Structure structureLog;
   private FeuilleCalculRubrique objetLigne;
   private List mesFeuillesLignes;

   public void recuperePaye() {
      this.mesFeuillesLignes = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "feuilleCalcul" + File.separator + "feuille_ligne_" + this.structureLog.getStrcodepays() + ".xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.objetLigne = new FeuilleCalculRubrique();
               if (((Element)var6.get(var7)).getChild("feurub_actif").getText().equals("1")) {
                  this.objetLigne.setFeurubActif(true);
               } else {
                  this.objetLigne.setFeurubActif(false);
               }

               this.objetLigne.setFeurubCode(((Element)var6.get(var7)).getChild("feurub_code").getText());
               if (((Element)var6.get(var7)).getChild("feurub_colA").getText().equals("1")) {
                  this.objetLigne.setFeurubColA(true);
               } else {
                  this.objetLigne.setFeurubColA(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colA_raz").getText().equals("1")) {
                  this.objetLigne.setFeurubColARaz(true);
               } else {
                  this.objetLigne.setFeurubColARaz(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colB").getText().equals("1")) {
                  this.objetLigne.setFeurubColB(true);
               } else {
                  this.objetLigne.setFeurubColB(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colB_raz").getText().equals("1")) {
                  this.objetLigne.setFeurubColBRaz(true);
               } else {
                  this.objetLigne.setFeurubColBRaz(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colC").getText().equals("1")) {
                  this.objetLigne.setFeurubColC(true);
               } else {
                  this.objetLigne.setFeurubColC(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colC_raz").getText().equals("1")) {
                  this.objetLigne.setFeurubColCRaz(true);
               } else {
                  this.objetLigne.setFeurubColCRaz(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colD").getText().equals("1")) {
                  this.objetLigne.setFeurubColD(true);
               } else {
                  this.objetLigne.setFeurubColD(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colD_raz").getText().equals("1")) {
                  this.objetLigne.setFeurubColDRaz(true);
               } else {
                  this.objetLigne.setFeurubColDRaz(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colE").getText().equals("1")) {
                  this.objetLigne.setFeurubColE(true);
               } else {
                  this.objetLigne.setFeurubColE(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_colE_raz").getText().equals("1")) {
                  this.objetLigne.setFeurubColERaz(true);
               } else {
                  this.objetLigne.setFeurubColERaz(false);
               }

               this.objetLigne.setFeurubCompte(((Element)var6.get(var7)).getChild("feurub_compte").getText());
               this.objetLigne.setFeurubFeuille(((Element)var6.get(var7)).getChild("feurub_feuille").getText());
               if (((Element)var6.get(var7)).getChild("feurub_variableA").getText().equals("1")) {
                  this.objetLigne.setFeurubVariableA(true);
               } else {
                  this.objetLigne.setFeurubVariableA(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_variableB").getText().equals("1")) {
                  this.objetLigne.setFeurubVariableB(true);
               } else {
                  this.objetLigne.setFeurubVariableB(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_variableC").getText().equals("1")) {
                  this.objetLigne.setFeurubVariableC(true);
               } else {
                  this.objetLigne.setFeurubVariableC(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_variableD").getText().equals("1")) {
                  this.objetLigne.setFeurubVariableD(true);
               } else {
                  this.objetLigne.setFeurubVariableD(false);
               }

               if (((Element)var6.get(var7)).getChild("feurub_variableE").getText().equals("1")) {
                  this.objetLigne.setFeurubVariableE(true);
               } else {
                  this.objetLigne.setFeurubVariableE(false);
               }

               this.mesFeuillesLignes.add(this.objetLigne);
            }

            var3.close();
         }
      } catch (JDOMException var8) {
      } catch (IOException var9) {
      }

   }

   public List getMesFeuillesLignes() {
      return this.mesFeuillesLignes;
   }

   public void setMesFeuillesLignes(List var1) {
      this.mesFeuillesLignes = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
