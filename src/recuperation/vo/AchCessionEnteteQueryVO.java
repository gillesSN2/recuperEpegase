package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AchCessionEnteteQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cesId;


    /**
     * date de creation
     */
    private LocalDateTime cesDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime cesDateModif;


    /**
     * id user createur
     */
    private Long cesIdCreateur;


    /**
     * nom du createur
     */
    private String cesNomCreateur;


    /**
     * id user de modification
     */
    private Long cesIdModif;


    /**
     * nom user de modification
     */
    private String cesNomModif;


    /**
     * date inventaire
     */
    private LocalDateTime cesDate;


    /**
     * numero inventaire
     */
    private String cesNum;


    /**
     * depot origine
     */
    private String cesDepotOrigine;


    /**
     * depot destination
     */
    private String cesDepotDestination;


    /**
     * nom du commercial
     */
    private String cesNomResponsable;


    /**
     * id du commercial
     */
    private Long cesIdResponsable;


    /**
     * serie
     */
    private String cesSerie;


    /**
     * objet
     */
    private String cesObject;


    /**
     * total ttc
     */
    private Double cesTotPump;


    /**
     * code activite
     */
    private String cesActivite;


    /**
     * code site
     */
    private String cesSite;


    /**
     * code departement
     */
    private String cesDepartement;


    /**
     * code service
     */
    private String cesService;


    /**
     * code region
     */
    private String cesRegion;


    /**
     * code secteur
     */
    private String cesSecteur;


    /**
     * code point de vente
     */
    private String cesPdv;


    /**
     * code analytique 2
     */
    private String cesAnal2;


    /**
     * code analytique 4
     */
    private String cesAnal4;


    /**
     * info 1
     */
    private String cesInfo1;


    /**
     * info 2
     */
    private String cesInfo2;


    /**
     * info 3
     */
    private String cesInfo3;


    /**
     * info 4
     */
    private String cesInfo4;


    /**
     * info 5
     */
    private String cesInfo5;


    /**
     * info 6
     */
    private String cesInfo6;


    /**
     * info 7
     */
    private String cesInfo7;


    /**
     * info 8
     */
    private String cesInfo8;


    /**
     * info 9
     */
    private String cesInfo9;


    /**
     * info 10
     */
    private String cesInfo10;


    /**
     * date impression
     */
    private LocalDate cesDateImp;


    /**
     * nom jasper du modele
     */
    private String cesModeleImp;


    /**
     * 0=sans validation 1=avec validation
     */
    private Integer cesEtatVal;


    /**
     * 0=non gele 1=gele
     */
    private Integer cesGele;


    /**
     * 0=En cours 1=valide 2=gele 3=annule
     */
    private Integer cesEtat;


    /**
     * date de validation
     */
    private LocalDate cesDateValide;


    /**
     * date annulation
     */
    private LocalDate cesDateAnnule;


    /**
     * motif annulation
     */
    private String cesMotifAnnule;

    private Long exeachId;

    private Long usrId;


    /**
     * nom equipe
     */
    private String cesNomEquipe;


    /**
     * id equipe
     */
    private Long cesIdEquipe;


    /**
     * 0=standard fixe 1=standard mobile 2=fictif
     */
    private Integer cesTypeDepot;


    /**
     * code sommier sortie
     */
    private String cesSommier;

}
