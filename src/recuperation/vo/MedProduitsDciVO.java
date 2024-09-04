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
public class MedProduitsDciVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "prodciId can not null")
    private Long prodciId;


    /**
     * date de creation
     */
    private LocalDateTime prodciDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime prodciDateModif;


    /**
     * utilisateur de creation
     */
    private Long prodciUserCreation;


    /**
     * utilisateur de modification
     */
    private Long prodciUserModif;


    /**
     * code dci
     */
    private String prodciCode;


    /**
     * forme
     */
    private String prodciForme;


    /**
     * indication
     */
    private String prodciIndication;


    /**
     * posologie
     */
    private String prodciPosologie;


    /**
     * contre indication
     */
    private String prodciContreIndic;


    /**
     * effet secondaire
     */
    private String prodciEffetSecond;


    /**
     * 0=medicamment 1= a base de plante 2=veterinaire 3=hydratant cutanee 4=parapharmacie
     */
    private Integer prodciType;


    /**
     * ???
     */
    private Integer prodciCat;

}
