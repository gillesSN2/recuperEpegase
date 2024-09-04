package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prc_caracteristique")
public class PrcCaracteristique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "car_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    /**
     * date creation
     */
    @Column(name = "car_date_creat")
    private LocalDateTime carDateCreat;

    /**
     * date modification
     */
    @Column(name = "car_date_modif")
    private LocalDateTime carDateModif;

    /**
     * id user de creation
     */
    @Column(name = "car_user_creat")
    private Long carUserCreat = 0L;

    /**
     * id user de modification
     */
    @Column(name = "car_user_modif")
    private Long carUserModif = 0L;

    /**
     * code nature
     */
    @Column(name = "car_nature")
    private Integer carNature = 0;

    /**
     * libelle nature
     */
    @Column(name = "car_lib_nature")
    private String carLibNature;

    /**
     * code famille
     */
    @Column(name = "car_famille")
    private String carFamille;

    /**
     * libelle famille
     */
    @Column(name = "car_lib_famille")
    private String carLibFamille;

    /**
     * code famille
     */
    @Column(name = "car_sous_famille")
    private String carSousFamille;

    /**
     * libelle famille
     */
    @Column(name = "car_lib_sous_famille")
    private String carLibSousFamille;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "car_inactif")
    private Integer carInactif = 0;

    /**
     * 0=nr 1=mecanique 2=hydraulique 3=elctrique 4=pneumatique 5=equipement 9=autre
     */
    @Column(name = "car_organe")
    private Integer carOrgane = 0;

    /**
     * 0=document administratif 1=document technique 2=outils 3=consommable 4=piece 5=accessoire 9=autre
     */
    @Column(name = "car_inventaire")
    private Integer carInventaire = 0;

    /**
     * 0=caracteristique 1=inventaire
     */
    @Column(name = "car_type")
    private Integer carType = 0;

    /**
     * libelle caracteristique
     */
    @Column(name = "car_libelle")
    private String carLibelle;

    @Column(name = "famprc1_id", nullable = false)
    private Long famprc1Id;

}
