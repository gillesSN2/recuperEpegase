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
public class VteTicketEnteteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ticId can not null")
    private Long ticId;


    /**
     * date du factue
     */
    private LocalDateTime ticDate;


    /**
     * numero facture
     */
    private String ticNum;


    /**
     * nom du responsable
     */
    private String ticNomResponsable;


    /**
     * id du responsable
     */
    private Long ticIdResponsable;


    /**
     * nom du commercial
     */
    private String ticNomCommercial;


    /**
     * id du commercial
     */
    private Long ticIdCommercial;


    /**
     * nom du client
     */
    private String ticNomTiers;


    /**
     * civilite du tiers
     */
    private String ticCivilTiers;


    /**
     * code site
     */
    private String ticSite;


    /**
     * code adepartement
     */
    private String ticDepartement;


    /**
     * code service
     */
    private String ticService;


    /**
     * prix total ht
     */
    private Double ticTotalHt;


    /**
     * total taxe
     */
    private Double ticTotalTva;


    /**
     * total taxe complementaire
     */
    private Double ticTotalTc;


    /**
     * total ttc
     */
    private Double ticTotalTtc;


    /**
     * total reglement
     */
    private Double ticTotalReglement;


    /**
     * 0=paiement comptant 1=terme date de facture 2=terme fin de mois 3=arrivee/paye 4=bon encaissement
     */
    private Integer ticTypeReg;


    /**
     * mode de reglement xml
     */
    private String ticModeReg;


    /**
     * nombre de jour
     */
    private Integer ticNbJourReg;


    /**
     * nombre de jour arrondi
     */
    private Integer ticArrondiReg;


    /**
     * date echeance de reglement
     */
    private LocalDate ticDateEcheReg;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    private Long usrId;


    /**
     * taux taxe complementaire
     */
    private Float ticTauxTc;


    /**
     * nom equipe
     */
    private String ticNomEquipe;


    /**
     * id equipe
     */
    private Long ticIdEquipe;


    /**
     * date transfert en compta
     */
    private LocalDate ticDateTransfert;


    /**
     * numero de transfert
     */
    private String ticNumTrf;


    /**
     * etat
     */
    private Integer ticEtat;


    /**
     * code devise
     */
    private String ticDevise;

}
