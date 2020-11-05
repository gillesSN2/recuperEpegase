package com.epegase.systeme.control;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class ProcessLauncher implements Serializable {
   private OutputStream out;
   private OutputStream err;
   private InputStream in;
   private Process process;
   private long timeout;
   private boolean finished;

   public ProcessLauncher() {
      this((OutputStream)null, (OutputStream)null, (InputStream)null, 0L);
   }

   public ProcessLauncher(OutputStream var1, OutputStream var2) {
      this(var1, var2, (InputStream)null, 0L);
   }

   public ProcessLauncher(OutputStream var1, OutputStream var2, InputStream var3) {
      this(var1, var2, var3, 0L);
   }

   public ProcessLauncher(OutputStream var1, OutputStream var2, long var3) {
      this(var1, var2, (InputStream)null, var3);
   }

   public ProcessLauncher(OutputStream var1, OutputStream var2, InputStream var3, long var4) {
      this.out = null;
      this.err = null;
      this.in = null;
      this.timeout = 0L;
      this.finished = false;
      this.out = var1;
      this.err = var2;
      this.in = var3;
      this.timeout = var4 < 0L ? 0L : var4;
   }

   public int exec(String var1) throws IOException {
      this.process = Runtime.getRuntime().exec(var1);
      return this.execute();
   }

   public int exec(String[] var1) throws IOException {
      this.process = Runtime.getRuntime().exec(var1);
      return this.execute();
   }

   public int exec(String[] var1, String[] var2) throws IOException {
      this.process = Runtime.getRuntime().exec(var1, var2);
      return this.execute();
   }

   public int exec(String[] var1, String[] var2, File var3) throws IOException {
      this.process = Runtime.getRuntime().exec(var1, var2, var3);
      return this.execute();
   }

   public int exec(String var1, String[] var2) throws IOException {
      this.process = Runtime.getRuntime().exec(var1, var2);
      return this.execute();
   }

   public int exec(String var1, String[] var2, File var3) throws IOException {
      this.process = Runtime.getRuntime().exec(var1, var2, var3);
      return this.execute();
   }

   private int execute() throws IOException {
      int var1 = -1;
      if (this.err == null) {
         this.process.getErrorStream().close();
      } else {
         this.createStreamThread(this.process.getErrorStream(), this.err);
      }

      if (this.out == null) {
         this.process.getInputStream().close();
      } else {
         this.createStreamThread(this.process.getInputStream(), this.out);
      }

      if (this.in != null) {
         this.createStreamThread(this.in, this.process.getOutputStream());
      }

      if (this.timeout > 0L) {
         Thread var2 = this.createProcessThread(this.process);
         var2.start();

         try {
            var2.join(this.timeout);

            try {
               var1 = this.process.exitValue();
            } catch (IllegalThreadStateException var5) {
               this.process.destroy();
               var1 = this.process.exitValue();
            }
         } catch (InterruptedException var6) {
            var6.printStackTrace();
         }
      } else if (this.timeout == 0L) {
         try {
            var1 = this.process.waitFor();
         } catch (InterruptedException var4) {
            var4.printStackTrace();
         }
      }

      this.finished = true;
      return var1;
   }

   private void createStreamThread(final InputStream var1, final OutputStream var2) {
      (new Thread(new Runnable() {
         public void run() {
            BufferedInputStream var1x = new BufferedInputStream(var1);
            BufferedOutputStream var2x = null;
            if (var2 != null) {
               var2x = new BufferedOutputStream(var2);
            }

            byte[] var3 = new byte[2048];
            boolean var4 = false;

            int var7;
            try {
               while((var7 = var1x.read(var3)) > 0) {
                  if (var2x != null) {
                     if (ProcessLauncher.this.finished) {
                        break;
                     }

                     var2x.write(var3, 0, var7);
                     var2x.flush();
                  }
               }
            } catch (IOException var6) {
               var6.printStackTrace();
            }

         }
      })).start();
   }

   private Thread createProcessThread(final Process var1) {
      return new Thread() {
         public void run() {
            try {
               var1.waitFor();
            } catch (InterruptedException var2) {
               var2.printStackTrace();
            }

         }
      };
   }

   public OutputStream getErrorStream() {
      return this.err;
   }

   public InputStream getInputStream() {
      return this.in;
   }

   public OutputStream getOutputStream() {
      return this.out;
   }

   public long getTimeout() {
      return this.timeout;
   }

   public void setErrorStream(OutputStream var1) {
      this.err = var1;
   }

   public void setInputStream(InputStream var1) {
      this.in = var1;
   }

   public void setOutputStream(OutputStream var1) {
      this.out = var1;
   }

   public void setTimeout(long var1) {
      this.timeout = var1;
   }
}
