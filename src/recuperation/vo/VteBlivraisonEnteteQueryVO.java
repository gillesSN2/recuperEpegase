package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VteBlivraisonEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long blvId;


    /**
     * date de creation
     */
    private LocalDateTime blvDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime blvDateModif;


    /**
     * id user createur
     */
    private Long blvIdCreateur;


    /**
     * nom du createur
     */
    private String blvNomCreateur;


    /**
     * id user de modification
     */
    private Long blvIdModif;


    /**
     * nom user de modification
     */
    private String blvNomModif;


    /**
     * 0=fermer 1=ouvert
     */
    private Integer blvMaj;


    /**
     * date du bon de livraison
     */
    private LocalDateTime blvDate;


    /**
     * numero du bon de livraison
     */
    private String blvNum;


    /**
     * nom du commercial
     */
    private String blvNomResponsable;


    /**
     * id du commercial
     */
    private Long blvIdResponsable;


    /**
     * nom du client
     */
    private String blvNomTiers;


    /**
     * civilite du tiers
     */
    private String blvCivilTiers;


    /**
     * id du contact
     */
    private Long blvIdContact;


    /**
     * nom du contact
     */
    private String blvNomContact;


    /**
     * civilite du contact
     */
    private String blvCivilContact;


    /**
     * serie
     */
    private String blvSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer blvExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer blvExoDouane;


    /**
     * categorie du client
     */
    private String blvCat;


    /**
     * code devise
     */
    private String blvDevise;


    /**
     * objet
     */
    private String blvObject;


    /**
     * observation
     */
    private String blvObservation;


    /**
     * code budget
     */
    private String blvBudget;


    /**
     * total ht
     */
    private Double blvTotHt;


    /**
     * total remise
     */
    private Double blvTotRemise;


    /**
     * total rabais
     */
    private Double blvTotRabais;


    /**
     * ttal tva
     */
    private Double blvTotTva;


    /**
     * taux taxe complementaire
     */
    private Float blvTauxTc;


    /**
     * total taxe complementaire
     */
    private Double blvTotTc;


    /**
     * total ttc
     */
    private Double blvTotTtc;


    /**
     * total reglement
     */
    private Double blvTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer blvSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String blvBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer blvTypeReg;


    /**
     * mode de reglement xml
     */
    private String blvModeReg;


    /**
     * nombre de jour
     */
    private Integer blvNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer blvArrondiReg;


    /**
     * condition de reglement
     */
    private String blvConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate blvDateEcheReg;


    /**
     * code journal des reglements
     */
    private String blvJournalReg;


    /**
     * code activite
     */
    private String blvActivite;


    /**
     * code site
     */
    private String blvSite;


    /**
     * code departement
     */
    private String blvDepartement;


    /**
     * code service
     */
    private String blvService;


    /**
     * code region
     */
    private String blvRegion;


    /**
     * code secteur
     */
    private String blvSecteur;


    /**
     * code point de vente
     */
    private String blvPdv;


    /**
     * code analytique 2
     */
    private String blvAnal2;


    /**
     * code analytique 4
     */
    private String blvAnal4;


    /**
     * info 1
     */
    private String blvInfo1;


    /**
     * info 2
     */
    private String blvInfo2;


    /**
     * info 3
     */
    private String blvInfo3;


    /**
     * info 4
     */
    private String blvInfo4;


    /**
     * info 5
     */
    private String blvInfo5;


    /**
     * info 6
     */
    private String blvInfo6;


    /**
     * info 7
     */
    private String blvInfo7;


    /**
     * info 8
     */
    private String blvInfo8;


    /**
     * info 9
     */
    private String blvInfo9;


    /**
     * info 10
     */
    private String blvInfo10;


    /**
     * code formule 1
     */
    private String blvFormule1;


    /**
     * code formule 2
     */
    private String blvFormule2;


    /**
     * nom jasper de l annexe 1
     */
    private String blvAnnexe1;


    /**
     * nom jasper de l annexe 2
     */
    private String blvAnnexe2;


    /**
     * code contrat
     */
    private String blvContrat;


    /**
     * code incoterm
     */
    private String blvIncoterm;


    /**
     * lieu de livraison
     */
    private String blvLieuLivraison;


    /**
     * date de livraison
     */
    private LocalDate blvDateLivraison;


    /**
     * info sur la livraison
     */
    private String blvInfoLivraison;


    /**
     * date impression
     */
    private LocalDate blvDateImp;


    /**
     * nom jasper du modele
     */
    private String blvModeleImp;


    /**
     * nom jasper page de garde
     */
    private String blvGarde;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer blvEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer blvGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    private Integer blvEtat;


    /**
     * date de validite
     */
    private LocalDate blvDateValidite;


    /**
     * date de relance
     */
    private LocalDate blvDateRelance;


    /**
     * date de validation
     */
    private LocalDate blvDateValide;


    /**
     * date de transformation
     */
    private LocalDate blvDateTransforme;


    /**
     * type de transformation
     */
    private Integer blvTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate blvDateAnnule;


    /**
     * motif annulation
     */
    private String blvMotifAnnule;


    /**
     * date de facturation
     */
    private LocalDate blvDateFacture;


    /**
     * nom du factor
     */
    private String blvFactorNom;


    /**
     * id du factor
     */
    private Long blvFactorId;


    /**
     * 0=en cours 1=accepter 2=refuser
     */
    private Integer blvFactorEtat;


    /**
     * 0=normal 99= divers
     */
    private Integer blvDiversTiers;


    /**
     * nom du tiers divers
     */
    private String blvDiversNom;


    /**
     * adresse du tiers divers
     */
    private String blvDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String blvDiversVille;


    /**
     * telephone du tiers divers
     */
    private String blvDiversTel;


    /**
     * mail du tiers divers
     */
    private String blvDiversMail;

    private Long exevteId;

    private Long tieId;

    private Long usrId;


    /**
     * nom du commercial
     */
    private String blvNomCommercial;


    /**
     * id du commercial
     */
    private Long blvIdCommercial;


    /**
     * memorisation numero facture
     */
    private String blvMemoNumFacture;


    /**
     * nom equipe
     */
    private String blvNomEquipe;


    /**
     * id equipe
     */
    private Long blvIdEquipe;


    /**
     * numero facture
     */
    private String blvoNumFacture;


    /**
     * 0=En cours 1=livree partiel 2=livree total
     */
    private Integer blvLivreeEtat;


    /**
     * 0=sans livreur 1=avec livreur
     */
    private Integer blvLivreur;


    /**
     * taux remise globale
     */
    private Float blvTauxRemise;


    /**
     * source du document
     */
    private String blvSource;

}
