package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmUsersObjectifsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long usrobjId;


    /**
     * date de creation
     */
    private LocalDateTime usrobjDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime usrobjDateModif;


    /**
     * utilisateur de creation
     */
    private Long usrobjUserCreat;


    /**
     * utilisateur de creation
     */
    private Long usrobjUserModif;


    /**
     * 0=devis 1=bc 2=bl 3=br 4=facture 5=ndb 6=avoir 10=rdv
     */
    private Integer usrobjNature;


    /**
     * anne objectif
     */
    private String usrobjAnnee;


    /**
     * objectif total
     */
    private Double usrobjCaTotal;


    /**
     * objectif janvier
     */
    private Double usrobjCa01;


    /**
     * objectif fevrier
     */
    private Double usrobjCa02;


    /**
     * objectif mars
     */
    private Double usrobjCa03;


    /**
     * objectif avril
     */
    private Double usrobjCa04;


    /**
     * objectif mai
     */
    private Double usrobjCa05;


    /**
     * objectif juin
     */
    private Double usrobjCa06;


    /**
     * objectif juillet
     */
    private Double usrobjCa07;


    /**
     * objectif aout
     */
    private Double usrobjCa08;


    /**
     * objectif septembre
     */
    private Double usrobjCa09;


    /**
     * objectif octobre
     */
    private Double usrobjCa10;


    /**
     * objectif novembre
     */
    private Double usrobjCa11;


    /**
     * objectif decembre
     */
    private Double usrobjCa12;

    private Long usrId;

}
