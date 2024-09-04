package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchFabricationEnteteAchatsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long fabId;


    /**
     * date de creation
     */
    private LocalDateTime fabDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime fabDateModif;


    /**
     * id user createur
     */
    private Long fabIdCreateur;


    /**
     * nom du createur
     */
    private String fabNomCreateur;


    /**
     * id user de modification
     */
    private Long fabIdModif;


    /**
     * nom user de modification
     */
    private String fabNomModif;


    /**
     * date inventaire
     */
    private LocalDateTime fabDate;


    /**
     * numero inventaire
     */
    private String fabNum;


    /**
     * code du process
     */
    private String fabProcess;


    /**
     * depot inventorie
     */
    private String fabDepot;


    /**
     * nom equipe
     */
    private String fabNomEquipe;


    /**
     * id equipe
     */
    private Long fabIdEquipe;


    /**
     * nom du commercial
     */
    private String fabNomResponsable;


    /**
     * id du commercial
     */
    private Long fabIdResponsable;


    /**
     * serie
     */
    private String fabSerie;


    /**
     * objet
     */
    private String fabObject;


    /**
     * total ttc
     */
    private Double fabTotPump;


    /**
     * code activite
     */
    private String fabActivite;


    /**
     * code site
     */
    private String fabSite;


    /**
     * code ligne
     */
    private String fabLigne;


    /**
     * code atelier
     */
    private String fabAtelier;


    /**
     * code analytique 2
     */
    private String fabAnal2;


    /**
     * code analytique 4
     */
    private String fabAnal4;


    /**
     * info 1
     */
    private String fabInfo1;


    /**
     * info 2
     */
    private String fabInfo2;


    /**
     * info 3
     */
    private String fabInfo3;


    /**
     * info 4
     */
    private String fabInfo4;


    /**
     * info 5
     */
    private String fabInfo5;


    /**
     * info 6
     */
    private String fabInfo6;


    /**
     * info 7
     */
    private String fabInfo7;


    /**
     * info 8
     */
    private String fabInfo8;


    /**
     * info 9
     */
    private String fabInfo9;


    /**
     * info 10
     */
    private String fabInfo10;


    /**
     * date impression
     */
    private LocalDateTime fabDateImp;


    /**
     * nom jasper du modele
     */
    private String fabModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer fabEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer fabGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer fabEtat;


    /**
     * date de validation
     */
    private LocalDate fabDateValide;


    /**
     * date annulation
     */
    private LocalDate fabDateAnnule;


    /**
     * motif annulation
     */
    private String fabMotifAnnule;

    private Long exeachId;

    private Long usrId;

}
