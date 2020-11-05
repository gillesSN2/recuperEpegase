package com.epegase.systeme.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class Validation implements Validator {
   public void validate(FacesContext var1, UIComponent var2, Object var3) throws ValidatorException {
      String var4 = (String)var3;
      Pattern var5 = Pattern.compile(".+@.+\\.[a-z]+");
      Matcher var6 = var5.matcher(var4);
      boolean var7 = var6.matches();
      if (!var7) {
         FacesMessage var8 = new FacesMessage();
         var8.setSummary("Entrez un email valide !");
         throw new ValidatorException(var8);
      }
   }
}
