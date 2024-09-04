package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_loyer")
public class CptLoyer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "loy_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loyId;

    /**
     * date de creation
     */
    @Column(name = "loy_date_creat")
    private LocalDateTime loyDateCreat;

    /**
     * date de modification
     */
    @Column(name = "loy_date_modif")
    private LocalDateTime loyDateModif;

    /**
     * user de creation
     */
    @Column(name = "loy_user_creat")
    private Long loyUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "loy_user_modif")
    private Long loyUserModif = 0L;

    /**
     * numero du bail
     */
    @Column(name = "loy_num_bail")
    private String loyNumBail;

    /**
     * compte tiers (client ou fournisseur)
     */
    @Column(name = "loy_compte_tiers")
    private String loyCompteTiers;

    /**
     * libelle tiers (client ou fournisseur)
     */
    @Column(name = "loy_lib_compte_tiers")
    private String loyLibCompteTiers;

    /**
     * numero de contribuable
     */
    @Column(name = "loy_num_contribuable")
    private String loyNumContribuable;

    /**
     * 0=particulier 1=sci locale 2=societe locale 3=sci locale 4=societe etrangere 5=administration
     */
    @Column(name = "loy_categorie")
    private Integer loyCategorie = 0;

    /**
     * 0=loyer verse 1=loyer encaisse
     */
    @Column(name = "loy_type")
    private Integer loyType = 0;

    /**
     * compte de loyer
     */
    @Column(name = "loy_compte_loyer")
    private String loyCompteLoyer;

    /**
     * libelle compte de loyer
     */
    @Column(name = "loy_lib_compte_loyer")
    private String loyLibCompteLoyer;

    /**
     * compte de taxe
     */
    @Column(name = "loy_compte_taxe")
    private String loyCompteTaxe;

    /**
     * libelle compte de taxe
     */
    @Column(name = "loy_lib_compte_taxe")
    private String loyLibCompteTaxe;

    /**
     * compte impot
     */
    @Column(name = "loy_compte_impot")
    private String loyCompteImpot;

    /**
     * libelle compte impot
     */
    @Column(name = "loy_lib_compte_impot")
    private String loyLibCompteImpot;

    /**
     * date debut du bail
     */
    @Column(name = "loy_date_debut")
    private LocalDate loyDateDebut;

    /**
     * date fin du bail
     */
    @Column(name = "loy_date_fin")
    private LocalDate loyDateFin;

    /**
     * description du bien
     */
    @Column(name = "loy_description")
    private String loyDescription;

    /**
     * usage de la location
     */
    @Column(name = "loy_usage")
    private String loyUsage;

    /**
     * 0=mensuel 1=trimestriel 2=semestriel 3=annuel
     */
    @Column(name = "loy_mode")
    private Integer loyMode = 0;

    /**
     * montant net du loyer
     */
    @Column(name = "loy_montant_net")
    private Double loyMontantNet = 0D;

    /**
     * 0=sans taxe 1=tva 2=tsil
     */
    @Column(name = "loy_type_taxe")
    private Integer loyTypeTaxe = 0;

    /**
     * taux de la taxe
     */
    @Column(name = "loy_taux_taxe")
    private Float loyTauxTaxe = 0F;

    /**
     * 0=sans impot 1=tom
     */
    @Column(name = "loy_type_impot")
    private Integer loyTypeImpot = 0;

    /**
     * taux des impots
     */
    @Column(name = "loy_taux_impot")
    private Float loyTauxImpot = 0F;

    /**
     * montant brut du loyer
     */
    @Column(name = "loy_montant_brut")
    private Double loyMontantBrut = 0D;

    /**
     * montant de la taxe
     */
    @Column(name = "loy_montant_taxe")
    private Double loyMontantTaxe = 0D;

    /**
     * montant des impots
     */
    @Column(name = "loy_montant_impot")
    private Double loyMontantImpot = 0D;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "loy_inactif")
    private Integer loyInactif = 0;

    /**
     * code activite
     */
    @Column(name = "loy_activiter_code")
    private String loyActiviterCode;

    /**
     * libelle activite
     */
    @Column(name = "loy_activite_lib")
    private String loyActiviteLib;

    /**
     * code site
     */
    @Column(name = "loy_site_code")
    private String loySiteCode;

    /**
     * libelle site
     */
    @Column(name = "loy_site_lib")
    private String loySiteLib;

    /**
     * code departement
     */
    @Column(name = "loy_departement_code")
    private String loyDepartementCode;

    /**
     * libelle departement
     */
    @Column(name = "loy_departement_lib")
    private String loyDepartementLib;

    /**
     * code service
     */
    @Column(name = "loy_service_code")
    private String loyServiceCode;

    /**
     * libelle service
     */
    @Column(name = "loy_service_lib")
    private String loyServiceLib;

    /**
     * code region
     */
    @Column(name = "loy_region_code")
    private String loyRegionCode;

    /**
     * libelle region
     */
    @Column(name = "loy_region_lib")
    private String loyRegionLib;

    /**
     * secteur
     */
    @Column(name = "loy_secteur_code")
    private String loySecteurCode;

    /**
     * libelle secteur
     */
    @Column(name = "loy_secteur_lib")
    private String loySecteurLib;

    /**
     * code pdv
     */
    @Column(name = "loy_pdv_code")
    private String loyPdvCode;

    /**
     * libellle pdv
     */
    @Column(name = "loy_pdv_lib")
    private String loyPdvLib;

    /**
     * code dossier
     */
    @Column(name = "loy_dossier_code")
    private String loyDossierCode;

    /**
     * libelle dossier
     */
    @Column(name = "loy_dossier_lib")
    private String loyDossierLib;

    /**
     * code mission
     */
    @Column(name = "loy_mission_code")
    private String loyMissionCode;

    /**
     * libelle mission
     */
    @Column(name = "loy_mission_lib")
    private String loyMissionLib;

    /**
     * code parc
     */
    @Column(name = "loy_parc_code")
    private String loyParcCode;

    /**
     * libelle parc
     */
    @Column(name = "loy_parc_lib")
    private String loyParcLib;

    /**
     * code cle1
     */
    @Column(name = "loy_cle1_code")
    private String loyCle1Code;

    /**
     * libelle cle 1
     */
    @Column(name = "loy_cle1_lib")
    private String loyCle1Lib;

    /**
     * code agent
     */
    @Column(name = "loy_agent_code")
    private String loyAgentCode;

    /**
     * libelle agent
     */
    @Column(name = "loy_agent_lib")
    private String loyAgentLib;

    /**
     * code budget
     */
    @Column(name = "loy_budget_code")
    private String loyBudgetCode;

    /**
     * libelle budget
     */
    @Column(name = "loy_budget_Lib")
    private String loyBudgetLib;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

}
