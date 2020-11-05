package com.epegase.systeme.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class ValidationChaineString implements Validator {
   public void validate(FacesContext var1, UIComponent var2, Object var3) throws ValidatorException {
      String var4 = (String)var3;
      Pattern var5 = Pattern.compile("[a-z]+[a-z]");
      Pattern var6 = Pattern.compile("[A-Z]+[A-Z]");
      Matcher var7 = var5.matcher(var4);
      Matcher var8 = var6.matcher(var4);
      boolean var9 = var7.matches();
      boolean var10 = var8.matches();
      if (!var9 && !var10) {
         FacesMessage var11 = new FacesMessage();
         var11.setSummary("Entrer une chaine valide !");
         throw new ValidatorException(var11);
      }
   }
}
