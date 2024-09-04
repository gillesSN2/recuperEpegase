package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_process_entete")
public class AchProcessEntete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "proces_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long procesId;

    /**
     * date de creation
     */
    @Column(name = "proces_date_creat")
    private LocalDateTime procesDateCreat;

    /**
     * date de modification
     */
    @Column(name = "proces_date_modif")
    private LocalDateTime procesDateModif;

    /**
     * id user createur
     */
    @Column(name = "proces_user_creat")
    private Long procesUserCreat = 0L;

    /**
     * id user de modification
     */
    @Column(name = "proces_user_modif")
    private Long procesUserModif = 0L;

    /**
     * code produit
     */
    @Column(name = "proces_code")
    private String procesCode;

    /**
     * libelle client
     */
    @Column(name = "proces_lib_client")
    private String procesLibClient;

    /**
     * libelle technique
     */
    @Column(name = "proces_lib_tech")
    private String procesLibTech;

    /**
     * depot de stockage
     */
    @Column(name = "proces_depot")
    private String procesDepot;

    /**
     * unite
     */
    @Column(name = "proces_unite")
    private String procesUnite;

    /**
     * coefficient
     */
    @Column(name = "proces_coef")
    private Float procesCoef = 0F;

    /**
     * site
     */
    @Column(name = "proces_site")
    private String procesSite;

    /**
     * ligne
     */
    @Column(name = "proces_ligne")
    private String procesLigne;

    /**
     * atelier
     */
    @Column(name = "proces_atelier")
    private String procesAtelier;

    /**
     * code acitivite commerciale
     */
    @Column(name = "proces_activite")
    private String procesActivite;

    /**
     * total pump
     */
    @Column(name = "proces_tot_pump")
    private Double procesTotPump = 0D;

    /**
     * 0=actif 1=inactif
     */
    @Column(name = "proces_inactif")
    private Integer procesInactif = 0;

}
