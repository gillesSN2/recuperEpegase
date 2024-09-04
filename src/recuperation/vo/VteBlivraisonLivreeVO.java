package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
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
public class VteBlivraisonLivreeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "blvlivId can not null")
    private Long blvlivId;


    /**
     * id du bl
     */
    private Long blvlivIdBl;


    /**
     * code produit
     */
    private String blvlivCode;


    /**
     * code depot
     */
    private String blvlivDepot;


    /**
     * quantite livree
     */
    private Float blvlivQteLivree;


    /**
     * quantite utilisee (valable pour le stock)
     */
    private Float blvlivQteUtilLivree;


    /**
     * date livraison
     */
    private LocalDateTime blvlivDate;


    /**
     * nom du chauffeur
     */
    private String blvlivChauffeur;


    /**
     * immatricule du vehicule
     */
    private String blvlivVehicule;


    /**
     * preparateur
     */
    private String blvlivPreparateur;

    @NotNull(message = "blvligId can not null")
    private Long blvligId;

}
