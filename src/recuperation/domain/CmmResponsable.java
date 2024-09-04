package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_responsable")
public class CmmResponsable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "rpb_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rpbId;

    /**
     * date de creation
     */
    @Column(name = "rpb_date_creat")
    private LocalDateTime rpbDateCreat;

    /**
     * date de modification
     */
    @Column(name = "rpb_date_modif")
    private LocalDateTime rpbDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "rpb_user_creat")
    private Long rpbUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "rpb_user_modif")
    private Long rpbUserModif = 0L;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "rpb_etat")
    private Integer rpbEtat = 0;

    /**
     * id du responsable
     */
    @Column(name = "rpb_user_id")
    private Long rpbUserId = 0L;

    /**
     * nom responsable
     */
    @Column(name = "rpb_nom")
    private String rpbNom;

    /**
     * prenom
     */
    @Column(name = "rpb_prenom")
    private String rpbPrenom;

    /**
     * fonction
     */
    @Column(name = "rpb_categorie")
    private String rpbCategorie;

    /**
     * civilite (suivant fichier xml)
     */
    @Column(name = "rpb_civilite")
    private String rpbCivilite;

    /**
     * date de debut
     */
    @Column(name = "rpb_date_debut")
    private LocalDateTime rpbDateDebut;

    /**
     * date de fin
     */
    @Column(name = "rpb_date_fin")
    private LocalDateTime rpbDateFin;

    /**
     * 1= defaut
     */
    @Column(name = "rpb_defaut")
    private Integer rpbDefaut = 0;

    @Column(name = "tie_id", nullable = false)
    private Long tieId;

}
