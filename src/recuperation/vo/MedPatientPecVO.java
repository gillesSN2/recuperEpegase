package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

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
public class MedPatientPecVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "patpecId can not null")
    private Long patpecId;


    /**
     * assurance, societe ou complementaire
     */
    private String patpecNumType;


    /**
     * numero de contrat de l assurance
     */
    private String patpecNumContrat;


    /**
     * dat de debut de prise en charge
     */
    private LocalDate patpecDateDebut;


    /**
     * dat de fin de prise en charge
     */
    private LocalDate patpecDateFin;


    /**
     * montant du planfond pour l hebergement
     */
    private Double patpecHebergementPlaf;


    /**
     * % remboursement hebergement
     */
    private Float patpecHebergementRep;


    /**
     * % remboursement des soins
     */
    private Float patpecSoins;


    /**
     * % remboursement des actes et examens
     */
    private Float patpecExamenss;


    /**
     * % remboursement des autres prestations
     */
    private Float patpecPrestations;


    /**
     * % remboursement soins dentaires
     */
    private Float patpecDentaire;


    /**
     * % remboursement soins occulaires
     */
    private Float patpecOcculaire;


    /**
     * % remboursement medicaments
     */
    private Float patpecMedicament;


    /**
     * % remboursement de l hotelerie
     */
    private Float patpacHotelerie;


    /**
     * montant remboursement forfaitaire
     */
    private Float patpecForfait;


    /**
     * 0=actif 1=inactif
     */
    private Integer patpecInactif;


    /**
     * numero de securite sociale
     */
    private String patpecNumCnss;


    /**
     * numero de couverture
     */
    private String patpecNumCouvert;


    /**
     * matricvule agent de couverture
     */
    private String patpecAgentRefact;

    @NotNull(message = "tieId can not null")
    private Long tieId;

    @NotNull(message = "patId can not null")
    private Long patId;

}
