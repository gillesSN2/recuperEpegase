package com.epegase.forms.administration;

import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculFormule;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculFormuleDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LectureFeuilleCalculPaye;
import com.epegase.systeme.xml.LectureFeuilleFormulePaye;
import com.epegase.systeme.xml.LectureFeuilleLignePaye;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormFeuilleCalcul implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private String nature = "100";
   private int utilisation;
   private OptionPaye optionPaye;
   private ExercicesPaye exercicesPaye;
   private ExercicesComptable exercicesComptable;
   private int var_nb_max = 100;
   private List lesFeuillesCalcul = new ArrayList();
   private FeuilleCalcul feuilleCalcul;
   private transient DataModel dataModelFeuillesCalcul = new ListDataModel();
   private FeuilleCalculDao feuilleCalculDao;
   private boolean afficheFeuille = false;
   private boolean showModalPanelFeuille = false;
   private boolean existeCopteDeja = false;
   private boolean inactif = false;
   private boolean afficheAjDefaut = false;
   private List mesNaturesItems = new ArrayList();
   private List mesModelesItems = new ArrayList();
   private List mesJournauxItems = new ArrayList();
   private boolean saisieCode;
   private boolean exerciceCompta;
   private PlanPaye planPaye = new PlanPaye();
   private List lesPlansPaye = new ArrayList();
   private PlanPayeDao planPayeDao;
   private transient DataModel dataModelRubrique = new ListDataModel();
   private List lesRubriques = new ArrayList();
   private FeuilleCalculRubrique feuilleCalculRubrique;
   private FeuilleCalculRubriqueDao feuilleCalculRubriqueDao;
   private boolean showModalPanelRubrique = false;
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private String styleColonne;
   private int nbColonne;
   private String colonneEnCours = "A";
   private transient DataModel dataModelColA = new ListDataModel();
   private transient DataModel dataModelColB = new ListDataModel();
   private transient DataModel dataModelColC = new ListDataModel();
   private transient DataModel dataModelColD = new ListDataModel();
   private transient DataModel dataModelColE = new ListDataModel();
   private List lesFormulesColA = new ArrayList();
   private List lesFormulesColB = new ArrayList();
   private List lesFormulesColC = new ArrayList();
   private List lesFormulesColD = new ArrayList();
   private List lesFormulesColE = new ArrayList();
   private FeuilleCalculFormule feuilleCalculFormule = new FeuilleCalculFormule();
   private FeuilleCalculFormuleDao feuilleCalculFormuleDao;
   private boolean afficheFormuleA;
   private boolean afficheFormuleB;
   private boolean afficheFormuleC;
   private boolean afficheFormuleD;
   private boolean afficheFormuleE;
   private boolean showModalPanelFormule = false;
   private transient DataModel dataModelFonction = new ListDataModel();
   private List lesFonctions = new ArrayList();
   private String fonction;
   private String format;
   private UtilPrint utilPrint;

   public void InstancesDaoUtilses() {
      this.planPayeDao = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculDao = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculRubriqueDao = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculFormuleDao = new FeuilleCalculFormuleDao(this.baseLog, this.utilInitHibernate);
   }

   public void initFeuilleCalcul(Session var1) throws IOException, HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      boolean var2 = false;
      Object var3 = var1.createQuery("SELECT COUNT(*) FROM FeuilleCalcul").uniqueResult();
      int var12 = Integer.parseInt(var3.toString());
      if (var12 > 0) {
         this.afficheAjDefaut = false;
      } else {
         this.afficheAjDefaut = true;
      }

      var3 = var1.createQuery("SELECT COUNT(*) FROM ExercicesComptable").uniqueResult();
      var12 = Integer.parseInt(var3.toString());
      if (var12 > 0) {
         this.exerciceCompta = true;
      } else {
         this.exerciceCompta = false;
      }

      this.lesPlansPaye.clear();
      this.lesPlansPaye = this.planPayeDao.chargerPlanPaye(this.exercicesPaye.getExepayId(), var1);
      this.mesNaturesItems.clear();
      new ArrayList();
      ArrayList var5 = new ArrayList();
      ChronoDao var6 = new ChronoDao(this.baseLog, this.utilInitHibernate);
      List var4 = var6.selectListPaye(0, var1);
      if (var4.size() != 0) {
         new Chrono();

         Chrono var7;
         for(int var8 = 0; var8 < var4.size(); ++var8) {
            var7 = (Chrono)var4.get(var8);
            if (var7.getChrNature() == 81) {
               var5.add(var7);
            }
         }

         if (var5.size() != 0) {
            String var14 = "";

            for(int var9 = 0; var9 < var5.size(); ++var9) {
               var7 = (Chrono)var5.get(var9);
               if (!var7.getChrSerie().startsWith("01") && !var7.getChrSerie().startsWith("02")) {
                  if (var7.getChrSerie().startsWith("03")) {
                     var14 = "03:Horaire";
                  } else if (!var7.getChrSerie().startsWith("05") && !var7.getChrSerie().startsWith("11")) {
                     var14 = var7.getChrSerie();
                  } else {
                     var14 = "05:Stagiaire";
                  }
               } else {
                  var14 = "01:Mensuel";
               }

               if (this.mesNaturesItems.size() == 0) {
                  this.mesNaturesItems.add(new SelectItem(var14));
               } else {
                  boolean var10 = false;

                  for(int var11 = 0; var11 < this.mesNaturesItems.size(); ++var11) {
                     if (((SelectItem)this.mesNaturesItems.get(var11)).getValue().toString().equals(var14)) {
                        var10 = true;
                        break;
                     }
                  }

                  if (!var10) {
                     this.mesNaturesItems.add(new SelectItem(var14));
                  }
               }
            }
         }
      }

      this.recupererModeleBulletin();
      this.mesJournauxItems.clear();
      JournauxComptablesDao var13 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.mesJournauxItems = var13.chargerLesJournaux(this.exercicesComptable, 3, 0, var1);
   }

   public void recupererModeleBulletin() {
      String var1 = "";
      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "bulletin" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.mesModelesItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.mesModelesItems.add(new SelectItem(var5));
            }
         }
      }

   }

   public String[] triAlphabetique(String[] var1, int var2) {
      int var3 = var2;
      boolean var4;
      if (var2 != 0) {
         do {
            var4 = false;

            for(int var5 = 0; var5 < var3 - 1; ++var5) {
               if (var1[var5].compareToIgnoreCase(var1[var5 + 1]) > 0) {
                  this.echanger(var1, var5, var5 + 1);
                  var4 = true;
               }
            }

            --var3;
         } while(var4);
      }

      return var1;
   }

   public void echanger(String[] var1, int var2, int var3) {
      String var4 = var1[var2];
      var1[var2] = var1[var3];
      var1[var3] = var4;
   }

   public void defaultAdd() throws HibernateException, NamingException, ParseException {
      LectureFeuilleCalculPaye var1 = new LectureFeuilleCalculPaye();
      var1.setStructureLog(this.structureLog);
      new ArrayList();
      var1.recuperePaye();
      List var2 = var1.getMesFeuilles();
      if (var2.size() != 0) {
         new ArrayList();
         List var3 = this.planPayeDao.chargerPlanPaye(this.exercicesPaye.getExepayId(), (Session)null);
         if (var3.size() != 0) {
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
            Transaction var5 = null;

            try {
               var5 = var4.beginTransaction();
               int var6 = 0;

               while(true) {
                  if (var6 >= var2.size()) {
                     var5.commit();
                     break;
                  }

                  new FeuilleCalcul();
                  FeuilleCalcul var7 = (FeuilleCalcul)var2.get(var6);
                  var7.setFeuDateCreat(new Date());
                  var7.setFeuUserCreat(this.usersLog.getUsrid());
                  var7.setExercicesPaye(this.exercicesPaye);
                  this.feuilleCalculDao.insert(var7, var4);
                  ++var6;
               }
            } catch (HibernateException var38) {
               if (var5 != null) {
                  var5.rollback();
               }

               throw var38;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.nature = "100";
            this.chargerFeuilleCalcul();
            LectureFeuilleLignePaye var40 = new LectureFeuilleLignePaye();
            var40.setStructureLog(this.structureLog);
            new ArrayList();
            var40.recuperePaye();
            List var41 = var40.getMesFeuillesLignes();
            if (var41.size() != 0) {
               var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
               Transaction var8 = null;

               try {
                  var8 = var4.beginTransaction();
                  int var9 = 0;

                  while(true) {
                     if (var9 >= var41.size()) {
                        var8.commit();
                        break;
                     }

                     new FeuilleCalculRubrique();
                     FeuilleCalculRubrique var10 = (FeuilleCalculRubrique)var41.get(var9);
                     this.feuilleCalcul = null;

                     int var11;
                     for(var11 = 0; var11 < this.lesFeuillesCalcul.size(); ++var11) {
                        if (((FeuilleCalcul)this.lesFeuillesCalcul.get(var11)).getFeuCode().equals(var10.getFeurubFeuille())) {
                           this.feuilleCalcul = (FeuilleCalcul)this.lesFeuillesCalcul.get(var11);
                           break;
                        }
                     }

                     var10.setFeuilleCalcul(this.feuilleCalcul);
                     this.planPaye = null;

                     for(var11 = 0; var11 < var3.size(); ++var11) {
                        if (((PlanPaye)var3.get(var11)).getPlpCode().equals(var10.getFeurubCode())) {
                           this.planPaye = (PlanPaye)var3.get(var11);
                           break;
                        }
                     }

                     var10.setPlanPaye(this.planPaye);
                     if (this.feuilleCalcul != null && this.planPaye != null) {
                        this.feuilleCalculRubriqueDao.insert(var10, var4);
                     }

                     ++var9;
                  }
               } catch (HibernateException var36) {
                  if (var8 != null) {
                     var8.rollback();
                  }

                  throw var36;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }

            new ArrayList();
            List var42 = this.feuilleCalculRubriqueDao.chargerRubriqueToutesFeuilles((Session)null);
            if (var42.size() != 0) {
               LectureFeuilleFormulePaye var43 = new LectureFeuilleFormulePaye();
               var43.setStructureLog(this.structureLog);
               new ArrayList();
               var43.recuperePaye();
               List var44 = var43.getMesFeuillesFormules();
               if (var44.size() != 0) {
                  var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
                  Transaction var45 = null;

                  try {
                     var45 = var4.beginTransaction();
                     int var12 = 0;

                     while(true) {
                        if (var12 >= var44.size()) {
                           var45.commit();
                           break;
                        }

                        new FeuilleCalculFormule();
                        FeuilleCalculFormule var13 = (FeuilleCalculFormule)var44.get(var12);
                        this.feuilleCalcul = null;

                        int var14;
                        for(var14 = 0; var14 < this.lesFeuillesCalcul.size(); ++var14) {
                           if (((FeuilleCalcul)this.lesFeuillesCalcul.get(var14)).getFeuCode().equals(var13.getFeurubforFeuille())) {
                              this.feuilleCalcul = (FeuilleCalcul)this.lesFeuillesCalcul.get(var14);
                              break;
                           }
                        }

                        var13.setFeuilleCalcul(this.feuilleCalcul);
                        this.feuilleCalculRubrique = null;

                        for(var14 = 0; var14 < var42.size(); ++var14) {
                           if (((FeuilleCalculRubrique)var42.get(var14)).getFeurubCode().equals(var13.getFeurubforCode()) && ((FeuilleCalculRubrique)var42.get(var14)).getFeurubFeuille().equals(var13.getFeurubforFeuille())) {
                              this.feuilleCalculRubrique = (FeuilleCalculRubrique)var42.get(var14);
                              break;
                           }
                        }

                        var13.setFeuilleCalculRubrique(this.feuilleCalculRubrique);
                        if (this.feuilleCalcul != null && this.feuilleCalculRubrique != null) {
                           this.feuilleCalculFormuleDao.insert(var13, var4);
                        }

                        ++var12;
                     }
                  } catch (HibernateException var34) {
                     if (var45 != null) {
                        var45.rollback();
                     }

                     throw var34;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               }

               this.afficheAjDefaut = false;
            }
         }
      }

   }

   public void chargerFeuilleCalcul() throws HibernateException, NamingException {
      this.chargerFeuilleCalcul((Session)null);
   }

   public void chargerFeuilleCalcul(Session var1) throws NamingException {
      this.lesFeuillesCalcul.clear();
      if (!this.nature.startsWith("9999")) {
         String var2 = "";
         if (this.nature.contains(":")) {
            String[] var3 = this.nature.split(":");
            var2 = var3[0];
         } else {
            var2 = this.nature;
         }

         this.lesFeuillesCalcul = this.feuilleCalculDao.chargerFeuilleNature(this.exercicesPaye.getExepayId(), var2, var1);
      }

      this.dataModelFeuillesCalcul.setWrappedData(this.lesFeuillesCalcul);
   }

   public void selectionFeuille() throws HibernateException, NamingException {
      if (this.dataModelFeuillesCalcul.isRowAvailable()) {
         this.feuilleCalcul = (FeuilleCalcul)this.dataModelFeuillesCalcul.getRowData();
         this.afficheFeuille = true;
         if (this.feuilleCalcul.getFeuInactif() != 0) {
            this.inactif = true;
         } else {
            this.inactif = false;
         }

         this.lesRubriques.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActiveConfig(this.feuilleCalcul, var1);
            if (this.lesPlansPaye.size() != 0) {
               new PlanPaye();

               for(int var4 = 0; var4 < this.lesPlansPaye.size(); ++var4) {
                  PlanPaye var3 = (PlanPaye)this.lesPlansPaye.get(var4);
                  if (var3.getPlpInactif() == 0) {
                     if (this.lesRubriques.size() == 0) {
                        this.feuilleCalculRubrique = new FeuilleCalculRubrique();
                        this.feuilleCalculRubrique.setPlanPaye(var3);
                        this.feuilleCalculRubrique.setFeurubCode(var3.getPlpCode());
                        this.feuilleCalculRubrique.setFeurubActif(false);
                        this.lesRubriques.add(this.feuilleCalculRubrique);
                     } else {
                        boolean var5 = false;
                        this.feuilleCalculRubrique = new FeuilleCalculRubrique();

                        for(int var6 = 0; var6 < this.lesRubriques.size(); ++var6) {
                           this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var6);
                           if (var3.getPlpCode().equals(this.feuilleCalculRubrique.getFeurubCode())) {
                              var5 = true;
                              break;
                           }
                        }

                        if (!var5) {
                           this.feuilleCalculRubrique = new FeuilleCalculRubrique();
                           this.feuilleCalculRubrique.setPlanPaye(var3);
                           this.feuilleCalculRubrique.setFeurubCode(var3.getPlpCode());
                           this.feuilleCalculRubrique.setFeurubActif(false);
                           this.lesRubriques.add(this.feuilleCalculRubrique);
                        }
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         UtilTrie var12 = new UtilTrie();
         this.lesRubriques = var12.triListeTransfertRubrique(this.lesRubriques);
         this.lesRubriques = var12.triListeTransfertRubrique(this.lesRubriques);
         this.lesRubriques = var12.triListeTransfertRubrique(this.lesRubriques);
         this.dataModelRubrique.setWrappedData(this.lesRubriques);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void ajouterFeuille() {
      this.feuilleCalcul = new FeuilleCalcul();
      this.afficheFeuille = false;
      this.existeCopteDeja = false;
      this.feuilleCalcul.setFeuNature("9999");
      this.saisieCode = true;
      this.showModalPanelFeuille = true;
   }

   public void duppliquerFeuille() throws HibernateException, NamingException, ParseException {
      if (this.feuilleCalcul != null) {
         boolean var1 = false;
         String var2 = "";
         String var3 = this.feuilleCalcul.getFeuCode();
         new ArrayList();
         List var4 = this.feuilleCalculFormuleDao.chargerFeuille((FeuilleCalcul)this.feuilleCalcul, (Session)null);
         FeuilleCalcul var5 = new FeuilleCalcul();
         String var6 = this.feuilleCalcul.getFeuCode() + "(Copie)";
         boolean var7 = this.feuilleCalculDao.existeCode(var6, this.exercicesPaye.getExepayId(), (Session)null);
         if (!var7) {
            var5 = this.feuilleCalcul;
            var5.setFeuCode(var6);
            var5.setFeuDateCreat(new Date());
            var5.setFeuUserCreat(this.usersLog.getUsrid());
            var5 = this.feuilleCalculDao.insert(var5);
            var1 = true;
         }

         if (var1 && var5 != null) {
            var1 = false;
            Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
            Transaction var9 = null;

            FeuilleCalculRubrique var10;
            try {
               var9 = var8.beginTransaction();
               if (this.lesRubriques.size() != 0) {
                  new FeuilleCalculRubrique();
                  new FeuilleCalculRubrique();
                  int var12 = 0;

                  while(true) {
                     if (var12 >= this.lesRubriques.size()) {
                        var1 = true;
                        break;
                     }

                     var10 = (FeuilleCalculRubrique)this.lesRubriques.get(var12);
                     if (var10.isFeurubColA() || var10.isFeurubColB() || var10.isFeurubColC() || var10.isFeurubColD() || var10.isFeurubColE()) {
                        FeuilleCalculRubrique var11 = new FeuilleCalculRubrique();
                        var11.setFeuilleCalcul(var5);
                        var11.setPlanPaye(var10.getPlanPaye());
                        var11.setFeurubActif(var10.isFeurubActif());
                        var11.setFeurubCode(var10.getFeurubCode());
                        var11.setFeurubColA(var10.isFeurubColA());
                        var11.setFeurubColARaz(var10.isFeurubColARaz());
                        var11.setFeurubColB(var10.isFeurubColB());
                        var11.setFeurubColBRaz(var10.isFeurubColBRaz());
                        var11.setFeurubColC(var10.isFeurubColC());
                        var11.setFeurubColCRaz(var10.isFeurubColCRaz());
                        var11.setFeurubColD(var10.isFeurubColD());
                        var11.setFeurubColDRaz(var10.isFeurubColDRaz());
                        var11.setFeurubColE(var10.isFeurubColE());
                        var11.setFeurubColERaz(var10.isFeurubColERaz());
                        var11.setFeurubCompte(var10.getFeurubCompte());
                        var11.setFeurubVariableA(var10.isFeurubVariableA());
                        var11.setFeurubVariableB(var10.isFeurubVariableB());
                        var11.setFeurubVariableC(var10.isFeurubVariableC());
                        var11.setFeurubVariableD(var10.isFeurubVariableD());
                        var11.setFeurubVariableE(var10.isFeurubVariableE());
                        this.feuilleCalculRubriqueDao.insert(var11, var8);
                     }

                     ++var12;
                  }
               }

               var9.commit();
            } catch (HibernateException var26) {
               if (var9 != null) {
                  var9.rollback();
               }

               throw var26;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var1) {
               var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
               var10 = null;

               try {
                  Transaction var28 = var8.beginTransaction();
                  if (var4.size() != 0) {
                     new FeuilleCalculFormule();
                     new FeuilleCalculRubrique();

                     for(int var13 = 0; var13 < var4.size(); ++var13) {
                        FeuilleCalculFormule var29 = (FeuilleCalculFormule)var4.get(var13);
                        var2 = var29.getFeurubforCode();
                        FeuilleCalculRubrique var30 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille((FeuilleCalcul)var5, var2, 1, var8);
                        if (var30 != null) {
                           FeuilleCalculFormule var14 = new FeuilleCalculFormule();
                           var14.setFeuilleCalcul(var5);
                           var14.setFeuilleCalculRubrique(var30);
                           var14.setFeurubforCode(var29.getFeurubforCode());
                           var14.setFeurubforColonne(var29.getFeurubforColonne());
                           var14.setFeurubforFormule(var29.getFeurubforFormule());
                           this.feuilleCalculFormuleDao.insert(var14, var8);
                        }
                     }
                  }

                  var28.commit();
               } catch (HibernateException var24) {
                  if (var10 != null) {
                     var10.rollback();
                  }

                  throw var24;
               } finally {
                  this.utilInitHibernate.closeSession();
               }
            }
         }

         this.chargerFeuilleCalcul();
         this.afficheFeuille = false;
      }

   }

   public void modifierFeuille() {
      if (this.feuilleCalcul != null) {
         this.existeCopteDeja = false;
         if (this.feuilleCalcul.getFeuCode().contains("(Copie)")) {
            this.saisieCode = true;
         } else {
            this.saisieCode = false;
         }

         this.showModalPanelFeuille = true;
      }

   }

   public void supprimerFeuille() throws HibernateException, NamingException {
      if (this.feuilleCalcul != null) {
         if (this.feuilleCalcul.getFeuInactif() == 0) {
            this.feuilleCalcul.setFeuInactif(1);
            this.feuilleCalcul = this.feuilleCalculDao.modif(this.feuilleCalcul);
            this.inactif = true;
         } else if (this.feuilleCalcul.getFeuInactif() == 1) {
            boolean var1 = true;
            Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
            Transaction var3 = null;

            List var4;
            try {
               var3 = var2.beginTransaction();
               new ArrayList();
               var4 = this.feuilleCalculFormuleDao.chargerFeuille(this.feuilleCalcul, var2);
               if (var4.size() != 0) {
                  for(int var5 = 0; var5 < var4.size(); ++var5) {
                     this.feuilleCalculFormule = (FeuilleCalculFormule)var4.get(var5);
                     this.feuilleCalculFormuleDao.delete(this.feuilleCalculFormule, var2);
                  }
               }

               var3.commit();
            } catch (HibernateException var31) {
               var1 = false;
               if (var3 != null) {
                  var3.rollback();
               }

               throw var31;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var1) {
               var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
               var4 = null;

               List var34;
               try {
                  Transaction var33 = var2.beginTransaction();
                  new ArrayList();
                  var34 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var2);
                  if (var34.size() != 0) {
                     for(int var6 = 0; var6 < var34.size(); ++var6) {
                        this.feuilleCalculRubrique = (FeuilleCalculRubrique)var34.get(var6);
                        this.feuilleCalculRubriqueDao.delete(this.feuilleCalculRubrique, var2);
                     }
                  }

                  var33.commit();
               } catch (HibernateException var29) {
                  var1 = false;
                  if (var4 != null) {
                     var4.rollback();
                  }

                  throw var29;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               if (var1) {
                  var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
                  var34 = null;

                  try {
                     Transaction var35 = var2.beginTransaction();
                     this.feuilleCalculDao.delete(this.feuilleCalcul, var2);
                     this.lesFeuillesCalcul.remove(this.feuilleCalcul);
                     this.dataModelFeuillesCalcul.setWrappedData(this.lesFeuillesCalcul);
                     var35.commit();
                  } catch (HibernateException var27) {
                     if (var34 != null) {
                        var34.rollback();
                     }

                     throw var27;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               }
            }
         }
      }

   }

   public void reactiveFeuille() throws HibernateException, NamingException {
      if (this.feuilleCalcul != null) {
         this.feuilleCalcul.setFeuInactif(0);
         this.feuilleCalcul = this.feuilleCalculDao.modif(this.feuilleCalcul);
         this.inactif = false;
      }

   }

   public void annulerFeuille() {
      this.afficheFeuille = false;
      this.showModalPanelFeuille = false;
   }

   public void testeUniciteFeuille() throws HibernateException, NamingException {
      this.existeCopteDeja = this.feuilleCalculDao.existeCode(this.feuilleCalcul.getFeuCode(), this.exercicesPaye.getExepayId(), (Session)null);
   }

   public void validerFeuille() throws HibernateException, NamingException {
      if (this.inactif) {
         this.feuilleCalcul.setFeuInactif(1);
      } else {
         this.feuilleCalcul.setFeuInactif(0);
      }

      if (this.feuilleCalcul.getFeu_id() == 0L) {
         this.feuilleCalcul.setExercicesPaye(this.exercicesPaye);
         this.feuilleCalcul = this.feuilleCalculDao.insert(this.feuilleCalcul);
         this.lesFeuillesCalcul.add(this.feuilleCalcul);
         this.dataModelFeuillesCalcul.setWrappedData(this.lesFeuillesCalcul);
      } else {
         this.feuilleCalcul = this.feuilleCalculDao.modif(this.feuilleCalcul);
      }

      if (this.lesRubriques.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesRubriques.size(); ++var3) {
               this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var3);
               long var4 = this.feuilleCalculRubrique.getFeurub_id();
               boolean var6 = this.feuilleCalculRubrique.isFeurubActif();
               boolean var7 = this.feuilleCalculRubrique.isFeurubColA();
               boolean var8 = this.feuilleCalculRubrique.isFeurubColB();
               boolean var9 = this.feuilleCalculRubrique.isFeurubColC();
               boolean var10 = this.feuilleCalculRubrique.isFeurubColD();
               boolean var11 = this.feuilleCalculRubrique.isFeurubColE();
               String var12 = this.feuilleCalculRubrique.getFeurubCompte();
               this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(var4, var1);
               if (this.feuilleCalculRubrique != null) {
                  this.feuilleCalculRubrique.setFeurubActif(var6);
                  this.feuilleCalculRubrique.setFeurubColA(var7);
                  this.feuilleCalculRubrique.setFeurubColB(var8);
                  this.feuilleCalculRubrique.setFeurubColC(var9);
                  this.feuilleCalculRubrique.setFeurubColD(var10);
                  this.feuilleCalculRubrique.setFeurubColE(var11);
                  this.feuilleCalculRubrique.setFeurubCompte(var12);
                  this.feuilleCalculRubriqueDao.modif(this.feuilleCalculRubrique, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var16) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.afficheFeuille = true;
      this.showModalPanelFeuille = false;
   }

   public void verifierFeuille() throws HibernateException, NamingException {
      if (this.lesFeuillesCalcul.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new PlanPaye();

            for(int var4 = 0; var4 < this.lesFeuillesCalcul.size(); ++var4) {
               this.feuilleCalcul = (FeuilleCalcul)this.lesFeuillesCalcul.get(var4);
               long var5 = this.exercicesPaye.getExepayId();
               new ArrayList();
               List var7 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var1);
               if (var7.size() != 0) {
                  for(int var8 = 0; var8 < var7.size(); ++var8) {
                     this.feuilleCalculRubrique = (FeuilleCalculRubrique)var7.get(var8);
                     if (this.feuilleCalculRubrique.getPlanPaye().getExercicesPaye().getExepayId() == var5) {
                        PlanPaye var3 = this.planPayeDao.chercherCode(this.feuilleCalculRubrique.getFeurubCode(), var5, var1);
                        if (var3 != null && var3.getPlpId() != this.feuilleCalculRubrique.getPlanPaye().getPlpId()) {
                           this.feuilleCalculRubrique.setPlanPaye(var3);
                           this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.modif(this.feuilleCalculRubrique, var1);
                        }
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void selectionRubrique() {
      if (this.extDTable != null) {
         int var1 = 0;
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.simpleSelectionEntete.getKeys();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var1 = Integer.parseInt(var4.toString());
            this.extDTable.setRowKey(var4);
            if (this.extDTable.isRowAvailable()) {
               var2.add(this.extDTable.getRowData());
            }
         }

         for(int var5 = 0; var5 < this.lesRubriques.size(); ++var5) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var5);
            if (var5 == var1) {
               this.feuilleCalculRubrique.setSelect(true);
            } else {
               this.feuilleCalculRubrique.setSelect(false);
            }
         }

         if (var2.size() != 0) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)var2.get(0);
            this.planPaye = this.feuilleCalculRubrique.getPlanPaye();
            this.lesFormulesColA.clear();
            this.lesFormulesColB.clear();
            this.lesFormulesColC.clear();
            this.lesFormulesColD.clear();
            this.lesFormulesColE.clear();
            this.dataModelColA.setWrappedData(this.lesFormulesColA);
            this.dataModelColA.setWrappedData(this.lesFormulesColB);
            this.dataModelColA.setWrappedData(this.lesFormulesColC);
            this.dataModelColA.setWrappedData(this.lesFormulesColD);
            this.dataModelColA.setWrappedData(this.lesFormulesColE);
            this.calculeNbColonnes();
         } else {
            this.feuilleCalculRubrique = null;
         }
      } else {
         this.feuilleCalculRubrique = null;
      }

   }

   public void calculeNbColonnes() {
      this.nbColonne = 0;
      if (this.feuilleCalculRubrique.isFeurubColA()) {
         ++this.nbColonne;
      }

      if (this.feuilleCalculRubrique.isFeurubColB()) {
         ++this.nbColonne;
      }

      if (this.feuilleCalculRubrique.isFeurubColC()) {
         ++this.nbColonne;
      }

      if (this.feuilleCalculRubrique.isFeurubColD()) {
         ++this.nbColonne;
      }

      if (this.feuilleCalculRubrique.isFeurubColE()) {
         ++this.nbColonne;
      }

      if (this.nbColonne != 0) {
         if (this.nbColonne == 1) {
            this.styleColonne = "clos90";
         } else if (this.nbColonne == 2) {
            this.styleColonne = "clos50g,clos50g";
         } else if (this.nbColonne == 3) {
            this.styleColonne = "clos30,clos30,clos30";
         } else if (this.nbColonne == 4) {
            this.styleColonne = "clos25g,clos25g,clos25g,clos25g";
         } else if (this.nbColonne == 5) {
            this.styleColonne = "clos20g,clos20g,clos20g,clos20g,clos20g";
         }
      }

   }

   public void detailRubrique() throws HibernateException, NamingException {
      this.selectionRubrique();
      if (this.feuilleCalculRubrique != null) {
         this.lesFormulesColA.clear();
         this.lesFormulesColB.clear();
         this.lesFormulesColC.clear();
         this.lesFormulesColD.clear();
         this.lesFormulesColE.clear();
         new ArrayList();
         List var1 = this.feuilleCalculFormuleDao.chargerRubriqueFeuille(this.feuilleCalculRubrique, (Session)null);
         if (var1.size() != 0) {
            new FeuilleCalculFormule();

            for(int var3 = 0; var3 < var1.size(); ++var3) {
               FeuilleCalculFormule var2 = (FeuilleCalculFormule)var1.get(var3);
               if (var2.getFeurubforColonne() != null && !var2.getFeurubforColonne().isEmpty()) {
                  if (var2.getFeurubforColonne().equals("A")) {
                     this.lesFormulesColA.add(var2);
                  } else if (var2.getFeurubforColonne().equals("B")) {
                     this.lesFormulesColB.add(var2);
                  } else if (var2.getFeurubforColonne().equals("C")) {
                     this.lesFormulesColC.add(var2);
                  } else if (var2.getFeurubforColonne().equals("D")) {
                     this.lesFormulesColD.add(var2);
                  } else if (var2.getFeurubforColonne().equals("E")) {
                     this.lesFormulesColE.add(var2);
                  }
               }
            }
         }

         this.dataModelColA.setWrappedData(this.lesFormulesColA);
         this.dataModelColB.setWrappedData(this.lesFormulesColB);
         this.dataModelColC.setWrappedData(this.lesFormulesColC);
         this.dataModelColD.setWrappedData(this.lesFormulesColD);
         this.dataModelColE.setWrappedData(this.lesFormulesColE);
         this.verifVariable();
         this.showModalPanelRubrique = true;
      }

   }

   public void fermerDetailRubrique() {
      this.showModalPanelRubrique = false;
   }

   public void verifVariable() {
      this.feuilleCalculRubrique.setFeurubVariableA(false);
      int var1;
      if (this.feuilleCalculRubrique.isFeurubColA() && this.lesFormulesColA.size() != 0) {
         for(var1 = 0; var1 < this.lesFormulesColA.size(); ++var1) {
            if (((FeuilleCalculFormule)this.lesFormulesColA.get(var1)).getFeurubforFormule().equals("VAR()")) {
               this.feuilleCalculRubrique.setFeurubVariableA(true);
               break;
            }
         }
      }

      this.feuilleCalculRubrique.setFeurubVariableB(false);
      if (this.feuilleCalculRubrique.isFeurubColB() && this.lesFormulesColB.size() != 0) {
         for(var1 = 0; var1 < this.lesFormulesColB.size(); ++var1) {
            if (((FeuilleCalculFormule)this.lesFormulesColB.get(var1)).getFeurubforFormule().equals("VAR()")) {
               this.feuilleCalculRubrique.setFeurubVariableB(true);
               break;
            }
         }
      }

      this.feuilleCalculRubrique.setFeurubVariableC(false);
      if (this.feuilleCalculRubrique.isFeurubColC() && this.lesFormulesColC.size() != 0) {
         for(var1 = 0; var1 < this.lesFormulesColC.size(); ++var1) {
            if (((FeuilleCalculFormule)this.lesFormulesColC.get(var1)).getFeurubforFormule().equals("VAR()")) {
               this.feuilleCalculRubrique.setFeurubVariableC(true);
               break;
            }
         }
      }

      this.feuilleCalculRubrique.setFeurubVariableD(false);
      if (this.feuilleCalculRubrique.isFeurubColD() && this.lesFormulesColD.size() != 0) {
         for(var1 = 0; var1 < this.lesFormulesColD.size(); ++var1) {
            if (((FeuilleCalculFormule)this.lesFormulesColD.get(var1)).getFeurubforFormule().equals("VAR()")) {
               this.feuilleCalculRubrique.setFeurubVariableD(true);
               break;
            }
         }
      }

      this.feuilleCalculRubrique.setFeurubVariableE(false);
      if (this.feuilleCalculRubrique.isFeurubColE() && this.lesFormulesColE.size() != 0) {
         for(var1 = 0; var1 < this.lesFormulesColE.size(); ++var1) {
            if (((FeuilleCalculFormule)this.lesFormulesColE.get(var1)).getFeurubforFormule().equals("VAR()")) {
               this.feuilleCalculRubrique.setFeurubVariableE(true);
               break;
            }
         }
      }

   }

   public void valideRubrique() throws HibernateException, NamingException {
      this.verifVariable();
      this.feuilleCalculRubrique.setFeuilleCalcul(this.feuilleCalcul);
      this.feuilleCalculRubrique.setPlanPaye(this.planPaye);
      if (this.feuilleCalculRubrique.getFeurub_id() == 0L) {
         this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.insert(this.feuilleCalculRubrique);
      } else {
         this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.modif(this.feuilleCalculRubrique);
      }

      this.showModalPanelRubrique = false;
   }

   public void selectionColonneA() {
      if (this.dataModelColA.isRowAvailable()) {
         this.feuilleCalculFormule = (FeuilleCalculFormule)this.dataModelColA.getRowData();
         this.afficheFormuleA = true;
      }

   }

   public void ajouterFormuleA() {
      this.feuilleCalculFormule = new FeuilleCalculFormule();
      this.colonneEnCours = "A";
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.showModalPanelFormule = true;
   }

   public void modifierFormuleA() {
      if (this.feuilleCalculFormule != null) {
         this.colonneEnCours = "A";
         this.showModalPanelFormule = true;
      }

   }

   public void supprimerFormuleA() throws HibernateException, NamingException {
      if (this.feuilleCalculFormule != null) {
         this.lesFormulesColA.remove(this.feuilleCalculFormule);
         this.feuilleCalculFormuleDao.delete(this.feuilleCalculFormule);
         this.colonneEnCours = "A";
         this.afficheFormuleA = false;
         this.verifVariable();
      }

   }

   public void selectionColonneB() {
      if (this.dataModelColB.isRowAvailable()) {
         this.feuilleCalculFormule = (FeuilleCalculFormule)this.dataModelColB.getRowData();
         this.afficheFormuleB = true;
      }

   }

   public void ajouterFormuleB() {
      this.feuilleCalculFormule = new FeuilleCalculFormule();
      this.colonneEnCours = "B";
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.showModalPanelFormule = true;
   }

   public void modifierFormuleB() {
      if (this.feuilleCalculFormule != null) {
         this.colonneEnCours = "B";
         this.showModalPanelFormule = true;
      }

   }

   public void supprimerFormuleB() throws HibernateException, NamingException {
      if (this.feuilleCalculFormule != null) {
         this.lesFormulesColB.remove(this.feuilleCalculFormule);
         this.feuilleCalculFormuleDao.delete(this.feuilleCalculFormule);
         this.colonneEnCours = "B";
         this.afficheFormuleB = false;
         this.verifVariable();
      }

   }

   public void selectionColonneC() {
      if (this.dataModelColC.isRowAvailable()) {
         this.feuilleCalculFormule = (FeuilleCalculFormule)this.dataModelColC.getRowData();
         this.afficheFormuleC = true;
      }

   }

   public void ajouterFormuleC() {
      this.feuilleCalculFormule = new FeuilleCalculFormule();
      this.colonneEnCours = "C";
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.showModalPanelFormule = true;
   }

   public void modifierFormuleC() {
      if (this.feuilleCalculFormule != null) {
         this.colonneEnCours = "C";
         this.showModalPanelFormule = true;
      }

   }

   public void supprimerFormuleC() throws HibernateException, NamingException {
      if (this.feuilleCalculFormule != null) {
         this.lesFormulesColC.remove(this.feuilleCalculFormule);
         this.feuilleCalculFormuleDao.delete(this.feuilleCalculFormule);
         this.colonneEnCours = "C";
         this.afficheFormuleC = false;
         this.verifVariable();
      }

   }

   public void selectionColonneD() {
      if (this.dataModelColD.isRowAvailable()) {
         this.feuilleCalculFormule = (FeuilleCalculFormule)this.dataModelColD.getRowData();
         this.afficheFormuleD = true;
      }

   }

   public void ajouterFormuleD() {
      this.feuilleCalculFormule = new FeuilleCalculFormule();
      this.colonneEnCours = "D";
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.showModalPanelFormule = true;
   }

   public void modifierFormuleD() {
      if (this.feuilleCalculFormule != null) {
         this.colonneEnCours = "D";
         this.showModalPanelFormule = true;
      }

   }

   public void supprimerFormuleD() throws HibernateException, NamingException {
      if (this.feuilleCalculFormule != null) {
         this.lesFormulesColD.remove(this.feuilleCalculFormule);
         this.feuilleCalculFormuleDao.delete(this.feuilleCalculFormule);
         this.colonneEnCours = "D";
         this.afficheFormuleD = false;
         this.verifVariable();
      }

   }

   public void selectionColonneE() {
      if (this.dataModelColE.isRowAvailable()) {
         this.feuilleCalculFormule = (FeuilleCalculFormule)this.dataModelColE.getRowData();
         this.afficheFormuleE = true;
      }

   }

   public void ajouterFormuleE() {
      this.feuilleCalculFormule = new FeuilleCalculFormule();
      this.colonneEnCours = "E";
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.showModalPanelFormule = true;
   }

   public void modifierFormuleE() {
      if (this.feuilleCalculFormule != null) {
         this.colonneEnCours = "E";
         this.showModalPanelFormule = true;
      }

   }

   public void supprimerFormuleE() throws HibernateException, NamingException {
      if (this.feuilleCalculFormule != null) {
         this.lesFormulesColE.remove(this.feuilleCalculFormule);
         this.feuilleCalculFormuleDao.delete(this.feuilleCalculFormule);
         this.colonneEnCours = "E";
         this.afficheFormuleE = false;
         this.verifVariable();
      }

   }

   public void fermerFormule() {
      if (this.colonneEnCours.equals("A")) {
         this.afficheFormuleA = false;
      } else if (this.colonneEnCours.equals("B")) {
         this.afficheFormuleB = false;
      } else if (this.colonneEnCours.equals("C")) {
         this.afficheFormuleC = false;
      } else if (this.colonneEnCours.equals("D")) {
         this.afficheFormuleD = false;
      } else if (this.colonneEnCours.equals("E")) {
         this.afficheFormuleE = false;
      }

      this.showModalPanelFormule = false;
   }

   public void validerFormule() throws HibernateException, NamingException {
      if (this.colonneEnCours.equals("A")) {
         this.afficheFormuleA = false;
      } else if (this.colonneEnCours.equals("B")) {
         this.afficheFormuleB = false;
      } else if (this.colonneEnCours.equals("C")) {
         this.afficheFormuleC = false;
      } else if (this.colonneEnCours.equals("D")) {
         this.afficheFormuleD = false;
      } else if (this.colonneEnCours.equals("E")) {
         this.afficheFormuleE = false;
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.planPaye = new PlanPaye();
         if (this.feuilleCalculRubrique.getFeurubCode() != null && !this.feuilleCalculRubrique.getFeurubCode().isEmpty()) {
            this.planPaye = this.planPayeDao.chercherCode(this.feuilleCalculRubrique.getFeurubCode(), this.exercicesPaye.getExepayId(), var1);
         }

         if (this.feuilleCalculRubrique.getFeurub_id() == 0L) {
            this.feuilleCalculRubrique.setFeuilleCalcul(this.feuilleCalcul);
            this.feuilleCalculRubrique.setPlanPaye(this.planPaye);
            this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.insert(this.feuilleCalculRubrique, var1);
         }

         this.feuilleCalculFormule.setFeuilleCalcul(this.feuilleCalcul);
         if (this.feuilleCalculFormule.getFeurubfor_id() == 0L) {
            this.feuilleCalculFormule.setFeurubforColonne(this.colonneEnCours);
            this.feuilleCalculFormule.setFeuilleCalculRubrique(this.feuilleCalculRubrique);
            this.feuilleCalculFormule.setFeurubforCode(this.feuilleCalculRubrique.getFeurubCode());
            this.feuilleCalculFormule = this.feuilleCalculFormuleDao.insert(this.feuilleCalculFormule, var1);
            if (this.colonneEnCours.equals("A")) {
               this.lesFormulesColA.add(this.feuilleCalculFormule);
               this.dataModelColA.setWrappedData(this.lesFormulesColA);
            } else if (this.colonneEnCours.equals("B")) {
               this.lesFormulesColB.add(this.feuilleCalculFormule);
               this.dataModelColB.setWrappedData(this.lesFormulesColB);
            } else if (this.colonneEnCours.equals("C")) {
               this.lesFormulesColC.add(this.feuilleCalculFormule);
               this.dataModelColC.setWrappedData(this.lesFormulesColC);
            } else if (this.colonneEnCours.equals("D")) {
               this.lesFormulesColD.add(this.feuilleCalculFormule);
               this.dataModelColD.setWrappedData(this.lesFormulesColD);
            } else if (this.colonneEnCours.equals("E")) {
               this.lesFormulesColE.add(this.feuilleCalculFormule);
               this.dataModelColE.setWrappedData(this.lesFormulesColE);
            }
         } else {
            this.feuilleCalculFormule = this.feuilleCalculFormuleDao.modif(this.feuilleCalculFormule, var1);
         }

         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelFormule = false;
      this.verifVariable();
   }

   public void AffecterSupp() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule(">");
   }

   public void AffecterSuppOrEq() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule(">=");
   }

   public void AffecterInf() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("<");
   }

   public void AffecterEq() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("=");
   }

   public void AffecterInfOrEq() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("<=");
   }

   public void AffecterDiff() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("<>");
   }

   public void AffecterEgal() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("==");
   }

   public void AffecterSi() {
      this.lesFonctions.clear();
      this.lesFonctions.add("SI(>):");
      this.lesFonctions.add("SI(>=):");
      this.lesFonctions.add("SI(<):");
      this.lesFonctions.add("SI(<=):");
      this.lesFonctions.add("SI(==):");
      this.lesFonctions.add("SI(<>):");
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("");
   }

   public void AffecterSinon() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("SINON");
   }

   public void AffecterFinSi() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("FINSI");
   }

   public void AffecterPlus() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("+");
   }

   public void AffecterMoins() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("-");
   }

   public void AffecterMulti() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("*");
   }

   public void AffecterDiv() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("/");
   }

   public void AffecterTot() {
      this.lesFonctions.clear();
      this.lesFonctions.add("TOT(BRUT)");
      this.lesFonctions.add("TOT(AVANTAGE_NATURE)");
      this.lesFonctions.add("TOT(INDEMNITE_COMPENSATRICE)");
      this.lesFonctions.add("TOT(BASE_FISCALE)");
      this.lesFonctions.add("TOT(BASE_FISCALE-N41)");
      this.lesFonctions.add("TOT(NET)");
      this.lesFonctions.add("TOT(INDEMNITES)");
      this.lesFonctions.add("TOT(RETENUES)");
      this.lesFonctions.add("TOT(NET_A_PAYER)");
      this.lesFonctions.add("TOT(109500-109559)");
      this.lesFonctions.add("TOT(109560-109599)");
      this.lesFonctions.add("TOT(NATURE_10)");
      this.lesFonctions.add("TOT(NATURE_11)");
      this.lesFonctions.add("TOT(NATURE_20)");
      this.lesFonctions.add("TOT(NATURE_21)");
      this.lesFonctions.add("TOT(NATURE_30)");
      this.lesFonctions.add("TOT(NATURE_40)");
      this.lesFonctions.add("TOT(NATURE_41)");
      this.lesFonctions.add("TOT(NATURE_42)");
      this.lesFonctions.add("TOT(NATURE_60)");
      this.lesFonctions.add("TOT(NATURE_61)");
      this.lesFonctions.add("TOT(NATURE_62)");
      this.lesFonctions.add("TOT(NATURE_90)");
      this.lesFonctions.add("TOT(BASE+SURSALAIRE)");
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("");
   }

   public void AffecterSom() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("SOM(:)");
   }

   public void AffecterCol() {
      this.lesFonctions.clear();
      this.lesFonctions.add("COL(A)");
      this.lesFonctions.add("COL(B)");
      this.lesFonctions.add("COL(C)");
      this.lesFonctions.add("COL(D)");
      this.lesFonctions.add("COL(E)");
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("");
   }

   public void AffecterVal() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("VAL()");
   }

   public void AffecterRub() {
      this.lesFonctions.clear();
      if (this.lesPlansPaye.size() != 0) {
         for(int var1 = 0; var1 < this.lesPlansPaye.size(); ++var1) {
            this.lesFonctions.add(((PlanPaye)this.lesPlansPaye.get(var1)).getPlpLibelleFR() + ":" + ((PlanPaye)this.lesPlansPaye.get(var1)).getPlpCode());
         }
      }

      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("RUB()");
   }

   public void AffecterMac() {
      this.lesFonctions.clear();
      this.lesFonctions.add("Salaire de base mensuel conventionné:M000001");
      this.lesFonctions.add("Prime d`ancienneté:M000002");
      this.lesFonctions.add("Nombre d`années de présence:M000003");
      this.lesFonctions.add("Congès payés = Base sur le brut:M000004");
      this.lesFonctions.add("Congès payés = Nombre de jours à prendre:M000005");
      this.lesFonctions.add("Congès payés = Indemnité de congés payés:M000006");
      this.lesFonctions.add("Congès payés = Indemnité de congés payés (simplifié):M000148");
      this.lesFonctions.add("Base imposable fiscale en cours:M000032");
      this.lesFonctions.add("Base imposable sociale en cours:M000033");
      this.lesFonctions.add("Calcul prêt interne:M000034");
      this.lesFonctions.add("Calcul prêt externe:M000035");
      this.lesFonctions.add("Calcul appoint précédent:M000036");
      this.lesFonctions.add("Calcul appoint à 100F supérieur:M000037");
      this.lesFonctions.add("Calcul appoint à 500F supérieur:M000038");
      this.lesFonctions.add("Calcul appoint à 1.000F supérieur:M000039");
      this.lesFonctions.add("Nombre de jours de présence:M000040");
      this.lesFonctions.add("Base imposable autre en cours:M000041");
      this.lesFonctions.add("Base imposable fiscale total:M000042");
      this.lesFonctions.add("Base imposable sociale total:M000043");
      this.lesFonctions.add("Base imposable autre total:M000044");
      this.lesFonctions.add("Base imposable patronale total:M000045");
      this.lesFonctions.add("Base imposable patronale en cours:M000046");
      this.lesFonctions.add("Plafond sécurité sociale (régime général):M000047");
      this.lesFonctions.add("Plafond sécurité sociale (régime cadre):M000048");
      this.lesFonctions.add("Plafond cotisation sociale:M000049");
      this.lesFonctions.add("Plafond prestation médicale:M000050");
      this.lesFonctions.add("SMIG (salaire minimum garanti):M000051");
      this.lesFonctions.add("Contrat sursalaire:M000052");
      this.lesFonctions.add("Contrat forfait heure supplémentaire:M000088");
      this.lesFonctions.add("Contrat prime de rendement:M000053");
      this.lesFonctions.add("Contrat prime de responsabilité:M000054");
      this.lesFonctions.add("Contrat prime de fonction:M000055");
      this.lesFonctions.add("Contrat prime de sujetion:M000082");
      this.lesFonctions.add("Contrat prime d`outillage:M000089");
      this.lesFonctions.add("Contrat prime d`astreinte:M000093");
      this.lesFonctions.add("Contrat indemnité de caisse:M000056");
      this.lesFonctions.add("Contrat indemnité de transport:M000057");
      this.lesFonctions.add("Contrat indemnité de logement:M000058");
      this.lesFonctions.add("Contrat indemnité de déplacement:M000059");
      this.lesFonctions.add("Contrat indemnité kilométrique:M000060");
      this.lesFonctions.add("Contrat indemnité de salissure:M000061");
      this.lesFonctions.add("Contrat indemnité de représentation:M000083");
      this.lesFonctions.add("Contrat avantage en nature logement:M000062");
      this.lesFonctions.add("Contrat avantage en nature domesticité:M000063");
      this.lesFonctions.add("Contrat avantage en nature de téléphone:M000064");
      this.lesFonctions.add("Contrat avantage en nature de eau:M000065");
      this.lesFonctions.add("Contrat avantage en nature de électricité:M000066");
      this.lesFonctions.add("Contrat avantage en nature de nourriture:M000067");
      this.lesFonctions.add("Contrat avantage en nature de véhicule:M000068");
      this.lesFonctions.add("Contrat forfait prestataire:M000084");
      this.lesFonctions.add("Contrat prime exceptionnelle fixe:M000147");
      this.lesFonctions.add("Congès payés = Indemnité sur ancienneté:M000069");
      this.lesFonctions.add("Congès payés = Indemnité sur enfants à charge:M000070");
      this.lesFonctions.add("Congès payés = Indemnité sur gardien:M000071");
      this.lesFonctions.add("Nombre d`enfants à charge:M000073");
      this.lesFonctions.add("Nombre de femmes:M000074");
      this.lesFonctions.add("Nombre de parts fiscales:M000075");
      this.lesFonctions.add("Nombre de parts TRIMF:M000076");
      this.lesFonctions.add("Base heures supplémentaires de référence:M000078");
      this.lesFonctions.add("Nombre enfants d`allocation:M000081");
      this.lesFonctions.add("Calcul appoint = net à atteindre:M000085");
      this.lesFonctions.add("Uniquement pour Locaux:M000086");
      this.lesFonctions.add("Uniquement pour Etrangers:M000087");
      this.lesFonctions.add("Nombre de mois de présence:M000090");
      this.lesFonctions.add("Capitalisation (Versement):M000091");
      this.lesFonctions.add("Capitalisation (Solde):M000092");
      this.lesFonctions.add("Stage Calcul brut total du stage:M000094");
      this.lesFonctions.add("Stage Calcul prime de précarité (fin contrat stage):M000095");
      this.lesFonctions.add("Base de référence spécifique:M000096");
      this.lesFonctions.add("Calcul appoint à 10F supérieur:M000101");
      this.lesFonctions.add("Calcul regul.paye en net:M000129");
      this.lesFonctions.add("Uniquement pour Cadres:M000130");
      this.lesFonctions.add("Uniquement pour Non Cadres:M000131");
      this.lesFonctions.add("Uniquement pour Techniciens:M000132");
      this.lesFonctions.add("Uniquement pour Main d`oeuvres:M000133");
      this.lesFonctions.add("Déduction salaire négatif (699999) M-1:M000134");
      this.lesFonctions.add("Déduction avance congés (208030) M-1:M000136");
      this.lesFonctions.add("Nombre d`heures de retard:M000137");
      this.lesFonctions.add("Base congés spécifique:M000149");
      this.lesFonctions.add("Convention Taux accident de travail:M000152");
      this.lesFonctions.add("Nombre de jours d`absence pour repos maladie:M000153");
      this.lesFonctions.add("Contrat indemnité diverse:M000154");
      this.lesFonctions.add("Nombre d`heures réelles du mois:M000155");
      this.lesFonctions.add("Contrat indemnité de responsabilité:M000156");
      this.lesFonctions.add("Contrat indemnité de nourriture:M000157");
      this.lesFonctions.add("Nombre d`heures de la convention:M000158");
      this.lesFonctions.add("Calcul appoint à 5F supérieur:M000159");
      this.lesFonctions.add("Contrat prime de transport:M000225");
      this.lesFonctions.add("Contrat prime de logement:M000226");
      this.lesFonctions.add("Contrat nb heure/mois:M000227");
      this.lesFonctions.add("Nombre de jours réel de présence:M000228");
      this.lesFonctions.add("Nombre de jours d`absences non payées:M000232");
      this.lesFonctions.add("Nombre de jours d`absences payées:M000233");
      this.lesFonctions.add("Nombre de jours d`absences payées à déduire sur congés:M000234");
      this.lesFonctions.add("Nombre de jours d`absences pour visite médicale:M000235");
      if (this.structureLog.getStrcodepays().equals("0029")) {
         this.lesFonctions.add("* Taux CNSS (P.S.):M000181");
         this.lesFonctions.add("* Calcul CNSS (P.S.):M000182");
         this.lesFonctions.add("* Calcul IRPP:M000183");
         this.lesFonctions.add("* Taux Régime retraite (P.P.):M000184");
         this.lesFonctions.add("* Calcul Régime retraite (P.P.):M000185");
         this.lesFonctions.add("* Taux Prestations familiales (P.P.):M000186");
         this.lesFonctions.add("* Calcul Prestations familiales (P.P.):M000187");
         this.lesFonctions.add("* Taux Accident de travail (P.P.):M000188");
         this.lesFonctions.add("* Calcul Accident de travail (P.P.):M000189");
         this.lesFonctions.add("* Taux VPS (P.P.):M000190");
         this.lesFonctions.add("* Calcul VPS (P.P.):M000191");
      } else if (!this.structureLog.getStrcodepays().equals("0041")) {
         if (this.structureLog.getStrcodepays().equals("0050")) {
            this.lesFonctions.add("* Plafond CNSS:M000160");
            this.lesFonctions.add("* Salaire Plafonné CNSS:M000161");
            this.lesFonctions.add("* Base CNSS:M000162");
            this.lesFonctions.add("* Taux CNSS (P.S.):M000163");
            this.lesFonctions.add("* Calcul CNSS (P.S.):M000164");
            this.lesFonctions.add("* Taux CNSS (P.P.):M000165");
            this.lesFonctions.add("* Calcul CNSS (P.P.):M000166");
            this.lesFonctions.add("* Base I.R.P.P.:M000167");
            this.lesFonctions.add("* Calcul IRPP:M000168");
            this.lesFonctions.add("* Taux Prestations familiales:M000245");
            this.lesFonctions.add("* Taux Accident de travail:M000246");
            this.lesFonctions.add("* Taux TUS (P.P.):M000236");
            this.lesFonctions.add("* Calcul TUS (P.P.):M000237");
            this.lesFonctions.add("* Taxe TOL (Centre ville):M000238");
            this.lesFonctions.add("* Taxe TOL (Périphérie):M000239");
            this.lesFonctions.add("* Calcul TOL:M000241");
            this.lesFonctions.add("* Plafond Prestations familiales et accidents travail:M000240");
            this.lesFonctions.add("* Calcul Prestations familiales:M000242");
            this.lesFonctions.add("* Calcul Accident de travail:M000243");
            this.lesFonctions.add("* Calcul Prime Eloignement:M000244");
         } else if (!this.structureLog.getStrcodepays().equals("0056")) {
            if (this.structureLog.getStrcodepays().equals("0077")) {
               this.lesFonctions.add("* Calcul CNSS (P.S.):M000024");
               this.lesFonctions.add("* Calcul CNSS (P.P.):M000025");
               this.lesFonctions.add("* Calcul TCS:M000026");
               this.lesFonctions.add("* Calcul IRPP:M000027");
               this.lesFonctions.add("* Calcul Centimes additionnels:M000028");
               this.lesFonctions.add("* Calcul Contribution développement routier:M000029");
               this.lesFonctions.add("* Calcul TV:M000030");
               this.lesFonctions.add("* Calcul TFSN:M000031");
               this.lesFonctions.add("* Calcul CNAMGS (P.S.):M000113");
               this.lesFonctions.add("* Calcul CNAMGS (P.P.):M000114");
               this.lesFonctions.add("* Calcul FNH:M000115");
               this.lesFonctions.add("* Taux CNSS (P.S.):M000116");
               this.lesFonctions.add("* Taux CNSS (P.P.):M000117");
               this.lesFonctions.add("* Taux CNAMGS (P.S.):M000118");
               this.lesFonctions.add("* Taux CNAMGS (P.P.):M000119");
               this.lesFonctions.add("* Plafond CNSS:M000120");
               this.lesFonctions.add("* Plafond CNAMGS:M000121");
               this.lesFonctions.add("* Calcul VF:M000122");
               this.lesFonctions.add("* Calcul TFP:M000123");
               this.lesFonctions.add("* Salaire Plafonné CNSS:M000124");
               this.lesFonctions.add("* Salaire Plafonné CNAMGS:M000125");
               this.lesFonctions.add("* Taux FNH:M000126");
               this.lesFonctions.add("* Base CNSS:M000127");
               this.lesFonctions.add("* Base CNAMGS:M000128");
               this.lesFonctions.add("* Calcul prime de solidarité:M000135");
               this.lesFonctions.add("* Taux C.F.P. (P.P.):M000138");
               this.lesFonctions.add("* Calcul C.F.P. (P.P.):M000139");
               this.lesFonctions.add("* Base T.C.S.:M000150");
               this.lesFonctions.add("* Base I.R.P.P.:M000151");
               this.lesFonctions.add("* Base Avantages en nature.:M000231");
            } else if (this.structureLog.getStrcodepays().equals("0078")) {
               this.lesFonctions.add("* Calcul Taxe (incom tax):M000179");
               this.lesFonctions.add("* Calcul Taxe Complémentaire:M000180");
            } else if (this.structureLog.getStrcodepays().equals("0088")) {
               this.lesFonctions.add("* Calcul RTS Retenue sur Traitement et Salaire:M000102");
               this.lesFonctions.add("* Calcul CNSS Prestations familiales (P.S.):M000103");
               this.lesFonctions.add("* Calcul CNSS Risques Professionnels (P.S.):M000104");
               this.lesFonctions.add("* Calcul CNSS Assurance Maladie (P.S.):M000105");
               this.lesFonctions.add("* Calcul CNSS Veillesse-décés-Invalidité (P.S.):M000106");
               this.lesFonctions.add("* Calcul VF Versements Forfaitaires sur Salaires:M000107");
               this.lesFonctions.add("* Calcul TA Taxe d`apprentissage:M000108");
               this.lesFonctions.add("* Calcul CNSS Prestations familiales (P.P.):M000109");
               this.lesFonctions.add("* Calcul CNSS Risques Professionnels (P.P.):M000110");
               this.lesFonctions.add("* Calcul CNSS Assurance Maladie (P.P.):M000111");
               this.lesFonctions.add("* Calcul CNSS Veillesse-décés-Invalidité (P.P.):M000112");
            } else if (this.structureLog.getStrcodepays().equals("0089")) {
               this.lesFonctions.add("* Plafond CNSS:M000205");
               this.lesFonctions.add("* Taux CNSS Assurance maladie (P.S.):M000206");
               this.lesFonctions.add("* Calcul CNSS Assurance maladie (P.S.):M000207");
               this.lesFonctions.add("* Taux CNSS Retraite-décés-Invalidité (P.S.):M000208");
               this.lesFonctions.add("* Calcul CNSS Retraite-décés-invalidité (P.S.):M000209");
               this.lesFonctions.add("* Calcul RTS Retenue sur Traitement et Salaire:M000210");
               this.lesFonctions.add("* Taux CNSS Assurance Maladie (P.P.):M000211");
               this.lesFonctions.add("* Calcul CNSS Assurance Maladie (P.P.):M000212");
               this.lesFonctions.add("* Taux CNSS Retraite-décés-Invalidité (P.P.):M000213");
               this.lesFonctions.add("* Calcul CNSS Retraite-décés-Invalidité (P.P.):M000214");
               this.lesFonctions.add("* Taux CNSS Accidents de traval (P.P.):M000215");
               this.lesFonctions.add("* Calcul CNSS Accidents de traval (P.P.):M000216");
               this.lesFonctions.add("* Taux CNSS Prestations familiales (P.P.):M000217");
               this.lesFonctions.add("* Calcul CNSS Prestations familiales (P.P.):M000218");
               this.lesFonctions.add("* Taux VF Versements Forfaitaires sur Salaires:M000219");
               this.lesFonctions.add("* Calcul VF Versements Forfaitaires sur Salaires:M000220");
               this.lesFonctions.add("* Taux TA Taxe d`apprentissage:M000221");
               this.lesFonctions.add("* Calcul TA Taxe d`apprentissage:M000222");
               this.lesFonctions.add("* Taux CFPA  Contribution à la Formation Professionnelle et à l`Apprentissage:M000223");
               this.lesFonctions.add("* Calcul CFPA  Contribution à la Formation Professionnelle et à l`Apprentissage:M000224");
            } else if (!this.structureLog.getStrcodepays().equals("0090")) {
               if (this.structureLog.getStrcodepays().equals("0138")) {
                  this.lesFonctions.add("* Calcul INPS RETRAITE (P.S.):M000017");
                  this.lesFonctions.add("* Calcul INPS RETRAITE (P.P.):M000018");
                  this.lesFonctions.add("* Calcul ITS:M000019");
                  this.lesFonctions.add("* Calcul Contribution forfaitaire (PP):M000020");
                  this.lesFonctions.add("* Calcul Taxe de formation (P.P.):M000021");
                  this.lesFonctions.add("* Calcul Taxe de logement (P.P.):M000022");
                  this.lesFonctions.add("* Calcul Taxe emploi jeune (P.P.):M000023");
                  this.lesFonctions.add("* Calcul AMO (P.S.):M000079");
                  this.lesFonctions.add("* Calcul AMO (P.P.):M000080");
                  this.lesFonctions.add("* Calcul Invalidité (P.P.):M000097");
                  this.lesFonctions.add("* Calcul Prestations familiales (P.P.):M000098");
                  this.lesFonctions.add("* Calcul ATMP (P.P.):M000099");
                  this.lesFonctions.add("* Calcul ANPE (P.P.):M000100");
               } else if (!this.structureLog.getStrcodepays().equals("0142")) {
                  if (this.structureLog.getStrcodepays().equals("0202")) {
                     this.lesFonctions.add("* Calcul IPRESS (P.S.):M000007");
                     this.lesFonctions.add("* Calcul IPRESS (P.P.):M000008");
                     this.lesFonctions.add("* Calcul IPRESS CADRE (P.S.):M000009");
                     this.lesFonctions.add("* Calcul IPRESS CADRE (P.P.):M000010");
                     this.lesFonctions.add("* Calcul IPM (P.S.):M000011");
                     this.lesFonctions.add("* Calcul IPM (P.P.):M000012");
                     this.lesFonctions.add("* Calcul I.R.:M000013");
                     this.lesFonctions.add("* Calcul TRIMF:M000014");
                     this.lesFonctions.add("* Calcul CSS-Prestations familiales:M000015");
                     this.lesFonctions.add("* Calcul CSS-Accident de travail:M000016");
                     this.lesFonctions.add("* Calcul C.F.C.E.:M000077");
                     this.lesFonctions.add("* Taux IPRESS Régime général (P.S.):M000140");
                     this.lesFonctions.add("* Taux IPRESS Régime cadre (P.S.):M000141");
                     this.lesFonctions.add("* Taux IPRESS Régime général (P.P.):M000142");
                     this.lesFonctions.add("* Taux IPRESS Régime cadre (P.P.):M000143");
                     this.lesFonctions.add("* Taux CSS-Prestations familiales:M000144");
                     this.lesFonctions.add("* Taux CSS-Accident de travail:M000145");
                     this.lesFonctions.add("* Taux C.F.C.E.:M000146");
                     this.lesFonctions.add("Congès payés = Indemnité sur médaille du travail:M000072");
                     this.lesFonctions.add("Congès payés = Indemnité complémentaire:M000229");
                     this.lesFonctions.add("Congès payés = Indemnité supplémentaire cadre:M000230");
                  } else if (this.structureLog.getStrcodepays().equals("0222")) {
                     this.lesFonctions.add("* Taux CNSS (P.S.):M000192");
                     this.lesFonctions.add("* Calcul CNSS (P.S.):M000193");
                     this.lesFonctions.add("* Calcul IRPP:M000194");
                     this.lesFonctions.add("* Plafond TCS (P.S.):M000195");
                     this.lesFonctions.add("* Calcul TCS (P.S.):M000196");
                     this.lesFonctions.add("* Taux Régime retraite (P.P.):M000197");
                     this.lesFonctions.add("* Calcul Régime retraite (P.P.):M000198");
                     this.lesFonctions.add("* Taux Prestations familiales (P.P.):M000199");
                     this.lesFonctions.add("* Calcul Prestations familiales (P.P.):M000200");
                     this.lesFonctions.add("* Taux Accident de travail (P.P.):M000201");
                     this.lesFonctions.add("* Calcul Accident de travail (P.P.):M000202");
                     this.lesFonctions.add("* Taux Taxe sur les salaire (P.P.):M000203");
                     this.lesFonctions.add("* Calcul Taxe sur les salaires (P.P.):M000204");
                  }
               }
            }
         }
      }

      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("MAC()");
   }

   public void AffecterSal() {
      this.lesFonctions.clear();
      this.lesFonctions.add("Etat = 0=actif 1=en congés 2=licencié 3=démissionné 4=décédé 5=retraité 6=fin de contrat 7=arrêt ou suspension:saleleEtat");
      this.lesFonctions.add("Genre = 0=femme 1=homme:saleleGenre");
      this.lesFonctions.add("Situation familliale = 0=célibataire 1=marié 2=concubin 3=pacsé 4=divorcé 5=veuf:saleleSitFamille");
      this.lesFonctions.add("Nombre d`enfants:saleleNbEnfant");
      this.lesFonctions.add("Nombre de parts fiscales:saleleNbPartFiscal");
      this.lesFonctions.add("Nombre de femmes:saleleNbFemme");
      this.lesFonctions.add("Nombre de part TRIMF:saleleNbPartTrimf");
      this.lesFonctions.add("Régime de congés : nb jour de congés:saleleNbJourCp");
      this.lesFonctions.add("Régime de congés : nb jour de travail:saleleNbJourTr");
      this.lesFonctions.add("Numéro de feuille de calcul:saleleFeuille");
      this.lesFonctions.add("Prime de rendement :salconPrimeRendement");
      this.lesFonctions.add("Prime de responsabilité :salconPrimeResponsabilite");
      this.lesFonctions.add("Prime de fonction :salconPrimeFonction");
      this.lesFonctions.add("Indemnité de caisse :salconIndemniteCaisse");
      this.lesFonctions.add("Indemnité de Transport :salconIndemniteTransport");
      this.lesFonctions.add("Indemnité de Logement :salconIndemniteLogement");
      this.lesFonctions.add("Avantage en nature (Logement):salconAvnLogement");
      this.lesFonctions.add("Avantage en nature (Domesticité):salconAvnDomesticite");
      this.lesFonctions.add("Avantage en nature (Eau):salconAvnEau");
      this.lesFonctions.add("Avantage en nature (Electricité):salconAvnElectricite");
      this.lesFonctions.add("Avantage en nature (Nourriture):salconAvnNourriture");
      this.lesFonctions.add("Avantage en nature (Vehicule):salconAvnVehicule");
      this.lesFonctions.add("Avantage en nature (Téléphone):salconAvnTelephone");
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("SAL()");
   }

   public void AffecterVar() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("VAR()");
   }

   public void AffecterTst() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("TST(E)");
   }

   public void AffecterAbs() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("ABS()");
   }

   public void AffecterArr() {
      this.lesFonctions.clear();
      this.lesFonctions.add("ARR(0)");
      this.lesFonctions.add("ARR(1)");
      this.lesFonctions.add("ARR(2)");
      this.lesFonctions.add("ARR(3)");
      this.lesFonctions.add("ARR(4)");
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("ARR(0)");
   }

   public void AffecterInv() {
      this.lesFonctions.clear();
      this.dataModelFonction.setWrappedData(this.lesFonctions);
      this.feuilleCalculFormule.setFeurubforFormule("INV()");
   }

   public void selectionFonction() {
      if (this.dataModelFonction.isRowAvailable()) {
         this.fonction = (String)this.dataModelFonction.getRowData();
         if (this.feuilleCalculFormule.getFeurubforFormule().equals("RUB()")) {
            String[] var1 = this.fonction.split(":");
            this.feuilleCalculFormule.setFeurubforFormule("RUB(" + var1[1] + ":E)");
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("SAL()")) {
            this.feuilleCalculFormule.setFeurubforFormule("SAL(" + this.fonction + ")");
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("MAC()")) {
            this.feuilleCalculFormule.setFeurubforFormule("MAC(" + this.fonction + ")");
         } else {
            this.feuilleCalculFormule.setFeurubforFormule(this.fonction);
         }
      }

   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.format = "XML";
      this.imprimer();
   }

   public void imprimer() throws JRException, IOException, SQLException, ClassNotFoundException, Exception {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilPrint.setBaseLog(this.baseLog);
      this.utilPrint.setStructureLog(this.structureLog);
      this.utilPrint.setUsersLog(this.usersLog);
      this.utilPrint.setFormat(this.format);
      this.utilPrint.setTiersSelectionne((Tiers)null);
      JRBeanCollectionDataSource var1 = null;
      this.utilPrint.setRapport("StructureFeuille");
      this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator);
      this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
      this.utilPrint.setEntete("Structure de la feuille de calcul n° " + this.feuilleCalcul.getFeuCode());
      ArrayList var2 = new ArrayList();
      Object var3 = new ArrayList();
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanPaye");
      if (this.lesRubriques.size() != 0) {
         for(int var5 = 0; var5 < this.lesRubriques.size(); ++var5) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var5);
            if (this.feuilleCalculRubrique.isFeurubActif()) {
               this.feuilleCalculRubrique.setFormuleA("");
               this.feuilleCalculRubrique.setFormuleB("");
               this.feuilleCalculRubrique.setFormuleC("");
               this.feuilleCalculRubrique.setFormuleD("");
               this.feuilleCalculRubrique.setFormuleE("");
               ((List)var3).clear();
               var3 = this.feuilleCalculFormuleDao.chargerRubriqueFeuille(this.feuilleCalculRubrique, var4);
               String var6;
               int var7;
               if (this.feuilleCalculRubrique.isFeurubColA()) {
                  var6 = "";

                  for(var7 = 0; var7 < ((List)var3).size(); ++var7) {
                     this.feuilleCalculFormule = (FeuilleCalculFormule)((List)var3).get(var7);
                     if (this.feuilleCalculFormule.getFeurubforColonne().equals("A")) {
                        if (var6 != null && !var6.isEmpty()) {
                           var6 = var6 + System.getProperty("line.separator") + this.feuilleCalculFormule.getFeurubforFormule();
                        } else {
                           var6 = this.feuilleCalculFormule.getFeurubforFormule();
                        }
                     }
                  }

                  this.feuilleCalculRubrique.setFormuleA(var6);
               }

               if (this.feuilleCalculRubrique.isFeurubColB()) {
                  var6 = "";

                  for(var7 = 0; var7 < ((List)var3).size(); ++var7) {
                     this.feuilleCalculFormule = (FeuilleCalculFormule)((List)var3).get(var7);
                     if (this.feuilleCalculFormule.getFeurubforColonne().equals("B")) {
                        if (var6 != null && !var6.isEmpty()) {
                           var6 = var6 + System.getProperty("line.separator") + this.feuilleCalculFormule.getFeurubforFormule();
                        } else {
                           var6 = this.feuilleCalculFormule.getFeurubforFormule();
                        }
                     }
                  }

                  this.feuilleCalculRubrique.setFormuleB(var6);
               }

               if (this.feuilleCalculRubrique.isFeurubColC()) {
                  var6 = "";

                  for(var7 = 0; var7 < ((List)var3).size(); ++var7) {
                     this.feuilleCalculFormule = (FeuilleCalculFormule)((List)var3).get(var7);
                     if (this.feuilleCalculFormule.getFeurubforColonne().equals("C")) {
                        if (var6 != null && !var6.isEmpty()) {
                           var6 = var6 + System.getProperty("line.separator") + this.feuilleCalculFormule.getFeurubforFormule();
                        } else {
                           var6 = this.feuilleCalculFormule.getFeurubforFormule();
                        }
                     }
                  }

                  this.feuilleCalculRubrique.setFormuleC(var6);
               }

               if (this.feuilleCalculRubrique.isFeurubColD()) {
                  var6 = "";

                  for(var7 = 0; var7 < ((List)var3).size(); ++var7) {
                     this.feuilleCalculFormule = (FeuilleCalculFormule)((List)var3).get(var7);
                     if (this.feuilleCalculFormule.getFeurubforColonne().equals("D")) {
                        if (var6 != null && !var6.isEmpty()) {
                           var6 = var6 + System.getProperty("line.separator") + this.feuilleCalculFormule.getFeurubforFormule();
                        } else {
                           var6 = this.feuilleCalculFormule.getFeurubforFormule();
                        }
                     }
                  }

                  this.feuilleCalculRubrique.setFormuleD(var6);
               }

               if (this.feuilleCalculRubrique.isFeurubColE()) {
                  var6 = "";

                  for(var7 = 0; var7 < ((List)var3).size(); ++var7) {
                     this.feuilleCalculFormule = (FeuilleCalculFormule)((List)var3).get(var7);
                     if (this.feuilleCalculFormule.getFeurubforColonne().equals("E")) {
                        if (var6 != null && !var6.isEmpty()) {
                           var6 = var6 + System.getProperty("line.separator") + this.feuilleCalculFormule.getFeurubforFormule();
                        } else {
                           var6 = this.feuilleCalculFormule.getFeurubforFormule();
                        }
                     }
                  }

                  this.feuilleCalculRubrique.setFormuleE(var6);
               }

               var2.add(this.feuilleCalculRubrique);
            }
         }
      }

      this.utilInitHibernate.closeSession();
      var1 = new JRBeanCollectionDataSource(var2);
      this.utilPrint.setjRBeanCollectionDataSource(var1);
      this.utilPrint.imprimeRapport();
   }

   public boolean isAfficheFeuille() {
      return this.afficheFeuille;
   }

   public void setAfficheFeuille(boolean var1) {
      this.afficheFeuille = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public DataModel getDataModelFeuillesCalcul() {
      return this.dataModelFeuillesCalcul;
   }

   public void setDataModelFeuillesCalcul(DataModel var1) {
      this.dataModelFeuillesCalcul = var1;
   }

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
   }

   public FeuilleCalcul getFeuilleCalcul() {
      return this.feuilleCalcul;
   }

   public void setFeuilleCalcul(FeuilleCalcul var1) {
      this.feuilleCalcul = var1;
   }

   public boolean isShowModalPanelFeuille() {
      return this.showModalPanelFeuille;
   }

   public void setShowModalPanelFeuille(boolean var1) {
      this.showModalPanelFeuille = var1;
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

   public String getNature() {
      return this.nature;
   }

   public void setNature(String var1) {
      this.nature = var1;
   }

   public int getUtilisation() {
      return this.utilisation;
   }

   public void setUtilisation(int var1) {
      this.utilisation = var1;
   }

   public boolean isExisteCopteDeja() {
      return this.existeCopteDeja;
   }

   public void setExisteCopteDeja(boolean var1) {
      this.existeCopteDeja = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public boolean isAfficheAjDefaut() {
      return this.afficheAjDefaut;
   }

   public void setAfficheAjDefaut(boolean var1) {
      this.afficheAjDefaut = var1;
   }

   public List getLesFeuillesCalcul() {
      return this.lesFeuillesCalcul;
   }

   public void setLesFeuillesCalcul(List var1) {
      this.lesFeuillesCalcul = var1;
   }

   public List getMesNaturesItems() {
      return this.mesNaturesItems;
   }

   public void setMesNaturesItems(List var1) {
      this.mesNaturesItems = var1;
   }

   public List getMesJournauxItems() {
      return this.mesJournauxItems;
   }

   public void setMesJournauxItems(List var1) {
      this.mesJournauxItems = var1;
   }

   public List getMesModelesItems() {
      return this.mesModelesItems;
   }

   public void setMesModelesItems(List var1) {
      this.mesModelesItems = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public DataModel getDataModelRubrique() {
      return this.dataModelRubrique;
   }

   public void setDataModelRubrique(DataModel var1) {
      this.dataModelRubrique = var1;
   }

   public boolean isShowModalPanelRubrique() {
      return this.showModalPanelRubrique;
   }

   public void setShowModalPanelRubrique(boolean var1) {
      this.showModalPanelRubrique = var1;
   }

   public FeuilleCalculRubrique getFeuilleCalculRubrique() {
      return this.feuilleCalculRubrique;
   }

   public void setFeuilleCalculRubrique(FeuilleCalculRubrique var1) {
      this.feuilleCalculRubrique = var1;
   }

   public DataModel getDataModelColA() {
      return this.dataModelColA;
   }

   public void setDataModelColA(DataModel var1) {
      this.dataModelColA = var1;
   }

   public DataModel getDataModelColB() {
      return this.dataModelColB;
   }

   public void setDataModelColB(DataModel var1) {
      this.dataModelColB = var1;
   }

   public DataModel getDataModelColC() {
      return this.dataModelColC;
   }

   public void setDataModelColC(DataModel var1) {
      this.dataModelColC = var1;
   }

   public DataModel getDataModelColD() {
      return this.dataModelColD;
   }

   public void setDataModelColD(DataModel var1) {
      this.dataModelColD = var1;
   }

   public DataModel getDataModelColE() {
      return this.dataModelColE;
   }

   public void setDataModelColE(DataModel var1) {
      this.dataModelColE = var1;
   }

   public String getStyleColonne() {
      return this.styleColonne;
   }

   public void setStyleColonne(String var1) {
      this.styleColonne = var1;
   }

   public int getNbColonne() {
      return this.nbColonne;
   }

   public void setNbColonne(int var1) {
      this.nbColonne = var1;
   }

   public boolean isAfficheFormuleA() {
      return this.afficheFormuleA;
   }

   public void setAfficheFormuleA(boolean var1) {
      this.afficheFormuleA = var1;
   }

   public boolean isAfficheFormuleB() {
      return this.afficheFormuleB;
   }

   public void setAfficheFormuleB(boolean var1) {
      this.afficheFormuleB = var1;
   }

   public boolean isAfficheFormuleC() {
      return this.afficheFormuleC;
   }

   public void setAfficheFormuleC(boolean var1) {
      this.afficheFormuleC = var1;
   }

   public boolean isAfficheFormuleD() {
      return this.afficheFormuleD;
   }

   public void setAfficheFormuleD(boolean var1) {
      this.afficheFormuleD = var1;
   }

   public boolean isAfficheFormuleE() {
      return this.afficheFormuleE;
   }

   public void setAfficheFormuleE(boolean var1) {
      this.afficheFormuleE = var1;
   }

   public FeuilleCalculFormule getFeuilleCalculFormule() {
      return this.feuilleCalculFormule;
   }

   public void setFeuilleCalculFormule(FeuilleCalculFormule var1) {
      this.feuilleCalculFormule = var1;
   }

   public boolean isShowModalPanelFormule() {
      return this.showModalPanelFormule;
   }

   public void setShowModalPanelFormule(boolean var1) {
      this.showModalPanelFormule = var1;
   }

   public DataModel getDataModelFonction() {
      return this.dataModelFonction;
   }

   public void setDataModelFonction(DataModel var1) {
      this.dataModelFonction = var1;
   }

   public String getFonction() {
      return this.fonction;
   }

   public void setFonction(String var1) {
      this.fonction = var1;
   }

   public boolean isSaisieCode() {
      return this.saisieCode;
   }

   public void setSaisieCode(boolean var1) {
      this.saisieCode = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
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

   public boolean isExerciceCompta() {
      return this.exerciceCompta;
   }

   public void setExerciceCompta(boolean var1) {
      this.exerciceCompta = var1;
   }
}
