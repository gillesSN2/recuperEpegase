package com.epegase.systeme.xml;

import com.epegase.systeme.classe.PlanPaye;
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

public class LecturePlanPaye implements Serializable {
   private Structure structureLog;
   private PlanPaye objetPaye;
   private List mesPlanPaye;

   public void recuperePaye() {
      this.mesPlanPaye = new ArrayList();

      try {
         File var1 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "planPaye" + File.separator + "plp_" + this.structureLog.getStrcodepays() + ".xml");
         if (var1.exists()) {
            SAXBuilder var2 = new SAXBuilder();
            FileReader var3 = new FileReader(var1);
            Document var4 = var2.build(var3);
            Element var5 = var4.getRootElement();
            List var6 = var5.getChildren();

            for(int var7 = 0; var7 < var6.size(); ++var7) {
               this.objetPaye = new PlanPaye();
               this.objetPaye.setPlpCode(((Element)var6.get(var7)).getChild("plp_code").getText());
               if (((Element)var6.get(var7)).getContent().size() == 81) {
                  this.objetPaye.setPlpCodeLie(((Element)var6.get(var7)).getChild("plp_codeLie").getText());
               } else {
                  this.objetPaye.setPlpCodeLie((String)null);
               }

               if (this.objetPaye.getPlpCodeLie() != null && !this.objetPaye.getPlpCodeLie().isEmpty() && this.objetPaye.getPlpCodeLie().equalsIgnoreCase("NULL")) {
                  this.objetPaye.setPlpCodeLie("");
               }

               this.objetPaye.setPlpLibelleFR(((Element)var6.get(var7)).getChild("plp_libelle_FR").getText());
               this.objetPaye.setPlpCommentaire(((Element)var6.get(var7)).getChild("plp_commentaire").getText());
               if (this.objetPaye.getPlpCommentaire() != null && !this.objetPaye.getPlpCommentaire().isEmpty() && this.objetPaye.getPlpCommentaire().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpCommentaire("");
               }

               this.objetPaye.setPlpNature(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_nature").getText()));
               this.objetPaye.setPlpLibelleNatureFR(((Element)var6.get(var7)).getChild("plp_libelle_nature_FR").getText());
               this.objetPaye.setPlpSens(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_sens").getText()));
               this.objetPaye.setPlpOption(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_option").getText()));
               this.objetPaye.setPlpGroupe(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_groupe").getText()));
               this.objetPaye.setPlpInactif(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_inactif").getText()));
               this.objetPaye.setPlpCompteNormal(((Element)var6.get(var7)).getChild("plp_compte_normal").getText());
               if (this.objetPaye.getPlpCompteNormal() != null && !this.objetPaye.getPlpCompteNormal().isEmpty() && this.objetPaye.getPlpCompteNormal().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpCompteNormal("");
               }

               this.objetPaye.setPlpComptePrestataire(((Element)var6.get(var7)).getChild("plp_compte_prestataire").getText());
               if (this.objetPaye.getPlpComptePrestataire() != null && !this.objetPaye.getPlpComptePrestataire().isEmpty() && this.objetPaye.getPlpComptePrestataire().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpComptePrestataire("");
               }

               this.objetPaye.setPlpCompteNormal(((Element)var6.get(var7)).getChild("plp_cp_normal").getText());
               if (this.objetPaye.getPlpCompteNormal() != null && !this.objetPaye.getPlpCompteNormal().isEmpty() && this.objetPaye.getPlpCompteNormal().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpCompteNormal("");
               }

               this.objetPaye.setPlpComptePrestataire(((Element)var6.get(var7)).getChild("plp_cp_prestataire").getText());
               if (this.objetPaye.getPlpComptePrestataire() != null && !this.objetPaye.getPlpComptePrestataire().isEmpty() && this.objetPaye.getPlpComptePrestataire().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpComptePrestataire("");
               }

               this.objetPaye.setPlpAnalytique(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_analytique").getText()));
               this.objetPaye.setPlpRan(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_ran").getText()));
               this.objetPaye.setPlpProtege(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_protege").getText()));
               if (((Element)var6.get(var7)).getChild("plp_base_fiscale").getText() != null && !((Element)var6.get(var7)).getChild("plp_base_fiscale").getText().isEmpty() && ((Element)var6.get(var7)).getChild("plp_base_fiscale").getText().equals("1")) {
                  this.objetPaye.setPlpBaseFiscale(true);
               } else {
                  this.objetPaye.setPlpBaseFiscale(false);
               }

               if (((Element)var6.get(var7)).getChild("plp_base_sociale").getText() != null && !((Element)var6.get(var7)).getChild("plp_base_sociale").getText().isEmpty() && ((Element)var6.get(var7)).getChild("plp_base_sociale").getText().equals("1")) {
                  this.objetPaye.setPlpBaseSociale(true);
               } else {
                  this.objetPaye.setPlpBaseSociale(false);
               }

               if (((Element)var6.get(var7)).getChild("plp_base_autre").getText() != null && !((Element)var6.get(var7)).getChild("plp_base_autre").getText().isEmpty() && ((Element)var6.get(var7)).getChild("plp_base_autre").getText().equals("1")) {
                  this.objetPaye.setPlpBaseAutre(true);
               } else {
                  this.objetPaye.setPlpBaseAutre(false);
               }

               if (((Element)var6.get(var7)).getChild("plp_base_patronale").getText() != null && !((Element)var6.get(var7)).getChild("plp_base_patronale").getText().isEmpty() && ((Element)var6.get(var7)).getChild("plp_base_patronale").getText().equals("1")) {
                  this.objetPaye.setPlpBasePatronale(true);
               } else {
                  this.objetPaye.setPlpBasePatronale(false);
               }

               this.objetPaye.setPlpTauxFiscale(Float.parseFloat(((Element)var6.get(var7)).getChild("plp_taux_fiscale").getText()));
               this.objetPaye.setPlpTauxSociale(Float.parseFloat(((Element)var6.get(var7)).getChild("plp_taux_sociale").getText()));
               this.objetPaye.setPlpTauxPatronal(Float.parseFloat(((Element)var6.get(var7)).getChild("plp_taux_patronal").getText()));
               this.objetPaye.setPlpFormuleFiscale(((Element)var6.get(var7)).getChild("plp_formule_fiscale").getText());
               if (this.objetPaye.getPlpFormuleFiscale() != null && !this.objetPaye.getPlpFormuleFiscale().isEmpty() && this.objetPaye.getPlpFormuleFiscale().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpFormuleFiscale("");
               }

               this.objetPaye.setPlpFormuleSociale(((Element)var6.get(var7)).getChild("plp_formule_sociale").getText());
               if (this.objetPaye.getPlpFormuleSociale() != null && !this.objetPaye.getPlpFormuleSociale().isEmpty() && this.objetPaye.getPlpFormuleSociale().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpFormuleSociale("");
               }

               this.objetPaye.setPlpFormulePatronale(((Element)var6.get(var7)).getChild("plp_formule_patronale").getText());
               if (this.objetPaye.getPlpFormulePatronale() != null && !this.objetPaye.getPlpFormulePatronale().isEmpty() && this.objetPaye.getPlpFormulePatronale().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpFormulePatronale("");
               }

               if (((Element)var6.get(var7)).getChild("plp_facture").getText() != null && !((Element)var6.get(var7)).getChild("plp_facture").getText().isEmpty() && ((Element)var6.get(var7)).getChild("plp_facture").getText().equals("1")) {
                  this.objetPaye.setPlpFacture(true);
               } else {
                  this.objetPaye.setPlpFacture(false);
               }

               this.objetPaye.setPlpProrataTemporis(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_prorata_temporis").getText()));
               this.objetPaye.setPlpCalculBase(((Element)var6.get(var7)).getChild("plp_calcul_base").getText());
               if (this.objetPaye.getPlpCalculBase() != null && !this.objetPaye.getPlpCalculBase().isEmpty() && this.objetPaye.getPlpCalculBase().equalsIgnoreCase("null")) {
                  this.objetPaye.setPlpCalculBase("");
               }

               this.objetPaye.setPlpGroupeCp(Integer.parseInt(((Element)var6.get(var7)).getChild("plp_groupe_cp").getText()));
               if (((Element)var6.get(var7)).getChild("plp_base_conges").getText() != null && !((Element)var6.get(var7)).getChild("plp_base_conges").getText().isEmpty() && ((Element)var6.get(var7)).getChild("plp_base_conges").getText().equals("1")) {
                  this.objetPaye.setPlpBaseConges(true);
               } else {
                  this.objetPaye.setPlpBaseConges(false);
               }

               if (this.objetPaye.getPlpInactif() == 0) {
                  this.mesPlanPaye.add(this.objetPaye);
               }
            }

            var3.close();
         }
      } catch (JDOMException var8) {
      } catch (IOException var9) {
      }

   }

   public List getMesPlanPaye() {
      return this.mesPlanPaye;
   }

   public void setMesPlanPaye(List var1) {
      this.mesPlanPaye = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }
}
