package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pay_feuille_calcul_rubrique")
public class PayFeuilleCalculRubrique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "feurub_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feurubId;

    /**
     * rubrique active
     */
    @Column(name = "feurub_actif")
    private Boolean feurubActif;

    /**
     * code rubrique
     */
    @Column(name = "feurub_code")
    private String feurubCode;

    /**
     * colonne A active
     */
    @Column(name = "feurub_colA")
    private Boolean feurubCola;

    /**
     * colonne B active
     */
    @Column(name = "feurub_colB")
    private Boolean feurubColb;

    /**
     * colonne C active
     */
    @Column(name = "feurub_colC")
    private Boolean feurubColc;

    /**
     * colonne D active
     */
    @Column(name = "feurub_colD")
    private Boolean feurubCold;

    /**
     * colonne E active
     */
    @Column(name = "feurub_colE")
    private Boolean feurubCole;

    /**
     * colonne A raz
     */
    @Column(name = "feurub_colA_raz")
    private Boolean feurubColaRaz;

    /**
     * colonne B raz
     */
    @Column(name = "feurub_colB_raz")
    private Boolean feurubColbRaz;

    /**
     * colonne C raz
     */
    @Column(name = "feurub_colC_raz")
    private Boolean feurubColcRaz;

    /**
     * colonne D raz
     */
    @Column(name = "feurub_colD_raz")
    private Boolean feurubColdRaz;

    /**
     * colonne E raz
     */
    @Column(name = "feurub_colE_raz")
    private Boolean feurubColeRaz;

    /**
     * compte
     */
    @Column(name = "feurub_compte")
    private String feurubCompte;

    @Column(name = "feu_id", nullable = false)
    private Long feuId;

    @Column(name = "plpId", nullable = false)
    private Long plpId;

    /**
     * variable salarie colonne A
     */
    @Column(name = "feurub_variableA")
    private Boolean feurubVariablea = Boolean.FALSE;

    /**
     * variable salarie colonne B
     */
    @Column(name = "feurub_variableB")
    private Boolean feurubVariableb = Boolean.FALSE;

    /**
     * variable salarie colonne C
     */
    @Column(name = "feurub_variableC")
    private Boolean feurubVariablec = Boolean.FALSE;

    /**
     * variable salarie colonne D
     */
    @Column(name = "feurub_variableD")
    private Boolean feurubVariabled = Boolean.FALSE;

    /**
     * variable salarie colonne E
     */
    @Column(name = "feurub_variableE")
    private Boolean feurubVariablee = Boolean.FALSE;

}
