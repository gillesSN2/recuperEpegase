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
public class CptJournauxMoisVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "joumenId can not null")
    private Long joumenId;


    /**
     * code journal
     */
    private String joumenCode;


    /**
     * periode MMAAAA
     */
    private String joumenPeriode;


    /**
     * user utilisation journal
     */
    private Long joumenUserIdJournal;


    /**
     * 0=journal ferme 1=journal ouvert
     */
    private Integer joumenOpenJournal;


    /**
     * nom utilisateur en cours
     */
    private String joumenOpenUserJournal;


    /**
     * = concatenation joumen_code : joumen_periode
     */
    private String joumenCle1;


    /**
     * 0=en cours 1=cloture mensuelle 2=cloture annuelle
     */
    private Integer joumenEtat;


    /**
     * 0=sans ecriture 1=ecriture deja saisie
     */
    private Integer joumenSaisie;


    /**
     * solde du releve de la banque
     */
    private Double joumenReleve;


    /**
     * solde du releve de la banque anterieur A-1
     */
    private Double joumenReleveAnte;

    @NotNull(message = "execptId can not null")
    private Long execptId;

}
