package com.epegase.systeme.control;

import com.epegase.systeme.util.StaticModePegase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet implements Serializable {
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   String maBase;
   private String imagePath;

   public void init() throws ServletException {
      this.imagePath = StaticModePegase.getCheminContext() + File.separator + "clients";
   }

   protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      String var3 = var1.getPathInfo();
      if (var3 == null) {
         var2.sendError(404);
      } else {
         this.imagePath = StaticModePegase.getCheminContext() + File.separator + "clients";
         File var4 = new File(this.imagePath, URLDecoder.decode(var3, "UTF-8"));
         if (!var4.exists()) {
            var2.sendError(404);
         } else {
            String var5 = this.getServletContext().getMimeType(var4.getName());
            if (var5 != null && var5.startsWith("image")) {
               var2.reset();
               var2.setBufferSize(10240);
               var2.setContentType(var5);
               var2.setHeader("Content-Length", String.valueOf(var4.length()));
               var2.setHeader("Content-Disposition", "inline; filename=\"" + var4.getName() + "\"");
               BufferedInputStream var6 = null;
               BufferedOutputStream var7 = null;

               try {
                  var6 = new BufferedInputStream(new FileInputStream(var4), 10240);
                  var7 = new BufferedOutputStream(var2.getOutputStream(), 10240);
                  byte[] var8 = new byte[10240];

                  int var9;
                  while((var9 = var6.read(var8)) > 0) {
                     var7.write(var8, 0, var9);
                  }
               } finally {
                  close(var7);
                  close(var6);
               }

            } else {
               var2.sendError(404);
            }
         }
      }
   }

   private static void close(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   protected void processRequest(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      var2.setContentType("text/html;charset=UTF-8");
      PrintWriter var3 = var2.getWriter();
      var3.close();
   }

   public String getMaBase() {
      return this.maBase;
   }

   public void setMaBase(String var1) {
      this.maBase = var1;
   }

   protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      this.processRequest(var1, var2);
   }

   public String getServletInfo() {
      return "Short description";
   }
}
