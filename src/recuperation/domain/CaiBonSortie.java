package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cai_bon_sortie")
public class CaiBonSortie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sort_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sortId;

    /**
     * concactenation du numero et de la nature
     */
    @Column(name = "sort_cle")
    private String sortCle;

    /**
     * date de creation
     */
    @Column(name = "sort_date_creat")
    private LocalDateTime sortDateCreat;

    /**
     * user de creation
     */
    @Column(name = "sort_user_creat")
    private Long sortUserCreat = 0L;

    /**
     * date de modification
     */
    @Column(name = "sort_date_modif")
    private LocalDateTime sortDateModif;

    /**
     * user de modification
     */
    @Column(name = "sort_user_modif")
    private Long sortUserModif = 0L;

    /**
     * nature du bonument
     */
    @Column(name = "sort_nature")
    private Integer sortNature;

    /**
     * date
     */
    @Column(name = "sort_date")
    private LocalDate sortDate;

    /**
     * numero du bon
     */
    @Column(name = "sort_num")
    private String sortNum;

    /**
     * nom du responsable
     */
    @Column(name = "sort_nom_responsable")
    private String sortNomResponsable;

    /**
     * nom du tiers
     */
    @Column(name = "sort_nom_tiers")
    private String sortNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "sort_id_tiers")
    private Long sortIdTiers = 0L;

    /**
     * type du tiers 0:client,1:Fournisseur,2:Agent,3:PlanComptable 4=patient 5=eleve
     */
    @Column(name = "sort_type_tiers")
    private Integer sortTypeTiers = 0;

    /**
     * 0=sortie normale 1=retrait dans compte tiers
     */
    @Column(name = "sort_depot_tiers")
    private Integer sortDepotTiers = 0;

    /**
     * serie
     */
    @Column(name = "sort_serie")
    private String sortSerie;

    /**
     * libelle
     */
    @Column(name = "sort_libelle")
    private String sortLibelle;

    /**
     * devise
     */
    @Column(name = "sort_devise")
    private String sortDevise;

    /**
     * montant
     */
    @Column(name = "sort_montant")
    private Double sortMontant = 0D;

    /**
     * type de reglement
     */
    @Column(name = "sort_type_reg")
    private Integer sortTypeReg = 0;

    /**
     * activite
     */
    @Column(name = "sort_activite")
    private String sortActivite;

    /**
     * site
     */
    @Column(name = "sort_site")
    private String sortSite;

    /**
     * departement
     */
    @Column(name = "sort_departement")
    private String sortDepartement;

    /**
     * service
     */
    @Column(name = "sort_service")
    private String sortService;

    /**
     * region
     */
    @Column(name = "sort_region")
    private String sortRegion;

    /**
     * secteur
     */
    @Column(name = "sort_secteur")
    private String sortSecteur;

    /**
     * Pdv
     */
    @Column(name = "sort_pdv")
    private String sortPdv;

    /**
     * budget
     */
    @Column(name = "sort_budget")
    private String sortBudget;

    /**
     * etat 0=a payer ; 1=regle
     */
    @Column(name = "sort_etat")
    private Integer sortEtat = 0;

    /**
     * date de valeur
     */
    @Column(name = "sort_date_relance")
    private LocalDate sortDateRelance;

    /**
     * 0:actif, 1:inactif
     */
    @Column(name = "sort_actif")
    private Integer sortActif = 0;

    /**
     * modele impression recu
     */
    @Column(name = "sort_modele_imp")
    private String sortModeleImp;

    /**
     * date impression recu
     */
    @Column(name = "sort_date_impression")
    private LocalDateTime sortDateImpression;

    /**
     * code caisse du bon
     */
    @Column(name = "sort_code_caiss")
    private String sortCodeCaiss;

    /**
     * libelle ciasse du bon
     */
    @Column(name = "sort_lib_caiss")
    private String sortLibCaiss;

    /**
     * code banque du bon
     */
    @Column(name = "sort_code_banq")
    private String sortCodeBanq;

    /**
     * libelle banque du bon
     */
    @Column(name = "sort_lib_banq")
    private String sortLibBanq;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * montant disponible sur budget
     */
    @Column(name = "sort_budget_dispo")
    private Double sortBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "sort_budget_treso")
    private Double sortBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "sort_budget_dispo_mois")
    private Double sortBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "sort_budget_treso_mois")
    private Double sortBudgetTresoMois = 0D;

    /**
     * dossier
     */
    @Column(name = "sort_dossier")
    private String sortDossier;

    /**
     * parc
     */
    @Column(name = "sort_parc")
    private String sortParc;

    /**
     * cle 1 de repartition
     */
    @Column(name = "sort_cle1_repartition")
    private String sortCle1Repartition;

    /**
     * cle 2 de repartition
     */
    @Column(name = "sort_cle2_repartition")
    private String sortCle2Repartition;

    /**
     * banque du tireur
     */
    @Column(name = "sort_banque_tireur")
    private String sortBanqueTireur;

    /**
     * numero cheque ou bordereau
     */
    @Column(name = "sort_num_chq_bdx")
    private String sortNumChqBdx;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "sort_etat_val")
    private Integer sortEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "sort_gele")
    private Integer sortGele = 0;

    /**
     * date de validation
     */
    @Column(name = "sort_date_valide")
    private LocalDate sortDateValide;

    /**
     * numero du document origine
     */
    @Column(name = "sort_document")
    private String sortDocument;

    /**
     * objet du document
     */
    @Column(name = "sort_objet")
    private String sortObjet;

    /**
     * code budget
     */
    @Column(name = "sort_code_budget_treso")
    private String sortCodeBudgetTreso;

    /**
     * code poste
     */
    @Column(name = "sort_code_poste_treso")
    private String sortCodePosteTreso;

    /**
     * code operation
     */
    @Column(name = "sort_operation")
    private String sortOperation;

}
