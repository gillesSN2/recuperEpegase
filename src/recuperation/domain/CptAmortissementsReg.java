package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cpt_amortissements_reg")
public class CptAmortissementsReg implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "amoreg_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amoregId;

    /**
     * date de creation
     */
    @Column(name = "amoreg_date_creat")
    private LocalDateTime amoregDateCreat;

    /**
     * date de modification
     */
    @Column(name = "amoreg_date_modif")
    private LocalDateTime amoregDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "amoreg_user_creat")
    private Long amoregUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "amoreg_user_modif")
    private Long amoregUserModif = 0L;

    /**
     * date de reglement
     */
    @Column(name = "amoreg_date_reg")
    private LocalDate amoregDateReg;

    /**
     * montant payee par le client
     */
    @Column(name = "amoreg_montant")
    private Double amoregMontant = 0D;

    @Column(name = "amo_id", nullable = false)
    private Long amoId;

}
