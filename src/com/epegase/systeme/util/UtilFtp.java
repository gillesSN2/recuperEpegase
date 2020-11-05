package com.epegase.systeme.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.TrustManager;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.util.TrustManagerUtils;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilFtp implements Serializable {
   private String ftpHostIP;
   private int port;
   private String username;
   private String password;
   private String ftpHostIPParam;
   private int portParam;
   private String usernameParam;
   private String passwordParam;

   public String sendFile(String var1, String var2, String var3, int var4) throws UnknownHostException, SocketException, IOException {
      String var5 = "";
      if (var4 == 0) {
         this.ftpHostIP = StaticModePegase.getIpServeur();
         this.port = 10021;
         this.username = "ePegaseFtp";
         this.password = "ePegaseFtp#";
         var3 = File.separator + "opt" + File.separator + "download" + File.separator + "backupBD";
         if (this.port == 10022) {
            var5 = this.envoieSecuriseTLS(var1, var2, var3);
         } else {
            var5 = this.envoieNormal(var1, var2, var3);
         }
      } else if (var4 == 10) {
         this.ftpHostIP = StaticModePegase.getIpServeur();
         this.port = 10021;
         this.username = "ePegaseFtp";
         this.password = "ePegaseFtp#";
         var3 = File.separator + "opt" + File.separator + "download" + File.separator + "backupGED";
         var5 = this.envoieNormal(var1, var2, var3);
      } else if (var4 == 21) {
         this.ftpHostIP = "162.251.80.22";
         this.port = 21;
         this.username = "ePegaseGdc@e-pegase.biz";
         this.password = "ePegaseGdc##";
         var3 = File.separator + "basesDonnees";
         var5 = this.envoieNormal(var1, var2, var3);
      } else if (var4 == 22) {
         this.ftpHostIP = "162.251.80.22";
         this.port = 21;
         this.username = "ePegaseGdc@e-pegase.biz";
         this.password = "ePegaseGdc##";
         var3 = File.separator + "saveDossier";
         var5 = this.envoieNormal(var1, var2, var3);
      } else if (var4 == 3) {
         this.ftpHostIP = this.ftpHostIPParam;
         this.port = this.portParam;
         this.username = this.usernameParam;
         this.password = this.passwordParam;
         var5 = this.envoieNormal(var1, var2, var3);
      }

      return var5;
   }

   public String sendFileEvolution(String var1, String var2) throws UnknownHostException, SocketException, IOException {
      String var3 = "";
      this.ftpHostIP = StaticModePegase.getIpServeur();
      this.port = 10021;
      this.username = "ePegaseFtp";
      this.password = "ePegaseFtp#";
      String var4 = File.separator + "opt" + File.separator + "glassfish" + File.separator + "domains" + File.separator + "domain1" + File.separator + "config" + File.separator + "epegase" + File.separator + "clients";
      var3 = this.envoieNormal(var1, var2, var4);
      return var3;
   }

   public String envoieNormal(String var1, String var2, String var3) {
      String var4 = "";
      String var5 = var3 + File.separator + var2;

      try {
         boolean var6 = true;
         FTPClient var7 = new FTPClient();
         FTPClientConfig var8 = new FTPClientConfig("UNIX");
         var8.setServerLanguageCode("fr");
         var8.setShortMonthNames("jan|fev|mar|avr|mai|jun|jul|aoû|sep|oct|nov|déc");
         var8.setDefaultDateFormatStr("dd MMM yyyy");
         var8.setRecentDateFormatStr("dd MMM HH:mm");
         var7.configure(var8);
         var7.connect(this.ftpHostIP, this.port);
         int var9 = var7.getReplyCode();
         if (FTPReply.isPositiveCompletion(var9)) {
            var7.login(this.username, this.password);
            var7.setFileType(2);
            var7.enterLocalPassiveMode();
            var6 = var7.changeWorkingDirectory(var3);
            if (var6) {
               try {
                  File var10 = new File(var1);
                  FileInputStream var11 = new FileInputStream(var10);
                  var7.storeFile(var5, var11);
                  var11.close();
                  var7.noop();
                  var7.logout();
               } catch (FTPConnectionClosedException var23) {
                  var4 = " Error: Server closed connection.";
               } catch (IOException var24) {
                  var4 = " Error: " + var24.toString();
               } finally {
                  if (var7.isConnected()) {
                     try {
                        var7.disconnect();
                     } catch (IOException var22) {
                     }
                  }

               }
            } else {
               var4 = " Error: Directory doesn't exist " + var3;
               var7.disconnect();
            }
         } else {
            var4 = " Error: Directory doesn't exist ";
            var7.disconnect();
         }
      } catch (Exception var26) {
         var4 = " Error: " + var26.toString();
      }

      return var4;
   }

   public String envoieSecuriseTLS(String var1, String var2, String var3) {
      String var4 = "";
      String var5 = var3 + var2;

      try {
         boolean var6 = true;
         FTPSClient var7 = new FTPSClient("SSL");
         var7.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
         var7.setTrustManager(TrustManagerUtils.getValidateServerCertificateTrustManager());
         var7.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
         var7.setTrustManager((TrustManager)null);
         FTPClientConfig var8 = new FTPClientConfig("UNIX");
         var8.setServerLanguageCode("fr");
         var8.setShortMonthNames("jan|fev|mar|avr|mai|jun|jul|aoû|sep|oct|nov|déc");
         var8.setDefaultDateFormatStr("dd MMM yyyy");
         var8.setRecentDateFormatStr("dd MMM HH:mm");
         var7.configure(var8);
         var7.connect(this.ftpHostIP, this.port);
         int var9 = var7.getReplyCode();
         if (FTPReply.isPositiveCompletion(var9)) {
            var7.login(this.username, this.password);
            var6 = var7.changeWorkingDirectory(var3);
            if (var6) {
               try {
                  var7.setBufferSize(1000);
                  var7.setFileType(2);
                  var7.enterLocalPassiveMode();
                  File var10 = new File(var1);
                  byte var11 = 0;
                  FileInputStream var12;
                  if (var11 == 0) {
                     var12 = new FileInputStream(var1);
                     var7.storeFile(var5, var12);
                     var12.close();
                  } else if (var11 == 3) {
                     var12 = new FileInputStream(var10);
                     var7.storeFile(var5, var12);
                     var12.close();
                  }

                  var7.noop();
                  var7.logout();
               } catch (FTPConnectionClosedException var24) {
                  var4 = " Error: Server closed connection.";
               } catch (IOException var25) {
                  var4 = " Error: " + var25.toString();
               } finally {
                  if (var7.isConnected()) {
                     try {
                        var7.disconnect();
                     } catch (IOException var23) {
                     }
                  }

               }
            } else {
               var4 = " Error: Directory doesn't exist " + var3;
               var7.disconnect();
            }
         } else {
            var4 = " Error: Directory doesn't exist ";
            var7.disconnect();
         }
      } catch (Exception var27) {
         var4 = " Error: " + var27.toString();
      }

      return var4;
   }

   public String receptionNormal(String var1, String var2, String var3) throws UnsupportedEncodingException {
      String var4 = "";
      String var5 = URLDecoder.decode(var3 + File.separator + var2, "UTF-8").trim();

      try {
         boolean var6 = true;
         boolean var7 = false;
         FTPClient var8 = new FTPClient();
         var8.connect(this.ftpHostIP, this.port);
         int var9 = var8.getReplyCode();
         if (!FTPReply.isPositiveCompletion(var9)) {
            var4 = " Error: Directory doesn't exist ";
            var8.disconnect();
         } else {
            var8.login(this.username, this.password);
            var8.setFileType(2);
            var8.enterLocalPassiveMode();
            var6 = var8.changeWorkingDirectory(var3);
            if (!var6) {
               var4 = " Error: Directory doesn't exist " + var3;
               var8.disconnect();
            } else {
               BufferedOutputStream var10 = new BufferedOutputStream(new FileOutputStream(var1));
               InputStream var11 = var8.retrieveFileStream(var5);
               byte[] var12 = new byte[4096];
               boolean var13 = true;

               int var15;
               while((var15 = var11.read(var12)) != -1) {
                  var10.write(var12, 0, var15);
               }

               var7 = var8.completePendingCommand();
               if (var7) {
                  var4 = "";
               } else {
                  var4 = " Error: File don`t downloaded " + var3;
                  var8.disconnect();
               }

               var10.close();
               var11.close();
            }
         }

         var8.disconnect();
      } catch (Exception var14) {
         var4 = " Error: " + var14.toString();
      }

      return var4;
   }

   public String receptionSecuriseTLS(String var1, String var2, String var3) {
      String var4 = "";
      String var5 = var3 + File.separator + var2;

      try {
         boolean var6 = true;
         FTPSClient var7 = new FTPSClient("SSL");
         var7.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
         var7.setTrustManager(TrustManagerUtils.getValidateServerCertificateTrustManager());
         var7.setTrustManager(TrustManagerUtils.getAcceptAllTrustManager());
         var7.setTrustManager((TrustManager)null);
         FTPClientConfig var8 = new FTPClientConfig("UNIX");
         var8.setServerLanguageCode("fr");
         var8.setShortMonthNames("jan|fev|mar|avr|mai|jun|jul|aoû|sep|oct|nov|déc");
         var8.setDefaultDateFormatStr("dd MMM yyyy");
         var8.setRecentDateFormatStr("dd MMM HH:mm");
         var7.configure(var8);
         var7.connect(this.ftpHostIP, this.port);
         int var9 = var7.getReplyCode();
         if (FTPReply.isPositiveCompletion(var9)) {
            var7.login(this.username, this.password);
            var6 = var7.changeWorkingDirectory(var3);
            if (var6) {
               try {
                  var7.setBufferSize(1000);
                  var7.setFileType(2);
                  var7.enterLocalPassiveMode();
                  File var10 = new File(var5);
                  byte var11 = 0;
                  FileInputStream var12;
                  if (var11 == 0) {
                     var12 = new FileInputStream(var10);
                     var7.storeFile(var1, var12);
                     var12.close();
                  } else if (var11 == 3) {
                     var12 = new FileInputStream(var10);
                     var7.storeFile(var1, var12);
                     var12.close();
                  }

                  var7.noop();
                  var7.logout();
               } catch (FTPConnectionClosedException var24) {
                  var4 = " Error: Server closed connection.";
               } catch (IOException var25) {
                  var4 = " Error: " + var25.toString();
               } finally {
                  if (var7.isConnected()) {
                     try {
                        var7.disconnect();
                     } catch (IOException var23) {
                     }
                  }

               }
            } else {
               var4 = " Error: Directory doesn't exist " + var3;
               var7.disconnect();
            }
         } else {
            var4 = " Error: Directory doesn't exist ";
            var7.disconnect();
         }
      } catch (Exception var27) {
         var4 = " Error: " + var27.toString();
      }

      return var4;
   }

   public List listeFichierDepuisHorus(String var1) throws SocketException, IOException {
      String var2 = "";
      ArrayList var3 = new ArrayList();
      this.ftpHostIP = StaticModePegase.getIpServeur();
      this.port = 10021;
      this.username = "ePegaseFtp";
      this.password = "ePegaseFtp#";
      String var4 = File.separator + "opt" + File.separator + "download" + File.separator + "bibliotheque" + var1;

      try {
         boolean var5 = true;
         FTPClient var6 = new FTPClient();
         FTPClientConfig var7 = new FTPClientConfig("UNIX");
         var7.setServerLanguageCode("fr");
         var7.setShortMonthNames("jan|fev|mar|avr|mai|jun|jul|aoû|sep|oct|nov|déc");
         var7.setDefaultDateFormatStr("dd MMM yyyy");
         var7.setRecentDateFormatStr("dd MMM HH:mm");
         var6.configure(var7);
         var6.connect(this.ftpHostIP, this.port);
         int var8 = var6.getReplyCode();
         if (FTPReply.isPositiveCompletion(var8)) {
            var6.login(this.username, this.password);
            var6.setFileType(2);
            var6.enterLocalPassiveMode();
            var5 = var6.changeWorkingDirectory(var4);
            if (var5) {
               String[] var9 = var6.listNames();
               if (var9 != null) {
                  var9 = this.triAlphabetique(var9, var9.length);

                  for(int var10 = 0; var10 < var9.length; ++var10) {
                     if (var9[var10].endsWith("jasper")) {
                        String var11 = var9[var10].substring(0, var9[var10].indexOf("."));
                        var3.add(var11);
                     }
                  }
               }
            } else {
               (new StringBuilder()).append(" Error: Directory doesn't exist ").append(var4).toString();
               var6.disconnect();
            }
         } else {
            var2 = " Error: Directory doesn't exist ";
            var6.disconnect();
         }
      } catch (Exception var12) {
         var2 = " Error: " + var12.toString();
      }

      return var3;
   }

   public String copierFichierVersHorus(String var1, String var2, String var3) {
      String var4 = "";
      this.ftpHostIP = StaticModePegase.getIpServeur();
      this.port = 10021;
      this.username = "ePegaseFtp";
      this.password = "ePegaseFtp#";
      String var5 = File.separator + "opt" + File.separator + "glassfish" + File.separator + "domains" + File.separator + "domain1" + File.separator + "config" + File.separator + "epegase" + File.separator + "bibliotheque" + var2;
      var4 = this.envoieNormal(var1, var3, var5);
      return var4;
   }

   public String copierFichierDepuisHorus(String var1, String var2, String var3) throws UnsupportedEncodingException {
      String var4 = "";
      this.ftpHostIP = StaticModePegase.getIpServeur();
      this.port = 10021;
      this.username = "ePegaseFtp";
      this.password = "ePegaseFtp#";
      var4 = this.receptionNormal(var1, var2, var3);
      return var4;
   }

   public String[] triAlphabetique(String[] var1, int var2) {
      int var3 = var2;
      boolean var4;
      if (var2 != 0) {
         do {
            var4 = false;

            for(int var5 = 0; var5 < var3 - 1; ++var5) {
               if (var1[var5].compareToIgnoreCase(var1[var5 + 1]) > 0) {
                  this.echanger(var1, var5, var5 + 1);
                  var4 = true;
               }
            }

            --var3;
         } while(var4);
      }

      return var1;
   }

   public void echanger(String[] var1, int var2, int var3) {
      String var4 = var1[var2];
      var1[var2] = var1[var3];
      var1[var3] = var4;
   }

   public String getFtpHostIPParam() {
      return this.ftpHostIPParam;
   }

   public void setFtpHostIPParam(String var1) {
      this.ftpHostIPParam = var1;
   }

   public String getPasswordParam() {
      return this.passwordParam;
   }

   public void setPasswordParam(String var1) {
      this.passwordParam = var1;
   }

   public int getPortParam() {
      return this.portParam;
   }

   public void setPortParam(int var1) {
      this.portParam = var1;
   }

   public String getUsernameParam() {
      return this.usernameParam;
   }

   public void setUsernameParam(String var1) {
      this.usernameParam = var1;
   }
}
