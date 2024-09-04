package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_convention_medical")
public class MedConventionMedical implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cvn_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cvnId;

    /**
     * date de creation
     */
    @Column(name = "cvn_date_creat")
    private LocalDateTime cvnDateCreat;

    /**
     * date de modification
     */
    @Column(name = "cvn_date_modif")
    private LocalDateTime cvnDateModif;

    /**
     * user de creation
     */
    @Column(name = "cvn_user_creat")
    private Long cvnUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "cvn_user_modif")
    private Long cvnUserModif = 0L;

    /**
     * type (lettre, produit...)
     */
    @Column(name = "cvn_type")
    private String cvnType;

    /**
     * code lettre
     */
    @Column(name = "cvn_lettre")
    private String cvnLettre;

    /**
     * libelle
     */
    @Column(name = "cvn_libelle")
    private String cvnLibelle;

    /**
     * valeur de la lettre
     */
    @Column(name = "cvn_valeur")
    private Double cvnValeur = 0D;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

    @Column(name = "exevte_id")
    private Long exevteId;

}
