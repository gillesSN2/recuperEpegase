package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_equipes")
public class CmmEquipes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "equ_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equId;

    /**
     * date de creation
     */
    @Column(name = "equ_date_creat")
    private LocalDateTime equDateCreat;

    /**
     * date de modification
     */
    @Column(name = "equ_date_modif")
    private LocalDateTime equDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "equ_user_creat")
    private Long equUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "equ_user_modif")
    private Long equUserModif = 0L;

    /**
     * 0=commercial 1=administratif 3=production
     */
    @Column(name = "equ_type")
    private Integer equType = 0;

    /**
     * code activite
     */
    @Column(name = "equ_code")
    private String equCode;

    /**
     * nom activite en FR
     */
    @Column(name = "equ_nom_FR")
    private String equNomFr;

    /**
     * nom activite en UK
     */
    @Column(name = "equ_nom_UK")
    private String equNomUk;

    /**
     * nom activite en SP
     */
    @Column(name = "equ_nom_SP")
    private String equNomSp;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "equ_inactif")
    private Integer equInactif = 0;

    /**
     * numero de quart
     */
    @Column(name = "equ_quart")
    private Integer equQuart = 0;

    /**
     * heure debut
     */
    @Column(name = "equ_heure_debut")
    private Integer equHeureDebut = 0;

    /**
     * heure fin
     */
    @Column(name = "equ_heure_fin")
    private Integer equHeureFin = 0;

    /**
     * minute debut
     */
    @Column(name = "equ_minute_debut")
    private Integer equMinuteDebut = 0;

    /**
     * minute fin
     */
    @Column(name = "equ_minute_fin")
    private Integer equMinuteFin = 0;

    /**
     * id responsable
     */
    @Column(name = "equ_id_responsable")
    private Long equIdResponsable = 0L;

    /**
     * nom responsable
     */
    @Column(name = "equ_nom_responsable")
    private String equNomResponsable;

    /**
     * tableau des id agents
     */
    @Column(name = "equ_id_agent")
    private String equIdAgent;

    /**
     * tableau des nom agents
     */
    @Column(name = "equ_nom_agent")
    private String equNomAgent;

    /**
     * depot de travail
     */
    @Column(name = "equ_depot")
    private String equDepot;

    /**
     * depot origine
     */
    @Column(name = "equ_depot_origine")
    private String equDepotOrigine;

    /**
     * caisse affectee
     */
    @Column(name = "equ_caisse")
    private String equCaisse;

    /**
     * 0=stock equipe 1=stock global
     */
    @Column(name = "equ_stock")
    private Integer equStock = 0;

}
