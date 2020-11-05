package com.epegase.systeme.control;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletOutputStream;

public class GZipServletOutputStream extends ServletOutputStream {
   private GZIPOutputStream gzipOutputStream = null;

   public GZipServletOutputStream(OutputStream var1) throws IOException {
      this.gzipOutputStream = new GZIPOutputStream(var1);
   }

   public void close() throws IOException {
      this.gzipOutputStream.close();
   }

   public void flush() throws IOException {
      this.gzipOutputStream.flush();
   }

   public void write(byte[] var1) throws IOException {
      this.gzipOutputStream.write(var1);
   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      this.gzipOutputStream.write(var1, var2, var3);
   }

   public void write(int var1) throws IOException {
      this.gzipOutputStream.write(var1);
   }
}
