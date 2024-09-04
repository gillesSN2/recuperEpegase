package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pay_salaries_variables")
public class PaySalariesVariables implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salvar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salvarId;

    /**
     * code rubrique
     */
    @Column(name = "salvar_code")
    private String salvarCode;

    /**
     * periode MM:AAAA ou JJ:MM:AAAA
     */
    @Column(name = "salvar_periode")
    private String salvarPeriode;

    /**
     * valeur colonne A
     */
    @Column(name = "salvar_valeur_colA")
    private Double salvarValeurCola = 0D;

    /**
     * valeur colonne B
     */
    @Column(name = "salvar_valeur_colB")
    private Double salvarValeurColb = 0D;

    /**
     * valeur colonne C
     */
    @Column(name = "salvar_valeur_colC")
    private Double salvarValeurColc = 0D;

    /**
     * valeur colonne D
     */
    @Column(name = "salvar_valeur_colD")
    private Double salvarValeurCold = 0D;

    /**
     * valeur colonne E
     */
    @Column(name = "salvar_valeur_colE")
    private Double salvarValeurCole = 0D;

    @Column(name = "plpId", nullable = false)
    private Long plpId;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    /**
     * variable salarie colonne A
     */
    @Column(name = "salvar_variableA")
    private Boolean salvarVariablea = Boolean.FALSE;

    /**
     * variable salarie colonne B
     */
    @Column(name = "salvar_variableB")
    private Boolean salvarVariableb = Boolean.FALSE;

    /**
     * variable salarie colonne C
     */
    @Column(name = "salvar_variableC")
    private Boolean salvarVariablec = Boolean.FALSE;

    /**
     * variable salarie colonne D
     */
    @Column(name = "salvar_variableD")
    private Boolean salvarVariabled = Boolean.FALSE;

    /**
     * variable salarie colonne E
     */
    @Column(name = "salvar_variableE")
    private Boolean salvarVariablee = Boolean.FALSE;

    /**
     * numero contrat
     */
    @Column(name = "salvar_contrat")
    private String salvarContrat;

    /**
     * feuille de calcul
     */
    @Column(name = "salvar_feuille")
    private String salvarFeuille;

}
