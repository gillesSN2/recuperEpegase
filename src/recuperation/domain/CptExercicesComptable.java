package recuperation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_exercices_comptable")
public class CptExercicesComptable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

    /**
     * date de creation exercice
     */
    @Column(name = "execpt_date_creat")
    private LocalDateTime execptDateCreat;

    /**
     * date de modification exercice
     */
    @Column(name = "execpt_date_modif")
    private LocalDateTime execptDateModif;

    /**
     * date de cloture exercice
     */
    @Column(name = "execpt_date_cloture")
    private LocalDateTime execptDateCloture;

    /**
     * utilisateur de creation exericce
     */
    @Column(name = "execpt_user_creat")
    private Long execptUserCreat = 0L;

    /**
     * utilisateur qui a fait la cloture
     */
    @Column(name = "execpt_user_cloture")
    private Long execptUserCloture = 0L;

    /**
     * utilisateur de modification exercice
     */
    @Column(name = "execpt_user_modif")
    private Long execptUserModif = 0L;

    /**
     * date de debut exercice
     */
    @Column(name = "execpt_date_debut")
    private LocalDate execptDateDebut;

    /**
     * date de fin de exercice
     */
    @Column(name = "execpt_date_fin")
    private LocalDate execptDateFin;

    /**
     * 0=exercice en cours 1=exercice cloture
     */
    @Column(name = "execpt_etat")
    private Integer execptEtat = 0;

    /**
     * date de debut des etats financiers
     */
    @Column(name = "execpt_et_date_debut")
    private LocalDate execptEtDateDebut;

    /**
     * date de fin des etats financiers
     */
    @Column(name = "execpt_et_date_fin")
    private LocalDate execptEtDateFin;

    /**
     * date de debut des tableaux de bord
     */
    @Column(name = "execpt_tb_date_debut")
    private LocalDate execptTbDateDebut;

    /**
     * date de fin des tableaux de bord
     */
    @Column(name = "execpt_tb_date_fin")
    private LocalDate execptTbDateFin;

    /**
     * inclu les journaux de situation
     */
    @Column(name = "execpt_jrx_sit")
    private Boolean execptJrxSit = Boolean.FALSE;

    /**
     * inclu les journaux reserves
     */
    @Column(name = "execpt_jrx_rsv")
    private Boolean execptJrxRsv = Boolean.FALSE;

    /**
     * date de creation entreprise
     */
    @Column(name = "execpt_date_creation_entreprise")
    private LocalDate execptDateCreationEntreprise;

    /**
     * annee de premiere activite dans le pays
     */
    @Column(name = "execpt_annee_activite_pays")
    private String execptAnneeActivitePays;

    /**
     * nombre etablissements dans le pays
     */
    @Column(name = "execpt_nb_etablissement_pays")
    private Integer execptNbEtablissementPays = 0;

    /**
     * nombre etablissements hors du pays
     */
    @Column(name = "execpt_nb_etablissement_hors")
    private Integer execptNbEtablissementHors = 0;

    /**
     * entreprise sous le controle public
     */
    @Column(name = "execpt_ctrl_publique")
    private Boolean execptCtrlPublique = Boolean.FALSE;

    /**
     * entreprise sous le controle prive local
     */
    @Column(name = "execpt_ctrl_prive_loc")
    private Boolean execptCtrlPriveLoc = Boolean.FALSE;

    /**
     * entreprise sous le controle prive etranger
     */
    @Column(name = "execpt_ctrl_prive_etr")
    private Boolean execptCtrlPriveEtr = Boolean.FALSE;

    /**
     * date cloture precedente
     */
    @Column(name = "execpt_date_clot_prec")
    private LocalDate execptDateClotPrec;

    /**
     * duree exercice precedente
     */
    @Column(name = "execpt_duree_prec")
    private Integer execptDureePrec = 0;

    /**
     * date arrete des comptes
     */
    @Column(name = "execpt_date_arret_compte")
    private LocalDate execptDateArretCompte;

    /**
     * code activite principale
     */
    @Column(name = "execpt_code_activite")
    private String execptCodeActivite;

    /**
     * libelle activite principale
     */
    @Column(name = "execpt_lib_activite")
    private String execptLibActivite;

    /**
     * capacite de production utilisee
     */
    @Column(name = "execpt_cap_production")
    private Integer execptCapProduction = 0;

    /**
     * numero agrement
     */
    @Column(name = "execpt_agrement")
    private String execptAgrement;

    /**
     * date d agrement
     */
    @Column(name = "execpt_date_agrement")
    private String execptDateAgrement;

    /**
     * duree de l agrement
     */
    @Column(name = "execpt_duree_agrement")
    private String execptDureeAgrement;

    /**
     * nom de la convention
     */
    @Column(name = "execpt_convention")
    private String execptConvention;

    /**
     * 0=privee 1=publique 2=etrangere
     */
    @Column(name = "execpt_type_entreprise")
    private Integer execptTypeEntreprise = 0;

    /**
     * 1=regime normal 2=regime simplifie 3=synthetique 4=forfait
     */
    @Column(name = "execpt_regime")
    private Integer execptRegime = 0;

    /**
     * numero du centre d impot
     */
    @Column(name = "execpt_centre_impot")
    private String execptCentreImpot;

    /**
     * inscription
     */
    @Column(name = "execpt_inscription")
    private String execptInscription;

    /**
     * 0=sans analytique 1=avec analytique
     */
    @Column(name = "execpt_analytique")
    private Boolean execptAnalytique = Boolean.FALSE;

    /**
     * nom du comptable
     */
    @Column(name = "execpt_nom_comptable")
    private String execptNomComptable;

    /**
     * adresse du comptable
     */
    @Column(name = "execpt_adresse_comptable")
    private String execptAdresseComptable;

    /**
     * ville du comptable
     */
    @Column(name = "execpt_ville_comptable")
    private String execptVilleComptable;

    /**
     * est-ce que le comptable est salarie ?
     */
    @Column(name = "execpt_salarie_comptable")
    private Boolean execptSalarieComptable = Boolean.FALSE;

    /**
     * telephone du comptable
     */
    @Column(name = "execpt_telephone_comptable")
    private String execptTelephoneComptable;

    /**
     * nom du contact
     */
    @Column(name = "execpt_nom_contact")
    private String execptNomContact;

    /**
     * adresse du contact
     */
    @Column(name = "execpt_adresse_contact")
    private String execptAdresseContact;

    /**
     * ville du contact
     */
    @Column(name = "execpt_ville_contact")
    private String execptVilleContact;

    /**
     * telephone du contact
     */
    @Column(name = "execpt_telephone_contact")
    private String execptTelephoneContact;

    /**
     * qualite du contact
     */
    @Column(name = "execpt_qua_contact")
    private String execptQuaContact;

    /**
     * nom du cabinet
     */
    @Column(name = "execpt_nom_cabinet")
    private String execptNomCabinet;

    /**
     * adresse du cabinet
     */
    @Column(name = "execpt_adresse_cabinet")
    private String execptAdresseCabinet;

    /**
     * ville du cabinet
     */
    @Column(name = "execpt_ville_cabinet")
    private String execptVilleCabinet;

    /**
     * telephone du cabinet
     */
    @Column(name = "execpt_telephone_cabinet")
    private String execptTelephoneCabinet;

    /**
     * nom du commissaire aux comptes
     */
    @Column(name = "execpt_nom_commissaire")
    private String execptNomCommissaire;

    /**
     * adresse du commissaire aux comptes
     */
    @Column(name = "execpt_adresse_commissaire")
    private String execptAdresseCommissaire;

    /**
     * ville du commissaire aux comptes
     */
    @Column(name = "execpt_ville_commissaire")
    private String execptVilleCommissaire;

    /**
     * telephone du commissaire aux comptes
     */
    @Column(name = "execpt_telephone_commissaire")
    private String execptTelephoneCommissaire;

    /**
     * nom du signataire des etats financiers
     */
    @Column(name = "execpt_nom_signataire")
    private String execptNomSignataire;

    /**
     * qualite du signataire
     */
    @Column(name = "execpt_qua_signataire")
    private String execptQuaSignataire;

    /**
     * 1=certification non assujetti
     */
    @Column(name = "execpt_efcna")
    private Boolean execptEfcna = Boolean.FALSE;

    /**
     * 1=certification refuse
     */
    @Column(name = "execpt_efcr")
    private Boolean execptEfcr = Boolean.FALSE;

    /**
     * 1=certification accepte avec reserve
     */
    @Column(name = "execpt_efcar")
    private Boolean execptEfcar = Boolean.FALSE;

    /**
     * 1=approvation sans reserve
     */
    @Column(name = "execpt_efasr")
    private Boolean execptEfasr = Boolean.FALSE;

    /**
     * 1=approvation non assujetti
     */
    @Column(name = "execpt_efana")
    private Boolean execptEfana = Boolean.FALSE;

    /**
     * 1=non approuve
     */
    @Column(name = "execpt_efanap")
    private Boolean execptEfanap = Boolean.FALSE;

    /**
     * 1=approvation
     */
    @Column(name = "execpt_efaap")
    private Boolean execptEfaap = Boolean.FALSE;

    /**
     * 0=exercice en cours 1=exercice cloture provisoire 2=cloture definitive
     */
    @Column(name = "execpt_etat_anterieur")
    private Integer execptEtatAnterieur = 0;

    /**
     * true si liasse cloturee
     */
    @Column(name = "execpt_liasse")
    private Boolean execptLiasse = Boolean.FALSE;

    /**
     * le resultat est il affecte
     */
    @Column(name = "execpt_resltat_affecte")
    private Boolean execptResltatAffecte = Boolean.FALSE;

}
