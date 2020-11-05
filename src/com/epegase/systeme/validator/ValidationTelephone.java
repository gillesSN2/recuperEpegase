package com.epegase.systeme.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidationTelephone implements Validator {
   public void validate(FacesContext var1, UIComponent var2, Object var3) throws ValidatorException {
      String var4 = (String)var3;
      Pattern var5 = Pattern.compile("\\+\\(+[0-9]+\\)+[0-9]+");
      Pattern var6 = Pattern.compile("[0-0]+[0-9]+[0-9]+");
      Pattern var7 = Pattern.compile("[0-0]+ +[0-9]+ +[0-9]+");
      Pattern var8 = Pattern.compile("[0-0]+-+[0-9]+-+[0-9]+");
      Pattern var9 = Pattern.compile("[0-0]+.+[0-9]+.+[0-9]+");
      Pattern var10 = Pattern.compile("\\++[0-9]+[0-9]+");
      Matcher var11 = var5.matcher(var4);
      Matcher var12 = var6.matcher(var4);
      Matcher var13 = var7.matcher(var4);
      Matcher var14 = var8.matcher(var4);
      Matcher var15 = var9.matcher(var4);
      Matcher var16 = var10.matcher(var4);
      boolean var17 = var11.matches();
      boolean var18 = var12.matches();
      boolean var19 = var13.matches();
      boolean var20 = var14.matches();
      boolean var21 = var15.matches();
      boolean var22 = var16.matches();
      if (!var17 && !var18 && !var19 && !var20 && !var21 && !var22) {
         FacesMessage var23 = new FacesMessage();
         var23.setSummary("Numéro Invalide !");
         throw new ValidatorException(var23);
      }
   }
}
