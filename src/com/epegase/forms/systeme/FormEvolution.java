package com.epegase.forms.systeme;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.PegEvolution;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.PegEvolutionDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilFtp;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormEvolution implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private int var_nb_max = 100;
   private Date var_date_deb;
   private Date var_date_fin;
   private String var_info;
   private UtilDate utilDate = new UtilDate();
   private String debut;
   private String fin;
   private PegEvolution pegEvolution;
   private List lesEvolutions = new ArrayList();
   private transient DataModel dataModelEvolution = new ListDataModel();
   private PegEvolutionDao pegEvolutionDao;
   private boolean afficheEvolution = false;
   private boolean showModalPanelEvolution = false;
   Element racine;
   Document document;
   private UtilFtp utilFtp = new UtilFtp();
   private String retour;
   private FormRecherche formRecherche;

   public void InstancesDaoUtilses() {
      this.pegEvolutionDao = new PegEvolutionDao(this.utilInitHibernate);
   }

   public void initPegEvolution() throws HibernateException, NamingException, ParseException {
      this.var_date_deb = this.utilDate.datePremierJourAnnee(new Date());
      this.var_date_fin = this.utilDate.dateDernierJourAnnee(new Date());
      this.debut = this.utilDate.dateToStringSQLLight(this.var_date_deb);
      this.fin = this.utilDate.dateToStringSQLLight(this.var_date_fin);
      this.var_info = "";
      this.lesEvolutions.clear();
      this.lesEvolutions = this.pegEvolutionDao.rechecheGlobale();
      this.dataModelEvolution.setWrappedData(this.lesEvolutions);
   }

   public void selectionLigne() throws HibernateException, NamingException {
      if (this.dataModelEvolution.isRowAvailable()) {
         this.pegEvolution = (PegEvolution)this.dataModelEvolution.getRowData();
         this.afficheEvolution = true;
      }

   }

   public void ajouterRubrique() {
      String var1 = "";
      String var2 = "";
      if (this.lesEvolutions.size() != 0) {
         this.pegEvolution = (PegEvolution)this.lesEvolutions.get(0);
         var2 = this.pegEvolution.getPegevoVersion();
         var1 = this.pegEvolution.getPegevoNomDeveloppeur();
      }

      this.pegEvolution = new PegEvolution();
      this.afficheEvolution = false;
      this.pegEvolution.setPegevoDate(new Date());
      this.pegEvolution.setPegevoVersion(var2);
      this.pegEvolution.setPegevoNomDeveloppeur(var1);
      this.showModalPanelEvolution = true;
   }

   public void modifierRubrique() {
      if (this.pegEvolution != null) {
         this.showModalPanelEvolution = true;
      }

   }

   public void supprimerRubrique() throws HibernateException, NamingException {
      if (this.pegEvolution != null) {
         this.pegEvolutionDao.delete((PegEvolution)null);
      }

   }

   public void annulerRubrique() {
      this.afficheEvolution = false;
      this.showModalPanelEvolution = false;
   }

   public void validerRubrique() throws HibernateException, NamingException {
      if (this.pegEvolution.getPegevoId() == 0L) {
         this.pegEvolution = this.pegEvolutionDao.insert(this.pegEvolution);
         this.lesEvolutions.add(this.pegEvolution);
         this.dataModelEvolution.setWrappedData(this.lesEvolutions);
      } else {
         this.pegEvolution = this.pegEvolutionDao.modif(this.pegEvolution);
      }

      this.afficheEvolution = true;
      this.showModalPanelEvolution = false;
   }

   public void exporterEpegase() throws UnknownHostException, SocketException, IOException {
      if (this.lesEvolutions.size() != 0) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "update" + File.separator + "evolutions.xml";
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         this.racine = new Element("evolution");
         this.document = new Document(this.racine);

         for(int var3 = 0; var3 < this.lesEvolutions.size(); ++var3) {
            this.pegEvolution = (PegEvolution)this.lesEvolutions.get(var3);
            Element var4 = new Element("article");
            this.racine.addContent(var4);
            Element var5 = new Element("version");
            Element var6 = new Element("date");
            Element var7 = new Element("type");
            Element var8 = new Element("module");
            Element var9 = new Element("ecran");
            Element var10 = new Element("objet");
            Element var11 = new Element("detail");
            Element var12 = new Element("developpeur");
            var5.setText(this.pegEvolution.getPegevoVersion());
            var6.setText(this.utilDate.dateToStringSQLLight(this.pegEvolution.getPegevoDate()));
            var7.setText(this.pegEvolution.getLibelleType());
            var8.setText(this.pegEvolution.getPegevoModule());
            var9.setText(this.pegEvolution.getPegevoEcran());
            var10.setText(this.pegEvolution.getPegevoObject());
            var11.setText(this.pegEvolution.getPegevoDetail());
            var12.setText(this.pegEvolution.getPegevoNomDeveloppeur());
            var4.addContent(var5);
            var4.addContent(var6);
            var4.addContent(var7);
            var4.addContent(var8);
            var4.addContent(var9);
            var4.addContent(var10);
            var4.addContent(var11);
            var4.addContent(var12);
         }

         this.enregistre(var1);
         this.upload(var1);
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

   public void upload(String var1) throws UnknownHostException, SocketException, IOException {
      this.retour = this.utilFtp.sendFileEvolution(var1, "evolutions.xml");
      this.formRecherche.setMessageTexte("Rapport mise à jour fichier évolution " + this.retour);
      this.formRecherche.setShowModalPanelMessage(true);
   }

   public boolean isAfficheEvolution() {
      return this.afficheEvolution;
   }

   public void setAfficheEvolution(boolean var1) {
      this.afficheEvolution = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public DataModel getDataModelEvolution() {
      return this.dataModelEvolution;
   }

   public void setDataModelEvolution(DataModel var1) {
      this.dataModelEvolution = var1;
   }

   public PegEvolution getPegEvolution() {
      return this.pegEvolution;
   }

   public void setPegEvolution(PegEvolution var1) {
      this.pegEvolution = var1;
   }

   public boolean isShowModalPanelEvolution() {
      return this.showModalPanelEvolution;
   }

   public void setShowModalPanelEvolution(boolean var1) {
      this.showModalPanelEvolution = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public Date getVar_date_deb() {
      return this.var_date_deb;
   }

   public void setVar_date_deb(Date var1) {
      this.var_date_deb = var1;
   }

   public Date getVar_date_fin() {
      return this.var_date_fin;
   }

   public void setVar_date_fin(Date var1) {
      this.var_date_fin = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public String getRetour() {
      return this.retour;
   }

   public void setRetour(String var1) {
      this.retour = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }
}
