package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
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
public class CmmModeleCourriersVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "modId can not null")
    private Long modId;


    /**
     * date de creation
     */
    private LocalDateTime modDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime modDateModif;


    /**
     * utilisateur de creation
     */
    private Long modUserCreat;


    /**
     * utilisateur de modification
     */
    private Long modUserModif;


    /**
     * code modele
     */
    private String modCode;


    /**
     * nom modele en FR
     */
    private String modNomFr;


    /**
     * nom modele en UK
     */
    private String modNomUk;


    /**
     * nom modele en SP
     */
    private String modNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer modInactif;


    /**
     * commercial(10= mail 20=lettre 21=annexe 22=correspondance 25=contrat) paye(82=contrat 83=attestation 84=avertissement 85=certificat 86=correspondance)
     */
    private Integer modNature;


    /**
     * vente(0=vte 1=leasing 2=assistance 3=garantie 4=sav 5=autre) paye(0=stage 1=cdd 2=cdi 3=prestataire)
     */
    private Integer modType;


    /**
     * texte
     */
    private String modTexte;


    /**
     * texte sur option
     */
    private String modOption;


    /**
     * texte sur condition de paiement
     */
    private String modConditionPaiement;


    /**
     * 0=sans 1=avec
     */
    private Integer modAccessoire;


    /**
     * 0=sans 1=avec
     */
    private Integer modAcompte;


    /**
     * plancher taux acompte
     */
    private Float modTauxAcompte;


    /**
     * 0=sans 1=avec
     */
    private Integer modAmortissement;


    /**
     * taux amortissement
     */
    private Float modTauxAmortissement;


    /**
     * 0=sans 1=avec
     */
    private Integer modFraisFinancier;


    /**
     * taux frais financiers
     */
    private Float modTauxFraisFinancier;


    /**
     * 0=sans 1=avec
     */
    private Integer modContratEntretien;


    /**
     * taux contrat entretien
     */
    private Float modTauxContratEntretien;


    /**
     * 0=sans 1=avec
     */
    private Integer modAssurance;


    /**
     * taux assurance
     */
    private Float modTauxAssurance;


    /**
     * 0=sans 1=avec
     */
    private Integer modFranchise;


    /**
     * taux franchise
     */
    private Float modTauxFranchise;


    /**
     * 0=sans 1=avec
     */
    private Integer modFraisStructure;


    /**
     * taux frais structure
     */
    private Float modTauxFraisStructure;


    /**
     * 0=sans 1=avec
     */
    private Integer modRemplacement;


    /**
     * taux vehicule de remplacement
     */
    private Float modTauxRemplacement;


    /**
     * 0=sans 1=avec
     */
    private Integer modRemplissage;


    /**
     * taux ponderation de remplissage
     */
    private Float modTauxRemplissage;


    /**
     * 0=sans 1=avec
     */
    private Integer modMarge;


    /**
     * taux marge
     */
    private Float modTauxMarge;


    /**
     * 0=sans 1=avec
     */
    private Integer modValeurResiduelle;


    /**
     * taux valeur residuelle
     */
    private Float modTauxValeurResiduelle;


    /**
     * duree minimale en nb mois
     */
    private Integer modDureeMin;


    /**
     * duree maximale en nb mois
     */
    private Integer modDureeMax;

}
