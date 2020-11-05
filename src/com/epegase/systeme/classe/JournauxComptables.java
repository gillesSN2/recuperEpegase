package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.component.UIInput;

public class JournauxComptables implements Serializable {
   private long pljId;
   private Date pljDateCreat;
   private Date pljDateModif;
   private long pljUserCreat;
   private long pljUserModif;
   private String pljCode = "";
   private UIInput UIpljCode;
   private String pljLibelleFr;
   private String pljLibelleUk;
   private String pljLibelleSp;
   private int pljNature = 0;
   private int pljReserve;
   private int pljAnalytique;
   private int pljFormatDevise = 0;
   private String LibNature;
   private String pljCompteTreso = " ";
   private String pljCompteTresoNew;
   private int pljPiece = 0;
   private String LibPiece;
   private int pljScenario = 0;
   private String LibScenario;
   private int pljTypeDevise;
   private String pljChoixDevise = "";
   private String pljBudjet;
   private int pljInactif;
   private String pljInactifFR;
   private int pljDvMbsp = 0;
   private int pljDvMbhp = 0;
   private int pljDvAbsp = 0;
   private int pljDvAbhp = 0;
   private int pljModeTreso;
   private String pljProjet;
   private String pljCodeBanque;
   private String pljCodeGuichet;
   private String pljNumeroCompte;
   private String pljCleRib;
   private String pljIban;
   private String pljSwift;
   private String pljCiviliteGestionnaire;
   private String pljNomGestionnaire;
   private String pljPrenomGestionnaire;
   private String pljTelephoneGestionnaire;
   private String pljMailGestionnaire;
   private int pljSasieInterdite;
   private ExercicesComptable exercice;
   private String imagInactif;
   private boolean afficheDevise = false;
   private List lesdev;
   private String etat;
   private boolean inactif;
   private boolean select;
   private String libelleProjet;

   public String getLibelleProjet() {
      if (this.pljProjet != null && !this.pljProjet.isEmpty()) {
         if (this.pljProjet.equals("99999")) {
            this.libelleProjet = "Tous projets";
         } else {
            this.libelleProjet = this.pljProjet;
         }
      } else {
         this.libelleProjet = "";
      }

      return this.libelleProjet;
   }

