package com.epegase.systeme.util;

import com.epegase.systeme.menu.MenuModuleHorizontalCtrl;
import java.io.IOException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.JDOMException;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilJob extends Thread {
   Timer timer;
   MenuModuleHorizontalCtrl menuModuleHorizontalCtrl;

   public void RepetAction() {
      this.timer = new Timer();
      this.timer.schedule(new UtilJobAction(), 10L, 60000L);
   }

   public void cancelJob() {
      this.timer.cancel();
   }

   public MenuModuleHorizontalCtrl getMenuModuleHorizontalCtrl() {
      return this.menuModuleHorizontalCtrl;
   }

   public void setMenuModuleHorizontalCtrl(MenuModuleHorizontalCtrl var1) {
      this.menuModuleHorizontalCtrl = var1;
   }

   public class UtilJobAction extends TimerTask {
      public void run() {
         try {
            UtilJob.this.menuModuleHorizontalCtrl.scanMessage();
         } catch (IOException var3) {
            Logger.getLogger(UtilJob.class.getName()).log(Level.SEVERE, (String)null, var3);
         } catch (JDOMException var4) {
            Logger.getLogger(UtilJob.class.getName()).log(Level.SEVERE, (String)null, var4);
         }

         try {
            UtilJob.this.menuModuleHorizontalCtrl.scanScript();
         } catch (ParseException var2) {
            Logger.getLogger(UtilJob.class.getName()).log(Level.SEVERE, (String)null, var2);
         }

      }
   }
}
