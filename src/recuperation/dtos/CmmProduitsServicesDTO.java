package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProduitsServicesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long proserId;


    /**
     * code de service
     */
    private String proserCode;


    /**
     * nom du service en FR
     */
    private String proserNomFr;

    private Long proId;

    private Long serId;

}
