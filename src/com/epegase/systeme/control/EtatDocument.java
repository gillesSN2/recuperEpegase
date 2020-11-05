package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class EtatDocument implements Serializable {

   public List calculelisteEtatsItems(int var1, int var2) {
      ArrayList var3 = new ArrayList();
      if (var1 == 7) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(13, "Non Payée"));
         var3.add(new SelectItem(14, "Payée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transférée en compta"));
         var3.add(new SelectItem(18, "Non transférée en compta"));
      } else if (var1 == 8) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(5, "Transformée"));
         var3.add(new SelectItem(11, "Relancée"));
      } else if (var1 == 10) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformée Partiel"));
         var3.add(new SelectItem(5, "Transformée Total"));
      } else if (var1 == 11) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformée Partiel"));
         var3.add(new SelectItem(5, "Transformée Total"));
         var3.add(new SelectItem(11, "Relancée"));
         var3.add(new SelectItem(15, "Exonérée"));
      } else if (var1 == 12) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformée Partiel"));
         var3.add(new SelectItem(5, "Transformée Total"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(11, "Priorité : Basse"));
         var3.add(new SelectItem(12, "Priorité : Normale"));
         var3.add(new SelectItem(13, "Priorité : Urgente"));
         var3.add(new SelectItem(14, "Priorité : Maximale"));
         var3.add(new SelectItem(15, "Réalisation Interne"));
         var3.add(new SelectItem(16, "Réalisation Externe"));
         if (var2 == 1) {
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Non Payée"));
            var3.add(new SelectItem(18, "Payée"));
         }
      } else if (var1 == 13) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformée Partiel"));
         var3.add(new SelectItem(5, "Transformée Total"));
      } else if (var1 == 14) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformé Partiel"));
         var3.add(new SelectItem(5, "Transformé Total"));
      } else if (var1 == 15) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(12, "Promotion"));
         if (var2 == 0) {
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(14, "Payée"));
         }

         var3.add(new SelectItem(15, "Exonérée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transférée en compta"));
         var3.add(new SelectItem(18, "Non transférée en compta"));
      } else if (var1 == 16) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejeté"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(11, "Relancé"));
         var3.add(new SelectItem(12, "Promotion"));
         var3.add(new SelectItem(13, "Non Payé"));
         var3.add(new SelectItem(14, "Payé"));
         var3.add(new SelectItem(15, "Exonéré"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transféré en compta"));
         var3.add(new SelectItem(18, "Non transféré en compta"));
      } else if (var1 == 17) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(12, "Promotion"));
         var3.add(new SelectItem(13, "Non Payée"));
         var3.add(new SelectItem(14, "Payée"));
         var3.add(new SelectItem(15, "Exonérée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transférée en compta"));
         var3.add(new SelectItem(18, "Non transférée en compta"));
      } else if (var1 == 18) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(12, "Promotion"));
         var3.add(new SelectItem(13, "Non Payée"));
         var3.add(new SelectItem(14, "Payée"));
         var3.add(new SelectItem(15, "Exonérée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transférée en compta"));
         var3.add(new SelectItem(18, "Non transférée en compta"));
      } else if (var1 == 150) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Chargement"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(4, "Frontière"));
         var3.add(new SelectItem(6, "Livraison"));
      } else if (var1 == 20) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejeté"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformé Partiel"));
         var3.add(new SelectItem(5, "Transformé Total"));
         var3.add(new SelectItem(11, "Relancé"));
         var3.add(new SelectItem(12, "Promotion"));
         var3.add(new SelectItem(15, "Exonéré"));
      } else if (var1 == 21) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(6, "Mise en attente"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejeté"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformée Partielle"));
         var3.add(new SelectItem(5, "Transformée Totale"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(11, "Relancé"));
         var3.add(new SelectItem(12, "Promotion"));
         var3.add(new SelectItem(13, "Non Payé"));
         var3.add(new SelectItem(14, "Payé"));
         var3.add(new SelectItem(15, "Exonéré"));
      } else if (var1 == 22) {
         var3.add(new SelectItem(0, "En cours"));
         if (var2 == 1) {
            var3.add(new SelectItem(28, "En cours + validée + livraison partielle + non payée"));
         } else {
            var3.add(new SelectItem(28, "En cours + validée + livraison partielle"));
         }

         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(29, "Validée + livraison partielle"));
         var3.add(new SelectItem(30, "En cours + Validée + transformée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformée Partielle"));
         var3.add(new SelectItem(5, "Transformée Totale"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(11, "Relancée"));
         var3.add(new SelectItem(12, "Promotion"));
         if (var2 == 1) {
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(16, "Avec accompte"));
            var3.add(new SelectItem(14, "Soldée"));
         }

         var3.add(new SelectItem(15, "Exonérée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(21, "Phase Validée et initiale"));
         var3.add(new SelectItem(22, "Phase Validée et en cours"));
         var3.add(new SelectItem(23, "Phase Validée et finale"));
         var3.add(new SelectItem(24, "Priorité : basse"));
         var3.add(new SelectItem(25, "Priorite : normale"));
         var3.add(new SelectItem(26, "Priorité : urgente"));
         var3.add(new SelectItem(27, "Priorité : maximale"));
      } else if (var1 == 23) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         if (var2 == 2) {
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(16, "Avec accompte"));
            var3.add(new SelectItem(14, "Soldée"));
         }

         var3.add(new SelectItem(33, "Validée et Non Facturée"));
         var3.add(new SelectItem(4, "Facturée Partielle"));
         var3.add(new SelectItem(5, "Facturée Totale"));
         var3.add(new SelectItem(30, "BL non livrée"));
         var3.add(new SelectItem(31, "BL livrée partielle"));
         var3.add(new SelectItem(32, "BL livrée totale"));
      } else if (var1 == 24) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejeté"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(4, "Transformé Partiel"));
         var3.add(new SelectItem(5, "Transformé Total"));
      } else if (var1 == 25) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(8, "Origine (Fusion)"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(11, "Relancée"));
         var3.add(new SelectItem(12, "Promotion"));
         if (var2 == 0) {
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(14, "Payée"));
         }

         var3.add(new SelectItem(20, "Factures Acomptes"));
         var3.add(new SelectItem(15, "Exonérée"));
         var3.add(new SelectItem(16, "Visa attente"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transférée en compta"));
         var3.add(new SelectItem(18, "Non transférée en compta"));
      } else if (var1 == 26) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejeté"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(11, "Relancé"));
         var3.add(new SelectItem(12, "Promotion"));
         var3.add(new SelectItem(13, "Non Payé"));
         var3.add(new SelectItem(14, "Payé"));
         var3.add(new SelectItem(15, "Exonéré"));
         var3.add(new SelectItem(16, "Visa attente"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transféré en compta"));
         var3.add(new SelectItem(18, "Non transféré en compta"));
      } else if (var1 == 27) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(11, "Relancée"));
         var3.add(new SelectItem(12, "Promotion"));
         var3.add(new SelectItem(13, "Non Payée"));
         var3.add(new SelectItem(14, "Payée"));
         var3.add(new SelectItem(15, "Exonérée"));
         var3.add(new SelectItem(16, "Visa attente"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transférée en compta"));
         var3.add(new SelectItem(18, "Non transférée en compta"));
      } else if (var1 == 28) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(4, "Déchargé"));
         var3.add(new SelectItem(5, "Trf. Cpte"));
      } else if (var1 == 140) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(4, "Terminé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
      } else if (var1 == 141) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(4, "Terminé"));
      } else if (var1 == 142) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(13, "Non Payée"));
         var3.add(new SelectItem(14, "Payée"));
         var3.add(new SelectItem(101, "----------"));
         var3.add(new SelectItem(17, "Transférée en compta"));
         var3.add(new SelectItem(18, "Non transférée en compta"));
      } else if (var1 == 127) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée interne"));
         var3.add(new SelectItem(2, "Annulée"));
         var3.add(new SelectItem(3, "Gelée"));
         var3.add(new SelectItem(4, "Validée client"));
         var3.add(new SelectItem(5, "Terminée"));
      } else if (var1 == 30) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
      } else if (var1 == 31) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
      } else if (var1 == 32) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
      } else if (var1 == 33) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
      } else if (var1 == 34) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejetée"));
      } else if (var1 == 35) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulée"));
      } else if (var1 == 43) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(4, "Facturé"));
      } else if (var1 == 45) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(3, "Annulée"));
      } else if (var1 == 46) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validé"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(4, "Attente Piece"));
         var3.add(new SelectItem(5, "Attente M.O."));
         var3.add(new SelectItem(9, "Cloturé"));
      } else if (var1 == 47) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelée"));
         var3.add(new SelectItem(3, "Annulé"));
         var3.add(new SelectItem(4, "Facturé"));
         var3.add(new SelectItem(11, "Non Facturé"));
         var3.add(new SelectItem(6, "Correction"));
         var3.add(new SelectItem(7, "Rejeté"));
      } else if (var1 == 57) {
         var3.add(new SelectItem(0, "En cours"));
         var3.add(new SelectItem(1, "Validée"));
         var3.add(new SelectItem(2, "Gelé"));
         var3.add(new SelectItem(3, "Annulée"));
         var3.add(new SelectItem(4, "Traitée"));
      } else if (var1 != 70) {
         if (var1 == 71) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(5, "Controlée"));
            var3.add(new SelectItem(6, "Refacturée Ass./Soc."));
            var3.add(new SelectItem(7, "Refacturée Compl."));
            var3.add(new SelectItem(19, "Validée, Contrôlée"));
            var3.add(new SelectItem(20, "Validée, Contrôlée, cloturé, Refacturé"));
            var3.add(new SelectItem(21, "En cours, Validée (Statistiques infirmerie)"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée Patient"));
            var3.add(new SelectItem(14, "Payée Patient"));
            var3.add(new SelectItem(15, "Non Payée Tiers"));
            var3.add(new SelectItem(16, "Payée Tiers"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 72) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(5, "Controlée"));
            var3.add(new SelectItem(6, "Refacturée Ass./Soc."));
            var3.add(new SelectItem(7, "Refacturée Compl."));
            var3.add(new SelectItem(19, "Validée, Contrôlée"));
            var3.add(new SelectItem(20, "Validée, Contrôlée, cloturé, Refacturé"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée Patient"));
            var3.add(new SelectItem(14, "Payée Patient"));
            var3.add(new SelectItem(15, "Non Payée Tiers"));
            var3.add(new SelectItem(16, "Payée Tiers"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 73) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(5, "Controlée"));
            var3.add(new SelectItem(6, "Refacturée Ass./Soc."));
            var3.add(new SelectItem(7, "Refacturée Compl."));
            var3.add(new SelectItem(19, "Validée, Contrôlée"));
            var3.add(new SelectItem(20, "Validée, Contrôlée, cloturé, Refacturé"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée Patient"));
            var3.add(new SelectItem(14, "Payée Patient"));
            var3.add(new SelectItem(15, "Non Payée Tiers"));
            var3.add(new SelectItem(16, "Payée Tiers"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 74) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(4, "Cloturée"));
            var3.add(new SelectItem(5, "Controlée"));
            var3.add(new SelectItem(6, "Refacturée Ass./Soc."));
            var3.add(new SelectItem(7, "Refacturée Compl."));
            var3.add(new SelectItem(19, "Validée, Contrôlée"));
            var3.add(new SelectItem(20, "Validée, Contrôlée, cloturé, Refacturé"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée Patient"));
            var3.add(new SelectItem(14, "Payée Patient"));
            var3.add(new SelectItem(15, "Non Payée Tiers"));
            var3.add(new SelectItem(16, "Payée Tiers"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 75) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Effectué"));
            var3.add(new SelectItem(11, "En cours + Effectué"));
            var3.add(new SelectItem(4, "Cloturée"));
         } else if (var1 == 76) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(4, "Cloturée"));
            var3.add(new SelectItem(5, "Controlée"));
            var3.add(new SelectItem(6, "Refacturée Ass./Soc."));
            var3.add(new SelectItem(7, "Refacturée Compl."));
            var3.add(new SelectItem(19, "Validée, Contrôlée"));
            var3.add(new SelectItem(20, "Validée, Contrôlée, cloturé, Refacturé"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée Patient"));
            var3.add(new SelectItem(14, "Payée Patient"));
            var3.add(new SelectItem(15, "Non Payée Tiers"));
            var3.add(new SelectItem(16, "Payée Tiers"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 77) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
         } else if (var1 == 78) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée sans récap."));
            var3.add(new SelectItem(19, "Validée avec récap."));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(6, "Correction"));
            var3.add(new SelectItem(7, "Rejetée"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(14, "Payée"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 182) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validé"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
         } else if (var1 == 101) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validé"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulé"));
            var3.add(new SelectItem(3, "Cloturé"));
         } else if (var1 == 161) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validé"));
            var3.add(new SelectItem(3, "Annulé"));
            var3.add(new SelectItem(4, "Terminé"));
         } else if (var1 == 162) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validé et actif"));
            var3.add(new SelectItem(3, "Annulé"));
            var3.add(new SelectItem(4, "Terminé"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(5, "Périme le:"));
            var3.add(new SelectItem(6, "Fin de facuration"));
         } else if (var1 == 163) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validé"));
            var3.add(new SelectItem(3, "Annulé"));
            var3.add(new SelectItem(4, "Terminé"));
         } else if (var1 == 164) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(14, "Payée"));
            var3.add(new SelectItem(15, "Exonérée"));
            var3.add(new SelectItem(16, "Visa attente"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 165) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(14, "Payée"));
            var3.add(new SelectItem(15, "Exonérée"));
            var3.add(new SelectItem(16, "Visa attente"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 171) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(3, "Annulée"));
         } else if (var1 == 172) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validé"));
            var3.add(new SelectItem(3, "Annulé"));
            var3.add(new SelectItem(4, "Terminé"));
         } else if (var1 == 173) {
            var3.add(new SelectItem(0, "APPEL CHARGE : En cours"));
            var3.add(new SelectItem(1, "APPEL CHARGE : Validée"));
            var3.add(new SelectItem(20, "A NOUVEAUX"));
            var3.add(new SelectItem(21, "FACTURES HONORAIRES"));
            var3.add(new SelectItem(22, "FONDS ROULEMENT"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(11, "Relancée"));
            var3.add(new SelectItem(12, "Promotion"));
            var3.add(new SelectItem(13, "Non Payée"));
            var3.add(new SelectItem(14, "Payée"));
            var3.add(new SelectItem(15, "Exonérée"));
            var3.add(new SelectItem(16, "Visa attente"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(17, "Transférée en compta"));
            var3.add(new SelectItem(18, "Non transférée en compta"));
         } else if (var1 == 174) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(3, "Annulée"));
         } else if (var1 == 175) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(3, "Annulée"));
         } else if (var1 == 176) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(3, "Annulée"));
         } else if (var1 == 220) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(6, "Mise en attente"));
            var3.add(new SelectItem(1, "Validé"));
            var3.add(new SelectItem(2, "Gelé"));
            var3.add(new SelectItem(3, "Annulé"));
            var3.add(new SelectItem(6, "Correction"));
            var3.add(new SelectItem(7, "Rejeté"));
            var3.add(new SelectItem(101, "----------"));
            var3.add(new SelectItem(4, "Accordé"));
            var3.add(new SelectItem(13, "Validé et Crédit Non Débloqué"));
            var3.add(new SelectItem(14, "Crédit débloqué"));
            var3.add(new SelectItem(5, "Attente Résultat final"));
            var3.add(new SelectItem(8, "Cloturé"));
         } else if (var1 == 250) {
            var3.add(new SelectItem(0, "En cours"));
            var3.add(new SelectItem(1, "Validée"));
            var3.add(new SelectItem(2, "Gelée"));
            var3.add(new SelectItem(3, "Annulée"));
            var3.add(new SelectItem(6, "Correction"));
            var3.add(new SelectItem(7, "Rejetée"));
         } else {
            var3.add(new SelectItem(101, "*** ERREUR ***"));
         }
      }

      return var3;
   }

   public String calculeLibelleEtat(int var1, int var2, int var3) {
      String var4 = "";
      new ArrayList();
      List var5 = this.calculelisteEtatsItems(var1, var3);
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            if (((SelectItem)var5.get(var6)).getValue().equals(var2)) {
               var4 = ((SelectItem)var5.get(var6)).getLabel().toString();
               break;
            }
         }
      }

      return var4;
   }

   public List calculelistePeriodeItems() {
      ArrayList var1 = new ArrayList();
      var1.add(new SelectItem(100, "Toutes périodes"));
      var1.add(new SelectItem(0, "Jour en cours"));
      var1.add(new SelectItem(1, "Semaine en cours"));
      var1.add(new SelectItem(2, "Mois en cours"));
      var1.add(new SelectItem(3, "Trimestre en cours"));
      var1.add(new SelectItem(4, "Semestre en cours"));
      var1.add(new SelectItem(11, "Année en cours"));
      var1.add(new SelectItem(13, "Année en cours + Année - 1"));
      var1.add(new SelectItem(14, "Année - 1"));
      var1.add(new SelectItem(5, "1er Trimestre en cours"));
      var1.add(new SelectItem(6, "2eme Trimestre en cours"));
      var1.add(new SelectItem(7, "3eme Trimestre en cours"));
      var1.add(new SelectItem(8, "4eme Trimestre en cours"));
      var1.add(new SelectItem(9, "1er Semestre en cours"));
      var1.add(new SelectItem(10, "2eme Semestre en cours"));
      var1.add(new SelectItem(12, "Années antérieures"));
      var1.add(new SelectItem(20, "Les 20 dernières saisies"));
      return var1;
   }

   public String calculeLibellePeriode(String var1) {
      String var2 = "";
      new ArrayList();
      List var3 = this.calculelistePeriodeItems();
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (((SelectItem)var3.get(var4)).getValue().toString().equals(var1)) {
               var2 = ((SelectItem)var3.get(var4)).getLabel().toString();
               break;
            }
         }
      }

      return var2;
   }
}
