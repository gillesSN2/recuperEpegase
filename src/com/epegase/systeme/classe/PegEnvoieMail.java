package com.epegase.systeme.classe;



import java.io.Serializable;
import java.util.Date;

public class PegEnvoieMail implements Serializable {
    private long pegmaiId;

    private int pegmaiMode;

    private long pegmaiNum;

    private Date pegmaiDateCreat;

    private Date pegmaiDateModif;

    private String pegmaiObjet;

    private String pegmaiDestinataire;

    private String pegmaiCorps;

    private String pegmaiUserCreat;

    private long pegmaiIdUserCreat;

    private String pegmaiUserModif;

    private long pegmaiIdUserModif;

    private String pegmaiResultat;

    public String getPegmaiCorps() {
        return this.pegmaiCorps;
    }

    public void setPegmaiCorps(String paramString) {
        this.pegmaiCorps = paramString;
    }

    public Date getPegmaiDateCreat() {
        return this.pegmaiDateCreat;
    }

    public void setPegmaiDateCreat(Date paramDate) {
        this.pegmaiDateCreat = paramDate;
    }

    public Date getPegmaiDateModif() {
        return this.pegmaiDateModif;
    }

    public void setPegmaiDateModif(Date paramDate) {
        this.pegmaiDateModif = paramDate;
    }

    public String getPegmaiDestinataire() {
        return this.pegmaiDestinataire;
    }

    public void setPegmaiDestinataire(String paramString) {
        this.pegmaiDestinataire = paramString;
    }

    public long getPegmaiId() {
        return this.pegmaiId;
    }

    public void setPegmaiId(long paramLong) {
        this.pegmaiId = paramLong;
    }

    public int getPegmaiMode() {
        return this.pegmaiMode;
    }

    public void setPegmaiMode(int paramInt) {
        this.pegmaiMode = paramInt;
    }

    public long getPegmaiNum() {
        return this.pegmaiNum;
    }

    public void setPegmaiNum(long paramLong) {
        this.pegmaiNum = paramLong;
    }

    public String getPegmaiObjet() {
        return this.pegmaiObjet;
    }

    public void setPegmaiObjet(String paramString) {
        this.pegmaiObjet = paramString;
    }

    public long getPegmaiIdUserCreat() {
        return this.pegmaiIdUserCreat;
    }

    public void setPegmaiIdUserCreat(long paramLong) {
        this.pegmaiIdUserCreat = paramLong;
    }

    public long getPegmaiIdUserModif() {
        return this.pegmaiIdUserModif;
    }

    public void setPegmaiIdUserModif(long paramLong) {
        this.pegmaiIdUserModif = paramLong;
    }

    public String getPegmaiUserCreat() {
        return this.pegmaiUserCreat;
    }

    public void setPegmaiUserCreat(String paramString) {
        this.pegmaiUserCreat = paramString;
    }

    public String getPegmaiUserModif() {
        return this.pegmaiUserModif;
    }

    public void setPegmaiUserModif(String paramString) {
        this.pegmaiUserModif = paramString;
    }

    public String getPegmaiResultat() {
        return this.pegmaiResultat;
    }

    public void setPegmaiResultat(String paramString) {
        this.pegmaiResultat = paramString;
    }
}

