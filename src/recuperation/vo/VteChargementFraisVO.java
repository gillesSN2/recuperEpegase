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
public class VteChargementFraisVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "chafraId can not null")
    private Long chafraId;


    /**
     * code produit
     */
    private String chafraCode;


    /**
     * famille vente
     */
    private String chafraFamille;


    /**
     * libelle produit
     */
    private String chafraLibelle;


    /**
     * num de piece
     */
    private String chafraPiece;


    /**
     * description du frais
     */
    private String chafraDescription;


    /**
     * montant du frais
     */
    private Double chafraMontant;


    /**
     * date du frais
     */
    private LocalDate chafraDate;

    @NotNull(message = "chamobId can not null")
    private Long chamobId;

}
