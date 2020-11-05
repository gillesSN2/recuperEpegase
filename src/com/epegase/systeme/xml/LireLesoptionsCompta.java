package com.epegase.systeme.xml;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.model.ListDataModel;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LireLesoptionsCompta implements Serializable {
   private long strId;
   private OptionComptabilite optionComptabilite;
   private LectureNatureCompte lectureNatureCompte = new LectureNatureCompte();
   private LectureRacines lectureRacines;
   private transient ListDataModel mesClassesAnalytiques;
   private transient ListDataModel mesClassesBudgets;
   private transient ListDataModel mesCentralisations;
   private ArrayList mesRacines;
   private int choixRacine;
   private String selecFiscalite;

   public LireLesoptionsCompta(Structure var1) throws IOException {
      if (var1.getStrzonefiscale2() != null && !var1.getStrzonefiscale2().isEmpty() && this.choixRacine == 2) {
         this.choixRacine = 1;
         this.selecFiscalite = var1.getStrzonefiscale();
      } else if (var1.getStrzonefiscale2() != null && !var1.getStrzonefiscale2().isEmpty() && this.choixRacine != 2) {
         this.choixRacine = 2;
         this.selecFiscalite = var1.getStrzonefiscale();
      } else {
         this.choixRacine = 0;
         this.selecFiscalite = var1.getStrzonefiscale2();
      }

      this.lectureRacines = new LectureRacines(this.selecFiscalite);
      this.lectureRacines.setStructureLog(var1);
      this.lectureRacines.recupereRacines();
      this.mesRacines = new ArrayList();
      this.mesRacines = (ArrayList)this.lectureRacines.getMesRacines();
   }

   public OptionComptabilite lancer() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "compta" + File.separator + "configuration" + File.separator + "optioncomptabilite.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         this.optionComptabilite = new OptionComptabilite();
         if (var5.getChildText("nbcr") != null && !var5.getChildText("nbcr").isEmpty()) {
            this.optionComptabilite.setNbcr(var5.getChildText("nbcr"));
         } else {
            this.optionComptabilite.setNbcr("10");
         }

         if (var5.getChildText("nbcrExport") != null && !var5.getChildText("nbcrExport").isEmpty()) {
            this.optionComptabilite.setNbcrExport(var5.getChildText("nbcrExport"));
         } else {
            this.optionComptabilite.setNbcrExport("7");
         }

         if (var5.getChildText("calculCompte") != null && !var5.getChildText("calculCompte").isEmpty()) {
            this.optionComptabilite.setCalculCompte(var5.getChildText("calculCompte"));
         } else {
            this.optionComptabilite.setCalculCompte("0");
         }

         this.optionComptabilite.setTypelib(var5.getChildText("typelib"));
         if (var5.getChildText("analytique") != null && !var5.getChildText("analytique").isEmpty()) {
            this.optionComptabilite.setAnalytique(var5.getChildText("analytique"));
         } else {
            this.optionComptabilite.setAnalytique("false");
         }

         if (var5.getChildText("saisieAnalytique") != null && !var5.getChildText("saisieAnalytique").isEmpty()) {
            this.optionComptabilite.setSaisieAnalytique(var5.getChildText("saisieAnalytique"));
         } else {
            this.optionComptabilite.setSaisieAnalytique("0");
         }

         if (var5.getChildText("analytiqueErreur") != null && !var5.getChildText("analytiqueErreur").isEmpty()) {
            this.optionComptabilite.setAnalytiqueErreur(var5.getChildText("analytiqueErreur"));
         } else {
            this.optionComptabilite.setAnalytiqueErreur("0");
         }

         if (var5.getChildText("analytiqueTransfert") != null && !var5.getChildText("analytiqueTransfert").isEmpty()) {
            this.optionComptabilite.setAnalytiqueTransfert(var5.getChildText("analytiqueTransfert"));
         } else {
            this.optionComptabilite.setAnalytiqueTransfert("0");
         }

         if (var5.getChildText("anal_c1") != null && !var5.getChildText("anal_c1").isEmpty()) {
            this.optionComptabilite.setAnal_c1(var5.getChildText("anal_c1"));
         } else {
            this.optionComptabilite.setAnal_c1("false");
         }

         if (var5.getChildText("anal_c2") != null && !var5.getChildText("anal_c2").isEmpty()) {
            this.optionComptabilite.setAnal_c2(var5.getChildText("anal_c2"));
         } else {
            this.optionComptabilite.setAnal_c2("false");
         }

         if (var5.getChildText("anal_c3") != null && !var5.getChildText("anal_c3").isEmpty()) {
            this.optionComptabilite.setAnal_c3(var5.getChildText("anal_c3"));
         } else {
            this.optionComptabilite.setAnal_c3("false");
         }

         if (var5.getChildText("anal_c4") != null && !var5.getChildText("anal_c4").isEmpty()) {
            this.optionComptabilite.setAnal_c4(var5.getChildText("anal_c4"));
         } else {
            this.optionComptabilite.setAnal_c4("false");
         }

         if (var5.getChildText("anal_c5") != null && !var5.getChildText("anal_c5").isEmpty()) {
            this.optionComptabilite.setAnal_c5(var5.getChildText("anal_c5"));
         } else {
            this.optionComptabilite.setAnal_c5("false");
         }

         if (var5.getChildText("anal_c6") != null && !var5.getChildText("anal_c6").isEmpty()) {
            this.optionComptabilite.setAnal_c6(var5.getChildText("anal_c6"));
         } else {
            this.optionComptabilite.setAnal_c6("false");
         }

         if (var5.getChildText("anal_c7") != null && !var5.getChildText("anal_c7").isEmpty()) {
            this.optionComptabilite.setAnal_c7(var5.getChildText("anal_c7"));
         } else {
            this.optionComptabilite.setAnal_c7("false");
         }

         if (var5.getChildText("anal_c8") != null && !var5.getChildText("anal_c8").isEmpty()) {
            this.optionComptabilite.setAnal_c8(var5.getChildText("anal_c8"));
         } else {
            this.optionComptabilite.setAnal_c8("false");
         }

         if (var5.getChildText("anal_c9") != null && !var5.getChildText("anal_c9").isEmpty()) {
            this.optionComptabilite.setAnal_c9(var5.getChildText("anal_c9"));
         } else {
            this.optionComptabilite.setAnal_c9("false");
         }

         if (var5.getChildText("anal_c10") != null && !var5.getChildText("anal_c10").isEmpty()) {
            this.optionComptabilite.setAnal_c10(var5.getChildText("anal_c10"));
         } else {
            this.optionComptabilite.setAnal_c10("false");
         }

         if (var5.getChildText("anal_c11") != null && !var5.getChildText("anal_c11").isEmpty()) {
            this.optionComptabilite.setAnal_c11(var5.getChildText("anal_c11"));
         } else {
            this.optionComptabilite.setAnal_c11("false");
         }

         if (var5.getChildText("anal_c12") != null && !var5.getChildText("anal_c12").isEmpty()) {
            this.optionComptabilite.setAnal_c12(var5.getChildText("anal_c12"));
         } else {
            this.optionComptabilite.setAnal_c12("false");
         }

         if (var5.getChildText("anal_c13") != null && !var5.getChildText("anal_c13").isEmpty()) {
            this.optionComptabilite.setAnal_c13(var5.getChildText("anal_c13"));
         } else {
            this.optionComptabilite.setAnal_c13("false");
         }

         if (var5.getChildText("anal_c14") != null && !var5.getChildText("anal_c14").isEmpty()) {
            this.optionComptabilite.setAnal_c14(var5.getChildText("anal_c14"));
         } else {
            this.optionComptabilite.setAnal_c14("false");
         }

         if (var5.getChildText("anal_c15") != null && !var5.getChildText("anal_c15").isEmpty()) {
            this.optionComptabilite.setAnal_c15(var5.getChildText("anal_c15"));
         } else {
            this.optionComptabilite.setAnal_c15("false");
         }

         if (var5.getChildText("anal_c16") != null && !var5.getChildText("anal_c16").isEmpty()) {
            this.optionComptabilite.setAnal_c16(var5.getChildText("anal_c16"));
         } else {
            this.optionComptabilite.setAnal_c16("false");
         }

         if (var5.getChildText("anal_c17") != null && !var5.getChildText("anal_c17").isEmpty()) {
            this.optionComptabilite.setAnal_c17(var5.getChildText("anal_c17"));
         } else {
            this.optionComptabilite.setAnal_c17("false");
         }

         if (var5.getChildText("anal_c18") != null && !var5.getChildText("anal_c18").isEmpty()) {
            this.optionComptabilite.setAnal_c18(var5.getChildText("anal_c18"));
         } else {
            this.optionComptabilite.setAnal_c18("false");
         }

         if (var5.getChildText("anal_c19") != null && !var5.getChildText("anal_c19").isEmpty()) {
            this.optionComptabilite.setAnal_c19(var5.getChildText("anal_c19"));
         } else {
            this.optionComptabilite.setAnal_c19("false");
         }

         if (var5.getChildText("anal_c20") != null && !var5.getChildText("anal_c20").isEmpty()) {
            this.optionComptabilite.setAnal_c20(var5.getChildText("anal_c20"));
         } else {
            this.optionComptabilite.setAnal_c20("false");
         }

         if (var5.getChildText("anal_c21") != null && !var5.getChildText("anal_c21").isEmpty()) {
            this.optionComptabilite.setAnal_c21(var5.getChildText("anal_c21"));
         } else {
            this.optionComptabilite.setAnal_c21("false");
         }

         if (var5.getChildText("anal_c22") != null && !var5.getChildText("anal_c22").isEmpty()) {
            this.optionComptabilite.setAnal_c22(var5.getChildText("anal_c22"));
         } else {
            this.optionComptabilite.setAnal_c22("false");
         }

         if (var5.getChildText("anal_c23") != null && !var5.getChildText("anal_c23").isEmpty()) {
            this.optionComptabilite.setAnal_c23(var5.getChildText("anal_c23"));
         } else {
            this.optionComptabilite.setAnal_c23("false");
         }

         if (var5.getChildText("anal_c24") != null && !var5.getChildText("anal_c24").isEmpty()) {
            this.optionComptabilite.setAnal_c24(var5.getChildText("anal_c24"));
         } else {
            this.optionComptabilite.setAnal_c24("false");
         }

         if (var5.getChildText("tresorerie") != null && !var5.getChildText("tresorerie").isEmpty()) {
            this.optionComptabilite.setTresorerie(var5.getChildText("tresorerie"));
         } else {
            this.optionComptabilite.setTresorerie("false");
         }

         if (var5.getChildText("budget") != null && !var5.getChildText("budget").isEmpty()) {
            this.optionComptabilite.setBudget(var5.getChildText("budget"));
         } else {
            this.optionComptabilite.setBudget("false");
         }

         if (var5.getChildText("bud_c1") != null && !var5.getChildText("bud_c1").isEmpty()) {
            this.optionComptabilite.setBud_c1(var5.getChildText("bud_c1"));
         } else {
            this.optionComptabilite.setBud_c1("false");
         }

         if (var5.getChildText("bud_c2") != null && !var5.getChildText("bud_c2").isEmpty()) {
            this.optionComptabilite.setBud_c2(var5.getChildText("bud_c2"));
         } else {
            this.optionComptabilite.setBud_c2("false");
         }

         if (var5.getChildText("bud_c3") != null && !var5.getChildText("bud_c3").isEmpty()) {
            this.optionComptabilite.setBud_c3(var5.getChildText("bud_c3"));
         } else {
            this.optionComptabilite.setBud_c3("false");
         }

         if (var5.getChildText("bud_c4") != null && !var5.getChildText("bud_c4").isEmpty()) {
            this.optionComptabilite.setBud_c4(var5.getChildText("bud_c4"));
         } else {
            this.optionComptabilite.setBud_c4("false");
         }

         if (var5.getChildText("bud_c5") != null && !var5.getChildText("bud_c5").isEmpty()) {
            this.optionComptabilite.setBud_c5(var5.getChildText("bud_c5"));
         } else {
            this.optionComptabilite.setBud_c5("false");
         }

         if (var5.getChildText("bud_c6") != null && !var5.getChildText("bud_c6").isEmpty()) {
            this.optionComptabilite.setBud_c6(var5.getChildText("bud_c6"));
         } else {
            this.optionComptabilite.setBud_c6("false");
         }

         if (var5.getChildText("bud_c7") != null && !var5.getChildText("bud_c7").isEmpty()) {
            this.optionComptabilite.setBud_c7(var5.getChildText("bud_c7"));
         } else {
            this.optionComptabilite.setBud_c7("false");
         }

         if (var5.getChildText("bud_c8") != null && !var5.getChildText("bud_c8").isEmpty()) {
            this.optionComptabilite.setBud_c8(var5.getChildText("bud_c8"));
         } else {
            this.optionComptabilite.setBud_c8("false");
         }

         if (var5.getChildText("bud_c9") != null && !var5.getChildText("bud_c9").isEmpty()) {
            this.optionComptabilite.setBud_c9(var5.getChildText("bud_c9"));
         } else {
            this.optionComptabilite.setBud_c9("false");
         }

         if (var5.getChildText("bud_c10") != null && !var5.getChildText("bud_c10").isEmpty()) {
            this.optionComptabilite.setBud_c10(var5.getChildText("bud_c10"));
         } else {
            this.optionComptabilite.setBud_c10("false");
         }

         if (var5.getChildText("bud_c11") != null && !var5.getChildText("bud_c11").isEmpty()) {
            this.optionComptabilite.setBud_c11(var5.getChildText("bud_c11"));
         } else {
            this.optionComptabilite.setBud_c11("false");
         }

         if (var5.getChildText("bud_c12") != null && !var5.getChildText("bud_c12").isEmpty()) {
            this.optionComptabilite.setBud_c12(var5.getChildText("bud_c12"));
         } else {
            this.optionComptabilite.setBud_c12("false");
         }

         if (var5.getChildText("bud_c13") != null && !var5.getChildText("bud_c13").isEmpty()) {
            this.optionComptabilite.setBud_c13(var5.getChildText("bud_c13"));
         } else {
            this.optionComptabilite.setBud_c13("false");
         }

         if (var5.getChildText("bud_c14") != null && !var5.getChildText("bud_c14").isEmpty()) {
            this.optionComptabilite.setBud_c14(var5.getChildText("bud_c14"));
         } else {
            this.optionComptabilite.setBud_c14("false");
         }

         if (var5.getChildText("bud_c15") != null && !var5.getChildText("bud_c15").isEmpty()) {
            this.optionComptabilite.setBud_c15(var5.getChildText("bud_c15"));
         } else {
            this.optionComptabilite.setBud_c15("false");
         }

         if (var5.getChildText("bud_c16") != null && !var5.getChildText("bud_c16").isEmpty()) {
            this.optionComptabilite.setBud_c16(var5.getChildText("bud_c16"));
         } else {
            this.optionComptabilite.setBud_c16("false");
         }

         if (var5.getChildText("bud_c17") != null && !var5.getChildText("bud_c17").isEmpty()) {
            this.optionComptabilite.setBud_c17(var5.getChildText("bud_c17"));
         } else {
            this.optionComptabilite.setBud_c17("false");
         }

         if (var5.getChildText("bud_c18") != null && !var5.getChildText("bud_c18").isEmpty()) {
            this.optionComptabilite.setBud_c18(var5.getChildText("bud_c18"));
         } else {
            this.optionComptabilite.setBud_c18("false");
         }

         if (var5.getChildText("bud_c19") != null && !var5.getChildText("bud_c19").isEmpty()) {
            this.optionComptabilite.setBud_c19(var5.getChildText("bud_c19"));
         } else {
            this.optionComptabilite.setBud_c19("false");
         }

         if (var5.getChildText("bud_c20") != null && !var5.getChildText("bud_c20").isEmpty()) {
            this.optionComptabilite.setBud_c20(var5.getChildText("bud_c20"));
         } else {
            this.optionComptabilite.setBud_c20("false");
         }

         if (var5.getChildText("bud_c21") != null && !var5.getChildText("bud_c21").isEmpty()) {
            this.optionComptabilite.setBud_c21(var5.getChildText("bud_c21"));
         } else {
            this.optionComptabilite.setBud_c21("false");
         }

         if (var5.getChildText("bud_c22") != null && !var5.getChildText("bud_c22").isEmpty()) {
            this.optionComptabilite.setBud_c22(var5.getChildText("bud_c22"));
         } else {
            this.optionComptabilite.setBud_c22("false");
         }

         if (var5.getChildText("bud_c23") != null && !var5.getChildText("bud_c23").isEmpty()) {
            this.optionComptabilite.setBud_c23(var5.getChildText("bud_c23"));
         } else {
            this.optionComptabilite.setBud_c23("false");
         }

         if (var5.getChildText("bud_c24") != null && !var5.getChildText("bud_c24").isEmpty()) {
            this.optionComptabilite.setBud_c24(var5.getChildText("bud_c24"));
         } else {
            this.optionComptabilite.setBud_c24("false");
         }

         if (var5.getChildText("cen_c20") != null && !var5.getChildText("cen_c20").isEmpty()) {
            this.optionComptabilite.setCen_c20(var5.getChildText("cen_c20"));
         } else {
            this.optionComptabilite.setCen_c20("false");
         }

         if (var5.getChildText("cen_c21") != null && !var5.getChildText("cen_c21").isEmpty()) {
            this.optionComptabilite.setCen_c21(var5.getChildText("cen_c21"));
         } else {
            this.optionComptabilite.setCen_c21("false");
         }

         if (var5.getChildText("cen_c22") != null && !var5.getChildText("cen_c22").isEmpty()) {
            this.optionComptabilite.setCen_c22(var5.getChildText("cen_c22"));
         } else {
            this.optionComptabilite.setCen_c22("false");
         }

         if (var5.getChildText("cen_c23") != null && !var5.getChildText("cen_c23").isEmpty()) {
            this.optionComptabilite.setCen_c23(var5.getChildText("cen_c23"));
         } else {
            this.optionComptabilite.setCen_c23("false");
         }

         if (var5.getChildText("cen_c24") != null && !var5.getChildText("cen_c24").isEmpty()) {
            this.optionComptabilite.setCen_c24(var5.getChildText("cen_c24"));
         } else {
            this.optionComptabilite.setCen_c24("false");
         }

         if (var5.getChildText("cen_c25") != null && !var5.getChildText("cen_c25").isEmpty()) {
            this.optionComptabilite.setCen_c25(var5.getChildText("cen_c25"));
         } else {
            this.optionComptabilite.setCen_c25("false");
         }

         if (var5.getChildText("cen_c26") != null && !var5.getChildText("cen_c26").isEmpty()) {
            this.optionComptabilite.setCen_c26(var5.getChildText("cen_c26"));
         } else {
            this.optionComptabilite.setCen_c26("false");
         }

         if (var5.getChildText("cen_c27") != null && !var5.getChildText("cen_c27").isEmpty()) {
            this.optionComptabilite.setCen_c27(var5.getChildText("cen_c27"));
         } else {
            this.optionComptabilite.setCen_c27("false");
         }

         if (var5.getChildText("cen_c28") != null && !var5.getChildText("cen_c28").isEmpty()) {
            this.optionComptabilite.setCen_c28(var5.getChildText("cen_c28"));
         } else {
            this.optionComptabilite.setCen_c28("false");
         }

         if (var5.getChildText("cen_c29") != null && !var5.getChildText("cen_c29").isEmpty()) {
            this.optionComptabilite.setCen_c29(var5.getChildText("cen_c29"));
         } else {
            this.optionComptabilite.setCen_c29("false");
         }

         if (var5.getChildText("cen_c30") != null && !var5.getChildText("cen_c30").isEmpty()) {
            this.optionComptabilite.setCen_c30(var5.getChildText("cen_c30"));
         } else {
            this.optionComptabilite.setCen_c30("false");
         }

         if (var5.getChildText("cen_c31") != null && !var5.getChildText("cen_c31").isEmpty()) {
            this.optionComptabilite.setCen_c31(var5.getChildText("cen_c31"));
         } else {
            this.optionComptabilite.setCen_c31("false");
         }

         if (var5.getChildText("cen_c32") != null && !var5.getChildText("cen_c32").isEmpty()) {
            this.optionComptabilite.setCen_c32(var5.getChildText("cen_c32"));
         } else {
            this.optionComptabilite.setCen_c32("false");
         }

         if (var5.getChildText("cen_c33") != null && !var5.getChildText("cen_c33").isEmpty()) {
            this.optionComptabilite.setCen_c33(var5.getChildText("cen_c33"));
         } else {
            this.optionComptabilite.setCen_c33("false");
         }

         if (var5.getChildText("cen_c34") != null && !var5.getChildText("cen_c34").isEmpty()) {
            this.optionComptabilite.setCen_c34(var5.getChildText("cen_c34"));
         } else {
            this.optionComptabilite.setCen_c34("false");
         }

         if (var5.getChildText("cen_c35") != null && !var5.getChildText("cen_c35").isEmpty()) {
            this.optionComptabilite.setCen_c35(var5.getChildText("cen_c35"));
         } else {
            this.optionComptabilite.setCen_c35("false");
         }

         if (var5.getChildText("cen_c36") != null && !var5.getChildText("cen_c36").isEmpty()) {
            this.optionComptabilite.setCen_c36(var5.getChildText("cen_c36"));
         } else {
            this.optionComptabilite.setCen_c36("false");
         }

         if (var5.getChildText("cen_c37") != null && !var5.getChildText("cen_c37").isEmpty()) {
            this.optionComptabilite.setCen_c37(var5.getChildText("cen_c37"));
         } else {
            this.optionComptabilite.setCen_c37("false");
         }

         if (var5.getChildText("cen_c38") != null && !var5.getChildText("cen_c38").isEmpty()) {
            this.optionComptabilite.setCen_c38(var5.getChildText("cen_c38"));
         } else {
            this.optionComptabilite.setCen_c38("false");
         }

         if (var5.getChildText("cen_c39") != null && !var5.getChildText("cen_c39").isEmpty()) {
            this.optionComptabilite.setCen_c39(var5.getChildText("cen_c39"));
         } else {
            this.optionComptabilite.setCen_c39("false");
         }

         if (var5.getChildText("cen_c40") != null && !var5.getChildText("cen_c40").isEmpty()) {
            this.optionComptabilite.setCen_c40(var5.getChildText("cen_c40"));
         } else {
            this.optionComptabilite.setCen_c40("false");
         }

         if (var5.getChildText("cen_c41") != null && !var5.getChildText("cen_c41").isEmpty()) {
            this.optionComptabilite.setCen_c41(var5.getChildText("cen_c41"));
         } else {
            this.optionComptabilite.setCen_c41("false");
         }

         if (var5.getChildText("cen_c42") != null && !var5.getChildText("cen_c42").isEmpty()) {
            this.optionComptabilite.setCen_c42(var5.getChildText("cen_c42"));
         } else {
            this.optionComptabilite.setCen_c42("false");
         }

         if (var5.getChildText("cen_c43") != null && !var5.getChildText("cen_c43").isEmpty()) {
            this.optionComptabilite.setCen_c43(var5.getChildText("cen_c43"));
         } else {
            this.optionComptabilite.setCen_c43("false");
         }

         if (var5.getChildText("cen_c44") != null && !var5.getChildText("cen_c44").isEmpty()) {
            this.optionComptabilite.setCen_c44(var5.getChildText("cen_c44"));
         } else {
            this.optionComptabilite.setCen_c44("false");
         }

         if (var5.getChildText("cen_c45") != null && !var5.getChildText("cen_c45").isEmpty()) {
            this.optionComptabilite.setCen_c45(var5.getChildText("cen_c45"));
         } else {
            this.optionComptabilite.setCen_c45("false");
         }

         if (var5.getChildText("cen_c46") != null && !var5.getChildText("cen_c46").isEmpty()) {
            this.optionComptabilite.setCen_c46(var5.getChildText("cen_c46"));
         } else {
            this.optionComptabilite.setCen_c46("false");
         }

         if (var5.getChildText("cen_c47") != null && !var5.getChildText("cen_c47").isEmpty()) {
            this.optionComptabilite.setCen_c47(var5.getChildText("cen_c47"));
         } else {
            this.optionComptabilite.setCen_c47("false");
         }

         if (var5.getChildText("cen_c48") != null && !var5.getChildText("cen_c48").isEmpty()) {
            this.optionComptabilite.setCen_c48(var5.getChildText("cen_c48"));
         } else {
            this.optionComptabilite.setCen_c48("false");
         }

         if (var5.getChildText("cen_c49") != null && !var5.getChildText("cen_c49").isEmpty()) {
            this.optionComptabilite.setCen_c49(var5.getChildText("cen_c49"));
         } else {
            this.optionComptabilite.setCen_c49("false");
         }

         if (var5.getChildText("compte_treso") != null && !var5.getChildText("compte_treso").isEmpty()) {
            this.optionComptabilite.setCompte_treso(var5.getChildText("compte_treso"));
         } else {
            this.optionComptabilite.setCompte_treso("false");
         }

         this.optionComptabilite.setTri_jrx(var5.getChildText("tri_jrx"));
         this.optionComptabilite.setTri_extrait(var5.getChildText("tri_extrait"));
         this.optionComptabilite.setTrf_brl(var5.getChildText("trf_brl"));
         if (var5.getChildText("trf_cpte") != null && !var5.getChildText("trf_cpte").isEmpty()) {
            this.optionComptabilite.setTrf_cpte(var5.getChildText("trf_cpte"));
         } else {
            this.optionComptabilite.setTrf_cpte("0");
         }

         if (var5.getChildText("trf_cpteAchats") != null && !var5.getChildText("trf_cpteAchats").isEmpty()) {
            this.optionComptabilite.setTrf_cpteAchats(var5.getChildText("trf_cpteAchats"));
         } else {
            this.optionComptabilite.setTrf_cpteAchats("0");
         }

         if (var5.getChildText("trf_cpteVentes") != null && !var5.getChildText("trf_cpteVentes").isEmpty()) {
            this.optionComptabilite.setTrf_cpteVentes(var5.getChildText("trf_cpteVentes"));
         } else {
            this.optionComptabilite.setTrf_cpteVentes("0");
         }

         if (var5.getChildText("trf_cptePaye") != null && !var5.getChildText("trf_cptePaye").isEmpty()) {
            this.optionComptabilite.setTrf_cptePaye(var5.getChildText("trf_cptePaye"));
         } else {
            this.optionComptabilite.setTrf_cptePaye("0");
         }

         if (var5.getChildText("trf_cpteImmo") != null && !var5.getChildText("trf_cpteImmo").isEmpty()) {
            this.optionComptabilite.setTrf_cpteImmo(var5.getChildText("trf_cpteImmo"));
         } else {
            this.optionComptabilite.setTrf_cpteImmo("0");
         }

         if (var5.getChildText("trf_cpteTreso") != null && !var5.getChildText("trf_cpteTreso").isEmpty()) {
            this.optionComptabilite.setTrf_cpteTreso(var5.getChildText("trf_cpteTreso"));
         } else {
            this.optionComptabilite.setTrf_cpteTreso("0");
         }

         if (var5.getChildText("exportOd") != null && !var5.getChildText("exportOd").isEmpty()) {
            this.optionComptabilite.setExportOd(var5.getChildText("exportOd"));
         } else {
            this.optionComptabilite.setExportOd("0");
         }

         if (var5.getChildText("verrouImport") != null && !var5.getChildText("verrouImport").isEmpty()) {
            this.optionComptabilite.setVerrouImport(var5.getChildText("verrouImport"));
         } else {
            this.optionComptabilite.setVerrouImport("0");
         }

         if (var5.getChildText("brouillardImport") != null && !var5.getChildText("brouillardImport").isEmpty()) {
            this.optionComptabilite.setBrouillardImport(var5.getChildText("brouillardImport"));
         } else {
            this.optionComptabilite.setBrouillardImport("0");
         }

         if (var5.getChildText("clotureSansControle") != null && !var5.getChildText("clotureSansControle").isEmpty()) {
            this.optionComptabilite.setClotureSansControle(var5.getChildText("clotureSansControle"));
         } else {
            this.optionComptabilite.setClotureSansControle("0");
         }

         if (var5.getChildText("clotureSansRappro") != null && !var5.getChildText("clotureSansRappro").isEmpty()) {
            this.optionComptabilite.setClotureSansRappro(var5.getChildText("clotureSansRappro"));
         } else {
            this.optionComptabilite.setClotureSansRappro("0");
         }

         if (var5.getChildText("clotureLettrageInutile") != null && !var5.getChildText("clotureLettrageInutile").isEmpty()) {
            this.optionComptabilite.setClotureLettrageInutile(var5.getChildText("clotureLettrageInutile"));
         } else {
            this.optionComptabilite.setClotureLettrageInutile("0");
         }

         if (var5.getChildText("clotureLettrage") != null && !var5.getChildText("clotureLettrage").isEmpty()) {
            this.optionComptabilite.setClotureLettrage(var5.getChildText("clotureLettrage"));
         } else {
            this.optionComptabilite.setClotureLettrage("0");
         }

         if (var5.getChildText("clotureBackup") != null && !var5.getChildText("clotureBackup").isEmpty()) {
            this.optionComptabilite.setClotureBackup(var5.getChildText("clotureBackup"));
         } else {
            this.optionComptabilite.setClotureBackup("0");
         }

         this.optionComptabilite.setEcartDebit(var5.getChildText("ecartDebit"));
         this.optionComptabilite.setEcartCredit(var5.getChildText("ecartCredit"));
         if (var5.getChildText("trf_rapprochement") != null && !var5.getChildText("trf_rapprochement").isEmpty()) {
            this.optionComptabilite.setTrf_rapprochement(var5.getChildText("trf_rapprochement"));
         } else {
            this.optionComptabilite.setTrf_rapprochement("0");
         }

         if (var5.getChildText("trf_rapprochementMode") != null && !var5.getChildText("trf_rapprochementMode").isEmpty()) {
            this.optionComptabilite.setTrf_rapprochementMode(var5.getChildText("trf_rapprochementMode"));
         } else {
            this.optionComptabilite.setTrf_rapprochementMode("0");
         }

         this.optionComptabilite.setColContrePartie(var5.getChildText("ContrePartie"));
         this.optionComptabilite.setColNumReference1(var5.getChildText("NumReference1"));
         this.optionComptabilite.setColNumReference2(var5.getChildText("NumReference2"));
         this.optionComptabilite.setAdresseFtp(var5.getChildText("adresseFtp"));
         this.optionComptabilite.setLoginFtp(var5.getChildText("loginFtp"));
         this.optionComptabilite.setPasswdFtp(var5.getChildText("passwdFtp"));
         this.optionComptabilite.setPortFtp(var5.getChildText("portFtp"));
         this.optionComptabilite.setDossierExport(var5.getChildText("dossierExport"));
         if (var5.getChildText("nbLigneMaxBr") != null && !var5.getChildText("nbLigneMaxBr").isEmpty()) {
            this.optionComptabilite.setNbLigneMaxBr(var5.getChildText("nbLigneMaxBr"));
         } else {
            this.optionComptabilite.setNbLigneMaxBr("100");
         }

         if (var5.getChildText("nbLigneMaxJr") != null && !var5.getChildText("nbLigneMaxJr").isEmpty()) {
            this.optionComptabilite.setNbLigneMaxJr(var5.getChildText("nbLigneMaxJr"));
         } else {
            this.optionComptabilite.setNbLigneMaxJr("100");
         }

         if (var5.getChildText("nbLigneMaxEx") != null && !var5.getChildText("nbLigneMaxEx").isEmpty()) {
            this.optionComptabilite.setNbLigneMaxEx(var5.getChildText("nbLigneMaxEx"));
         } else {
            this.optionComptabilite.setNbLigneMaxEx("100");
         }

         if (var5.getChildText("nbLigneMaxAm") != null && !var5.getChildText("nbLigneMaxAm").isEmpty()) {
            this.optionComptabilite.setNbLigneMaxAm(var5.getChildText("nbLigneMaxAm"));
         } else {
            this.optionComptabilite.setNbLigneMaxAm("100");
         }

         if (var5.getChildText("nbLigneMaxLo") != null && !var5.getChildText("nbLigneMaxLo").isEmpty()) {
            this.optionComptabilite.setNbLigneMaxLo(var5.getChildText("nbLigneMaxLo"));
         } else {
            this.optionComptabilite.setNbLigneMaxLo("100");
         }

         if (var5.getChildText("nbLigneMaxBu") != null && !var5.getChildText("nbLigneMaxBu").isEmpty()) {
            this.optionComptabilite.setNbLigneMaxBu(var5.getChildText("nbLigneMaxBu"));
         } else {
            this.optionComptabilite.setNbLigneMaxBu("100");
         }

         if (var5.getChildText("planCpteLiasse") != null && !var5.getChildText("planCpteLiasse").isEmpty()) {
            this.optionComptabilite.setPlanCpteLiasse(var5.getChildText("planCpteLiasse"));
         } else {
            this.optionComptabilite.setPlanCpteLiasse("0");
         }

         if (var5.getChildText("calculImmobilisation") != null && !var5.getChildText("calculImmobilisation").isEmpty()) {
            this.optionComptabilite.setCalculImmobilisation(var5.getChildText("calculImmobilisation"));
         } else {
            this.optionComptabilite.setCalculImmobilisation("0");
         }

         this.optionComptabilite.setMailClotureRappro(var5.getChildText("mailClotureRappro"));
         this.optionComptabilite.setMailClotureJournal(var5.getChildText("mailClotureJournal"));
         var3.close();
      } catch (JDOMException var6) {
      } catch (IOException var7) {
      }

      this.chargerClasseAnalytique();
      this.chargerClasseBudget();
      this.chargerCentralisation();
      return this.optionComptabilite;
   }

   public ListDataModel chargerClasseAnalytique() {
      this.mesClassesAnalytiques = new ListDataModel();
      ArrayList var1 = new ArrayList();
      new ArrayList();
      ArrayList var2 = (ArrayList)this.lectureNatureCompte.getMesNatureCompte();
      ObjetCompte var3 = null;
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(0)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(0)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c1()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(1)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(1)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c2()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(2)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(2)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c3()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(3)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(3)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c4()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(4)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(4)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c5()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(5)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(5)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c6()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(6)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(6)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c7()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(7)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(7)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c8()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(8)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(8)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c9()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(9)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(9)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c10()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(10)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(10)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c11()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(11)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(11)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c12()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(12)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(12)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c13()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(13)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(13)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c14()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(14)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(14)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c15()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(15)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(15)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c16()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(16)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(16)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c17()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(17)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(17)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c18()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(18)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(18)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c19()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(19)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(19)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c20()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(20)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(20)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c21()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(21)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(21)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c22()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(22)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(22)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c23()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(23)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(23)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getAnal_c24()));
      var1.add(var3);
      this.mesClassesAnalytiques.setWrappedData(var1);
      return this.mesClassesAnalytiques;
   }

   public ListDataModel chargerClasseBudget() {
      this.mesClassesBudgets = new ListDataModel();
      ArrayList var1 = new ArrayList();
      new ArrayList();
      ArrayList var2 = (ArrayList)this.lectureNatureCompte.getMesNatureCompte();
      ObjetCompte var3 = null;
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(0)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(0)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c1()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(1)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(1)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c2()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(2)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(2)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c3()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(3)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(3)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c4()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(4)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(4)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c5()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(5)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(5)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c6()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(6)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(6)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c7()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(7)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(7)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c8()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(8)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(8)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c9()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(9)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(9)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c10()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(10)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(10)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c11()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(11)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(11)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c12()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(12)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(12)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c13()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(13)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(13)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c14()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(14)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(14)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c15()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(15)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(15)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c16()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(16)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(16)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c17()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(17)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(17)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c18()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(18)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(18)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c19()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(19)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(19)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c20()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(20)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(20)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c21()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(21)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(21)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c22()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(22)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(22)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c23()));
      var1.add(var3);
      var3 = new ObjetCompte();
      var3.setCode(((ObjetCompte)var2.get(23)).getCode());
      var3.setNom_FR(((ObjetCompte)var2.get(23)).getNom_FR());
      var3.setValide(Boolean.parseBoolean(this.optionComptabilite.getBud_c24()));
      var1.add(var3);
      this.mesClassesBudgets.setWrappedData(var1);
      return this.mesClassesBudgets;
   }

   public ListDataModel chargerCentralisation() {
      this.mesCentralisations = new ListDataModel();
      ArrayList var1 = new ArrayList();
      ObjetCompte var2 = null;
      var2 = new ObjetCompte();
      var2.setCode("20");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c20()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("21");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c21()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("22");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c22()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("23");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c23()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("24");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c24()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("25");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c25()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("26");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c26()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("27");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c27()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("28");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c28()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("29");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c29()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("30");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c30()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("31");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c31()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("32");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c32()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("33");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c33()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("34");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c34()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("35");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c35()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("36");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c36()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("37");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c37()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("38");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c38()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("39");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c39()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("40");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c40()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("41");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c41()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("42");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c42()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("43");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c43()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("44");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c44()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("45");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c45()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("46");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c46()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("47");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c47()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("48");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c48()));
      var1.add(var2);
      var2 = new ObjetCompte();
      var2.setCode("49");
      var2.setNom_FR(this.calculeLibelleRacine(var2.getCode()));
      var2.setValide(Boolean.parseBoolean(this.optionComptabilite.getCen_c49()));
      var1.add(var2);
      this.mesCentralisations.setWrappedData(var1);
      return this.mesCentralisations;
   }

   public String calculeLibelleRacine(String var1) {
      String var2 = "";
      if (this.mesRacines.size() != 0) {
         for(int var3 = 0; var3 < this.mesRacines.size(); ++var3) {
            if (((ObjetRacine)this.mesRacines.get(var3)).getCode().startsWith(var1)) {
               var2 = ((ObjetRacine)this.mesRacines.get(var3)).getNom_FR();
               break;
            }
         }
      }

      return var2;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public ListDataModel getMesClassesAnalytiques() {
      return this.mesClassesAnalytiques;
   }

   public void setMesClassesAnalytiques(ListDataModel var1) {
      this.mesClassesAnalytiques = var1;
   }

   public ListDataModel getMesClassesBudgets() {
      return this.mesClassesBudgets;
   }

   public void setMesClassesBudgets(ListDataModel var1) {
      this.mesClassesBudgets = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }

   public ListDataModel getMesCentralisations() {
      return this.mesCentralisations;
   }

   public void setMesCentralisations(ListDataModel var1) {
      this.mesCentralisations = var1;
   }
}
