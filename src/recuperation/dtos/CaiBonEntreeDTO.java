package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiBonEntreeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long entrId;


    /**
     * concvactenation du numero et de la nature
     */
    private String entrCle;


    /**
     * date de creation
     */
    private LocalDateTime entrDateCreat;


    /**
     * user de creation
     */
    private Long entrUserCreat;


    /**
     * date de modification
     */
    private LocalDateTime entrDateModif;


    /**
     * user de modification
     */
    private Long entrUserModif;


    /**
     * nature du bonument
     */
    private Integer entrNature;


    /**
     * date
     */
    private LocalDate entrDate;


    /**
     * numero du bon
     */
    private String entrNum;


    /**
     * nom du responsable
     */
    private String entrNomResponsable;


    /**
     * nom du tiers
     */
    private String entrNomTiers;


    /**
     * id du tiers
     */
    private Long entrIdTiers;


    /**
     * type du tiers 0:client,1:Fournisseur,2:Agent,3:PlanComptable 4=patient 5=eleve
     */
    private Integer entrTypeTiers;


    /**
     * 0=entree normale 1=depot dans compte tiers
     */
    private Integer entrDepotTiers;


    /**
     * serie
     */
    private String entrSerie;


    /**
     * libelle
     */
    private String entrLibelle;


    /**
     * devise
     */
    private String entrDevise;


    /**
     * montant
     */
    private Double entrMontant;


    /**
     * tye de reglement
     */
    private Integer entrTypeReg;


    /**
     * activite
     */
    private String entrActivite;


    /**
     * site
     */
    private String entrSite;


    /**
     * departement
     */
    private String entrDepartement;


    /**
     * service
     */
    private String entrService;


    /**
     * region
     */
    private String entrRegion;


    /**
     * secteur
     */
    private String entrSecteur;


    /**
     * Pdv
     */
    private String entrPdv;


    /**
     * budget
     */
    private String entrBudget;


    /**
     * etat 0=a encaisser ; 1=regler
     */
    private Integer entrEtat;


    /**
     * date de valeur
     */
    private LocalDate entrDateRelance;


    /**
     * 0 actif, 1 inactif
     */
    private Integer entrActif;


    /**
     * modele impression recu
     */
    private String entrModeleImp;


    /**
     * date impression recu
     */
    private LocalDateTime entrDateImpression;


    /**
     * code d la caisse du bon
     */
    private String entrCodeCaiss;


    /**
     * libelle d la caisse du bon
     */
    private String entrLibCaiss;


    /**
     * code banque du bon
     */
    private String entrCodeBanq;


    /**
     * libelle banque du bon
     */
    private String entrLibBanq;

    private Long execaiId;


    /**
     * montant disponible sur budget
     */
    private Double entrBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double entrBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double entrBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double entrBudgetTresoMois;


    /**
     * dossier
     */
    private String entrDossier;


    /**
     * parc
     */
    private String entrParc;


    /**
     * banque emetteur
     */
    private String entrBanqueTireur;


    /**
     * numero cheque ou bordereau
     */
    private String entrNumChqBdx;


    /**
     * code budget
     */
    private String entrCodeBudgetTreso;


    /**
     * code poste
     */
    private String entrCodePosteTreso;

}
