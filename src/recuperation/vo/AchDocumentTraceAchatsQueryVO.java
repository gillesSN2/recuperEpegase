package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AchDocumentTraceAchatsQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

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

    private Long exeachId;

}
