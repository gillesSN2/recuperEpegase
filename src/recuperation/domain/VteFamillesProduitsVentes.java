package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_familles_produits_ventes")
public class VteFamillesProduitsVentes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "famvte_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long famvteId;

    /**
     * date de creation
     */
    @Column(name = "famvte_date_creation")
    private LocalDateTime famvteDateCreation;

    /**
     * date de modification
     */
    @Column(name = "famvte_date_modif")
    private LocalDateTime famvteDateModif;

    /**
     * user de creation
     */
    @Column(name = "famvte_user_creation")
    private Long famvteUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "famvte_user_modif")
    private Long famvteUserModif = 0L;

    /**
     * code de la famille
     */
    @Column(name = "famvte_code")
    private String famvteCode;

    /**
     * libelle de la famille FR
     */
    @Column(name = "famvte_libelle_FR")
    private String famvteLibelleFr;

    /**
     * libelle de la famille UK
     */
    @Column(name = "famvte_libelle_UK")
    private String famvteLibelleUk;

    /**
     * libelle de la famille SP
     */
    @Column(name = "famvte_libelle_SP")
    private String famvteLibelleSp;

    /**
     * code de taxe achat
     */
    @Column(name = "famvte_taxe")
    private String famvteTaxe;

    /**
     * code de la douane
     */
    @Column(name = "famvte_douane")
    private String famvteDouane;

    /**
     * compte de vente en local
     */
    @Column(name = "famvte_compte_local")
    private String famvteCompteLocal;

    /**
     * compte de vente dan la zone
     */
    @Column(name = "famvte_compte_zone")
    private String famvteCompteZone;

    /**
     * compte de vente hors de la zone
     */
    @Column(name = "famvte_compte_exterieur")
    private String famvteCompteExterieur;

    /**
     * compte de vente sur stock
     */
    @Column(name = "famvte_compte_stock")
    private String famvteCompteStock;

    /**
     * compte de vente sur produit
     */
    @Column(name = "famvte_compte_produit")
    private String famvteCompteProduit;

    /**
     * 0=sans stock 1=stock simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    @Column(name = "famvte_stock")
    private Integer famvteStock = 0;

    /**
     * lie au ficheir XML nature
     */
    @Column(name = "famvte_nature")
    private String famvteNature;

    /**
     * libelle de la nature
     */
    @Column(name = "famvte_lib_nature")
    private String famvteLibNature;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "famvte_inactif")
    private Integer famvteInactif = 0;

    /**
     * 0=standar
     */
    @Column(name = "famvte_cat")
    private Integer famvteCat = 0;

    /**
     * code analytique 2
     */
    @Column(name = "famvte_anal2")
    private String famvteAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "famvte_anal4")
    private String famvteAnal4;

    /**
     * code budget
     */
    @Column(name = "famvte_budget")
    private String famvteBudget;

    /**
     * code activite
     */
    @Column(name = "famvte_activite")
    private String famvteActivite;

    /**
     * code depot de vente
     */
    @Column(name = "famvte_depot_vte")
    private String famvteDepotVte;

    /**
     * code service de vente
     */
    @Column(name = "famvte_service")
    private String famvteService;

    /**
     * cle 1 de repartition
     */
    @Column(name = "famvte_cle1")
    private String famvteCle1;

    /**
     * cle 2 de repartition
     */
    @Column(name = "famvte_cle2")
    private String famvteCle2;

    /**
     * marque
     */
    @Column(name = "famvte_marque")
    private String famvteMarque;

    /**
     * coef prix vente
     */
    @Column(name = "famvte_coef_pv")
    private Float famvteCoefPv = 0F;

    @Column(name = "exevte_id", nullable = false)
    private Long exevteId;

    /**
     * compte de vente en local non taxable
     */
    @Column(name = "famvte_compte_nom_taxable")
    private String famvteCompteNomTaxable;

}
