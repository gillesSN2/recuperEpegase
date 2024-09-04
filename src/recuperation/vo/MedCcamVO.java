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
public class MedCcamVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "ccamId can not null")
    private Long ccamId;


    /**
     * code famille
     */
    private String ccamFamCode;

    private String ccamFamLibFr;

    private String ccamFamLibUk;

    private String ccamFamLibSp;


    /**
     * code sous famille
     */
    private String ccamSfamCode;

    private String ccamSfamLibFr;

    private String ccamSfamLibUk;

    private String ccamSfamLibSp;


    /**
     * code sous sous famille
     */
    private String ccamSsfamCode;

    private String ccamSsfamLibFr;

    private String ccamSsfamLibUk;

    private String ccamSsfamLibSp;


    /**
     * code sous sous sous famille
     */
    private String ccamSssfamCode;

    private String ccamSssfamLibFr;

    private String ccamSssfamLibUk;

    private String ccamSssfamLibSp;


    /**
     * code ccam
     */
    private String ccamDetCode;

    private String ccamDetLibFr;

    private String ccamDetLibUk;

    private String ccamDetLibSp;


    /**
     * code activite
     */
    private String ccamDetActivite;

    private String ccamDetPhase;


    /**
     * prix en euro
     */
    private Float ccamDetPuEuro;


    /**
     * prix local
     */
    private Float ccamDetPuLocal;

    private String ccamDetRmbSc;

    private String ccamDetAccPre;

    private String ccamDetExoTm;

    private String ccamDetGrp;

}
