package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_conditionnement")
public class CmmConditionnement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cdt_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdtId;

    /**
     * date de creation
     */
    @Column(name = "cdt_date_creation")
    private LocalDateTime cdtDateCreation;

    /**
     * date de modification
     */
    @Column(name = "cdt_date_modif")
    private LocalDateTime cdtDateModif;

    /**
     * user de creation
     */
    @Column(name = "cdt_user_creation")
    private Long cdtUserCreation = 0L;

    /**
     * user de modification
     */
    @Column(name = "cdt_user_modif")
    private Long cdtUserModif = 0L;

    /**
     * libelle conditionnement
     */
    @Column(name = "cdt_libelle")
    private String cdtLibelle;

    /**
     * description du conditionnement
     */
    @Column(name = "cdt_description")
    private String cdtDescription;

    /**
     * quantite 1n
     */
    @Column(name = "cdt_coef1")
    private Float cdtCoef1 = 0F;

    /**
     * unite
     */
    @Column(name = "cdt_unite1")
    private String cdtUnite1;

    /**
     * code unite
     */
    @Column(name = "cdt_code_unite1")
    private String cdtCodeUnite1;

    /**
     * quantite 2
     */
    @Column(name = "cdt_coef2")
    private Float cdtCoef2 = 0F;

    /**
     * unite
     */
    @Column(name = "cdt_unite2")
    private String cdtUnite2;

    /**
     * code unite
     */
    @Column(name = "cdt_code_unite2")
    private String cdtCodeUnite2;

    /**
     * longueur 2
     */
    @Column(name = "cdt_long2")
    private Float cdtLong2 = 0F;

    /**
     * largeur 2
     */
    @Column(name = "cdt_larg2")
    private Float cdtLarg2 = 0F;

    /**
     * hauteur 2
     */
    @Column(name = "cdt_haut2")
    private Float cdtHaut2 = 0F;

    /**
     * diametre 2
     */
    @Column(name = "cdt_diam2")
    private Float cdtDiam2 = 0F;

    /**
     * nombre 2
     */
    @Column(name = "cdt_nb2")
    private Float cdtNb2 = 0F;

    /**
     * libelle prochain conditionnement
     */
    @Column(name = "cdt_suite")
    private String cdtSuite;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "cdt_inactif")
    private Integer cdtInactif = 0;

}
