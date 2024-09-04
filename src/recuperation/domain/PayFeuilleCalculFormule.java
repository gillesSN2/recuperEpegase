package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pay_feuille_calcul_formule")
public class PayFeuilleCalculFormule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "feurubfor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feurubforId;

    /**
     * code rubrique
     */
    @Column(name = "feurubfor_code")
    private String feurubforCode;

    /**
     * colonne A,B,C,D ou E
     */
    @Column(name = "feurubfor_colonne")
    private String feurubforColonne;

    /**
     * formule
     */
    @Column(name = "feurubfor_formule")
    private String feurubforFormule;

    @Column(name = "feurub_id", nullable = false)
    private Long feurubId;

    @Column(name = "feu_id")
    private Long feuId;

}
