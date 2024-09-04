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
public class AchBonEntreeEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "binId can not null")
    private Long binId;


    /**
     * date de creation
     */
    private LocalDateTime binDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime binDateModif;


    /**
     * id user createur
     */
    private Long binIdCreateur;


    /**
     * nom du createur
     */
    private String binNomCreateur;


    /**
     * id user de modification
     */
    private Long binIdModif;


    /**
     * nom user de modification
     */
    private String binNomModif;


    /**
     * date inventaire
     */
    private LocalDateTime binDate;


    /**
     * numero inventaire
     */
    private String binNum;


    /**
     * depot inventorie
     */
    private String binDepot;


    /**
     * nom du commercial
     */
    private String binNomResponsable;


    /**
     * id du commercial
     */
    private Long binIdResponsable;


    /**
     * serie
     */
    private String binSerie;


    /**
     * objet
     */
    private String binObject;


    /**
     * total ttc
     */
    private Double binTotPump;


    /**
     * code activite
     */
    private String binActivite;


    /**
     * code site
     */
    private String binSite;


    /**
     * code departement
     */
    private String binDepartement;


    /**
     * code service
     */
    private String binService;


    /**
     * code region
     */
    private String binRegion;


    /**
     * code secteur
     */
    private String binSecteur;


    /**
     * code point de vente
     */
    private String binPdv;


    /**
     * code analytique 2
     */
    private String binAnal2;


    /**
     * code analytique 4
     */
    private String binAnal4;


    /**
     * info 1
     */
    private String binInfo1;


    /**
     * info 2
     */
    private String binInfo2;


    /**
     * info 3
     */
    private String binInfo3;


    /**
     * info 4
     */
    private String binInfo4;


    /**
     * info 5
     */
    private String binInfo5;


    /**
     * info 6
     */
    private String binInfo6;


    /**
     * info 7
     */
    private String binInfo7;


    /**
     * info 8
     */
    private String binInfo8;


    /**
     * info 9
     */
    private String binInfo9;


    /**
     * info 10
     */
    private String binInfo10;


    /**
     * date impression
     */
    private LocalDate binDateImp;


    /**
     * nom jasper du modele
     */
    private String binModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer binEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer binGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer binEtat;


    /**
     * date de validation
     */
    private LocalDate binDateValide;


    /**
     * date annulation
     */
    private LocalDate binDateAnnule;


    /**
     * motif annulation
     */
    private String binMotifAnnule;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;

    private Long usrId;


    /**
     * nom du rapporteur
     */
    private String binNomRapporteur;


    /**
     * id du rapporteur
     */
    private Long binIdRapporteur;


    /**
     * numero contrat
     */
    private String binContrat;


    /**
     * nom equipe
     */
    private String binNomEquipe;


    /**
     * id equipe
     */
    private Long binIdEquipe;

}
