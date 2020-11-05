package com.epegase.systeme.control;


import com.epegase.systeme.classe.Users;
import java.io.Serializable;

public class ObjetUser implements Serializable {
  private Users users;
  
  private String codeGrp;
  
  private String nomGrp;
  
  private String nomModule;
  
  private int accesModule;
  
  private String nomFonction;
  
  private int accesFonction;
  
  private int ajoutFonction;
  
  private int dupFonction;
  
  private int modifFonction;
  
  private int supFonction;
  
  private int impFonction;
  
  private int trfFonction;
  
  private int cloSerFonction;
  
  private String majLibelle;
  
  private String valLibelle;
  
  private String devalLibelle;
  
  private String dupLibelle;
  
  public Users getUsers() {
    return this.users;
  }
  
  public void setUsers(Users paramUsers) {
    this.users = paramUsers;
  }
  
  public int getAccesFonction() {
    return this.accesFonction;
  }
  
  public void setAccesFonction(int paramInt) {
    this.accesFonction = paramInt;
  }
  
  public int getAccesModule() {
    return this.accesModule;
  }
  
  public void setAccesModule(int paramInt) {
    this.accesModule = paramInt;
  }
  
  public int getAjoutFonction() {
    return this.ajoutFonction;
  }
  
  public void setAjoutFonction(int paramInt) {
    this.ajoutFonction = paramInt;
  }
  
  public int getCloSerFonction() {
    return this.cloSerFonction;
  }
  
  public void setCloSerFonction(int paramInt) {
    this.cloSerFonction = paramInt;
  }
  
  public String getCodeGrp() {
    return this.codeGrp;
  }
  
  public void setCodeGrp(String paramString) {
    this.codeGrp = paramString;
  }
  
  public int getDupFonction() {
    return this.dupFonction;
  }
  
  public void setDupFonction(int paramInt) {
    this.dupFonction = paramInt;
  }
  
  public int getImpFonction() {
    return this.impFonction;
  }
  
  public void setImpFonction(int paramInt) {
    this.impFonction = paramInt;
  }
  
  public int getModifFonction() {
    return this.modifFonction;
  }
  
  public void setModifFonction(int paramInt) {
    this.modifFonction = paramInt;
  }
  
  public String getNomFonction() {
    return this.nomFonction;
  }
  
  public void setNomFonction(String paramString) {
    this.nomFonction = paramString;
  }
  
  public String getNomGrp() {
    return this.nomGrp;
  }
  
  public void setNomGrp(String paramString) {
    this.nomGrp = paramString;
  }
  
  public String getNomModule() {
    return this.nomModule;
  }
  
  public void setNomModule(String paramString) {
    this.nomModule = paramString;
  }
  
  public int getSupFonction() {
    return this.supFonction;
  }
  
  public void setSupFonction(int paramInt) {
    this.supFonction = paramInt;
  }
  
  public int getTrfFonction() {
    return this.trfFonction;
  }
  
  public void setTrfFonction(int paramInt) {
    this.trfFonction = paramInt;
  }
  
  public String getDevalLibelle() {
    return this.devalLibelle;
  }
  
  public void setDevalLibelle(String paramString) {
    this.devalLibelle = paramString;
  }
  
  public String getDupLibelle() {
    return this.dupLibelle;
  }
  
  public void setDupLibelle(String paramString) {
    this.dupLibelle = paramString;
  }
  
  public String getMajLibelle() {
    return this.majLibelle;
  }
  
  public void setMajLibelle(String paramString) {
    this.majLibelle = paramString;
  }
  
  public String getValLibelle() {
    return this.valLibelle;
  }
  
  public void setValLibelle(String paramString) {
    this.valLibelle = paramString;
  }
}
