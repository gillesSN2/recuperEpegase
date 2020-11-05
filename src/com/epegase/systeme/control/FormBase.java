package com.epegase.systeme.control;

import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FormBase implements Serializable {
   public String getParameter(String var1) {
      FacesContext var2 = FacesContext.getCurrentInstance();
      ExternalContext var3 = var2.getExternalContext();
      HttpServletRequest var4 = (HttpServletRequest)var3.getRequest();
      return var4.getParameter(var1);
   }
}
