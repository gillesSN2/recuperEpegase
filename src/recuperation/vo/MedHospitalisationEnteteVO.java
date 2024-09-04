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
public class MedHospitalisationEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "hosId can not null")
    private Long hosId;


    /**
     * date de creation
     */
    private LocalDateTime hosDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime hosDateModif;


    /**
     * id user createur
     */
    private Long hosIdCreateur;


    /**
     * nom du createur
     */
    private String hosNomCreateur;


    /**
     * id user de modification
     */
    private Long hosIdModif;


    /**
     * nom user de modification
     */
    private String hosNomModif;


    /**
     * numero consult
     */
    private String hosNum;


    /**
     * date entree
     */
    private LocalDate hosDateEntree;


    /**
     * date sortie
     */
    private LocalDate hosDateSortie;


    /**
     * nombre de jours
     */
    private Integer hosNbJour;


    /**
     * motid entree fichier xml
     */
    private String hosMotifEntree;


    /**
     * motid sortie fichier xml
     */
    private String hosMotifSortie;


    /**
     * 0=ns 1=accident domestique 2=accident route 3=accident travail 4=maladie 5=autre
     */
    private Integer hosCategorie;


    /**
     * serie A, B, C, D ou X
     */
    private String hosSerie;


    /**
     * date de modification
     */
    private LocalDate hosDateTransfert;


    /**
     * date de paiement du relicat
     */
    private LocalDate hosEcheanceReliquat;


    /**
     * 0=non cloture 1=cloture
     */
    private Integer hosCloture;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer hosEtatVal;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer hosEtat;


    /**
     * numero rss
     */
    private String hosNumRss;


    /**
     * numero rum
     */
    private String hosNumRum;


    /**
     * liste des serivces
     */
    private String hosService;


    /**
     * code protocole
     */
    private String hosProtocole;


    /**
     * code pathologie
     */
    private String hosPathologie;


    /**
     * nom prescripteur
     */
    private String hosPrescripteur;


    /**
     * id medecin
     */
    private Long hosIdMedecin;


    /**
     * nom medecin
     */
    private String hosMedecin;


    /**
     * numeo bon de commande
     */
    private String hosNumBc;


    /**
     * id patient
     */
    private Long hosIdPatient;


    /**
     * civilite
     */
    private String hosCivilite;


    /**
     * nom et prenom
     */
    private String hosNomPatient;


    /**
     * id societe
     */
    private Long hosIdSociete;


    /**
     * nom societe
     */
    private String hosNomSociete;


    /**
     * matricule
     */
    private String hosMatricule;


    /**
     * id assurance
     */
    private Long hosIdAssurance;


    /**
     * nom assurance
     */
    private String hosNomAssurance;


    /**
     * numero de contrat
     */
    private String hosContratAssurance;


    /**
     * id commplementaire
     */
    private Long hosIdComplementaire;


    /**
     * nom complementaire
     */
    private String hosNomComplemtaire;


    /**
     * numero de contrat
     */
    private String hosContratComplementaire;


    /**
     * avec ou sans
     */
    private String hosPec;


    /**
     * famille du patient lie au fichier xml
     */
    private String hosFam;


    /**
     * part ht patient
     */
    private Double hosTotPatient;


    /**
     * part ht societe
     */
    private Double hosTotSociete;


    /**
     * part ht assurance
     */
    private Double hosTotAssurance;


    /**
     * part ht complementaire
     */
    private Double hosTotComplmentaire;


    /**
     * part taxe patient
     */
    private Double hosTotTaxePatient;


    /**
     * part taxe societe
     */
    private Double hosTotTaxeSociete;


    /**
     * part taxe assurance
     */
    private Double hosTotTaxeAssurance;


    /**
     * part taxe complementaire
     */
    private Double hosTotTaxeComplementaire;


    /**
     * total general
     */
    private Double hosTotGeneral;


    /**
     * total taxe
     */
    private Double hosTotTaxeGeneral;


    /**
     * reglement patient
     */
    private Double hosRegPatient;


    /**
     * 0= non solde 1=solde patient
     */
    private Integer hosSoldePatient;


    /**
     * reglement tiers
     */
    private Double hosRegTiers;


    /**
     * 0= non solde 1=solde tiers
     */
    private Integer hosSoldeTiers;


    /**
     * nom de la banque + numero de compte
     */
    private String hosBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer hosTypeReg;


    /**
     * mode de reglement xml
     */
    private String hosModeReg;


    /**
     * nombre de jour
     */
    private Integer hosNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer hosArrondiReg;


    /**
     * date echeance de reglement
     */
    private LocalDate hosDateEcheReg;


    /**
     * code activite
     */
    private String hosActivite;


    /**
     * info 1
     */
    private String hosInfo1;


    /**
     * info 2
     */
    private String hosInfo2;


    /**
     * info 3
     */
    private String hosInfo3;


    /**
     * info 4
     */
    private String hosInfo4;


    /**
     * info 5
     */
    private String hosInfo5;


    /**
     * info 6
     */
    private String hosInfo6;


    /**
     * info 7
     */
    private String hosInfo7;


    /**
     * info 8
     */
    private String hosInfo8;


    /**
     * info 9
     */
    private String hosInfo9;


    /**
     * info 10
     */
    private String hosInfo10;


    /**
     * date impression
     */
    private LocalDateTime hosDateImp;


    /**
     * nom jasper du modele
     */
    private String hosModeleImp;

    @NotNull(message = "exemedId can not null")
    private Long exemedId;

    @NotNull(message = "patId can not null")
    private Long patId;

    private Long exevteId;

}
