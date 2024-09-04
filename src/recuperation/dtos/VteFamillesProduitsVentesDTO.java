package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VteFamillesProduitsVentesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long famvteId;


    /**
     * date de creation
     */
    private LocalDateTime famvteDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime famvteDateModif;


    /**
     * user de creation
     */
    private Long famvteUserCreation;


    /**
     * user de modification
     */
    private Long famvteUserModif;


    /**
     * code de la famille
     */
    private String famvteCode;


    /**
     * libelle de la famille FR
     */
    private String famvteLibelleFr;


    /**
     * libelle de la famille UK
     */
    private String famvteLibelleUk;


    /**
     * libelle de la famille SP
     */
    private String famvteLibelleSp;


    /**
     * code de taxe achat
     */
    private String famvteTaxe;


    /**
     * code de la douane
     */
    private String famvteDouane;


    /**
     * compte de vente en local
     */
    private String famvteCompteLocal;


    /**
     * compte de vente dan la zone
     */
    private String famvteCompteZone;


    /**
     * compte de vente hors de la zone
     */
    private String famvteCompteExterieur;


    /**
     * compte de vente sur stock
     */
    private String famvteCompteStock;


    /**
     * compte de vente sur produit
     */
    private String famvteCompteProduit;


    /**
     * 0=sans stock 1=stock simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    private Integer famvteStock;


    /**
     * lie au ficheir XML nature
     */
    private String famvteNature;


    /**
     * libelle de la nature
     */
    private String famvteLibNature;


    /**
     * 0=actif 1=inactif
     */
    private Integer famvteInactif;


    /**
     * 0=standar
     */
    private Integer famvteCat;


    /**
     * code analytique 2
     */
    private String famvteAnal2;


    /**
     * code analytique 4
     */
    private String famvteAnal4;


    /**
     * code budget
     */
    private String famvteBudget;


    /**
     * code activite
     */
    private String famvteActivite;


    /**
     * code depot de vente
     */
    private String famvteDepotVte;


    /**
     * code service de vente
     */
    private String famvteService;


    /**
     * cle 1 de repartition
     */
    private String famvteCle1;


    /**
     * cle 2 de repartition
     */
    private String famvteCle2;


    /**
     * marque
     */
    private String famvteMarque;


    /**
     * coef prix vente
     */
    private Float famvteCoefPv;

    private Long exevteId;


    /**
     * compte de vente en local non taxable
     */
    private String famvteCompteNomTaxable;

}
