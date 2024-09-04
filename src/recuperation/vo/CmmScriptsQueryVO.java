package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CmmScriptsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long scrId;


    /**
     * date de creation
     */
    private LocalDateTime scrDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime scrDateModif;


    /**
     * utilisateur de creation
     */
    private Long scrUserCreat;


    /**
     * utilisateur de modification
     */
    private Long scrUserModif;


    /**
     * 0= savegarde base 1= sauvegarde dossier 2=
     */
    private Integer scrType;


    /**
     * libelle du script
     */
    private String scrLibelle;


    /**
     * descriptif
     */
    private String scrDescription;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer scrInactif;


    /**
     * 1=lundi
     */
    private Boolean scrLundi;


    /**
     * 1=mardi
     */
    private Boolean scrMardi;


    /**
     * 1=mercredi
     */
    private Boolean scrMercredi;


    /**
     * 1=jeudi
     */
    private Boolean scrJeudi;


    /**
     * 1=vendredi
     */
    private Boolean scrVendredi;


    /**
     * 1=samedi
     */
    private Boolean scrSamedi;


    /**
     * 1=dimanche
     */
    private Boolean scrDimanche;


    /**
     * date de debut
     */
    private LocalDate scrDateDebut;


    /**
     * date de fin
     */
    private LocalDate scrDateFin;


    /**
     * heure
     */
    private String scrHeureLundi;


    /**
     * minute
     */
    private String scrMinuteLundi;


    /**
     * heure
     */
    private String scrHeureMardi;


    /**
     * minute
     */
    private String scrMinuteMardi;


    /**
     * heure
     */
    private String scrHeureMercredi;


    /**
     * minute
     */
    private String scrMinuteMercredi;


    /**
     * heure
     */
    private String scrHeureJeudi;


    /**
     * minute
     */
    private String scrMinuteJeudi;


    /**
     * heure
     */
    private String scrHeureVendredi;


    /**
     * minute
     */
    private String scrMinuteVendredi;


    /**
     * heure
     */
    private String scrHeureSamedi;


    /**
     * minute
     */
    private String scrMinuteSamedi;


    /**
     * heure
     */
    private String scrHeureDimanche;


    /**
     * minute
     */
    private String scrMinuteDimanche;


    /**
     * mail envoie du resultat
     */
    private String scrMail;


    /**
     * methode a executer
     */
    private String scrMethode;


    /**
     * parametre : chemin
     */
    private String scrParametreChemin;


    /**
     * url
     */
    private String scrUrl;


    /**
     * login
     */
    private String scrLogin;


    /**
     * pw
     */
    private String scrPw;

}
