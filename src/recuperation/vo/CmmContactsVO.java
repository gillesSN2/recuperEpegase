package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class CmmContactsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "conId can not null")
    private Long conId;


    /**
     * date de creation
     */
    private LocalDateTime conDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime conDateModif;


    /**
     * utilisateur de creation
     */
    private Long conUserCreat;


    /**
     * utilisateur de modification
     */
    private Long conUserModif;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer conEtat;


    /**
     * nom
     */
    private String conNom;


    /**
     * prenom
     */
    private String conPrenom;


    /**
     * nom prenom
     */
    private String conPatronyme;


    /**
     * civilite (suivant fichier xml)
     */
    private String conCivilite;


    /**
     * pays
     */
    private String conNomPays;


    /**
     * code de la langue
     */
    private String conLangue;


    /**
     * fonction du contact
     */
    private String conFonction;


    /**
     * imputation service
     */
    private String conService;


    /**
     * date de naissance
     */
    private LocalDate conDateNaissance;


    /**
     * periode anniversaire JJ:MM par rapport aÃ‚Â  la date d anniversaire
     */
    private String conAnniversaire;


    /**
     * telephone domicile
     */
    private String conTelBur;


    /**
     * telephone domicile
     */
    private String conTelDom;


    /**
     * mobile 1
     */
    private String conCel1;


    /**
     * mobile 2
     */
    private String conCel2;


    /**
     * mobile 3
     */
    private String conCel3;


    /**
     * fax
     */
    private String conFax;


    /**
     * adresse
     */
    private String conAdresse;


    /**
     * no rue
     */
    private String conRue;


    /**
     * no de lot
     */
    private String conLot;


    /**
     * no ilot
     */
    private String conIlot;


    /**
     * batiment
     */
    private String conBatiment;


    /**
     * no porte
     */
    private String conPorte;


    /**
     * escalier
     */
    private String conEscalier;


    /**
     * ascenseur
     */
    private String conAscensseur;


    /**
     * quantier
     */
    private String conQuartier;


    /**
     * commune
     */
    private String conCommune;


    /**
     * departement
     */
    private String conDeparte;


    /**
     * zone
     */
    private String conZone;


    /**
     * boite postale
     */
    private String conBp;


    /**
     * cedex
     */
    private String conCedex;


    /**
     * ville
     */
    private String conVille;


    /**
     * adresse yahoo
     */
    private String conYahoo;


    /**
     * adresse msn
     */
    private String conMsn;


    /**
     * adresse skype
     */
    private String conSkype;


    /**
     * adresse aol
     */
    private String conAol;


    /**
     * mail 1
     */
    private String conMail1;


    /**
     * mail 2
     */
    private String conMail2;


    /**
     * mail 3
     */
    private String conMail3;


    /**
     * mail 4
     */
    private String conMail4;


    /**
     * mail 5
     */
    private String conMail5;


    /**
     * blog
     */
    private String conBlog;


    /**
     * adresse web
     */
    private String conWeb;


    /**
     * observation
     */
    private String conObservation;


    /**
     * appreciation
     */
    private String conAppreciation;


    /**
     * code banque
     */
    private String conNumBanque;


    /**
     * code guichet
     */
    private String conGuichetBanque;


    /**
     * numero de compte
     */
    private String conCompteBanque;


    /**
     * cle rib
     */
    private String conCleBanque;


    /**
     * code iban
     */
    private String conIban;


    /**
     * code swift
     */
    private String conSwift;

    @NotNull(message = "tieId can not null")
    private Long tieId;


    /**
     * code journal de la banque
     */
    private String conJournal;


    /**
     * mot de passe espace client
     */
    private String conPwEspaceClient;

}
