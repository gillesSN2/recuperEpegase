package com.epegase.systeme.util;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.ajax4jsf.util.base64.Base64;

public class MD5Password implements Serializable {
   private String encryptionScheme = "Blowfish/ECB/NoPadding";
   private String algo = "Blowfish";
   private String keySecret = "12481632641282565121024";
   private String charEncoding = "UTF-8";

   public String getEncodedPassword(String var1) {
      byte[] var2 = var1.getBytes();
      Object var3 = null;

      byte[] var8;
      try {
         var8 = MessageDigest.getInstance("MD5").digest(var2);
      } catch (NoSuchAlgorithmException var7) {
         throw new Error("no MD5 support in this VM");
      }

      StringBuffer var4 = new StringBuffer();

      for(int var5 = 0; var5 < var8.length; ++var5) {
         String var6 = Integer.toHexString(var8[var5]);
         if (var6.length() == 1) {
            var4.append('0');
            var4.append(var6.charAt(var6.length() - 1));
         } else {
            var4.append(var6.substring(var6.length() - 2));
         }
      }

      return var4.toString();
   }

   public String doubleEncryption_Blowfish_Base64(String var1) {
      try {
         byte[] var3 = var1.getBytes(this.charEncoding);
         byte[] var4;
         if (var3.length % 8 != 0) {
            var4 = new byte[var3.length + 8 - var3.length % 8];
            System.arraycopy(var3, 0, var4, 0, var3.length);
            var3 = var4;
         }

         var4 = this.keySecret.getBytes(this.charEncoding);
         SecretKeySpec var5 = new SecretKeySpec(var4, this.algo);
         Cipher var2 = Cipher.getInstance(this.encryptionScheme);
         var2.init(1, var5);
         byte[] var6 = var2.doFinal(var3);
         byte[] var7 = Base64.encodeBase64(var6);
         return new String(var7);
      } catch (Exception var8) {
         var8.printStackTrace();
         return null;
      }
   }

   public String doubleDecryption_Base64_Blowfish(String var1) {
      try {
         byte[] var3 = Base64.decodeBase64(var1.getBytes(this.charEncoding));
         byte[] var4;
         if (var3.length % 8 != 0) {
            var4 = new byte[var3.length + 8 - var3.length % 8];
            System.arraycopy(var3, 0, var4, 0, var3.length);
            var3 = var4;
         }

         var4 = this.keySecret.getBytes(this.charEncoding);
         SecretKeySpec var5 = new SecretKeySpec(var4, this.algo);
         Cipher var2 = Cipher.getInstance(this.encryptionScheme);
         var2.init(2, var5);
         byte[] var6 = var2.doFinal(var3);
         return new String(var6);
      } catch (Exception var7) {
         var7.printStackTrace();
         return null;
      }
   }
}
