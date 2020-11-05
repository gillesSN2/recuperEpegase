package com.epegase.forms.administration;

import com.epegase.systeme.classe.Marques;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.MarquesDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormMarques implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private Marques marques = new Marques();
   private MarquesDao marquesDao;
   private List marquesList = new ArrayList();
   private transient DataModel datamodel = new ListDataModel();
   private String valImp = "false";
   private boolean inactif;
   private int convertionInactif;
   private boolean visibiliteBton;
   private boolean showModalPanel;
   private UtilDownload utilDownload = new UtilDownload();
   private boolean var_affFicPdf;
   private String urlphotoProd;
   private boolean existPdfFile;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedFile;
   private UploadedFile uploadedPDFFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;

   public FormMarques() throws ParseException {
   }

   public void InstancesDaoUtilses() {
      this.marquesDao = new MarquesDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesMarques(Session var1) throws HibernateException, NamingException {
      this.marquesList = this.marquesDao.selectMarques(var1);
      if (this.marquesList.size() > 0) {
         this.datamodel = new ListDataModel();
         this.datamodel.setWrappedData(this.marquesList);
      }

   }

   public void reactiverCompte() throws HibernateException, NamingException {
      if (this.marques != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Marques");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.marques.setMarDateModif(new Date());
            this.marques.setMarUserModif(this.usersLog.getUsrid());
            this.marques.setMarInactif(0);
            this.marques = this.marquesDao.modif(this.marques, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void removeCompte() throws HibernateException, NamingException {
      if (this.marques != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Marques");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.marques.setMarDateModif(new Date());
            this.marques.setMarUserModif(this.usersLog.getUsrid());
            this.marques.setMarInactif(2);
            this.marques = this.marquesDao.modif(this.marques, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.setVisibiliteBton(false);
   }

   public void annule() {
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void selectionFormule() throws IOException, SQLException {
      this.annule();
      if (this.datamodel.isRowAvailable()) {
         this.marques = (Marques)this.datamodel.getRowData();
         this.affichePhotoProduit();
         int var1 = this.marques.getMarInactif();
         if (var1 == 2) {
            this.setVisibiliteBton(false);
         } else {
            this.setVisibiliteBton(true);
         }
      }

   }

   public void saveFormules() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Marques");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.marques.getMarId() == 0L) {
            this.marques.setMarDateCreation(new Date());
            this.marques.setMarUserCreation(this.usersLog.getUsrid());
            this.marques.setMarInactif(this.getConvertionInactif());
            this.marques = this.marquesDao.insert(this.marques, var1);
            this.marquesList.add(this.marques);
            this.datamodel.setWrappedData(this.marquesList);
         } else {
            this.marques.setMarDateModif(new Date());
            this.marques.setMarUserModif(this.usersLog.getUsrid());
            this.marques.setMarInactif(this.getConvertionInactif());
            this.marques = this.marquesDao.modif(this.marques, var1);
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

      this.setVisibiliteBton(false);
      this.setShowModalPanel(false);
      this.setValImp("false");
   }

   public void supprimerFormulesAchats() throws HibernateException, NamingException {
      this.annule();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Marques");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.marquesDao.delete(this.marques, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.lesMarques((Session)null);
   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.marques.getMarPhoto() != null) {
         this.urlphotoProd = this.baseLog + "/photos/marque/photo/" + this.marques.getMarPhoto();
      } else {
         this.urlphotoProd = "";
      }

   }

   public void verifierPdf() {
      this.existPdfFile = this.isExistPdfFile();
   }

   public boolean isExistPdfFile() {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "photo") + File.separator + this.marques.getMarId() + ".pdf";
      File var2 = new File(var1);
      if (var2.exists()) {
         this.existPdfFile = true;
      } else {
         this.existPdfFile = false;
      }

      return this.existPdfFile;
   }

   public void setExistPdfFile(boolean var1) {
      this.existPdfFile = var1;
   }

   public String readPdfFile() throws IOException {
      BufferedInputStream var1 = null;
      BufferedOutputStream var2 = null;
      FacesContext var3 = FacesContext.getCurrentInstance();
      HttpServletResponse var4 = (HttpServletResponse)var3.getExternalContext().getResponse();
      String var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "photo") + File.separator + this.marques.getMarId() + ".pdf";
      File var6 = new File(var5);
      if (var6.exists()) {
         try {
            var1 = new BufferedInputStream(new FileInputStream(var6), 10240);
            var4.reset();
            var4.setContentType("application/pdf");
            var4.addHeader("Content-disposition", "attachment; filename=" + var6.getName());
            var4.setContentLength((int)var6.length());
            var2 = new BufferedOutputStream(var4.getOutputStream(), 10240);
            byte[] var7 = new byte[10240];

            while(true) {
               int var8;
               if ((var8 = var1.read(var7)) <= 0) {
                  var2.flush();
                  break;
               }

               var2.write(var7, 0, var8);
            }
         } finally {
            close(var2);
            close(var1);
         }

         var3.responseComplete();
      }

      return "home";
   }

   private static void close(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "photo") + File.separator + this.marques.getMarId();
            File var3 = new File(var2);
            if (var3.exists()) {
               var3.delete();
            }

            String var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.marques.getMarId() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "photo" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
            this.fileName = var4;
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.marques.setMarPhoto(var4);
            this.urlphotoProd = this.baseLog + "/photos/marque/photo/" + this.marques.getMarPhoto();
         }
      } catch (IOException var7) {
         this.marques.setMarPhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void submitPDF() throws IOException, JDOMException, HibernateException, NamingException {
      if (this.uploadedPDFFile != null) {
         String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "pdf") + File.separator + this.marques.getMarId() + ".pdf";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         FacesContext var3 = FacesContext.getCurrentInstance();

         try {
            String var4 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var5 = var4.substring(var4.indexOf(".") + 1);
            var4 = this.marques.getMarId() + "." + var5;
            File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "pdf" + File.separator), var4);
            this.utilDownload.write(var6, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var4;
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.marques.setMarPdf(var4);
         } catch (IOException var7) {
            var3.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var7.printStackTrace();
         }
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      String var1 = "";
      int var2 = this.marques.getMarPhoto().lastIndexOf(46);
      if (0 < var2 && var2 <= this.marques.getMarPhoto().length() - 2) {
         var1 = "." + this.marques.getMarPhoto().substring(var2 + 1);
      }

      String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "photo") + File.separator + this.marques.getMarId() + var1;
      File var4 = new File(var3);
      if (var4.exists()) {
         var4.delete();
      }

      this.marques.setMarPhoto((String)null);
   }

   public void reInitPDF() throws HibernateException, NamingException {
      this.marques.setMarPdf((String)null);
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "marque" + File.separator + "pdf") + File.separator + this.marques.getMarId() + ".pdf";
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void visibleAjt() {
      this.marques = new Marques();
      this.inactif = false;
      this.setShowModalPanel(true);
   }

   public void visibleMod() {
      this.setShowModalPanel(true);
   }

   public int getConvertionInactif() {
      if (!this.inactif) {
         this.convertionInactif = 0;
      } else {
         this.convertionInactif = 1;
      }

      return this.convertionInactif;
   }

   public void setConvertionInactif(int var1) {
      this.convertionInactif = var1;
   }

   public boolean isInactif() {
      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public DataModel getDatamodel() {
      return this.datamodel;
   }

   public void setDatamodel(DataModel var1) {
      this.datamodel = var1;
   }

   public String getValImp() {
      return this.valImp;
   }

   public void setValImp(String var1) {
      this.valImp = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
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

   public Marques getMarques() {
      return this.marques;
   }

   public void setMarques(Marques var1) {
      this.marques = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_affFicPdf() {
      return this.var_affFicPdf;
   }

   public void setVar_affFicPdf(boolean var1) {
      this.var_affFicPdf = var1;
   }

   public List getMarquesList() {
      return this.marquesList;
   }

   public void setMarquesList(List var1) {
      this.marquesList = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
