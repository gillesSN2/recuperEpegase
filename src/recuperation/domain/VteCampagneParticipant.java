package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vte_campagne_participant")
public class VteCampagneParticipant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "campar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long camparId;

    /**
     * date de creation
     */
    @Column(name = "campar_date_creat")
    private LocalDateTime camparDateCreat;

    /**
     * date de modification
     */
    @Column(name = "campar_date_modif")
    private LocalDateTime camparDateModif;

    /**
     * id user createur
     */
    @Column(name = "campar_id_createur")
    private Long camparIdCreateur = 0L;

    /**
     * nom du createur
     */
    @Column(name = "campar_nom_createur")
    private String camparNomCreateur;

    /**
     * id user de modification
     */
    @Column(name = "campar_id_modif")
    private Long camparIdModif = 0L;

    /**
     * nom user de modification
     */
    @Column(name = "campar_nom_modif")
    private String camparNomModif;

    /**
     * date evenement
     */
    @Column(name = "campar_date")
    private LocalDateTime camparDate;

    /**
     * commentaire du contact
     */
    @Column(name = "campar_commentaire")
    private String camparCommentaire;

    /**
     * action a faire
     */
    @Column(name = "campar_action")
    private String camparAction;

    /**
     * cadeau au contact
     */
    @Column(name = "campar_cadeau")
    private String camparCadeau;

    /**
     * nom tiers
     */
    @Column(name = "campar_nom_tiers")
    private String camparNomTiers;

    /**
     * id du tiers
     */
    @Column(name = "campar_id_tiers")
    private Long camparIdTiers = 0L;

    @Column(name = "cam_id", nullable = false)
    private Long camId;

    @Column(name = "con_id", nullable = false)
    private Long conId;

}
