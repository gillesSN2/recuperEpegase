package com.epegase.systeme.util;

import com.epegase.systeme.classe.Bal;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.CentreImpot;
import com.epegase.systeme.classe.CertificationDocument;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.MailsPj;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientContact;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetBal;
import com.epegase.systeme.dao.BalDao;
import com.epegase.systeme.dao.CentreImpotDao;
import com.epegase.systeme.dao.CertificationDocumentDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.MailsDao;
import com.epegase.systeme.dao.MailsPJDao;
import com.epegase.systeme.dao.PatientContactDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.UserDao;
import com.lowagie.text.DocumentException;
import com.mysql.jdbc.Driver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.Vector;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.fill.JRFileVirtualizer;
import net.sf.jasperreports.engine.util.JRDataUtils;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.richfaces.json.JSONException;
import org.richfaces.json.JSONObject;
import org.springframework.context.annotation.Scope;

@Scope("request")
public class UtilPrint extends HttpServlet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String nomMapping;
   private String rapport;
   private String rapportEncapsule;
   private String cheminRapport;
   private String cheminLogo;
   private String cheminSignature;
   private String cheminSousrapport;
   private String cheminScan;
   private String cheminListeDoc;
   private String imageFondPage;
   private String duplicata;
   private String source = "";
   private JRBeanCollectionDataSource jRBeanCollectionDataSource;
   private String emetteur;
   private String destinataire;
   private String destinataireCC;
   private String destinataireCCI;
   private String corpsMail;
   private long idEquipe;
   private long idResponsable;
   private long idCommercial;
   private String entete;
   private long exercice;
   private Date DateDeb;
   private Date DateFin;
   private String DateDebUk;
   private String DateFinUk;
   private String journal;
   private String compte;
   private String centralisation;
   private int page_init;
   private int etat_init;
   private String filtre;
   private String requete;
   private String recordPath;
   private String format;
   private List lesbalEmetteursItems;
   private List lesbalDestinatairesItems;
   private List lesbalDestinataires;
   private List lesmodelesImpressions;
   private transient DataModel dataModelLesDestinataires;
   private ObjetBal objetBal;
   private String[] listeDestinataire;
   private Parc parc;
   private String montant_lettre;
   private String montant_lettre_local;
   private String nbDecQte;
   private String nbDecPu;
   private String cheminMail;
   private int cat = 0;
   private int nature = 0;
   private long id_doc;
   private boolean poidsAff = false;
   private int poidsImp = 0;
   private String numDoc;
   private Tiers tiersSelectionne;
   private BulletinSalaire bulletinSelectionne;
   private Contacts contact;
   private String totauxTtc;
   private String totauxHt;
   private String totauxTaxe;
   private int nbCar;
   private String typeEcriture;
   private float taux;
   private float taux2;
   private float taux3;
   private double plafond;
   private long sign_id;
   private String sign_ville;
   private String sign_nom;
   private String sign_prenom;
   private String sign_signature;
   private String sign_fonction;
   private String sign_metier;
   private String sign_civilite;
   private String sign_mail;
   private String sign_telephone;
   private Patients patientsSelectionne;
   private Patients patientsEncours;
   private PatientContact patientContact;
   private String pageGarde;
   private String annexe1;
   private String annexe2;
   private String adresseLivraison;
   private String adresseFacturation;
   private String infoOrigineDoc;
   private String matricule;
   private String tri;
   private int typeVente;
   private String var_nom_col1;
   private String var_nom_col2;
   private String var_nom_col3;
   private String var_nom_col4;
   private String var_nom_col5;
   private String var_nom_col6;
   private String var_nom_col7;
   private String var_nom_col8;
   private String var_nom_col9;
   private String var_nom_col10;
   private String var_nom_col11;
   private String var_nom_col12;
   private String var_nom_col13;
   private String var_nom_col14;
   private String var_nom_col15;
   private String var_nom_col16;
   private String var_nom_col17;
   private String var_nom_col18;
   private String var_nom_col19;
   private String var_nom_col20;
   private double valeur1;
   private double valeur2;
   private double valeur3;
   private String m0DteDeb;
   private String m0DteFin;
   private String m30DteDeb;
   private String m30DteFin;
   private String m60DteDeb;
   private String m60DteFin;
   private String m90DteDeb;
   private String m90DteFin;
   private String m120DteDeb;
   private String service;
   private List mesImprimantesServeurItems;
   private String monImprimante;
   private boolean imprimanteReseau = false;
   private boolean certification = false;
   private String centreImpot;

   public UtilPrint(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
      this.lesbalEmetteursItems = new ArrayList();
      this.lesbalEmetteursItems.add(new SelectItem(""));
      this.lesbalDestinatairesItems = new ArrayList();
      this.lesbalDestinatairesItems.add(new SelectItem(""));
      this.lesbalDestinataires = new ArrayList();
      this.dataModelLesDestinataires = new ListDataModel();
      this.format = "PDF";
      this.parc = new Parc();
      this.mesImprimantesServeurItems = new ArrayList();
      this.mesImprimantesServeurItems.clear();
      PrintService var2 = null;
      HashPrintRequestAttributeSet var3 = new HashPrintRequestAttributeSet();
      var3.add(MediaSizeName.ISO_A4);
      PrintService[] var4 = PrintServiceLookup.lookupPrintServices((DocFlavor)null, (AttributeSet)null);

      for(int var5 = 0; var5 < var4.length; ++var5) {
         var2 = var4[var5];
         this.mesImprimantesServeurItems.add(new SelectItem(var2.getName().toString()));
         this.imprimanteReseau = true;
      }

      this.contact = new Contacts();
   }

   public void imprimeRapport() throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      JRXmlDataSource var1 = null;
      JasperPrint var2 = new JasperPrint();
      var2.setLocaleCode(JRDataUtils.getLocaleCode(Locale.FRENCH));
      var2.setTimeZoneId(JRDataUtils.getTimeZoneId(TimeZone.getDefault()));
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      Object var4 = null;
      HashMap var5 = new HashMap();
      this.lesmodelesImpressions = new ArrayList();
      File var6 = new File(StaticModePegase.getCheminContext());
      String var7 = "" + var6.getAbsoluteFile();
      this.cheminLogo = var7 + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "entete" + File.separator;
      this.cheminSignature = var7 + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "Users" + File.separator;
      Map var17 = this.Structure(var5);
      if (this.cheminRapport == null || this.cheminRapport.isEmpty()) {
         this.cheminRapport = this.cheminSousrapport;
      }

      if (this.source != null && !this.source.isEmpty()) {
         var1 = new JRXmlDataSource((new File(this.source)).toURI().toURL().toExternalForm(), this.recordPath);
         var2 = JasperFillManager.fillReport(this.cheminRapport + this.rapport + ".jasper", var17, var1);
      } else if ((this.requete == null || this.requete.isEmpty()) && this.jRBeanCollectionDataSource.getData().size() != 0) {
         if (this.rapportEncapsule != null && !this.rapportEncapsule.isEmpty()) {
            var2 = JasperFillManager.fillReport(this.cheminRapport + this.rapport + ".jasper", var17, this.jRBeanCollectionDataSource);
         } else {
            var2 = JasperFillManager.fillReport(this.cheminRapport + this.rapport + ".jasper", var17, this.jRBeanCollectionDataSource);
         }
      } else if (this.requete != null && !this.requete.isEmpty()) {
         if (this.nomMapping != null && !this.nomMapping.isEmpty() && !this.nomMapping.equals("systeme")) {
            Session var18 = this.utilInitHibernate.getOpenSession(this.baseLog, this.nomMapping);
            var2 = JasperFillManager.fillReport(this.cheminRapport + this.rapport + ".jasper", var17, var18.connection());
            this.utilInitHibernate.closeSessionIreport();
         } else {
            Driver var8;
            Connection var9;
            if (this.nomMapping != null && !this.nomMapping.isEmpty() && this.nomMapping.equals("systeme")) {
               var8 = new Driver();
               DriverManager.registerDriver(var8);
               var9 = DriverManager.getConnection("jdbc:mysql://" + StaticModePegase.getAccesBase() + "/epegase", this.utilInitHibernate.getUser(), this.utilInitHibernate.getPw());
               var2 = JasperFillManager.fillReport(this.cheminRapport + this.rapport + ".jasper", var17, var9);
               var9.close();
            } else {
               var8 = new Driver();
               DriverManager.registerDriver(var8);
               var9 = DriverManager.getConnection("jdbc:mysql://" + StaticModePegase.getAccesBase() + "/" + this.baseLog, this.utilInitHibernate.getUser(), this.utilInitHibernate.getPw());
               var2 = JasperFillManager.fillReport(this.cheminRapport + this.rapport + ".jasper", var17, var9);
               var9.close();
            }
         }
      }

      FacesContext var19 = FacesContext.getCurrentInstance();
      HttpServletResponse var20 = (HttpServletResponse)var19.getExternalContext().getResponse();
      byte[] var16;
      String var28;
      if (this.format.equalsIgnoreCase("PRT")) {
         PrintService var10 = null;
         HashPrintRequestAttributeSet var11 = new HashPrintRequestAttributeSet();
         var11.add(MediaSizeName.ISO_A4);
         PrintService[] var12 = PrintServiceLookup.lookupPrintServices((DocFlavor)null, (AttributeSet)null);

         for(int var13 = 0; var13 < var12.length; ++var13) {
            var10 = var12[var13];
            if (this.monImprimante != null && !this.monImprimante.isEmpty() && var10.getName().toString().equals(this.monImprimante)) {
               break;
            }
         }

         if (var10 != null) {
            JRPrintServiceExporter var32 = new JRPrintServiceExporter();
            var32.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var32.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var32.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, var10.getAttributes());
            var32.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            var32.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            var32.exportReport();
         }
      } else {
         JRPdfExporter var21;
         if (this.format.equalsIgnoreCase("JRV")) {
            var20.setContentType("application/pdf");
            var21 = new JRPdfExporter();
            var21.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var21.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var21.setParameter(JRPdfExporterParameter.PERMISSIONS, new Integer(2580));
            var21.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var21.exportReport();
            var16 = var3.toByteArray();
            if (this.certification) {
               var16 = this.certification(var16, var20, var3, var19);
            }

            var20.setHeader("Expires", "0");
            var20.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            var20.setHeader("Pragma", "public");
            var20.setContentType("application/pdf");
            var20.setContentLength(var16.length);
            var20.getOutputStream().write(var16);
            ServletOutputStream var22 = var20.getOutputStream();
            var3.writeTo(var22);
            var22.flush();
            var19.responseComplete();
         } else if (this.format.equalsIgnoreCase("PDF")) {
            var20.setContentType("application/pdf");
            var21 = new JRPdfExporter();
            var21.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var21.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var21.setParameter(JRPdfExporterParameter.PERMISSIONS, new Integer(2580));
            var21.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var21.exportReport();
         } else if (this.format.equalsIgnoreCase("XLS")) {
            var20.setContentType("application/vnd.ms-excel");
            JRXlsExporter var23 = new JRXlsExporter();
            var23.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var23.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var23.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            var23.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
            var23.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            var23.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var23.exportReport();
         } else if (this.format.equalsIgnoreCase("DOC")) {
            var20.setContentType("pplication/msword");
            JRRtfExporter var26 = new JRRtfExporter();
            var26.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var26.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var26.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var26.exportReport();
         } else if (this.format.equalsIgnoreCase("ODT")) {
            var20.setContentType("application/rtf");
            JROdtExporter var27 = new JROdtExporter();
            var27.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var27.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var27.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var27.exportReport();
         } else if (this.format.equalsIgnoreCase("XML")) {
            var20.setContentType("text/xml");
            JRXmlExporter var29 = new JRXmlExporter();
            var29.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var29.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var29.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var29.exportReport();
         } else if (this.format.equalsIgnoreCase("HTML")) {
            var20.setContentType("text/html");
            JRHtmlExporter var30 = new JRHtmlExporter();
            var30.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var30.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var30.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var30.exportReport();
         } else if (this.format.equalsIgnoreCase("CSV")) {
            var20.setContentType("text/csv");
            JRCsvExporter var31 = new JRCsvExporter();
            var31.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var31.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var31.setParameter(JRExporterParameter.CHARACTER_ENCODING, "ISO-8859-1");
            var31.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ",");
            var31.setParameter(JRCsvExporterParameter.RECORD_DELIMITER, "\n");
            var31.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var31.exportReport();
         } else if (this.format.equalsIgnoreCase("MAIL")) {
            this.cheminMail = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "mails" + File.separator + "envoi" + File.separator;
            var21 = new JRPdfExporter();
            var21.setParameter(JRExporterParameter.JASPER_PRINT, var2);
            var21.setParameter(JRExporterParameter.PARAMETERS_OVERRIDE_REPORT_HINTS, true);
            var21.setParameter(JRPdfExporterParameter.PERMISSIONS, new Integer(2580));
            var21.setParameter(JRExporterParameter.OUTPUT_STREAM, var3);
            var21.exportReport();
            ArrayList var24 = new ArrayList();
            var28 = "";
            String var34 = "";
            if (this.id_doc == 0L) {
               if (this.bulletinSelectionne != null) {
                  var28 = "_" + this.bulletinSelectionne.getBulsalMatricule() + "_" + this.bulletinSelectionne.getBulsalPeriode();
               }

               JasperExportManager.exportReportToPdfFile(var2, this.cheminMail + this.rapport + var28 + ".pdf");
               var24.add(new File(this.cheminMail + this.rapport + var28 + ".pdf"));
            } else {
               if (this.tiersSelectionne != null) {
                  if (this.tiersSelectionne.getTiesigle() != null && !this.tiersSelectionne.getTiesigle().isEmpty()) {
                     var28 = this.tiersSelectionne.getTiesigle();
                  } else {
                     int var14 = this.tiersSelectionne.getTieraisonsocialenom().length();
                     if (var14 >= 5) {
                        var28 = this.tiersSelectionne.getTieraisonsocialenom().substring(0, 5);
                     } else {
                        var28 = this.tiersSelectionne.getTieraisonsocialenom().substring(0, var14);
                     }
                  }

                  var28 = "_" + this.purgeEspace(var28);
                  if (this.numDoc != null && !this.numDoc.isEmpty()) {
                     var34 = this.numDoc;
                  }
               }

               if (var34 != null && !var34.isEmpty()) {
                  String var35 = "";
                  if (var34.contains("/")) {
                     String[] var15 = var34.split("/");
                     var35 = var15[0];
                  } else {
                     var35 = var34;
                  }

                  JasperExportManager.exportReportToPdfFile(var2, this.cheminMail + this.rapport + var28 + var35 + ".pdf");
                  var24.add(new File(this.cheminMail + this.rapport + var28 + var35 + ".pdf"));
               } else {
                  JasperExportManager.exportReportToPdfFile(var2, this.cheminMail + this.rapport + var28 + this.id_doc + ".pdf");
                  var24.add(new File(this.cheminMail + this.rapport + var28 + this.id_doc + ".pdf"));
               }
            }

            this.generationMail(this.emetteur, this.destinataireCC, this.destinataireCCI, var24);
            var20.setHeader("Content-Description", "File Transfer");
            var20.setHeader("Content-Type", "text/html");
            var20.setHeader("Content-Transfer-Encoding", "binary");
            var20.setHeader("Expires", "0");
            var20.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            var20.setHeader("Pragma", "public");
            var19.responseComplete();
         }
      }

      if (!this.format.equalsIgnoreCase("MAIL") && !this.format.equalsIgnoreCase("JRV") && !this.format.equalsIgnoreCase("PRT")) {
         String var33 = "";
         String var25 = "";
         if (this.tiersSelectionne != null) {
            if (this.tiersSelectionne.getTiesigle() != null && !this.tiersSelectionne.getTiesigle().isEmpty()) {
               var33 = this.tiersSelectionne.getTiesigle();
            } else {
               int var37 = this.tiersSelectionne.getTieraisonsocialenom().length();
               if (var37 >= 5) {
                  var33 = this.tiersSelectionne.getTieraisonsocialenom().substring(0, 5);
               } else {
                  var33 = this.tiersSelectionne.getTieraisonsocialenom().substring(0, var37);
               }
            }

            var33 = "_" + this.purgeEspace(var33) + "_";
            if (this.numDoc != null && !this.numDoc.isEmpty()) {
               var28 = "";
               if (this.numDoc.contains("/")) {
                  String[] var36 = this.numDoc.split("/");
                  var28 = var36[0];
               } else {
                  var28 = this.numDoc;
               }

               var25 = "_" + var28;
            }
         }

         if (!this.format.equalsIgnoreCase("JRV") && !this.format.equalsIgnoreCase("PDF")) {
            var16 = var3.toByteArray();
            var20.setHeader("Content-Description", "File Transfer");
            var20.addHeader("Content-disposition", "attachment;filename=" + this.rapport + var33 + var25 + "." + this.format);
            var20.setHeader("Content-Type", "application/" + this.format);
            var20.setHeader("Content-Transfer-Encoding", "binary");
            var20.setHeader("Expires", "0");
            var20.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            var20.setHeader("Pragma", "public");
            var20.setContentLength(var16.length);
            var20.getOutputStream().write(var16);
            var20.setContentType("application/" + this.format);
            var19.responseComplete();
         } else {
            var16 = var3.toByteArray();
            if (this.certification) {
               var16 = this.certification(var16, var20, var3, var19);
            }

            var20.setHeader("Content-Description", "File Transfer");
            var20.addHeader("Content-disposition", "attachment;filename=" + this.rapport + var33 + var25 + "." + this.format);
            var20.setHeader("Content-Type", "application/" + this.format);
            var20.setHeader("Content-Transfer-Encoding", "binary");
            var20.setHeader("Expires", "0");
            var20.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            var20.setHeader("Pragma", "public");
            var20.setContentLength(var16.length);
            var20.getOutputStream().write(var16);
            var20.setContentType("application/" + this.format);
            var19.responseComplete();
         }
      }

   }

   public byte[] certification(byte[] var1, HttpServletResponse var2, ByteArrayOutputStream var3, FacesContext var4) throws MalformedURLException, XmlRpcException, IOException, HibernateException, NamingException, DocumentException {
      byte[] var5 = null;
      if (this.structureLog.getStrcpteuniversign() != null && !this.structureLog.getStrcpteuniversign().isEmpty() && this.structureLog.getStrpwuniversign() != null && !this.structureLog.getStrpwuniversign().isEmpty()) {
         XmlRpcClientConfigImpl var6 = new XmlRpcClientConfigImpl();
         var6.setServerURL(new URL("https://testsign.sentrust.sn/wsSenTrustSign.php"));
         var6.setEncoding("UTF-8");
         XmlRpcClient var7 = new XmlRpcClient();
         var7.setConfig(var6);
         HashMap var8 = new HashMap();
         Vector var9 = new Vector();
         HashMap var10 = new HashMap();
         var10.put("x", 100);
         var10.put("y", 200);
         var10.put("patternName", "default");
         var8.put("signatureField", var10);
         var9.addElement(var1);
         var9.addElement(var8);
         var5 = (byte[])((byte[])var7.execute("wsSenTrustSign.cachetSenTrust", var9));
         CertificationDocumentDao var11 = new CertificationDocumentDao(this.baseLog, this.utilInitHibernate);
         CertificationDocument var12 = new CertificationDocument();
         var12.setUsers(this.usersLog);
         var12.setCerDateCreat(new Date());
         var12.setCerUserCreat(this.usersLog.getUsrid());
         var12.setCerNature(this.nature);
         var12.setCerNum(this.numDoc);
         var12.setCerNomRapport(this.rapport);
         byte var13 = 0;
         if (this.nature >= 120 && this.nature <= 129) {
            var13 = 1;
         } else if (this.nature >= 80 && this.nature <= 99) {
            var13 = 2;
         } else if (this.nature >= 50 && this.nature <= 69) {
            var13 = 3;
         } else if (this.nature >= 70 && this.nature <= 79) {
            var13 = 4;
         } else if (this.nature >= 100 && this.nature <= 109) {
            var13 = 5;
         } else if (this.nature >= 60 && this.nature <= 69) {
            var13 = 6;
         } else if (this.nature >= 160 && this.nature <= 179) {
            var13 = 6;
         }

         var12.setCerTypeTiers(var13);
         var12.setCerQte(-1);
         var11.insert(var12);
      }

      return var5;
   }

   public String purgeEspace(String var1) {
      String var2 = "";
      if (var1.contains(" ")) {
         for(int var3 = 0; var3 < var1.length(); ++var3) {
            String var4 = var1.substring(var3, var3 + 1);
            if (var4.equals(" ")) {
               var2 = var2 + "";
            } else {
               var2 = var2 + var1.substring(var3, var3 + 1);
            }
         }
      } else {
         var2 = var1;
      }

      return var2;
   }

   public Map Structure(Map var1) throws HibernateException, NamingException, JSONException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      if (!this.format.equalsIgnoreCase("XLS") && !this.format.equalsIgnoreCase("HTML") && !this.format.equalsIgnoreCase("XML") && !this.format.equalsIgnoreCase("CSV")) {
         var1.put("IS_IGNORE_PAGINATION", false);
      } else {
         var1.put("IS_IGNORE_PAGINATION", true);
      }

      if (StaticModePegase.getCompil_version() != null && !StaticModePegase.getCompil_version().isEmpty()) {
         var1.put("version", StaticModePegase.getCompil_version().subSequence(0, 4));
      } else {
         var1.put("version", "");
      }

      JRFileVirtualizer var3 = new JRFileVirtualizer(1000, System.getProperty("user.dir"));
      var1.put("REPORT_VIRTUALIZER", var3);
      var1.put("SUBREPORT_DIR", this.cheminSousrapport);
      var1.put("entete", this.entete);
      if (this.filtre == null) {
         this.filtre = "";
      }

      if (this.rapportEncapsule != null && !this.rapportEncapsule.isEmpty()) {
         var1.put("jRDataBean", this.jRBeanCollectionDataSource);
      } else {
         var1.put("jRDataBean", (Object)null);
      }

      var1.put("filtre", this.filtre);
      var1.put("exercice", this.exercice);
      var1.put("dateDeb", this.DateDeb);
      var1.put("dateFin", this.DateFin);
      var1.put("dateDebUk", this.DateDebUk);
      var1.put("dateFinUk", this.DateFinUk);
      var1.put("journal", this.journal);
      var1.put("compte", this.compte);
      var1.put("centralisation", this.centralisation);
      var1.put("requete", this.requete);
      var1.put("nbst", this.nbCar);
      var1.put("nature", this.nature);
      var1.put("id_doc", this.id_doc);
      var1.put("typeEcriture", this.typeEcriture);
      var1.put("taux", this.taux);
      var1.put("taux2", this.taux2);
      var1.put("taux3", this.taux3);
      var1.put("plafond", this.plafond);
      var1.put("page_init", this.page_init);
      var1.put("etat_init", this.etat_init);
      var1.put("montant_lettre", this.montant_lettre);
      var1.put("montant_lettre_local", this.montant_lettre_local);
      var1.put("totauxHt", this.totauxHt);
      var1.put("totauxTaxe", this.totauxTaxe);
      var1.put("totauxTtc", this.totauxTtc);
      var1.put("pageGarde", this.pageGarde);
      var1.put("annexe1", this.annexe1);
      var1.put("annexe2", this.annexe2);
      var1.put("adresseLivraison", this.adresseLivraison);
      var1.put("adresseFacturation", this.adresseFacturation);
      var1.put("imageFond", this.cheminSousrapport + this.imageFondPage);
      var1.put("cheminScan", this.cheminScan);
      var1.put("infoOrigineDoc", this.infoOrigineDoc);
      var1.put("duplicata", this.duplicata);
      var1.put("valeur1", this.valeur1);
      var1.put("valeur2", this.valeur2);
      var1.put("valeur3", this.valeur3);
      var1.put("listeJava", this.jRBeanCollectionDataSource);
      var1.put("matricule", this.matricule);
      var1.put("service", this.service);
      var1.put("tri", this.tri);
      var1.put("codeSecurity", this.calculeSecurityCode());
      if (this.parc != null) {
         var1.put("parcChassis", this.parc.getPrcChassis());
      } else {
         var1.put("parcChassis", "");
      }

      var1.put("warming", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "commun" + File.separator + "Warning.png" + File.separator);
      var1.put("id", this.structureLog.getStrid());
      var1.put("date_creation", this.structureLog.getStrdtecreat());
      var1.put("date_modification", this.structureLog.getStrdtemodif());
      var1.put("user_creation", this.structureLog.getStrusercreat());
      var1.put("user_modification", this.structureLog.getStrusermodif());
      var1.put("etat", this.structureLog.getStretat());
      var1.put("poids", this.poidsImp);
      var1.put("mode", this.structureLog.getStrmode());
      var1.put("societe", this.structureLog.getStrraisonsociale());
      var1.put("sigle", this.structureLog.getStrsigle());
      var1.put("nom_pays", this.structureLog.getStrnompays());
      var1.put("code_pays", this.structureLog.getStrcodepays());
      var1.put("devise", this.structureLog.getStrdevise());
      var1.put("formatDevise", this.structureLog.getStrformatdevise());
      var1.put("langue", this.structureLog.getStrlangue());
      var1.put("zone_fiscale", this.structureLog.getStrzonefiscale());
      var1.put("zone_commerciale", this.structureLog.getStrzonecommerciale());
      var1.put("format_date", this.structureLog.getStrformatdate());
      var1.put("format_heure", this.structureLog.getStrformatheure());
      var1.put("heure_debut", this.structureLog.getStrHrDeb() + ":" + this.structureLog.getStrMnDeb());
      var1.put("heure_fin", this.structureLog.getStrHrFin() + ":" + this.structureLog.getStrMnFin());
      var1.put("pas_horaire", this.structureLog.getStrHrPas() + ":" + this.structureLog.getStrMnPas());
      var1.put("forme_juridique", this.structureLog.getStrformejuridique());
      var1.put("type_entreprise", this.structureLog.getStrtypeentreprise());
      var1.put("adresse", this.structureLog.getStradresse());
      var1.put("rue", this.structureLog.getStrrue());
      var1.put("lot", this.structureLog.getStrlot());
      var1.put("porte", this.structureLog.getStrporte());
      var1.put("quartier", this.structureLog.getStrquartier());
      var1.put("ville", this.structureLog.getStrville());
      var1.put("commune", this.structureLog.getStrcommune());
      var1.put("departement", this.structureLog.getStrdepartement());
      var1.put("zone", this.structureLog.getStrzone());
      var1.put("batiment", this.structureLog.getStrbatiment());
      var1.put("etage", this.structureLog.getStretage());
      var1.put("boite_postale", this.structureLog.getStrbp());
      var1.put("cedex", this.structureLog.getStrcedex());
      var1.put("telephone_1", this.structureLog.getStrtel1());
      var1.put("telephone_2", this.structureLog.getStrtel2());
      var1.put("telephone_3", this.structureLog.getStrtel3());
      var1.put("fax", this.structureLog.getStrfax());
      var1.put("telex", this.structureLog.getStrtelex());
      var1.put("site_web", this.structureLog.getStrsitewzb());
      var1.put("activite", this.structureLog.getStractiviteCommerciale());
      var1.put("responsable", this.structureLog.getStrResponsable());
      var1.put("qualite_responsable", this.structureLog.getStrQualiteResponsable());
      var1.put("capital", this.structureLog.getStrCapital());
      var1.put("repertoire", this.structureLog.getStrrepertoire());
      var1.put("identification_1", this.structureLog.getStrnum1());
      var1.put("identification_2", this.structureLog.getStrnum2());
      var1.put("identification_3", this.structureLog.getStrnum3());
      var1.put("identification_4", this.structureLog.getStrnum4());
      var1.put("identification_5", this.structureLog.getStrnum5());
      var1.put("identification_6", this.structureLog.getStrnum6());
      var1.put("identification_7", this.structureLog.getStrnum7());
      var1.put("identification_8", this.structureLog.getStrnum8());
      var1.put("identification_9", this.structureLog.getStrnum9());
      var1.put("identification_10", this.structureLog.getStrnum10());
      var1.put("identification_11", this.structureLog.getStrnum11());
      var1.put("identification_12", this.structureLog.getStrnum12());
      var1.put("identification_13", this.structureLog.getStrnum13());
      var1.put("identification_14", this.structureLog.getStrnum14());
      var1.put("identification_15", this.structureLog.getStrnum15());
      var1.put("identification_16", this.structureLog.getStrnum16());
      var1.put("identification_17", this.structureLog.getStrnum17());
      var1.put("identification_18", this.structureLog.getStrnum18());
      var1.put("identification_19", this.structureLog.getStrnum19());
      var1.put("identification_20", this.structureLog.getStrnum20());
      var1.put("nbDecQte", this.nbDecQte);
      var1.put("nbDecPu", this.nbDecPu);
      if (this.structureLog.getStrcodepays().equals("0138") && this.centreImpot != null && !this.centreImpot.isEmpty() && !this.centreImpot.equals("100")) {
         new CentreImpot();
         CentreImpotDao var5 = new CentreImpotDao(this.baseLog, this.utilInitHibernate);
         String var6 = "";
         if (this.centreImpot.contains(":")) {
            String[] var7 = this.centreImpot.split(":");
            var6 = var7[0];
         } else {
            var6 = this.centreImpot;
         }

         CentreImpot var4 = var5.rechercheEntreImpotByCode(var6, 0, var2);
         if (var4 != null) {
            var1.put("societe", var4.getCenimpNom());
            var1.put("adresse", var4.getCenimpAdresse());
            var1.put("boite_postale", var4.getCenimpBP());
            var1.put("telephone_1", var4.getCenimpTel1());
            var1.put("fax", var4.getCenimpFax());
            var1.put("ville", var4.getCenimpVille());
            var1.put("identification_3", var4.getCenimpNumeroImmatriculation());
         }
      }

      if (this.contact != null) {
         var1.put("contact_cel1", this.contact.getConcel1());
         var1.put("contact_mail1", this.contact.getConmail1());
      } else {
         var1.put("contact_cel1", "");
         var1.put("contact_mail1", "");
      }

      var1.put("var_nom_col1", this.var_nom_col1);
      var1.put("var_nom_col2", this.var_nom_col2);
      var1.put("var_nom_col3", this.var_nom_col3);
      var1.put("var_nom_col4", this.var_nom_col4);
      var1.put("var_nom_col5", this.var_nom_col5);
      var1.put("var_nom_col6", this.var_nom_col6);
      var1.put("var_nom_col7", this.var_nom_col7);
      var1.put("var_nom_col8", this.var_nom_col8);
      var1.put("var_nom_col9", this.var_nom_col9);
      var1.put("var_nom_col10", this.var_nom_col10);
      var1.put("var_nom_col11", this.var_nom_col11);
      var1.put("var_nom_col12", this.var_nom_col12);
      var1.put("var_nom_col13", this.var_nom_col13);
      var1.put("var_nom_col14", this.var_nom_col14);
      var1.put("var_nom_col15", this.var_nom_col15);
      var1.put("var_nom_col16", this.var_nom_col16);
      var1.put("var_nom_col17", this.var_nom_col17);
      var1.put("var_nom_col18", this.var_nom_col18);
      var1.put("var_nom_col19", this.var_nom_col19);
      var1.put("var_nom_col20", this.var_nom_col20);
      var1.put("m0DteDeb", this.m0DteDeb);
      var1.put("m0DteFin", this.m0DteFin);
      var1.put("m30DteDeb", this.m30DteDeb);
      var1.put("m30DteFin", this.m30DteFin);
      var1.put("m60DteDeb", this.m60DteDeb);
      var1.put("m60DteFin", this.m60DteFin);
      var1.put("m90DteDeb", this.m90DteDeb);
      var1.put("m90DteFin", this.m90DteFin);
      var1.put("m120DteDeb", this.m120DteDeb);
      if (this.structureLog.getStrLogo1() != null && !this.structureLog.getStrLogo1().isEmpty()) {
         var1.put("logo_1", this.cheminLogo + this.structureLog.getStrLogo1());
      } else {
         var1.put("logo_1", (Object)null);
      }

      if (this.structureLog.getStrLogo2() != null && !this.structureLog.getStrLogo2().isEmpty()) {
         var1.put("logo_2", this.cheminLogo + this.structureLog.getStrLogo2());
      } else {
         var1.put("logo_2", (Object)null);
      }

      if (this.structureLog.getStrLogo3() != null && !this.structureLog.getStrLogo3().isEmpty()) {
         var1.put("logo_3", this.cheminLogo + this.structureLog.getStrLogo3());
      } else {
         var1.put("logo_3", (Object)null);
      }

      if (this.structureLog.getStrLogo4() != null && !this.structureLog.getStrLogo4().isEmpty()) {
         var1.put("logo_4", this.cheminLogo + this.structureLog.getStrLogo4());
      } else {
         var1.put("logo_4", (Object)null);
      }

      if (this.structureLog.getStrLogo5() != null && !this.structureLog.getStrLogo5().isEmpty()) {
         var1.put("logo_5", this.cheminLogo + this.structureLog.getStrLogo5());
      } else {
         var1.put("logo_5", (Object)null);
      }

      if (this.structureLog.getStrLogo6() != null && !this.structureLog.getStrLogo6().isEmpty()) {
         var1.put("logo_6", this.cheminLogo + this.structureLog.getStrLogo6());
      } else {
         var1.put("logo_6", (Object)null);
      }

      if (this.structureLog.getStrLogo7() != null && !this.structureLog.getStrLogo7().isEmpty()) {
         var1.put("logo_7", this.cheminLogo + this.structureLog.getStrLogo7());
      } else {
         var1.put("logo_7", (Object)null);
      }

      if (this.structureLog.getStrLogo8() != null && !this.structureLog.getStrLogo8().isEmpty()) {
         var1.put("logo_8", this.cheminLogo + this.structureLog.getStrLogo8());
      } else {
         var1.put("logo_8", (Object)null);
      }

      if (this.structureLog.getStrLogo9() != null && !this.structureLog.getStrLogo9().isEmpty()) {
         var1.put("logo_9", this.cheminLogo + this.structureLog.getStrLogo9());
      } else {
         var1.put("logo_9", (Object)null);
      }

      if (this.structureLog.getStrLogo10() != null && !this.structureLog.getStrLogo10().isEmpty()) {
         var1.put("logo_10", this.cheminLogo + this.structureLog.getStrLogo10());
      } else {
         var1.put("logo_10", (Object)null);
      }

      var1.put("logo_100", (Object)null);
      var1.put("logo_101", (Object)null);
      var1.put("logo_102", (Object)null);
      var1.put("logo_103", (Object)null);
      var1.put("logo_104", (Object)null);
      if (this.structureLog.getStrcodepays().equals("0029")) {
         var1.put("logo_100", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "irpp_1.jpg");
         var1.put("logo_101", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "irpp_2.jpg");
      } else if (this.structureLog.getStrcodepays().equals("0077")) {
         var1.put("logo_100", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "logoCnss.gif");
         var1.put("logo_101", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "logoCnamgs.gif");
      } else if (this.structureLog.getStrcodepays().equals("0138")) {
         var1.put("logo_100", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "logoCaisseSecu.gif");
         var1.put("logo_101", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "titreCaisseSecu.gif");
      } else if (this.structureLog.getStrcodepays().equals("0202")) {
         var1.put("logo_100", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "logoCaisseSecu.gif");
         var1.put("logo_101", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "titreCaisseSecu.gif");
         var1.put("logo_102", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "piedPageCaisseSecu.gif");
         var1.put("logo_103", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "ipres_logo.jpg");
         var1.put("logo_104", StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + "ipres_declaration.jpg");
      }

      if (this.tiersSelectionne != null) {
      }

      var1.put("mails", this.usersLog.getUsrMail());
      var1.put("mails_societe", this.structureLog.getStradressemail());
      var1.put("banques", this.banquesStructure(var2));
      this.recupRespCreat(var2);
      var1.put("idEquipe", this.idEquipe);
      var1.put("signe_ville", this.sign_ville);
      var1.put("signe_nom", this.sign_nom);
      var1.put("signe_fonction", this.sign_fonction);
      var1.put("signe_metier", this.sign_metier);
      var1.put("signe_civilite", this.sign_civilite);
      if (this.sign_signature != null && !this.sign_signature.isEmpty() && !this.sign_signature.endsWith("pdf") && !this.sign_signature.endsWith("PDF")) {
         var1.put("signe_signature", this.cheminSignature + this.sign_signature);
      } else {
         var1.put("signe_signature", (Object)null);
      }

      var1.put("signe_mail", this.sign_mail);
      var1.put("signe_telephone", this.sign_telephone);
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         String var3 = "";
         String var4 = "";

         int var5;
         for(var5 = 0; var5 < var1.length(); ++var5) {
            var4 = (String)var1.subSequence(var5, var5 + 1);
            if ("1234567890".contains(var4)) {
               var3 = var3 + var4.toUpperCase();
            } else if (var4.equals("/")) {
               var3 = var3 + "0";
            } else {
               var3 = var3 + "";
            }
         }

         boolean var9 = false;
         byte var6 = 12;
         var5 = var3.length();
         int var7 = var6 - var5;
         String var8 = "";
         if (var7 == 1) {
            var8 = "0";
         } else if (var7 == 2) {
            var8 = "00";
         } else if (var7 == 3) {
            var8 = "000";
         } else if (var7 == 4) {
            var8 = "0000";
         } else if (var7 == 5) {
            var8 = "00000";
         } else if (var7 == 6) {
            var8 = "000000";
         } else if (var7 == 7) {
            var8 = "0000000";
         } else if (var7 == 8) {
            var8 = "00000000";
         } else if (var7 == 9) {
            var8 = "000000000";
         } else if (var7 == 10) {
            var8 = "0000000000";
         } else if (var7 == 11) {
            var8 = "00000000000";
         } else if (var7 == 12) {
            var8 = "000000000000";
         } else if (var7 == 13) {
            var8 = "0000000000000";
         } else if (var7 == 14) {
            var8 = "00000000000000";
         } else if (var7 == 15) {
            var8 = "000000000000000";
         } else if (var7 == 16) {
            var8 = "0000000000000000";
         } else if (var7 == 17) {
            var8 = "00000000000000000";
         } else if (var7 == 18) {
            var8 = "000000000000000000";
         } else if (var7 == 19) {
            var8 = "0000000000000000000";
         } else if (var7 == 20) {
            var8 = "00000000000000000000";
         }

         var2 = var8 + "" + var3;
      }

      return var2;
   }

   public String calculeSecurityCode() throws JSONException {
      String var1 = "";
      this.calculeModuleVente();
      JSONObject var2 = new JSONObject();
      String var3;
      MD5Password var4;
      if (this.numDoc != null && !this.numDoc.isEmpty()) {
         var2.put("tag", "%SEC%");
         var2.put("fdqn", new String(StaticModePegase.getUrlHost()));
         var2.put("user", new String("user@Guest#31"));
         var2.put("pwd", new String("547HijK_#Fg6"));
         var2.put("base", new Long(this.structureLog.getStrid()));
         var2.put("nature", new Integer(this.nature));
         var2.put("numero", new String(this.numDoc));
         var3 = var2.toString();
         var4 = new MD5Password();
         var1 = var4.doubleEncryption_Blowfish_Base64(var3);
      } else if (this.rapport.equals("UtilisateursQrCode") && this.idResponsable != 0L) {
         var2.put("tag", "%USR#%");
         var2.put("fdqn", new String(StaticModePegase.getUrlHost()));
         var2.put("user", new String("user@Guest#31"));
         var2.put("pwd", new String("547HijK_#Fg6"));
         var2.put("base", new Long(this.structureLog.getStrid()));
         var2.put("iduser", new Long(this.idResponsable));
         var3 = var2.toString();
         var4 = new MD5Password();
         var1 = var4.doubleEncryption_Blowfish_Base64(var3);
      } else if (this.rapport.equals("TiersQrCode") && this.idResponsable != 0L) {
         var2.put("tag", "%RONDE%");
         var2.put("base", new Long(this.structureLog.getStrid()));
         var2.put("idtiers", new Long(this.tiersSelectionne.getTieid()));
         var3 = var2.toString();
         var4 = new MD5Password();
         var1 = var4.doubleEncryption_Blowfish_Base64(var3);
      }

      return var1;
   }

   public String calculeSecurityCode(String var1, long var2) throws JSONException {
      String var4 = "";
      JSONObject var5 = new JSONObject();
      String var6;
      MD5Password var7;
      if (var1.equals("ImmobilisationQrCode") && var2 != 0L) {
         var5.put("tag", "%IMMO%");
         var5.put("base", new Long(this.structureLog.getStrid()));
         var5.put("num", new Long(var2));
         var6 = var5.toString();
         var7 = new MD5Password();
         var4 = var7.doubleEncryption_Blowfish_Base64(var6);
      } else if (var1.equals("ResetQrCode") && var2 == 0L) {
         var5.put("tag", "%RST#%");
         var5.put("iduser", new Long(this.idResponsable));
         var6 = var5.toString();
         var7 = new MD5Password();
         var4 = var7.doubleEncryption_Blowfish_Base64(var6);
      }

      return var4;
   }

   public void calculeModuleVente() {
      this.typeVente = 0;
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty() && this.structureLog.getStrmod1().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod1().substring(0, 3));
      } else if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty() && this.structureLog.getStrmod2().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod2().substring(0, 3));
      } else if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty() && this.structureLog.getStrmod3().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod3().substring(0, 3));
      } else if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty() && this.structureLog.getStrmod4().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod4().substring(0, 3));
      } else if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty() && this.structureLog.getStrmod5().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod5().substring(0, 3));
      } else if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty() && this.structureLog.getStrmod6().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod6().substring(0, 3));
      } else if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty() && this.structureLog.getStrmod7().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod7().substring(0, 3));
      } else if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty() && this.structureLog.getStrmod8().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod8().substring(0, 3));
      } else if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod9().isEmpty() && this.structureLog.getStrmod9().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod9().substring(0, 3));
      } else if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty() && this.structureLog.getStrmod10().startsWith("8")) {
         this.typeVente = Integer.parseInt(this.structureLog.getStrmod10().substring(0, 3));
      } else {
         this.typeVente = 801;
      }

   }

   public String mailsStructure(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      BalDao var3 = new BalDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.selectBalLogActif(this.structureLog.getStrid(), var1);
      if (var4.size() > 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            new Bal();
            Bal var6 = (Bal)var4.get(var5);
            var2 = var6.getBaladressemail();
         }
      }

      return var2;
   }

   public String banquesStructure(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      ContactDao var3 = new ContactDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.chargerLesContactsBq(var1);
      if (var4.size() > 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            new Contacts();
            Contacts var6 = (Contacts)var4.get(var5);
            if (var6.getTiers().getTiesigle() != null && !var6.getTiers().getTiesigle().isEmpty()) {
               if (var6.getConiban() != null && !var6.getConiban().isEmpty()) {
                  var2 = var6.getTiers().getTiesigle() + " " + var6.getConnumbanque() + " " + var6.getConguichetbanque() + " " + var6.getConcomptebanque() + ":" + var6.getConclebanque() + " IBAN " + var6.getConiban();
               } else {
                  var2 = var6.getTiers().getTiesigle() + " " + var6.getConnumbanque() + " " + var6.getConguichetbanque() + " " + var6.getConcomptebanque() + ":" + var6.getConclebanque();
               }
            } else if (var6.getConiban() != null && !var6.getConiban().isEmpty()) {
               var2 = var6.getTiers().getTieraisonsocialenom() + " " + var6.getConnumbanque() + " " + var6.getConguichetbanque() + " " + var6.getConcomptebanque() + ":" + var6.getConclebanque() + " IBAN " + var6.getConiban();
            } else {
               var2 = var6.getTiers().getTieraisonsocialenom() + " " + var6.getConnumbanque() + " " + var6.getConguichetbanque() + " " + var6.getConcomptebanque() + ":" + var6.getConclebanque();
            }
         }
      }

      return var2;
   }

   public void recupRespCreat(Session var1) throws HibernateException, NamingException {
      this.sign_id = 0L;
      this.sign_nom = "";
      this.sign_prenom = "";
      this.sign_fonction = "";
      this.sign_metier = "";
      this.sign_civilite = "";
      this.sign_signature = "";
      this.sign_mail = "";
      this.sign_telephone = "";
      if (this.idResponsable == 0L && this.idCommercial == 0L) {
         if (this.usersLog != null) {
            this.sign_id = this.usersLog.getUsrid();
            this.sign_nom = this.usersLog.getUsrNom();
            this.sign_prenom = this.usersLog.getUsrPrenom();
            this.sign_fonction = this.usersLog.getUsrFonction();
            this.sign_metier = this.usersLog.getUsrMetier();
            this.sign_civilite = this.usersLog.getUsrCivilite();
            this.sign_ville = this.usersLog.getUsrVille();
            this.sign_signature = this.usersLog.getUsrSignature();
            this.sign_mail = this.usersLog.getUsrMail();
            this.sign_telephone = this.usersLog.getUsrTelBureau();
         } else {
            this.sign_mail = "";
         }
      } else {
         Users var2 = new Users();
         UserDao var3 = new UserDao(this.baseLog, this.utilInitHibernate);
         if (this.idCommercial != 0L) {
            var2 = var3.selectByIdUsers(this.idCommercial, var1);
         } else if (this.idResponsable != 0L) {
            var2 = var3.selectByIdUsers(this.idResponsable, var1);
         }

         if (var2 != null) {
            this.sign_id = var2.getUsrid();
            this.sign_nom = var2.getUsrNom();
            this.sign_prenom = var2.getUsrPrenom();
            this.sign_fonction = var2.getUsrFonction();
            this.sign_metier = var2.getUsrMetier();
            this.sign_civilite = var2.getUsrCivilite();
            this.sign_ville = var2.getUsrVille();
            this.sign_signature = var2.getUsrSignature();
            this.sign_mail = var2.getUsrMail();
            this.sign_telephone = var2.getUsrTelBureau();
         } else {
            this.sign_id = this.usersLog.getUsrid();
            this.sign_nom = this.usersLog.getUsrNom();
            this.sign_prenom = this.usersLog.getUsrPrenom();
            this.sign_fonction = this.usersLog.getUsrFonction();
            this.sign_metier = this.usersLog.getUsrMetier();
            this.sign_civilite = this.usersLog.getUsrCivilite();
            this.sign_ville = this.usersLog.getUsrVille();
            this.sign_signature = this.usersLog.getUsrSignature();
            this.sign_mail = this.usersLog.getUsrMail();
            this.sign_telephone = this.usersLog.getUsrTelBureau();
         }
      }

      if (this.sign_civilite == null) {
         this.sign_civilite = "";
      }

      if (this.sign_nom == null) {
         this.sign_nom = "";
      }

      if (this.sign_prenom == null) {
         this.sign_prenom = "";
      }

      if (this.sign_fonction == null) {
         this.sign_fonction = "";
      }

      if (this.sign_metier == null) {
         this.sign_metier = "";
      }

      if (this.sign_signature == null) {
         this.sign_signature = "";
      }

      if (this.sign_ville == null || !this.sign_ville.isEmpty()) {
         this.sign_ville = this.structureLog.getStrville();
      }

      if (this.sign_mail == null) {
         this.sign_mail = "";
      }

      if (this.sign_telephone == null) {
         this.sign_telephone = "";
      }

      if (this.sign_prenom != null && !this.sign_prenom.isEmpty()) {
         this.sign_nom = this.sign_prenom + " " + this.sign_nom;
      }

   }

   public void generationMail(String var1, String var2, String var3, List var4) throws Exception {
      String var5 = "";
      if (this.lesbalDestinataires.size() != 0) {
         for(int var6 = 0; var6 < this.lesbalDestinataires.size(); ++var6) {
            if (((ObjetBal)this.lesbalDestinataires.get(var6)).isLigneSelect() && ((ObjetBal)this.lesbalDestinataires.get(var6)).getLigneMail() != null && !((ObjetBal)this.lesbalDestinataires.get(var6)).getLigneMail().isEmpty() && ((ObjetBal)this.lesbalDestinataires.get(var6)).getLigneMail().contains("@")) {
               if (var5 != null && !var5.isEmpty()) {
                  var5 = var5 + "," + ((ObjetBal)this.lesbalDestinataires.get(var6)).getLigneMail();
               } else {
                  var5 = ((ObjetBal)this.lesbalDestinataires.get(var6)).getLigneMail();
               }
            }
         }
      }

      this.destinataire = var5;
      if (var1 != null && !var1.isEmpty() && (var5 != null && !var5.isEmpty() || var2 != null && !var2.isEmpty() || var3 != null && !var3.isEmpty())) {
         Session var19 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
         if (var5 != null && !var5.isEmpty()) {
            this.recupererContact(var5, var19);
         } else {
            this.contact = null;
         }

         Bal var7 = new Bal();
         var7 = this.recupererEmetteur(var1, var7, this.baseLog, var19);
         if (var7 != null) {
            String var8 = "";
            if (var8 == null || var8.isEmpty()) {
               var8 = "<html><head></head><body ><h:form>";
               var8 = var8 + "<table style=\"border:1px dotted green\" align=\"center\" width=\"100%\">";
               var8 = var8 + "<thead></thead>";
               String var9 = "";
               if (this.contact != null && this.contact.getConid() != 0L) {
                  var9 = this.contact.getConcivilite();
               }

               if (var9.equals("")) {
                  var9 = "Madame, Monsieur";
               }

               var8 = var8 + "<table><tbody><tr><td>Bonjour, " + var9 + ", <br/>" + "<br/>";
               var8 = var8 + this.corpsMail;
               var8 = var8 + "<br/><br/>Emetteur : &nbsp; " + this.structureLog.getStrraisonsociale() + "<br/>";
               var8 = var8 + "Contact : &nbsp; " + this.sign_civilite + " " + this.sign_nom + "<br/>";
               var8 = var8 + "Type de document : &nbsp; " + this.rapport + ".pdf" + "<br/>" + "<br/>";
               var8 = var8 + "Restant &agrave; votre &eacute;coute pour toutes informations compl&eacute;mentaires, veuillez agr&eacute;er, " + var9 + ", l'expressions de nos sentiments distingu&eacute;s. " + "<br/>" + "<br/>";
               if (this.sign_prenom != null && !this.sign_prenom.isEmpty()) {
                  var8 = var8 + "Cordialement, <br/>" + this.sign_prenom + "." + "<br/>";
               } else {
                  var8 = var8 + "Cordialement, <br/>" + this.sign_nom + "." + "<br/>";
               }

               if (this.sign_metier != null && !this.sign_metier.isEmpty()) {
                  var8 = var8 + this.sign_metier + "<br/>";
               } else if (this.sign_fonction != null && !this.sign_fonction.isEmpty()) {
                  var8 = var8 + this.sign_fonction + "<br/>";
               }

               var8 = var8 + "<br/><i style=\"color:red;font-size:11px;\">Ce message vous est ";
               var8 = var8 + "envoy&eacute; automatiquement &agrave; partir de la plateforme de gestion e-P&eacute;gase (https://www.e-pegase.biz/epegase/).</i></td></tr><tr><td></td></tr></tbody></table>";
               if (var7 != null && var7.getBalSignature() != null) {
                  var8 = var8 + "<br/><br/>" + var7.getBalSignature();
               } else {
                  var8 = var8 + "---";
               }

               var8 = var8 + "</h:form></body></html>";
            }

            UtilMail var20 = new UtilMail(this.structureLog);
            String var10 = "";
            if (this.idResponsable != 0L && this.sign_mail.contains("@")) {
               var10 = this.sign_mail;
            }

            String var11 = "";
            if (this.rapport != null && !this.rapport.isEmpty()) {
               var11 = var20.sendMail(var8, this.destinataire, this.destinataireCC, this.destinataireCCI, this.emetteur, var10, "Document : " + this.rapport + ".pdf", var7, var4);
            } else {
               var11 = var20.sendMail(var8, this.destinataire, this.destinataireCC, this.destinataireCCI, this.emetteur, var10, "Informations ePegase", var7, var4);
            }

            Transaction var12 = null;

            try {
               var12 = var19.beginTransaction();
               this.insertMail(var11, var8, var7, var1, var5, var2, var3, var10, var4, var19);
               var12.commit();
            } catch (HibernateException var17) {
               if (var12 != null) {
                  var12.rollback();
               }

               throw var17;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public String calcultexte() {
      String var1 = "";
      if (this.nature == 10) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, notre demande d`achat.";
      } else if (this.nature == 11) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, notre demande de cotation.";
      } else if (this.nature == 12) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, notre commande ferme.";
      } else if (this.nature == 13) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, notre r&eacute;ception.";
      } else if (this.nature == 14) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, la marchandise que nous vous retournons.";
      } else if (this.nature == 15) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture dont nous accusons r&eacute;ception.";
      } else if (this.nature == 16) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre avoir dont nous accusons r&eacute;ception.";
      } else if (this.nature == 17) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre note de d&eacute;bit dont nous accusons r&eacute;ception.";
      } else if (this.nature == 18) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture de frais.";
      } else if (this.nature == 19) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bon de d&eacute;caissement.";
      } else if (this.nature == 150) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bon de r&eacute;acheminement.";
      } else if (this.nature == 7) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre calcul de commission.";
      } else if (this.nature == 8) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, notre r&eacute;flexion concernant votre demande.";
      } else if (this.nature == 9) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre contrat.";
      } else if (this.nature == 20) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, notre r&eacute;flexion concernant votre demande.";
      } else if (this.nature == 21) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, notre meilleure offre concernant votre demande.";
      } else if (this.nature == 22) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, la commande que vous nous avez confirm&eacute;e.";
      } else if (this.nature == 23) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, la livraison que vous allez recevoir.";
      } else if (this.nature == 24) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, le retour que nous avons constat&eacute;.";
      } else if (this.nature == 25) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture.";
      } else if (this.nature == 26) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre avoir.";
      } else if (this.nature == 27) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre note de d&eacute;bit.";
      } else if (this.nature == 28) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre chargement.";
      } else if (this.nature == 29) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bon encaissement.";
      } else if (this.nature == 140) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre contrat.";
      } else if (this.nature == 141) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre campagne.";
      } else if (this.nature == 142) {
         this.cat = 0;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture interne.";
      } else if (this.nature == 30) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre inventaire.";
      } else if (this.nature == 31) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bon d`entr&eacute;e.";
      } else if (this.nature == 32) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bon de sortie.";
      } else if (this.nature == 33) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre cession de marchandises.";
      } else if (this.nature == 34) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre production.";
      } else if (this.nature == 35) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre valorisation.";
      } else if (this.nature == 36) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre sommier.";
      } else if (this.nature == 37) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre s&eacute;rialisation.";
      } else if (this.nature == 38) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre lot.";
      } else if (this.nature == 40) {
         this.cat = 1;
      } else if (this.nature == 41) {
         this.cat = 1;
      } else if (this.nature == 42) {
         this.cat = 1;
      } else if (this.nature == 43) {
         this.cat = 1;
      } else if (this.nature == 44) {
         this.cat = 1;
      } else if (this.nature == 45) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre cosommation.";
      } else if (this.nature == 46) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre O.R..";
      } else if (this.nature == 47) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre manifeste";
      } else if (this.nature == 48) {
         this.cat = 1;
      } else if (this.nature == 49) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre chargement.";
      } else if (this.nature == 50) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre loyer.";
      } else if (this.nature == 51) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre immobilisation.";
      } else if (this.nature == 52) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre budget.";
      } else if (this.nature == 53) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, vos journaux.";
      } else if (this.nature == 531) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre brouillard du jour.";
      } else if (this.nature == 532) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre brouillard du mois.";
      } else if (this.nature == 534) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votrre extrait de compte.";
      } else if (this.nature == 535) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre extrait analytique.";
      } else if (this.nature == 538) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre extrait de projet.";
      } else if (this.nature == 539) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre extrait de projet.";
      } else if (this.nature == 54) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre budget de tr&eacute;sorerie.";
      } else if (this.nature == 56) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre rapprochement bancaire.";
      } else if (this.nature == 57) {
         this.cat = 1;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, vos notes externes.";
      } else if (this.nature == 60) {
         this.cat = 1;
      } else if (this.nature == 61) {
         this.cat = 1;
      } else if (this.nature == 62) {
         this.cat = 1;
      } else if (this.nature == 63) {
         this.cat = 1;
      } else if (this.nature == 64) {
         this.cat = 1;
      } else if (this.nature == 65) {
         this.cat = 1;
      } else if (this.nature == 70) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre consultation.";
      } else if (this.nature == 71) {
         this.cat = 2;
      } else if (this.nature == 72) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre ordonnance.";
      } else if (this.nature == 73) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture de pharmacie.";
      } else if (this.nature == 74) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre analyse de laboratoire.";
      } else if (this.nature == 75) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre r&eacute;sultat d`analyse.";
      } else if (this.nature == 76) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre hospitalisation.";
      } else if (this.nature == 77) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre devis.";
      } else if (this.nature == 78) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture.";
      } else if (this.nature == 79) {
         this.cat = 2;
      } else if (this.nature == 180) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre rapport m&eacute;dical.";
      } else if (this.nature == 181) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture.";
      } else if (this.nature == 182) {
         this.cat = 2;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre r&eacute;capitulatif.";
      } else if (this.nature == 80) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre document des ressoures humaines.";
      } else if (this.nature == 81 && this.bulletinSelectionne != null) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bulletin de salaire pour la période du " + this.bulletinSelectionne.getBulsalPeriode() + ".";
         this.cat = 3;
      } else if (this.nature == 81 && this.bulletinSelectionne == null) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre fiche.";
         this.cat = 3;
      } else if (this.nature == 82) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre contrat de travail.";
      } else if (this.nature == 83) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre attestation.";
      } else if (this.nature == 84) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre document de cursus.";
      } else if (this.nature == 85) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre vertificat.";
      } else if (this.nature == 86) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre correspondance;";
      } else if (this.nature == 87) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre &eacute;ch&eacute;ancier de prr&egrave;t;";
      } else if (this.nature == 88) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre document de cong&eacute;s pay&eacute;s;";
      } else if (this.nature == 89) {
         this.cat = 3;
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre document d`absence";
      } else if (this.nature == 90 && this.bulletinSelectionne != null) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bulletin de salaire pour la période du " + this.bulletinSelectionne.getBulsalPeriode() + ".";
         this.cat = 3;
      } else if (this.nature == 91) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre document de mission";
         this.cat = 3;
      } else if (this.nature == 92) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre document de pointage";
         this.cat = 3;
      } else if (this.nature == 93) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre document des ressoures humaines.";
         this.cat = 3;
      } else if (this.nature == 99) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre C.V..";
         this.cat = 3;
      } else if (this.nature == 4) {
         this.cat = 4;
         var1 = "Veuillez corriger le document ci-joint en apportant les correctifs sp&eacute;cifi&eacute;s";
      } else if (this.nature == 100) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre fiche.";
         this.cat = 5;
      } else if (this.nature == 101) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre fiche m&eacute;diath&egrave;que.";
         this.cat = 5;
      } else if (this.nature == 102) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture.";
         this.cat = 5;
      } else if (this.nature == 103) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, vos pr&eacute;sences.";
         this.cat = 5;
      } else if (this.nature == 104) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, vos notes.";
         this.cat = 5;
      } else if (this.nature == 105) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, vos violences.";
         this.cat = 5;
      } else if (this.nature == 109) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre bon d`encaissement.";
         this.cat = 5;
      } else if (this.nature == 160) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre Bien";
         this.cat = 6;
      } else if (this.nature == 161) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre contrat g&eacute;rance";
         this.cat = 6;
      } else if (this.nature == 162) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, vottre bail locatif";
         this.cat = 6;
      } else if (this.nature == 163) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, vos travaux";
         this.cat = 6;
      } else if (this.nature == 164) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture de charges";
         this.cat = 6;
      } else if (this.nature == 165) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre facture de location";
         this.cat = 6;
      } else if (this.nature == 171) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre contrat de syndic";
         this.cat = 6;
      } else if (this.nature == 172) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre budget";
         this.cat = 6;
      } else if (this.nature == 173) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre appel de charges";
         this.cat = 6;
      } else if (this.nature == 175) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre pr&eacute;paration PV";
         this.cat = 6;
      } else if (this.nature == 176) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, votre d&eacute;cisions AG";
         this.cat = 6;
      }

      if (var1.isEmpty()) {
         var1 = "Veuillez trouver en pi&egrave;ce jointe, le document que vous nous avez demand&eacute;.";
      }

      return var1;
   }

   public Bal recupererEmetteur(String var1, Bal var2, String var3, Session var4) throws HibernateException, NamingException {
      this.baseLog = var3;
      BalDao var5 = new BalDao(this.baseLog, this.utilInitHibernate);
      if (var1 != null) {
         if (var1.equals("SOCIETE")) {
            var2 = var5.chargeMailSociete(this.structureLog.getStrid(), var4);
         } else {
            var2 = var5.logMailExiste(var1, var4);
         }
      } else {
         var2 = null;
      }

      if (var2 == null) {
         var2 = new Bal();
         var2.setBalssl(StaticModePegase.getSslEmmeteurSmp());
         var2.setBalsmtauthentification(StaticModePegase.getAuthentificationEmetteurSmp());
         var2.setBalsmtpserveur(StaticModePegase.getServeurEmetteurSmp());
         var2.setBalsmtpport(StaticModePegase.getPortEmetteurSmp());
         var2.setBaladressemail(StaticModePegase.getAdresseEmetteurSmp());
         var2.setBalpw(StaticModePegase.getPwEmetteurSmp());
         if (this.idResponsable != 0L && this.sign_mail.contains("@")) {
            var2.setBaladressemailreponse(this.sign_mail);
         } else {
            var2.setBaladressemailreponse((String)null);
         }
      }

      return var2;
   }

   public void recupererContact(String var1, Session var2) throws HibernateException, NamingException {
      if (this.tiersSelectionne != null) {
         ContactDao var3 = new ContactDao(this.baseLog, this.utilInitHibernate);
         this.contact = new Contacts();
         this.contact = var3.selectContactsEmail(var1, var2);
      } else {
         UserDao var5 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.contact = new Contacts();
         new Users();
         Users var4 = var5.logUser(var1, var2);
         if (var4 != null) {
            this.contact.setConid(var4.getUsrid());
            this.contact.setConcivilite(var4.getUsrCivilite());
         } else {
            this.contact = null;
         }
      }

   }

   public Patients recupPatients(String var1) throws HibernateException, NamingException {
      this.patientsSelectionne = new Patients();
      this.patientContact = new PatientContact();
      PatientContactDao var2 = new PatientContactDao(this.baseLog, this.utilInitHibernate);
      PatientsDao var3 = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.patientContact = var2.selectPatientsEmail(var1, (Session)null);
      if (this.patientsEncours != null) {
         this.patientsSelectionne = this.patientsEncours;
      } else if (this.patientContact != null) {
         this.patientsSelectionne = var3.selectPatientsD(this.patientContact.getPatient().getPatId());
      }

      return this.patientsSelectionne;
   }

   public void insertMail(String var1, String var2, Bal var3, String var4, String var5, String var6, String var7, String var8, List var9, Session var10) {
      MailsDao var11 = new MailsDao(this.baseLog, this.utilInitHibernate);
      Mails var12 = new Mails();
      var12.setMaiNum(this.calculeChrono());
      var12.setMaiDateCreation(new Date());
      var12.setMaiUserCreation(this.usersLog.getUsrid());
      var12.setMaiDateModif((Date)null);
      var12.setMaiUserModif(0L);
      var12.setMaiStr(var3.getBalStructure());
      var12.setMaiGrp(var3.getBalGroupe());
      var12.setMaiUsr(var3.getBalUser());
      var12.setMaiModele("");
      var12.setMaiNosRef(this.usersLog.getUsrCollaboration() + "/" + this.initialeUsers() + "/");
      var12.setMaiVosRef("");
      var12.setMaiPriorite(0);
      var12.setMaiType(0);
      var12.setMaiSens(0);
      var12.setMaiStatut(var1);
      if (var1 != null && !var1.isEmpty()) {
         var12.setMaiErreur(true);
      } else {
         var12.setMaiErreur(false);
      }

      var12.setMaiPj(1);
      var12.setMaiEmetteur(var4);
      var12.setMaiObjet("Document : " + this.rapport + ".pdf");
      var12.setMaiDestinataire(var5);
      var12.setMaiCc(var6);
      var12.setMaiCci(var7);
      var12.setMaiCorps(var2);
      if (this.cat == 0 && this.tiersSelectionne != null) {
         var12.setMaiTiersId(this.tiersSelectionne.getTieid());
         if (this.tiersSelectionne.getTieprenom() != null && !this.tiersSelectionne.getTieprenom().isEmpty()) {
            var12.setMaiTiersRs(this.tiersSelectionne.getTieraisonsocialenom() + " " + this.tiersSelectionne.getTieprenom());
         } else {
            var12.setMaiTiersRs(this.tiersSelectionne.getTieraisonsocialenom());
         }
      } else if (this.cat == 1) {
         var12.setMaiAgentId(0L);
         var12.setMaiAgentNom("");
      } else if (this.cat == 2 && this.patientsSelectionne != null) {
         var12.setMaiPatientId(this.patientsSelectionne.getPatId());
         var12.setMaiPatientNom(this.patientsSelectionne.getPatronyme());
      } else if (this.cat == 3 && this.bulletinSelectionne != null) {
         var12.setMaiSalarieId(this.bulletinSelectionne.getSalaries().getSalId());
         var12.setMaiSalarieNom(this.bulletinSelectionne.getSalaries().getPatronyme());
      }

      var12 = var11.insertMail(var12, var10);
      var12.setMaiNum("" + var12.getMaiId());
      var12.setMaiNosRef(var12.getMaiNosRef() + var12.getMaiNum());
      var12 = var11.modifMail(var12, var10);
      MailsPJDao var13 = new MailsPJDao(this.baseLog, this.utilInitHibernate);
      if (var9.size() != 0) {
         for(int var14 = 0; var14 < var9.size(); ++var14) {
            MailsPj var15 = new MailsPj();
            var15.setMails(var12);
            var15.setMalpjAcces(((File)var9.get(var14)).getName());
            var13.insertMailPj(var15, var10);
         }
      }

   }

   public String calculeChrono() {
      String var1 = "x";
      return var1;
   }

   public String initialeUsers() {
      String var1 = this.usersLog.getUsrNom().toUpperCase() + " " + this.usersLog.getUsrPrenom().toUpperCase();
      String[] var2 = var1.split(" ");
      int var3 = var2.length;
      String var4 = "";

      for(int var5 = 0; var5 < var3; ++var5) {
         var4 = var4 + var2[var5].substring(0, 1);
      }

      return var4;
   }

   public void chargerLesBalEmtteurs(String var1, Structure var2, Users var3, Tiers var4, String var5) throws HibernateException, NamingException {
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.tiersSelectionne = var4;
      this.patientsSelectionne = null;
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      this.lesbalEmetteursItems = new ArrayList();
      this.lesbalEmetteursItems.add(new SelectItem("infos@e-pegase.biz"));
      this.chargerLesContacts(var4, var5, var6);
      this.utilInitHibernate.closeSession();
   }

   public void chargerLesBalEmtteurs(String var1, Structure var2, Users var3, Salaries var4) throws HibernateException, NamingException {
      this.lesbalDestinatairesItems.clear();
      this.lesbalDestinataires.clear();
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.patientsSelectionne = null;
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      this.lesbalEmetteursItems = new ArrayList();
      this.lesbalEmetteursItems.add(new SelectItem("infos@e-pegase.biz"));
      if (var4 != null) {
         if (var4.getSalMail1() != null && var4.getSalMail1().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var4.getSalMail1()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var4.getPatronyme());
            this.objetBal.setLigneMail(var4.getSalMail1());
            this.lesbalDestinataires.add(this.objetBal);
         }

         if (var4.getSalAol() != null && var4.getSalAol().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var4.getSalAol()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var4.getPatronyme());
            this.objetBal.setLigneMail(var4.getSalAol());
            this.lesbalDestinataires.add(this.objetBal);
         }

         if (var4.getSalYahoo() != null && var4.getSalYahoo().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var4.getSalYahoo()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var4.getPatronyme());
            this.objetBal.setLigneMail(var4.getSalYahoo());
            this.lesbalDestinataires.add(this.objetBal);
         }

         if (var4.getSalMsn() != null && var4.getSalMsn().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var4.getSalMsn()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var4.getPatronyme());
            this.objetBal.setLigneMail(var4.getSalMsn());
            this.lesbalDestinataires.add(this.objetBal);
         }
      }

      this.dataModelLesDestinataires.setWrappedData(this.lesbalDestinataires);
      this.utilInitHibernate.closeSession();
   }

   public void chargerLesBalEmtteurs(String var1, Structure var2, Users var3, Patients var4) throws HibernateException, NamingException {
      this.lesbalDestinatairesItems.clear();
      this.lesbalDestinataires.clear();
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.patientsSelectionne = var4;
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      this.lesbalEmetteursItems = new ArrayList();
      this.lesbalEmetteursItems.add(new SelectItem("infos@e-pegase.biz"));
      if (var4 != null) {
         if (var4.getPatMail1() != null && var4.getPatMail1().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var4.getPatMail1()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var4.getPatronyme());
            this.objetBal.setLigneMail(var4.getPatMail1());
            this.lesbalDestinataires.add(this.objetBal);
         }

         if (var4.getPatYahoo() != null && var4.getPatYahoo().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var4.getPatYahoo()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var4.getPatronyme());
            this.objetBal.setLigneMail(var4.getPatYahoo());
            this.lesbalDestinataires.add(this.objetBal);
         }

         if (var4.getPatMsn() != null && var4.getPatMsn().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var4.getPatMsn()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var4.getPatronyme());
            this.objetBal.setLigneMail(var4.getPatMsn());
            this.lesbalDestinataires.add(this.objetBal);
         }
      }

      this.dataModelLesDestinataires.setWrappedData(this.lesbalDestinataires);
      this.utilInitHibernate.closeSession();
   }

   public void chargerLesContacts(Tiers var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesbalDestinatairesItems.clear();
      this.lesbalDestinataires.clear();
      List var5;
      int var6;
      boolean var8;
      if (this.tiersSelectionne != null) {
         if (var1.getTiemail1() != null && var1.getTiemail1().contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var1.getTiemail1()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var1.getTieraisonsocialenom());
            this.objetBal.setLigneMail(var1.getTiemail1());
            this.lesbalDestinataires.add(this.objetBal);
         }

         boolean var4;
         if (var1.getTiemail2() != null && var1.getTiemail2().contains("@")) {
            var4 = this.verifUniciteMail(var1.getTiemail2());
            if (!var4) {
               this.lesbalDestinatairesItems.add(new SelectItem(var1.getTiemail2()));
               this.objetBal = new ObjetBal();
               this.objetBal.setLigneSelect(false);
               this.objetBal.setLignePatronyme(var1.getTieraisonsocialenom());
               this.objetBal.setLigneMail(var1.getTiemail2());
               this.lesbalDestinataires.add(this.objetBal);
            }
         }

         if (var1.getTiemail3() != null && var1.getTiemail3().contains("@")) {
            var4 = this.verifUniciteMail(var1.getTiemail3());
            if (!var4) {
               this.lesbalDestinatairesItems.add(new SelectItem(var1.getTiemail3()));
               this.objetBal = new ObjetBal();
               this.objetBal.setLigneSelect(false);
               this.objetBal.setLignePatronyme(var1.getTieraisonsocialenom());
               this.objetBal.setLigneMail(var1.getTiemail3());
               this.lesbalDestinataires.add(this.objetBal);
            }
         }

         if (var1.getTiemail4() != null && var1.getTiemail4().contains("@")) {
            var4 = this.verifUniciteMail(var1.getTiemail4());
            if (!var4) {
               this.lesbalDestinatairesItems.add(new SelectItem(var1.getTiemail4()));
               this.objetBal = new ObjetBal();
               this.objetBal.setLigneSelect(false);
               this.objetBal.setLignePatronyme(var1.getTieraisonsocialenom());
               this.objetBal.setLigneMail(var1.getTiemail4());
               this.lesbalDestinataires.add(this.objetBal);
            }
         }

         if (var1.getTiemail5() != null && var1.getTiemail5().contains("@")) {
            var4 = this.verifUniciteMail(var1.getTiemail5());
            if (!var4) {
               this.lesbalDestinatairesItems.add(new SelectItem(var1.getTiemail5()));
               this.objetBal = new ObjetBal();
               this.objetBal.setLigneSelect(false);
               this.objetBal.setLignePatronyme(var1.getTieraisonsocialenom());
               this.objetBal.setLigneMail(var1.getTiemail5());
               this.lesbalDestinataires.add(this.objetBal);
            }
         }

         ContactDao var9 = new ContactDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         var5 = var9.chargerLesContactsEmail(var1.getTieid(), var3);

         for(var6 = 0; var6 < var5.size(); ++var6) {
            new Contacts();
            Contacts var7 = (Contacts)var5.get(var6);
            if (var7.getConmail1() != null && var7.getConmail1().contains("@")) {
               var8 = this.verifUniciteMail(var7.getConmail1());
               if (!var8) {
                  this.lesbalDestinatairesItems.add(new SelectItem(var7.getConmail1() + ":" + var7.getConpatronyme()));
                  this.objetBal = new ObjetBal();
                  this.objetBal.setLigneSelect(false);
                  this.objetBal.setLignePatronyme(var7.getConpatronyme());
                  this.objetBal.setLigneMail(var7.getConmail1());
                  this.lesbalDestinataires.add(this.objetBal);
               }
            }

            if (var7.getConmail2() != null && var7.getConmail2().contains("@")) {
               var8 = this.verifUniciteMail(var7.getConmail2());
               if (!var8) {
                  this.lesbalDestinatairesItems.add(new SelectItem(var7.getConmail2() + ":" + var7.getConpatronyme()));
                  this.objetBal = new ObjetBal();
                  this.objetBal.setLigneSelect(false);
                  this.objetBal.setLignePatronyme(var7.getConpatronyme());
                  this.objetBal.setLigneMail(var7.getConmail2());
                  this.lesbalDestinataires.add(this.objetBal);
               }
            }

            if (var7.getConmail3() != null && var7.getConmail3().contains("@")) {
               var8 = this.verifUniciteMail(var7.getConmail3());
               if (!var8) {
                  this.lesbalDestinatairesItems.add(new SelectItem(var7.getConmail3() + ":" + var7.getConpatronyme()));
                  this.objetBal = new ObjetBal();
                  this.objetBal.setLigneSelect(false);
                  this.objetBal.setLignePatronyme(var7.getConpatronyme());
                  this.objetBal.setLigneMail(var7.getConmail3());
                  this.lesbalDestinataires.add(this.objetBal);
               }
            }

            if (var7.getConmail4() != null && var7.getConmail4().contains("@")) {
               var8 = this.verifUniciteMail(var7.getConmail4());
               if (!var8) {
                  this.lesbalDestinatairesItems.add(new SelectItem(var7.getConmail4() + ":" + var7.getConpatronyme()));
                  this.objetBal = new ObjetBal();
                  this.objetBal.setLigneSelect(false);
                  this.objetBal.setLignePatronyme(var7.getConpatronyme());
                  this.objetBal.setLigneMail(var7.getConmail4());
                  this.lesbalDestinataires.add(this.objetBal);
               }
            }

            if (var7.getConmail5() != null && var7.getConmail5().contains("@")) {
               var8 = this.verifUniciteMail(var7.getConmail5());
               if (!var8) {
                  this.lesbalDestinatairesItems.add(new SelectItem(var7.getConmail5() + ":" + var7.getConpatronyme()));
                  this.objetBal = new ObjetBal();
                  this.objetBal.setLigneSelect(false);
                  this.objetBal.setLignePatronyme(var7.getConpatronyme());
                  this.objetBal.setLigneMail(var7.getConmail5());
                  this.lesbalDestinataires.add(this.objetBal);
               }
            }
         }

         if (var2 != null && !var2.isEmpty() && var2.contains("@")) {
            this.lesbalDestinatairesItems.add(new SelectItem(var2, var2));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var2);
            this.objetBal.setLigneMail(var2);
            this.lesbalDestinataires.add(this.objetBal);
         }
      } else {
         UserDao var10 = new UserDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         var5 = var10.selectUserActif(var3);

         for(var6 = 0; var6 < var5.size(); ++var6) {
            new Users();
            Users var11 = (Users)var5.get(var6);
            if (var11.getUsrMail() != null && var11.getUsrMail().contains("@")) {
               var8 = this.verifUniciteMail(var11.getUsrMail());
               if (!var8) {
                  this.lesbalDestinatairesItems.add(new SelectItem(var11.getUsrMail() + ":" + var11.getUsrPatronyme()));
                  this.objetBal = new ObjetBal();
                  this.objetBal.setLigneSelect(false);
                  this.objetBal.setLignePatronyme(var11.getUsrPatronyme());
                  this.objetBal.setLigneMail(var11.getUsrMail());
                  this.lesbalDestinataires.add(this.objetBal);
               }
            }
         }
      }

      this.dataModelLesDestinataires.setWrappedData(this.lesbalDestinataires);
   }

   public boolean verifUniciteMail(String var1) {
      boolean var2 = false;
      if (this.lesbalDestinatairesItems.size() != 0) {
         for(int var3 = 0; var3 < this.lesbalDestinatairesItems.size(); ++var3) {
            if (((SelectItem)this.lesbalDestinatairesItems.get(var3)).getLabel().equals(var1)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public void chargerLesBalEmtteursPatient(String var1, Structure var2, Users var3, Patients var4) throws HibernateException, NamingException {
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.tiersSelectionne = null;
      this.patientsSelectionne = var4;
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      BalDao var6 = new BalDao(this.baseLog, this.utilInitHibernate);
      ArrayList var7 = new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      List var8 = var6.selectBalLogActif(this.structureLog.getStrid(), var5);
      List var9 = var6.selectBalGrpLogActif(this.usersLog.getUsrCollaboration(), var5);
      List var10 = var6.selectBalUserLogActif(this.usersLog.getUsrid(), var5);
      int var11;
      if (var8.size() != 0) {
         for(var11 = 0; var11 < var8.size(); ++var11) {
            var7.add(var8.get(var11));
         }
      }

      if (var9.size() != 0) {
         for(var11 = 0; var11 < var9.size(); ++var11) {
            var7.add(var9.get(var11));
         }
      }

      if (var10.size() != 0) {
         for(var11 = 0; var11 < var10.size(); ++var11) {
            var7.add(var10.get(var11));
         }
      }

      this.lesbalEmetteursItems = new ArrayList();
      if (var7.size() != 0) {
         for(var11 = 0; var11 < var7.size(); ++var11) {
            new Bal();
            Bal var12 = (Bal)var7.get(var11);
            this.lesbalEmetteursItems.add(new SelectItem(var12.getBaladressemail()));
         }
      }

      if (this.structureLog.getStrsmtChoix() == 1) {
         this.lesbalEmetteursItems.add(new SelectItem("epegase.biz@gmail.com"));
      } else if (this.structureLog.getStrsmtChoix() == 2) {
         this.lesbalEmetteursItems.add(new SelectItem("infos.epegase@yahoo.fr"));
      } else if (this.structureLog.getStrsmtChoix() == 0) {
         this.lesbalEmetteursItems.add(new SelectItem("assistance@e-pegase.biz"));
      } else if (this.structureLog.getStrsmtChoix() == 5) {
         this.lesbalEmetteursItems.add(new SelectItem("infos@e-pegase.info"));
      } else if (this.structureLog.getStrsmtChoix() == 6) {
         this.lesbalEmetteursItems.add(new SelectItem("infos@e-pegase.biz"));
      }

      this.chargerLesContactsPatient(var4, var5);
      this.utilInitHibernate.closeSession();
   }

   public void chargerLesContactsPatient(Patients var1, Session var2) throws HibernateException, NamingException {
      this.lesbalDestinatairesItems.clear();
      this.lesbalDestinataires.clear();
      Object var3 = new ArrayList();
      PatientContactDao var4 = new PatientContactDao(this.baseLog, this.utilInitHibernate);
      if (var1 != null) {
         var3 = var4.chargerLesContactsEmail(var1.getPatId(), var2);
      }

      for(int var5 = 0; var5 < ((List)var3).size(); ++var5) {
         new PatientContact();
         PatientContact var6 = (PatientContact)((List)var3).get(var5);
         if (var6.getPatconMail() != null && var6.getPatconMail().contains("@")) {
            Contacts var7 = new Contacts();
            var7.setMailgeneric(var6.getPatconMail());
            this.lesbalDestinatairesItems.add(new SelectItem(var7.getMailgeneric()));
            this.objetBal = new ObjetBal();
            this.objetBal.setLigneSelect(false);
            this.objetBal.setLignePatronyme(var1.getPatronyme());
            this.objetBal.setLigneMail(var7.getMailgeneric());
            this.lesbalDestinataires.add(this.objetBal);
         }
      }

      this.dataModelLesDestinataires.setWrappedData(this.lesbalDestinataires);
   }

   public void chargerLesBalEmtteursSalaries(String var1, Structure var2, Users var3, Salaries var4) throws HibernateException, NamingException {
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.tiersSelectionne = null;
      this.patientsSelectionne = null;
      Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Mail");
      BalDao var6 = new BalDao(this.baseLog, this.utilInitHibernate);
      ArrayList var7 = new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      List var8 = var6.selectBalLogActif(this.structureLog.getStrid(), var5);
      List var9 = var6.selectBalGrpLogActif(this.usersLog.getUsrCollaboration(), var5);
      List var10 = var6.selectBalUserLogActif(this.usersLog.getUsrid(), var5);
      int var11;
      if (var8.size() != 0) {
         for(var11 = 0; var11 < var8.size(); ++var11) {
            var7.add(var8.get(var11));
         }
      }

      if (var9.size() != 0) {
         for(var11 = 0; var11 < var9.size(); ++var11) {
            var7.add(var9.get(var11));
         }
      }

      if (var10.size() != 0) {
         for(var11 = 0; var11 < var10.size(); ++var11) {
            var7.add(var10.get(var11));
         }
      }

      this.lesbalEmetteursItems = new ArrayList();
      if (var7.size() != 0) {
         for(var11 = 0; var11 < var7.size(); ++var11) {
            new Bal();
            Bal var12 = (Bal)var7.get(var11);
            this.lesbalEmetteursItems.add(new SelectItem(var12.getBaladressemail()));
         }
      }

      if (this.structureLog.getStrsmtChoix() == 1) {
         this.lesbalEmetteursItems.add(new SelectItem("epegase.biz@gmail.com"));
      } else if (this.structureLog.getStrsmtChoix() == 2) {
         this.lesbalEmetteursItems.add(new SelectItem("infos.epegase@yahoo.fr"));
      } else if (this.structureLog.getStrsmtChoix() == 0) {
         this.lesbalEmetteursItems.add(new SelectItem("assistance@e-pegase.biz"));
      } else if (this.structureLog.getStrsmtChoix() == 5) {
         this.lesbalEmetteursItems.add(new SelectItem("infos@e-pegase.info"));
      } else if (this.structureLog.getStrsmtChoix() == 6) {
         this.lesbalEmetteursItems.add(new SelectItem("infos@e-pegase.biz"));
      }

      this.chargerLesContactsSalaries(var4);
      this.utilInitHibernate.closeSession();
   }

   public void chargerLesContactsSalaries(Salaries var1) throws HibernateException, NamingException {
      this.lesbalDestinatairesItems.clear();
      this.lesbalDestinataires.clear();
      if (var1.getSalMail1() != null && !var1.getSalMail1().isEmpty() && var1.getSalMail1().contains("@")) {
         this.lesbalDestinatairesItems.add(new SelectItem(var1.getSalMail1()));
         this.objetBal = new ObjetBal();
         this.objetBal.setLigneSelect(false);
         this.objetBal.setLignePatronyme(var1.getPatronyme());
         this.objetBal.setLigneMail(var1.getSalMail1());
         this.lesbalDestinataires.add(this.objetBal);
      }

      if (var1.getSalYahoo() != null && !var1.getSalYahoo().isEmpty() && var1.getSalYahoo().contains("@")) {
         this.lesbalDestinatairesItems.add(new SelectItem(var1.getSalYahoo()));
         this.objetBal = new ObjetBal();
         this.objetBal.setLigneSelect(false);
         this.objetBal.setLignePatronyme(var1.getPatronyme());
         this.objetBal.setLigneMail(var1.getSalYahoo());
         this.lesbalDestinataires.add(this.objetBal);
      }

      if (var1.getSalAol() != null && !var1.getSalAol().isEmpty() && var1.getSalAol().contains("@")) {
         this.lesbalDestinatairesItems.add(new SelectItem(var1.getSalAol()));
         this.objetBal = new ObjetBal();
         this.objetBal.setLigneSelect(false);
         this.objetBal.setLignePatronyme(var1.getPatronyme());
         this.objetBal.setLigneMail(var1.getSalAol());
         this.lesbalDestinataires.add(this.objetBal);
      }

      if (var1.getSalMsn() != null && !var1.getSalMsn().isEmpty() && var1.getSalMsn().contains("@")) {
         this.lesbalDestinatairesItems.add(new SelectItem(var1.getSalMsn()));
         this.objetBal = new ObjetBal();
         this.objetBal.setLigneSelect(false);
         this.objetBal.setLignePatronyme(var1.getPatronyme());
         this.objetBal.setLigneMail(var1.getSalMsn());
         this.lesbalDestinataires.add(this.objetBal);
      }

      this.dataModelLesDestinataires.setWrappedData(this.lesbalDestinataires);
   }

   public String getSource() {
      return this.source;
   }

   public void setSource(String var1) {
      this.source = var1;
   }

   public String getEmetteur() {
      return this.emetteur;
   }

   public void setEmetteur(String var1) {
      this.emetteur = var1;
   }

   public String getCheminRapport() {
      return this.cheminRapport;
   }

   public void setCheminRapport(String var1) {
      this.cheminRapport = var1;
   }

   public String getCheminSousrapport() {
      return this.cheminSousrapport;
   }

   public void setCheminSousrapport(String var1) {
      this.cheminSousrapport = var1;
   }

   public String getFiltre() {
      return this.filtre;
   }

   public void setFiltre(String var1) {
      this.filtre = var1;
   }

   public String getRapport() {
      return this.rapport;
   }

   public void setRapport(String var1) {
      this.rapport = var1;
   }

   public String getRecordPath() {
      return this.recordPath;
   }

   public void setRecordPath(String var1) {
      this.recordPath = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public List getLesbalEmetteursItems() {
      return this.lesbalEmetteursItems;
   }

   public void setLesbalEmetteursItems(List var1) {
      this.lesbalEmetteursItems = var1;
   }

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
   }

   public List getLesmodelesImpressions() {
      return this.lesmodelesImpressions;
   }

   public void setLesmodelesImpressions(List var1) {
      this.lesmodelesImpressions = var1;
   }

   public String getCheminListeDoc() {
      return this.cheminListeDoc;
   }

   public void setCheminListeDoc(String var1) {
      this.cheminListeDoc = var1;
   }

   public List getLesbalDestinatairesItems() {
      return this.lesbalDestinatairesItems;
   }

   public void setLesbalDestinatairesItems(List var1) {
      this.lesbalDestinatairesItems = var1;
   }

   public String getMontant_lettre() {
      return this.montant_lettre;
   }

   public void setMontant_lettre(String var1) {
      this.montant_lettre = var1;
   }

   public String getCheminMail() {
      return this.cheminMail;
   }

   public void setCheminMail(String var1) {
      this.cheminMail = var1;
   }

   public String getCheminLogo() {
      return this.cheminLogo;
   }

   public void setCheminLogo(String var1) {
      this.cheminLogo = var1;
   }

   public Contacts getContact() {
      return this.contact;
   }

   public void setContact(Contacts var1) {
      this.contact = var1;
   }

   public Tiers getTiersSelectionne() {
      return this.tiersSelectionne;
   }

   public void setTiersSelectionne(Tiers var1) {
      this.tiersSelectionne = var1;
   }

   public String getTotauxHt() {
      return this.totauxHt;
   }

   public void setTotauxHt(String var1) {
      this.totauxHt = var1;
   }

   public String getTotauxTaxe() {
      return this.totauxTaxe;
   }

   public void setTotauxTaxe(String var1) {
      this.totauxTaxe = var1;
   }

   public String getTotauxTtc() {
      return this.totauxTtc;
   }

   public void setTotauxTtc(String var1) {
      this.totauxTtc = var1;
   }

   public int getNbCar() {
      return this.nbCar;
   }

   public void setNbCar(int var1) {
      this.nbCar = var1;
   }

   public long getExercice() {
      return this.exercice;
   }

   public void setExercice(long var1) {
      this.exercice = var1;
   }

   public Date getDateFin() {
      return this.DateFin;
   }

   public void setDateFin(Date var1) {
      this.DateFin = var1;
   }

   public Date getDateDeb() {
      return this.DateDeb;
   }

   public void setDateDeb(Date var1) {
      this.DateDeb = var1;
   }

   public int getPage_init() {
      return this.page_init;
   }

   public void setPage_init(int var1) {
      this.page_init = var1;
   }

   public int getEtat_init() {
      return this.etat_init;
   }

   public void setEtat_init(int var1) {
      this.etat_init = var1;
   }

   public long getIdResponsable() {
      return this.idResponsable;
   }

   public void setIdResponsable(long var1) {
      this.idResponsable = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public long getId_doc() {
      return this.id_doc;
   }

   public void setId_doc(long var1) {
      this.id_doc = var1;
   }

   public Patients getPatientsSelectionne() {
      return this.patientsSelectionne;
   }

   public void setPatientsSelectionne(Patients var1) {
      this.patientsSelectionne = var1;
   }

   public Patients getPatientsEncours() {
      return this.patientsEncours;
   }

   public void setPatientsEncours(Patients var1) {
      this.patientsEncours = var1;
   }

   public PatientContact getPatientContact() {
      return this.patientContact;
   }

   public void setPatientContact(PatientContact var1) {
      this.patientContact = var1;
   }

   public JRBeanCollectionDataSource getjRBeanCollectionDataSource() {
      return this.jRBeanCollectionDataSource;
   }

   public void setjRBeanCollectionDataSource(JRBeanCollectionDataSource var1) {
      this.jRBeanCollectionDataSource = var1;
   }

   public String getCheminSignature() {
      return this.cheminSignature;
   }

   public void setCheminSignature(String var1) {
      this.cheminSignature = var1;
   }

   public String getAnnexe1() {
      return this.annexe1;
   }

   public void setAnnexe1(String var1) {
      this.annexe1 = var1;
   }

   public String getAnnexe2() {
      return this.annexe2;
   }

   public void setAnnexe2(String var1) {
      this.annexe2 = var1;
   }

   public String getPageGarde() {
      return this.pageGarde;
   }

   public void setPageGarde(String var1) {
      this.pageGarde = var1;
   }

   public String getEntete() {
      return this.entete;
   }

   public void setEntete(String var1) {
      this.entete = var1;
   }

   public String getNomMapping() {
      return this.nomMapping;
   }

   public void setNomMapping(String var1) {
      this.nomMapping = var1;
   }

   public String getCompte() {
      return this.compte;
   }

   public void setCompte(String var1) {
      this.compte = var1;
   }

   public String getJournal() {
      return this.journal;
   }

   public void setJournal(String var1) {
      this.journal = var1;
   }

   public String getDateDebUk() {
      return this.DateDebUk;
   }

   public void setDateDebUk(String var1) {
      this.DateDebUk = var1;
   }

   public String getDateFinUk() {
      return this.DateFinUk;
   }

   public void setDateFinUk(String var1) {
      this.DateFinUk = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public String getVar_nom_col1() {
      return this.var_nom_col1;
   }

   public void setVar_nom_col1(String var1) {
      this.var_nom_col1 = var1;
   }

   public String getVar_nom_col10() {
      return this.var_nom_col10;
   }

   public void setVar_nom_col10(String var1) {
      this.var_nom_col10 = var1;
   }

   public String getVar_nom_col11() {
      return this.var_nom_col11;
   }

   public void setVar_nom_col11(String var1) {
      this.var_nom_col11 = var1;
   }

   public String getVar_nom_col12() {
      return this.var_nom_col12;
   }

   public void setVar_nom_col12(String var1) {
      this.var_nom_col12 = var1;
   }

   public String getVar_nom_col13() {
      return this.var_nom_col13;
   }

   public void setVar_nom_col13(String var1) {
      this.var_nom_col13 = var1;
   }

   public String getVar_nom_col14() {
      return this.var_nom_col14;
   }

   public void setVar_nom_col14(String var1) {
      this.var_nom_col14 = var1;
   }

   public String getVar_nom_col15() {
      return this.var_nom_col15;
   }

   public void setVar_nom_col15(String var1) {
      this.var_nom_col15 = var1;
   }

   public String getVar_nom_col16() {
      return this.var_nom_col16;
   }

   public void setVar_nom_col16(String var1) {
      this.var_nom_col16 = var1;
   }

   public String getVar_nom_col17() {
      return this.var_nom_col17;
   }

   public void setVar_nom_col17(String var1) {
      this.var_nom_col17 = var1;
   }

   public String getVar_nom_col18() {
      return this.var_nom_col18;
   }

   public void setVar_nom_col18(String var1) {
      this.var_nom_col18 = var1;
   }

   public String getVar_nom_col19() {
      return this.var_nom_col19;
   }

   public void setVar_nom_col19(String var1) {
      this.var_nom_col19 = var1;
   }

   public String getVar_nom_col2() {
      return this.var_nom_col2;
   }

   public void setVar_nom_col2(String var1) {
      this.var_nom_col2 = var1;
   }

   public String getVar_nom_col20() {
      return this.var_nom_col20;
   }

   public void setVar_nom_col20(String var1) {
      this.var_nom_col20 = var1;
   }

   public String getVar_nom_col3() {
      return this.var_nom_col3;
   }

   public void setVar_nom_col3(String var1) {
      this.var_nom_col3 = var1;
   }

   public String getVar_nom_col4() {
      return this.var_nom_col4;
   }

   public void setVar_nom_col4(String var1) {
      this.var_nom_col4 = var1;
   }

   public String getVar_nom_col5() {
      return this.var_nom_col5;
   }

   public void setVar_nom_col5(String var1) {
      this.var_nom_col5 = var1;
   }

   public String getVar_nom_col6() {
      return this.var_nom_col6;
   }

   public void setVar_nom_col6(String var1) {
      this.var_nom_col6 = var1;
   }

   public String getVar_nom_col7() {
      return this.var_nom_col7;
   }

   public void setVar_nom_col7(String var1) {
      this.var_nom_col7 = var1;
   }

   public String getVar_nom_col8() {
      return this.var_nom_col8;
   }

   public void setVar_nom_col8(String var1) {
      this.var_nom_col8 = var1;
   }

   public String getVar_nom_col9() {
      return this.var_nom_col9;
   }

   public void setVar_nom_col9(String var1) {
      this.var_nom_col9 = var1;
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

   public double getValeur1() {
      return this.valeur1;
   }

   public void setValeur1(double var1) {
      this.valeur1 = var1;
   }

   public double getValeur2() {
      return this.valeur2;
   }

   public void setValeur2(double var1) {
      this.valeur2 = var1;
   }

   public String getM0DteDeb() {
      return this.m0DteDeb;
   }

   public void setM0DteDeb(String var1) {
      this.m0DteDeb = var1;
   }

   public String getM0DteFin() {
      return this.m0DteFin;
   }

   public void setM0DteFin(String var1) {
      this.m0DteFin = var1;
   }

   public String getM120DteDeb() {
      return this.m120DteDeb;
   }

   public void setM120DteDeb(String var1) {
      this.m120DteDeb = var1;
   }

   public String getM30DteDeb() {
      return this.m30DteDeb;
   }

   public void setM30DteDeb(String var1) {
      this.m30DteDeb = var1;
   }

   public String getM30DteFin() {
      return this.m30DteFin;
   }

   public void setM30DteFin(String var1) {
      this.m30DteFin = var1;
   }

   public String getM60DteDeb() {
      return this.m60DteDeb;
   }

   public void setM60DteDeb(String var1) {
      this.m60DteDeb = var1;
   }

   public String getM60DteFin() {
      return this.m60DteFin;
   }

   public void setM60DteFin(String var1) {
      this.m60DteFin = var1;
   }

   public String getM90DteDeb() {
      return this.m90DteDeb;
   }

   public void setM90DteDeb(String var1) {
      this.m90DteDeb = var1;
   }

   public String getM90DteFin() {
      return this.m90DteFin;
   }

   public void setM90DteFin(String var1) {
      this.m90DteFin = var1;
   }

   public String getDuplicata() {
      return this.duplicata;
   }

   public void setDuplicata(String var1) {
      this.duplicata = var1;
   }

   public String getImageFondPage() {
      return this.imageFondPage;
   }

   public void setImageFondPage(String var1) {
      this.imageFondPage = var1;
   }

   public String getNbDecPu() {
      return this.nbDecPu;
   }

   public void setNbDecPu(String var1) {
      this.nbDecPu = var1;
   }

   public String getNbDecQte() {
      return this.nbDecQte;
   }

   public void setNbDecQte(String var1) {
      this.nbDecQte = var1;
   }

   public String getDestinataireCC() {
      return this.destinataireCC;
   }

   public void setDestinataireCC(String var1) {
      this.destinataireCC = var1;
   }

   public String getDestinataireCCI() {
      return this.destinataireCCI;
   }

   public void setDestinataireCCI(String var1) {
      this.destinataireCCI = var1;
   }

   public long getIdCommercial() {
      return this.idCommercial;
   }

   public void setIdCommercial(long var1) {
      this.idCommercial = var1;
   }

   public long getIdEquipe() {
      return this.idEquipe;
   }

   public void setIdEquipe(long var1) {
      this.idEquipe = var1;
   }

   public String getInfoOrigineDoc() {
      return this.infoOrigineDoc;
   }

   public void setInfoOrigineDoc(String var1) {
      this.infoOrigineDoc = var1;
   }

   public List getMesImprimantesServeurItems() {
      return this.mesImprimantesServeurItems;
   }

   public void setMesImprimantesServeurItems(List var1) {
      this.mesImprimantesServeurItems = var1;
   }

   public String getMonImprimante() {
      return this.monImprimante;
   }

   public void setMonImprimante(String var1) {
      this.monImprimante = var1;
   }

   public boolean isImprimanteReseau() {
      return this.imprimanteReseau;
   }

   public void setImprimanteReseau(boolean var1) {
      this.imprimanteReseau = var1;
   }

   public String getMatricule() {
      return this.matricule;
   }

   public void setMatricule(String var1) {
      this.matricule = var1;
   }

   public String getNumDoc() {
      return this.numDoc;
   }

   public void setNumDoc(String var1) {
      this.numDoc = var1;
   }

   public String getRapportEncapsule() {
      return this.rapportEncapsule;
   }

   public void setRapportEncapsule(String var1) {
      this.rapportEncapsule = var1;
   }

   public float getTaux() {
      return this.taux;
   }

   public void setTaux(float var1) {
      this.taux = var1;
   }

   public String getMontant_lettre_local() {
      return this.montant_lettre_local;
   }

   public void setMontant_lettre_local(String var1) {
      this.montant_lettre_local = var1;
   }

   public String getTypeEcriture() {
      return this.typeEcriture;
   }

   public void setTypeEcriture(String var1) {
      this.typeEcriture = var1;
   }

   public String getCheminScan() {
      return this.cheminScan;
   }

   public void setCheminScan(String var1) {
      this.cheminScan = var1;
   }

   public float getTaux2() {
      return this.taux2;
   }

   public void setTaux2(float var1) {
      this.taux2 = var1;
   }

   public float getTaux3() {
      return this.taux3;
   }

   public void setTaux3(float var1) {
      this.taux3 = var1;
   }

   public double getPlafond() {
      return this.plafond;
   }

   public void setPlafond(double var1) {
      this.plafond = var1;
   }

   public boolean isCertification() {
      return this.certification;
   }

   public void setCertification(boolean var1) {
      this.certification = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getCentralisation() {
      return this.centralisation;
   }

   public void setCentralisation(String var1) {
      this.centralisation = var1;
   }

   public String getCentreImpot() {
      return this.centreImpot;
   }

   public void setCentreImpot(String var1) {
      this.centreImpot = var1;
   }

   public String getTri() {
      return this.tri;
   }

   public void setTri(String var1) {
      this.tri = var1;
   }

   public double getValeur3() {
      return this.valeur3;
   }

   public void setValeur3(double var1) {
      this.valeur3 = var1;
   }

   public BulletinSalaire getBulletinSelectionne() {
      return this.bulletinSelectionne;
   }

   public void setBulletinSelectionne(BulletinSalaire var1) {
      this.bulletinSelectionne = var1;
   }

   public boolean isPoidsAff() {
      return this.poidsAff;
   }

   public void setPoidsAff(boolean var1) {
      this.poidsAff = var1;
   }

   public int getPoidsImp() {
      return this.poidsImp;
   }

   public void setPoidsImp(int var1) {
      this.poidsImp = var1;
   }

   public String getAdresseLivraison() {
      return this.adresseLivraison;
   }

   public void setAdresseLivraison(String var1) {
      this.adresseLivraison = var1;
   }

   public String getAdresseFacturation() {
      return this.adresseFacturation;
   }

   public void setAdresseFacturation(String var1) {
      this.adresseFacturation = var1;
   }

   public DataModel getDataModelLesDestinataires() {
      return this.dataModelLesDestinataires;
   }

   public void setDataModelLesDestinataires(DataModel var1) {
      this.dataModelLesDestinataires = var1;
   }

   public String getCorpsMail() {
      return this.corpsMail;
   }

   public void setCorpsMail(String var1) {
      this.corpsMail = var1;
   }

   public String getDestinataire() {
      return this.destinataire;
   }

   public void setDestinataire(String var1) {
      this.destinataire = var1;
   }
}
