package com.epegase.systeme.util;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetMail;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.net.ssl.internal.ssl.Provider;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.Flags.Flag;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.naming.NamingException;
import org.apache.log4j.net.SMTPAppender;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilMail extends SMTPAppender implements Serializable {
   private String SMTP_HOST_NAME;
   private String SMTP_AUTH_USER;
   private String SMTP_AUTH_PWD;
   private int SMTP_AUTH_PORT;
   private int SMTP_SSL;
   private int SMTP_AUTHENTIFICATION;
   private String msg_body;
   private boolean msg_pj;
   private int var_currentValueMsg;
   private String var_infosMsg;
   private String baseLog;
   private String PATH_TO_DATA;
   private List lesMailsAcceptes;
   private List lesMailsRejetes;
   private Structure structureLog;
   private int choixEmetteur;
   private int authentificationEmetteurSmp;
   private String serveurEmetteurSmp;
   private int portEmetteurSmp;
   private String adresseEmetteurSmp;
   private String pwEmetteurSmp;
   private int sslEmmeteurSmp;
   private String serveurEmetteurImap;
   private int portEmetteurImap;
   private int authentificationEmetteurPop;
   private String serveurEmetteurPop;
   private int portEmetteurPop;
   private String adresseEmetteurPop;
   private String pwEmetteurPop;
   private int sslEmmeteurPop;
   private int nbexemplairePop;
   private String reponseMail;
   private String signatureMail;

   public UtilMail(Structure var1) {
      this.structureLog = var1;
      this.lesMailsAcceptes = new ArrayList();
      this.lesMailsRejetes = new ArrayList();
   }

   public UtilMail() {
   }

   public Bal calculBalEmetteur(String var1, int var2) throws HibernateException, NamingException {
      if (var2 >= 10) {
         this.choixEmetteur = var2 - 10;
      } else {
         this.choixEmetteur = this.structureLog.getStrsmtChoix();
      }

      this.configMail();
      Bal var3 = new Bal();
      var3.setBalpopauthentification(this.authentificationEmetteurPop);
      var3.setBalpopexemplaire(this.nbexemplairePop);
      var3.setBalpopserveur(this.serveurEmetteurPop);
      var3.setBalpopport(this.portEmetteurPop);
      var3.setBalimapserveur(this.serveurEmetteurImap);
      var3.setBalimapport(this.portEmetteurImap);
      var3.setBalsmtauthentification(this.authentificationEmetteurSmp);
      var3.setBalsmtpserveur(this.serveurEmetteurSmp);
      var3.setBalsmtpport(this.portEmetteurSmp);
      var3.setBalssl(this.sslEmmeteurSmp);
      var3.setBalpw(this.pwEmetteurSmp);
      var3.setBaladressemail(this.adresseEmetteurSmp);
      if (var1 != null && !var1.isEmpty()) {
         var3.setBaladressemailreponse(var1);
      } else {
         var3.setBaladressemailreponse((String)null);
      }

      var3.setBalSignature(this.signatureMail);
      if (this.serveurEmetteurSmp == null && this.serveurEmetteurSmp.isEmpty()) {
         this.choixEmetteur = 1;
         this.configMail();
      }

      return var3;
   }

   public void configMail() {
      if (this.choixEmetteur == 0 || this.choixEmetteur == 1 || this.choixEmetteur == 2 || this.choixEmetteur == 5) {
         this.choixEmetteur = 6;
      }

      if (this.choixEmetteur != 0 && this.choixEmetteur != 1 && this.choixEmetteur != 2) {
         if (this.choixEmetteur == 3) {
            this.sslEmmeteurSmp = this.structureLog.getStrssl();
            this.authentificationEmetteurSmp = this.structureLog.getStrsmtauthentification();
            this.serveurEmetteurSmp = this.structureLog.getStrsmtpserveur();
            this.portEmetteurSmp = this.structureLog.getStrsmtpport();
            this.adresseEmetteurSmp = this.structureLog.getStradressemail();
            this.pwEmetteurSmp = this.structureLog.getStrpw();
            this.serveurEmetteurImap = this.structureLog.getStrimapserveur();
            this.portEmetteurImap = this.structureLog.getStrimapport();
            this.authentificationEmetteurPop = this.structureLog.getStrpopauthentification();
            this.serveurEmetteurPop = this.structureLog.getStrpopserveur();
            this.portEmetteurPop = this.structureLog.getStrpopport();
            this.adresseEmetteurPop = this.structureLog.getStradressemail();
            this.pwEmetteurPop = this.structureLog.getStrpw();
            this.sslEmmeteurPop = this.structureLog.getStrssl();
            this.reponseMail = this.structureLog.getStradressemailreponse();
            this.signatureMail = this.structureLog.getStrSignature();
         } else if (this.choixEmetteur == 4) {
            this.sslEmmeteurSmp = 0;
            this.serveurEmetteurSmp = "";
            this.portEmetteurSmp = 0;
            this.adresseEmetteurSmp = "";
            this.pwEmetteurSmp = "";
            this.serveurEmetteurImap = "";
            this.portEmetteurImap = 0;
            this.authentificationEmetteurPop = 0;
            this.serveurEmetteurPop = "";
            this.portEmetteurPop = 0;
            this.adresseEmetteurPop = "";
            this.pwEmetteurPop = "";
            this.sslEmmeteurPop = 0;
            this.reponseMail = null;
            this.signatureMail = null;
         } else if (this.choixEmetteur != 5 && this.choixEmetteur == 6) {
            this.sslEmmeteurSmp = StaticModePegase.getSslEmmeteurSmp();
            this.authentificationEmetteurSmp = StaticModePegase.getAuthentificationEmetteurSmp();
            this.serveurEmetteurSmp = StaticModePegase.getServeurEmetteurSmp();
            this.portEmetteurSmp = StaticModePegase.getPortEmetteurSmp();
            this.adresseEmetteurSmp = StaticModePegase.getAdresseEmetteurSmp();
            this.pwEmetteurSmp = StaticModePegase.getPwEmetteurSmp();
            this.serveurEmetteurImap = "";
            this.portEmetteurImap = 0;
            this.authentificationEmetteurPop = 0;
            this.serveurEmetteurPop = "";
            this.portEmetteurPop = 0;
            this.adresseEmetteurPop = "";
            this.pwEmetteurPop = "";
            this.sslEmmeteurPop = 0;
            this.reponseMail = null;
            this.signatureMail = null;
         }
      }

   }

   public String sendMail(String var1, String var2, String var3, String var4, String var5, String var6, String var7, Bal var8) throws Exception {
      String var9 = "";
      Properties var10 = new Properties();
      if (var8 != null) {
         this.SMTP_HOST_NAME = var8.getBalsmtpserveur();
         this.SMTP_AUTH_USER = var8.getBaladressemail();
         this.SMTP_AUTH_PWD = var8.getBalpw();
         this.SMTP_AUTH_PORT = var8.getBalsmtpport();
         this.SMTP_SSL = var8.getBalssl();
         this.SMTP_AUTHENTIFICATION = var8.getBalsmtauthentification();
         var10.put("mail.smtp.from", this.SMTP_AUTH_USER);
         var10.put("mail.smtp.password", this.SMTP_AUTH_PWD);
         var10.put("mail.smtp.host", this.SMTP_HOST_NAME);
         var10.put("mail.smtp.port", this.SMTP_AUTH_PORT);
         var10.put("mail.transport.protocol", "smtp");
         if (this.SMTP_AUTHENTIFICATION == 1) {
            var10.put("mail.smtp.auth", "true");
         } else {
            var10.put("mail.smtp.auth", "false");
         }

         if (this.SMTP_SSL == 0) {
            var10.put("mail.smtp.starttls.enable", "false");
         } else if (this.SMTP_SSL == 1) {
            Security.addProvider(new Provider());
            var10.put("mail.smtp.ssl.trust", StaticModePegase.getServeurEmetteurSmp());
            var10.put("mail.smtp.socketFactory.port", this.SMTP_AUTH_PORT);
            var10.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            var10.put("mail.smtp.socketFactory.fallback", "false");
         } else if (this.SMTP_SSL == 2) {
            var10.put("mail.smtp.starttls.enable", "true");
         }

         Session var11 = null;
         if (this.SMTP_SSL == 1) {
            var11 = Session.getInstance(var10, new Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(UtilMail.this.SMTP_AUTH_USER, UtilMail.this.SMTP_AUTH_PWD);
               }
            });
         } else {
            var11 = Session.getInstance(var10);
         }

         try {
            MimeMessage var12 = new MimeMessage(var11);
            var12.setFrom(new InternetAddress(this.SMTP_AUTH_USER));
            if (var2 != null && !var2.isEmpty()) {
               var2 = this.calculAdresseMail(var2);
               if (var2.contains(",")) {
                  var12.addRecipients(RecipientType.TO, InternetAddress.parse(var2));
               } else {
                  var12.addRecipient(RecipientType.TO, new InternetAddress(var2));
               }
            } else if (var3 != null && !var3.isEmpty()) {
               var2 = this.calculAdresseMail(var3);
               if (var2.contains(",")) {
                  var12.addRecipients(RecipientType.TO, InternetAddress.parse(var2));
               } else {
                  var12.addRecipient(RecipientType.TO, new InternetAddress(var2));
               }

               var3 = "";
            }

            if (var3 != null && !var3.isEmpty()) {
               var3 = this.calculAdresseMail(var3);
               if (var3.contains(",")) {
                  var12.addRecipients(RecipientType.CC, InternetAddress.parse(var3));
               } else {
                  var12.addRecipient(RecipientType.CC, new InternetAddress(var3));
               }
            }

            if (var4 != null && !var4.isEmpty()) {
               var4 = this.calculAdresseMail(var4);
               if (var4.contains(",")) {
                  var12.addRecipients(RecipientType.BCC, InternetAddress.parse(var4));
               } else {
                  var12.addRecipient(RecipientType.BCC, new InternetAddress(var4));
               }
            }

            if (var6 != null && !var6.isEmpty() && var6.contains("@")) {
               var12.addRecipient(RecipientType.CC, new InternetAddress(var6));
            }

            if (var8.getBaladressemailreponse() != null && !var8.getBaladressemailreponse().isEmpty()) {
               var12.setReplyTo(InternetAddress.parse(var8.getBaladressemailreponse()));
            }

            var12.setSentDate(new Date());
            var12.setSubject(var7.toUpperCase(), "UTF-8");
            var12.setContent(var1, "text/html;charset=utf-8");
            var12.setHeader("ePegase", "ePegase");
            Transport var13 = var11.getTransport("smtp");
            var13.connect(this.SMTP_HOST_NAME, this.SMTP_AUTH_PORT, this.SMTP_AUTH_USER, this.SMTP_AUTH_PWD);
            var13.sendMessage(var12, var12.getAllRecipients());
            if (var13 != null) {
               var13.close();
            }
         } catch (MessagingException var14) {
            var9 = var14.toString();
         }
      } else {
         this.SMTP_HOST_NAME = "";
         this.SMTP_AUTH_USER = "";
         this.SMTP_AUTH_PWD = "";
         this.SMTP_AUTH_PORT = 0;
         this.SMTP_SSL = 0;
         this.SMTP_AUTHENTIFICATION = 0;
         var9 = "Pas d'emetteur";
      }

      return var9;
   }

   public String sendMail(String var1, String var2, String var3, String var4, String var5, String var6, String var7, Bal var8, List var9) throws Exception {
      String var10 = "";
      Properties var11 = new Properties();
      if (var8 != null) {
         this.SMTP_HOST_NAME = var8.getBalsmtpserveur();
         this.SMTP_AUTH_USER = var8.getBaladressemail();
         this.SMTP_AUTH_PWD = var8.getBalpw();
         this.SMTP_AUTH_PORT = var8.getBalsmtpport();
         this.SMTP_SSL = var8.getBalssl();
         this.SMTP_AUTHENTIFICATION = var8.getBalsmtauthentification();
         var11.put("mail.smtp.from", this.SMTP_AUTH_USER);
         var11.put("mail.smtp.password", this.SMTP_AUTH_PWD);
         var11.put("mail.smtp.host", this.SMTP_HOST_NAME);
         var11.put("mail.smtp.port", this.SMTP_AUTH_PORT);
         var11.put("mail.transport.protocol", "smtp");
         if (this.SMTP_AUTHENTIFICATION == 1) {
            var11.put("mail.smtp.auth", "true");
         } else {
            var11.put("mail.smtp.auth", "false");
         }

         if (this.SMTP_SSL == 0) {
            var11.put("mail.smtp.starttls.enable", "false");
         } else if (this.SMTP_SSL == 1) {
            Security.addProvider(new Provider());
            var11.put("mail.smtp.ssl.trust", StaticModePegase.getServeurEmetteurSmp());
            var11.put("mail.smtp.socketFactory.port", this.SMTP_AUTH_PORT);
            var11.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            var11.put("mail.smtp.socketFactory.fallback", "false");
         } else if (this.SMTP_SSL == 2) {
            var11.put("mail.smtp.starttls.enable", "true");
         }

         Session var12 = null;
         if (this.SMTP_SSL == 1) {
            var12 = Session.getInstance(var11, new Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                  return new PasswordAuthentication(UtilMail.this.SMTP_AUTH_USER, UtilMail.this.SMTP_AUTH_PWD);
               }
            });
         } else {
            var12 = Session.getInstance(var11);
         }

         try {
            MimeMessage var13 = new MimeMessage(var12);
            var13.setFrom(new InternetAddress(this.SMTP_AUTH_USER));
            if (var2 != null && !var2.isEmpty()) {
               var2 = this.calculAdresseMail(var2);
               if (var2.contains(",")) {
                  var13.addRecipients(RecipientType.TO, InternetAddress.parse(var2));
               } else {
                  var13.addRecipient(RecipientType.TO, new InternetAddress(var2));
               }
            } else if (var3 != null && !var3.isEmpty()) {
               var2 = this.calculAdresseMail(var3);
               if (var2.contains(",")) {
                  var13.addRecipients(RecipientType.TO, InternetAddress.parse(var2));
               } else {
                  var13.addRecipient(RecipientType.TO, new InternetAddress(var2));
               }

               var3 = "";
            }

            if (var3 != null && !var3.isEmpty() && var3.contains("@")) {
               var3 = this.calculAdresseMail(var3);
               if (var3.contains(",")) {
                  var13.addRecipients(RecipientType.CC, InternetAddress.parse(var3));
               } else {
                  var13.addRecipient(RecipientType.CC, new InternetAddress(var3));
               }
            }

            if (var4 != null && !var4.isEmpty() && var4.contains("@")) {
               var4 = this.calculAdresseMail(var4);
               if (var4.contains(",")) {
                  var13.addRecipients(RecipientType.BCC, InternetAddress.parse(var4));
               } else {
                  var13.addRecipient(RecipientType.BCC, new InternetAddress(var4));
               }
            }

            if (var6 != null && !var6.isEmpty() && var6.contains("@")) {
               var13.addRecipient(RecipientType.CC, new InternetAddress(var6));
            }

            if (var8.getBaladressemailreponse() != null && !var8.getBaladressemailreponse().isEmpty()) {
               var13.setReplyTo(InternetAddress.parse(var8.getBaladressemailreponse()));
            }

            var13.setSentDate(new Date());
            var13.setSubject(var7.toUpperCase());
            var13.setContent(var1, "text/html;charset=utf-8");
            var13.setHeader("ePegase", "ePegase");
            MimeBodyPart var14 = new MimeBodyPart();
            var14.setText(var1);
            if (var9.size() != 0) {
               MimeMultipart var15 = new MimeMultipart();
               MimeBodyPart var16 = new MimeBodyPart();
               var16.setContent(var1, "text/html");
               var16.setHeader("ePegase", "ePegase");
               var15.addBodyPart(var16);

               for(int var17 = 0; var17 < var9.size(); ++var17) {
                  MimeBodyPart var18 = new MimeBodyPart();
                  File var19 = (File)var9.get(var17);
                  var18.setFileName(var19.getName());
                  var18.attachFile(var19);
                  var15.addBodyPart(var18);
               }

               var13.setContent(var15);
            }

            Transport var21 = var12.getTransport("smtp");
            var21.connect(this.SMTP_HOST_NAME, this.SMTP_AUTH_PORT, this.SMTP_AUTH_USER, this.SMTP_AUTH_PWD);
            var21.sendMessage(var13, var13.getAllRecipients());
            if (var21 != null) {
               var21.close();
            }
         } catch (MessagingException var20) {
            var10 = var20.toString();
         }
      } else {
         this.SMTP_HOST_NAME = "";
         this.SMTP_AUTH_USER = "";
         this.SMTP_AUTH_PWD = "";
         this.SMTP_AUTH_PORT = 0;
         this.SMTP_SSL = 0;
         this.SMTP_AUTHENTIFICATION = 0;
         var10 = "Pas d'emetteur";
      }

      return var10;
   }

   public String calculAdresseMail(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         String[] var3 = null;
         if (!var1.contains("#")) {
            if (var1.contains(":")) {
               var3 = var1.split(":");
               var2 = var3[1];
            } else {
               var2 = var1;
            }
         } else {
            String[] var4 = var1.split("#");

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if (var4[var5].contains(":")) {
                  var3 = var4[var5].split(":");
                  if (var2 != null && !var2.isEmpty()) {
                     var2 = var2 + "," + var3[1];
                  } else {
                     var2 = var3[1];
                  }
               } else if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + var4[1];
               } else {
                  var2 = var4[1];
               }
            }
         }
      }

      return var2;
   }

   public String calculAdresseMailCollaborateur(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         String[] var3 = null;
         if (!var1.contains("#")) {
            if (var1.contains(":")) {
               var3 = var1.split(":");
               var2 = var3[3];
            } else {
               var2 = var1;
            }
         } else {
            String[] var4 = var1.split("#");

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if (var4[var5].contains(":")) {
                  var3 = var4[var5].split(":");
                  if (var2 != null && !var2.isEmpty()) {
                     var2 = var2 + "," + var3[3];
                  } else {
                     var2 = var3[3];
                  }
               } else if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + var4[3];
               } else {
                  var2 = var4[3];
               }
            }
         }
      }

      return var2;
   }

   public void mailInscription(String var1, String var2, String var3) throws Exception {
      String var4 = "";
      Object var5 = null;
      Bal var6 = this.calculBalEmetteur((String)var5, 11);
      if (var6 != null) {
         this.sendMail(var1, var2, (String)null, (String)null, (String)var5, (String)null, var3, var6);
      } else {
         var4 = "Erreur creation BAL";
      }

   }

   public void mailDemandeInformation(String var1, String var2, String var3, String var4) throws Exception {
      String var5 = "";
      Object var6 = null;
      Bal var7 = this.calculBalEmetteur((String)var6, 11);
      if (var7 != null) {
         this.sendMail(var1, var2, (String)null, var3, (String)var6, (String)null, var4, var7);
      } else {
         var5 = "Erreur creation BAL";
      }

   }

   public void mailNews(String var1, String var2, String var3) throws Exception {
      String var4 = "";
      Object var5 = null;
      Bal var6 = this.calculBalEmetteur((String)var5, 11);
      if (var6 != null) {
         this.sendMail(var1, (String)null, (String)null, var2, (String)var5, (String)null, var3, var6);
      } else {
         var4 = "Erreur creation BAL";
      }

   }

   public void mailImportProspect(String var1, String var2, String var3) throws Exception {
      String var4 = "";
      Object var5 = null;
      Bal var6 = this.calculBalEmetteur((String)var5, 11);
      if (var6 != null) {
         this.sendMail(var1, (String)null, (String)null, var2, (String)var5, (String)null, var3, var6);
      } else {
         var4 = "Erreur creation BAL";
      }

   }

   public String envoieMailRdv(Structure var1, Users var2, Rdv var3, UtilDate var4) throws Exception {
      String var5 = "";
      Bal var6 = this.calculBalEmetteur(var2.getUsrMail(), 0);
      if (var6 != null) {
         if (var3.getRdvMailContact() != null && !var3.getRdvMailContact().isEmpty()) {
            String var7 = this.calculAdresseMail(var3.getRdvMailContact());
            String var8 = this.calculAdresseMailCollaborateur(var3.getRdvCollaborateur());
            Object var9 = null;
            String var10 = null;
            if (var2.getUsrMail() != null && !var2.getUsrMail().isEmpty() && var2.getUsrMailCopie() == 1) {
               var10 = var2.getUsrMail();
            }

            if (var7 != null && !var7.isEmpty()) {
               String var11 = "";
               if (var3.getRdvEtat() == 0) {
                  if (var3.getRdvNature() == 1) {
                     var11 = "Confirmation de Rendez-vous avec " + var1.getStrraisonsociale();
                  } else {
                     var11 = "Confirmation de R&eacute;union avec " + var1.getStrraisonsociale();
                  }
               } else if (var3.getRdvEtat() == 1) {
                  if (var3.getRdvNature() == 1) {
                     var11 = "Rendez-vous Effectu&eacute; avec " + var1.getStrraisonsociale();
                  } else {
                     var11 = "R&eacute;union Effectu&eacute;e avec " + var1.getStrraisonsociale();
                  }
               } else if (var3.getRdvEtat() == 2) {
                  if (var3.getRdvNature() == 1) {
                     var11 = "REPORT de Rendez-vous avec " + var1.getStrraisonsociale();
                  } else {
                     var11 = "REPORT de R&eacute;union avec " + var1.getStrraisonsociale();
                  }
               } else if (var3.getRdvEtat() == 3) {
                  if (var3.getRdvNature() == 1) {
                     var11 = "ANNULATION de Rendez-vous avec " + var1.getStrraisonsociale();
                  } else {
                     var11 = "ANNULATION de R&eacute;union avec " + var1.getStrraisonsociale();
                  }
               }

               String var12 = "";
               var12 = "<html><head></head><body>";
               var12 = var12 + "<p text-align:left;>";
               String var13 = "";
               if (var3.getUsers() != null) {
                  var13 = var3.getUsers().getUsrCivilite();
               }

               if (var13.equals("")) {
                  var13 = "Madame, Monsieur";
               }

               var12 = var12 + "Bonjour, " + var13 + ", <br/>" + "<br/>";
               var12 = var12 + "</p>";
               var12 = var12 + "<p>Notre rendez-vous est fix&eacute; le " + var4.dateToStringFr(var3.getRdvDteDe()) + " &agrave; partir de " + var3.getRdvHrDe() + "H" + var3.getRdvMnDe() + "<br/>";
               if (var3.getRdvSujet() != null && !var3.getRdvSujet().isEmpty()) {
                  var12 = var12 + "<br/>- OBJET:<br/>" + var3.getRdvSujet();
               }

               if (var3.getRdvDescript() != null && !var3.getRdvDescript().isEmpty()) {
                  var12 = var12 + "<br/>- DESCRIPTIF:<br/>" + var3.getRdvDescript();
               }

               if (var3.getRdvLieu() != null && !var3.getRdvLieu().isEmpty()) {
                  var12 = var12 + "<br/>- LIEU:<br/>" + var3.getRdvLieu();
               }

               if (var3.getRdvTache() != null && !var3.getRdvTache().isEmpty()) {
                  var12 = var12 + "<br/>- TACHE:<br/>" + var3.getRdvTache();
               }

               if (var3.getRdvCr() != null && !var3.getRdvCr().isEmpty()) {
                  var12 = var12 + "<br/>- COMPTE RENDU:<br/>" + var3.getRdvCr();
               }

               if (var3.getRdvCollaborateur() != null && !var3.getRdvCollaborateur().isEmpty()) {
                  String var14 = "";
                  String[] var15 = null;
                  String var18;
                  if (!var3.getRdvCollaborateur().contains("#")) {
                     var15 = var3.getRdvCollaborateur().split(":");
                     String var16 = var15[0];
                     String var17 = var15[2];
                     if (var17 == null) {
                        var17 = "";
                     }

                     var18 = var15[3];
                     if (var18 == null) {
                        var18 = "";
                     }

                     var14 = var17 + " " + var16 + " " + var18;
                  } else {
                     String[] var21 = var3.getRdvCollaborateur().split("#");

                     for(int var22 = 0; var22 < var21.length; ++var22) {
                        var15 = var21[var22].split(":");
                        var18 = var15[0];
                        String var19 = var15[2];
                        if (var19 == null) {
                           var19 = "";
                        }

                        String var20 = var15[3];
                        if (var20 == null) {
                           var20 = "";
                        }

                        var14 = var14 + var19 + " " + var18 + " " + var20 + "\n";
                     }
                  }

                  var12 = var12 + "<br/>- COLLABORATEUR(S):<br/>" + var14;
               }

               var12 = var12 + "</p>";
               var12 = var12 + "<p>Emetteur : &nbsp; " + var1.getStrraisonsociale() + "<br/>";
               var12 = var12 + "Contact : &nbsp; " + var13 + " " + var3.getUsers().getUsrPatronyme();
               var12 = var12 + "</p>";
               var12 = var12 + "<p>Restant &agrave; votre &eacute;coute pour toutes informations compl&eacute;mentaires, veuillez agr&eacute;er, " + var13 + ", l'expressions de nos sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
               if (var3.getUsers().getUsrPrenom() != null && !var3.getUsers().getUsrPrenom().isEmpty()) {
                  var12 = var12 + "Cordialement, <br/>" + var3.getUsers().getUsrPrenom() + "." + "<br/>";
               } else {
                  var12 = var12 + "Cordialement, <br/>" + var3.getUsers().getUsrNom() + "." + "<br/>";
               }

               if (var3.getUsers().getUsrFonction() != null && !var3.getUsers().getUsrFonction().isEmpty()) {
                  var12 = var12 + var3.getUsers().getUsrFonction() + "<br/>";
               }

               var12 = var12 + "</p>";
               var12 = var12 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
               var12 = var12 + "<p>";
               if (var6 != null && var6.getBalSignature() != null) {
                  var12 = var12 + "---";
                  var12 = var12 + var6.getBalSignature();
               } else {
                  var12 = var12 + "---";
               }

               var12 = var12 + "</p>";
               var12 = var12 + "</body></html>";
               var5 = this.sendMail(var12, var7, var8, (String)var9, var6.getBaladressemail(), var10, var11, var6);
            }
         }
      } else {
         var5 = "Erreur creation BAL";
      }

      return var5;
   }

   public String envoieMailCourrier(Structure var1, Users var2, Mails var3, String var4, UtilDate var5, long var6) throws Exception {
      String var8 = "";
      Bal var9 = this.calculBalEmetteur(var2.getUsrMail(), 0);
      if (var9 != null) {
         if (var4 != null && !var4.isEmpty()) {
            String var10 = this.calculAdresseMail(var4);
            Object var11 = null;
            Object var12 = null;
            String var13 = null;
            if (var2.getUsrMail() != null && !var2.getUsrMail().isEmpty() && var2.getUsrMailCopie() == 1) {
               var13 = var2.getUsrMail();
            }

            if (var10 != null && !var10.isEmpty()) {
               String var14 = "";
               if (var3.getMaiSens() == 3) {
                  var14 = "Courrier allant vers " + var3.getMaiTiersRs();
               } else if (var3.getMaiSens() == 4) {
                  var14 = "Courrier venant de " + var3.getMaiTiersRs();
               } else {
                  var14 = "ERREUR AVANT EXPLOSION....";
               }

               String var15 = "";
               var15 = "<html><head></head><body>";
               var15 = var15 + "<p text-align:left;>";
               var15 = var15 + "Bonjour, <br/><br/>";
               var15 = var15 + "</p>";
               var15 = var15 + "<p>R&eacute;sum&eacute; du courrier :<br/>";
               if (var3.getMaiObjet() != null && !var3.getMaiObjet().isEmpty()) {
                  var15 = var15 + "<br/>- OBJET:<br/>" + var3.getMaiObjet();
               }

               if (var3.getMaiCorps() != null && !var3.getMaiCorps().isEmpty()) {
                  var15 = var15 + "<br/>- TEXTE:<br/>" + var3.getMaiCorps();
               }

               var15 = var15 + "</p>";
               var15 = var15 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
               var15 = var15 + "<p>";
               if (var9 != null && var9.getBalSignature() != null) {
                  var15 = var15 + "---";
                  var15 = var15 + var9.getBalSignature();
               } else {
                  var15 = var15 + "---";
               }

               var15 = var15 + "</p>";
               var15 = var15 + "</body></html>";
               if (var3.getMaiScanCourrier() != null && !var3.getMaiScanCourrier().isEmpty() && var6 != 0L) {
                  ArrayList var16 = new ArrayList();
                  String var17 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var6 + File.separator + "photos" + File.separator + "scanCourriers" + File.separator + var3.getMaiScanCourrier();
                  var16.add(new File(var17));
                  var8 = this.sendMail(var15, var10, (String)var11, (String)var12, var9.getBaladressemail(), var13, var14, var9, var16);
               } else {
                  var8 = this.sendMail(var15, var10, (String)var11, (String)var12, var9.getBaladressemail(), var13, var14, var9);
               }
            }
         }
      } else {
         var8 = "Erreur creation BAL";
      }

      return var8;
   }

   public String envoieMailSms(Structure var1, Users var2, int var3) throws Exception {
      String var4 = "";
      Bal var5 = this.calculBalEmetteur(var2.getUsrMail(), 0);
      if (var5 != null) {
         String var6 = "assistance@e-pegase.biz";
         Object var7 = null;
         Object var8 = null;
         Object var9 = null;
         String var10 = "";
         if (var3 == 0) {
            var10 = "5 000 SMS";
         } else if (var3 == 1) {
            var10 = "10 000 SMS";
         } else if (var3 == 2) {
            var10 = "50 000 SMS";
         } else if (var3 == 3) {
            var10 = "100 000 SMS avec";
         }

         String var11 = "";
         var11 = "<html><head></head><body>";
         var11 = var11 + "<p text-align:left;>";
         String var12 = "Madame, Monsieur";
         var11 = var11 + "Bonjour, " + var12 + ", <br/>" + "<br/>";
         var11 = var11 + "</p>";
         var11 = var11 + "<p>Nous désirons acheter le pack " + var10 + "<br/>";
         var11 = var11 + "</p>";
         var11 = var11 + "<p>Emetteur : &nbsp; " + var1.getStrraisonsociale() + "<br/>";
         var11 = var11 + "Contact : &nbsp; " + var12 + " " + var2.getUsrPatronyme();
         var11 = var11 + "</p>";
         var11 = var11 + "<p>Restant &agrave; votre &eacute;coute pour toutes informations compl&eacute;mentaires, veuillez agr&eacute;er, " + var12 + ", l'expressions de nos sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
         if (var2.getUsrPrenom() != null && !var2.getUsrPrenom().isEmpty()) {
            var11 = var11 + "Cordialement, <br/>" + var2.getUsrPrenom() + "." + "<br/>";
         } else {
            var11 = var11 + "Cordialement, <br/>" + var2.getUsrNom() + "." + "<br/>";
         }

         if (var2.getUsrFonction() != null && !var2.getUsrFonction().isEmpty()) {
            var11 = var11 + var2.getUsrFonction() + "<br/>";
         }

         var11 = var11 + "</p>";
         var11 = var11 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
         var11 = var11 + "<p>";
         if (var5 != null && var5.getBalSignature() != null) {
            var11 = var11 + "---";
            var11 = var11 + var5.getBalSignature();
         } else {
            var11 = var11 + "---";
         }

         var11 = var11 + "</p>";
         var11 = var11 + "</body></html>";
         String var13 = "Achat pack " + var10;
         var4 = this.sendMail(var11, var6, (String)var7, (String)var8, var5.getBaladressemail(), (String)var9, var13, var5);
      }

      return var4;
   }

   public String envoieMailCpAbs(Structure var1, Users var2, SalariesConges var3, UtilDate var4) throws Exception {
      String var5 = "";
      Bal var6 = this.calculBalEmetteur(var2.getUsrMail(), 0);
      if (var6 != null) {
         String var7 = "";
         if (var3.getSalaries().getSalMail1() != null && !var3.getSalaries().getSalMail1().isEmpty()) {
            var7 = var3.getSalaries().getSalMail1();
         } else if (var3.getSalaries().getSalAol() != null && !var3.getSalaries().getSalAol().isEmpty()) {
            var7 = var3.getSalaries().getSalAol();
         } else if (var3.getSalaries().getSalYahoo() != null && !var3.getSalaries().getSalYahoo().isEmpty()) {
            var7 = var3.getSalaries().getSalYahoo();
         } else if (var3.getSalaries().getSalMsn() != null && !var3.getSalaries().getSalMsn().isEmpty()) {
            var7 = var3.getSalaries().getSalMsn();
         }

         if (var3 != null && var7 != null && !var7.isEmpty() && var7.contains("@")) {
            String var8 = this.calculAdresseMail(var7);
            Object var9 = null;
            Object var10 = null;
            String var11 = null;
            if (var2.getUsrMail() != null && !var2.getUsrMail().isEmpty() && var2.getUsrMailCopie() == 1) {
               var11 = var2.getUsrMail();
            }

            if (var8 != null && !var8.isEmpty()) {
               boolean var12 = false;
               String var13 = "";
               if (var3.getSalcngNature() == 9) {
                  var12 = true;
                  var13 = "Demande de congés: Rejetée";
               } else if (var3.getSalcngNature() >= 1 && var3.getSalcngNature() <= 7) {
                  var12 = true;
                  var13 = "Demande de congés: Acceptée";
               } else if (var3.getSalcngNature() == 19) {
                  var12 = true;
                  var13 = "Demande d`absence: Rejetée";
               } else if (var3.getSalcngNature() >= 11 && var3.getSalcngNature() <= 13) {
                  var12 = true;
                  var13 = "Demande d`absence: Rejetée";
               }

               if (var12) {
                  String var14 = "";
                  var14 = "<html><head></head><body>";
                  var14 = var14 + "<p text-align:left;>";
                  String var15 = "";
                  if (var3.getSalaries().getSalCivilite() != null && !var3.getSalaries().getSalCivilite().isEmpty()) {
                     var15 = var3.getSalaries().getSalCivilite();
                  }

                  if (var15.equals("")) {
                     var15 = "Madame, Monsieur";
                  }

                  var14 = var14 + "Bonjour, " + var15 + ", <br/>" + "<br/>";
                  var14 = var14 + "</p>";
                  if (var3.getSalcngNature() != 9 && var3.getSalcngNature() != 19) {
                     var14 = var14 + "<p>Nous avons le plaisir de vous informer que votre demande a &eacute;t&eacute; accept&eacute;e. <br/>";
                  } else if (var3.getSalcngObjet() != null && !var3.getSalcngObjet().isEmpty()) {
                     var14 = var14 + "<p>Nous avons le regret de vous informer que votre demande a &eacute;t&eacute; rejet&eacute;e pour le motif suivant: " + var3.getSalcngObjet() + "<br/>";
                  } else {
                     var14 = var14 + "<p>Nous avons le regret de vous informer que votre demande a &eacute;t&eacute; rejet&eacute;e. Pour plus d`informations veuillez vous rapprocher de votre responsable des ressources humaines. <br/>";
                  }

                  if (var3.getSalcngNature() == 0) {
                     var14 = var14 + "<br/>- OBJET:<br/>Demande de cong&eacute;s";
                  } else if (var3.getSalcngNature() == 1) {
                     var14 = var14 + "<br/>- OBJET:<br/>Cong&eacute;s normaux (Solde total)";
                  } else if (var3.getSalcngNature() == 2) {
                     var14 = var14 + "<br/>- OBJET:<br/>Cong&eacute;s normaux (Nb jours pris)";
                  } else if (var3.getSalcngNature() == 3) {
                     var14 = var14 + "<br/>- OBJET:<br/>Bulletin de cong&eacute;s";
                  } else if (var3.getSalcngNature() == 4) {
                     var14 = var14 + "<br/>- OBJET:<br/>Cong&eacute;s travaill&eacute;s";
                  } else if (var3.getSalcngNature() == 5) {
                     var14 = var14 + "<br/>- OBJET:<br/>Cong&eacute;s non calcul&eacute;s";
                  } else if (var3.getSalcngNature() == 6) {
                     var14 = var14 + "<br/>- OBJET:<br/>Cong&eacute;s de Maternit&eacute;";
                  } else if (var3.getSalcngNature() == 7) {
                     var14 = var14 + "<br/>- OBJET:<br/>Mise à disposition";
                  } else if (var3.getSalcngNature() == 9) {
                     var14 = var14 + "<br/>- OBJET:<br/>Demande rejet&eacute;e";
                  } else if (var3.getSalcngNature() == 10) {
                     var14 = var14 + "<br/>- OBJET:<br/>Demande d`absence";
                  } else if (var3.getSalcngNature() == 11) {
                     var14 = var14 + "<br/>- OBJET:<br/>Absence pay&eacute;e";
                  } else if (var3.getSalcngNature() == 12) {
                     var14 = var14 + "<br/>- OBJET:<br/>Absence non pay&eacute;e";
                  } else if (var3.getSalcngNature() == 13) {
                     var14 = var14 + "<br/>- OBJET:<br/>Absence pay&eacute;e &agrave; d&eacute;duire sur Cong&eacute;s";
                  } else if (var3.getSalcngNature() == 19) {
                     var14 = var14 + "<br/>- OBJET:<br/>Demande rejet&eacute;e";
                  }

                  if (var3.getSalcngLieu() != null && !var3.getSalcngLieu().isEmpty()) {
                     var14 = var14 + "<br/>- LIEU:<br/>" + var3.getSalcngLieu();
                  }

                  if (var3.getSalcngObjet() != null && !var3.getSalcngObjet().isEmpty()) {
                     var14 = var14 + "<br/>- OBSERVATIONS:<br/>" + var3.getSalcngObjet();
                  }

                  if (var3.getSalcngDateDebut() != null) {
                     var14 = var14 + "<br/>- DATE DEBUT:<br/>" + var4.dateToStringFr(var3.getSalcngDateDebut());
                  }

                  if (var3.getSalcngDateFin() != null) {
                     var14 = var14 + "<br/>- DATE FIN:<br/>" + var4.dateToStringFr(var3.getSalcngDateFin());
                  }

                  if (var3.getSalcngResponsable() != null && !var3.getSalcngResponsable().isEmpty()) {
                     var14 = var14 + "<br/>- RESPONSABLE:<br/>" + var3.getSalcngResponsable();
                  }

                  var14 = var14 + "</p>";
                  var14 = var14 + "<p>Restant &agrave; votre &eacute;coute pour toutes informations compl&eacute;mentaires, veuillez agr&eacute;er, " + var15 + ", l'expressions de nos sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
                  if (var2.getUsrPrenom() != null && !var2.getUsrPrenom().isEmpty()) {
                     var14 = var14 + "Cordialement, <br/>" + var2.getUsrPrenom() + "." + "<br/>";
                  } else {
                     var14 = var14 + "Cordialement, <br/>" + var2.getUsrNom() + "." + "<br/>";
                  }

                  if (var2.getUsrFonction() != null && !var2.getUsrFonction().isEmpty()) {
                     var14 = var14 + var2.getUsrFonction() + "<br/>";
                  }

                  var14 = var14 + "</p>";
                  var14 = var14 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
                  var14 = var14 + "<p>";
                  if (var6 != null && var6.getBalSignature() != null) {
                     var14 = var14 + "---";
                     var14 = var14 + var6.getBalSignature();
                  } else {
                     var14 = var14 + "---";
                  }

                  var14 = var14 + "</p>";
                  var14 = var14 + "</body></html>";
                  var5 = this.sendMail(var14, var8, (String)var9, (String)var10, var6.getBaladressemail(), var11, var13, var6);
               }
            }
         }
      } else {
         var5 = "Erreur creation BAL";
      }

      return var5;
   }

   public String envoieMailCertificationDocument(Structure var1, Users var2, int var3) throws Exception {
      String var4 = "";
      Bal var5 = this.calculBalEmetteur(var2.getUsrMail(), 0);
      if (var5 != null) {
         String var6 = "assistance@e-pegase.biz";
         Object var7 = null;
         Object var8 = null;
         Object var9 = null;
         String var10 = "";
         if (var3 == 0) {
            var10 = "5 000 SMS";
         } else if (var3 == 1) {
            var10 = "10 000 SMS";
         } else if (var3 == 2) {
            var10 = "50 000 SMS";
         } else if (var3 == 3) {
            var10 = "100 000 SMS avec";
         }

         String var11 = "";
         var11 = "<html><head></head><body>";
         var11 = var11 + "<p text-align:left;>";
         String var12 = "Madame, Monsieur";
         var11 = var11 + "Bonjour, " + var12 + ", <br/>" + "<br/>";
         var11 = var11 + "</p>";
         var11 = var11 + "<p>Nous désirons acheter le pack " + var10 + "<br/>";
         var11 = var11 + "</p>";
         var11 = var11 + "<p>Emetteur : &nbsp; " + var1.getStrraisonsociale() + "<br/>";
         var11 = var11 + "Contact : &nbsp; " + var12 + " " + var2.getUsrPatronyme();
         var11 = var11 + "</p>";
         var11 = var11 + "<p>Restant &agrave; votre &eacute;coute pour toutes informations compl&eacute;mentaires, veuillez agr&eacute;er, " + var12 + ", l'expressions de nos sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
         if (var2.getUsrPrenom() != null && !var2.getUsrPrenom().isEmpty()) {
            var11 = var11 + "Cordialement, <br/>" + var2.getUsrPrenom() + "." + "<br/>";
         } else {
            var11 = var11 + "Cordialement, <br/>" + var2.getUsrNom() + "." + "<br/>";
         }

         if (var2.getUsrFonction() != null && !var2.getUsrFonction().isEmpty()) {
            var11 = var11 + var2.getUsrFonction() + "<br/>";
         }

         var11 = var11 + "</p>";
         var11 = var11 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
         var11 = var11 + "<p>";
         if (var5 != null && var5.getBalSignature() != null) {
            var11 = var11 + "---";
            var11 = var11 + var5.getBalSignature();
         } else {
            var11 = var11 + "---";
         }

         var11 = var11 + "</p>";
         var11 = var11 + "</body></html>";
         String var13 = "Achat pack " + var10;
         var4 = this.sendMail(var11, var6, (String)var7, (String)var8, var5.getBaladressemail(), (String)var9, var13, var5);
      }

      return var4;
   }

   public String mailCreationCabinet(StructurePeg var1, Structure var2) throws Exception {
      String var3 = "";
      String var4 = "gillesdecruzel@gmail.com";
      Object var5 = null;
      Bal var6 = this.calculBalEmetteur((String)var5, 11);
      if (var6 != null) {
         String var7 = "";
         var7 = "<html><head></head><body>";
         var7 = var7 + "<p>";
         var7 = var7 + "Cabinet Emetteur : &nbsp; " + var2.getStrraisonsociale() + "<br/>";
         var7 = var7 + "<br/>Id Cabinet : &nbsp; " + var2.getStrid() + "<br/>";
         var7 = var7 + "<br/>Creation structure : &nbsp; " + var1.getStrraisonsociale() + "<br/>";
         var7 = var7 + "<br/>Id structure : &nbsp; " + var1.getStrId() + "<br/>";
         var7 = var7 + "</p>";
         var7 = var7 + "</body></html>";
         var3 = this.sendMail(var7, var4, (String)null, (String)null, (String)var5, (String)null, "Creation Cabinet", var6);
      } else {
         var3 = "Erreur creation BAL";
      }

      return var3;
   }

   public String envoieMailRappro(Structure var1, Users var2, String var3, int var4, String var5, UtilDate var6) throws Exception {
      String var7 = "";
      Bal var8 = this.calculBalEmetteur(var2.getUsrMail(), 0);
      if (var8 != null) {
         if (var5 != null && !var5.isEmpty()) {
            String var9 = this.calculAdresseMail(var5);
            Object var10 = null;
            Object var11 = null;
            String var12 = null;
            if (var2.getUsrMail() != null && !var2.getUsrMail().isEmpty() && var2.getUsrMailCopie() == 1) {
               var12 = var2.getUsrMail();
            }

            if (var9 != null && !var9.isEmpty()) {
               String var13 = "";
               if (var4 == 0) {
                  var13 = "Cloture rapprochement bancaire " + var3;
               } else {
                  var13 = "D&eacute;cloture rapprochement bancaire " + var3;
               }

               String var14 = "";
               var14 = "<html><head></head><body>";
               var14 = var14 + "<p text-align:left;>";
               var14 = var14 + "Bonjour, <br/><br/>";
               var14 = var14 + "</p>";
               var14 = var14 + "<p>R&eacute;sum&eacute; du rapprochement bancaire :<br/>";
               if (var13 != null && !var13.isEmpty()) {
                  var14 = var14 + "<br/>- OBJET:<br/>" + var13;
               }

               if (var3 != null && !var3.isEmpty()) {
                  var14 = var14 + "<br/>- TEXTE:<br/>" + var3;
               }

               if (var4 == 0) {
                  var14 = var14 + "<br/>- Clotur&eacute; par:<br/>" + var2.getUsrPatronyme() + " le " + var6.dateToStringFrComplet(new Date());
               } else {
                  var14 = var14 + "<br/>- D&eacute;clotur&eacute; par:<br/>" + var2.getUsrPatronyme() + " le " + var6.dateToStringFrComplet(new Date());
               }

               var14 = var14 + "</p>";
               var14 = var14 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
               var14 = var14 + "<p>";
               if (var8 != null && var8.getBalSignature() != null) {
                  var14 = var14 + "---";
                  var14 = var14 + var8.getBalSignature();
               } else {
                  var14 = var14 + "---";
               }

               var14 = var14 + "</p>";
               var14 = var14 + "</body></html>";
               var7 = this.sendMail(var14, var9, (String)var10, (String)var11, var8.getBaladressemail(), var12, var13, var8);
            }
         }
      } else {
         var7 = "Erreur creation BAL";
      }

      return var7;
   }

   public String envoieMailJournal(Structure var1, Users var2, String var3, int var4, String var5, UtilDate var6) throws Exception {
      String var7 = "";
      Bal var8 = this.calculBalEmetteur(var2.getUsrMail(), 0);
      if (var8 != null) {
         if (var5 != null && !var5.isEmpty()) {
            String var9 = this.calculAdresseMail(var5);
            Object var10 = null;
            Object var11 = null;
            String var12 = null;
            if (var2.getUsrMail() != null && !var2.getUsrMail().isEmpty() && var2.getUsrMailCopie() == 1) {
               var12 = var2.getUsrMail();
            }

            if (var9 != null && !var9.isEmpty()) {
               String var13 = "";
               if (var4 == 0) {
                  var13 = "Cloture journal comptable " + var3;
               } else {
                  var13 = "D&eacute;cloture journal comptable " + var3;
               }

               String var14 = "";
               var14 = "<html><head></head><body>";
               var14 = var14 + "<p text-align:left;>";
               var14 = var14 + "Bonjour, <br/><br/>";
               var14 = var14 + "</p>";
               var14 = var14 + "<p>R&eacute;sum&eacute; du journal comptable :<br/>";
               if (var13 != null && !var13.isEmpty()) {
                  var14 = var14 + "<br/>- OBJET:<br/>" + var13;
               }

               if (var3 != null && !var3.isEmpty()) {
                  var14 = var14 + "<br/>- TEXTE:<br/>" + var3;
               }

               if (var4 == 0) {
                  var14 = var14 + "<br/>- Clotur&eacute; par:<br/>" + var2.getUsrPatronyme() + " le " + var6.dateToStringFrComplet(new Date());
               } else {
                  var14 = var14 + "<br/>- D&eacute;clotur&eacute; par:<br/>" + var2.getUsrPatronyme() + " le " + var6.dateToStringFrComplet(new Date());
               }

               var14 = var14 + "</p>";
               var14 = var14 + "<p style=\"color:red;font-weight:bold;font-size:8px;\">Ce message vous est envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz).</p>";
               var14 = var14 + "<p>";
               if (var8 != null && var8.getBalSignature() != null) {
                  var14 = var14 + "---";
                  var14 = var14 + var8.getBalSignature();
               } else {
                  var14 = var14 + "---";
               }

               var14 = var14 + "</p>";
               var14 = var14 + "</body></html>";
               var7 = this.sendMail(var14, var9, (String)var10, (String)var11, var8.getBaladressemail(), var12, var13, var8);
            }
         }
      } else {
         var7 = "Erreur creation BAL";
      }

      return var7;
   }

   public void lectureBal(Bal var1, String var2, List var3, List var4) {
      this.baseLog = var2;
      this.PATH_TO_DATA = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "mails" + File.separator + "reception" + File.separator;
      this.var_infosMsg = "Connexion en cours...";
      this.var_currentValueMsg = 0;
      this.lesMailsRejetes.clear();
      this.lesMailsAcceptes.clear();
      if (var1 != null && (var1.getBalimapport() != 0 || var1.getBalpopport() != 0)) {
         Properties var5 = new Properties();
         Authenticator var6 = new Authenticator() {
         };
         if (var1.getBalimapport() != 0) {
            var5.setProperty("mail.store.protocol", "imap");
            var5.setProperty("mail.imaps.partialfetch", "false");
         } else if (var1.getBalpopport() != 0) {
            var5.setProperty("mail.store.protocol", "pop3");
            var5.setProperty("mail.pop3.starttls.enable", "true");
         }

         var5.setProperty("mail.mime.encodefilename", "true");
         var5.setProperty("mail.mime.decodefilename", "true");
         var5.setProperty("mail.mime.charset", "utf-8");
         var5.setProperty("mail.mime.decodetext.strict", "true");
         Session var7 = Session.getInstance(var5, var6);
         Store var8 = null;
         Folder var9 = null;
         Folder var10 = null;

         try {
            var7.setDebug(false);
            if (var1.getBalimapport() != 0) {
               var8 = var7.getStore("imaps");
               var8.connect(var1.getBalimapserveur(), var1.getBalimapport(), var1.getBaladressemail(), var1.getBalpw());
            } else if (var1.getBalpopport() != 0) {
               var8 = var7.getStore("pop3s");
               var8.connect(var1.getBalpopserveur(), var1.getBalpopport(), var1.getBaladressemail(), var1.getBalpw());
            }

            var9 = var8.getDefaultFolder();
            var10 = var9.getFolder("INBOX");
            this.lectureMessage(var10, var3, var4);
         } catch (Exception var20) {
            var20.printStackTrace();
            StaticModePegase.setTexte_message("Erreur lecture des mails : Boite mail inaccessible");
            StaticModePegase.setAffiche_message(true);
         } finally {
            this.close(var10);
            this.close(var9);

            try {
               if (var8 != null && var8.isConnected()) {
                  var8.close();
               }
            } catch (MessagingException var19) {
               var19.printStackTrace();
               StaticModePegase.setTexte_message("Erreur bal : " + var19);
               StaticModePegase.setAffiche_message(true);
            }

         }
      }

   }

   private void lectureMessage(Folder var1, List var2, List var3) {
      new ObjetMail();

      try {
         var1.open(2);
         int var5 = var1.getMessageCount();
         int var6 = var1.getUnreadMessageCount();
         Flags var7 = new Flags(Flag.SEEN);
         FlagTerm var8 = new FlagTerm(var7, false);
         Flags var9 = new Flags(Flag.RECENT);
         FlagTerm var10 = new FlagTerm(var9, false);
         AndTerm var11 = new AndTerm(var8, var10);
         Message[] var12 = var1.search(var11);
         int var13 = var12.length;

         for(int var14 = 0; var14 < var12.length; ++var14) {
            Message var15 = var12[var14];
            this.var_infosMsg = "Lecture du message " + var14 + " sur " + var13 + " mails non lus (total mail " + var5 + ")";
            if (var14 != 0) {
               this.var_currentValueMsg = 100 / (var13 / var14);
            }

            var15.setFlags(new Flags(Flag.SEEN), true);
            String var16 = "";
            Address[] var17 = var15.getFrom();
            Address[] var18 = var17;
            int var19 = var17.length;

            int var20;
            for(var20 = 0; var20 < var19; ++var20) {
               Address var21 = var18[var20];
               if (var16 == null || var16.isEmpty()) {
                  var16 = this.mejAdresseMail(var21);
                  break;
               }
            }

            if (var16 != null && !var16.isEmpty()) {
               String var33 = "";
               var17 = var15.getRecipients(RecipientType.TO);
               int var37;
               if (var17 != null) {
                  Address[] var34 = var17;
                  var20 = var17.length;

                  for(var37 = 0; var37 < var20; ++var37) {
                     Address var22 = var34[var37];
                     if (var33 != null && !var33.isEmpty()) {
                        var33 = var33 + "#" + this.mejAdresseMail(var22);
                     } else {
                        var33 = this.mejAdresseMail(var22);
                     }
                  }
               }

               String var35 = "";
               var17 = var15.getRecipients(RecipientType.CC);
               int var39;
               if (var17 != null) {
                  Address[] var36 = var17;
                  var37 = var17.length;

                  for(var39 = 0; var39 < var37; ++var39) {
                     Address var23 = var36[var39];
                     if (var35 != null && !var35.isEmpty()) {
                        var35 = var35 + "#" + this.mejAdresseMail(var23);
                     } else {
                        var35 = this.mejAdresseMail(var23);
                     }
                  }
               }

               String var38 = "";
               var17 = var15.getRecipients(RecipientType.BCC);
               int var42;
               if (var17 != null) {
                  Address[] var40 = var17;
                  var39 = var17.length;

                  for(var42 = 0; var42 < var39; ++var42) {
                     Address var24 = var40[var42];
                     if (var38 != null && !var38.isEmpty()) {
                        var38 = var38 + "#" + this.mejAdresseMail(var24);
                     } else {
                        var38 = this.mejAdresseMail(var24);
                     }
                  }
               }

               String var41 = "";
               var17 = var15.getReplyTo();
               if (var17 != null) {
                  Address[] var43 = var17;
                  var42 = var17.length;

                  for(int var45 = 0; var45 < var42; ++var45) {
                     Address var25 = var43[var45];
                     if (var41 != null && !var41.isEmpty()) {
                        var41 = var41 + "#" + this.mejAdresseMail(var25);
                     } else {
                        var41 = this.mejAdresseMail(var25);
                     }
                  }
               }

               boolean var44 = false;
               Contacts var46 = new Contacts();
               Tiers var47 = new Tiers();
               int var48;
               if (var2.size() != 0) {
                  for(var48 = 0; var48 < var2.size(); ++var48) {
                     var46 = (Contacts)var2.get(var48);
                     if (var46.getConmail1() != null && !var46.getConmail1().isEmpty() && var46.getConmail1().contains("@") && var16.contains(var46.getConmail1())) {
                        var47 = var46.getTiers();
                        var44 = true;
                        break;
                     }

                     if (!var44) {
                        if (var46.getConmail2() != null && !var46.getConmail2().isEmpty() && var46.getConmail2().contains("@") && var16.contains(var46.getConmail2())) {
                           var47 = var46.getTiers();
                           var44 = true;
                           break;
                        }

                        if (!var44) {
                           if (var46.getConmail3() != null && !var46.getConmail3().isEmpty() && var46.getConmail3().contains("@") && var16.contains(var46.getConmail3())) {
                              var47 = var46.getTiers();
                              var44 = true;
                              break;
                           }

                           if (!var44) {
                              if (var46.getConmail4() != null && !var46.getConmail4().isEmpty() && var46.getConmail4().contains("@") && var16.contains(var46.getConmail4())) {
                                 var47 = var46.getTiers();
                                 var44 = true;
                                 break;
                              }

                              if (!var44 && var46.getConmail5() != null && !var46.getConmail5().isEmpty() && var46.getConmail5().contains("@") && var16.contains(var46.getConmail5())) {
                                 var47 = var46.getTiers();
                                 var44 = true;
                                 break;
                              }
                           }
                        }
                     }
                  }
               }

               if (!var44 && var3.size() != 0) {
                  var46 = null;

                  for(var48 = 0; var48 < var3.size(); ++var48) {
                     var47 = (Tiers)var3.get(var48);
                     if (var47.getTiemail1() != null && !var47.getTiemail1().isEmpty() && var47.getTiemail1().contains("@") && var16.contains(var47.getTiemail1())) {
                        var44 = true;
                        break;
                     }

                     if (!var44) {
                        if (var47.getTiemail2() != null && !var47.getTiemail2().isEmpty() && var47.getTiemail2().contains("@") && var16.contains(var47.getTiemail2())) {
                           var44 = true;
                           break;
                        }

                        if (!var44) {
                           if (var47.getTiemail3() != null && !var47.getTiemail3().isEmpty() && var47.getTiemail3().contains("@") && var16.contains(var47.getTiemail3())) {
                              var44 = true;
                              break;
                           }

                           if (!var44) {
                              if (var47.getTiemail4() != null && !var47.getTiemail4().isEmpty() && var47.getTiemail4().contains("@") && var16.contains(var47.getTiemail4())) {
                                 var44 = true;
                                 break;
                              }

                              if (!var44 && var47.getTiemail5() != null && !var47.getTiemail5().isEmpty() && var47.getTiemail5().contains("@") && var16.contains(var47.getTiemail5())) {
                                 var44 = true;
                                 break;
                              }
                           }
                        }
                     }
                  }
               }

               ObjetMail var4;
               if (var44) {
                  if (!var44) {
                     var46 = null;
                     var47 = null;
                  }

                  var4 = new ObjetMail();
                  this.msg_body = "";
                  this.msg_pj = false;
                  if (var15.getContentType() != null) {
                     var4.setMailContentType(var15.getContentType());
                     long var49 = 0L;
                     if (var46 != null) {
                        var49 = var46.getConid();
                     } else {
                        var49 = 0L;
                     }

                     long var27 = 0L;
                     if (var47 != null) {
                        var27 = var47.getTieid();
                     } else {
                        var27 = 0L;
                     }

                     String var29 = "" + var27 + var49 + (var15.getReceivedDate().getYear() + 1900) + var15.getReceivedDate().getMonth() + var15.getReceivedDate().getDay() + var15.getReceivedDate().getHours() + var15.getReceivedDate().getMinutes() + var15.getReceivedDate().getSeconds();
                     long var30 = Long.parseLong(var29);
                     var4.setMailNumero(var30);
                     this.extractMessage(var15, var30, true);
                     var4.setMailContent(this.msg_body);
                     var4.setMailPj(this.msg_pj);
                     var4.setMailDateEnvoie(var15.getSentDate());
                     var4.setMailDateRecue(var15.getReceivedDate());
                     var4.setMailDescription(var15.getDescription());
                     var4.setMailDestinataire(var33);
                     var4.setMailDestinataireCC(var35);
                     var4.setMailDestinataireCCI(var38);
                     var4.setMailExpediteur(var16);
                     var4.setMailFileName(var15.getFileName());
                     var4.setMailIndice(var14);
                     var4.setMailSize(var15.getSize());
                     var4.setMailSujet(var15.getSubject());
                     if (var46 != null) {
                        var4.setMaiIdContact(var46.getConid());
                        var4.setMaiNomContact(var46.getConpatronyme());
                     } else {
                        var4.setMaiIdContact(0L);
                        var4.setMaiNomContact("");
                     }

                     if (var47 != null) {
                        var4.setMaiIdTiers(var47.getTieid());
                        var4.setMaiRaisonSociale(var47.getTieraisonsocialenom());
                     } else {
                        var4.setMaiIdTiers(0L);
                        var4.setMaiRaisonSociale("");
                     }

                     this.lesMailsAcceptes.add(var4);
                  }
               } else {
                  var4 = new ObjetMail();
                  this.msg_body = "";
                  this.msg_pj = false;
                  if (var15.getContentType() != null) {
                     var4.setMailContentType(var15.getContentType());
                     var4.setMailNumero(0L);
                     this.extractMessage(var15, 0L, false);
                     var4.setMailContent(this.msg_body);
                     var4.setMailPj(false);
                     var4.setMailDateEnvoie(var15.getSentDate());
                     var4.setMailDateRecue(var15.getReceivedDate());
                     var4.setMailDescription(var15.getDescription());
                     var4.setMailDestinataire(var33);
                     var4.setMailDestinataireCC(var35);
                     var4.setMailDestinataireCCI(var38);
                     var4.setMailExpediteur(var16);
                     var4.setMailFileName(var15.getFileName());
                     var4.setMailIndice(var14);
                     var4.setMailSize(var15.getSize());
                     var4.setMailSujet(var15.getSubject());
                     var4.setMaiIdContact(0L);
                     var4.setMaiNomContact("");
                     var4.setMaiIdTiers(0L);
                     var4.setMaiRaisonSociale("");
                     this.lesMailsRejetes.add(var4);
                  }
               }
            }
         }
      } catch (Exception var32) {
         var32.printStackTrace();
      }

      this.var_infosMsg = "Enregistrement des mails en cours";
      this.var_currentValueMsg = 0;
   }

   private void close(Folder var1) {
      if (var1 != null && var1.isOpen()) {
         try {
            var1.close(false);
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }

   }

   public String mejAdresseMail(Address var1) throws UnsupportedEncodingException {
      String var2 = new String(var1.toString().getBytes("ISO-8859-1"));
      String var3 = "";
      if (var2 != null && !var2.isEmpty()) {
         String[] var4 = null;
         if (var2.contains("<")) {
            var4 = var2.split("<");
            var3 = var4[0] + ":" + var4[1].substring(0, var4[1].length() - 1);
         } else {
            var3 = var2;
         }

         if (var3.contains("\"")) {
            char[] var5 = var3.toCharArray();
            String var6 = "";

            for(int var7 = 0; var7 < var5.length; ++var7) {
               if (var5[var7] != '"') {
                  var6 = var6 + var5[var7];
               }
            }

            var3 = var6;
         }

         if (var3.contains("ISO") && var3.contains(":")) {
            String[] var8 = var3.split(":");
            var3 = var8[1];
         }
      }

      return var3;
   }

   public void extractMessage(Message var1, long var2, boolean var4) throws Exception {
      try {
         if (var1.getContent() != null) {
            Object var5 = var1.getContent();
            if (var5 != null) {
               if (var5 instanceof Multipart) {
                  Multipart var6 = (Multipart)var5;
                  int var7 = 0;

                  for(int var8 = var6.getCount(); var7 < var8; ++var7) {
                     this.processBodyPart(var6.getBodyPart(var7), var2, var7, var4);
                  }
               } else {
                  this.processBodyPart(var1, var2, 0, var4);
               }
            }
         }
      } catch (MessagingException var9) {
         var9.printStackTrace();
      }

   }

   public void processBodyPart(Part var1, long var2, int var4, boolean var5) throws MessagingException, IOException {
      String var6 = System.getProperty("line.separator");
      String var7 = var1.getDisposition();
      String var8 = var1.getContentType();
      this.msg_pj = false;
      String var9;
      if (var7 == null) {
         var9 = "";
         if (var8 == null || !var8.contains("multipart/") && !var8.contains("multipart/ALTERNATIVE") && !var8.contains("multipart/RELATED") && !var8.contains("multipart/MIXED")) {
            byte[] var13;
            int var14;
            if (var8 == null || !var8.contains("IMAGE/JPEG") && !var8.contains("image/jpeg")) {
               if (var8 == null || !var8.contains("IMAGE/") && !var8.contains("image/")) {
                  if (var8 == null || !var8.contains("TEXT/PLAIN") && !var8.contains("text/plain")) {
                     if (var8 != null && (var8.contains("TEXT/HTML") || var8.contains("text/html"))) {
                        var9 = new String(var1.getContent().toString());
                        this.msg_body = this.msg_body + var6 + var9;
                     } else {
                        var9 = new String(var1.getContent().toString()) + " (AUTRE CONTENT-TYPE : " + var8 + ")";
                        this.msg_body = this.msg_body + var6 + var9;
                     }
                  }
               } else {
                  File var16 = new File("image" + (new Date()).getTime() + ".jpg");
                  DataOutputStream var18 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(var16)));
                  BASE64DecoderStream var20 = (BASE64DecoderStream)var1.getContent();
                  var13 = new byte[1024];

                  while((var14 = var20.read(var13)) != -1) {
                     var18.write(var13, 0, var14);
                  }
               }
            } else {
               Object var15 = var1.getContent();
               InputStream var11 = (InputStream)var15;
               boolean var12 = false;
               var13 = new byte[var11.available()];

               while(var11.available() > 0) {
                  var14 = var11.read(var13);
                  if (var14 == -1) {
                     break;
                  }
               }

               FileOutputStream var22 = new FileOutputStream("/tmp/image.jpg");
               var22.write(var13);
            }
         } else {
            InputStream var10 = var1.getInputStream();
            var9 = this.inputStreamToString(var10, var6);
            this.msg_body = this.msg_body + var6 + var9;
         }
      } else {
         DataHandler var17;
         File var19;
         FileOutputStream var21;
         if (var7.equalsIgnoreCase("attachment")) {
            if (var1.getFileName() != null && var5) {
               var9 = this.purgeFileName(var1.getFileName());
               var17 = var1.getDataHandler();
               var19 = new File(this.PATH_TO_DATA + var2 + ":" + var9);
               if (var19 != null) {
                  this.msg_pj = true;
                  if (!var19.exists()) {
                     var21 = new FileOutputStream(var19);
                     var17.writeTo(var21);
                     var21.flush();
                     var21.close();
                  }
               }

               this.msg_body = this.msg_body + var6 + var1.getFileName();
            }
         } else if (var7.equalsIgnoreCase("inline") && var1.getFileName() != null && var5) {
            var9 = this.purgeFileName(var1.getFileName());
            var17 = var1.getDataHandler();
            var19 = new File(this.PATH_TO_DATA + var2 + ":" + var9);
            if (var19 != null) {
               this.msg_pj = true;
               if (!var19.exists()) {
                  var21 = new FileOutputStream(var19);
                  var17.writeTo(var21);
                  var21.flush();
                  var21.close();
               }
            }

            this.msg_body = this.msg_body + var6 + var1.getFileName();
         }
      }

   }

   private String purgeFileName(String var1) throws UnsupportedEncodingException {
      String var2 = "";
      if (var1.toString().contains(" ")) {
         String var3 = "";

         for(int var4 = 0; var4 < var1.length(); ++var4) {
            String var5 = var1.substring(var4, var4 + 1);
            if (var5.equals(" ")) {
               var3 = var3 + "_";
            } else {
               var3 = var3 + var1.substring(var4, var4 + 1);
            }
         }

         var2 = var3;
      } else {
         var2 = var1;
      }

      if (var2 == null || var2.isEmpty()) {
         var2 = "fichier";
      }

      return var2;
   }

   public String inputStreamToString(InputStream var1, String var2) throws IOException {
      String var3 = "";
      BufferedReader var4 = new BufferedReader(new InputStreamReader(var1));
      StringBuilder var5 = new StringBuilder();
      String var6 = null;

      while((var6 = var4.readLine()) != null) {
         var5.append(var6 + "\n");
      }

      var4.close();
      var3 = var5.toString();
      return var3;
   }

   public int getVar_currentValueMsg() {
      return this.var_currentValueMsg;
   }

   public void setVar_currentValueMsg(int var1) {
      this.var_currentValueMsg = var1;
   }

   public String getVar_infosMsg() {
      return this.var_infosMsg;
   }

   public void setVar_infosMsg(String var1) {
      this.var_infosMsg = var1;
   }

   public List getLesMailsRejetes() {
      return this.lesMailsRejetes;
   }

   public void setLesMailsRejetes(List var1) {
      this.lesMailsRejetes = var1;
   }

   public List getLesMailsAcceptes() {
      return this.lesMailsAcceptes;
   }

   public void setLesMailsAcceptes(List var1) {
      this.lesMailsAcceptes = var1;
   }
}
