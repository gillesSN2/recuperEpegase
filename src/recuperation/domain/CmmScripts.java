package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cmm_scripts")
public class CmmScripts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "scr_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrId;

    /**
     * date de creation
     */
    @Column(name = "scr_date_creat")
    private LocalDateTime scrDateCreat;

    /**
     * date de modification
     */
    @Column(name = "scr_date_modif")
    private LocalDateTime scrDateModif;

    /**
     * utilisateur de creation
     */
    @Column(name = "scr_user_creat")
    private Long scrUserCreat = 0L;

    /**
     * utilisateur de modification
     */
    @Column(name = "scr_user_modif")
    private Long scrUserModif = 0L;

    /**
     * 0= savegarde base 1= sauvegarde dossier 2=
     */
    @Column(name = "scr_type")
    private Integer scrType = 0;

    /**
     * libelle du script
     */
    @Column(name = "scr_libelle")
    private String scrLibelle;

    /**
     * descriptif
     */
    @Column(name = "scr_description")
    private String scrDescription;

    /**
     * 0=actif 1=inactif 2=supprimer
     */
    @Column(name = "scr_inactif")
    private Integer scrInactif = 0;

    /**
     * 1=lundi
     */
    @Column(name = "scr_lundi")
    private Boolean scrLundi = Boolean.FALSE;

    /**
     * 1=mardi
     */
    @Column(name = "scr_mardi")
    private Boolean scrMardi = Boolean.FALSE;

    /**
     * 1=mercredi
     */
    @Column(name = "scr_mercredi")
    private Boolean scrMercredi = Boolean.FALSE;

    /**
     * 1=jeudi
     */
    @Column(name = "scr_jeudi")
    private Boolean scrJeudi = Boolean.FALSE;

    /**
     * 1=vendredi
     */
    @Column(name = "scr_vendredi")
    private Boolean scrVendredi = Boolean.FALSE;

    /**
     * 1=samedi
     */
    @Column(name = "scr_samedi")
    private Boolean scrSamedi = Boolean.FALSE;

    /**
     * 1=dimanche
     */
    @Column(name = "scr_dimanche")
    private Boolean scrDimanche = Boolean.FALSE;

    /**
     * date de debut
     */
    @Column(name = "scr_date_debut")
    private LocalDate scrDateDebut;

    /**
     * date de fin
     */
    @Column(name = "scr_date_fin")
    private LocalDate scrDateFin;

    /**
     * heure
     */
    @Column(name = "scr_heure_lundi")
    private String scrHeureLundi;

    /**
     * minute
     */
    @Column(name = "scr_minute_lundi")
    private String scrMinuteLundi;

    /**
     * heure
     */
    @Column(name = "scr_heure_mardi")
    private String scrHeureMardi;

    /**
     * minute
     */
    @Column(name = "scr_minute_mardi")
    private String scrMinuteMardi;

    /**
     * heure
     */
    @Column(name = "scr_heure_mercredi")
    private String scrHeureMercredi;

    /**
     * minute
     */
    @Column(name = "scr_minute_mercredi")
    private String scrMinuteMercredi;

    /**
     * heure
     */
    @Column(name = "scr_heure_jeudi")
    private String scrHeureJeudi;

    /**
     * minute
     */
    @Column(name = "scr_minute_jeudi")
    private String scrMinuteJeudi;

    /**
     * heure
     */
    @Column(name = "scr_heure_vendredi")
    private String scrHeureVendredi;

    /**
     * minute
     */
    @Column(name = "scr_minute_vendredi")
    private String scrMinuteVendredi;

    /**
     * heure
     */
    @Column(name = "scr_heure_samedi")
    private String scrHeureSamedi;

    /**
     * minute
     */
    @Column(name = "scr_minute_samedi")
    private String scrMinuteSamedi;

    /**
     * heure
     */
    @Column(name = "scr_heure_dimanche")
    private String scrHeureDimanche;

    /**
     * minute
     */
    @Column(name = "scr_minute_dimanche")
    private String scrMinuteDimanche;

    /**
     * mail envoie du resultat
     */
    @Column(name = "scr_mail")
    private String scrMail;

    /**
     * methode a executer
     */
    @Column(name = "scr_methode")
    private String scrMethode;

    /**
     * parametre : chemin
     */
    @Column(name = "scr_parametre_chemin")
    private String scrParametreChemin;

    /**
     * url
     */
    @Column(name = "scr_url")
    private String scrUrl;

    /**
     * login
     */
    @Column(name = "scr_login")
    private String scrLogin;

    /**
     * pw
     */
    @Column(name = "scr_pw")
    private String scrPw;

}
