package com.epegase.systeme.control;

import com.Ostermiller.util.CmdLnOption;
import com.Ostermiller.util.PasswordVerifier;
import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

public class RandPass implements Serializable {
   public static final String version = "1.1";
   protected static ResourceBundle labels = ResourceBundle.getBundle("com.Ostermiller.util.RandPass", Locale.getDefault());
   private static final int DEFAULT_PASSWORD_LENGTH = 8;
   public static final char[] NUMBERS_AND_LETTERS_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   public static final char[] SYMBOLS_ALPHABET = new char[]{'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~'};
   public static final char[] PRINTABLE_ALPHABET = new char[]{'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '?', '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~'};
   public static final char[] LOWERCASE_LETTERS_ALPHABET = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
   public static final char[] LOWERCASE_LETTERS_AND_NUMBERS_ALPHABET = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   public static final char[] LETTERS_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
   public static final char[] UPPERCASE_LETTERS_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
   public static final char[] NONCONFUSING_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z', '2', '3', '4', '5', '6', '7', '8', '9'};
   protected SecureRandom rand;
   protected int repetition;
   protected char[] alphabet;
   protected char[] firstAlphabet;
   protected char[] lastAlphabet;
   private Vector requirements;
   private Vector verifiers;
   private boolean[] touched;
   private int[] available;

   public RandPass() {
      this(new SecureRandom(), NONCONFUSING_ALPHABET);
   }

   public RandPass(SecureRandom var1) {
      this(var1, NONCONFUSING_ALPHABET);
   }

   public RandPass(char[] var1) {
      this(new SecureRandom(), var1);
   }

   public RandPass(SecureRandom var1, char[] var2) {
      this.repetition = -1;
      this.requirements = null;
      this.verifiers = null;
      this.touched = null;
      this.available = null;
      this.rand = var1;
      this.alphabet = var2;
   }

   public String calculPwd() throws Exception {
      byte var1 = 1;
      char[] var2 = NONCONFUSING_ALPHABET;
      Object var3 = null;
      Object var4 = null;
      Vector var5 = new Vector();
      Vector var6 = new Vector();
      byte var7 = 0;
      byte var8 = 10;
      RandPass var9 = new RandPass();
      var9.setAlphabet(var2);
      var9.setFirstAlphabet((char[])var3);
      var9.setLastAlphabet((char[])var4);
      var9.setMaxRepetition(var7);

      int var10;
      for(var10 = 0; var10 < var5.size(); ++var10) {
         var9.addRequirement(((String)var5.elementAt(var10)).toCharArray(), 1);
      }

      for(var10 = 0; var10 < var6.size(); ++var10) {
         var9.addVerifier((PasswordVerifier)((PasswordVerifier)Class.forName((String)var6.elementAt(var10)).newInstance()));
      }

      byte var11 = 0;
      return var11 < var1 ? var9.getPass(var8) : "";
   }

   public void addRequirement(char[] var1, int var2) {
      if (this.requirements == null) {
         this.requirements = new Vector();
      }

      this.requirements.add(new Requirement(var1, var2));
   }

   public void setAlphabet(char[] var1) {
      if (var1 == null) {
         throw new NullPointerException("Null alphabet");
      } else if (var1.length == 0) {
         throw new ArrayIndexOutOfBoundsException("No characters in alphabet");
      } else {
         this.alphabet = var1;
      }
   }

   public void setRandomGenerator(SecureRandom var1) {
      this.rand = var1;
   }

   public void setFirstAlphabet(char[] var1) {
      if (var1 != null && var1.length != 0) {
         this.firstAlphabet = var1;
      } else {
         this.firstAlphabet = null;
      }

   }

   public void setLastAlphabet(char[] var1) {
      if (var1 != null && var1.length != 0) {
         this.lastAlphabet = var1;
      } else {
         this.lastAlphabet = null;
      }

   }

   public void setMaxRepetition(int var1) {
      this.repetition = var1 - 1;
   }

   public char[] getPassChars(char[] var1) {
      boolean var2 = false;

      while(!var2) {
         int var3 = var1.length;

         int var4;
         for(var4 = 0; var4 < var3; ++var4) {
            char[] var5 = this.alphabet;
            if (var4 == 0 && this.firstAlphabet != null) {
               var5 = this.firstAlphabet;
            } else if (var4 == var3 - 1 && this.lastAlphabet != null) {
               var5 = this.lastAlphabet;
            }

            int var6 = avoidRepetition(var5, var1, var4, this.repetition, var5.length);
            var1[var4] = var5[this.rand.nextInt(var6)];
         }

         if (this.requirements != null) {
            this.applyRequirements(var1);
         }

         var2 = true;

         for(var4 = 0; var2 && this.verifiers != null && var4 < this.verifiers.size(); ++var4) {
            var2 = ((PasswordVerifier)this.verifiers.elementAt(var4)).verify(var1);
         }
      }

      return var1;
   }

   public void addVerifier(PasswordVerifier var1) {
      if (this.verifiers == null) {
         this.verifiers = new Vector();
      }

      this.verifiers.add(var1);
   }

   private void applyRequirements(char[] var1) {
      int var2 = this.requirements.size();
      if (var2 > 0) {
         int var3 = var1.length;
         if (this.touched == null || this.touched.length < var3) {
            this.touched = new boolean[var3];
         }

         if (this.available == null || this.available.length < var3) {
            this.available = new int[var3];
         }

         int var4;
         for(var4 = 0; var4 < var3; ++var4) {
            this.touched[var4] = false;
         }

         for(var4 = 0; var4 < var2; ++var4) {
            Requirement var5 = (Requirement)this.requirements.elementAt(var4);
            int var6 = var5.alphabet.length;
            int var7 = 0;
            int var8 = 0;

            int var9;
            for(var9 = 0; var9 < var3; ++var9) {
               if (arrayContains(var5.alphabet, var1[var9]) && var7 < var5.num) {
                  ++var7;
                  this.touched[var9] = true;
                  if (this.repetition >= 0) {
                     var6 -= moveto(var5.alphabet, var6, var1[var9]);
                     if (var6 < 0) {
                        var6 = var5.alphabet.length;
                     }
                  }
               } else if (!this.touched[var9]) {
                  this.available[var8] = var9;
                  ++var8;
               }
            }

            var9 = var5.num - var7;

            for(int var10 = 0; var10 < var9 && var8 > 0; ++var10) {
               int var11 = this.rand.nextInt(var8);
               char var12 = var5.alphabet[this.rand.nextInt(var6)];
               var1[this.available[var11]] = var12;
               this.touched[this.available[var11]] = true;
               --var8;
               this.available[var11] = this.available[var8];
               if (this.repetition >= 0) {
                  var6 -= moveto(var5.alphabet, var6, var12);
                  if (var6 < 0) {
                     var6 = var5.alphabet.length;
                  }
               }
            }
         }
      }

   }

   private static boolean arrayContains(char[] var0, char var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         if (var0[var2] == var1) {
            return true;
         }
      }

      return false;
   }

