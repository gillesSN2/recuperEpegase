package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pay_salaries_historique")
public class PaySalariesHistorique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salhis_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salhisId;

    /**
     * numero contrat
     */
    @Column(name = "salhis_contrat")
    private String salhisContrat;

    /**
     * code rubrique
     */
    @Column(name = "salhis_code")
    private String salhisCode;

    /**
     * libelle rubrique
     */
    @Column(name = "salhis_libelle")
    private String salhisLibelle;

    /**
     * date historique
     */
    @Column(name = "salhis_date")
    private LocalDate salhisDate;

    /**
     * valeur colonne E
     */
    @Column(name = "salhis_valeur_colE")
    private Double salhisValeurCole = 0D;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

}
