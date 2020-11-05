package com.epegase.systeme.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.faces.context.FacesContext;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletContext;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.SAXException;

public class StaticModePegase implements Serializable {
   private static String urlIp;
   private static String ipServeur;
   private static int urlPort;
   private static String urlHost;
   private static String urlProtocole;
   private static boolean localApplication = false;
   private static String compil_version;
   private static String compil_date;
   private static String version_distante;
   private static String date_distante;
   private static String cheminContext;
   private static int internet_actif;
   private static int osContext;
   private static String accesBase = "";
   private static String accesServeur = "";
   private static String imageStartup;
   private static String pageAccueil;
   private static String reponseFinale;
   private static boolean affiche_message = false;
   private static String texte_message;
   private static int sslEmmeteurSmp;
   private static int authentificationEmetteurSmp;
   private static String serveurEmetteurSmp;
   private static int portEmetteurSmp;
   private static String adresseEmetteurSmp;
   private static String pwEmetteurSmp;

   public StaticModePegase() throws UnknownHostException, ParserConfigurationException, SAXException, JDOMException, IOException, NoSuchAlgorithmException, KeyManagementException {
      ipServeur = "94.247.27.91";
      sslEmmeteurSmp = 0;
      authentificationEmetteurSmp = 1;
      serveurEmetteurSmp = "mail.e-pegase.biz";
      portEmetteurSmp = 25;
      adresseEmetteurSmp = "infos";
      pwEmetteurSmp = "?MJ]e4i9wavl";
      this.VersionInstallee();
      this.VersionDistante();
   }

   public void VersionInstallee() {
      FacesContext var1 = FacesContext.getCurrentInstance();
      ServletContext var2 = (ServletContext)var1.getExternalContext().getContext();
      cheminContext = var2.getContextPath().substring(1);
      compil_version = "";
      compil_date = "";

      try {
         SAXBuilder var3 = new SAXBuilder();
         File var4 = new File(cheminContext + File.separator + "configuration" + File.separator + "update" + File.separator + "version.xml");
         if (var4.exists()) {
            FileReader var5 = new FileReader(var4);
            Document var6 = var3.build(var5);
            Element var7 = var6.getRootElement();
            compil_version = var7.getChildText("numero");
            compil_date = var7.getChildText("date");
            internet_actif = Integer.parseInt(var7.getChildText("internet"));
            osContext = Integer.parseInt(var7.getChildText("os"));
            if (osContext != 3) {
               String var8 = System.getProperty("os.name");
               if (var8.contains("Linux")) {
                  osContext = 0;
               } else if (var8.contains("Windows")) {
                  osContext = 1;
               } else if (var8.contains("Mac")) {
                  osContext = 2;
               }
            }

            if (var7.getChildText("base") != null && !var7.getChildText("base").isEmpty()) {
               accesBase = var7.getChildText("base");
            } else {
               accesBase = "localhost:3306";
            }

            InetAddress var15 = InetAddress.getLocalHost();
            String var9 = var15.getHostAddress();
            if (!var9.startsWith("192.") && !var9.startsWith("127.") && !var9.startsWith("10.")) {
               localApplication = false;
               if (var9.equals(ipServeur)) {
                  accesServeur = "www.e-pegase.biz";
                  urlIp = "https://www.e-pegase.biz";
                  urlHost = "www.e-pegase.biz";
                  urlPort = 443;
               } else {
                  boolean var16 = false;
                  String var11 = "";
                  int var17;
                  if (var7.getChildText("serveur") != null && !var7.getChildText("serveur").isEmpty()) {
                     String[] var12 = var7.getChildText("serveur").split(":");
                     var11 = var12[0];
                     var17 = Integer.parseInt(var12[1]);
                  } else {
                     var11 = var9;
                     var17 = 8080;
                  }

                  accesServeur = var11 + ":" + var17;
                  urlIp = "http://" + var11;
                  urlHost = var11;
                  urlPort = var17;
               }
            } else {
               localApplication = true;
               if (var7.getChildText("serveur") != null && !var7.getChildText("serveur").isEmpty()) {
                  accesServeur = var7.getChildText("serveur");
               } else {
                  accesServeur = "localhost:8080";
               }

               urlIp = "http://" + accesServeur;
               String[] var10 = accesServeur.split(":");
               urlHost = var10[0];
               urlPort = Integer.parseInt(var10[1]);
            }

            var5.close();
            System.out.println("************************************ ip : " + var9);
            if (var9.startsWith("https://")) {
               urlProtocole = "https";
            } else {
               urlProtocole = "http";
            }

            imageStartup = var7.getChildText("imageStartup");
            if (imageStartup == null || imageStartup.isEmpty()) {
               imageStartup = "startup";
            }

            if (urlHost.equalsIgnoreCase("www.e-pegase.biz")) {
               imageStartup = "startup";
            }

            pageAccueil = var7.getChildText("pageAccueil");
            if (pageAccueil == null || pageAccueil.isEmpty()) {
               pageAccueil = "1";
            }

            if (urlHost.equalsIgnoreCase("www.e-pegase.biz")) {
               pageAccueil = "1";
            }
         }

         System.out.println("************************************ ip : " + urlHost);
         System.out.println("************************************ base : " + accesBase);
         System.out.println("************************************ serveur : " + accesServeur);
         System.out.println("************************************ urlIp : " + urlIp);
      } catch (JDOMException var13) {
      } catch (IOException var14) {
      }

   }

