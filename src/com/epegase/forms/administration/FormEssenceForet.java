package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureEssenceForet;
import com.epegase.systeme.xml.ObjetEssenceForet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormEssenceForet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List listeElement = new ArrayList();
   private transient DataModel dataModelElement = new ListDataModel();
   private ObjetEssenceForet objetEssenceForet;
   private boolean btnModClient = false;
   private String lib;
   private String cod;
   private double atibt;
   private double octra;
   private double export;
   private double martelage;
   private double prx_plage_01;
   private double prx_cession_01;
   private double val_douane_01;
   private double prx_plage_02;
   private double prx_cession_02;
   private double val_douane_02;
   private double prx_plage_03;
   private double prx_cession_03;
   private double val_douane_03;
   private double prx_plage_04;
   private double prx_cession_04;
   private double val_douane_04;
   private double prx_plage_05;
   private double prx_cession_05;
   private double val_douane_05;
   private double prx_plage_06;
   private double prx_cession_06;
   private double val_douane_06;
   private double prx_plage_07;
   private double prx_cession_07;
   private double val_douane_07;
   private double prx_plage_08;
   private double prx_cession_08;
   private double val_douane_08;
   private double prx_plage_09;
   private double prx_cession_09;
   private double val_douane_09;
   private double prx_plage_10;
   private double prx_cession_10;
   private double val_douane_10;
   private double prx_plage_11;
   private double prx_cession_11;
   private double val_douane_11;
   private double prx_plage_12;
   private double prx_cession_12;
   private double val_douane_12;
   private boolean afficheModePanelAjt;
   private boolean afficheModePanel;
   Element racine;
   Document document;

   public FormEssenceForet() throws IOException {
   }

   public void listeEssence() throws JDOMException, IOException {
      LectureEssenceForet var1 = new LectureEssenceForet();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerEssences();
      this.listeElement = var1.getMesElements();
      this.dataModelElement.setWrappedData(this.listeElement);
   }

   public void lanceAjouter() throws HibernateException, NamingException {
      this.objetEssenceForet = new ObjetEssenceForet();
      this.lib = "";
      this.cod = "";
      this.atibt = 0.0D;
      this.octra = 0.0D;
      this.export = 0.0D;
      this.martelage = 0.0D;
      this.prx_plage_01 = 0.0D;
      this.prx_cession_01 = 0.0D;
      this.val_douane_01 = 0.0D;
      this.prx_plage_02 = 0.0D;
      this.prx_cession_02 = 0.0D;
      this.val_douane_02 = 0.0D;
      this.prx_plage_03 = 0.0D;
      this.prx_cession_03 = 0.0D;
      this.val_douane_03 = 0.0D;
      this.prx_plage_04 = 0.0D;
      this.prx_cession_04 = 0.0D;
      this.val_douane_04 = 4.0D;
      this.prx_plage_05 = 0.0D;
      this.prx_cession_05 = 0.0D;
      this.val_douane_05 = 0.0D;
      this.prx_plage_06 = 0.0D;
      this.prx_cession_06 = 0.0D;
      this.val_douane_06 = 0.0D;
      this.prx_plage_07 = 0.0D;
      this.prx_cession_07 = 0.0D;
      this.val_douane_07 = 0.0D;
      this.prx_plage_08 = 0.0D;
      this.prx_cession_08 = 0.0D;
      this.val_douane_08 = 0.0D;
      this.prx_plage_09 = 0.0D;
      this.prx_cession_09 = 0.0D;
      this.val_douane_09 = 0.0D;
      this.prx_plage_10 = 0.0D;
      this.prx_cession_10 = 0.0D;
      this.val_douane_10 = 0.0D;
      this.prx_plage_11 = 0.0D;
      this.prx_cession_11 = 0.0D;
      this.val_douane_11 = 0.0D;
      this.prx_plage_12 = 0.0D;
      this.prx_cession_12 = 0.0D;
      this.val_douane_12 = 0.0D;
      this.afficheModePanelAjt = true;
      this.afficheModePanel = false;
   }

   public void selectionLigne() {
      if (this.dataModelElement.isRowAvailable()) {
         this.objetEssenceForet = (ObjetEssenceForet)this.dataModelElement.getRowData();
         this.lib = this.objetEssenceForet.getCode();
         this.cod = this.objetEssenceForet.getLibelle();
         this.atibt = (double)this.objetEssenceForet.getAtibt();
         this.octra = (double)this.objetEssenceForet.getOctra();
         this.export = (double)this.objetEssenceForet.getExport();
         this.martelage = (double)this.objetEssenceForet.getMartelage();
         this.prx_plage_01 = this.objetEssenceForet.getPrx_plage_01();
         this.prx_cession_01 = this.objetEssenceForet.getPrx_cession_01();
         this.val_douane_01 = this.objetEssenceForet.getVal_douane_01();
         this.prx_plage_02 = this.objetEssenceForet.getPrx_plage_02();
         this.prx_cession_02 = this.objetEssenceForet.getPrx_cession_02();
         this.val_douane_02 = this.objetEssenceForet.getVal_douane_02();
         this.prx_plage_03 = this.objetEssenceForet.getPrx_plage_03();
         this.prx_cession_03 = this.objetEssenceForet.getPrx_cession_03();
         this.val_douane_03 = this.objetEssenceForet.getVal_douane_03();
         this.prx_plage_04 = this.objetEssenceForet.getPrx_plage_04();
         this.prx_cession_04 = this.objetEssenceForet.getPrx_cession_04();
         this.val_douane_04 = this.objetEssenceForet.getVal_douane_04();
         this.prx_plage_05 = this.objetEssenceForet.getPrx_plage_05();
         this.prx_cession_05 = this.objetEssenceForet.getPrx_cession_05();
         this.val_douane_05 = this.objetEssenceForet.getVal_douane_05();
         this.prx_plage_06 = this.objetEssenceForet.getPrx_plage_06();
         this.prx_cession_06 = this.objetEssenceForet.getPrx_cession_06();
         this.val_douane_06 = this.objetEssenceForet.getVal_douane_06();
         this.prx_plage_07 = this.objetEssenceForet.getPrx_plage_07();
         this.prx_cession_07 = this.objetEssenceForet.getPrx_cession_07();
         this.val_douane_07 = this.objetEssenceForet.getVal_douane_07();
         this.prx_plage_08 = this.objetEssenceForet.getPrx_plage_08();
         this.prx_cession_08 = this.objetEssenceForet.getPrx_cession_08();
         this.val_douane_08 = this.objetEssenceForet.getVal_douane_08();
         this.prx_plage_09 = this.objetEssenceForet.getPrx_plage_09();
         this.prx_cession_09 = this.objetEssenceForet.getPrx_cession_09();
         this.val_douane_09 = this.objetEssenceForet.getVal_douane_09();
         this.prx_plage_10 = this.objetEssenceForet.getPrx_plage_10();
         this.prx_cession_10 = this.objetEssenceForet.getPrx_cession_10();
         this.val_douane_10 = this.objetEssenceForet.getVal_douane_10();
         this.prx_plage_11 = this.objetEssenceForet.getPrx_plage_11();
         this.prx_cession_11 = this.objetEssenceForet.getPrx_cession_11();
         this.val_douane_11 = this.objetEssenceForet.getVal_douane_11();
         this.prx_plage_12 = this.objetEssenceForet.getPrx_plage_12();
         this.prx_cession_12 = this.objetEssenceForet.getPrx_cession_12();
         this.val_douane_12 = this.objetEssenceForet.getVal_douane_12();
         this.btnModClient = true;
      }

   }

   public void lanceModif() throws HibernateException, NamingException {
      this.lib = this.objetEssenceForet.getLibelle();
      this.cod = this.objetEssenceForet.getCode();
      this.afficheModePanel = true;
      this.afficheModePanelAjt = false;
   }

   public void closeModif() {
      this.afficheModePanelAjt = false;
      this.afficheModePanel = false;
   }

   public void majAjout() throws JDOMException, IOException {
      this.creation("essences");
      this.listeEssence();
      this.closeModif();
      this.btnModClient = false;
   }

   public void majModif() throws JDOMException, IOException {
      this.objetEssenceForet.setLibelle(this.lib);
      this.objetEssenceForet.setCode(this.cod);
      this.modification("essences");
      this.listeEssence();
      this.closeModif();
      this.btnModClient = false;
   }

   public void supprimer() throws JDOMException, IOException {
      this.supprimer("essences");
      this.listeEssence();
      this.closeModif();
      this.btnModClient = false;
   }

   public void creation(String var1) {
      File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml");
      Element var4;
      Element var5;
      Element var6;
      Element var7;
      Element var8;
      Element var9;
      Element var10;
      Element var11;
      Element var12;
      Element var13;
      Element var14;
      Element var15;
      Element var16;
      Element var17;
      Element var18;
      Element var19;
      Element var20;
      Element var21;
      Element var22;
      Element var23;
      Element var24;
      Element var25;
      Element var26;
      Element var27;
      Element var28;
      Element var29;
      Element var30;
      Element var31;
      Element var32;
      Element var33;
      Element var34;
      Element var35;
      Element var36;
      Element var37;
      Element var38;
      Element var39;
      Element var40;
      Element var41;
      Element var42;
      Element var43;
      Element var44;
      Element var45;
      if (var2.exists()) {
         SAXBuilder var3 = new SAXBuilder();

         try {
            this.document = var3.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml"));
            this.racine = this.document.getRootElement();
            var4 = new Element("essence");
            this.racine.addContent(var4);
            var5 = new Element("code");
            var5.setText(this.cod);
            var4.addContent(var5);
            var6 = new Element("libelle");
            var6.setText(this.lib);
            var4.addContent(var6);
            var7 = new Element("atibt");
            var7.setText("" + this.atibt);
            var4.addContent(var7);
            var8 = new Element("octra");
            var8.setText("" + this.octra);
            var4.addContent(var8);
            var9 = new Element("export");
            var9.setText("" + this.export);
            var4.addContent(var9);
            var10 = new Element("martelage");
            var10.setText("" + this.martelage);
            var4.addContent(var10);
            var11 = new Element("prx_plage_01");
            var11.setText("" + this.prx_plage_01);
            var4.addContent(var11);
            var12 = new Element("prx_cession_01");
            var12.setText("" + this.prx_cession_01);
            var4.addContent(var12);
            var13 = new Element("val_douane_01");
            var13.setText("" + this.val_douane_01);
            var4.addContent(var13);
            var14 = new Element("prx_plage_02");
            var14.setText("" + this.prx_plage_02);
            var4.addContent(var14);
            var15 = new Element("prx_cession_02");
            var15.setText("" + this.prx_cession_02);
            var4.addContent(var15);
            var16 = new Element("val_douane_02");
            var16.setText("" + this.val_douane_02);
            var4.addContent(var16);
            var17 = new Element("prx_plage_03");
            var17.setText("" + this.prx_plage_03);
            var4.addContent(var17);
            var18 = new Element("prx_cession_03");
            var18.setText("" + this.prx_cession_03);
            var4.addContent(var18);
            var19 = new Element("val_douane_03");
            var19.setText("" + this.val_douane_03);
            var4.addContent(var19);
            var20 = new Element("prx_plage_04");
            var20.setText("" + this.prx_plage_04);
            var4.addContent(var20);
            var21 = new Element("prx_cession_04");
            var21.setText("" + this.prx_cession_04);
            var4.addContent(var21);
            var22 = new Element("val_douane_04");
            var22.setText("" + this.val_douane_04);
            var4.addContent(var22);
            var23 = new Element("prx_plage_05");
            var23.setText("" + this.prx_plage_05);
            var4.addContent(var23);
            var24 = new Element("prx_cession_05");
            var24.setText("" + this.prx_cession_05);
            var4.addContent(var24);
            var25 = new Element("val_douane_05");
            var25.setText("" + this.val_douane_05);
            var4.addContent(var25);
            var26 = new Element("prx_plage_06");
            var26.setText("" + this.prx_plage_06);
            var4.addContent(var26);
            var27 = new Element("prx_cession_06");
            var27.setText("" + this.prx_cession_06);
            var4.addContent(var27);
            var28 = new Element("val_douane_06");
            var28.setText("" + this.val_douane_06);
            var4.addContent(var28);
            var29 = new Element("prx_plage_07");
            var29.setText("" + this.prx_plage_07);
            var4.addContent(var29);
            var30 = new Element("prx_cession_07");
            var30.setText("" + this.prx_cession_07);
            var4.addContent(var30);
            var31 = new Element("val_douane_07");
            var31.setText("" + this.val_douane_07);
            var4.addContent(var31);
            var32 = new Element("prx_plage_08");
            var32.setText("" + this.prx_plage_08);
            var4.addContent(var32);
            var33 = new Element("prx_cession_08");
            var33.setText("" + this.prx_cession_08);
            var4.addContent(var33);
            var34 = new Element("val_douane_08");
            var34.setText("" + this.val_douane_08);
            var4.addContent(var34);
            var35 = new Element("prx_plage_09");
            var35.setText("" + this.prx_plage_09);
            var4.addContent(var35);
            var36 = new Element("prx_cession_09");
            var36.setText("" + this.prx_cession_09);
            var4.addContent(var36);
            var37 = new Element("val_douane_09");
            var37.setText("" + this.val_douane_09);
            var4.addContent(var37);
            var38 = new Element("prx_plage_10");
            var38.setText("" + this.prx_plage_10);
            var4.addContent(var38);
            var39 = new Element("prx_cession_10");
            var39.setText("" + this.prx_cession_10);
            var4.addContent(var39);
            var40 = new Element("val_douane_10");
            var40.setText("" + this.val_douane_10);
            var4.addContent(var40);
            var41 = new Element("prx_plage_11");
            var41.setText("" + this.prx_plage_11);
            var4.addContent(var41);
            var42 = new Element("prx_cession_11");
            var42.setText("" + this.prx_cession_11);
            var4.addContent(var42);
            var43 = new Element("val_douane_11");
            var43.setText("" + this.val_douane_11);
            var4.addContent(var43);
            var44 = new Element("prx_plage_12");
            var44.setText("" + this.prx_plage_12);
            var4.addContent(var44);
            var45 = new Element("prx_cession_12");
            var45.setText("" + this.prx_cession_12);
            var4.addContent(var45);
            Element var46 = new Element("val_douane_12");
            var46.setText("" + this.val_douane_12);
            var4.addContent(var46);
            this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml");
         } catch (JDOMException var47) {
         } catch (IOException var48) {
         }
      } else {
         this.racine = new Element("essences");
         this.document = new Document(this.racine);
         Element var49 = new Element("essence");
         this.racine.addContent(var49);
         var4 = new Element("code");
         var4.setText(this.cod);
         var49.addContent(var4);
         var5 = new Element("libelle");
         var5.setText(this.lib);
         var49.addContent(var5);
         var6 = new Element("atibt");
         var6.setText("" + this.atibt);
         var49.addContent(var6);
         var7 = new Element("octra");
         var7.setText("" + this.octra);
         var49.addContent(var7);
         var8 = new Element("export");
         var8.setText("" + this.export);
         var49.addContent(var8);
         var9 = new Element("martelage");
         var9.setText("" + this.martelage);
         var49.addContent(var9);
         var10 = new Element("prx_plage_01");
         var10.setText("" + this.prx_plage_01);
         var49.addContent(var10);
         var11 = new Element("prx_cession_01");
         var11.setText("" + this.prx_cession_01);
         var49.addContent(var11);
         var12 = new Element("val_douane_01");
         var12.setText("" + this.val_douane_01);
         var49.addContent(var12);
         var13 = new Element("prx_plage_02");
         var13.setText("" + this.prx_plage_02);
         var49.addContent(var13);
         var14 = new Element("prx_cession_02");
         var14.setText("" + this.prx_cession_02);
         var49.addContent(var14);
         var15 = new Element("val_douane_02");
         var15.setText("" + this.val_douane_02);
         var49.addContent(var15);
         var16 = new Element("prx_plage_03");
         var16.setText("" + this.prx_plage_03);
         var49.addContent(var16);
         var17 = new Element("prx_cession_03");
         var17.setText("" + this.prx_cession_03);
         var49.addContent(var17);
         var18 = new Element("val_douane_03");
         var18.setText("" + this.val_douane_03);
         var49.addContent(var18);
         var19 = new Element("prx_plage_04");
         var19.setText("" + this.prx_plage_04);
         var49.addContent(var19);
         var20 = new Element("prx_cession_04");
         var20.setText("" + this.prx_cession_04);
         var49.addContent(var20);
         var21 = new Element("val_douane_04");
         var21.setText("" + this.val_douane_04);
         var49.addContent(var21);
         var22 = new Element("prx_plage_05");
         var22.setText("" + this.prx_plage_05);
         var49.addContent(var22);
         var23 = new Element("prx_cession_05");
         var23.setText("" + this.prx_cession_05);
         var49.addContent(var23);
         var24 = new Element("val_douane_05");
         var24.setText("" + this.val_douane_05);
         var49.addContent(var24);
         var25 = new Element("prx_plage_06");
         var25.setText("" + this.prx_plage_06);
         var49.addContent(var25);
         var26 = new Element("prx_cession_06");
         var26.setText("" + this.prx_cession_06);
         var49.addContent(var26);
         var27 = new Element("val_douane_06");
         var27.setText("" + this.val_douane_06);
         var49.addContent(var27);
         var28 = new Element("prx_plage_07");
         var28.setText("" + this.prx_plage_07);
         var49.addContent(var28);
         var29 = new Element("prx_cession_07");
         var29.setText("" + this.prx_cession_07);
         var49.addContent(var29);
         var30 = new Element("val_douane_07");
         var30.setText("" + this.val_douane_07);
         var49.addContent(var30);
         var31 = new Element("prx_plage_08");
         var31.setText("" + this.prx_plage_08);
         var49.addContent(var31);
         var32 = new Element("prx_cession_08");
         var32.setText("" + this.prx_cession_08);
         var49.addContent(var32);
         var33 = new Element("val_douane_08");
         var33.setText("" + this.val_douane_08);
         var49.addContent(var33);
         var34 = new Element("prx_plage_09");
         var34.setText("" + this.prx_plage_09);
         var49.addContent(var34);
         var35 = new Element("prx_cession_09");
         var35.setText("" + this.prx_cession_09);
         var49.addContent(var35);
         var36 = new Element("val_douane_09");
         var36.setText("" + this.val_douane_09);
         var49.addContent(var36);
         var37 = new Element("prx_plage_10");
         var37.setText("" + this.prx_plage_10);
         var49.addContent(var37);
         var38 = new Element("prx_cession_10");
         var38.setText("" + this.prx_cession_10);
         var49.addContent(var38);
         var39 = new Element("val_douane_10");
         var39.setText("" + this.val_douane_10);
         var49.addContent(var39);
         var40 = new Element("prx_plage_11");
         var40.setText("" + this.prx_plage_11);
         var49.addContent(var40);
         var41 = new Element("prx_cession_11");
         var41.setText("" + this.prx_cession_11);
         var49.addContent(var41);
         var42 = new Element("val_douane_11");
         var42.setText("" + this.val_douane_11);
         var49.addContent(var42);
         var43 = new Element("prx_plage_12");
         var43.setText("" + this.prx_plage_12);
         var49.addContent(var43);
         var44 = new Element("prx_cession_12");
         var44.setText("" + this.prx_cession_12);
         var49.addContent(var44);
         var45 = new Element("val_douane_12");
         var45.setText("" + this.val_douane_12);
         var49.addContent(var45);
         this.enregistre(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml");
      }

   }

   public void enregistre(String var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public void modification(String var1) throws JDOMException, IOException {
      SAXBuilder var2 = new SAXBuilder();
      Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml"));
      Element var4 = var3.getRootElement();
      this.listeElement.remove(this.objetEssenceForet.getIndice());
      this.listeElement.add(this.objetEssenceForet.getIndice(), this.objetEssenceForet);
      this.creerArborescenceXml(var4, var3, var1);
   }

   public void creerArborescenceXml(Element var1, Document var2, String var3) throws FileNotFoundException, IOException {
      var1 = var2.getRootElement();
      var1.removeContent();

      for(int var4 = 0; var4 < this.listeElement.size(); ++var4) {
         this.objetEssenceForet = (ObjetEssenceForet)this.listeElement.get(var4);
         Element var5 = new Element("essence");
         Element var6 = new Element("code");
         var6.setText(this.cod);
         var5.addContent(var6);
         Element var7 = new Element("libelle");
         var7.setText(this.lib);
         var5.addContent(var7);
         Element var8 = new Element("atibt");
         var8.setText("" + this.atibt);
         var5.addContent(var8);
         Element var9 = new Element("octra");
         var9.setText("" + this.octra);
         var5.addContent(var9);
         Element var10 = new Element("export");
         var10.setText("" + this.export);
         var5.addContent(var10);
         Element var11 = new Element("martelage");
         var11.setText("" + this.martelage);
         var5.addContent(var11);
         Element var12 = new Element("prx_plage_01");
         var12.setText("" + this.prx_plage_01);
         var5.addContent(var12);
         Element var13 = new Element("prx_cession_01");
         var13.setText("" + this.prx_cession_01);
         var5.addContent(var13);
         Element var14 = new Element("val_douane_01");
         var14.setText("" + this.val_douane_01);
         var5.addContent(var14);
         Element var15 = new Element("prx_plage_02");
         var15.setText("" + this.prx_plage_02);
         var5.addContent(var15);
         Element var16 = new Element("prx_cession_02");
         var16.setText("" + this.prx_cession_02);
         var5.addContent(var16);
         Element var17 = new Element("val_douane_02");
         var17.setText("" + this.val_douane_02);
         var5.addContent(var17);
         Element var18 = new Element("prx_plage_03");
         var18.setText("" + this.prx_plage_03);
         var5.addContent(var18);
         Element var19 = new Element("prx_cession_03");
         var19.setText("" + this.prx_cession_03);
         var5.addContent(var19);
         Element var20 = new Element("val_douane_03");
         var20.setText("" + this.val_douane_03);
         var5.addContent(var20);
         Element var21 = new Element("prx_plage_04");
         var21.setText("" + this.prx_plage_04);
         var5.addContent(var21);
         Element var22 = new Element("prx_cession_04");
         var22.setText("" + this.prx_cession_04);
         var5.addContent(var22);
         Element var23 = new Element("val_douane_04");
         var23.setText("" + this.val_douane_04);
         var5.addContent(var23);
         Element var24 = new Element("prx_plage_05");
         var24.setText("" + this.prx_plage_05);
         var5.addContent(var24);
         Element var25 = new Element("prx_cession_05");
         var25.setText("" + this.prx_cession_05);
         var5.addContent(var25);
         Element var26 = new Element("val_douane_05");
         var26.setText("" + this.val_douane_05);
         var5.addContent(var26);
         Element var27 = new Element("prx_plage_06");
         var27.setText("" + this.prx_plage_06);
         var5.addContent(var27);
         Element var28 = new Element("prx_cession_06");
         var28.setText("" + this.prx_cession_06);
         var5.addContent(var28);
         Element var29 = new Element("val_douane_06");
         var29.setText("" + this.val_douane_06);
         var5.addContent(var29);
         Element var30 = new Element("prx_plage_07");
         var30.setText("" + this.prx_plage_07);
         var5.addContent(var30);
         Element var31 = new Element("prx_cession_07");
         var31.setText("" + this.prx_cession_07);
         var5.addContent(var31);
         Element var32 = new Element("val_douane_07");
         var32.setText("" + this.val_douane_07);
         var5.addContent(var32);
         Element var33 = new Element("prx_plage_08");
         var33.setText("" + this.prx_plage_08);
         var5.addContent(var33);
         Element var34 = new Element("prx_cession_08");
         var34.setText("" + this.prx_cession_08);
         var5.addContent(var34);
         Element var35 = new Element("val_douane_08");
         var35.setText("" + this.val_douane_08);
         var5.addContent(var35);
         Element var36 = new Element("prx_plage_09");
         var36.setText("" + this.prx_plage_09);
         var5.addContent(var36);
         Element var37 = new Element("prx_cession_09");
         var37.setText("" + this.prx_cession_09);
         var5.addContent(var37);
         Element var38 = new Element("val_douane_09");
         var38.setText("" + this.val_douane_09);
         var5.addContent(var38);
         Element var39 = new Element("prx_plage_10");
         var39.setText("" + this.prx_plage_10);
         var5.addContent(var39);
         Element var40 = new Element("prx_cession_10");
         var40.setText("" + this.prx_cession_10);
         var5.addContent(var40);
         Element var41 = new Element("val_douane_10");
         var41.setText("" + this.val_douane_10);
         var5.addContent(var41);
         Element var42 = new Element("prx_plage_11");
         var42.setText("" + this.prx_plage_11);
         var5.addContent(var42);
         Element var43 = new Element("prx_cession_11");
         var43.setText("" + this.prx_cession_11);
         var5.addContent(var43);
         Element var44 = new Element("val_douane_11");
         var44.setText("" + this.val_douane_11);
         var5.addContent(var44);
         Element var45 = new Element("prx_plage_12");
         var45.setText("" + this.prx_plage_12);
         var5.addContent(var45);
         Element var46 = new Element("prx_cession_12");
         var46.setText("" + this.prx_cession_12);
         var5.addContent(var46);
         Element var47 = new Element("val_douane_12");
         var47.setText("" + this.val_douane_12);
         var5.addContent(var47);
         var1.addContent(var5);
      }

      this.enregistreFmtClient(var2, var3);
   }

   public void enregistreFmtClient(Document var1, String var2) throws FileNotFoundException, IOException {
      XMLOutputter var3 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var4 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var2 + ".xml");
      var3.output(var1, var4);
      var4.close();
   }

   public void supprimer(String var1) throws JDOMException, IOException {
      SAXBuilder var2 = new SAXBuilder();
      Document var3 = var2.build(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "foret" + File.separator + "configuration" + File.separator + var1 + ".xml"));
      Element var4 = var3.getRootElement();
      this.listeElement.remove(this.objetEssenceForet.getIndice());
      this.creerArborescenceXml(var4, var3, var1);
   }

   public DataModel getDataModelElement() {
      return this.dataModelElement;
   }

   public void setDataModelElement(DataModel var1) {
      this.dataModelElement = var1;
   }

   public boolean isBtnModClient() {
      return this.btnModClient;
   }

   public void setBtnModClient(boolean var1) {
      this.btnModClient = var1;
   }

   public List getListeElement() {
      return this.listeElement;
   }

   public void setListeElement(List var1) {
      this.listeElement = var1;
   }

   public String getLib() {
      return this.lib;
   }

   public void setLib(String var1) {
      this.lib = var1;
   }

   public boolean isAfficheModePanel() {
      return this.afficheModePanel;
   }

   public void setAfficheModePanel(boolean var1) {
      this.afficheModePanel = var1;
   }

   public boolean isAfficheModePanelAjt() {
      return this.afficheModePanelAjt;
   }

   public void setAfficheModePanelAjt(boolean var1) {
      this.afficheModePanelAjt = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getCod() {
      return this.cod;
   }

   public void setCod(String var1) {
      this.cod = var1;
   }

   public double getAtibt() {
      return this.atibt;
   }

   public void setAtibt(double var1) {
      this.atibt = var1;
   }

   public double getExport() {
      return this.export;
   }

   public void setExport(double var1) {
      this.export = var1;
   }

   public double getMartelage() {
      return this.martelage;
   }

   public void setMartelage(double var1) {
      this.martelage = var1;
   }

   public ObjetEssenceForet getObjetEssenceForet() {
      return this.objetEssenceForet;
   }

   public void setObjetEssenceForet(ObjetEssenceForet var1) {
      this.objetEssenceForet = var1;
   }

   public double getOctra() {
      return this.octra;
   }

   public void setOctra(double var1) {
      this.octra = var1;
   }

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public double getPrx_cession_01() {
      return this.prx_cession_01;
   }

   public void setPrx_cession_01(double var1) {
      this.prx_cession_01 = var1;
   }

   public double getPrx_cession_02() {
      return this.prx_cession_02;
   }

   public void setPrx_cession_02(double var1) {
      this.prx_cession_02 = var1;
   }

   public double getPrx_cession_03() {
      return this.prx_cession_03;
   }

   public void setPrx_cession_03(double var1) {
      this.prx_cession_03 = var1;
   }

   public double getPrx_cession_04() {
      return this.prx_cession_04;
   }

   public void setPrx_cession_04(double var1) {
      this.prx_cession_04 = var1;
   }

   public double getPrx_cession_05() {
      return this.prx_cession_05;
   }

   public void setPrx_cession_05(double var1) {
      this.prx_cession_05 = var1;
   }

   public double getPrx_cession_06() {
      return this.prx_cession_06;
   }

   public void setPrx_cession_06(double var1) {
      this.prx_cession_06 = var1;
   }

   public double getPrx_cession_07() {
      return this.prx_cession_07;
   }

   public void setPrx_cession_07(double var1) {
      this.prx_cession_07 = var1;
   }

   public double getPrx_cession_08() {
      return this.prx_cession_08;
   }

   public void setPrx_cession_08(double var1) {
      this.prx_cession_08 = var1;
   }

   public double getPrx_cession_09() {
      return this.prx_cession_09;
   }

   public void setPrx_cession_09(double var1) {
      this.prx_cession_09 = var1;
   }

   public double getPrx_cession_10() {
      return this.prx_cession_10;
   }

   public void setPrx_cession_10(double var1) {
      this.prx_cession_10 = var1;
   }

   public double getPrx_cession_11() {
      return this.prx_cession_11;
   }

   public void setPrx_cession_11(double var1) {
      this.prx_cession_11 = var1;
   }

   public double getPrx_cession_12() {
      return this.prx_cession_12;
   }

   public void setPrx_cession_12(double var1) {
      this.prx_cession_12 = var1;
   }

   public double getPrx_plage_01() {
      return this.prx_plage_01;
   }

   public void setPrx_plage_01(double var1) {
      this.prx_plage_01 = var1;
   }

   public double getPrx_plage_02() {
      return this.prx_plage_02;
   }

   public void setPrx_plage_02(double var1) {
      this.prx_plage_02 = var1;
   }

   public double getPrx_plage_03() {
      return this.prx_plage_03;
   }

   public void setPrx_plage_03(double var1) {
      this.prx_plage_03 = var1;
   }

   public double getPrx_plage_04() {
      return this.prx_plage_04;
   }

   public void setPrx_plage_04(double var1) {
      this.prx_plage_04 = var1;
   }

   public double getPrx_plage_05() {
      return this.prx_plage_05;
   }

   public void setPrx_plage_05(double var1) {
      this.prx_plage_05 = var1;
   }

   public double getPrx_plage_06() {
      return this.prx_plage_06;
   }

   public void setPrx_plage_06(double var1) {
      this.prx_plage_06 = var1;
   }

   public double getPrx_plage_07() {
      return this.prx_plage_07;
   }

   public void setPrx_plage_07(double var1) {
      this.prx_plage_07 = var1;
   }

   public double getPrx_plage_08() {
      return this.prx_plage_08;
   }

   public void setPrx_plage_08(double var1) {
      this.prx_plage_08 = var1;
   }

   public double getPrx_plage_09() {
      return this.prx_plage_09;
   }

   public void setPrx_plage_09(double var1) {
      this.prx_plage_09 = var1;
   }

   public double getPrx_plage_10() {
      return this.prx_plage_10;
   }

   public void setPrx_plage_10(double var1) {
      this.prx_plage_10 = var1;
   }

   public double getPrx_plage_11() {
      return this.prx_plage_11;
   }

   public void setPrx_plage_11(double var1) {
      this.prx_plage_11 = var1;
   }

   public double getPrx_plage_12() {
      return this.prx_plage_12;
   }

   public void setPrx_plage_12(double var1) {
      this.prx_plage_12 = var1;
   }

   public double getVal_douane_01() {
      return this.val_douane_01;
   }

   public void setVal_douane_01(double var1) {
      this.val_douane_01 = var1;
   }

   public double getVal_douane_02() {
      return this.val_douane_02;
   }

   public void setVal_douane_02(double var1) {
      this.val_douane_02 = var1;
   }

   public double getVal_douane_03() {
      return this.val_douane_03;
   }

   public void setVal_douane_03(double var1) {
      this.val_douane_03 = var1;
   }

   public double getVal_douane_04() {
      return this.val_douane_04;
   }

   public void setVal_douane_04(double var1) {
      this.val_douane_04 = var1;
   }

   public double getVal_douane_05() {
      return this.val_douane_05;
   }

   public void setVal_douane_05(double var1) {
      this.val_douane_05 = var1;
   }

   public double getVal_douane_06() {
      return this.val_douane_06;
   }

   public void setVal_douane_06(double var1) {
      this.val_douane_06 = var1;
   }

   public double getVal_douane_07() {
      return this.val_douane_07;
   }

   public void setVal_douane_07(double var1) {
      this.val_douane_07 = var1;
   }

   public double getVal_douane_08() {
      return this.val_douane_08;
   }

   public void setVal_douane_08(double var1) {
      this.val_douane_08 = var1;
   }

   public double getVal_douane_09() {
      return this.val_douane_09;
   }

   public void setVal_douane_09(double var1) {
      this.val_douane_09 = var1;
   }

   public double getVal_douane_10() {
      return this.val_douane_10;
   }

   public void setVal_douane_10(double var1) {
      this.val_douane_10 = var1;
   }

   public double getVal_douane_11() {
      return this.val_douane_11;
   }

   public void setVal_douane_11(double var1) {
      this.val_douane_11 = var1;
   }

   public double getVal_douane_12() {
      return this.val_douane_12;
   }

   public void setVal_douane_12(double var1) {
      this.val_douane_12 = var1;
   }
}
