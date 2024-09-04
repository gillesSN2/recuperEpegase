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
public class PaySalariesMissionsFraisVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "salmisfraId can not null")
    private Long salmisfraId;


    /**
     * date du frais
     */
    private LocalDate salmisfraDate;


    /**
     * objet du frais
     */
    private String salmisfraObjet;


    /**
     * 0=preparation mission 1=retour mission
     */
    private Integer salmisfraMode;


    /**
     * 0=transport 1=hebergement 2=restauration 3=divers
     */
    private Integer salmisfraType;


    /**
     * reference du frais
     */
    private String salmisfraReference;


    /**
     * fourisseur origine
     */
    private String salmisfraFournisseur;


    /**
     * cout du frais
     */
    private Double salmisfraCout;

    @NotNull(message = "salId can not null")
    private Long salId;

    @NotNull(message = "misId can not null")
    private Long misId;

}
