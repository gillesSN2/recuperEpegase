package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteSimulationEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long simcrtId;


    /**
     * date de creation
     */
    private LocalDateTime simcrtDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime simcrtDateModif;


    /**
     * id user createur
     */
    private Long simcrtIdCreateur;


    /**
     * nom du createur
     */
    private String simcrtNomCreateur;


    /**
     * id user de modification
     */
    private Long simcrtIdModif;


    /**
     * nom user de modification
     */
    private String simcrtNomModif;


    /**
     * date du devis
     */
    private LocalDateTime simcrtDate;


    /**
     * numero devis
     */
    private String simcrtNum;


    /**
     * nom du commercial
     */
    private String simcrtNomResponsable;


    /**
     * id du commercial
     */
    private Long simcrtIdResponsable;


    /**
     * nom du client
     */
    private String simcrtNomTiers;


    /**
     * civilite du tiers
     */
    private String simcrtCivilTiers;


    /**
     * id du contact
     */
    private Long simcrtIdContact;


    /**
     * nom du contact ou destinataire
     */
    private String simcrtNomContact;


    /**
     * civilite du contact
     */
    private String simcrtCivilContact;


    /**
     * serie A, B, C, D ou X
     */
    private String simcrtSerie;


    /**
     * 0=avec tva 1=sans tva
     */
    private Integer simcrtExoTva;


    /**
     * 0=avec douane 1=sans douane
     */
    private Integer simcrtExoDouane;


    /**
     * categorie du client
     */
    private String simcrtCat;


    /**
     * code devise
     */
    private String simcrtDevise;


    /**
     * objet
     */
    private String simcrtObject;


    /**
     * observation
     */
    private String simcrtObservation;


    /**
     * total ht
     */
    private Double simcrtTotHt;


    /**
     * ttal tva
     */
    private Double simcrtTotTva;


    /**
     * total taxe complementaire
     */
    private Double simcrtTotTc;


    /**
     * total ttc
     */
    private Double simcrtTotTtc;


    /**
     * code activite
     */
    private String simcrtActivite;


    /**
     * code site
     */
    private String simcrtSite;


    /**
     * code departement
     */
    private String simcrtDepartement;


    /**
     * code service
     */
    private String simcrtService;


    /**
     * code region
     */
    private String simcrtRegion;


    /**
     * code secteur
     */
    private String simcrtSecteur;


    /**
     * code point de vente
     */
    private String simcrtPdv;


    /**
     * code analytique 2 (parc)
     */
    private String simcrtAnal2;


    /**
     * code analytique 4 (dossier)
     */
    private String simcrtAnal4;


    /**
     * info 1
     */
    private String simcrtInfo1;


    /**
     * info 2
     */
    private String simcrtInfo2;


    /**
     * info 3
     */
    private String simcrtInfo3;


    /**
     * info 4
     */
    private String simcrtInfo4;


    /**
     * info 5
     */
    private String simcrtInfo5;


    /**
     * info 6
     */
    private String simcrtInfo6;


    /**
     * info 7
     */
    private String simcrtInfo7;


    /**
     * info 8
     */
    private String simcrtInfo8;


    /**
     * info 9
     */
    private String simcrtInfo9;


    /**
     * info 10
     */
    private String simcrtInfo10;


    /**
     * code formule 1
     */
    private String simcrtFormule1;


    /**
     * code formule 2
     */
    private String simcrtFormule2;


    /**
     * nom jasper du modele annexe 1
     */
    private String simcrtAnnexe1;


    /**
     * nom jasper du modele annexe 2
     */
    private String simcrtAnnexe2;


    /**
     * code incoterm
     */
    private String simcrtIncoterm;


    /**
     * lieu de livraison
     */
    private String simcrtLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate simcrtDateLivraison;


    /**
     * info sur la livraison
     */
    private String simcrtInfoLivraison;


    /**
     * date impression
     */
    private LocalDateTime simcrtDateImp;


    /**
     * nom jasper du modele
     */
    private String simcrtModeleImp;


    /**
     * nom jasper du modele page de garde
     */
    private String simcrtGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer simcrtEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer simcrtGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer simcrtEtat;


    /**
     * date de validite
     */
    private LocalDate simcrtDateValidite;


    /**
     * date de relance
     */
    private LocalDate simcrtDateRelance;


    /**
     * date de validation
     */
    private LocalDateTime simcrtDateValide;


    /**
     * date de transformation
     */
    private LocalDateTime simcrtDateTransforme;


    /**
     * type de transformation
     */
    private Integer simcrtTypeTransforme;


    /**
     * date annulation
     */
    private LocalDateTime simcrtDateAnnule;


    /**
     * motif annulation
     */
    private String simcrtMotifAnnule;


    /**
     * type de contrat
     */
    private String simcrtTypeContrat;


    /**
     * code du produit
     */
    private String simcrtCode;


    /**
     * marque
     */
    private String simcrtMarque;


    /**
     * gamme
     */
    private String simcrtGamme;


    /**
     * modele
     */
    private String simcrtModele;


    /**
     * code taxe
     */
    private String simcrtTaxe;


    /**
     * taux de taxe
     */
    private Float simcrtTauxTaxe;


    /**
     * base prc
     */
    private Double simcrtPrc;


    /**
     * % de remise
     */
    private Float simcrtTauxRemise;


    /**
     * montant remise
     */
    private Double simcrtRemise;


    /**
     * base prg
     */
    private Double simcrtPrg;


    /**
     * prix des accessoires
     */
    private Double simcrtAccessoire;


    /**
     * acompte
     */
    private Double simcrtAcompte;


    /**
     * base de calcul
     */
    private Double simcrtBase;


    /**
     * amortissement
     */
    private Double simcrtAmortissement;


    /**
     * frais financier
     */
    private Double simcrtFraisFinancier;


    /**
     * contrat entretien
     */
    private Double simcrtEntretien;


    /**
     * assurance
     */
    private Double simcrtAssurance;


    /**
     * franchise
     */
    private Double simcrtFranchise;


    /**
     * frais structure
     */
    private Double simcrtFraisstructure;


    /**
     * remplacement
     */
    private Double simcrtRemplacement;


    /**
     * remplissage
     */
    private Double simcrtRemplissage;


    /**
     * valeur de rachat
     */
    private Double simcrtValeurRachat;


    /**
     * prix de revient
     */
    private Double simcrtPr;


    /**
     * valeur residuelle theorique
     */
    private Double simcrtValeurResiduelleTheo;


    /**
     * valeur residuelle rellee
     */
    private Double simcrtValeurResiduelleReelle;


    /**
     * nombre de mois minimum
     */
    private Integer simcrtDureeMoin;


    /**
     * nombre de mois maximum
     */
    private Integer simcrtDureeMax;


    /**
     * nombre de mois
     */
    private Integer simcrtNbMois;


    /**
     * total mensuel ht
     */
    private Double simcrtThMois;


    /**
     * total mensuel taxe
     */
    private Double simcrtTxMois;


    /**
     * total mensuel ttc
     */
    private Double simcrtTtMois;


    /**
     * cumule echeance
     */
    private Double simcrtCumulEcheance;


    /**
     * taux valeur residuelle
     */
    private Float simcrtTauxValeurResiduelle;


    /**
     * taux amortissement
     */
    private Float simcrtTauxAmortissement;


    /**
     * taux frais financier
     */
    private Float simcrtTauxFraisFinancier;


    /**
     * taux cout entretien
     */
    private Float simcrtTauxEntretien;


    /**
     * taux assurance
     */
    private Float simcrtTauxAssurance;


    /**
     * taux franchise
     */
    private Float simcrtTauxFranchise;


    /**
     * taux frais structure
     */
    private Float simcrtTauxFraisStructure;


    /**
     * taux vehicule de remplacement
     */
    private Float simcrtTauxRemplacement;


    /**
     * taux remplissage
     */
    private Float simcrtTauxRemplissage;


    /**
     * taux marge
     */
    private Float simcrtTauxMarge;


    /**
     * 0=normal 99= divers
     */
    private Integer simcrtDiversTiers;


    /**
     * nom du tiers divers
     */
    private String simcrtDiversNom;


    /**
     * adresse du tiers divers
     */
    private String simcrtDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String simcrtDiversVille;


    /**
     * telephone du tiers divers
     */
    private String simcrtDiversTel;


    /**
     * mail du tiers divers
     */
    private String simcrtDiversMail;

    private Long exevteId;

    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String simcrtNomCommercial;


    /**
     * id du commercial
     */
    private Long simcrtIdCommercial;


    /**
     * nom equipe
     */
    private String simcrtNomEquipe;


    /**
     * id equipe
     */
    private Long simcrtIdEquipe;

}
