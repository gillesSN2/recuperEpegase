package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PrcParcAffectationQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long prcaffId;


    /**
     * date creation
     */
    private LocalDateTime prcaffDateCreat;


    /**
     * date modification
     */
    private LocalDateTime prcaffDateModif;


    /**
     * id user de creation
     */
    private Long prcaffUserCreat;


    /**
     * id user de modification
     */
    private Long prcaffUserModif;


    /**
     * 0=affectation 1=imputation 2=proprietaire
     */
    private Integer prcaffType;


    /**
     * matricule du salarie
     */
    private String prcaffMatSalarie;


    /**
     * nom du salarie
     */
    private String prcaffNomSalarie;


    /**
     * prenom du salarie
     */
    private String prcaffPrenomSalarie;


    /**
     * code service
     */
    private String prcaffService;


    /**
     * libelle service
     */
    private String prcaffLibService;


    /**
     * id du tiers
     */
    private Long prcaffIdTiers;


    /**
     * nom du tiers
     */
    private String prcaffNomTiers;


    /**
     * contact du tiers
     */
    private String prcaffContactTiers;


    /**
     * telephone du tiers
     */
    private String prcaffTelTiers;


    /**
     * ville du tiers
     */
    private String prcaffVilleTiers;


    /**
     * adresse du tiers
     */
    private String prcaffAdresseTiers;


    /**
     * date debut
     */
    private LocalDate prcaffDateDebut;


    /**
     * date fin
     */
    private LocalDate prcaffDateFin;

    private Long prcId;

}
