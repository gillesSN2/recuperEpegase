package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_frais_theo_achats")
public class AchFraisTheoAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "fst_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fstId;

    /**
     * date de creation
     */
    @Column(name = "fst_date_creat")
    private LocalDateTime fstDateCreat;

    /**
     * date de modification
     */
    @Column(name = "fst_date_modif")
    private LocalDateTime fstDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "fst_user_creat")
    private Long fstUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "fst_user_modif")
    private Long fstUserModif = 0L;

    /**
     * nom de la feuille
     */
    @Column(name = "fst_feuille")
    private String fstFeuille;

    /**
     * type de la feuille
     */
    @Column(name = "fst_type")
    private Integer fstType = 0;

    /**
     * code frais
     */
    @Column(name = "fst_code")
    private String fstCode;

    /**
     * nom frais en FR
     */
    @Column(name = "fst_nom_FR")
    private String fstNomFr;

    /**
     * nom frais en UK
     */
    @Column(name = "fst_nom_UK")
    private String fstNomUk;

    /**
     * nom frais en SP
     */
    @Column(name = "fst_nom_SP")
    private String fstNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "fst_inactif")
    private Integer fstInactif = 0;

    /**
     * annee de debut de validite
     */
    @Column(name = "fst_taux")
    private Float fstTaux = 0F;

    /**
     * formule
     */
    @Column(name = "fst_formule")
    private String fstFormule;

    /**
     * ordre de la ligne
     */
    @Column(name = "fst_ordre")
    private Integer fstOrdre = 0;

    /**
     * autorise dans la colonne ht
     */
    @Column(name = "fst_col_ht")
    private Boolean fstColHt = Boolean.FALSE;

    /**
     * autorise dans la colonne exo partielle
     */
    @Column(name = "fst_col_exop")
    private Boolean fstColExop = Boolean.FALSE;

    /**
     * autorise dans la colonne exo totale
     */
    @Column(name = "fst_col_exot")
    private Boolean fstColExot = Boolean.FALSE;

    /**
     * 0=standard 1=prc 2=prg
     */
    @Column(name = "fst_col_type")
    private Integer fstColType = 0;

}
