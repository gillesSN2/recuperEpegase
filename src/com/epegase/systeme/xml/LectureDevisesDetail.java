package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LectureDevisesDetail implements Serializable {
   private List mesDetails;
   private List mesDevisesDetailItems;

   public LectureDevisesDetail() throws IOException {
   }

   public List recupereDevises(String var1) throws ParseException {
      this.mesDetails = new ArrayList();
      this.mesDevisesDetailItems = new ArrayList();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "devises";
      File var3 = new File(var2);
      String[] var4 = var3.list();

      for(int var5 = var4.length - 1; var5 >= 0; --var5) {
         if (var4[var5].startsWith(var1)) {
            try {
               SAXBuilder var6 = new SAXBuilder();
               File var7 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "devises" + File.separator + var4[var5]);
               FileReader var8 = new FileReader(var7);
               Document var9 = var6.build(var8);
               Element var10 = var9.getRootElement();
               List var11 = var10.getChildren("historique");
               Iterator var12 = var11.iterator();

               while(var12.hasNext()) {
                  Element var13 = (Element)var12.next();
                  ObjetDevisesDetail var14 = new ObjetDevisesDetail();
                  var14.setDate((Date)null);
                  var14.setCode(var1);
                  var14.setMadate(var13.getChild("date").getText());
                  var14.setTaux1(var13.getChild("taux1").getText());
                  var14.setTaux2(var13.getChild("taux2").getText());
                  this.mesDetails.add(var14);
                  this.mesDevisesDetailItems.add(new SelectItem(var14));
               }

               var8.close();
            } catch (JDOMException var15) {
            } catch (IOException var16) {
            }
         }
      }

      return this.mesDetails;
   }

   public List getMesDetails() {
      return this.mesDetails;
   }

   public void setMesDetails(List var1) {
      this.mesDetails = var1;
   }
}
