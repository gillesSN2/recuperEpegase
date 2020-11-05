package com.epegase.systeme.util;

import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilDownload implements Serializable {
   public void downloadFile(String var1, String var2) throws MalformedURLException, IOException {
      URL var3 = this.convertirFichierUtl(var1, "");
      BufferedReader var4 = null;
      FileOutputStream var5 = null;
      InputStream var6 = null;

      try {
         URLConnection var7 = var3.openConnection();
         int var8 = var7.getContentLength();
         if (var8 == -1) {
            throw new IOException("Fichier non valide.");
         }

         var6 = var7.getInputStream();
         var4 = new BufferedReader(new InputStreamReader(var6));
         JFileChooser var9 = new JFileChooser(new File("mes doc"));
         var9.setSelectedFile(new File(var2));
         var9.setVisible(true);
         var9.setDialogTitle("Télécharger le fichier sélectionné");
         var9.setDragEnabled(false);
         if (var9.showSaveDialog((Component)null) == 0) {
            String var10 = var9.getCurrentDirectory().toString() + File.separator + var2;
            if (var9.getCurrentDirectory() != null) {
               var5 = new FileOutputStream(var10);
               byte[] var11 = new byte[1024];

               for(int var12 = var6.read(var11); var12 > 0; var12 = var6.read(var11)) {
                  var5.write(var11, 0, var12);
               }
            }
         }
      } catch (Exception var25) {
         var25.printStackTrace();
      } finally {
         try {
            if (var5 != null) {
               var5.flush();
               var5.close();
            }
         } catch (IOException var24) {
            var24.printStackTrace();
         }

         try {
            var4.close();
         } catch (Exception var23) {
            var23.printStackTrace();
         }

      }

   }

   public void downloadFile(String var1, String var2, String var3) throws MalformedURLException, IOException {
      URL var4 = this.convertirFichierUtl(var1, "https://e-pegase.biz/");
      FileOutputStream var5 = null;

      try {
         URLConnection var6 = var4.openConnection();
         int var7 = var6.getContentLength();
         if (var7 == -1) {
            throw new IOException("Fichier non valide.");
         }

         InputStream var8 = var6.getInputStream();
         var5 = new FileOutputStream(var3);
         byte[] var9 = new byte[1024];

         for(int var10 = var8.read(var9); var10 > 0; var10 = var8.read(var9)) {
            var5.write(var9, 0, var10);
         }
      } catch (Exception var14) {
         var14.printStackTrace();
      } finally {
         if (var5 != null) {
            var5.flush();
            var5.close();
         }

      }

   }

   public URL convertirFichierUtl(String var1, String var2) throws MalformedURLException, IOException {
      URL var3 = null;
      if (var2 == null || var2.isEmpty()) {
         var2 = StaticModePegase.getUrlIp() + File.separator;
      }

      if (!var1.contains("null")) {
         if (!var1.startsWith("http")) {
            var1 = var2 + var1;
         } else if (var2 != null && !var2.isEmpty() && var2.equals("epegase/maj/epegase.war")) {
            var1 = var1 + File.separator + var2;
         }

         var3 = new URL(var1);
      }

      return var3;
   }

   public String codeAdresse(URL var1) throws MalformedURLException {
      String var2 = var1.toString();
      String var3 = "";

      for(int var4 = 0; var4 < var2.length(); ++var4) {
         String var5 = var2.substring(var4, var4 + 1);
         if (var5.equals(":")) {
            var3 = var3 + "%3A";
         } else if (var5.equals("/")) {
            var3 = var3 + "%2F";
         } else {
            var3 = var3 + var2.substring(var4, var4 + 1);
         }
      }

      return var3;
   }

   public String calculeTypeMine(String var1) {
      String var2 = "";
      var1 = var1.toLowerCase();
      if (var1.contains(".pdf")) {
         var2 = "application/pdf";
      } else if (var1.contains(".rtf")) {
         var2 = "application/rtf";
      } else if (var1.contains(".html")) {
         var2 = "application/html";
      } else if (var1.contains(".doc")) {
         var2 = "application/doc";
      } else if (var1.contains(".docx")) {
         var2 = "application/msword";
      } else if (var1.contains(".odt")) {
         var2 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
      } else if (!var1.contains(".xls") && !var1.contains(".xlsx")) {
         if (var1.contains(".ods")) {
            var2 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
         } else if (!var1.contains(".ppt") && !var1.contains(".pptx")) {
            if (var1.contains(".odp")) {
               var2 = "application/powerpoint";
            } else if (!var1.contains(".txt") && !var1.contains(".sql") && !var1.contains(".log")) {
               if (!var1.contains(".zip") && !var1.contains(".rar")) {
                  if (!var1.contains(".mp3") && !var1.contains(".mp4")) {
                     if (var1.contains(".lnk")) {
                        var2 = "application/html";
                     } else {
                        var2 = "application/octet-stream";
                     }
                  } else {
                     var2 = "application/octet-stream";
                  }
               } else {
                  var2 = "application/octet-stream";
               }
            } else {
               var2 = "text/plain";
            }
         } else {
            var2 = "application/vnd.ms-powerpoint";
         }
      } else {
         var2 = "application/vnd.ms-excel";
      }

      return var2;
   }

   public String trimFilePath(String var1) {
      return var1.substring(var1.lastIndexOf("/") + 1).substring(var1.lastIndexOf("\\") + 1);
   }

   public File uniqueFile(File var1, String var2) throws IOException {
      File var3 = new File(var1, var2);
      if (var3.exists()) {
         int var6 = var2.lastIndexOf(".");
         String var4;
         String var5;
         if (var6 > -1) {
            var4 = var2.substring(0, var6) + "[";
            var5 = "]" + var2.substring(var6);
         } else {
            var4 = var2 + "[";
            var5 = "]";
         }

         for(int var7 = 0; var3.exists(); var3 = new File(var1, var4 + var7++ + var5)) {
            if (var7 < 0) {
               throw new IOException("No unique filename available for " + var2 + " in path " + var1.getPath() + ".");
            }
         }
      }

      return var3;
   }

   public void write(File var1, InputStream var2) throws IOException {
      this.write(var1, var2, false);
   }

   public void write(File var1, InputStream var2, boolean var3) throws IOException {
      this.mkdirs(var1);
      BufferedOutputStream var4 = null;

      try {
         var4 = new BufferedOutputStream(new FileOutputStream(var1, var3));
         boolean var5 = true;

         int var9;
         while((var9 = var2.read()) != -1) {
            var4.write(var9);
         }
      } finally {
         close(var2, var1);
         close(var4, var1);
      }

   }

   public void write(File var1, String var2, boolean var3) throws IOException {
      this.write(var1, (Reader)(new CharArrayReader(var2.toCharArray())), var3);
   }

   public void write(File var1, String var2) throws IOException {
      this.write(var1, (Reader)(new CharArrayReader(var2.toCharArray())), false);
   }

   public void write(File var1, Reader var2, boolean var3) throws IOException {
      this.mkdirs(var1);
      BufferedWriter var4 = null;

      try {
         var4 = new BufferedWriter(new FileWriter(var1, var3));
         boolean var5 = true;

         int var9;
         while((var9 = var2.read()) != -1) {
            var4.write(var9);
         }
      } finally {
         close(var2, var1);
         close(var4, var1);
      }

   }

   public void write(File var1, char[] var2, boolean var3) throws IOException {
      this.write(var1, (Reader)(new CharArrayReader(var2)), var3);
   }

   public void write(File var1, char[] var2) throws IOException {
      this.write(var1, (Reader)(new CharArrayReader(var2)), false);
   }

   public void write(File var1, byte[] var2, boolean var3) throws IOException {
      this.write(var1, (InputStream)(new ByteArrayInputStream(var2)), var3);
   }

   public void write(File var1, byte[] var2) throws IOException {
      this.write(var1, (InputStream)(new ByteArrayInputStream(var2)), false);
   }

   public void write(File var1, Reader var2) throws IOException {
      this.write(var1, var2, false);
   }

   public void write(File var1, List var2, boolean var3) throws IOException {
      this.mkdirs(var1);
      BufferedWriter var4 = null;
      String var5 = System.getProperty("line.separator");

      try {
         var4 = new BufferedWriter(new FileWriter(var1, var3));
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            var4.write(var7);
            var4.write(var5);
         }
      } finally {
         close(var4, var1);
      }

   }

   private void mkdirs(File var1) throws IOException {
      if (var1.exists() && !var1.isFile()) {
         throw new IOException("File " + var1.getPath() + " is actually not a file.");
      } else {
         File var2 = var1.getParentFile();
         if (!var2.exists() && !var2.mkdirs()) {
            throw new IOException("Creating directories " + var2.getPath() + " failed.");
         }
      }
   }

   private static void close(Closeable var0, File var1) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var4) {
            String var3 = "Closing file " + var1.getPath() + " failed.";
            System.err.println(var3);
            var4.printStackTrace();
         }
      }

   }

   public void move(File var1, File var2) throws IOException {
      this.move(var1, var2, true);
   }

   public void move(File var1, File var2, boolean var3) throws IOException {
      if (var2.exists()) {
         if (!var3) {
            throw new IOException("Moving file " + var1.getPath() + " to " + var2.getPath() + " failed." + " The destination file already exists.");
         }

         var2.delete();
      }

      this.mkdirs(var2);
      if (!var1.renameTo(var2)) {
         throw new IOException("Moving file " + var1.getPath() + " to " + var2.getPath() + " failed.");
      }
   }

   public void copy(File var1, File var2) throws IOException {
      this.copy(var1, var2, true);
   }

   public void copy(File var1, File var2, boolean var3) throws IOException {
      if (!var1.exists()) {
         throw new IOException("Error file " + var1.getPath() + " doesn't exist...");
      } else if (var2.exists() && !var3) {
         throw new IOException("Copying file " + var1.getPath() + " to " + var2.getPath() + " failed." + " The destination file already exists...");
      } else {
         this.mkdirs(var2);
         BufferedInputStream var4 = null;
         BufferedOutputStream var5 = null;

         try {
            var4 = new BufferedInputStream(new FileInputStream(var1));
            var5 = new BufferedOutputStream(new FileOutputStream(var2));
            boolean var6 = true;

            int var10;
            while((var10 = var4.read()) != -1) {
               var5.write(var10);
            }
         } finally {
            close(var4, var1);
            close(var5, var2);
         }

      }
   }

   public List readRecords(File var1) throws IOException {
      BufferedReader var2 = (BufferedReader)this.readReader(var1);
      ArrayList var3 = new ArrayList();
      String var4 = null;

      try {
         while((var4 = var2.readLine()) != null) {
            var3.add(var4);
         }
      } finally {
         close(var2, var1);
      }

      return var3;
   }

   public Reader readReader(File var1) throws IOException {
      return new BufferedReader(new FileReader(var1));
   }

   public char[] readChars(File var1) throws IOException {
      BufferedReader var2 = (BufferedReader)this.readReader(var1);
      char[] var3 = new char[(int)var1.length()];
      var2.read(var3);
      return var3;
   }

   public InputStream readStream(File var1) throws IOException {
      return new BufferedInputStream(new FileInputStream(var1));
   }

   public byte[] readBytes(File var1) throws IOException {
      BufferedInputStream var2 = (BufferedInputStream)this.readStream(var1);
      byte[] var3 = new byte[var2.available()];
      var2.read(var3);
      return var3;
   }

   public String readString(File var1) throws IOException {
      return new String(this.readChars(var1));
   }
}
