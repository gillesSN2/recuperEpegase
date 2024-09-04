package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaySalariesCongesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long salcngId;


    /**
     * date de creation
     */
    private LocalDateTime salcngDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime salcngDateModif;


    /**
     * utilisateur de creation
     */
    private Long salcngUserCreat;


    /**
     * utilisateur de modification
     */
    private Long salcngUserModif;


    /**
     * 0=conges 1=absences posees 2=absences ou retards constatees
     */
    private Integer salcngType;


    /**
     * 0=cp normaux 1=bulletin de conges 2=conges travaille 3=conges immediat
     */
    private Integer salcngNature;


    /**
     * date debut des conges
     */
    private LocalDate salcngDateDebut;


    /**
     * date fin des conges
     */
    private LocalDate salcngDateFin;


    /**
     * duree des conges
     */
    private Integer salcngDuree;


    /**
     * motif des conges
     */
    private String salcngObjet;


    /**
     * responsable
     */
    private String salcngResponsable;


    /**
     * lieu
     */
    private String salcngLieu;


    /**
     * nombre heure de retard
     */
    private Float salcngNbHeure;


    /**
     * 0= sans habilitation 1=avec habilitation
     */
    private Integer salcngEtatVal;


    /**
     * 0=non valide 1=valide
     */
    private Integer salcngEtat;


    /**
     * date de validation
     */
    private LocalDateTime salcngDateValide;


    /**
     * date impression
     */
    private LocalDateTime salcngDateImp;

    private Long salId;


    /**
     * absence le matin
     */
    private Boolean salcngAm;


    /**
     * absence apres midi
     */
    private Boolean salcngPm;

}
