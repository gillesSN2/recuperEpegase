package com.epegase.systeme.control;

import java.io.Serializable;

public class DocumentStatistique implements Serializable {
   String nomConseiller;
   long idConseiller;
   int nbTiersPeriode = 0;
   int nbTiersHorsPeriode = 0;
   int nbTiersNonAffectePeriode = 0;
   int nbTiersNonAffecteHorsPeriode = 0;
   int nbRappelPeriode = 0;
   int nbRappelHorsPeriode = 0;
   int nbRdvPeriode = 0;
   int nbRdvHorsPeriode = 0;
   int nbToDoPeriode = 0;
   int nbToDoHorsPeriode = 0;
   int nbEmploiTPeriode = 0;
   int nbEmploiTHorsPeriode = 0;
   int nbVisitePeriode = 0;
   int nbVisiteHorsPeriode = 0;
   int nbInterventionPeriode = 0;
   int nbInterventionHorsPeriode = 0;
   int nbAppelPeriode = 0;
   int nbAppelHorsPeriode = 0;
   int nbPointagePeriode = 0;
   int nbPointageHorsPeriode = 0;
   int nbReunionPeriode = 0;
   int nbReunionHorsPeriode = 0;
   int nbMessagePeriode = 0;
   int nbMessageHorsPeriode = 0;
   int nbPostitPeriode = 0;
   int nbPostitHorsPeriode = 0;
   int nbCalendrierPeriode = 0;
   int nbCalendrierHorsPeriode = 0;
   int nbCmdPeriode = 0;
   int nbCmdHorsPeriode = 0;
   int nbMailsPeriode = 0;
   int nbMailsHorsPeriode = 0;
   int nbRondePeriode = 0;
   int nbRondeHorsPeriode = 0;

   public long getIdConseiller() {
      return this.idConseiller;
   }

   public void setIdConseiller(long var1) {
      this.idConseiller = var1;
   }

   public String getNomConseiller() {
      return this.nomConseiller;
   }

   public void setNomConseiller(String var1) {
      this.nomConseiller = var1;
   }

   public int getNbAppelHorsPeriode() {
      return this.nbAppelHorsPeriode;
   }

   public void setNbAppelHorsPeriode(int var1) {
      this.nbAppelHorsPeriode = var1;
   }

   public int getNbAppelPeriode() {
      return this.nbAppelPeriode;
   }

   public void setNbAppelPeriode(int var1) {
      this.nbAppelPeriode = var1;
   }

   public int getNbCalendrierHorsPeriode() {
      return this.nbCalendrierHorsPeriode;
   }

   public void setNbCalendrierHorsPeriode(int var1) {
      this.nbCalendrierHorsPeriode = var1;
   }

   public int getNbCalendrierPeriode() {
      return this.nbCalendrierPeriode;
   }

   public void setNbCalendrierPeriode(int var1) {
      this.nbCalendrierPeriode = var1;
   }

   public int getNbCmdHorsPeriode() {
      return this.nbCmdHorsPeriode;
   }

   public void setNbCmdHorsPeriode(int var1) {
      this.nbCmdHorsPeriode = var1;
   }

   public int getNbCmdPeriode() {
      return this.nbCmdPeriode;
   }

   public void setNbCmdPeriode(int var1) {
      this.nbCmdPeriode = var1;
   }

   public int getNbEmploiTHorsPeriode() {
      return this.nbEmploiTHorsPeriode;
   }

   public void setNbEmploiTHorsPeriode(int var1) {
      this.nbEmploiTHorsPeriode = var1;
   }

   public int getNbEmploiTPeriode() {
      return this.nbEmploiTPeriode;
   }

   public void setNbEmploiTPeriode(int var1) {
      this.nbEmploiTPeriode = var1;
   }

   public int getNbInterventionHorsPeriode() {
      return this.nbInterventionHorsPeriode;
   }

   public void setNbInterventionHorsPeriode(int var1) {
      this.nbInterventionHorsPeriode = var1;
   }

   public int getNbInterventionPeriode() {
      return this.nbInterventionPeriode;
   }

   public void setNbInterventionPeriode(int var1) {
      this.nbInterventionPeriode = var1;
   }

   public int getNbMailsHorsPeriode() {
      return this.nbMailsHorsPeriode;
   }

   public void setNbMailsHorsPeriode(int var1) {
      this.nbMailsHorsPeriode = var1;
   }

   public int getNbMailsPeriode() {
      return this.nbMailsPeriode;
   }

   public void setNbMailsPeriode(int var1) {
      this.nbMailsPeriode = var1;
   }

