package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_familles_parc1")
public class PrcFamillesParc1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "famprc1_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long famprc1Id;

    /**
     * date de creation
     */
    @Column(name = "famprc1_date_creation")
    private LocalDateTime famprc1DateCreation;

    /**
     * date de modification
     */
    @Column(name = "famprc1_date_modif")
    private LocalDateTime famprc1DateModif;

    /**
     * user de creation
     */
    @Column(name = "famprc1_user_creation")
    private Long famprc1UserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "famprc1_user_modif")
    private Long famprc1UserModif = 0L;

    /**
     * suivant code xml
     */
    @Column(name = "famprc1_nature")
    private Integer famprc1Nature = 0;

    /**
     * libelle nature
     */
    @Column(name = "famprc1_lib_nature")
    private String famprc1LibNature;

    /**
     * code famille parc
     */
    @Column(name = "famprc1_code")
    private String famprc1Code;

    /**
     * libelle famille parc en FR
     */
    @Column(name = "famprc1_libelle_fr")
    private String famprc1LibelleFr;

    /**
     * libelle famille parc en UK
     */
    @Column(name = "famprc1_libelle_uk")
    private String famprc1LibelleUk;

    /**
     * libelle famille parc en SP
     */
    @Column(name = "famprc1_libelle_sp")
    private String famprc1LibelleSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "famprc1_inactif")
    private Integer famprc1Inactif = 0;

}
