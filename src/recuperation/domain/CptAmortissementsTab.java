package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cpt_amortissements_tab")
public class CptAmortissementsTab implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "amotab_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amotabId;

    /**
     * date debut periode
     */
    @Column(name = "amotab_date_deb")
    private LocalDate amotabDateDeb;

    /**
     * date fin periode
     */
    @Column(name = "amotab_date_fin")
    private LocalDate amotabDateFin;

    /**
     * montant amortissement
     */
    @Column(name = "amotab_montant")
    private Double amotabMontant = 0D;

    /**
     * date transfert en compta
     */
    @Column(name = "amotab_date_trf")
    private LocalDate amotabDateTrf;

    /**
     * valeur transferee
     */
    @Column(name = "amotab_valeur")
    private Double amotabValeur = 0D;

    /**
     * valeur vnc
     */
    @Column(name = "amotab_vnc")
    private Double amotabVnc = 0D;

    /**
     * imputation site
     */
    @Column(name = "amotab_site")
    private String amotabSite;

    /**
     * libelle site
     */
    @Column(name = "amotab_lib_site")
    private String amotabLibSite;

    /**
     * imputation departement
     */
    @Column(name = "amotab_departement")
    private String amotabDepartement;

    /**
     * libelle departement
     */
    @Column(name = "amotab_lib_departement")
    private String amotabLibDepartement;

    /**
     * imputation service
     */
    @Column(name = "amotab_service")
    private String amotabService;

    /**
     * libelle service
     */
    @Column(name = "amotab_lib_service")
    private String amotabLibService;

    /**
     * imputation region
     */
    @Column(name = "amotab_region")
    private String amotabRegion;

    /**
     * libelle region
     */
    @Column(name = "amotab_lib_region")
    private String amotabLibRegion;

    /**
     * imputation secteur
     */
    @Column(name = "amotab_secteur")
    private String amotabSecteur;

    /**
     * libelle secteur
     */
    @Column(name = "amotab_lib_secteur")
    private String amotabLibSecteur;

    /**
     * imputation point de vente
     */
    @Column(name = "amotab_pdv")
    private String amotabPdv;

    /**
     * libelle pdv
     */
    @Column(name = "amotab_lib_pdv")
    private String amotabLibPdv;

    /**
     * imputation analytique 1
     */
    @Column(name = "amotab_anal1")
    private String amotabAnal1;

    /**
     * libelle anal1
     */
    @Column(name = "amotab_lib_anal1")
    private String amotabLibAnal1;

    /**
     * imputation analytique 2
     */
    @Column(name = "amotab_anal2")
    private String amotabAnal2;

    /**
     * libelle anal2
     */
    @Column(name = "amotab_lib_anal2")
    private String amotabLibAnal2;

    /**
     * imputation analytique 3
     */
    @Column(name = "amotab_anal3")
    private String amotabAnal3;

    /**
     * libelle anal3
     */
    @Column(name = "amotab_lib_anal3")
    private String amotabLibAnal3;

    /**
     * imputation analytique 4
     */
    @Column(name = "amotab_anal4")
    private String amotabAnal4;

    /**
     * libelle anal4
     */
    @Column(name = "amotab_lib_anal4")
    private String amotabLibAnal4;

    /**
     * code activite
     */
    @Column(name = "amotab_activite")
    private String amotabActivite;

    /**
     * libelle activite
     */
    @Column(name = "amotab_lib_activite")
    private String amotabLibActivite;

    /**
     * code projet
     */
    @Column(name = "amotab_projet")
    private String amotabProjet;

    /**
     * libelle projet
     */
    @Column(name = "amotab_lib_projet")
    private String amotabLibProjet;

    /**
     * imputation budgetaire
     */
    @Column(name = "amotab_budget")
    private String amotabBudget;

    /**
     * libelle budget
     */
    @Column(name = "amotab_lib_budget")
    private String amotabLibBudget;

    @Column(name = "amo_id", nullable = false)
    private Long amoId;

    /**
     * date de sortie
     */
    @Column(name = "amotab_date_sortie")
    private LocalDate amotabDateSortie;

    /**
     * valeur cesssion
     */
    @Column(name = "amotab_valeur_cession")
    private Double amotabValeurCession = 0D;

}
