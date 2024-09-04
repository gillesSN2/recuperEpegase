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
public class CptEcrituresAnterieurVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ecrantId can not null")
    private Long ecrantId;


    /**
     * concatenation ecr_code:ecr_periode
     */
    private String ecrantCle1;


    /**
     * date ecriture
     */
    private LocalDate ecrantDateCreat;


    /**
     * code journal table planJournauxComptables
     */
    private String ecrantCode;


    /**
     * MM:AAAA par rapport a la date de saisie
     */
    private String ecrantPeriode;


    /**
     * partie annee de la date de saisie
     */
    private String ecrantAnnee;


    /**
     * montant credit dans la devise de saisie
     */
    private Double ecrantDebitSaisie;


    /**
     * montant credit dans la devise de saisie
     */
    private Double ecrantCreditSaisie;


    /**
     * code de rapprochement MM:AAAA
     */
    private String ecrantRapprochement;


    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    private Integer ecrantCloture;


    /**
     * libelle ecriture
     */
    private String ecrantLibelle;


    /**
     * numero de piece comptable
     */
    private String ecrantPiece;


    /**
     * reference 1
     */
    private String ecrantReference1;


    /**
     * reference 2
     */
    private String ecrantReference2;


    /**
     * 0=anterieur 1=extra comptable
     */
    private Integer ecrantType;

    @NotNull(message = "execptId can not null")
    private Long execptId;

}
