package com.epegase.forms.administration;

import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.model.DataModel;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormOptionComptabilite implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionComptabilite optionComptabilite = new OptionComptabilite();
   private Element racine = new Element("option_compta");
   private Document document;
   private long idStructure;
   private boolean griserNbrCarNumCpte;
   private transient DataModel mesClassesAnalytiques;
   private transient DataModel mesClassesBudgets;
   private transient DataModel mesCentralisations;
   private ObjetCompte objetCompte;
   private boolean majOptionAchats;
   private boolean majOptionVentes;
   private boolean majOptionMedical;
   private UploadedFile uploadedFile;

   public FormOptionComptabilite() throws SAXException {
      this.document = new Document(this.racine);
   }

   public void parcourrir() throws IOException {
      if (this.uploadedFile != null) {
         File var1 = new File(this.uploadedFile.getName());
         this.optionComptabilite.setDossierExport(var1.getAbsolutePath().toString());
      }

   }

   public void creerOptioncompta() throws IOException, SAXException {
      this.racine.removeContent();
      Element var1 = new Element("nbcr");
      this.racine.addContent(var1);
      var1.setText(this.optionComptabilite.getNbcr());
      Element var2 = new Element("nbcrExport");
      this.racine.addContent(var2);
      var2.setText(this.optionComptabilite.getNbcrExport());
      Element var3 = new Element("calculCompte");
      this.racine.addContent(var3);
      var3.setText(this.optionComptabilite.getCalculCompte());
      Element var4 = new Element("typelib");
      this.racine.addContent(var4);
      var4.setText(this.optionComptabilite.getTypelib());
      Element var5 = new Element("tri_jrx");
      this.racine.addContent(var5);
      var5.setText(this.optionComptabilite.getTri_jrx());
      Element var6 = new Element("tri_extrait");
      this.racine.addContent(var6);
      var6.setText(this.optionComptabilite.getTri_extrait());
      Element var7 = new Element("trf_brl");
      this.racine.addContent(var7);
      var7.setText(this.optionComptabilite.getTrf_brl());
      Element var8 = new Element("trf_cpte");
      this.racine.addContent(var8);
      var8.setText(this.optionComptabilite.getTrf_cpte());
      Element var9 = new Element("trf_cpteAchats");
      this.racine.addContent(var9);
      var9.setText(this.optionComptabilite.getTrf_cpteAchats());
      Element var10 = new Element("trf_cpteVentes");
      this.racine.addContent(var10);
      var10.setText(this.optionComptabilite.getTrf_cpteVentes());
      Element var11 = new Element("trf_cptePaye");
      this.racine.addContent(var11);
      var11.setText(this.optionComptabilite.getTrf_cptePaye());
      Element var12 = new Element("trf_cpteImmo");
      this.racine.addContent(var12);
      var12.setText(this.optionComptabilite.getTrf_cpteImmo());
      Element var13 = new Element("trf_cpteTreso");
      this.racine.addContent(var13);
      var13.setText(this.optionComptabilite.getTrf_cpteTreso());
      Element var14 = new Element("exportOd");
      this.racine.addContent(var14);
      var14.setText(this.optionComptabilite.getExportOd());
      Element var15 = new Element("verrouImport");
      this.racine.addContent(var15);
      var15.setText(this.optionComptabilite.getVerrouImport());
      Element var16 = new Element("brouillardImport");
      this.racine.addContent(var16);
      var16.setText(this.optionComptabilite.getBrouillardImport());
      Element var17 = new Element("clotureSansControle");
      this.racine.addContent(var17);
      var17.setText(this.optionComptabilite.getClotureSansControle());
      Element var18 = new Element("clotureSansRappro");
      this.racine.addContent(var18);
      var18.setText(this.optionComptabilite.getClotureSansRappro());
      Element var19 = new Element("clotureLettrageInutile");
      this.racine.addContent(var19);
      var19.setText(this.optionComptabilite.getClotureLettrageInutile());
      Element var20 = new Element("clotureLettrage");
      this.racine.addContent(var20);
      var20.setText(this.optionComptabilite.getClotureLettrage());
      Element var21 = new Element("clotureBackup");
      this.racine.addContent(var21);
      var21.setText(this.optionComptabilite.getClotureBackup());
      Element var22 = new Element("ecartDebit");
      this.racine.addContent(var22);
      var22.setText(this.optionComptabilite.getEcartDebit());
      Element var23 = new Element("ecartCredit");
      this.racine.addContent(var23);
      var23.setText(this.optionComptabilite.getEcartCredit());
      Element var24 = new Element("trf_rapprochement");
      this.racine.addContent(var24);
      var24.setText(this.optionComptabilite.getTrf_rapprochement());
      Element var25 = new Element("trf_rapprochementMode");
      this.racine.addContent(var25);
      var25.setText(this.optionComptabilite.getTrf_rapprochementMode());
      Element var26 = new Element("analytique");
      this.racine.addContent(var26);
      var26.setText(this.optionComptabilite.getAnalytique());
      Element var27 = new Element("saisieAnalytique");
      this.racine.addContent(var27);
      var27.setText(this.optionComptabilite.getSaisieAnalytique());
      Element var28 = new Element("analytiqueErreur");
      this.racine.addContent(var28);
      var28.setText(this.optionComptabilite.getAnalytiqueErreur());
      Element var29 = new Element("analytiqueTransfert");
      this.racine.addContent(var29);
      var29.setText(this.optionComptabilite.getAnalytiqueTransfert());
      Element var30 = new Element("anal_c1");
      this.racine.addContent(var30);
      this.mesClassesAnalytiques.setRowIndex(0);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var30.setText("" + this.objetCompte.isValide());
      Element var31 = new Element("anal_c2");
      this.racine.addContent(var31);
      this.mesClassesAnalytiques.setRowIndex(1);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var31.setText("" + this.objetCompte.isValide());
      Element var32 = new Element("anal_c3");
      this.racine.addContent(var32);
      this.mesClassesAnalytiques.setRowIndex(2);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var32.setText("" + this.objetCompte.isValide());
      Element var33 = new Element("anal_c4");
      this.racine.addContent(var33);
      this.mesClassesAnalytiques.setRowIndex(3);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var33.setText("" + this.objetCompte.isValide());
      Element var34 = new Element("anal_c5");
      this.racine.addContent(var34);
      this.mesClassesAnalytiques.setRowIndex(4);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var34.setText("" + this.objetCompte.isValide());
      Element var35 = new Element("anal_c6");
      this.racine.addContent(var35);
      this.mesClassesAnalytiques.setRowIndex(5);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var35.setText("" + this.objetCompte.isValide());
      Element var36 = new Element("anal_c7");
      this.racine.addContent(var36);
      this.mesClassesAnalytiques.setRowIndex(6);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var36.setText("" + this.objetCompte.isValide());
      Element var37 = new Element("anal_c8");
      this.racine.addContent(var37);
      this.mesClassesAnalytiques.setRowIndex(7);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var37.setText("" + this.objetCompte.isValide());
      Element var38 = new Element("anal_c9");
      this.racine.addContent(var38);
      this.mesClassesAnalytiques.setRowIndex(8);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var38.setText("" + this.objetCompte.isValide());
      Element var39 = new Element("anal_c10");
      this.racine.addContent(var39);
      this.mesClassesAnalytiques.setRowIndex(9);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var39.setText("" + this.objetCompte.isValide());
      Element var40 = new Element("anal_c11");
      this.racine.addContent(var40);
      this.mesClassesAnalytiques.setRowIndex(10);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var40.setText("" + this.objetCompte.isValide());
      Element var41 = new Element("anal_c12");
      this.racine.addContent(var41);
      this.mesClassesAnalytiques.setRowIndex(11);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var41.setText("" + this.objetCompte.isValide());
      Element var42 = new Element("anal_c13");
      this.racine.addContent(var42);
      this.mesClassesAnalytiques.setRowIndex(12);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var42.setText("" + this.objetCompte.isValide());
      Element var43 = new Element("anal_c14");
      this.racine.addContent(var43);
      this.mesClassesAnalytiques.setRowIndex(13);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var43.setText("" + this.objetCompte.isValide());
      Element var44 = new Element("anal_c15");
      this.racine.addContent(var44);
      this.mesClassesAnalytiques.setRowIndex(14);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var44.setText("" + this.objetCompte.isValide());
      Element var45 = new Element("anal_c16");
      this.racine.addContent(var45);
      this.mesClassesAnalytiques.setRowIndex(15);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var45.setText("" + this.objetCompte.isValide());
      Element var46 = new Element("anal_c17");
      this.racine.addContent(var46);
      this.mesClassesAnalytiques.setRowIndex(16);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var46.setText("" + this.objetCompte.isValide());
      Element var47 = new Element("anal_c18");
      this.racine.addContent(var47);
      this.mesClassesAnalytiques.setRowIndex(17);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var47.setText("" + this.objetCompte.isValide());
      Element var48 = new Element("anal_c19");
      this.racine.addContent(var48);
      this.mesClassesAnalytiques.setRowIndex(18);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var48.setText("" + this.objetCompte.isValide());
      Element var49 = new Element("anal_c20");
      this.racine.addContent(var49);
      this.mesClassesAnalytiques.setRowIndex(19);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var49.setText("" + this.objetCompte.isValide());
      Element var50 = new Element("anal_c21");
      this.racine.addContent(var50);
      this.mesClassesAnalytiques.setRowIndex(20);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var50.setText("" + this.objetCompte.isValide());
      Element var51 = new Element("anal_c22");
      this.racine.addContent(var51);
      this.mesClassesAnalytiques.setRowIndex(21);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var51.setText("" + this.objetCompte.isValide());
      Element var52 = new Element("anal_c23");
      this.racine.addContent(var52);
      this.mesClassesAnalytiques.setRowIndex(22);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var52.setText("" + this.objetCompte.isValide());
      Element var53 = new Element("anal_c24");
      this.racine.addContent(var53);
      this.mesClassesAnalytiques.setRowIndex(23);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var53.setText("" + this.objetCompte.isValide());
      Element var54 = new Element("tresorerie");
      this.racine.addContent(var54);
      var54.setText(this.optionComptabilite.getTresorerie());
      Element var55 = new Element("budget");
      this.racine.addContent(var55);
      var55.setText(this.optionComptabilite.getBudget());
      Element var56 = new Element("bud_c1");
      this.racine.addContent(var56);
      this.mesClassesBudgets.setRowIndex(0);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var56.setText("" + this.objetCompte.isValide());
      Element var57 = new Element("bud_c2");
      this.racine.addContent(var57);
      this.mesClassesBudgets.setRowIndex(1);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var57.setText("" + this.objetCompte.isValide());
      Element var58 = new Element("bud_c3");
      this.racine.addContent(var58);
      this.mesClassesBudgets.setRowIndex(2);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var58.setText("" + this.objetCompte.isValide());
      Element var59 = new Element("bud_c4");
      this.racine.addContent(var59);
      this.mesClassesBudgets.setRowIndex(3);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var59.setText("" + this.objetCompte.isValide());
      Element var60 = new Element("bud_c5");
      this.racine.addContent(var60);
      this.mesClassesBudgets.setRowIndex(4);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var60.setText("" + this.objetCompte.isValide());
      Element var61 = new Element("bud_c6");
      this.racine.addContent(var61);
      this.mesClassesBudgets.setRowIndex(5);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var61.setText("" + this.objetCompte.isValide());
      Element var62 = new Element("bud_c7");
      this.racine.addContent(var62);
      this.mesClassesBudgets.setRowIndex(6);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var62.setText("" + this.objetCompte.isValide());
      Element var63 = new Element("bud_c8");
      this.racine.addContent(var63);
      this.mesClassesBudgets.setRowIndex(7);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var63.setText("" + this.objetCompte.isValide());
      Element var64 = new Element("bud_c9");
      this.racine.addContent(var64);
      this.mesClassesBudgets.setRowIndex(8);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var64.setText("" + this.objetCompte.isValide());
      Element var65 = new Element("bud_c10");
      this.racine.addContent(var65);
      this.mesClassesBudgets.setRowIndex(9);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var65.setText("" + this.objetCompte.isValide());
      Element var66 = new Element("bud_c11");
      this.racine.addContent(var66);
      this.mesClassesBudgets.setRowIndex(10);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var66.setText("" + this.objetCompte.isValide());
      Element var67 = new Element("bud_c12");
      this.racine.addContent(var67);
      this.mesClassesAnalytiques.setRowIndex(11);
      this.objetCompte = (ObjetCompte)this.mesClassesAnalytiques.getRowData();
      var67.setText("" + this.objetCompte.isValide());
      Element var68 = new Element("bud_c13");
      this.racine.addContent(var68);
      this.mesClassesBudgets.setRowIndex(12);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var68.setText("" + this.objetCompte.isValide());
      Element var69 = new Element("bud_c14");
      this.racine.addContent(var69);
      this.mesClassesBudgets.setRowIndex(13);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var69.setText("" + this.objetCompte.isValide());
      Element var70 = new Element("bud_c15");
      this.racine.addContent(var70);
      this.mesClassesBudgets.setRowIndex(14);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var70.setText("" + this.objetCompte.isValide());
      Element var71 = new Element("bud_c16");
      this.racine.addContent(var71);
      this.mesClassesBudgets.setRowIndex(15);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var71.setText("" + this.objetCompte.isValide());
      Element var72 = new Element("bud_c17");
      this.racine.addContent(var72);
      this.mesClassesBudgets.setRowIndex(16);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var72.setText("" + this.objetCompte.isValide());
      Element var73 = new Element("bud_c18");
      this.racine.addContent(var73);
      this.mesClassesBudgets.setRowIndex(17);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var73.setText("" + this.objetCompte.isValide());
      Element var74 = new Element("bud_c19");
      this.racine.addContent(var74);
      this.mesClassesBudgets.setRowIndex(18);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var74.setText("" + this.objetCompte.isValide());
      Element var75 = new Element("bud_c20");
      this.racine.addContent(var75);
      this.mesClassesBudgets.setRowIndex(19);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var75.setText("" + this.objetCompte.isValide());
      Element var76 = new Element("bud_c21");
      this.racine.addContent(var76);
      this.mesClassesBudgets.setRowIndex(20);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var76.setText("" + this.objetCompte.isValide());
      Element var77 = new Element("bud_c22");
      this.racine.addContent(var77);
      this.mesClassesBudgets.setRowIndex(21);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var77.setText("" + this.objetCompte.isValide());
      Element var78 = new Element("bud_c23");
      this.racine.addContent(var78);
      this.mesClassesBudgets.setRowIndex(22);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var78.setText("" + this.objetCompte.isValide());
      Element var79 = new Element("bud_c24");
      this.racine.addContent(var79);
      this.mesClassesBudgets.setRowIndex(23);
      this.objetCompte = (ObjetCompte)this.mesClassesBudgets.getRowData();
      var79.setText("" + this.objetCompte.isValide());
      Element var80 = new Element("cen_c20");
      this.racine.addContent(var80);
      this.mesCentralisations.setRowIndex(0);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var80.setText("" + this.objetCompte.isValide());
      Element var81 = new Element("cen_c21");
      this.racine.addContent(var81);
      this.mesCentralisations.setRowIndex(1);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var81.setText("" + this.objetCompte.isValide());
      Element var82 = new Element("cen_c22");
      this.racine.addContent(var82);
      this.mesCentralisations.setRowIndex(2);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var82.setText("" + this.objetCompte.isValide());
      Element var83 = new Element("cen_c23");
      this.racine.addContent(var83);
      this.mesCentralisations.setRowIndex(3);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var83.setText("" + this.objetCompte.isValide());
      Element var84 = new Element("cen_c24");
      this.racine.addContent(var84);
      this.mesCentralisations.setRowIndex(4);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var84.setText("" + this.objetCompte.isValide());
      Element var85 = new Element("cen_c25");
      this.racine.addContent(var85);
      this.mesCentralisations.setRowIndex(5);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var85.setText("" + this.objetCompte.isValide());
      Element var86 = new Element("cen_c26");
      this.racine.addContent(var86);
      this.mesCentralisations.setRowIndex(6);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var86.setText("" + this.objetCompte.isValide());
      Element var87 = new Element("cen_c27");
      this.racine.addContent(var87);
      this.mesCentralisations.setRowIndex(7);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var87.setText("" + this.objetCompte.isValide());
      Element var88 = new Element("cen_c28");
      this.racine.addContent(var88);
      this.mesCentralisations.setRowIndex(8);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var88.setText("" + this.objetCompte.isValide());
      Element var89 = new Element("cen_c29");
      this.racine.addContent(var89);
      this.mesCentralisations.setRowIndex(9);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var89.setText("" + this.objetCompte.isValide());
      Element var90 = new Element("cen_c30");
      this.racine.addContent(var90);
      this.mesCentralisations.setRowIndex(10);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var90.setText("" + this.objetCompte.isValide());
      Element var91 = new Element("cen_c31");
      this.racine.addContent(var91);
      this.mesCentralisations.setRowIndex(11);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var91.setText("" + this.objetCompte.isValide());
      Element var92 = new Element("cen_c32");
      this.racine.addContent(var92);
      this.mesCentralisations.setRowIndex(12);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var92.setText("" + this.objetCompte.isValide());
      Element var93 = new Element("cen_c33");
      this.racine.addContent(var93);
      this.mesCentralisations.setRowIndex(13);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var93.setText("" + this.objetCompte.isValide());
      Element var94 = new Element("cen_c34");
      this.racine.addContent(var94);
      this.mesCentralisations.setRowIndex(14);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var94.setText("" + this.objetCompte.isValide());
      Element var95 = new Element("cen_c35");
      this.racine.addContent(var95);
      this.mesCentralisations.setRowIndex(15);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var95.setText("" + this.objetCompte.isValide());
      Element var96 = new Element("cen_c36");
      this.racine.addContent(var96);
      this.mesCentralisations.setRowIndex(16);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var96.setText("" + this.objetCompte.isValide());
      Element var97 = new Element("cen_c37");
      this.racine.addContent(var97);
      this.mesCentralisations.setRowIndex(17);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var97.setText("" + this.objetCompte.isValide());
      Element var98 = new Element("cen_c38");
      this.racine.addContent(var98);
      this.mesCentralisations.setRowIndex(18);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var98.setText("" + this.objetCompte.isValide());
      Element var99 = new Element("cen_c39");
      this.racine.addContent(var99);
      this.mesCentralisations.setRowIndex(19);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var99.setText("" + this.objetCompte.isValide());
      Element var100 = new Element("cen_c40");
      this.racine.addContent(var100);
      this.mesCentralisations.setRowIndex(20);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var100.setText("" + this.objetCompte.isValide());
      Element var101 = new Element("cen_c41");
      this.racine.addContent(var101);
      this.mesCentralisations.setRowIndex(21);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var101.setText("" + this.objetCompte.isValide());
      Element var102 = new Element("cen_c42");
      this.racine.addContent(var102);
      this.mesCentralisations.setRowIndex(22);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var102.setText("" + this.objetCompte.isValide());
      Element var103 = new Element("cen_c43");
      this.racine.addContent(var103);
      this.mesCentralisations.setRowIndex(23);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var103.setText("" + this.objetCompte.isValide());
      Element var104 = new Element("cen_c44");
      this.racine.addContent(var104);
      this.mesCentralisations.setRowIndex(24);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var104.setText("" + this.objetCompte.isValide());
      Element var105 = new Element("cen_c45");
      this.racine.addContent(var105);
      this.mesCentralisations.setRowIndex(25);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var105.setText("" + this.objetCompte.isValide());
      Element var106 = new Element("cen_c46");
      this.racine.addContent(var106);
      this.mesCentralisations.setRowIndex(26);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var106.setText("" + this.objetCompte.isValide());
      Element var107 = new Element("cen_c47");
      this.racine.addContent(var107);
      this.mesCentralisations.setRowIndex(27);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var107.setText("" + this.objetCompte.isValide());
      Element var108 = new Element("cen_c48");
      this.racine.addContent(var108);
      this.mesCentralisations.setRowIndex(28);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var108.setText("" + this.objetCompte.isValide());
      Element var109 = new Element("cen_c49");
      this.racine.addContent(var109);
      this.mesCentralisations.setRowIndex(29);
      this.objetCompte = (ObjetCompte)this.mesCentralisations.getRowData();
      var109.setText("" + this.objetCompte.isValide());
      Element var110 = new Element("ContrePartie");
      this.racine.addContent(var110);
      var110.setText(this.optionComptabilite.getColContrePartie());
      Element var111 = new Element("NumReference1");
      this.racine.addContent(var111);
      var111.setText(this.optionComptabilite.getColNumReference1());
      Element var112 = new Element("NumReference2");
      this.racine.addContent(var112);
      var112.setText(this.optionComptabilite.getColNumReference2());
      Element var113 = new Element("nbLigneMaxAm");
      this.racine.addContent(var113);
      var113.setText(this.optionComptabilite.getNbLigneMaxAm());
      Element var114 = new Element("nbLigneMaxLo");
      this.racine.addContent(var114);
      var114.setText(this.optionComptabilite.getNbLigneMaxLo());
      Element var115 = new Element("nbLigneMaxBu");
      this.racine.addContent(var115);
      var115.setText(this.optionComptabilite.getNbLigneMaxBu());
      Element var116 = new Element("nbLigneMaxEx");
      this.racine.addContent(var116);
      var116.setText(this.optionComptabilite.getNbLigneMaxEx());
      Element var117 = new Element("nbLigneMaxJr");
      this.racine.addContent(var117);
      var117.setText(this.optionComptabilite.getNbLigneMaxJr());
      Element var118 = new Element("nbLigneMaxBr");
      this.racine.addContent(var118);
      var118.setText(this.optionComptabilite.getNbLigneMaxBr());
      Element var119 = new Element("dossierExport");
      this.racine.addContent(var119);
      var119.setText(this.optionComptabilite.getDossierExport());
      Element var120 = new Element("planCpteLiasse");
      this.racine.addContent(var120);
      var120.setText(this.optionComptabilite.getPlanCpteLiasse());
      Element var121 = new Element("calculImmobilisation");
      this.racine.addContent(var121);
      var121.setText(this.optionComptabilite.getCalculImmobilisation());
      Element var122 = new Element("mailClotureRappro");
      this.racine.addContent(var122);
      var122.setText(this.optionComptabilite.getMailClotureRappro());
      Element var123 = new Element("mailClotureJournal");
      this.racine.addContent(var123);
      var123.setText(this.optionComptabilite.getMailClotureJournal());
      this.enregistre();
   }

   public void enregistre() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "compta" + File.separator + "configuration" + File.separator + "optioncomptabilite.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public boolean isGriserNbrCarNumCpte() {
      return this.griserNbrCarNumCpte;
   }

   public void setGriserNbrCarNumCpte(boolean var1) {
      this.griserNbrCarNumCpte = var1;
   }

   public long getIdStructure() {
      return this.idStructure;
   }

   public void setIdStructure(long var1) {
      this.idStructure = var1;
   }

   public boolean isMajOptionAchats() {
      return this.majOptionAchats;
   }

   public void setMajOptionAchats(boolean var1) {
      this.majOptionAchats = var1;
   }

   public boolean isMajOptionVentes() {
      return this.majOptionVentes;
   }

   public void setMajOptionVentes(boolean var1) {
      this.majOptionVentes = var1;
   }

   public DataModel getMesClassesAnalytiques() {
      return this.mesClassesAnalytiques;
   }

   public void setMesClassesAnalytiques(DataModel var1) {
      this.mesClassesAnalytiques = var1;
   }

   public DataModel getMesClassesBudgets() {
      return this.mesClassesBudgets;
   }

   public void setMesClassesBudgets(DataModel var1) {
      this.mesClassesBudgets = var1;
   }

   public ObjetCompte getObjetCompte() {
      return this.objetCompte;
   }

   public void setObjetCompte(ObjetCompte var1) {
      this.objetCompte = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public boolean isMajOptionMedical() {
      return this.majOptionMedical;
   }

   public void setMajOptionMedical(boolean var1) {
      this.majOptionMedical = var1;
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

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public DataModel getMesCentralisations() {
      return this.mesCentralisations;
   }

   public void setMesCentralisations(DataModel var1) {
      this.mesCentralisations = var1;
   }
}
