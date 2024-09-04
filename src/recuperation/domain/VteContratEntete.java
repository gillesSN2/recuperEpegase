package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_contrat_entete")
public class VteContratEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "crt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crtId;

    /**
     * date de creation
     */
    @Column(name = "crt_date_creat")
    private LocalDateTime crtDateCreat;

    /**
     * date de modification
     */
    @Column(name = "crt_date_modif")
    private LocalDateTime crtDateModif;

    /**
     * id user createur
     */
    @Column(name = "crt_id_createur")
    private Long crtIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "crt_nom_createur")
    private String crtNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "crt_id_modif")
    private Long crtIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "crt_nom_modif")
    private String crtNomModif;

    /**
     * date du factue
     */
    @Column(name = "crt_date")
    private LocalDateTime crtDate;

    /**
     * numero facture
     */
    @Column(name = "crt_num")
    private String crtNum;

    /**
     * nom equipe
     */
    @Column(name = "crt_nom_equipe")
    private String crtNomEquipe;

    /**
     * id equipe
     */
    @Column(name = "crt_id_equipe")
    private Long crtIdEquipe = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "crt_nom_responsable")
    private String crtNomResponsable;

    /**
     * id du commercial
     */
    @Column(name = "crt_id_responsable")
    private Long crtIdResponsable = 0L;

    /**
     * nom du commercial
     */
    @Column(name = "crt_nom_commercial")
    private String crtNomCommercial;

    /**
     * id du commercial
     */
    @Column(name = "crt_id_commercial")
    private Long crtIdCommercial = 0L;

    /**
     * nom du divers
     */
    @Column(name = "crt_divers_nom")
    private String crtDiversNom;

    /**
     * nom du client
     */
    @Column(name = "crt_nom_tiers")
    private String crtNomTiers;

    /**
     * civilite du tiers
     */
    @Column(name = "crt_civil_tiers")
    private String crtCivilTiers;

    /**
     * id du contact
     */
    @Column(name = "crt_id_contact")
    private Long crtIdContact = 0L;

    /**
     * nom du contact
     */
    @Column(name = "crt_nom_contact")
    private String crtNomContact;

    /**
     * civilite du contact
     */
    @Column(name = "crt_civil_contact")
    private String crtCivilContact;

    /**
     * serie
     */
    @Column(name = "crt_serie")
    private String crtSerie;

    /**
     * 0=avec Tva 1=sans Tva
     */
    @Column(name = "crt_exo_tva")
    private Integer crtExoTva = 0;

    /**
     * 0=avec Douane 1=sans Douane
     */
    @Column(name = "crt_exo_douane")
    private Integer crtExoDouane = 0;

    /**
     * categorie du client
     */
    @Column(name = "crt_cat")
    private String crtCat;

    /**
     * code devise
     */
    @Column(name = "crt_devise")
    private String crtDevise;

    /**
     * objet
     */
    @Column(name = "crt_object")
    private String crtObject;

    /**
     * observation
     */
    @Column(name = "crt_observation")
    private String crtObservation;

    /**
     * code budget
     */
    @Column(name = "crt_budget")
    private String crtBudget;

    /**
     * taux remise globale
     */
    @Column(name = "crt_taux_remise")
    private Float crtTauxRemise = 0F;

    /**
     * total ht
     */
    @Column(name = "crt_tot_ht")
    private Double crtTotHt = 0D;

    /**
     * total remise
     */
    @Column(name = "crt_tot_remise")
    private Double crtTotRemise = 0D;

    /**
     * total rabais
     */
    @Column(name = "crt_tot_rabais")
    private Double crtTotRabais = 0D;

    /**
     * ttal tva
     */
    @Column(name = "crt_tot_tva")
    private Double crtTotTva = 0D;

    /**
     * taux taxe complementaire
     */
    @Column(name = "crt_taux_tc")
    private Float crtTauxTc = 0F;

    /**
     * total taxe complementaire
     */
    @Column(name = "crt_tot_tc")
    private Double crtTotTc = 0D;

    /**
     * total ttc
     */
    @Column(name = "crt_tot_ttc")
    private Double crtTotTtc = 0D;

    /**
     * total timbre
     */
    @Column(name = "crt_tot_timbre")
    private Double crtTotTimbre = 0D;

    /**
     * nom de la banque + numero de compte
     */
    @Column(name = "crt_banque")
    private String crtBanque;

    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    @Column(name = "crt_type_reg")
    private Integer crtTypeReg = 0;

    /**
     * mode de reglement xml
     */
    @Column(name = "crt_mode_reg")
    private String crtModeReg;

    /**
     * nombre de jour
     */
    @Column(name = "crt_nb_jour_reg")
    private Integer crtNbJourReg = 0;

    /**
     * nombre de jour arrondi
     */
    @Column(name = "crt_arrondi_reg")
    private Integer crtArrondiReg = 0;

    /**
     * condition de reglement
     */
    @Column(name = "crt_condition_reg")
    private String crtConditionReg;

    /**
     * code journal des reglements
     */
    @Column(name = "crt_journal_reg")
    private String crtJournalReg;

    /**
     * code activite
     */
    @Column(name = "crt_activite")
    private String crtActivite;

    /**
     * code site
     */
    @Column(name = "crt_site")
    private String crtSite;

    /**
     * code departement
     */
    @Column(name = "crt_departement")
    private String crtDepartement;

    /**
     * code service
     */
    @Column(name = "crt_service")
    private String crtService;

    /**
     * code region
     */
    @Column(name = "crt_region")
    private String crtRegion;

    /**
     * code secteur
     */
    @Column(name = "crt_secteur")
    private String crtSecteur;

    /**
     * code point de vente
     */
    @Column(name = "crt_pdv")
    private String crtPdv;

    /**
     * code analytique 2
     */
    @Column(name = "crt_anal2")
    private String crtAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "crt_anal4")
    private String crtAnal4;

    /**
     * info 1
     */
    @Column(name = "crt_info1")
    private String crtInfo1;

    /**
     * info 2
     */
    @Column(name = "crt_info2")
    private String crtInfo2;

    /**
     * info 3
     */
    @Column(name = "crt_info3")
    private String crtInfo3;

    /**
     * info 4
     */
    @Column(name = "crt_info4")
    private String crtInfo4;

    /**
     * info 5
     */
    @Column(name = "crt_info5")
    private String crtInfo5;

    /**
     * info 6
     */
    @Column(name = "crt_info6")
    private String crtInfo6;

    /**
     * info 7
     */
    @Column(name = "crt_info7")
    private String crtInfo7;

    /**
     * info 8
     */
    @Column(name = "crt_info8")
    private String crtInfo8;

    /**
     * info 9
     */
    @Column(name = "crt_info9")
    private String crtInfo9;

    /**
     * info 10
     */
    @Column(name = "crt_info10")
    private String crtInfo10;

    /**
     * code formule 1
     */
    @Column(name = "crt_formule1")
    private String crtFormule1;

    /**
     * code formule 2
     */
    @Column(name = "crt_formule2")
    private String crtFormule2;

    /**
     * date impression
     */
    @Column(name = "crt_date_imp")
    private LocalDate crtDateImp;

    /**
     * nom jasper du modele
     */
    @Column(name = "crt_modele_imp")
    private String crtModeleImp;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "crt_etat_val")
    private Integer crtEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "crt_gele")
    private Integer crtGele = 0;

    /**
     * 0=En cours 1=valide 2=gele 3=annule 4=transforme
     */
    @Column(name = "crt_etat")
    private Integer crtEtat = 0;

    /**
     * numero de transfert
     */
    @Column(name = "crt_num_trf")
    private String crtNumTrf;

    /**
     * date de validite
     */
    @Column(name = "crt_date_validite")
    private LocalDate crtDateValidite;

    /**
     * date de validation
     */
    @Column(name = "crt_date_valide")
    private LocalDate crtDateValide;

    /**
     * motif exoneration
     */
    @Column(name = "crt_motif_exo")
    private String crtMotifExo;

    /**
     * numero du visa
     */
    @Column(name = "crt_num_visa")
    private String crtNumVisa;

    /**
     * date du visa
     */
    @Column(name = "crt_date_visa")
    private LocalDate crtDateVisa;

    /**
     * rangement du visa
     */
    @Column(name = "crt_range_visa")
    private String crtRangeVisa;

    /**
     * date transfert en compta
     */
    @Column(name = "crt_date_transfert")
    private LocalDate crtDateTransfert;

    /**
     * si facture directe et stock alors 1 sinon 0
     */
    @Column(name = "crt_stock")
    private Integer crtStock = 0;

    /**
     * source du document
     */
    @Column(name = "crt_source")
    private String crtSource;

    /**
     * date debut
     */
    @Column(name = "crt_date_debut")
    private LocalDate crtDateDebut;

    /**
     * date fin
     */
    @Column(name = "crt_date_fin")
    private LocalDate crtDateFin;

    /**
     * 0=contrat vente 1=maintenance ou assistance 2=abonnement saas
     */
    @Column(name = "crt_type")
    private Integer crtType = 0;

    /**
     * 0=jour 1=semaine 2=mois 3=trimestre 4=semestre 5=annuel
     */
    @Column(name = "crt_periodicite")
    private Integer crtPeriodicite = 0;

    /**
     * jour de generation
     */
    @Column(name = "crt_jour")
    private Integer crtJour = 0;

    /**
     * text du contrat
     */
    @Column(name = "crt_text")
    private String crtText;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "usr_id")
    private Long usrId;

}