   private static int avoidRepetition(char[] var0, char[] var1, int var2, int var3, int var4) {
      if (var3 > -1) {
         for(int var5 = 0; (var5 = findRep(var1, var5, var2, var3)) != -1; ++var5) {
            var4 -= moveto(var0, var4, var1[var5 + var3]);
         }

         if (var4 == 0) {
            var4 = var0.length;
         }
      }

      return var4;
   }

   private static int findRep(char[] var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 < var2 - var3; ++var4) {
         boolean var5 = true;

         for(int var6 = 0; var5 && var6 < var3; ++var6) {
            if (var0[var4 + var6] != var0[var2 - var3 + var6]) {
               var5 = false;
            }
         }

         if (var5) {
            return var4;
         }
      }

      return -1;
   }

   private static int moveto(char[] var0, int var1, char var2) {
      int var3 = 0;

      for(int var4 = 0; var4 < var1; ++var4) {
         if (var0[var4] == var2) {
            --var1;
            char var5 = var0[var1];
            var0[var1] = var0[var4];
            var0[var4] = var5;
            ++var3;
         }
      }

      return var3;
   }

   public char[] getPassChars(int var1) {
      return this.getPassChars(new char[var1]);
   }

   public char[] getPassChars() {
      return this.getPassChars(8);
   }

   public String getPass(int var1) {
      return new String(this.getPassChars(new char[var1]));
   }

   public String getPass() {
      return this.getPass(8);
   }

   private static enum RandPassCmdLnOption {
      HELP((new CmdLnOption(RandPass.labels.getString("help.option"))).setDescription(RandPass.labels.getString("help.message"))),
      VERSION((new CmdLnOption(RandPass.labels.getString("version.option"))).setDescription(RandPass.labels.getString("version.message"))),
      ABOUT((new CmdLnOption(RandPass.labels.getString("about.option"))).setDescription(RandPass.labels.getString("about.message"))),
      ALPHABET((new CmdLnOption(RandPass.labels.getString("alphabet.option"), 'a')).setRequiredArgument().setDescription(RandPass.labels.getString("a.message"))),
      FIRST((new CmdLnOption(RandPass.labels.getString("first.alphabet.option"), 'F')).setRequiredArgument().setDescription(RandPass.labels.getString("F.message"))),
      LAST((new CmdLnOption(RandPass.labels.getString("last.alphabet.option"), 'L')).setRequiredArgument().setDescription(RandPass.labels.getString("L.message"))),
      NUMBER((new CmdLnOption(RandPass.labels.getString("number.option"), 'n')).setRequiredArgument().setDescription(RandPass.labels.getString("n.message"))),
      REPS((new CmdLnOption(RandPass.labels.getString("maxrep.option"), 'r')).setRequiredArgument().setDescription(RandPass.labels.getString("r.message"))),
      LENGTH((new CmdLnOption(RandPass.labels.getString("length.option"), 'l')).setRequiredArgument().setDescription(RandPass.labels.getString("l.message"))),
      REQUIRE((new CmdLnOption(RandPass.labels.getString("require.option"), 'R')).setRequiredArgument().setDescription(RandPass.labels.getString("R.message"))),
      VERIFY((new CmdLnOption(RandPass.labels.getString("verify.option"), 'v')).setRequiredArgument().setDescription(RandPass.labels.getString("v.message")));

      private CmdLnOption option;

      private RandPassCmdLnOption(CmdLnOption var3) {
         var3.setUserObject(this);
         this.option = var3;
      }

      private CmdLnOption getCmdLineOption() {
         return this.option;
      }
   }

   private class Requirement {
      private char[] alphabet;
      private int num;

      private Requirement(char[] var2, int var3) {
         this.alphabet = var2;
         this.num = var3;
      }

      // $FF: synthetic method
      Requirement(char[] var2, int var3, Object var4) {
         this(var2, var3);
      }
   }
}
