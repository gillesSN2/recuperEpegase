package com.epegase.systeme.fileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class FileRep {
   public static void copy(InputStream var0, OutputStream var1, int var2) throws IOException {
      byte[] var3 = new byte[var2];

      int var4;
      while((var4 = var0.read(var3)) != -1) {
         var1.write(var3, 0, var4);
      }

   }

   public static void copyDirectory(File var0, File var1) throws IOException {
      if (!var1.exists()) {
         var1.mkdir();
      }

      File[] var2 = var0.listFiles();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         File var4 = var2[var3];
         copy(var4, new File(var1, var4.getName()));
      }

   }

   public static void copyFile(File var0, File var1) throws IOException {
      FileInputStream var2 = new FileInputStream(var0);
      FileOutputStream var3 = new FileOutputStream(var1);
      copy(var2, var3, (int)Math.min(var0.length(), 4096L));
      var2.close();
      var3.close();
   }

   public static void copy(File var0, File var1) throws IOException {
      if (var0.isFile()) {
         copyFile(var0, var1);
      } else {
         if (!var0.isDirectory()) {
            throw new FileNotFoundException(var0.toString() + " does not exist");
         }

         copyDirectory(var0, var1);
      }

   }
}
