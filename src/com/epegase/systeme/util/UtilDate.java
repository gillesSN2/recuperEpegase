package com.epegase.systeme.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class UtilDate implements Serializable {
   public SimpleDateFormat formatterSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   public SimpleDateFormat formatterSQLLight = new SimpleDateFormat("yyyy-MM-dd");
   public SimpleDateFormat formatterFr = new SimpleDateFormat("dd-MM-yyyy");
   public SimpleDateFormat formatterFrComplet = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
   public SimpleDateFormat formatterFrLg = new SimpleDateFormat("dd/MM/yy");
   public SimpleDateFormat formatterFrCpt = new SimpleDateFormat("EEEEE dd MMMMM yyyy");

   public Date stringToDateSQL(String var1) throws ParseException {
      return this.formatterSQL.parse(var1);
   }

   public String dateToStringSQL(Date var1) {
      return this.formatterSQL.format(var1);
   }

   public Date stringToDateSQLLight(String var1) throws ParseException {
      return this.formatterSQLLight.parse(var1);
   }

   public String dateToStringSQLLight(Date var1) {
      return this.formatterSQLLight.format(var1);
   }

   public Date stringToDateFr(String var1) throws ParseException {
      return this.formatterFr.parse(var1);
   }

   public Date stringToDateFrLg(String var1) throws ParseException {
      return this.formatterFrLg.parse(var1);
   }

   public Date stringToDateFrComplet(String var1) throws ParseException {
      return this.formatterFrComplet.parse(var1);
   }

   public String dateToStringFr(Date var1) {
      return this.formatterFr.format(var1);
   }

   public String dateToStringFrLg(Date var1) {
      return this.formatterFrLg.format(var1);
   }

   public String dateToStringFrCpt(Date var1) {
      return this.formatterFrCpt.format(var1);
   }

   public String dateToStringFrComplet(Date var1) {
      return this.formatterFrComplet.format(var1);
   }

   public Date dateToSQLLight(Date var1) throws ParseException {
      String var2 = null;
      int var3 = var1.getDate();
      String var4 = "";
      if (var3 <= 9) {
         var4 = "0" + var3;
      } else {
         var4 = "" + var3;
      }

      int var5 = var1.getMonth() + 1;
      String var6 = "";
      if (var5 <= 9) {
         var6 = "0" + var5;
      } else {
         var6 = "" + var5;
      }

      int var7 = var1.getYear() + 1900;
      var2 = var7 + "-" + var6 + "-" + var4;
      return this.formatterSQLLight.parse(var2);
   }

   public String date2ToSQLLight(Date var1) throws ParseException {
      String var2 = null;
      int var3 = var1.getDate();
      String var4 = "";
      if (var3 <= 9) {
         var4 = "0" + var3;
      } else {
         var4 = "" + var3;
      }

      int var5 = var1.getMonth() + 1;
      String var6 = "";
      if (var5 <= 9) {
         var6 = "0" + var5;
      } else {
         var6 = "" + var5;
      }

      int var7 = var1.getYear() + 1900;
      var2 = var7 + "-" + var6 + "-" + var4;
      return var2;
   }

   public Date dateToSQL(Date var1, String var2, String var3, String var4) throws ParseException {
      String var5 = null;
      int var6 = var1.getDate();
      String var7 = "";
      if (var6 <= 9) {
         var7 = "0" + var6;
      } else {
         var7 = "" + var6;
      }

      int var8 = var1.getMonth() + 1;
      String var9 = "";
      if (var8 <= 9) {
         var9 = "0" + var8;
      } else {
         var9 = "" + var8;
      }

      int var10 = var1.getYear() + 1900;
      if (var2 == null || var2.isEmpty()) {
         var2 = "00";
      }

      if (var3 == null || var3.isEmpty()) {
         var3 = "00";
      }

      if (var4 == null || var4.isEmpty()) {
         var4 = "00";
      }

      var5 = var10 + "-" + var9 + "-" + var7 + " " + var2 + ":" + var3 + ":" + var4;
      return this.formatterSQL.parse(var5);
   }

   public Date CalculDateEcheance(Date var1, int var2, int var3, int var4) throws ParseException {
      Date var5 = null;
      if (var1 == null) {
         var1 = new Date();
      }

      if (var2 != 0 && var2 != 5) {
         if (var2 == 1) {
            var5 = this.datedevaleurTheo(var1, var3);
            if (var4 != 0) {
               var5 = this.dateEcheanceArrondi(var5, var4);
            }
         } else if (var2 == 2) {
            int var6 = var3 / 30;
            if (var6 >= 1) {
               long var7 = (long)(var1.getYear() + 1900);
               int var9 = var1.getMonth() + 1 + var6;
               if (var9 > 13) {
                  var9 -= 12;
                  ++var7;
               }

               String var10 = "";
               if (var9 <= 9) {
                  var10 = "0" + var9;
               } else {
                  var10 = "" + var9;
               }

               String var11 = "01";
               Date var12 = this.stringToDateSQLLight(var7 + "-" + var10 + "-" + var11);
               var5 = this.dateDernierJourMois(var12);
            } else {
               this.dateDernierJourMois(var1);
               var5 = this.datedevaleurTheo(var1, var3);
            }

            if (var4 != 0) {
               var5 = this.dateEcheanceArrondi(var5, var4);
            }
         } else if (var2 == 3) {
            var5 = var1;
         } else if (var2 == 4) {
            var5 = this.datedevaleurTheo(var1, var3);
            if (var4 != 0) {
               var5 = this.dateEcheanceArrondi(var5, var4);
            }
         } else {
            var5 = null;
         }
      } else {
         var5 = var1;
      }

      return var5;
   }

   public Date datedevaleurTheo(Date var1, int var2) {
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var1);
      var4.add(5, var2);
      Date var5 = var4.getTime();
      return var5;
   }

   public Date datedevaleurMois(Date var1, int var2) {
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var1);
      var4.add(2, var2);
      Date var5 = var4.getTime();
      return var5;
   }

   public Date dateEcheanceArrondi(Date var1, int var2) {
      Calendar var3 = Calendar.getInstance();
      var3.setTime(var1);
      SimpleDateFormat var4 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE);
      String var5 = var4.format(var1);
      String[] var6 = var5.split("-");
      int var7 = Integer.parseInt(var6[0]);
      GregorianCalendar var8;
      if (var7 <= var2) {
         var8 = new GregorianCalendar();
         var8.setTime(var1);
         var8.add(5, -var7);
         var8.add(5, var2);
         var1 = var8.getTime();
      } else {
         var8 = new GregorianCalendar();
         var8.setTime(var1);
         var8.add(5, -var7);
         var8.add(2, 1);
         var8.add(5, var2 + 1);
         var1 = var8.getTime();
      }

      return var1;
   }

   public Date datePremierJourMois(Date var1) throws ParseException {
      String var2 = "01";
      String var3 = "";
      if (var1.getMonth() + 1 <= 9) {
         var3 = "0" + (var1.getMonth() + 1);
      } else {
         var3 = "" + (var1.getMonth() + 1);
      }

      String var4 = "" + (var1.getYear() + 1900);
      String var5 = var4 + "-" + var3 + "-" + var2;
      Date var6 = this.stringToDateSQLLight(var5);
      return var6;
   }

   public Date dateDernierJourMois(Date var1) throws ParseException {
      byte var2 = 31;
      int var3 = var1.getMonth() + 1;
      int var4 = var1.getYear() + 1900;
      var1 = this.stringToDateSQLLight(var4 + "-" + var3 + "-" + var2);
      if (var1.getMonth() + 1 != var3) {
         var2 = 30;
         var1 = this.stringToDateSQLLight(var4 + "-" + var3 + "-" + var2);
         if (var1.getMonth() + 1 != var3) {
            var2 = 29;
            var1 = this.stringToDateSQLLight(var4 + "-" + var3 + "-" + var2);
            if (var1.getMonth() + 1 != var3) {
               var2 = 28;
               var1 = this.stringToDateSQLLight(var4 + "-" + var3 + "-" + var2);
            }
         }
      }

      return var1;
   }

   public Date datePremierJourAnneePrecedente(Date var1) throws ParseException {
      String var2 = "01";
      String var3 = "";
      if (var1.getMonth() + 1 <= 9) {
         var3 = "0" + (var1.getMonth() + 1);
      } else {
         var3 = "" + (var1.getMonth() + 1);
      }

      String var4 = "" + (var1.getYear() + 1900 - 1);
      String var5 = var4 + "-" + var3 + "-" + var2;
      Date var6 = this.stringToDateSQLLight(var5);
      return var6;
   }

   public Date dateMoisSuivant(Date var1) throws ParseException {
      byte var2 = 1;
      int var3 = var1.getMonth() + 1;
      int var4 = var1.getYear() + 1900;
      ++var3;
      if (var3 > 12) {
         var3 = 1;
         ++var4;
      }

      String var5 = "";
      if (var2 <= 9) {
         var5 = "0" + var2;
      } else {
         var5 = "" + var2;
      }

      String var6 = "";
      if (var3 <= 9) {
         var6 = "0" + var3;
      } else {
         var6 = "" + var3;
      }

      var1 = this.stringToDateSQLLight(var4 + "-" + var6 + "-" + var5);
      return var1;
   }

   public Date dateMoisSuivant(Date var1, int var2) throws ParseException {
      boolean var3 = false;
      if (var2 >= 29) {
         var3 = true;
         var2 = 28;
      }

      int var4 = var1.getMonth() + 1;
      int var5 = var1.getYear() + 1900;
      ++var4;
      if (var4 > 12) {
         var4 = 1;
         ++var5;
      }

      String var6 = "";
      if (var2 <= 9) {
         var6 = "0" + var2;
      } else {
         var6 = "" + var2;
      }

      String var7 = "";
      if (var4 <= 9) {
         var7 = "0" + var4;
      } else {
         var7 = "" + var4;
      }

      var1 = this.stringToDateSQLLight(var5 + "-" + var7 + "-" + var6);
      if (var3) {
         this.dateDernierJourMois(var1);
      }

      return var1;
   }

   public Date dateMoisPrecedent(Date var1) throws ParseException {
      byte var2 = 1;
      int var3 = var1.getMonth() + 1;
      int var4 = var1.getYear() + 1900;
      --var3;
      if (var3 < 1) {
         var3 = 12;
         --var4;
      }

      String var5 = "";
      if (var2 <= 9) {
         var5 = "0" + var2;
      } else {
         var5 = "" + var2;
      }

      String var6 = "";
      if (var3 <= 9) {
         var6 = "0" + var3;
      } else {
         var6 = "" + var3;
      }

      var1 = this.stringToDateSQLLight(var4 + "-" + var6 + "-" + var5);
      return var1;
   }

   public Date dateJourPrecedent(Date var1) throws ParseException {
      int var2 = var1.getDate();
      int var3 = var1.getMonth() + 1;
      int var4 = var1.getYear() + 1900;
      --var2;
      if (var2 < 1) {
         --var3;
         if (var3 < 1) {
            var3 = 12;
            --var4;
         }

         if (var3 != 1 && var3 != 3 && var3 != 5 && var3 != 7 && var3 != 8 && var3 != 10 && var3 != 12) {
            if (var3 != 4 && var3 != 6 && var3 != 9 && var3 != 11) {
               if (var3 == 2) {
                  int var5 = (int)Math.IEEEremainder((double)var4, 4.0D);
                  if (var5 == 0) {
                     var2 = 29;
                  } else {
                     var2 = 28;
                  }
               }
            } else {
               var2 = 30;
            }
         } else {
            var2 = 31;
         }
      }

      String var7 = "";
      if (var2 <= 9) {
         var7 = "0" + var2;
      } else {
         var7 = "" + var2;
      }

      String var6 = "";
      if (var3 <= 9) {
         var6 = "0" + var3;
      } else {
         var6 = "" + var3;
      }

      var1 = this.stringToDateSQLLight(var4 + "-" + var6 + "-" + var7);
      return var1;
   }

   public Date dateJourSuivant(Date var1) throws ParseException {
      int var2 = var1.getDate();
      int var3 = var1.getMonth() + 1;
      int var4 = var1.getYear() + 1900;
      ++var2;
      if (var2 < 1) {
         ++var3;
         if (var3 < 1) {
            var3 = 12;
            ++var4;
         }

         if (var3 != 1 && var3 != 3 && var3 != 5 && var3 != 7 && var3 != 8 && var3 != 10 && var3 != 12) {
            if (var3 != 4 && var3 != 6 && var3 != 9 && var3 != 11) {
               if (var3 == 2) {
                  int var5 = (int)Math.IEEEremainder((double)var4, 4.0D);
                  if (var5 == 0) {
                     var2 = 29;
                  } else {
                     var2 = 28;
                  }
               }
            } else {
               var2 = 30;
            }
         } else {
            var2 = 31;
         }
      }

      String var7 = "";
      if (var2 <= 9) {
         var7 = "0" + var2;
      } else {
         var7 = "" + var2;
      }

      String var6 = "";
      if (var3 <= 9) {
         var6 = "0" + var3;
      } else {
         var6 = "" + var3;
      }

      var1 = this.stringToDateSQLLight(var4 + "-" + var6 + "-" + var7);
      return var1;
   }

   public Date datePremierJourAnnee(Date var1) throws ParseException {
      byte var2 = 1;
      byte var3 = 1;
      int var4 = var1.getYear() + 1900;
      var1 = this.stringToDateSQLLight(var4 + "-" + var3 + "-" + var2);
      return var1;
   }

   public Date dateDernierJourAnnee(Date var1) throws ParseException {
      byte var2 = 31;
      byte var3 = 12;
      int var4 = var1.getYear() + 1900;
      var1 = this.stringToDateSQLLight(var4 + "-" + var3 + "-" + var2);
      return var1;
   }

   public String dateToPeriodeFr(Date var1) {
      String var2 = "";
      int var3 = var1.getMonth() + 1;
      String var4 = "";
      if (var3 <= 9) {
         var4 = "0" + var3;
      } else {
         var4 = "" + var3;
      }

      int var5 = var1.getYear() + 1900;
      var2 = var4 + ":" + var5;
      return var2;
   }

   public String dateToPeriodeUs(Date var1) {
      String var2 = "";
      int var3 = var1.getMonth() + 1;
      String var4 = "";
      if (var3 <= 9) {
         var4 = "0" + var3;
      } else {
         var4 = "" + var3;
      }

      int var5 = var1.getYear() + 1900;
      var2 = var5 + ":" + var4;
      return var2;
   }

   public Date calculDateTrf(String var1, int var2) throws ParseException {
      Date var3 = null;
      String[] var4 = var1.split(":");
      String var5 = "";
      if (var2 <= 9) {
         var5 = "0" + var2;
      } else {
         var5 = "" + var2;
      }

      String var6 = var4[0];
      String var7 = var4[1];
      if (!var6.equals("02") || !var5.equals("29") && !var5.equals("30") && !var5.equals("31")) {
         if ((var6.equals("04") || var6.equals("06") || var6.equals("06") || var6.equals("09") || var6.equals("11")) && var5.equals("31")) {
            var5 = "30";
         }
      } else {
         var5 = "28";
      }

      String var8 = var7 + "-" + var6 + "-" + var5;
      var3 = this.stringToDateSQLLight(var8);
      return var3;
   }

   public int dateNbJourMois(Date var1) throws ParseException {
      Date var2 = this.datePremierJourMois(var1);
      Date var3 = this.dateDernierJourMois(var1);
      byte var4 = 1;
      byte var5 = 12;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      Calendar var9 = Calendar.getInstance();
      Calendar var10 = Calendar.getInstance();
      Calendar var11 = Calendar.getInstance();
      var9.setTime(var2);
      var10.setTime(var3);
      int var13 = 0;

      while(true) {
         do {
            if (!var9.before(var10)) {
               int var12 = var13 / var5;
               var13 -= var12 * var5;
               var11 = Calendar.getInstance();
               var11.setTime(var2);
               var11.add(1, var12);
               var11.add(2, var13);
               int var14 = (int)((var10.getTimeInMillis() - var11.getTimeInMillis()) / 86400000L) + 1;
               return var14;
            }

            var9.add(2, var4);
         } while(!var9.before(var10) && !var9.equals(var10));

         ++var13;
      }
   }

   public int dateNbJourMois(Date var1, Date var2) throws ParseException {
      byte var3 = 1;
      byte var4 = 12;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      Calendar var8 = Calendar.getInstance();
      Calendar var9 = Calendar.getInstance();
      Calendar var10 = Calendar.getInstance();
      var8.setTime(var1);
      var9.setTime(var2);
      int var12 = 0;

      while(true) {
         do {
            if (!var8.before(var9)) {
               int var11 = var12 / var4;
               var12 -= var11 * var4;
               var10 = Calendar.getInstance();
               var10.setTime(var1);
               var10.add(1, var11);
               var10.add(2, var12);
               int var13 = (int)((var9.getTimeInMillis() - var10.getTimeInMillis()) / 86400000L) + 1;
               return var13;
            }

            var8.add(2, var3);
         } while(!var8.before(var9) && !var8.equals(var9));

         ++var12;
      }
   }
}
