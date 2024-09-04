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
public class CmmMailsLuVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "mailuId can not null")
    private Long mailuId;


    /**
     * date de lecture
     */
    private LocalDateTime malluDateLecture;


    /**
     * anotation user
     */
    private String malluNote;


    /**
     * nom et prenom user
     */
    private String malluUser;

    @NotNull(message = "usrId can not null")
    private Long usrId;

    @NotNull(message = "maiId can not null")
    private Long maiId;

}
