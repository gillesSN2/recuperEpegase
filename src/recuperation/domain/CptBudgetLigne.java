package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_budget_ligne")
public class CptBudgetLigne implements Serializable {

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
     * defini le dernier budget utilise de 1 aÃ‚Â  4
     */
    @Column(name = "budlig_util")
    private Integer budligUtil = 0;

    /**
     * code activite
     */
    @Column(name = "budlig_activite")
    private String budligActivite;

    /**
     * code site
     */
    @Column(name = "budlig_site")
    private String budligSite;

    /**
     * code departement
     */
    @Column(name = "budlig_departement")
    private String budligDepartement;

    /**
     * code service
     */
    @Column(name = "budlig_service")
    private String budligService;

    /**
     * code region
     */
    @Column(name = "budlig_region")
    private String budligRegion;

    /**
     * code secteur
     */
    @Column(name = "budlig_secteur")
    private String budligSecteur;

    /**
     * code pdv
     */
    @Column(name = "budlig_pdv")
    private String budligPdv;

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

    /**
     * quantite initiale
     */
    @Column(name = "budlig_01_tot_qte")
    private Float budlig01TotQte = 0F;

    /**
     * quantite reamenagement 2
     */
    @Column(name = "budlig_02_tot_qte")
    private Float budlig02TotQte = 0F;

    /**
     * quantite reamenagement 3
     */
    @Column(name = "budlig_03_tot_qte")
    private Float budlig03TotQte = 0F;

    /**
     * quantite reamenagement 4
     */
    @Column(name = "budlig_04_tot_qte")
    private Float budlig04TotQte = 0F;

    /**
     * janvier reamenagement 1
     */
    @Column(name = "budlig_01_r1_qte")
    private Float budlig01R1Qte = 0F;

    /**
     * fevrier reamenagement 1
     */
    @Column(name = "budlig_02_r1_qte")
    private Float budlig02R1Qte = 0F;

    /**
     * mars reamenagement 1
     */
    @Column(name = "budlig_03_r1_qte")
    private Float budlig03R1Qte = 0F;

    /**
     * avril reamenagement 1
     */
    @Column(name = "budlig_04_r1_qte")
    private Float budlig04R1Qte = 0F;

    /**
     * mai reamenagement 1
     */
    @Column(name = "budlig_05_r1_qte")
    private Float budlig05R1Qte = 0F;

    /**
     * juin reamenagement 1
     */
    @Column(name = "budlig_06_r1_qte")
    private Float budlig06R1Qte = 0F;

    /**
     * juillet reamenagement 1
     */
    @Column(name = "budlig_07_r1_qte")
    private Float budlig07R1Qte = 0F;

    /**
     * aout reamenagement 1
     */
    @Column(name = "budlig_08_r1_qte")
    private Float budlig08R1Qte = 0F;

    /**
     * septembre reamenagement 1
     */
    @Column(name = "budlig_09_r1_qte")
    private Float budlig09R1Qte = 0F;

    /**
     * octobre reamenagement 1
     */
    @Column(name = "budlig_10_r1_qte")
    private Float budlig10R1Qte = 0F;

    /**
     * novembre reamenagement 1
     */
    @Column(name = "budlig_11_r1_qte")
    private Float budlig11R1Qte = 0F;

    /**
     * decembre reamenagement 1
     */
    @Column(name = "budlig_12_r1_qte")
    private Float budlig12R1Qte = 0F;

    /**
     * janvier reamenagement 2
     */
    @Column(name = "budlig_01_r2_qte")
    private Float budlig01R2Qte = 0F;

    /**
     * fevrier reamenagement 2
     */
    @Column(name = "budlig_02_r2_qte")
    private Float budlig02R2Qte = 0F;

    /**
     * mars reamenagement 2
     */
    @Column(name = "budlig_03_r2_qte")
    private Float budlig03R2Qte = 0F;

    /**
     * avril reamenagement 2
     */
    @Column(name = "budlig_04_r2_qte")
    private Float budlig04R2Qte = 0F;

    /**
     * mai reamenagement 2
     */
    @Column(name = "budlig_05_r2_qte")
    private Float budlig05R2Qte = 0F;

    /**
     * juin reamenagement 2
     */
    @Column(name = "budlig_06_r2_qte")
    private Float budlig06R2Qte = 0F;

    /**
     * juillet reamenagement 2
     */
    @Column(name = "budlig_07_r2_qte")
    private Float budlig07R2Qte = 0F;

    /**
     * aout reamenagement 2
     */
    @Column(name = "budlig_08_r2_qte")
    private Float budlig08R2Qte = 0F;

    /**
     * septembre reamenagement 2
     */
    @Column(name = "budlig_09_r2_qte")
    private Float budlig09R2Qte = 0F;

