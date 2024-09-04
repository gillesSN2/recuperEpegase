package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmTachesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long tacId;


    /**
     * date de creation
     */
    private LocalDateTime tacDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime tacDateModif;


    /**
     * utilisateur de creation
     */
    private Long tacUserCreat;


    /**
     * utilisateur de creation
     */
    private Long tacUserModif;


    /**
     * code tache
     */
    private String tacCode;


    /**
     * libelle FR
     */
    private String tacNomFr;


    /**
     * libelle UK
     */
    private String tacNomUk;


    /**
     * libelle UK
     */
    private String tacNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer tacInactif;


    /**
     * prix de revient de la tache
     */
    private Float tacValPr;


    /**
     * prix de vente de la tache
     */
    private Float tacValPv;


    /**
     * nombre de jour
     */
    private Integer tacValJj;


    /**
     * nombre heures
     */
    private Integer tacValHh;


    /**
     * nombre de minutes
     */
    private Integer tacValMm;


    /**
     * nombre de seconde
     */
    private Integer tacValSs;

}