   private boolean netIsAvailable() {
      try {
         URL var1 = new URL("http://www.google.com");
         URLConnection var2 = var1.openConnection();
         var2.connect();
         return true;
      } catch (MalformedURLException var3) {
         throw new RuntimeException(var3);
      } catch (IOException var4) {
         return false;
      }
   }

   public void VersionDistante() throws UnknownHostException, ParserConfigurationException, SAXException, JDOMException, IOException, NoSuchAlgorithmException, KeyManagementException {
      version_distante = "";
      date_distante = "";
      if (internet_actif == 2) {
         if (this.netIsAvailable()) {
            InetAddress var1 = InetAddress.getLocalHost();
            String var2 = var1.getHostAddress();
            if (var2.startsWith("192.") || var2.startsWith("127.") || var2.startsWith("10.")) {
               try {
                  TrustManager[] var3 = new TrustManager[]{new X509TrustManager() {
                     public X509Certificate[] getAcceptedIssuers() {
                        return null;
                     }

                     public void checkClientTrusted(X509Certificate[] var1, String var2) {
                     }

                     public void checkServerTrusted(X509Certificate[] var1, String var2) {
                     }
                  }};
                  SSLContext var4 = SSLContext.getInstance("SSL");
                  var4.init((KeyManager[])null, var3, new SecureRandom());
                  HttpsURLConnection.setDefaultSSLSocketFactory(var4.getSocketFactory());
                  HostnameVerifier var5 = new HostnameVerifier() {
                     public boolean verify(String var1, SSLSession var2) {
                        return true;
                     }
                  };
                  HttpsURLConnection.setDefaultHostnameVerifier(var5);
                  SAXBuilder var6 = new SAXBuilder();
                  String var7 = "https://" + ipServeur + ":" + "443" + "/epegase/update/versionServeur.xml";
                  URL var8 = new URL(var7);
                  System.out.println("************************************ connexion : " + var8);
                  Document var9 = var6.build(var8.openStream());
                  Element var10 = var9.getRootElement();
                  version_distante = var10.getChildText("numero");
                  date_distante = var10.getChildText("date");
                  internet_actif = 2;
                  if (getVersion_distante() != null && !getVersion_distante().isEmpty() && !getVersion_distante().equalsIgnoreCase(getCompil_version())) {
                     texte_message = "UNE NOUVELLE VERSION EST DISPONIBLE. Allez dans Administration, puis Utilitaires et Maintenance pour procéder à la mise à jour.";
                     affiche_message = true;
                  }
               } catch (IOException var11) {
                  if (var11.toString().contains("NoRouteToHostException")) {
                     internet_actif = 1;
                  } else {
                     internet_actif = 0;
                  }

                  System.out.println("************************************ erreur1 : " + var11.toString());
               } catch (JDOMException var12) {
                  internet_actif = 0;
                  System.out.println("************************************ erreur2 : " + var12.toString());
               } catch (KeyManagementException var13) {
                  internet_actif = 0;
                  System.out.println("************************************ erreur3 : " + var13.toString());
               } catch (NoSuchAlgorithmException var14) {
                  internet_actif = 0;
                  System.out.println("************************************ erreur4 : " + var14.toString());
               }
            }

            if (internet_actif == 0) {
               if (this.netIsAvailable()) {
                  internet_actif = 1;
               } else {
                  internet_actif = 0;
               }
            }
         } else {
            internet_actif = 0;
         }
      }

      System.out.println("************************************ internet : " + internet_actif);
   }

