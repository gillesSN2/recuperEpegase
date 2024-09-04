package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_couleur")
public class CmmCouleur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cou_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couId;

    /**
     * date de creation
     */
    @Column(name = "mcou_date_creation")
    private LocalDateTime mcouDateCreation;

    /**
     * date de modification
     */
    @Column(name = "cou_date_modif")
    private LocalDateTime couDateModif;

    /**
     * user de creation
     */
    @Column(name = "cou_user_creation")
    private Long couUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "cou_user_modif")
    private Long couUserModif = 0L;

    /**
     * libelle FR
     */
    @Column(name = "cou_libelle_fr")
    private String couLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "cou_libelle_uk")
    private String couLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "cou_libelle_sp")
    private String couLibelleSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "cou_inactif")
    private Integer couInactif = 0;

}
