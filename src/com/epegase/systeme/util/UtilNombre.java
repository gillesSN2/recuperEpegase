package com.epegase.systeme.util;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.ObjetDevises;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class UtilNombre implements Serializable {
   private List listeDevisesGlobales = new ArrayList();
   private List listeDevisesSpeciales = new ArrayList();
   private String[] dizaineNames = new String[]{"", "", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre-vingt", "quatre-vingt"};
   private String[] uniteNames1 = new String[]{"", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf"};
   private String[] uniteNames2 = new String[]{"", "", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix"};

   public UtilNombre() {
   }

   public UtilNombre(String var1) {
      this.chargerDevisesGlobales();
   }

   private String convertZeroToHundred(int var1) {
      int var2 = var1 / 10;
      int var3 = var1 % 10;
      String var4 = "";
      switch(var2) {
      case 1:
      case 7:
      case 9:
         var3 += 10;
      default:
         String var5 = "";
         if (var2 > 1) {
            var5 = "-";
         }

         switch(var3) {
         case 0:
            var5 = "";
            break;
         case 1:
            if (var2 == 8) {
               var5 = "-";
            } else {
               var5 = " et ";
            }
            break;
         case 11:
            if (var2 == 7) {
               var5 = " et ";
            }
         }

         switch(var2) {
         case 0:
            var4 = this.uniteNames1[var3];
            break;
         case 8:
            if (var3 == 0) {
               var4 = this.dizaineNames[var2];
            } else {
               var4 = this.dizaineNames[var2] + var5 + this.uniteNames1[var3];
            }
            break;
         default:
            var4 = this.dizaineNames[var2] + var5 + this.uniteNames1[var3];
         }

         return var4;
      }
   }

   private String convertLessThanOneThousand(int var1) {
      int var2 = var1 / 100;
      int var3 = var1 % 100;
      String var4 = this.convertZeroToHundred(var3);
      String var5;
      switch(var2) {
      case 0:
         var5 = var4;
         break;
      case 1:
         if (var3 > 0) {
            var5 = "cent " + var4;
         } else {
            var5 = "cent";
         }
         break;
      default:
         if (var3 > 0) {
            var5 = this.uniteNames2[var2] + " cent " + var4;
         } else {
            var5 = this.uniteNames2[var2] + " cents";
         }
      }

      return var5;
   }

   public String begin(double var1, String var3) {
      long var4 = 0L;
      long var6 = 0L;
      boolean var8 = false;
      if (var1 == 0.0D) {
         return "zéro";
      } else {
         var4 = (long)var1;
         int var25 = (int)(var1 - (double)var4);
         var6 = (long)var25;
         if (var3 != null && !var3.isEmpty()) {
            if (var3.equals("XOF") || var3.equals("XAF")) {
               var3 = "Fcfa";
            }
         } else {
            var3 = "";
         }

         String var9 = "";
         if (var6 != 0L) {
            var9 = var4 + "." + var6;
         } else {
            var9 = "" + var4;
         }

         String var10 = "";
         int var11 = 0;
         String var12;
         if (var9.contains(".")) {
            var12 = "";
            boolean var13 = false;
            int var26 = var9.indexOf(".");
            var12 = var9.substring(0, var26);
            var10 = var12;
            String var14 = var9.substring(var26 + 1);
            var11 = Integer.parseInt(var14);
         } else {
            var10 = var9;
         }

         var12 = "000000000000";
         DecimalFormat var27 = new DecimalFormat(var12);
         var9 = var27.format(Double.parseDouble(var10));
         int var28 = Integer.parseInt(var9.substring(0, 3));
         int var15 = Integer.parseInt(var9.substring(3, 6));
         int var16 = Integer.parseInt(var9.substring(6, 9));
         int var17 = Integer.parseInt(var9.substring(9, 12));
         String var18;
         switch(var28) {
         case 0:
            var18 = "";
            break;
         case 1:
            var18 = this.convertLessThanOneThousand(var28) + " milliard ";
            break;
         default:
            var18 = this.convertLessThanOneThousand(var28) + " milliards ";
         }

         String var20;
         switch(var15) {
         case 0:
            var20 = "";
            break;
         case 1:
            var20 = this.convertLessThanOneThousand(var15) + " million ";
            break;
         default:
            var20 = this.convertLessThanOneThousand(var15) + " millions ";
         }

         String var19 = var18 + var20;
         String var21;
         switch(var16) {
         case 0:
            var21 = "";
            break;
         case 1:
            var21 = "mille ";
            break;
         default:
            var21 = this.convertLessThanOneThousand(var16) + " mille ";
         }

         var19 = var19 + var21;
         String var22 = this.convertLessThanOneThousand(var17);
         var19 = var19 + var22;
         String var23 = "";
         if (var11 != 0 && var3 != null && !var3.isEmpty() && !var3.equals("Fcfa")) {
            var23 = " et " + this.convertZeroToHundred(var11);
            if (var3.equalsIgnoreCase("EUR")) {
               var23 = var23 + " centimes";
            } else if (var3.equalsIgnoreCase("USD")) {
               var23 = var23 + " cents";
            } else if (var3.equalsIgnoreCase("GBP")) {
               var23 = var23 + " pence";
            }
         }

         String var24 = "";
         if (var23 != null && !var23.isEmpty()) {
            var19 = var19.toLowerCase() + " " + var3.toUpperCase() + " " + var23.toLowerCase();
            var24 = var19.replaceFirst(".", (var19.charAt(0) + "").toUpperCase());
         } else {
            var19 = var19.toLowerCase() + " " + var3.toUpperCase();
            var24 = var19.replaceFirst(".", (var19.charAt(0) + "").toUpperCase());
         }

         return var24;
      }
   }

   public String beginSimple(double var1, String var3) {
      String var4 = "";
      double var5 = this.myRoundDevise(var1, var3);
      if (var3 != null && !var3.isEmpty()) {
         if (var3.equals("XOF")) {
            var3 = "Fcfa";
         }
      } else {
         var3 = "";
      }

      String var7 = "" + var5;
      if (var7.contains(".")) {
         String var8 = "";
         boolean var9 = false;
         int var10 = var7.indexOf(".");
         var8 = var7.substring(0, var10);
         var4 = var8 + " " + var3;
      } else {
         var4 = var7 + " " + var3;
      }

      return var4;
   }

   public String beginQte(float var1, String var2) {
      int var3 = Integer.parseInt(var2);
      String var4 = "";
      float var5 = this.myRound(var1, var3);
      String var6 = "" + var5;
      if (var6.contains(".")) {
         String var7 = "";
         boolean var8 = false;
         int var9 = var6.indexOf(".");
         var7 = var6.substring(0, var9);
         var4 = var7;
      } else {
         var4 = var6;
      }

      return var4;
   }

   public String beginGraph(double var1, int var3) {
      String var4 = "";
      long var5 = (long)this.myRoundFormat(var1, var3);
      String var7 = "" + var5;
      if (var7.contains(".")) {
         String var8 = "";
         boolean var9 = false;
         int var10 = var7.indexOf(".");
         var8 = var7.substring(0, var10);
         var4 = var8 + ".0";
      } else {
         var4 = var7 + ".0";
      }

      return var4;
   }

   public String beginText(double var1, int var3) {
      String var4 = "";
      long var5 = (long)this.myRoundFormat(var1, var3);
      String var7 = "" + var5;
      String var8;
      int var11;
      if (var7.contains(".")) {
         var8 = "";
         boolean var9 = false;
         var11 = var7.indexOf(".");
         var8 = var7.substring(0, var11);
         var4 = var8;
      } else {
         var4 = var7;
      }

      if (var4.length() >= 4) {
         var8 = "";
         var4 = var4 + "";
         var11 = 0;

         for(int var10 = var4.length(); var10 >= 0; --var10) {
            if (var10 != var4.length()) {
               var8 = var4.substring(var10, var10 + 1) + var8;
               ++var11;
               if (var11 == 3) {
                  var8 = "." + var8;
                  var11 = 0;
               }
            }
         }

         var4 = var8;
      }

      return var4;
   }

   public ObjetDevises calculerLibelleDevise(String var1) throws IOException {
      LectureDevises var2 = new LectureDevises();
      new ArrayList();
      List var3 = var2.getMesDevises();
      ObjetDevises var4 = new ObjetDevises();
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            if (((ObjetDevises)var3.get(var5)).getCode().equalsIgnoreCase(var1)) {
               var4 = (ObjetDevises)var3.get(var5);
               break;
            }
         }
      }

      return var4;
   }

   public int nbDecimal(String var1) {
      byte var2 = 0;
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.equalsIgnoreCase("XOF") && !var1.equalsIgnoreCase("XAF")) {
            var2 = 2;
         } else {
            var2 = 0;
         }
      }

      return var2;
   }

   public int formatDevise(String var1) {
      byte var2 = 0;
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.equalsIgnoreCase("XOF") && !var1.equalsIgnoreCase("XAF")) {
            if (!var1.equalsIgnoreCase("XEU") && !var1.equalsIgnoreCase("EUR") && !var1.equalsIgnoreCase("CHF")) {
               var2 = 0;
            } else {
               var2 = 1;
            }
         } else {
            var2 = 2;
         }
      }

      return var2;
   }

   public double myRoundFormat(double var1, int var3) {
      byte var4;
      if (var3 == 2) {
         var4 = 0;
      } else {
         var4 = 2;
      }

      double var5 = Math.pow(10.0D, (double)var4);
      return (double)Math.round(var1 * var5) / var5;
   }

   public double myRoundDevise(double var1, String var3) {
      byte var4 = 2;
      if (var3 != null && !var3.isEmpty()) {
         if (var3.equalsIgnoreCase("XOF") || var3.equalsIgnoreCase("XAF")) {
            var4 = 0;
         }
      } else {
         var4 = 2;
      }

      double var5 = Math.pow(10.0D, (double)var4);
      return (double)Math.round(var1 * var5) / var5;
   }

   public float myRoundDevise(float var1, String var2) {
      byte var3 = 2;
      if (var2 != null && !var2.isEmpty()) {
         if (var2.equalsIgnoreCase("XOF") || var2.equalsIgnoreCase("XAF")) {
            var3 = 0;
         }
      } else {
         var3 = 2;
      }

      float var4 = (float)Math.pow(10.0D, (double)var3);
      return (float)Math.round(var1 * var4) / var4;
   }

   public double myRound(double var1, int var3) {
      double var4 = Math.pow(10.0D, (double)var3);
      return (double)Math.round(var1 * var4) / var4;
   }

   public String myConvertString(double var1, int var3) {
      String var4 = "";
      long var5 = (long)this.myRoundFormat(var1, var3);
      String var7 = "" + var5;
      if (var7.contains(".")) {
         String var8 = "";
         boolean var9 = false;
         int var10 = var7.indexOf(".");
         var8 = var7.substring(0, var10);
         var4 = var8;
      } else {
         var4 = var7;
      }

      return var4;
   }

   public String myConvertStringSeperateur(double var1, int var3) {
      DecimalFormat var4 = (DecimalFormat)DecimalFormat.getInstance();
      var4.applyPattern("#,##0");
      String var5 = "" + var4.format(var1);
      return var5;
   }

   public float myRound(float var1, int var2) {
      float var3 = (float)Math.pow(10.0D, (double)var2);
      return (float)Math.round(var1 * var3) / var3;
   }

   public void chargerDevisesGlobales() {
      this.listeDevisesGlobales.clear();

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "devises" + File.separator + "devises.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            ObjetDevises var8 = new ObjetDevises();
            var8.setCode(((Element)var6.get(var7)).getChild("code").getText());
            var8.setTaux1(((Element)var6.get(var7)).getChild("taux1").getText());
            var8.setTaux2(((Element)var6.get(var7)).getChild("taux2").getText());
            this.listeDevisesGlobales.add(var8);
         }

         var3.close();
      } catch (JDOMException var9) {
      } catch (IOException var10) {
      }

   }

   public void chargerDevisesSpeciales(String var1, String var2) {
      this.listeDevisesSpeciales.clear();

      try {
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "devises" + File.separator + var1 + "_" + var2 + ".xml");
         if (var3.exists()) {
            SAXBuilder var4 = new SAXBuilder();
            FileReader var5 = new FileReader(var3);
            Document var6 = var4.build(var5);
            Element var7 = var6.getRootElement();
            List var8 = var7.getChildren();

            for(int var9 = 0; var9 < var8.size(); ++var9) {
               ObjetDevises var10 = new ObjetDevises();
               var10.setDate(((Element)var8.get(var9)).getChild("date").getText());
               var10.setTaux1(((Element)var8.get(var9)).getChild("taux1").getText());
               var10.setTaux2(((Element)var8.get(var9)).getChild("taux2").getText());
               this.listeDevisesSpeciales.add(var10);
            }

            var5.close();
         }
      } catch (JDOMException var11) {
      } catch (IOException var12) {
      }

   }

   public float deviseTaux1(String var1, Date var2) {
      float var3 = 1.0F;
      String var4 = "" + (var2.getYear() + 1900);
      this.chargerDevisesSpeciales(var1, var4);
      if (this.listeDevisesSpeciales.size() == 0) {
         this.chargerDevisesSpeciales(var1, var4);
      }

      if (this.listeDevisesSpeciales.size() != 0) {
         String var5 = "";
         if (var2.getMonth() + 1 <= 9) {
            var5 = "0" + (var2.getMonth() + 1);
         } else {
            var5 = "" + (var2.getMonth() + 1);
         }

         String var6 = "";
         if (var2.getDate() <= 9) {
            var6 = "0" + var2.getDate();
         } else {
            var6 = "" + var2.getDate();
         }

         String var7 = var4 + "/" + var5 + "/" + var6;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.listeDevisesSpeciales.size(); ++var9) {
            new ObjetDevises();
            ObjetDevises var10 = (ObjetDevises)this.listeDevisesSpeciales.get(var9);
            if (var10.getDate().equalsIgnoreCase(var7)) {
               var3 = Float.parseFloat(var10.getTaux1());
               var8 = true;
               break;
            }
         }

         if (!var8) {
            new ObjetDevises();
            ObjetDevises var13 = (ObjetDevises)this.listeDevisesSpeciales.get(0);
            var3 = Float.parseFloat(var13.getTaux1());
         }
      } else if (this.listeDevisesGlobales.size() != 0) {
         for(int var11 = 0; var11 < this.listeDevisesGlobales.size(); ++var11) {
            new ObjetDevises();
            ObjetDevises var12 = (ObjetDevises)this.listeDevisesGlobales.get(var11);
            if (var12.getCode().equalsIgnoreCase(var1)) {
               var3 = Float.parseFloat(var12.getTaux1());
               break;
            }
         }
      }

      return var3;
   }

   public float deviseTaux2(String var1, Date var2) {
      float var3 = 1.0F;
      String var4 = "" + (var2.getYear() + 1900);
      if (this.listeDevisesSpeciales.size() == 0) {
         this.chargerDevisesSpeciales(var1, var4);
      }

      if (this.listeDevisesSpeciales.size() != 0) {
         String var5 = "";
         if (var2.getMonth() + 1 <= 9) {
            var5 = "0" + (var2.getMonth() + 1);
         } else {
            var5 = "" + (var2.getMonth() + 1);
         }

         String var6 = "";
         if (var2.getDate() <= 9) {
            var6 = "0" + var2.getDate();
         } else {
            var6 = "" + var2.getDate();
         }

         String var7 = var4 + "/" + var5 + "/" + var6;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.listeDevisesSpeciales.size(); ++var9) {
            new ObjetDevises();
            ObjetDevises var10 = (ObjetDevises)this.listeDevisesSpeciales.get(var9);
            if (var10.getDate().equalsIgnoreCase(var7)) {
               var3 = Float.parseFloat(var10.getTaux2());
               var8 = true;
               break;
            }
         }

         if (!var8) {
            new ObjetDevises();
            ObjetDevises var13 = (ObjetDevises)this.listeDevisesSpeciales.get(0);
            var3 = Float.parseFloat(var13.getTaux2());
         }
      } else if (this.listeDevisesGlobales.size() != 0) {
         for(int var11 = 0; var11 < this.listeDevisesGlobales.size(); ++var11) {
            new ObjetDevises();
            ObjetDevises var12 = (ObjetDevises)this.listeDevisesGlobales.get(var11);
            if (var12.getCode().equalsIgnoreCase(var1)) {
               var3 = Float.parseFloat(var12.getTaux2());
               break;
            }
         }
      }

      return var3;
   }

   public double calculTimbre(Structure var1, double var2, int var4, String var5, Date var6) {
      double var7 = 0.0D;
      if (var1.getStrcodepays().equals("0056")) {
         if (var2 <= 5000.0D) {
            var7 = 0.0D;
         } else if (var2 >= 5001.0D && var2 <= 100000.0D) {
            var7 = 100.0D;
         } else if (var2 >= 100001.0D && var2 <= 500000.0D) {
            var7 = 500.0D;
         } else if (var2 >= 500001.0D && var2 <= 1000000.0D) {
            var7 = 1000.0D;
         } else if (var2 >= 1000001.0D && var2 <= 5000000.0D) {
            var7 = 2000.0D;
         } else if (var2 >= 5000001.0D) {
            var7 = 5000.0D;
         }
      } else if (!var1.getStrcodepays().equals("0138") && var1.getStrcodepays().equals("0202")) {
         if (var4 <= 2012) {
            if (var2 <= 100.0D) {
               var7 = 0.0D;
            } else if (var2 > 100.0D && var2 <= 1000.0D) {
               var7 = 20.0D;
            } else if (var2 > 1000.0D && var2 <= 10000.0D) {
               var7 = 150.0D;
            } else if (var2 > 10000.0D && var2 <= 50000.0D) {
               var7 = 200.0D;
            } else {
               double var9 = var2 - 50000.0D;
               double var11 = this.myRound(var9 / 50000.0D, 0);
               ++var11;
               var7 = 100.0D * var11 + 200.0D;
            }
         } else if ((var6.getYear() + 1900 != 2015 || var6.getMonth() + 1 < 5) && var6.getYear() + 1900 < 2016) {
            if (var2 < 20000.0D) {
               var7 = 0.0D;
            } else {
               var7 = this.myRoundDevise(var2 * 0.01D, var5);
            }
         } else if (var2 < 100000.0D) {
            var7 = 0.0D;
         } else {
            var7 = this.myRoundDevise(var2 * 0.01D, var5);
         }
      }

      return var7;
   }

   public double extractionTimbre(Structure var1, double var2, int var4, String var5, Date var6) {
      double var7 = 0.0D;
      if (var1.getStrcodepays().equals("0056")) {
         if (var2 <= 5000.0D) {
            var7 = 0.0D;
         } else if (var2 >= 5001.0D && var2 <= 100000.0D) {
            var7 = 100.0D;
         } else if (var2 >= 100001.0D && var2 <= 500000.0D) {
            var7 = 500.0D;
         } else if (var2 >= 500001.0D && var2 <= 1000000.0D) {
            var7 = 1000.0D;
         } else if (var2 >= 1000001.0D && var2 <= 5000000.0D) {
            var7 = 2000.0D;
         } else if (var2 >= 5000001.0D) {
            var7 = 5000.0D;
         }
      } else if (!var1.getStrcodepays().equals("0138") && var1.getStrcodepays().equals("0202")) {
         if (var4 <= 2012) {
            if (var2 <= 100.0D) {
               var7 = 0.0D;
            } else if (var2 > 100.0D && var2 <= 1000.0D) {
               var7 = 20.0D;
            } else if (var2 > 1000.0D && var2 <= 10000.0D) {
               var7 = 150.0D;
            } else if (var2 > 10000.0D && var2 <= 50000.0D) {
               var7 = 200.0D;
            } else {
               double var9 = var2 - 50000.0D;
               double var11 = this.myRound(var9 / 50000.0D, 0);
               ++var11;
               var7 = 100.0D * var11 + 200.0D;
            }
         } else if ((var6.getYear() + 1900 != 2015 || var6.getMonth() + 1 < 5) && var6.getYear() + 1900 < 2016) {
            if (var2 < 20000.0D) {
               var7 = 0.0D;
            } else {
               var7 = var2 - this.myRoundDevise(var2 / 1.01D, var5);
            }
         } else if (var2 < 100000.0D) {
            var7 = 0.0D;
         } else {
            var7 = var2 - this.myRoundDevise(var2 / 1.01D, var5);
         }
      }

      return var7;
   }

   public String texteTimbre(Structure var1, String var2, int var3, String var4, Date var5) {
      String var6 = "";
      if (var1.getStrcodepays().equals("0056")) {
         var6 = "Si le paiement est en espèces alors le montant des timbres sera de " + var2;
      } else if (var1.getStrcodepays().equals("0138")) {
         var6 = "Si le paiement est en espèces alors le montant des timbres sera de " + var2;
      } else if (var1.getStrcodepays().equals("0202")) {
         if (var3 <= 2012) {
            var6 = "Si le paiement est en espèces alors le montant des timbres sera de " + var2;
         } else if ((var5.getYear() + 1900 != 2015 || var5.getMonth() + 1 < 5) && var5.getYear() + 1900 < 2016) {
            if (var1.getStrid() == 15L) {
               var6 = "ATTENTION:\nDispositions du Code Général des Impôts:\nLe droit de timbres des quittances sur les encaissements en espèce est fixé à 1% (" + var2 + ") lorsque les sommes encaissées sont supérieures à 20.000 Fcfa";
            } else {
               var6 = "Si le paiement est en espèces alors le montant des timbres sera de " + var2;
            }
         } else if (var1.getStrid() == 15L) {
            var6 = "ATTENTION :\nDispositions du Code Général des Impôts :\nLe droit de timbres des quittances sur les encaissements en espèce est fixé à 1% (" + var2 + ") lorsque les sommes encaissées sont supérieures à 100.000 Fcfa";
         } else {
            var6 = "Si le paiement est en espèces alors le montant des timbres sera de " + var2;
         }
      }

      return var6;
   }
}
