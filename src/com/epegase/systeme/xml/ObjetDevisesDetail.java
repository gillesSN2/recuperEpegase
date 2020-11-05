package com.epegase.systeme.xml;

import com.epegase.systeme.util.UtilDate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

public class ObjetDevisesDetail implements Serializable {
   private int indice;
   private Date date;
   private String code;
   private String taux1;
   private String madate;
   private String taux2;
   UtilDate dteEche = new UtilDate();

   public Date getDate() throws ParseException {
      String[] var1 = this.madate.split("/");
      String var2 = var1[0];
      String var3 = var1[1];
      String var4 = var1[2];
      String var5 = var4 + "-" + var3 + "-" + var2;
      this.date = this.dteEche.stringToDateSQLLight(var5);
      return this.date;
   }

   public void setDate(Date var1) {
      this.date = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getTaux1() {
      return this.taux1;
   }

   public void setTaux1(String var1) {
      this.taux1 = var1;
   }

   public String getTaux2() {
      return this.taux2;
   }

   public void setTaux2(String var1) {
      this.taux2 = var1;
   }

   public String getMadate() {
      return this.madate;
   }

   public void setMadate(String var1) {
      this.madate = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public UtilDate getDteEche() {
      return this.dteEche;
   }

   public void setDteEche(UtilDate var1) {
      this.dteEche = var1;
   }
}
