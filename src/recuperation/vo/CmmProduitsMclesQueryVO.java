package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProduitsMclesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long promclId;


    /**
     * mot cle
     */
    private String promclMot;

    private Long proId;

}
