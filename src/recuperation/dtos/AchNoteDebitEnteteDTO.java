package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchNoteDebitEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ndfId;


    /**
     * date de creation
     */
    private LocalDateTime ndfDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime ndfDateModif;


    /**
     * id user createur
     */
    private Long ndfIdCreateur;


    /**
     * nom du createur
     */
    private String ndfNomCreateur;


    /**
     * id user de modification
     */
    private Long ndfIdModif;


    /**
     * nom user de modification
     */
    private String ndfNomModif;


    /**
     * date de la note de debit
     */
    private LocalDateTime ndfDate;


    /**
     * numero note de debit
     */
    private String ndfNum;


    /**
     * numero valorisation
     */
    private String ndfValo;


    /**
     * nom du commercial
     */
    private String ndfNomResponsable;


    /**
     * id du commercial
     */
    private Long ndfIdResponsable;


    /**
     * nom du fournisseur
     */
    private String ndfNomTiers;


    /**
     * civilite du tiers
     */
    private String ndfCivilTiers;


    /**
     * id du contact
     */
    private Long ndfIdContact;


    /**
     * nom du contact
     */
    private String ndfNomContact;


    /**
     * civilite du contact
     */
    private String ndfCivilContact;


    /**
     * serie
     */
    private String ndfSerie;


    /**
     * 0=avec Tva 1=sans Tva
     */
    private Integer ndfExoTva;


    /**
     * 0=avec Douane 1=sans Douane
     */
    private Integer ndfExoDouane;


    /**
     * categorie du fournisseur
     */
    private String ndfCat;


    /**
     * code devise
     */
    private String ndfDevise;


    /**
     * objet
     */
    private String ndfObject;


    /**
     * observation
     */
    private String ndfObservation;


    /**
     * code budget
     */
    private String ndfBudget;


    /**
     * montant disponible sur budget
     */
    private Double ndfBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double ndfBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double ndfBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double ndfBudgetTresoMois;


    /**
     * total ht
     */
    private Double ndfTotHt;


    /**
     * total remise
     */
    private Double ndfTotRemise;


    /**
     * total rabais
     */
    private Double ndfTotRabais;


    /**
     * ttal tva
     */
    private Double ndfTotTva;


    /**
     * total taxe complementaire
     */
    private Double ndfTotTc;


    /**
     * total ttc
     */
    private Double ndfTotTtc;


    /**
     * total reglement
     */
    private Double ndfTotReglement;


    /**
     * 0=non solde 1=solde
     */
    private Integer ndfSolde;


    /**
     * nom de la banque + numero de compte
     */
    private String ndfBanque;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/payee 4=bon encaissement
     */
    private Integer ndfTypeReg;


    /**
     * mode de reglement xml
     */
    private String ndfModeReg;


    /**
     * nombre de jour
     */
    private Integer ndfNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer ndfArrondiReg;


    /**
     * condition de reglement
     */
    private String ndfConditionReg;


    /**
     * date echeance de reglement
     */
    private LocalDate ndfDateEcheReg;


    /**
     * code journal des reglements
     */
    private String ndfJournalReg;


    /**
     * code activite
     */
    private String ndfActivite;


    /**
     * code site
     */
    private String ndfSite;


    /**
     * code departement
     */
    private String ndfDepartement;


    /**
     * code service
     */
    private String ndfService;


    /**
     * code region
     */
    private String ndfRegion;


    /**
     * code secteur
     */
    private String ndfSecteur;


    /**
     * code point de vente
     */
    private String ndfPdv;


    /**
     * code analytique 2
     */
    private String ndfAnal2;


    /**
     * code analytique 4
     */
    private String ndfAnal4;


    /**
     * info 1
     */
    private String ndfInfo1;


    /**
     * info 2
     */
    private String ndfInfo2;


    /**
     * info 3
     */
    private String ndfInfo3;


    /**
     * info 4
     */
    private String ndfInfo4;


    /**
     * info 5
     */
    private String ndfInfo5;


    /**
     * info 6
     */
    private String ndfInfo6;


    /**
     * info 7
     */
    private String ndfInfo7;


    /**
     * info 8
     */
    private String ndfInfo8;


    /**
     * info 9
     */
    private String ndfInfo9;


    /**
     * info 10
     */
    private String ndfInfo10;


    /**
     * code formule 1
     */
    private String ndfFormule1;


    /**
     * code formule 2
     */
    private String ndfFormule2;


    /**
     * nom jasper anexe 1
     */
    private String ndfAnnexe1;


    /**
     * nom jasper anexe 2
     */
    private String ndfAnnexe2;


    /**
     * code contrat
     */
    private String ndfContrat;


    /**
     * date impression
     */
    private LocalDate ndfDateImp;


    /**
     * nom jasper du modele
     */
    private String ndfModeleImp;


    /**
     * 0=sans validation 1=avecc validation
     */
    private Integer ndfEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer ndfGele;


    /**
     * 0=En cour
     */
    private Integer ndfEtat;


    /**
     * date de validite
     */
    private LocalDate ndfDateValidite;


    /**
     * date de relance
     */
    private LocalDate ndfDateRelance;


    /**
     * date de validation
     */
    private LocalDate ndfDateValide;


    /**
     * date de transformation
     */
    private LocalDate ndfDateTransforme;


    /**
     * type de transformation
     */
    private Integer ndfTypeTransforme;


    /**
     * date annulation
     */
    private LocalDate ndfDateAnnule;


    /**
     * motif annulation
     */
    private String ndfMotifAnnule;


    /**
     * date transfert en compta
     */
    private LocalDate ndfDateTransfert;

    private Long exeachId;

    private Long tieId;

    private Long usrId;


    /**
     * 0=normal 99= divers
     */
    private Integer ndfDiversTiers;


    /**
     * nom du tiers divers
     */
    private String ndfDiversNom;


    /**
     * adresse du tiers divers
     */
    private String ndfDiversAdresse;


    /**
     * ville du tiers divers
     */
    private String ndfDiversVille;


    /**
     * telephone du tiers divers
     */
    private String ndfDiversTel;


    /**
     * mail du tiers divers
     */
    private String ndfDiversMail;


    /**
     * numero de transfert
     */
    private String ndfNumTrf;

}
