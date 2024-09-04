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
public class PaySalariesHistoriqueVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "salhisId can not null")
    private Long salhisId;


    /**
     * numero contrat
     */
    private String salhisContrat;


    /**
     * code rubrique
     */
    private String salhisCode;


    /**
     * libelle rubrique
     */
    private String salhisLibelle;


    /**
     * date historique
     */
    private LocalDate salhisDate;


    /**
     * valeur colonne E
     */
    private Double salhisValeurCole;

    @NotNull(message = "salId can not null")
    private Long salId;

    @NotNull(message = "exepayId can not null")
    private Long exepayId;

}
