package com.epegase.systeme.menu;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.control.Module;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class MenuListe implements Serializable {
   public boolean rechercheModule(Structure var1, int var2) {
      boolean var3 = false;
      ArrayList var4 = new ArrayList();
      if (var1.getStrmod1() != null && !var1.getStrmod1().isEmpty()) {
         var4.add(var1.getStrmod1());
      }

      if (var1.getStrmod2() != null && !var1.getStrmod2().isEmpty()) {
         var4.add(var1.getStrmod2());
      }

      if (var1.getStrmod3() != null && !var1.getStrmod3().isEmpty()) {
         var4.add(var1.getStrmod3());
      }

      if (var1.getStrmod4() != null && !var1.getStrmod4().isEmpty()) {
         var4.add(var1.getStrmod4());
      }

      if (var1.getStrmod5() != null && !var1.getStrmod5().isEmpty()) {
         var4.add(var1.getStrmod5());
      }

      if (var1.getStrmod6() != null && !var1.getStrmod6().isEmpty()) {
         var4.add(var1.getStrmod6());
      }

      if (var1.getStrmod7() != null && !var1.getStrmod7().isEmpty()) {
         var4.add(var1.getStrmod7());
      }

      if (var1.getStrmod8() != null && !var1.getStrmod8().isEmpty()) {
         var4.add(var1.getStrmod8());
      }

      if (var1.getStrmod9() != null && !var1.getStrmod8().isEmpty()) {
         var4.add(var1.getStrmod9());
      }

      if (var1.getStrmod10() != null && !var1.getStrmod10().isEmpty()) {
         var4.add(var1.getStrmod10());
      }

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         String var6 = "" + var2;
         if (var6.contentEquals((CharSequence)var4.get(var5))) {
            var3 = true;
         }
      }

      return var3;
   }

   public DataModel menuOffice() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Options de l'Office");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Chronos de l'Office");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Gestion des répertoires (dossiers)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des natures des courriers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des porte-feuilles d`affaire");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des natures des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des sujets des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des lieux des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des budgets des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des % d'apports des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste des modes de financements des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Liste des délais de livraison des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Liste des prochaines actions des RDV");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Liste des conclusions vendeurs des RDV");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuTiers() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Chronos des Tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Gestion des devises");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Gestion des familles de Tiers clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Gestion des familles de Tiers fournisseurs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Gestion des types de règlements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Gestion des modes de règlement clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Gestion des modes de règlement fournisseurs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des appréciations des tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des civilités des tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des sources des tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste des catégories de tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Liste des métiers des tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Liste des fonctions des utilisateurs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Liste des formes juridiques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Liste des Pays");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Liste des banques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Liste des centres intérêts");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuComptaLib() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options de la comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos de la comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Natures des comptes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Natures des journaux comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Racines comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Plans comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Journaux comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Configuration avancée des impressions générales");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuComptaSoc() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options de la comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos de la comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Natures des comptes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Natures des journaux comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Racines comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Plans comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Journaux comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Localisations immobilisations");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Modèles d`écritures");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Plans analytiques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Plans budgétaires");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Plans trésorerie");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Etats financiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Configuration avancée des impressions générales");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Configuration avancée des impressions analytiques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Configuration avancée des impressions des amortissements...");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuAchats(Structure var1, int var2) {
      if (var1.getStrtypeentreprise() == null || var1.getStrtypeentreprise().isEmpty()) {
         var1.setStrtypeentreprise("0");
      }

      ListDataModel var3 = new ListDataModel();
      ArrayList var4 = new ArrayList();
      Module var5 = new Module();
      var5.setLibelle("0001-Gestion des exercices");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0002-Options des achats");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0003-Options des stocks");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0004-Chronos des achats et des stocks");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0005-Liste des dépôts");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0006-Liste des taxes d’achats");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0007-Liste des positions tarifaires");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0008-Liste des natures des familles de produits");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0009-Liste des marques");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0010-Liste des couleurs");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0011-Liste des familles de produits d’achats");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0012-Liste des incoterms");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0013-Liste des formules d’achats");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0014-Liste des unités de stockage");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0015-Liste des conditionnements");
      var4.add(var5);
      if (var1.getStrtypeentreprise().equals("2")) {
         var5 = new Module();
         var5.setLibelle("0016-Liste des process");
         var4.add(var5);
      }

      var5 = new Module();
      var5.setLibelle("0017-Liste des feuilles de frais (calcul du PR théorique)");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0018-Liste des budgets sur achats");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0019-Configuration avancée des impressions relatives aux fournisseurs");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0020-Configuration avancée des impressions des documents fournisseurs");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0021-Configuration avancée des impressions des listes de documents fournisseurs");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0022-Configuration avancée des impressions relatives aux stocks");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0023-Configuration avancée des impressions des documents stocks");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0024-Configuration avancée des impressions des listes de documents stocks");
      var4.add(var5);
      var5 = new Module();
      var5.setLibelle("0025-Habilitation des documents d'achat");
      var4.add(var5);
      if (var2 == 2) {
         var5 = new Module();
         var5.setLibelle("0026-Planning théorique élevage Aviculture");
         var4.add(var5);
      }

      for(int var6 = 0; var6 < var4.size(); ++var6) {
         ((Module)var4.get(var6)).setIndice((long)var6);
      }

      var3.setWrappedData(var4);
      return var3;
   }

   public DataModel menuVentes() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des marques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des couleurs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des Suivis de livraison de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des incoterms");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Liste des unités");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Liste des conditionnements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Liste des modèles de devis avec produits pré-sélectionnés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0018-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0019-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0020-Habilitation et validation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0021-Publication des produits dans E-commerce");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuPaye() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des Payes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des Payes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des Natures des salariés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des Centres des impôts");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des Centres de sécurité sociale");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des Classements des salariés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des Niveaux d'emploi");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des Codes d'emploi");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des Conventions collectives et Grilles salariales");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste du Plan de paye");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Liste des Feuilles de calcul");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Nature des éléments R.H.");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Liste des modèles de documents R.H.");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Localisation des salariés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Nature des prêts");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Bilan social");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0018-Configuration avancée des impressions des documents des agents");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0019-Configuration avancée des impressions des listes de documents des agents");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0020-Habilitation et validation");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuCaisse() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des Caisses");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Liste des Opérations de Caisses");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des Caisses");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Chronos des Caisses");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Configuration avancée des impressions des reçus des bons d'entrée");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Configuration avancée des impressions des reçus des bons de sortie");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-0001-Configuration avancée des impressions des reçus des virements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Configuration avancée des impressions des reçus des documents");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Configuration avancée des impressions des listes des reçus");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Configuration avancée des impressions des listes des opérations");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Habilitation et validation");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuMedical(Structure var1) {
      ListDataModel var2 = new ListDataModel();
      ArrayList var3 = new ArrayList();
      Module var4 = new Module();
      var4.setLibelle("0001-Gestion des exercices");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0002-Options du médical");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0003-Chronos du médical");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0004-Liste des protocoles médicaux");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0005-Liste des antécédents médicaux");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0006-Liste des taxes médicales");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0007-Liste des natures des familles de produits");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0008-Liste des familles de produits de médicaux");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0009-Valeur des lettres");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0010-Liste des types de pathologies");
      var3.add(var4);
      if (this.rechercheModule(var1, 81500)) {
         var4 = new Module();
         var4.setLibelle("0025-Liste des vaccins");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0026-Liste des audiométies");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0027-Liste des examens V.M.E.");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0028-Liste des examens V.M.A.");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0029-Liste des examens I.D.R. (tubertest)");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0030-Liste des motifs des entrées des consultations et du laboratoire");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0031-Classification internationale de maladies (CIM)");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0032-Liste des médicamments");
         var3.add(var4);
      } else {
         var4 = new Module();
         var4.setLibelle("0011-Liste des motifs des entrées des consultations et du laboratoire");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0012-Liste des motifs des entrées des hospitalisations");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0013-Liste des provenances des hospitalisations");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0014-Liste des motifs des sorties des hospitalisations");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0015-Liste des destinations des hospitalisations");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0016-Liste des spécialités par service");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0017-Liste des catégories des examens de laboratoire");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0018-Catégorie majeure de diagnostiques (CMD)");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0019-Classification internationale de maladies (CIM)");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0020-Codification communes des actes (CCAM)");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0021-Nomenclature générale des actes professionels (NGAP)");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0022-Complication ou morbidité associée (CMA)");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0023-Liste des médicamments");
         var3.add(var4);
         var4 = new Module();
         var4.setLibelle("0024-Commissions des médecins");
         var3.add(var4);
      }

      var4 = new Module();
      var4.setLibelle("0033-Configuration avancée des impressions relatives aux patients");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0034-Configuration avancée des impressions des documents patients");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0035-Configuration avancée des impressions des listes des documents patients");
      var3.add(var4);
      var4 = new Module();
      var4.setLibelle("0036-Habilitation et validation");
      var3.add(var4);

      for(int var5 = 0; var5 < var3.size(); ++var5) {
         ((Module)var3.get(var5)).setIndice((long)var5);
      }

      var2.setWrappedData(var3);
      return var2;
   }

   public DataModel menuMicroFinance() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options de la Microfinance ");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Liste des taxes de la Microfinance");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des natures des familles de produits ");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des familles de produits de la Microfinance");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des caisses ");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Script des ouvertures de dossier");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Script des fermetures de dossier");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Configuration des comptes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Configuration des prêts");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Configuration des produits divers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Configuration avancée des Impressions des  Micros Finances");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Habilitation et validation");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuParcs() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des Parcs ");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des Parcs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des natures des Parcs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des familles des Parcs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Caractéristiques et inventaires des familles des Parcs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des motifs d'entrée");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des ports, aéroports, gares, agences");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des lieux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des natures des manifests");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Configuration avancée des impressions des documents des parcs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Configuration avancée des impressions des listes de documents des parcs");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuVentesCpt() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des marques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des couleurs");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des Suivis de livraison de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des incoterms");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Liste des unités");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Liste des conditionnements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0018-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0019-Habilitation et validation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0020-Publication des produits dans E-commerce");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuFondation() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices de la fondation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options de la fondation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos de la fondation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Nature des demandes");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuInterim() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des incoterms");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Habilitation et validation");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuCabinet() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des missions");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Habilitation et validation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Publication des produits dans E-commerce");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuTransit() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des Suivis de livraison de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des incoterms");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des unités");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste des conditionnements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Habilitation et validation");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuChange() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices ...");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuEducation() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options de l'éducation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos de l'éducation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des classes/Filières");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des classements médiathèques (méthode Dewey)");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuPecherie() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices ...");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuTemples() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices ...");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuPartiPolitique() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices ...");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuForet() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options de la forêt");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos de la forêt");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des essences");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des classements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des lieux (Origines et destinations)");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuImmobilier() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options de l'immobilier");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos de l'immobilier");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des natures des biens");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Habilitation et validation");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuRestaurant() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des unités");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des conditionnements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Habilitation et validation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Publication des produits dans E-commerce");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuHotelerie() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Options des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Chronos des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Liste des taxes des ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Liste des natures des familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Liste des familles de produits de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Liste des formules de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Liste des unités");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Liste des conditionnements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Liste des modèles de documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Liste des modèles de contrats commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Configuration avancée des impressions relatives aux clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Configuration avancée des impressions des documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Configuration avancée des impressions des listes de documents clients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Habilitation et validation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Publication des produits dans E-commerce");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuTemps() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      new Module();
      Module var3 = new Module();
      var3.setLibelle("0001-Gestion des tâches");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesTiers() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Fusion des tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Recalcul des tiers (A CREER) à partir des documents commerciaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Flag des mails des bals d'une période");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Dé-Flag des mails des bals d'une période");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Vérification des pièces jointes reçues");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Réimputation des tiers (Suspects, Prospects, clients)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Chiffrement Cesar (tiers, destinataires, salariés, users, plan comptable)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Transfert élément parapheur d'un user vers un autre");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesCompta() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Recalcul des natures des comptes des écritures comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Recalcul des natures des journaux des écritures comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Transfert des plans analytiques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Dé-validation des écritures comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Effacement des sémaphores dans les journaux comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Délettrage des écritures entre 2 exercices");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Flag des dotations (forcage du transfert en comptabilité)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Annulation du transfert des dotations en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Recalcul des clés des écritures comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Calcul du tableau des dotations");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Recalcul des écritures analytiques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Dé-cloture mensuelle des journaux comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Vérification des décimales dans les journaux comptables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Recalcul des clés des journaux mois");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Restauration écritures détruites");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Suppression écritures des journaux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Flag les rapprochements bancaires (initalisation)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0018-Analyse et réparation des écritures générales");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0019-Analyse des écritures analytiques");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0020-Dé-cloture des rapprochements bancaires");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0021-Recalcul des clés des rapprochements bancaires");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0022-Recalcul du plan comptable");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0023-Recalcul libellé des comptes des amortissements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0024-Génération plan comptable à partir des tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0025-Recalcul libellé des comptes des écritures");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0026-Recalcul montant colonne EURO");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0027-Recalcul des dates d'échéances des écritures comptables");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesAchats() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Annuler le transfert des achats en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Forcer le transfert des achats en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Réimputation des dépôts (Inventaire, Cession, Bon entrée, Bon sortie)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Recalcul des stocks");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Recalculer libellé des lignes de documents avec les produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Affectation des dépots par familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Recalcul solde des factures, des notes de débit et des factures de frais");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Recalcul des dates d'échéance des factures, des notes de débit et des factures de frais");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Recalcul des valorisations des réceptions et des fabrications.");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Recalcul des PUMP des entrées en stock");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Recalcul des PUMP (PRC) des mouvements des produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Désactivation des produits dont le stock = 0");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Suppression des produits désactivés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Vérification des dossiers d'importation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Extraction TVA/douanes dans les factures de frais");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Recalcul des connexions des tables Cotation, BC, Réception, Retour, Facture, Ndb et Avoir avec les Tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Change numéro de dossier importation");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0018-Génération des familles de produits achats absentes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0019-Recalcul des familles de produits dans les mouvements d'achats");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0020-Recalcul des derniéres dates sur cotation, CMD, Réception, retour, facture, note débit, avoir");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0021-Recalcul des libelles des familles des produits à partir des familles");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0022-Affectation des services par familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0023-Suppression des documents d`achats pour une période");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0024-Désactive produits sans mouvements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0025-Désactive produits sans inventaire");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0026-Regénération des liaisons des produits/Fournisseurs à partir des réceptions");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0027-Recalcul connexion des frais directs avec les réceptions");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0028-Recalcul des références founisseurs dans cotations, commandes et réceptions");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesVentes() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Annuler le transfert des ventes en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Forcer le transfert des ventes en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Recalcul dernier règlement dans les factures");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Recalcul des tarifs des produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Désactiver les produits sans tarif");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Recalculer libellé des lignes de documents avec les produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Affectation des tarifs par familles de produits");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Génération des BL à partir des factures directes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Recalcul solde des B.C., B.L., factures et des notes de débit");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Recalcul des dates d'échéance des factures et des notes de débit");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Recalcul des liaisons N° (Bl : N° Facture, Facture : N° Bl, Retour : N° Avoir)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Recalcul des prix unitaires TTC dans les lignes des factures ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Recalcul des liaisons BC => BL lignes (à partir de la traçabilité)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Recalcul des quantités livrées des BL à partir des BL livrés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Recalcul des connexions de la table livraison livrée");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Recalcul des connexions des tables Devis, BC, BL, Retour, Facture, Ndb et Avoir");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Génération des règlements des factures => solde des factures");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0018-Recalcul des activités des documents entetes à partir des activités des produits (BC, BL, FAC)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0019-Recalcul des qte livrées sur CMD à partir des BL");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0020-Recalcul le cumul des timbres des factures à partir des règlements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0021-Recalcul la date de facture à partir de la date du BL");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0022-Génération des familles de produits ventes absentes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0023-Recalcul des groupe Tiers/Destinataires dans les documents (Devis, BC, BL, BR, Facture, Ndb, Avoir, contrat)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0024-Purger les doublons des tracabilités");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0025-Recalcul des familles de produits dans les mouvements de ventes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0026-Recalcul des TVA ou CSS ou TC sur devis, BC, BL, facture, note débit, avoir");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0027-Recalcul des derniéres dates sur devis, BC, BL, retour, facture, note débit, avoir");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0028-Recalcul dernier règlement dans les commandes");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0029-Enlève du stocks toutes les prestations (sans familles achats)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0030-Mise en livraison des qte BL livrées (livreurs)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0031-Suppression des documents de ventes pour une période");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0032-Si bl ttc <> facture TTC et factures non lettrées alors récuperer lignes des BL");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesMedical() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Connexion des Ayants-Droits avec les Assurés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Mise à jour des patients avec prise en charge ");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Fusion des patients");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Suppression des documents médicaux pour une période");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Recalcul des documents médicaux pour une période");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Annuler le transfert des ventes en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Forcer le transfert des ventes en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Recalcul des etats des dcumements médicaux");
      var2.add(var3);
      new Module();

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesParc() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("déverrouillage des manifestes");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesPaye() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Recalcul des bulletins de salaire");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Suppression des bulletins de salaire");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Recalcul des prêts (avec les échéances actuelles)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Recalcul des salariés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Dé-cloture des bulletins de salaire");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Annulation du transfert des bulletins de salaire en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Effacement des sémaphores dans les préparations");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Effacement des sémaphores dans les générations");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Recalcul des lignes des bulletins colA et colB (rub. impôts)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Recopie contrat dans éléments et bulletins");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Recalcul des numeros de semaine des CP");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Génération des salariés en USERS");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Recalcul des prêts (regénération des échéances manquantes)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0014-Recopie nature des salariés dans nature des contrats");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0015-Recalcul base conventionnée dans contrat");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0016-Saisie turbo des bulletins de salaires");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0017-Génération des contrats à partir des salariés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0018-Recalcul des N° SECU, IPRESS, CNSS, CNAMGS, AMO dans les bulletins");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0019-Recalcul des compteurs des congés payés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0020-Recalcul du plan de paye dans les lignes des bulletins");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0021-Recalcul du plan de paye dans les variables");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0022-Recopie imputation tiers des salariés dans les contrats et les bulletins");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0023-Recopie dans bulletins les informations du salariés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0024-Recalcul de la base des congés payés (à exécuter 2 fois)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0025-Recopies des variables de Décembre vers Janvier (après cloture annuelle)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0026-Recalcul de la table salarie_RH (mise en place des Familles et sous familles)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0027-Effacer les variables (RAZ)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0028-Nettoyage des variables (filtre des doublons)");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0029-Recalcul des clés des journaux mois");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0030-Recopie matricule et nature depuis le salarié vers bulletins, elements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0031-Recopie matricule et nature depuis bulletins vers salarié, elements");
      var2.add(var3);
      new Module();

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesTreso() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Annuler le transfert des caisses en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Forcer le transfert des caisses en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Recalcul règlements VRT Caisse/Banque");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Recalcul (flague) les bons d'encaissements avec les reglèments");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Recalcul des connexions des tables Tiers");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Recalcul des activités des règlements à partir des activités des documents (BC, BL, FAC) + vérification");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Recalcul des numéros de reçus vides");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Suppression des documents de trésorerie pour une période");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Dé-cloture des caisses commerciales mensuelles");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Dé-cloture des caisses commerciales journalières");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Recalcul des clés des règlements");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }

   public DataModel menuUtilitairesImmobilier() {
      ListDataModel var1 = new ListDataModel();
      ArrayList var2 = new ArrayList();
      Module var3 = new Module();
      var3.setLibelle("0001-Annuler le transfert des locations en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0002-Forcer le transfert des locations en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0003-Annuler le transfert du syndic en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0004-Forcer le transfert du syndic en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0005-Annuler le transfert du négoce en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0006-Forcer le transfert du négoce en comptabilité");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0007-Recalcul les biens");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0008-Recalcul les baux");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0009-Recalcul les factures");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0010-Recalcul les règlements");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0011-Recalcul les réglements des factures");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0012-Désactive les tiers inutilisés");
      var2.add(var3);
      var3 = new Module();
      var3.setLibelle("0013-Suppression des documents immobiliers pour une période");
      var2.add(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         ((Module)var2.get(var4)).setIndice((long)var4);
      }

      var1.setWrappedData(var2);
      return var1;
   }
}
