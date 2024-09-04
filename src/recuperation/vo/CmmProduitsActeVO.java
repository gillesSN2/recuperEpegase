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
public class CmmProduitsActeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "proactId can not null")
    private Long proactId;


    /**
     * hierarchie
     */
    private String proactHierarchie;


    /**
     * rang
     */
    private String proactRang;


    /**
     * position
     */
    private String proactPosition;


    /**
     * y
     */
    private String proactY;


    /**
     * icr
     */
    private String proactIcr;


    /**
     * para
     */
    private String proactPara;


    /**
     * A
     */
    private String proactA;


    /**
     * B
     */
    private String proactB;


    /**
     * CC
     */
    private String proactCc;


    /**
     * score
     */
    private String proactScrore;


    /**
     * observation
     */
    private String proactObservations;

    @NotNull(message = "proId can not null")
    private Long proId;

}
