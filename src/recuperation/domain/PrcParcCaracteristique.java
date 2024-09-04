package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_parc_caracteristique")
public class PrcParcCaracteristique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prccar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prccarId;

    /**
     * date creation
     */
    @Column(name = "prccar_date_creat")
    private LocalDateTime prccarDateCreat;

    /**
     * date modification
     */
    @Column(name = "prccar_date_modif")
    private LocalDateTime prccarDateModif;

    /**
     * id user de creation
     */
    @Column(name = "prccar_user_creat")
    private Long prccarUserCreat = 0L;

    /**
     * id user de modification
     */
    @Column(name = "prccar_user_modif")
    private Long prccarUserModif = 0L;

    /**
     * code nature
     */
    @Column(name = "prccar_nature")
    private String prccarNature;

    /**
     * libelle nature
     */
    @Column(name = "prccar_lib_nature")
    private String prccarLibNature;

    /**
     * 0=caracteristique 1=inventaire
     */
    @Column(name = "prccar_type")
    private Integer prccarType = 0;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "prccar_inactif")
    private Integer prccarInactif = 0;

    /**
     * 0=organe mecanique 1=equipement 2=pneumatique 3=autre
     */
    @Column(name = "prccar_organe")
    private Integer prccarOrgane = 0;

    /**
     * libelle caracteristique
     */
    @Column(name = "prccar_libelle")
    private String prccarLibelle;

    @Column(name = "prc_id")
    private Long prcId;

}
