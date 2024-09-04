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
public class CmmProduitsTarifVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "protarId can not null")
    private Long protarId;


    /**
     * coefficient de vente
     */
    private Float protarCoef;


    /**
     * famille client
     */
    private String protarClient;


    /**
     * lettre
     */
    private String protarLettre;


    /**
     * nombre de lettre
     */
    private Float protarNb;


    /**
     * valeur de lettre
     */
    private Double protarValeur;


    /**
     * prix vente
     */
    private Double protarPv;


    /**
     * ordre = numero ligne xml
     */
    private Integer protarOrdre;


    /**
     * conditionnement
     */
    private String protarCondit;


    /**
     * unite
     */
    private String protarUnite;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer protarInactif;


    /**
     * 1=exonere de tva
     */
    private Boolean protarExoTva;


    /**
     * 1=exonere de douane
     */
    private Boolean protarExoDd;


    /**
     * taux de tva
     */
    private Float protarTauxTva;


    /**
     * prix vente du marche
     */
    private Double protarPvMarche;


    /**
     * prix vente concurrent 1
     */
    private Double protarPvCc1;


    /**
     * prix vente concurrent 2
     */
    private Double protarPvCc2;


    /**
     * prix vente concurrent 3
     */
    private Double protarPvCc3;


    /**
     * date prix du marche
     */
    private LocalDate protarDateMarche;


    /**
     * date prix vente concurrent 1
     */
    private LocalDate protarDateCc1;


    /**
     * date prix vente concurrent 2
     */
    private LocalDate protarDateCc2;


    /**
     * date prix vente concurrent 3
     */
    private LocalDate protarDateCc3;

    @NotNull(message = "proId can not null")
    private Long proId;


    /**
     * nom concurrent 1
     */
    private String protarNomCc1;


    /**
     * nom concurrent 2
     */
    private String protarNomCc2;


    /**
     * nom concurrent 3
     */
    private String protarNomCc3;


    /**
     * tarif par quantite
     */
    private String protarTarifQte;

}
