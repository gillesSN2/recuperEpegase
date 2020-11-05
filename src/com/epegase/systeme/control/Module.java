package com.epegase.systeme.control;

import com.epegase.systeme.classe.Groupe;
import java.io.Serializable;
import java.util.List;

public class Module implements Serializable {
   private long indice;
   private String libelle;
   private String libelle1FR;
   private String libelle1UK;
   private String libelle1SP;
   private String menu1FR;
   private String menu1UK;
   private String menu1SP;
   private String info1FR;
   private String info1UK;
   private String info1SP;
   private String code1;
   private String type1;
   private String valeur1;
   private String modif1;
   private boolean desactif1;
   private Groupe groupe;
   private List listeLibelle;

   public String getInfo1FR() {
      return this.info1FR;
   }

   public void setInfo1FR(String var1) {
      this.info1FR = var1;
   }

   public String getInfo1SP() {
      return this.info1SP;
   }

   public void setInfo1SP(String var1) {
      this.info1SP = var1;
   }

   public String getInfo1UK() {
      return this.info1UK;
   }

   public void setInfo1UK(String var1) {
      this.info1UK = var1;
   }

   public String getLibelle1FR() {
      return this.libelle1FR;
   }

   public void setLibelle1FR(String var1) {
      this.libelle1FR = var1;
   }

   public String getLibelle1SP() {
      return this.libelle1SP;
   }

   public void setLibelle1SP(String var1) {
      this.libelle1SP = var1;
   }

   public String getLibelle1UK() {
      return this.libelle1UK;
   }

   public void setLibelle1UK(String var1) {
      this.libelle1UK = var1;
   }

   public String getMenu1FR() {
      return this.menu1FR;
   }

   public void setMenu1FR(String var1) {
      this.menu1FR = var1;
   }

   public String getMenu1SP() {
      return this.menu1SP;
   }

   public void setMenu1SP(String var1) {
      this.menu1SP = var1;
   }

   public String getMenu1UK() {
      return this.menu1UK;
   }

   public void setMenu1UK(String var1) {
      this.menu1UK = var1;
   }

   public long getIndice() {
      return this.indice;
   }

   public void setIndice(long var1) {
      this.indice = var1;
   }

   public String getCode1() {
      return this.code1;
   }

   public void setCode1(String var1) {
      this.code1 = var1;
   }

   public boolean isDesactif1() {
      return this.desactif1;
   }

   public void setDesactif1(boolean var1) {
      this.desactif1 = var1;
   }

   public String getModif1() {
      return this.modif1;
   }

   public void setModif1(String var1) {
      this.modif1 = var1;
   }

   public String getType1() {
      return this.type1;
   }

   public void setType1(String var1) {
      this.type1 = var1;
   }

   public String getValeur1() {
      return this.valeur1;
   }

   public void setValeur1(String var1) {
      this.valeur1 = var1;
   }

   public Groupe getGroupe() {
      return this.groupe;
   }

   public void setGroupe(Groupe var1) {
      this.groupe = var1;
   }

   public List getListeLibelle() {
      return this.listeLibelle;
   }

   public void setListeLibelle(List var1) {
      this.listeLibelle = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }
}
