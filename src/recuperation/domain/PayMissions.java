package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pay_missions")
public class PayMissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mis_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long misId;

    /**
     * date de creation
     */
    @Column(name = "mis_date_creat")
    private LocalDateTime misDateCreat;

    /**
     * date de modification
     */
    @Column(name = "mis_date_modif")
    private LocalDateTime misDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "mis_user_creat")
    private Long misUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "mis_user_modif")
    private Long misUserModif = 0L;

    /**
     * numero mission
     */
    @Column(name = "mis_num")
    private String misNum;

    /**
     * pays
     */
    @Column(name = "mis_pays")
    private String misPays;

    /**
     * 0=formation 1=reunion 2=seminaire 3=terrain 4=visite
     */
    @Column(name = "mis_nature")
    private Integer misNature = 0;

    /**
     * 0=local 1=etranger
     */
    @Column(name = "mis_mode")
    private Integer misMode = 0;

    /**
     * prix unitaire perdiem
     */
    @Column(name = "mis_pu_perdiem")
    private Double misPuPerdiem = 0D;

    /**
     * nombre de jour theorique
     */
    @Column(name = "mis_nb_jour_theo")
    private Integer misNbJourTheo = 0;

    /**
     * perdiem theorique
     */
    @Column(name = "mis_perdiem_theo")
    private Double misPerdiemTheo = 0D;

    /**
     * objectif
     */
    @Column(name = "mis_objectif")
    private String misObjectif;

    /**
     * detail mission
     */
    @Column(name = "mis_detail")
    private String misDetail;

    /**
     * 0=en cours 1=approuve 2=execution 3=retour 4=cloture 5=annule 6=gele
     */
    @Column(name = "mis_etat")
    private Integer misEtat = 0;

    /**
     * imputation service
     */
    @Column(name = "mis_service")
    private String misService;

    /**
     * imputation activite
     */
    @Column(name = "mis_acticvite")
    private String misActicvite;

    /**
     * imputation budget
     */
    @Column(name = "mis_budget")
    private String misBudget;

    /**
     * disponibilite du budget
     */
    @Column(name = "mis_budget_dispo")
    private Double misBudgetDispo = 0D;

    /**
     * disponibilite du budget du mois
     */
    @Column(name = "mis_budget_dispo_mois")
    private Double misBudgetDispoMois = 0D;

    /**
     * disponibilite de tresorerie
     */
    @Column(name = "mis_budget_treso")
    private Double misBudgetTreso = 0D;

    /**
     * disponibilite de tresorerie du mois
     */
    @Column(name = "mis_budget_treso_mois")
    private Double misBudgetTresoMois = 0D;

    /**
     * id responsable
     */
    @Column(name = "mis_id_responsable")
    private Long misIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "mis_nom_responsable")
    private String misNomResponsable;

    /**
     * date debut
     */
    @Column(name = "mis_date_debut")
    private LocalDate misDateDebut;

    /**
     * date fin
     */
    @Column(name = "mis_date_fin")
    private LocalDate misDateFin;

    /**
     * date debut reelle
     */
    @Column(name = "mis_date_debut_reel")
    private LocalDate misDateDebutReel;

    /**
     * date fin reelle
     */
    @Column(name = "mis_date_fin_reel")
    private LocalDate misDateFinReel;

    /**
     * nombre de jour reel
     */
    @Column(name = "mis_nb_jour_reel")
    private Integer misNbJourReel = 0;

    /**
     * perdiem reel
     */
    @Column(name = "mis_perdiem_reel")
    private Double misPerdiemReel = 0D;

    /**
     * ordre de mission
     */
    @Column(name = "mis_ordre_mission")
    private String misOrdreMission;

    /**
     * itineraire
     */
    @Column(name = "mis_itineraire")
    private String misItineraire;

    /**
     * rapport de mission
     */
    @Column(name = "mis_rapport_mission")
    private String misRapportMission;

    /**
     * total transport
     */
    @Column(name = "mis_total_transport")
    private Double misTotalTransport = 0D;

    /**
     * total hebergement
     */
    @Column(name = "mis_total_hebergement")
    private Double misTotalHebergement = 0D;

    /**
     * total restauration
     */
    @Column(name = "mis_total_restauration")
    private Double misTotalRestauration = 0D;

    /**
     * total divers
     */
    @Column(name = "mis_total_divers")
    private Double misTotalDivers = 0D;

    /**
     * total visa
     */
    @Column(name = "mis_total_visa")
    private Double misTotalVisa = 0D;

    /**
     * total perdiem
     */
    @Column(name = "mis_total_perdiem")
    private Double misTotalPerdiem = 0D;

    /**
     * total cout mission
     */
    @Column(name = "mis_total_cout")
    private Double misTotalCout = 0D;

    @Column(name = "exepay_id", nullable = false)
    private Long exepayId;

}
