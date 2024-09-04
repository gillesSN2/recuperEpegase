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
public class MedMotifEntreeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "mteId can not null")
    private Long mteId;


    /**
     * user de creation
     */
    private Long mteUserCreat;


    /**
     * user de modification
     */
    private Long mteUserModif;


    /**
     * dat de ceration
     */
    private LocalDateTime mteDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime mteDateModif;


    /**
     * code du protocole
     */
    private String mteCode;


    /**
     * libelle du protocole
     */
    private String mteLibelle;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer mteInactif;


    /**
     * 0=non 1=actif dans les consult gene
     */
    private Integer mteConGene;


    /**
     * 0=non 1=actif dans les consult spe
     */
    private Integer mteConSpe;


    /**
     * 0=non 1=actif dans les labo
     */
    private Integer mteLab;


    /**
     * 0=non 1=actif dans les pharmacies
     */
    private Integer mtePha;


    /**
     * 0=non 1=actif dans les consult gene
     */
    private Integer mteHosp;

    @NotNull(message = "exemedId can not null")
    private Long exemedId;

    private Long exevteId;

}
