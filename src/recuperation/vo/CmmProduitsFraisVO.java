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
public class CmmProduitsFraisVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "profrsId can not null")
    private Long profrsId;


    /**
     * ordre des reponses
     */
    private Integer profrsOrdre;


    /**
     * nom feuille
     */
    private String profrsFeuille;


    /**
     * numero de calcul
     */
    private String profrsNum;


    /**
     * type de la feuille
     */
    private Integer profrsType;


    /**
     * date de creation
     */
    private LocalDate profrsDate;


    /**
     * code
     */
    private String profrsCode;


    /**
     * nom item en FR
     */
    private String profrsLibelle;


    /**
     * taux
     */
    private Float profrsTaux;


    /**
     * formule
     */
    private String profrsFormule;


    /**
     * valeur HT
     */
    private Double profrsHt;


    /**
     * valeur exoneration partielle
     */
    private Double profrsExoPartielle;


    /**
     * valeur exoneration complete
     */
    private Double profrsExoComplete;


    /**
     * autorise dans la colonne ht
     */
    private Boolean profrsColHt;


    /**
     * autorise dans la colonne exo partielle
     */
    private Boolean profrsColExop;


    /**
     * autorise dans la colonne exo totale
     */
    private Boolean profrsColExot;


    /**
     * 0=standard 1=prc 2=prg
     */
    private Integer profrsColType;


    /**
     * prix achat en devise
     */
    private Double profrsPa;


    /**
     * fret en devise
     */
    private Double profrsFret;


    /**
     * assurance locale
     */
    private Double profrsAssurance;


    /**
     * devise
     */
    private String profrsDevise;


    /**
     * coefficient devise
     */
    private Float profrsCoefDevise;


    /**
     * total caf
     */
    private Double profrsCaf;

    @NotNull(message = "proId can not null")
    private Long proId;

}
