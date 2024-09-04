package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_salaries_pointage")
public class PaySalariesPointage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salpoi_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salpoiId;

    /**
     * date de creation
     */
    @Column(name = "salpoi_date_creat")
    private LocalDateTime salpoiDateCreat;

    /**
     * date de modification
     */
    @Column(name = "salpoi_date_modif")
    private LocalDateTime salpoiDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "salpoi_user_creat")
    private Long salpoiUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "salpoi_user_modif")
    private Long salpoiUserModif = 0L;

    /**
     * numero enregistrement
     */
    @Column(name = "salpoi_num")
    private String salpoiNum;

    /**
     * etat 0=en cours 1=valide
     */
    @Column(name = "salpoi_etat")
    private Integer salpoiEtat = 0;

    /**
     * 0=pointage
     */
    @Column(name = "salpoi_nature")
    private Integer salpoiNature = 0;

    /**
     * date
     */
    @Column(name = "salpoi_date")
    private LocalDate salpoiDate;

    /**
     * periode aaaa:mm
     */
    @Column(name = "salpoi_periode")
    private String salpoiPeriode;

    /**
     * heure debut
     */
    @Column(name = "salpoi_heure_debut")
    private Integer salpoiHeureDebut = 0;

    /**
     * heure fin
     */
    @Column(name = "salpoi_heure_fin")
    private Integer salpoiHeureFin = 0;

    /**
     * minute debut
     */
    @Column(name = "salpoi_minute_debut")
    private Integer salpoiMinuteDebut = 0;

    /**
     * minute fin
     */
    @Column(name = "salpoi_minute_fin")
    private Integer salpoiMinuteFin = 0;

    /**
     * duree
     */
    @Column(name = "salpoi_duree")
    private Integer salpoiDuree = 0;

    /**
     * objet evenement
     */
    @Column(name = "salpoi_objet")
    private String salpoiObjet;

    /**
     * mission
     */
    @Column(name = "salpoi_mission")
    private String salpoiMission;

    /**
     * service
     */
    @Column(name = "salpoi_service")
    private String salpoiService;

    /**
     * activite
     */
    @Column(name = "salpoi_activite")
    private String salpoiActivite;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

}
