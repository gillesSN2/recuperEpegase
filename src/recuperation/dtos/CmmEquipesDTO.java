package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmEquipesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long equId;


    /**
     * date de creation
     */
    private LocalDateTime equDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime equDateModif;


    /**
     * utilisateur de creation
     */
    private Long equUserCreat;


    /**
     * utilisateur de modification
     */
    private Long equUserModif;


    /**
     * 0=commercial 1=administratif 3=production
     */
    private Integer equType;


    /**
     * code activite
     */
    private String equCode;


    /**
     * nom activite en FR
     */
    private String equNomFr;


    /**
     * nom activite en UK
     */
    private String equNomUk;


    /**
     * nom activite en SP
     */
    private String equNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer equInactif;


    /**
     * numero de quart
     */
    private Integer equQuart;


    /**
     * heure debut
     */
    private Integer equHeureDebut;


    /**
     * heure fin
     */
    private Integer equHeureFin;


    /**
     * minute debut
     */
    private Integer equMinuteDebut;


    /**
     * minute fin
     */
    private Integer equMinuteFin;


    /**
     * id responsable
     */
    private Long equIdResponsable;


    /**
     * nom responsable
     */
    private String equNomResponsable;


    /**
     * tableau des id agents
     */
    private String equIdAgent;


    /**
     * tableau des nom agents
     */
    private String equNomAgent;


    /**
     * depot de travail
     */
    private String equDepot;


    /**
     * depot origine
     */
    private String equDepotOrigine;


    /**
     * caisse affectee
     */
    private String equCaisse;


    /**
     * 0=stock equipe 1=stock global
     */
    private Integer equStock;

}