   public void setLibelleProjet(String var1) {
      this.libelleProjet = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public ExercicesComptable getExercice() {
      return this.exercice;
   }

   public void setExercice(ExercicesComptable var1) {
      this.exercice = var1;
   }

   public String getPljBudjet() {
      return this.pljBudjet;
   }

   public void setPljBudjet(String var1) {
      this.pljBudjet = var1;
   }

   public String getPljChoixDevise() {
      return this.pljChoixDevise;
   }

   public void setPljChoixDevise(String var1) {
      this.pljChoixDevise = var1;
   }

   public String getPljCode() {
      if (this.pljCode != null && !this.pljCode.isEmpty()) {
         this.pljCode = this.pljCode.toUpperCase();
      }

      return this.pljCode;
   }

   public void setPljCode(String var1) {
      this.pljCode = var1;
   }

   public String getPljCompteTreso() {
      return this.pljCompteTreso;
   }

   public void setPljCompteTreso(String var1) {
      this.pljCompteTreso = var1;
   }

   public Date getPljDateCreat() {
      return this.pljDateCreat;
   }

   public void setPljDateCreat(Date var1) {
      this.pljDateCreat = var1;
   }

   public long getPljId() {
      return this.pljId;
   }

   public void setPljId(long var1) {
      this.pljId = var1;
   }

   public int getPljInactif() {
      return this.pljInactif;
   }

   public void setPljInactif(int var1) {
      this.pljInactif = var1;
   }

   public String getPljLibelleFr() {
      if (this.pljLibelleFr != null && !this.pljLibelleFr.isEmpty()) {
         this.pljLibelleFr = this.pljLibelleFr.toUpperCase();
      }

      return this.pljLibelleFr;
   }

   public void setPljLibelleFr(String var1) {
      this.pljLibelleFr = var1;
   }

   public String getPljLibelleSp() {
      return this.pljLibelleSp;
   }

   public void setPljLibelleSp(String var1) {
      this.pljLibelleSp = var1;
   }

   public String getPljLibelleUk() {
      return this.pljLibelleUk;
   }

   public void setPljLibelleUk(String var1) {
      this.pljLibelleUk = var1;
   }

   public String getLibNature() {
      if (this.pljNature == 0) {
         this.LibNature = "Général";
      } else if (this.pljNature == 1) {
         this.LibNature = "Achats";
      } else if (this.pljNature == 2) {
         this.LibNature = "Ventes";
      } else if (this.pljNature == 3) {
         this.LibNature = "Paye";
      } else if (this.pljNature == 4) {
         this.LibNature = "Loyer";
      } else if (this.pljNature == 5) {
         this.LibNature = "Amortissement";
      } else if (this.pljNature == 6) {
         this.LibNature = "Amort. VPP";
      } else if (this.pljNature == 7) {
         this.LibNature = "Bnq avec Cent.";
      } else if (this.pljNature == 8) {
         this.LibNature = "Bnq sans Cent.";
      } else if (this.pljNature == 9) {
         this.LibNature = "Cais. avec Cent.";
      } else if (this.pljNature == 10) {
         this.LibNature = "Cais. sans Cent.";
      } else if (this.pljNature == 11) {
         this.LibNature = "Situation";
      } else if (this.pljNature == 12) {
         this.LibNature = "Réservé";
      } else if (this.pljNature == 13) {
         this.LibNature = "Balance";
      } else if (this.pljNature == 14) {
         this.LibNature = "Clôture";
      } else if (this.pljNature == 15) {
         this.LibNature = "RAN";
      }

      return this.LibNature;
   }

   public int getPljPiece() {
      return this.pljPiece;
   }

   public void setPljPiece(int var1) {
      this.pljPiece = var1;
   }

   public int getPljScenario() {
      return this.pljScenario;
   }

   public void setPljScenario(int var1) {
      this.pljScenario = var1;
   }

   public int getPljTypeDevise() {
      return this.pljTypeDevise;
   }

   public void setPljTypeDevise(int var1) {
      this.pljTypeDevise = var1;
   }

   public long getPljUserCreat() {
      return this.pljUserCreat;
   }

   public void setPljUserCreat(long var1) {
      this.pljUserCreat = var1;
   }

   public long getPljUserModif() {
      return this.pljUserModif;
   }

   public void setPljUserModif(long var1) {
      this.pljUserModif = var1;
   }

   public Date getPljDateModif() {
      return this.pljDateModif;
   }

   public void setPljDateModif(Date var1) {
      this.pljDateModif = var1;
   }

   public void setPljNature(int var1) {
      this.pljNature = var1;
   }

   public String getLibScenario() {
      if (this.pljScenario == 0) {
         this.LibScenario = "Sans scénario";
      } else if (this.pljScenario == 1) {
         this.LibScenario = "Modèle 1";
      } else if (this.pljScenario == 2) {
         this.LibScenario = "Modèle 2";
      } else if (this.pljScenario == 3) {
         this.LibScenario = "Modèle 3";
      }

      return this.LibScenario;
   }

   public String getLibPiece() {
      if (this.pljPiece == 0) {
         this.LibPiece = "Pièce manuelle";
      } else if (this.pljPiece == 1) {
         this.LibPiece = "Automatique à chaque ligne";
      } else if (this.pljPiece == 2) {
         this.LibPiece = "Automatique sur solde nul";
      }

      return this.LibPiece;
   }

   public String getPljInactifFR() {
      if (this.pljInactif == 0) {
         this.pljInactifFR = "VRAI";
      } else if (this.pljInactif == 1) {
         this.pljInactifFR = "FAUX";
      }

      return this.pljInactifFR;
   }

   public void setPljInactifFR(String var1) {
      this.pljInactifFR = var1;
   }

   public UIInput getUIpljCode() {
      return this.UIpljCode;
   }

   public void setUIpljCode(UIInput var1) {
      this.UIpljCode = var1;
   }

   public int getPljFormatDevise() {
      return this.pljFormatDevise;
   }

   public void setPljFormatDevise(int var1) {
      this.pljFormatDevise = var1;
   }

   public void setImagInactif(String var1) {
      this.imagInactif = var1;
   }

   public boolean isAfficheDevise() {
      if (this.pljTypeDevise == 1) {
         this.afficheDevise = true;
      } else {
         this.afficheDevise = false;
      }

      return this.afficheDevise;
   }

   public void setAfficheDevise(boolean var1) {
      this.afficheDevise = var1;
   }

   public String getEtat() {
      if (this.pljInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.pljInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.pljInactif != 1 && this.pljInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public int getPljDvAbhp() {
      return this.pljDvAbhp;
   }

   public void setPljDvAbhp(int var1) {
      this.pljDvAbhp = var1;
   }

   public int getPljDvAbsp() {
      return this.pljDvAbsp;
   }

   public void setPljDvAbsp(int var1) {
      this.pljDvAbsp = var1;
   }

   public int getPljDvMbhp() {
      return this.pljDvMbhp;
   }

   public void setPljDvMbhp(int var1) {
      this.pljDvMbhp = var1;
   }

   public int getPljDvMbsp() {
      return this.pljDvMbsp;
   }

   public void setPljDvMbsp(int var1) {
      this.pljDvMbsp = var1;
   }

   public List getLesdev() {
      return this.lesdev;
   }

   public void setLesdev(List var1) {
      this.lesdev = var1;
   }

   public int getPljModeTreso() {
      return this.pljModeTreso;
   }

   public void setPljModeTreso(int var1) {
      this.pljModeTreso = var1;
   }

   public String getImagInactif() {
      return this.imagInactif;
   }

   public int getPljNature() {
      return this.pljNature;
   }

   public void setLibNature(String var1) {
      this.LibNature = var1;
   }

   public void setLibPiece(String var1) {
      this.LibPiece = var1;
   }

   public void setLibScenario(String var1) {
      this.LibScenario = var1;
   }

   public int getPljReserve() {
      return this.pljReserve;
   }

   public void setPljReserve(int var1) {
      this.pljReserve = var1;
   }

   public String getPljProjet() {
      return this.pljProjet;
   }

   public void setPljProjet(String var1) {
      this.pljProjet = var1;
   }

   public String getPljCiviliteGestionnaire() {
      return this.pljCiviliteGestionnaire;
   }

   public void setPljCiviliteGestionnaire(String var1) {
      this.pljCiviliteGestionnaire = var1;
   }

   public String getPljCleRib() {
      return this.pljCleRib;
   }

   public void setPljCleRib(String var1) {
      this.pljCleRib = var1;
   }

   public String getPljCodeBanque() {
      return this.pljCodeBanque;
   }

   public void setPljCodeBanque(String var1) {
      this.pljCodeBanque = var1;
   }

   public String getPljCodeGuichet() {
      return this.pljCodeGuichet;
   }

   public void setPljCodeGuichet(String var1) {
      this.pljCodeGuichet = var1;
   }

   public String getPljMailGestionnaire() {
      return this.pljMailGestionnaire;
   }

   public void setPljMailGestionnaire(String var1) {
      this.pljMailGestionnaire = var1;
   }

   public String getPljNomGestionnaire() {
      return this.pljNomGestionnaire;
   }

   public void setPljNomGestionnaire(String var1) {
      this.pljNomGestionnaire = var1;
   }

   public String getPljNumeroCompte() {
      return this.pljNumeroCompte;
   }

   public void setPljNumeroCompte(String var1) {
      this.pljNumeroCompte = var1;
   }

   public String getPljPrenomGestionnaire() {
      return this.pljPrenomGestionnaire;
   }

   public void setPljPrenomGestionnaire(String var1) {
      this.pljPrenomGestionnaire = var1;
   }

   public String getPljTelephoneGestionnaire() {
      return this.pljTelephoneGestionnaire;
   }

   public void setPljTelephoneGestionnaire(String var1) {
      this.pljTelephoneGestionnaire = var1;
   }

   public String getPljIban() {
      return this.pljIban;
   }

   public void setPljIban(String var1) {
      this.pljIban = var1;
   }

   public String getPljSwift() {
      return this.pljSwift;
   }

   public void setPljSwift(String var1) {
      this.pljSwift = var1;
   }

   public int getPljSasieInterdite() {
      return this.pljSasieInterdite;
   }

   public void setPljSasieInterdite(int var1) {
      this.pljSasieInterdite = var1;
   }

   public String getPljCompteTresoNew() {
      return this.pljCompteTresoNew;
   }

   public void setPljCompteTresoNew(String var1) {
      this.pljCompteTresoNew = var1;
   }

   public int getPljAnalytique() {
      return this.pljAnalytique;
   }

   public void setPljAnalytique(int var1) {
      this.pljAnalytique = var1;
   }
}
