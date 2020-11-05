package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class UsersFavoris implements Serializable {
   private long usrfavId;
   private Date usrfavDateCreat;
   private Date usrfavDateModif;
   private long usrfavUserCreat;
   private long usrfavUserModif;
   private String usrfavNom;
   private String usrfavUrl;
   private Integer usrfavInactif;
   private Integer usrfavNature;
   private String usrfavLogin;
   private String usrfavPw;
   private String usrfavMail;
   private long usrfavStructurePeg;
   private long usrfavIdUser;
   private String usrfavCiviliteUser;
   private String usrfavNomUser;
   private String usrfavPrenomUser;
   private String usrfavFonctionUser;
   private Users users;
   private boolean afficheImag;
   private String etat;
   private String accesSite;

   public String getEtat() {
      if (this.usrfavInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else {
         this.etat = "";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.usrfavInactif == 1) {
         this.afficheImag = true;
      } else {
         this.afficheImag = false;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getAccesSite() {
      if (this.usrfavLogin == null || this.usrfavLogin.isEmpty() || !this.usrfavUrl.contains("http://") && !this.usrfavUrl.contains("ftp://")) {
         this.accesSite = this.usrfavUrl;
      } else {
         String[] var1 = this.usrfavUrl.split("//");
         this.accesSite = var1[0] + "//" + this.usrfavLogin + ":" + this.usrfavPw + "@" + var1[1];
      }

      if (!this.accesSite.startsWith("http://") || !this.accesSite.startsWith("https://") || this.accesSite.startsWith("ftp://") || this.accesSite.startsWith("ftps://")) {
         this.accesSite = "http://" + this.accesSite;
      }

      return this.accesSite;
   }

   public void setAccesSite(String var1) {
      this.accesSite = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public Date getUsrfavDateCreat() {
      return this.usrfavDateCreat;
   }

   public void setUsrfavDateCreat(Date var1) {
      this.usrfavDateCreat = var1;
   }

   public Date getUsrfavDateModif() {
      return this.usrfavDateModif;
   }

   public void setUsrfavDateModif(Date var1) {
      this.usrfavDateModif = var1;
   }

   public long getUsrfavId() {
      return this.usrfavId;
   }

   public void setUsrfavId(long var1) {
      this.usrfavId = var1;
   }

   public Integer getUsrfavInactif() {
      return this.usrfavInactif;
   }

   public void setUsrfavInactif(Integer var1) {
      this.usrfavInactif = var1;
   }

   public String getUsrfavLogin() {
      return this.usrfavLogin;
   }

   public void setUsrfavLogin(String var1) {
      this.usrfavLogin = var1;
   }

   public Integer getUsrfavNature() {
      return this.usrfavNature;
   }

   public void setUsrfavNature(Integer var1) {
      this.usrfavNature = var1;
   }

   public String getUsrfavNom() {
      return this.usrfavNom;
   }

   public void setUsrfavNom(String var1) {
      this.usrfavNom = var1;
   }

   public String getUsrfavPw() {
      return this.usrfavPw;
   }

   public void setUsrfavPw(String var1) {
      this.usrfavPw = var1;
   }

   public String getUsrfavUrl() {
      return this.usrfavUrl;
   }

   public void setUsrfavUrl(String var1) {
      this.usrfavUrl = var1;
   }

   public long getUsrfavUserCreat() {
      return this.usrfavUserCreat;
   }

   public void setUsrfavUserCreat(long var1) {
      this.usrfavUserCreat = var1;
   }

   public long getUsrfavUserModif() {
      return this.usrfavUserModif;
   }

   public void setUsrfavUserModif(long var1) {
      this.usrfavUserModif = var1;
   }

   public long getUsrfavStructurePeg() {
      return this.usrfavStructurePeg;
   }

   public void setUsrfavStructurePeg(long var1) {
      this.usrfavStructurePeg = var1;
   }

   public String getUsrfavCiviliteUser() {
      return this.usrfavCiviliteUser;
   }

   public void setUsrfavCiviliteUser(String var1) {
      this.usrfavCiviliteUser = var1;
   }

   public String getUsrfavFonctionUser() {
      return this.usrfavFonctionUser;
   }

   public void setUsrfavFonctionUser(String var1) {
      this.usrfavFonctionUser = var1;
   }

   public String getUsrfavNomUser() {
      return this.usrfavNomUser;
   }

   public void setUsrfavNomUser(String var1) {
      this.usrfavNomUser = var1;
   }

   public String getUsrfavPrenomUser() {
      return this.usrfavPrenomUser;
   }

   public void setUsrfavPrenomUser(String var1) {
      this.usrfavPrenomUser = var1;
   }

   public long getUsrfavIdUser() {
      return this.usrfavIdUser;
   }

   public void setUsrfavIdUser(long var1) {
      this.usrfavIdUser = var1;
   }

   public String getUsrfavMail() {
      return this.usrfavMail;
   }

   public void setUsrfavMail(String var1) {
      this.usrfavMail = var1;
   }
}
