package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class VteDocumentTraceVentesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
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

    private Long exevteId;

}
