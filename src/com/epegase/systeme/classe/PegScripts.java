package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PegScripts implements Serializable {
   private long scrId;
   private Date scrDateCreat;
   private Date scrDateModif;
   private long scrUserCreat;
   private long scrUserModif;
   private int scrType;
   private String scrLibelle;
   private String scrDescription;
   private int scrInactif;
   private boolean scrLundi;
   private boolean scrMardi;
   private boolean scrMercredi;
   private boolean scrJeudi;
   private boolean scrVendredi;
   private boolean scrSamedi;
   private boolean scrDimanche;
   private String scrHeureLundi;
   private String scrMinuteLundi;
   private String scrHeureMardi;
   private String scrMinuteMardi;
   private String scrHeureMercredi;
   private String scrMinuteMercredi;
   private String scrHeureJeudi;
   private String scrMinuteJeudi;
   private String scrHeureVendredi;
   private String scrMinuteVendredi;
   private String scrHeureSamedi;
   private String scrMinuteSamedi;
   private String scrHeureDimanche;
   private String scrMinuteDimanche;
   private Date scrDateDebut;
   private Date scrDateFin;
   private String scrMail;
   private String scrMethode;
   private String scrParametreChemin;
   private String scrUrl;
   private String scrLogin;
   private String scrPw;
   private long scrIdStructure;
   private String scrNomStructure;
   private String libelleType;
   private boolean executee;
   private String dateExecution;

   public String getDateExecution() {
      return this.dateExecution;
   }

   public void setDateExecution(String var1) {
      this.dateExecution = var1;
   }

   public boolean isExecutee() {
      return this.executee;
   }

   public void setExecutee(boolean var1) {
      this.executee = var1;
   }

   public String getLibelleType() {
      if (this.scrType == 1) {
         this.libelleType = "Update BD ePegase";
      } else if (this.scrType == 2) {
         this.libelleType = "Backup BD vers ePegase-Netissime";
      } else if (this.scrType == 3) {
         this.libelleType = "Update BD vers serveur local";
      } else if (this.scrType == 4) {
         this.libelleType = "Backup BD vers disque local";
      } else if (this.scrType == 5) {
         this.libelleType = "Backup BD vers FTP";
      } else if (this.scrType == 6) {
         this.libelleType = "Backup STR vers ePegase-Netissime";
      } else if (this.scrType == 7) {
         this.libelleType = "Backup STR vers disque local";
      } else if (this.scrType == 8) {
         this.libelleType = "Backup STR vers FTP";
      } else if (this.scrType == 9) {
         this.libelleType = "Backup GED vers ePegase-Netissime";
      } else if (this.scrType == 10) {
         this.libelleType = "Backup GED vers disque local";
      } else if (this.scrType == 11) {
         this.libelleType = "Backup GED vers FTP";
      } else if (this.scrType == 21) {
         this.libelleType = "Backup BD vers ePegase-Kheweul";
      } else if (this.scrType == 22) {
         this.libelleType = "Backup STR vers ePegase-Kheweul";
      } else if (this.scrType == 23) {
         this.libelleType = "Backup GED vers ePegase-Kheweul";
      } else if (this.scrType == 99) {
         this.libelleType = "Exécute méthode";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public Date getScrDateCreat() {
      return this.scrDateCreat;
   }

   public void setScrDateCreat(Date var1) {
      this.scrDateCreat = var1;
   }

   public Date getScrDateDebut() {
      return this.scrDateDebut;
   }

   public void setScrDateDebut(Date var1) {
      this.scrDateDebut = var1;
   }

   public Date getScrDateFin() {
      return this.scrDateFin;
   }

   public void setScrDateFin(Date var1) {
      this.scrDateFin = var1;
   }

   public Date getScrDateModif() {
      return this.scrDateModif;
   }

   public void setScrDateModif(Date var1) {
      this.scrDateModif = var1;
   }

   public String getScrDescription() {
      return this.scrDescription;
   }

   public void setScrDescription(String var1) {
      this.scrDescription = var1;
   }

   public boolean isScrDimanche() {
      return this.scrDimanche;
   }

   public void setScrDimanche(boolean var1) {
      this.scrDimanche = var1;
   }

   public long getScrId() {
      return this.scrId;
   }

   public void setScrId(long var1) {
      this.scrId = var1;
   }

   public int getScrInactif() {
      return this.scrInactif;
   }

   public void setScrInactif(int var1) {
      this.scrInactif = var1;
   }

   public boolean isScrJeudi() {
      return this.scrJeudi;
   }

   public void setScrJeudi(boolean var1) {
      this.scrJeudi = var1;
   }

   public String getScrLibelle() {
      return this.scrLibelle;
   }

   public void setScrLibelle(String var1) {
      this.scrLibelle = var1;
   }

   public boolean isScrLundi() {
      return this.scrLundi;
   }

   public void setScrLundi(boolean var1) {
      this.scrLundi = var1;
   }

   public String getScrMail() {
      return this.scrMail;
   }

   public void setScrMail(String var1) {
      this.scrMail = var1;
   }

   public boolean isScrMardi() {
      return this.scrMardi;
   }

   public void setScrMardi(boolean var1) {
      this.scrMardi = var1;
   }

   public boolean isScrMercredi() {
      return this.scrMercredi;
   }

   public void setScrMercredi(boolean var1) {
      this.scrMercredi = var1;
   }

   public String getScrMethode() {
      return this.scrMethode;
   }

   public void setScrMethode(String var1) {
      this.scrMethode = var1;
   }

   public String getScrParametreChemin() {
      return this.scrParametreChemin;
   }

   public void setScrParametreChemin(String var1) {
      this.scrParametreChemin = var1;
   }

   public boolean isScrSamedi() {
      return this.scrSamedi;
   }

   public void setScrSamedi(boolean var1) {
      this.scrSamedi = var1;
   }

   public long getScrUserCreat() {
      return this.scrUserCreat;
   }

   public void setScrUserCreat(long var1) {
      this.scrUserCreat = var1;
   }

   public long getScrUserModif() {
      return this.scrUserModif;
   }

   public void setScrUserModif(long var1) {
      this.scrUserModif = var1;
   }

   public boolean isScrVendredi() {
      return this.scrVendredi;
   }

   public void setScrVendredi(boolean var1) {
      this.scrVendredi = var1;
   }

   public String getScrHeureDimanche() {
      return this.scrHeureDimanche;
   }

   public void setScrHeureDimanche(String var1) {
      this.scrHeureDimanche = var1;
   }

   public String getScrHeureJeudi() {
      return this.scrHeureJeudi;
   }

   public void setScrHeureJeudi(String var1) {
      this.scrHeureJeudi = var1;
   }

   public String getScrHeureLundi() {
      return this.scrHeureLundi;
   }

   public void setScrHeureLundi(String var1) {
      this.scrHeureLundi = var1;
   }

   public String getScrHeureMardi() {
      return this.scrHeureMardi;
   }

   public void setScrHeureMardi(String var1) {
      this.scrHeureMardi = var1;
   }

   public String getScrHeureMercredi() {
      return this.scrHeureMercredi;
   }

   public void setScrHeureMercredi(String var1) {
      this.scrHeureMercredi = var1;
   }

   public String getScrHeureSamedi() {
      return this.scrHeureSamedi;
   }

   public void setScrHeureSamedi(String var1) {
      this.scrHeureSamedi = var1;
   }

   public String getScrHeureVendredi() {
      return this.scrHeureVendredi;
   }

   public void setScrHeureVendredi(String var1) {
      this.scrHeureVendredi = var1;
   }

   public String getScrMinuteDimanche() {
      return this.scrMinuteDimanche;
   }

   public void setScrMinuteDimanche(String var1) {
      this.scrMinuteDimanche = var1;
   }

   public String getScrMinuteJeudi() {
      return this.scrMinuteJeudi;
   }

   public void setScrMinuteJeudi(String var1) {
      this.scrMinuteJeudi = var1;
   }

   public String getScrMinuteLundi() {
      return this.scrMinuteLundi;
   }

   public void setScrMinuteLundi(String var1) {
      this.scrMinuteLundi = var1;
   }

   public String getScrMinuteMardi() {
      return this.scrMinuteMardi;
   }

   public void setScrMinuteMardi(String var1) {
      this.scrMinuteMardi = var1;
   }

   public String getScrMinuteMercredi() {
      return this.scrMinuteMercredi;
   }

   public void setScrMinuteMercredi(String var1) {
      this.scrMinuteMercredi = var1;
   }

   public String getScrMinuteSamedi() {
      return this.scrMinuteSamedi;
   }

   public void setScrMinuteSamedi(String var1) {
      this.scrMinuteSamedi = var1;
   }

   public String getScrMinuteVendredi() {
      return this.scrMinuteVendredi;
   }

   public void setScrMinuteVendredi(String var1) {
      this.scrMinuteVendredi = var1;
   }

   public int getScrType() {
      return this.scrType;
   }

   public void setScrType(int var1) {
      this.scrType = var1;
   }

   public String getScrLogin() {
      return this.scrLogin;
   }

   public void setScrLogin(String var1) {
      this.scrLogin = var1;
   }

   public String getScrPw() {
      return this.scrPw;
   }

   public void setScrPw(String var1) {
      this.scrPw = var1;
   }

   public String getScrUrl() {
      return this.scrUrl;
   }

   public void setScrUrl(String var1) {
      this.scrUrl = var1;
   }

   public long getScrIdStructure() {
      return this.scrIdStructure;
   }

   public void setScrIdStructure(long var1) {
      this.scrIdStructure = var1;
   }

   public String getScrNomStructure() {
      return this.scrNomStructure;
   }

   public void setScrNomStructure(String var1) {
      this.scrNomStructure = var1;
   }
}
