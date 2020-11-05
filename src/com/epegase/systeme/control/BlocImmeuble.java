package com.epegase.systeme.control;

import java.io.Serializable;

public class BlocImmeuble implements Serializable {
   private long indice;
   private String code;
   private int millieme;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public long getIndice() {
      return this.indice;
   }

   public void setIndice(long var1) {
      this.indice = var1;
   }

   public int getMillieme() {
      return this.millieme;
   }

   public void setMillieme(int var1) {
      this.millieme = var1;
   }
}
