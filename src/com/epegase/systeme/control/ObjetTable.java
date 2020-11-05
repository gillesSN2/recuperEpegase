package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.List;

public class ObjetTable implements Serializable {
   private int indice;
   private int nature;
   private String column_name;
   private String column_comment;
   private String column_type;
   private String column_numeric;
   private String column_nbCar;
   private List listEcrituresAnalytiqueCtrl;
   private String column_code;
   private int column_qte;
   private double column_pr;
   private double column_pv;
   private long column_id;
   private boolean column_select;
   private int exo_douane;
   private int exo_tva;
   private float coef_prp;

   public String getColumn_comment() {
      return this.column_comment;
   }

   public void setColumn_comment(String var1) {
      this.column_comment = var1;
   }

   public String getColumn_name() {
      return this.column_name;
   }

   public void setColumn_name(String var1) {
      this.column_name = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public List getListEcrituresAnalytiqueCtrl() {
      return this.listEcrituresAnalytiqueCtrl;
   }

   public void setListEcrituresAnalytiqueCtrl(List var1) {
      this.listEcrituresAnalytiqueCtrl = var1;
   }

   public String getColumn_type() {
      return this.column_type;
   }

   public void setColumn_type(String var1) {
      this.column_type = var1;
   }

   public String getColumn_numeric() {
      return this.column_numeric;
   }

   public void setColumn_numeric(String var1) {
      this.column_numeric = var1;
   }

   public String getColumn_nbCar() {
      return this.column_nbCar;
   }

   public void setColumn_nbCar(String var1) {
      this.column_nbCar = var1;
   }

   public double getColumn_pr() {
      return this.column_pr;
   }

   public void setColumn_pr(double var1) {
      this.column_pr = var1;
   }

   public int getColumn_qte() {
      return this.column_qte;
   }

   public void setColumn_qte(int var1) {
      this.column_qte = var1;
   }

   public boolean isColumn_select() {
      return this.column_select;
   }

   public void setColumn_select(boolean var1) {
      this.column_select = var1;
   }

   public String getColumn_code() {
      return this.column_code;
   }

   public void setColumn_code(String var1) {
      this.column_code = var1;
   }

   public double getColumn_pv() {
      return this.column_pv;
   }

   public void setColumn_pv(double var1) {
      this.column_pv = var1;
   }

   public long getColumn_id() {
      return this.column_id;
   }

   public void setColumn_id(long var1) {
      this.column_id = var1;
   }

   public float getCoef_prp() {
      return this.coef_prp;
   }

   public void setCoef_prp(float var1) {
      this.coef_prp = var1;
   }

   public int getExo_douane() {
      return this.exo_douane;
   }

   public void setExo_douane(int var1) {
      this.exo_douane = var1;
   }

   public int getExo_tva() {
      return this.exo_tva;
   }

   public void setExo_tva(int var1) {
      this.exo_tva = var1;
   }
}
