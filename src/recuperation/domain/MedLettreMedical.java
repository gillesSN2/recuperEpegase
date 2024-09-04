package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_lettre_medical")
public class MedLettreMedical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "let_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letId;

    /**
     * date de creation
     */
    @Column(name = "let_date_creat")
    private LocalDateTime letDateCreat;

    /**
     * date de modification
     */
    @Column(name = "let_date_modif")
    private LocalDateTime letDateModif;

    /**
     * user de creation
     */
    @Column(name = "let_user_creat")
    private Long letUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "let_user_modif")
    private Long letUserModif = 0L;

    /**
     * code lettre
     */
    @Column(name = "let_lettre")
    private String letLettre;

    /**
     * libelle FR
     */
    @Column(name = "let_libelle_FR")
    private String letLibelleFr;

    /**
     * libelle UK
     */
    @Column(name = "let_libelle_UK")
    private String letLibelleUk;

    /**
     * libelle SP
     */
    @Column(name = "let_libelle_SP")
    private String letLibelleSp;

    /**
     * valeur de la lettre
     */
    @Column(name = "let_valeur")
    private Double letValeur = 0D;

    /**
     * 1=inactif 2=supprimer
     */
    @Column(name = "let_inactif")
    private Integer letInactif = 0;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "exevte_id")
    private Long exevteId;

}
