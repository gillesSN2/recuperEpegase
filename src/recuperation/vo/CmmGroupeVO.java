package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class CmmGroupeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "grpId can not null")
    private Long grpId;


    /**
     * code du groupe
     */
    private String grpCode;


    /**
     * nom du groupe
     */
    private String grpLibelle;


    /**
     * 0=sans acces module tiers 1=acces module tiers
     */
    private Integer grpModuleTie;


    /**
     * 0=sans acces module office 1=acces module office
     */
    private Integer grpModuleOff;


    /**
     * 0=sans acces module achats 1=acces module achats
     */
    private Integer grpModuleAch;


    /**
     * 0=sans acces module stock 1=acces module stock
     */
    private Integer grpModuleStk;


    /**
     * 0=sans acces module ventes 1=acces module ventes
     */
    private Integer grpModuleVte;


    /**
     * 0=sans acces module compta 1=acces module compta
     */
    private Integer grpModuleCpt;


    /**
     * 0=sans acces module parc 1=acces module parc
     */
    private Integer grpModulePrc;


    /**
     * 0=sans acces module caisse 1=acces module caisse
     */
    private Integer grpModuleCai;


    /**
     * 0=sans acces module paye 1=acces module paye
     */
    private Integer grpModulePay;


    /**
     * 0=sans acces module medical 1=acces module medical
     */
    private Integer grpModuleMed;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpModuleFree;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAccesMail;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAccesCopie;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAccesParapheur;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpCaissier;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpCaissierService;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpService;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpRecus;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpDateCai;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpImputCai;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpMontantCai;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchatsAervice;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchats;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpCommAchats;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchPump;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpDateAch;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpDateStk;


    /**
     * depot par defaut
     */
    private String grpDepot;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerRemiseAch;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerPaAch;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerSerieAch;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpProdServiceAch;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfDa;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfCot;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfCmd;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfRec;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfRet;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfFac;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfFra;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfAvr;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAchTrfNdd;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVentesService;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVentes;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpCommVentes;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpFactureCaisse;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAffPump;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAffPvMarche;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpAffPlancher;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpDateVte;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerRemise;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerPv;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerSerie;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpProdService;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfBes;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfDev;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfBc;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfBl;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfRet;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfFac;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfAvr;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVteTrfNdd;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpMedicalService;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpMedical;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpDateMed;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpPaye;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpPayeService;


    /**
     * 0 acces total 1 acces prive
     */
    private Integer grpMf;


    /**
     * journaux interdits
     */
    private String grpJrxInterdit;


    /**
     * 0=journaux reserves autorises 1=journaux reserves interdits
     */
    private Integer grpJrxReserve;


    /**
     * 0=tous les brouillard 1=mes brouillards
     */
    private Integer grpAccesBrouillard;


    /**
     * 0=sans correction 1=acces correction
     */
    private Integer grpAccesCorrection;


    /**
     * 0=liasse non modifiable 1=liasse modifiable
     */
    private Integer grpModifLiasse;


    /**
     * 0 acces prive 1 acces total inutilise
     */
    private Integer grpPlanning;


    /**
     * 0 acces prive 1 acces total inutilise
     */
    private String grpPlanningService;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerRabaisAch;


    /**
     * 0=sans acces module free 1=acces module free
     */
    private Integer grpVerRabais;


    /**
     * 0=sans acces module education 1=acces module education
     */
    private Integer grpModuleEdu;


    /**
     * 0=sans acces module guest 1=acces module guest
     */
    private Integer grpModuleGuest;

}
