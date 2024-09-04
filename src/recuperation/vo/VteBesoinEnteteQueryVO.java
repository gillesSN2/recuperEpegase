package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteBesoinEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long besId;


    /**
     * date de creation
     */
    private LocalDateTime besDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime besDateModif;


    /**
     * id user createur
     */
    private Long besIdCreateur;


    /**
     * nom du createur
     */
    private String besNomCreateur;


    /**
     * id user de modification
     */
    private Long besIdModif;


    /**
     * nom user de modification
     */
    private String besNomModif;


    /**
     * date du devis
     */
    private LocalDateTime besDate;


    /**
     * numero devis
     */
    private String besNum;


    /**
     * nom du commercial
     */
    private String besNomResponsable;


    /**
     * id du commercial
     */
    private Long besIdResponsable;


    /**
     * nom du commercial
     */
    private String besNomCommercial;


    /**
     * id du commercial
     */
    private Long besIdCommercial;


    /**
     * code campagne
     */
    private String besNumCampagne;


    /**
     * id du campagne
     */
    private Long besIdCampagne;


    /**
     * nom du client
     */
    private String besNomTiers;


    /**
     * civilite du tiers
     */
    private String besCivilTiers;


    /**
     * id du contact
     */
    private Long besIdContact;


    /**
     * nom du contact ou destinataire
     */
    private String besNomContact;


    /**
     * civilite du contact
     */
    private String besCivilContact;


    /**
     * serie A, B, C, D ou X
     */
    private String besSerie;


    /**
     * 0=avec tva 1=sans tva
     */
    private Integer besExoTva;


    /**
     * 0=avec douane 1=sans douane
     */
    private Integer besExoDouane;


    /**
     * categorie du tarif
     */
    private String besCat;


    /**
     * code devise
     */
    private String besDevise;


    /**
     * objet
     */
    private String besObject;


    /**
     * observation
     */
    private String besObservation;


    /**
     * total ht
     */
    private Double besTotHt;


    /**
     * total remise
     */
    private Double besTotRemise;


    /**
     * total rabais
     */
    private Double besTotRabais;


    /**
     * ttal tva
     */
    private Double besTotTva;


    /**
     * taux taxe complementaire
     */
    private Float besTauxTc;


    /**
     * total taxe complementaire
     */
    private Double besTotTc;


    /**
     * total ttc
     */
    private Double besTotTtc;


    /**
     * total reglement
     */
    private Double besTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer besSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String besBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement 5=demande credit
     */
    private Integer besTypeReg;


    /**
     * mode de reglement xml
     */
    private String besModeReg;


    /**
     * date echeance reliquat si type reg = 5
     */
    private LocalDate besEcheanceReliquat;


    /**
     * motif du rejet accord du credit
     */
    private String besMotifRejetCredit;


    /**
     * nombre de jour
     */
    private Integer besNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer besArrondiReg;


    /**
     * condition de reglement
     */
    private String besConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate besDateEcheReg;


    /**
     * code journal des reglements
     */
    private String besJournalReg;


    /**
     * code activite
     */
    private String besActivite;


    /**
     * code site
     */
    private String besSite;


    /**
     * code departement
     */
    private String besDepartement;


    /**
     * code service
     */
    private String besService;


    /**
     * code region
     */
    private String besRegion;


    /**
     * code secteur
     */
    private String besSecteur;


    /**
     * code point de vente
     */
    private String besPdv;


    /**
     * code analytique 2 (parc)
     */
    private String besAnal2;


    /**
     * code analytique 4 (dossier)
     */
    private String besAnal4;


    /**
     * date impression
     */
    private LocalDateTime besDateImp;


    /**
     * nom jasper du modele
     */
    private String besModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer besEtatVal;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    private Integer besEtat;


    /**
     * date de validite
     */
    private LocalDate besDateValidite;


    /**
     * date de relance
     */
    private LocalDate besDateRelance;


    /**
     * date de validation
     */
    private LocalDateTime besDateValide;


    /**
     * date de transformation
     */
    private LocalDateTime besDateTransforme;


    /**
     * type de transformation
     */
    private Integer besTypeTransforme;


    /**
     * date annulation
     */
    private LocalDateTime besDateAnnule;


    /**
     * motif annulation
     */
    private String besMotifAnnule;


    /**
     * 0=normal 99= divers
     */
    private Integer besDiversTiers;


    /**
     * nom du tiers divers
     */
    private String besDiversNom;


    /**
     * adresse du tiers divers
     */
    private String besDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String besDiversVille;


    /**
     * telephone du tiers divers
     */
    private String besDiversTel;


    /**
     * mail du tiers divers
     */
    private String besDiversMail;

    private Long exevteId;

    private Long tieId;

    private Long usrId;


    /**
     * nom equipe
     */
    private String besNomEquipe;


    /**
     * id equipe
     */
    private Long besIdEquipe;

}
