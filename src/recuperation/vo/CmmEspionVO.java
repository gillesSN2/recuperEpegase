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
public class CmmEspionVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "espId can not null")
    private Long espId;


    /**
     * date de creation
     */
    private LocalDateTime espDteCreat;


    /**
     * action realisee
     */
    private String espAction;


    /**
     * 0=espion 1=log
     */
    private Integer espType;

    @NotNull(message = "usrId can not null")
    private Long usrId;

}
