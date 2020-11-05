package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class RdvSemaine implements Serializable {
   private String heure = "";
   private String lundi = "";
   private String mardi = "";
   private String mercredi = "";
   private String jeudi = "";
   private String vendredi = "";
   private String samedi = "";
   private String dimanche = "";
   private String rdvLun = "";
   private String rdvMar = "";
   private String rdvMer = "";
   private String rdvJeu = "";
   private String rdvVen = "";
   private String rdvSam = "";
   private String rdvDim = "";
   private int num_sem;
   private List lesRdvJourLundi = new ArrayList();
   private List lesRdvJourMardi = new ArrayList();
   private List lesRdvJourMercredi = new ArrayList();
   private List lesRdvJourJeudi = new ArrayList();
   private List lesRdvJourVendredi = new ArrayList();
   private List lesRdvJourSamedi = new ArrayList();
   private List lesRdvJourDimanche = new ArrayList();
   private List lesCmdJourLundi = new ArrayList();
   private List lesCmdJourMardi = new ArrayList();
   private List lesCmdJourMercredi = new ArrayList();
   private List lesCmdJourJeudi = new ArrayList();
   private List lesCmdJourVendredi = new ArrayList();
   private List lesCmdJourSamedi = new ArrayList();
   private List lesCmdJourDimanche = new ArrayList();
   private transient DataModel dataModelLundi = new ListDataModel();
   private transient DataModel dataModelMardi = new ListDataModel();
   private transient DataModel dataModelMercredi = new ListDataModel();
   private transient DataModel dataModelJeudi = new ListDataModel();
   private transient DataModel dataModelVendredi = new ListDataModel();
   private transient DataModel dataModelSamedi = new ListDataModel();
   private transient DataModel dataModelDimanche = new ListDataModel();
   private boolean affiche01;
   private boolean affiche02;
   private boolean affiche03;
   private boolean affiche04;
   private boolean affiche05;
   private boolean affiche06;
   private boolean affiche07;
   private boolean affiche01Sup;
   private boolean affiche02Sup;
   private boolean affiche03Sup;
   private boolean affiche04Sup;
   private boolean affiche05Sup;
   private boolean affiche06Sup;
   private boolean affiche07Sup;
   private long rdvUsrLundi;
   private long rdvUsrMardi;
   private long rdvUsrMercredi;
   private long rdvUsrJeudi;
   private long rdvUsrVendredi;
   private long rdvUsrSamedi;
   private long rdvUsrDimanche;
   private long rdvIdLundi;
   private long rdvIdMardi;
   private long rdvIdMercredi;
   private long rdvIdJeudi;
   private long rdvIdVendredi;
   private long rdvIdSamedi;
   private long rdvIdDimanche;
   private int rdvEtatLundi;
   private int rdvEtatMardi;
   private int rdvEtatMercredi;
   private int rdvEtatJeudi;
   private int rdvEtatVendredi;
   private int rdvEtatSamedi;
   private int rdvEtatDimanche;
   private boolean rdvErreurLundi;
   private boolean rdvErreurMardi;
   private boolean rdvErreurMercredi;
   private boolean rdvErreurJeudi;
   private boolean rdvErreurVendredi;
   private boolean rdvErreurSamedi;
   private boolean rdvErreurDimanche;
   private String impcol01;
   private String impcol02;
   private String impcol03;
   private String impcol04;
   private String impcol05;
   private String impcol06;
   private String impcol07;
   private int nbRdv;
   private int nbNonFait;
   private int nbFait;
   private int nbReporte;
   private int nbAnnule;
   private int rdvNature;
   private String rdvLibNature;
   private String color;
   private float tauxSucces;

   public String getColor() {
      if (this.rdvNature == 0) {
         this.color = "color:#000000;";
      } else if (this.rdvNature == 1) {
         this.color = "color:#0000FF;";
      } else if (this.rdvNature == 2) {
         this.color = "color:#B404AE;";
      } else if (this.rdvNature == 3) {
         this.color = "color:#610B0B;";
      } else if (this.rdvNature == 4) {
         this.color = "color:#FFBF00;";
      } else if (this.rdvNature == 5) {
         this.color = "color:#FAAC58;";
      } else if (this.rdvNature == 6) {
         this.color = "color:#01A9DB;";
      } else if (this.rdvNature == 7) {
         this.color = "color:#FF8000;";
      } else if (this.rdvNature == 8) {
         this.color = "color:#FF0040;text-decoration: blink;";
      } else if (this.rdvNature == 9) {
         this.color = "color:#585858;";
      } else if (this.rdvNature == 10) {
         this.color = "color:#FA58F4;";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getRdvLibNature() {
      if (this.rdvNature == 0) {
         this.rdvLibNature = "Rappel";
      } else if (this.rdvNature == 1) {
         this.rdvLibNature = "Rdv";
      } else if (this.rdvNature == 2) {
         this.rdvLibNature = "To Do";
      } else if (this.rdvNature == 3) {
         this.rdvLibNature = "Emploi du temps";
      } else if (this.rdvNature == 4) {
         this.rdvLibNature = "Visite";
      } else if (this.rdvNature == 5) {
         this.rdvLibNature = "Intervention";
      } else if (this.rdvNature == 6) {
         this.rdvLibNature = "Appel";
      } else if (this.rdvNature == 7) {
         this.rdvLibNature = "Pointage";
      } else if (this.rdvNature == 8) {
         this.rdvLibNature = "Réunion";
      } else if (this.rdvNature == 9) {
         this.rdvLibNature = "Message";
      } else if (this.rdvNature == 10) {
         this.rdvLibNature = "Post-it";
      } else if (this.rdvNature == 11) {
         this.rdvLibNature = "Cal.Fiscal";
      }

      return this.rdvLibNature;
   }

   public void setRdvLibNature(String var1) {
      this.rdvLibNature = var1;
   }

   public String getDimanche() {
      return this.dimanche;
   }

   public void setDimanche(String var1) {
      this.dimanche = var1;
   }

   public String getJeudi() {
      return this.jeudi;
   }

   public void setJeudi(String var1) {
      this.jeudi = var1;
   }

   public String getLundi() {
      return this.lundi;
   }

   public void setLundi(String var1) {
      this.lundi = var1;
   }

   public String getMardi() {
      return this.mardi;
   }

   public void setMardi(String var1) {
      this.mardi = var1;
   }

   public String getMercredi() {
      return this.mercredi;
   }

   public void setMercredi(String var1) {
      this.mercredi = var1;
   }

   public String getSamedi() {
      return this.samedi;
   }

   public void setSamedi(String var1) {
      this.samedi = var1;
   }

   public String getVendredi() {
      return this.vendredi;
   }

   public void setVendredi(String var1) {
      this.vendredi = var1;
   }

   public String getHeure() {
      return this.heure;
   }

   public void setHeure(String var1) {
      this.heure = var1;
   }

   public String getRdvDim() {
      return this.rdvDim;
   }

   public void setRdvDim(String var1) {
      this.rdvDim = var1;
   }

   public String getRdvJeu() {
      return this.rdvJeu;
   }

   public void setRdvJeu(String var1) {
      this.rdvJeu = var1;
   }

   public String getRdvLun() {
      return this.rdvLun;
   }

   public void setRdvLun(String var1) {
      this.rdvLun = var1;
   }

   public String getRdvMar() {
      return this.rdvMar;
   }

   public void setRdvMar(String var1) {
      this.rdvMar = var1;
   }

   public String getRdvMer() {
      return this.rdvMer;
   }

   public void setRdvMer(String var1) {
      this.rdvMer = var1;
   }

   public String getRdvSam() {
      return this.rdvSam;
   }

   public void setRdvSam(String var1) {
      this.rdvSam = var1;
   }

   public String getRdvVen() {
      return this.rdvVen;
   }

   public void setRdvVen(String var1) {
      this.rdvVen = var1;
   }

   public int getNum_sem() {
      return this.num_sem;
   }

   public void setNum_sem(int var1) {
      this.num_sem = var1;
   }

   public List getLesRdvJourDimanche() {
      return this.lesRdvJourDimanche;
   }

   public void setLesRdvJourDimanche(List var1) {
      this.lesRdvJourDimanche = var1;
   }

   public List getLesRdvJourJeudi() {
      return this.lesRdvJourJeudi;
   }

   public void setLesRdvJourJeudi(List var1) {
      this.lesRdvJourJeudi = var1;
   }

   public List getLesRdvJourLundi() {
      return this.lesRdvJourLundi;
   }

   public void setLesRdvJourLundi(List var1) {
      this.lesRdvJourLundi = var1;
   }

   public List getLesRdvJourMardi() {
      return this.lesRdvJourMardi;
   }

   public void setLesRdvJourMardi(List var1) {
      this.lesRdvJourMardi = var1;
   }

   public List getLesRdvJourMercredi() {
      return this.lesRdvJourMercredi;
   }

   public void setLesRdvJourMercredi(List var1) {
      this.lesRdvJourMercredi = var1;
   }

   public List getLesRdvJourSamedi() {
      return this.lesRdvJourSamedi;
   }

   public void setLesRdvJourSamedi(List var1) {
      this.lesRdvJourSamedi = var1;
   }

   public List getLesRdvJourVendredi() {
      return this.lesRdvJourVendredi;
   }

   public void setLesRdvJourVendredi(List var1) {
      this.lesRdvJourVendredi = var1;
   }

   public DataModel getDataModelDimanche() {
      return this.dataModelDimanche;
   }

   public void setDataModelDimanche(DataModel var1) {
      this.dataModelDimanche = var1;
   }

   public DataModel getDataModelJeudi() {
      return this.dataModelJeudi;
   }

   public void setDataModelJeudi(DataModel var1) {
      this.dataModelJeudi = var1;
   }

   public DataModel getDataModelLundi() {
      return this.dataModelLundi;
   }

   public void setDataModelLundi(DataModel var1) {
      this.dataModelLundi = var1;
   }

   public DataModel getDataModelMardi() {
      return this.dataModelMardi;
   }

   public void setDataModelMardi(DataModel var1) {
      this.dataModelMardi = var1;
   }

   public DataModel getDataModelMercredi() {
      return this.dataModelMercredi;
   }

   public void setDataModelMercredi(DataModel var1) {
      this.dataModelMercredi = var1;
   }

   public DataModel getDataModelSamedi() {
      return this.dataModelSamedi;
   }

   public void setDataModelSamedi(DataModel var1) {
      this.dataModelSamedi = var1;
   }

   public DataModel getDataModelVendredi() {
      return this.dataModelVendredi;
   }

   public void setDataModelVendredi(DataModel var1) {
      this.dataModelVendredi = var1;
   }

   public boolean isAffiche01() {
      return this.affiche01;
   }

   public void setAffiche01(boolean var1) {
      this.affiche01 = var1;
   }

   public boolean isAffiche02() {
      return this.affiche02;
   }

   public void setAffiche02(boolean var1) {
      this.affiche02 = var1;
   }

   public boolean isAffiche03() {
      return this.affiche03;
   }

   public void setAffiche03(boolean var1) {
      this.affiche03 = var1;
   }

   public boolean isAffiche04() {
      return this.affiche04;
   }

   public void setAffiche04(boolean var1) {
      this.affiche04 = var1;
   }

   public boolean isAffiche05() {
      return this.affiche05;
   }

   public void setAffiche05(boolean var1) {
      this.affiche05 = var1;
   }

   public boolean isAffiche06() {
      return this.affiche06;
   }

   public void setAffiche06(boolean var1) {
      this.affiche06 = var1;
   }

   public boolean isAffiche07() {
      return this.affiche07;
   }

   public void setAffiche07(boolean var1) {
      this.affiche07 = var1;
   }

   public long getRdvUsrDimanche() {
      return this.rdvUsrDimanche;
   }

   public void setRdvUsrDimanche(long var1) {
      this.rdvUsrDimanche = var1;
   }

   public long getRdvUsrJeudi() {
      return this.rdvUsrJeudi;
   }

   public void setRdvUsrJeudi(long var1) {
      this.rdvUsrJeudi = var1;
   }

   public long getRdvUsrLundi() {
      return this.rdvUsrLundi;
   }

   public void setRdvUsrLundi(long var1) {
      this.rdvUsrLundi = var1;
   }

   public long getRdvUsrMardi() {
      return this.rdvUsrMardi;
   }

   public void setRdvUsrMardi(long var1) {
      this.rdvUsrMardi = var1;
   }

   public long getRdvUsrMercredi() {
      return this.rdvUsrMercredi;
   }

   public void setRdvUsrMercredi(long var1) {
      this.rdvUsrMercredi = var1;
   }

   public long getRdvUsrSamedi() {
      return this.rdvUsrSamedi;
   }

   public void setRdvUsrSamedi(long var1) {
      this.rdvUsrSamedi = var1;
   }

   public long getRdvUsrVendredi() {
      return this.rdvUsrVendredi;
   }

   public void setRdvUsrVendredi(long var1) {
      this.rdvUsrVendredi = var1;
   }

   public long getRdvIdDimanche() {
      return this.rdvIdDimanche;
   }

   public void setRdvIdDimanche(long var1) {
      this.rdvIdDimanche = var1;
   }

   public long getRdvIdJeudi() {
      return this.rdvIdJeudi;
   }

   public void setRdvIdJeudi(long var1) {
      this.rdvIdJeudi = var1;
   }

   public long getRdvIdLundi() {
      return this.rdvIdLundi;
   }

   public void setRdvIdLundi(long var1) {
      this.rdvIdLundi = var1;
   }

   public long getRdvIdMardi() {
      return this.rdvIdMardi;
   }

   public void setRdvIdMardi(long var1) {
      this.rdvIdMardi = var1;
   }

   public long getRdvIdMercredi() {
      return this.rdvIdMercredi;
   }

   public void setRdvIdMercredi(long var1) {
      this.rdvIdMercredi = var1;
   }

   public long getRdvIdSamedi() {
      return this.rdvIdSamedi;
   }

   public void setRdvIdSamedi(long var1) {
      this.rdvIdSamedi = var1;
   }

   public long getRdvIdVendredi() {
      return this.rdvIdVendredi;
   }

   public void setRdvIdVendredi(long var1) {
      this.rdvIdVendredi = var1;
   }

   public int getRdvEtatDimanche() {
      return this.rdvEtatDimanche;
   }

   public void setRdvEtatDimanche(int var1) {
      this.rdvEtatDimanche = var1;
   }

   public int getRdvEtatJeudi() {
      return this.rdvEtatJeudi;
   }

   public void setRdvEtatJeudi(int var1) {
      this.rdvEtatJeudi = var1;
   }

   public int getRdvEtatLundi() {
      return this.rdvEtatLundi;
   }

   public void setRdvEtatLundi(int var1) {
      this.rdvEtatLundi = var1;
   }

   public int getRdvEtatMardi() {
      return this.rdvEtatMardi;
   }

   public void setRdvEtatMardi(int var1) {
      this.rdvEtatMardi = var1;
   }

   public int getRdvEtatMercredi() {
      return this.rdvEtatMercredi;
   }

   public void setRdvEtatMercredi(int var1) {
      this.rdvEtatMercredi = var1;
   }

   public int getRdvEtatSamedi() {
      return this.rdvEtatSamedi;
   }

   public void setRdvEtatSamedi(int var1) {
      this.rdvEtatSamedi = var1;
   }

   public int getRdvEtatVendredi() {
      return this.rdvEtatVendredi;
   }

   public void setRdvEtatVendredi(int var1) {
      this.rdvEtatVendredi = var1;
   }

   public boolean isAffiche01Sup() {
      return this.affiche01Sup;
   }

   public void setAffiche01Sup(boolean var1) {
      this.affiche01Sup = var1;
   }

   public boolean isAffiche02Sup() {
      return this.affiche02Sup;
   }

   public void setAffiche02Sup(boolean var1) {
      this.affiche02Sup = var1;
   }

   public boolean isAffiche03Sup() {
      return this.affiche03Sup;
   }

   public void setAffiche03Sup(boolean var1) {
      this.affiche03Sup = var1;
   }

   public boolean isAffiche04Sup() {
      return this.affiche04Sup;
   }

   public void setAffiche04Sup(boolean var1) {
      this.affiche04Sup = var1;
   }

   public boolean isAffiche05Sup() {
      return this.affiche05Sup;
   }

   public void setAffiche05Sup(boolean var1) {
      this.affiche05Sup = var1;
   }

   public boolean isAffiche06Sup() {
      return this.affiche06Sup;
   }

   public void setAffiche06Sup(boolean var1) {
      this.affiche06Sup = var1;
   }

   public boolean isAffiche07Sup() {
      return this.affiche07Sup;
   }

   public void setAffiche07Sup(boolean var1) {
      this.affiche07Sup = var1;
   }

   public String getImpcol01() {
      return this.impcol01;
   }

   public void setImpcol01(String var1) {
      this.impcol01 = var1;
   }

   public String getImpcol02() {
      return this.impcol02;
   }

   public void setImpcol02(String var1) {
      this.impcol02 = var1;
   }

   public String getImpcol03() {
      return this.impcol03;
   }

   public void setImpcol03(String var1) {
      this.impcol03 = var1;
   }

   public String getImpcol04() {
      return this.impcol04;
   }

   public void setImpcol04(String var1) {
      this.impcol04 = var1;
   }

   public String getImpcol05() {
      return this.impcol05;
   }

   public void setImpcol05(String var1) {
      this.impcol05 = var1;
   }

   public String getImpcol06() {
      return this.impcol06;
   }

   public void setImpcol06(String var1) {
      this.impcol06 = var1;
   }

   public String getImpcol07() {
      return this.impcol07;
   }

   public void setImpcol07(String var1) {
      this.impcol07 = var1;
   }

   public int getNbAnnule() {
      return this.nbAnnule;
   }

   public void setNbAnnule(int var1) {
      this.nbAnnule = var1;
   }

   public int getNbFait() {
      return this.nbFait;
   }

   public void setNbFait(int var1) {
      this.nbFait = var1;
   }

   public int getNbNonFait() {
      return this.nbNonFait;
   }

   public void setNbNonFait(int var1) {
      this.nbNonFait = var1;
   }

   public int getNbReporte() {
      return this.nbReporte;
   }

   public void setNbReporte(int var1) {
      this.nbReporte = var1;
   }

   public int getRdvNature() {
      return this.rdvNature;
   }

   public void setRdvNature(int var1) {
      this.rdvNature = var1;
   }

   public int getNbRdv() {
      return this.nbRdv;
   }

   public void setNbRdv(int var1) {
      this.nbRdv = var1;
   }

   public float getTauxSucces() {
      return this.tauxSucces;
   }

   public void setTauxSucces(float var1) {
      this.tauxSucces = var1;
   }

   public boolean isRdvErreurDimanche() {
      return this.rdvErreurDimanche;
   }

   public void setRdvErreurDimanche(boolean var1) {
      this.rdvErreurDimanche = var1;
   }

   public boolean isRdvErreurJeudi() {
      return this.rdvErreurJeudi;
   }

   public void setRdvErreurJeudi(boolean var1) {
      this.rdvErreurJeudi = var1;
   }

   public boolean isRdvErreurLundi() {
      return this.rdvErreurLundi;
   }

   public void setRdvErreurLundi(boolean var1) {
      this.rdvErreurLundi = var1;
   }

   public boolean isRdvErreurMardi() {
      return this.rdvErreurMardi;
   }

   public void setRdvErreurMardi(boolean var1) {
      this.rdvErreurMardi = var1;
   }

   public boolean isRdvErreurMercredi() {
      return this.rdvErreurMercredi;
   }

   public void setRdvErreurMercredi(boolean var1) {
      this.rdvErreurMercredi = var1;
   }

   public boolean isRdvErreurSamedi() {
      return this.rdvErreurSamedi;
   }

   public void setRdvErreurSamedi(boolean var1) {
      this.rdvErreurSamedi = var1;
   }

   public boolean isRdvErreurVendredi() {
      return this.rdvErreurVendredi;
   }

   public void setRdvErreurVendredi(boolean var1) {
      this.rdvErreurVendredi = var1;
   }

   public List getLesCmdJourDimanche() {
      return this.lesCmdJourDimanche;
   }

   public void setLesCmdJourDimanche(List var1) {
      this.lesCmdJourDimanche = var1;
   }

   public List getLesCmdJourJeudi() {
      return this.lesCmdJourJeudi;
   }

   public void setLesCmdJourJeudi(List var1) {
      this.lesCmdJourJeudi = var1;
   }

   public List getLesCmdJourLundi() {
      return this.lesCmdJourLundi;
   }

   public void setLesCmdJourLundi(List var1) {
      this.lesCmdJourLundi = var1;
   }

   public List getLesCmdJourMardi() {
      return this.lesCmdJourMardi;
   }

   public void setLesCmdJourMardi(List var1) {
      this.lesCmdJourMardi = var1;
   }

   public List getLesCmdJourMercredi() {
      return this.lesCmdJourMercredi;
   }

   public void setLesCmdJourMercredi(List var1) {
      this.lesCmdJourMercredi = var1;
   }

   public List getLesCmdJourSamedi() {
      return this.lesCmdJourSamedi;
   }

   public void setLesCmdJourSamedi(List var1) {
      this.lesCmdJourSamedi = var1;
   }

   public List getLesCmdJourVendredi() {
      return this.lesCmdJourVendredi;
   }

   public void setLesCmdJourVendredi(List var1) {
      this.lesCmdJourVendredi = var1;
   }
}
