package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_metiers")
public class CmmMetiers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "met_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metId;

    /**
     * date de creation
     */
    @Column(name = "met_date_creat")
    private LocalDateTime metDateCreat;

    /**
     * date de modification
     */
    @Column(name = "met_date_modif")
    private LocalDateTime metDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "met_user_creat")
    private Long metUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "met_user_modif")
    private Long metUserModif = 0L;

    /**
     * nom activite en FR
     */
    @Column(name = "met_nom_FR")
    private String metNomFr;

    /**
     * nom activite en UK
     */
    @Column(name = "met_nom_UK")
    private String metNomUk;

    /**
     * nom activite en SP
     */
    @Column(name = "met_nom_SP")
    private String metNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "met_inactif")
    private Integer metInactif = 0;

    /**
     * 0=personne physique 1=personne morale
     */
    @Column(name = "met_type")
    private Integer metType = 0;

}
