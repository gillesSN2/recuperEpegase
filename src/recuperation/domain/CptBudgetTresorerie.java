package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_budget_tresorerie")
public class CptBudgetTresorerie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bud_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budId;

    /**
     * date de creation
     */
    @Column(name = "bud_date_creat")
    private LocalDateTime budDateCreat;

    /**
     * date de modification
     */
    @Column(name = "bud_date_modif")
    private LocalDateTime budDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "bud_user_creat")
    private Long budUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "bud_user_modif")
    private Long budUserModif = 0L;

    /**
     * code projet
     */
    @Column(name = "bud_projet")
    private String budProjet;

    /**
     * annee de definition
     */
    @Column(name = "bud_annee")
    private String budAnnee;

    /**
     * code budget
     */
    @Column(name = "bud_code")
    private String budCode;

    /**
     * libelle du budget en FR
     */
    @Column(name = "bud_libelle_FR")
    private String budLibelleFr;

    /**
     * libelle du budget en UK
     */
    @Column(name = "bud_libelle_UK")
    private String budLibelleUk;

    /**
     * libelle du budget en SP
     */
    @Column(name = "bud_libelle_SP")
    private String budLibelleSp;

    /**
     * 0=encaissement 1=decaissement
     */
    @Column(name = "bud_sens")
    private Integer budSens = 0;

    /**
     * defini le dernier budget utilise (de 1 a  4)
     */
    @Column(name = "bud_util")
    private Integer budUtil = 0;

    /**
     * valeur initiale
     */
    @Column(name = "bud_01_tot_val")
    private Double bud01TotVal = 0D;

    /**
     * valeur reamenagement 2
     */
    @Column(name = "bud_02_tot_val")
    private Double bud02TotVal = 0D;

    /**
     * valeur reamenagement 3
     */
    @Column(name = "bud_03_tot_val")
    private Double bud03TotVal = 0D;

    /**
     * valeur reamenagement 4
     */
    @Column(name = "bud_04_tot_val")
    private Double bud04TotVal = 0D;

    /**
     * janvier reamenagement 1
     */
    @Column(name = "bud_01_r1_val")
    private Double bud01R1Val = 0D;

    /**
     * fevrier reamenagement 1
     */
    @Column(name = "bud_02_r1_val")
    private Double bud02R1Val = 0D;

    /**
     * mars reamenagement 1
     */
    @Column(name = "bud_03_r1_val")
    private Double bud03R1Val = 0D;

    /**
     * avril reamenagement 1
     */
    @Column(name = "bud_04_r1_val")
    private Double bud04R1Val = 0D;

    /**
     * mai reamenagement 1
     */
    @Column(name = "bud_05_r1_val")
    private Double bud05R1Val = 0D;

    /**
     * juin reamenagement 1
     */
    @Column(name = "bud_06_r1_val")
    private Double bud06R1Val = 0D;

    /**
     * juillet reamenagement 1
     */
    @Column(name = "bud_07_r1_val")
    private Double bud07R1Val = 0D;

    /**
     * aout reamenagement 1
     */
    @Column(name = "bud_08_r1_val")
    private Double bud08R1Val = 0D;

    /**
     * septembre reamenagement 1
     */
    @Column(name = "bud_09_r1_val")
    private Double bud09R1Val = 0D;

    /**
     * octobre reamenagement 1
     */
    @Column(name = "bud_10_r1_val")
    private Double bud10R1Val = 0D;

    /**
     * novembre reamenagement 1
     */
    @Column(name = "bud_11_r1_val")
    private Double bud11R1Val = 0D;

    /**
     * decembre reamenagement 1
     */
    @Column(name = "bud_12_r1_val")
    private Double bud12R1Val = 0D;

    /**
     * janvier reamenagement 2
     */
    @Column(name = "bud_01_r2_val")
    private Double bud01R2Val = 0D;

    /**
     * fevrier reamenagement 2
     */
    @Column(name = "bud_02_r2_val")
    private Double bud02R2Val = 0D;

    /**
     * mars reamenagement 2
     */
    @Column(name = "bud_03_r2_val")
    private Double bud03R2Val = 0D;

    /**
     * avril reamenagement 2
     */
    @Column(name = "bud_04_r2_val")
    private Double bud04R2Val = 0D;

    /**
     * mai reamenagement 2
     */
    @Column(name = "bud_05_r2_val")
    private Double bud05R2Val = 0D;

    /**
     * juin reamenagement 2
     */
    @Column(name = "bud_06_r2_val")
    private Double bud06R2Val = 0D;

    /**
     * juillet reamenagement 2
     */
    @Column(name = "bud_07_r2_val")
    private Double bud07R2Val = 0D;

    /**
     * aout reamenagement 2
     */
    @Column(name = "bud_08_r2_val")
    private Double bud08R2Val = 0D;

    /**
     * septembre reamenagement v
     */
    @Column(name = "bud_09_r2_val")
    private Double bud09R2Val = 0D;

    /**
     * octobre reamenagement 2
     */
    @Column(name = "bud_10_r2_val")
    private Double bud10R2Val = 0D;

    /**
     * novembre reamenagement 2
     */
    @Column(name = "bud_11_r2_val")
    private Double bud11R2Val = 0D;

    /**
     * decembre reamenagement 2
     */
    @Column(name = "bud_12_r2_val")
    private Double bud12R2Val = 0D;

    /**
     * janvier reamenagement 3
     */
    @Column(name = "bud_01_r3_val")
    private Double bud01R3Val = 0D;

    /**
     * fevrier reamenagement 3
     */
    @Column(name = "bud_02_r3_val")
    private Double bud02R3Val = 0D;

    /**
     * mars reamenagement 3
     */
    @Column(name = "bud_03_r3_val")
    private Double bud03R3Val = 0D;

    /**
     * avril reamenagement 3
     */
    @Column(name = "bud_04_r3_val")
    private Double bud04R3Val = 0D;

    /**
     * mai reamenagement 3
     */
    @Column(name = "bud_05_r3_val")
    private Double bud05R3Val = 0D;

    /**
     * juin reamenagement 3
     */
    @Column(name = "bud_06_r3_val")
    private Double bud06R3Val = 0D;

    /**
     * juillet reamenagement 3
     */
    @Column(name = "bud_07_r3_val")
    private Double bud07R3Val = 0D;

    /**
     * aout reamenagement 3
     */
    @Column(name = "bud_08_r3_val")
    private Double bud08R3Val = 0D;

    /**
     * septembre reamenagement 3
     */
    @Column(name = "bud_09_r3_val")
    private Double bud09R3Val = 0D;

    /**
     * octobre reamenagement 3
     */
    @Column(name = "bud_10_r3_val")
    private Double bud10R3Val = 0D;

    /**
     * novembre reamenagement 3
     */
    @Column(name = "bud_11_r3_val")
    private Double bud11R3Val = 0D;

    /**
     * decembre reamenagement 3
     */
    @Column(name = "bud_12_r3_val")
    private Double bud12R3Val = 0D;

    /**
     * janvier reamenagement 4
     */
    @Column(name = "bud_01_r4_val")
    private Double bud01R4Val = 0D;

    /**
     * fevrier reamenagement 4
     */
    @Column(name = "bud_02_r4_val")
    private Double bud02R4Val = 0D;

    /**
     * mars reamenagement 4
     */
    @Column(name = "bud_03_r4_val")
    private Double bud03R4Val = 0D;

    /**
     * avril reamenagement 4
     */
    @Column(name = "bud_04_r4_val")
    private Double bud04R4Val = 0D;

    /**
     * mai reamenagement 4
     */
    @Column(name = "bud_05_r4_val")
    private Double bud05R4Val = 0D;

    /**
     * juin reamenagement 4
     */
    @Column(name = "bud_06_r4_val")
    private Double bud06R4Val = 0D;

    /**
     * juillet reamenagement 4
     */
    @Column(name = "bud_07_r4_val")
    private Double bud07R4Val = 0D;

    /**
     * aout reamenagement 4
     */
    @Column(name = "bud_08_r4_val")
    private Double bud08R4Val = 0D;

    /**
     * septembre reamenagement 4
     */
    @Column(name = "bud_09_r4_val")
    private Double bud09R4Val = 0D;

    /**
     * octobre reamenagement 4
     */
    @Column(name = "bud_10_r4_val")
    private Double bud10R4Val = 0D;

    /**
     * novembre reamenagement 4
     */
    @Column(name = "bud_11_r4_val")
    private Double bud11R4Val = 0D;

    /**
     * decembre reamenagement 4
     */
    @Column(name = "bud_12_r4_val")
    private Double bud12R4Val = 0D;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

}
