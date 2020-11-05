package com.epegase.systeme.util;

import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.Cadeaux;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Conditionnement;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.ParcConsommation;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.PumpAchats;
import com.epegase.systeme.classe.ReacheminementLigneAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.ReceptionSerieAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TicketLigneVentes;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.control.Stock;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CadeauxDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ParcConsommationDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.PumpAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ReceptionLotAchatsDao;
import com.epegase.systeme.dao.ReceptionSerieAchatsDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.TicketLigneVentesDao;
import com.epegase.systeme.dao.UniteDao;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CalculStock implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private String produit;
   private String depot;
   private Date date_inventaire;
   private float qte_inventaire;
   private List lesMvt = new ArrayList();
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private UtilNombre utilNombre = new UtilNombre();
   private PumpAchatsDao pumpAchatsDao;
   private ProduitsDepotDao produitsDepotDao;
   private ProduitsAchsDao produitsAchsDao;
   private ReceptionSerieAchatsDao receptionSerieAchatsDao;
   private ReceptionLotAchatsDao receptionLotAchatsDao;
   private InventaireLigneDao inventaireLigneDao;
   private BonEntreeLigneDao bonEntreeLigneDao;
   private BonSortieLigneDao bonSortieLigneDao;
   private ParcConsommationDao parcConsommationDao;
   private CessionLigneDao cessionLigneDao;
   private CessionLigneDao cessionLigneDestDao;
   private FabricationEnteteAchatsDao fabricationEnteteAchatsDao;
   private FabricationLigneAchatsDao fabricationLigneAchatsDao;
   private CotationLigneAchatsDao cotationLigneAchatsDao;
   private CommandeLigneAchatsDao commandeLigneAchatsDao;
   private ReceptionLigneAchatsDao receptionLigneAchatsDao;
   private RetourLigneAchatsDao retourLigneAchatsDao;
   private FactureLigneAchatsDao factureLigneAchatsDao;
   private AvoirLigneAchatsDao avoirLigneAchatsDao;
   private DevisLigneVentesDao devisLigneVentesDao;
   private CommandeLigneVentesDao commandeLigneVentesDao;
   private LivraisonLigneVentesDao livraisonLigneVentesDao;
   private PharmacieLigneDao pharmacieLigneDao;
   private HospitalisationMediDao hospitalisationMediDao;
   private FactureLigneVentesDao factureLigneVentesDao;
   private TicketLigneVentesDao ticketLigneVentesDao;
   private ChargementLigneDao chargementLigneDao;
   private RetourLigneVentesDao retourLigneVentesDao;
   private AvoirLigneVentesDao avoirLigneVentesDao;
   private NoteDebitLigneVentesDao noteDebitLigneVentesDao;
   private CadeauxDao cadeauxDao;
   private UtilDate utilDate = new UtilDate();
   int etat;
   String num;
   String ser;
   String obs;
   long idEquipe;
   String nomDivers;
   String nomTiers;
   Date date;
   String devise;
   long idDoc;
   int typeChg;
   String nomDepot;
   String code;
   String nomFamille;
   String libelle;
   float qteLig;
   float qteUtilLig;
   double puLig;
   double ptLig;
   double prLig;
   double pumpLig;
   String dossier;
   float coefDevise;
   float coefPr;
   double prKgrLig;
   float poidsBrut;
   int stockDirect;

   public CalculStock() {
      this.pumpAchatsDao = new PumpAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.receptionSerieAchatsDao = new ReceptionSerieAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLotAchatsDao = new ReceptionLotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.inventaireLigneDao = new InventaireLigneDao(this.baseLog, this.utilInitHibernate);
      this.bonEntreeLigneDao = new BonEntreeLigneDao(this.baseLog, this.utilInitHibernate);
      this.bonSortieLigneDao = new BonSortieLigneDao(this.baseLog, this.utilInitHibernate);
      this.parcConsommationDao = new ParcConsommationDao(this.baseLog, this.utilInitHibernate);
      this.cessionLigneDao = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      this.cessionLigneDestDao = new CessionLigneDao(this.baseLog, this.utilInitHibernate);
      this.fabricationEnteteAchatsDao = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fabricationLigneAchatsDao = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.cotationLigneAchatsDao = new CotationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneAchatsDao = new CommandeLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLigneAchatsDao = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.retourLigneAchatsDao = new RetourLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneAchatsDao = new FactureLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneAchatsDao = new AvoirLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.devisLigneVentesDao = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.livraisonLigneVentesDao = new LivraisonLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneVentesDao = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.ticketLigneVentesDao = new TicketLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.chargementLigneDao = new ChargementLigneDao(this.baseLog, this.utilInitHibernate);
      this.retourLigneVentesDao = new RetourLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.avoirLigneVentesDao = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.noteDebitLigneVentesDao = new NoteDebitLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.cadeauxDao = new CadeauxDao(this.baseLog, this.utilInitHibernate);
   }

   public List sort(List var1) throws ParseException {
      UtilTrie var2 = new UtilTrie();
      var1 = var2.triListeDate(var1);
      var1 = var2.triListeDate(var1);
      var1 = var2.triListeDate(var1);
      var1 = var2.triListeDate(var1);
      var1 = var2.triListeDate(var1);
      float var3 = 0.0F;
      if (var1.size() != 0) {
         new Stock();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            Stock var4 = (Stock)var1.get(var5);
            if (var4.getStk_code_depot() != null && !var4.getStk_code_depot().isEmpty()) {
               if (var4.getStk_type() == 30) {
                  var3 = var4.getStk_qte_in() - var4.getStk_qte_out();
               }

               if (var4.getStk_etat().equalsIgnoreCase("Validé") || var4.getStk_etat().equalsIgnoreCase("Trf partiel") || var4.getStk_etat().equalsIgnoreCase("Trf total")) {
                  var3 += var4.getStk_qte_in() - var4.getStk_qte_out();
                  var4.setStk_qte_progress(var3);
               }
            }
         }
      }

      return var1;
   }

   public List calculConditionnementStock(List var1, Produits var2, ProduitsDepot var3, Session var4) {
      ArrayList var5 = new ArrayList();
      if (var2 != null) {
         if ((var2.getProCondition1() == null || var2.getProCondition1().isEmpty()) && (var2.getProCondition2() == null || var2.getProCondition2().isEmpty()) && (var2.getProCondition3() == null || var2.getProCondition3().isEmpty()) && (var2.getProCondition4() == null || var2.getProCondition4().isEmpty()) && var2.getProCondition5() != null && !var2.getProCondition5().isEmpty()) {
         }

         if (var2.getProCondition1() != null && !var2.getProCondition1().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition1(), var2.getProCondition1()));
         }

         if (var2.getProCondition2() != null && !var2.getProCondition2().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition2(), var2.getProCondition2()));
         }

         if (var2.getProCondition3() != null && !var2.getProCondition3().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition3(), var2.getProCondition3()));
         }

         if (var2.getProCondition4() != null && !var2.getProCondition4().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition4(), var2.getProCondition4()));
         }

         if (var2.getProCondition5() != null && !var2.getProCondition5().isEmpty()) {
            if (var2.getProCondition5().contains("/0.0:")) {
               String[] var6 = var2.getProCondition5().split("/");
               String[] var7 = var6[1].split(":");
               var2.setProCondition5(var6[0] + "/" + var2.getProNbUnite() + ":" + var7[1]);
            }

            var5.add(new SelectItem(var2.getProCondition5(), var2.getProCondition5()));
         }

         if (var3 != null && var3.getProdepEchelle() >= 150 && var3.getProdepEchelle() <= 700) {
            if (var3.getProdepEchelle() >= 150 && var3.getProdepEchelle() <= 200) {
               var5.add(new SelectItem(150, "millimètre linéaire"));
               var5.add(new SelectItem(151, "centimètre linéaire"));
               var5.add(new SelectItem(152, "décimètre linéaire"));
               var5.add(new SelectItem(153, "mètre linéaire"));
               var5.add(new SelectItem(154, "décamètre linéaire"));
               var5.add(new SelectItem(155, "hectomètre linéaire"));
               var5.add(new SelectItem(156, "kilomètre linéaire"));
            } else if (var3.getProdepEchelle() >= 250 && var3.getProdepEchelle() <= 300) {
               var5.add(new SelectItem(250, "millimètre carré"));
               var5.add(new SelectItem(251, "centimètre carré"));
               var5.add(new SelectItem(252, "décimètre carré"));
               var5.add(new SelectItem(253, "mètre carré"));
               var5.add(new SelectItem(254, "décamètre carré"));
               var5.add(new SelectItem(255, "hectomètre carré"));
               var5.add(new SelectItem(256, "kilomètre carré"));
               var5.add(new SelectItem(257, "are"));
               var5.add(new SelectItem(258, "hectare"));
            } else if (var3.getProdepEchelle() >= 350 && var3.getProdepEchelle() <= 400) {
               var5.add(new SelectItem(350, "millimètre cube"));
               var5.add(new SelectItem(351, "centimètre cube"));
               var5.add(new SelectItem(352, "décimètre cube"));
               var5.add(new SelectItem(353, "mètre cube"));
               var5.add(new SelectItem(354, "décamètre cube"));
               var5.add(new SelectItem(355, "hectomètre cube"));
               var5.add(new SelectItem(356, "kilomètre cube"));
               var5.add(new SelectItem(357, "2O pieds"));
               var5.add(new SelectItem(358, "40 pieds"));
            } else if (var3.getProdepEchelle() >= 450 && var3.getProdepEchelle() <= 500) {
               var5.add(new SelectItem(450, "millimètre cube"));
               var5.add(new SelectItem(451, "centimètre cube"));
               var5.add(new SelectItem(452, "décimètre cube"));
               var5.add(new SelectItem(453, "mètre cube"));
               var5.add(new SelectItem(454, "décamètre cube"));
               var5.add(new SelectItem(455, "hectomètre cube"));
               var5.add(new SelectItem(456, "kilomètre cube"));
            } else if (var3.getProdepEchelle() >= 550 && var3.getProdepEchelle() <= 600) {
               var5.add(new SelectItem(550, "millilitre"));
               var5.add(new SelectItem(551, "centilitre"));
               var5.add(new SelectItem(552, "décilitre"));
               var5.add(new SelectItem(553, "litre"));
               var5.add(new SelectItem(554, "décalitre"));
               var5.add(new SelectItem(555, "hectolitre"));
               var5.add(new SelectItem(556, "kilolitre"));
               var5.add(new SelectItem(557, "gallon"));
               var5.add(new SelectItem(558, "baril"));
               var5.add(new SelectItem(559, "fut"));
               var5.add(new SelectItem(560, "cubi"));
            } else if (var3.getProdepEchelle() >= 650 && var3.getProdepEchelle() <= 700) {
               var5.add(new SelectItem(650, "milligramme"));
               var5.add(new SelectItem(651, "centigramme"));
               var5.add(new SelectItem(652, "décigramme"));
               var5.add(new SelectItem(653, "gramme"));
               var5.add(new SelectItem(654, "décagramme"));
               var5.add(new SelectItem(655, "hectogramme"));
               var5.add(new SelectItem(656, "kilogramme"));
               var5.add(new SelectItem(657, "quintal"));
               var5.add(new SelectItem(658, "tonne"));
            }
         }
      }

      return var5;
   }

   public List calculConditionnementVentes(List var1, Produits var2, ProduitsDepot var3, Session var4) {
      ArrayList var5 = new ArrayList();
      if (var2 != null) {
         if ((var2.getProCondition1() == null || var2.getProCondition1().isEmpty()) && (var2.getProCondition2() == null || var2.getProCondition2().isEmpty()) && (var2.getProCondition3() == null || var2.getProCondition3().isEmpty()) && (var2.getProCondition4() == null || var2.getProCondition4().isEmpty()) && var2.getProCondition5() != null && !var2.getProCondition5().isEmpty()) {
         }

         if (var2.getProCondition1() != null && !var2.getProCondition1().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition1(), var2.getProCondition1()));
         }

         if (var2.getProCondition2() != null && !var2.getProCondition2().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition2(), var2.getProCondition2()));
         }

         if (var2.getProCondition3() != null && !var2.getProCondition3().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition3(), var2.getProCondition3()));
         }

         if (var2.getProCondition4() != null && !var2.getProCondition4().isEmpty()) {
            var5.add(new SelectItem(var2.getProCondition4(), var2.getProCondition4()));
         }

         if (var3 != null && var3.getProdepEchelle() >= 150 && var3.getProdepEchelle() <= 700) {
            if (var3.getProdepEchelle() >= 150 && var3.getProdepEchelle() <= 200) {
               var5.add(new SelectItem(150, "millimètre linéaire"));
               var5.add(new SelectItem(151, "centimètre linéaire"));
               var5.add(new SelectItem(152, "décimètre linéaire"));
               var5.add(new SelectItem(153, "mètre linéaire"));
               var5.add(new SelectItem(154, "décamètre linéaire"));
               var5.add(new SelectItem(155, "hectomètre linéaire"));
               var5.add(new SelectItem(156, "kilomètre linéaire"));
            } else if (var3.getProdepEchelle() >= 250 && var3.getProdepEchelle() <= 300) {
               var5.add(new SelectItem(250, "millimètre carré"));
               var5.add(new SelectItem(251, "centimètre carré"));
               var5.add(new SelectItem(252, "décimètre carré"));
               var5.add(new SelectItem(253, "mètre carré"));
               var5.add(new SelectItem(254, "décamètre carré"));
               var5.add(new SelectItem(255, "hectomètre carré"));
               var5.add(new SelectItem(256, "kilomètre carré"));
               var5.add(new SelectItem(257, "are"));
               var5.add(new SelectItem(258, "hectare"));
            } else if (var3.getProdepEchelle() >= 350 && var3.getProdepEchelle() <= 400) {
               var5.add(new SelectItem(350, "millimètre cube"));
               var5.add(new SelectItem(351, "centimètre cube"));
               var5.add(new SelectItem(352, "décimètre cube"));
               var5.add(new SelectItem(353, "mètre cube"));
               var5.add(new SelectItem(354, "décamètre cube"));
               var5.add(new SelectItem(355, "hectomètre cube"));
               var5.add(new SelectItem(356, "kilomètre cube"));
               var5.add(new SelectItem(357, "2O pieds"));
               var5.add(new SelectItem(358, "40 pieds"));
            } else if (var3.getProdepEchelle() >= 450 && var3.getProdepEchelle() <= 500) {
               var5.add(new SelectItem(450, "millimètre cube"));
               var5.add(new SelectItem(451, "centimètre cube"));
               var5.add(new SelectItem(452, "décimètre cube"));
               var5.add(new SelectItem(453, "mètre cube"));
               var5.add(new SelectItem(454, "décamètre cube"));
               var5.add(new SelectItem(455, "hectomètre cube"));
               var5.add(new SelectItem(456, "kilomètre cube"));
            } else if (var3.getProdepEchelle() >= 550 && var3.getProdepEchelle() <= 600) {
               var5.add(new SelectItem(550, "millilitre"));
               var5.add(new SelectItem(551, "centilitre"));
               var5.add(new SelectItem(552, "décilitre"));
               var5.add(new SelectItem(553, "litre"));
               var5.add(new SelectItem(554, "décalitre"));
               var5.add(new SelectItem(555, "hectolitre"));
               var5.add(new SelectItem(556, "kilolitre"));
               var5.add(new SelectItem(557, "gallon"));
               var5.add(new SelectItem(558, "baril"));
               var5.add(new SelectItem(559, "fut"));
               var5.add(new SelectItem(560, "cubi"));
            } else if (var3.getProdepEchelle() >= 650 && var3.getProdepEchelle() <= 700) {
               var5.add(new SelectItem(650, "milligramme"));
               var5.add(new SelectItem(651, "centigramme"));
               var5.add(new SelectItem(652, "décigramme"));
               var5.add(new SelectItem(653, "gramme"));
               var5.add(new SelectItem(654, "décagramme"));
               var5.add(new SelectItem(655, "hectogramme"));
               var5.add(new SelectItem(656, "kilogramme"));
               var5.add(new SelectItem(657, "quintal"));
               var5.add(new SelectItem(658, "tonne"));
            }
         }
      }

      return var5;
   }

   public float calculQteUtil(Produits var1, ProduitsDepot var2, String var3, float var4, float var5, float var6, float var7, float var8, float var9, String var10, UtilInitHibernate var11, Session var12) throws HibernateException, NamingException {
      this.baseLog = var10;
      this.utilInitHibernate = var11;
      float var13 = 0.0F;
      float var14 = 0.0F;
      if (var1 != null && var2 != null) {
         String var15 = "*";
         Conditionnement var16 = new Conditionnement();
         ConditionnementDao var17 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Unite();
         UniteDao var19 = new UniteDao(this.baseLog, this.utilInitHibernate);
         if (var2.getProdepEchelle() >= 150 && var2.getProdepEchelle() <= 200) {
            var4 = var5 * var4;
         } else if (var2.getProdepEchelle() >= 250 && var2.getProdepEchelle() <= 300) {
            var4 = var5 * var6 * var4;
         } else if (var2.getProdepEchelle() >= 350 && var2.getProdepEchelle() <= 400) {
            var4 = var5 * var6 * var7 * var4;
         } else if (var2.getProdepEchelle() >= 450 && var2.getProdepEchelle() <= 500) {
            var4 = var5 * var8 * var4;
         } else if (var2.getProdepEchelle() >= 550 && var2.getProdepEchelle() <= 600 && var1.getProDensite() != 0.0F) {
            var4 = var1.getProDensite() * var4;
         } else if (var2.getProdepEchelle() >= 650 && var2.getProdepEchelle() <= 700 && var1.getProPoidsBrut() != 0.0F) {
            var4 = var1.getProPoidsBrut() * var4;
         }

         while(var15 != null && !var15.isEmpty()) {
            String var20 = "";
            boolean var21 = false;
            float var22 = 0.0F;
            String var23 = "";
            int var24 = 0;
            float var25 = 0.0F;
            if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
               Unite var18;
               int var31;
               if (var15.equals("*")) {
                  String[] var26;
                  String var27;
                  if (var3.contains("/")) {
                     var26 = var3.split("/");
                     var27 = var26[0];
                     String var28 = var26[1];
                     String[] var29 = var27.split(":");
                     var20 = var29[2];
                     var22 = Float.parseFloat(var29[1]);
                     var18 = var19.selectUnite(var20, var12);
                     if (var18 != null) {
                        var31 = var18.getUniEchelle();
                     } else {
                        var31 = 0;
                     }

                     String[] var30 = var28.split(":");
                     var23 = var30[1];
                     boolean var32 = false;
                     var25 = Float.parseFloat(var30[0]);
                     var18 = var19.selectUnite(var23, var12);
                     if (var18 != null) {
                        var24 = var18.getUniEchelle();
                     } else {
                        var24 = 0;
                     }

                     var16 = var17.trouveConditionnement(var27, var22, var20, var25, var23, var9, var12);
                     if (var16 != null) {
                        var15 = var16.getCdtSuite();
                     }
                  } else {
                     var26 = var3.split(":");
                     var27 = var26[0];
                     var20 = var26[2];
                     var22 = Float.parseFloat(var26[1]);
                     var18 = var19.selectUnite(var20, var12);
                     if (var18 != null) {
                        var31 = var18.getUniEchelle();
                     } else {
                        var31 = 0;
                     }

                     var16 = var17.trouveConditionnement(var27, var22, var20, var25, var23, var9, var12);
                     if (var16 != null) {
                        var15 = var16.getCdtSuite();
                     }
                  }
               } else {
                  var20 = var16.getCdtCodeUnite1();
                  var22 = var16.getCdtCoef1();
                  var18 = var19.selectUnite(var20, var12);
                  if (var18 != null) {
                     var31 = var18.getUniEchelle();
                  } else {
                     var31 = 0;
                  }

                  var23 = var16.getCdtCodeUnite2();
                  var25 = var16.getCdtCoef2();
                  var18 = var19.selectUnite(var23, var12);
                  if (var18 != null) {
                     var24 = var18.getUniEchelle();
                  } else {
                     var24 = 0;
                  }

                  var15 = var16.getCdtSuite();
               }

               if (var2 != null && var31 >= 150 && var31 <= 700) {
                  var14 = this.calculCoefConversion(var31, var24);
               } else {
                  var14 = 1.0F;
               }

               var13 = var4 / var14 * var22 * var25;
            } else if (var3 != null && !var3.isEmpty() && !var3.contains(":")) {
               if (var2 != null && var2.getProdepEchelle() >= 150 && var2.getProdepEchelle() <= 700) {
                  var14 = this.calculCoefConversion(var2.getProdepEchelle(), Integer.parseInt(var3));
               } else {
                  var14 = 1.0F;
               }

               var13 = var4 / var14;
            } else {
               var13 = var4;
            }

            if (var15 != null && !var15.isEmpty()) {
               var16 = var17.rechercheConditionnement(var15, var12);
               if (var16 == null) {
                  var15 = "";
               }
            }
         }
      } else {
         var13 = var4;
      }

      return var13;
   }

   public float calculQteUtilMultiple(Produits var1, ProduitsDepot var2, String var3, float var4, float var5, float var6, float var7, float var8, float var9, String var10, Session var11) throws HibernateException, NamingException {
      this.baseLog = var10;
      float var12 = 0.0F;
      float var13 = 0.0F;
      if (var1 != null && var2 != null) {
         String var14 = "*";
         Conditionnement var15 = new Conditionnement();
         ConditionnementDao var16 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
         new Unite();
         UniteDao var18 = new UniteDao(this.baseLog, this.utilInitHibernate);
         if (var2.getProdepEchelle() >= 150 && var2.getProdepEchelle() <= 200) {
            var4 = var5 * var4;
         } else if (var2.getProdepEchelle() >= 250 && var2.getProdepEchelle() <= 300) {
            var4 = var5 * var6 * var4;
         } else if (var2.getProdepEchelle() >= 350 && var2.getProdepEchelle() <= 400) {
            var4 = var5 * var6 * var7 * var4;
         } else if (var2.getProdepEchelle() >= 450 && var2.getProdepEchelle() <= 500) {
            var4 = var5 * var8 * var4;
         } else if (var2.getProdepEchelle() >= 550 && var2.getProdepEchelle() <= 600 && var1.getProDensite() != 0.0F) {
            var4 = var1.getProDensite() * var4;
         } else if (var2.getProdepEchelle() >= 650 && var2.getProdepEchelle() <= 700 && var1.getProPoidsBrut() != 0.0F) {
            var4 = var1.getProPoidsBrut() * var4;
         }

         while(var14 != null && !var14.isEmpty()) {
            String var19 = "";
            boolean var20 = false;
            float var21 = 0.0F;
            String var22 = "";
            int var23 = 0;
            float var24 = 0.0F;
            if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
               Unite var17;
               int var30;
               if (var14.equals("*")) {
                  String[] var25;
                  String var26;
                  if (var3.contains("/")) {
                     var25 = var3.split("/");
                     var26 = var25[0];
                     String var27 = var25[1];
                     String[] var28 = var26.split(":");
                     var19 = var28[2];
                     var21 = Float.parseFloat(var28[1]);
                     var17 = var18.selectUnite(var19, var11);
                     if (var17 != null) {
                        var30 = var17.getUniEchelle();
                     } else {
                        var30 = 0;
                     }

                     String[] var29 = var27.split(":");
                     var22 = var29[1];
                     boolean var31 = false;
                     var24 = Float.parseFloat(var29[0]);
                     var17 = var18.selectUnite(var22, var11);
                     if (var17 != null) {
                        var23 = var17.getUniEchelle();
                     } else {
                        var23 = 0;
                     }

                     var15 = var16.trouveConditionnement(var26, var21, var19, var24, var22, var9, var11);
                     if (var15 != null) {
                        var14 = var15.getCdtSuite();
                     }
                  } else {
                     var25 = var3.split(":");
                     var26 = var25[0];
                     var19 = var25[2];
                     var21 = Float.parseFloat(var25[1]);
                     var17 = var18.selectUnite(var19, var11);
                     if (var17 != null) {
                        var30 = var17.getUniEchelle();
                     } else {
                        var30 = 0;
                     }

                     var15 = var16.trouveConditionnement(var26, var21, var19, var24, var22, var9, var11);
                     if (var15 != null) {
                        var14 = var15.getCdtSuite();
                     }
                  }
               } else {
                  var19 = var15.getCdtCodeUnite1();
                  var21 = var15.getCdtCoef1();
                  var17 = var18.selectUnite(var19, var11);
                  if (var17 != null) {
                     var30 = var17.getUniEchelle();
                  } else {
                     var30 = 0;
                  }

                  var22 = var15.getCdtCodeUnite2();
                  var24 = var15.getCdtCoef2();
                  var17 = var18.selectUnite(var22, var11);
                  if (var17 != null) {
                     var23 = var17.getUniEchelle();
                  } else {
                     var23 = 0;
                  }

                  var14 = var15.getCdtSuite();
               }

               if (var2 != null && var30 >= 150 && var30 <= 700) {
                  var13 = this.calculCoefConversion(var30, var23);
               } else {
                  var13 = 1.0F;
               }

               var12 = var4 * var13 * var21 / var24;
            } else if (var3 != null && !var3.isEmpty() && !var3.contains(":")) {
               if (var2 != null && var2.getProdepEchelle() >= 150 && var2.getProdepEchelle() <= 700) {
                  var13 = this.calculCoefConversion(var2.getProdepEchelle(), Integer.parseInt(var3));
               } else {
                  var13 = 1.0F;
               }

               var12 = var4 * var13;
            } else {
               var12 = var4;
            }

            var15 = var16.rechercheConditionnement(var14, var11);
            if (var15 == null) {
               var14 = "";
            }
         }
      } else {
         var12 = var4;
      }

      return var12;
   }

   public float calculCoefConversion(int var1, int var2) {
      float var3 = 0.0F;
      if (var1 == var2) {
         var3 = 1.0F;
      } else if ((var1 == 150 || var1 == 250 || var1 == 350 || var1 == 450 || var1 == 550 || var1 == 650) && (var2 == 151 || var2 == 251 || var2 == 351 || var2 == 451 || var2 == 551 || var2 == 651)) {
         var3 = 0.1F;
      } else if ((var1 == 150 || var1 == 250 || var1 == 350 || var1 == 450 || var1 == 550 || var1 == 650) && (var2 == 152 || var2 == 252 || var2 == 352 || var2 == 452 || var2 == 552 || var2 == 652)) {
         var3 = 0.01F;
      } else if ((var1 == 150 || var1 == 250 || var1 == 350 || var1 == 450 || var1 == 550 || var1 == 650) && (var2 == 153 || var2 == 253 || var2 == 353 || var2 == 453 || var2 == 553 || var2 == 653)) {
         var3 = 0.001F;
      } else if (var1 != 150 && var1 != 250 && var1 != 350 && var1 != 450 && var1 != 550 && var1 != 650 || var2 != 154 && var2 != 254 && var2 != 354 && var2 != 454 && var2 != 554 && var2 != 654) {
         if (var1 != 150 && var1 != 250 && var1 != 350 && var1 != 450 && var1 != 550 && var1 != 650 || var2 != 155 && var2 != 255 && var2 != 355 && var2 != 455 && var2 != 555 && var2 != 655) {
            if (var1 != 150 && var1 != 250 && var1 != 350 && var1 != 450 && var1 != 550 && var1 != 650 || var2 != 156 && var2 != 256 && var2 != 356 && var2 != 456 && var2 != 556 && var2 != 656) {
               if (var1 == 650 && var2 == 657) {
                  var3 = 1.0E-8F;
               } else if (var1 == 650 && var2 == 658) {
                  var3 = 1.0E-9F;
               } else if (var1 != 151 && var1 != 251 && var1 != 351 && var1 != 451 && var1 != 551 && var1 != 651 || var2 != 150 && var2 != 250 && var2 != 350 && var2 != 450 && var2 != 550 && var2 != 650) {
                  if (var1 != 151 && var1 != 251 && var1 != 351 && var1 != 451 && var1 != 551 && var1 != 651 || var2 != 152 && var2 != 252 && var2 != 352 && var2 != 452 && var2 != 552 && var2 != 652) {
                     if ((var1 == 151 || var1 == 251 || var1 == 351 || var1 == 451 || var1 == 551 || var1 == 651) && (var2 == 153 || var2 == 253 || var2 == 353 || var2 == 453 || var2 == 553 || var2 == 653)) {
                        var3 = 0.01F;
                     } else if ((var1 == 151 || var1 == 251 || var1 == 351 || var1 == 451 || var1 == 551 || var1 == 651) && (var2 == 154 || var2 == 254 || var2 == 354 || var2 == 454 || var2 == 554 || var2 == 654)) {
                        var3 = 0.001F;
                     } else if ((var1 == 151 || var1 == 251 || var1 == 351 || var1 == 451 || var1 == 551 || var1 == 651) && (var2 == 155 || var2 == 255 || var2 == 355 || var2 == 455 || var2 == 555 || var2 == 655)) {
                        var3 = 1.0E-4F;
                     } else if (var1 != 151 && var1 != 251 && var1 != 351 && var1 != 451 && var1 != 551 && var1 != 651 || var2 != 156 && var2 != 256 && var2 != 356 && var2 != 456 && var2 != 556 && var2 != 656) {
                        if (var1 == 651 && var2 == 657) {
                           var3 = 1.0E-7F;
                        } else if (var1 == 651 && var2 == 658) {
                           var3 = 1.0E-8F;
                        } else if ((var1 == 152 || var1 == 252 || var1 == 352 || var1 == 452 || var1 == 552 || var1 == 652) && (var2 == 150 || var2 == 250 || var2 == 350 || var2 == 450 || var2 == 550 || var2 == 650)) {
                           var3 = 100.0F;
                        } else if (var1 != 152 && var1 != 252 && var1 != 352 && var1 != 452 && var1 != 552 && var1 != 652 || var2 != 151 && var2 != 251 && var2 != 351 && var2 != 451 && var2 != 551 && var2 != 651) {
                           if (var1 != 152 && var1 != 252 && var1 != 352 && var1 != 452 && var1 != 552 && var1 != 652 || var2 != 153 && var2 != 253 && var2 != 353 && var2 != 453 && var2 != 553 && var2 != 653) {
                              if ((var1 == 152 || var1 == 252 || var1 == 352 || var1 == 452 || var1 == 552 || var1 == 652) && (var2 == 154 || var2 == 254 || var2 == 354 || var2 == 454 || var2 == 554 || var2 == 654)) {
                                 var3 = 0.01F;
                              } else if ((var1 == 152 || var1 == 252 || var1 == 352 || var1 == 452 || var1 == 552 || var1 == 652) && (var2 == 155 || var2 == 255 || var2 == 355 || var2 == 455 || var2 == 555 || var2 == 655)) {
                                 var3 = 0.001F;
                              } else if (var1 != 152 && var1 != 252 && var1 != 352 && var1 != 452 && var1 != 552 && var1 != 652 || var2 != 156 && var2 != 256 && var2 != 356 && var2 != 456 && var2 != 556 && var2 != 656) {
                                 if (var1 == 652 && var2 == 657) {
                                    var3 = 1.0E-6F;
                                 } else if (var1 == 652 && var2 == 658) {
                                    var3 = 1.0E-7F;
                                 } else if ((var1 == 153 || var1 == 253 || var1 == 353 || var1 == 453 || var1 == 553 || var1 == 653) && (var2 == 150 || var2 == 250 || var2 == 350 || var2 == 450 || var2 == 550 || var2 == 650)) {
                                    var3 = 1000.0F;
                                 } else if ((var1 == 153 || var1 == 253 || var1 == 353 || var1 == 453 || var1 == 553 || var1 == 653) && (var2 == 151 || var2 == 251 || var2 == 351 || var2 == 451 || var2 == 551 || var2 == 651)) {
                                    var3 = 100.0F;
                                 } else if ((var1 == 153 || var1 == 253 || var1 == 353 || var1 == 453 || var1 == 553 || var1 == 653) && (var2 == 152 || var2 == 252 || var2 == 352 || var2 == 452 || var2 == 552 || var2 == 652)) {
                                    var3 = 10.0F;
                                 } else if ((var1 == 153 || var1 == 253 || var1 == 353 || var1 == 453 || var1 == 553 || var1 == 653) && (var2 == 154 || var2 == 254 || var2 == 354 || var2 == 454 || var2 == 554 || var2 == 654)) {
                                    var3 = 0.1F;
                                 } else if ((var1 == 153 || var1 == 253 || var1 == 353 || var1 == 453 || var1 == 553 || var1 == 653) && (var2 == 155 || var2 == 255 || var2 == 355 || var2 == 455 || var2 == 555 || var2 == 655)) {
                                    var3 = 0.01F;
                                 } else if ((var1 == 153 || var1 == 253 || var1 == 353 || var1 == 453 || var1 == 553 || var1 == 653) && (var2 == 156 || var2 == 256 || var2 == 356 || var2 == 456 || var2 == 556 || var2 == 656)) {
                                    var3 = 0.001F;
                                 } else if (var1 == 653 && var2 == 657) {
                                    var3 = 1.0E-5F;
                                 } else if (var1 == 653 && var2 == 658) {
                                    var3 = 1.0E-6F;
                                 } else if ((var1 == 154 || var1 == 254 || var1 == 354 || var1 == 454 || var1 == 554 || var1 == 654) && (var2 == 150 || var2 == 250 || var2 == 350 || var2 == 450 || var2 == 550 || var2 == 650)) {
                                    var3 = 10000.0F;
                                 } else if ((var1 == 154 || var1 == 254 || var1 == 354 || var1 == 454 || var1 == 554 || var1 == 654) && (var2 == 151 || var2 == 251 || var2 == 351 || var2 == 451 || var2 == 551 || var2 == 651)) {
                                    var3 = 1000.0F;
                                 } else if ((var1 == 154 || var1 == 254 || var1 == 354 || var1 == 454 || var1 == 554 || var1 == 654) && (var2 == 152 || var2 == 252 || var2 == 352 || var2 == 452 || var2 == 552 || var2 == 652)) {
                                    var3 = 100.0F;
                                 } else if ((var1 == 154 || var1 == 254 || var1 == 354 || var1 == 454 || var1 == 554 || var1 == 654) && (var2 == 153 || var2 == 253 || var2 == 353 || var2 == 453 || var2 == 553 || var2 == 653)) {
                                    var3 = 10.0F;
                                 } else if ((var1 == 154 || var1 == 254 || var1 == 354 || var1 == 454 || var1 == 554 || var1 == 654) && (var2 == 155 || var2 == 255 || var2 == 355 || var2 == 455 || var2 == 555 || var2 == 655)) {
                                    var3 = 0.1F;
                                 } else if (var1 != 154 && var1 != 254 && var1 != 354 && var1 != 454 && var1 != 554 && var1 != 654 || var2 != 156 && var2 != 256 && var2 != 356 && var2 != 456 && var2 != 556 && var2 != 656) {
                                    if (var1 == 654 && var2 == 657) {
                                       var3 = 1.0E-4F;
                                    } else if (var1 == 654 && var2 == 658) {
                                       var3 = 1.0E-5F;
                                    } else if (var1 != 155 && var1 != 255 && var1 != 355 && var1 != 455 && var1 != 555 && var1 != 655 || var2 != 150 && var2 != 250 && var2 != 350 && var2 != 450 && var2 != 550 && var2 != 650) {
                                       if (var1 != 155 && var1 != 255 && var1 != 355 && var1 != 455 && var1 != 555 && var1 != 655 || var2 != 151 && var2 != 251 && var2 != 351 && var2 != 451 && var2 != 551 && var2 != 651) {
                                          if ((var1 == 155 || var1 == 255 || var1 == 355 || var1 == 455 || var1 == 555 || var1 == 655) && (var2 == 152 || var2 == 252 || var2 == 352 || var2 == 452 || var2 == 552 || var2 == 652)) {
                                             var3 = 1000.0F;
                                          } else if ((var1 == 155 || var1 == 255 || var1 == 355 || var1 == 455 || var1 == 555 || var1 == 655) && (var2 == 153 || var2 == 253 || var2 == 353 || var2 == 453 || var2 == 553 || var2 == 653)) {
                                             var3 = 100.0F;
                                          } else if ((var1 == 155 || var1 == 255 || var1 == 355 || var1 == 455 || var1 == 555 || var1 == 655) && (var2 == 154 || var2 == 254 || var2 == 354 || var2 == 454 || var2 == 554 || var2 == 654)) {
                                             var3 = 10.0F;
                                          } else if (var1 != 155 && var1 != 255 && var1 != 355 && var1 != 455 && var1 != 555 && var1 != 655 || var2 != 156 && var2 != 256 && var2 != 356 && var2 != 456 && var2 != 556 && var2 != 656) {
                                             if (var1 == 655 && var2 == 657) {
                                                var3 = 0.001F;
                                             } else if (var1 == 655 && var2 == 658) {
                                                var3 = 1.0E-4F;
                                             } else if ((var1 == 156 || var1 == 256 || var1 == 356 || var1 == 456 || var1 == 556 || var1 == 656) && (var2 == 150 || var2 == 250 || var2 == 350 || var2 == 450 || var2 == 550 || var2 == 650)) {
                                                var3 = 1000000.0F;
                                             } else if (var1 != 156 && var1 != 256 && var1 != 356 && var1 != 456 && var1 != 556 && var1 != 656 || var2 != 151 && var2 != 251 && var2 != 351 && var2 != 451 && var2 != 551 && var2 != 651) {
                                                if (var1 != 156 && var1 != 256 && var1 != 356 && var1 != 456 && var1 != 556 && var1 != 656 || var2 != 152 && var2 != 252 && var2 != 352 && var2 != 452 && var2 != 552 && var2 != 652) {
                                                   if ((var1 == 156 || var1 == 256 || var1 == 356 || var1 == 456 || var1 == 556 || var1 == 656) && (var2 == 153 || var2 == 253 || var2 == 353 || var2 == 453 || var2 == 553 || var2 == 653)) {
                                                      var3 = 1000.0F;
                                                   } else if ((var1 == 156 || var1 == 256 || var1 == 356 || var1 == 456 || var1 == 556 || var1 == 656) && (var2 == 154 || var2 == 254 || var2 == 354 || var2 == 454 || var2 == 554 || var2 == 654)) {
                                                      var3 = 100.0F;
                                                   } else if (var1 != 156 && var1 != 256 && var1 != 356 && var1 != 456 && var1 != 556 && var1 != 656 || var2 != 155 && var2 != 255 && var2 != 355 && var2 != 455 && var2 != 555 && var2 != 655) {
                                                      if (var1 == 656 && var2 == 657) {
                                                         var3 = 0.01F;
                                                      } else if (var1 == 656 && var2 == 658) {
                                                         var3 = 0.001F;
                                                      } else if (var1 == 657 && var2 == 650) {
                                                         var3 = 1.0E8F;
                                                      } else if (var1 == 657 && var2 == 651) {
                                                         var3 = 1.0E7F;
                                                      } else if (var1 == 657 && var2 == 652) {
                                                         var3 = 1000000.0F;
                                                      } else if (var1 == 657 && var2 == 653) {
                                                         var3 = 100000.0F;
                                                      } else if (var1 == 657 && var2 == 654) {
                                                         var3 = 10000.0F;
                                                      } else if (var1 == 657 && var2 == 655) {
                                                         var3 = 1000.0F;
                                                      } else if (var1 == 657 && var2 == 656) {
                                                         var3 = 100.0F;
                                                      } else if (var1 == 657 && var2 == 658) {
                                                         var3 = 0.1F;
                                                      } else if (var1 == 658 && var2 == 650) {
                                                         var3 = 1.0E9F;
                                                      } else if (var1 == 658 && var2 == 651) {
                                                         var3 = 1.0E8F;
                                                      } else if (var1 == 658 && var2 == 652) {
                                                         var3 = 1.0E7F;
                                                      } else if (var1 == 658 && var2 == 653) {
                                                         var3 = 1000000.0F;
                                                      } else if (var1 == 658 && var2 == 654) {
                                                         var3 = 100000.0F;
                                                      } else if (var1 == 658 && var2 == 655) {
                                                         var3 = 10000.0F;
                                                      } else if (var1 == 658 && var2 == 656) {
                                                         var3 = 1000.0F;
                                                      } else if (var1 == 658 && var2 == 657) {
                                                         var3 = 10.0F;
                                                      }
                                                   } else {
                                                      var3 = 10.0F;
                                                   }
                                                } else {
                                                   var3 = 10000.0F;
                                                }
                                             } else {
                                                var3 = 100000.0F;
                                             }
                                          } else {
                                             var3 = 0.1F;
                                          }
                                       } else {
                                          var3 = 10000.0F;
                                       }
                                    } else {
                                       var3 = 100000.0F;
                                    }
                                 } else {
                                    var3 = 0.01F;
                                 }
                              } else {
                                 var3 = 1.0E-4F;
                              }
                           } else {
                              var3 = 0.1F;
                           }
                        } else {
                           var3 = 10.0F;
                        }
                     } else {
                        var3 = 1.0E-5F;
                     }
                  } else {
                     var3 = 0.1F;
                  }
               } else {
                  var3 = 10.0F;
               }
            } else {
               var3 = 1.0E-6F;
            }
         } else {
            var3 = 1.0E-5F;
         }
      } else {
         var3 = 1.0E-4F;
      }

      if (var3 == 0.0F) {
         var3 = 1.0F;
      }

      System.out.println("echelleStockage " + var1 + " echelleSaisie " + var2 + " coef " + var3);
      return var3;
   }

   public double rechercheDernierPr(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      double var5 = 0.0D;
      if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         new PumpAchats();
         PumpAchats var7 = this.pumpAchatsDao.chargeDernierPumpByProdDep(var1, var2, var4);
         if (var7 != null) {
            var5 = var7.getPumPr();
         } else {
            var5 = 0.0D;
         }
      }

      return var5;
   }

   public double rechercheDernierPump(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      double var5 = 0.0D;
      if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         new PumpAchats();
         PumpAchats var7 = this.pumpAchatsDao.chargeDernierPumpByProdDep(var1, var2, var4);
         if (var7 != null) {
            var5 = var7.getPumPump();
         } else {
            var5 = 0.0D;
         }
      }

      return var5;
   }

   public void majInventaire(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      ArrayList var5 = new ArrayList();
      InventaireLigne var6;
      float var9;
      if (var1.size() != 0) {
         new InventaireLigne();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            var6 = (InventaireLigne)var1.get(var7);
            if (var6.getInvligCode() != null && !var6.getInvligCode().isEmpty()) {
               if (var5.size() == 0) {
                  var5.add(var6);
               } else {
                  boolean var8 = false;
                  var9 = var6.getInvligQteUtil();

                  for(int var10 = 0; var10 < var5.size(); ++var10) {
                     if (((InventaireLigne)var5.get(var10)).getInvligCode().equals(var6.getInvligCode())) {
                        var9 += ((InventaireLigne)var5.get(var10)).getInvligQteUtil();
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     var5.add(var6);
                  } else {
                     var6.setInvligQteUtil(var9);
                     var5.add(var6);
                  }
               }
            }
         }
      }

      this.baseLog = var3;
      if (var5.size() != 0) {
         new InventaireLigne();
         new Produits();

         for(int var12 = 0; var12 < var5.size(); ++var12) {
            var6 = (InventaireLigne)var5.get(var12);
            if (var6.getInvligCode() != null && !var6.getInvligCode().isEmpty()) {
               Produits var11 = this.produitsAchsDao.chargeToutProduit(var6.getInvligCode(), var4);
               if (var11 != null && var11.getProStock() != 0) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var6.getInvligCode(), var6.getInventaireEntete().getInvDepot(), var4);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateInv(new Date());
                     if (var6.getInvligCasier() != null && !var6.getInvligCasier().isEmpty()) {
                        this.produitsDepot.setProdepCasier(var6.getInvligCasier());
                     }

                     if (this.produitsDepot.getProdepPr() == 0.0D && var6.getInvligPump() != 0.0D) {
                        this.produitsDepot.setProdepPr(var6.getInvligPump());
                     }

                     if (this.produitsDepot.getProdepPump() == 0.0D && var6.getInvligPump() != 0.0D) {
                        this.produitsDepot.setProdepPump(var6.getInvligPump());
                     }

                     var9 = 0.0F;
                     if (var2 == 1) {
                        if (var6.getInventaireEntete().getInvType() == 0) {
                           var9 = var6.getInvligQteUtil();
                        } else {
                           var9 = this.produitsDepot.getProdepQteStk() + var6.getInvligQteUtil();
                        }
                     } else {
                        var9 = this.produitsDepot.getProdepQteStk() - var6.getInvligQteUtil();
                     }

                     this.produitsDepot.setProdepQteStk(var9);
                     this.produitsDepotDao.modif(this.produitsDepot, var4);
                  }
               }
            }
         }
      }

   }

   public void majBonEntree(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new BonEntreeLigne();
         new Produits();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            BonEntreeLigne var5 = (BonEntreeLigne)var1.get(var7);
            if (var5.getBinligCode() != null && !var5.getBinligCode().isEmpty()) {
               Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getBinligCode(), var4);
               if (var6 != null && var6.getProStock() != 0) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getBinligCode(), var5.getBonEntreeEntete().getBinDepot(), var4);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateEntree(new Date());
                     if (var5.getBinligCasier() != null && !var5.getBinligCasier().isEmpty()) {
                        this.produitsDepot.setProdepCasier(var5.getBinligCasier());
                     }

                     if (this.produitsDepot.getProdepPr() == 0.0D && var5.getBinligPump() != 0.0D) {
                        this.produitsDepot.setProdepPr(var5.getBinligPump());
                     }

                     if (this.produitsDepot.getProdepPump() == 0.0D && var5.getBinligPump() != 0.0D) {
                        this.produitsDepot.setProdepPump(var5.getBinligPump());
                     }

                     float var8 = 0.0F;
                     if (var2 == 1) {
                        var8 = this.produitsDepot.getProdepQteStk() + var5.getBinligQteUtil();
                     } else {
                        var8 = this.produitsDepot.getProdepQteStk() - var5.getBinligQteUtil();
                     }

                     this.produitsDepot.setProdepQteStk(var8);
                     this.produitsDepotDao.modif(this.produitsDepot, var4);
                  }
               }
            }
         }
      }

   }

   public void majBonEntree(BonEntreeLigne var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1 != null && var1.getBinligCode() != null && !var1.getBinligCode().isEmpty()) {
         new Produits();
         Produits var5 = this.produitsAchsDao.chargeToutProduit(var1.getBinligCode(), var4);
         if (var5 != null && var5.getProStock() != 0) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBinligCode(), var1.getBonEntreeEntete().getBinDepot(), var4);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateEntree(new Date());
               if (var1.getBinligCasier() != null && !var1.getBinligCasier().isEmpty()) {
                  this.produitsDepot.setProdepCasier(var1.getBinligCasier());
               }

               if (this.produitsDepot.getProdepPr() == 0.0D && var1.getBinligPump() != 0.0D) {
                  this.produitsDepot.setProdepPr(var1.getBinligPump());
               }

               if (this.produitsDepot.getProdepPump() == 0.0D && var1.getBinligPump() != 0.0D) {
                  this.produitsDepot.setProdepPump(var1.getBinligPump());
               }

               float var6 = 0.0F;
               if (var2 == 1) {
                  var6 = this.produitsDepot.getProdepQteStk() + var1.getBinligQteUtil();
               } else {
                  var6 = this.produitsDepot.getProdepQteStk() - var1.getBinligQteUtil();
               }

               this.produitsDepot.setProdepQteStk(var6);
               this.produitsDepotDao.modif(this.produitsDepot, var4);
            }
         }
      }

   }

   public void majBonSortie(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new BonSortieLigne();
         new Produits();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            BonSortieLigne var5 = (BonSortieLigne)var1.get(var7);
            if (var5.getBouligCode() != null && !var5.getBouligCode().isEmpty()) {
               Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getBouligCode(), var4);
               if (var6 != null && var6.getProStock() != 0) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getBouligCode(), var5.getBonSortieEntete().getBouDepot(), var4);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     if (var5.getBouligCasier() != null && !var5.getBouligCasier().isEmpty()) {
                        this.produitsDepot.setProdepCasier(var5.getBouligCasier());
                     }

                     if (this.produitsDepot.getProdepPr() == 0.0D && var5.getBouligPump() != 0.0D) {
                        this.produitsDepot.setProdepPr(var5.getBouligPump());
                     }

                     if (this.produitsDepot.getProdepPump() == 0.0D && var5.getBouligPump() != 0.0D) {
                        this.produitsDepot.setProdepPump(var5.getBouligPump());
                     }

                     float var8 = 0.0F;
                     if (var2 == 1) {
                        var8 = this.produitsDepot.getProdepQteStk() - var5.getBouligQteUtil();
                     } else {
                        var8 = this.produitsDepot.getProdepQteStk() + var5.getBouligQteUtil();
                     }

                     this.produitsDepot.setProdepQteStk(var8);
                     this.produitsDepotDao.modif(this.produitsDepot, var4);
                  }
               }
            }
         }
      }

   }

   public void majCession(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new CessionLigne();
         new Produits();
         new DepotAchats();
         DepotAchatsDao var8 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);

         for(int var9 = 0; var9 < var1.size(); ++var9) {
            CessionLigne var5 = (CessionLigne)var1.get(var9);
            if (var5.getCesligCode() != null && !var5.getCesligCode().isEmpty()) {
               Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getCesligCode(), var4);
               if (var6 != null && var6.getProStock() != 0) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getCesligCode(), var5.getCessionEntete().getCesDepotOrigine(), var4);
                  float var10;
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     if (var5.getCesligCasierOrigine() != null && !var5.getCesligCasierOrigine().isEmpty()) {
                        this.produitsDepot.setProdepCasier(var5.getCesligCasierOrigine());
                     }

                     if (this.produitsDepot.getProdepPr() == 0.0D && var5.getCesligPump() != 0.0D) {
                        this.produitsDepot.setProdepPr(var5.getCesligPump());
                     }

                     if (this.produitsDepot.getProdepPump() == 0.0D && var5.getCesligPump() != 0.0D) {
                        this.produitsDepot.setProdepPump(var5.getCesligPump());
                     }

                     var10 = 0.0F;
                     if (var2 == 1) {
                        var10 = this.produitsDepot.getProdepQteStk() - var5.getCesligQteUtil();
                     } else {
                        var10 = this.produitsDepot.getProdepQteStk() + var5.getCesligQteUtil();
                     }

                     this.produitsDepot.setProdepQteStk(var10);
                     this.produitsDepotDao.modif(this.produitsDepot, var4);
                  }

                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getCesligCode(), var5.getCessionEntete().getCesDepotDestination(), var4);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateEntree(new Date());
                     if (var5.getCesligCasierDestination() != null && !var5.getCesligCasierDestination().isEmpty()) {
                        this.produitsDepot.setProdepCasier(var5.getCesligCasierDestination());
                     }

                     if (this.produitsDepot.getProdepPr() == 0.0D && var5.getCesligPump() != 0.0D) {
                        this.produitsDepot.setProdepPr(var5.getCesligPump());
                     }

                     if (this.produitsDepot.getProdepPump() == 0.0D && var5.getCesligPump() != 0.0D) {
                        this.produitsDepot.setProdepPump(var5.getCesligPump());
                     }

                     var10 = 0.0F;
                     if (var2 == 1) {
                        var10 = this.produitsDepot.getProdepQteStk() + var5.getCesligQteUtil();
                     } else {
                        var10 = this.produitsDepot.getProdepQteStk() - var5.getCesligQteUtil();
                     }

                     this.produitsDepot.setProdepQteStk(var10);
                     this.produitsDepotDao.modif(this.produitsDepot, var4);
                  } else {
                     DepotAchats var7 = var8.trouveDepot(var5.getCessionEntete().getCesDepotDestination(), var4);
                     if (var7 != null) {
                        this.produitsDepot = new ProduitsDepot();
                        this.produitsDepot.setProduits(var6);
                        this.produitsDepot.setDepot(var7);
                        this.produitsDepot.setProdepCle(this.produitsDepot.getDepot().getDpoCode() + ":" + this.produitsDepot.getProduits().getProCode());
                        this.produitsDepot.setProdepDateEntree(new Date());
                        if (var5.getCesligCasierDestination() != null && !var5.getCesligCasierDestination().isEmpty()) {
                           this.produitsDepot.setProdepCasier(var5.getCesligCasierDestination());
                        }

                        if (this.produitsDepot.getProdepPr() == 0.0D && var5.getCesligPump() != 0.0D) {
                           this.produitsDepot.setProdepPr(var5.getCesligPump());
                        }

                        if (this.produitsDepot.getProdepPump() == 0.0D && var5.getCesligPump() != 0.0D) {
                           this.produitsDepot.setProdepPump(var5.getCesligPump());
                        }

                        var10 = var5.getCesligQteUtil();
                        this.produitsDepot.setProdepQteStk(var10);
                        this.produitsDepotDao.insert(this.produitsDepot, var4);
                     }
                  }
               }
            }
         }
      }

   }

   public void majFabrication(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new FabricationLigneAchats();
         new Produits();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            FabricationLigneAchats var5 = (FabricationLigneAchats)var1.get(var7);
            if (var5.getFabligCode() != null && !var5.getFabligCode().isEmpty()) {
               Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getFabligCode(), var4);
               if (var6 != null && var6.getProStock() != 0) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getFabligCode(), var5.getFabligDepot(), var4);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     if (var5.getFabligCasier() != null && !var5.getFabligCasier().isEmpty()) {
                        this.produitsDepot.setProdepCasier(var5.getFabligCasier());
                     }

                     if (this.produitsDepot.getProdepPr() == 0.0D && var5.getFabligPump() != 0.0D) {
                        this.produitsDepot.setProdepPr(var5.getFabligPump());
                     }

                     if (this.produitsDepot.getProdepPump() == 0.0D && var5.getFabligPump() != 0.0D) {
                        this.produitsDepot.setProdepPump(var5.getFabligPump());
                     }

                     float var8 = 0.0F;
                     if (var2 == 1) {
                        var8 = this.produitsDepot.getProdepQteStk() - var5.getFabligQteUtil();
                     } else {
                        var8 = this.produitsDepot.getProdepQteStk() + var5.getFabligQteUtil();
                     }

                     this.produitsDepot.setProdepQteStk(var8);
                     this.produitsDepotDao.modif(this.produitsDepot, var4);
                  }
               }
            }
         }
      }

   }

   public void majFabrication(FabricationEnteteAchats var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1 != null) {
         new Produits();
         Produits var5 = this.produitsAchsDao.chargeToutProduit(var1.getFabProcess(), var4);
         if (var5 != null && var5.getProStock() != 0) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getFabProcess(), var1.getFabDepot(), var4);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateEntree(new Date());
               if (this.produitsDepot.getProdepPr() == 0.0D && var1.getFabTotPump() != 0.0D) {
                  this.produitsDepot.setProdepPr(var1.getFabTotPump());
               }

               if (this.produitsDepot.getProdepPump() == 0.0D && var1.getFabTotPump() != 0.0D) {
                  this.produitsDepot.setProdepPump(var1.getFabTotPump());
               }

               float var6 = 0.0F;
               if (var2 == 1) {
                  var6 = this.produitsDepot.getProdepQteStk() - var1.getFabQteUtil();
               } else {
                  var6 = this.produitsDepot.getProdepQteStk() + var1.getFabQteUtil();
               }

               this.produitsDepot.setProdepQteStk(var6);
               this.produitsDepotDao.modif(this.produitsDepot, var4);
            }
         }
      }

   }

   public void majConsommation(ParcConsommation var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1 != null) {
         new Produits();
         Produits var5 = this.produitsAchsDao.chargeToutProduit(var1.getPrcconCode(), var4);
         if (var5 != null && var5.getProStock() != 0) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getPrcconCode(), var1.getPrcconDepot(), var4);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               float var6 = 0.0F;
               if (var2 == 1) {
                  var6 = this.produitsDepot.getProdepQteStk() - var1.getPrcconQte();
               } else {
                  var6 = this.produitsDepot.getProdepQteStk() + var1.getPrcconQte();
               }

               this.produitsDepot.setProdepQteStk(var6);
               this.produitsDepotDao.modif(this.produitsDepot, var4);
            }
         }
      }

   }

   public void trfCotCommandeAchatATT(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         new CommandeLigneAchats();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            CommandeLigneAchats var4 = (CommandeLigneAchats)var1.get(var5);
            if (var4.getCmdligCode() != null && !var4.getCmdligCode().isEmpty() && var4.getCmdligDepot() != null && !var4.getCmdligDepot().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getCmdligCode(), var4.getCmdligDepot(), var3);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateEntree(new Date());
                  float var6 = this.produitsDepot.getProdepQteCmdAch() + var4.getCmdligQteUtil();
                  this.produitsDepot.setProdepQteCmdAch(var6);
                  this.produitsDepotDao.modif(this.produitsDepot, var3);
               }
            }
         }
      }

   }

   public void trfCmdReceptionAchatATT(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         new ReceptionLigneAchats();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            ReceptionLigneAchats var4 = (ReceptionLigneAchats)var1.get(var5);
            if (var4.getRecligCode() != null && !var4.getRecligCode().isEmpty() && var4.getRecligDepot() != null && !var4.getRecligDepot().isEmpty()) {
               float var6;
               if ((var4.getRecligDepotCmd() == null || var4.getRecligDepotCmd().isEmpty() || var4.getRecligDepotCmd() != null && !var4.getRecligDepotCmd().isEmpty()) && var4.getRecligDepot().equalsIgnoreCase(var4.getRecligDepotCmd())) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getRecligCode(), var4.getRecligDepot(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateEntree(new Date());
                     var6 = this.produitsDepot.getProdepQteCmdAch() - var4.getRecligQteUtil();
                     if (var6 < 0.0F) {
                        var6 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteCmdAch(var6);
                     float var7 = this.produitsDepot.getProdepQteAttAch() + var4.getRecligQteUtil();
                     this.produitsDepot.setProdepQteAttAch(var7);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }
               } else {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getRecligCode(), var4.getRecligDepotCmd(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateEntree(new Date());
                     var6 = this.produitsDepot.getProdepQteCmdAch() - var4.getRecligQteUtil();
                     if (var6 < 0.0F) {
                        var6 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteCmdAch(var6);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }

                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getRecligCode(), var4.getRecligDepot(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateEntree(new Date());
                     var6 = this.produitsDepot.getProdepQteAttAch() + var4.getRecligQteUtil();
                     this.produitsDepot.setProdepQteAttAch(var6);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }
               }
            }
         }
      }

   }

   public void majCommandeAchatsATT(CommandeLigneAchats var1, Produits var2, float var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var2 != null && var2.getProStock() != 0) {
         this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getCmdligCode(), var1.getCmdligDepot(), var6);
         if (this.produitsDepot != null) {
            this.produitsDepot.setProdepDateEntree(new Date());
            float var7 = 0.0F;
            if (var4 == 1) {
               var7 = this.produitsDepot.getProdepQteCmdAch() - var3 + var1.getCmdligQteUtil();
            } else {
               var7 = this.produitsDepot.getProdepQteCmdAch() - var1.getCmdligQteUtil();
            }

            this.produitsDepot.setProdepQteCmdAch(var7);
            this.produitsDepotDao.modif(this.produitsDepot, var6);
         }
      }

   }

   public void majReceptionAchatsATT(ReceptionLigneAchats var1, Produits var2, float var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var2 != null && var2.getProStock() != 0) {
         float var7;
         if (var4 == 1) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getRecligCode(), var1.getRecligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateEntree(new Date());
               var7 = this.produitsDepot.getProdepQteAttAch() - var3 + var1.getRecligQteUtil();
               this.produitsDepot.setProdepQteAttAch(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         } else if (var1.getRecligCode() != null && !var1.getRecligCode().isEmpty() && var1.getRecligDepot() != null && !var1.getRecligDepot().isEmpty()) {
            if (var1.getRecligDepotCmd() == null || var1.getRecligDepotCmd().isEmpty() || var1.getRecligDepotCmd() != null && !var1.getRecligDepotCmd().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getRecligCode(), var1.getRecligDepot(), var6);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateEntree(new Date());
                  var7 = this.produitsDepot.getProdepQteAttAch() - var1.getRecligQteUtil();
                  this.produitsDepot.setProdepQteAttAch(var7);
                  float var8 = this.produitsDepot.getProdepQteCmdAch() + var1.getRecligQteUtil();
                  this.produitsDepot.setProdepQteCmdAch(var8);
                  this.produitsDepotDao.modif(this.produitsDepot, var6);
               }
            } else {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getRecligCode(), var1.getRecligDepot(), var6);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateEntree(new Date());
                  var7 = this.produitsDepot.getProdepQteAttAch() - var1.getRecligQteUtil();
                  this.produitsDepot.setProdepQteAttAch(var7);
                  this.produitsDepotDao.modif(this.produitsDepot, var6);
               }

               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getRecligCode(), var1.getRecligDepotCmd(), var6);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateEntree(new Date());
                  var7 = this.produitsDepot.getProdepQteCmdAch() + var1.getRecligQteUtil();
                  this.produitsDepot.setProdepQteCmdAch(var7);
                  this.produitsDepotDao.modif(this.produitsDepot, var6);
               }
            }
         }
      }

   }

   public void majReceptionAchatsVAL(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new ReceptionLigneAchats();
         new Produits();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            ReceptionLigneAchats var5 = (ReceptionLigneAchats)var1.get(var7);
            if (var5.getRecligCode() != null && !var5.getRecligCode().isEmpty()) {
               Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getRecligCode(), var4);
               if (var6 != null && var6.getProStock() != 0) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getRecligCode(), var5.getRecligDepot(), var4);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateEntree(new Date());
                     float var8 = 0.0F;
                     float var9 = 0.0F;
                     if (var2 == 1) {
                        var8 = this.produitsDepot.getProdepQteAttAch() - var5.getRecligQteUtil();
                        if (var8 < 0.0F) {
                           this.produitsDepot.setProdepQteAttAch(0.0F);
                        } else {
                           this.produitsDepot.setProdepQteAttAch(var8);
                        }

                        var9 = this.produitsDepot.getProdepQteStk() + var5.getRecligQteUtil();
                        this.produitsDepot.setProdepQteStk(var9);
                     } else {
                        var8 = this.produitsDepot.getProdepQteAttAch() + var5.getRecligQteUtil();
                        this.produitsDepot.setProdepQteAttAch(var8);
                        var9 = this.produitsDepot.getProdepQteStk() - var5.getRecligQteUtil();
                        this.produitsDepot.setProdepQteStk(var9);
                     }

                     this.produitsDepotDao.modif(this.produitsDepot, var4);
                     if (var6.getProStock() == 5) {
                        new ArrayList();
                        List var10 = this.receptionSerieAchatsDao.selectReceptionSerieByRecLig(var5, var4);
                        if (var10.size() != 0) {
                           new ReceptionSerieAchats();

                           for(int var12 = 0; var12 < var10.size(); ++var12) {
                              ReceptionSerieAchats var11 = (ReceptionSerieAchats)var10.get(var12);
                              var11.setRecserPr(var5.getRecligPr());
                              this.receptionSerieAchatsDao.modif(var11, var4);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void majRetourAchatsATT(RetourLigneAchats var1, Produits var2, float var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var2 != null && var2.getProStock() != 0) {
         float var7;
         if (var4 == 1) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBrfligCode(), var1.getBrfligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateEntree(new Date());
               var7 = this.produitsDepot.getProdepQteAttAch() - var3 - var1.getBrfligQteUtil();
               this.produitsDepot.setProdepQteAttAch(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         } else if (var1.getBrfligCode() != null && !var1.getBrfligCode().isEmpty() && var1.getBrfligDepot() != null && !var1.getBrfligDepot().isEmpty()) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBrfligCode(), var1.getBrfligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateEntree(new Date());
               var7 = this.produitsDepot.getProdepQteAttAch() + var1.getBrfligQteUtil();
               this.produitsDepot.setProdepQteAttAch(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         }
      }

   }

   public void majRetourAchatsVAL(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new RetourLigneAchats();
         new Produits();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            RetourLigneAchats var5 = (RetourLigneAchats)var1.get(var7);
            Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getBrfligCode(), var4);
            if (var6 != null && var6.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getBrfligCode(), var5.getBrfligDepot(), var4);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateEntree(new Date());
                  float var8 = 0.0F;
                  float var9 = 0.0F;
                  if (var2 == 1) {
                     var8 = this.produitsDepot.getProdepQteAttAch() + var5.getBrfligQteUtil();
                     this.produitsDepot.setProdepQteAttAch(var8);
                     var9 = this.produitsDepot.getProdepQteStk() - var5.getBrfligQteUtil();
                     this.produitsDepot.setProdepQteStk(var9);
                  } else {
                     var8 = this.produitsDepot.getProdepQteAttAch() - var5.getBrfligQteUtil();
                     this.produitsDepot.setProdepQteAttAch(var8);
                     var9 = this.produitsDepot.getProdepQteStk() + var5.getBrfligQteUtil();
                     this.produitsDepot.setProdepQteStk(var9);
                  }
               }
            }
         }
      }

   }

   public void majReacheminementAchatsVAL(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new ReacheminementLigneAchats();
         new Produits();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            ReacheminementLigneAchats var5 = (ReacheminementLigneAchats)var1.get(var7);
            Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getRealigCode(), var4);
            if (var6 != null && var6.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getRealigCode(), var5.getRealigOrigDepot(), var4);
               float var8;
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateEntree(new Date());
                  var8 = 0.0F;
                  if (var2 == 1) {
                     var8 = this.produitsDepot.getProdepQteStk() - var5.getRealigOrigQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  } else {
                     var8 = this.produitsDepot.getProdepQteStk() + var5.getRealigOrigQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var4);
               }

               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getRealigCode(), var5.getRealigDestDepot(), var4);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateEntree(new Date());
                  var8 = 0.0F;
                  if (var2 == 1) {
                     var8 = this.produitsDepot.getProdepQteStk() + var5.getRealigDestQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  } else {
                     var8 = this.produitsDepot.getProdepQteStk() - var5.getRealigDestQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var4);
               }
            }
         }
      }

   }

   public void trfDevCommandeVenteATT(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         new CommandeLigneVentes();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            CommandeLigneVentes var4 = (CommandeLigneVentes)var1.get(var5);
            if (var4.getBcmligCode() != null && !var4.getBcmligCode().isEmpty() && var4.getBcmligDepot() != null && !var4.getBcmligDepot().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getBcmligCode(), var4.getBcmligDepot(), var3);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var6 = this.produitsDepot.getProdepQteCmdVte() + var4.getBcmligQteUtil();
                  this.produitsDepot.setProdepQteCmdVte(var6);
                  this.produitsDepotDao.modif(this.produitsDepot, var3);
               }
            }
         }
      }

   }

   public void trfDevLivraisonVenteATT(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         new LivraisonLigneVentes();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            LivraisonLigneVentes var4 = (LivraisonLigneVentes)var1.get(var5);
            if (var4.getBlvligCode() != null && !var4.getBlvligCode().isEmpty() && var4.getBlvligDepot() != null && !var4.getBlvligDepot().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getBlvligCode(), var4.getBlvligDepot(), var3);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var6 = this.produitsDepot.getProdepQteAttVte() + var4.getBlvligQteUtilStock();
                  this.produitsDepot.setProdepQteAttVte(var6);
                  this.produitsDepotDao.modif(this.produitsDepot, var3);
               }
            }
         }
      }

   }

   public float majCommandeVentesATT(CommandeLigneVentes var1, Produits var2, int var3, String var4, Session var5) throws HibernateException, NamingException {
      float var6 = 0.0F;
      this.baseLog = var4;
      if (var2 != null && var2.getProStock() != 0) {
         this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBcmligCode(), var1.getBcmligDepot(), var5);
         if (this.produitsDepot != null) {
            this.produitsDepot.setProdepDateSortie(new Date());
            float var7 = 0.0F;
            if (var3 == 1) {
               var7 = this.produitsDepot.getProdepQteCmdVte() + var1.getBcmligQteUtil();
               var6 = this.produitsDepot.getProdepQteStk() + var1.getBcmligQteUtil();
            } else {
               var7 = this.produitsDepot.getProdepQteCmdVte() - var1.getBcmligQteUtil();
               if (var7 < 0.0F) {
                  var7 = 0.0F;
               }

               var6 = this.produitsDepot.getProdepQteStk() - var1.getBcmligQteUtil();
            }

            this.produitsDepot.setProdepQteCmdVte(var7);
            this.produitsDepotDao.modif(this.produitsDepot, var5);
         }
      }

      return var6;
   }

   public float majCommandeVentesVAL(CommandeLigneVentes var1, Produits var2, int var3, String var4, Session var5) throws HibernateException, NamingException {
      float var6 = 0.0F;
      this.baseLog = var4;
      if (var2 != null && var2.getProStock() != 0) {
         this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBcmligCode(), var1.getBcmligDepot(), var5);
         if (this.produitsDepot != null) {
            this.produitsDepot.setProdepDateSortie(new Date());
            float var7 = 0.0F;
            if (var3 == 1) {
               var7 = this.produitsDepot.getProdepQteStk() - var1.getBcmligQteUtil();
               this.produitsDepot.setProdepQteStk(var7);
            } else {
               var7 = this.produitsDepot.getProdepQteStk() + var1.getBcmligQteUtil();
               this.produitsDepot.setProdepQteStk(var7);
            }

            this.produitsDepotDao.modif(this.produitsDepot, var5);
            var6 = this.produitsDepot.getProdepQteStk();
         }
      }

      return var6;
   }

   public void majCommandeVentesVAL(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new Produits();
         new CommandeLigneVentes();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            CommandeLigneVentes var6 = (CommandeLigneVentes)var1.get(var7);
            Produits var5 = this.produitsAchsDao.chargeToutProduit(var6.getBcmligCode(), var4);
            if (var5 != null && var5.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var6.getBcmligCode(), var6.getBcmligDepot(), var4);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var8 = 0.0F;
                  if (var2 == 1) {
                     var8 = this.produitsDepot.getProdepQteStk() - var6.getBcmligQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  } else {
                     var8 = this.produitsDepot.getProdepQteStk() + var6.getBcmligQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var4);
               }
            }
         }
      }

   }

   public void majCommandeVentesANNULE(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         new CommandeLigneVentes();
         new Produits();

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            CommandeLigneVentes var4 = (CommandeLigneVentes)var1.get(var6);
            Produits var5 = this.produitsAchsDao.chargeToutProduit(var4.getBcmligCode(), var3);
            if (var5 != null && var5.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getBcmligCode(), var4.getBcmligDepot(), var3);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var7 = 0.0F;
                  var7 = this.produitsDepot.getProdepQteCmdVte() + var4.getBcmligQteUtil();
                  this.produitsDepot.setProdepQteCmdVte(var7);
                  this.produitsDepotDao.modif(this.produitsDepot, var3);
               }
            }
         }
      }

   }

   public void trfCmdLivraisonVenteATT(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         new LivraisonLigneVentes();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            LivraisonLigneVentes var4 = (LivraisonLigneVentes)var1.get(var5);
            if (var4.getBlvligCode() != null && !var4.getBlvligCode().isEmpty() && var4.getBlvligDepot() != null && !var4.getBlvligDepot().isEmpty()) {
               float var6;
               if ((var4.getBlvligDepotCmd() == null || var4.getBlvligDepotCmd().isEmpty() || var4.getBlvligDepotCmd() != null && !var4.getBlvligDepotCmd().isEmpty()) && var4.getBlvligDepot().equalsIgnoreCase(var4.getBlvligDepotCmd())) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getBlvligCode(), var4.getBlvligDepot(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     var6 = this.produitsDepot.getProdepQteCmdVte() - var4.getBlvligQteUtilStock();
                     if (var6 < 0.0F) {
                        var6 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteCmdVte(var6);
                     float var7 = this.produitsDepot.getProdepQteAttVte() + var4.getBlvligQteUtilStock();
                     this.produitsDepot.setProdepQteAttVte(var7);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }
               } else {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getBlvligCode(), var4.getBlvligDepotCmd(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     var6 = this.produitsDepot.getProdepQteCmdVte() - var4.getBlvligQteUtilStock();
                     if (var6 < 0.0F) {
                        var6 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteCmdVte(var6);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }

                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getBlvligCode(), var4.getBlvligDepot(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     var6 = this.produitsDepot.getProdepQteAttVte() + var4.getBlvligQteUtilStock();
                     this.produitsDepot.setProdepQteAttVte(var6);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }
               }
            }
         }
      }

   }

   public void trfCmdFacturationVenteATT(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         new FactureLigneVentes();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            FactureLigneVentes var4 = (FactureLigneVentes)var1.get(var5);
            if (var4.getFacligCode() != null && !var4.getFacligCode().isEmpty() && var4.getFacligDepot() != null && !var4.getFacligDepot().isEmpty()) {
               float var6;
               if (var4.getFacligDepot() != null && !var4.getFacligDepot().isEmpty()) {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getFacligCode(), var4.getFacligDepot(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     var6 = this.produitsDepot.getProdepQteCmdVte() - var4.getFacligQteUtil();
                     if (var6 < 0.0F) {
                        var6 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteCmdVte(var6);
                     float var7 = this.produitsDepot.getProdepQteAttVte() + var4.getFacligQteUtil();
                     this.produitsDepot.setProdepQteAttVte(var7);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }
               } else {
                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getFacligCode(), var4.getFacligDepot(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     var6 = this.produitsDepot.getProdepQteCmdVte() - var4.getFacligQteUtil();
                     if (var6 < 0.0F) {
                        var6 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteCmdVte(var6);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }

                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(var4.getFacligCode(), var4.getFacligDepot(), var3);
                  if (this.produitsDepot != null) {
                     this.produitsDepot.setProdepDateSortie(new Date());
                     var6 = this.produitsDepot.getProdepQteAttVte() + var4.getFacligQteUtil();
                     this.produitsDepot.setProdepQteAttVte(var6);
                     this.produitsDepotDao.modif(this.produitsDepot, var3);
                  }
               }
            }
         }
      }

   }

   public void majLivraisonVentesATT(LivraisonLigneVentes var1, Produits var2, float var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var2 != null && var2.getProStock() != 0) {
         float var7;
         if (var4 == 1) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBlvligCode(), var1.getBlvligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               var7 = this.produitsDepot.getProdepQteAttVte() - var3 + var1.getBlvligQteUtilStock();
               if (var7 < 0.0F) {
                  var7 = 0.0F;
               }

               this.produitsDepot.setProdepQteAttVte(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         } else if (var1.getBlvligCode() != null && !var1.getBlvligCode().isEmpty() && var1.getBlvligDepot() != null && !var1.getBlvligDepot().isEmpty()) {
            if (var1.getBlvligDepotCmd() == null || var1.getBlvligDepotCmd().isEmpty() || var1.getBlvligDepotCmd() != null && !var1.getBlvligDepotCmd().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBlvligCode(), var1.getBlvligDepot(), var6);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  var7 = this.produitsDepot.getProdepQteAttVte() - var1.getBlvligQteUtilStock();
                  if (var7 < 0.0F) {
                     var7 = 0.0F;
                  }

                  this.produitsDepot.setProdepQteAttVte(var7);
                  float var8 = this.produitsDepot.getProdepQteCmdVte() + var1.getBlvligQteUtilStock();
                  this.produitsDepot.setProdepQteCmdVte(var8);
                  this.produitsDepotDao.modif(this.produitsDepot, var6);
               }
            } else {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBlvligCode(), var1.getBlvligDepot(), var6);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  var7 = this.produitsDepot.getProdepQteAttVte() - var1.getBlvligQteUtilStock();
                  if (var7 < 0.0F) {
                     var7 = 0.0F;
                  }

                  this.produitsDepot.setProdepQteAttVte(var7);
                  this.produitsDepotDao.modif(this.produitsDepot, var6);
               }

               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBlvligCode(), var1.getBlvligDepotCmd(), var6);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  var7 = this.produitsDepot.getProdepQteCmdVte() + var1.getBlvligQteUtilStock();
                  this.produitsDepot.setProdepQteCmdVte(var7);
                  this.produitsDepotDao.modif(this.produitsDepot, var6);
               }
            }
         }
      }

   }

   public void majLivraisonVentesVAL(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new Produits();
         new LivraisonLigneVentes();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            LivraisonLigneVentes var6 = (LivraisonLigneVentes)var1.get(var7);
            Produits var5 = this.produitsAchsDao.chargeToutProduit(var6.getBlvligCode(), var4);
            if (var5 != null && var5.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var6.getBlvligCode(), var6.getBlvligDepot(), var4);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var8 = 0.0F;
                  float var9 = 0.0F;
                  if (var2 == 1) {
                     var8 = this.produitsDepot.getProdepQteAttVte() - var6.getBlvligQteUtilStock();
                     if (var8 < 0.0F) {
                        var8 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteAttVte(var8);
                     var9 = this.produitsDepot.getProdepQteStk() - var6.getBlvligQteUtilStock();
                     this.produitsDepot.setProdepQteStk(var9);
                  } else {
                     var8 = this.produitsDepot.getProdepQteAttVte() + var6.getBlvligQteUtilStock();
                     this.produitsDepot.setProdepQteAttVte(var8);
                     var9 = this.produitsDepot.getProdepQteStk() + var6.getBlvligQteUtilStock();
                     this.produitsDepot.setProdepQteStk(var9);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var4);
               }
            }
         }
      }

   }

   public void majFactureVentesVAL(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         new Produits();
         new FactureLigneVentes();

         for(int var7 = 0; var7 < var1.size(); ++var7) {
            FactureLigneVentes var6 = (FactureLigneVentes)var1.get(var7);
            Produits var5 = this.produitsAchsDao.chargeToutProduit(var6.getFacligCode(), var4);
            if (var5 != null && var5.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var6.getFacligCode(), var6.getFacligDepot(), var4);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var8 = 0.0F;
                  float var9 = 0.0F;
                  if (var2 == 1) {
                     var8 = this.produitsDepot.getProdepQteAttVte() - var6.getFacligQteUtil();
                     if (var8 < 0.0F) {
                        var8 = 0.0F;
                     }

                     this.produitsDepot.setProdepQteAttVte(var8);
                     var9 = this.produitsDepot.getProdepQteStk() - var6.getFacligQteUtil();
                     this.produitsDepot.setProdepQteStk(var9);
                  } else {
                     var8 = this.produitsDepot.getProdepQteAttVte() + var6.getFacligQteUtil();
                     this.produitsDepot.setProdepQteAttVte(var8);
                     var9 = this.produitsDepot.getProdepQteStk() + var6.getFacligQteUtil();
                     this.produitsDepot.setProdepQteStk(var9);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var4);
               }
            }
         }
      }

   }

   public void majCadeauxVentesVAL(Cadeaux var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1 != null) {
         new Produits();
         Produits var5 = this.produitsAchsDao.chargeToutProduit(var1.getCadCode(), var4);
         if (var5 != null && var5.getProStock() != 0) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getCadCode(), var1.getCadDepot(), var4);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               float var6 = 0.0F;
               if (var1.getCadQteUtil() == 0.0F) {
                  var1.setCadQteUtil(var1.getCadQte());
               }

               if (var2 == 1) {
                  var6 = this.produitsDepot.getProdepQteStk() - var1.getCadQteUtil();
                  this.produitsDepot.setProdepQteStk(var6);
               } else {
                  var6 = this.produitsDepot.getProdepQteStk() + var1.getCadQteUtil();
                  this.produitsDepot.setProdepQteStk(var6);
               }

               this.produitsDepotDao.modif(this.produitsDepot, var4);
            }
         }
      }

   }

   public void majChargementVentesVAL(ChargementLigne var1, float var2, Produits var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var3 != null && var3.getProStock() != 0) {
         this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getChaligCode(), var1.getChaligDepotCharg(), var6);
         if (this.produitsDepot != null) {
            this.produitsDepot.setProdepDateSortie(new Date());
            float var7 = 0.0F;
            if (var4 == 1) {
               var7 = this.produitsDepot.getProdepQteStk() + var2 - var1.getChaligQteCharg();
               this.produitsDepot.setProdepQteStk(var7);
            } else {
               var7 = this.produitsDepot.getProdepQteStk() - var2 + var1.getChaligQteCharg();
               this.produitsDepot.setProdepQteStk(var7);
            }

            this.produitsDepotDao.modif(this.produitsDepot, var6);
         }
      }

   }

   public void majTicketVentesVAL(List var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      if (var1.size() != 0) {
         for(int var5 = 0; var5 < var1.size(); ++var5) {
            new TicketLigneVentes();
            TicketLigneVentes var6 = (TicketLigneVentes)var1.get(var5);
            new Produits();
            Produits var7 = this.produitsAchsDao.chargeToutProduit(var6.getTicligCode(), var4);
            if (var7 != null && var7.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var6.getTicligCode(), var6.getTicligDepot(), var4);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var8 = 0.0F;
                  if (var2 == 1) {
                     var8 = this.produitsDepot.getProdepQteStk() - var6.getTicligQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  } else {
                     var8 = this.produitsDepot.getProdepQteStk() + var6.getTicligQteUtil();
                     this.produitsDepot.setProdepQteStk(var8);
                  }

                  this.produitsDepotDao.modif(this.produitsDepot, var4);
               }
            }
         }
      }

   }

   public void majRetourVentesATT(RetourLigneVentes var1, Produits var2, float var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var2 != null && var2.getProStock() != 0) {
         float var7;
         if (var4 == 1) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBrtligCode(), var1.getBrtligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               var7 = this.produitsDepot.getProdepQteAttVte() - var3 - var1.getBrtligQteUtil();
               if (var7 < 0.0F) {
                  var7 = 0.0F;
               }

               this.produitsDepot.setProdepQteAttVte(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         } else if (var1.getBrtligCode() != null && !var1.getBrtligCode().isEmpty() && var1.getBrtligDepot() != null && !var1.getBrtligDepot().isEmpty()) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getBrtligCode(), var1.getBrtligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               var7 = this.produitsDepot.getProdepQteAttVte() + var1.getBrtligQteUtil();
               this.produitsDepot.setProdepQteAttVte(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         }
      }

   }

   public void majRetourVentesVAL(List var1, String var2, Session var3) throws HibernateException, NamingException {
      this.baseLog = var2;
      if (var1.size() != 0) {
         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new RetourLigneVentes();
            RetourLigneVentes var5 = (RetourLigneVentes)var1.get(var4);
            new Produits();
            Produits var6 = this.produitsAchsDao.chargeToutProduit(var5.getBrtligCode(), var3);
            if (var6 != null && var6.getProStock() != 0) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var5.getBrtligCode(), var5.getBrtligDepot(), var3);
               if (this.produitsDepot != null) {
                  this.produitsDepot.setProdepDateSortie(new Date());
                  float var7 = this.produitsDepot.getProdepQteAttVte() - var5.getBrtligQteUtil();
                  if (var7 < 0.0F) {
                     var7 = 0.0F;
                  }

                  this.produitsDepot.setProdepQteAttVte(var7);
                  float var8 = this.produitsDepot.getProdepQteAttVte() + var5.getBrtligQteUtil();
                  this.produitsDepot.setProdepQteAttVte(var8);
                  this.produitsDepotDao.modif(this.produitsDepot, var3);
               }
            }
         }
      }

   }

   public void majPharmacie(PharmacieLigne var1, Produits var2, float var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var2 != null && var2.getProStock() != 0) {
         float var7;
         if (var4 == 1) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getPhaligProduit(), var1.getPhaligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               var7 = this.produitsDepot.getProdepQteStk() - var3 + var1.getPhaligQte();
               if (var7 < 0.0F) {
                  var7 = 0.0F;
               }

               this.produitsDepot.setProdepQteStk(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         } else if (var1.getPhaligProduit() != null && !var1.getPhaligProduit().isEmpty() && var1.getPhaligDepot() != null && !var1.getPhaligDepot().isEmpty()) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getPhaligProduit(), var1.getPhaligDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               var7 = this.produitsDepot.getProdepQteStk() - var1.getPhaligQte();
               if (var7 < 0.0F) {
                  var7 = 0.0F;
               }

               this.produitsDepot.setProdepQteStk(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         }
      }

   }

   public void majHospitalisation(HospitalisationMedi var1, Produits var2, float var3, int var4, String var5, Session var6) throws HibernateException, NamingException {
      this.baseLog = var5;
      if (var2 != null && var2.getProStock() != 0) {
         float var7;
         if (var4 == 1) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getHosmedProduit(), var1.getHosmedDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               var7 = this.produitsDepot.getProdepQteStk() - var3 + var1.getHosmedQte();
               if (var7 < 0.0F) {
                  var7 = 0.0F;
               }

               this.produitsDepot.setProdepQteStk(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         } else if (var1.getHosmedProduit() != null && !var1.getHosmedProduit().isEmpty() && var1.getHosmedDepot() != null && !var1.getHosmedDepot().isEmpty()) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getHosmedProduit(), var1.getHosmedDepot(), var6);
            if (this.produitsDepot != null) {
               this.produitsDepot.setProdepDateSortie(new Date());
               var7 = this.produitsDepot.getProdepQteStk() - var1.getHosmedQte();
               if (var7 < 0.0F) {
                  var7 = 0.0F;
               }

               this.produitsDepot.setProdepQteStk(var7);
               this.produitsDepotDao.modif(this.produitsDepot, var6);
            }
         }
      }

   }

   public InventaireLigne chercheDernierInventaire(String var1, String var2, long var3, String var5, Session var6) throws ParseException {
      this.baseLog = var5;
      new InventaireLigne();
      new ArrayList();
      List var8 = this.inventaireLigneDao.chargerLesMvts(var1, var2, var3, var6);
      InventaireLigne var7;
      if (var8.size() != 0) {
         for(int var9 = 0; var9 < var8.size(); ++var9) {
            if (((InventaireLigne)var8.get(var9)).getInventaireEntete().getInvEtat() != 1) {
               var8.remove(var9);
               --var9;
               if (var9 == 0) {
                  break;
               }
            }
         }

         if (var8.size() != 0) {
            boolean var14 = false;
            long var10 = ((InventaireLigne)var8.get(0)).getInventaireEntete().getInvId();
            float var12 = 0.0F;

            for(int var13 = 0; var13 < var8.size(); ++var13) {
               if (((InventaireLigne)var8.get(var13)).getInventaireEntete().getInvEtat() == 1 && var10 == ((InventaireLigne)var8.get(var13)).getInventaireEntete().getInvId()) {
                  float var10000 = var12 + ((InventaireLigne)var8.get(var13)).getInvligQteUtil();
                  var14 = true;
                  break;
               }
            }

            if (var14) {
               var7 = (InventaireLigne)var8.get(0);
               var7.setInvligQteUtil(var7.getInvligQteUtil());
            } else {
               var7 = null;
            }
         } else {
            var7 = null;
         }
      } else {
         var7 = null;
      }

      return var7;
   }

   public InventaireLigne chercheDernierInventaire(String var1, String var2, String var3, Session var4) throws ParseException {
      this.baseLog = var3;
      new InventaireLigne();
      new ArrayList();
      List var6 = this.inventaireLigneDao.chargerLesMvts(var1, var2, var4);
      InventaireLigne var5;
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            if (((InventaireLigne)var6.get(var7)).getInventaireEntete().getInvEtat() != 1) {
               var6.remove(var7);
               --var7;
               if (var7 == 0) {
                  break;
               }
            }
         }

         if (var6.size() != 0) {
            boolean var12 = false;
            long var8 = ((InventaireLigne)var6.get(0)).getInventaireEntete().getInvId();
            float var10 = 0.0F;

            for(int var11 = 0; var11 < var6.size(); ++var11) {
               if (((InventaireLigne)var6.get(var11)).getInventaireEntete().getInvEtat() == 1 && var8 == ((InventaireLigne)var6.get(var11)).getInventaireEntete().getInvId()) {
                  float var10000 = var10 + ((InventaireLigne)var6.get(var11)).getInvligQteUtil();
                  var12 = true;
                  break;
               }
            }

            if (var12) {
               var5 = (InventaireLigne)var6.get(0);
               var5.setInvligQteUtil(var5.getInvligQteUtil());
            } else {
               var5 = null;
            }
         } else {
            var5 = null;
         }
      } else {
         var5 = null;
      }

      return var5;
   }

   public InventaireLigne localisationInventaire(String var1, String var2, String var3, String var4, String var5, long var6, String var8, Session var9) throws ParseException {
      this.baseLog = var8;
      new InventaireLigne();
      new ArrayList();
      List var11 = this.inventaireLigneDao.localisationInv(var1, var2, var3, var4, var5, var6, var9);
      InventaireLigne var10;
      if (var11.size() != 0) {
         for(int var12 = 0; var12 < var11.size(); ++var12) {
            if (((InventaireLigne)var11.get(var12)).getInventaireEntete().getInvEtat() != 1) {
               var11.remove(var12);
               --var12;
               if (var12 == 0) {
                  break;
               }
            }
         }

         if (var11.size() != 0) {
            boolean var17 = false;
            long var13 = ((InventaireLigne)var11.get(0)).getInventaireEntete().getInvId();
            float var15 = 0.0F;

            for(int var16 = 0; var16 < var11.size(); ++var16) {
               if (((InventaireLigne)var11.get(var16)).getInventaireEntete().getInvEtat() == 1 && var13 == ((InventaireLigne)var11.get(var16)).getInventaireEntete().getInvId()) {
                  float var10000 = var15 + ((InventaireLigne)var11.get(var16)).getInvligQteUtil();
                  var17 = true;
                  break;
               }
            }

            if (var17) {
               var10 = (InventaireLigne)var11.get(0);
               var10.setInvligQteUtil(var10.getInvligQteUtil());
            } else {
               var10 = null;
            }
         } else {
            var10 = null;
         }
      } else {
         var10 = null;
      }

      return var10;
   }

   public ReceptionLigneAchats chercheDernierReception(String var1, String var2, long var3, String var5, Session var6) throws ParseException {
      this.baseLog = var5;
      new ReceptionLigneAchats();
      new ArrayList();
      List var8 = this.receptionLigneAchatsDao.chargerLesMvts(var1, var2, var3, var6);
      ReceptionLigneAchats var7;
      if (var8.size() != 0) {
         for(int var9 = 0; var9 < var8.size(); ++var9) {
            if (((ReceptionLigneAchats)var8.get(var9)).getReceptionEnteteAchats().getRecEtat() == 0) {
               var8.remove(var9);
               --var9;
               if (var9 == 0) {
                  break;
               }
            }
         }

         if (var8.size() != 0) {
            boolean var14 = false;
            long var10 = ((ReceptionLigneAchats)var8.get(0)).getReceptionEnteteAchats().getRecId();
            float var12 = 0.0F;

            for(int var13 = 0; var13 < var8.size(); ++var13) {
               if (var10 == ((ReceptionLigneAchats)var8.get(var13)).getReceptionEnteteAchats().getRecId()) {
                  var12 += ((ReceptionLigneAchats)var8.get(var13)).getRecligQteUtil();
                  var14 = true;
                  break;
               }
            }

            if (var14) {
               var7 = (ReceptionLigneAchats)var8.get(0);
               var7.setRecligQteUtil(var7.getRecligQteUtil());
            } else {
               var7 = null;
            }

            if (var12 == 0.0F && var7.getRecligPrU() == 0.0D) {
               var7 = null;
            }
         } else {
            var7 = null;
         }
      } else {
         var7 = null;
      }

      return var7;
   }

   public ReceptionLigneAchats chercheDernierReception(String var1, String var2, String var3, Session var4) throws ParseException {
      this.baseLog = var3;
      new ReceptionLigneAchats();
      new ArrayList();
      List var6 = this.receptionLigneAchatsDao.chargerLesMvts(var1, var2, var4);
      ReceptionLigneAchats var5;
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            if (((ReceptionLigneAchats)var6.get(var7)).getReceptionEnteteAchats().getRecEtat() == 0) {
               var6.remove(var7);
               --var7;
               if (var7 == 0) {
                  break;
               }
            }
         }

         if (var6.size() != 0) {
            boolean var12 = false;
            long var8 = ((ReceptionLigneAchats)var6.get(0)).getReceptionEnteteAchats().getRecId();
            float var10 = 0.0F;

            for(int var11 = 0; var11 < var6.size(); ++var11) {
               if (var8 == ((ReceptionLigneAchats)var6.get(var11)).getReceptionEnteteAchats().getRecId()) {
                  var10 += ((ReceptionLigneAchats)var6.get(var11)).getRecligQteUtil();
                  var12 = true;
                  break;
               }
            }

            if (var12) {
               var5 = (ReceptionLigneAchats)var6.get(0);
               var5.setRecligQteUtil(var5.getRecligQteUtil());
            } else {
               var5 = null;
            }

            if (var10 == 0.0F && var5.getRecligPrU() == 0.0D) {
               var5 = null;
            }
         } else {
            var5 = null;
         }
      } else {
         var5 = null;
      }

      return var5;
   }

   public ProduitsDepot recalculStock(String var1, ProduitsDepot var2, InventaireLigne var3, String var4, String var5, String var6, long var7, String var9, String var10, Structure var11, Session var12) throws NamingException, ParseException {
      boolean var13 = false;
      if (var12 == null) {
         var12 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         var13 = true;
      }

      this.baseLog = var10;
      this.structureLog = var11;
      this.lesMvt.clear();
      float var14 = 0.0F;
      float var15 = 0.0F;
      float var16 = 0.0F;
      float var17 = 0.0F;
      float var18 = 0.0F;
      this.utilDate = new UtilDate();
      Date var19 = null;
      if (var3 == null) {
         var19 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
      } else {
         var19 = var3.getInventaireEntete().getInvDate();
         Stock var20 = new Stock();
         var20.setStk_lib_type("Inventaire");
         var20.setStk_type(30);
         if (var3.getInventaireEntete().getInvEtat() == 1) {
            var20.setStk_etat("Validé");
            var20.setStk_code_depot(var3.getInvligDepot());
            var20.setStk_code_produit(var3.getInvligCode());
            var20.setStk_numero(var3.getInventaireEntete().getInvNum());
            var20.setStk_tiers("Inventaire");
            var20.setStk_activite(var3.getInventaireEntete().getInvActivite());
            var20.setStk_date_mvt(var3.getInventaireEntete().getInvDate());
            var20.setStk_pa(0.0D);
            var20.setStkDevise(this.structureLog.getStrdevise());
            var20.setStk_format_devise(this.utilNombre.formatDevise(var20.getStkDevise()));
            var20.setStk_pv(0.0D);
            var20.setStk_pump(var3.getInvligPump());
            var20.setStk_qte_in(var3.getInvligQteUtil());
            var20.setStk_qte_out(0.0F);
            this.lesMvt.add(var20);
         } else {
            var19 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
         }
      }

      boolean var23 = false;
      if (var9.equals("1")) {
         var23 = true;
      }

      this.chargerMouvements(1, "", var1, var4, var5, var6, var7, "", "", var19, new Date(), false, true, true, true, false, false, false, true, true, true, true, false, var23, true, true, false, false, false, true, true, true, var9, this.baseLog, this.structureLog, var12);
      if (this.lesMvt.size() != 0) {
         UtilTrie var21 = new UtilTrie();
         this.lesMvt = var21.triListeDate(this.lesMvt);
         this.lesMvt = var21.triListeDate(this.lesMvt);
         this.lesMvt = var21.triListeDate(this.lesMvt);
         this.lesMvt = var21.triListeDate(this.lesMvt);

         for(int var22 = 0; var22 < this.lesMvt.size(); ++var22) {
            if (((Stock)this.lesMvt.get(var22)).getStk_type() != 10 && ((Stock)this.lesMvt.get(var22)).getStk_type() != 11 && ((Stock)this.lesMvt.get(var22)).getStk_type() != 12) {
               var18 += ((Stock)this.lesMvt.get(var22)).getStk_qte_in() - ((Stock)this.lesMvt.get(var22)).getStk_qte_out();
            }
         }
      }

      if (var2 != null) {
         var2.setProdepQteCmdAch(var14);
         var2.setProdepQteAttAch(var16);
         var2.setProdepQteCmdVte(var15);
         var2.setProdepQteAttVte(var17);
         var2.setProdepQteStk(var18);
      } else {
         var2 = null;
      }

      if (var13) {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public ProduitsDepot recalculPump(String var1, String var2, ProduitsDepot var3, InventaireLigne var4, String var5, String var6, String var7, long var8, String var10, String var11, Structure var12, Session var13) throws NamingException, ParseException {
      boolean var14 = false;
      if (var13 == null) {
         var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         var14 = true;
      }

      new ReceptionLigneAchats();
      new FabricationLigneAchats();
      new FabricationEnteteAchats();
      new PumpAchats();
      this.baseLog = var11;
      this.structureLog = var12;
      this.lesMvt.clear();
      double var19 = 0.0D;
      double var21 = 0.0D;
      float var23 = 0.0F;
      this.utilDate = new UtilDate();
      Date var24 = null;
      new Stock();
      Stock var25 = null;
      if (var4 == null) {
         var24 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
      } else {
         var24 = var4.getInventaireEntete().getInvDate();
         var21 = var4.getInvligPump();
         var23 = var4.getInvligQteUtil();
         Stock var26 = new Stock();
         var26.setStk_lib_type("Inventaire");
         var26.setStk_type(30);
         if (var4.getInventaireEntete().getInvEtat() == 1) {
            var26.setStk_etat("Validé");
            var26.setStk_code_depot(var4.getInvligDepot());
            var26.setStk_code_produit(var4.getInvligCode());
            var26.setStk_numero(var4.getInventaireEntete().getInvNum());
            var26.setStk_tiers("Inventaire");
            var26.setStk_activite(var4.getInventaireEntete().getInvActivite());
            var26.setStk_date_mvt(var4.getInventaireEntete().getInvDate());
            var26.setStk_pa(0.0D);
            var26.setStkDevise(this.structureLog.getStrdevise());
            var26.setStk_format_devise(this.utilNombre.formatDevise(var26.getStkDevise()));
            var26.setStk_pv(0.0D);
            var26.setStk_pump(var4.getInvligPump());
            var26.setStk_qte_in(var4.getInvligQteUtil());
            var26.setStk_qte_out(0.0F);
            var25 = var26;
         }
      }

      this.chargerMouvements(1, "", var2, var5, var6, var7, var8, "", "", var24, new Date(), false, true, true, true, false, false, false, true, true, true, true, false, true, true, true, false, false, false, true, true, true, var10, this.baseLog, this.structureLog, var13);
      if (var25 != null) {
         this.lesMvt.add(0, var25);
      }

      if (this.lesMvt.size() != 0) {
         UtilTrie var32 = new UtilTrie();
         this.lesMvt = var32.triListeDate(this.lesMvt);
         double var27 = 0.0D;
         var19 = 0.0D;

         for(int var29 = 0; var29 < this.lesMvt.size(); ++var29) {
            if (((Stock)this.lesMvt.get(var29)).getStk_type() != 10 && ((Stock)this.lesMvt.get(var29)).getStk_type() != 11 && ((Stock)this.lesMvt.get(var29)).getStk_type() != 12) {
               if (((Stock)this.lesMvt.get(var29)).getStk_type() == 30) {
                  var23 = 0.0F;
                  var21 = ((Stock)this.lesMvt.get(var29)).getStk_pump();
                  var23 = this.cumulQte(var23, var29);
               } else {
                  PumpAchats var18;
                  float var30;
                  float var31;
                  if (((Stock)this.lesMvt.get(var29)).getStk_type() == 13) {
                     ReceptionLigneAchats var15 = this.receptionLigneAchatsDao.rechercheReception(((Stock)this.lesMvt.get(var29)).getStk_id(), var13);
                     if (var15 != null && !var15.getReceptionEnteteAchats().isRecExcluValo()) {
                        if (var1.equals("0")) {
                           if (var23 <= 0.0F) {
                              if (((Stock)this.lesMvt.get(var29)).getStk_qte_in() != 0.0F) {
                                 var19 = ((Stock)this.lesMvt.get(var29)).getStk_pa() * (double)((Stock)this.lesMvt.get(var29)).getStk_qte_in() / (double)((Stock)this.lesMvt.get(var29)).getStk_qte_in();
                              }
                           } else if (var23 + ((Stock)this.lesMvt.get(var29)).getStk_qte_in() != 0.0F) {
                              var19 = (var21 * (double)var23 + ((Stock)this.lesMvt.get(var29)).getStk_pa() * (double)((Stock)this.lesMvt.get(var29)).getStk_qte_in()) / (double)(var23 + ((Stock)this.lesMvt.get(var29)).getStk_qte_in());
                           }
                        } else if (((Stock)this.lesMvt.get(var29)).getStk_qte_in() != 0.0F) {
                           var30 = var23 - ((Stock)this.lesMvt.get(var29)).getStk_qte_in();
                           if (var30 < 0.0F) {
                              var30 = 0.0F;
                           }

                           var31 = var23 + ((Stock)this.lesMvt.get(var29)).getStk_qte_in();
                           if (var31 != 0.0F) {
                              if (var27 != 0.0D) {
                                 var19 = (var27 * (double)var30 + ((Stock)this.lesMvt.get(var29)).getStk_pa() * (double)((Stock)this.lesMvt.get(var29)).getStk_qte_in()) / (double)(var23 + ((Stock)this.lesMvt.get(var29)).getStk_qte_in());
                              } else {
                                 var19 = (((Stock)this.lesMvt.get(var29)).getStk_pa() * (double)var30 + ((Stock)this.lesMvt.get(var29)).getStk_pa() * (double)((Stock)this.lesMvt.get(var29)).getStk_qte_in()) / (double)(var23 + ((Stock)this.lesMvt.get(var29)).getStk_qte_in());
                              }
                           }
                        }

                        var15.setRecligPump(var19);
                        var15 = this.receptionLigneAchatsDao.modifLigne(var15, var13);
                        if (var15.getRecligCode() != null && !var15.getRecligCode().isEmpty()) {
                           var18 = this.pumpAchatsDao.chargePumpByIdDocLigne(var15.getRecligId(), 13, var13);
                           if (var18 != null) {
                              var18.setPumPump(var19);
                              this.pumpAchatsDao.modif(var18, var13);
                           } else {
                              var18 = new PumpAchats();
                              var18.setExercicesAchats(var15.getReceptionEnteteAchats().getExercicesAchats());
                              var18.setPumDate(var15.getReceptionEnteteAchats().getRecDate());
                              var18.setPumDateCreat(new Date());
                              var18.setPumDepot(var15.getRecligDepot());
                              var18.setPumDossier(var15.getReceptionEnteteAchats().getRecAnal4());
                              var18.setPumIdCreateur(0L);
                              var18.setPumIdDocOrigine(var15.getReceptionEnteteAchats().getRecId());
                              var18.setPumIdLigneOrigine(var15.getRecligId());
                              var18.setPumNatureOrigine(13);
                              var18.setPumNumDocOrigine(var15.getReceptionEnteteAchats().getRecNum());
                              var18.setPumPa(var15.getRecligPu());
                              var18.setPumPrKg(var15.getRecligPrKg());
                              var18.setPumPr(var15.getRecligPr());
                              var18.setPumProduit(var15.getRecligCode());
                              var18.setPumPump(var15.getRecligPump());
                              var18.setPumQteOperation(var15.getRecligQte());
                              var18.setPumQteStock(var23);
                              this.pumpAchatsDao.insert(var18, var13);
                           }
                        }

                        var21 = var19;
                        var27 = var15.getRecligPump();
                        var23 = this.cumulQte(var23, var29);
                     }
                  } else if (((Stock)this.lesMvt.get(var29)).getStk_type() == 34) {
                     FabricationEnteteAchats var17 = this.fabricationEnteteAchatsDao.pourParapheur(((Stock)this.lesMvt.get(var29)).getStk_id(), var13);
                     if (var17 != null && var17.getFabOption2() == 0) {
                        if (var1.equals("0")) {
                           if (var17.getFabQte() != 0.0F) {
                              if (var23 <= 0.0F) {
                                 if (var17.getFabQte() != 0.0F) {
                                    var19 = var17.getFabPump() * (double)var17.getFabQte() / (double)var17.getFabQte();
                                 }
                              } else if (var23 + var17.getFabQte() != 0.0F) {
                                 var19 = (var21 * (double)var23 + var17.getFabPump() * (double)var17.getFabQte()) / (double)(var23 + var17.getFabQte());
                              }
                           }
                        } else if (var17.getFabQte() != 0.0F) {
                           var30 = var23 - var17.getFabQte();
                           if (var30 < 0.0F) {
                              var30 = 0.0F;
                           }

                           var31 = var23 + var17.getFabQte();
                           if (var31 != 0.0F) {
                              if (var27 != 0.0D) {
                                 var19 = (var27 * (double)var30 + var17.getFabPump() * (double)var17.getFabQte()) / (double)(var23 + var17.getFabQte());
                              } else {
                                 var19 = (((Stock)this.lesMvt.get(var29)).getStk_pa() * (double)var30 + var17.getFabPump() * (double)var17.getFabQte()) / (double)(var23 + var17.getFabQte());
                              }
                           }
                        }

                        if (var17.getFabProcess() != null && !var17.getFabProcess().isEmpty()) {
                           var18 = this.pumpAchatsDao.chargePumpByIdDoc(var17.getFabId(), 34, var13);
                           if (var18 != null) {
                              var18.setPumPump(var19);
                              this.pumpAchatsDao.modif(var18, var13);
                           } else {
                              var18 = new PumpAchats();
                              var18.setExercicesAchats(var17.getExercicesAchats());
                              var18.setPumDate(var17.getFabDate());
                              var18.setPumDateCreat(new Date());
                              var18.setPumDepot(var17.getFabDepot());
                              var18.setPumDossier(var17.getFabAnal4());
                              var18.setPumIdCreateur(0L);
                              var18.setPumIdDocOrigine(var17.getFabId());
                              var18.setPumIdLigneOrigine(0L);
                              var18.setPumNatureOrigine(34);
                              var18.setPumNumDocOrigine(var17.getFabNum());
                              var18.setPumPa(var17.getFabPump());
                              var18.setPumPrKg(var17.getFabPump());
                              var18.setPumPr(var17.getFabPump());
                              var18.setPumProduit(var17.getFabProcess());
                              var18.setPumPump(var17.getFabPump());
                              var18.setPumQteOperation(var17.getFabQte());
                              var18.setPumQteStock(var23);
                              this.pumpAchatsDao.insert(var18, var13);
                           }
                        }

                        var21 = var19;
                        var27 = var17.getFabPump();
                        var23 = this.cumulQte(var23, var29);
                     }
                  } else {
                     var23 = this.cumulQte(var23, var29);
                  }
               }
            }
         }
      }

      if (var3 != null) {
         if (var19 != 0.0D) {
            var3.setProdepPump(var19);
         } else {
            var3.setProdepPump(var21);
         }
      } else {
         var3 = null;
      }

      if (var14) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public float cumulQte(float var1, int var2) {
      var1 += ((Stock)this.lesMvt.get(var2)).getStk_qte_in() - ((Stock)this.lesMvt.get(var2)).getStk_qte_out();
      return var1;
   }

   public void recalculStockGlobal(String var1, String var2, String var3, Structure var4, Session var5) throws NamingException, ParseException {
      this.baseLog = var3;
      this.structureLog = var4;
      new ArrayList();
      List var6 = this.produitsDepotDao.produitDepByprodList(var1, var5);
      new ArrayList();
      List var7 = this.inventaireLigneDao.chargerLesMvts((String)null, var1, var5);
      this.lesMvt.clear();
      Date var8 = this.utilDate.stringToDateSQL("2000-01-01 00:00:00");
      boolean var9 = false;
      if (var2.equals("1")) {
         var9 = true;
      }

      this.chargerMouvements(1, "", (String)null, (String)null, (String)null, var1, 0L, "", "", var8, new Date(), false, true, true, true, false, false, false, true, true, true, true, false, var9, true, true, false, false, false, true, true, true, var2, this.baseLog, this.structureLog, var5);
      UtilTrie var10 = new UtilTrie();

      for(int var11 = 0; var11 < var6.size(); ++var11) {
         this.produitsDepot = (ProduitsDepot)var6.get(var11);
         String var12 = this.produitsDepot.getProduits().getProCode();
         float var13 = 0.0F;
         float var14 = 0.0F;
         float var15 = 0.0F;
         float var16 = 0.0F;
         float var17 = 0.0F;
         Date var18 = null;
         new InventaireLigne();

         for(int var20 = 0; var20 < var7.size(); ++var20) {
            InventaireLigne var19 = (InventaireLigne)var7.get(var20);
            if (var19.getInvligCode() != null && !var19.getInvligCode().isEmpty() && var19.getInvligCode().equals(var12) && (var18 == null || var19.getInventaireEntete().getInvDate().compareTo(var18) > 0)) {
               var17 = var19.getInvligQte();
               var18 = var19.getInventaireEntete().getInvDate();
            }
         }

         ArrayList var22 = new ArrayList();

         int var21;
         for(var21 = 0; var21 < this.lesMvt.size(); ++var21) {
            if (((Stock)this.lesMvt.get(var21)).getStk_code_produit() != null && !((Stock)this.lesMvt.get(var21)).getStk_code_produit().isEmpty() && ((Stock)this.lesMvt.get(var21)).getStk_code_produit().equals(var12)) {
               var22.add(this.lesMvt.get(var21));
            }
         }

         List var23 = var10.triListeDate(var22);
         var23 = var10.triListeDate(var23);
         var23 = var10.triListeDate(var23);
         var23 = var10.triListeDate(var23);

         for(var21 = 0; var21 < var23.size(); ++var21) {
            if ((var18 == null || ((Stock)var23.get(var21)).getStk_date_mvt().compareTo(var18) >= 0) && ((Stock)var23.get(var21)).getStk_type() != 10 && ((Stock)var23.get(var21)).getStk_type() != 11 && ((Stock)var23.get(var21)).getStk_type() != 12) {
               var17 += ((Stock)var23.get(var21)).getStk_qte_in() - ((Stock)var23.get(var21)).getStk_qte_out();
            }
         }

         this.produitsDepot.setProdepQteCmdAch(var13);
         this.produitsDepot.setProdepQteAttAch(var15);
         this.produitsDepot.setProdepQteCmdVte(var14);
         this.produitsDepot.setProdepQteAttVte(var16);
         this.produitsDepot.setProdepQteStk(var17);
         this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var5);
      }

   }

   public void razLesMvt() {
      this.lesMvt.clear();
   }

   public List chargerMouvements(int var1, String var2, String var3, String var4, String var5, String var6, long var7, String var9, String var10, Date var11, Date var12, boolean var13, boolean var14, boolean var15, boolean var16, boolean var17, boolean var18, boolean var19, boolean var20, boolean var21, boolean var22, boolean var23, boolean var24, boolean var25, boolean var26, boolean var27, boolean var28, boolean var29, boolean var30, boolean var31, boolean var32, boolean var33, String var34, String var35, Structure var36, Session var37) throws NamingException, ParseException {
      this.baseLog = var35;
      this.structureLog = var36;
      boolean var38 = false;
      if (var37 == null) {
         var37 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
         var38 = true;
      }

      this.utilDate = new UtilDate();
      String var39 = "";
      String var40 = "";
      String var41 = "";
      Date var44;
      if (var11 != null) {
         var39 = this.utilDate.dateToStringSQL(var11);
      } else {
         new ExercicesAchats();
         ExercicesAchatsDao var43 = new ExercicesAchatsDao(var35, this.utilInitHibernate);
         ExercicesAchats var42 = var43.recupererLastExo(var37);
         var44 = this.utilDate.stringToDateSQL(this.utilDate.dateToStringSQLLight(var42.getExeachDateDebut()) + " 00:00:00");
         var40 = this.utilDate.dateToStringSQL(var44);
         new ExercicesVentes();
         ExercicesVentesDao var46 = new ExercicesVentesDao(var35, this.utilInitHibernate);
         ExercicesVentes var45 = var46.recupererLastExo(var37);
         Date var47 = this.utilDate.stringToDateSQL(this.utilDate.dateToStringSQLLight(var45.getExevteDateDebut()) + " 00:00:00");
         var41 = this.utilDate.dateToStringSQL(var47);
      }

      Date var48 = this.utilDate.stringToDateSQL(this.utilDate.dateToStringSQLLight(var12) + " 23:59:59");
      String var49 = this.utilDate.dateToStringSQL(var48);
      var44 = null;
      if (var30) {
         if (var39 != null && !var39.isEmpty()) {
            this.mvtsStkPump(var44, var4, var6, var5, var7, var9, var10, var39, var49, var37);
         } else {
            this.mvtsStkPump(var44, var4, var6, var5, var7, var9, var10, var40, var49, var37);
         }
      } else {
         if (var19 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsStkInventaire(var44, var2, var4, var6, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsStkInventaire(var44, var2, var4, var6, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var20) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsStkBonEntree(var44, var2, var4, var6, var1, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsStkBonEntree(var44, var2, var4, var6, var1, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var21) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsStkBonSortie(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsStkBonSortie(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var22) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsStkCession(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsStkCession(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var23 && this.structureLog.getStrtypeentreprise() != null && !this.structureLog.getStrtypeentreprise().isEmpty() && this.structureLog.getStrtypeentreprise().equals("2")) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsStkFabrication(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsStkFabrication(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var13 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsAchCotation(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsAchCotation(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var14 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsAchCommande(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsAchCommande(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var15) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsAchReception(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsAchReception(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var16) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsAchRetour(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsAchRetour(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var17 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsAchFacture(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsAchFacture(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var18 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsAchAvoir(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsAchAvoir(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var40, var49, var37);
            }
         }

         if (var24 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteDevis(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteDevis(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }

         if (var25 && (var1 == 0 || var1 == 1 && var34.equals("1") || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteCommande(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var34, var39, var49, var37);
            } else {
               this.mvtsVteCommande(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var34, var41, var49, var37);
            }
         }

         if (var26 && (var1 == 0 || var1 == 1 && var34.equals("0") || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteLivraison(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var25, var37);
            } else {
               this.mvtsVteLivraison(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var25, var37);
            }
         }

         if (var33) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteTicket(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteTicket(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }

         if (var31) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteChargement(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteChargement(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }

         if (var27) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteRetour(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteRetour(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }

         if (var28 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteFacture(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteFacture(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }

         if (var29 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteAvoir(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteAvoir(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }

         if (var32 && (var1 == 0 || var1 == 2)) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteNoteDebit(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteNoteDebit(var44, var2, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }

         if (var15 || var26) {
            if (var39 != null && !var39.isEmpty()) {
               this.mvtsVteCadeaux(var44, var4, var6, var1, var3, var5, var7, var9, var10, var39, var49, var37);
            } else {
               this.mvtsVteCadeaux(var44, var4, var6, var1, var3, var5, var7, var9, var10, var41, var49, var37);
            }
         }
      }

      if (var38) {
         this.utilInitHibernate.closeSession();
      }

      return this.lesMvt;
   }

   public void mvtsStkPump(Object[] var1, String var2, String var3, String var4, long var5, String var7, String var8, String var9, String var10, Session var11) throws ParseException {
      new ArrayList();
      List var12 = this.pumpAchatsDao.chargerLesMvts(var2, var3, var9, var10, var11);
      if (var12.size() != 0) {
         new PumpAchats();

         for(int var14 = 0; var14 < var12.size(); ++var14) {
            Stock var15 = new Stock();
            PumpAchats var13 = (PumpAchats)var12.get(var14);
            var15.setStk_lib_type("Evol. PUMP");
            var15.setStk_type(30);
            if (var13.getPumNatureOrigine() == 13) {
               var15.setStk_etat("Réception");
            } else {
               var15.setStk_etat("");
            }

            var15.setStkOrigine(var13.getPumNatureOrigine());
            var15.setStk_code_depot(var13.getPumDepot());
            var15.setStk_code_produit(var13.getPumProduit());
            var15.setStk_code_generique(var4);
            var15.setStk_numero("" + var13.getPumNumDocOrigine());
            var15.setStk_serie("..");
            var15.setStk_tiers("");
            var15.setStk_divers("");
            var15.setStkDevise(this.structureLog.getStrdevise());
            var15.setStk_devise(0.0F);
            var15.setStk_activite("");
            var15.setStk_dossier(var13.getPumDossier());
            var15.setStk_date_mvt(var13.getPumDate());
            var15.setStk_pa(var13.getPumPr());
            var15.setStk_prKg(var13.getPumPrKg());
            var15.setStk_pump(var13.getPumPump());
            var15.setStk_pv(var13.getPumPr());
            var15.setStk_qte_in(var13.getPumQteOperation());
            var15.setStk_qte_out(var13.getPumQteStock());
            this.lesMvt.add(var15);
         }
      }

   }

   public void mvtsStkInventaire(Object[] var1, String var2, String var3, String var4, String var5, long var6, String var8, String var9, String var10, String var11, Session var12) throws ParseException {
      new ArrayList();
      List var13 = this.inventaireLigneDao.chargerLesMvts(var2, var3, var4, var6, var8, var9, var10, var11, var12);
      if (var13.size() != 0) {
         for(int var14 = 0; var14 < var13.size(); ++var14) {
            Stock var15 = new Stock();
            var1 = (Object[])((Object[])var13.get(var14));
            this.calculeLigneStock(var1);
            var15.setStk_lib_type("Inventaire");
            var15.setStk_id(this.idDoc);
            var15.setStk_type(30);
            if (this.etat == 0) {
               var15.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var15.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var15.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var15.setStk_etat("Annulé");
            } else {
               var15.setStk_etat("????");
            }

            var15.setStk_code_depot(this.nomDepot);
            var15.setStk_code_produit(this.code);
            var15.setStk_code_generique(var5);
            var15.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var16 = this.nomFamille.split(":");
                  var15.setStkFamille(var16[0]);
               } else {
                  var15.setStkFamille(this.nomFamille);
               }
            } else {
               var15.setStkFamille("");
            }

            var15.setStk_numero(this.num);
            var15.setStk_serie(this.ser);
            var15.setStk_tiers("Inventaire");
            var15.setStk_divers("");
            var15.setStk_activite("");
            var15.setStk_dossier("");
            var15.setStk_date_mvt(this.date);
            var15.setStk_pa(0.0D);
            var15.setStkDevise(this.structureLog.getStrdevise());
            var15.setStk_format_devise(this.utilNombre.formatDevise(var15.getStkDevise()));
            var15.setStk_devise(0.0F);
            var15.setStk_pv(0.0D);
            var15.setStk_pump(this.pumpLig);
            var15.setStk_qte_in(this.qteUtilLig);
            var15.setStk_qte_out(0.0F);
            var15.setStk_Obs(this.obs);
            this.lesMvt.add(var15);
         }
      }

   }

   public void mvtsStkBonEntree(Object[] var1, String var2, String var3, String var4, int var5, String var6, long var7, String var9, String var10, String var11, String var12, Session var13) throws ParseException {
      new ArrayList();
      List var14 = this.bonEntreeLigneDao.chargerLesMvts(var2, var3, var4, var7, var9, var10, var11, var12, var13);
      if (var14.size() != 0) {
         for(int var15 = 0; var15 < var14.size(); ++var15) {
            Stock var16 = new Stock();
            var1 = (Object[])((Object[])var14.get(var15));
            this.calculeLigneStock(var1);
            if (this.etat == 0) {
               var16.setStk_lib_type("(EC) Bon entrée");
            } else {
               var16.setStk_lib_type("Bon entrée");
            }

            var16.setStk_id(this.idDoc);
            var16.setStk_type(31);
            if (this.etat == 0) {
               var16.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var16.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var16.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var16.setStk_etat("Annulé");
            } else {
               var16.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && this.etat == 1 || var5 == 3 && (this.etat == 0 || this.etat == 1)) {
               var16.setStk_code_depot(this.nomDepot);
               var16.setStk_code_produit(this.code);
               var16.setStk_code_generique(var6);
               var16.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var17 = this.nomFamille.split(":");
                     var16.setStkFamille(var17[0]);
                  } else {
                     var16.setStkFamille(this.nomFamille);
                  }
               } else {
                  var16.setStkFamille("");
               }

               var16.setStk_numero(this.num);
               var16.setStk_serie(this.ser);
               var16.setStk_tiers(this.nomDivers);
               var16.setStk_equipe(this.idEquipe);
               var16.setStk_divers("");
               var16.setStk_activite("");
               var16.setStk_dossier("");
               var16.setStk_date_mvt(this.date);
               var16.setStk_pa(0.0D);
               var16.setStkDevise(this.structureLog.getStrdevise());
               var16.setStk_format_devise(this.utilNombre.formatDevise(var16.getStkDevise()));
               var16.setStk_devise(0.0F);
               var16.setStk_pv(0.0D);
               var16.setStk_pump(this.pumpLig);
               var16.setStk_qte_in(this.qteUtilLig);
               var16.setStk_qte_out(0.0F);
               var16.setStk_Obs(this.obs);
               this.lesMvt.add(var16);
            }
         }
      }

   }

   public void mvtsStkBonSortie(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.bonSortieLigneDao.chargerLesMvts(var2, var3, var4, var8, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneStock(var1);
            if (this.etat == 0) {
               var17.setStk_lib_type("(EC) Bon sortie");
            } else {
               var17.setStk_lib_type("Bon sortie");
            }

            var17.setStk_id(this.idDoc);
            var17.setStk_type(32);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else {
               var17.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && this.etat == 1 || var5 == 3 && (this.etat == 0 || this.etat == 1)) {
               var17.setStk_code_depot(this.nomDepot);
               var17.setStk_code_produit(this.code);
               var17.setStk_code_generique(var7);
               var17.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var18 = this.nomFamille.split(":");
                     var17.setStkFamille(var18[0]);
                  } else {
                     var17.setStkFamille(this.nomFamille);
                  }
               } else {
                  var17.setStkFamille("");
               }

               var17.setStk_numero(this.num);
               var17.setStk_serie(this.ser);
               var17.setStk_tiers(this.nomDivers);
               var17.setStk_equipe(this.idEquipe);
               var17.setStk_divers("");
               var17.setStk_activite("");
               var17.setStk_dossier("");
               var17.setStk_date_mvt(this.date);
               var17.setStk_pa(0.0D);
               var17.setStkDevise(this.structureLog.getStrdevise());
               var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
               var17.setStk_devise(0.0F);
               var17.setStk_pv(0.0D);
               var17.setStk_pump(this.pumpLig);
               var17.setStk_qte_in(0.0F);
               var17.setStk_qte_out(this.qteUtilLig);
               var17.setStk_Obs(this.obs);
               this.lesMvt.add(var17);
            }
         }
      }

      if (var6 == null || var6.equals("0104") || var6.equals("0105") || var6.equals("1604") || var6.equals("1605")) {
         new ArrayList();
         List var19 = this.parcConsommationDao.chargerLesMvts(var2, var3, var4, 0L, var10, var11, var12, var13, var14);
         if (var19.size() != 0) {
            for(int var20 = 0; var20 < var19.size(); ++var20) {
               Stock var21 = new Stock();
               var1 = (Object[])((Object[])var19.get(var20));
               this.calculeLigneStock(var1);
               if (this.typeChg == 0) {
                  if (this.etat == 0) {
                     var21.setStk_lib_type("(EC) Carburant");
                  } else {
                     var21.setStk_lib_type("Carburant");
                  }
               } else if (this.typeChg == 1) {
                  if (this.etat == 0) {
                     var21.setStk_lib_type("(EC) Lubrifiant");
                  } else {
                     var21.setStk_lib_type("Lubrifiant");
                  }
               }

               var21.setStk_id(this.idDoc);
               var21.setStk_type(32);
               if (this.etat == 0) {
                  var21.setStk_etat("Demande");
               } else if (this.etat == 1) {
                  var21.setStk_etat("Validé");
               } else if (this.etat == 2) {
                  var21.setStk_etat("Gelé");
               } else if (this.etat == 3) {
                  var21.setStk_etat("Annulé");
               } else {
                  var21.setStk_etat("????");
               }

               if (var5 == 0 || var5 == 2 || var5 == 1 && this.etat == 1 || var5 == 3 && (this.etat == 0 || this.etat == 1)) {
                  var21.setStk_code_depot(this.nomDepot);
                  var21.setStk_code_produit(this.code);
                  var21.setStk_code_generique(var7);
                  var21.setStkLibelle(this.libelle);
                  var21.setStkFamille("");
                  var21.setStk_numero(this.num);
                  var21.setStk_serie(this.ser);
                  var21.setStk_tiers(this.nomDivers);
                  var21.setStk_equipe(0L);
                  var21.setStk_divers("");
                  var21.setStk_activite("");
                  var21.setStk_dossier("");
                  var21.setStk_date_mvt(this.date);
                  var21.setStk_pa(0.0D);
                  var21.setStkDevise(this.structureLog.getStrdevise());
                  var21.setStk_format_devise(this.utilNombre.formatDevise(var21.getStkDevise()));
                  var21.setStk_devise(0.0F);
                  var21.setStk_pv(0.0D);
                  var21.setStk_pump(this.pumpLig);
                  var21.setStk_qte_in(0.0F);
                  var21.setStk_qte_out(this.qteUtilLig);
                  var21.setStk_Obs(this.obs);
                  this.lesMvt.add(var21);
               }
            }
         }
      }

   }

   public void mvtsStkCession(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.cessionLigneDao.chargerLesMvtsOrigine(var2, var3, var4, var8, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneStock(var1);
            if (this.etat == 0) {
               var17.setStk_lib_type("(EC) Cession sortie");
            } else {
               var17.setStk_lib_type("Cession sortie");
            }

            var17.setStk_id(this.idDoc);
            var17.setStk_type(33);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else {
               var17.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
               var17.setStk_code_depot(this.nomDepot);
               var17.setStk_code_produit(this.code);
               var17.setStk_code_generique(var7);
               var17.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var18 = this.nomFamille.split(":");
                     var17.setStkFamille(var18[0]);
                  } else {
                     var17.setStkFamille(this.nomFamille);
                  }
               } else {
                  var17.setStkFamille("");
               }

               var17.setStk_numero(this.num);
               var17.setStk_serie(this.ser);
               var17.setStk_tiers("Cession sortie");
               var17.setStk_equipe(this.idEquipe);
               var17.setStk_divers("");
               var17.setStk_activite("");
               var17.setStk_dossier("");
               var17.setStk_date_mvt(this.date);
               var17.setStk_pa(0.0D);
               var17.setStkDevise(this.structureLog.getStrdevise());
               var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
               var17.setStk_devise(0.0F);
               var17.setStk_pv(0.0D);
               var17.setStk_pump(this.pumpLig);
               var17.setStk_qte_in(0.0F);
               var17.setStk_qte_out(this.qteUtilLig);
               var17.setStk_Obs(this.obs);
               this.lesMvt.add(var17);
            }
         }
      }

      new ArrayList();
      List var20 = this.cessionLigneDestDao.chargerLesMvtsDestination(var2, var3, var4, var8, var10, var11, var12, var13, var14);
      if (var20.size() != 0) {
         for(int var21 = 0; var21 < var20.size(); ++var21) {
            Stock var22 = new Stock();
            var1 = (Object[])((Object[])var20.get(var21));
            this.calculeLigneStock(var1);
            if (this.etat == 0) {
               var22.setStk_lib_type("(EC) Cession entrée");
            } else {
               var22.setStk_lib_type("Cession entrée");
            }

            var22.setStk_id(this.idDoc);
            var22.setStk_type(33);
            if (this.etat == 0) {
               var22.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var22.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var22.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var22.setStk_etat("Annulé");
            } else {
               var22.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
               var22.setStk_code_depot(this.nomDepot);
               var22.setStk_code_produit(this.code);
               var22.setStk_code_generique(var7);
               var22.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var19 = this.nomFamille.split(":");
                     var22.setStkFamille(var19[0]);
                  } else {
                     var22.setStkFamille(this.nomFamille);
                  }
               } else {
                  var22.setStkFamille("");
               }

               var22.setStk_numero(this.num);
               var22.setStk_serie(this.ser);
               var22.setStk_equipe(this.idEquipe);
               var22.setStk_tiers("Cession entrée");
               var22.setStk_divers("");
               var22.setStk_activite("");
               var22.setStk_dossier("");
               var22.setStk_date_mvt(this.date);
               var22.setStk_pa(0.0D);
               var22.setStkDevise(this.structureLog.getStrdevise());
               var22.setStk_format_devise(this.utilNombre.formatDevise(var22.getStkDevise()));
               var22.setStk_devise(0.0F);
               var22.setStk_pv(0.0D);
               var22.setStk_pump(this.pumpLig);
               var22.setStk_qte_in(this.qteUtilLig);
               var22.setStk_qte_out(0.0F);
               var22.setStk_Obs(this.obs);
               this.lesMvt.add(var22);
            }
         }
      }

   }

   public void mvtsStkFabrication(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.fabricationEnteteAchatsDao.chargerLesMvts(var2, var3, var4, var8, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         new FabricationEnteteAchats();

         for(int var17 = 0; var17 < var15.size(); ++var17) {
            FabricationEnteteAchats var16 = (FabricationEnteteAchats)var15.get(var17);
            if (var16.getFabOption2() == 0) {
               Stock var18 = new Stock();
               if (var16.getFabEtat() == 0) {
                  var18.setStk_lib_type("(EC) Fab. Produit");
               } else {
                  var18.setStk_lib_type("Fab. Produit");
               }

               var18.setStk_id(var16.getFabId());
               var18.setStk_type(34);
               if (var16.getFabEtat() == 0) {
                  var18.setStk_etat("En cours");
               } else if (var16.getFabEtat() == 1) {
                  var18.setStk_etat("Validé");
               } else if (var16.getFabEtat() == 2) {
                  var18.setStk_etat("Gelé");
               } else if (var16.getFabEtat() == 3) {
                  var18.setStk_etat("Annulé");
               } else {
                  var18.setStk_etat("????");
               }

               if (var5 == 0 || var5 == 2 || var5 == 1 && var16.getFabEtat() == 1 || var5 == 3 && (var16.getFabEtat() == 0 || var16.getFabEtat() == 1)) {
                  var18.setStk_code_depot(var16.getFabDepot());
                  var18.setStk_code_produit(var16.getFabProcess());
                  var18.setStk_code_generique(var7);
                  var18.setStkLibelle(var16.getFabLibClient());
                  if (var16.getFabFamille() != null && !var16.getFabFamille().isEmpty()) {
                     if (var16.getFabFamille().contains(":")) {
                        String[] var19 = var16.getFabFamille().split(":");
                        var18.setStkFamille(var19[0]);
                     } else {
                        var18.setStkFamille(var16.getFabFamille());
                     }
                  } else {
                     var18.setStkFamille("");
                  }

                  var18.setStk_numero(var16.getFabNum());
                  var18.setStk_serie(var16.getFabSerie());
                  var18.setStk_tiers("Fabrication");
                  var18.setStk_equipe(0L);
                  var18.setStk_divers("");
                  var18.setStk_activite("");
                  var18.setStk_dossier("");
                  var18.setStk_date_mvt(var16.getFabDate());
                  var18.setStk_pa(0.0D);
                  var18.setStkDevise(this.structureLog.getStrdevise());
                  var18.setStk_format_devise(this.utilNombre.formatDevise(var18.getStkDevise()));
                  var18.setStk_devise(0.0F);
                  var18.setStk_pv(0.0D);
                  var18.setStk_pump(var16.getFabTotPump());
                  var18.setStk_qte_in(var16.getFabQteUtil());
                  var18.setStk_qte_out(0.0F);
                  this.lesMvt.add(var18);
               }
            }
         }
      }

      new ArrayList();
      List var21 = this.fabricationLigneAchatsDao.chargerLesMvts(var2, var3, var4, var8, var10, var11, var12, var13, var14);
      if (var21.size() != 0) {
         new FabricationLigneAchats();

         for(int var23 = 0; var23 < var21.size(); ++var23) {
            FabricationLigneAchats var22 = (FabricationLigneAchats)var21.get(var23);
            Stock var24 = new Stock();
            if (var22.getFabligType() == 1) {
               if (var22.getFabricationEnteteAchats().getFabEtat() == 0) {
                  var24.setStk_lib_type("(EC) Fab. Intrant");
               } else {
                  var24.setStk_lib_type("Fab. Intrant");
               }
            } else if (var22.getFabligType() == 2) {
               if (var22.getFabricationEnteteAchats().getFabEtat() == 0) {
                  var24.setStk_lib_type("(EC) Fab. SousProduit");
               } else {
                  var24.setStk_lib_type("Fab. SousProduit");
               }
            } else if (var22.getFabligType() == 3) {
               if (var22.getFabricationEnteteAchats().getFabEtat() == 0) {
                  var24.setStk_lib_type("(EC) Fab. Déchets");
               } else {
                  var24.setStk_lib_type("Fab. Déchets");
               }
            } else if (var22.getFabligType() == 5) {
               if (var22.getFabricationEnteteAchats().getFabEtat() == 0) {
                  var24.setStk_lib_type("(EC) Fab. Générés");
               } else {
                  var24.setStk_lib_type("Fab. Générés");
               }
            }

            var24.setStk_id(var22.getFabligId());
            var24.setStk_type(34);
            if (var22.getFabricationEnteteAchats().getFabEtat() == 0) {
               var24.setStk_etat("En cours");
            } else if (var22.getFabricationEnteteAchats().getFabEtat() == 1) {
               var24.setStk_etat("Validé");
            } else if (var22.getFabricationEnteteAchats().getFabEtat() == 2) {
               var24.setStk_etat("Gelé");
            } else if (var22.getFabricationEnteteAchats().getFabEtat() == 3) {
               var24.setStk_etat("Annulé");
            } else {
               var24.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && (var22.getFabricationEnteteAchats().getFabEtat() == 1 || var22.getFabricationEnteteAchats().getFabEtat() == 2 || var22.getFabricationEnteteAchats().getFabEtat() == 3 || var22.getFabricationEnteteAchats().getFabEtat() == 5) || var5 == 3 && (var22.getFabricationEnteteAchats().getFabEtat() == 0 || var22.getFabricationEnteteAchats().getFabEtat() == 1 || var22.getFabricationEnteteAchats().getFabEtat() == 2 || var22.getFabricationEnteteAchats().getFabEtat() == 3 || var22.getFabricationEnteteAchats().getFabEtat() == 5)) {
               var24.setStk_code_depot(var22.getFabligDepot());
               var24.setStk_code_produit(var22.getFabligCode());
               var24.setStk_code_generique(var7);
               var24.setStkLibelle(var22.getFabligLibelle());
               if (var22.getFabligFamille() != null && !var22.getFabligFamille().isEmpty()) {
                  if (var22.getFabligFamille().contains(":")) {
                     String[] var20 = var22.getFabligFamille().split(":");
                     var24.setStkFamille(var20[0]);
                  } else {
                     var24.setStkFamille(var22.getFabligFamille());
                  }
               } else {
                  var24.setStkFamille("");
               }

               var24.setStk_numero(var22.getFabricationEnteteAchats().getFabNum());
               var24.setStk_serie(var22.getFabricationEnteteAchats().getFabSerie());
               var24.setStk_tiers("Fabrication");
               var24.setStk_equipe(0L);
               var24.setStk_divers("");
               var24.setStk_activite("");
               var24.setStk_dossier("");
               var24.setStk_date_mvt(var22.getFabricationEnteteAchats().getFabDate());
               var24.setStk_pa(0.0D);
               var24.setStkDevise(this.structureLog.getStrdevise());
               var24.setStk_format_devise(this.utilNombre.formatDevise(var24.getStkDevise()));
               var24.setStk_devise(0.0F);
               var24.setStk_pv(0.0D);
               var24.setStk_pump(var22.getFabligPump());
               if (var22.getFabligType() == 1) {
                  var24.setStk_qte_in(0.0F);
                  var24.setStk_qte_out(var22.getFabligQteUtil());
               } else if (var22.getFabligType() == 2) {
                  var24.setStk_qte_in(var22.getFabligQteUtil());
                  var24.setStk_qte_out(0.0F);
               } else if (var22.getFabligType() == 3) {
                  var24.setStk_qte_in(var22.getFabligQteUtil());
                  var24.setStk_qte_out(0.0F);
               } else if (var22.getFabligType() == 5) {
                  var24.setStk_qte_in(var22.getFabligQteUtil());
                  var24.setStk_qte_out(0.0F);
               }

               this.lesMvt.add(var24);
            }
         }
      }

   }

   public void mvtsAchCotation(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.cotationLigneAchatsDao.chargerLesMvts(var2, var3, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneAchat(var1);
            var17.setStk_lib_type("F.Cotation");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(11);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            var17.setStk_code_depot("");
            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie(this.ser);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var17.setStk_divers("FD");
               var17.setStk_tiers(this.nomDivers);
            } else {
               var17.setStk_divers("FO");
               var17.setStk_tiers(this.nomTiers);
            }

            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.devise);
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_devise(0.0F);
            var17.setStk_pv(0.0D);
            var17.setStk_pump(this.pumpLig);
            var17.setStk_qte_in(this.qteUtilLig);
            var17.setStk_qte_out(0.0F);
            var17.setStk_Obs(this.obs);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsAchCommande(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.commandeLigneAchatsDao.chargerLesMvts(var2, var3, var10, var11, var4, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneAchat(var1);
            var17.setStk_lib_type("F.Commande");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(12);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && this.etat == 0) {
               var17.setStk_code_depot("");
               var17.setStk_code_produit(this.code);
               var17.setStk_code_generique(var7);
               var17.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var18 = this.nomFamille.split(":");
                     var17.setStkFamille(var18[0]);
                  } else {
                     var17.setStkFamille(this.nomFamille);
                  }
               } else {
                  var17.setStkFamille("");
               }

               var17.setStk_numero(this.num);
               var17.setStk_serie(this.ser);
               if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                  var17.setStk_divers("FD");
                  var17.setStk_tiers(this.nomDivers);
               } else {
                  var17.setStk_divers("FO");
                  var17.setStk_tiers(this.nomTiers);
               }

               var17.setStk_activite("");
               var17.setStk_dossier("");
               var17.setStk_date_mvt(this.date);
               var17.setStk_pa(0.0D);
               var17.setStkDevise(this.devise);
               var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
               var17.setStk_devise(0.0F);
               var17.setStk_pv(0.0D);
               var17.setStk_pump(this.pumpLig);
               var17.setStk_coefPr(this.coefPr);
               var17.setStk_qte_in(this.qteUtilLig);
               var17.setStk_qte_out(0.0F);
               var17.setStk_Obs(this.obs);
               this.lesMvt.add(var17);
            }
         }
      }

   }

   public void mvtsAchReception(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.receptionLigneAchatsDao.chargerLesMvts(var2, var3, var4, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneAchat(var1);
            if (this.etat == 0) {
               var17.setStk_lib_type("(EC) F.Réception");
            } else {
               var17.setStk_lib_type("F.Réception");
            }

            var17.setStk_id(this.idDoc);
            var17.setStk_type(13);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
               var17.setStk_code_depot(this.nomDepot);
               var17.setStk_code_produit(this.code);
               var17.setStk_code_generique(var7);
               var17.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var18 = this.nomFamille.split(":");
                     var17.setStkFamille(var18[0]);
                  } else {
                     var17.setStkFamille(this.nomFamille);
                  }
               } else {
                  var17.setStkFamille("");
               }

               var17.setStk_numero(this.num);
               var17.setStk_serie(this.ser);
               if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                  var17.setStk_divers("FD");
                  var17.setStk_tiers(this.nomDivers);
               } else {
                  var17.setStk_divers("FO");
                  var17.setStk_tiers(this.nomTiers);
               }

               var17.setStk_activite("");
               var17.setStk_dossier(this.dossier);
               var17.setStk_date_mvt(this.date);
               var17.setStk_pa(this.prLig);
               var17.setStkDevise(this.devise);
               var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
               var17.setStk_devise(this.coefDevise);
               var17.setStk_pv(0.0D);
               var17.setStk_pump(this.pumpLig);
               var17.setStk_coefPr(this.coefPr);
               var17.setStk_prKg(this.prKgrLig);
               var17.setStk_qte_in(this.qteUtilLig);
               var17.setStk_qte_out(0.0F);
               var17.setStk_Obs(this.obs);
               this.lesMvt.add(var17);
            }
         }
      }

   }

   public void mvtsAchRetour(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.retourLigneAchatsDao.chargerLesMvts(var2, var3, var4, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneAchat(var1);
            if (this.etat == 0) {
               var17.setStk_lib_type("(EC) F.Retour");
            } else {
               var17.setStk_lib_type("F.Retour");
            }

            var17.setStk_id(this.idDoc);
            var17.setStk_type(14);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
               var17.setStk_code_depot(this.nomDepot);
               var17.setStk_code_produit(this.code);
               var17.setStk_code_generique(var7);
               var17.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var18 = this.nomFamille.split(":");
                     var17.setStkFamille(var18[0]);
                  } else {
                     var17.setStkFamille(this.nomFamille);
                  }
               } else {
                  var17.setStkFamille("");
               }

               var17.setStk_numero(this.num);
               var17.setStk_serie(this.ser);
               if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                  var17.setStk_divers("FD");
                  var17.setStk_tiers(this.nomDivers);
               } else {
                  var17.setStk_divers("FO");
                  var17.setStk_tiers(this.nomTiers);
               }

               var17.setStk_activite("");
               var17.setStk_dossier("");
               var17.setStk_date_mvt(this.date);
               var17.setStk_pa(0.0D);
               var17.setStkDevise(this.devise);
               var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
               var17.setStk_devise(0.0F);
               var17.setStk_pv(0.0D);
               var17.setStk_pump(this.pumpLig);
               var17.setStk_coefPr(0.0F);
               var17.setStk_qte_in(0.0F);
               var17.setStk_qte_out(this.qteUtilLig);
               this.lesMvt.add(var17);
            }
         }
      }

   }

   public void mvtsAchFacture(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.factureLigneAchatsDao.chargerLesMvts(var2, var3, var10, var11, var12, var13, "", var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneAchat(var1);
            var17.setStk_lib_type("F.Facture");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(15);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            var17.setStk_code_depot("");
            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie(this.ser);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var17.setStk_divers("FD");
               var17.setStk_tiers(this.nomDivers);
            } else {
               var17.setStk_divers("FO");
               var17.setStk_tiers(this.nomTiers);
            }

            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.devise);
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_pv(0.0D);
            var17.setStk_pump(this.pumpLig);
            var17.setStk_coefPr(0.0F);
            var17.setStk_qte_in(this.qteUtilLig);
            var17.setStk_qte_out(0.0F);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsAchAvoir(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException, HibernateException, NamingException {
      new ArrayList();
      List var15 = this.avoirLigneAchatsDao.chargerLesMvts(var2, var3, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneAchat(var1);
            var17.setStk_lib_type("F.Avoir");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(16);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            var17.setStk_code_depot("");
            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie(this.ser);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var17.setStk_divers("FD");
               var17.setStk_tiers(this.nomDivers);
            } else {
               var17.setStk_divers("FO");
               var17.setStk_tiers(this.nomTiers);
            }

            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.devise);
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_devise(0.0F);
            var17.setStk_pv(0.0D);
            var17.setStk_pump(this.pumpLig);
            var17.setStk_coefPr(0.0F);
            var17.setStk_qte_in(0.0F);
            var17.setStk_qte_out(this.qteUtilLig);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsVteDevis(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.devisLigneVentesDao.chargerLesMvts(var2, var3, var8, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneVente(var1);
            var17.setStk_lib_type("C.Devis");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(21);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            var17.setStk_code_depot("");
            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie(this.ser);
            var17.setStk_equipe(this.idEquipe);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var17.setStk_divers("CD");
               var17.setStk_tiers(this.nomDivers);
            } else {
               var17.setStk_divers("CL");
               var17.setStk_tiers(this.nomTiers);
            }

            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.devise);
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_devise(1.0F);
            if (this.qteUtilLig != this.qteLig) {
               double var20 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var17.getStkDevise());
               var17.setStk_pv(var20);
            } else {
               var17.setStk_pv(this.puLig);
            }

            var17.setStk_pump(this.pumpLig);
            var17.setStk_qte_in(0.0F);
            var17.setStk_qte_out(this.qteUtilLig);
            var17.setStk_qte(this.qteLig);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsVteCommande(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, String var14, Session var15) throws ParseException {
      new ArrayList();
      List var16 = this.commandeLigneVentesDao.chargerLesMvts(var2, var3, var4, var8, var10, var11, var13, var14, var15);
      if (var16.size() != 0) {
         for(int var17 = 0; var17 < var16.size(); ++var17) {
            Stock var18 = new Stock();
            var1 = (Object[])((Object[])var16.get(var17));
            this.calculeLigneDirecteVente(var1);
            var18.setStk_lib_type("C.Commande");
            var18.setStk_id(this.idDoc);
            var18.setStk_type(22);
            if (this.etat == 0) {
               var18.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var18.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var18.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var18.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var18.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var18.setStk_etat("Trf total");
            } else {
               var18.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && this.etat == 0 || var5 == 1 && var12.equals("1") && (this.etat == 1 || this.etat == 4 || this.etat == 5) || (var5 == 1 || var5 == 3) && (this.etat == 0 || this.etat == 1)) {
               if (this.stockDirect == 1) {
                  var18.setStk_code_depot(this.nomDepot);
               } else {
                  var18.setStk_code_depot(this.nomDepot + " (SS)");
               }

               var18.setStk_code_produit(this.code);
               var18.setStk_code_generique(var7);
               var18.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var19 = this.nomFamille.split(":");
                     var18.setStkFamille(var19[0]);
                  } else {
                     var18.setStkFamille(this.nomFamille);
                  }
               } else {
                  var18.setStkFamille("");
               }

               var18.setStk_numero(this.num);
               var18.setStk_serie(this.ser);
               var18.setStk_equipe(this.idEquipe);
               if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                  var18.setStk_divers("CD");
                  var18.setStk_tiers(this.nomDivers);
               } else {
                  var18.setStk_divers("CL");
                  var18.setStk_tiers(this.nomTiers);
               }

               var18.setStk_activite("");
               var18.setStk_dossier("");
               var18.setStk_date_mvt(this.date);
               var18.setStk_pa(0.0D);
               var18.setStkDevise(this.devise);
               var18.setStk_format_devise(this.utilNombre.formatDevise(var18.getStkDevise()));
               var18.setStk_devise(1.0F);
               if (this.qteUtilLig != this.qteLig) {
                  double var21 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var18.getStkDevise());
                  var18.setStk_pv(var21);
               } else {
                  var18.setStk_pv(this.puLig);
               }

               var18.setStk_pump(this.pumpLig);
               var18.setStk_qte_in(0.0F);
               var18.setStk_qte_out(this.qteUtilLig);
               var18.setStk_qte(this.qteLig);
               this.lesMvt.add(var18);
            }
         }
      }

   }

   public void mvtsVteLivraison(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, boolean var14, Session var15) throws ParseException {
      List var16;
      int var17;
      Stock var18;
      String[] var19;
      if (var5 == 0 || var5 == 2 || var5 == 1) {
         new ArrayList();
         var16 = this.livraisonLigneVentesDao.chargerLesLivraisonsDirectes(var2, var3, var4, var8, var10, var11, var12, var13, "", var15);
         if (var16.size() != 0) {
            for(var17 = 0; var17 < var16.size(); ++var17) {
               var18 = new Stock();
               var1 = (Object[])((Object[])var16.get(var17));
               this.calculeLigneVente(var1);
               if (this.etat <= 5) {
                  if (this.etat == 0) {
                     var18.setStk_lib_type("(EC) C.Livraison");
                  } else {
                     var18.setStk_lib_type("C.Livraison");
                  }

                  var18.setStk_id(this.idDoc);
                  var18.setStk_type(23);
                  if (this.etat == 0) {
                     var18.setStk_etat("En cours");
                  } else if (this.etat == 1) {
                     var18.setStk_etat("Validé");
                  } else if (this.etat == 2) {
                     var18.setStk_etat("Gelé");
                  } else if (this.etat == 3) {
                     var18.setStk_etat("Annulé");
                  } else if (this.etat == 4) {
                     var18.setStk_etat("Trf partiel");
                  } else if (this.etat == 5) {
                     var18.setStk_etat("Trf total");
                  } else {
                     var18.setStk_etat("????");
                  }

                  if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
                     var18.setStk_code_depot(this.nomDepot);
                     var18.setStk_code_produit(this.code);
                     var18.setStk_code_generique(var7);
                     var18.setStkLibelle(this.libelle);
                     if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                        if (this.nomFamille.contains(":")) {
                           var19 = this.nomFamille.split(":");
                           var18.setStkFamille(var19[0]);
                        } else {
                           var18.setStkFamille(this.nomFamille);
                        }
                     } else {
                        var18.setStkFamille("");
                     }

                     var18.setStk_numero(this.num);
                     var18.setStk_serie(this.ser);
                     var18.setStk_equipe(this.idEquipe);
                     if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                        var18.setStk_divers("CD");
                        var18.setStk_tiers(this.nomDivers);
                     } else {
                        var18.setStk_divers("CL");
                        var18.setStk_tiers(this.nomTiers);
                     }

                     var18.setStk_activite("");
                     var18.setStk_dossier("");
                     var18.setStk_date_mvt(this.date);
                     var18.setStk_pa(0.0D);
                     var18.setStkDevise(this.devise);
                     var18.setStk_format_devise(this.utilNombre.formatDevise(var18.getStkDevise()));
                     var18.setStk_devise(1.0F);
                     var18.setStk_pv(this.puLig);
                     var18.setStk_pump(this.pumpLig);
                     var18.setStk_qte_in(0.0F);
                     var18.setStk_qte_out(this.qteUtilLig);
                     var18.setStk_qte(this.qteLig);
                     this.lesMvt.add(var18);
                  }
               }
            }
         }
      }

      double var21;
      if (var14) {
         new ArrayList();
         var16 = this.commandeLigneVentesDao.chargerLesCommandesDirectes(var2, var3, var4, var8, var10, var11, var12, var13, var15);
         if (var16.size() != 0) {
            for(var17 = 0; var17 < var16.size(); ++var17) {
               var18 = new Stock();
               var1 = (Object[])((Object[])var16.get(var17));
               this.calculeLigneDirecteVente(var1);
               if (this.etat <= 5) {
                  if (this.etat == 0) {
                     var18.setStk_lib_type("(EC) C.CMD Directe");
                  } else {
                     var18.setStk_lib_type("C.CMD Directe");
                  }

                  var18.setStk_id(this.idDoc);
                  var18.setStk_type(22);
                  if (this.etat == 0) {
                     var18.setStk_etat("En cours");
                  } else if (this.etat == 1) {
                     var18.setStk_etat("Validé");
                  } else if (this.etat == 2) {
                     var18.setStk_etat("Gelé");
                  } else if (this.etat == 3) {
                     var18.setStk_etat("Annulé");
                  } else if (this.etat == 4) {
                     var18.setStk_etat("Trf partiel");
                  } else if (this.etat == 5) {
                     var18.setStk_etat("Trf total");
                  } else {
                     var18.setStk_etat("????");
                  }

                  if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
                     if (this.stockDirect == 1) {
                        var18.setStk_code_depot(this.nomDepot);
                     } else {
                        var18.setStk_code_depot(this.nomDepot + " (SS)");
                     }

                     var18.setStk_code_produit(this.code);
                     var18.setStk_code_generique(var7);
                     var18.setStkLibelle(this.libelle);
                     if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                        if (this.nomFamille.contains(":")) {
                           var19 = this.nomFamille.split(":");
                           var18.setStkFamille(var19[0]);
                        } else {
                           var18.setStkFamille(this.nomFamille);
                        }
                     } else {
                        var18.setStkFamille("");
                     }

                     var18.setStk_numero(this.num);
                     var18.setStk_serie(this.ser);
                     var18.setStk_equipe(this.idEquipe);
                     if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                        var18.setStk_divers("CD");
                        var18.setStk_tiers(this.nomDivers);
                     } else {
                        var18.setStk_divers("CL");
                        var18.setStk_tiers(this.nomTiers);
                     }

                     var18.setStk_activite("");
                     var18.setStk_dossier("");
                     var18.setStk_date_mvt(this.date);
                     var18.setStk_pa(0.0D);
                     var18.setStkDevise(this.devise);
                     var18.setStk_format_devise(this.utilNombre.formatDevise(var18.getStkDevise()));
                     var18.setStk_devise(1.0F);
                     if (this.qteUtilLig != this.qteLig) {
                        var21 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var18.getStkDevise());
                        var18.setStk_pv(var21);
                     } else {
                        var18.setStk_pv(this.puLig);
                     }

                     var18.setStk_pump(this.pumpLig);
                     var18.setStk_qte_in(0.0F);
                     var18.setStk_qte_out(this.qteUtilLig);
                     var18.setStk_qte(this.qteLig);
                     this.lesMvt.add(var18);
                  }
               }
            }
         }
      }

      if (var6 == null || var6.equals("1105")) {
         if (var5 == 0 || var5 == 2 || var5 == 1 || var5 == 3) {
            new ArrayList();
            var16 = this.pharmacieLigneDao.chargerLesMvts(var2, var3, var4, var10, var11, var12, var13, "", var15);
            if (var16.size() != 0) {
               for(var17 = 0; var17 < var16.size(); ++var17) {
                  var18 = new Stock();
                  var1 = (Object[])((Object[])var16.get(var17));
                  this.calculeLigneMedical(var1);
                  if (this.etat <= 5) {
                     if (this.etat == 0) {
                        var18.setStk_lib_type("(EC) Pharmacie");
                     } else {
                        var18.setStk_lib_type("Pharmacie");
                     }

                     var18.setStk_id(this.idDoc);
                     var18.setStk_type(73);
                     if (this.etat == 0) {
                        var18.setStk_etat("En cours");
                     } else if (this.etat == 1) {
                        var18.setStk_etat("Validé");
                     } else if (this.etat == 2) {
                        var18.setStk_etat("Gelé");
                     } else if (this.etat == 3) {
                        var18.setStk_etat("Annulé");
                     } else if (this.etat == 4) {
                        var18.setStk_etat("Trf partiel");
                     } else if (this.etat == 5) {
                        var18.setStk_etat("Trf total");
                     } else {
                        var18.setStk_etat("????");
                     }

                     if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
                        var18.setStk_code_depot(this.nomDepot);
                        var18.setStk_code_produit(this.code);
                        var18.setStk_code_generique(var7);
                        var18.setStkLibelle(this.libelle);
                        if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                           if (this.nomFamille.contains(":")) {
                              var19 = this.nomFamille.split(":");
                              var18.setStkFamille(var19[0]);
                           } else {
                              var18.setStkFamille(this.nomFamille);
                           }
                        } else {
                           var18.setStkFamille("");
                        }

                        var18.setStk_numero(this.num);
                        var18.setStk_serie(this.ser);
                        var18.setStk_equipe(0L);
                        if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                           var18.setStk_divers("CD");
                           var18.setStk_tiers(this.nomDivers);
                        } else {
                           var18.setStk_divers("CL");
                           var18.setStk_tiers(this.nomTiers);
                        }

                        var18.setStk_activite("");
                        var18.setStk_dossier("");
                        var18.setStk_date_mvt(this.date);
                        var18.setStk_pa(0.0D);
                        var18.setStkDevise(this.structureLog.getStrdevise());
                        var18.setStk_format_devise(this.structureLog.getStrformatdevise());
                        var18.setStk_devise(1.0F);
                        var18.setStk_pv(this.puLig);
                        var18.setStk_pump(this.pumpLig);
                        var18.setStk_qte_in(0.0F);
                        var18.setStk_qte_out(this.qteUtilLig);
                        var18.setStk_qte(this.qteLig);
                        this.lesMvt.add(var18);
                     }
                  }
               }
            }
         }

         if (var5 == 0 || var5 == 2 || var5 == 1 || var5 == 3) {
            new ArrayList();
            var16 = this.hospitalisationMediDao.chargerLesMvts(var2, var3, var4, var10, var11, var12, var13, "", var15);
            if (var16.size() != 0) {
               for(var17 = 0; var17 < var16.size(); ++var17) {
                  var18 = new Stock();
                  var1 = (Object[])((Object[])var16.get(var17));
                  this.calculeLigneMedical(var1);
                  if (this.etat <= 5) {
                     if (this.etat == 0) {
                        var18.setStk_lib_type("(EC) Hospit.Med.");
                     } else {
                        var18.setStk_lib_type("Hospit.Med.");
                     }

                     var18.setStk_id(this.idDoc);
                     var18.setStk_type(76);
                     if (this.etat == 0) {
                        var18.setStk_etat("En cours");
                     } else if (this.etat == 1) {
                        var18.setStk_etat("Validé");
                     } else if (this.etat == 2) {
                        var18.setStk_etat("Gelé");
                     } else if (this.etat == 3) {
                        var18.setStk_etat("Annulé");
                     } else if (this.etat == 4) {
                        var18.setStk_etat("Trf partiel");
                     } else if (this.etat == 5) {
                        var18.setStk_etat("Trf total");
                     } else {
                        var18.setStk_etat("????");
                     }

                     if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
                        var18.setStk_code_depot(this.nomDepot);
                        var18.setStk_code_produit(this.code);
                        var18.setStk_code_generique(var7);
                        var18.setStkLibelle(this.libelle);
                        if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                           if (this.nomFamille.contains(":")) {
                              var19 = this.nomFamille.split(":");
                              var18.setStkFamille(var19[0]);
                           } else {
                              var18.setStkFamille(this.nomFamille);
                           }
                        } else {
                           var18.setStkFamille("");
                        }

                        var18.setStk_numero(this.num);
                        var18.setStk_serie(this.ser);
                        var18.setStk_equipe(0L);
                        if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                           var18.setStk_divers("CD");
                           var18.setStk_tiers(this.nomDivers);
                        } else {
                           var18.setStk_divers("CL");
                           var18.setStk_tiers(this.nomTiers);
                        }

                        var18.setStk_activite("");
                        var18.setStk_dossier("");
                        var18.setStk_date_mvt(this.date);
                        var18.setStk_pa(0.0D);
                        var18.setStkDevise(this.structureLog.getStrdevise());
                        var18.setStk_format_devise(this.structureLog.getStrformatdevise());
                        var18.setStk_devise(1.0F);
                        var18.setStk_pv(this.puLig);
                        var18.setStk_pump(this.pumpLig);
                        var18.setStk_qte_in(0.0F);
                        var18.setStk_qte_out(this.qteUtilLig);
                        var18.setStk_qte(this.qteLig);
                        this.lesMvt.add(var18);
                     }
                  }
               }
            }
         }
      }

      if (var5 == 0 || var5 == 2 || var5 == 1 || var5 == 3) {
         new ArrayList();
         var16 = this.factureLigneVentesDao.chargerLesFacturesDirectes(var2, var3, var8, var4, var10, var11, var12, var13, var15);
         if (var16.size() != 0) {
            for(var17 = 0; var17 < var16.size(); ++var17) {
               var18 = new Stock();
               var1 = (Object[])((Object[])var16.get(var17));
               this.calculeLigneDirecteVente(var1);
               if (this.etat == 0) {
                  var18.setStk_lib_type("(EC) C.Facture Directe");
               } else {
                  var18.setStk_lib_type("C.Facture Directe");
               }

               var18.setStk_id(this.idDoc);
               var18.setStk_type(25);
               if (this.etat == 0) {
                  var18.setStk_etat("En cours");
               } else if (this.etat == 1) {
                  var18.setStk_etat("Validé");
               } else if (this.etat == 2) {
                  var18.setStk_etat("Gelé");
               } else if (this.etat == 3) {
                  var18.setStk_etat("Annulé");
               } else if (this.etat == 4) {
                  var18.setStk_etat("Trf partiel");
               } else if (this.etat == 5) {
                  var18.setStk_etat("Trf total");
               } else {
                  var18.setStk_etat("????");
               }

               if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
                  if (this.stockDirect == 1) {
                     var18.setFactureDirecte(1);
                     var18.setStk_code_depot(this.nomDepot);
                  } else {
                     var18.setFactureDirecte(0);
                     var18.setStk_code_depot(this.nomDepot + " (SS)");
                  }

                  var18.setStk_code_produit(this.code);
                  var18.setStk_code_generique(var7);
                  var18.setStkLibelle(this.libelle);
                  if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                     if (this.nomFamille.contains(":")) {
                        var19 = this.nomFamille.split(":");
                        var18.setStkFamille(var19[0]);
                     } else {
                        var18.setStkFamille(this.nomFamille);
                     }
                  } else {
                     var18.setStkFamille("");
                  }

                  var18.setStk_numero(this.num);
                  var18.setStk_serie(this.ser);
                  var18.setStk_equipe(this.idEquipe);
                  if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                     var18.setStk_divers("CD");
                     var18.setStk_tiers(this.nomDivers);
                  } else {
                     var18.setStk_divers("CL");
                     var18.setStk_tiers(this.nomTiers);
                  }

                  var18.setStk_activite("");
                  var18.setStk_dossier("");
                  var18.setStk_date_mvt(this.date);
                  var18.setStk_pa(0.0D);
                  var18.setStkDevise(this.devise);
                  var18.setStk_format_devise(this.utilNombre.formatDevise(var18.getStkDevise()));
                  var18.setStk_devise(1.0F);
                  if (this.qteUtilLig != this.qteLig) {
                     var21 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var18.getStkDevise());
                     var18.setStk_pv(var21);
                  } else {
                     var18.setStk_pv(this.puLig);
                  }

                  var18.setStk_pump(this.pumpLig);
                  var18.setStk_qte_in(0.0F);
                  var18.setStk_qte_out(this.qteUtilLig);
                  var18.setStk_qte(this.qteLig);
                  this.lesMvt.add(var18);
               }
            }
         }
      }

   }

   public void mvtsVteTicket(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.ticketLigneVentesDao.chargerLesTickets(var2, var3, var4, var8, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneTicket(var1);
            if (this.etat == 0) {
               var17.setStk_lib_type("(EC) C.Ticket");
            } else {
               var17.setStk_lib_type("C.Ticket");
            }

            var17.setStk_id(this.idDoc);
            var17.setStk_type(25);
            var17.setStk_etat("Validé");
            var17.setStk_code_depot(this.nomDepot);
            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie("..");
            var17.setStk_equipe(this.idEquipe);
            var17.setStk_divers("CL");
            var17.setStk_tiers(this.nomTiers);
            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.structureLog.getStrdevise());
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_devise(1.0F);
            var17.setStk_pv(this.puLig);
            var17.setStk_pump(this.pumpLig);
            var17.setStk_qte_in(0.0F);
            var17.setStk_qte_out(this.qteUtilLig);
            var17.setStk_qte(this.qteLig);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsVteChargement(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.chargementLigneDao.chargerLesMvts(var2, var3, var4, var8, var10, var11, var12, var13, var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneChargement(var1);
            String[] var18;
            if (this.qteLig != 0.0F) {
               if (this.typeChg == 1) {
                  if (this.etat == 0) {
                     var17.setStk_lib_type("(EC) C.Rechargement");
                  } else {
                     var17.setStk_lib_type("C.Rechargement");
                  }
               } else if (this.etat == 0) {
                  var17.setStk_lib_type("(EC) C.Chargement");
               } else {
                  var17.setStk_lib_type("C.Chargement");
               }

               var17.setStk_id(this.idDoc);
               var17.setStk_type(23);
               if (this.etat == 0) {
                  var17.setStk_etat("En cours");
               } else if (this.etat == 1) {
                  var17.setStk_etat("Validé");
               } else if (this.etat == 2) {
                  var17.setStk_etat("Gelé");
               } else if (this.etat == 3) {
                  var17.setStk_etat("Annulé");
               } else if (this.etat == 4) {
                  var17.setStk_etat("Trf partiel");
               } else if (this.etat == 5) {
                  var17.setStk_etat("Trf total");
               } else {
                  var17.setStk_etat("????");
               }

               if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
                  var17.setStk_code_depot(this.nomDepot);
                  var17.setStk_code_produit(this.code);
                  var17.setStk_code_generique(var7);
                  var17.setStkLibelle(this.libelle);
                  if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                     if (this.nomFamille.contains(":")) {
                        var18 = this.nomFamille.split(":");
                        var17.setStkFamille(var18[0]);
                     } else {
                        var17.setStkFamille(this.nomFamille);
                     }
                  } else {
                     var17.setStkFamille("");
                  }

                  var17.setStk_numero(this.num);
                  var17.setStk_serie(this.ser);
                  var17.setStk_equipe(this.idEquipe);
                  var17.setStk_tiers("Chargement/rechargement");
                  var17.setStk_divers("");
                  var17.setStk_activite("");
                  var17.setStk_dossier("");
                  var17.setStk_date_mvt(this.date);
                  var17.setStk_pa(0.0D);
                  var17.setStkDevise(this.structureLog.getStrdevise());
                  var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
                  var17.setStk_devise(1.0F);
                  var17.setStk_pv(this.puLig);
                  var17.setStk_pump(this.pumpLig);
                  var17.setStk_qte_in(0.0F);
                  var17.setStk_qte_out(this.qteUtilLig - this.qteLig);
                  var17.setStk_qte(this.qteUtilLig - this.qteLig);
                  this.lesMvt.add(var17);
               }
            }

            if (this.qteUtilLig != 0.0F) {
               if (this.etat == 0) {
                  var17.setStk_lib_type("(EC) C.Déchargement");
               } else {
                  var17.setStk_lib_type("C.Déchargement");
               }

               var17.setStk_id(this.idDoc);
               var17.setStk_type(24);
               if (this.etat == 0) {
                  var17.setStk_etat("En cours");
               } else if (this.etat == 1) {
                  var17.setStk_etat("Validé");
               } else if (this.etat == 2) {
                  var17.setStk_etat("Gelé");
               } else if (this.etat == 3) {
                  var17.setStk_etat("Annulé");
               } else if (this.etat == 4) {
                  var17.setStk_etat("Trf partiel");
               } else if (this.etat == 5) {
                  var17.setStk_etat("Trf total");
               } else {
                  var17.setStk_etat("????");
               }

               if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
                  var17.setStk_code_depot(this.nomDepot);
                  var17.setStk_code_produit(this.code);
                  var17.setStk_code_generique(var7);
                  var17.setStkLibelle(this.libelle);
                  if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                     if (this.nomFamille.contains(":")) {
                        var18 = this.nomFamille.split(":");
                        var17.setStkFamille(var18[0]);
                     } else {
                        var17.setStkFamille(this.nomFamille);
                     }
                  } else {
                     var17.setStkFamille("");
                  }

                  var17.setStk_numero(this.num);
                  var17.setStk_serie(this.ser);
                  var17.setStk_equipe(this.idEquipe);
                  var17.setStk_tiers("Retour déchargement");
                  var17.setStk_divers("");
                  var17.setStk_activite("");
                  var17.setStk_dossier("");
                  var17.setStk_date_mvt(this.date);
                  var17.setStk_pa(0.0D);
                  var17.setStkDevise(this.structureLog.getStrdevise());
                  var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
                  var17.setStk_devise(1.0F);
                  var17.setStk_pv(this.puLig);
                  var17.setStk_pump(this.pumpLig);
                  var17.setStk_qte_in(this.qteUtilLig);
                  var17.setStk_qte_out(0.0F);
                  var17.setStk_qte(this.qteLig);
                  this.lesMvt.add(var17);
               }
            }
         }
      }

   }

   public void mvtsVteRetour(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.retourLigneVentesDao.chargerLesMvts(var2, var3, var4, var8, var10, var11, var12, var13, "", var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneVente(var1);
            if (this.etat == 0) {
               var17.setStk_lib_type("(EC) C.Retour");
            } else {
               var17.setStk_lib_type("C.Retour");
            }

            var17.setStk_id(this.idDoc);
            var17.setStk_type(24);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            if (var5 == 0 || var5 == 2 || var5 == 1 && (this.etat == 1 || this.etat >= 4) || var5 == 3 && (this.etat == 0 || this.etat == 1 || this.etat >= 4)) {
               var17.setStk_code_depot(this.nomDepot);
               var17.setStk_code_produit(this.code);
               var17.setStk_code_generique(var7);
               var17.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var18 = this.nomFamille.split(":");
                     var17.setStkFamille(var18[0]);
                  } else {
                     var17.setStkFamille(this.nomFamille);
                  }
               } else {
                  var17.setStkFamille("");
               }

               var17.setStk_numero(this.num);
               var17.setStk_serie(this.ser);
               var17.setStk_equipe(this.idEquipe);
               if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                  var17.setStk_divers("CD");
                  var17.setStk_tiers(this.nomDivers);
               } else {
                  var17.setStk_divers("CL");
                  var17.setStk_tiers(this.nomTiers);
               }

               var17.setStk_activite("");
               var17.setStk_dossier("");
               var17.setStk_date_mvt(this.date);
               var17.setStk_pa(0.0D);
               var17.setStkDevise(this.devise);
               var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
               var17.setStk_devise(1.0F);
               if (this.qteUtilLig != this.qteLig) {
                  double var20 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var17.getStkDevise());
                  var17.setStk_pv(var20);
               } else {
                  var17.setStk_pv(this.puLig);
               }

               var17.setStk_pump(this.pumpLig);
               var17.setStk_qte_in(this.qteUtilLig);
               var17.setStk_qte_out(0.0F);
               var17.setStk_qte(this.qteLig);
               this.lesMvt.add(var17);
            }
         }
      }

   }

   public void mvtsVteFacture(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.factureLigneVentesDao.chargerLesMvts(var2, var3, var4, var8, var10, var11, var12, var13, "", var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneDirecteVente(var1);
            var17.setStk_lib_type("C.Facture Directe");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(25);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            var17.setFactureDirecte(0);
            if (this.stockDirect == 1) {
               var17.setFactureDirecte(1);
               var17.setStk_code_depot(this.nomDepot);
            } else {
               var17.setFactureDirecte(0);
               var17.setStk_code_depot(this.nomDepot + " (SS)");
            }

            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie(this.ser);
            var17.setStk_equipe(this.idEquipe);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var17.setStk_divers("CD");
               var17.setStk_tiers(this.nomDivers);
            } else {
               var17.setStk_divers("CL");
               var17.setStk_tiers(this.nomTiers);
            }

            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.devise);
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_devise(1.0F);
            if (this.qteUtilLig != this.qteLig) {
               double var20 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var17.getStkDevise());
               var17.setStk_pv(var20);
            } else {
               var17.setStk_pv(this.puLig);
            }

            var17.setStk_pump(this.pumpLig);
            var17.setStk_qte_in(0.0F);
            var17.setStk_qte_out(this.qteUtilLig);
            var17.setStk_qte(this.qteLig);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsVteAvoir(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.avoirLigneVentesDao.chargerLesMvts(var2, var3, var8, var10, var11, var12, var13, "", var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneVente(var1);
            var17.setStk_lib_type("C.Avoir");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(26);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            var17.setStk_code_depot("");
            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie(this.ser);
            var17.setStk_equipe(this.idEquipe);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var17.setStk_divers("CD");
               var17.setStk_tiers(this.nomDivers);
            } else {
               var17.setStk_divers("CL");
               var17.setStk_tiers(this.nomTiers);
            }

            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.devise);
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_devise(1.0F);
            if (this.qteUtilLig != this.qteLig) {
               double var20 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var17.getStkDevise());
               var17.setStk_pv(var20);
            } else {
               var17.setStk_pv(this.puLig);
            }

            var17.setStk_pump(this.pumpLig);
            var17.setStk_qte_in(this.qteUtilLig);
            var17.setStk_qte_out(0.0F);
            var17.setStk_qte(this.qteLig);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsVteNoteDebit(Object[] var1, String var2, String var3, String var4, int var5, String var6, String var7, long var8, String var10, String var11, String var12, String var13, Session var14) throws ParseException {
      new ArrayList();
      List var15 = this.noteDebitLigneVentesDao.chargerLesMvts(var2, var3, var8, var10, var11, var12, var13, "", var14);
      if (var15.size() != 0) {
         for(int var16 = 0; var16 < var15.size(); ++var16) {
            Stock var17 = new Stock();
            var1 = (Object[])((Object[])var15.get(var16));
            this.calculeLigneVente(var1);
            var17.setStk_lib_type("C.noteDebit");
            var17.setStk_id(this.idDoc);
            var17.setStk_type(27);
            if (this.etat == 0) {
               var17.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var17.setStk_etat("Validé");
            } else if (this.etat == 2) {
               var17.setStk_etat("Gelé");
            } else if (this.etat == 3) {
               var17.setStk_etat("Annulé");
            } else if (this.etat == 4) {
               var17.setStk_etat("Trf partiel");
            } else if (this.etat == 5) {
               var17.setStk_etat("Trf total");
            } else {
               var17.setStk_etat("????");
            }

            var17.setStk_code_depot("");
            var17.setStk_code_produit(this.code);
            var17.setStk_code_generique(var7);
            var17.setStkLibelle(this.libelle);
            if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
               if (this.nomFamille.contains(":")) {
                  String[] var18 = this.nomFamille.split(":");
                  var17.setStkFamille(var18[0]);
               } else {
                  var17.setStkFamille(this.nomFamille);
               }
            } else {
               var17.setStkFamille("");
            }

            var17.setStk_numero(this.num);
            var17.setStk_serie(this.ser);
            var17.setStk_equipe(this.idEquipe);
            if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
               var17.setStk_divers("CD");
               var17.setStk_tiers(this.nomDivers);
            } else {
               var17.setStk_divers("CL");
               var17.setStk_tiers(this.nomTiers);
            }

            var17.setStk_activite("");
            var17.setStk_dossier("");
            var17.setStk_date_mvt(this.date);
            var17.setStk_pa(0.0D);
            var17.setStkDevise(this.devise);
            var17.setStk_format_devise(this.utilNombre.formatDevise(var17.getStkDevise()));
            var17.setStk_devise(1.0F);
            if (this.qteUtilLig != this.qteLig) {
               double var20 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var17.getStkDevise());
               var17.setStk_pv(var20);
            } else {
               var17.setStk_pv(this.puLig);
            }

            var17.setStk_pump(this.pumpLig);
            var17.setStk_qte_in(this.qteUtilLig);
            var17.setStk_qte_out(0.0F);
            var17.setStk_qte(this.qteLig);
            this.lesMvt.add(var17);
         }
      }

   }

   public void mvtsVteCadeaux(Object[] var1, String var2, String var3, int var4, String var5, String var6, long var7, String var9, String var10, String var11, String var12, Session var13) throws ParseException {
      new ArrayList();
      List var14 = this.cadeauxDao.chargerLesMvts(var2, var3, var11, var12, var13);
      if (var14.size() != 0) {
         for(int var15 = 0; var15 < var14.size(); ++var15) {
            Stock var16 = new Stock();
            var1 = (Object[])((Object[])var14.get(var15));
            this.calculeCadeaux(var1);
            if (this.etat == 0) {
               var16.setStk_lib_type("(EC) Cadeaux");
            } else {
               var16.setStk_lib_type("Cadeaux");
            }

            var16.setStk_id(this.idDoc);
            var16.setStk_type(25);
            if (this.etat == 0) {
               var16.setStk_etat("En cours");
            } else if (this.etat == 1) {
               var16.setStk_etat("Validé");
            }

            if (var4 == 0 || var4 == 2 || var4 == 1 && this.etat == 1 || var4 == 3 && (this.etat == 0 || this.etat == 1)) {
               var16.setStk_code_depot(var3);
               var16.setStk_code_produit(this.code);
               var16.setStk_code_generique(var6);
               var16.setStkLibelle(this.libelle);
               if (this.nomFamille != null && !this.nomFamille.isEmpty()) {
                  if (this.nomFamille.contains(":")) {
                     String[] var17 = this.nomFamille.split(":");
                     var16.setStkFamille(var17[0]);
                  } else {
                     var16.setStkFamille(this.nomFamille);
                  }
               } else {
                  var16.setStkFamille("");
               }

               var16.setStk_numero(this.num);
               var16.setStk_serie("..");
               var16.setStk_equipe(this.idEquipe);
               if (this.nomDivers != null && !this.nomDivers.isEmpty()) {
                  var16.setStk_divers("CD");
                  var16.setStk_tiers(this.nomDivers);
               } else {
                  var16.setStk_divers("CL");
                  var16.setStk_tiers(this.nomTiers);
               }

               var16.setStk_activite("");
               var16.setStk_dossier("");
               var16.setStk_date_mvt(this.date);
               var16.setStk_pa(0.0D);
               var16.setStkDevise(this.devise);
               var16.setStk_format_devise(this.utilNombre.formatDevise(var16.getStkDevise()));
               var16.setStk_devise(1.0F);
               if (this.qteUtilLig != this.qteLig) {
                  double var19 = this.utilNombre.myRoundDevise(this.ptLig / (double)this.qteUtilLig, var16.getStkDevise());
                  var16.setStk_pv(var19);
               } else {
                  var16.setStk_pv(this.puLig);
               }

               var16.setStk_pump(this.pumpLig);
               var16.setStk_qte_in(0.0F);
               var16.setStk_qte_out(this.qteUtilLig);
               var16.setStk_qte(this.qteLig);
               this.lesMvt.add(var16);
            }
         }
      }

   }

   public void calculeLigneStock(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.ser = var1[2].toString();
      } else {
         this.ser = "..";
      }

      if (var1[3] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[3].toString());
      } else {
         this.date = null;
      }

      if (var1[4] != null) {
         this.idEquipe = Long.parseLong(var1[4].toString());
      } else {
         this.idEquipe = 0L;
      }

      if (var1[5] != null) {
         this.idDoc = Long.parseLong(var1[5].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[6] != null) {
         this.nomDepot = var1[6].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[7] != null) {
         this.code = var1[7].toString();
      } else {
         this.code = "";
      }

      if (var1[8] != null) {
         this.nomFamille = var1[8].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[9] != null) {
         this.libelle = var1[9].toString();
      } else {
         this.libelle = "";
      }

      if (var1[10] != null) {
         this.qteLig = Float.parseFloat(var1[10].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[11] != null) {
         this.qteUtilLig = Float.parseFloat(var1[11].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[12] != null) {
         this.pumpLig = Double.parseDouble(var1[12].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[13] != null) {
         this.ptLig = Double.parseDouble(var1[13].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[14] != null) {
         this.poidsBrut = Float.parseFloat(var1[14].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

      if (var1.length >= 16) {
         if (var1[15] != null) {
            this.obs = var1[15].toString();
         } else {
            this.obs = "";
         }

         if (var1.length >= 17) {
            if (var1[16] != null) {
               this.nomDivers = var1[16].toString();
            } else {
               this.nomDivers = "";
            }

            if (var1.length >= 18) {
               if (var1[17] != null) {
                  this.typeChg = Integer.parseInt(var1[17].toString());
               } else {
                  this.typeChg = 0;
               }
            }
         }
      }

   }

   public void calculeLigneAchat(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.ser = var1[2].toString();
      } else {
         this.ser = "";
      }

      if (var1[3] != null) {
         this.nomDivers = var1[3].toString();
      } else {
         this.nomDivers = "";
      }

      if (var1[4] != null) {
         this.nomTiers = var1[4].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[5] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[5].toString());
      } else {
         this.date = null;
      }

      if (var1[6] != null) {
         this.devise = var1[6].toString();
      } else {
         this.devise = "";
      }

      if (var1[7] != null) {
         this.idDoc = Long.parseLong(var1[7].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[8] != null) {
         this.nomDepot = var1[8].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[9] != null) {
         this.code = var1[9].toString();
      } else {
         this.code = "";
      }

      if (var1[10] != null) {
         this.nomFamille = var1[10].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[11] != null) {
         this.libelle = var1[11].toString();
      } else {
         this.libelle = "";
      }

      if (var1[12] != null) {
         this.qteLig = Float.parseFloat(var1[12].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[13] != null) {
         this.qteUtilLig = Float.parseFloat(var1[13].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[14] != null) {
         this.puLig = Double.parseDouble(var1[14].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[15] != null) {
         this.ptLig = Double.parseDouble(var1[15].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[16] != null) {
         this.prLig = Double.parseDouble(var1[16].toString());
      } else {
         this.prLig = 0.0D;
      }

      if (var1[17] != null) {
         this.pumpLig = Double.parseDouble(var1[17].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[18] != null) {
         this.poidsBrut = Float.parseFloat(var1[18].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

      if (var1.length >= 20) {
         if (var1[19] != null) {
            this.obs = var1[19].toString();
         } else {
            this.obs = "";
         }

         if (var1.length >= 21) {
            if (var1[20] != null) {
               this.dossier = var1[20].toString();
            } else {
               this.dossier = "";
            }

            if (var1.length >= 22) {
               if (var1[21] != null) {
                  this.coefDevise = Float.parseFloat(var1[21].toString());
               } else {
                  this.coefDevise = 0.0F;
               }

               if (var1.length >= 23) {
                  if (var1[22] != null) {
                     this.coefPr = Float.parseFloat(var1[22].toString());
                  } else {
                     this.coefPr = 0.0F;
                  }

                  if (var1.length >= 24) {
                     if (var1[23] != null) {
                        this.prKgrLig = (double)Float.parseFloat(var1[23].toString());
                     } else {
                        this.prKgrLig = 0.0D;
                     }
                  }
               }
            }
         }
      }

   }

   public void calculeLigneVente(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.ser = var1[2].toString();
      } else {
         this.ser = "";
      }

      if (var1[3] != null) {
         this.idEquipe = Long.parseLong(var1[3].toString());
      } else {
         this.idEquipe = 0L;
      }

      if (var1[4] != null) {
         this.nomDivers = var1[4].toString();
      } else {
         this.nomDivers = "";
      }

      if (var1[5] != null) {
         this.nomTiers = var1[5].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[6] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[6].toString());
      } else {
         this.date = null;
      }

      if (var1[7] != null) {
         this.devise = var1[7].toString();
      } else {
         this.devise = "";
      }

      if (var1[8] != null) {
         this.idDoc = Long.parseLong(var1[8].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[9] != null) {
         this.nomDepot = var1[9].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[10] != null) {
         this.code = var1[10].toString();
      } else {
         this.code = "";
      }

      if (var1[11] != null) {
         this.nomFamille = var1[11].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[12] != null) {
         this.libelle = var1[12].toString();
      } else {
         this.libelle = "";
      }

      if (var1[13] != null) {
         this.qteLig = Float.parseFloat(var1[13].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[14] != null) {
         this.qteUtilLig = Float.parseFloat(var1[14].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[15] != null) {
         this.puLig = Double.parseDouble(var1[15].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[16] != null) {
         this.ptLig = Double.parseDouble(var1[16].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[17] != null) {
         this.pumpLig = Double.parseDouble(var1[17].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[18] != null) {
         this.poidsBrut = Float.parseFloat(var1[18].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

   }

   public void calculeLigneTicket(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.idEquipe = Long.parseLong(var1[2].toString());
      } else {
         this.idEquipe = 0L;
      }

      if (var1[3] != null) {
         this.nomDivers = var1[3].toString();
      } else {
         this.nomDivers = "";
      }

      if (var1[4] != null) {
         this.nomTiers = var1[4].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[5] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[5].toString());
      } else {
         this.date = null;
      }

      if (var1[6] != null) {
         this.devise = var1[6].toString();
      } else {
         this.devise = "";
      }

      if (var1[7] != null) {
         this.idDoc = Long.parseLong(var1[7].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[8] != null) {
         this.nomDepot = var1[8].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[9] != null) {
         this.code = var1[9].toString();
      } else {
         this.code = "";
      }

      if (var1[10] != null) {
         this.nomFamille = var1[10].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[11] != null) {
         this.libelle = var1[11].toString();
      } else {
         this.libelle = "";
      }

      if (var1[12] != null) {
         this.qteLig = Float.parseFloat(var1[12].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[13] != null) {
         this.qteUtilLig = Float.parseFloat(var1[13].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[14] != null) {
         this.puLig = Double.parseDouble(var1[14].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[15] != null) {
         this.ptLig = Double.parseDouble(var1[15].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[16] != null) {
         this.pumpLig = Double.parseDouble(var1[16].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[17] != null) {
         this.poidsBrut = Float.parseFloat(var1[17].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

   }

   public void calculeLigneDirecteVente(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.ser = var1[2].toString();
      } else {
         this.ser = "";
      }

      if (var1[3] != null) {
         this.idEquipe = Long.parseLong(var1[3].toString());
      } else {
         this.idEquipe = 0L;
      }

      if (var1[4] != null) {
         this.nomDivers = var1[4].toString();
      } else {
         this.nomDivers = "";
      }

      if (var1[5] != null) {
         this.nomTiers = var1[5].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[6] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[6].toString());
      } else {
         this.date = null;
      }

      if (var1[7] != null) {
         this.devise = var1[7].toString();
      } else {
         this.devise = "";
      }

      if (var1[8] != null) {
         this.idDoc = Long.parseLong(var1[8].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[9] != null) {
         this.nomDepot = var1[9].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[10] != null) {
         this.code = var1[10].toString();
      } else {
         this.code = "";
      }

      if (var1[11] != null) {
         this.nomFamille = var1[11].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[12] != null) {
         this.libelle = var1[12].toString();
      } else {
         this.libelle = "";
      }

      if (var1[13] != null) {
         this.qteLig = Float.parseFloat(var1[13].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[14] != null) {
         this.qteUtilLig = Float.parseFloat(var1[14].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[15] != null) {
         this.puLig = Double.parseDouble(var1[15].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[16] != null) {
         this.ptLig = Double.parseDouble(var1[16].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[17] != null) {
         this.pumpLig = Double.parseDouble(var1[17].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[18] != null) {
         this.poidsBrut = Float.parseFloat(var1[18].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

      if (var1[19] != null) {
         this.stockDirect = Integer.parseInt(var1[19].toString());
      } else {
         this.stockDirect = 0;
      }

   }

   public void calculeCadeaux(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
         this.idDoc = Long.parseLong(var1[1].toString());
      } else {
         this.num = "";
         this.idDoc = 0L;
      }

      this.ser = "..";
      if (var1[2] != null) {
         this.nomTiers = var1[2].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[3] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[3].toString());
      } else {
         this.date = null;
      }

      if (var1[4] != null) {
         this.nomDepot = var1[4].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[5] != null) {
         this.code = var1[5].toString();
      } else {
         this.code = "";
      }

      if (var1[6] != null) {
         this.nomFamille = var1[6].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[7] != null) {
         this.libelle = var1[7].toString();
      } else {
         this.libelle = "";
      }

      if (var1[8] != null) {
         this.qteLig = Float.parseFloat(var1[8].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[9] != null) {
         this.qteUtilLig = Float.parseFloat(var1[9].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[10] != null) {
         this.pumpLig = Double.parseDouble(var1[10].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[11] != null) {
         this.poidsBrut = Float.parseFloat(var1[11].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

   }

   public void calculeLigneMedical(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      this.ser = "..";
      if (var1[2] != null) {
         this.nomTiers = var1[2].toString();
      } else {
         this.nomTiers = "";
      }

      if (var1[3] != null) {
         if (var1[3].toString().contains(":")) {
            this.date = this.utilDate.stringToDateSQL(var1[3].toString());
         } else {
            this.date = this.utilDate.stringToDateSQLLight(var1[3].toString());
         }
      } else {
         this.date = null;
      }

      if (var1[4] != null) {
         this.idDoc = Long.parseLong(var1[4].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[5] != null) {
         this.nomDepot = var1[5].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[6] != null) {
         this.code = var1[6].toString();
      } else {
         this.code = "";
      }

      if (var1[7] != null) {
         this.nomFamille = var1[7].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[8] != null) {
         this.libelle = var1[8].toString();
      } else {
         this.libelle = "";
      }

      if (var1[9] != null) {
         this.qteLig = Float.parseFloat(var1[9].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[9] != null) {
         this.qteUtilLig = Float.parseFloat(var1[9].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[11] != null) {
         this.puLig = Double.parseDouble(var1[11].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[12] != null) {
         this.ptLig = Double.parseDouble(var1[12].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[13] != null) {
         this.pumpLig = Double.parseDouble(var1[13].toString());
      } else {
         this.pumpLig = 0.0D;
      }

   }

   public void calculeLigneChargement(Object[] var1) throws ParseException {
      if (var1[0] != null) {
         this.etat = Integer.parseInt(var1[0].toString());
      } else {
         this.etat = 0;
      }

      if (var1[1] != null) {
         this.num = var1[1].toString();
      } else {
         this.num = "";
      }

      if (var1[2] != null) {
         this.ser = var1[2].toString();
      } else {
         this.ser = "";
      }

      if (var1[3] != null) {
         this.idEquipe = Long.parseLong(var1[3].toString());
      } else {
         this.idEquipe = 0L;
      }

      if (var1[4] != null) {
         this.date = this.utilDate.stringToDateSQL(var1[4].toString());
      } else {
         this.date = null;
      }

      if (var1[5] != null) {
         this.idDoc = Long.parseLong(var1[5].toString());
      } else {
         this.idDoc = 0L;
      }

      if (var1[6] != null) {
         this.typeChg = Integer.parseInt(var1[6].toString());
      } else {
         this.typeChg = 0;
      }

      if (var1[7] != null) {
         this.nomDepot = var1[7].toString();
      } else {
         this.nomDepot = "";
      }

      if (var1[8] != null) {
         this.code = var1[8].toString();
      } else {
         this.code = "";
      }

      if (var1[9] != null) {
         this.nomFamille = var1[9].toString();
      } else {
         this.nomFamille = "";
      }

      if (var1[10] != null) {
         this.libelle = var1[10].toString();
      } else {
         this.libelle = "";
      }

      if (var1[11] != null) {
         this.qteUtilLig = Float.parseFloat(var1[11].toString());
      } else {
         this.qteUtilLig = 0.0F;
      }

      if (var1[12] != null) {
         this.qteLig = Float.parseFloat(var1[12].toString());
      } else {
         this.qteLig = 0.0F;
      }

      if (var1[13] != null) {
         this.puLig = Double.parseDouble(var1[13].toString());
      } else {
         this.puLig = 0.0D;
      }

      if (var1[14] != null) {
         this.ptLig = Double.parseDouble(var1[14].toString());
      } else {
         this.ptLig = 0.0D;
      }

      if (var1[15] != null) {
         this.pumpLig = Double.parseDouble(var1[15].toString());
      } else {
         this.pumpLig = 0.0D;
      }

      if (var1[16] != null) {
         this.poidsBrut = Float.parseFloat(var1[16].toString());
      } else {
         this.poidsBrut = 0.0F;
      }

   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public UtilInitHibernate getInitHibernateSessionFactory_2() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }
}
