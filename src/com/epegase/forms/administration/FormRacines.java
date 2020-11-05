package com.epegase.forms.administration;

import com.epegase.systeme.classe.*;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import javax.naming.NamingException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormRacines implements Serializable {
    private UtilInitHibernate utilInitHibernate;
    private String baseLog;
    private Structure structureLog;
    private Users usersLog;
    private String pageIndex;
    private Element racine;
    private Document document;
    private String fiscalite;
    private String format;
    private List lesfiscalites;
    private int ligne;
    private Racines racines = new Racines();
    private RacinesDao racinesDao;
    private LectureZonesFiscales zoneFiscale;
    private ExercicesComptable selectedExo;
    private int choixRacine;
    private String selecFiscalite;
    private int nombrCaracter;

    public FormRacines() {
        this.racinesDao = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
    }

    public void InstancesDaoUtilses() {
        this.racinesDao = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
    }

    public List chargerMesRacinesCpteXml() throws IOException {
        this.lesfiscalites = new ArrayList();
        LectureNatureCompte var1 = new LectureNatureCompte();
        new ArrayList();
        List var2 = var1.getMesNatureCompte();
        LectureRacines var3 = new LectureRacines(this.selecFiscalite);
        var3.setStructureLog(this.structureLog);
        var3.recupereRacines();
        new ArrayList();
        List var4 = var3.getMesRacines();
        if (var4.size() != 0) {
            for (int var5 = 0; var5 < var4.size(); ++var5) {
                Racines var6 = new Racines();
                var6.setRacCode(((ObjetRacine) var4.get(var5)).getCode());
                var6.setRacLibelleFr(((ObjetRacine) var4.get(var5)).getNom_FR());
                if (var6.getRacCode().length() == 1) {
                    var6.setAff_racine(((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk(((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp(((ObjetRacine) var4.get(var5)).getNom_SP());
                } else if (var6.getRacCode().length() == 2) {
                    var6.setAff_racine("          " + ((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk("          " + ((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp("          " + ((ObjetRacine) var4.get(var5)).getNom_SP());
                } else if (var6.getRacCode().length() == 3) {
                    var6.setAff_racine("                    " + ((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk("                    " + ((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp("                    " + ((ObjetRacine) var4.get(var5)).getNom_SP());
                } else if (var6.getRacCode().length() == 4) {
                    var6.setAff_racine("                              " + ((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk("                              " + ((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp("                              " + ((ObjetRacine) var4.get(var5)).getNom_SP());
                } else if (var6.getRacCode().length() == 5) {
                    var6.setAff_racine("                                        " + ((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk("                                        " + ((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp("                                        " + ((ObjetRacine) var4.get(var5)).getNom_SP());
                } else if (var6.getRacCode().length() == 6) {
                    var6.setAff_racine("                                                  " + ((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk("                                                  " + ((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp("                                                  " + ((ObjetRacine) var4.get(var5)).getNom_SP());
                } else if (var6.getRacCode().length() == 7) {
                    var6.setAff_racine("                                                         " + ((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk("                                                            " + ((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp("                                                            " + ((ObjetRacine) var4.get(var5)).getNom_SP());
                } else if (var6.getRacCode().length() == 8) {
                    var6.setAff_racine("                                                                      " + ((ObjetRacine) var4.get(var5)).getNom_FR());
                    var6.setRacLibelleUk("                                                                      " + ((ObjetRacine) var4.get(var5)).getNom_UK());
                    var6.setRacLibelleSp("                                                                      " + ((ObjetRacine) var4.get(var5)).getNom_SP());
                }

                var6.setRacCodenature(((ObjetRacine) var4.get(var5)).getNature());
                var6.setRacnature("");
                if (var2.size() != 0) {
                    for (int var7 = 0; var7 < var2.size(); ++var7) {
                        if (((ObjetCompte) var2.get(var7)).getCode().equals(var6.getRacCodenature())) {
                            var6.setRacnature(((ObjetCompte) var2.get(var7)).getNom_FR());
                            break;
                        }
                    }
                }

                var6.setRacUtil(((ObjetRacine) var4.get(var5)).getUtil());
                var6.setRactaux(0.0F);
                this.lesfiscalites.add(var6);
            }
        }

        return this.lesfiscalites;
    }

    public void rechargerRacines() throws HibernateException, NamingException, IOException {
        this.supprimerRacine();
        this.chargerMesRacinesCpteXml();
    }

    public List chargerMesRacinesCpteDao(Session var1) throws HibernateException, NamingException {
        this.lesfiscalites = new ArrayList();
        this.lesfiscalites = this.racinesDao.chargerMesRacines(this.selecFiscalite, var1);
        return this.lesfiscalites;
    }

    public void chargerMesracines() throws HibernateException, NamingException, IOException {
        this.chargerMesracines(null);
        if (this.lesfiscalites.size() == 0) {
            this.chargerMesRacinesCpteXml();
        }

    }

    public void chargerMesracines(Session var1) throws HibernateException, NamingException, IOException {
        if (this.structureLog.getStrzonefiscale2() == null || this.structureLog.getStrzonefiscale2().isEmpty() || this.choixRacine != 2 && this.choixRacine != 0) {
            if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.choixRacine == 1) {
                this.choixRacine = 2;
                this.selecFiscalite = this.structureLog.getStrzonefiscale2();
            } else {
                this.choixRacine = 0;
                this.selecFiscalite = this.structureLog.getStrzonefiscale();
            }
        } else {
            this.choixRacine = 1;
            this.selecFiscalite = this.structureLog.getStrzonefiscale();
        }

        this.fiscalite = this.selecFiscalite;
        if (this.chargerMesRacinesCpteDao(var1).size() == 0) {
            this.chargerMesRacinesCpteXml();
        } else {
            LectureNatureCompte var2 = new LectureNatureCompte();
            new ArrayList();
            List var3 = var2.getMesNatureCompte();
            LectureRacines var4 = new LectureRacines(this.selecFiscalite);
            var4.setStructureLog(this.structureLog);
            var4.recupereRacines();
            new ArrayList();
            List var5 = var4.getMesRacines();
            if (var5.size() != 0) {
                int var7;
                for (int var6 = 0; var6 < this.lesfiscalites.size(); ++var6) {
                    this.racines = (Racines) this.lesfiscalites.get(var6);

                    for (var7 = 0; var7 < var5.size(); ++var7) {
                        if (((ObjetRacine) var5.get(var7)).getCode().equals(this.racines.getRacCode())) {
                            this.racines.setRacLibelleFr(((ObjetRacine) var5.get(var7)).getNom_FR());
                            this.racines.setRacCodenature(((ObjetRacine) var5.get(var7)).getNature());
                            this.racines.setRacnature("");
                            if (var3.size() != 0) {
                                for (int var8 = 0; var8 < var3.size(); ++var8) {
                                    if (((ObjetCompte) var3.get(var8)).getCode().equals(this.racines.getRacCodenature())) {
                                        this.racines.setRacnature(((ObjetCompte) var3.get(var8)).getNom_FR());
                                        break;
                                    }
                                }
                            }

                            this.racines.setRacUtil(((ObjetRacine) var5.get(var7)).getUtil());
                            break;
                        }
                    }
                }

                new ObjetRacine();

                for (var7 = 0; var7 < var5.size(); ++var7) {
                    ObjetRacine var10 = (ObjetRacine) var5.get(var7);
                    boolean var11 = false;

                    int var9;
                    for (var9 = 0; var9 < this.lesfiscalites.size(); ++var9) {
                        if (var10.getCode().equals(((Racines) this.lesfiscalites.get(var9)).getRacCode())) {
                            var11 = true;
                            break;
                        }
                    }

                    if (!var11) {
                        this.racines = new Racines();
                        this.racines.setRacCode(var10.getCode());
                        this.racines.setRacCodenature(var10.getNature());
                        this.racines.setRacFiscalite(this.selecFiscalite);
                        this.racines.setRacLibelleFr(var10.getNom_FR());
                        this.racines.setRacLibelleSp(var10.getNom_SP());
                        this.racines.setRacLibelleUk(var10.getNom_UK());
                        this.racines.setRacUtil(var10.getUtil());
                        this.racines.setRacnature("");
                        if (var3.size() != 0) {
                            for (var9 = 0; var9 < var3.size(); ++var9) {
                                if (((ObjetCompte) var3.get(var9)).getCode().equals(this.racines.getRacCodenature())) {
                                    this.racines.setRacnature(((ObjetCompte) var3.get(var9)).getNom_FR());
                                    break;
                                }
                            }
                        }

                        this.lesfiscalites.add(this.racines);
                    }
                }
            }
        }

    }

    public void saveracine() throws HibernateException, NamingException {
        this.supprimerRacine();
        this.racinesDao.saveRacineComptable(this.selecFiscalite, this.lesfiscalites);
        this.chargerMesRacinesCpteDao(null);
    }

    public void atteindreRacineComptable() {
    }

    public void revenirParametrecompta() {
    }

    public void supprimerRacine() throws HibernateException, NamingException {
        this.racinesDao.removeRacine(this.selecFiscalite);
    }

    public void exportXML() {
        new SAXBuilder();

        try {
            File var2 = File.createTempFile("test", ".xml");
            String var3 = var2.getAbsolutePath();
            this.racine = new Element("fiscalite");
            this.document = new Document(this.racine);
            new Racines();

            for (int var5 = 0; var5 < this.lesfiscalites.size(); ++var5) {
                Racines var4 = (Racines) this.lesfiscalites.get(var5);
                Element var6 = new Element("racine");
                Element var7 = new Element("code");
                var6.addContent(var7);
                var7.setText(var4.getRacCode());
                Element var8 = new Element("lib_FR");
                var6.addContent(var8);
                var8.setText("" + var4.getRacLibelleFr());
                Element var9 = new Element("lib_UK");
                var6.addContent(var9);
                var9.setText(var4.getRacLibelleUk());
                Element var10 = new Element("lib_SP");
                var6.addContent(var10);
                var10.setText(var4.getRacLibelleSp());
                Element var11 = new Element("nature");
                var6.addContent(var11);
                var11.setText("" + var4.getRacCodenature());
                Element var12 = new Element("util");
                var6.addContent(var12);
                var12.setText("" + var4.getRacUtil());
                this.racine.addContent(var6);
            }

            this.enregistre(var2);
        } catch (Exception var13) {
        }

    }

    public void enregistre(File var1) {
        try {
            XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
            FileOutputStream var3 = new FileOutputStream(var1);
            var2.output(this.document, var3);
            var3.close();
        } catch (IOException var4) {
        }

    }

    public void generationPlanComptable() throws HibernateException, NamingException, IOException {
        if (this.lesfiscalites.size() != 0) {
            LireLesoptionsCompta var1 = new LireLesoptionsCompta(this.structureLog);
            var1.setStrId(this.structureLog.getStrid());
            var1.lancer();
            this.nombrCaracter = Integer.parseInt(var1.getOptionComptabilite().getNbcr());
            new ArrayList();
            LectureNatureCompte var3 = new LectureNatureCompte();
            List var2 = var3.getMesNatureCompte();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
            Transaction var5 = null;

            try {
                var5 = var4.beginTransaction();
                new PlanComptable();
                PlanComptableDao var7 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);

                for (int var8 = 0; var8 < this.lesfiscalites.size(); ++var8) {
                    this.racines = (Racines) this.lesfiscalites.get(var8);
                    if (this.racines.getRacUtil() != null && !this.racines.getRacUtil().isEmpty() && this.racines.getRacUtil().equals("1")) {
                        PlanComptable var6 = new PlanComptable();
                        var6.setPlcDateCreat(new Date());
                        var6.setPlcUserCreat(this.usersLog.getUsrid());
                        var6.setPlcAnalCle1("");
                        var6.setPlcAnalCle2("");
                        String var9 = "0";
                        var9 = this.getComplementutil(var9, this.racines.getRacCode());
                        var6.setPlcCompte(this.racines.getRacCode().concat(var9));
                        var6.setPlcCodeRacine(this.racines.getRacCode());
                        var6.setPlcFiscalite(this.selecFiscalite);
                        var6.setPlcInactif(0);
                        var6.setPlcLibelleCpteFR(this.racines.getRacLibelleFr());
                        var6.setPlcLibelleCpteSP(this.racines.getRacLibelleSp());
                        var6.setPlcLibelleCpteUK(this.racines.getRacLibelleUk());
                        var6.setPlcLibelleRacineFR(this.racines.getRacLibelleFr());
                        var6.setPlcLibelleRacineSP(this.racines.getRacLibelleSp());
                        var6.setPlcLibelleRacineUK(this.racines.getRacLibelleUk());
                        var6.setPlcLibre(this.calculPlcLibre(var6.getPlcCompte(), this.racines.getRacCode()));
                        if (this.racines.getRacCodenature() == null || this.racines.getRacCodenature().isEmpty()) {
                            this.racines.setRacCodenature("0");
                        }

                       var6.setPlcRanDetaille(var6.getPlcNature() == 6 || var6.getPlcNature() == 7);

                        var6.setPlcSage("");
                        var6.setPlcNature(Integer.parseInt(this.racines.getRacCodenature()));

                        for (int var10 = 0; var10 < var2.size(); ++var10) {
                            new ObjetCompte();
                            ObjetCompte var11 = (ObjetCompte) var2.get(var10);
                            if (var11.getCode().contentEquals(this.racines.getRacCodenature())) {
                                var6.setPlcLibelleNatureFR(var11.getNom_FR());
                                var6.setPlcLibelleNatureSP(var11.getNom_SP());
                                var6.setPlcLibelleNatureUK(var11.getNom_SP());
                                var6.setPlcSens(Integer.parseInt(var11.getSens()));
                               var6.setPlcRanDetaille(var6.getPlcNature() == 6 || var6.getPlcNature() == 7 || var6.getPlcNature() == 8 || var6.getPlcNature() == 9 || var6.getPlcNature() == 13 || var6.getPlcNature() == 14 || var6.getPlcNature() == 15);
                            }
                        }

                        var6.setPlcTauxTaxe(this.racines.getRactaux());
                        var6.setExercicesComptable(this.selectedExo);
                        var7.insert(var6, var4);
                    }
                }

                var5.commit();
            } catch (HibernateException var15) {
                if (var5 != null) {
                    var5.rollback();
                }

                throw var15;
            } finally {
                this.utilInitHibernate.closeSession();
            }
        }

    }

    public String getComplementutil(String var1, String var2) {
        String var3 = var2.concat(var1);
        int var4 = this.nombrCaracter - var3.length();
        String var5 = "";
        String[] var6 = new String[var4];

        for (int var7 = 0; var7 < var4; ++var7) {
            var6[var7] = "0";
            var5 = var5 + var6[var7];
        }

        var5 = var5 + var1;
        return var5;
    }

    public String calculPlcLibre(String var1, String var2) {
        String var3 = null;
        int var4 = var2.length();
        var3 = var1.substring(var4);
        return var3;
    }

    public String verificationLgCompte(String var1, LireLesoptionsCompta var2) throws IOException {
        int var3 = Integer.parseInt(var2.getOptionComptabilite().getNbcr()) - var1.length();
        String var4 = var1;
        if (var3 == 1) {
            var4 = var1 + "0";
        } else if (var3 == 2) {
            var4 = var1 + "00";
        } else if (var3 == 3) {
            var4 = var1 + "000";
        } else if (var3 == 4) {
            var4 = var1 + "0000";
        } else if (var3 == 5) {
            var4 = var1 + "00000";
        } else if (var3 == 6) {
            var4 = var1 + "000000";
        } else if (var3 == 7) {
            var4 = var1 + "0000000";
        } else if (var3 == 8) {
            var4 = var1 + "00000000";
        } else if (var3 == 9) {
            var4 = var1 + "000000000";
        } else if (var3 == 10) {
            var4 = var1 + "0000000000";
        } else if (var3 == 11) {
            var4 = var1 + "00000000000";
        } else if (var3 == 12) {
            var4 = var1 + "000000000000";
        } else if (var3 == 13) {
            var4 = var1 + "0000000000000";
        } else if (var3 == 14) {
            var4 = var1 + "00000000000000";
        } else if (var3 == 15) {
            var4 = var1 + "000000000000000";
        } else if (var3 == 16) {
            var4 = var1 + "0000000000000000";
        } else if (var3 == 17) {
            var4 = var1 + "00000000000000000";
        } else if (var3 == 18) {
            var4 = var1 + "000000000000000000";
        } else if (var3 == 19) {
            var4 = var1 + "0000000000000000000";
        }

        return var4;
    }

    public ExercicesComptable getSelectedExo() {
        return this.selectedExo;
    }

    public void setSelectedExo(ExercicesComptable var1) {
        this.selectedExo = var1;
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

    public LectureZonesFiscales getZoneFiscale() {
        return this.zoneFiscale;
    }

    public void setZoneFiscale(LectureZonesFiscales var1) {
        this.zoneFiscale = var1;
    }

    public String getFiscalite() {
        return this.fiscalite;
    }

    public void setFiscalite(String var1) {
        this.fiscalite = var1;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String var1) {
        this.format = var1;
    }

    public List getLesfiscalites() {
        return this.lesfiscalites;
    }

    public void setLesfiscalites(List var1) {
        this.lesfiscalites = var1;
    }

    public int getLigne() {
        return this.ligne;
    }

    public void setLigne(int var1) {
        this.ligne = var1;
    }

    public Racines getRacines() {
        return this.racines;
    }

    public void setRacines(Racines var1) {
        this.racines = var1;
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

    public int getChoixRacine() {
        return this.choixRacine;
    }

    public void setChoixRacine(int var1) {
        this.choixRacine = var1;
    }

    public String getSelecFiscalite() {
        return this.selecFiscalite;
    }

    public void setSelecFiscalite(String var1) {
        this.selecFiscalite = var1;
    }
}
