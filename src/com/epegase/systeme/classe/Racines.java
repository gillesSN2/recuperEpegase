package com.epegase.systeme.classe;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

public class Racines implements Serializable {
   private long racId;
   private String racFiscalite;
   private String racCode;
   private String racLibelleFr;
   private String racLibelleUk;
   private String racLibelleSp;
   private String racnature;
   private String racCodenature;
   private float ractaux;
   private String racUtil;
   private int indice;
   private String numero;
   private int nombrCaractere = 10;
   private boolean griser = false;
   private String aff_racine;
   private String lib_nature;

   public String getLib_nature() {
      if (this.racCodenature.equalsIgnoreCase("1")) {
         this.lib_nature = "Capital";
      } else if (this.racCodenature.equalsIgnoreCase("2")) {
         this.lib_nature = "Résultat";
      } else if (this.racCodenature.equalsIgnoreCase("3")) {
         this.lib_nature = "Immobilisations";
      } else if (this.racCodenature.equalsIgnoreCase("4")) {
         this.lib_nature = "Amortissements et Provisions";
      } else if (this.racCodenature.equalsIgnoreCase("5")) {
         this.lib_nature = "Stock";
      } else if (this.racCodenature.equalsIgnoreCase("6")) {
         this.lib_nature = "Fournisseurs";
      } else if (this.racCodenature.equalsIgnoreCase("7")) {
         this.lib_nature = "Clients";
      } else if (this.racCodenature.equalsIgnoreCase("8")) {
         this.lib_nature = "Personnels";
      } else if (this.racCodenature.equalsIgnoreCase("9")) {
         this.lib_nature = "Autres Tiers";
      } else if (this.racCodenature.equalsIgnoreCase("10")) {
         this.lib_nature = "Banques";
      } else if (this.racCodenature.equalsIgnoreCase("11")) {
         this.lib_nature = "Caisses";
      } else if (this.racCodenature.equalsIgnoreCase("12")) {
         this.lib_nature = "Autres Trésoreries";
      } else if (this.racCodenature.equalsIgnoreCase("13")) {
         this.lib_nature = "TVA sur achats";
      } else if (this.racCodenature.equalsIgnoreCase("14")) {
         this.lib_nature = "TVA sur ventes";
      } else if (this.racCodenature.equalsIgnoreCase("15")) {
         this.lib_nature = "Autres Etats";
      } else if (this.racCodenature.equalsIgnoreCase("16")) {
         this.lib_nature = "Charges";
      } else if (this.racCodenature.equalsIgnoreCase("17")) {
         this.lib_nature = "Produits";
      } else if (this.racCodenature.equalsIgnoreCase("18")) {
         this.lib_nature = "Dotations";
      } else if (this.racCodenature.equalsIgnoreCase("19")) {
         this.lib_nature = "Réserves";
      } else if (this.racCodenature.equalsIgnoreCase("20")) {
         this.lib_nature = "Report à nouveaux";
      } else if (this.racCodenature.equalsIgnoreCase("21")) {
         this.lib_nature = "Subventions";
      } else if (this.racCodenature.equalsIgnoreCase("22")) {
         this.lib_nature = "Emprunts et dettes";
      } else if (this.racCodenature.equalsIgnoreCase("23")) {
         this.lib_nature = "Produits et charges HAO";
      } else if (this.racCodenature.equalsIgnoreCase("24")) {
         this.lib_nature = "Résultats";
      } else if (this.racCodenature.equalsIgnoreCase("25")) {
         this.lib_nature = "Plus ou moins value de cession";
      } else if (this.racCodenature.equalsIgnoreCase("26")) {
         this.lib_nature = "Provisions";
      } else if (this.racCodenature.equalsIgnoreCase("27")) {
         this.lib_nature = "Dépréciation";
      } else if (this.racCodenature.equalsIgnoreCase("28")) {
         this.lib_nature = "Dettes de location et acquisition";
      } else if (this.racCodenature.equalsIgnoreCase("90")) {
         this.lib_nature = "Attente";
      } else if (this.racCodenature.equalsIgnoreCase("99")) {
         this.lib_nature = "Aucune nature";
      }

      return this.lib_nature;
   }

