package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchBonSortieEnteteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bouId;


    /**
     * date de creation
     */
    private LocalDateTime bouDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime bouDateModif;


    /**
     * id user createur
     */
    private Long bouIdCreateur;


    /**
     * nom du createur
     */
    private String bouNomCreateur;


    /**
     * id user de modification
     */
    private Long bouIdModif;


    /**
     * nom user de modification
     */
    private String bouNomModif;


    /**
     * date inventaire
     */
    private LocalDateTime bouDate;


    /**
     * numero inventaire
     */
    private String bouNum;


    /**
     * depot inventorie
     */
    private String bouDepot;


    /**
     * nom du commercial
     */
    private String bouNomResponsable;


    /**
     * id du commercial
     */
    private Long bouIdResponsable;


    /**
     * serie
     */
    private String bouSerie;


    /**
     * objet
     */
    private String bouObject;


    /**
     * total ttc
     */
    private Double bouTotPump;


    /**
     * code activite
     */
    private String bouActivite;


    /**
     * code site
     */
    private String bouSite;


    /**
     * code departement
     */
    private String bouDepartement;


    /**
     * code service
     */
    private String bouService;


    /**
     * code region
     */
    private String bouRegion;


    /**
     * code secteur
     */
    private String bouSecteur;


    /**
     * code point de vente
     */
    private String bouPdv;


    /**
     * code analytique 2
     */
    private String bouAnal2;


    /**
     * code analytique 4
     */
    private String bouAnal4;


    /**
     * info 1
     */
    private String bouInfo1;


    /**
     * info 2
     */
    private String bouInfo2;


    /**
     * info 3
     */
    private String bouInfo3;


    /**
     * info 4
     */
    private String bouInfo4;


    /**
     * info 5
     */
    private String bouInfo5;


    /**
     * info 6
     */
    private String bouInfo6;


    /**
     * info 7
     */
    private String bouInfo7;


    /**
     * info 8
     */
    private String bouInfo8;


    /**
     * info 9
     */
    private String bouInfo9;


    /**
     * info 10
     */
    private String bouInfo10;


    /**
     * date impression
     */
    private LocalDate bouDateImp;


    /**
     * nom jasper du modele
     */
    private String bouModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer bouEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer bouGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer bouEtat;


    /**
     * date de validation
     */
    private LocalDate bouDateValide;


    /**
     * date annulation
     */
    private LocalDate bouDateAnnule;


    /**
     * motif annulation
     */
    private String bouMotifAnnule;

    private Long exeachId;

    private Long usrId;


    /**
     * nom du demandeur
     */
    private String bouNomDemandeur;


    /**
     * id du demandeur
     */
    private Long bouIdDemandeur;


    /**
     * nom equipe
     */
    private String bouNomEquipe;


    /**
     * id equipe
     */
    private Long bouIdEquipe;

}
