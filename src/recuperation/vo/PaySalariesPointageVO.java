package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class PaySalariesPointageVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "salpoiId can not null")
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

    @NotNull(message = "salId can not null")
    private Long salId;

    @NotNull(message = "exepayId can not null")
    private Long exepayId;

}
