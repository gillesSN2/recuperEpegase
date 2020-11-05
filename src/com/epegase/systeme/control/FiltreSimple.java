package com.epegase.systeme.control;

import java.io.File;
import java.io.Serializable;
import javax.swing.filechooser.FileFilter;

public class FiltreSimple extends FileFilter implements Serializable {
   private String description;
   private String extension;

   public FiltreSimple(String var1, String var2) {
      if (var1 != null && var2 != null) {
         this.description = var1;
         this.extension = var2;
      } else {
         throw new NullPointerException("La description (ou extension) ne peut être null.");
      }
   }

   public boolean accept(File var1) {
      if (var1.isDirectory()) {
         return true;
      } else {
         String var2 = var1.getName().toLowerCase();
         return var2.endsWith(this.extension);
      }
   }

   public String getDescription() {
      return this.description;
   }
}