   public static String getUrlIp() {
      return urlIp;
   }

   public static void setUrlIp(String var0) {
      urlIp = var0;
   }

   public String getvarUrlIp() {
      return urlIp;
   }

   public static String getCompil_date() {
      return compil_date;
   }

   public static void setCompil_date(String var0) {
      compil_date = var0;
   }

   public static String getCompil_version() {
      return compil_version;
   }

   public static void setCompil_version(String var0) {
      compil_version = var0;
   }

   public static String getDate_distante() {
      return date_distante;
   }

   public static void setDate_distante(String var0) {
      date_distante = var0;
   }

   public static String getVersion_distante() {
      return version_distante;
   }

   public static void setVersion_distante(String var0) {
      version_distante = var0;
   }

   public static String getCheminContext() {
      return cheminContext;
   }

   public static void setCheminContext(String var0) {
      cheminContext = var0;
   }

   public static int getInternet_actif() {
      return internet_actif;
   }

   public static void setInternet_actif(int var0) {
      internet_actif = var0;
   }

   public static int getOsContext() {
      return osContext;
   }

   public static void setOsContext(int var0) {
      osContext = var0;
   }

   public static boolean isLocalApplication() {
      return localApplication;
   }

   public static void setLocalApplication(boolean var0) {
      localApplication = var0;
   }

   public static String getAccesBase() {
      return accesBase;
   }

   public static void setAccesBase(String var0) {
      accesBase = var0;
   }

   public static String getImageStartup() {
      return imageStartup;
   }

   public static void setImageStartup(String var0) {
      imageStartup = var0;
   }

   public static String getAccesServeur() {
      return accesServeur;
   }

   public static void setAccesServeur(String var0) {
      accesServeur = var0;
   }

   public static String getUrlHost() {
      if (urlHost == null || urlHost.isEmpty()) {
         urlHost = "localhost";
      }

      return urlHost;
   }

   public static void setUrlHost(String var0) {
      urlHost = var0;
   }

   public static int getUrlPort() {
      return urlPort;
   }

   public static void setUrlPort(int var0) {
      urlPort = var0;
   }

   public static String getUrlProtocole() {
      return urlProtocole;
   }

   public static void setUrlProtocole(String var0) {
      urlProtocole = var0;
   }

   public static boolean isAffiche_message() {
      return affiche_message;
   }

   public static void setAffiche_message(boolean var0) {
      affiche_message = var0;
   }

   public static String getTexte_message() {
      return texte_message;
   }

   public static void setTexte_message(String var0) {
      texte_message = var0;
   }

   public static String getIpServeur() {
      return ipServeur;
   }

   public static void setIpServeur(String var0) {
      ipServeur = var0;
   }

   public static String getPageAccueil() {
      return pageAccueil;
   }

   public static void setPageAccueil(String var0) {
      pageAccueil = var0;
   }

   public static String getAdresseEmetteurSmp() {
      return adresseEmetteurSmp;
   }

   public static void setAdresseEmetteurSmp(String var0) {
      adresseEmetteurSmp = var0;
   }

   public static int getAuthentificationEmetteurSmp() {
      return authentificationEmetteurSmp;
   }

   public static void setAuthentificationEmetteurSmp(int var0) {
      authentificationEmetteurSmp = var0;
   }

   public static int getPortEmetteurSmp() {
      return portEmetteurSmp;
   }

   public static void setPortEmetteurSmp(int var0) {
      portEmetteurSmp = var0;
   }

   public static String getPwEmetteurSmp() {
      return pwEmetteurSmp;
   }

   public static void setPwEmetteurSmp(String var0) {
      pwEmetteurSmp = var0;
   }

   public static String getServeurEmetteurSmp() {
      return serveurEmetteurSmp;
   }

   public static void setServeurEmetteurSmp(String var0) {
      serveurEmetteurSmp = var0;
   }

   public static int getSslEmmeteurSmp() {
      return sslEmmeteurSmp;
   }

   public static void setSslEmmeteurSmp(int var0) {
      sslEmmeteurSmp = var0;
   }

   public static String getReponseFinale() {
      return reponseFinale;
   }

   public static void setReponseFinale(String var0) {
      reponseFinale = var0;
   }
}
