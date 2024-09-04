package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_motif_entree")
public class PrcMotifEntree implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mtp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mtpId;

    /**
     * user de creation
     */
    @Column(name = "mtp_user_creat")
    private Long mtpUserCreat = 0L;

    /**
     * user de modification
     */
    @Column(name = "mtp_user_modif")
    private Long mtpUserModif = 0L;

    /**
     * date de creation
     */
    @Column(name = "mtp_date_creat")
    private LocalDateTime mtpDateCreat;

    /**
     * date de modification
     */
    @Column(name = "mtp_date_modif")
    private LocalDateTime mtpDateModif;

    /**
     * code du motif
     */
    @Column(name = "mtp_code")
    private String mtpCode;

    /**
     * libelle du motif
     */
    @Column(name = "mtp_libelle")
    private String mtpLibelle;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "mtp_inactif")
    private Integer mtpInactif = 0;

    /**
     * code famille
     */
    @Column(name = "mtp_famille")
    private String mtpFamille;

    /**
     * type de motif
     */
    @Column(name = "mtp_type")
    private String mtpType;

}
