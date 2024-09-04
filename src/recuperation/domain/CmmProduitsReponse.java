package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cmm_produits_reponse")
public class CmmProduitsReponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prorep_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prorepId;

    /**
     * 0=reponse predefinie 1=conclusion predefinie
     */
    @Column(name = "prorep_type")
    private Integer prorepType = 0;

    /**
     * texte de la reponse
     */
    @Column(name = "prorep_reponse")
    private String prorepReponse;

    /**
     * ordre des reponses
     */
    @Column(name = "prorep_ordre")
    private Integer prorepOrdre = 0;

    /**
     * question
     */
    @Column(name = "prorep_question")
    private String prorepQuestion;

    /**
     * 0=sans reponse 1=reponse positive 2=reponse negative
     */
    @Column(name = "prorep_resultat")
    private Integer prorepResultat = 0;

    /**
     * action positive
     */
    @Column(name = "prorep_action_positive")
    private String prorepActionPositive;

    /**
     * action negative
     */
    @Column(name = "prorep_action_negative")
    private String prorepActionNegative;

    @Column(name = "prolab_id")
    private Long prolabId;

    @Column(name = "prodet_id")
    private Long prodetId;

    @Column(name = "pro_id", nullable = false)
    private Long proId;

    /**
     * code produit
     */
    @Column(name = "prorep_code")
    private String prorepCode;

    /**
     * libelle examen
     */
    @Column(name = "prorep_libelle")
    private String prorepLibelle;

}
