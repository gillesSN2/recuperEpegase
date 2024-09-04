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
public class CmmPlanAnalytiqueVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "anaId can not null")
    private Long anaId;


    /**
     * date de creation
     */
    private LocalDateTime anaDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime anaDateModif;


    /**
     * utilisateur de creation
     */
    private Long anaUserCreat;


    /**
     * utilisateur de modification
     */
    private Long anaUserModif;


    /**
     * annee
     */
    private String anaAnnee;


    /**
     * nature 1=a1 2=a2 3=a3 4=a4 5=chantier 6=dossier 7=destinataire 8=parc 9=cle
     */
    private String anaNature;


    /**
     * ordre des elements
     */
    private Integer anaOrdre;


    /**
     * code analytique 1
     */
    private String anaCode;


    /**
     * libelle en FR
     */
    private String anaNomFr;


    /**
     * libelle en UK
     */
    private String anaNomUk;


    /**
     * libelle en SP
     */
    private String anaNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer anaInactif;


    /**
     * nature de la repartition
     */
    private Integer anaNatureRepartition;


    /**
     * annee de debut de validite
     */
    private Integer anaAnneeDebut;


    /**
     * annee de fin de validite
     */
    private Integer anaAnneeFin;


    /**
     * type de dossier
     */
    private String anaTypeDossier;


    /**
     * date debut mission
     */
    private LocalDate anaMissionDebut;


    /**
     * date fin mission
     */
    private LocalDate anaMissionFin;


    /**
     * nom du proprietaire
     */
    private String anaMissionProprietaire;


    /**
     * lettre de commande
     */
    private String anaMissionLettreCmd;


    /**
     * nom du chef de chantier
     */
    private String anaMissionChef;


    /**
     * cout theorique
     */
    private Double anaMissionCoutTheorique;


    /**
     * etat du chantier 0=en cours 1=ferme 2=gele 3=abondonne
     */
    private Integer anaMission0;


    /**
     * civilite (suivant fichier xml)
     */
    private String anaTiersCivilite;


    /**
     * telephone destinataire
     */
    private String anaTiersTelephone;


    /**
     * fax
     */
    private String anatiersFax;


    /**
     * adresse destinataire
     */
    private String anaTiersAdresse;


    /**
     * boite postale
     */
    private String anaTiersBp;


    /**
     * adresse mail
     */
    private String anaTiersMail;


    /**
     * ville
     */
    private String anaTiersVille;


    /**
     * point de vente
     */
    private String anaTiersPdv;


    /**
     * appreciation
     */
    private String anaTiersAppreciaiton;


    /**
     * nom pays
     */
    private String anaTiersNomPays;


    /**
     * code devise
     */
    private String anaTiersDevise;


    /**
     * format devise
     */
    private Integer anaTiersFormatDevise;


    /**
     * source du tiers
     */
    private String anaTiersSource;


    /**
     * code langue
     */
    private String anaTiersLangue;


    /**
     * observations
     */
    private String anaTiersObs;


    /**
     * 1=autorise dans les ventes
     */
    private Boolean anaVte;


    /**
     * 1=autorise dans les achats
     */
    private Boolean anaAch;


    /**
     * 1=autorise dans la production
     */
    private Boolean anaPrd;


    /**
     * 1=autorise dans les frais generaux
     */
    private Boolean anaFrg;


    /**
     * 1=autorise dans les investissements
     */
    private Boolean anaInv;


    /**
     * 1=autorise dans la tva
     */
    private Boolean anaTva;


    /**
     * 1=autorise dans les impots et taxes
     */
    private Boolean anaTax;


    /**
     * 1=autorise dans les salaries
     */
    private Boolean anaSal;


    /**
     * devise
     */
    private String anaTypeDevise;


    /**
     * taux de devise
     */
    private Float anaTypeTauxDevise;


    /**
     * exoneration de tva
     */
    private Boolean anaTypeExoTva;


    /**
     * exoneration de douane
     */
    private Boolean anaTypeExoDouane;


    /**
     * etat du chantier 0=en cours 1=ferme 2=gele 3=abondonne
     */
    private Integer anaMissionEtat;


    /**
     * regroupement des destinataires
     */
    private String anaTiersRegroupe;


    /**
     * id du tiers
     */
    private Long anaIdTiers;


    /**
     * service affaire
     */
    private String anaAffairesService;


    /**
     * etat affaire 0=en cours 1=terminee
     */
    private Integer anaAffaireEtat;


    /**
     * nom agent
     */
    private String anaAffairesAgent;


    /**
     * valeur theorique
     */
    private Double anaAffaireTheo;


    /**
     * valeur relle
     */
    private Double anaAffaireReel;


    /**
     * nom contact
     */
    private String anaAffairesConctact;


    /**
     * date premiere information
     */
    private LocalDate anaDateInformation;


    /**
     * date premier rendez vous
     */
    private LocalDate anaDateRdv;


    /**
     * cout affaire theorique
     */
    private Double anaAffairesCoutTheo;


    /**
     * cout affaire reel
     */
    private Double anaAffairesCoutReel;

}
