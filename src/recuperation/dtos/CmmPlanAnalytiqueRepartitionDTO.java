package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmPlanAnalytiqueRepartitionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cleId;


    /**
     * ordre des lignes
     */
    private Integer cleOrdre;


    /**
     * code activite
     */
    private String cleCodeActivite;


    /**
     * libelle activite
     */
    private String cleLibelleActivite;


    /**
     * repartition activite
     */
    private Double cleRepActivite;


    /**
     * code site
     */
    private String cleCodeSite;


    /**
     * libelle site
     */
    private String cleLibelleSite;


    /**
     * repartition site
     */
    private Double cleRepSite;


    /**
     * code departement
     */
    private String cleCodeDepartement;


    /**
     * libelle departement
     */
    private String cleLibelleDepartement;


    /**
     * repartition departement
     */
    private Double cleRepDepartement;


    /**
     * code service
     */
    private String cleCodeService;


    /**
     * libelle service
     */
    private String cleLibelleService;


    /**
     * repartition service
     */
    private Double cleRepService;


    /**
     * code region
     */
    private String cleCodeRegion;


    /**
     * libelle region
     */
    private String cleLibelleRegion;


    /**
     * repartition region
     */
    private Double cleRepRegion;


    /**
     * code secteur
     */
    private String cleCodeSecteur;


    /**
     * libelle secteur
     */
    private String cleLibelleSecteur;


    /**
     * repartition secteur
     */
    private Double cleRepSecteur;


    /**
     * code pdv
     */
    private String cleCodePdv;


    /**
     * libelle pdv
     */
    private String cleLibellePdv;


    /**
     * repartition pdv
     */
    private Double cleRepPdv;


    /**
     * code ligne
     */
    private String cleCodeLigne;


    /**
     * libelle ligne
     */
    private String cleLibelleLigne;


    /**
     * repartition ligne
     */
    private Double cleRepLigne;


    /**
     * code atelier
     */
    private String cleCodeAtelier;


    /**
     * libelle atelier
     */
    private String cleLibelleAtelier;


    /**
     * repartition atelier
     */
    private Double cleRepAtelier;


    /**
     * code dossier
     */
    private String cleCodeDossier;


    /**
     * libelle dossier
     */
    private String cleLibelleDossier;


    /**
     * repartition dossier
     */
    private Double cleRepDossier;


    /**
     * code mission
     */
    private String cleCodeParc;


    /**
     * libelle parc
     */
    private String cleLibelleParc;


    /**
     * repartition parc
     */
    private Double cleRepParc;


    /**
     * code agent
     */
    private String cleCodeAgent;


    /**
     * libelle agent
     */
    private String cleLibelleAgent;


    /**
     * repartition agent
     */
    private Double cleRepAgent;

    private Long anaId;

}
