package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import java.io.File;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.SAXException;

public class LectureEvolution implements Serializable {
   private ObjetEvolution objetEvolution;
   private List lesEvolutions = new ArrayList();
   private UtilDate utilDate = new UtilDate();

   public LectureEvolution(String var1, String var2, String var3, String var4) throws UnknownHostException, ParserConfigurationException, SAXException, JDOMException, IOException, NoSuchAlgorithmException, KeyManagementException, ParseException {
      this.recupereEvolution(var1, var2, var3, var4);
   }

   public void recupereEvolution(String var1, String var2, String var3, String var4) throws UnknownHostException, ParserConfigurationException, SAXException, JDOMException, IOException, NoSuchAlgorithmException, KeyManagementException, ParseException {
      boolean var5 = true;
      InetAddress var6 = InetAddress.getLocalHost();
      String var7 = var6.getHostAddress();
      String var24;
      String var25;
      String var26;
      if ((this.netIsAvailable() || var7.equals(StaticModePegase.getIpServeur())) && (var7.startsWith("192.") || var7.startsWith("127.") || var7.startsWith("10.") || var7.equals(StaticModePegase.getIpServeur()))) {
         try {
            TrustManager[] var8 = new TrustManager[]{new X509TrustManager() {
               public X509Certificate[] getAcceptedIssuers() {
                  return null;
               }

               public void checkClientTrusted(X509Certificate[] var1, String var2) {
               }

               public void checkServerTrusted(X509Certificate[] var1, String var2) {
               }
            }};
            SSLContext var9 = SSLContext.getInstance("SSL");
            var9.init((KeyManager[])null, var8, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(var9.getSocketFactory());
            HostnameVerifier var10 = new HostnameVerifier() {
               public boolean verify(String var1, SSLSession var2) {
                  return true;
               }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(var10);
            SAXBuilder var11 = new SAXBuilder();
            String var12 = "https://" + StaticModePegase.getIpServeur() + ":" + "443" + File.separator + "epegase" + File.separator + "clients" + File.separator + "evolutions.xml";
            URL var13 = new URL(var12);
            Document var14 = var11.build(var13.openStream());
            Element var15 = var14.getRootElement();
            this.lesEvolutions = new ArrayList();
            List var16 = var15.getChildren();
            boolean var17 = false;
            boolean var18 = false;
            boolean var19 = false;
            Date var20 = this.utilDate.stringToDateSQLLight(var1);
            Date var21 = this.utilDate.stringToDateSQLLight(var2);
            Date var22 = null;

            for(int var23 = 0; var23 < var16.size(); ++var23) {
               this.objetEvolution = new ObjetEvolution();
               var24 = ((Element)var16.get(var23)).getChild("version").getText();
               var25 = ((Element)var16.get(var23)).getChild("date").getText();
               var26 = ((Element)var16.get(var23)).getChild("type").getText();
               String var27 = ((Element)var16.get(var23)).getChild("module").getText();
               String var28 = ((Element)var16.get(var23)).getChild("ecran").getText();
               String var29 = ((Element)var16.get(var23)).getChild("objet").getText();
               String var30 = ((Element)var16.get(var23)).getChild("detail").getText();
               String var31 = ((Element)var16.get(var23)).getChild("developpeur").getText();
               var22 = this.utilDate.stringToDateSQLLight(var25);
               var17 = false;
               var18 = false;
               var19 = false;
               if (var3 != null && !var3.isEmpty()) {
                  if (var3.equals(var27)) {
                     var17 = true;
                  }
               } else {
                  var17 = true;
               }

               if (var4 != null && !var4.isEmpty()) {
                  if (var29.contains(var3) || var30.contains(var3) || var24.contains(var3)) {
                     var18 = true;
                  }
               } else {
                  var18 = true;
               }

               if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
                  if (var22.compareTo(var20) >= 0 && var22.compareTo(var21) <= 0) {
                     var19 = true;
                  }
               } else {
                  var19 = true;
               }

               if (var17 && var18 && var19) {
                  this.objetEvolution.setVersion(var24);
                  this.objetEvolution.setDate(var25);
                  this.objetEvolution.setType(var26);
                  this.objetEvolution.setModule(var27);
                  this.objetEvolution.setEcran(var28);
                  this.objetEvolution.setObjet(var29);
                  this.objetEvolution.setDetail(var30);
                  this.objetEvolution.setDeveloppeur(var31);
                  this.lesEvolutions.add(this.objetEvolution);
               }
            }

            var5 = false;
         } catch (IOException var34) {
         } catch (JDOMException var35) {
         } catch (KeyManagementException var36) {
         } catch (NoSuchAlgorithmException var37) {
         }
      }

      if (var5) {
         SAXBuilder var38 = new SAXBuilder();

         try {
            Document var39 = var38.build(new File(StaticModePegase.getCheminContext() + File.separator + "evolutions.xml"));
            Element var40 = var39.getRootElement();
            this.lesEvolutions = new ArrayList();
            List var41 = var40.getChildren();
            boolean var42 = false;
            boolean var43 = false;
            boolean var44 = false;
            Date var45 = this.utilDate.stringToDateSQLLight(var1);
            Date var46 = this.utilDate.stringToDateSQLLight(var2);
            Date var47 = null;

            for(int var48 = 0; var48 < var41.size(); ++var48) {
               this.objetEvolution = new ObjetEvolution();
               String var50 = ((Element)var41.get(var48)).getChild("version").getText();
               String var49 = ((Element)var41.get(var48)).getChild("date").getText();
               String var51 = ((Element)var41.get(var48)).getChild("type").getText();
               String var52 = ((Element)var41.get(var48)).getChild("module").getText();
               String var53 = ((Element)var41.get(var48)).getChild("ecran").getText();
               var24 = ((Element)var41.get(var48)).getChild("objet").getText();
               var25 = ((Element)var41.get(var48)).getChild("detail").getText();
               var26 = ((Element)var41.get(var48)).getChild("developpeur").getText();
               var47 = this.utilDate.stringToDateSQLLight(var49);
               var42 = false;
               var43 = false;
               var44 = false;
               if (var3 != null && !var3.isEmpty()) {
                  if (var3.equals(var52)) {
                     var42 = true;
                  }
               } else {
                  var42 = true;
               }

               if (var4 != null && !var4.isEmpty()) {
                  if (var24.contains(var3) || var25.contains(var3) || var50.contains(var3)) {
                     var43 = true;
                  }
               } else {
                  var43 = true;
               }

               if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
                  if (var47.compareTo(var45) >= 0 && var47.compareTo(var46) <= 0) {
                     var44 = true;
                  }
               } else {
                  var44 = true;
               }

               if (var42 && var43 && var44) {
                  this.objetEvolution.setVersion(var50);
                  this.objetEvolution.setDate(var49);
                  this.objetEvolution.setType(var51);
                  this.objetEvolution.setModule(var52);
                  this.objetEvolution.setEcran(var53);
                  this.objetEvolution.setObjet(var24);
                  this.objetEvolution.setDetail(var25);
                  this.objetEvolution.setDeveloppeur(var26);
                  this.lesEvolutions.add(this.objetEvolution);
               }
            }
         } catch (JDOMException var32) {
         } catch (IOException var33) {
         }
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

   public List getLesEvolutions() {
      return this.lesEvolutions;
   }

   public void setLesEvolutions(List var1) {
      this.lesEvolutions = var1;
   }
}
