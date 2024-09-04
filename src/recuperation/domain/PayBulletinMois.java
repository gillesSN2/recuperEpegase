package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pay_bulletin_mois")
public class PayBulletinMois implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bulmen_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bulmenId;

    /**
     * numero feuille
     */
    @Column(name = "bulmen_feuille")
    private String bulmenFeuille;

    /**
     * periode MMAAAA
     */
    @Column(name = "bulmen_periode")
    private String bulmenPeriode;

    /**
     * = concatenation bulmen_feuille : bulmen_periode
     */
    @Column(name = "bulmen_cle1")
    private String bulmenCle1;

    /**
     * 0=en cours 1=saisie mensuelle 2=generation 3=cloture 4=transfert
     */
    @Column(name = "bulmen_etat")
    private Integer bulmenEtat = 0;

    /**
     * user utilisation journal
     */
    @Column(name = "bulmen_user_id_journal")
    private Long bulmenUserIdJournal = 0L;

    /**
     * 0=journal ferme 1=journal ouvert
     */
    @Column(name = "bulmen_open_journal")
    private Integer bulmenOpenJournal = 0;

    /**
     * nom utilisateur en cours
     */
    @Column(name = "bulmen_open_user_journal")
    private String bulmenOpenUserJournal;

    /**
     * user utilisation journal
     */
    @Column(name = "bulmen_user_id_generation")
    private Long bulmenUserIdGeneration = 0L;

    /**
     * 0=journal ferme 1=journal ouvert
     */
    @Column(name = "bulmen_open_generation")
    private Integer bulmenOpenGeneration = 0;

    /**
     * nom utilisateur en cours
     */
    @Column(name = "bulmen_open_user_generation")
    private String bulmenOpenUserGeneration;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

}
