package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_taches")
public class CmmTaches implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tac_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tacId;

    /**
     * date de creation
     */
    @Column(name = "tac_date_creat")
    private LocalDateTime tacDateCreat;

    /**
     * date de modification
     */
    @Column(name = "tac_date_modif")
    private LocalDateTime tacDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "tac_user_creat")
    private Long tacUserCreat = 0L;

    /**
     * utilisateur de creation
     */
    @Column(name = "tac_user_modif")
    private Long tacUserModif = 0L;

    /**
     * code tache
     */
    @Column(name = "tac_code")
    private String tacCode;

    /**
     * libelle FR
     */
    @Column(name = "tac_nom_FR")
    private String tacNomFr;

    /**
     * libelle UK
     */
    @Column(name = "tac_nom_UK")
    private String tacNomUk;

    /**
     * libelle UK
     */
    @Column(name = "tac_nom_SP")
    private String tacNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "tac_inactif")
    private Integer tacInactif = 0;

    /**
     * prix de revient de la tache
     */
    @Column(name = "tac_val_pr")
    private Float tacValPr = 0F;

    /**
     * prix de vente de la tache
     */
    @Column(name = "tac_val_pv")
    private Float tacValPv = 0F;

    /**
     * nombre de jour
     */
    @Column(name = "tac_val_jj")
    private Integer tacValJj = 0;

    /**
     * nombre heures
     */
    @Column(name = "tac_val_hh")
    private Integer tacValHh = 0;

    /**
     * nombre de minutes
     */
    @Column(name = "tac_val_mm")
    private Integer tacValMm = 0;

    /**
     * nombre de seconde
     */
    @Column(name = "tac_val_ss")
    private Integer tacValSs = 0;

}
