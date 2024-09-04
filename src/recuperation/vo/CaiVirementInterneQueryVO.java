package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CaiVirementInterneQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long virId;


    /**
     * concactenation du numero et de la nature
     */
    private String virCle;


    /**
     * date de creation
     */
    private LocalDateTime virDateCreat;


    /**
     * user de creation
     */
    private Long virUserCreat;


    /**
     * date de modification
     */
    private LocalDateTime virDateModif;


    /**
     * user de creation
     */
    private Long virUserModif;


    /**
     * nature du bonument
     */
    private Integer virNature;


    /**
     * numero du bon
     */
    private String virNum;


    /**
     * date
     */
    private LocalDate virDate;


    /**
     * nom du responsable
     */
    private String virNomResponsable;


    /**
     * code joural de emetrice
     */
    private String virCodEmetrice;


    /**
     * nom de emetrice
     */
    private String virNomEmetrice;


    /**
     * code joural du recepteur
     */
    private String virCodReceptrice;


    /**
     * nom de la receptrice
     */
    private String virNomReceptrice;


    /**
     * serie
     */
    private String virSerie;


    /**
     * libelle
     */
    private String virLibelle;


    /**
     * devise
     */
    private String virDevise;


    /**
     * montant
     */
    private Double virMontant;


    /**
     * tye de reglement
     */
    private Integer virTypeReg;


    /**
     * etat 0=a payer ; 1=regle
     */
    private Integer virEtat;


    /**
     * date de valeur
     */
    private LocalDate virDateValeur;


    /**
     * 0 actif, 1 inactif
     */
    private Integer virActif;


    /**
     * code de la caisse
     */
    private String virCodeCaiss;


    /**
     * libelle de la caisse
     */
    private String virLibCaiss;


    /**
     * activite
     */
    private String virActivite;


    /**
     * site
     */
    private String virSite;


    /**
     * departement
     */
    private String virDepartement;


    /**
     * service
     */
    private String virService;


    /**
     * region
     */
    private String virRegion;


    /**
     * secteur
     */
    private String virSecteur;


    /**
     * Pdv
     */
    private String virPdv;


    /**
     * budget
     */
    private String virBudget;

    private Long execaiId;


    /**
     * montant disponible sur budget
     */
    private Double virBudgetDispo;


    /**
     * montant disponible sur treso
     */
    private Double virBudgetTreso;


    /**
     * budget mensuel dispo
     */
    private Double virBudgetDispoMois;


    /**
     * budget mensuel treso
     */
    private Double virBudgetTresoMois;


    /**
     * dossier
     */
    private String virDossier;


    /**
     * parc
     */
    private String virParc;


    /**
     * numero cheque ou bordereau
     */
    private String virNumChqBdx;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer virEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer virGele;


    /**
     * date de validation
     */
    private LocalDate virDateValide;


    /**
     * modele impression recu
     */
    private String virModeleImp;


    /**
     * date impression recu
     */
    private LocalDateTime virDateImpression;


    /**
     * code budget
     */
    private String virCodeBudgetTreso;


    /**
     * code poste
     */
    private String virCodePosteTreso;

}
