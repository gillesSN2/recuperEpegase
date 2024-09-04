package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmMailsLuQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

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

    private Long usrId;

    private Long maiId;

}
