package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_familles_parc2")
public class PrcFamillesParc2 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "famprc2_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long famprc2Id;

    /**
     * date de creation
     */
    @Column(name = "famprc2_date_creation")
    private LocalDateTime famprc2DateCreation;

    /**
     * date de modification
     */
    @Column(name = "famprc2_date_modif")
    private LocalDateTime famprc2DateModif;

    /**
     * user de creation
     */
    @Column(name = "famprc2_user_creation")
    private Long famprc2UserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "famprc2_user_modif")
    private Long famprc2UserModif = 0L;

    /**
     * code famille parc
     */
    @Column(name = "famprc2_code")
    private String famprc2Code;

    /**
     * libelle famille parc en FR
     */
    @Column(name = "famprc2_libelle_fr")
    private String famprc2LibelleFr;

    /**
     * libelle famille parc en UK
     */
    @Column(name = "famprc2_libelle_uk")
    private String famprc2LibelleUk;

    /**
     * libelle famille parc en SP
     */
    @Column(name = "famprc2_libelle_sp")
    private String famprc2LibelleSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "famprc2_inactif")
    private Integer famprc2Inactif = 0;

    @Column(name = "famprc1_id", nullable = false)
    private Long famprc1Id;

}
