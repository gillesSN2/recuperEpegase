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
@Table(name = "cai_virement_interne")
public class CaiVirementInterne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "vir_id", nullable = false)
    private Long virId;

    /**
     * concactenation du numero et de la nature
     */
    @Column(name = "vir_cle")
    private String virCle;

    /**
     * date de creation
     */
    @Column(name = "vir_date_creat")
    private LocalDateTime virDateCreat;

    /**
     * user de creation
     */
    @Column(name = "vir_user_creat")
    private Long virUserCreat = 0L;

    /**
     * date de modification
     */
    @Column(name = "vir_date_modif")
    private LocalDateTime virDateModif;

    /**
     * user de creation
     */
    @Column(name = "vir_user_modif")
    private Long virUserModif = 0L;

    /**
     * nature du bonument
     */
    @Column(name = "vir_nature")
    private Integer virNature;

    /**
     * numero du bon
     */
    @Column(name = "vir_num")
    private String virNum;

    /**
     * date
     */
    @Column(name = "vir_date")
    private LocalDate virDate;

    /**
     * nom du responsable
     */
    @Column(name = "vir_nom_responsable")
    private String virNomResponsable;

    /**
     * code joural de emetrice
     */
    @Column(name = "vir_cod_emetrice")
    private String virCodEmetrice;

    /**
     * nom de emetrice
     */
    @Column(name = "vir_nom_emetrice")
    private String virNomEmetrice;

    /**
     * code joural du recepteur
     */
    @Column(name = "vir_cod_receptrice")
    private String virCodReceptrice;

    /**
     * nom de la receptrice
     */
    @Column(name = "vir_nom_receptrice")
    private String virNomReceptrice;

    /**
     * serie
     */
    @Column(name = "vir_serie")
    private String virSerie;

    /**
     * libelle
     */
    @Column(name = "vir_libelle")
    private String virLibelle;

    /**
     * devise
     */
    @Column(name = "vir_devise")
    private String virDevise;

    /**
     * montant
     */
    @Column(name = "vir_montant")
    private Double virMontant = 0D;

    /**
     * tye de reglement
     */
    @Column(name = "vir_type_reg")
    private Integer virTypeReg = 0;

    /**
     * etat 0=a payer ; 1=regle
     */
    @Column(name = "VirEtat")
    private Integer virEtat = 0;

    /**
     * date de valeur
     */
    @Column(name = "vir_date_valeur")
    private LocalDate virDateValeur;

    /**
     * 0 actif, 1 inactif
     */
    @Column(name = "vir_actif")
    private Integer virActif = 0;

    /**
     * code de la caisse
     */
    @Column(name = "vir_code_caiss")
    private String virCodeCaiss;

    /**
     * libelle de la caisse
     */
    @Column(name = "vir_lib_caiss")
    private String virLibCaiss;

    /**
     * activite
     */
    @Column(name = "vir_activite")
    private String virActivite;

    /**
     * site
     */
    @Column(name = "vir_site")
    private String virSite;

    /**
     * departement
     */
    @Column(name = "vir_departement")
    private String virDepartement;

    /**
     * service
     */
    @Column(name = "vir_service")
    private String virService;

    /**
     * region
     */
    @Column(name = "vir_region")
    private String virRegion;

    /**
     * secteur
     */
    @Column(name = "vir_secteur")
    private String virSecteur;

    /**
     * Pdv
     */
    @Column(name = "vir_pdv")
    private String virPdv;

    /**
     * budget
     */
    @Column(name = "vir_budget")
    private String virBudget;

    @Column(name = "execai_id", nullable = false)
    private Long execaiId;

    /**
     * montant disponible sur budget
     */
    @Column(name = "vir_budget_dispo")
    private Double virBudgetDispo = 0D;

    /**
     * montant disponible sur treso
     */
    @Column(name = "vir_budget_treso")
    private Double virBudgetTreso = 0D;

    /**
     * budget mensuel dispo
     */
    @Column(name = "vir_budget_dispo_mois")
    private Double virBudgetDispoMois = 0D;

    /**
     * budget mensuel treso
     */
    @Column(name = "vir_budget_treso_mois")
    private Double virBudgetTresoMois = 0D;

    /**
     * dossier
     */
    @Column(name = "vir_dossier")
    private String virDossier;

    /**
     * parc
     */
    @Column(name = "vir_parc")
    private String virParc;

    /**
     * numero cheque ou bordereau
     */
    @Column(name = "vir_num_chq_bdx")
    private String virNumChqBdx;

    /**
     * 0=sans validation 1=avec validation
     */
    @Column(name = "vir_etat_val")
    private Integer virEtatVal = 0;

    /**
     * 0=non gele 1=gele
     */
    @Column(name = "vir_gele")
    private Integer virGele = 0;

    /**
     * date de validation
     */
    @Column(name = "vir_date_valide")
    private LocalDate virDateValide;

    /**
     * modele impression recu
     */
    @Column(name = "vir_modele_imp")
    private String virModeleImp;

    /**
     * date impression recu
     */
    @Column(name = "vir_date_impression")
    private LocalDateTime virDateImpression;

    /**
     * code budget
     */
    @Column(name = "vir_code_budget_treso")
    private String virCodeBudgetTreso;

    /**
     * code poste
     */
    @Column(name = "vir_code_poste_treso")
    private String virCodePosteTreso;

}
