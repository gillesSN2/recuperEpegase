package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_pathologie")
public class MedPathologie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "phl_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phlId;

    /**
     * user de creation
     */
    @Column(name = "phl_user_creat")
    private Long phlUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "phl_user_modif")
    private Long phlUserModif = 0L;

    /**
     * dat de ceration
     */
    @Column(name = "phl_date_creat")
    private LocalDateTime phlDateCreat;

    /**
     * date de modification
     */
    @Column(name = "phl_date_modif")
    private LocalDateTime phlDateModif;

    /**
     * code du protocole
     */
    @Column(name = "phl_code")
    private String phlCode;

    /**
     * libelle du protocole
     */
    @Column(name = "phl_libelle")
    private String phlLibelle;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "phl_inactif")
    private Integer phlInactif = 0;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "exevte_id")
    private Long exevteId;

}
