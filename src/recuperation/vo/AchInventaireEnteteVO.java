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
public class AchInventaireEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "invId can not null")
    private Long invId;


    /**
     * date de creation
     */
    private LocalDateTime invDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime invDateModif;


    /**
     * id user createur
     */
    private Long invIdCreateur;


    /**
     * nom du createur
     */
    private String invNomCreateur;


    /**
     * id user de modification
     */
    private Long invIdModif;


    /**
     * nom user de modification
     */
    private String invNomModif;


    /**
     * date inventaire
     */
    private LocalDateTime invDate;


    /**
     * numero inventaire
     */
    private String invNum;


    /**
     * depot inventorie
     */
    private String invDepot;


    /**
     * 0=ecrasement 1=correction
     */
    private Integer invType;


    /**
     * 0=normal 1=sur depot 2=sur casier 3=sur famille 4=sur stock negatif
     */
    private Integer invMode;


    /**
     * specification de creation inventaire
     */
    private String invModeSpecif;


    /**
     * nom du commercial
     */
    private String invNomResponsable;


    /**
     * id du commercial
     */
    private Long invIdResponsable;


    /**
     * serie
     */
    private String invSerie;


    /**
     * objet
     */
    private String invObject;


    /**
     * total ttc
     */
    private Double invTotPump;


    /**
     * code activite
     */
    private String invActivite;


    /**
     * code site
     */
    private String invSite;


    /**
     * code departement
     */
    private String invDepartement;


    /**
     * code service
     */
    private String invService;


    /**
     * code region
     */
    private String invRegion;


    /**
     * code secteur
     */
    private String invSecteur;


    /**
     * code point de vente
     */
    private String invPdv;


    /**
     * code analytique 2
     */
    private String invAnal2;


    /**
     * code analytique 4
     */
    private String invAnal4;


    /**
     * info 1
     */
    private String invInfo1;


    /**
     * info 2
     */
    private String invInfo2;


    /**
     * info 3
     */
    private String invInfo3;


    /**
     * info 4
     */
    private String invInfo4;


    /**
     * info 5
     */
    private String invInfo5;


    /**
     * info 6
     */
    private String invInfo6;


    /**
     * info 7
     */
    private String invInfo7;


    /**
     * info 8
     */
    private String invInfo8;


    /**
     * info 9
     */
    private String invInfo9;


    /**
     * info 10
     */
    private String invInfo10;


    /**
     * date impression
     */
    private LocalDate invDateImp;


    /**
     * nom jasper du modele
     */
    private String invModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer invEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer invGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer invEtat;


    /**
     * date de validation
     */
    private LocalDate invDateValide;


    /**
     * date annulation
     */
    private LocalDate invDateAnnule;


    /**
     * motif annulation
     */
    private String invMotifAnnule;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;

    private Long usrId;


    /**
     * nom equipe
     */
    private String invNomEquipe;


    /**
     * id equipe
     */
    private Long invIdEquipe;

}
