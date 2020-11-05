package com.epegase.forms.administration;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetImmatriculation;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormStructureEntete implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private StructureDao structureDao;
   private UserDao userDao;
   private boolean errorConnection;
   private String fileName;
   private UploadedFile uploadedFile;
   private UploadedFile uploadedFileSecondaire;
   private UploadedFile uploadedFileTertiaire;
   private UploadedFile uploadedFileQuaternaire;
   private UploadedFile uploadedFileCinq;
   private UploadedFile uploadedFileSix;
   private UploadedFile uploadedFileSept;
   private UploadedFile uploadedFileHuit;
   private UploadedFile uploadedFileNeuf;
   private UploadedFile uploadedFileDix;
   private List mesBanquesItems = new ArrayList();
   private UtilDownload utilDownload = new UtilDownload();
   private Bal bal = new Bal();
   private BalDao balDao;
   private List lesBal = new ArrayList();
   private transient DataModel dataModelBal = new ListDataModel();
   private boolean visibleBal = false;
   private boolean var_existMail = false;
   private boolean var_valide_bal = false;
   private boolean showModalPanelBal = false;
   private String var_memo_pw;
   private ObjetImmatriculation pmoral;
   private List lesStructuresPeg;

   public FormStructureEntete() throws IOException, JDOMException {
   }

   public void InstancesDaoUtilses() throws IOException, JDOMException {
      this.structureDao = new StructureDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.balDao = new BalDao(this.baseLog, this.utilInitHibernate);
   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void chargerLesBanques(Session var1) throws HibernateException, NamingException {
      this.mesBanquesItems = new ArrayList();
      ContactDao var2 = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.mesBanquesItems = var2.chargerLesContactsBqItems(var1);
   }

   public void majStructure() throws IOException, JDOMException, SQLException, HibernateException, NamingException {
      this.structureLog.setStrECommerceVal(0);
      if (this.structureLog.getStrip() != null && !this.structureLog.getStrip().isEmpty() && this.structureLog.getStrdomaine() != null && !this.structureLog.getStrdomaine().isEmpty()) {
         try {
            (new StringBuilder()).append("jdbc:mysql://").append(this.structureLog.getStrip()).append("/").append(this.structureLog.getStrnombd()).toString();
            String var23 = this.structureLog.getStrlogbd();
            String var25 = this.structureLog.getStrpwbd();
         } catch (Exception var18) {
            this.errorConnection = true;
            System.err.println("Got an exception! ");
            System.err.println(var18.getMessage());
         }
      } else {
         this.structureDao.modStructure(this.structureLog);
         if (this.lesStructuresPeg.size() != 0 && this.structureLog.getStrmaitrecabinet() >= 1 && this.structureLog.getStrmaitrecabinet() <= 9) {
            int var1 = this.structureLog.getStrmode();
            int var2 = this.structureLog.getStrAddInto();
            int var3 = this.structureLog.getStrClusterMap();
            int var4 = this.structureLog.getStrHangout();
            int var5 = this.structureLog.getStrGoogleTraduction();
            String var6 = this.structureLog.getStrbistriLink();
            String var7 = this.structureLog.getStrappDropbox();
            String var8 = this.structureLog.getStrcpteorange();
            String var9 = this.structureLog.getStrcptebicitel();
            String var10 = this.structureLog.getStrcpteuniversign();
            String var11 = this.structureLog.getStrpwuniversign();
            new Structure();

            for(int var13 = 0; var13 < this.lesStructuresPeg.size(); ++var13) {
               Structure var12 = this.structureDao.logStructureId(((StructurePeg)this.lesStructuresPeg.get(var13)).getStrId(), (Session)null);
               if (var12 != null) {
                  var12.setStrmode(var1);
                  var12.setStrAddInto(var2);
                  var12.setStrClusterMap(var3);
                  var12.setStrHangout(var4);
                  var12.setStrGoogleTraduction(var5);
                  var12.setStrbistriLink(var6);
                  var12.setStrappDropbox(var7);
                  var12.setStrcpteorange(var8);
                  var12.setStrcptebicitel(var9);
                  var12.setStrcpteuniversign(var10);
                  var12.setStrpwuniversign(var11);
                  this.structureDao.modStructure(var12);
               }
            }
         }

         new StructurePeg();
         StructurePeg var21 = this.structureDao.logStructurePeg(this.structureLog.getStrid());
         if (var21 != null) {
            Session var22 = this.utilInitHibernate.getSysteme();
            Transaction var24 = null;

            try {
               var24 = var22.beginTransaction();
               var21.setStrlangue(this.structureLog.getStrlangue());
               var21.setStradresse(this.structureLog.getStradresse());
               var21.setStrville(this.structureLog.getStrville());
               var21.setStrrue(this.structureLog.getStrrue());
               var21.setStrlot(this.structureLog.getStrlot());
               var21.setStrporte(this.structureLog.getStrporte());
               var21.setStrbatiment(this.structureLog.getStrbatiment());
               var21.setStretage(this.structureLog.getStretage());
               var21.setStrquartier(this.structureLog.getStrquartier());
               var21.setStrcommune(this.structureLog.getStrcommune());
               var21.setStrzone(this.structureLog.getStrzone());
               var21.setStrdepartement(this.structureLog.getStrdepartement());
               var21.setStrcedex(this.structureLog.getStrcedex());
               var21.setStrbp(this.structureLog.getStrbp());
               var21.setStrtel1(this.structureLog.getStrtel1());
               var21.setStrtel2(this.structureLog.getStrtel2());
               var21.setStrtel3(this.structureLog.getStrtel3());
               var21.setStrfax(this.structureLog.getStrfax());
               var21.setStrtelex(this.structureLog.getStrtelex());
               var21.setStrdtecreat(this.structureLog.getStrdtecreat());
               var21.setStretat(this.structureLog.getStretat());
               var21.setStrtypeentreprise(this.structureLog.getStrtypeentreprise());
               var21.setStrdevise(this.structureLog.getStrdevise());
               var21.setStrformatdevise(this.structureLog.getStrformatdevise());
               var21.setStrformejuridique(this.structureLog.getStrformejuridique());
               var21.setStrzonecommerciale(this.structureLog.getStrzonecommerciale());
               var21.setStrzonefiscale(this.structureLog.getStrzonefiscale());
               var21.setStrnum1(this.structureLog.getStrnum1());
               var21.setStrnum2(this.structureLog.getStrnum2());
               var21.setStrnum3(this.structureLog.getStrnum3());
               var21.setStrnum4(this.structureLog.getStrnum4());
               var21.setStrnum5(this.structureLog.getStrnum5());
               var21.setStrnum6(this.structureLog.getStrnum6());
               var21.setStrnum7(this.structureLog.getStrnum7());
               var21.setStrnum8(this.structureLog.getStrnum8());
               var21.setStrnum9(this.structureLog.getStrnum9());
               var21.setStrnum10(this.structureLog.getStrnum10());
               var21.setStrnum11(this.structureLog.getStrnum11());
               var21.setStrnum12(this.structureLog.getStrnum12());
               var21.setStrnum13(this.structureLog.getStrnum13());
               var21.setStrnum14(this.structureLog.getStrnum14());
               var21.setStrnum15(this.structureLog.getStrnum15());
               var21.setStrnum16(this.structureLog.getStrnum16());
               var21.setStrnum17(this.structureLog.getStrnum17());
               var21.setStrnum18(this.structureLog.getStrnum18());
               var21.setStrnum19(this.structureLog.getStrnum19());
               var21.setStrnum20(this.structureLog.getStrnum20());
               var21.setStrmod1(this.structureLog.getStrmod1());
               var21.setStrmod2(this.structureLog.getStrmod2());
               var21.setStrmod3(this.structureLog.getStrmod3());
               var21.setStrmod4(this.structureLog.getStrmod4());
               var21.setStrmod5(this.structureLog.getStrmod5());
               var21.setStrmod6(this.structureLog.getStrmod6());
               var21.setStrmod7(this.structureLog.getStrmod7());
               var21.setStrmod8(this.structureLog.getStrmod8());
               var21.setStrmod9(this.structureLog.getStrmod9());
               var21.setStrmod10(this.structureLog.getStrmod10());
               var21.setStrmode(this.structureLog.getStrmode());
               var22.update(var21);
               var24.commit();
            } catch (HibernateException var19) {
               if (var24 != null) {
                  var24.rollback();
               }

               throw var19;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.showModalPanelBal = false;
      this.errorConnection = false;
   }

   public void ajoutLogo1() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFile != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo1." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            var3.delete();
            File var4 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var4, this.uploadedFile.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo1(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var5) {
      }

   }

   public void ajoutLogo2() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileSecondaire != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileSecondaire.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo2." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            var3.delete();
            File var4 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var4, this.uploadedFileSecondaire.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo2(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var5) {
      }

   }

   public void ajoutLogo3() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileTertiaire != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileTertiaire.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo3." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileTertiaire.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo3(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void ajoutLogo4() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileQuaternaire != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileQuaternaire.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo4." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileQuaternaire.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo4(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void ajoutLogo5() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileCinq != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileCinq.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo5." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileCinq.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo5(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void ajoutLogo6() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileSix != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileSix.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo6." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileSix.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo6(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void ajoutLogo7() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileSept != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileSept.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo7." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileSept.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo7(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void ajoutLogo8() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileHuit != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileHuit.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo8." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileHuit.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo8(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void ajoutLogo9() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileNeuf != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileNeuf.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo9." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileNeuf.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo9(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void ajoutLogo10() throws IOException, JDOMException, HibernateException, NamingException {
      try {
         if (this.uploadedFileDix != null) {
            String var1 = this.utilDownload.trimFilePath(this.uploadedFileDix.getName().trim());
            String var2 = var1.substring(var1.indexOf(".") + 1);
            var1 = "logo10." + var2;
            File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator + var1);
            boolean var4 = var3.delete();
            File var5 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "entete" + File.separator), var1);
            this.utilDownload.write(var5, this.uploadedFileDix.getInputStream());
            this.fileName = var1;
            this.structureLog.setStrLogo10(var1);
            this.structureLog = this.structureDao.modStructure(this.structureLog);
         }
      } catch (IOException var6) {
      }

   }

   public void reInitLogo1() throws HibernateException, NamingException {
      this.structureLog.setStrLogo1((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo2() throws HibernateException, NamingException {
      this.structureLog.setStrLogo2((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo3() throws HibernateException, NamingException {
      this.structureLog.setStrLogo3((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo4() throws HibernateException, NamingException {
      this.structureLog.setStrLogo4((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo5() throws HibernateException, NamingException {
      this.structureLog.setStrLogo5((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo6() throws HibernateException, NamingException {
      this.structureLog.setStrLogo6((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo7() throws HibernateException, NamingException {
      this.structureLog.setStrLogo7((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo8() throws HibernateException, NamingException {
      this.structureLog.setStrLogo8((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo9() throws HibernateException, NamingException {
      this.structureLog.setStrLogo9((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void reInitLogo10() throws HibernateException, NamingException {
      this.structureLog.setStrLogo10((String)null);
      this.structureLog = this.structureDao.modStructure(this.structureLog);
   }

   public void chargerlesBal(Session var1) throws HibernateException, NamingException {
      this.lesBal.clear();
      this.lesBal = this.balDao.selectBalLog(this.structureLog.getStrid(), var1);
      this.dataModelBal.setWrappedData(this.lesBal);
   }

   public void selectionBal() {
      if (this.dataModelBal.isRowAvailable()) {
         this.bal = (Bal)this.dataModelBal.getRowData();
         this.visibleBal = true;
      }

   }

   public void ajouterBal() {
      this.bal = new Bal();
      this.var_memo_pw = "";
      this.var_existMail = false;
      this.var_valide_bal = false;
      this.showModalPanelBal = true;
   }

   public void modifierBal() {
      if (this.bal != null) {
         this.var_memo_pw = this.bal.getBalpw();
         this.var_existMail = false;
         this.var_valide_bal = true;
         this.showModalPanelBal = true;
      }

   }

   public void supprimerBal() throws HibernateException, NamingException {
      if (this.bal != null) {
         this.lesBal.remove(this.bal);
         this.dataModelBal.setWrappedData(this.lesBal);
         this.balDao.delete(this.bal);
         this.visibleBal = false;
      }

   }

   public void annulerBal() {
      this.showModalPanelBal = false;
      this.visibleBal = false;
   }

   public void verifExistMail() throws HibernateException, NamingException {
      if (this.bal.getBaladressemail().contains("@")) {
         Bal var1 = this.balDao.logMailExiste(this.bal.getBaladressemail(), (Session)null);
         if (var1 != null) {
            this.var_existMail = true;
            this.var_valide_bal = false;
         } else {
            this.var_existMail = false;
            this.var_valide_bal = true;
         }
      } else {
         this.var_existMail = false;
         this.var_valide_bal = false;
      }

   }

   public void saveBal() throws HibernateException, NamingException {
      if (this.bal.getBalpw() == null || this.bal.getBalpw().isEmpty()) {
         this.bal.setBalpw(this.var_memo_pw);
      }

      if (this.bal.getBalid() == 0L) {
         this.bal.setBaldatecreat(new Date());
         this.bal.setBalusercreat(this.usersLog.getUsrid());
         this.bal.setBalStructure(this.structureLog.getStrid());
         this.bal.setBalGroupe("");
         this.bal.setBalUser(0L);
         this.bal = this.balDao.insert(this.bal);
         this.lesBal.add(this.bal);
         this.dataModelBal.setWrappedData(this.lesBal);
      } else {
         this.bal.setBaldatemodif(new Date());
         this.bal.setBalusermodif(this.usersLog.getUsrid());
         this.bal = this.balDao.modif(this.bal);
      }

      this.showModalPanelBal = false;
      this.visibleBal = false;
   }

   public void defautBal() throws HibernateException, NamingException {
      if (this.lesBal.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Bal var3 = new Bal();
            new Bal();

            for(int var5 = 0; var5 < this.lesBal.size(); ++var5) {
               Bal var4 = (Bal)this.lesBal.get(var5);
               if (var4 == this.bal) {
                  var4.setBalDefaut(true);
                  var3 = var4;
               } else {
                  var4.setBalDefaut(false);
               }

               this.balDao.modif(var4, var1);
            }

            if (var3.getBalid() != 0L) {
               this.structureLog.setStradressemail(var3.getBaladressemail());
               this.structureLog.setStradressemailreponse(var3.getBaladressemailreponse());
               this.structureLog.setStrpw(var3.getBalpw());
               this.structureLog.setStrpopserveur(var3.getBalpopserveur());
               this.structureLog.setStrpopport(var3.getBalpopport());
               this.structureLog.setStrpopauthentification(var3.getBalpopauthentification());
               this.structureLog.setStrpopexemplaire(var3.getBalpopexemplaire());
               this.structureLog.setStrimapserveur(var3.getBalimapserveur());
               this.structureLog.setStrimapport(var3.getBalimapport());
               this.structureLog.setStrsmtpserveur(var3.getBalsmtpserveur());
               this.structureLog.setStrsmtpport(var3.getBalsmtpport());
               this.structureLog.setStrsmtauthentification(var3.getBalsmtauthentification());
               this.structureLog.setStrSignature(var3.getBalSignature());
            } else {
               this.structureLog.setStradressemail((String)null);
               this.structureLog.setStradressemailreponse((String)null);
               this.structureLog.setStrpw((String)null);
               this.structureLog.setStrpopserveur((String)null);
               this.structureLog.setStrpopport(0);
               this.structureLog.setStrpopauthentification(0);
               this.structureLog.setStrpopexemplaire(0);
               this.structureLog.setStrimapserveur((String)null);
               this.structureLog.setStrimapport(0);
               this.structureLog.setStrsmtpserveur((String)null);
               this.structureLog.setStrsmtpport(0);
               this.structureLog.setStrsmtauthentification(0);
               this.structureLog.setStrSignature((String)null);
            }

            this.structureLog = this.structureDao.modStructure(this.structureLog, var1);
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

   public void annulerPingServer() {
      this.errorConnection = false;
   }

   public boolean isErrorConnection() {
      return this.errorConnection;
   }

   public void setErrorConnection(boolean var1) {
      this.errorConnection = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public UploadedFile getUploadedFileQuaternaire() {
      return this.uploadedFileQuaternaire;
   }

   public void setUploadedFileQuaternaire(UploadedFile var1) {
      this.uploadedFileQuaternaire = var1;
   }

   public UploadedFile getUploadedFileSecondaire() {
      return this.uploadedFileSecondaire;
   }

   public void setUploadedFileSecondaire(UploadedFile var1) {
      this.uploadedFileSecondaire = var1;
   }

   public UploadedFile getUploadedFileTertiaire() {
      return this.uploadedFileTertiaire;
   }

   public void setUploadedFileTertiaire(UploadedFile var1) {
      this.uploadedFileTertiaire = var1;
   }

   public Bal getBal() {
      return this.bal;
   }

   public void setBal(Bal var1) {
      this.bal = var1;
   }

   public DataModel getDataModelBal() {
      return this.dataModelBal;
   }

   public void setDataModelBal(DataModel var1) {
      this.dataModelBal = var1;
   }

   public boolean isShowModalPanelBal() {
      return this.showModalPanelBal;
   }

   public void setShowModalPanelBal(boolean var1) {
      this.showModalPanelBal = var1;
   }

   public boolean isVar_existMail() {
      return this.var_existMail;
   }

   public void setVar_existMail(boolean var1) {
      this.var_existMail = var1;
   }

   public boolean isVar_valide_bal() {
      return this.var_valide_bal;
   }

   public void setVar_valide_bal(boolean var1) {
      this.var_valide_bal = var1;
   }

   public boolean isVisibleBal() {
      return this.visibleBal;
   }

   public void setVisibleBal(boolean var1) {
      this.visibleBal = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
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

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public ObjetImmatriculation getPmoral() {
      return this.pmoral;
   }

   public void setPmoral(ObjetImmatriculation var1) {
      this.pmoral = var1;
   }

   public UploadedFile getUploadedFileCinq() {
      return this.uploadedFileCinq;
   }

   public void setUploadedFileCinq(UploadedFile var1) {
      this.uploadedFileCinq = var1;
   }

   public UploadedFile getUploadedFileHuit() {
      return this.uploadedFileHuit;
   }

   public void setUploadedFileHuit(UploadedFile var1) {
      this.uploadedFileHuit = var1;
   }

   public UploadedFile getUploadedFileSept() {
      return this.uploadedFileSept;
   }

   public void setUploadedFileSept(UploadedFile var1) {
      this.uploadedFileSept = var1;
   }

   public UploadedFile getUploadedFileSix() {
      return this.uploadedFileSix;
   }

   public void setUploadedFileSix(UploadedFile var1) {
      this.uploadedFileSix = var1;
   }

   public UploadedFile getUploadedFileDix() {
      return this.uploadedFileDix;
   }

   public void setUploadedFileDix(UploadedFile var1) {
      this.uploadedFileDix = var1;
   }

   public UploadedFile getUploadedFileNeuf() {
      return this.uploadedFileNeuf;
   }

   public void setUploadedFileNeuf(UploadedFile var1) {
      this.uploadedFileNeuf = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getLesStructuresPeg() {
      return this.lesStructuresPeg;
   }

   public void setLesStructuresPeg(List var1) {
      this.lesStructuresPeg = var1;
   }
}
