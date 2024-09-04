package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteDevisEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long dvsId;


    /**
     * date de creation
     */
    private LocalDateTime dvsDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime dvsDateModif;


    /**
     * id user createur
     */
    private Long dvsIdCreateur;


    /**
     * nom du createur
     */
    private String dvsNomCreateur;


    /**
     * id user de modification
     */
    private Long dvsIdModif;


    /**
     * nom user de modification
     */
    private String dvsNomModif;


    /**
     * date du devis
     */
    private LocalDateTime dvsDate;


    /**
     * numero devis
     */
    private String dvsNum;


    /**
     * nom du commercial
     */
    private String dvsNomResponsable;


    /**
     * id du commercial
     */
    private Long dvsIdResponsable;


    /**
     * nom du client
     */
    private String dvsNomTiers;


    /**
     * civilite du tiers
     */
    private String dvsCivilTiers;


    /**
     * id du contact
     */
    private Long dvsIdContact;


    /**
     * nom du contact ou destinataire
     */
    private String dvsNomContact;


    /**
     * civilite du contact
     */
    private String dvsCivilContact;


    /**
     * serie A, B, C, D ou X
     */
    private String dvsSerie;


    /**
     * 0=avec tva 1=sans tva
     */
    private Integer dvsExoTva;


    /**
     * 0=avec douane 1=sans douane
     */
    private Integer dvsExoDouane;


    /**
     * categorie du client
     */
    private String dvsCat;


    /**
     * code devise
     */
    private String dvsDevise;


    /**
     * objet
     */
    private String dvsObject;


    /**
     * observation
     */
    private String dvsObservation;


    /**
     * total ht
     */
    private Double dvsTotHt;


    /**
     * total remise
     */
    private Double dvsTotRemise;


    /**
     * total rabais
     */
    private Double dvsTotRabais;


    /**
     * ttal tva
     */
    private Double dvsTotTva;


    /**
     * taux taxe complementaire
     */
    private Float dvsTauxTc;


    /**
     * total taxe complementaire
     */
    private Double dvsTotTc;


    /**
     * total ttc
     */
    private Double dvsTotTtc;


    /**
     * total reglement
     */
    private Double dvsTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer dvsSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String dvsBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement 5=demande credit
     */
    private Integer dvsTypeReg;


    /**
     * mode de reglement xml
     */
    private String dvsModeReg;


    /**
     * date echeance reliquat si type reg = 5
     */
    private LocalDate dvsEcheanceReliquat;


    /**
     * motif du rejet accord du credit
     */
    private String dvsMotifRejetCredit;


    /**
     * nombre de jour
     */
    private Integer dvsNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer dvsArrondiReg;


    /**
     * condition de reglement
     */
    private String dvsConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate dvsDateEcheReg;


    /**
     * code journal des reglements
     */
    private String dvsJournalReg;


    /**
     * code activite
     */
    private String dvsActivite;


    /**
     * code site
     */
    private String dvsSite;


    /**
     * code departement
     */
    private String dvsDepartement;


    /**
     * code service
     */
    private String dvsService;


    /**
     * code region
     */
    private String dvsRegion;


    /**
     * code secteur
     */
    private String dvsSecteur;


    /**
     * code point de vente
     */
    private String dvsPdv;


    /**
     * code analytique 2 (parc)
     */
    private String dvsAnal2;


    /**
     * code analytique 4 (dossier)
     */
    private String dvsAnal4;


    /**
     * info 1
     */
    private String dvsInfo1;


    /**
     * info 2
     */
    private String dvsInfo2;


    /**
     * info 3
     */
    private String dvsInfo3;


    /**
     * info 4
     */
    private String dvsInfo4;


    /**
     * info 5
     */
    private String dvsInfo5;


    /**
     * info 6
     */
    private String dvsInfo6;


    /**
     * info 7
     */
    private String dvsInfo7;


    /**
     * info 8
     */
    private String dvsInfo8;


    /**
     * info 9
     */
    private String dvsInfo9;


    /**
     * info 10
     */
    private String dvsInfo10;


    /**
     * code formule 1
     */
    private String dvsFormule1;


    /**
     * code formule 2
     */
    private String dvsFormule2;


    /**
     * nom jasper du modele annexe 1
     */
    private String dvsAnnexe1;


    /**
     * nom jasper du modele annexe 2
     */
    private String dvsAnnexe2;


    /**
     * code contrat
     */
    private String dvsContrat;


    /**
     * code incoterm
     */
    private String dvsIncoterm;


    /**
     * lieu de livraison
     */
    private String dvsLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate dvsDateLivraison;


    /**
     * info sur la livraison
     */
    private String dvsInfoLivraison;


    /**
     * date impression
     */
    private LocalDateTime dvsDateImp;


    /**
     * nom jasper du modele
     */
    private String dvsModeleImp;


    /**
     * nom jasper du modele page de garde
     */
    private String dvsGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer dvsEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer dvsGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme partiel 5=transforme total
     */
    private Integer dvsEtat;


    /**
     * date de validite
     */
    private LocalDate dvsDateValidite;


    /**
     * date de relance
     */
    private LocalDate dvsDateRelance;


    /**
     * date de validation
     */
    private LocalDateTime dvsDateValide;


    /**
     * date de transformation
     */
    private LocalDateTime dvsDateTransforme;


    /**
     * type de transformation
     */
    private Integer dvsTypeTransforme;


    /**
     * date annulation
     */
    private LocalDateTime dvsDateAnnule;


    /**
     * motif annulation
     */
    private String dvsMotifAnnule;


    /**
     * nom du factor
     */
    private String dvsFactorNom;


    /**
     * id du factor
     */
    private Long dvsFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer dvsFactorEtat;


    /**
     * beneficiaires
     */
    private String dvsBeneficiaire;


    /**
     * numero accord
     */
    private String dvsAccord;


    /**
     * regime
     */
    private String dvsRegime;


    /**
     * bureau
     */
    private String dvsBureau;


    /**
     * pays origine
     */
    private String dvsPays;


    /**
     * utilisation
     */
    private String dvsUtilisation;


    /**
     * fournisseur
     */
    private String dvsFournisseur;


    /**
     * 0=normal 99= divers
     */
    private Integer dvsDiversTiers;


    /**
     * nom du tiers divers
     */
    private String dvsDiversNom;


    /**
     * adresse du tiers divers
     */
    private String dvsDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String dvsDiversVille;


    /**
     * telephone du tiers divers
     */
    private String dvsDiversTel;


    /**
     * mail du tiers divers
     */
    private String dvsDiversMail;

    private Long exevteId;

    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String dvsNomCommercial;


    /**
     * id du commercial
     */
    private Long dvsIdCommercial;


    /**
     * nom equipe
     */
    private String dvsNomEquipe;


    /**
     * id equipe
     */
    private Long dvsIdEquipe;


    /**
     * taux remise globale
     */
    private Float dvsTauxRemise;


    /**
     * source du document
     */
    private String dvsSource;

}