   public void setLib_nature(String var1) {
      this.lib_nature = var1;
   }

   public String getAff_racine() {
      if (this.racCode.length() == 2) {
         this.aff_racine = this.racLibelleFr;
      } else if (this.racCode.length() == 3) {
         this.aff_racine = "               " + this.racLibelleFr;
      } else if (this.racCode.length() == 4) {
         this.aff_racine = "                                " + this.racLibelleFr;
      } else if (this.racCode.length() == 5) {
         this.aff_racine = "                                                " + this.racLibelleFr;
      } else if (this.racCode.length() == 6) {
         this.aff_racine = "                                                                " + this.racLibelleFr;
      }

      return this.aff_racine;
   }

   public void setAff_racine(String var1) {
      this.aff_racine = var1;
   }

   public String getRacnature() {
      return this.racnature;
   }

   public void setRacnature(String var1) {
      this.racnature = var1;
   }

   public long getRacId() {
      return this.racId;
   }

   public void setRacId(long var1) {
      this.racId = var1;
   }

   public String getRacCode() {
      return this.racCode;
   }

   public void setRacCode(String var1) {
      this.racCode = var1;
   }

   public String getRacLibelleFr() {
      return this.racLibelleFr;
   }

   public void setRacLibelleFr(String var1) {
      this.racLibelleFr = var1;
   }

   public String getRacLibelleSp() {
      return this.racLibelleSp;
   }

   public void setRacLibelleSp(String var1) {
      this.racLibelleSp = var1;
   }

   public String getRacLibelleUk() {
      return this.racLibelleUk;
   }

   public void setRacLibelleUk(String var1) {
      this.racLibelleUk = var1;
   }

   public String getRacCodenature() {
      return this.racCodenature;
   }

   public void setRacCodenature(String var1) {
      this.racCodenature = var1;
   }

   public float getRactaux() {
      return this.ractaux;
   }

   public void setRactaux(float var1) {
      this.ractaux = var1;
   }

   public String getRacUtil() {
      return this.racUtil;
   }

   public void setRacUtil(String var1) {
      this.racUtil = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public boolean isGriser() {
      if (this.racnature != null && !this.racnature.isEmpty()) {
         if (!this.racnature.equalsIgnoreCase("Immobilisations") && !this.racnature.contains("TVA") && !this.racnature.contains("BRS") && !this.racnature.equalsIgnoreCase("Autres Etats")) {
            this.griser = false;
         } else {
            this.griser = true;
         }
      } else {
         this.griser = false;
      }

      return this.griser;
   }

   public void setGriser(boolean var1) {
      this.griser = var1;
   }

   public Object getAsObject(FacesContext var1, UIComponent var2, String var3) {
      String var4 = "{0,1,2,3,4,5,6,7,8,9,.}";
      if (var3.matches(var4)) {
         return var3;
      } else {
         FacesMessage var5 = new FacesMessage();
         var5.setSeverity(FacesMessage.SEVERITY_ERROR);
         var5.setSummary("Format incorrect");
         var5.setDetail("Format requis : saisir les valeurs numériques");
         throw new ConverterException(var5);
      }
   }

   public String getNumero() {
      this.numero = this.racCode.concat(this.getComplement());
      return this.numero;
   }

   public void setNumero(String var1) {
      this.numero = var1;
   }

   public int getNombrCaractere() {
      return this.nombrCaractere;
   }

   public void setNombrCaractere(int var1) {
      this.nombrCaractere = var1;
   }

   public String getComplement() {
      int var1 = this.nombrCaractere - this.racCode.length();
      String var2 = "";
      String[] var3 = new String[var1];

      for(int var4 = 0; var4 < var1; ++var4) {
         var3[var4] = "0";
         var2 = var2.concat(var3[var4]);
      }

      return var2;
   }

   public String getRacFiscalite() {
      return this.racFiscalite;
   }

   public void setRacFiscalite(String var1) {
      this.racFiscalite = var1;
   }
}
