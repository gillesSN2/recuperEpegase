package com.epegase.systeme.control;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipServletResponseWrapper extends HttpServletResponseWrapper {
   private GZipServletOutputStream gzipOutputStream = null;
   private PrintWriter printWriter = null;

   public GZipServletResponseWrapper(HttpServletResponse var1) throws IOException {
      super(var1);
   }

   public void close() throws IOException {
      if (this.printWriter != null) {
         this.printWriter.close();
      }

      if (this.gzipOutputStream != null) {
         this.gzipOutputStream.close();
      }

   }

   public void flushBuffer() throws IOException {
      if (this.printWriter != null) {
         this.printWriter.flush();
      }

      IOException var1 = null;

      try {
         if (this.gzipOutputStream != null) {
            this.gzipOutputStream.flush();
         }
      } catch (IOException var5) {
         var1 = var5;
      }

      IOException var2 = null;

      try {
         super.flushBuffer();
      } catch (IOException var4) {
         var2 = var4;
      }

      if (var1 != null) {
         throw var1;
      } else if (var2 != null) {
         throw var2;
      }
   }

   public ServletOutputStream getOutputStream() throws IOException {
      if (this.printWriter != null) {
         throw new IllegalStateException("PrintWriter obtained already - cannot get OutputStream");
      } else {
         if (this.gzipOutputStream == null) {
            this.gzipOutputStream = new GZipServletOutputStream(this.getResponse().getOutputStream());
         }

         return this.gzipOutputStream;
      }
   }

   public PrintWriter getWriter() throws IOException {
      if (this.printWriter == null && this.gzipOutputStream != null) {
         throw new IllegalStateException("OutputStream obtained already - cannot get PrintWriter");
      } else {
         if (this.printWriter == null) {
            this.gzipOutputStream = new GZipServletOutputStream(this.getResponse().getOutputStream());
            this.printWriter = new PrintWriter(new OutputStreamWriter(this.gzipOutputStream, this.getResponse().getCharacterEncoding()));
         }

         return this.printWriter;
      }
   }

   public void setContentLength(int var1) {
   }
}
