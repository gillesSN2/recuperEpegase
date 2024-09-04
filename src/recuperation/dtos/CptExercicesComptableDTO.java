package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CptExercicesComptableDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long execptId;


    /**
     * date de creation exercice
     */
    private LocalDateTime execptDateCreat;


    /**
     * date de modification exercice
     */
    private LocalDateTime execptDateModif;


    /**
     * date de cloture exercice
     */
    private LocalDateTime execptDateCloture;


    /**
     * utilisateur de creation exericce
     */
    private Long execptUserCreat;


    /**
     * utilisateur qui a fait la cloture
     */
    private Long execptUserCloture;


    /**
     * utilisateur de modification exercice
     */
    private Long execptUserModif;


    /**
     * date de debut exercice
     */
    private LocalDate execptDateDebut;


    /**
     * date de fin de exercice
     */
    private LocalDate execptDateFin;


    /**
     * 0=exercice en cours 1=exercice cloture
     */
    private Integer execptEtat;


    /**
     * date de debut des etats financiers
     */
    private LocalDate execptEtDateDebut;


    /**
     * date de fin des etats financiers
     */
    private LocalDate execptEtDateFin;


    /**
     * date de debut des tableaux de bord
     */
    private LocalDate execptTbDateDebut;


    /**
     * date de fin des tableaux de bord
     */
    private LocalDate execptTbDateFin;


    /**
     * inclu les journaux de situation
     */
    private Boolean execptJrxSit;


    /**
     * inclu les journaux reserves
     */
    private Boolean execptJrxRsv;


    /**
     * date de creation entreprise
     */
    private LocalDate execptDateCreationEntreprise;


    /**
     * annee de premiere activite dans le pays
     */
    private String execptAnneeActivitePays;


    /**
     * nombre etablissements dans le pays
     */
    private Integer execptNbEtablissementPays;


    /**
     * nombre etablissements hors du pays
     */
    private Integer execptNbEtablissementHors;


    /**
     * entreprise sous le controle public
     */
    private Boolean execptCtrlPublique;


    /**
     * entreprise sous le controle prive local
     */
    private Boolean execptCtrlPriveLoc;


    /**
     * entreprise sous le controle prive etranger
     */
    private Boolean execptCtrlPriveEtr;


    /**
     * date cloture precedente
     */
    private LocalDate execptDateClotPrec;


    /**
     * duree exercice precedente
     */
    private Integer execptDureePrec;


    /**
     * date arrete des comptes
     */
    private LocalDate execptDateArretCompte;


    /**
     * code activite principale
     */
    private String execptCodeActivite;


    /**
     * libelle activite principale
     */
    private String execptLibActivite;


    /**
     * capacite de production utilisee
     */
    private Integer execptCapProduction;


    /**
     * numero agrement
     */
    private String execptAgrement;


    /**
     * date d agrement
     */
    private String execptDateAgrement;


    /**
     * duree de l agrement
     */
    private String execptDureeAgrement;


    /**
     * nom de la convention
     */
    private String execptConvention;


    /**
     * 0=privee 1=publique 2=etrangere
     */
    private Integer execptTypeEntreprise;


    /**
     * 1=regime normal 2=regime simplifie 3=synthetique 4=forfait
     */
    private Integer execptRegime;


    /**
     * numero du centre d impot
     */
    private String execptCentreImpot;


    /**
     * inscription
     */
    private String execptInscription;


    /**
     * 0=sans analytique 1=avec analytique
     */
    private Boolean execptAnalytique;


    /**
     * nom du comptable
     */
    private String execptNomComptable;


    /**
     * adresse du comptable
     */
    private String execptAdresseComptable;


    /**
     * ville du comptable
     */
    private String execptVilleComptable;


    /**
     * est-ce que le comptable est salarie ?
     */
    private Boolean execptSalarieComptable;


    /**
     * telephone du comptable
     */
    private String execptTelephoneComptable;


    /**
     * nom du contact
     */
    private String execptNomContact;


    /**
     * adresse du contact
     */
    private String execptAdresseContact;


    /**
     * ville du contact
     */
    private String execptVilleContact;


    /**
     * telephone du contact
     */
    private String execptTelephoneContact;


    /**
     * qualite du contact
     */
    private String execptQuaContact;


    /**
     * nom du cabinet
     */
    private String execptNomCabinet;


    /**
     * adresse du cabinet
     */
    private String execptAdresseCabinet;


    /**
     * ville du cabinet
     */
    private String execptVilleCabinet;


    /**
     * telephone du cabinet
     */
    private String execptTelephoneCabinet;


    /**
     * nom du commissaire aux comptes
     */
    private String execptNomCommissaire;


    /**
     * adresse du commissaire aux comptes
     */
    private String execptAdresseCommissaire;


    /**
     * ville du commissaire aux comptes
     */
    private String execptVilleCommissaire;


    /**
     * telephone du commissaire aux comptes
     */
    private String execptTelephoneCommissaire;


    /**
     * nom du signataire des etats financiers
     */
    private String execptNomSignataire;


    /**
     * qualite du signataire
     */
    private String execptQuaSignataire;


    /**
     * 1=certification non assujetti
     */
    private Boolean execptEfcna;


    /**
     * 1=certification refuse
     */
    private Boolean execptEfcr;


    /**
     * 1=certification accepte avec reserve
     */
    private Boolean execptEfcar;


    /**
     * 1=approvation sans reserve
     */
    private Boolean execptEfasr;


    /**
     * 1=approvation non assujetti
     */
    private Boolean execptEfana;


    /**
     * 1=non approuve
     */
    private Boolean execptEfanap;


    /**
     * 1=approvation
     */
    private Boolean execptEfaap;


    /**
     * 0=exercice en cours 1=exercice cloture provisoire 2=cloture definitive
     */
    private Integer execptEtatAnterieur;


    /**
     * true si liasse cloturee
     */
    private Boolean execptLiasse;


    /**
     * le resultat est il affecte
     */
    private Boolean execptResltatAffecte;

}
