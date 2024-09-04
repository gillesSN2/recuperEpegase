package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_salaries_conges")
public class PaySalariesConges implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "salcng_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salcngId;

    /**
     * date de creation
     */
    @Column(name = "salcng_date_creat")
    private LocalDateTime salcngDateCreat;

    /**
     * date de modification
     */
    @Column(name = "salcng_date_modif")
    private LocalDateTime salcngDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "salcng_user_creat")
    private Long salcngUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "salcng_user_modif")
    private Long salcngUserModif = 0L;

    /**
     * 0=conges 1=absences posees 2=absences ou retards constatees
     */
    @Column(name = "salcng_type")
    private Integer salcngType = 0;

    /**
     * 0=cp normaux 1=bulletin de conges 2=conges travaille 3=conges immediat
     */
    @Column(name = "salcng_nature")
    private Integer salcngNature = 0;

    /**
     * date debut des conges
     */
    @Column(name = "salcng_date_debut")
    private LocalDate salcngDateDebut;

    /**
     * date fin des conges
     */
    @Column(name = "salcng_date_fin")
    private LocalDate salcngDateFin;

    /**
     * duree des conges
     */
    @Column(name = "salcng_duree")
    private Integer salcngDuree;

    /**
     * motif des conges
     */
    @Column(name = "salcng_objet")
    private String salcngObjet;

    /**
     * responsable
     */
    @Column(name = "salcng_responsable")
    private String salcngResponsable;

    /**
     * lieu
     */
    @Column(name = "salcng_lieu")
    private String salcngLieu;

    /**
     * nombre heure de retard
     */
    @Column(name = "salcng_nb_heure")
    private Float salcngNbHeure = 0F;

    /**
     * 0= sans habilitation 1=avec habilitation
     */
    @Column(name = "salcng_etat_val")
    private Integer salcngEtatVal = 0;

    /**
     * 0=non valide 1=valide
     */
    @Column(name = "salcng_etat")
    private Integer salcngEtat = 0;

    /**
     * date de validation
     */
    @Column(name = "salcng_date_valide")
    private LocalDateTime salcngDateValide;

    /**
     * date impression
     */
    @Column(name = "salcng_date_imp")
    private LocalDateTime salcngDateImp;

    @Column(name = "sal_id", nullable = false)
    private Long salId;

    /**
     * absence le matin
     */
    @Column(name = "salcng_am")
    private Boolean salcngAm = Boolean.FALSE;

    /**
     * absence apres midi
     */
    @Column(name = "salcng_pm")
    private Boolean salcngPm = Boolean.FALSE;

}
