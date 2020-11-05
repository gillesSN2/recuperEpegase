package com.epegase.systeme.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjetModuleNiveauFirst implements Serializable {
   private int indice;
   private String libelle1_FR;
   private String libelle1_UK;
   private String libelle1_SP;
   private String menu1_FR;
   private String menu1_UK;
   private String menu1_SP;
   private String info1_FR;
   private String info1_UK;
   private String info1_SP;
   private String code1;
   private String type1;
   private String valeur1;
   private String modif1;
   private String desactif1;
   private List niveauSecond = new ArrayList();

   public String getCode1() {
      return this.code1;
   }

   public void setCode1(String var1) {
      this.code1 = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getDesactif1() {
      return this.desactif1;
   }

   public void setDesactif1(String var1) {
      this.desactif1 = var1;
   }

   public String getInfo1_FR() {
      return this.info1_FR;
   }

   public void setInfo1_FR(String var1) {
      this.info1_FR = var1;
   }

   public String getInfo1_SP() {
      return this.info1_SP;
   }

   public void setInfo1_SP(String var1) {
      this.info1_SP = var1;
   }

   public String getInfo1_UK() {
      return this.info1_UK;
   }

   public void setInfo1_UK(String var1) {
      this.info1_UK = var1;
   }

   public String getLibelle1_FR() {
      return this.libelle1_FR;
   }

   public void setLibelle1_FR(String var1) {
      this.libelle1_FR = var1;
   }

   public String getLibelle1_SP() {
      return this.libelle1_SP;
   }

   public void setLibelle1_SP(String var1) {
      this.libelle1_SP = var1;
   }

   public String getLibelle1_UK() {
      return this.libelle1_UK;
   }

   public void setLibelle1_UK(String var1) {
      this.libelle1_UK = var1;
   }

   public String getMenu1_FR() {
      return this.menu1_FR;
   }

   public void setMenu1_FR(String var1) {
      this.menu1_FR = var1;
   }

   public String getMenu1_SP() {
      return this.menu1_SP;
   }

   public void setMenu1_SP(String var1) {
      this.menu1_SP = var1;
   }

   public String getMenu1_UK() {
      return this.menu1_UK;
   }

   public void setMenu1_UK(String var1) {
      this.menu1_UK = var1;
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

   public List getNiveauSecond() {
      return this.niveauSecond;
   }

   public void setNiveauSecond(List var1) {
      this.niveauSecond = var1;
   }
}
