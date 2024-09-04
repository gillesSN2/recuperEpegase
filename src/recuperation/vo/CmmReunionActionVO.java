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
public class CmmReunionActionVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "reuactId can not null")
    private Long reuactId;


    /**
     * numero de reunion
     */
    private String reuactNum;


    /**
     * id du user
     */
    private Long reuactIdUser;


    /**
     * nom du user
     */
    private String reuactNomUser;


    /**
     * prenom du user
     */
    private String reuactPrenomUser;


    /**
     * civilite du user
     */
    private String reuactCiviliteUser;


    /**
     * fonction du user
     */
    private String reuactFonctionUser;


    /**
     * quoi
     */
    private String reuactQuoi;


    /**
     * quand
     */
    private String reuactQuand;


    /**
     * date buttoire
     */
    private LocalDate reuactDate;


    /**
     * ou
     */
    private String reuactOu;


    /**
     * 0=en cours 1=traite succes 2=traite echec 3=non traite 4=repporte
     */
    private Integer reuactEtat;


    /**
     * date report
     */
    private LocalDate reuactDateReport;

    @NotNull(message = "reuId can not null")
    private Long reuId;


    /**
     * date execution
     */
    private LocalDate reuactDateExecution;


    /**
     * numero reunion execution
     */
    private String reuactNumExecution;


    /**
     * observation execution
     */
    private String reuactObsExecution;

}
