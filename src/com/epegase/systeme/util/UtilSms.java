package com.epegase.systeme.util;

import com.epegase.systeme.classe.Sms;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.SmsDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilSms implements Serializable {
   private Structure structureLog;
   private Users usersLog;
   private String baseLog;
   private UtilInitHibernate utilInitHibernate;
   private int choixOperateur = 0;

   public UtilSms(UtilInitHibernate var1, Structure var2, Users var3, String var4) {
      this.utilInitHibernate = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.baseLog = var4;
   }

   public void sendSmsOne(String var1, String var2, String var3, String var4, long var5, String var7, long var8, int var10) throws IOException, HibernateException, NamingException, SQLException {
      if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         var2 = this.filtreNumerique(var2);
         if (this.choixOperateur == 0) {
            this.smsAllmysms(var1, var2, var3, var4, var5, var7, var8, var10);
         } else if (this.choixOperateur == 1) {
            this.smsOrange(var1, var2, var3, var4, var5, var7, var8, var10);
         }
      }

   }

   public void smsAllmysms(String var1, String var2, String var3, String var4, long var5, String var7, long var8, int var10) throws HibernateException, NamingException, UnsupportedEncodingException, MalformedURLException, IOException {
      SmsDao var11 = new SmsDao(this.baseLog, this.utilInitHibernate);
      int var12 = var11.calculeNbSms((Session)null);
      String var13 = null;
      String var16;
      if (var12 > 0) {
         String var14 = "";
         if (this.structureLog.getStrsigle() != null && !this.structureLog.getStrsigle().isEmpty()) {
            var14 = this.structureLog.getStrsigle() + " ePegase";
         } else {
            var14 = this.structureLog.getStrraisonsociale() + " ePegase";
         }

         String var15 = URLEncoder.encode(var14, "UTF-8");
         var16 = "smssms6";
         String var17 = "da1e0ec02dab5f2";
         String var18 = URLEncoder.encode(var1, "UTF-8");
         String var19 = "<DATA><MESSAGE><![CDATA[" + var18 + "]]></MESSAGE><TPOA>" + var15 + "</TPOA><SMS><MOBILEPHONE>" + var2 + "</MOBILEPHONE></SMS></DATA>";
         String var20 = "http://api.allmysms.com/http/9.0/sendSms/?login=" + var16 + "&apiKey=" + var17 + "&smsData=" + var19;
         URL var21 = new URL(var20);
         URLConnection var22 = var21.openConnection();
         InputStream var23 = var22.getInputStream();
         byte[] var24 = new byte[1024];

         int var28;
         for(boolean var25 = false; (var28 = var23.read(var24)) != -1; var13 = new String(var24, 0, var28)) {
         }

         var23.close();
      } else {
         var13 = "STATUS103";
      }

      Sms var26 = new Sms();
      var26.setSmsCiviliteContact(var4);
      var26.setSmsDate(new Date());
      var26.setSmsIdContact(var5);
      var26.setSmsIdTiers(var8);
      var26.setSmsMobile(var2);
      var26.setSmsNomContact(var3);
      var26.setSmsNomTiers(var7);
      var26.setSmsNum("");
      byte var27 = 0;
      var16 = this.filtreCaracteres(var13);
      if (var16.contains("STATUS100")) {
         var26.setSmsStatus("OK");
         var27 = -1;
      } else if (var16.contains("STATUS101")) {
         var26.setSmsStatus("ENVOI DIFFERE");
         var27 = -1;
      } else if (var16.contains("STATUS102")) {
         var26.setSmsStatus("PROBELEME DE CONNEXION");
      } else if (var16.contains("STATUS103")) {
         var26.setSmsStatus("CREDIT INSUFFISANT (LE VOTRE)");
      } else if (var16.contains("STATUS104")) {
         var26.setSmsStatus("CREDIT INSUFFISANT (PARTENAIRE)");
      } else if (var16.contains("STATUS105")) {
         var26.setSmsStatus("PROBELEME DE  FORMAT (105)");
      } else if (var16.contains("STATUS109")) {
         var26.setSmsStatus("PROBLEME DE FORMAT (109)");
      } else if (var16.contains("STATUS110")) {
         var26.setSmsStatus("PROBLEME DE FORMAT (110)");
      } else if (var16.contains("STATUS111")) {
         var26.setSmsStatus("TROP DE CARACTERES");
      } else if (var16.contains("STATUS114")) {
         var26.setSmsStatus("NUMERO DE TELEPHONE INVALIDE");
      } else if (var16.contains("STATUS115")) {
         var26.setSmsStatus("PROBLEME DE FORMAT (115)");
      } else {
         var26.setSmsStatus(var16.substring(0, 99));
      }

      var26.setSmsTexte(var1);
      var26.setSmsTypeTiers(var10);
      var26.setSmsQte(var27);
      var26.setUsers(this.usersLog);
      var11.insert(var26);
   }

   public void smsOrange(String var1, String var2, String var3, String var4, long var5, String var7, long var8, int var10) throws HibernateException, NamingException, UnsupportedEncodingException, MalformedURLException, IOException {
      SmsDao var11 = new SmsDao(this.baseLog, this.utilInitHibernate);
      int var12 = var11.calculeNbSms((Session)null);
      String var13 = null;
      String var16;
      if (var12 > 0) {
         String var14 = "NdJdEsxwCtco2XwqFT0rYolsfyga";
         String var15 = "8WaSyvNp7hbJ037B2u4ar27cAMAa";
         var16 = "7635929ee38df1845b9388b7119597a";
         String var17 = "";
         if (this.structureLog.getStrsigle() != null && !this.structureLog.getStrsigle().isEmpty()) {
            var17 = this.structureLog.getStrsigle() + " ePegase";
         } else {
            var17 = this.structureLog.getStrraisonsociale() + " ePegase";
         }

         String var18 = URLEncoder.encode(var17, "UTF-8");
         String var19 = URLEncoder.encode(var1, "UTF-8");
         String var20 = "{ address :[tel:9990000xxxxxxx ], senderName :1234, message:Test SMS for the challenge documentation}";
         String var21 = "https://api.sdp.orange.com/smsmessaging/v1/outbound/tel%3A%2B9990000" + var16 + "/requests";
         URL var22 = new URL(var21);
         URLConnection var23 = var22.openConnection();
         InputStream var24 = var23.getInputStream();
         byte[] var25 = new byte[1024];

         int var29;
         for(boolean var26 = false; (var29 = var24.read(var25)) != -1; var13 = new String(var25, 0, var29)) {
         }

         var24.close();
      } else {
         var13 = "STATUS103";
      }

      Sms var27 = new Sms();
      var27.setSmsCiviliteContact(var4);
      var27.setSmsDate(new Date());
      var27.setSmsIdContact(var5);
      var27.setSmsIdTiers(var8);
      var27.setSmsMobile(var2);
      var27.setSmsNomContact(var3);
      var27.setSmsNomTiers(var7);
      var27.setSmsNum("");
      byte var28 = 0;
      var16 = this.filtreCaracteres(var13);
      if (var16.contains("STATUS100")) {
         var27.setSmsStatus("OK");
         var28 = -1;
      } else if (var16.contains("STATUS101")) {
         var27.setSmsStatus("ENVOI DIFFERE");
         var28 = -1;
      } else if (var16.contains("STATUS102")) {
         var27.setSmsStatus("PROBELEME DE CONNEXION");
      } else if (var16.contains("STATUS103")) {
         var27.setSmsStatus("CREDIT INSUFFISANT (LE VOTRE)");
      } else if (var16.contains("STATUS104")) {
         var27.setSmsStatus("CREDIT INSUFFISANT (PARTENAIRE)");
      } else if (var16.contains("STATUS105")) {
         var27.setSmsStatus("PROBELEME DE  FORMAT (105)");
      } else if (var16.contains("STATUS109")) {
         var27.setSmsStatus("PROBLEME DE FORMAT (109)");
      } else if (var16.contains("STATUS110")) {
         var27.setSmsStatus("PROBLEME DE FORMAT (110)");
      } else if (var16.contains("STATUS111")) {
         var27.setSmsStatus("TROP DE CARACTERES");
      } else if (var16.contains("STATUS114")) {
         var27.setSmsStatus("NUMERO DE TELEPHONE INVALIDE");
      } else if (var16.contains("STATUS115")) {
         var27.setSmsStatus("PROBLEME DE FORMAT (115)");
      } else {
         var27.setSmsStatus(var16.substring(0, 99));
      }

      var27.setSmsTexte(var1);
      var27.setSmsTypeTiers(var10);
      var27.setSmsQte(var28);
      var27.setUsers(this.usersLog);
      var11.insert(var27);
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
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

   public String sendSmsListe(String var1, String var2) throws IOException, HibernateException, NamingException, SQLException {
      String var3 = "";
      if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         var2 = this.filtreNumerique(var2);
         if (this.choixOperateur == 0) {
            var3 = this.smsAllmysmsListe(var1, var2);
         } else if (this.choixOperateur == 1) {
         }
      }

      return var3;
   }

   public String smsAllmysmsListe(String var1, String var2) throws HibernateException, NamingException, UnsupportedEncodingException, MalformedURLException, IOException {
      SmsDao var3 = new SmsDao(this.baseLog, this.utilInitHibernate);
      int var4 = var3.calculeNbSms((Session)null);
      String var5 = "";
      if (var4 > 0) {
         String var6 = "";
         if (this.structureLog.getStrsigle() != null && !this.structureLog.getStrsigle().isEmpty()) {
            var6 = this.structureLog.getStrsigle() + " ePegase";
         } else {
            var6 = this.structureLog.getStrraisonsociale() + " ePegase";
         }

         String var7 = URLEncoder.encode(var6, "UTF-8");
         String var8 = "smssms6";
         String var9 = "da1e0ec02dab5f2";
         String var10 = URLEncoder.encode(var1, "UTF-8");
         String var11 = "<DATA><MESSAGE><![CDATA[" + var10 + "]]></MESSAGE><TPOA>" + var7 + "</TPOA><SMS><MOBILEPHONE>" + var2 + "</MOBILEPHONE></SMS></DATA>";
         String var12 = "http://api.allmysms.com/http/9.0/sendSms/?login=" + var8 + "&apiKey=" + var9 + "&smsData=" + var11;
         URL var13 = new URL(var12);
         URLConnection var14 = var13.openConnection();
         InputStream var15 = var14.getInputStream();
         byte[] var16 = new byte[1024];

         int var18;
         for(boolean var17 = false; (var18 = var15.read(var16)) != -1; var5 = new String(var16, 0, var18)) {
         }

         var15.close();
      } else {
         var5 = "STATUS103";
      }

      return var5;
   }

   public Sms enregistrementSms(Sms var1, SmsDao var2, String var3, String var4, String var5, String var6, long var7, String var9, long var10, int var12, Session var13) throws HibernateException, NamingException {
      var1.setSmsCiviliteContact(var6);
      var1.setSmsDate(new Date());
      var1.setSmsIdContact(var7);
      var1.setSmsIdTiers(var10);
      var1.setSmsMobile(var4);
      var1.setSmsNomContact(var5);
      var1.setSmsNomTiers(var9);
      var1.setSmsNum("");
      var1.setSmsTexte(var3);
      var1.setSmsStatus("");
      var1.setSmsTypeTiers(var12);
      var1.setSmsQte(0);
      var1.setUsers(this.usersLog);
      var1 = var2.insert(var1, var13);
      return var1;
   }

   public void majStatut(List var1, String var2, Sms var3, SmsDao var4, Session var5) {
      if (var1.size() != 0) {
         if (this.choixOperateur == 0) {
            for(int var6 = 0; var6 < var1.size(); ++var6) {
               var3 = (Sms)var1.get(var6);
               byte var7 = 0;
               String var8 = this.filtreCaracteres(var2);
               if (var8.contains("STATUS100")) {
                  var3.setSmsStatus("OK");
                  var7 = -1;
               } else if (var8.contains("STATUS101")) {
                  var3.setSmsStatus("ENVOI DIFFERE");
                  var7 = -1;
               } else if (var8.contains("STATUS102")) {
                  var3.setSmsStatus("PROBELEME DE CONNEXION");
               } else if (var8.contains("STATUS103")) {
                  var3.setSmsStatus("CREDIT INSUFFISANT (LE VOTRE)");
               } else if (var8.contains("STATUS104")) {
                  var3.setSmsStatus("CREDIT INSUFFISANT (PARTENAIRE)");
               } else if (var8.contains("STATUS105")) {
                  var3.setSmsStatus("PROBELEME DE  FORMAT (105)");
               } else if (var8.contains("STATUS109")) {
                  var3.setSmsStatus("PROBLEME DE FORMAT (109)");
               } else if (var8.contains("STATUS110")) {
                  var3.setSmsStatus("PROBLEME DE FORMAT (110)");
               } else if (var8.contains("STATUS111")) {
                  var3.setSmsStatus("TROP DE CARACTERES");
               } else if (var8.contains("STATUS114")) {
                  var3.setSmsStatus("NUMERO DE TELEPHONE INVALIDE");
               } else if (var8.contains("STATUS115")) {
                  var3.setSmsStatus("PROBLEME DE FORMAT (115)");
               } else {
                  var3.setSmsStatus(var8.substring(0, 99));
               }

               var3.setSmsQte(var7);
               var4.modif(var3, var5);
            }
         } else if (this.choixOperateur == 1) {
         }
      }

   }
}
