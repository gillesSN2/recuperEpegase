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
@Table(name = "cai_bon_entree")
public class CaiBonEntree implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "entr_id", nullable = false)
    private Long entrId;

    /**
     * concvactenation du numero et de la nature
     */
    @Column(name = "entr_cle")
    private String entrCle;

    /**
     * date de creation
     */
    @Column(name = "entr_date_creat")
    private LocalDateTime entrDateCreat;

    /**
     * user de creation
     */
    @Column(name = "entr_user_creat")
    private Long entrUserCreat = 0L;

    /**
     * date de modification
     */
    @Column(name = "entr_date_modif")
    private LocalDateTime entrDateModif;

    /**
     * user de modification
     */
    @Column(name = "entr_user_modif")
    private Long entrUserModif = 0L;

    /**
     * nature du bonument
     */
    @Column(name = "entr_nature")
    private Integer entrNature;

    /**
     * date
     */
    @Column(name = "entr_date")
    private LocalDate entrDate;

    /**
     * numero du bon
     */
    @Column(name = "entr_num")
    private String entrNum;

    /**
     * nom du responsable
     */
    @Column(name = "entr_nom_responsable")
    private String entrNomResponsable;

    /**
     * nom du tiers
     */
    @Column(name = "entr_nom_tiers")
    private String entrNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "entr_id_tiers")
    private Long entrIdTiers = 0L;

    /**
     * type du tiers 0:client,1:Fournisseur,2:Agent,3:PlanComptable 4=patient 5=eleve
     */
    @Column(name = "entr_type_tiers")
    private Integer entrTypeTiers = 0;

    /**
     * 0=entree normale 1=depot dans compte tiers
     */
    @Column(name = "entr_depot_tiers")
    private Integer entrDepotTiers = 0;

    /**
     * serie
     */
    @Column(name = "entr_serie")
    private String entrSerie;

    /**
     * libelle
     */
    @Column(name = "entr_libelle")
    private String entrLibelle;

    /**
     * devise
     */
    @Column(name = "entr_devise")
    private String entrDevise;

    /**
     * montant
     */
    @Column(name = "entr_montant")
    private Double entrMontant = 0D;

    /**
     * tye de reglement
     */
    @Column(name = "entr_type_reg")
    private Integer entrTypeReg = 0;

    /**
     * activite
     */
    @Column(name = "entr_activite")
    private String entrActivite;

    /**
     * site
     */
    @Column(name = "entr_site")
    private String entrSite;

    /**
     * departement
     */
    @Column(name = "entr_departement")
    private String entrDepartement;

    /**
     * service
     */
    @Column(name = "entr_service")
    private String entrService;

    /**
     * region
     */
    @Column(name = "entr_region")
    private String entrRegion;

    /**
     * secteur
     */
    @Column(name = "entr_secteur")
    private String entrSecteur;

    /**
     * Pdv
     */
    @Column(name = "entr_pdv")
    private String entrPdv;

    /**
     * budget
     */
    @Column(name = "entr_budget")
    private String entrBudget;

    /**
     * etat 0=a encaisser ; 1=regler
     */
    @Column(name = "entrEtat")
    private Integer entrEtat = 0;

    /**
     * date de valeur
     */
    @Column(name = "entr_date_relance")
    private LocalDate entrDateRelance;

    /**
     * 0 actif, 1 inactif
     */
    @Column(name = "entr_actif")
    private Integer entrActif = 0;

    /**
     * modele impression recu
     */
    @Column(name = "entr_modele_imp")
    private String entrModeleImp;

    /**
     * date impression recu
     */
    @Column(name = "entr_date_impression")
    private LocalDateTime entrDateImpression;

    /**
     * code d la caisse du bon
     */
    @Column(name = "entr_code_caiss")
    private String entrCodeCaiss;

    /**
     * libelle d la caisse du bon
     */
    @Column(name = "entr_lib_caiss")
    private String entrLibCaiss;

    /**
     * code banque du bon
     */
    @Column(name = "entr_code_banq")
    private String entrCodeBanq;

    /**
     * libelle banque du bon
     */
    @Column(name = "entr_lib_banq")
    private String entrLibBanq;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * montant disponible sur budget
     */
    @Column(name = "entr_budget_dispo")
    private Double entrBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "entr_budget_treso")
    private Double entrBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "entr_budget_dispo_mois")
    private Double entrBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "entr_budget_treso_mois")
    private Double entrBudgetTresoMois = 0D;

    /**
     * dossier
     */
    @Column(name = "entr_dossier")
    private String entrDossier;

    /**
     * parc
     */
    @Column(name = "entr_parc")
    private String entrParc;

    /**
     * banque emetteur
     */
    @Column(name = "entr_banque_tireur")
    private String entrBanqueTireur;

    /**
     * numero cheque ou bordereau
     */
    @Column(name = "entr_num_chq_bdx")
    private String entrNumChqBdx;

    /**
     * code budget
     */
    @Column(name = "entr_code_budget_treso")
    private String entrCodeBudgetTreso;

    /**
     * code poste
     */
    @Column(name = "entr_code_poste_treso")
    private String entrCodePosteTreso;

}
