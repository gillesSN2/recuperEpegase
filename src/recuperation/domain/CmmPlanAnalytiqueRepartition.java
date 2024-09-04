package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_plan_analytique_repartition")
public class CmmPlanAnalytiqueRepartition implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cle_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cleId;

    /**
     * ordre des lignes
     */
    @Column(name = "cle_ordre")
    private Integer cleOrdre = 0;

    /**
     * code activite
     */
    @Column(name = "cle_code_activite")
    private String cleCodeActivite;

    /**
     * libelle activite
     */
    @Column(name = "cle_libelle_activite")
    private String cleLibelleActivite;

    /**
     * repartition activite
     */
    @Column(name = "cle_rep_activite")
    private Double cleRepActivite = 0D;

    /**
     * code site
     */
    @Column(name = "cle_code_site")
    private String cleCodeSite;

    /**
     * libelle site
     */
    @Column(name = "cle_libelle_site")
    private String cleLibelleSite;

    /**
     * repartition site
     */
    @Column(name = "cle_rep_site")
    private Double cleRepSite = 0D;

    /**
     * code departement
     */
    @Column(name = "cle_code_departement")
    private String cleCodeDepartement;

    /**
     * libelle departement
     */
    @Column(name = "cle_libelle_departement")
    private String cleLibelleDepartement;

    /**
     * repartition departement
     */
    @Column(name = "cle_rep_departement")
    private Double cleRepDepartement = 0D;

    /**
     * code service
     */
    @Column(name = "cle_code_service")
    private String cleCodeService;

    /**
     * libelle service
     */
    @Column(name = "cle_libelle_service")
    private String cleLibelleService;

    /**
     * repartition service
     */
    @Column(name = "cle_rep_service")
    private Double cleRepService = 0D;

    /**
     * code region
     */
    @Column(name = "cle_code_region")
    private String cleCodeRegion;

    /**
     * libelle region
     */
    @Column(name = "cle_libelle_region")
    private String cleLibelleRegion;

    /**
     * repartition region
     */
    @Column(name = "cle_rep_region")
    private Double cleRepRegion = 0D;

    /**
     * code secteur
     */
    @Column(name = "cle_code_secteur")
    private String cleCodeSecteur;

    /**
     * libelle secteur
     */
    @Column(name = "cle_libelle_secteur")
    private String cleLibelleSecteur;

    /**
     * repartition secteur
     */
    @Column(name = "cle_rep_secteur")
    private Double cleRepSecteur = 0D;

    /**
     * code pdv
     */
    @Column(name = "cle_code_pdv")
    private String cleCodePdv;

    /**
     * libelle pdv
     */
    @Column(name = "cle_libelle_pdv")
    private String cleLibellePdv;

    /**
     * repartition pdv
     */
    @Column(name = "cle_rep_pdv")
    private Double cleRepPdv = 0D;

    /**
     * code ligne
     */
    @Column(name = "cle_code_ligne")
    private String cleCodeLigne;

    /**
     * libelle ligne
     */
    @Column(name = "cle_libelle_ligne")
    private String cleLibelleLigne;

    /**
     * repartition ligne
     */
    @Column(name = "cle_rep_ligne")
    private Double cleRepLigne = 0D;

    /**
     * code atelier
     */
    @Column(name = "cle_code_atelier")
    private String cleCodeAtelier;

    /**
     * libelle atelier
     */
    @Column(name = "cle_libelle_atelier")
    private String cleLibelleAtelier;

    /**
     * repartition atelier
     */
    @Column(name = "cle_rep_atelier")
    private Double cleRepAtelier = 0D;

    /**
     * code dossier
     */
    @Column(name = "cle_code_dossier")
    private String cleCodeDossier;

    /**
     * libelle dossier
     */
    @Column(name = "cle_libelle_dossier")
    private String cleLibelleDossier;

    /**
     * repartition dossier
     */
    @Column(name = "cle_rep_dossier")
    private Double cleRepDossier = 0D;

    /**
     * code mission
     */
    @Column(name = "cle_code_parc")
    private String cleCodeParc;

    /**
     * libelle parc
     */
    @Column(name = "cle_libelle_parc")
    private String cleLibelleParc;

    /**
     * repartition parc
     */
    @Column(name = "cle_rep_parc")
    private Double cleRepParc = 0D;

    /**
     * code agent
     */
    @Column(name = "cle_code_agent")
    private String cleCodeAgent;

    /**
     * libelle agent
     */
    @Column(name = "cle_libelle_agent")
    private String cleLibelleAgent;

    /**
     * repartition agent
     */
    @Column(name = "cle_rep_agent")
    private Double cleRepAgent = 0D;

    @Column(name = "ana_id", nullable = false)
    private Long anaId;

}
