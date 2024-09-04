package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cmm_reunion_action")
public class CmmReunionAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "reuact_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reuactId;

    /**
     * numero de reunion
     */
    @Column(name = "reuact_num")
    private String reuactNum;

    /**
     * id du user
     */
    @Column(name = "reuact_id_user")
    private Long reuactIdUser = 0L;

    /**
     * nom du user
     */
    @Column(name = "reuact_nom_user")
    private String reuactNomUser;

    /**
     * prenom du user
     */
    @Column(name = "reuact_prenom_user")
    private String reuactPrenomUser;

    /**
     * civilite du user
     */
    @Column(name = "reuact_civilite_user")
    private String reuactCiviliteUser;

    /**
     * fonction du user
     */
    @Column(name = "reuact_fonction_user")
    private String reuactFonctionUser;

    /**
     * quoi
     */
    @Column(name = "reuact_quoi")
    private String reuactQuoi;

    /**
     * quand
     */
    @Column(name = "reuact_quand")
    private String reuactQuand;

    /**
     * date buttoire
     */
    @Column(name = "reuact_date")
    private LocalDate reuactDate;

    /**
     * ou
     */
    @Column(name = "reuact_ou")
    private String reuactOu;

    /**
     * 0=en cours 1=traite succes 2=traite echec 3=non traite 4=repporte
     */
    @Column(name = "reuact_etat")
    private Integer reuactEtat = 0;

    /**
     * date report
     */
    @Column(name = "reuact_date_report")
    private LocalDate reuactDateReport;

    @Column(name = "reu_id", nullable = false)
    private Long reuId;

    /**
     * date execution
     */
    @Column(name = "reuact_date_execution")
    private LocalDate reuactDateExecution;

    /**
     * numero reunion execution
     */
    @Column(name = "reuact_num_execution")
    private String reuactNumExecution;

    /**
     * observation execution
     */
    @Column(name = "reuact_obs_execution")
    private String reuactObsExecution;

}
