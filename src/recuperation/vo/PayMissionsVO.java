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
public class PayMissionsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "misId can not null")
    private Long misId;


    /**
     * date de creation
     */
    private LocalDateTime misDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime misDateModif;


    /**
     * utilisateur de creation
     */
    private Long misUserCreat;


    /**
     * utilisateur de modification
     */
    private Long misUserModif;


    /**
     * numero mission
     */
    private String misNum;


    /**
     * pays
     */
    private String misPays;


    /**
     * 0=formation 1=reunion 2=seminaire 3=terrain 4=visite
     */
    private Integer misNature;


    /**
     * 0=local 1=etranger
     */
    private Integer misMode;


    /**
     * prix unitaire perdiem
     */
    private Double misPuPerdiem;


    /**
     * nombre de jour theorique
     */
    private Integer misNbJourTheo;


    /**
     * perdiem theorique
     */
    private Double misPerdiemTheo;


    /**
     * objectif
     */
    private String misObjectif;


    /**
     * detail mission
     */
    private String misDetail;


    /**
     * 0=en cours 1=approuve 2=execution 3=retour 4=cloture 5=annule 6=gele
     */
    private Integer misEtat;


    /**
     * imputation service
     */
    private String misService;


    /**
     * imputation activite
     */
    private String misActicvite;


    /**
     * imputation budget
     */
    private String misBudget;


    /**
     * disponibilite du budget
     */
    private Double misBudgetDispo;


    /**
     * disponibilite du budget du mois
     */
    private Double misBudgetDispoMois;


    /**
     * disponibilite de tresorerie
     */
    private Double misBudgetTreso;


    /**
     * disponibilite de tresorerie du mois
     */
    private Double misBudgetTresoMois;


    /**
     * id responsable
     */
    private Long misIdResponsable;


    /**
     * nom responsable
     */
    private String misNomResponsable;


    /**
     * date debut
     */
    private LocalDate misDateDebut;


    /**
     * date fin
     */
    private LocalDate misDateFin;


    /**
     * date debut reelle
     */
    private LocalDate misDateDebutReel;


    /**
     * date fin reelle
     */
    private LocalDate misDateFinReel;


    /**
     * nombre de jour reel
     */
    private Integer misNbJourReel;


    /**
     * perdiem reel
     */
    private Double misPerdiemReel;


    /**
     * ordre de mission
     */
    private String misOrdreMission;


    /**
     * itineraire
     */
    private String misItineraire;


    /**
     * rapport de mission
     */
    private String misRapportMission;


    /**
     * total transport
     */
    private Double misTotalTransport;


    /**
     * total hebergement
     */
    private Double misTotalHebergement;


    /**
     * total restauration
     */
    private Double misTotalRestauration;


    /**
     * total divers
     */
    private Double misTotalDivers;


    /**
     * total visa
     */
    private Double misTotalVisa;


    /**
     * total perdiem
     */
    private Double misTotalPerdiem;


    /**
     * total cout mission
     */
    private Double misTotalCout;

    @NotNull(message = "exepayId can not null")
    private Long exepayId;

}
