package com.epegase.systeme.xml;



import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.xml.ObjetEvolution;
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
import java.text.ParseException;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.SAXException;

public class LectureInformations implements Serializable {
  private ObjetEvolution objetInformationsHaut;
  
  public ObjetEvolution recupereInformations() throws UnknownHostException, ParserConfigurationException, SAXException, JDOMException, IOException, NoSuchAlgorithmException, KeyManagementException, ParseException {
    boolean bool1 = true;
    InetAddress inetAddress = InetAddress.getLocalHost();
    String str = inetAddress.getHostAddress();
    boolean bool2 = false;
    if ((netIsAvailable() == true || str.equals(StaticModePegase.getIpServeur()) == true) && (str.startsWith("192.") || str.startsWith("127.") || str.startsWith("10.") || str.equals(StaticModePegase.getIpServeur()) == true))
      try {
        TrustManager[] arrayOfTrustManager = { (TrustManager)new Object() };
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        sSLContext.init(null, arrayOfTrustManager, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        Object object = new Object();
        HttpsURLConnection.setDefaultHostnameVerifier((HostnameVerifier)object);
        SAXBuilder sAXBuilder = new SAXBuilder();
        String str1 = "https://" + StaticModePegase.getIpServeur() + ":" + "443" + File.separator + "epegase" + File.separator + "clients" + File.separator + "informations.xml";
        URL uRL = new URL(str1);
        Document document = sAXBuilder.build(uRL.openStream());
        Element element = document.getRootElement();
        List<Element> list = element.getChildren();
        for (byte b = 0; b < list.size(); b++) {
          this.objetInformationsHaut = new ObjetEvolution();
          String str2 = ((Element)list.get(b)).getChild("date").getText();
          String str3 = ((Element)list.get(b)).getChild("texte").getText();
          String str4 = ((Element)list.get(b)).getChild("image").getText();
          String str5 = ((Element)list.get(b)).getChild("position").getText();
          String str6 = ((Element)list.get(b)).getChild("actif").getText();
          this.objetInformationsHaut.setDate(str2);
          this.objetInformationsHaut.setObjet(str3);
          this.objetInformationsHaut.setEcran(str4);
          this.objetInformationsHaut.setModule(str5);
          this.objetInformationsHaut.setType(str6);
          if (this.objetInformationsHaut.getType() != null && !this.objetInformationsHaut.getType().isEmpty() && this.objetInformationsHaut.getType().equals("0"))
            this.objetInformationsHaut = new ObjetEvolution(); 
        } 
        bool1 = false;
        bool2 = true;
      } catch (IOException iOException) {
      
      } catch (JDOMException jDOMException) {
      
      } catch (KeyManagementException keyManagementException) {
      
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {} 
    if (bool1 == true || !bool2) {
      SAXBuilder sAXBuilder = new SAXBuilder();
      try {
        File file = new File(StaticModePegase.getCheminContext() + File.separator + "informations.xml");
        if (file.exists() == true) {
          FileReader fileReader = new FileReader(file);
          Document document = sAXBuilder.build(fileReader);
          Element element = document.getRootElement();
          List<Element> list = element.getChildren();
          for (byte b = 0; b < list.size(); b++) {
            this.objetInformationsHaut = new ObjetEvolution();
            String str1 = ((Element)list.get(b)).getChild("date").getText();
            String str2 = ((Element)list.get(b)).getChild("texte").getText();
            String str3 = ((Element)list.get(b)).getChild("image").getText();
            String str4 = ((Element)list.get(b)).getChild("position").getText();
            String str5 = ((Element)list.get(b)).getChild("actif").getText();
            this.objetInformationsHaut.setDate(str1);
            this.objetInformationsHaut.setObjet(str2);
            this.objetInformationsHaut.setEcran(str3);
            this.objetInformationsHaut.setModule(str4);
            this.objetInformationsHaut.setType(str5);
            if (this.objetInformationsHaut.getType() != null && !this.objetInformationsHaut.getType().isEmpty() && this.objetInformationsHaut.getType().equals("0"))
              this.objetInformationsHaut = new ObjetEvolution(); 
          } 
          fileReader.close();
        } 
      } catch (JDOMException jDOMException) {
      
      } catch (IOException iOException) {}
    } 
    return this.objetInformationsHaut;
  }
  
  private boolean netIsAvailable() {
    try {
      URL uRL = new URL("http://www.google.com");
      URLConnection uRLConnection = uRL.openConnection();
      uRLConnection.connect();
      return true;
    } catch (MalformedURLException malformedURLException) {
      throw new RuntimeException(malformedURLException);
    } catch (IOException iOException) {
      return false;
    } 
  }
}

