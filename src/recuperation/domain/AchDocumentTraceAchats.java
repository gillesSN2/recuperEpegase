package recuperation.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ach_document_trace_achats")
public class AchDocumentTraceAchats implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "doctrf_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctrfId;

    /**
     * date de creation
     */
    @Column(name = "doctrf_date_creat")
    private LocalDateTime doctrfDateCreat;

    /**
     * utilisateur de creation
     */
    @Column(name = "doctrf_user_id")
    private Long doctrfUserId = 0L;

    /**
     * nom utilisateur de creation
     */
    @Column(name = "doctrf_user_nom")
    private String doctrfUserNom;

    /**
     * type origine
     */
    @Column(name = "doctrf_org_type")
    private Integer doctrfOrgType = 0;

    /**
     * numero origine
     */
    @Column(name = "doctrf_org_num")
    private String doctrfOrgNum;

    /**
     * date origine
     */
    @Column(name = "doctrf_org_date")
    private LocalDateTime doctrfOrgDate;

    /**
     * serie origine
     */
    @Column(name = "doctrf_org_serie")
    private String doctrfOrgSerie;

    /**
     * id origine
     */
    @Column(name = "doctrf_org_id")
    private Long doctrfOrgId = 0L;

    /**
     * type destination
     */
    @Column(name = "doctrf_dst_type")
    private Integer doctrfDstType = 0;

    /**
     * numero destination
     */
    @Column(name = "doctrf_dst_num")
    private String doctrfDstNum;

    /**
     * date destination
     */
    @Column(name = "doctrf_dst_date")
    private LocalDateTime doctrfDstDate;

    /**
     * serie destination
     */
    @Column(name = "doctrf_dst_serie")
    private String doctrfDstSerie;

    /**
     * id destination
     */
    @Column(name = "doctrf_dst_id")
    private Long doctrfDstId = 0L;

    @Column(name = "exeach_id", nullable = false)
    private Long exeachId;

}
