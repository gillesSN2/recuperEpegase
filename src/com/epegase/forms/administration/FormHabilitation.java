package com.epegase.forms.administration;

import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormHabilitation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private String var_libelle;
   private List habilitationList = new ArrayList();
   private transient DataModel datamodelHabilitation = new ListDataModel();
   private HabilitationDao habilitationDao;
   private UserDao userDao;
   private List lesUsers = new ArrayList();
   private List mesUsersItems1 = new ArrayList();
   private List mesUsersItems2 = new ArrayList();
   private List mesUsersItems3 = new ArrayList();
   private List mesUsersItems4 = new ArrayList();
   private List mesUsersItems5 = new ArrayList();
   private List mesUsersItems6 = new ArrayList();
   private Habilitation habilitation;
   private List lesNaturesHabilitations = new ArrayList();
   private boolean showModalPanel;
   private boolean testDoubleHabilitation = false;
   private boolean visibiliteBton = false;
   private boolean inactifUser1 = false;
   private boolean inactifUser2 = false;
   private boolean inactifUser3 = false;
   private boolean inactifUser4 = false;
   private boolean inactifUser5 = false;
   private boolean inactifUser6 = false;
   private boolean uniciteUser = false;
   private boolean uniciteUser1 = false;
   private boolean uniciteUser2 = false;
   private boolean uniciteUser3 = false;
   private boolean uniciteUser4 = false;
   private boolean uniciteUser5 = false;
   private boolean uniciteUser6 = false;
   private boolean monoSignatureUser1 = true;
   private boolean monoSignatureUser2 = true;
   private boolean monoSignatureUser3 = true;
   private boolean monoSignatureUser4 = true;
   private boolean monoSignatureUser5 = true;
   private boolean monoSignatureUser6 = true;
   private boolean RegilmonoSignature1 = false;
   private boolean RegilmonoSignature2 = false;
   private boolean RegilmonoSignature3 = false;
   private boolean RegilmonoSignature4 = false;
   private boolean RegilmonoSignature5 = false;
   private boolean RegilmonoSignature6 = false;

   public void InstancesDaoUtilses() {
      this.habilitationDao = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
   }

   public void lesHabilitationsAchats(Session var1) throws HibernateException, NamingException {
      this.var_libelle = "ACHAT";
      this.habilitationList.clear();
      this.habilitationList = this.habilitationDao.selectListAchat(var1);
      this.datamodelHabilitation.setWrappedData(this.habilitationList);
      this.lesNaturesHabilitations.add(new SelectItem(10, "Demande Achat"));
      this.lesNaturesHabilitations.add(new SelectItem(11, "Cotation"));
      this.lesNaturesHabilitations.add(new SelectItem(12, "Commande fournisseur"));
      this.lesNaturesHabilitations.add(new SelectItem(13, "Réception fournisseur"));
      this.lesNaturesHabilitations.add(new SelectItem(14, "Retour fournisseur"));
      this.lesNaturesHabilitations.add(new SelectItem(15, "Facture fournisseur"));
      this.lesNaturesHabilitations.add(new SelectItem(16, "Avoir fournisseur"));
      this.lesNaturesHabilitations.add(new SelectItem(17, "Note de débit fournisseur"));
      this.lesNaturesHabilitations.add(new SelectItem(18, "Facture de frais"));
      this.lesNaturesHabilitations.add(new SelectItem(19, "Bon décaissement"));
      this.lesNaturesHabilitations.add(new SelectItem(30, "Inventaire"));
      this.lesNaturesHabilitations.add(new SelectItem(31, "Bon entrée"));
      this.lesNaturesHabilitations.add(new SelectItem(32, "Bon sortie"));
      this.lesNaturesHabilitations.add(new SelectItem(33, "Cession"));
      this.lesNaturesHabilitations.add(new SelectItem(34, "Production"));
      this.lesUsers = this.userDao.chargerLesSignataires("Achats", var1);
      this.recupererMesUsers1Items();
   }

   public void lesHabilitationsVentes(Session var1) throws HibernateException, NamingException {
      this.var_libelle = "VENTE";
      this.habilitationList.clear();
      this.habilitationList = this.habilitationDao.selectListVente(var1);
      this.datamodelHabilitation.setWrappedData(this.habilitationList);
      this.lesNaturesHabilitations.add(new SelectItem(8, "Simulation de contrat"));
      this.lesNaturesHabilitations.add(new SelectItem(20, "Besoin"));
      this.lesNaturesHabilitations.add(new SelectItem(21, "Devis"));
      this.lesNaturesHabilitations.add(new SelectItem(22, "Commande"));
      this.lesNaturesHabilitations.add(new SelectItem(23, "Livraison"));
      this.lesNaturesHabilitations.add(new SelectItem(24, "Bon de retour"));
      this.lesNaturesHabilitations.add(new SelectItem(25, "Facture"));
      this.lesNaturesHabilitations.add(new SelectItem(26, "Avoir"));
      this.lesNaturesHabilitations.add(new SelectItem(27, "Note débit"));
      this.lesNaturesHabilitations.add(new SelectItem(140, "Contrat vente"));
      this.lesNaturesHabilitations.add(new SelectItem(142, "Facture interne"));
      this.lesNaturesHabilitations.add(new SelectItem(29, "Bon encaissement"));
      this.lesUsers = this.userDao.chargerLesSignataires("Ventes", var1);
      this.recupererMesUsers1Items();
   }

   public void lesHabilitationsCaisse(Session var1) throws HibernateException, NamingException {
      this.var_libelle = "CAISSE";
      this.habilitationList.clear();
      this.habilitationList = this.habilitationDao.selectListCaiss(var1);
      this.datamodelHabilitation.setWrappedData(this.habilitationList);
      this.lesNaturesHabilitations.add(new SelectItem(62, "Bon de sortie caisse"));
      this.lesNaturesHabilitations.add(new SelectItem(63, "Bon d`entrée caisse"));
      this.lesNaturesHabilitations.add(new SelectItem(64, "Virement interne"));
      this.lesUsers = this.userDao.chargerLesSignataires("Caisse", var1);
      this.recupererMesUsers1Items();
   }

   public void lesHabilitationsPaye(Session var1) throws HibernateException, NamingException {
      this.var_libelle = "PAYE";
      this.habilitationList.clear();
      this.habilitationList = this.habilitationDao.selectListPaye(var1);
      this.datamodelHabilitation.setWrappedData(this.habilitationList);
      this.lesNaturesHabilitations.add(new SelectItem(82, "Contrat"));
      this.lesNaturesHabilitations.add(new SelectItem(83, "Attestation"));
      this.lesNaturesHabilitations.add(new SelectItem(85, "Certificat"));
      this.lesNaturesHabilitations.add(new SelectItem(86, "Correspondance"));
      this.lesNaturesHabilitations.add(new SelectItem(87, "Prêts (internes/externes/manuels)"));
      this.lesNaturesHabilitations.add(new SelectItem(88, "Congés"));
      this.lesNaturesHabilitations.add(new SelectItem(89, "Absences"));
      this.lesUsers = this.userDao.chargerLesSignataires("Paye", var1);
      this.recupererMesUsers1Items();
   }

   public void lesHabilitationsComptabilite(Session var1) throws HibernateException, NamingException {
      this.var_libelle = "COMPTABILITE";
      this.habilitationList.clear();
      this.habilitationList = this.habilitationDao.selectListVente(var1);
      this.datamodelHabilitation.setWrappedData(this.habilitationList);
      this.lesUsers = this.userDao.chargerLesSignataires("Compta", var1);
      this.recupererMesUsers1Items();
   }

   public void lesHabilitationsMedical(Session var1) throws HibernateException, NamingException {
      this.var_libelle = "MEDICAL";
      this.habilitationList.clear();
      this.habilitationList = this.habilitationDao.selectListMedical(var1);
      this.datamodelHabilitation.setWrappedData(this.habilitationList);
      this.lesUsers = this.userDao.chargerLesSignataires("Medical", var1);
      this.recupererMesUsers1Items();
   }

   public void lesHabilitationsImmobilier(Session var1) throws HibernateException, NamingException {
      this.var_libelle = "IMMOBILIER";
      this.habilitationList.clear();
      this.habilitationList = this.habilitationDao.selectListVente(var1);
      this.datamodelHabilitation.setWrappedData(this.habilitationList);
      this.lesUsers = this.userDao.chargerLesSignataires("Ventes", var1);
      this.recupererMesUsers1Items();
   }

   public void recupererMesUsers1Items() throws HibernateException, NamingException {
      this.mesUsersItems1.clear();
      String var1 = "";
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < this.getLesUsers().size(); ++var4) {
         long var5 = ((Users)this.getLesUsers().get(var4)).getUsrid();
         if (this.habilitation == null || this.habilitation != null && this.habilitation.getHabUser2Id() != var5 && this.habilitation.getHabUser3Id() != var5 && this.habilitation.getHabUser4Id() != var5 && this.habilitation.getHabUser5Id() != var5 && this.habilitation.getHabUser6Id() != var5) {
            String var7 = ((Users)this.getLesUsers().get(var4)).getUsrNom();
            String var8 = ((Users)this.getLesUsers().get(var4)).getUsrPrenom();
            String var9 = ((Users)this.getLesUsers().get(var4)).getUsrCivilite();
            if (var7 != null && !var7.isEmpty()) {
               var1 = var7;
            } else {
               var1 = "";
            }

            if (var8 != null && !var8.isEmpty()) {
               var2 = var8;
            } else {
               var2 = "";
            }

            if (var9 != null && !var9.isEmpty()) {
               var3 = "(" + var9 + ")";
            } else {
               var3 = "";
            }

            this.mesUsersItems1.add(new SelectItem(var5, var1 + " " + var2 + " " + var3));
         }
      }

   }

   public void recupererMesUsers2Items() throws HibernateException, NamingException {
      this.mesUsersItems2.clear();
      String var1 = "";
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < this.getLesUsers().size(); ++var4) {
         long var5 = ((Users)this.getLesUsers().get(var4)).getUsrid();
         if (this.habilitation == null || this.habilitation != null && this.habilitation.getHabUser1Id() != var5 && this.habilitation.getHabUser3Id() != var5 && this.habilitation.getHabUser4Id() != var5 && this.habilitation.getHabUser5Id() != var5 && this.habilitation.getHabUser6Id() != var5) {
            String var7 = ((Users)this.getLesUsers().get(var4)).getUsrNom();
            String var8 = ((Users)this.getLesUsers().get(var4)).getUsrPrenom();
            String var9 = ((Users)this.getLesUsers().get(var4)).getUsrCivilite();
            if (var7 != null && !var7.isEmpty()) {
               var1 = var7;
            } else {
               var1 = "";
            }

            if (var8 != null && !var8.isEmpty()) {
               var2 = var8;
            } else {
               var2 = "";
            }

            if (var9 != null && !var9.isEmpty()) {
               var3 = "(" + var9 + ")";
            } else {
               var3 = "";
            }

            this.mesUsersItems2.add(new SelectItem(var5, var1 + " " + var2 + " " + var3));
         }
      }

   }

   public void recupererMesUsers3Items() throws HibernateException, NamingException {
      this.mesUsersItems3.clear();
      String var1 = "";
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < this.getLesUsers().size(); ++var4) {
         long var5 = ((Users)this.getLesUsers().get(var4)).getUsrid();
         if (this.habilitation == null || this.habilitation != null && this.habilitation.getHabUser1Id() != var5 && this.habilitation.getHabUser2Id() != var5 && this.habilitation.getHabUser4Id() != var5 && this.habilitation.getHabUser5Id() != var5 && this.habilitation.getHabUser6Id() != var5) {
            String var7 = ((Users)this.getLesUsers().get(var4)).getUsrNom();
            String var8 = ((Users)this.getLesUsers().get(var4)).getUsrPrenom();
            String var9 = ((Users)this.getLesUsers().get(var4)).getUsrCivilite();
            if (var7 != null && !var7.isEmpty()) {
               var1 = var7;
            } else {
               var1 = "";
            }

            if (var8 != null && !var8.isEmpty()) {
               var2 = var8;
            } else {
               var2 = "";
            }

            if (var9 != null && !var9.isEmpty()) {
               var3 = "(" + var9 + ")";
            } else {
               var3 = "";
            }

            this.mesUsersItems3.add(new SelectItem(var5, var1 + " " + var2 + " " + var3));
         }
      }

   }

   public void recupererMesUsers4Items() throws HibernateException, NamingException {
      this.mesUsersItems4.clear();
      String var1 = "";
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < this.getLesUsers().size(); ++var4) {
         long var5 = ((Users)this.getLesUsers().get(var4)).getUsrid();
         if (this.habilitation == null || this.habilitation != null && this.habilitation.getHabUser1Id() != var5 && this.habilitation.getHabUser2Id() != var5 && this.habilitation.getHabUser3Id() != var5 && this.habilitation.getHabUser5Id() != var5 && this.habilitation.getHabUser6Id() != var5) {
            String var7 = ((Users)this.getLesUsers().get(var4)).getUsrNom();
            String var8 = ((Users)this.getLesUsers().get(var4)).getUsrPrenom();
            String var9 = ((Users)this.getLesUsers().get(var4)).getUsrCivilite();
            if (var7 != null && !var7.isEmpty()) {
               var1 = var7;
            } else {
               var1 = "";
            }

            if (var8 != null && !var8.isEmpty()) {
               var2 = var8;
            } else {
               var2 = "";
            }

            if (var9 != null && !var9.isEmpty()) {
               var3 = "(" + var9 + ")";
            } else {
               var3 = "";
            }

            this.mesUsersItems4.add(new SelectItem(var5, var1 + " " + var2 + " " + var3));
         }
      }

   }

   public void recupererMesUsers5Items() throws HibernateException, NamingException {
      this.mesUsersItems5.clear();
      String var1 = "";
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < this.getLesUsers().size(); ++var4) {
         long var5 = ((Users)this.getLesUsers().get(var4)).getUsrid();
         if (this.habilitation == null || this.habilitation != null && this.habilitation.getHabUser1Id() != var5 && this.habilitation.getHabUser2Id() != var5 && this.habilitation.getHabUser3Id() != var5 && this.habilitation.getHabUser4Id() != var5 && this.habilitation.getHabUser6Id() != var5) {
            String var7 = ((Users)this.getLesUsers().get(var4)).getUsrNom();
            String var8 = ((Users)this.getLesUsers().get(var4)).getUsrPrenom();
            String var9 = ((Users)this.getLesUsers().get(var4)).getUsrCivilite();
            if (var7 != null && !var7.isEmpty()) {
               var1 = var7;
            } else {
               var1 = "";
            }

            if (var8 != null && !var8.isEmpty()) {
               var2 = var8;
            } else {
               var2 = "";
            }

            if (var9 != null && !var9.isEmpty()) {
               var3 = "(" + var9 + ")";
            } else {
               var3 = "";
            }

            this.mesUsersItems5.add(new SelectItem(var5, var1 + " " + var2 + " " + var3));
         }
      }

   }

   public void recupererMesUsers6Items() throws HibernateException, NamingException {
      this.mesUsersItems6.clear();
      String var1 = "";
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < this.getLesUsers().size(); ++var4) {
         long var5 = ((Users)this.getLesUsers().get(var4)).getUsrid();
         if (this.habilitation == null || this.habilitation != null && this.habilitation.getHabUser1Id() != var5 && this.habilitation.getHabUser2Id() != var5 && this.habilitation.getHabUser3Id() != var5 && this.habilitation.getHabUser4Id() != var5 && this.habilitation.getHabUser5Id() != var5) {
            String var7 = ((Users)this.getLesUsers().get(var4)).getUsrNom();
            String var8 = ((Users)this.getLesUsers().get(var4)).getUsrPrenom();
            String var9 = ((Users)this.getLesUsers().get(var4)).getUsrCivilite();
            if (var7 != null && !var7.isEmpty()) {
               var1 = var7;
            } else {
               var1 = "";
            }

            if (var8 != null && !var8.isEmpty()) {
               var2 = var8;
            } else {
               var2 = "";
            }

            if (var9 != null && !var9.isEmpty()) {
               var3 = "(" + var9 + ")";
            } else {
               var3 = "";
            }

            this.mesUsersItems6.add(new SelectItem(var5, var1 + " " + var2 + " " + var3));
         }
      }

   }

   public void panalAjt() throws HibernateException, NamingException {
      this.uniciteUser1 = false;
      this.uniciteUser2 = false;
      this.uniciteUser3 = false;
      this.uniciteUser4 = false;
      this.uniciteUser5 = false;
      this.uniciteUser6 = false;
      this.monoSignatureUser1 = true;
      this.monoSignatureUser2 = true;
      this.monoSignatureUser3 = true;
      this.monoSignatureUser4 = true;
      this.monoSignatureUser5 = true;
      this.monoSignatureUser6 = true;
      this.RegilmonoSignature1 = false;
      this.RegilmonoSignature2 = false;
      this.RegilmonoSignature3 = false;
      this.RegilmonoSignature4 = false;
      this.RegilmonoSignature5 = false;
      this.RegilmonoSignature6 = false;
      this.habilitation = new Habilitation();
      this.habilitation.setHabNature(0);
      this.habilitation.setHabMode(0);
      this.habilitation.setHabNature(1);
      this.showModalPanel = true;
   }

   public void panalModif() throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.uniciteUser1 = false;
         this.uniciteUser2 = false;
         this.uniciteUser3 = false;
         this.uniciteUser4 = false;
         this.uniciteUser5 = false;
         this.uniciteUser6 = false;
         this.testDoubleHabilitation = true;
         this.activationU1();
         this.activationU2();
         this.activationU3();
         this.activationU4();
         this.activationU5();
         this.activationU6();
         this.monoSignature();
         this.showModalPanel = true;
      }

   }

   public void selectionHabilitation() {
      this.habilitation = new Habilitation();
      if (this.datamodelHabilitation.isRowAvailable()) {
         this.habilitation = (Habilitation)this.datamodelHabilitation.getRowData();
         this.visibiliteBton = true;
      }

   }

   public void annule() {
      this.showModalPanel = false;
      this.visibiliteBton = false;
      this.testDoubleHabilitation = false;
   }

   public void supprimerHabilittation() throws HibernateException, NamingException {
      if (this.habilitation != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.habilitationDao.delete(this.habilitation, var1);
            this.habilitationList.remove(this.habilitation);
            this.datamodelHabilitation.setWrappedData(this.habilitationList);
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

      this.visibiliteBton = false;
      this.testDoubleHabilitation = false;
   }

   public void saveHabilatition() throws HibernateException, NamingException {
      if (this.habilitation.getHabUser1Id() != 0L || this.habilitation.getHabUser2Id() != 0L || this.habilitation.getHabUser3Id() != 0L || this.habilitation.getHabUser4Id() != 0L || this.habilitation.getHabUser5Id() != 0L || this.habilitation.getHabUser6Id() != 0L) {
         this.habilitation.setHabNature(this.habilitation.getHabNature());
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Habilitation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.habilitation.getHabMode() == 0) {
               this.habilitation.setHabNombre(1);
            }

            if (this.habilitation.getHabId() == 0L) {
               this.habilitation = this.habilitationDao.insert(this.habilitation, var1);
               this.habilitationList.add(this.habilitation);
               this.datamodelHabilitation.setWrappedData(this.habilitationList);
            } else {
               this.habilitation = this.habilitationDao.modifier(this.habilitation, var1);
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
      }

      this.showModalPanel = false;
   }

   public void doublon() throws HibernateException, NamingException {
      if (this.habilitation.getHabNature() != 0) {
         String var1 = "";
         var1 = "habNature='" + this.habilitation.getHabNature() + "'";
         Habilitation var2 = this.habilitationDao.selectUnique(var1, (Session)null);
         if (var2 != null) {
            this.setTestDoubleHabilitation(false);
         } else {
            this.setTestDoubleHabilitation(true);
         }
      } else {
         this.setTestDoubleHabilitation(false);
      }

   }

   public void decoupageUsers1() throws HibernateException, NamingException {
      this.setUniciteUser1(false);
      if (this.habilitation.getHabUser1Id() != 0L) {
         long var1 = this.habilitation.getHabUser1Id();
         long var3 = this.habilitation.getHabUser2Id();
         long var5 = this.habilitation.getHabUser3Id();
         long var7 = this.habilitation.getHabUser4Id();
         long var9 = this.habilitation.getHabUser5Id();
         long var11 = this.habilitation.getHabUser6Id();
         if (var1 != 0L) {
            this.uniciteUtulisateur(var1, var3, var5, var7, var9, var11);
            if (!this.uniciteUser) {
               this.setUniciteUser1(false);
               long var13 = 0L;
               String var15 = "";
               var15 = "usrid='" + var1 + "'";
               Users var16 = this.userDao.selectLeUser(var15, (Session)null);
               this.habilitation.setHabUser1Id(var16.getUsrid());
               this.habilitation.setHabUser1Nom(var16.getUsrNom());
            } else {
               this.setUniciteUser1(true);
            }
         }
      }

   }

   public void decoupageUsers2() throws HibernateException, NamingException {
      this.setUniciteUser2(false);
      if (this.habilitation.getHabUser2Id() != 0L) {
         long var1 = this.habilitation.getHabUser2Id();
         long var3 = this.habilitation.getHabUser1Id();
         long var5 = this.habilitation.getHabUser3Id();
         long var7 = this.habilitation.getHabUser4Id();
         long var9 = this.habilitation.getHabUser5Id();
         long var11 = this.habilitation.getHabUser6Id();
         if (var1 != 0L) {
            this.uniciteUtulisateur(var1, var3, var5, var7, var9, var11);
            if (!this.uniciteUser) {
               long var13 = 0L;
               String var15 = "";
               var15 = "usrid='" + var1 + "'";
               Users var16 = this.userDao.selectLeUser(var15, (Session)null);
               this.habilitation.setHabUser2Id(var16.getUsrid());
               this.habilitation.setHabUser2Nom(var16.getUsrNom());
            } else {
               this.setUniciteUser2(true);
            }
         }
      }

   }

   public void decoupageUsers3() throws HibernateException, NamingException {
      this.setUniciteUser3(false);
      if (this.habilitation.getHabUser3Id() != 0L) {
         long var1 = this.habilitation.getHabUser3Id();
         long var3 = this.habilitation.getHabUser1Id();
         long var5 = this.habilitation.getHabUser2Id();
         long var7 = this.habilitation.getHabUser4Id();
         long var9 = this.habilitation.getHabUser5Id();
         long var11 = this.habilitation.getHabUser6Id();
         if (var1 != 0L) {
            this.uniciteUtulisateur(var1, var3, var5, var7, var9, var11);
            if (!this.uniciteUser) {
               long var13 = 0L;
               String var15 = "";
               var15 = "usrid='" + var1 + "'";
               Users var16 = this.userDao.selectLeUser(var15, (Session)null);
               this.habilitation.setHabUser3Id(var16.getUsrid());
               this.habilitation.setHabUser3Nom(var16.getUsrNom());
            } else {
               this.setUniciteUser3(true);
            }
         }
      }

   }

   public void decoupageUsers4() throws HibernateException, NamingException {
      this.setUniciteUser4(false);
      if (this.habilitation.getHabUser4Id() != 0L) {
         long var1 = this.habilitation.getHabUser4Id();
         long var3 = this.habilitation.getHabUser1Id();
         long var5 = this.habilitation.getHabUser2Id();
         long var7 = this.habilitation.getHabUser3Id();
         long var9 = this.habilitation.getHabUser5Id();
         long var11 = this.habilitation.getHabUser6Id();
         if (var1 != 0L) {
            this.uniciteUtulisateur(var1, var3, var5, var7, var9, var11);
            if (!this.uniciteUser) {
               long var13 = 0L;
               String var15 = "";
               var15 = "usrid='" + var1 + "'";
               Users var16 = this.userDao.selectLeUser(var15, (Session)null);
               this.habilitation.setHabUser4Id(var16.getUsrid());
               this.habilitation.setHabUser4Nom(var16.getUsrNom());
            } else {
               this.setUniciteUser4(true);
            }
         }
      }

   }

   public void decoupageUsers5() throws HibernateException, NamingException {
      this.setUniciteUser5(false);
      if (this.habilitation.getHabUser5Id() != 0L) {
         long var1 = this.habilitation.getHabUser5Id();
         long var3 = this.habilitation.getHabUser1Id();
         long var5 = this.habilitation.getHabUser2Id();
         long var7 = this.habilitation.getHabUser3Id();
         long var9 = this.habilitation.getHabUser4Id();
         long var11 = this.habilitation.getHabUser6Id();
         if (var1 != 0L) {
            this.uniciteUtulisateur(var1, var5, var7, var9, var3, var11);
            if (!this.uniciteUser) {
               long var13 = 0L;
               String var15 = "";
               var15 = "usrid='" + var1 + "'";
               Users var16 = this.userDao.selectLeUser(var15, (Session)null);
               this.habilitation.setHabUser5Id(var16.getUsrid());
               this.habilitation.setHabUser5Nom(var16.getUsrNom());
            } else {
               this.setUniciteUser5(true);
            }
         }
      }

   }

   public void decoupageUsers6() throws HibernateException, NamingException {
      this.setUniciteUser6(false);
      if (this.habilitation.getHabUser6Id() != 0L) {
         long var1 = this.habilitation.getHabUser6Id();
         long var3 = this.habilitation.getHabUser1Id();
         long var5 = this.habilitation.getHabUser2Id();
         long var7 = this.habilitation.getHabUser3Id();
         long var9 = this.habilitation.getHabUser4Id();
         long var11 = this.habilitation.getHabUser5Id();
         if (var1 != 0L) {
            this.uniciteUtulisateur(var1, var3, var5, var7, var9, var11);
            if (!this.uniciteUser) {
               long var13 = 0L;
               String var15 = "";
               var15 = "usrid='" + var1 + "'";
               Users var16 = this.userDao.selectLeUser(var15, (Session)null);
               this.habilitation.setHabUser6Id(var16.getUsrid());
               this.habilitation.setHabUser6Nom(var16.getUsrNom());
            } else {
               this.setUniciteUser6(true);
            }
         }
      }

   }

   public void decoupageRempla1() throws HibernateException, NamingException {
      long var1 = 0L;
      String var3 = "";
      var1 = this.habilitation.getHabRemplace1Id();
      if (var1 != 0L) {
         var3 = "usrid='" + var1 + "'";
         Users var4 = this.userDao.selectLeUser(var3, (Session)null);
         this.habilitation.setHabRemplace1Id(var4.getUsrid());
         this.habilitation.setHabRemplace1Nom(var4.getUsrNom());
      } else {
         this.habilitation.setHabRemplace1Nom("");
      }

   }

   public void decoupageRempla2() throws HibernateException, NamingException {
      long var1 = 0L;
      String var3 = "";
      var1 = this.habilitation.getHabRemplace2Id();
      if (var1 != 0L) {
         var3 = "usrid='" + var1 + "'";
         Users var4 = this.userDao.selectLeUser(var3, (Session)null);
         this.habilitation.setHabRemplace2Id(var4.getUsrid());
         this.habilitation.setHabRemplace2Nom(var4.getUsrNom());
      } else {
         this.habilitation.setHabRemplace2Nom("");
      }

   }

   public void decoupageRempla3() throws HibernateException, NamingException {
      long var1 = 0L;
      String var3 = "";
      var1 = this.habilitation.getHabRemplace3Id();
      if (var1 != 0L) {
         var3 = "usrid='" + var1 + "'";
         Users var4 = this.userDao.selectLeUser(var3, (Session)null);
         this.habilitation.setHabRemplace3Id(var4.getUsrid());
         this.habilitation.setHabRemplace3Nom(var4.getUsrNom());
      } else {
         this.habilitation.setHabRemplace3Nom("");
      }

   }

   public void decoupageRempla4() throws HibernateException, NamingException {
      long var1 = 0L;
      String var3 = "";
      var1 = this.habilitation.getHabRemplace4Id();
      if (var1 != 0L) {
         var3 = "usrid='" + var1 + "'";
         Users var4 = this.userDao.selectLeUser(var3, (Session)null);
         this.habilitation.setHabRemplace4Id(var4.getUsrid());
         this.habilitation.setHabRemplace4Nom(var4.getUsrNom());
      } else {
         this.habilitation.setHabRemplace4Nom("");
      }

   }

   public void decoupageRempla5() throws HibernateException, NamingException {
      long var1 = 0L;
      String var3 = "";
      var1 = this.habilitation.getHabRemplace5Id();
      if (var1 != 0L) {
         var3 = "usrid='" + var1 + "'";
         Users var4 = this.userDao.selectLeUser(var3, (Session)null);
         this.habilitation.setHabRemplace5Id(var4.getUsrid());
         this.habilitation.setHabRemplace5Nom(var4.getUsrNom());
      } else {
         this.habilitation.setHabRemplace5Nom("");
      }

   }

   public void decoupageRempla6() throws HibernateException, NamingException {
      long var1 = 0L;
      String var3 = "";
      var1 = this.habilitation.getHabRemplace6Id();
      if (var1 != 0L) {
         var3 = "usrid='" + var1 + "'";
         Users var4 = this.userDao.selectLeUser(var3, (Session)null);
         this.habilitation.setHabRemplace6Id(var4.getUsrid());
         this.habilitation.setHabRemplace6Nom(var4.getUsrNom());
      } else {
         this.habilitation.setHabRemplace6Nom("");
      }

   }

   public void activationU1() throws HibernateException, NamingException {
      if (this.habilitation.getHabUser1Cat() == 0) {
         this.habilitation.setHabUser1Id(0L);
         this.habilitation.setHabUser1Nom("");
         this.habilitation.setHabRemplace1Id(0L);
         this.habilitation.setHabRemplace1Nom("");
         this.setInactifUser1(false);
         this.setUniciteUser1(false);
      } else {
         this.setInactifUser1(true);
         this.recupererMesUsers1Items();
      }

   }

   public void activationU2() throws HibernateException, NamingException {
      if (this.habilitation.getHabUser2Cat() == 0) {
         this.habilitation.setHabUser2Id(0L);
         this.habilitation.setHabUser2Nom("");
         this.habilitation.setHabRemplace2Id(0L);
         this.habilitation.setHabRemplace2Nom("");
         this.setInactifUser2(false);
         this.setUniciteUser2(false);
      } else {
         this.setInactifUser2(true);
         this.recupererMesUsers2Items();
      }

   }

   public void activationU3() throws HibernateException, NamingException {
      if (this.habilitation.getHabUser3Cat() == 0) {
         this.habilitation.setHabUser3Id(0L);
         this.habilitation.setHabUser3Nom("");
         this.habilitation.setHabRemplace3Id(0L);
         this.habilitation.setHabRemplace3Nom("");
         this.setInactifUser3(false);
         this.setUniciteUser3(false);
      } else {
         this.setInactifUser3(true);
         this.recupererMesUsers3Items();
      }

   }

   public void activationU4() throws HibernateException, NamingException {
      if (this.habilitation.getHabUser4Cat() == 0) {
         this.habilitation.setHabUser4Id(0L);
         this.habilitation.setHabUser4Nom("");
         this.habilitation.setHabRemplace5Id(0L);
         this.habilitation.setHabRemplace5Nom("");
         this.setInactifUser4(false);
         this.setUniciteUser4(false);
      } else {
         this.setInactifUser4(true);
         this.recupererMesUsers4Items();
      }

   }

   public void activationU5() throws HibernateException, NamingException {
      if (this.habilitation.getHabUser5Cat() == 0) {
         this.habilitation.setHabUser5Id(0L);
         this.habilitation.setHabUser5Nom("");
         this.habilitation.setHabRemplace5Id(0L);
         this.habilitation.setHabRemplace5Nom("");
         this.setInactifUser5(false);
         this.setUniciteUser5(false);
      } else {
         this.setInactifUser5(true);
         this.recupererMesUsers5Items();
      }

   }

   public void activationU6() throws HibernateException, NamingException {
      if (this.habilitation.getHabUser6Cat() == 0) {
         this.habilitation.setHabUser6Id(0L);
         this.habilitation.setHabUser6Nom("");
         this.habilitation.setHabRemplace6Id(0L);
         this.habilitation.setHabRemplace6Nom("");
         this.setInactifUser6(false);
         this.setUniciteUser6(false);
      } else {
         this.setInactifUser6(true);
         this.recupererMesUsers6Items();
      }

   }

   public void uniciteUtulisateur(long var1, long var3, long var5, long var7, long var9, long var11) {
      if (var3 != var1 && var5 != var1 && var7 != var1 && var9 != var1 && var11 != var1) {
         this.setUniciteUser(false);
      } else {
         this.setUniciteUser(true);
      }

   }

   public void monoSignature() throws HibernateException, NamingException {
      if (this.habilitation.getHabMode() == 0) {
         if (this.habilitation.getHabUser1Id() != 0L) {
            this.inactifUser1 = true;
         } else {
            this.inactifUser1 = false;
         }

         if (this.habilitation.getHabRemplace1Id() != 0L) {
            this.monoSignatureUser1 = true;
         } else {
            this.monoSignatureUser1 = false;
         }

         this.inactifUser1 = true;
         this.inactifUser2 = false;
         this.inactifUser3 = false;
         this.inactifUser4 = false;
         this.inactifUser5 = false;
         this.inactifUser6 = false;
         this.habilitation.setHabUser2Id(0L);
         this.habilitation.setHabRemplace2Id(0L);
         this.habilitation.setHabUser3Id(0L);
         this.habilitation.setHabRemplace3Id(0L);
         this.habilitation.setHabUser4Id(0L);
         this.habilitation.setHabRemplace4Id(0L);
         this.habilitation.setHabUser5Id(0L);
         this.habilitation.setHabRemplace5Id(0L);
         this.habilitation.setHabUser6Id(0L);
         this.habilitation.setHabRemplace6Id(0L);
         this.monoSignatureUser1 = true;
         this.monoSignatureUser2 = false;
         this.monoSignatureUser3 = false;
         this.monoSignatureUser4 = false;
         this.monoSignatureUser5 = false;
         this.monoSignatureUser6 = false;
      } else {
         this.multiSignature();
      }

   }

   public void multiSignature() throws HibernateException, NamingException {
      if (this.habilitation.getHabMode() == 1) {
         if (this.habilitation.getHabNombre() == 0) {
            this.habilitation.setHabNombre(2);
         }

         this.habilitation.setHabUser1Id(this.habilitation.getHabUser1Id());
         this.habilitation.setHabRemplace1Id(this.habilitation.getHabRemplace1Id());
         this.habilitation.setHabUser2Id(this.habilitation.getHabUser2Id());
         this.habilitation.setHabRemplace2Id(this.habilitation.getHabRemplace2Id());
         this.habilitation.setHabUser3Id(this.habilitation.getHabUser3Id());
         this.habilitation.setHabRemplace3Id(this.habilitation.getHabRemplace3Id());
         this.habilitation.setHabUser4Id(this.habilitation.getHabUser4Id());
         this.habilitation.setHabRemplace4Id(this.habilitation.getHabRemplace4Id());
         this.habilitation.setHabUser5Id(this.habilitation.getHabUser5Id());
         this.habilitation.setHabRemplace5Id(this.habilitation.getHabRemplace5Id());
         this.habilitation.setHabUser6Id(this.habilitation.getHabUser6Id());
         this.habilitation.setHabRemplace6Id(this.habilitation.getHabRemplace6Id());
         this.monoSignatureUser1 = true;
         this.monoSignatureUser2 = true;
         this.monoSignatureUser3 = true;
         this.monoSignatureUser4 = true;
         this.monoSignatureUser5 = true;
         this.monoSignatureUser6 = true;
      }

   }

   public DataModel getDatamodelHabilitation() {
      return this.datamodelHabilitation;
   }

   public void setDatamodelHabilitation(DataModel var1) {
      this.datamodelHabilitation = var1;
   }

   public List getHabilitationList() {
      return this.habilitationList;
   }

   public void setHabilitationList(List var1) {
      this.habilitationList = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public boolean isShowModalPanel() {
      return this.showModalPanel;
   }

   public void setShowModalPanel(boolean var1) {
      this.showModalPanel = var1;
   }

   public boolean isTestDoubleHabilitation() {
      return this.testDoubleHabilitation;
   }

   public void setTestDoubleHabilitation(boolean var1) {
      this.testDoubleHabilitation = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isInactifUser1() {
      return this.inactifUser1;
   }

   public void setInactifUser1(boolean var1) {
      this.inactifUser1 = var1;
   }

   public boolean isInactifUser2() {
      return this.inactifUser2;
   }

   public void setInactifUser2(boolean var1) {
      this.inactifUser2 = var1;
   }

   public boolean isInactifUser3() {
      return this.inactifUser3;
   }

   public void setInactifUser3(boolean var1) {
      this.inactifUser3 = var1;
   }

   public boolean isInactifUser4() {
      return this.inactifUser4;
   }

   public void setInactifUser4(boolean var1) {
      this.inactifUser4 = var1;
   }

   public boolean isInactifUser5() {
      return this.inactifUser5;
   }

   public void setInactifUser5(boolean var1) {
      this.inactifUser5 = var1;
   }

   public boolean isInactifUser6() {
      return this.inactifUser6;
   }

   public void setInactifUser6(boolean var1) {
      this.inactifUser6 = var1;
   }

   public List getLesUsers() {
      return this.lesUsers;
   }

   public void setLesUsers(List var1) {
      this.lesUsers = var1;
   }

   public List getMesUsersItems1() {
      return this.mesUsersItems1;
   }

   public void setMesUsersItems1(List var1) {
      this.mesUsersItems1 = var1;
   }

   public List getMesUsersItems2() {
      return this.mesUsersItems2;
   }

   public void setMesUsersItems2(List var1) {
      this.mesUsersItems2 = var1;
   }

   public List getMesUsersItems3() {
      return this.mesUsersItems3;
   }

   public void setMesUsersItems3(List var1) {
      this.mesUsersItems3 = var1;
   }

   public List getMesUsersItems4() {
      return this.mesUsersItems4;
   }

   public void setMesUsersItems4(List var1) {
      this.mesUsersItems4 = var1;
   }

   public List getMesUsersItems5() {
      return this.mesUsersItems5;
   }

   public void setMesUsersItems5(List var1) {
      this.mesUsersItems5 = var1;
   }

   public List getMesUsersItems6() {
      return this.mesUsersItems6;
   }

   public void setMesUsersItems6(List var1) {
      this.mesUsersItems6 = var1;
   }

   public boolean isUniciteUser() {
      return this.uniciteUser;
   }

   public void setUniciteUser(boolean var1) {
      this.uniciteUser = var1;
   }

   public boolean isUniciteUser1() {
      return this.uniciteUser1;
   }

   public void setUniciteUser1(boolean var1) {
      this.uniciteUser1 = var1;
   }

   public boolean isUniciteUser2() {
      return this.uniciteUser2;
   }

   public void setUniciteUser2(boolean var1) {
      this.uniciteUser2 = var1;
   }

   public boolean isUniciteUser3() {
      return this.uniciteUser3;
   }

   public void setUniciteUser3(boolean var1) {
      this.uniciteUser3 = var1;
   }

   public boolean isUniciteUser4() {
      return this.uniciteUser4;
   }

   public void setUniciteUser4(boolean var1) {
      this.uniciteUser4 = var1;
   }

   public boolean isUniciteUser5() {
      return this.uniciteUser5;
   }

   public void setUniciteUser5(boolean var1) {
      this.uniciteUser5 = var1;
   }

   public boolean isUniciteUser6() {
      return this.uniciteUser6;
   }

   public void setUniciteUser6(boolean var1) {
      this.uniciteUser6 = var1;
   }

   public boolean isMonoSignatureUser1() {
      return this.monoSignatureUser1;
   }

   public void setMonoSignatureUser1(boolean var1) {
      this.monoSignatureUser1 = var1;
   }

   public boolean isMonoSignatureUser2() {
      return this.monoSignatureUser2;
   }

   public void setMonoSignatureUser2(boolean var1) {
      this.monoSignatureUser2 = var1;
   }

   public boolean isMonoSignatureUser3() {
      return this.monoSignatureUser3;
   }

   public void setMonoSignatureUser3(boolean var1) {
      this.monoSignatureUser3 = var1;
   }

   public boolean isMonoSignatureUser4() {
      return this.monoSignatureUser4;
   }

   public void setMonoSignatureUser4(boolean var1) {
      this.monoSignatureUser4 = var1;
   }

   public boolean isMonoSignatureUser5() {
      return this.monoSignatureUser5;
   }

   public void setMonoSignatureUser5(boolean var1) {
      this.monoSignatureUser5 = var1;
   }

   public boolean isMonoSignatureUser6() {
      return this.monoSignatureUser6;
   }

   public void setMonoSignatureUser6(boolean var1) {
      this.monoSignatureUser6 = var1;
   }

   public boolean isRegilmonoSignature1() {
      return this.RegilmonoSignature1;
   }

   public void setRegilmonoSignature1(boolean var1) {
      this.RegilmonoSignature1 = var1;
   }

   public boolean isRegilmonoSignature2() {
      return this.RegilmonoSignature2;
   }

   public void setRegilmonoSignature2(boolean var1) {
      this.RegilmonoSignature2 = var1;
   }

   public boolean isRegilmonoSignature3() {
      return this.RegilmonoSignature3;
   }

   public void setRegilmonoSignature3(boolean var1) {
      this.RegilmonoSignature3 = var1;
   }

   public boolean isRegilmonoSignature4() {
      return this.RegilmonoSignature4;
   }

   public void setRegilmonoSignature4(boolean var1) {
      this.RegilmonoSignature4 = var1;
   }

   public boolean isRegilmonoSignature5() {
      return this.RegilmonoSignature5;
   }

   public void setRegilmonoSignature5(boolean var1) {
      this.RegilmonoSignature5 = var1;
   }

   public boolean isRegilmonoSignature6() {
      return this.RegilmonoSignature6;
   }

   public void setRegilmonoSignature6(boolean var1) {
      this.RegilmonoSignature6 = var1;
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

   public String getVar_libelle() {
      return this.var_libelle;
   }

   public void setVar_libelle(String var1) {
      this.var_libelle = var1;
   }

   public List getLesNaturesHabilitations() {
      return this.lesNaturesHabilitations;
   }

   public void setLesNaturesHabilitations(List var1) {
      this.lesNaturesHabilitations = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }
}
