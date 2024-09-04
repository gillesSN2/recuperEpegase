package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmUsersChronoQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long usrchrId;


    /**
     * date de creation
     */
    private LocalDateTime usrchrDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime usrchrDateModif;


    /**
     * utilisateur de creation
     */
    private Long usrchrUserCreat;


    /**
     * utilisateur de creation
     */
    private Long usrchrUserModif;


    /**
     * code serie
     */
    private String usrchrSerie;


    /**
     * libelle serie
     */
    private String usrchrLib;


    /**
     * code nature
     */
    private Integer usrchrNature;


    /**
     * 0=valide a l impression 1=valide a l enregistrement 2=sur bouton
     */
    private Integer usrchrValidation;


    /**
     * 0=devalidation interdite 1=devalidation autorisee
     */
    private Integer usrchrDevalidation;


    /**
     * 0=dupplication interdite 1=dupplication autorisee
     */
    private Integer usrchrDupplication;


    /**
     * mise ÃƒÂ  jour autorisee 1=mise ÃƒÂ  jour interdite
     */
    private Integer usrchrUpdate;


    /**
     * 0=public 1=prive
     */
    private Integer usrchrPrive;

    private Long usrId;


    /**
     * montant plafond de l operation
     */
    private String usrchrPlanfond;


    /**
     * 0=autorisee sans habilitation 1=autorisee avec habilitation 2=interdiction
     */
    private String usrchrMode;

}