   public int getNbMessageHorsPeriode() {
      return this.nbMessageHorsPeriode;
   }

   public void setNbMessageHorsPeriode(int var1) {
      this.nbMessageHorsPeriode = var1;
   }

   public int getNbMessagePeriode() {
      return this.nbMessagePeriode;
   }

   public void setNbMessagePeriode(int var1) {
      this.nbMessagePeriode = var1;
   }

   public int getNbPointageHorsPeriode() {
      return this.nbPointageHorsPeriode;
   }

   public void setNbPointageHorsPeriode(int var1) {
      this.nbPointageHorsPeriode = var1;
   }

   public int getNbPointagePeriode() {
      return this.nbPointagePeriode;
   }

   public void setNbPointagePeriode(int var1) {
      this.nbPointagePeriode = var1;
   }

   public int getNbPostitHorsPeriode() {
      return this.nbPostitHorsPeriode;
   }

   public void setNbPostitHorsPeriode(int var1) {
      this.nbPostitHorsPeriode = var1;
   }

   public int getNbPostitPeriode() {
      return this.nbPostitPeriode;
   }

   public void setNbPostitPeriode(int var1) {
      this.nbPostitPeriode = var1;
   }

   public int getNbRappelHorsPeriode() {
      return this.nbRappelHorsPeriode;
   }

   public void setNbRappelHorsPeriode(int var1) {
      this.nbRappelHorsPeriode = var1;
   }

   public int getNbRappelPeriode() {
      return this.nbRappelPeriode;
   }

   public void setNbRappelPeriode(int var1) {
      this.nbRappelPeriode = var1;
   }

   public int getNbRdvHorsPeriode() {
      return this.nbRdvHorsPeriode;
   }

   public void setNbRdvHorsPeriode(int var1) {
      this.nbRdvHorsPeriode = var1;
   }

   public int getNbRdvPeriode() {
      return this.nbRdvPeriode;
   }

   public void setNbRdvPeriode(int var1) {
      this.nbRdvPeriode = var1;
   }

   public int getNbReunionHorsPeriode() {
      return this.nbReunionHorsPeriode;
   }

   public void setNbReunionHorsPeriode(int var1) {
      this.nbReunionHorsPeriode = var1;
   }

   public int getNbReunionPeriode() {
      return this.nbReunionPeriode;
   }

   public void setNbReunionPeriode(int var1) {
      this.nbReunionPeriode = var1;
   }

   public int getNbRondeHorsPeriode() {
      return this.nbRondeHorsPeriode;
   }

   public void setNbRondeHorsPeriode(int var1) {
      this.nbRondeHorsPeriode = var1;
   }

   public int getNbRondePeriode() {
      return this.nbRondePeriode;
   }

   public void setNbRondePeriode(int var1) {
      this.nbRondePeriode = var1;
   }

   public int getNbTiersHorsPeriode() {
      return this.nbTiersHorsPeriode;
   }

   public void setNbTiersHorsPeriode(int var1) {
      this.nbTiersHorsPeriode = var1;
   }

   public int getNbTiersNonAffecteHorsPeriode() {
      return this.nbTiersNonAffecteHorsPeriode;
   }

   public void setNbTiersNonAffecteHorsPeriode(int var1) {
      this.nbTiersNonAffecteHorsPeriode = var1;
   }

   public int getNbTiersNonAffectePeriode() {
      return this.nbTiersNonAffectePeriode;
   }

   public void setNbTiersNonAffectePeriode(int var1) {
      this.nbTiersNonAffectePeriode = var1;
   }

   public int getNbTiersPeriode() {
      return this.nbTiersPeriode;
   }

   public void setNbTiersPeriode(int var1) {
      this.nbTiersPeriode = var1;
   }

   public int getNbToDoHorsPeriode() {
      return this.nbToDoHorsPeriode;
   }

   public void setNbToDoHorsPeriode(int var1) {
      this.nbToDoHorsPeriode = var1;
   }

   public int getNbToDoPeriode() {
      return this.nbToDoPeriode;
   }

   public void setNbToDoPeriode(int var1) {
      this.nbToDoPeriode = var1;
   }

   public int getNbVisiteHorsPeriode() {
      return this.nbVisiteHorsPeriode;
   }

   public void setNbVisiteHorsPeriode(int var1) {
      this.nbVisiteHorsPeriode = var1;
   }

   public int getNbVisitePeriode() {
      return this.nbVisitePeriode;
   }

   public void setNbVisitePeriode(int var1) {
      this.nbVisitePeriode = var1;
   }
}
