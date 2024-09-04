package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VteCampagneParticipantQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long camparId;


    /**
     * date de creation
     */
    private LocalDateTime camparDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime camparDateModif;


    /**
     * id user createur
     */
    private Long camparIdCreateur;


    /**
     * nom du createur
     */
    private String camparNomCreateur;


    /**
     * id user de modification
     */
    private Long camparIdModif;


    /**
     * nom user de modification
     */
    private String camparNomModif;


    /**
     * date evenement
     */
    private LocalDateTime camparDate;


    /**
     * commentaire du contact
     */
    private String camparCommentaire;


    /**
     * action a faire
     */
    private String camparAction;


    /**
     * cadeau au contact
     */
    private String camparCadeau;


    /**
     * nom tiers
     */
    private String camparNomTiers;


    /**
     * id du tiers
     */
    private Long camparIdTiers;

    private Long camId;

    private Long conId;

}
