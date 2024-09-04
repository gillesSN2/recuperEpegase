package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MedFamillesProduitsMedicalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long fammedId;


    /**
     * date de creation
     */
    private LocalDateTime fammedDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime fammedDateModif;


    /**
     * user de creation
     */
    private Long fammedUserCreation;


    /**
     * user de modification
     */
    private Long fammedUserModif;


    /**
     * code de la famille
     */
    private String fammedCode;


    /**
     * libelle de la famille FR
     */
    private String fammedLibelleFr;


    /**
     * libelle de la famille UK
     */
    private String fammedLibelleUk;


    /**
     * libelle de la famille SP
     */
    private String fammedLibelleSp;


    /**
     * code de taxe achat
     */
    private String fammedTaxe;


    /**
     * code de la douane
     */
    private String fammedDouane;


    /**
     * compte de vente en local
     */
    private String fammedCompteLocal;


    /**
     * compte de vente dan la zone
     */
    private String fammedCompteZone;


    /**
     * compte de vente hors de la zone
     */
    private String fammedCompteExterieur;


    /**
     * compte de vente sur stock
     */
    private String fammedCompteStock;


    /**
     * compte de vente sur produit
     */
    private String fammedCompteProduit;


    /**
     * 0=sans stock 1=stock simple 2=lifo 3=fifo 4=peremption 5=serialise 6=consigne 7=debours
     */
    private Integer fammedStock;


    /**
     * lie au ficheir XML nature
     */
    private String fammedNature;


    /**
     * libelle de la nature
     */
    private String fammedLibNature;


    /**
     * 0=actif 1=inactif
     */
    private Integer fammedInactif;


    /**
     * 0=standar
     */
    private Integer fammedCat;


    /**
     * code analytique 2
     */
    private String fammedAnal2;


    /**
     * code analytique 4
     */
    private String fammedAnal4;


    /**
     * code budget
     */
    private String fammedBudget;


    /**
     * code activite
     */
    private String fammedActivite;


    /**
     * code depot de vente
     */
    private String fammedDepotVte;

    private Long exemedId;


    /**
     * compte de vente en local non taxable
     */
    private String fammedCompteNonTaxable;


    /**
     * code service de vente
     */
    private String fammedService;

    private Long exevteId;

}
