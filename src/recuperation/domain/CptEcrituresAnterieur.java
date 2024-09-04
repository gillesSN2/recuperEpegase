package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cpt_ecritures_anterieur")
public class CptEcrituresAnterieur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ecrant_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ecrantId;

    /**
     * concatenation ecr_code:ecr_periode
     */
    @Column(name = "ecrant_cle1")
    private String ecrantCle1;

    /**
     * date ecriture
     */
    @Column(name = "ecrant_date_creat")
    private LocalDate ecrantDateCreat;

    /**
     * code journal table planJournauxComptables
     */
    @Column(name = "ecrant_code")
    private String ecrantCode;

    /**
     * MM:AAAA par rapport a la date de saisie
     */
    @Column(name = "ecrant_periode")
    private String ecrantPeriode;

    /**
     * partie annee de la date de saisie
     */
    @Column(name = "ecrant_annee")
    private String ecrantAnnee;

    /**
     * montant credit dans la devise de saisie
     */
    @Column(name = "ecrant_debit_saisie")
    private Double ecrantDebitSaisie = 0D;

    /**
     * montant credit dans la devise de saisie
     */
    @Column(name = "ecrant_credit_saisie")
    private Double ecrantCreditSaisie = 0D;

    /**
     * code de rapprochement MM:AAAA
     */
    @Column(name = "ecrant_rapprochement")
    private String ecrantRapprochement;

    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    @Column(name = "ecrant_cloture")
    private Integer ecrantCloture = 0;

    /**
     * libelle ecriture
     */
    @Column(name = "ecrant_libelle")
    private String ecrantLibelle;

    /**
     * numero de piece comptable
     */
    @Column(name = "ecrant_piece")
    private String ecrantPiece;

    /**
     * reference 1
     */
    @Column(name = "ecrant_reference1")
    private String ecrantReference1;

    /**
     * reference 2
     */
    @Column(name = "ecrant_reference2")
    private String ecrantReference2;

    /**
     * 0=anterieur 1=extra comptable
     */
    @Column(name = "ecrant_type")
    private Integer ecrantType = 0;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

}
