package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "med_protocole")
public class MedProtocole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prtId;

    /**
     * user de creation
     */
    @Column(name = "prt_user_creat")
    private Long prtUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "prt_user_modif")
    private Long prtUserModif = 0L;

    /**
     * dat de ceration
     */
    @Column(name = "prt_date_creat")
    private LocalDateTime prtDateCreat;

    /**
     * date de modification
     */
    @Column(name = "prt_date_modif")
    private LocalDateTime prtDateModif;

    /**
     * code du protocole
     */
    @Column(name = "prt_code")
    private String prtCode;

    /**
     * libelle du protocole
     */
    @Column(name = "prt_libelle")
    private String prtLibelle;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "prt_inactif")
    private Integer prtInactif = 0;

    @Column(name = "exemed_id", nullable = false)
    private Long exemedId;

    @Column(name = "exevte_id")
    private Long exevteId;

}
