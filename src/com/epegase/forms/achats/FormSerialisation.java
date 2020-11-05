package com.epegase.forms.achats;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.ReceptionSerieAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.FiltreSimple;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ReceptionSerieAchatsDao;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import javax.swing.JFileChooser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;
import org.xml.sax.SAXException;

public class FormSerialisation {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats lastExoAchats;
   private int var_nb_max = 100;
   private boolean accesProduits;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_special = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_prp = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean visibleOngleEntete;
   private boolean visibiliteBton = false;
   private boolean champ1 = false;
   private boolean champ2 = false;
   private boolean champ3 = false;
   private boolean champ4 = false;
   private boolean champ5 = false;
   private boolean champ6 = false;
   private boolean champ7 = false;
   private boolean champ8 = false;
   private boolean champ9 = false;
   private boolean champ10 = false;
   private boolean champ11 = false;
   private boolean champ12 = false;
   private boolean champ13 = false;
   private boolean champ14 = false;
   private boolean champ15 = false;
   private boolean champ16 = false;
   private boolean champ17 = false;
   private boolean champ18 = false;
   private boolean champ19 = false;
   private boolean champ20 = false;
   private int inpEtat = 0;
   private String inpNum = "";
   private String inpCarton = "";
   private String inpPalette = "";
   private String inpLot = "";
   private List mesCartonsItem = new ArrayList();
   private List mesPalettesItem = new ArrayList();
   private List mesLotsItem = new ArrayList();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private Date inpDu = null;
   private Date inpAu = null;
   private String inpService = "100";
   private String periode;
   private boolean var_more_search = false;
   private int var_choix_importation;
   private List lesNumerosSerie = new ArrayList();
   private transient DataModel dataModelSerie = new ListDataModel();
   private ReceptionSerieAchats receptionSerieAchats;
   private ReceptionSerieAchatsDao receptionSerieAchatsDao;
   private transient DataModel dataModelLot = new ListDataModel();
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private PlansAnalytiques plansAnalytiques;
   private List lesNumerosLots = new ArrayList();

