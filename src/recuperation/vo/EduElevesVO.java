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
public class EduElevesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "eleId can not null")
    private Long eleId;


    /**
     * date de creation
     */
    private LocalDateTime eleDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime eleDateModif;


    /**
     * user de creation
     */
    private Long eleUserCreat;


    /**
     * user de modification
     */
    private Long eleUserModif;


    /**
     * 0=actif 1=inactif 2=supprime
     */
    private Integer eleEtat;


    /**
     * numero dossier
     */
    private String eleDossier;


    /**
     * nom du patient
     */
    private String eleNom;


    /**
     * prenom
     */
    private String elePrenom;


    /**
     * photo
     */
    private String elePhoto;


    /**
     * nom de jeune fille
     */
    private String eleNomJf;


    /**
     * numero de cate d identite
     */
    private String eleCi;


    /**
     * numero de securite sociale
     */
    private String eleSecu;


    /**
     * couvert par
     */
    private String eleCouvert;


    /**
     * civilite
     */
    private String eleCivilite;


    /**
     * telephone domicile
     */
    private String eleTelDom;


    /**
     * cellulaire 1
     */
    private String eleCel1;


    /**
     * cellulaire 2
     */
    private String eleCel2;


    /**
     * cellulaire 3
     */
    private String eleCel3;


    /**
     * telephone voiture
     */
    private String eleTelVoiture;


    /**
     * 0=femme 1=homme
     */
    private Integer eleSexe;


    /**
     * date de naissance
     */
    private LocalDate eleDateNaissance;


    /**
     * lieu de naissance
     */
    private String eleLieuNaissance;


    /**
     * pays de naissance
     */
    private String elePaysNaissance;


    /**
     * observations
     */
    private String eleObservations;


    /**
     * adresse actuelle
     */
    private String eleAdresse;


    /**
     * numero rue
     */
    private String eleRue;


    /**
     * numero lot
     */
    private String eleLot;


    /**
     * numero illot
     */
    private String eleIlot;


    /**
     * numero batiment
     */
    private String eleBatiment;


    /**
     * numero porte
     */
    private String elePorte;


    /**
     * numero etage
     */
    private String eleEtage;


    /**
     * ascenseur
     */
    private String eleAscensseur;


    /**
     * quartier
     */
    private String eleQuartier;


    /**
     * commune
     */
    private String eleCommune;


    /**
     * departement
     */
    private String eleDepart;


    /**
     * zone
     */
    private String eleZone;


    /**
     * boite poste
     */
    private String eleBp;


    /**
     * cedex
     */
    private String eleCedex;


    /**
     * ville
     */
    private String eleVille;


    /**
     * pays
     */
    private String elePays;


    /**
     * adresse yahoo
     */
    private String eleYahoo;


    /**
     * adresse msn
     */
    private String eleMsn;


    /**
     * adresse skype
     */
    private String eleSkype;


    /**
     * mail 1
     */
    private String eleMail1;


    /**
     * famille patient
     */
    private String eleNomFamille;


    /**
     * serie
     */
    private String eleSerie;


    /**
     * nom banque
     */
    private String eleNomBanque;


    /**
     * adresse banque
     */
    private String eleAdresseBanque;


    /**
     * numero banque
     */
    private String eleNumBanque;


    /**
     * numero guichet
     */
    private String eleGuichetBanque;


    /**
     * numero compte
     */
    private String eleCompteBanque;


    /**
     * rib
     */
    private String eleCleBanque;


    /**
     * iban
     */
    private String eleIban;


    /**
     * swift
     */
    private String eleSwift;


    /**
     * compte comptable
     */
    private String eleCompte;


    /**
     * situation de famille
     */
    private Integer eleSitFam;


    /**
     * nom du pere
     */
    private String eleNomPere;


    /**
     * nom de la mere
     */
    private String eleNomMere;


    /**
     * mode de reglement
     */
    private String eleModeReg;


    /**
     * 0=sans calcul 1=paiement comptant 2=terme date de facture 3=terme fin de mois
     */
    private Integer eleTypeReg;


    /**
     * nombre de jours d echeance
     */
    private Integer eleNbEcheance;


    /**
     * nombre de jours d arrondi
     */
    private Integer eleNbArrondi;


    /**
     * conditions de reglements
     */
    private String eleConditionReg;

}
