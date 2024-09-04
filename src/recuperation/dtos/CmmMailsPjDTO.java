package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmMailsPjDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long maipjId;


    /**
     * chemin acces a la pj
     */
    private String malpjAcces;

    private Long maiId;

}
