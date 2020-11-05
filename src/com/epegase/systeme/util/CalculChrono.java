package com.epegase.systeme.util;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.dao.ChronoDao;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CalculChrono implements Serializable {
   private String baseLog;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private UtilInitHibernate utilInitHibernate;

   public CalculChrono(String var1, UtilInitHibernate var2) {
      this.baseLog = var1;
      this.utilInitHibernate = var2;
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
   }

   public boolean verificationChrono(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      new Chrono();
      Chrono var4 = this.chronoDao.chronoByNat(var1, var2);
      if (var4 != null) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public String numero(int var1, long var2) {
      String var4 = "" + var2;
      return this.completeNumero(var1, var4);
   }

   public String numero(int var1, String var2) {
      return this.completeNumero(var1, var2);
   }

   public String completeNumero(int var1, String var2) {
      boolean var3 = false;
      int var7 = var2.length();
      int var4 = var1 - var7;
      String var5 = "";
      if (var4 == 1) {
         var5 = "0";
      } else if (var4 == 2) {
         var5 = "00";
      } else if (var4 == 3) {
         var5 = "000";
      } else if (var4 == 4) {
         var5 = "0000";
      } else if (var4 == 5) {
         var5 = "00000";
      } else if (var4 == 6) {
         var5 = "000000";
      } else if (var4 == 7) {
         var5 = "0000000";
      } else if (var4 == 8) {
         var5 = "00000000";
      } else if (var4 == 9) {
         var5 = "000000000";
      } else if (var4 == 10) {
         var5 = "0000000000";
      } else if (var4 == 11) {
         var5 = "00000000000";
      } else if (var4 == 12) {
         var5 = "000000000000";
      } else if (var4 == 13) {
         var5 = "0000000000000";
      } else if (var4 == 14) {
         var5 = "00000000000000";
      } else if (var4 == 15) {
         var5 = "000000000000000";
      } else if (var4 == 16) {
         var5 = "0000000000000000";
      } else if (var4 == 17) {
         var5 = "00000000000000000";
      } else if (var4 == 18) {
         var5 = "000000000000000000";
      } else if (var4 == 19) {
         var5 = "0000000000000000000";
      } else if (var4 == 20) {
         var5 = "00000000000000000000";
      }

      String var6 = var5 + "" + var2;
      return var6;
   }

   public String numCompose(Date var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      long var6 = 0L;
      this.chrono = new Chrono();
      String var8 = "";
      var8 = "" + (var1.getYear() + 1900);
      if (var3 == null || var3.isEmpty()) {
         var3 = "";
      }

      this.chrono = this.chronoDao.chronoBySerieNat(var3, var2, var8, var4);
      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var3 + " nature " + var2);
         var5 = "";
      } else {
         var6 = this.enregitrerNumero(var1, var4);
         var5 = this.formattageChrono(this.chrono, var6, "", var3, var1);
      }

      return var5;
   }

   public String numComposeCaisse(Date var1, int var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      String var6 = "";
      long var7 = 0L;
      this.chrono = new Chrono();
      String var9 = "";
      var9 = "" + (var1.getYear() + 1900);
      if (var3 == null || var3.isEmpty()) {
         var3 = "";
      }

      String var10 = "";
      if (var4 != null && !var4.isEmpty() && var4.contains(":")) {
         String[] var11 = var4.split(":");
         var10 = var11[0];
      } else {
         var10 = var4;
      }

      if (var10 != null && !var10.isEmpty()) {
         this.chrono = this.chronoDao.chronoBySerieNat(var3, var10, var2, var9, var5);
      } else {
         this.chrono = this.chronoDao.chronoBySerieNat(var3, var2, var9, var5);
      }

      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var3 + " nature " + var2);
         var6 = "";
      } else {
         var7 = this.enregitrerNumero(var1, var5);
         var6 = this.formattageChrono(this.chrono, var7, "", var3, var1);
      }

      return var6;
   }

   public String numComposeOffice(Date var1, int var2, String var3, long var4, Session var6) throws HibernateException, NamingException {
      String var7 = "";
      long var8 = 0L;
      this.chrono = new Chrono();
      String var10 = "";
      var10 = "" + (var1.getYear() + 1900);
      if (var3 == null || var3.isEmpty()) {
         var3 = "";
      }

      this.chrono = this.chronoDao.chronoBySerieNat(var3, var2, var10, var4, var6);
      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var3 + " nature " + var2);
         var7 = "";
      } else {
         var8 = this.enregitrerNumero(var1, var6);
         var7 = this.formattageChrono(this.chrono, var8, "", var3, var1);
      }

      return var7;
   }

   public String matriculeCompose(Date var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      String var5 = "";
      long var6 = 0L;
      this.chrono = new Chrono();
      if (var3 == null || var3.isEmpty()) {
         var3 = "";
      }

      this.chrono = this.chronoDao.rechercheSalarieNature(var3, var2, var4);
      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var3 + " nature " + var2);
         var5 = "";
      } else {
         var6 = this.enregitrerNumero(var1, var4);
         var5 = this.formattageChrono(this.chrono, var6, "", var3, var1);
      }

      return var5;
   }

   public String matriculeFormattage(String var1, Date var2, int var3, String var4, Session var5) throws HibernateException, NamingException {
      String var6 = "";
      this.chrono = new Chrono();
      if (var4 == null || var4.isEmpty()) {
         var4 = "";
      }

      this.chrono = this.chronoDao.rechercheSalarieNature(var4, var3, var5);
      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var4 + " nature " + var3);
         var6 = "";
      } else {
         var6 = this.formattageChrono(this.chrono, var1, "", var4, var2);
      }

      return var6;
   }

   public String dossierFormattage(String var1, Date var2, int var3, String var4, Session var5) throws HibernateException, NamingException {
      String var6 = "";
      this.chrono = new Chrono();
      if (var4 == null || var4.isEmpty()) {
         var4 = "";
      }

      this.chrono = this.chronoDao.rechercheEleveNature(var4, var3, var5);
      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var4 + " nature " + var3);
         var6 = "";
      } else {
         var6 = this.formattageChrono(this.chrono, var1, "", var4, var2);
      }

      return var6;
   }

   public long enregitrerNumero(Date var1, Session var2) throws HibernateException, NamingException {
      long var3 = 0L;
      if (this.chrono.getChrMode() == 0) {
         this.chrono.setChrNumAn(this.chrono.getChrNumAn() + 1L);
         var3 = this.chrono.getChrNumAn();
      } else if (this.chrono.getChrMode() == 1) {
         String var5 = "";
         if (var1.getMonth() + 1 <= 9) {
            var5 = "0" + (var1.getMonth() + 1);
         } else {
            var5 = "" + (var1.getMonth() + 1);
         }

         if (var5.equalsIgnoreCase("01")) {
            this.chrono.setChrNum01(this.chrono.getChrNum01() + 1L);
            var3 = this.chrono.getChrNum01();
         } else if (var5.equalsIgnoreCase("02")) {
            this.chrono.setChrNum02(this.chrono.getChrNum02() + 1L);
            var3 = this.chrono.getChrNum02();
         } else if (var5.equalsIgnoreCase("03")) {
            this.chrono.setChrNum03(this.chrono.getChrNum03() + 1L);
            var3 = this.chrono.getChrNum03();
         } else if (var5.equalsIgnoreCase("04")) {
            this.chrono.setChrNum04(this.chrono.getChrNum04() + 1L);
            var3 = this.chrono.getChrNum04();
         } else if (var5.equalsIgnoreCase("05")) {
            this.chrono.setChrNum05(this.chrono.getChrNum05() + 1L);
            var3 = this.chrono.getChrNum05();
         } else if (var5.equalsIgnoreCase("06")) {
            this.chrono.setChrNum06(this.chrono.getChrNum06() + 1L);
            var3 = this.chrono.getChrNum06();
         } else if (var5.equalsIgnoreCase("07")) {
            this.chrono.setChrNum07(this.chrono.getChrNum07() + 1L);
            var3 = this.chrono.getChrNum07();
         } else if (var5.equalsIgnoreCase("08")) {
            this.chrono.setChrNum08(this.chrono.getChrNum08() + 1L);
            var3 = this.chrono.getChrNum08();
         } else if (var5.equalsIgnoreCase("09")) {
            this.chrono.setChrNum09(this.chrono.getChrNum09() + 1L);
            var3 = this.chrono.getChrNum09();
         } else if (var5.equalsIgnoreCase("10")) {
            this.chrono.setChrNum10(this.chrono.getChrNum10() + 1L);
            var3 = this.chrono.getChrNum10();
         } else if (var5.equalsIgnoreCase("11")) {
            this.chrono.setChrNum11(this.chrono.getChrNum11() + 1L);
            var3 = this.chrono.getChrNum11();
         } else if (var5.equalsIgnoreCase("12")) {
            this.chrono.setChrNum12(this.chrono.getChrNum12() + 1L);
            var3 = this.chrono.getChrNum12();
         }
      } else if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrNum(this.chrono.getChrNum() + 1L);
         var3 = this.chrono.getChrNum();
      }

      this.chrono = this.chronoDao.modifierChrono(this.chrono, var2);
      return var3;
   }

   public String formattageChrono(Chrono var1, String var2, String var3, Date var4) {
      String var5 = "";
      String var6 = "";
      if (var4 == null) {
         var4 = new Date();
      }

      SimpleDateFormat var7 = new SimpleDateFormat("dd-MM-yyyy");
      String var8 = "" + var7.format(var4);
      String[] var9 = var8.split("-");
      String var10 = var9[0];
      String var11 = var9[1];
      String var12 = var9[2];
      var6 = this.numero(var1.getChrNbCar(), var1.getChrNum());
      if (var1.getChrFormat() == 0) {
         var5 = var6;
      } else if (var1.getChrFormat() == 1) {
         var5 = var11 + "" + var6;
      } else if (var1.getChrFormat() == 2) {
         var5 = var12.subSequence(2, 4) + "" + var11 + "" + var6;
      } else if (var1.getChrFormat() == 3) {
         var5 = var6 + "/" + var12.subSequence(2, 4);
      } else if (var1.getChrFormat() == 4) {
         var5 = var6 + "/" + var12.subSequence(2, 4) + "" + var11;
      } else if (var1.getChrFormat() == 5) {
         var5 = var6 + "/" + var2;
      } else if (var1.getChrFormat() == 6) {
         var5 = var6 + "/" + var11 + "/" + var2;
      } else if (var1.getChrFormat() == 7) {
         var5 = var12 + var11 + var10 + var6;
      } else if (var1.getChrFormat() == 8) {
         var5 = var12.subSequence(2, 4) + "-" + var6;
      } else if (var1.getChrFormat() == 9) {
         var5 = var6 + "/" + var11;
      } else if (var1.getChrFormat() == 10) {
         var5 = var12.subSequence(2, 4) + var6;
      } else if (var1.getChrFormat() == 11) {
         var5 = var6 + "/" + var11 + var10 + var12.subSequence(2, 4);
      } else if (var1.getChrFormat() == 12) {
         var5 = var12 + var6;
      }

      if (var1.getChrPrefixe() != null && !var1.getChrPrefixe().isEmpty()) {
         var5 = var1.getChrPrefixe() + "-" + var5;
      }

      if (var1.getChrSufixe() != null && !var1.getChrSufixe().isEmpty()) {
         var5 = var5 + "-" + var1.getChrSufixe();
      }

      return var5;
   }

   public String formattageChrono(Chrono var1, long var2, String var4, String var5, Date var6) {
      String var7 = "";
      String var8 = "";
      if (var6 == null) {
         var6 = new Date();
      }

      SimpleDateFormat var9 = new SimpleDateFormat("dd-MM-yyyy");
      String var10 = "" + var9.format(var6);
      String[] var11 = var10.split("-");
      String var12 = var11[0];
      String var13 = var11[1];
      String var14 = var11[2];
      var8 = this.numero(var1.getChrNbCar(), var2);
      if (var1.getChrFormat() == 0) {
         var7 = var8;
      } else if (var1.getChrFormat() == 1) {
         var7 = var13 + "" + var8;
      } else if (var1.getChrFormat() == 2) {
         var7 = var14.subSequence(2, 4) + "" + var13 + "" + var8;
      } else if (var1.getChrFormat() == 3) {
         var7 = var8 + "/" + var14.subSequence(2, 4);
      } else if (var1.getChrFormat() == 4) {
         var7 = var8 + "/" + var14.subSequence(2, 4) + "" + var13;
      } else if (var1.getChrFormat() == 5) {
         var7 = var8 + "/" + var4;
      } else if (var1.getChrFormat() == 6) {
         var7 = var8 + "/" + var13 + "/" + var4;
      } else if (var1.getChrFormat() == 7) {
         var7 = var14 + var13 + var12 + var8;
      } else if (var1.getChrFormat() == 8) {
         var7 = var14.subSequence(2, 4) + "-" + var8;
      } else if (var1.getChrFormat() == 9) {
         var7 = var8 + "/" + var13;
      } else if (var1.getChrFormat() == 10) {
         var7 = var14.subSequence(2, 4) + var8;
      } else if (var1.getChrFormat() == 11) {
         var7 = var8 + "/" + var13 + var12 + var14.subSequence(2, 4);
      } else if (var1.getChrFormat() == 12) {
         var7 = var14 + var8;
      }

      if (var1.getChrPrefixe() != null && !var1.getChrPrefixe().isEmpty()) {
         var7 = var1.getChrPrefixe() + "-" + var7;
      }

      if (var1.getChrSufixe() != null && !var1.getChrSufixe().isEmpty()) {
         var7 = var7 + "-" + var1.getChrSufixe();
      }

      return var7;
   }

   public String formattageChrono(Chrono var1, String var2, String var3, String var4, Date var5) {
      String var6 = "";
      String var7 = "";
      if (var5 == null) {
         var5 = new Date();
      }

      SimpleDateFormat var8 = new SimpleDateFormat("dd-MM-yyyy");
      String var9 = "" + var8.format(var5);
      String[] var10 = var9.split("-");
      String var11 = var10[0];
      String var12 = var10[1];
      String var13 = var10[2];
      var7 = this.numero(var1.getChrNbCar(), var2);
      if (var1.getChrFormat() == 0) {
         var6 = var7;
      } else if (var1.getChrFormat() == 1) {
         var6 = var12 + "" + var7;
      } else if (var1.getChrFormat() == 2) {
         var6 = var13.subSequence(2, 4) + "" + var12 + "" + var7;
      } else if (var1.getChrFormat() == 3) {
         var6 = var7 + "/" + var13.subSequence(2, 4);
      } else if (var1.getChrFormat() == 4) {
         var6 = var7 + "/" + var13.subSequence(2, 4) + "" + var12;
      } else if (var1.getChrFormat() == 5) {
         var6 = var7 + "/" + var3;
      } else if (var1.getChrFormat() == 6) {
         var6 = var7 + "/" + var12 + "/" + var3;
      } else if (var1.getChrFormat() == 7) {
         var6 = var13 + var12 + var11 + var7;
      } else if (var1.getChrFormat() == 8) {
         var6 = var13.subSequence(2, 4) + "-" + var7;
      } else if (var1.getChrFormat() == 9) {
         var6 = var7 + "/" + var12;
      } else if (var1.getChrFormat() == 10) {
         var6 = var13.subSequence(2, 4) + var7;
      } else if (var1.getChrFormat() == 11) {
         var6 = var7 + "/" + var12 + var11 + var13.subSequence(2, 4);
      } else if (var1.getChrFormat() == 12) {
         var6 = var13 + var7;
      }

      if (var1.getChrPrefixe() != null && !var1.getChrPrefixe().isEmpty()) {
         var6 = var1.getChrPrefixe() + "-" + var6;
      }

      if (var1.getChrSufixe() != null && !var1.getChrSufixe().isEmpty()) {
         var6 = var6 + "-" + var1.getChrSufixe();
      }

      return var6;
   }

   public String numCompose(Date var1, int var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         String[] var6 = var3.split(":");
         var3 = var6[0];
      }

      String var10 = "";
      long var7 = 0L;
      this.chrono = new Chrono();
      String var9 = "";
      var9 = "" + (var1.getYear() + 1900);
      if (var4 == null || var4.isEmpty()) {
         var4 = "";
      }

      this.chrono = this.chronoDao.chronoBySerieNat(var4, var2, var9, var5);
      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var4 + " nature " + var2);
         var10 = "";
      } else {
         var7 = this.enregitrerNumero(var1, var3, var5);
         var10 = this.formattageChrono(this.chrono, var7, "", var3, var4, var1);
      }

      return var10;
   }

   public String numComposeCaisse(Date var1, int var2, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      if (var3 != null && !var3.isEmpty() && var3.contains(":")) {
         String[] var7 = var3.split(":");
         var3 = var7[0];
      }

      String var13 = "";
      long var8 = 0L;
      this.chrono = new Chrono();
      String var10 = "";
      var10 = "" + (var1.getYear() + 1900);
      if (var4 == null || var4.isEmpty()) {
         var4 = "";
      }

      String var11 = "";
      if (var5 != null && !var5.isEmpty() && var5.contains(":")) {
         String[] var12 = var5.split(":");
         var11 = var12[0];
      } else {
         var11 = var5;
      }

      if (var11 != null && !var11.isEmpty()) {
         this.chrono = this.chronoDao.chronoBySerieNat(var4, var11, var2, var10, var6);
      } else {
         this.chrono = this.chronoDao.chronoBySerieNat(var4, var2, var10, var6);
      }

      if (this.chrono == null) {
         System.out.println("le chrono n'existe pas... serie " + var4 + " nature " + var2);
         var13 = "";
      } else {
         var8 = this.enregitrerNumero(var1, var3, var6);
         var13 = this.formattageChrono(this.chrono, var8, "", var3, var4, var1);
      }

      return var13;
   }

   public long enregitrerNumero(Date var1, String var2, Session var3) throws HibernateException, NamingException {
      long var4 = 0L;
      String var6;
      if (var2.equals("1")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_1(this.chrono.getChrNumAn_1() + 1L);
            var4 = this.chrono.getChrNumAn_1();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_1(this.chrono.getChrNum01_1() + 1L);
               var4 = this.chrono.getChrNum01_1();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_1(this.chrono.getChrNum02_1() + 1L);
               var4 = this.chrono.getChrNum02_1();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_1(this.chrono.getChrNum03_1() + 1L);
               var4 = this.chrono.getChrNum03_1();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_1(this.chrono.getChrNum04_1() + 1L);
               var4 = this.chrono.getChrNum04_1();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_1(this.chrono.getChrNum05_1() + 1L);
               var4 = this.chrono.getChrNum05_1();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_1(this.chrono.getChrNum06_1() + 1L);
               var4 = this.chrono.getChrNum06_1();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_1(this.chrono.getChrNum07_1() + 1L);
               var4 = this.chrono.getChrNum07_1();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_1(this.chrono.getChrNum08_1() + 1L);
               var4 = this.chrono.getChrNum08_1();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_1(this.chrono.getChrNum09_1() + 1L);
               var4 = this.chrono.getChrNum09_1();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_1(this.chrono.getChrNum10_1() + 1L);
               var4 = this.chrono.getChrNum10_1();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_1(this.chrono.getChrNum11_1() + 1L);
               var4 = this.chrono.getChrNum11_1();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_1(this.chrono.getChrNum12_1() + 1L);
               var4 = this.chrono.getChrNum12_1();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_1(this.chrono.getChrNum_1() + 1L);
            var4 = this.chrono.getChrNum_1();
         }
      } else if (var2.equals("2")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_2(this.chrono.getChrNumAn_2() + 1L);
            var4 = this.chrono.getChrNumAn_2();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_2(this.chrono.getChrNum01_2() + 1L);
               var4 = this.chrono.getChrNum01_2();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_2(this.chrono.getChrNum02_2() + 1L);
               var4 = this.chrono.getChrNum02_2();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_2(this.chrono.getChrNum03_2() + 1L);
               var4 = this.chrono.getChrNum03_2();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_2(this.chrono.getChrNum04_2() + 1L);
               var4 = this.chrono.getChrNum04_2();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_2(this.chrono.getChrNum05_2() + 1L);
               var4 = this.chrono.getChrNum05_2();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_2(this.chrono.getChrNum06_2() + 1L);
               var4 = this.chrono.getChrNum06_2();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_2(this.chrono.getChrNum07_2() + 1L);
               var4 = this.chrono.getChrNum07_2();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_2(this.chrono.getChrNum08_2() + 1L);
               var4 = this.chrono.getChrNum08_2();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_2(this.chrono.getChrNum09_2() + 1L);
               var4 = this.chrono.getChrNum09_2();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_2(this.chrono.getChrNum10_2() + 1L);
               var4 = this.chrono.getChrNum10_2();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_2(this.chrono.getChrNum11_2() + 1L);
               var4 = this.chrono.getChrNum11_2();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_2(this.chrono.getChrNum12_2() + 1L);
               var4 = this.chrono.getChrNum12_2();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_2(this.chrono.getChrNum_2() + 1L);
            var4 = this.chrono.getChrNum_2();
         }
      } else if (var2.equals("3")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_3(this.chrono.getChrNumAn_3() + 1L);
            var4 = this.chrono.getChrNumAn_3();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_3(this.chrono.getChrNum01_3() + 1L);
               var4 = this.chrono.getChrNum01_3();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_3(this.chrono.getChrNum02_3() + 1L);
               var4 = this.chrono.getChrNum02_3();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_3(this.chrono.getChrNum03_3() + 1L);
               var4 = this.chrono.getChrNum03_3();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_3(this.chrono.getChrNum04_3() + 1L);
               var4 = this.chrono.getChrNum04_3();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_3(this.chrono.getChrNum05_3() + 1L);
               var4 = this.chrono.getChrNum05_3();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_3(this.chrono.getChrNum06_3() + 1L);
               var4 = this.chrono.getChrNum06_3();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_3(this.chrono.getChrNum07_3() + 1L);
               var4 = this.chrono.getChrNum07_3();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_3(this.chrono.getChrNum08_3() + 1L);
               var4 = this.chrono.getChrNum08_3();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_3(this.chrono.getChrNum09_3() + 1L);
               var4 = this.chrono.getChrNum09_3();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_3(this.chrono.getChrNum10_3() + 1L);
               var4 = this.chrono.getChrNum10_3();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_3(this.chrono.getChrNum11_3() + 1L);
               var4 = this.chrono.getChrNum11_3();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_3(this.chrono.getChrNum12_3() + 1L);
               var4 = this.chrono.getChrNum12_3();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_3(this.chrono.getChrNum_3() + 1L);
            var4 = this.chrono.getChrNum_3();
         }
      } else if (var2.equals("4")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_4(this.chrono.getChrNumAn_4() + 1L);
            var4 = this.chrono.getChrNumAn_4();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_4(this.chrono.getChrNum01_4() + 1L);
               var4 = this.chrono.getChrNum01_4();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_4(this.chrono.getChrNum02_4() + 1L);
               var4 = this.chrono.getChrNum02_4();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_4(this.chrono.getChrNum03_4() + 1L);
               var4 = this.chrono.getChrNum03_4();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_4(this.chrono.getChrNum04_4() + 1L);
               var4 = this.chrono.getChrNum04_4();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_4(this.chrono.getChrNum05_4() + 1L);
               var4 = this.chrono.getChrNum05_4();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_4(this.chrono.getChrNum06_4() + 1L);
               var4 = this.chrono.getChrNum06_4();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_4(this.chrono.getChrNum07_4() + 1L);
               var4 = this.chrono.getChrNum07_4();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_4(this.chrono.getChrNum08_4() + 1L);
               var4 = this.chrono.getChrNum08_4();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_4(this.chrono.getChrNum09_4() + 1L);
               var4 = this.chrono.getChrNum09_4();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_4(this.chrono.getChrNum10_4() + 1L);
               var4 = this.chrono.getChrNum10_4();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_4(this.chrono.getChrNum11_4() + 1L);
               var4 = this.chrono.getChrNum11_4();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_4(this.chrono.getChrNum12_4() + 1L);
               var4 = this.chrono.getChrNum12_4();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_4(this.chrono.getChrNum_4() + 1L);
            var4 = this.chrono.getChrNum_4();
         }
      } else if (var2.equals("5")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_5(this.chrono.getChrNumAn_5() + 1L);
            var4 = this.chrono.getChrNumAn_5();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_5(this.chrono.getChrNum01_5() + 1L);
               var4 = this.chrono.getChrNum01_5();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_5(this.chrono.getChrNum02_5() + 1L);
               var4 = this.chrono.getChrNum02_5();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_5(this.chrono.getChrNum03_5() + 1L);
               var4 = this.chrono.getChrNum03_5();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_5(this.chrono.getChrNum04_5() + 1L);
               var4 = this.chrono.getChrNum04_5();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_5(this.chrono.getChrNum05_5() + 1L);
               var4 = this.chrono.getChrNum05_5();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_5(this.chrono.getChrNum06_5() + 1L);
               var4 = this.chrono.getChrNum06_5();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_5(this.chrono.getChrNum07_5() + 1L);
               var4 = this.chrono.getChrNum07_5();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_5(this.chrono.getChrNum08_5() + 1L);
               var4 = this.chrono.getChrNum08_5();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_5(this.chrono.getChrNum09_5() + 1L);
               var4 = this.chrono.getChrNum09_5();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_5(this.chrono.getChrNum10_5() + 1L);
               var4 = this.chrono.getChrNum10_5();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_5(this.chrono.getChrNum11_5() + 1L);
               var4 = this.chrono.getChrNum11_5();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_5(this.chrono.getChrNum12_5() + 1L);
               var4 = this.chrono.getChrNum12_5();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_5(this.chrono.getChrNum_5() + 1L);
            var4 = this.chrono.getChrNum_5();
         }
      } else if (var2.equals("6")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_6(this.chrono.getChrNumAn_6() + 1L);
            var4 = this.chrono.getChrNumAn_6();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_6(this.chrono.getChrNum01_6() + 1L);
               var4 = this.chrono.getChrNum01_6();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_6(this.chrono.getChrNum02_6() + 1L);
               var4 = this.chrono.getChrNum02_6();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_6(this.chrono.getChrNum03_6() + 1L);
               var4 = this.chrono.getChrNum03_6();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_6(this.chrono.getChrNum04_6() + 1L);
               var4 = this.chrono.getChrNum04_6();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_6(this.chrono.getChrNum05_6() + 1L);
               var4 = this.chrono.getChrNum05_6();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_6(this.chrono.getChrNum06_6() + 1L);
               var4 = this.chrono.getChrNum06_6();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_6(this.chrono.getChrNum07_6() + 1L);
               var4 = this.chrono.getChrNum07_6();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_6(this.chrono.getChrNum08_6() + 1L);
               var4 = this.chrono.getChrNum08_6();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_6(this.chrono.getChrNum09_6() + 1L);
               var4 = this.chrono.getChrNum09_6();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_6(this.chrono.getChrNum10_6() + 1L);
               var4 = this.chrono.getChrNum10_6();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_6(this.chrono.getChrNum11_6() + 1L);
               var4 = this.chrono.getChrNum11_6();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_6(this.chrono.getChrNum12_6() + 1L);
               var4 = this.chrono.getChrNum12_6();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_6(this.chrono.getChrNum_6() + 1L);
            var4 = this.chrono.getChrNum_6();
         }
      } else if (var2.equals("7")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_7(this.chrono.getChrNumAn_7() + 1L);
            var4 = this.chrono.getChrNumAn_7();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_7(this.chrono.getChrNum01_7() + 1L);
               var4 = this.chrono.getChrNum01_7();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_7(this.chrono.getChrNum02_7() + 1L);
               var4 = this.chrono.getChrNum02_7();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_7(this.chrono.getChrNum03_7() + 1L);
               var4 = this.chrono.getChrNum03_7();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_7(this.chrono.getChrNum04_7() + 1L);
               var4 = this.chrono.getChrNum04_7();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_7(this.chrono.getChrNum05_7() + 1L);
               var4 = this.chrono.getChrNum05_7();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_7(this.chrono.getChrNum06_7() + 1L);
               var4 = this.chrono.getChrNum06_7();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_7(this.chrono.getChrNum07_7() + 1L);
               var4 = this.chrono.getChrNum07_7();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_7(this.chrono.getChrNum08_7() + 1L);
               var4 = this.chrono.getChrNum08_7();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_7(this.chrono.getChrNum09_7() + 1L);
               var4 = this.chrono.getChrNum09_7();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_7(this.chrono.getChrNum10_7() + 1L);
               var4 = this.chrono.getChrNum10_7();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_7(this.chrono.getChrNum11_7() + 1L);
               var4 = this.chrono.getChrNum11_7();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_7(this.chrono.getChrNum12_7() + 1L);
               var4 = this.chrono.getChrNum12_7();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum(this.chrono.getChrNum_7() + 1L);
            var4 = this.chrono.getChrNum_7();
         }
      } else if (var2.equals("8")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_8(this.chrono.getChrNumAn_8() + 1L);
            var4 = this.chrono.getChrNumAn_8();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_8(this.chrono.getChrNum01_8() + 1L);
               var4 = this.chrono.getChrNum01_8();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_8(this.chrono.getChrNum02_8() + 1L);
               var4 = this.chrono.getChrNum02_8();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_8(this.chrono.getChrNum03_8() + 1L);
               var4 = this.chrono.getChrNum03_8();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_8(this.chrono.getChrNum04_8() + 1L);
               var4 = this.chrono.getChrNum04_8();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_8(this.chrono.getChrNum05_8() + 1L);
               var4 = this.chrono.getChrNum05_8();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_8(this.chrono.getChrNum06_8() + 1L);
               var4 = this.chrono.getChrNum06_8();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_8(this.chrono.getChrNum07_8() + 1L);
               var4 = this.chrono.getChrNum07_8();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_8(this.chrono.getChrNum08_8() + 1L);
               var4 = this.chrono.getChrNum08_8();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_8(this.chrono.getChrNum09_8() + 1L);
               var4 = this.chrono.getChrNum09_8();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_8(this.chrono.getChrNum10_8() + 1L);
               var4 = this.chrono.getChrNum10_8();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_8(this.chrono.getChrNum11_8() + 1L);
               var4 = this.chrono.getChrNum11_8();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_8(this.chrono.getChrNum12_8() + 1L);
               var4 = this.chrono.getChrNum12_8();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_8(this.chrono.getChrNum_8() + 1L);
            var4 = this.chrono.getChrNum_8();
         }
      } else if (var2.equals("9")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_9(this.chrono.getChrNumAn_9() + 1L);
            var4 = this.chrono.getChrNumAn_9();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_9(this.chrono.getChrNum01_9() + 1L);
               var4 = this.chrono.getChrNum01_9();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_9(this.chrono.getChrNum02_9() + 1L);
               var4 = this.chrono.getChrNum02_9();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_9(this.chrono.getChrNum03_9() + 1L);
               var4 = this.chrono.getChrNum03_9();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_9(this.chrono.getChrNum04_9() + 1L);
               var4 = this.chrono.getChrNum04_9();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_9(this.chrono.getChrNum05_9() + 1L);
               var4 = this.chrono.getChrNum05_9();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_9(this.chrono.getChrNum06_9() + 1L);
               var4 = this.chrono.getChrNum06_9();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_9(this.chrono.getChrNum07_9() + 1L);
               var4 = this.chrono.getChrNum07_9();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_9(this.chrono.getChrNum08_9() + 1L);
               var4 = this.chrono.getChrNum08_9();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_9(this.chrono.getChrNum09_9() + 1L);
               var4 = this.chrono.getChrNum09_9();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_9(this.chrono.getChrNum10_9() + 1L);
               var4 = this.chrono.getChrNum10_9();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_9(this.chrono.getChrNum11_9() + 1L);
               var4 = this.chrono.getChrNum11_9();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_9(this.chrono.getChrNum12_9() + 1L);
               var4 = this.chrono.getChrNum12_9();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_9(this.chrono.getChrNum_9() + 1L);
            var4 = this.chrono.getChrNum_9();
         }
      } else if (var2.equals("10")) {
         if (this.chrono.getChrMode() == 0) {
            this.chrono.setChrNumAn_A(this.chrono.getChrNumAn_A() + 1L);
            var4 = this.chrono.getChrNumAn_A();
         } else if (this.chrono.getChrMode() == 1) {
            var6 = "";
            if (var1.getMonth() + 1 <= 9) {
               var6 = "0" + (var1.getMonth() + 1);
            } else {
               var6 = "" + (var1.getMonth() + 1);
            }

            if (var6.equalsIgnoreCase("01")) {
               this.chrono.setChrNum01_A(this.chrono.getChrNum01_A() + 1L);
               var4 = this.chrono.getChrNum01_A();
            } else if (var6.equalsIgnoreCase("02")) {
               this.chrono.setChrNum02_A(this.chrono.getChrNum02_A() + 1L);
               var4 = this.chrono.getChrNum02_A();
            } else if (var6.equalsIgnoreCase("03")) {
               this.chrono.setChrNum03_A(this.chrono.getChrNum03_A() + 1L);
               var4 = this.chrono.getChrNum03_A();
            } else if (var6.equalsIgnoreCase("04")) {
               this.chrono.setChrNum04_A(this.chrono.getChrNum04_A() + 1L);
               var4 = this.chrono.getChrNum04_A();
            } else if (var6.equalsIgnoreCase("05")) {
               this.chrono.setChrNum05_A(this.chrono.getChrNum05_A() + 1L);
               var4 = this.chrono.getChrNum05_A();
            } else if (var6.equalsIgnoreCase("06")) {
               this.chrono.setChrNum06_A(this.chrono.getChrNum06_A() + 1L);
               var4 = this.chrono.getChrNum06_A();
            } else if (var6.equalsIgnoreCase("07")) {
               this.chrono.setChrNum07_A(this.chrono.getChrNum07_A() + 1L);
               var4 = this.chrono.getChrNum07_A();
            } else if (var6.equalsIgnoreCase("08")) {
               this.chrono.setChrNum08_A(this.chrono.getChrNum08_A() + 1L);
               var4 = this.chrono.getChrNum08_A();
            } else if (var6.equalsIgnoreCase("09")) {
               this.chrono.setChrNum09_A(this.chrono.getChrNum09_A() + 1L);
               var4 = this.chrono.getChrNum09_A();
            } else if (var6.equalsIgnoreCase("10")) {
               this.chrono.setChrNum10_A(this.chrono.getChrNum10_A() + 1L);
               var4 = this.chrono.getChrNum10_A();
            } else if (var6.equalsIgnoreCase("11")) {
               this.chrono.setChrNum11_A(this.chrono.getChrNum11_A() + 1L);
               var4 = this.chrono.getChrNum11_A();
            } else if (var6.equalsIgnoreCase("12")) {
               this.chrono.setChrNum12_A(this.chrono.getChrNum12_A() + 1L);
               var4 = this.chrono.getChrNum12_A();
            }
         } else if (this.chrono.getChrMode() == 2) {
            this.chrono.setChrNum_A(this.chrono.getChrNum_A() + 1L);
            var4 = this.chrono.getChrNum_A();
         }
      } else if (this.chrono.getChrMode() == 0) {
         this.chrono.setChrNumAn(this.chrono.getChrNumAn() + 1L);
         var4 = this.chrono.getChrNumAn();
      } else if (this.chrono.getChrMode() == 1) {
         var6 = "";
         if (var1.getMonth() + 1 <= 9) {
            var6 = "0" + (var1.getMonth() + 1);
         } else {
            var6 = "" + (var1.getMonth() + 1);
         }

         if (var6.equalsIgnoreCase("01")) {
            this.chrono.setChrNum01(this.chrono.getChrNum01() + 1L);
            var4 = this.chrono.getChrNum01();
         } else if (var6.equalsIgnoreCase("02")) {
            this.chrono.setChrNum02(this.chrono.getChrNum02() + 1L);
            var4 = this.chrono.getChrNum02();
         } else if (var6.equalsIgnoreCase("03")) {
            this.chrono.setChrNum03(this.chrono.getChrNum03() + 1L);
            var4 = this.chrono.getChrNum03();
         } else if (var6.equalsIgnoreCase("04")) {
            this.chrono.setChrNum04(this.chrono.getChrNum04() + 1L);
            var4 = this.chrono.getChrNum04();
         } else if (var6.equalsIgnoreCase("05")) {
            this.chrono.setChrNum05(this.chrono.getChrNum05() + 1L);
            var4 = this.chrono.getChrNum05();
         } else if (var6.equalsIgnoreCase("06")) {
            this.chrono.setChrNum06(this.chrono.getChrNum06() + 1L);
            var4 = this.chrono.getChrNum06();
         } else if (var6.equalsIgnoreCase("07")) {
            this.chrono.setChrNum07(this.chrono.getChrNum07() + 1L);
            var4 = this.chrono.getChrNum07();
         } else if (var6.equalsIgnoreCase("08")) {
            this.chrono.setChrNum08(this.chrono.getChrNum08() + 1L);
            var4 = this.chrono.getChrNum08();
         } else if (var6.equalsIgnoreCase("09")) {
            this.chrono.setChrNum09(this.chrono.getChrNum09() + 1L);
            var4 = this.chrono.getChrNum09();
         } else if (var6.equalsIgnoreCase("10")) {
            this.chrono.setChrNum10(this.chrono.getChrNum10() + 1L);
            var4 = this.chrono.getChrNum10();
         } else if (var6.equalsIgnoreCase("11")) {
            this.chrono.setChrNum11(this.chrono.getChrNum11() + 1L);
            var4 = this.chrono.getChrNum11();
         } else if (var6.equalsIgnoreCase("12")) {
            this.chrono.setChrNum12(this.chrono.getChrNum12() + 1L);
            var4 = this.chrono.getChrNum12();
         }
      } else if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrNum(this.chrono.getChrNum() + 1L);
         var4 = this.chrono.getChrNum();
      }

      this.chrono = this.chronoDao.modifierChrono(this.chrono, var3);
      return var4;
   }

   public String formattageChrono(Chrono var1, long var2, String var4, String var5, String var6, Date var7) {
      String var8 = "";
      String var9 = "";
      if (var7 == null) {
         var7 = new Date();
      }

      SimpleDateFormat var10 = new SimpleDateFormat("dd-MM-yyyy");
      String var11 = "" + var10.format(var7);
      String[] var12 = var11.split("-");
      String var13 = var12[0];
      String var14 = var12[1];
      String var15 = var12[2];
      var9 = this.numero(var1.getChrNbCar(), var2);
      if (var1.getChrFormat() == 0) {
         var8 = var9;
      } else if (var1.getChrFormat() == 1) {
         var8 = var14 + "" + var9;
      } else if (var1.getChrFormat() == 2) {
         var8 = var15.subSequence(2, 4) + "" + var14 + "" + var9;
      } else if (var1.getChrFormat() == 3) {
         var8 = var9 + "/" + var15.subSequence(2, 4);
      } else if (var1.getChrFormat() == 4) {
         var8 = var9 + "/" + var15.subSequence(2, 4) + "" + var14;
      } else if (var1.getChrFormat() == 5) {
         var8 = var9 + "/" + var4;
      } else if (var1.getChrFormat() == 6) {
         var8 = var9 + "/" + var14 + "/" + var4;
      } else if (var1.getChrFormat() == 7) {
         var8 = var15 + var14 + var13 + var9;
      } else if (var1.getChrFormat() == 8) {
         var8 = var15.subSequence(2, 4) + "-" + var9;
      } else if (var1.getChrFormat() == 9) {
         var8 = var9 + "/" + var14;
      } else if (var1.getChrFormat() == 10) {
         var8 = var15.subSequence(2, 4) + var9;
      } else if (var1.getChrFormat() == 11) {
         var8 = var9 + "/" + var14 + var13 + var15.subSequence(2, 4);
      } else if (var1.getChrFormat() == 12) {
         var8 = var15 + var9;
      }

      if (var5.equals("1")) {
         if (var1.getChrPrefixe_1() != null && !var1.getChrPrefixe_1().isEmpty()) {
            var8 = var1.getChrPrefixe_1() + "-" + var8;
         }

         if (var1.getChrSufixe_1() != null && !var1.getChrSufixe_1().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_1();
         }
      } else if (var5.equals("2")) {
         if (var1.getChrPrefixe_2() != null && !var1.getChrPrefixe_2().isEmpty()) {
            var8 = var1.getChrPrefixe_2() + "-" + var8;
         }

         if (var1.getChrSufixe_2() != null && !var1.getChrSufixe_2().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_2();
         }
      } else if (var5.equals("3")) {
         if (var1.getChrPrefixe_3() != null && !var1.getChrPrefixe_3().isEmpty()) {
            var8 = var1.getChrPrefixe_3() + "-" + var8;
         }

         if (var1.getChrSufixe_3() != null && !var1.getChrSufixe_3().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_3();
         }
      } else if (var5.equals("4")) {
         if (var1.getChrPrefixe_4() != null && !var1.getChrPrefixe_4().isEmpty()) {
            var8 = var1.getChrPrefixe_4() + "-" + var8;
         }

         if (var1.getChrSufixe_4() != null && !var1.getChrSufixe_4().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_4();
         }
      } else if (var5.equals("5")) {
         if (var1.getChrPrefixe_5() != null && !var1.getChrPrefixe_5().isEmpty()) {
            var8 = var1.getChrPrefixe_5() + "-" + var8;
         }

         if (var1.getChrSufixe_5() != null && !var1.getChrSufixe_5().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_5();
         }
      } else if (var5.equals("6")) {
         if (var1.getChrPrefixe_6() != null && !var1.getChrPrefixe_6().isEmpty()) {
            var8 = var1.getChrPrefixe_6() + "-" + var8;
         }

         if (var1.getChrSufixe_6() != null && !var1.getChrSufixe_6().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_6();
         }
      } else if (var5.equals("7")) {
         if (var1.getChrPrefixe_7() != null && !var1.getChrPrefixe_7().isEmpty()) {
            var8 = var1.getChrPrefixe_7() + "-" + var8;
         }

         if (var1.getChrSufixe_7() != null && !var1.getChrSufixe_7().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_7();
         }
      } else if (var5.equals("8")) {
         if (var1.getChrPrefixe_8() != null && !var1.getChrPrefixe_8().isEmpty()) {
            var8 = var1.getChrPrefixe_8() + "-" + var8;
         }

         if (var1.getChrSufixe_8() != null && !var1.getChrSufixe_8().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_8();
         }
      } else if (var5.equals("9")) {
         if (var1.getChrPrefixe_9() != null && !var1.getChrPrefixe_9().isEmpty()) {
            var8 = var1.getChrPrefixe_9() + "-" + var8;
         }

         if (var1.getChrSufixe_9() != null && !var1.getChrSufixe_9().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_9();
         }
      } else if (var5.equals("10")) {
         if (var1.getChrPrefixe_A() != null && !var1.getChrPrefixe_A().isEmpty()) {
            var8 = var1.getChrPrefixe_A() + "-" + var8;
         }

         if (var1.getChrSufixe_A() != null && !var1.getChrSufixe_A().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe_A();
         }
      } else {
         if (var1.getChrPrefixe() != null && !var1.getChrPrefixe().isEmpty()) {
            var8 = var1.getChrPrefixe() + "-" + var8;
         }

         if (var1.getChrSufixe() != null && !var1.getChrSufixe().isEmpty()) {
            var8 = var8 + "-" + var1.getChrSufixe();
         }
      }

      return var8;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }
}
