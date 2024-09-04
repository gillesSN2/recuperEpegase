package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_point_de_vente")
public class CmmPointDeVente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "pdv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pdvId;

    /**
     * date de creation
     */
    @Column(name = "pdv_date_creat")
    private LocalDateTime pdvDateCreat;

    /**
     * date de modification
     */
    @Column(name = "pdv_date_modif")
    private LocalDateTime pdvDateModif;

    /**
     * utilisateur de modification
     */
    @Column(name = "pdv_user_creat")
    private Long pdvUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "pdv_user_modif")
    private Long pdvUserModif = 0L;

    /**
     * code de pdv
     */
    @Column(name = "pdv_code")
    private String pdvCode;

    /**
     * nom du pdv en FR
     */
    @Column(name = "pdv_nom_FR")
    private String pdvNomFr;

    /**
     * nom du pdv en UK
     */
    @Column(name = "pdv_nom_UK")
    private String pdvNomUk;

    /**
     * nom du pdv en SP
     */
    @Column(name = "pdv_nom_SP")
    private String pdvNomSp;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "pdv_inactif")
    private Integer pdvInactif = 0;

    /**
     * % de repartition par rapport au secteur
     */
    @Column(name = "pdv_pourcentage")
    private Float pdvPourcentage = 0F;

    @Column(name = "reg_id", nullable = false)
    private Long regId;

    @Column(name = "sec_id", nullable = false)
    private Long secId;

    /**
     * id responsable
     */
    @Column(name = "pdv_id_responsable")
    private Long pdvIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "pdv_nom_responsable")
    private String pdvNomResponsable;

}
