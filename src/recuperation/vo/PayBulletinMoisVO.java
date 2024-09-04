package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

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
public class PayBulletinMoisVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "bulmenId can not null")
    private Long bulmenId;


    /**
     * numero feuille
     */
    private String bulmenFeuille;


    /**
     * periode MMAAAA
     */
    private String bulmenPeriode;


    /**
     * = concatenation bulmen_feuille : bulmen_periode
     */
    private String bulmenCle1;


    /**
     * 0=en cours 1=saisie mensuelle 2=generation 3=cloture 4=transfert
     */
    private Integer bulmenEtat;


    /**
     * user utilisation journal
     */
    private Long bulmenUserIdJournal;


    /**
     * 0=journal ferme 1=journal ouvert
     */
    private Integer bulmenOpenJournal;


    /**
     * nom utilisateur en cours
     */
    private String bulmenOpenUserJournal;


    /**
     * user utilisation journal
     */
    private Long bulmenUserIdGeneration;


    /**
     * 0=journal ferme 1=journal ouvert
     */
    private Integer bulmenOpenGeneration;


    /**
     * nom utilisateur en cours
     */
    private String bulmenOpenUserGeneration;

    @NotNull(message = "exepayId can not null")
    private Long exepayId;

}