   public void InstancesDaoUtilses() {
      this.receptionSerieAchatsDao = new ReceptionSerieAchatsDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats() {
      if (!this.optionAchats.getLib1().isEmpty() && !this.optionAchats.getLib2().isEmpty() && !this.optionAchats.getLib3().isEmpty() && !this.optionAchats.getLib4().isEmpty() && !this.optionAchats.getLib5().isEmpty() && !this.optionAchats.getLib6().isEmpty() && !this.optionAchats.getLib7().isEmpty() && !this.optionAchats.getLib8().isEmpty() && !this.optionAchats.getLib9().isEmpty() && !this.optionAchats.getLib10().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionAchats.getSerie1() != null && !this.optionAchats.getSerie1().isEmpty()) {
         this.champ1 = true;
      }

      if (this.optionAchats.getSerie2() != null && !this.optionAchats.getSerie2().isEmpty()) {
         this.champ2 = true;
      }

      if (this.optionAchats.getSerie3() != null && !this.optionAchats.getSerie3().isEmpty()) {
         this.champ3 = true;
      }

      if (this.optionAchats.getSerie4() != null && !this.optionAchats.getSerie4().isEmpty()) {
         this.champ4 = true;
      }

      if (this.optionAchats.getSerie5() != null && !this.optionAchats.getSerie5().isEmpty()) {
         this.champ5 = true;
      }

      if (this.optionAchats.getSerie6() != null && !this.optionAchats.getSerie6().isEmpty()) {
         this.champ6 = true;
      }

      if (this.optionAchats.getSerie7() != null && !this.optionAchats.getSerie7().isEmpty()) {
         this.champ7 = true;
      }

      if (this.optionAchats.getSerie8() != null && !this.optionAchats.getSerie8().isEmpty()) {
         this.champ8 = true;
      }

      if (this.optionAchats.getSerie9() != null && !this.optionAchats.getSerie9().isEmpty()) {
         this.champ9 = true;
      }

      if (this.optionAchats.getSerie10() != null && !this.optionAchats.getSerie10().isEmpty()) {
         this.champ10 = true;
      }

      if (this.optionAchats.getSerie11() != null && !this.optionAchats.getSerie11().isEmpty()) {
         this.champ11 = true;
      }

      if (this.optionAchats.getSerie12() != null && !this.optionAchats.getSerie12().isEmpty()) {
         this.champ12 = true;
      }

      if (this.optionAchats.getSerie13() != null && !this.optionAchats.getSerie13().isEmpty()) {
         this.champ13 = true;
      }

      if (this.optionAchats.getSerie14() != null && !this.optionAchats.getSerie14().isEmpty()) {
         this.champ14 = true;
      }

      if (this.optionAchats.getSerie15() != null && !this.optionAchats.getSerie15().isEmpty()) {
         this.champ15 = true;
      }

      if (this.optionAchats.getSerie16() != null && !this.optionAchats.getSerie16().isEmpty()) {
         this.champ16 = true;
      }

      if (this.optionAchats.getSerie17() != null && !this.optionAchats.getSerie17().isEmpty()) {
         this.champ17 = true;
      }

      if (this.optionAchats.getSerie18() != null && !this.optionAchats.getSerie18().isEmpty()) {
         this.champ18 = true;
      }

      if (this.optionAchats.getSerie19() != null && !this.optionAchats.getSerie19().isEmpty()) {
         this.champ19 = true;
      }

      if (this.optionAchats.getSerie20() != null && !this.optionAchats.getSerie20().isEmpty()) {
         this.champ20 = true;
      }

      if (this.optionAchats.getNbLigneMax() != null && !this.optionAchats.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionAchats.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.initPage();
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrProdServiceAch() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
      }

      this.visibiliteBton = false;
   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_reglement = false;
      this.var_acc_special = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_prp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_acc_document = true;
            } else if (var1.getCode().equals("52")) {
               this.var_acc_imputation = true;
            } else if (var1.getCode().equals("53")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("54")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("55")) {
               this.var_acc_special = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("60")) {
               this.var_acc_prp = true;
            }
         }
      }

   }

   public void autorisationDocument() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationImputation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("52")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationComplement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("53")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationReglement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("54")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationSpecial() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("55")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationHabilitation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("56")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationEtat() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("57")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationTracabilite() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("58")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationPrp() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("60")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void initPage() {
      this.var_action = 0;
      this.inpEtat = 0;
      this.lesNumerosSerie.clear();
   }

   public void selectionFichier() throws IOException, SAXException, NamingException {
      FiltreSimple var2 = new FiltreSimple("Fichiers CSV", ".csv");
      JFileChooser var3 = new JFileChooser();
      var3.addChoosableFileFilter(var2);
      var3.setVisible(true);
      var3.setDialogTitle("Importation N° de séries (fichier .CSV)");
      var3.setDragEnabled(true);
      int var4 = var3.showOpenDialog((Component)null);
      if (var4 == 0) {
         File var1 = var3.getSelectedFile();
         this.importLocal(var1);
      }

   }

   public void importFtp() {
   }

   public void importLocal(File var1) throws IOException, NamingException {
      UtilDownload var2 = new UtilDownload();

      try {
         if (var1 != null) {
            String var3 = var2.trimFilePath(var1.getName().trim());
            String var4 = var3.substring(var3.indexOf(".") + 1);
            if (var4.equalsIgnoreCase("csv")) {
               ArrayList var5 = new ArrayList();
               FileReader var6 = new FileReader(var1);
               BufferedReader var7 = new BufferedReader(var6);

               for(String var8 = var7.readLine(); var8 != null; var8 = var7.readLine()) {
                  var5.add(var8);
               }

               var7.close();
               var6.close();
               if (var5.size() != 0) {
                  this.preparationTransfertImport(var5);
               }
            }
         }
      } catch (IOException var9) {
         var9.printStackTrace();
      }

   }

   public void preparationTransfertImport(List var1) throws HibernateException, NamingException {
      if (var1.size() != 0) {
         this.lesNumerosSerie = new ArrayList();

         for(int var2 = 0; var2 < var1.size(); ++var2) {
            String var3 = (String)var1.get(var2);
            String[] var4 = var3.split(",");
            this.receptionSerieAchats = new ReceptionSerieAchats();
            if (var4[0] != null && !var4[0].isEmpty() && var4[1] != null && !var4[1].isEmpty()) {
               this.receptionSerieAchats.setRecserSerie(var4[0]);
               if (var4[1] != null && !var4[1].isEmpty()) {
                  this.receptionSerieAchats.setRecserCode(var4[1]);
               }

               if (var4[2] != null && !var4[2].isEmpty()) {
                  this.receptionSerieAchats.setRecserCarton(var4[2]);
               } else {
                  this.receptionSerieAchats.setRecserCarton("");
               }

               if (var4[3] != null && !var4[3].isEmpty()) {
                  this.receptionSerieAchats.setRecserPalette(var4[3]);
               } else {
                  this.receptionSerieAchats.setRecserPalette("");
               }

               if (var4[4] != null && !var4[4].isEmpty()) {
                  this.receptionSerieAchats.setRecserLot(var4[4]);
               } else {
                  this.receptionSerieAchats.setRecserLot("");
               }

               if (this.champ1) {
                  if (var4[5] != null && !var4[5].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp1(var4[5]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp1("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp1("");
               }

               if (this.champ2) {
                  if (var4[6] != null && !var4[6].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp2(var4[6]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp2("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp2("");
               }

               if (this.champ3) {
                  if (var4[7] != null && !var4[7].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp3(var4[7]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp3("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp3("");
               }

               if (this.champ4) {
                  if (var4[8] != null && !var4[8].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp4(var4[8]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp4("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp4("");
               }

               if (this.champ5) {
                  if (var4[9] != null && !var4[9].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp5(var4[9]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp5("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp5("");
               }

               if (this.champ6) {
                  if (var4[10] != null && !var4[10].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp6(var4[10]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp6("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp6("");
               }

               if (this.champ7) {
                  if (var4[11] != null && !var4[11].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp7(var4[11]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp7("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp7("");
               }

               if (this.champ8) {
                  if (var4[12] != null && !var4[12].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp8(var4[12]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp8("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp8("");
               }

               if (this.champ9) {
                  if (var4[13] != null && !var4[13].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp7(var4[13]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp9("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp9("");
               }

               if (this.champ10) {
                  if (var4[14] != null && !var4[14].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp10(var4[14]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp10("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp10("");
               }

               if (this.champ11) {
                  if (var4[15] != null && !var4[15].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp11(var4[15]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp11("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp11("");
               }

               if (this.champ12) {
                  if (var4[16] != null && !var4[16].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp12(var4[16]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp12("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp12("");
               }

               if (this.champ13) {
                  if (var4[17] != null && !var4[17].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp13(var4[17]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp13("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp13("");
               }

               if (this.champ14) {
                  if (var4[18] != null && !var4[18].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp14(var4[18]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp14("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp14("");
               }

               if (this.champ15) {
                  if (var4[19] != null && !var4[19].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp15(var4[19]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp15("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp15("");
               }

               if (this.champ16) {
                  if (var4[20] != null && !var4[20].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp16(var4[20]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp16("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp16("");
               }

               if (this.champ17) {
                  if (var4[21] != null && !var4[21].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp17(var4[21]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp17("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp17("");
               }

               if (this.champ18) {
                  if (var4[22] != null && !var4[22].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp18(var4[22]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp18("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp18("");
               }

               if (this.champ19) {
                  if (var4[23] != null && !var4[23].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp19(var4[23]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp19("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp19("");
               }

               if (this.champ20) {
                  if (var4[24] != null && !var4[24].isEmpty()) {
                     this.receptionSerieAchats.setRecserChamp20(var4[24]);
                  } else {
                     this.receptionSerieAchats.setRecserChamp20("");
                  }
               } else {
                  this.receptionSerieAchats.setRecserChamp20("");
               }

               this.lesNumerosSerie.add(this.receptionSerieAchats);
            }
         }

         this.dataModelSerie.setWrappedData(this.lesNumerosSerie);
         this.calculCarton();
         this.calculPalette();
         this.calculLot();
         this.saveSerie();
      }

      this.var_choix_importation = 0;
   }

   public void saveSerie() throws HibernateException, NamingException {
      if (this.lesNumerosSerie.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionLigne");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesNumerosSerie.size(); ++var3) {
               new ReceptionSerieAchats();
               new ReceptionSerieAchats();
               ReceptionSerieAchats var4 = (ReceptionSerieAchats)this.lesNumerosSerie.get(var3);
               ReceptionSerieAchats var5 = this.receptionSerieAchatsDao.rechercheSerieByNum(var4.getRecserSerie(), var1);
               if (var5 == null) {
                  this.receptionSerieAchatsDao.insert(var4, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void calculCarton() {
      if (this.lesNumerosSerie.size() != 0) {
         ArrayList var1 = new ArrayList();

         int var2;
         for(var2 = 0; var2 < this.lesNumerosSerie.size(); ++var2) {
            if (var1.size() == 0) {
               var1.add(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserCarton());
            } else {
               boolean var3 = false;

               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  if (((String)var1.get(var4)).toString().equals(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserCarton())) {
                     var3 = true;
                     break;
                  }
               }

               if (!var3) {
                  var1.add(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserCarton());
               }
            }
         }

         this.mesCartonsItem.clear();
         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               this.mesCartonsItem.add(new SelectItem(((String)var1.get(var2)).toString()));
            }
         }
      }

   }

   public void calculPalette() {
      if (this.lesNumerosSerie.size() != 0) {
         ArrayList var1 = new ArrayList();

         int var2;
         for(var2 = 0; var2 < this.lesNumerosSerie.size(); ++var2) {
            if (var1.size() == 0) {
               var1.add(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserPalette());
            } else {
               boolean var3 = false;

               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  if (((String)var1.get(var4)).toString().equals(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserPalette())) {
                     var3 = true;
                     break;
                  }
               }

               if (!var3) {
                  var1.add(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserPalette());
               }
            }
         }

         this.mesPalettesItem.clear();
         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               this.mesPalettesItem.add(new SelectItem(((String)var1.get(var2)).toString()));
            }
         }
      }

   }

   public void calculLot() {
      if (this.lesNumerosSerie.size() != 0) {
         ArrayList var1 = new ArrayList();

         int var2;
         for(var2 = 0; var2 < this.lesNumerosSerie.size(); ++var2) {
            if (var1.size() == 0) {
               var1.add(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserLot());
            } else {
               boolean var3 = false;

               for(int var4 = 0; var4 < var1.size(); ++var4) {
                  if (((String)var1.get(var4)).toString().equals(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserLot())) {
                     var3 = true;
                     break;
                  }
               }

               if (!var3) {
                  var1.add(((ReceptionSerieAchats)this.lesNumerosSerie.get(var2)).getRecserLot());
               }
            }
         }

         this.mesLotsItem.clear();
         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               this.mesLotsItem.add(new SelectItem(((String)var1.get(var2)).toString()));
            }
         }
      }

   }

   public void executerRequete() throws HibernateException, NamingException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException {
      this.lesNumerosSerie.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.lesNumerosSerie = this.receptionSerieAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.inpNum, this.inpEtat, this.inpCarton, this.inpPalette, this.inpLot);
      this.dataModelSerie.setWrappedData(this.lesNumerosSerie);
      this.calculCarton();
      this.calculPalette();
      this.calculLot();
      this.visibiliteBton = false;
   }

   public void executerRequeteLot() {
   }

   public void chergerListeDetailLot() {
   }

   public void selectionLot() {
   }

   public void visualisationLot() {
   }

   public void modifierLot() {
   }

   public void consulterLot() {
   }

   public void supprimerLot() {
   }

   public void annulerLot() {
   }

   public void validerLot() {
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_habilitation() {
      return this.var_acc_habilitation;
   }

   public void setVar_acc_habilitation(boolean var1) {
      this.var_acc_habilitation = var1;
   }

   public boolean isVar_acc_imputation() {
      return this.var_acc_imputation;
   }

   public void setVar_acc_imputation(boolean var1) {
      this.var_acc_imputation = var1;
   }

   public boolean isVar_acc_prp() {
      return this.var_acc_prp;
   }

   public void setVar_acc_prp(boolean var1) {
      this.var_acc_prp = var1;
   }

   public boolean isVar_acc_reglement() {
      return this.var_acc_reglement;
   }

   public void setVar_acc_reglement(boolean var1) {
      this.var_acc_reglement = var1;
   }

   public boolean isVar_acc_special() {
      return this.var_acc_special;
   }

   public void setVar_acc_special(boolean var1) {
      this.var_acc_special = var1;
   }

   public boolean isVar_acc_tracabilite() {
      return this.var_acc_tracabilite;
   }

   public void setVar_acc_tracabilite(boolean var1) {
      this.var_acc_tracabilite = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public int getVar_choix_importation() {
      return this.var_choix_importation;
   }

   public void setVar_choix_importation(int var1) {
      this.var_choix_importation = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibleOngleEntete() {
      return this.visibleOngleEntete;
   }

   public void setVisibleOngleEntete(boolean var1) {
      this.visibleOngleEntete = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public DataModel getDataModelSerie() {
      return this.dataModelSerie;
   }

   public void setDataModelSerie(DataModel var1) {
      this.dataModelSerie = var1;
   }

   public List getMesCartonsItem() {
      return this.mesCartonsItem;
   }

   public void setMesCartonsItem(List var1) {
      this.mesCartonsItem = var1;
   }

   public List getMesPalettesItem() {
      return this.mesPalettesItem;
   }

   public void setMesPalettesItem(List var1) {
      this.mesPalettesItem = var1;
   }

   public String getInpCarton() {
      return this.inpCarton;
   }

   public void setInpCarton(String var1) {
      this.inpCarton = var1;
   }

   public String getInpPalette() {
      return this.inpPalette;
   }

   public void setInpPalette(String var1) {
      this.inpPalette = var1;
   }

   public boolean isChamp1() {
      return this.champ1;
   }

   public void setChamp1(boolean var1) {
      this.champ1 = var1;
   }

   public boolean isChamp10() {
      return this.champ10;
   }

   public void setChamp10(boolean var1) {
      this.champ10 = var1;
   }

   public boolean isChamp2() {
      return this.champ2;
   }

   public void setChamp2(boolean var1) {
      this.champ2 = var1;
   }

   public boolean isChamp3() {
      return this.champ3;
   }

   public void setChamp3(boolean var1) {
      this.champ3 = var1;
   }

   public boolean isChamp4() {
      return this.champ4;
   }

   public void setChamp4(boolean var1) {
      this.champ4 = var1;
   }

   public boolean isChamp5() {
      return this.champ5;
   }

   public void setChamp5(boolean var1) {
      this.champ5 = var1;
   }

   public boolean isChamp6() {
      return this.champ6;
   }

   public void setChamp6(boolean var1) {
      this.champ6 = var1;
   }

   public boolean isChamp7() {
      return this.champ7;
   }

   public void setChamp7(boolean var1) {
      this.champ7 = var1;
   }

   public boolean isChamp8() {
      return this.champ8;
   }

   public void setChamp8(boolean var1) {
      this.champ8 = var1;
   }

   public boolean isChamp9() {
      return this.champ9;
   }

   public void setChamp9(boolean var1) {
      this.champ9 = var1;
   }

   public boolean isChamp11() {
      return this.champ11;
   }

   public void setChamp11(boolean var1) {
      this.champ11 = var1;
   }

   public boolean isChamp12() {
      return this.champ12;
   }

   public void setChamp12(boolean var1) {
      this.champ12 = var1;
   }

   public boolean isChamp13() {
      return this.champ13;
   }

   public void setChamp13(boolean var1) {
      this.champ13 = var1;
   }

   public boolean isChamp14() {
      return this.champ14;
   }

   public void setChamp14(boolean var1) {
      this.champ14 = var1;
   }

   public boolean isChamp15() {
      return this.champ15;
   }

   public void setChamp15(boolean var1) {
      this.champ15 = var1;
   }

   public boolean isChamp16() {
      return this.champ16;
   }

   public void setChamp16(boolean var1) {
      this.champ16 = var1;
   }

   public boolean isChamp17() {
      return this.champ17;
   }

   public void setChamp17(boolean var1) {
      this.champ17 = var1;
   }

   public boolean isChamp18() {
      return this.champ18;
   }

   public void setChamp18(boolean var1) {
      this.champ18 = var1;
   }

   public boolean isChamp19() {
      return this.champ19;
   }

   public void setChamp19(boolean var1) {
      this.champ19 = var1;
   }

   public boolean isChamp20() {
      return this.champ20;
   }

   public void setChamp20(boolean var1) {
      this.champ20 = var1;
   }

   public List getMesLotsItem() {
      return this.mesLotsItem;
   }

   public void setMesLotsItem(List var1) {
      this.mesLotsItem = var1;
   }

   public String getInpLot() {
      return this.inpLot;
   }

   public void setInpLot(String var1) {
      this.inpLot = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public DataModel getDataModelLot() {
      return this.dataModelLot;
   }

   public void setDataModelLot(DataModel var1) {
      this.dataModelLot = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }
}
