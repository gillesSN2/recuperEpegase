package com.epegase.forms.systeme;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FormServerLog implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String fichierServer;
   private String jvmServeur;

   public void lectureFichierGlassfish() throws UnknownHostException {
      String var1 = "";
      String var2 = "";
      InetAddress var3 = InetAddress.getLocalHost();
      String var4 = var3.getHostAddress();
      if (!var4.startsWith("192.") && !var4.startsWith("127.") && !var4.startsWith("10.")) {
         var2 = "/opt/glassfish/domains/epegase/logs/server.log";
      } else if (StaticModePegase.getOsContext() == 0) {
         var2 = "/usr/local/SUNWappserver/domains/domain1/logs/server.log";
      } else if (StaticModePegase.getOsContext() == 1) {
         var2 = "C:/Sun/SunAppServer/domains/domain1/logs/server.log";
      } else if (StaticModePegase.getOsContext() == 2) {
         var2 = "/usr/local/SUNWappserver/domains/domain1/logs/server.log";
      }

      try {
         FileInputStream var5 = new FileInputStream(var2);
         InputStreamReader var6 = new InputStreamReader(var5);
         BufferedReader var7 = new BufferedReader(var6);

         for(String var8 = ""; (var8 = var7.readLine()) != null; var1 = var1 + var8 + "\n") {
         }

         this.fichierServer = var1;
         var7.close();
      } catch (Exception var9) {
         this.fichierServer = var9.toString() + "";
      }

   }

   public void lectureFichierJvm() throws UnknownHostException {
      String var1 = "";
      String var2 = "";
      InetAddress var3 = InetAddress.getLocalHost();
      String var4 = var3.getHostAddress();
      if (!var4.startsWith("192.") && !var4.startsWith("127.") && !var4.startsWith("10.")) {
         var2 = "/opt/glassfish/domains/epegase/logs/jvm.log";
      } else if (StaticModePegase.getOsContext() == 1) {
         var2 = "C:/Sun/SunAppServer/domains/domain1/logs/jvm.log";
      } else {
         var2 = "/usr/local/SUNWappserver/domains/domain1/logs/jvm.log";
      }

      try {
         FileInputStream var5 = new FileInputStream(var2);
         InputStreamReader var6 = new InputStreamReader(var5);
         BufferedReader var7 = new BufferedReader(var6);

         for(String var8 = ""; (var8 = var7.readLine()) != null; var1 = var1 + var8 + "\n") {
         }

         this.jvmServeur = var1;
         var7.close();
      } catch (Exception var9) {
         System.out.println(var9.toString());
         this.jvmServeur = var9.toString() + "";
      }

   }

   public String getFichierServer() {
      return this.fichierServer;
   }

   public void setFichierServer(String var1) {
      this.fichierServer = var1;
   }

   public String getJvmServeur() {
      return this.jvmServeur;
   }

   public void setJvmServeur(String var1) {
      this.jvmServeur = var1;
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

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
