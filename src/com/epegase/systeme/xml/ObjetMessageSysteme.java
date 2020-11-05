package com.epegase.systeme.xml;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjetMessageSysteme implements Serializable {
    private Integer indice;
    private String date;
    private String texte;
    private String actif;
    private String type;
    private int etat;
    private String adresse;
    private long taille;
    private String cat;
    private String anniv;
    private boolean ajout;
    private boolean modif;
    private boolean supp;
    private String memoRepertoire;
    private String espace;
    private boolean selection;

    public int getEtat() {
        return this.etat;
    }

    public void setEtat(int var1) {
        this.etat = var1;
    }

    public String getType() {
        if (this.texte != null && !this.texte.isEmpty()) {
            if (this.texte.contains(".")) {
                String var1 = this.texte.toLowerCase();
                if (var1.contains(".pdf")) {
                    this.type = "/images/fichier_reader.png";
                } else if (!var1.contains(".doc") && !var1.contains(".docx")) {
                    if (!var1.contains(".odt") && !var1.contains(".odf") && !var1.contains(".odp") && !var1.contains(".ods")) {
                        if (!var1.contains(".xls") && !var1.contains(".xlsx")) {
                            if (!var1.contains(".ppt") && !var1.contains(".pptx")) {
                                if (!var1.contains(".txt") && !var1.contains(".sql") && !var1.contains(".log")) {
                                    if (!var1.contains(".zip") && !var1.contains(".rar")) {
                                        if (!var1.contains(".mp3") && !var1.contains(".mp4")) {
                                            if (this.texte.equals("..")) {
                                                this.type = "/images/retour.png";
                                            } else {
                                                this.type = "/images/fichier_autre.png";
                                            }
                                        } else {
                                            this.type = "/images/fichier_mp3.png";
                                        }
                                    } else {
                                        this.type = "/images/fichier_zip.png";
                                    }
                                } else {
                                    this.type = "/images/fichier_texte.png";
                                }
                            } else {
                                this.type = "/images/fichier_powerPoint.png";
                            }
                        } else {
                            this.type = "/images/fichier_excel.png";
                        }
                    } else {
                        this.type = "/images/fichier_openOffice.png";
                    }
                } else {
                    this.type = "/images/fichier_word.png";
                }
            } else if (this.etat == 1) {
                this.type = "/images/dossierOuvert.png";
            } else {
                this.type = "/images/dossierFerme.png";
            }
        } else {
            this.type = "";
        }

        return this.type;
    }

    public void setType(String var1) {
        this.type = var1;
    }

    public String getAnniv() {
        return this.anniv;
    }

    public void setAnniv(String var1) {
        this.anniv = var1;
    }

    public Integer getIndice() {
        return this.indice;
    }

    public void setIndice(Integer var1) {
        this.indice = var1;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String var1) {
        this.date = var1;
    }

    public String getTexte() {
        return this.texte;
    }

    public void setTexte(String var1) {
        this.texte = var1;
    }

    public String getActif() {
        return this.actif;
    }

    public void setActif(String var1) {
        this.actif = var1;
    }

    public boolean isAjout() {
        return this.ajout;
    }

    public void setAjout(boolean var1) {
        this.ajout = var1;
    }

    public boolean isModif() {
        return this.modif;
    }

    public void setModif(boolean var1) {
        this.modif = var1;
    }

    public boolean isSupp() {
        return this.supp;
    }

    public void setSupp(boolean var1) {
        this.supp = var1;
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String var1) {
        this.cat = var1;
    }

    public long getTaille() {
        return this.taille;
    }

    public void setTaille(long var1) {
        this.taille = var1;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String var1) {
        this.adresse = var1;
    }

    public String getMemoRepertoire() {
        return this.memoRepertoire;
    }

    public void setMemoRepertoire(String var1) {
        this.memoRepertoire = var1;
    }

    public String getEspace() {
        int var1 = 0;
        if (this.memoRepertoire != null && !this.memoRepertoire.isEmpty()) {
            var1 = this.stringOccur(this.memoRepertoire, "/") + 1;
        }

        this.espace = "";
        if (var1 != 0) {
            for (int var2 = 0; var2 < var1; ++var2) {
                this.espace = this.espace + ".....";
            }

            this.espace = this.espace + ":";
        }

        return this.espace;
    }

    public int stringOccur(String var1, String var2) {
        return this.regexOccur(var1, Pattern.quote(var2));
    }

    public int regexOccur(String var1, String var2) {
        Matcher var3 = Pattern.compile(var2).matcher(var1);

        int var4;
        for (var4 = 0; var3.find(); ++var4) {
        }

        return var4;
    }

    public void setEspace(String var1) {
        this.espace = var1;
    }

    public boolean isSelection() {
        return this.selection;
    }

    public void setSelection(boolean var1) {
        this.selection = var1;
    }
}
