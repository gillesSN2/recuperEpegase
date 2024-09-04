package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pay_bulletin_ligne")
public class PayBulletinLigne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bullig_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bulligId;

    /**
     * code rubrique
     */
    @Column(name = "bullig_rubrique")
    private String bulligRubrique;

    /**
     * libelle rubrique
     */
    @Column(name = "bullig_libelle")
    private String bulligLibelle;

    /**
     * affiche colonne A
     */
    @Column(name = "bullig_aff_colA")
    private Boolean bulligAffCola = Boolean.FALSE;

    /**
     * affiche colonne B
     */
    @Column(name = "bullig_aff_colB")
    private Boolean bulligAffColb = Boolean.FALSE;

    /**
     * affiche colonne C
     */
    @Column(name = "bullig_aff_colC")
    private Boolean bulligAffColc = Boolean.FALSE;

    /**
     * affiche colonne D
     */
    @Column(name = "bullig_aff_colD")
    private Boolean bulligAffCold = Boolean.FALSE;

    /**
     * affiche colonne E
     */
    @Column(name = "bullig_aff_colE")
    private Boolean bulligAffCole = Boolean.FALSE;

    /**
     * valeur colonne A
     */
    @Column(name = "bullig_val_colA")
    private Double bulligValCola = 0D;

    /**
     * valeur colonne B
     */
    @Column(name = "bullig_val_colB")
    private Double bulligValColb = 0D;

    /**
     * valeur colonne C
     */
    @Column(name = "bullig_val_colC")
    private Double bulligValColc = 0D;

    /**
     * valeur colonne D
     */
    @Column(name = "bullig_val_colD")
    private Double bulligValCold = 0D;

    /**
     * valeur colonne E
     */
    @Column(name = "bullig_val_colE")
    private Double bulligValCole = 0D;

    /**
     * code nature
     */
    @Column(name = "bullig_nature")
    private Integer bulligNature = 0;

    /**
     * 0=+ 1=- 2=calcul 3=resultat
     */
    @Column(name = "bullig_sens")
    private Integer bulligSens = 0;

    /**
     * id pret ligne
     */
    @Column(name = "bullig_id_pret_ligne")
    private Long bulligIdPretLigne = 0L;

    /**
     * numero de pret
     */
    @Column(name = "bullig_num_pret")
    private String bulligNumPret;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    @Column(name = "bulsal_id", nullable = false)
    private Long bulsalId;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

    /**
     * observation
     */
    @Column(name = "bullig_observation")
    private String bulligObservation;

}
