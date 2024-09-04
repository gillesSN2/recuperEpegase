package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchCotationsEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cotId;


    /**
     * date de creation
     */
    private LocalDateTime cotDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime cotDateModif;


    /**
     * id user createur
     */
    private Long cotIdCreateur;


    /**
     * nom du createur
     */
    private String cotNomCreateur;


    /**
     * id utilisateur de modification
     */
    private Long cotIdModif;


    /**
     * nom utilisateur de modification
     */
    private String cotNomModif;


    /**
     * date de cotation
     */
    private LocalDateTime cotDate;


    /**
     * numero
     */
    private String cotNum;


    /**
     * nom du commercial
     */
    private String cotNomResponsable;


    /**
     * id du commercial
     */
    private Long cotIdResponsable;


    /**
     * nom du client
     */
    private String cotNomTiers;


    /**
     * civilite du tiers
     */
    private String cotCivilTiers;


    /**
     * id du contact
     */
    private Long cotIdContact;


    /**
     * nom du contact
     */
    private String cotNomContact;


    /**
     * civilite du contact
     */
    private String cotCivilContact;


    /**
     * serie
     */
    private String cotSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer cotExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer cotExoDouane;


    /**
     * categorie du fournisseur
     */
    private String cotCat;


    /**
     * code devise
     */
    private String cotDevise;


    /**
     * objet
     */
    private String cotObject;


    /**
     * observation
     */
    private String cotObservation;


    /**
     * code budget
     */
    private String cotBudget;


    /**
     * total ht
     */
    private Double cotTotHt;


    /**
     * total remise
     */
    private Double cotTotRemise;


    /**
     * budget treso
     */
    private Double cotBudgetTreso;


    /**
     * budget dispo
     */
    private Double cotBudgetDispo;


    /**
     * budget mensuel dispo
     */
    private Double cotBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double cotBudgetTresoMois;


    /**
     * total rabais
     */
    private Double cotTotRabais;


    /**
     * ttal tva
     */
    private Double cotTotTva;


    /**
     * total taxe complementaire
     */
    private Double cotTotTc;


    /**
     * total ttc
     */
    private Double cotTotTtc;


    /**
     * nom de la banque + numero de compte
     */
    private String cotBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer cotTypeReg;


    /**
     * mode de reglement xml
     */
    private String cotModeReg;


    /**
     * nombre de jour
     */
    private Integer cotNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer cotArrondiReg;


    /**
     * condition de reglement
     */
    private String cotConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate cotDateEcheReg;


    /**
     * code activite
     */
    private String cotActivite;


    /**
     * code site
     */
    private String cotSite;


    /**
     * code departement
     */
    private String cotDepartement;


    /**
     * code service
     */
    private String cotService;


    /**
     * code region
     */
    private String cotRegion;


    /**
     * code secteur
     */
    private String cotSecteur;


    /**
     * code point de vente
     */
    private String cotPdv;


    /**
     * code analytique 2
     */
    private String cotAnal2;


    /**
     * code analytique 4
     */
    private String cotAnal4;


    /**
     * info 1
     */
    private String cotInfo1;


    /**
     * info 2
     */
    private String cotInfo2;


    /**
     * info 3
     */
    private String cotInfo3;


    /**
     * info 4
     */
    private String cotInfo4;


    /**
     * info 5
     */
    private String cotInfo5;


    /**
     * info 6
     */
    private String cotInfo6;


    /**
     * info 7
     */
    private String cotInfo7;


    /**
     * info 8
     */
    private String cotInfo8;


    /**
     * info 9
     */
    private String cotInfo9;


    /**
     * info 10
     */
    private String cotInfo10;


    /**
     * code formule 1
     */
    private String cotFormule1;


    /**
     * code formule 2
     */
    private String cotFormule2;


    /**
     * nom jasper de l annexe 1
     */
    private String cotAnnexe1;


    /**
     * nom jasper de l annexe 2
     */
    private String cotAnnexe2;


    /**
     * code contrat
     */
    private String cotContrat;


    /**
     * code incoterm
     */
    private String cotIncoterm;


    /**
     * lieu de livraison
     */
    private String cotLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate cotDateLivraison;


    /**
     * info sur la livraison
     */
    private String cotInfoLivraison;


    /**
     * date impression
     */
    private LocalDate cotDateImp;


    /**
     * nom jasper du modele
     */
    private String cotModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer cotEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer cotGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    private Integer cotEtat;


    /**
     * date de validite
     */
    private LocalDate cotDateValidite;


    /**
     * date de relance
     */
    private LocalDate cotDateRelance;


    /**
     * date de validation
     */
    private LocalDate cotDateValide;


    /**
     * date de transformation
     */
    private LocalDate cotDateTransforme;


    /**
     * type de transformation
     */
    private Integer cotTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate cotDateAnnule;


    /**
     * motif annulation
     */
    private String cotMotifAnnule;

    private Long exeachId;

    private Long tieId;

    private Long usrId;


    /**
     * 0=normal 99= divers
     */
    private Integer cotDiversTiers;


    /**
     * nom du tiers divers
     */
    private String cotDiversNom;


    /**
     * adresse du tiers divers
     */
    private String cotDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String cotDiversVille;


    /**
     * telephone du tiers divers
     */
    private String cotDiversTel;


    /**
     * mail du tiers divers
     */
    private String cotDiversMail;

}
