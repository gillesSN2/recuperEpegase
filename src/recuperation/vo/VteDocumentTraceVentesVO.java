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
public class VteDocumentTraceVentesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "doctraId can not null")
    private Long doctraId;


    /**
     * date de creation
     */
    private LocalDateTime doctraDateCreat;


    /**
     * utilisateur de creation
     */
    private Long doctraUserId;


    /**
     * nom utilisateur de creation
     */
    private String doctraUserNom;


    /**
     * type origine
     */
    private Integer doctraOrgType;


    /**
     * numero origine
     */
    private String doctraOrgNum;


    /**
     * date origine
     */
    private LocalDateTime doctraOrgDate;


    /**
     * serie origine
     */
    private String doctraOrgSerie;


    /**
     * id origine
     */
    private Long doctraOrgId;


    /**
     * type destination
     */
    private Integer doctraDstType;


    /**
     * numero destination
     */
    private String doctraDstNum;


    /**
     * date destination
     */
    private LocalDateTime doctraDstDate;


    /**
     * serie destination
     */
    private String doctraDstSerie;


    /**
     * id destination
     */
    private Long doctraDstId;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

}
