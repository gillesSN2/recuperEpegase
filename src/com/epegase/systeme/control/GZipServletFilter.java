package com.epegase.systeme.control;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GZipServletFilter implements Filter {
   public void init(FilterConfig var1) throws ServletException {
   }

   public void destroy() {
   }

   public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) throws IOException, ServletException {
      HttpServletRequest var4 = (HttpServletRequest)var1;
      HttpServletResponse var5 = (HttpServletResponse)var2;
      if (this.acceptsGZipEncoding(var4)) {
         var5.addHeader("Content-Encoding", "gzip");
         GZipServletResponseWrapper var6 = new GZipServletResponseWrapper(var5);
         var3.doFilter(var1, var6);
         var6.close();
      } else {
         var3.doFilter(var1, var2);
      }

   }

   private boolean acceptsGZipEncoding(HttpServletRequest var1) {
      String var2 = var1.getHeader("Accept-Encoding");
      return var2 != null && var2.indexOf("gzip") != -1;
   }
}
