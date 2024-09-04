package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PaySalariesPointageQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long salpoiId;


    /**
     * date de creation
     */
    private LocalDateTime salpoiDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime salpoiDateModif;


    /**
     * utilisateur de creation
     */
    private Long salpoiUserCreat;


    /**
     * utilisateur de modification
     */
    private Long salpoiUserModif;


    /**
     * numero enregistrement
     */
    private String salpoiNum;


    /**
     * etat 0=en cours 1=valide
     */
    private Integer salpoiEtat;


    /**
     * 0=pointage
     */
    private Integer salpoiNature;


    /**
     * date
     */
    private LocalDate salpoiDate;


    /**
     * periode aaaa:mm
     */
    private String salpoiPeriode;


    /**
     * heure debut
     */
    private Integer salpoiHeureDebut;


    /**
     * heure fin
     */
    private Integer salpoiHeureFin;


    /**
     * minute debut
     */
    private Integer salpoiMinuteDebut;


    /**
     * minute fin
     */
    private Integer salpoiMinuteFin;


    /**
     * duree
     */
    private Integer salpoiDuree;


    /**
     * objet evenement
     */
    private String salpoiObjet;


    /**
     * mission
     */
    private String salpoiMission;


    /**
     * service
     */
    private String salpoiService;


    /**
     * activite
     */
    private String salpoiActivite;

    private Long salId;

    private Long exepayId;

}
