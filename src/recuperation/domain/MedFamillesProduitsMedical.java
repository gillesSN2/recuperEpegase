package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_familles_produits_medical")
public class MedFamillesProduitsMedical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fammed_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fammedId;

    /**
     * date de creation
     */
    @Column(name = "fammed_date_creation")
    private LocalDateTime fammedDateCreation;

    /**
     * date de modification
     */
    @Column(name = "fammed_date_modif")
    private LocalDateTime fammedDateModif;

    /**
     * user de creation
     */
    @Column(name = "fammed_user_creation")
    private Long fammedUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "fammed_user_modif")
    private Long fammedUserModif = 0L;

    /**
     * code de la famille
     */
    @Column(name = "fammed_code")
    private String fammedCode;

    /**
     * libelle de la famille FR
     */
    @Column(name = "fammed_libelle_FR")
    private String fammedLibelleFr;

    /**
     * libelle de la famille UK
     */
    @Column(name = "fammed_libelle_UK")
    private String fammedLibelleUk;

    /**
     * libelle de la famille SP
     */
    @Column(name = "fammed_libelle_SP")
    private String fammedLibelleSp;

    /**
     * code de taxe achat
     */
    @Column(name = "fammed_taxe")
    private String fammedTaxe;

    /**
     * code de la douane
     */
    @Column(name = "fammed_douane")
    private String fammedDouane;

    /**
     * compte de vente en local
     */
    @Column(name = "fammed_compte_local")
    private String fammedCompteLocal;

    /**
     * compte de vente dan la zone
     */
    @Column(name = "fammed_compte_zone")
    private String fammedCompteZone;

    /**
     * compte de vente hors de la zone
     */
    @Column(name = "fammed_compte_exterieur")
    private String fammedCompteExterieur;

    /**
     * compte de vente sur stock
     */
    @Column(name = "fammed_compte_stock")
    private String fammedCompteStock;

    /**
     * compte de vente sur produit
     */
    @Column(name = "fammed_compte_produit")
    private String fammedCompteProduit;

    /**
     * 0=sans stock 1=stock simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    @Column(name = "fammed_stock")
    private Integer fammedStock = 0;

    /**
     * lie au ficheir XML nature
     */
    @Column(name = "fammed_nature")
    private String fammedNature;

    /**
     * libelle de la nature
     */
    @Column(name = "fammed_lib_nature")
    private String fammedLibNature;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "fammed_inactif")
    private Integer fammedInactif = 0;

    /**
     * 0=standar
     */
    @Column(name = "fammed_cat")
    private Integer fammedCat = 0;

    /**
     * code analytique 2
     */
    @Column(name = "fammed_anal2")
    private String fammedAnal2;

    /**
     * code analytique 4
     */
    @Column(name = "fammed_anal4")
    private String fammedAnal4;

    /**
     * code budget
     */
    @Column(name = "fammed_budget")
    private String fammedBudget;

    /**
     * code activite
     */
    @Column(name = "fammed_activite")
    private String fammedActivite;

    /**
     * code depot de vente
     */
    @Column(name = "fammed_depot_vte")
    private String fammedDepotVte;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    /**
     * compte de vente en local non taxable
     */
    @Column(name = "fammed_compte_non_taxable")
    private String fammedCompteNonTaxable;

    /**
     * code service de vente
     */
    @Column(name = "fammed_service")
    private String fammedService;

    @Column(name = "exevte_id")
    private Long exevteId;

}
