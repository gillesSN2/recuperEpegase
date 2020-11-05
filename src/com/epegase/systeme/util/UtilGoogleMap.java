package com.epegase.systeme.util;

import com.epegase.systeme.classe.AmortissementInv;
import com.epegase.systeme.classe.EcrituresNotes;
import com.epegase.systeme.classe.ForetGrume;
import com.epegase.systeme.classe.LocalisationGps;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.Structure;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilGoogleMap implements Serializable {
   private Structure structureLog;
   private String scheme = "https";
   private String authority = "www.google.com";
   private String path = "/maps/embed/v1/place";
   private String key = "key=AIzaSyBSQDBdEONFM9CSG-WFDFnStBB-FK6Bk9Q";
   private String authorityRoute = "roads.googleapis.com";
   private String pathRoute = "/v1/snapToRoads";
   private String keyRoute = "key=AIzaSyCWflSqfqJuaJcx4Tfzl7LWNHRYHdXQtYc";
   private URI uri;
   private String tokenMapbox = "pk.eyJ1IjoiZ2lsbGVzc24iLCJhIjoiY2lxMmNncmVqMDA0NWhzbTIwaXFrcW92MyJ9.flznRKAgLvuxrX2SpmMKkQ";

   public UtilGoogleMap(Structure var1) {
      this.structureLog = var1;
   }

   public URI calculMap(String var1, String var2, String var3, String var4) throws URISyntaxException {
      if (var4 == null || var4.isEmpty()) {
         var4 = this.structureLog.getStrnompays();
      }

      var4 = var4.toLowerCase();
      if (var3 == null || var3.isEmpty()) {
         var3 = this.structureLog.getStrville();
      }

      var3 = var3.toLowerCase();
      String var5 = "";
      var1 = this.filtre(var1);
      var2 = this.filtre(var2);
      String var6 = "";
      if (var1 != null && !var1.isEmpty()) {
         var6 = var1.toLowerCase();
      }

      if (var2 != null && !var2.isEmpty()) {
         var6 = var6 + " " + var2.toLowerCase();
      }

      if (var6 != null && !var6.isEmpty()) {
         var5 = var6 + "," + var3 + "+" + var4;
      } else {
         var5 = var3 + "+" + var4;
      }

      String var7 = this.key + "&q=" + var5;
      this.uri = new URI(this.scheme, this.authority, this.path, var7, "123");
      return this.uri;
   }

   public URI calculRouteGoogleMap(List var1) throws URISyntaxException {
      if (var1.size() != 0) {
         String var2 = "";

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            if (var2 != null && !var2.isEmpty()) {
               var2 = var2 + "|" + ((LocalisationGps)var1.get(var3)).getLocgpsLatitude() + "," + ((LocalisationGps)var1.get(var3)).getLocgpsLongitude();
            } else {
               var2 = ((LocalisationGps)var1.get(var3)).getLocgpsLatitude() + "," + ((LocalisationGps)var1.get(var3)).getLocgpsLongitude();
            }

            if (var3 >= 99) {
               break;
            }
         }

         var2 = "path=" + var2;
         String var4 = var2 + "&interpolate=false&" + this.keyRoute;
         this.uri = new URI(this.scheme, this.authorityRoute, this.pathRoute, var4, (String)null);
      } else {
         this.uri = new URI(this.scheme, this.authorityRoute, this.pathRoute, (String)null, (String)null);
      }

      return this.uri;
   }

   public String calculRouteMapBox(List var1) throws URISyntaxException {
      String var2 = "";
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            if (((LocalisationGps)var1.get(var3)).getLocgpsLatitude() != 0.0F && ((LocalisationGps)var1.get(var3)).getLocgpsLongitude() != 0.0F) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + ",\n[" + ((LocalisationGps)var1.get(var3)).getLocgpsLatitude() + "," + ((LocalisationGps)var1.get(var3)).getLocgpsLongitude() + "]";
               } else {
                  var2 = "[" + ((LocalisationGps)var1.get(var3)).getLocgpsLatitude() + "," + ((LocalisationGps)var1.get(var3)).getLocgpsLongitude() + "]";
               }
            }
         }
      }

      return var2;
   }

   public String calculPointMapBox(List var1) throws URISyntaxException {
      String var2 = "";
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            if (((Rdv)var1.get(var3)).getRdvX() != 0.0D && ((Rdv)var1.get(var3)).getRdvY() != 0.0D) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + ",\n[" + ((Rdv)var1.get(var3)).getRdvX() + "," + ((Rdv)var1.get(var3)).getRdvY() + "]";
               } else {
                  var2 = "[" + ((Rdv)var1.get(var3)).getRdvX() + "," + ((Rdv)var1.get(var3)).getRdvY() + "]";
               }
            }
         }
      }

      return var2;
   }

   public String calculForetMapBox(List var1) throws URISyntaxException {
      String var2 = "";
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            if (((ForetGrume)var1.get(var3)).getGruLocX() != 0.0D && ((ForetGrume)var1.get(var3)).getGruLocY() != 0.0D) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + ",\n[" + ((ForetGrume)var1.get(var3)).getGruLocX() + "," + ((ForetGrume)var1.get(var3)).getGruLocY() + "]";
               } else {
                  var2 = "[" + ((ForetGrume)var1.get(var3)).getGruLocX() + "," + ((ForetGrume)var1.get(var3)).getGruLocY() + "]";
               }
            }
         }
      }

      return var2;
   }

   public String calculPointMapBoxRdv(Rdv var1) throws URISyntaxException {
      String var2 = "";
      if (var1 != null && var1.getRdvX() != 0.0D && var1.getRdvY() != 0.0D) {
         if (var2 != null && !var2.isEmpty()) {
            var2 = var2 + ",\n[" + var1.getRdvX() + "," + var1.getRdvY() + "]";
         } else {
            var2 = "[" + var1.getRdvX() + "," + var1.getRdvY() + "]";
         }
      }

      return var2;
   }

   public String calculPointMapBoxNote(EcrituresNotes var1) throws URISyntaxException {
      String var2 = "";
      if (var1 != null && var1.getEcrnotLongitude() != 0.0D && var1.getEcrnotLatitude() != 0.0D) {
         if (var2 != null && !var2.isEmpty()) {
            var2 = var2 + ",\n[" + var1.getEcrnotLongitude() + "," + var1.getEcrnotLatitude() + "]";
         } else {
            var2 = "[" + var1.getEcrnotLongitude() + "," + var1.getEcrnotLatitude() + "]";
         }
      }

      return var2;
   }

   public String calculPointMapBoxImmo(AmortissementInv var1) throws URISyntaxException {
      String var2 = "";
      if (var1 != null && var1.getAmoinvLongitude() != 0.0D && var1.getAmoinvLatitude() != 0.0D) {
         if (var2 != null && !var2.isEmpty()) {
            var2 = var2 + ",\n[" + var1.getAmoinvLongitude() + "," + var1.getAmoinvLatitude() + "]";
         } else {
            var2 = "[" + var1.getAmoinvLongitude() + "," + var1.getAmoinvLatitude() + "]";
         }
      }

      return var2;
   }

   public String filtre(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         var2 = var1;
         if (var1.contains(",")) {
            var2 = var1.replace(",", "");
         }

         if (var1.contains("é")) {
            var2 = var1.replace("é", "e");
         }

         if (var1.contains("è")) {
            var2 = var1.replace("è", "e");
         }

         if (var1.contains("ê")) {
            var2 = var1.replace("ê", "e");
         }

         if (var1.contains("ë")) {
            var2 = var1.replace("ë", "e");
         }

         if (var1.contains("ç")) {
            var2 = var1.replace("ç", "c");
         }

         if (var1.contains("à")) {
            var2 = var1.replace("à", "a");
         }

         if (var1.contains("°")) {
            var2 = var1.replace("°", " ");
         }

         if (var1.contains("/")) {
            var2 = var1.replace("/", " ");
         }
      }

      return var2;
   }
}
