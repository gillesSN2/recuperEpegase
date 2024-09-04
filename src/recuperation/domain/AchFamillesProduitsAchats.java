package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_familles_produits_achats")
public class AchFamillesProduitsAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "famach_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long famachId;

    /**
     * date de creation
     */
    @Column(name = "famach_date_creation")
    private LocalDateTime famachDateCreation;

    /**
     * date de modification
     */
    @Column(name = "famach_date_modif")
    private LocalDateTime famachDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "famach_user_creation")
    private Long famachUserCreation = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "famach_user_modif")
    private Long famachUserModif = 0L;

    /**
     * code famille
     */
    @Column(name = "famach_code")
    private String famachCode;

    /**
     * nom du suivi en FR
     */
    @Column(name = "famach_libelle_fr")
    private String famachLibelleFr;

    /**
     * nom du suivi en UK
     */
    @Column(name = "famach_libelle_uk")
    private String famachLibelleUk;

    /**
     * nom du suivi en SP
     */
    @Column(name = "famach_libelle_sp")
    private String famachLibelleSp;

    /**
     * code taxe achat
     */
    @Column(name = "famach_taxe")
    private String famachTaxe;

    /**
     * code douane
     */
    @Column(name = "famach_douane")
    private String famachDouane;

    /**
     * compte local
     */
    @Column(name = "famach_compte_local")
    private String famachCompteLocal;

    /**
     * compte dans la zone
     */
    @Column(name = "famach_compte_zone")
    private String famachCompteZone;

    /**
     * compte exterieur
     */
    @Column(name = "famach_compte_exterieur")
    private String famachCompteExterieur;

    /**
     * compte stock
     */
    @Column(name = "famach_compte_stock")
    private String famachCompteStock;

    /**
     * compte charge
     */
    @Column(name = "famach_compte_charge")
    private String famachCompteCharge;

    /**
     * 0=sans stock 1=simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    @Column(name = "famach_stock")
    private Integer famachStock = 0;

    /**
     * 0=standard 1=production 2=consommable 3=services 4=immobilisation 90=famille
     */
    @Column(name = "famach_cat")
    private Integer famachCat = 0;

    /**
     * position du fichier xml
     */
    @Column(name = "famach_nature")
    private String famachNature;

    /**
     * libelle nature
     */
    @Column(name = "famach_lib_nature")
    private String famachLibNature;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "famach_inactif")
    private Integer famachInactif = 0;

    /**
     * analytique 2
     */
    @Column(name = "famach_anal2")
    private String famachAnal2;

    /**
     * analytique 4
     */
    @Column(name = "famach_anal4")
    private String famachAnal4;

    /**
     * budget
     */
    @Column(name = "famach_budget")
    private String famachBudget;

    /**
     * activite
     */
    @Column(name = "famach_activite")
    private String famachActivite;

    /**
     * code depot achat
     */
    @Column(name = "famach_depot_ach")
    private String famachDepotAch;

    /**
     * code depot production
     */
    @Column(name = "famach_depot_prd")
    private String famachDepotPrd;

    /**
     * code service achat
     */
    @Column(name = "famach_service")
    private String famachService;

    /**
     * cle 1 de repartition
     */
    @Column(name = "famach_cle1")
    private String famachCle1;

    /**
     * cle 2 de repartition
     */
    @Column(name = "famach_cle2")
    private String famachCle2;

    /**
     * marque
     */
    @Column(name = "famach_marque")
    private String famachMarque;

    /**
     * unite de stockage
     */
    @Column(name = "famach_unite")
    private String famachUnite;

    /**
     * valeur unite de stockage
     */
    @Column(name = "famach_echelle")
    private Integer famachEchelle = 0;

    /**
     * conditionnement 1
     */
    @Column(name = "famach_condition1")
    private String famachCondition1;

    /**
     * conditionnement 2
     */
    @Column(name = "famach_condition2")
    private String famachCondition2;

    /**
     * conditionnement 3
     */
    @Column(name = "famach_condition3")
    private String famachCondition3;

    /**
     * conditionnement 4
     */
    @Column(name = "famach_condition4")
    private String famachCondition4;

    /**
     * conditionnement 5
     */
    @Column(name = "famach_condition5")
    private String famachCondition5;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

    /**
     * coefficient valorisation par defaut
     */
    @Column(name = "famach_coef_val_defaut")
    private Float famachCoefValDefaut = 0F;

    /**
     * compte acht en cours
     */
    @Column(name = "famach_compte_encours")
    private String famachCompteEncours;

    /**
     * coefficient de prg
     */
    @Column(name = "famach_coef_prg")
    private Float famachCoefPrg = 0F;

    /**
     * coefficient entrepot fictif
     */
    @Column(name = "famach_coef_fictif")
    private Float famachCoefFictif = 0F;

    /**
     * famille liee avec les ventes
     */
    @Column(name = "famach_liee_vte")
    private Boolean famachLieeVte = Boolean.FALSE;

}
