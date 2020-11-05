package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LecturePays implements Serializable {
   private ObjetPays pays;
   private List mespays = new ArrayList();
   private List mesPaysItems;
   private List mesNationnalitesItems;

   public LecturePays() {
      this.recupereLespays();
   }

   public void recupereLespays() {
      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "pays.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         List var6 = var5.getChildren();
         this.mespays = new ArrayList();
         this.mesPaysItems = new ArrayList();
         this.mesNationnalitesItems = new ArrayList();

         int var7;
         for(var7 = 0; var7 < var6.size(); ++var7) {
            this.pays = new ObjetPays();
            this.pays.setIdentification(((Element)var6.get(var7)).getChild("identification").getText());
            this.pays.setLangue(((Element)var6.get(var7)).getChild("langue").getText());
            this.pays.setGestion(((Element)var6.get(var7)).getChild("gestion").getText());
            this.pays.setIso(((Element)var6.get(var7)).getChild("iso").getText());
            this.pays.setDrapeau(((Element)var6.get(var7)).getChild("drapeau").getText());
            this.pays.setNom_FR(((Element)var6.get(var7)).getChild("nom_FR").getText());
            this.pays.setNom_UK(((Element)var6.get(var7)).getChild("nom_UK").getText());
            this.pays.setNom_SP(((Element)var6.get(var7)).getChild("nom_SP").getText());
            this.pays.setNationnalite_FR(((Element)var6.get(var7)).getChild("nationnalite_FR").getText());
            this.pays.setNationnalite_UK(((Element)var6.get(var7)).getChild("nationnalite_UK").getText());
            this.pays.setNationnalite_SP(((Element)var6.get(var7)).getChild("nationnalite_SP").getText());
            this.pays.setZone(((Element)var6.get(var7)).getChild("zone").getText());
            this.pays.setFiscalite(((Element)var6.get(var7)).getChild("fiscalite").getText());
            this.pays.setIndicatif(((Element)var6.get(var7)).getChild("indicatif").getText());
            this.pays.setRefGabon(((Element)var6.get(var7)).getChild("refGabon").getText());
            this.pays.setDevise(((Element)var6.get(var7)).getChild("devise").getText());
            this.mespays.add(this.pays);
         }

         if (this.mespays.size() != 0) {
            this.mespays = this.triListePays(this.mespays);

            for(var7 = 0; var7 < this.mespays.size(); ++var7) {
               this.pays = (ObjetPays)this.mespays.get(var7);
               this.mesPaysItems.add(new SelectItem(this.pays.getNom_FR()));
            }

            new ArrayList();
            List var11 = this.triListeNationnalite(this.mespays);

            for(int var8 = 0; var8 < var11.size(); ++var8) {
               this.pays = (ObjetPays)var11.get(var8);
               if (this.pays.getNationnalite_FR() != null && !this.pays.getNationnalite_FR().isEmpty()) {
                  this.mesNationnalitesItems.add(new SelectItem(this.pays.getNationnalite_FR()));
               }
            }
         }

         var3.close();
      } catch (JDOMException var9) {
      } catch (IOException var10) {
      }

   }

   public List triListePays(List var1) {
      ArrayList var2 = new ArrayList();
      new ObjetPays();
      new ObjetPays();
      String var5 = "";
      String var6 = "";
      if (var1.size() != 0) {
         for(int var7 = 0; var7 < var1.size(); ++var7) {
            new ObjetPays();
            ObjetPays var3 = (ObjetPays)var1.get(var7);
            var5 = var3.getNom_FR();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  new ObjetPays();
                  ObjetPays var4 = (ObjetPays)var2.get(var9);
                  int var10 = var9 - 1;
                  if (var10 < 0) {
                     var10 = 0;
                  }

                  var6 = var4.getNom_FR();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var10, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public List triListeNationnalite(List var1) {
      ArrayList var2 = new ArrayList();
      new ObjetPays();
      new ObjetPays();
      String var5 = "";
      String var6 = "";
      if (var1.size() != 0) {
         for(int var7 = 0; var7 < var1.size(); ++var7) {
            new ObjetPays();
            ObjetPays var3 = (ObjetPays)var1.get(var7);
            var5 = var3.getNationnalite_FR();
            var6 = "";
            if (var2.size() == 0) {
               var2.add(var3);
            } else {
               boolean var8 = false;

               for(int var9 = 0; var9 < var2.size(); ++var9) {
                  new ObjetPays();
                  ObjetPays var4 = (ObjetPays)var2.get(var9);
                  int var10 = var9 - 1;
                  if (var10 < 0) {
                     var10 = 0;
                  }

                  var6 = var4.getNationnalite_FR();
                  if (var5.compareTo(var6) < 0) {
                     var2.add(var10, var3);
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var2.add(var3);
               }
            }
         }
      }

      return var2;
   }

   public ObjetPays trouvePays(String var1) {
      this.pays = new ObjetPays();
      if (this.mespays.size() != 0) {
         for(int var2 = 0; var2 < this.mespays.size(); ++var2) {
            if (((ObjetPays)this.mespays.get(var2)).getIdentification().equals(var1)) {
               this.pays = (ObjetPays)this.mespays.get(var2);
               break;
            }
         }
      }

      return this.pays;
   }

   public ObjetPays trouveNomPays(String var1) {
      this.pays = new ObjetPays();
      if (this.mespays.size() != 0) {
         for(int var2 = 0; var2 < this.mespays.size(); ++var2) {
            if (((ObjetPays)this.mespays.get(var2)).getNom_FR().equals(var1)) {
               this.pays = (ObjetPays)this.mespays.get(var2);
               break;
            }
         }
      }

      return this.pays;
   }

   public List getMespays() {
      return this.mespays;
   }

   public void setMespays(List var1) {
      this.mespays = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public List getMesNationnalitesItems() {
      return this.mesNationnalitesItems;
   }

   public void setMesNationnalitesItems(List var1) {
      this.mesNationnalitesItems = var1;
   }
}
