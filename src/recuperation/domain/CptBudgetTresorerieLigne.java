package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_budget_tresorerie_ligne")
public class CptBudgetTresorerieLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "budlig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long budligId;

    /**
     * code budget
     */
    @Column(name = "budlig_code")
    private String budligCode;

    /**
     * defini le dernier budget utilise de 1 a  4
     */
    @Column(name = "budlig_util")
    private Integer budligUtil = 0;

    /**
     * code activite
     */
    @Column(name = "budlig_activite")
    private String budligActivite;

    /**
     * valeur initiale
     */
    @Column(name = "budlig_01_tot_val")
    private Double budlig01TotVal = 0D;

    /**
     * valeur reamenagement 2
     */
    @Column(name = "budlig_02_tot_val")
    private Double budlig02TotVal = 0D;

    /**
     * valeur reamenagement 3
     */
    @Column(name = "budlig_03_tot_val")
    private Double budlig03TotVal = 0D;

    /**
     * valeur reamenagement 4
     */
    @Column(name = "budlig_04_tot_val")
    private Double budlig04TotVal = 0D;

    /**
     * janvier reamenagement 1
     */
    @Column(name = "budlig_01_r1_val")
    private Double budlig01R1Val = 0D;

    /**
     * fevrier reamenagement 1
     */
    @Column(name = "budlig_02_r1_val")
    private Double budlig02R1Val = 0D;

    /**
     * mars reamenagement 1
     */
    @Column(name = "budlig_03_r1_val")
    private Double budlig03R1Val = 0D;

    /**
     * avril reamenagement 1
     */
    @Column(name = "budlig_04_r1_val")
    private Double budlig04R1Val = 0D;

    /**
     * mai reamenagement 1
     */
    @Column(name = "budlig_05_r1_val")
    private Double budlig05R1Val = 0D;

    /**
     * juin reamenagement 1
     */
    @Column(name = "budlig_06_r1_val")
    private Double budlig06R1Val = 0D;

    /**
     * juillet reamenagement 1
     */
    @Column(name = "budlig_07_r1_val")
    private Double budlig07R1Val = 0D;

    /**
     * aout reamenagement 1
     */
    @Column(name = "budlig_08_r1_val")
    private Double budlig08R1Val = 0D;

    /**
     * septembre reamenagement 1
     */
    @Column(name = "budlig_09_r1_val")
    private Double budlig09R1Val = 0D;

    /**
     * octobre reamenagement 1
     */
    @Column(name = "budlig_10_r1_val")
    private Double budlig10R1Val = 0D;

    /**
     * novembre reamenagement 1
     */
    @Column(name = "budlig_11_r1_val")
    private Double budlig11R1Val = 0D;

    /**
     * decembre reamenagement 1
     */
    @Column(name = "budlig_12_r1_val")
    private Double budlig12R1Val = 0D;

    /**
     * janvier reamenagement 2
     */
    @Column(name = "budlig_01_r2_val")
    private Double budlig01R2Val = 0D;

    /**
     * fevrier reamenagement 2
     */
    @Column(name = "budlig_02_r2_val")
    private Double budlig02R2Val = 0D;

    /**
     * mars reamenagement 2
     */
    @Column(name = "budlig_03_r2_val")
    private Double budlig03R2Val = 0D;

    /**
     * avril reamenagement 2
     */
    @Column(name = "budlig_04_r2_val")
    private Double budlig04R2Val = 0D;

    /**
     * mai reamenagement 2
     */
    @Column(name = "budlig_05_r2_val")
    private Double budlig05R2Val = 0D;

    /**
     * juin reamenagement 2
     */
    @Column(name = "budlig_06_r2_val")
    private Double budlig06R2Val = 0D;

    /**
     * juillet reamenagement 2
     */
    @Column(name = "budlig_07_r2_val")
    private Double budlig07R2Val = 0D;

    /**
     * aout reamenagement 2
     */
    @Column(name = "budlig_08_r2_val")
    private Double budlig08R2Val = 0D;

    /**
     * septembre reamenagement v
     */
    @Column(name = "budlig_09_r2_val")
    private Double budlig09R2Val = 0D;

    /**
     * octobre reamenagement 2
     */
    @Column(name = "budlig_10_r2_val")
    private Double budlig10R2Val = 0D;

    /**
     * novembre reamenagement 2
     */
    @Column(name = "budlig_11_r2_val")
    private Double budlig11R2Val = 0D;

    /**
     * decembre reamenagement 2
     */
    @Column(name = "budlig_12_r2_val")
    private Double budlig12R2Val = 0D;

    /**
     * janvier reamenagement 3
     */
    @Column(name = "budlig_01_r3_val")
    private Double budlig01R3Val = 0D;

    /**
     * fevrier reamenagement 3
     */
    @Column(name = "budlig_02_r3_val")
    private Double budlig02R3Val = 0D;

    /**
     * mars reamenagement 3
     */
    @Column(name = "budlig_03_r3_val")
    private Double budlig03R3Val = 0D;

    /**
     * avril reamenagement 3
     */
    @Column(name = "budlig_04_r3_val")
    private Double budlig04R3Val = 0D;

    /**
     * mai reamenagement 3
     */
    @Column(name = "budlig_05_r3_val")
    private Double budlig05R3Val = 0D;

    /**
     * juin reamenagement 3
     */
    @Column(name = "budlig_06_r3_val")
    private Double budlig06R3Val = 0D;

    /**
     * juillet reamenagement 3
     */
    @Column(name = "budlig_07_r3_val")
    private Double budlig07R3Val = 0D;

    /**
     * aout reamenagement 3
     */
    @Column(name = "budlig_08_r3_val")
    private Double budlig08R3Val = 0D;

    /**
     * septembre reamenagement 3
     */
    @Column(name = "budlig_09_r3_val")
    private Double budlig09R3Val = 0D;

    /**
     * octobre reamenagement 3
     */
    @Column(name = "budlig_10_r3_val")
    private Double budlig10R3Val = 0D;

    /**
     * novembre reamenagement 3
     */
    @Column(name = "budlig_11_r3_val")
    private Double budlig11R3Val = 0D;

    /**
     * decembre reamenagement 3
     */
    @Column(name = "budlig_12_r3_val")
    private Double budlig12R3Val = 0D;

    /**
     * janvier reamenagement 4
     */
    @Column(name = "budlig_01_r4_val")
    private Double budlig01R4Val = 0D;

    /**
     * fevrier reamenagement 4
     */
    @Column(name = "budlig_02_r4_val")
    private Double budlig02R4Val = 0D;

    /**
     * mars reamenagement 4
     */
    @Column(name = "budlig_03_r4_val")
    private Double budlig03R4Val = 0D;

    /**
     * avril reamenagement 4
     */
    @Column(name = "budlig_04_r4_val")
    private Double budlig04R4Val = 0D;

    /**
     * mai reamenagement 4
     */
    @Column(name = "budlig_05_r4_val")
    private Double budlig05R4Val = 0D;

    /**
     * juin reamenagement 4
     */
    @Column(name = "budlig_06_r4_val")
    private Double budlig06R4Val = 0D;

    /**
     * juillet reamenagement 4
     */
    @Column(name = "budlig_07_r4_val")
    private Double budlig07R4Val = 0D;

    /**
     * aout reamenagement 4
     */
    @Column(name = "budlig_08_r4_val")
    private Double budlig08R4Val = 0D;

    /**
     * septembre reamenagement 4
     */
    @Column(name = "budlig_09_r4_val")
    private Double budlig09R4Val = 0D;

    /**
     * octobre reamenagement 4
     */
    @Column(name = "budlig_10_r4_val")
    private Double budlig10R4Val = 0D;

    /**
     * novembre reamenagement 4
     */
    @Column(name = "budlig_11_r4_val")
    private Double budlig11R4Val = 0D;

    /**
     * decembre reamenagement 4
     */
    @Column(name = "budlig_12_r4_val")
    private Double budlig12R4Val = 0D;

    @Column(name = "bud_id", nullable = false)
    private Long budId;

}
