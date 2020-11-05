package com.epegase.systeme.util;

import com.epegase.systeme.control.TransfertCompta;
import com.epegase.systeme.control.TransfertPaye;
import com.epegase.systeme.control.TransfertTiers;
import com.epegase.systeme.control.TransfertVentes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilExcel implements Serializable {
   public List lectureFichierPaye(File var1, long var2) {
      TransfertPaye var4 = new TransfertPaye();
      ArrayList var5 = new ArrayList();

      try {
         POIFSFileSystem var6 = new POIFSFileSystem(new FileInputStream(var1));
         HSSFWorkbook var7 = new HSSFWorkbook(var6);
         HSSFSheet var8 = var7.getSheetAt(0);
         HSSFRow var9 = null;
         HSSFCell var10 = null;
         int var11 = 1;
         String var12 = "";
         boolean var13 = false;
         boolean var14 = false;
         boolean var15 = false;
         boolean var16 = false;
         String var17 = "";
         String var18 = "";

         for(int var19 = 0; var19 < var7.getNumberOfSheets(); ++var19) {
            var8 = var7.getSheetAt(var19);
            var17 = var7.getSheetName(var19).toString();
            if (var13) {
               var5.add(var4);
               var4 = new TransfertPaye();
               var4.setTrfNomFeuille(var17);
               var4.setTrfPeriode(var18);
            } else if (var14) {
               var5.add(var4);
               var4 = new TransfertPaye();
               var4.setTrfNomFeuille(var17);
               var4.setTrfPeriode(var18);
            } else if (var15) {
               var5.add(var4);
               var4 = new TransfertPaye();
               var4.setTrfNomFeuille(var17);
               var4.setTrfPeriode("");
            } else if (var16 && var2 == 179L) {
               var5.add(var4);
               var4 = new TransfertPaye();
               var4.setTrfNomFeuille(var17);
               var4.setTrfPeriode("POINTAGE-OMEGA");
               var4.setTrfColT00("POINTAGE-OMEGA");
            }

            var13 = false;
            var14 = false;
            var15 = false;
            var16 = false;
            var12 = "";

            label404:
            for(Iterator var20 = var8.rowIterator(); var20.hasNext(); ++var11) {
               var9 = (HSSFRow)var20.next();
               if (var13) {
                  var5.add(var4);
                  var4 = new TransfertPaye();
                  var4.setTrfNomFeuille(var17);
                  var4.setTrfPeriode(var18);
               } else if (var14) {
                  var5.add(var4);
                  var4 = new TransfertPaye();
                  var4.setTrfNomFeuille(var17);
                  var4.setTrfPeriode(var18);
               } else if (var15) {
                  var5.add(var4);
                  var4 = new TransfertPaye();
                  var4.setTrfNomFeuille(var17);
                  var4.setTrfPeriode("");
               } else if (var16 && var2 == 179L) {
                  var5.add(var4);
                  var4 = new TransfertPaye();
                  var4.setTrfNomFeuille(var17);
                  var4.setTrfPeriode("POINTAGE-OMEGA");
                  var4.setTrfColT00("POINTAGE-OMEGA");
               }

               Iterator var21 = var9.cellIterator();

               while(true) {
                  while(true) {
                     while(true) {
                        if (!var21.hasNext()) {
                           continue label404;
                        }

                        var10 = (HSSFCell)var21.next();
                        switch(var10.getCellType()) {
                        case 0:
                           var12 = Double.toString(var10.getNumericCellValue());
                           break;
                        case 1:
                           var12 = var10.getStringCellValue();
                           break;
                        case 2:
                           var12 = Double.toString(0.0D);
                           break;
                        case 3:
                           var12 = Double.toString(0.0D);
                           break;
                        case 4:
                           var12 = Boolean.toString(var10.getBooleanCellValue());
                        }

                        if (var12.equals("RUBRIQUE")) {
                           var13 = true;
                           var4 = new TransfertPaye();
                           var4.setTrfNomFeuille(var17);
                           var4.setTrfPeriode(var18);
                           var4.setTrfColT00("RUBRIQUE");
                        } else if (var12.equals("CHAMP")) {
                           var14 = true;
                           var4 = new TransfertPaye();
                           var4.setTrfNomFeuille(var17);
                           var4.setTrfPeriode("CHAMP");
                           var4.setTrfColT00("CHAMP");
                        } else if (!var15 && var12.startsWith("sal_")) {
                           var15 = true;
                           var4 = new TransfertPaye();
                           var4.setTrfNomFeuille(var17);
                        } else if (!var13 && !var15 && !var14 && var12.equals("Matricule") && var2 == 179L) {
                           var16 = true;
                           var4 = new TransfertPaye();
                           var4.setTrfPeriode("POINTAGE-OMEGA");
                           var4.setTrfColT00("POINTAGE-OMEGA");
                           var4.setTrfNomFeuille(var17);
                        }

                        if (var13) {
                           int var22;
                           if (var10.getColumnIndex() == 0) {
                              if (var12.contains(".")) {
                                 var22 = var12.indexOf(".");
                                 var4.setTrfColT00(var12.substring(0, var22));
                              } else {
                                 var4.setTrfColT00(var12);
                              }

                              if (var4.getTrfColT00() != null && !var4.getTrfColT00().isEmpty() && var4.getTrfColT00().equals("0")) {
                                 var4.setTrfColT00("");
                              }
                           } else if (var10.getColumnIndex() == 1) {
                              if (var12.contains(".")) {
                                 var22 = var12.indexOf(".");
                                 var4.setTrfColT01(var12.substring(0, var22));
                              } else {
                                 var4.setTrfColT01(var12);
                              }

                              if (var4.getTrfColT01() != null && !var4.getTrfColT01().isEmpty() && var4.getTrfColT01().equals("0")) {
                                 var4.setTrfColT01("");
                              }
                           } else if (var10.getColumnIndex() == 2) {
                              if (var12.contains(".")) {
                                 var22 = var12.indexOf(".");
                                 var4.setTrfColT02(var12.substring(0, var22));
                              } else {
                                 var4.setTrfColT02(var12);
                              }

                              if (var4.getTrfColT02() != null && !var4.getTrfColT02().isEmpty() && var4.getTrfColT02().equals("0")) {
                                 var4.setTrfColT02("");
                              }
                           } else if (var10.getColumnIndex() == 3) {
                              var4.setTrfColT03(var12);
                           } else if (var10.getColumnIndex() == 4) {
                              var4.setTrfColT04(var12);
                              if (var18 == null || var18.isEmpty()) {
                                 var18 = var12;
                              }
                           } else if (var10.getColumnIndex() == 5) {
                              var4.setTrfColT05(var12);
                           } else if (var10.getColumnIndex() == 6) {
                              var4.setTrfColT06(var12);
                           } else if (var10.getColumnIndex() == 7) {
                              var4.setTrfColT07(var12);
                           } else if (var10.getColumnIndex() == 8) {
                              var4.setTrfColT08(var12);
                           } else if (var10.getColumnIndex() == 9) {
                              var4.setTrfColT09(var12);
                           } else if (var10.getColumnIndex() == 10) {
                              var4.setTrfColT10(var12);
                           } else if (var10.getColumnIndex() == 11) {
                              var4.setTrfColT11(var12);
                           } else if (var10.getColumnIndex() == 12) {
                              var4.setTrfColT12(var12);
                           } else if (var10.getColumnIndex() == 13) {
                              var4.setTrfColT13(var12);
                           } else if (var10.getColumnIndex() == 14) {
                              var4.setTrfColT14(var12);
                           } else if (var10.getColumnIndex() == 15) {
                              var4.setTrfColT15(var12);
                           } else if (var10.getColumnIndex() == 16) {
                              var4.setTrfColT16(var12);
                           } else if (var10.getColumnIndex() == 17) {
                              var4.setTrfColT17(var12);
                           } else if (var10.getColumnIndex() == 18) {
                              var4.setTrfColT18(var12);
                           } else if (var10.getColumnIndex() == 19) {
                              var4.setTrfColT19(var12);
                           } else if (var10.getColumnIndex() == 20) {
                              var4.setTrfColT20(var12);
                           } else if (var10.getColumnIndex() == 21) {
                              var4.setTrfColT21(var12);
                           } else if (var10.getColumnIndex() == 22) {
                              var4.setTrfColT22(var12);
                           } else if (var10.getColumnIndex() == 23) {
                              var4.setTrfColT23(var12);
                           } else if (var10.getColumnIndex() == 24) {
                              var4.setTrfColT24(var12);
                           } else if (var10.getColumnIndex() == 25) {
                              var4.setTrfColT25(var12);
                           } else if (var10.getColumnIndex() == 26) {
                              var4.setTrfColT26(var12);
                           } else if (var10.getColumnIndex() == 27) {
                              var4.setTrfColT27(var12);
                           } else if (var10.getColumnIndex() == 28) {
                              var4.setTrfColT28(var12);
                           } else if (var10.getColumnIndex() == 29) {
                              var4.setTrfColT29(var12);
                           } else if (var10.getColumnIndex() == 30) {
                              var4.setTrfColT30(var12);
                           } else if (var10.getColumnIndex() == 31) {
                              var4.setTrfColT31(var12);
                           } else if (var10.getColumnIndex() == 32) {
                              var4.setTrfColT32(var12);
                           } else if (var10.getColumnIndex() == 33) {
                              var4.setTrfColT33(var12);
                           } else if (var10.getColumnIndex() == 34) {
                              var4.setTrfColT34(var12);
                           } else if (var10.getColumnIndex() == 35) {
                              var4.setTrfColT35(var12);
                           } else if (var10.getColumnIndex() == 36) {
                              var4.setTrfColT36(var12);
                           } else if (var10.getColumnIndex() == 37) {
                              var4.setTrfColT37(var12);
                           } else if (var10.getColumnIndex() == 38) {
                              var4.setTrfColT38(var12);
                           } else if (var10.getColumnIndex() == 39) {
                              var4.setTrfColT39(var12);
                           } else if (var10.getColumnIndex() == 40) {
                              var4.setTrfColT40(var12);
                           }
                        } else if (var15 || var14 || var16) {
                           if (var10.getColumnIndex() == 0) {
                              var4.setTrfColT00(var12);
                           } else if (var10.getColumnIndex() == 1) {
                              var4.setTrfColT01(var12);
                           } else if (var10.getColumnIndex() == 2) {
                              var4.setTrfColT02(var12);
                           } else if (var10.getColumnIndex() == 3) {
                              var4.setTrfColT03(var12);
                           } else if (var10.getColumnIndex() == 4) {
                              var4.setTrfColT04(var12);
                           } else if (var10.getColumnIndex() == 5) {
                              var4.setTrfColT05(var12);
                           } else if (var10.getColumnIndex() == 6) {
                              var4.setTrfColT06(var12);
                           } else if (var10.getColumnIndex() == 7) {
                              var4.setTrfColT07(var12);
                           } else if (var10.getColumnIndex() == 8) {
                              var4.setTrfColT08(var12);
                           } else if (var10.getColumnIndex() == 9) {
                              var4.setTrfColT09(var12);
                           } else if (var10.getColumnIndex() == 10) {
                              var4.setTrfColT10(var12);
                           } else if (var10.getColumnIndex() == 11) {
                              var4.setTrfColT11(var12);
                           } else if (var10.getColumnIndex() == 12) {
                              var4.setTrfColT12(var12);
                           } else if (var10.getColumnIndex() == 13) {
                              var4.setTrfColT13(var12);
                           } else if (var10.getColumnIndex() == 14) {
                              var4.setTrfColT14(var12);
                           } else if (var10.getColumnIndex() == 15) {
                              var4.setTrfColT15(var12);
                           } else if (var10.getColumnIndex() == 16) {
                              var4.setTrfColT16(var12);
                           } else if (var10.getColumnIndex() == 17) {
                              var4.setTrfColT17(var12);
                           } else if (var10.getColumnIndex() == 18) {
                              var4.setTrfColT18(var12);
                           } else if (var10.getColumnIndex() == 19) {
                              var4.setTrfColT19(var12);
                           } else if (var10.getColumnIndex() == 20) {
                              var4.setTrfColT20(var12);
                           } else if (var10.getColumnIndex() == 21) {
                              var4.setTrfColT21(var12);
                           } else if (var10.getColumnIndex() == 22) {
                              var4.setTrfColT22(var12);
                           } else if (var10.getColumnIndex() == 23) {
                              var4.setTrfColT23(var12);
                           } else if (var10.getColumnIndex() == 24) {
                              var4.setTrfColT24(var12);
                           } else if (var10.getColumnIndex() == 25) {
                              var4.setTrfColT25(var12);
                           } else if (var10.getColumnIndex() == 26) {
                              var4.setTrfColT26(var12);
                           } else if (var10.getColumnIndex() == 27) {
                              var4.setTrfColT27(var12);
                           } else if (var10.getColumnIndex() == 28) {
                              var4.setTrfColT28(var12);
                           } else if (var10.getColumnIndex() == 29) {
                              var4.setTrfColT29(var12);
                           } else if (var10.getColumnIndex() == 30) {
                              var4.setTrfColT30(var12);
                           } else if (var10.getColumnIndex() == 31) {
                              var4.setTrfColT31(var12);
                           } else if (var10.getColumnIndex() == 32) {
                              var4.setTrfColT32(var12);
                           } else if (var10.getColumnIndex() == 33) {
                              var4.setTrfColT33(var12);
                           } else if (var10.getColumnIndex() == 34) {
                              var4.setTrfColT34(var12);
                           } else if (var10.getColumnIndex() == 35) {
                              var4.setTrfColT35(var12);
                           } else if (var10.getColumnIndex() == 36) {
                              var4.setTrfColT36(var12);
                           } else if (var10.getColumnIndex() == 37) {
                              var4.setTrfColT37(var12);
                           } else if (var10.getColumnIndex() == 38) {
                              var4.setTrfColT38(var12);
                           } else if (var10.getColumnIndex() == 39) {
                              var4.setTrfColT39(var12);
                           } else if (var10.getColumnIndex() == 40) {
                              var4.setTrfColT40(var12);
                           }
                        }
                     }
                  }
               }
            }
         }
      } catch (FileNotFoundException var23) {
         var23.printStackTrace();
      } catch (IOException var24) {
         var24.printStackTrace();
      }

      return var5;
   }

   public int lectureComptaExcel(File var1) {
      byte var2 = 99;

      try {
         POIFSFileSystem var3 = new POIFSFileSystem(new FileInputStream(var1));
         HSSFWorkbook var4 = new HSSFWorkbook(var3);
         HSSFSheet var5 = var4.getSheetAt(0);
         HSSFRow var6 = null;
         HSSFCell var7 = null;
         byte var8 = 0;
         String var9 = "";
         var5 = var4.getSheetAt(var8);
         Iterator var10 = var5.rowIterator();

         while(var10.hasNext()) {
            var6 = (HSSFRow)var10.next();
            short var11 = var6.getLastCellNum();
            Iterator var12 = var6.cellIterator();
            if (var12.hasNext()) {
               var7 = (HSSFCell)var12.next();
               switch(var7.getCellType()) {
               case 0:
                  var9 = Double.toString(var7.getNumericCellValue());
                  break;
               case 1:
                  var9 = var7.getStringCellValue();
                  break;
               case 2:
                  var9 = Double.toString(0.0D);
                  break;
               case 3:
                  var9 = Double.toString(0.0D);
                  break;
               case 4:
                  var9 = Boolean.toString(var7.getBooleanCellValue());
               }

               if (var9 != null && !var9.isEmpty() && var9.startsWith("amo_")) {
                  var2 = 80;
               } else if (var9 != null && !var9.isEmpty() && var9.startsWith("ecr_")) {
                  var2 = 81;
               }
            }

            if (var2 != 80 && var2 != 81) {
               if (var6.getLastCellNum() == 9) {
                  var2 = 0;
               } else {
                  var2 = 1;
               }
               break;
            }
         }
      } catch (FileNotFoundException var13) {
         var13.printStackTrace();
      } catch (IOException var14) {
         var14.printStackTrace();
      }

      return var2;
   }

   public List lectureFichierBalance(File var1) {
      new TransfertCompta();
      ArrayList var3 = new ArrayList();

      try {
         POIFSFileSystem var4 = new POIFSFileSystem(new FileInputStream(var1));
         HSSFWorkbook var5 = new HSSFWorkbook(var4);
         HSSFSheet var6 = var5.getSheetAt(0);
         HSSFRow var7 = null;
         HSSFCell var8 = null;
         int var9 = 1;
         String var10 = "";

         label107:
         for(int var11 = 0; var11 < var5.getNumberOfSheets(); ++var11) {
            var6 = var5.getSheetAt(var11);
            var10 = var5.getSheetName(var11).toString();
            System.out.println("feuille " + var5.getSheetName(var11).toString());
            Iterator var12 = var6.rowIterator();

            while(true) {
               TransfertCompta var2;
               String var14;
               String var15;
               double var20;
               double var22;
               do {
                  if (!var12.hasNext()) {
                     continue label107;
                  }

                  var7 = (HSSFRow)var12.next();
                  System.out.println("ligne " + var7.getRowNum());
                  int var13 = 0;
                  var14 = "";
                  var15 = "";
                  double var16 = 0.0D;
                  double var18 = 0.0D;
                  var20 = 0.0D;
                  var22 = 0.0D;

                  for(Iterator var24 = var7.cellIterator(); var24.hasNext(); System.out.println("      colonne  " + var8.getColumnIndex() + "  ")) {
                     var8 = (HSSFCell)var24.next();
                     ++var13;
                     double var25;
                     if (var13 == 1) {
                        switch(var8.getCellType()) {
                        case 0:
                           var25 = var8.getNumericCellValue();
                           var14 = this.beginText(var25, 0);
                           break;
                        case 1:
                           var14 = var8.getStringCellValue().toString();
                        }
                     } else if (var13 == 2) {
                        switch(var8.getCellType()) {
                        case 0:
                           var25 = var8.getNumericCellValue();
                           var15 = this.beginText(var25, 0);
                           break;
                        case 1:
                           var15 = var8.getStringCellValue().toString();
                        }
                     } else if (var13 == 3) {
                        switch(var8.getCellType()) {
                        case 0:
                           var16 = var8.getNumericCellValue();
                           break;
                        case 1:
                           var16 = 0.0D;
                        }
                     } else if (var13 == 4) {
                        switch(var8.getCellType()) {
                        case 0:
                           var18 = var8.getNumericCellValue();
                           break;
                        case 1:
                           var18 = 0.0D;
                        }
                     } else if (var13 == 5) {
                        switch(var8.getCellType()) {
                        case 0:
                           var20 = var8.getNumericCellValue();
                           break;
                        case 1:
                           var20 = 0.0D;
                        }
                     } else if (var13 == 6) {
                        switch(var8.getCellType()) {
                        case 0:
                           var22 = var8.getNumericCellValue();
                           break;
                        case 1:
                           var22 = 0.0D;
                        }
                     }
                  }

                  ++var9;
                  if (var16 != 0.0D || var18 != 0.0D) {
                     var2 = new TransfertCompta();
                     var2.setTrfCode("AN");
                     var2.setTrfPiece("AN");
                     var2.setTrfCompte(var14);
                     var2.setTrfLibelle(var15);
                     var2.setTrfDebitSaisie(var16);
                     var2.setTrfCreditSaisie(var18);
                     var3.add(var2);
                  }
               } while(var20 == 0.0D && var22 == 0.0D);

               var2 = new TransfertCompta();
               var2.setTrfCode("OD");
               var2.setTrfPiece("OD");
               var2.setTrfCompte(var14);
               var2.setTrfLibelle(var15);
               var2.setTrfDebitMvts(var20);
               var2.setTrfCreditMvts(var22);
               var3.add(var2);
            }
         }
      } catch (FileNotFoundException var27) {
         var27.printStackTrace();
      } catch (IOException var28) {
         var28.printStackTrace();
      }

      return var3;
   }

   public List lectureFichierEcriture(File var1) {
      new TransfertCompta();
      ArrayList var3 = new ArrayList();

      try {
         POIFSFileSystem var4 = new POIFSFileSystem(new FileInputStream(var1));
         HSSFWorkbook var5 = new HSSFWorkbook(var4);
         HSSFSheet var6 = var5.getSheetAt(0);
         HSSFRow var7 = null;
         HSSFCell var8 = null;
         int var9 = 1;
         String var10 = "";
         UtilNombre var11 = new UtilNombre();

         label166:
         for(int var12 = 0; var12 < var5.getNumberOfSheets(); ++var12) {
            var6 = var5.getSheetAt(var12);
            var10 = var5.getSheetName(var12).toString();
            System.out.println("feuille " + var5.getSheetName(var12).toString());
            Iterator var13 = var6.rowIterator();

            while(true) {
               Date var15;
               String var16;
               String var17;
               String var18;
               String var19;
               String var20;
               String var21;
               double var22;
               double var24;
               do {
                  if (!var13.hasNext()) {
                     continue label166;
                  }

                  var7 = (HSSFRow)var13.next();
                  System.out.println("ligne " + var7.getRowNum());
                  int var14 = 0;
                  var15 = null;
                  var16 = "";
                  var17 = "";
                  var18 = "";
                  var19 = "";
                  var20 = "";
                  var21 = "";
                  var22 = 0.0D;
                  var24 = 0.0D;

                  for(Iterator var26 = var7.cellIterator(); var26.hasNext(); System.out.println("      colonne  " + var8.getColumnIndex() + "  ")) {
                     var8 = (HSSFCell)var26.next();
                     ++var14;
                     if (var14 == 1) {
                        switch(var8.getCellType()) {
                        case 0:
                           var15 = var8.getDateCellValue();
                        }
                     } else if (var14 == 2) {
                        switch(var8.getCellType()) {
                        case 1:
                           var16 = var8.getStringCellValue().toString();
                        }
                     } else if (var14 == 3) {
                        switch(var8.getCellType()) {
                        case 0:
                           var17 = var11.myConvertString(var8.getNumericCellValue(), 2);
                           break;
                        case 1:
                           var17 = var8.getStringCellValue().toString();
                        }
                     } else if (var14 == 4) {
                        switch(var8.getCellType()) {
                        case 0:
                           var19 = var11.myConvertString(var8.getNumericCellValue(), 2);
                           break;
                        case 1:
                           var19 = var8.getStringCellValue().toString();
                        }
                     } else if (var14 == 5) {
                        switch(var8.getCellType()) {
                        case 1:
                           var18 = var8.getStringCellValue().toString();
                        }
                     } else if (var14 == 6) {
                        switch(var8.getCellType()) {
                        case 0:
                           var22 = var8.getNumericCellValue();
                           break;
                        case 1:
                           var22 = 0.0D;
                        }
                     } else if (var14 == 7) {
                        switch(var8.getCellType()) {
                        case 0:
                           var24 = var8.getNumericCellValue();
                           break;
                        case 1:
                           var24 = 0.0D;
                        }
                     } else if (var14 == 8) {
                        switch(var8.getCellType()) {
                        case 1:
                           var21 = var8.getStringCellValue().toString();
                        }
                     } else if (var14 == 9) {
                        switch(var8.getCellType()) {
                        case 1:
                           var20 = var8.getStringCellValue().toString();
                        }
                     }
                  }

                  ++var9;
               } while(var22 == 0.0D && var24 == 0.0D);

               TransfertCompta var2 = new TransfertCompta();
               var2.setTrfDateSaisie(var15);
               var2.setTrfCode(var16);
               var2.setTrfPiece(var19);
               var2.setTrfCompte(var17);
               var2.setTrfLibelle(var18);
               var2.setTrfDebitSaisie(var22);
               var2.setTrfCreditSaisie(var24);
               double var34 = 0.0D;
               if (var22 != 0.0D && var24 == 0.0D) {
                  var34 = var22;
               } else {
                  var34 = var24;
               }

               if (var21 != null && !var21.isEmpty()) {
                  String[] var28;
                  if (!var21.contains(",")) {
                     if (var21.contains(":")) {
                        var28 = var21.split(":");
                        var2.setTrfActivite(var28[0] + ":" + var28[0] + ":null:null:null:null:0.0:" + var28[1]);
                     } else {
                        var2.setTrfActivite(var21 + ":" + var21 + ":null:null:null:null:0.0:" + var34);
                     }
                  } else {
                     var28 = null;
                     var28 = var21.split(",");
                     String[] var29 = null;
                     String var30 = "";
                     int var31 = 0;

                     while(true) {
                        if (var31 >= var28.length) {
                           var2.setTrfActivite(var30);
                           break;
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           if (var28[var31].contains(":")) {
                              var29 = var28[var31].split(":");
                              var30 = var30 + "#" + var29[0] + ":" + var29[0] + ":null:null:null:null:0.0:" + var29[1];
                           }
                        } else if (var28[var31].contains(":")) {
                           var29 = var28[var31].split(":");
                           var30 = var29[0] + ":" + var29[0] + ":null:null:null:null:0.0:" + var29[1];
                        }

                        ++var31;
                     }
                  }
               } else {
                  var2.setTrfActivite("");
               }

               var2.setTrfLettre(var20);
               var3.add(var2);
            }
         }
      } catch (FileNotFoundException var32) {
         var32.printStackTrace();
      } catch (IOException var33) {
         var33.printStackTrace();
      }

      return var3;
   }

   public List lectureFichierVentes(File var1) {
      TransfertVentes var2 = new TransfertVentes();
      ArrayList var3 = new ArrayList();

      try {
         POIFSFileSystem var4 = new POIFSFileSystem(new FileInputStream(var1));
         HSSFWorkbook var5 = new HSSFWorkbook(var4);
         HSSFSheet var6 = var5.getSheetAt(0);
         HSSFRow var7 = null;
         HSSFCell var8 = null;
         int var9 = 1;
         String var10 = "";
         boolean var11 = false;
         boolean var12 = false;
         String var13 = "";
         String var14 = "";

         for(int var15 = 0; var15 < var5.getNumberOfSheets(); ++var15) {
            var6 = var5.getSheetAt(var15);
            var13 = var5.getSheetName(var15).toString();

            for(Iterator var16 = var6.rowIterator(); var16.hasNext(); ++var9) {
               var7 = (HSSFRow)var16.next();
               if (var12) {
                  var3.add(var2);
               }

               var12 = true;
               var2 = new TransfertVentes();
               var2.setTrfNomFeuille(var13);
               var2.setTrfPeriode("");
               Iterator var17 = var7.cellIterator();

               while(var17.hasNext()) {
                  var8 = (HSSFCell)var17.next();
                  switch(var8.getCellType()) {
                  case 0:
                     var10 = Double.toString(var8.getNumericCellValue());
                     break;
                  case 1:
                     var10 = var8.getStringCellValue();
                     break;
                  case 2:
                     var10 = Double.toString(0.0D);
                     break;
                  case 3:
                     var10 = Double.toString(0.0D);
                     break;
                  case 4:
                     var10 = Boolean.toString(var8.getBooleanCellValue());
                  }

                  if (var12) {
                     if (var8.getColumnIndex() == 0) {
                        var2.setTrfColT00(var10);
                     } else if (var8.getColumnIndex() == 1) {
                        var2.setTrfColT01(var10);
                     } else if (var8.getColumnIndex() == 2) {
                        var2.setTrfColT02(var10);
                     } else if (var8.getColumnIndex() == 3) {
                        var2.setTrfColT03(var10);
                     } else if (var8.getColumnIndex() == 4) {
                        var2.setTrfColT04(var10);
                     } else if (var8.getColumnIndex() == 5) {
                        var2.setTrfColT05(var10);
                     } else if (var8.getColumnIndex() == 6) {
                        var2.setTrfColT06(var10);
                     } else if (var8.getColumnIndex() == 7) {
                        var2.setTrfColT07(var10);
                     } else if (var8.getColumnIndex() == 8) {
                        var2.setTrfColT08(var10);
                     } else if (var8.getColumnIndex() == 9) {
                        var2.setTrfColT09(var10);
                     } else if (var8.getColumnIndex() == 10) {
                        var2.setTrfColT10(var10);
                     } else if (var8.getColumnIndex() == 11) {
                        var2.setTrfColT11(var10);
                     } else if (var8.getColumnIndex() == 12) {
                        var2.setTrfColT12(var10);
                     } else if (var8.getColumnIndex() == 13) {
                        var2.setTrfColT13(var10);
                     } else if (var8.getColumnIndex() == 14) {
                        var2.setTrfColT14(var10);
                     } else if (var8.getColumnIndex() == 15) {
                        var2.setTrfColT15(var10);
                     } else if (var8.getColumnIndex() == 16) {
                        var2.setTrfColT16(var10);
                     } else if (var8.getColumnIndex() == 17) {
                        var2.setTrfColT17(var10);
                     } else if (var8.getColumnIndex() == 18) {
                        var2.setTrfColT18(var10);
                     } else if (var8.getColumnIndex() == 19) {
                        var2.setTrfColT19(var10);
                     } else if (var8.getColumnIndex() == 20) {
                        var2.setTrfColT20(var10);
                     } else if (var8.getColumnIndex() == 21) {
                        var2.setTrfColT21(var10);
                     } else if (var8.getColumnIndex() == 22) {
                        var2.setTrfColT22(var10);
                     } else if (var8.getColumnIndex() == 23) {
                        var2.setTrfColT23(var10);
                     } else if (var8.getColumnIndex() == 24) {
                        var2.setTrfColT24(var10);
                     } else if (var8.getColumnIndex() == 25) {
                        var2.setTrfColT25(var10);
                     } else if (var8.getColumnIndex() == 26) {
                        var2.setTrfColT26(var10);
                     } else if (var8.getColumnIndex() == 27) {
                        var2.setTrfColT27(var10);
                     } else if (var8.getColumnIndex() == 28) {
                        var2.setTrfColT28(var10);
                     } else if (var8.getColumnIndex() == 29) {
                        var2.setTrfColT29(var10);
                     } else if (var8.getColumnIndex() == 30) {
                        var2.setTrfColT30(var10);
                     } else if (var8.getColumnIndex() == 31) {
                        var2.setTrfColT31(var10);
                     } else if (var8.getColumnIndex() == 32) {
                        var2.setTrfColT32(var10);
                     } else if (var8.getColumnIndex() == 33) {
                        var2.setTrfColT33(var10);
                     } else if (var8.getColumnIndex() == 34) {
                        var2.setTrfColT34(var10);
                     } else if (var8.getColumnIndex() == 35) {
                        var2.setTrfColT35(var10);
                     } else if (var8.getColumnIndex() == 36) {
                        var2.setTrfColT36(var10);
                     } else if (var8.getColumnIndex() == 37) {
                        var2.setTrfColT37(var10);
                     } else if (var8.getColumnIndex() == 38) {
                        var2.setTrfColT38(var10);
                     } else if (var8.getColumnIndex() == 39) {
                        var2.setTrfColT39(var10);
                     } else if (var8.getColumnIndex() == 40) {
                        var2.setTrfColT40(var10);
                     }
                  }
               }
            }

            if (var12) {
               var3.add(var2);
            }
         }
      } catch (FileNotFoundException var18) {
         var18.printStackTrace();
      } catch (IOException var19) {
         var19.printStackTrace();
      }

      return var3;
   }

   public List lectureFichierTiers(File var1) {
      TransfertTiers var2 = new TransfertTiers();
      ArrayList var3 = new ArrayList();

      try {
         POIFSFileSystem var4 = new POIFSFileSystem(new FileInputStream(var1));
         HSSFWorkbook var5 = new HSSFWorkbook(var4);
         HSSFSheet var6 = var5.getSheetAt(0);
         HSSFRow var7 = null;
         HSSFCell var8 = null;
         int var9 = 1;
         String var10 = "";
         boolean var11 = false;
         boolean var12 = false;
         boolean var13 = false;
         boolean var14 = false;
         String var15 = "";

         for(int var16 = 0; var16 < var5.getNumberOfSheets(); ++var16) {
            var6 = var5.getSheetAt(var16);
            var15 = var5.getSheetName(var16).toString();
            if (var11) {
               var3.add(var2);
               var2 = new TransfertTiers();
               var2.setTrfNomFeuille(var15);
               var2.setTrfPeriode("");
            } else if (var12) {
               var3.add(var2);
               var2 = new TransfertTiers();
               var2.setTrfNomFeuille(var15);
               var2.setTrfPeriode("");
            } else if (var13) {
               var3.add(var2);
               var2 = new TransfertTiers();
               var2.setTrfNomFeuille(var15);
               var2.setTrfPeriode("");
            } else if (var14) {
               var3.add(var2);
               var2 = new TransfertTiers();
               var2.setTrfNomFeuille(var15);
               var2.setTrfPeriode("");
            }

            var11 = false;
            var12 = false;
            var13 = false;
            var14 = false;
            var10 = "";

            label218:
            for(Iterator var17 = var6.rowIterator(); var17.hasNext(); ++var9) {
               var7 = (HSSFRow)var17.next();
               if (var11) {
                  var3.add(var2);
                  var2 = new TransfertTiers();
                  var2.setTrfNomFeuille(var15);
                  var2.setTrfPeriode("");
               } else if (var12) {
                  var3.add(var2);
                  var2 = new TransfertTiers();
                  var2.setTrfNomFeuille(var15);
                  var2.setTrfPeriode("");
               } else if (var13) {
                  var3.add(var2);
                  var2 = new TransfertTiers();
                  var2.setTrfNomFeuille(var15);
                  var2.setTrfPeriode("");
               } else if (var14) {
                  var3.add(var2);
                  var2 = new TransfertTiers();
                  var2.setTrfNomFeuille(var15);
                  var2.setTrfPeriode("");
               }

               Iterator var18 = var7.cellIterator();

               while(true) {
                  do {
                     if (!var18.hasNext()) {
                        continue label218;
                     }

                     var8 = (HSSFCell)var18.next();
                     switch(var8.getCellType()) {
                     case 0:
                        var10 = Double.toString(var8.getNumericCellValue());
                        break;
                     case 1:
                        var10 = var8.getStringCellValue();
                        break;
                     case 2:
                        var10 = Double.toString(0.0D);
                        break;
                     case 3:
                        var10 = Double.toString(0.0D);
                        break;
                     case 4:
                        var10 = Boolean.toString(var8.getBooleanCellValue());
                     }

                     if (var10.equals("TIERS")) {
                        var11 = true;
                        var2 = new TransfertTiers();
                        var2.setTrfNomFeuille(var15);
                        var2.setTrfPeriode("");
                        var2.setTrfColT00("TIERS");
                     } else if (var10.equals("PATIENTS")) {
                        var12 = true;
                        var2 = new TransfertTiers();
                        var2.setTrfNomFeuille(var15);
                        var2.setTrfPeriode("");
                        var2.setTrfColT00("PATIENTS");
                     } else if (var10.equals("ELEVES")) {
                        var13 = true;
                        var2 = new TransfertTiers();
                        var2.setTrfNomFeuille(var15);
                        var2.setTrfPeriode("");
                        var2.setTrfColT00("ELEVES");
                     } else if (var10.equals("CONTACTS")) {
                        var14 = true;
                        var2 = new TransfertTiers();
                        var2.setTrfNomFeuille(var15);
                        var2.setTrfPeriode("");
                        var2.setTrfColT00("CONTACTS");
                     }
                  } while(!var11 && !var12 && !var13 && !var14);

                  if (var8.getColumnIndex() == 0) {
                     var2.setTrfColT00(var10);
                  } else if (var8.getColumnIndex() == 1) {
                     var2.setTrfColT01(var10);
                  } else if (var8.getColumnIndex() == 2) {
                     var2.setTrfColT02(var10);
                  } else if (var8.getColumnIndex() == 3) {
                     var2.setTrfColT03(var10);
                  } else if (var8.getColumnIndex() == 4) {
                     var2.setTrfColT04(var10);
                  } else if (var8.getColumnIndex() == 5) {
                     var2.setTrfColT05(var10);
                  } else if (var8.getColumnIndex() == 6) {
                     var2.setTrfColT06(var10);
                  } else if (var8.getColumnIndex() == 7) {
                     var2.setTrfColT07(var10);
                  } else if (var8.getColumnIndex() == 8) {
                     var2.setTrfColT08(var10);
                  } else if (var8.getColumnIndex() == 9) {
                     var2.setTrfColT09(var10);
                  } else if (var8.getColumnIndex() == 10) {
                     var2.setTrfColT10(var10);
                  } else if (var8.getColumnIndex() == 11) {
                     var2.setTrfColT11(var10);
                  } else if (var8.getColumnIndex() == 12) {
                     var2.setTrfColT12(var10);
                  } else if (var8.getColumnIndex() == 13) {
                     var2.setTrfColT13(var10);
                  } else if (var8.getColumnIndex() == 14) {
                     var2.setTrfColT14(var10);
                  } else if (var8.getColumnIndex() == 15) {
                     var2.setTrfColT15(var10);
                  } else if (var8.getColumnIndex() == 16) {
                     var2.setTrfColT16(var10);
                  } else if (var8.getColumnIndex() == 17) {
                     var2.setTrfColT17(var10);
                  } else if (var8.getColumnIndex() == 18) {
                     var2.setTrfColT18(var10);
                  } else if (var8.getColumnIndex() == 19) {
                     var2.setTrfColT19(var10);
                  } else if (var8.getColumnIndex() == 20) {
                     var2.setTrfColT20(var10);
                  } else if (var8.getColumnIndex() == 21) {
                     var2.setTrfColT21(var10);
                  } else if (var8.getColumnIndex() == 22) {
                     var2.setTrfColT22(var10);
                  } else if (var8.getColumnIndex() == 23) {
                     var2.setTrfColT23(var10);
                  } else if (var8.getColumnIndex() == 24) {
                     var2.setTrfColT24(var10);
                  } else if (var8.getColumnIndex() == 25) {
                     var2.setTrfColT25(var10);
                  } else if (var8.getColumnIndex() == 26) {
                     var2.setTrfColT26(var10);
                  } else if (var8.getColumnIndex() == 27) {
                     var2.setTrfColT27(var10);
                  } else if (var8.getColumnIndex() == 28) {
                     var2.setTrfColT28(var10);
                  } else if (var8.getColumnIndex() == 29) {
                     var2.setTrfColT29(var10);
                  } else if (var8.getColumnIndex() == 30) {
                     var2.setTrfColT30(var10);
                  } else if (var8.getColumnIndex() == 31) {
                     var2.setTrfColT31(var10);
                  } else if (var8.getColumnIndex() == 32) {
                     var2.setTrfColT32(var10);
                  } else if (var8.getColumnIndex() == 33) {
                     var2.setTrfColT33(var10);
                  } else if (var8.getColumnIndex() == 34) {
                     var2.setTrfColT34(var10);
                  } else if (var8.getColumnIndex() == 35) {
                     var2.setTrfColT35(var10);
                  } else if (var8.getColumnIndex() == 36) {
                     var2.setTrfColT36(var10);
                  } else if (var8.getColumnIndex() == 37) {
                     var2.setTrfColT37(var10);
                  } else if (var8.getColumnIndex() == 38) {
                     var2.setTrfColT38(var10);
                  } else if (var8.getColumnIndex() == 39) {
                     var2.setTrfColT39(var10);
                  } else if (var8.getColumnIndex() == 40) {
                     var2.setTrfColT40(var10);
                  }
               }
            }

            var3.add(var2);
         }
      } catch (FileNotFoundException var19) {
         var19.printStackTrace();
      } catch (IOException var20) {
         var20.printStackTrace();
      }

      return var3;
   }

   public String filtreNumerique(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
   }

   public String filtreTexte(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
   }

   public String beginText(double var1, int var3) {
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
}