    /**
     * octobre reamenagement 2
     */
    @Column(name = "budlig_10_r2_qte")
    private Float budlig10R2Qte = 0F;

    /**
     * novembre reamenagement 2
     */
    @Column(name = "budlig_11_r2_qte")
    private Float budlig11R2Qte = 0F;

    /**
     * decembre reamenagement 2
     */
    @Column(name = "budlig_12_r2_qte")
    private Float budlig12R2Qte = 0F;

    /**
     * janvier reamenagement 3
     */
    @Column(name = "budlig_01_r3_qte")
    private Float budlig01R3Qte = 0F;

    /**
     * fevrier reamenagement 3
     */
    @Column(name = "budlig_02_r3_qte")
    private Float budlig02R3Qte = 0F;

    /**
     * mars reamenagement 3
     */
    @Column(name = "budlig_03_r3_qte")
    private Float budlig03R3Qte = 0F;

    /**
     * avril reamenagement 3
     */
    @Column(name = "budlig_04_r3_qte")
    private Float budlig04R3Qte = 0F;

    /**
     * mai reamenagement 3
     */
    @Column(name = "budlig_05_r3_qte")
    private Float budlig05R3Qte = 0F;

    /**
     * juin reamenagement 3
     */
    @Column(name = "budlig_06_r3_qte")
    private Float budlig06R3Qte = 0F;

    /**
     * juillet reamenagement 3
     */
    @Column(name = "budlig_07_r3_qte")
    private Float budlig07R3Qte = 0F;

    /**
     * aout reamenagement 3
     */
    @Column(name = "budlig_08_r3_qte")
    private Float budlig08R3Qte = 0F;

    /**
     * septembre reamenagement 3
     */
    @Column(name = "budlig_09_r3_qte")
    private Float budlig09R3Qte = 0F;

    /**
     * octobre reamenagement 3
     */
    @Column(name = "budlig_10_r3_qte")
    private Float budlig10R3Qte = 0F;

    /**
     * novembre reamenagement 3
     */
    @Column(name = "budlig_11_r3_qte")
    private Float budlig11R3Qte = 0F;

    /**
     * decembre reamenagement 3
     */
    @Column(name = "budlig_12_r3_qte")
    private Float budlig12R3Qte = 0F;

    /**
     * janvier reamenagement 4
     */
    @Column(name = "budlig_01_r4_qte")
    private Float budlig01R4Qte = 0F;

    /**
     * fevrier reamenagement 4
     */
    @Column(name = "budlig_02_r4_qte")
    private Float budlig02R4Qte = 0F;

    /**
     * mars reamenagement 4
     */
    @Column(name = "budlig_03_r4_qte")
    private Float budlig03R4Qte = 0F;

    /**
     * avril reamenagement 4
     */
    @Column(name = "budlig_04_r4_qte")
    private Float budlig04R4Qte = 0F;

    /**
     * mai reamenagement 4
     */
    @Column(name = "budlig_05_r4_qte")
    private Float budlig05R4Qte = 0F;

    /**
     * juin reamenagement 4
     */
    @Column(name = "budlig_06_r4_qte")
    private Float budlig06R4Qte = 0F;

    /**
     * juillet reamenagement 4
     */
    @Column(name = "budlig_07_r4_qte")
    private Float budlig07R4Qte = 0F;

    /**
     * aout reamenagement 4
     */
    @Column(name = "budlig_08_r4_qte")
    private Float budlig08R4Qte = 0F;

    /**
     * septembre reamenagement 4
     */
    @Column(name = "budlig_09_r4_qte")
    private Float budlig09R4Qte = 0F;

    /**
     * octobre reamenagement 4
     */
    @Column(name = "budlig_10_r4_qte")
    private Float budlig10R4Qte = 0F;

    /**
     * novembre reamenagement 4
     */
    @Column(name = "budlig_11_r4_qte")
    private Float budlig11R4Qte = 0F;

    /**
     * decembre reamenagement 4
     */
    @Column(name = "budlig_12_r4_qte")
    private Float budlig12R4Qte = 0F;

    @Column(name = "bud_id", nullable = false)
    private Long budId;

    /**
     * lib activite
     */
    @Column(name = "budlig_lib_activite")
    private String budligLibActivite;

    /**
     * code anal1
     */
    @Column(name = "budlig_anal1")
    private String budligAnal1;

    /**
     * lib anal1
     */
    @Column(name = "budlig_lib_anal1")
    private String budligLibAnal1;

    /**
     * code anal3
     */
    @Column(name = "budlig_anal3")
    private String budligAnal3;

    /**
     * lib anal3
     */
    @Column(name = "budlig_lib_anal3")
    private String budligLibAnal3;

}
