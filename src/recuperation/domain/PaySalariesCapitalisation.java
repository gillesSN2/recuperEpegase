package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_salaries_capitalisation")
public class PaySalariesCapitalisation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salcap_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salcapId;

    /**
     * date de creation
     */
    @Column(name = "salcap_date_creat")
    private LocalDateTime salcapDateCreat;

    /**
     * date de modification
     */
    @Column(name = "salcap_date_modif")
    private LocalDateTime salcapDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "salcap_user_creat")
    private Long salcapUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "salcap_user_modif")
    private Long salcapUserModif = 0L;

    /**
     * montant initial
     */
    @Column(name = "salcap_inital")
    private Double salcapInital = 0D;

    /**
     * montant du versement
     */
    @Column(name = "salcap_montant")
    private Double salcapMontant = 0D;

    /**
     * rubrique de versement automatique
     */
    @Column(name = "salcap_rub_versement")
    private String salcapRubVersement;

    /**
     * rubrique de versement spontanee
     */
    @Column(name = "salcap_rub_spontanee")
    private String salcapRubSpontanee;

    /**
     * rubrique de retrait
     */
    @Column(name = "salcap_rub_retrait")
    private String salcapRubRetrait;

    /**
     * 0=non valide 1=valide
     */
    @Column(name = "salcap_etat")
    private Integer salcapEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "salcap_date_valide")
    private LocalDateTime salcapDateValide;

    /**
     * date impression
     */
    @Column(name = "salcap_date_imp")
    private LocalDateTime salcapDateImp;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

}
