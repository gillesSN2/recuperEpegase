package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CmmEspionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
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

    private Long usrId;

}
