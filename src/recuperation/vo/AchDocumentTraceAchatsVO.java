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
public class AchDocumentTraceAchatsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "doctrfId can not null")
    private Long doctrfId;


    /**
     * date de creation
     */
    private LocalDateTime doctrfDateCreat;


    /**
     * utilisateur de creation
     */
    private Long doctrfUserId;


    /**
     * nom utilisateur de creation
     */
    private String doctrfUserNom;


    /**
     * type origine
     */
    private Integer doctrfOrgType;


    /**
     * numero origine
     */
    private String doctrfOrgNum;


    /**
     * date origine
     */
    private LocalDateTime doctrfOrgDate;


    /**
     * serie origine
     */
    private String doctrfOrgSerie;


    /**
     * id origine
     */
    private Long doctrfOrgId;


    /**
     * type destination
     */
    private Integer doctrfDstType;


    /**
     * numero destination
     */
    private String doctrfDstNum;


    /**
     * date destination
     */
    private LocalDateTime doctrfDstDate;


    /**
     * serie destination
     */
    private String doctrfDstSerie;


    /**
     * id destination
     */
    private Long doctrfDstId;

    @NotNull(message = "exeachId can not null")
    private Long exeachId;

}
