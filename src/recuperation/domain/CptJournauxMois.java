package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cpt_journaux_mois")
public class CptJournauxMois implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "joumen_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joumenId;

    /**
     * code journal
     */
    @Column(name = "joumen_code")
    private String joumenCode;

    /**
     * periode MMAAAA
     */
    @Column(name = "joumen_periode")
    private String joumenPeriode;

    /**
     * user utilisation journal
     */
    @Column(name = "joumen_user_id_journal")
    private Long joumenUserIdJournal = 0L;

    /**
     * 0=journal ferme 1=journal ouvert
     */
    @Column(name = "joumen_open_journal")
    private Integer joumenOpenJournal = 0;

    /**
     * nom utilisateur en cours
     */
    @Column(name = "joumen_open_user_journal")
    private String joumenOpenUserJournal = "0";

    /**
     * = concatenation joumen_code : joumen_periode
     */
    @Column(name = "joumen_cle1")
    private String joumenCle1 = "0";

    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    @Column(name = "joumen_etat")
    private Integer joumenEtat = 0;

    /**
     * 0=sans ecriture 1=ecriture deja saisie
     */
    @Column(name = "joumen_saisie")
    private Integer joumenSaisie = 0;

    /**
     * solde du releve de la banque
     */
    @Column(name = "joumen_releve")
    private Double joumenReleve = 0D;

    /**
     * solde du releve de la banque anterieur A-1
     */
    @Column(name = "joumen_releve_Ante")
    private Double joumenReleveAnte = 0D;

    @Column(name = "execpt_id", nullable = false)
    private Long execptId;

}
