package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_racines")
public class CptRacines implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rac_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long racId;

    /**
     * code racine
     */
    @Column(name = "rac_code")
    private String racCode;

    /**
     * libelle FR
     */
    @Column(name = "rac_libelle_fr")
    private String racLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "rac_libelle_uk")
    private String racLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "rac_libelle_sp")
    private String racLibelleSp;

    /**
     * nature racine
     */
    @Column(name = "rac_nature")
    private String racNature;

    /**
     * code racine
     */
    @Column(name = "rac_codenature")
    private String racCodenature;

    /**
     * taux de taxe
     */
    @Column(name = "rac_taux_taxe")
    private Float racTauxTaxe = 0F;

    /**
     * 0=pas dernier niveau 1=dernier niveau
     */
    @Column(name = "rac_util")
    private String racUtil;

}
