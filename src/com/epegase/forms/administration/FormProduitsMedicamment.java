package com.epegase.forms.administration;

import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.PegMedicemment;
import com.epegase.systeme.classe.PegMedicemmentDci;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDci;
import com.epegase.systeme.classe.ProduitsMedicamment;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.FileCtrl;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.PegMedicammentDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsMedicammentDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

public class FormProduitsMedicamment implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private List lesMedicamments = new ArrayList();
   private transient DataModel madatamodel = new ListDataModel();
   private List mesdciItems = new ArrayList();
   private List mesclasseItems = new ArrayList();
   private List mestypeItems = new ArrayList();
   private ProduitsMedicamment produitsMedicamment;
   private ProduitsMedicammentDao produitsMedicammentDao;
   private ProduitsAchsDao produitsDao;
   private FamillesProduitsVentesDao famillesProduitsMedicalDao;
   private ProduitsDci produitsDci = new ProduitsDci();
   private String var_typeFind = "";
   private String var_cipFind = "";
   private String var_speFind = "";
   private String var_dciFind = "";
   private String var_classeFind = "";
   private boolean afficheButtModif = false;
   private boolean affiche_dci = false;
   private boolean showModalPanelBasePublique = false;
   private FileCtrl fileCtrl;
   private ArrayList listFiles = new ArrayList();
   private UploadItem item;
   private int uploadsAvailable = 1;
   private List listeImporter = new ArrayList();

   public void instanceDaoUtilises() {
      this.produitsMedicammentDao = new ProduitsMedicammentDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsMedicalDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void rechercherProduit() throws HibernateException, NamingException {
      int var1 = Integer.parseInt(this.var_typeFind);
      if (this.var_dciFind.equalsIgnoreCase("100")) {
         this.var_dciFind = "";
      }

      if (this.var_classeFind.equalsIgnoreCase("100")) {
         this.var_classeFind = "";
      }

      this.lesMedicamments = this.produitsMedicammentDao.rechercheMedicamments(var1, this.var_cipFind, this.var_speFind, this.var_dciFind, this.var_classeFind, (Session)null);
      this.madatamodel.setWrappedData(this.lesMedicamments);
   }

   public void effaceRecherche() {
      this.lesMedicamments.clear();
      this.madatamodel.setWrappedData(this.lesMedicamments);
   }

   public void calculeSelectItem() throws HibernateException, NamingException {
      this.calculeSelectItem((Session)null);
   }

   public void calculeSelectItem(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
         var2 = true;
      }

      if (this.var_typeFind == null || this.var_typeFind.isEmpty()) {
         this.var_typeFind = "0";
      }

      int var3 = Integer.parseInt(this.var_typeFind);
      this.mesclasseItems.clear();
      this.mesclasseItems = this.produitsMedicammentDao.listeClasseItems(var3, var1);
      this.mesdciItems.clear();
      this.mesdciItems = this.produitsMedicammentDao.listeDciItems(var3, var1);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      this.effaceRecherche();
   }

   public void selectionMedicamment() throws HibernateException, NamingException {
      if (this.madatamodel.isRowAvailable()) {
         this.produitsMedicamment = (ProduitsMedicamment)this.madatamodel.getRowData();
         this.afficheButtModif = true;
         this.affiche_dci = false;
         if (this.produitsMedicamment.getPromdcCodeDci() != null && !this.produitsMedicamment.getPromdcCodeDci().isEmpty()) {
            this.produitsDci = new ProduitsDci();
            this.produitsDci = this.produitsMedicammentDao.rechercheDci(this.produitsMedicamment.getPromdcCodeDci(), (Session)null);
            if (this.produitsDci != null) {
               this.affiche_dci = true;
            }
         }
      }

   }

   public void transfMedicammentProduit() throws HibernateException, NamingException {
      if (this.lesMedicamments.size() != 0) {
         this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
         FamillesProduitsVentes var2 = this.famillesProduitsMedicalDao.FamillesProduitsMedicalByNature("1105", var1);
         if (var2 != null) {
            Transaction var3 = null;

            try {
               var3 = var1.beginTransaction();
               new ProduitsMedicamment();

               for(int var5 = 0; var5 < this.lesMedicamments.size(); ++var5) {
                  ProduitsMedicamment var4 = (ProduitsMedicamment)this.lesMedicamments.get(var5);
                  String var6 = "";
                  if (var4.getPromdcCodeCis() != null && !var4.getPromdcCodeCis().isEmpty() && var4.getPromdcCodeCis().length() >= 2) {
                     var6 = var4.getPromdcCodeCis();
                  } else if (var4.getPromdcCodeCip() != null && !var4.getPromdcCodeCip().isEmpty() && var4.getPromdcCodeCip().length() >= 2) {
                     var6 = var4.getPromdcCodeCip();
                  }

                  if (var6 != null && !var6.isEmpty() && var6.length() >= 2) {
                     new Produits();
                     Produits var7 = this.produitsDao.existCodeProduit(var6, var1);
                     if (var7 == null) {
                        Produits var8 = new Produits();
                        var8.setProDateCreat(new Date());
                        var8.setProUserCreat(this.usersLog.getUsrid());
                        var8.setProVteNat("1105");
                        var8.setProVteCode(var2.getFamvteCode());
                        var8.setProVteLib(var2.getFamvteLibelleFr());
                        var8.setProVteCpteZ(var2.getFamvteCompteZone());
                        var8.setProVteCpteHz(var2.getFamvteCompteExterieur());
                        var8.setProVteCpteLoc(var2.getFamvteCompteLocal());
                        var8.setProVteCptePr(var2.getFamvteCompteProduit());
                        var8.setProVteCpteSt(var2.getFamvteCompteStock());
                        var8.setProVteDouane(var2.getFamvteDouane());
                        var8.setProVteTva(var2.getFamvteTaxe());
                        var8.setProCode(var6);
                        var8.setProLibClient(var4.getPromdcSpecialite());
                        var8.setProLibTech(var4.getPromdcCodeDci());
                        this.produitsDao.insert(var8, var1);
                     } else {
                        var7.setProDateModif(new Date());
                        var7.setProUserModif(this.usersLog.getUsrid());
                        var7.setProVteNat("1105");
                        var7.setProVteCode(var2.getFamvteCode());
                        var7.setProVteLib(var2.getFamvteLibelleFr());
                        var7.setProVteCpteZ(var2.getFamvteCompteZone());
                        var7.setProVteCpteHz(var2.getFamvteCompteExterieur());
                        var7.setProVteCpteLoc(var2.getFamvteCompteLocal());
                        var7.setProVteCptePr(var2.getFamvteCompteProduit());
                        var7.setProVteCpteSt(var2.getFamvteCompteStock());
                        var7.setProVteDouane(var2.getFamvteDouane());
                        var7.setProVteTva(var2.getFamvteTaxe());
                        var7.setProLibClient(var4.getPromdcSpecialite());
                        var7.setProLibTech(var4.getPromdcCodeDci());
                        this.produitsDao.modif(var7, var1);
                     }
                  }
               }

               var3.commit();
            } catch (HibernateException var12) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var12;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void importerMayite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
      new ArrayList();
      List var2 = this.produitsMedicammentDao.selectAllMedicammentMedical(var1);
      new ArrayList();
      List var3 = this.produitsMedicammentDao.selectAllDciMedical(var1);
      this.utilInitHibernate.closeSession();
      var1 = this.utilInitHibernate.getSysteme();
      PegMedicammentDao var4 = new PegMedicammentDao(this.utilInitHibernate);
      new ArrayList();
      List var5 = var4.rechercheDci((Session)null);
      new ArrayList();
      List var6 = var4.rechercheMedicamment((Session)null);
      this.utilInitHibernate.closeSession();
      if (var6.size() != 0 && var5.size() != 0) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
         Transaction var7 = null;

         try {
            var7 = var1.beginTransaction();
            boolean var8 = false;
            new PegMedicemmentDci();

            int var11;
            for(int var10 = 0; var10 < var5.size(); ++var10) {
               PegMedicemmentDci var9 = (PegMedicemmentDci)var5.get(var10);
               if (var3.size() != 0) {
                  for(var11 = 0; var11 < var3.size(); ++var11) {
                     if (var9.getMeddciId() == ((ProduitsDci)var3.get(var11)).getProdciId()) {
                        this.produitsDci = (ProduitsDci)var3.get(var11);
                        var8 = true;
                        break;
                     }
                  }
               } else {
                  var8 = false;
               }

               if (!var8) {
                  this.produitsDci = new ProduitsDci();
                  this.produitsDci.setProdciId(var9.getMeddciId());
                  this.produitsDci.setProdciCat(var9.getMeddciCat());
                  this.produitsDci.setProdciCode(var9.getMeddciDci());
                  this.produitsDci.setProdciContreIndic(var9.getMeddciCindic());
                  this.produitsDci.setProdciDateCreation(new Date());
                  this.produitsDci.setProdciDateModif((Date)null);
                  this.produitsDci.setProdciEffetSecond(var9.getMeddciEffet());
                  this.produitsDci.setProdciForme(var9.getMeddciForme());
                  this.produitsDci.setProdciIndication(var9.getMeddciIndic());
                  this.produitsDci.setProdciPosologie(var9.getMeddciPoso());
                  this.produitsDci.setProdciType(var9.getMeddciType());
                  this.produitsDci.setProdciUserCreation(this.usersLog.getUsrid());
                  this.produitsDci.setProdciUserModif(0L);
                  this.produitsMedicammentDao.insertDci(this.produitsDci, var1);
               } else {
                  this.produitsDci.setProdciId(var9.getMeddciId());
                  this.produitsDci.setProdciCat(var9.getMeddciCat());
                  this.produitsDci.setProdciCode(var9.getMeddciDci());
                  this.produitsDci.setProdciContreIndic(var9.getMeddciCindic());
                  this.produitsDci.setProdciDateModif(new Date());
                  this.produitsDci.setProdciEffetSecond(var9.getMeddciEffet());
                  this.produitsDci.setProdciForme(var9.getMeddciForme());
                  this.produitsDci.setProdciIndication(var9.getMeddciIndic());
                  this.produitsDci.setProdciPosologie(var9.getMeddciPoso());
                  this.produitsDci.setProdciType(var9.getMeddciType());
                  this.produitsDci.setProdciUserModif(this.usersLog.getUsrid());
                  this.produitsMedicammentDao.modifDci(this.produitsDci, var1);
               }
            }

            var1.flush();
            new PegMedicemment();

            for(var11 = 0; var11 < var6.size(); ++var11) {
               PegMedicemment var18 = (PegMedicemment)var6.get(var11);
               if (var2.size() != 0) {
                  for(int var12 = 0; var12 < var2.size(); ++var12) {
                     if (var18.getMedId() == ((ProduitsMedicamment)var2.get(var12)).getPromdcId()) {
                        this.produitsMedicamment = (ProduitsMedicamment)var2.get(var12);
                        var8 = true;
                        break;
                     }
                  }
               } else {
                  var8 = false;
               }

               if (!var8) {
                  this.produitsMedicamment = new ProduitsMedicamment();
                  this.produitsMedicamment.setPromdcId(var18.getMedId());
                  this.produitsMedicamment.setPromdcClasse(var18.getMedClasse());
                  this.produitsMedicamment.setPromdcCodeCis(var18.getMedCip());
                  this.produitsMedicamment.setPromdcCodeCip(var18.getMedCophase());
                  this.produitsMedicamment.setPromdcCodeDci(var18.getMedDci());
                  this.produitsMedicamment.setPromdcDateCreation(new Date());
                  this.produitsMedicamment.setPromdcDateModif((Date)null);
                  this.produitsMedicamment.setPromdcDosage(var18.getMedDosage());
                  this.produitsMedicamment.setPromdcForme(var18.getMedForme());
                  this.produitsMedicamment.setPromdcLaboratoire(var18.getMedLaboratoire());
                  this.produitsMedicamment.setPromdcListe(var18.getMedListe());
                  this.produitsMedicamment.setPromdcPrix(var18.getMedPrixLoc());
                  this.produitsMedicamment.setPromdcSpecialite(var18.getMedSpecialite());
                  this.produitsMedicamment.setPromdcType(var18.getMedType());
                  this.produitsMedicamment.setPromdcUserCreation(this.usersLog.getUsrid());
                  this.produitsMedicamment.setPromdcUserModif(0L);
                  this.produitsMedicammentDao.insertMed(this.produitsMedicamment, var1);
               } else {
                  this.produitsMedicamment.setPromdcId(var18.getMedId());
                  this.produitsMedicamment.setPromdcClasse(var18.getMedClasse());
                  this.produitsMedicamment.setPromdcCodeCis(var18.getMedCip());
                  this.produitsMedicamment.setPromdcCodeCip(var18.getMedCophase());
                  this.produitsMedicamment.setPromdcCodeDci(var18.getMedDci());
                  this.produitsMedicamment.setPromdcDateModif(new Date());
                  this.produitsMedicamment.setPromdcDosage(var18.getMedDosage());
                  this.produitsMedicamment.setPromdcForme(var18.getMedForme());
                  this.produitsMedicamment.setPromdcLaboratoire(var18.getMedLaboratoire());
                  this.produitsMedicamment.setPromdcListe(var18.getMedListe());
                  this.produitsMedicamment.setPromdcPrix(var18.getMedPrixLoc());
                  this.produitsMedicamment.setPromdcSpecialite(var18.getMedSpecialite());
                  this.produitsMedicamment.setPromdcType(var18.getMedType());
                  this.produitsMedicamment.setPromdcUserModif(this.usersLog.getUsrid());
                  this.produitsMedicammentDao.modifMed(this.produitsMedicamment, var1);
               }
            }

            var1.flush();
            var7.commit();
         } catch (HibernateException var16) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.calculeSelectItem((Session)null);
   }

   public void importerBasePublique() {
      this.showModalPanelBasePublique = true;
   }

   public void listener(UploadEvent var1) throws NamingException, HibernateException, ParseException, FileNotFoundException, IOException {
      this.item = var1.getUploadItem();
      this.fileCtrl = new FileCtrl();
      this.fileCtrl.setLength(this.item.getFileSize());
      this.fileCtrl.setName(this.item.getFileName());
      this.fileCtrl.setChemin(this.item.getFile().getPath().toString());
      this.fileCtrl.setData(this.item.getData());
      this.listFiles.add(this.fileCtrl);
      --this.uploadsAvailable;
      this.importationFichier();
   }

   public void importationFichier() throws NamingException, HibernateException, ParseException, FileNotFoundException, IOException {
      try {
         ArrayList var1 = new ArrayList();
         if (this.listFiles.size() != 0) {
            for(int var2 = 0; var2 < this.listFiles.size(); ++var2) {
               this.fileCtrl = (FileCtrl)this.listFiles.get(var2);
               String var3 = ((FileCtrl)this.listFiles.get(var2)).getName();
               File var4 = new File(this.fileCtrl.getChemin());
               if (var4.exists()) {
                  FileReader var5 = new FileReader(var4);
                  BufferedReader var6 = new BufferedReader(var5);

                  for(String var7 = var6.readLine(); var7 != null; var7 = var6.readLine()) {
                     if (var7.contains("\"")) {
                        char[] var8 = var7.toCharArray();
                        String var9 = "";

                        for(int var10 = 0; var10 < var8.length; ++var10) {
                           if (var8[var10] != '"') {
                              var9 = var9 + var8[var10];
                           }
                        }

                        var7 = var9;
                     }

                     if (var7.contains("'")) {
                        var7.replace("'", "`");
                     }

                     var1.add(var7);
                  }

                  var6.close();
                  var5.close();
               }
            }
         }

         if (var1.size() != 0) {
            this.preparationTransfertImport(var1);
         }
      } catch (IOException var11) {
         var11.printStackTrace();
      }

   }

   public void fermerBasePublique() {
      this.showModalPanelBasePublique = false;
   }

   public void preparationTransfertImport(List var1) {
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.listeImporter.add(var1.get(var2));
         }
      }

   }

   public void validerBasePublique() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "MedicammentPublic");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         if (this.listeImporter.size() != 0) {
            this.lesMedicamments = this.produitsMedicammentDao.selectAllMedicammentMedical(var1);

            for(int var3 = 0; var3 < this.listeImporter.size(); ++var3) {
               String var4 = ((String)this.listeImporter.get(var3)).toString();
               String[] var5 = var4.split("\t");
               int var6 = var5.length;
               this.produitsMedicamment = null;
               boolean var7 = false;
               if (this.lesMedicamments.size() != 0) {
                  for(int var8 = 0; var8 < this.lesMedicamments.size(); ++var8) {
                     if (((ProduitsMedicamment)this.lesMedicamments.get(var8)).getPromdcCodeCis().equals(var5[0])) {
                        this.produitsMedicamment = (ProduitsMedicamment)this.lesMedicamments.get(var8);
                        var7 = true;
                        break;
                     }
                  }
               }

               if (!var7) {
                  this.produitsDci = new ProduitsDci();
                  this.produitsMedicamment = new ProduitsMedicamment();
                  this.produitsMedicamment.setPromdcType(0);
                  this.produitsMedicamment.setPromdcCodeCis(var5[0]);
                  this.produitsMedicamment.setPromdcSpecialite(var5[1]);
                  this.produitsMedicamment.setPromdcForme(var5[2]);
                  this.produitsMedicamment.setPromdcDateMes(var5[7]);
                  this.produitsMedicamment.setPromdcLaboratoire(var5[10]);
                  this.produitsMedicamment = this.produitsMedicammentDao.insertMed(this.produitsMedicamment, var1);
                  var1.flush();
                  this.lesMedicamments.add(this.produitsMedicamment);
               } else if (this.produitsMedicamment != null) {
                  this.produitsMedicamment.setPromdcCodeCis(var5[0]);
                  this.produitsMedicamment.setPromdcSpecialite(var5[1]);
                  this.produitsMedicamment.setPromdcForme(var5[2]);
                  this.produitsMedicamment.setPromdcDateMes(var5[7]);
                  this.produitsMedicamment.setPromdcLaboratoire(var5[10]);
                  this.produitsMedicamment = this.produitsMedicammentDao.modifMed(this.produitsMedicamment, var1);
                  var1.flush();
               }
            }

            var2.commit();
         }
      } catch (HibernateException var12) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelBasePublique = false;
   }

   public boolean isAfficheButtModif() {
      return this.afficheButtModif;
   }

   public void setAfficheButtModif(boolean var1) {
      this.afficheButtModif = var1;
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public Object getRowData() {
      return this.madatamodel.getRowData();
   }

   public List getLesMedicamments() {
      return this.lesMedicamments;
   }

   public void setLesMedicamments(List var1) {
      this.lesMedicamments = var1;
   }

   public ProduitsMedicamment getProduitsMedicamment() {
      return this.produitsMedicamment;
   }

   public void setProduitsMedicamment(ProduitsMedicamment var1) {
      this.produitsMedicamment = var1;
   }

   public List getMesclasseItems() {
      return this.mesclasseItems;
   }

   public void setMesclasseItems(List var1) {
      this.mesclasseItems = var1;
   }

   public List getMesdciItems() {
      return this.mesdciItems;
   }

   public void setMesdciItems(List var1) {
      this.mesdciItems = var1;
   }

   public List getMestypeItems() {
      return this.mestypeItems;
   }

   public void setMestypeItems(List var1) {
      this.mestypeItems = var1;
   }

   public String getVar_cipFind() {
      return this.var_cipFind;
   }

   public void setVar_cipFind(String var1) {
      this.var_cipFind = var1;
   }

   public String getVar_classeFind() {
      return this.var_classeFind;
   }

   public void setVar_classeFind(String var1) {
      this.var_classeFind = var1;
   }

   public String getVar_dciFind() {
      return this.var_dciFind;
   }

   public void setVar_dciFind(String var1) {
      this.var_dciFind = var1;
   }

   public String getVar_speFind() {
      return this.var_speFind;
   }

   public void setVar_speFind(String var1) {
      this.var_speFind = var1;
   }

   public String getVar_typeFind() {
      return this.var_typeFind;
   }

   public void setVar_typeFind(String var1) {
      this.var_typeFind = var1;
   }

   public boolean isAffiche_dci() {
      return this.affiche_dci;
   }

   public void setAffiche_dci(boolean var1) {
      this.affiche_dci = var1;
   }

   public ProduitsDci getProduitsDci() {
      return this.produitsDci;
   }

   public void setProduitsDci(ProduitsDci var1) {
      this.produitsDci = var1;
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

   public boolean isShowModalPanelBasePublique() {
      return this.showModalPanelBasePublique;
   }

   public void setShowModalPanelBasePublique(boolean var1) {
      this.showModalPanelBasePublique = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }
}
